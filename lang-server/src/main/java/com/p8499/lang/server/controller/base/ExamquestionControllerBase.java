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
import com.p8499.lang.server.bean.Examquestion;
import com.p8499.lang.server.mask.ExamquestionMask;
import com.p8499.lang.server.mapper.local.ExamquestionMapper;

public abstract class ExamquestionControllerBase {
  protected static final String path = "api/examquestion/";
  protected static final String attachPath = "api/examquestion_attachment/";
  protected static final String pathKey = "{eqid}";

  @RequestMapping(
    value = path + pathKey,
    method = RequestMethod.GET,
    produces = "application/json;charset=UTF-8"
  )
  public String get(
      HttpSession session,
      HttpServletRequest request,
      HttpServletResponse response,
      @PathVariable Integer eqid,
      @RequestParam(required = false) String mask)
      throws Exception {
    ExamquestionMask maskObj =
        mask == null || mask.equals("")
            ? new ExamquestionMask().all(true)
            : jackson.readValue(mask, ExamquestionMask.class);
    Examquestion bean = onGet(session, request, response, eqid, maskObj);
    return jackson.writeValueAsString(bean);
  }

  protected abstract Examquestion onGet(
      HttpSession session,
      HttpServletRequest request,
      HttpServletResponse response,
      Integer eqid,
      ExamquestionMask mask)
      throws Exception;

  protected Examquestion baseGet(Integer eqid, ExamquestionMask mask) {
    return examquestionMapper.get(eqid, mask);
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
      @RequestBody Examquestion bean)
      throws Exception {
    onAdd(session, request, response, bean);
    return jackson.writeValueAsString(bean);
  }

  protected abstract Examquestion onAdd(
      HttpSession session,
      HttpServletRequest request,
      HttpServletResponse response,
      Examquestion bean)
      throws Exception;

  protected Examquestion baseAdd(Examquestion bean) {
    if (!validatorFactory.getValidator().validate(bean, Insert.class).isEmpty()) {
      return null;
    }
    examquestionMapper.add(bean);
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
      @PathVariable Integer eqid,
      @RequestBody Examquestion bean,
      @RequestParam(required = false) String mask)
      throws Exception {
    ExamquestionMask maskObj =
        mask == null || mask.equals("")
            ? new ExamquestionMask().all(true)
            : jackson.readValue(mask, ExamquestionMask.class);
    onUpdate(session, request, response, eqid, bean, maskObj);
    return jackson.writeValueAsString(bean);
  }

  protected abstract Examquestion onUpdate(
      HttpSession session,
      HttpServletRequest request,
      HttpServletResponse response,
      Integer eqid,
      Examquestion bean,
      ExamquestionMask mask)
      throws Exception;

  protected Examquestion baseUpdate(Examquestion bean, ExamquestionMask mask) {
    Set<ConstraintViolation<Examquestion>> violationSet =
        validatorFactory.getValidator().validate(bean, Update.class);
    for (ConstraintViolation<Examquestion> violation : violationSet) {
      if (mask.get(violation.getPropertyPath().toString())) {
        return null;
      }
    }
    examquestionMapper.update(bean, mask);
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
      @PathVariable Integer eqid)
      throws Exception {
    onDelete(session, request, response, eqid);
  }

  protected abstract void onDelete(
      HttpSession session, HttpServletRequest request, HttpServletResponse response, Integer eqid)
      throws Exception;

  protected boolean baseDelete(Integer eqid) {
    return examquestionMapper.delete(eqid);
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
    ExamquestionMask maskObj =
        mask == null || mask.equals("")
            ? new ExamquestionMask().all(true)
            : jackson.readValue(mask, ExamquestionMask.class);
    Long total = onCount(session, request, response, filterObj);
    if (total == null) return null;
    long start = rangeObj.getStart(total);
    long count = rangeObj.getCount(total);
    List<Examquestion> results =
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

  protected abstract List<Examquestion> onQuery(
      HttpSession session,
      HttpServletRequest request,
      HttpServletResponse response,
      FilterExpr filter,
      OrderByListExpr orderByList,
      long start,
      long count,
      ExamquestionMask mask)
      throws Exception;

  protected long baseCount(FilterExpr filter) {
    return examquestionMapper.count(filter == null ? null : filter.toString());
  }

  protected List<Examquestion> baseQuery(
      FilterExpr filter,
      OrderByListExpr orderByList,
      long start,
      long count,
      ExamquestionMask mask) {
    return examquestionMapper.query(
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
      @PathVariable Integer eqid,
      @RequestParam(required = true) String name)
      throws Exception {
    InputStream input = inputStream(session, request, response, eqid, name);
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
      Integer eqid,
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
      @PathVariable Integer eqid,
      @RequestParam(required = true) String name)
      throws Exception {
    OutputStream output = outputStream(session, request, response, eqid, name);
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
      Integer eqid,
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
      @PathVariable Integer eqid,
      @RequestParam(required = true) String name)
      throws Exception {
    onDeleteAttach(session, request, response, eqid, name);
  }

  protected abstract void onDeleteAttach(
      HttpSession session,
      HttpServletRequest request,
      HttpServletResponse response,
      Integer eqid,
      String name)
      throws Exception;

  public String listAttaches(
      HttpSession session,
      HttpServletRequest request,
      HttpServletResponse response,
      @PathVariable Integer eqid)
      throws Exception {
    List<String> result = onListAttaches(session, request, response, eqid);
    return jackson.writeValueAsString(result);
  }

  protected abstract List<String> onListAttaches(
      HttpSession session, HttpServletRequest request, HttpServletResponse response, Integer eqid)
      throws Exception;

  @Value(value = "#{jackson}")
  protected ObjectMapper jackson;

  @Value(value = "#{validatorFactory}")
  protected LocalValidatorFactoryBean validatorFactory;

  @Value(value = "#{examquestionMapper}")
  protected ExamquestionMapper examquestionMapper;
}
