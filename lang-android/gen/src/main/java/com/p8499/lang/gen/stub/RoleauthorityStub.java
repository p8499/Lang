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
import com.p8499.lang.gen.bean.Roleauthority;
import com.p8499.lang.gen.mask.RoleauthorityMask;

public class RoleauthorityStub {
  public static final String path = "api/roleauthority/";
  public static final String attachPath = "api/roleauthority_attachment/";
  public static final String pathKey = "{raid}";

  private static RoleauthorityStub service;

  public static RoleauthorityStub getInstance(Context context) {
    if (service == null) {
      service = new RoleauthorityStub(context);
    }
    return service;
  }

  private Api api;

  public RoleauthorityStub(Context context) {
    api = RetrofitFactory.getInstance(context).create(Api.class);
  }

  public Flowable<Response<Roleauthority>> get(Integer raid) {
    return get(raid, null);
  }

  public Flowable<Response<Roleauthority>> get(Integer raid, RoleauthorityMask mask) {
    Flowable<Response<Roleauthority>> flowable = null;
    try {
      flowable =
          api.get(
                  raid,
                  mask == null ? null : RetrofitFactory.getObjectMapper().writeValueAsString(mask))
              .subscribeOn(Schedulers.io());
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return flowable;
  }

  public Flowable<Response<Roleauthority>> add(Roleauthority bean) {
    Flowable<Response<Roleauthority>> flowable = api.add(bean).subscribeOn(Schedulers.io());
    return flowable;
  }

  public Flowable<Response<Roleauthority>> update(Roleauthority bean) {
    return update(bean, null);
  }

  public Flowable<Response<Roleauthority>> update(Roleauthority bean, RoleauthorityMask mask) {
    Flowable<Response<Roleauthority>> flowable = null;
    try {
      flowable =
          api.update(
                  bean.getRaid(),
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
                      .writeValueAsString(new RoleauthorityMask().setRaid(true)))
              .subscribeOn(Schedulers.io());
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return flowable;
  }

  public Flowable<Response<List<Roleauthority>>> query(FilterLogicExpr filter, RangeExpr range) {
    return query(filter, null, range, null);
  }

  public Flowable<Response<List<Roleauthority>>> query(
      FilterLogicExpr filter, OrderByListExpr orderBy, RangeExpr range) {
    return query(filter, orderBy, range, null);
  }

  public Flowable<Response<List<Roleauthority>>> query(
      FilterLogicExpr filter, RangeExpr range, RoleauthorityMask mask) {
    return query(filter, null, range, mask);
  }

  public Flowable<Response<List<Roleauthority>>> query(
      FilterLogicExpr filter, OrderByListExpr orderBy, RangeExpr range, RoleauthorityMask mask) {
    Flowable<Response<List<Roleauthority>>> flowable = null;
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

  public Flowable<Response<Void>> delete(Integer raid) {
    return api.delete(raid).subscribeOn(Schedulers.io());
  }

  public Flowable<Response<ResponseBody>> downloadAttach(Integer raid, String name) {
    Flowable<Response<ResponseBody>> flowable =
        api.downloadAttach(raid, name, "application/octet-stream").subscribeOn(Schedulers.io());
    return flowable;
  }

  public Flowable<Response<Void>> uploadAttach(Integer raid, String name, byte[] bytes) {
    RequestBody body = RequestBody.create(MediaType.parse("multipart/form-data"), bytes);
    Flowable<Response<Void>> flowable =
        api.uploadAttach(raid, name, body).subscribeOn(Schedulers.io());
    return flowable;
  }

  public Flowable<Response<Void>> deleteAttach(Integer raid, String name) {
    Flowable<Response<Void>> flowable = api.deleteAttach(raid, name).subscribeOn(Schedulers.io());
    return flowable;
  }

  public Flowable<Response<List<String>>> listAttaches(Integer raid) {
    Flowable<Response<List<String>>> flowable = api.listAttaches(raid).subscribeOn(Schedulers.io());
    return flowable;
  }

  public interface Api {
    @GET(path + pathKey)
    Flowable<Response<Roleauthority>> get(@Path("raid") Integer raid, @Query("mask") String mask);

    @POST(path)
    Flowable<Response<Roleauthority>> add(@Body Roleauthority bean);

    @PUT(path + pathKey)
    Flowable<Response<Roleauthority>> update(
        @Path("raid") Integer raid, @Body Roleauthority bean, @Query("mask") String mask);

    @DELETE(path + pathKey)
    Flowable<Response<Void>> delete(@Path("raid") Integer raid);

    @GET(path)
    Flowable<Response<List<Roleauthority>>> query(
        @Query("filter") String filter,
        @Query("orderBy") String orderBy,
        @Header("Range") String range,
        @Query("mask") String mask);

    @GET(path)
    Flowable<Response<Void>> count(
        @Query("filter") String filter, @Header("Range") String range, @Query("mask") String mask);

    @GET(attachPath + pathKey)
    Flowable<Response<ResponseBody>> downloadAttach(
        @Path("raid") Integer raid, @Query("name") String name, @Header("Accept") String accept);

    @PUT(attachPath + pathKey)
    Flowable<Response<Void>> uploadAttach(
        @Path("raid") Integer raid, @Query("name") String name, @Body RequestBody body);

    @DELETE(attachPath + pathKey)
    Flowable<Response<Void>> deleteAttach(@Path("raid") Integer raid, @Query("name") String name);

    @GET(attachPath + pathKey)
    Flowable<Response<List<String>>> listAttaches(@Path("raid") Integer raid);
  }
}
