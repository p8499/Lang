package com.p8499.lang.server.controller.base;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.http.HttpStatus;
import org.springframework.util.StreamUtils;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.p8499.lang.server.*;
import com.p8499.lang.server.bean.Certificate;
import com.p8499.lang.server.mask.CertificateMask;
import com.p8499.lang.server.mapper.local.CertificateMapper;

public abstract class CertificateControllerBase {
  protected static final String path = "api/certificate/";
  protected static final String attachPath = "api/certificate_attachment/";
  protected static final String pathKey = "{crid}";

  @RequestMapping(
    value = path + pathKey,
    method = RequestMethod.GET,
    produces = "application/json;charset=UTF-8"
  )
  public String get(
      HttpSession session,
      HttpServletRequest request,
      HttpServletResponse response,
      @PathVariable Integer crid,
      @RequestParam(required = false) String mask)
      throws Exception {
    CertificateMask maskObj =
        mask == null || mask.equals("")
            ? new CertificateMask().all(true)
            : jackson.readValue(mask, CertificateMask.class);
    Certificate bean = onGet(session, request, response, crid, maskObj);
    return jackson.writeValueAsString(bean);
  }

  protected abstract Certificate onGet(
      HttpSession session,
      HttpServletRequest request,
      HttpServletResponse response,
      Integer crid,
      CertificateMask mask)
      throws Exception;

  protected Certificate baseGet(Integer crid, CertificateMask mask) {
    return certificateMapper.get(crid, mask);
  }

  @RequestMapping(
    value = path,
    method = RequestMethod.POST,
    produces = "application/json;charset=UTF-8"
  )
  public String add(
      HttpSession session,
      HttpServletRequest request,
      HttpServletResponse response,
      @RequestBody Certificate bean)
      throws Exception {
    onAdd(session, request, response, bean);
    return jackson.writeValueAsString(bean);
  }

  protected abstract Certificate onAdd(
      HttpSession session,
      HttpServletRequest request,
      HttpServletResponse response,
      Certificate bean)
      throws Exception;

  protected Certificate baseAdd(Certificate bean) {
    if (!validatorFactory.getValidator().validate(bean, Insert.class).isEmpty()) {
      return null;
    }
    certificateMapper.add(bean);
    return bean;
  }

  @RequestMapping(
    value = path + pathKey,
    method = RequestMethod.PUT,
    produces = "application/json;charset=UTF-8"
  )
  public String update(
      HttpSession session,
      HttpServletRequest request,
      HttpServletResponse response,
      @PathVariable Integer crid,
      @RequestBody Certificate bean,
      @RequestParam(required = false) String mask)
      throws Exception {
    CertificateMask maskObj =
        mask == null || mask.equals("")
            ? new CertificateMask().all(true)
            : jackson.readValue(mask, CertificateMask.class);
    onUpdate(session, request, response, crid, bean, maskObj);
    return jackson.writeValueAsString(bean);
  }

  protected abstract Certificate onUpdate(
      HttpSession session,
      HttpServletRequest request,
      HttpServletResponse response,
      Integer crid,
      Certificate bean,
      CertificateMask mask)
      throws Exception;

  protected Certificate baseUpdate(Certificate bean, CertificateMask mask) {
    Set<ConstraintViolation<Certificate>> violationSet =
        validatorFactory.getValidator().validate(bean, Update.class);
    for (ConstraintViolation<Certificate> violation : violationSet) {
      if (mask.get(violation.getPropertyPath().toString())) {
        return null;
      }
    }
    certificateMapper.update(bean, mask);
    return bean;
  }

  @RequestMapping(
    value = path + pathKey,
    method = RequestMethod.DELETE,
    produces = "application/json;charset=UTF-8"
  )
  public void delete(
      HttpSession session,
      HttpServletRequest request,
      HttpServletResponse response,
      @PathVariable Integer crid)
      throws Exception {
    onDelete(session, request, response, crid);
  }

  protected abstract void onDelete(
      HttpSession session, HttpServletRequest request, HttpServletResponse response, Integer crid)
      throws Exception;

  protected boolean baseDelete(Integer crid) {
    return certificateMapper.delete(crid);
  }

