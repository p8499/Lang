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
import com.p8499.lang.server.bean.Sentence;
import com.p8499.lang.server.mask.SentenceMask;
import com.p8499.lang.server.mapper.local.SentenceMapper;

public abstract class SentenceControllerBase {
  protected static final String path = "api/sentence/";
  protected static final String attachPath = "api/sentence_attachment/";
  protected static final String pathKey = "{asid}";

  @RequestMapping(
    value = path + pathKey,
    method = RequestMethod.GET,
    produces = "application/json;charset=UTF-8"
  )
  public String get(
      HttpSession session,
      HttpServletRequest request,
      HttpServletResponse response,
      @PathVariable Integer asid,
      @RequestParam(required = false) String mask)
      throws Exception {
    SentenceMask maskObj =
        mask == null || mask.equals("")
            ? new SentenceMask().all(true)
            : jackson.readValue(mask, SentenceMask.class);
    Sentence bean = onGet(session, request, response, asid, maskObj);
    return jackson.writeValueAsString(bean);
  }

  protected abstract Sentence onGet(
      HttpSession session,
      HttpServletRequest request,
      HttpServletResponse response,
      Integer asid,
      SentenceMask mask)
      throws Exception;

  protected Sentence baseGet(Integer asid, SentenceMask mask) {
    return sentenceMapper.get(asid, mask);
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
      @RequestBody Sentence bean)
      throws Exception {
    onAdd(session, request, response, bean);
    return jackson.writeValueAsString(bean);
  }

  protected abstract Sentence onAdd(
      HttpSession session, HttpServletRequest request, HttpServletResponse response, Sentence bean)
      throws Exception;

  protected Sentence baseAdd(Sentence bean) {
    if (!validatorFactory.getValidator().validate(bean, Insert.class).isEmpty()) {
      return null;
    }
    sentenceMapper.add(bean);
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
      @PathVariable Integer asid,
      @RequestBody Sentence bean,
      @RequestParam(required = false) String mask)
      throws Exception {
    SentenceMask maskObj =
        mask == null || mask.equals("")
            ? new SentenceMask().all(true)
            : jackson.readValue(mask, SentenceMask.class);
    onUpdate(session, request, response, asid, bean, maskObj);
    return jackson.writeValueAsString(bean);
  }

  protected abstract Sentence onUpdate(
      HttpSession session,
      HttpServletRequest request,
      HttpServletResponse response,
      Integer asid,
      Sentence bean,
      SentenceMask mask)
      throws Exception;

  protected Sentence baseUpdate(Sentence bean, SentenceMask mask) {
    Set<ConstraintViolation<Sentence>> violationSet =
        validatorFactory.getValidator().validate(bean, Update.class);
    for (ConstraintViolation<Sentence> violation : violationSet) {
      if (mask.get(violation.getPropertyPath().toString())) {
        return null;
      }
    }
    sentenceMapper.update(bean, mask);
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
      @PathVariable Integer asid)
      throws Exception {
    onDelete(session, request, response, asid);
  }

  protected abstract void onDelete(
      HttpSession session, HttpServletRequest request, HttpServletResponse response, Integer asid)
      throws Exception;

  protected boolean baseDelete(Integer asid) {
    return sentenceMapper.delete(asid);
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
    SentenceMask maskObj =
        mask == null || mask.equals("")
            ? new SentenceMask().all(true)
            : jackson.readValue(mask, SentenceMask.class);
    Long total = onCount(session, request, response, filterObj);
    if (total == null) return null;
    long start = rangeObj.getStart(total);
    long count = rangeObj.getCount(total);
    List<Sentence> results =
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

  protected abstract List<Sentence> onQuery(
      HttpSession session,
      HttpServletRequest request,
      HttpServletResponse response,
      FilterExpr filter,
      OrderByListExpr orderByList,
      long start,
      long count,
      SentenceMask mask)
      throws Exception;

  protected long baseCount(FilterExpr filter) {
    return sentenceMapper.count(filter == null ? null : filter.toString());
  }

  protected List<Sentence> baseQuery(
      FilterExpr filter, OrderByListExpr orderByList, long start, long count, SentenceMask mask) {
    return sentenceMapper.query(
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
      @PathVariable Integer asid,
      @RequestParam(required = true) String name)
      throws Exception {
    InputStream input = inputStream(session, request, response, asid, name);
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
      Integer asid,
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
      @PathVariable Integer asid,
      @RequestParam(required = true) String name)
      throws Exception {
    OutputStream output = outputStream(session, request, response, asid, name);
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
      Integer asid,
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
      @PathVariable Integer asid,
      @RequestParam(required = true) String name)
      throws Exception {
    onDeleteAttach(session, request, response, asid, name);
  }

  protected abstract void onDeleteAttach(
      HttpSession session,
      HttpServletRequest request,
      HttpServletResponse response,
      Integer asid,
      String name)
      throws Exception;

  public String listAttaches(
      HttpSession session,
      HttpServletRequest request,
      HttpServletResponse response,
      @PathVariable Integer asid)
      throws Exception {
    List<String> result = onListAttaches(session, request, response, asid);
    return jackson.writeValueAsString(result);
  }

  protected abstract List<String> onListAttaches(
      HttpSession session, HttpServletRequest request, HttpServletResponse response, Integer asid)
      throws Exception;

  @Value(value = "#{jackson}")
  protected ObjectMapper jackson;

  @Value(value = "#{validatorFactory}")
  protected LocalValidatorFactoryBean validatorFactory;

  @Value(value = "#{sentenceMapper}")
  protected SentenceMapper sentenceMapper;
}
