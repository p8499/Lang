package com.p8499.lang.gen.stub;

import android.content.Context;
import java.util.List;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.p8499.lang.gen.FilterLogicExpr;
import com.p8499.lang.gen.OrderByListExpr;
import com.p8499.lang.gen.RangeExpr;
import com.p8499.lang.gen.RetrofitFactory;
import com.p8499.lang.gen.bean.Examquestion;
import com.p8499.lang.gen.mask.ExamquestionMask;

public class ExamquestionStub {
  public static final String path = "api/examquestion/";
  public static final String attachPath = "api/examquestion_attachment/";
  public static final String pathKey = "{eqid}";

  private static ExamquestionStub service;

  public static ExamquestionStub getInstance(Context context) {
    if (service == null) {
      service = new ExamquestionStub(context);
    }
    return service;
  }

  private Api api;

  public ExamquestionStub(Context context) {
    api = RetrofitFactory.getInstance(context).create(Api.class);
  }

  public Flowable<Response<Examquestion>> get(Integer eqid) {
    return get(eqid, null);
  }

  public Flowable<Response<Examquestion>> get(Integer eqid, ExamquestionMask mask) {
    Flowable<Response<Examquestion>> flowable = null;
    try {
      flowable =
          api.get(
                  eqid,
                  mask == null ? null : RetrofitFactory.getObjectMapper().writeValueAsString(mask))
              .subscribeOn(Schedulers.io());
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return flowable;
  }

  public Flowable<Response<Examquestion>> add(Examquestion bean) {
    Flowable<Response<Examquestion>> flowable = api.add(bean).subscribeOn(Schedulers.io());
    return flowable;
  }

  public Flowable<Response<Examquestion>> update(Examquestion bean) {
    return update(bean, null);
  }

  public Flowable<Response<Examquestion>> update(Examquestion bean, ExamquestionMask mask) {
    Flowable<Response<Examquestion>> flowable = null;
    try {
      flowable =
          api.update(
                  bean.getEqid(),
                  bean,
                  mask == null ? null : RetrofitFactory.getObjectMapper().writeValueAsString(mask))
              .subscribeOn(Schedulers.io());
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return flowable;
  }

  public Flowable<Response<Void>> count(FilterLogicExpr filter) {
    Flowable<Response<Void>> flowable = null;
    try {
      flowable =
          api.count(
                  filter == null
                      ? null
                      : RetrofitFactory.getObjectMapper().writeValueAsString(filter),
                  new RangeExpr("items", 0L, -1L).toString(),
                  RetrofitFactory.getObjectMapper()
                      .writeValueAsString(new ExamquestionMask().setEqid(true)))
              .subscribeOn(Schedulers.io());
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return flowable;
  }

  public Flowable<Response<List<Examquestion>>> query(FilterLogicExpr filter, RangeExpr range) {
    return query(filter, null, range, null);
  }

  public Flowable<Response<List<Examquestion>>> query(
      FilterLogicExpr filter, OrderByListExpr orderBy, RangeExpr range) {
    return query(filter, orderBy, range, null);
  }

  public Flowable<Response<List<Examquestion>>> query(
      FilterLogicExpr filter, RangeExpr range, ExamquestionMask mask) {
    return query(filter, null, range, mask);
  }

  public Flowable<Response<List<Examquestion>>> query(
      FilterLogicExpr filter, OrderByListExpr orderBy, RangeExpr range, ExamquestionMask mask) {
    Flowable<Response<List<Examquestion>>> flowable = null;
    try {
      flowable =
          api.query(
                  filter == null
                      ? null
                      : RetrofitFactory.getObjectMapper().writeValueAsString(filter),
                  orderBy == null ? null : orderBy.toQuery(),
                  range == null ? null : range.toString(),
                  mask == null ? null : RetrofitFactory.getObjectMapper().writeValueAsString(mask))
              .subscribeOn(Schedulers.io());
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return flowable;
  }

  public Flowable<Response<Void>> delete(Integer eqid) {
    return api.delete(eqid).subscribeOn(Schedulers.io());
  }

  public Flowable<Response<ResponseBody>> downloadAttach(Integer eqid, String name) {
    Flowable<Response<ResponseBody>> flowable =
        api.downloadAttach(eqid, name, "application/octet-stream").subscribeOn(Schedulers.io());
    return flowable;
  }

  public Flowable<Response<Void>> uploadAttach(Integer eqid, String name, byte[] bytes) {
    RequestBody body = RequestBody.create(MediaType.parse("multipart/form-data"), bytes);
    Flowable<Response<Void>> flowable =
        api.uploadAttach(eqid, name, body).subscribeOn(Schedulers.io());
    return flowable;
  }

  public Flowable<Response<Void>> deleteAttach(Integer eqid, String name) {
    Flowable<Response<Void>> flowable = api.deleteAttach(eqid, name).subscribeOn(Schedulers.io());
    return flowable;
  }

  public Flowable<Response<List<String>>> listAttaches(Integer eqid) {
    Flowable<Response<List<String>>> flowable = api.listAttaches(eqid).subscribeOn(Schedulers.io());
    return flowable;
  }

  public interface Api {
    @GET(path + pathKey)
    Flowable<Response<Examquestion>> get(@Path("eqid") Integer eqid, @Query("mask") String mask);

    @POST(path)
    Flowable<Response<Examquestion>> add(@Body Examquestion bean);

    @PUT(path + pathKey)
    Flowable<Response<Examquestion>> update(
        @Path("eqid") Integer eqid, @Body Examquestion bean, @Query("mask") String mask);

    @DELETE(path + pathKey)
    Flowable<Response<Void>> delete(@Path("eqid") Integer eqid);

    @GET(path)
    Flowable<Response<List<Examquestion>>> query(
        @Query("filter") String filter,
        @Query("orderBy") String orderBy,
        @Header("Range") String range,
        @Query("mask") String mask);

    @GET(path)
    Flowable<Response<Void>> count(
        @Query("filter") String filter, @Header("Range") String range, @Query("mask") String mask);

    @GET(attachPath + pathKey)
    Flowable<Response<ResponseBody>> downloadAttach(
        @Path("eqid") Integer eqid, @Query("name") String name, @Header("Accept") String accept);

    @PUT(attachPath + pathKey)
    Flowable<Response<Void>> uploadAttach(
        @Path("eqid") Integer eqid, @Query("name") String name, @Body RequestBody body);

    @DELETE(attachPath + pathKey)
    Flowable<Response<Void>> deleteAttach(@Path("eqid") Integer eqid, @Query("name") String name);

    @GET(attachPath + pathKey)
    Flowable<Response<List<String>>> listAttaches(@Path("eqid") Integer eqid);
  }
}
