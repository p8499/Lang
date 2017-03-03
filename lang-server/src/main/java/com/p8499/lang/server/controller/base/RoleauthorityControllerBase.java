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
import com.p8499.lang.server.bean.Roleauthority;
import com.p8499.lang.server.mask.RoleauthorityMask;
import com.p8499.lang.server.mapper.local.RoleauthorityMapper;

public abstract class RoleauthorityControllerBase {
  protected static final String path = "api/roleauthority/";
  protected static final String attachPath = "api/roleauthority_attachment/";
  protected static final String pathKey = "{raid}";

  @RequestMapping(
    value = path + pathKey,
    method = RequestMethod.GET,
    produces = "application/json;charset=UTF-8"
  )
  public String get(
      HttpSession session,
      HttpServletRequest request,
      HttpServletResponse response,
      @PathVariable Integer raid,
      @RequestParam(required = false) String mask)
      throws Exception {
    RoleauthorityMask maskObj =
        mask == null || mask.equals("")
            ? new RoleauthorityMask().all(true)
            : jackson.readValue(mask, RoleauthorityMask.class);
    Roleauthority bean = onGet(session, request, response, raid, maskObj);
    return jackson.writeValueAsString(bean);
  }

  protected abstract Roleauthority onGet(
      HttpSession session,
      HttpServletRequest request,
      HttpServletResponse response,
      Integer raid,
      RoleauthorityMask mask)
      throws Exception;

  protected Roleauthority baseGet(Integer raid, RoleauthorityMask mask) {
    return roleauthorityMapper.get(raid, mask);
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
      @RequestBody Roleauthority bean)
      throws Exception {
    onAdd(session, request, response, bean);
    return jackson.writeValueAsString(bean);
  }

  protected abstract Roleauthority onAdd(
      HttpSession session,
      HttpServletRequest request,
      HttpServletResponse response,
      Roleauthority bean)
      throws Exception;

  protected Roleauthority baseAdd(Roleauthority bean) {
    if (!validatorFactory.getValidator().validate(bean, Insert.class).isEmpty()) {
      return null;
    }
    roleauthorityMapper.add(bean);
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
      @PathVariable Integer raid,
      @RequestBody Roleauthority bean,
      @RequestParam(required = false) String mask)
      throws Exception {
    RoleauthorityMask maskObj =
        mask == null || mask.equals("")
            ? new RoleauthorityMask().all(true)
            : jackson.readValue(mask, RoleauthorityMask.class);
    onUpdate(session, request, response, raid, bean, maskObj);
    return jackson.writeValueAsString(bean);
  }

  protected abstract Roleauthority onUpdate(
      HttpSession session,
      HttpServletRequest request,
      HttpServletResponse response,
      Integer raid,
      Roleauthority bean,
      RoleauthorityMask mask)
      throws Exception;

  protected Roleauthority baseUpdate(Roleauthority bean, RoleauthorityMask mask) {
    Set<ConstraintViolation<Roleauthority>> violationSet =
        validatorFactory.getValidator().validate(bean, Update.class);
    for (ConstraintViolation<Roleauthority> violation : violationSet) {
      if (mask.get(violation.getPropertyPath().toString())) {
        return null;
      }
    }
    roleauthorityMapper.update(bean, mask);
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
      @PathVariable Integer raid)
      throws Exception {
    onDelete(session, request, response, raid);
  }

  protected abstract void onDelete(
      HttpSession session, HttpServletRequest request, HttpServletResponse response, Integer raid)
      throws Exception;

  protected boolean baseDelete(Integer raid) {
    return roleauthorityMapper.delete(raid);
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
    RoleauthorityMask maskObj =
        mask == null || mask.equals("")
            ? new RoleauthorityMask().all(true)
            : jackson.readValue(mask, RoleauthorityMask.class);
    Long total = onCount(session, request, response, filterObj);
    if (total == null) return null;
    long start = rangeObj.getStart(total);
    long count = rangeObj.getCount(total);
    List<Roleauthority> results =
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

  protected abstract List<Roleauthority> onQuery(
      HttpSession session,
      HttpServletRequest request,
      HttpServletResponse response,
      FilterExpr filter,
      OrderByListExpr orderByList,
      long start,
      long count,
      RoleauthorityMask mask)
      throws Exception;

  protected long baseCount(FilterExpr filter) {
    return roleauthorityMapper.count(filter == null ? null : filter.toString());
  }

  protected List<Roleauthority> baseQuery(
      FilterExpr filter,
      OrderByListExpr orderByList,
      long start,
      long count,
      RoleauthorityMask mask) {
    return roleauthorityMapper.query(
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
      @PathVariable Integer raid,
      @RequestParam(required = true) String name)
      throws Exception {
    InputStream input = inputStream(session, request, response, raid, name);
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
      Integer raid,
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
      @PathVariable Integer raid,
      @RequestParam(required = true) String name)
      throws Exception {
    OutputStream output = outputStream(session, request, response, raid, name);
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
      Integer raid,
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
      @PathVariable Integer raid,
      @RequestParam(required = true) String name)
      throws Exception {
    onDeleteAttach(session, request, response, raid, name);
  }

  protected abstract void onDeleteAttach(
      HttpSession session,
      HttpServletRequest request,
      HttpServletResponse response,
      Integer raid,
      String name)
      throws Exception;

  public String listAttaches(
      HttpSession session,
      HttpServletRequest request,
      HttpServletResponse response,
      @PathVariable Integer raid)
      throws Exception {
    List<String> result = onListAttaches(session, request, response, raid);
    return jackson.writeValueAsString(result);
  }

  protected abstract List<String> onListAttaches(
      HttpSession session, HttpServletRequest request, HttpServletResponse response, Integer raid)
      throws Exception;

  @Value(value = "#{jackson}")
  protected ObjectMapper jackson;

  @Value(value = "#{validatorFactory}")
  protected LocalValidatorFactoryBean validatorFactory;

  @Value(value = "#{roleauthorityMapper}")
  protected RoleauthorityMapper roleauthorityMapper;
}
