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
import com.p8499.lang.gen.bean.Questionoption;
import com.p8499.lang.gen.mask.QuestionoptionMask;

public class QuestionoptionStub {
  public static final String path = "api/questionoption/";
  public static final String attachPath = "api/questionoption_attachment/";
  public static final String pathKey = "{toid}";

  private static QuestionoptionStub service;

  public static QuestionoptionStub getInstance(Context context) {
    if (service == null) {
      service = new QuestionoptionStub(context);
    }
    return service;
  }

  private Api api;

  public QuestionoptionStub(Context context) {
    api = RetrofitFactory.getInstance(context).create(Api.class);
  }

  public Flowable<Response<Questionoption>> get(Integer toid) {
    return get(toid, null);
  }

  public Flowable<Response<Questionoption>> get(Integer toid, QuestionoptionMask mask) {
    Flowable<Response<Questionoption>> flowable = null;
    try {
      flowable =
          api.get(
                  toid,
                  mask == null ? null : RetrofitFactory.getObjectMapper().writeValueAsString(mask))
              .subscribeOn(Schedulers.io());
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return flowable;
  }

  public Flowable<Response<Questionoption>> add(Questionoption bean) {
    Flowable<Response<Questionoption>> flowable = api.add(bean).subscribeOn(Schedulers.io());
    return flowable;
  }

  public Flowable<Response<Questionoption>> update(Questionoption bean) {
    return update(bean, null);
  }

  public Flowable<Response<Questionoption>> update(Questionoption bean, QuestionoptionMask mask) {
    Flowable<Response<Questionoption>> flowable = null;
    try {
      flowable =
          api.update(
                  bean.getToid(),
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
                      .writeValueAsString(new QuestionoptionMask().setToid(true)))
              .subscribeOn(Schedulers.io());
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return flowable;
  }

  public Flowable<Response<List<Questionoption>>> query(FilterLogicExpr filter, RangeExpr range) {
    return query(filter, null, range, null);
  }

  public Flowable<Response<List<Questionoption>>> query(
      FilterLogicExpr filter, OrderByListExpr orderBy, RangeExpr range) {
    return query(filter, orderBy, range, null);
  }

  public Flowable<Response<List<Questionoption>>> query(
      FilterLogicExpr filter, RangeExpr range, QuestionoptionMask mask) {
    return query(filter, null, range, mask);
  }

  public Flowable<Response<List<Questionoption>>> query(
      FilterLogicExpr filter, OrderByListExpr orderBy, RangeExpr range, QuestionoptionMask mask) {
    Flowable<Response<List<Questionoption>>> flowable = null;
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

  public Flowable<Response<Void>> delete(Integer toid) {
    return api.delete(toid).subscribeOn(Schedulers.io());
  }

  public Flowable<Response<ResponseBody>> downloadAttach(Integer toid, String name) {
    Flowable<Response<ResponseBody>> flowable =
        api.downloadAttach(toid, name, "application/octet-stream").subscribeOn(Schedulers.io());
    return flowable;
  }

  public Flowable<Response<Void>> uploadAttach(Integer toid, String name, byte[] bytes) {
    RequestBody body = RequestBody.create(MediaType.parse("multipart/form-data"), bytes);
    Flowable<Response<Void>> flowable =
        api.uploadAttach(toid, name, body).subscribeOn(Schedulers.io());
    return flowable;
  }

  public Flowable<Response<Void>> deleteAttach(Integer toid, String name) {
    Flowable<Response<Void>> flowable = api.deleteAttach(toid, name).subscribeOn(Schedulers.io());
    return flowable;
  }

  public Flowable<Response<List<String>>> listAttaches(Integer toid) {
    Flowable<Response<List<String>>> flowable = api.listAttaches(toid).subscribeOn(Schedulers.io());
    return flowable;
  }

  public interface Api {
    @GET(path + pathKey)
    Flowable<Response<Questionoption>> get(@Path("toid") Integer toid, @Query("mask") String mask);

    @POST(path)
    Flowable<Response<Questionoption>> add(@Body Questionoption bean);

    @PUT(path + pathKey)
    Flowable<Response<Questionoption>> update(
        @Path("toid") Integer toid, @Body Questionoption bean, @Query("mask") String mask);

    @DELETE(path + pathKey)
    Flowable<Response<Void>> delete(@Path("toid") Integer toid);

    @GET(path)
    Flowable<Response<List<Questionoption>>> query(
        @Query("filter") String filter,
        @Query("orderBy") String orderBy,
        @Header("Range") String range,
        @Query("mask") String mask);

    @GET(path)
    Flowable<Response<Void>> count(
        @Query("filter") String filter, @Header("Range") String range, @Query("mask") String mask);

    @GET(attachPath + pathKey)
    Flowable<Response<ResponseBody>> downloadAttach(
        @Path("toid") Integer toid, @Query("name") String name, @Header("Accept") String accept);

    @PUT(attachPath + pathKey)
    Flowable<Response<Void>> uploadAttach(
        @Path("toid") Integer toid, @Query("name") String name, @Body RequestBody body);

    @DELETE(attachPath + pathKey)
    Flowable<Response<Void>> deleteAttach(@Path("toid") Integer toid, @Query("name") String name);

    @GET(attachPath + pathKey)
    Flowable<Response<List<String>>> listAttaches(@Path("toid") Integer toid);
  }
}
