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
import com.p8499.lang.gen.bean.Sentence;
import com.p8499.lang.gen.mask.SentenceMask;

public class SentenceStub {
  public static final String path = "api/sentence/";
  public static final String attachPath = "api/sentence_attachment/";
  public static final String pathKey = "{asid}";

  private static SentenceStub service;

  public static SentenceStub getInstance(Context context) {
    if (service == null) {
      service = new SentenceStub(context);
    }
    return service;
  }

  private Api api;

  public SentenceStub(Context context) {
    api = RetrofitFactory.getInstance(context).create(Api.class);
  }

  public Flowable<Response<Sentence>> get(Integer asid) {
    return get(asid, null);
  }

  public Flowable<Response<Sentence>> get(Integer asid, SentenceMask mask) {
    Flowable<Response<Sentence>> flowable = null;
    try {
      flowable =
          api.get(
                  asid,
                  mask == null ? null : RetrofitFactory.getObjectMapper().writeValueAsString(mask))
              .subscribeOn(Schedulers.io());
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return flowable;
  }

  public Flowable<Response<Sentence>> add(Sentence bean) {
    Flowable<Response<Sentence>> flowable = api.add(bean).subscribeOn(Schedulers.io());
    return flowable;
  }

  public Flowable<Response<Sentence>> update(Sentence bean) {
    return update(bean, null);
  }

  public Flowable<Response<Sentence>> update(Sentence bean, SentenceMask mask) {
    Flowable<Response<Sentence>> flowable = null;
    try {
      flowable =
          api.update(
                  bean.getAsid(),
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
                      .writeValueAsString(new SentenceMask().setAsid(true)))
              .subscribeOn(Schedulers.io());
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return flowable;
  }

  public Flowable<Response<List<Sentence>>> query(FilterLogicExpr filter, RangeExpr range) {
    return query(filter, null, range, null);
  }

  public Flowable<Response<List<Sentence>>> query(
      FilterLogicExpr filter, OrderByListExpr orderBy, RangeExpr range) {
    return query(filter, orderBy, range, null);
  }

  public Flowable<Response<List<Sentence>>> query(
      FilterLogicExpr filter, RangeExpr range, SentenceMask mask) {
    return query(filter, null, range, mask);
  }

  public Flowable<Response<List<Sentence>>> query(
      FilterLogicExpr filter, OrderByListExpr orderBy, RangeExpr range, SentenceMask mask) {
    Flowable<Response<List<Sentence>>> flowable = null;
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

  public Flowable<Response<Void>> delete(Integer asid) {
    return api.delete(asid).subscribeOn(Schedulers.io());
  }

  public Flowable<Response<ResponseBody>> downloadAttach(Integer asid, String name) {
    Flowable<Response<ResponseBody>> flowable =
        api.downloadAttach(asid, name, "application/octet-stream").subscribeOn(Schedulers.io());
    return flowable;
  }

  public Flowable<Response<Void>> uploadAttach(Integer asid, String name, byte[] bytes) {
    RequestBody body = RequestBody.create(MediaType.parse("multipart/form-data"), bytes);
    Flowable<Response<Void>> flowable =
        api.uploadAttach(asid, name, body).subscribeOn(Schedulers.io());
    return flowable;
  }

  public Flowable<Response<Void>> deleteAttach(Integer asid, String name) {
    Flowable<Response<Void>> flowable = api.deleteAttach(asid, name).subscribeOn(Schedulers.io());
    return flowable;
  }

  public Flowable<Response<List<String>>> listAttaches(Integer asid) {
    Flowable<Response<List<String>>> flowable = api.listAttaches(asid).subscribeOn(Schedulers.io());
    return flowable;
  }

  public interface Api {
    @GET(path + pathKey)
    Flowable<Response<Sentence>> get(@Path("asid") Integer asid, @Query("mask") String mask);

    @POST(path)
    Flowable<Response<Sentence>> add(@Body Sentence bean);

    @PUT(path + pathKey)
    Flowable<Response<Sentence>> update(
        @Path("asid") Integer asid, @Body Sentence bean, @Query("mask") String mask);

    @DELETE(path + pathKey)
    Flowable<Response<Void>> delete(@Path("asid") Integer asid);

    @GET(path)
    Flowable<Response<List<Sentence>>> query(
        @Query("filter") String filter,
        @Query("orderBy") String orderBy,
        @Header("Range") String range,
        @Query("mask") String mask);

    @GET(path)
    Flowable<Response<Void>> count(
        @Query("filter") String filter, @Header("Range") String range, @Query("mask") String mask);

    @GET(attachPath + pathKey)
    Flowable<Response<ResponseBody>> downloadAttach(
        @Path("asid") Integer asid, @Query("name") String name, @Header("Accept") String accept);

    @PUT(attachPath + pathKey)
    Flowable<Response<Void>> uploadAttach(
        @Path("asid") Integer asid, @Query("name") String name, @Body RequestBody body);

    @DELETE(attachPath + pathKey)
    Flowable<Response<Void>> deleteAttach(@Path("asid") Integer asid, @Query("name") String name);

    @GET(attachPath + pathKey)
    Flowable<Response<List<String>>> listAttaches(@Path("asid") Integer asid);
  }
}
