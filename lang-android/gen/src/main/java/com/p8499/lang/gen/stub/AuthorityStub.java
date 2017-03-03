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
import com.p8499.lang.gen.bean.Authority;
import com.p8499.lang.gen.mask.AuthorityMask;

public class AuthorityStub {
  public static final String path = "api/authority/";
  public static final String attachPath = "api/authority_attachment/";
  public static final String pathKey = "{auid}";

  private static AuthorityStub service;

  public static AuthorityStub getInstance(Context context) {
    if (service == null) {
      service = new AuthorityStub(context);
    }
    return service;
  }

  private Api api;

  public AuthorityStub(Context context) {
    api = RetrofitFactory.getInstance(context).create(Api.class);
  }

  public Flowable<Response<Authority>> get(String auid) {
    return get(auid, null);
  }

  public Flowable<Response<Authority>> get(String auid, AuthorityMask mask) {
    Flowable<Response<Authority>> flowable = null;
    try {
      flowable =
          api.get(
                  auid,
                  mask == null ? null : RetrofitFactory.getObjectMapper().writeValueAsString(mask))
              .subscribeOn(Schedulers.io());
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return flowable;
  }

  public Flowable<Response<Authority>> add(Authority bean) {
    Flowable<Response<Authority>> flowable =
        api.add(bean.getAuid(), bean).subscribeOn(Schedulers.io());
    return flowable;
  }

  public Flowable<Response<Authority>> update(Authority bean) {
    return update(bean, null);
  }

  public Flowable<Response<Authority>> update(Authority bean, AuthorityMask mask) {
    Flowable<Response<Authority>> flowable = null;
    try {
      flowable =
          api.update(
                  bean.getAuid(),
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
                      .writeValueAsString(new AuthorityMask().setAuid(true)))
              .subscribeOn(Schedulers.io());
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return flowable;
  }

  public Flowable<Response<List<Authority>>> query(FilterLogicExpr filter, RangeExpr range) {
    return query(filter, null, range, null);
  }

  public Flowable<Response<List<Authority>>> query(
      FilterLogicExpr filter, OrderByListExpr orderBy, RangeExpr range) {
    return query(filter, orderBy, range, null);
  }

  public Flowable<Response<List<Authority>>> query(
      FilterLogicExpr filter, RangeExpr range, AuthorityMask mask) {
    return query(filter, null, range, mask);
  }

  public Flowable<Response<List<Authority>>> query(
      FilterLogicExpr filter, OrderByListExpr orderBy, RangeExpr range, AuthorityMask mask) {
    Flowable<Response<List<Authority>>> flowable = null;
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

  public Flowable<Response<Void>> delete(String auid) {
    return api.delete(auid).subscribeOn(Schedulers.io());
  }

  public Flowable<Response<ResponseBody>> downloadAttach(String auid, String name) {
    Flowable<Response<ResponseBody>> flowable =
        api.downloadAttach(auid, name, "application/octet-stream").subscribeOn(Schedulers.io());
    return flowable;
  }

  public Flowable<Response<Void>> uploadAttach(String auid, String name, byte[] bytes) {
    RequestBody body = RequestBody.create(MediaType.parse("multipart/form-data"), bytes);
    Flowable<Response<Void>> flowable =
        api.uploadAttach(auid, name, body).subscribeOn(Schedulers.io());
    return flowable;
  }

  public Flowable<Response<Void>> deleteAttach(String auid, String name) {
    Flowable<Response<Void>> flowable = api.deleteAttach(auid, name).subscribeOn(Schedulers.io());
    return flowable;
  }

  public Flowable<Response<List<String>>> listAttaches(String auid) {
    Flowable<Response<List<String>>> flowable = api.listAttaches(auid).subscribeOn(Schedulers.io());
    return flowable;
  }

  public interface Api {
    @GET(path + pathKey)
    Flowable<Response<Authority>> get(@Path("auid") String auid, @Query("mask") String mask);

    @POST(path + pathKey)
    Flowable<Response<Authority>> add(@Path("auid") String auid, @Body Authority bean);

    @PUT(path + pathKey)
    Flowable<Response<Authority>> update(
        @Path("auid") String auid, @Body Authority bean, @Query("mask") String mask);

    @DELETE(path + pathKey)
    Flowable<Response<Void>> delete(@Path("auid") String auid);

    @GET(path)
    Flowable<Response<List<Authority>>> query(
        @Query("filter") String filter,
        @Query("orderBy") String orderBy,
        @Header("Range") String range,
        @Query("mask") String mask);

    @GET(path)
    Flowable<Response<Void>> count(
        @Query("filter") String filter, @Header("Range") String range, @Query("mask") String mask);

    @GET(attachPath + pathKey)
    Flowable<Response<ResponseBody>> downloadAttach(
        @Path("auid") String auid, @Query("name") String name, @Header("Accept") String accept);

    @PUT(attachPath + pathKey)
    Flowable<Response<Void>> uploadAttach(
        @Path("auid") String auid, @Query("name") String name, @Body RequestBody body);

    @DELETE(attachPath + pathKey)
    Flowable<Response<Void>> deleteAttach(@Path("auid") String auid, @Query("name") String name);

    @GET(attachPath + pathKey)
    Flowable<Response<List<String>>> listAttaches(@Path("auid") String auid);
  }
}
