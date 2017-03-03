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
import com.p8499.lang.server.bean.Authority;
import com.p8499.lang.server.mask.AuthorityMask;
import com.p8499.lang.server.mapper.local.AuthorityMapper;

public abstract class AuthorityControllerBase {
  protected static final String path = "api/authority/";
  protected static final String attachPath = "api/authority_attachment/";
  protected static final String pathKey = "{auid}";

  @RequestMapping(
    value = path + pathKey,
    method = RequestMethod.GET,
    produces = "application/json;charset=UTF-8"
  )
  public String get(
      HttpSession session,
      HttpServletRequest request,
      HttpServletResponse response,
      @PathVariable String auid,
      @RequestParam(required = false) String mask)
      throws Exception {
    AuthorityMask maskObj =
        mask == null || mask.equals("")
            ? new AuthorityMask().all(true)
            : jackson.readValue(mask, AuthorityMask.class);
    Authority bean = onGet(session, request, response, auid, maskObj);
    return jackson.writeValueAsString(bean);
  }

  protected abstract Authority onGet(
      HttpSession session,
      HttpServletRequest request,
      HttpServletResponse response,
      String auid,
      AuthorityMask mask)
      throws Exception;

  protected Authority baseGet(String auid, AuthorityMask mask) {
    return authorityMapper.get(auid, mask);
  }

  @RequestMapping(
    value = path + pathKey,
    method = RequestMethod.POST,
    produces = "application/json;charset=UTF-8"
  )
  public String add(
      HttpSession session,
      HttpServletRequest request,
      HttpServletResponse response,
      @PathVariable String auid,
      @RequestBody Authority bean)
      throws Exception {
    onAdd(session, request, response, auid, bean);
    return jackson.writeValueAsString(bean);
  }

  protected abstract Authority onAdd(
      HttpSession session,
      HttpServletRequest request,
      HttpServletResponse response,
      String auid,
      Authority bean)
      throws Exception;

  protected Authority baseAdd(Authority bean) {
    if (!validatorFactory.getValidator().validate(bean, Insert.class).isEmpty()) {
      return null;
    }
    authorityMapper.add(bean);
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
      @PathVariable String auid,
      @RequestBody Authority bean,
      @RequestParam(required = false) String mask)
      throws Exception {
    AuthorityMask maskObj =
        mask == null || mask.equals("")
            ? new AuthorityMask().all(true)
            : jackson.readValue(mask, AuthorityMask.class);
    onUpdate(session, request, response, auid, bean, maskObj);
    return jackson.writeValueAsString(bean);
  }

  protected abstract Authority onUpdate(
      HttpSession session,
      HttpServletRequest request,
      HttpServletResponse response,
      String auid,
      Authority bean,
      AuthorityMask mask)
      throws Exception;

  protected Authority baseUpdate(Authority bean, AuthorityMask mask) {
    Set<ConstraintViolation<Authority>> violationSet =
        validatorFactory.getValidator().validate(bean, Update.class);
    for (ConstraintViolation<Authority> violation : violationSet) {
      if (mask.get(violation.getPropertyPath().toString())) {
        return null;
      }
    }
    authorityMapper.update(bean, mask);
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
      @PathVariable String auid)
      throws Exception {
    onDelete(session, request, response, auid);
  }

  protected abstract void onDelete(
      HttpSession session, HttpServletRequest request, HttpServletResponse response, String auid)
      throws Exception;

  protected boolean baseDelete(String auid) {
    return authorityMapper.delete(auid);
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
    AuthorityMask maskObj =
        mask == null || mask.equals("")
            ? new AuthorityMask().all(true)
            : jackson.readValue(mask, AuthorityMask.class);
    Long total = onCount(session, request, response, filterObj);
    if (total == null) return null;
    long start = rangeObj.getStart(total);
    long count = rangeObj.getCount(total);
    List<Authority> results =
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

  protected abstract List<Authority> onQuery(
      HttpSession session,
      HttpServletRequest request,
      HttpServletResponse response,
      FilterExpr filter,
      OrderByListExpr orderByList,
      long start,
      long count,
      AuthorityMask mask)
      throws Exception;

  protected long baseCount(FilterExpr filter) {
    return authorityMapper.count(filter == null ? null : filter.toString());
  }

  protected List<Authority> baseQuery(
      FilterExpr filter, OrderByListExpr orderByList, long start, long count, AuthorityMask mask) {
    return authorityMapper.query(
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
      @PathVariable String auid,
      @RequestParam(required = true) String name)
      throws Exception {
    InputStream input = inputStream(session, request, response, auid, name);
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
      String auid,
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
      @PathVariable String auid,
      @RequestParam(required = true) String name)
      throws Exception {
    OutputStream output = outputStream(session, request, response, auid, name);
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
      String auid,
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
      @PathVariable String auid,
      @RequestParam(required = true) String name)
      throws Exception {
    onDeleteAttach(session, request, response, auid, name);
  }

  protected abstract void onDeleteAttach(
      HttpSession session,
      HttpServletRequest request,
      HttpServletResponse response,
      String auid,
      String name)
      throws Exception;

  public String listAttaches(
      HttpSession session,
      HttpServletRequest request,
      HttpServletResponse response,
      @PathVariable String auid)
      throws Exception {
    List<String> result = onListAttaches(session, request, response, auid);
    return jackson.writeValueAsString(result);
  }

  protected abstract List<String> onListAttaches(
      HttpSession session, HttpServletRequest request, HttpServletResponse response, String auid)
      throws Exception;

  @Value(value = "#{jackson}")
  protected ObjectMapper jackson;

  @Value(value = "#{validatorFactory}")
  protected LocalValidatorFactoryBean validatorFactory;

  @Value(value = "#{authorityMapper}")
  protected AuthorityMapper authorityMapper;
}