  @RequestMapping(
    value = path,
    method = RequestMethod.GET,
    produces = "application/json;charset=UTF-8"
  )
  public String query(
      HttpSession session,
      HttpServletRequest request,
      HttpServletResponse response,
      @RequestParam(required = false) String filter,
      @RequestParam(required = false) String orderBy,
      @RequestHeader(required = false, name = "Range", defaultValue = "items=0-9") String range,
      @RequestParam(required = false) String mask)
      throws Exception {
    FilterExpr filterObj =
        filter == null || filter.equals("") ? null : jackson.readValue(filter, FilterExpr.class);
    OrderByListExpr orderByListObj =
        mask == null || mask.equals("") ? null : OrderByListExpr.fromQuery(orderBy);
    RangeExpr rangeObj = RangeExpr.fromQuery(range);
    CertificateMask maskObj =
        mask == null || mask.equals("")
            ? new CertificateMask().all(true)
            : jackson.readValue(mask, CertificateMask.class);
    Long total = onCount(session, request, response, filterObj);
    if (total == null) return null;
    long start = rangeObj.getStart(total);
    long count = rangeObj.getCount(total);
    List<Certificate> results =
        onQuery(session, request, response, filterObj, orderByListObj, start, count, maskObj);
    response.setHeader(
        "Content-Range", RangeListExpr.getContentRange(start, results.size(), total));
    return jackson.writeValueAsString(results);
  }

  protected abstract Long onCount(
      HttpSession session,
      HttpServletRequest request,
      HttpServletResponse response,
      FilterExpr filter)
      throws Exception;

  protected abstract List<Certificate> onQuery(
      HttpSession session,
      HttpServletRequest request,
      HttpServletResponse response,
      FilterExpr filter,
      OrderByListExpr orderByList,
      long start,
      long count,
      CertificateMask mask)
      throws Exception;

  protected long baseCount(FilterExpr filter) {
    return certificateMapper.count(filter == null ? null : filter.toString());
  }

  protected List<Certificate> baseQuery(
      FilterExpr filter,
      OrderByListExpr orderByList,
      long start,
      long count,
      CertificateMask mask) {
    return certificateMapper.query(
        filter == null ? null : filter.toString(),
        orderByList == null ? null : orderByList.toString(),
        start,
        count,
        mask);
  }

  @RequestMapping(
    value = attachPath + pathKey,
    method = RequestMethod.GET,
    produces = "application/octet-stream"
  )
  public void downloadAttach(
      HttpSession session,
      HttpServletRequest request,
      HttpServletResponse response,
      @PathVariable Integer crid,
      @RequestParam(required = true) String name)
      throws Exception {
    InputStream input = inputStream(session, request, response, crid, name);
    if (input == null) {
      return;
    }
    String contentType = URLConnection.guessContentTypeFromName(name);
    response.setContentType(contentType == null ? "application/octet-stream" : contentType);
    response.setHeader("Content-Disposition", "attachment;fileName=" + name);
    StreamUtils.copy(input, response.getOutputStream());
    input.close();
    response.getOutputStream().close();
  }

  protected abstract InputStream inputStream(
      HttpSession session,
      HttpServletRequest request,
      HttpServletResponse response,
      Integer crid,
      String name)
      throws Exception;

  @RequestMapping(
    value = attachPath + pathKey,
    method = RequestMethod.PUT,
    produces = "application/json;charset=UTF-8"
  )
  public void uploadAttach(
      HttpSession session,
      HttpServletRequest request,
      HttpServletResponse response,
      @PathVariable Integer crid,
      @RequestParam(required = true) String name)
      throws Exception {
    OutputStream output = outputStream(session, request, response, crid, name);
    if (output == null) {
      return;
    }
    StreamUtils.copy(request.getInputStream(), output);
    request.getInputStream().close();
    output.close();
  }

  protected abstract OutputStream outputStream(
      HttpSession session,
      HttpServletRequest request,
      HttpServletResponse response,
      Integer crid,
      String name)
      throws Exception;

  @RequestMapping(
    value = attachPath + pathKey,
    method = RequestMethod.DELETE,
    produces = "application/json;charset=UTF-8"
  )
  public void deleteAttach(
      HttpSession session,
      HttpServletRequest request,
      HttpServletResponse response,
      @PathVariable Integer crid,
      @RequestParam(required = true) String name)
      throws Exception {
    onDeleteAttach(session, request, response, crid, name);
  }

  protected abstract void onDeleteAttach(
      HttpSession session,
      HttpServletRequest request,
      HttpServletResponse response,
      Integer crid,
      String name)
      throws Exception;

  public String listAttaches(
      HttpSession session,
      HttpServletRequest request,
      HttpServletResponse response,
      @PathVariable Integer crid)
      throws Exception {
    List<String> result = onListAttaches(session, request, response, crid);
    return jackson.writeValueAsString(result);
  }

  protected abstract List<String> onListAttaches(
      HttpSession session, HttpServletRequest request, HttpServletResponse response, Integer crid)
      throws Exception;

  @Value(value = "#{jackson}")
  protected ObjectMapper jackson;

  @Value(value = "#{validatorFactory}")
  protected LocalValidatorFactoryBean validatorFactory;

  @Value(value = "#{certificateMapper}")
  protected CertificateMapper certificateMapper;
}
