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
import com.p8499.lang.gen.bean.Usercreation;
import com.p8499.lang.gen.mask.UsercreationMask;

public class UsercreationStub {
  public static final String path = "api/usercreation/";
  public static final String attachPath = "api/usercreation_attachment/";
  public static final String pathKey = "{ucid}";

  private static UsercreationStub service;

  public static UsercreationStub getInstance(Context context) {
    if (service == null) {
      service = new UsercreationStub(context);
    }
    return service;
  }

  private Api api;

  public UsercreationStub(Context context) {
    api = RetrofitFactory.getInstance(context).create(Api.class);
  }

  public Flowable<Response<Usercreation>> get(Integer ucid) {
    return get(ucid, null);
  }

  public Flowable<Response<Usercreation>> get(Integer ucid, UsercreationMask mask) {
    Flowable<Response<Usercreation>> flowable = null;
    try {
      flowable =
          api.get(
                  ucid,
                  mask == null ? null : RetrofitFactory.getObjectMapper().writeValueAsString(mask))
              .subscribeOn(Schedulers.io());
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return flowable;
  }

  public Flowable<Response<Usercreation>> add(Usercreation bean) {
    Flowable<Response<Usercreation>> flowable = api.add(bean).subscribeOn(Schedulers.io());
    return flowable;
  }

  public Flowable<Response<Usercreation>> update(Usercreation bean) {
    return update(bean, null);
  }

  public Flowable<Response<Usercreation>> update(Usercreation bean, UsercreationMask mask) {
    Flowable<Response<Usercreation>> flowable = null;
    try {
      flowable =
          api.update(
                  bean.getUcid(),
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
                      .writeValueAsString(new UsercreationMask().setUcid(true)))
              .subscribeOn(Schedulers.io());
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return flowable;
  }

  public Flowable<Response<List<Usercreation>>> query(FilterLogicExpr filter, RangeExpr range) {
    return query(filter, null, range, null);
  }

  public Flowable<Response<List<Usercreation>>> query(
      FilterLogicExpr filter, OrderByListExpr orderBy, RangeExpr range) {
    return query(filter, orderBy, range, null);
  }

  public Flowable<Response<List<Usercreation>>> query(
      FilterLogicExpr filter, RangeExpr range, UsercreationMask mask) {
    return query(filter, null, range, mask);
  }

  public Flowable<Response<List<Usercreation>>> query(
      FilterLogicExpr filter, OrderByListExpr orderBy, RangeExpr range, UsercreationMask mask) {
    Flowable<Response<List<Usercreation>>> flowable = null;
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

  public Flowable<Response<Void>> delete(Integer ucid) {
    return api.delete(ucid).subscribeOn(Schedulers.io());
  }

  public Flowable<Response<ResponseBody>> downloadAttach(Integer ucid, String name) {
    Flowable<Response<ResponseBody>> flowable =
        api.downloadAttach(ucid, name, "application/octet-stream").subscribeOn(Schedulers.io());
    return flowable;
  }

  public Flowable<Response<Void>> uploadAttach(Integer ucid, String name, byte[] bytes) {
    RequestBody body = RequestBody.create(MediaType.parse("multipart/form-data"), bytes);
    Flowable<Response<Void>> flowable =
        api.uploadAttach(ucid, name, body).subscribeOn(Schedulers.io());
    return flowable;
  }

  public Flowable<Response<Void>> deleteAttach(Integer ucid, String name) {
    Flowable<Response<Void>> flowable = api.deleteAttach(ucid, name).subscribeOn(Schedulers.io());
    return flowable;
  }

  public Flowable<Response<List<String>>> listAttaches(Integer ucid) {
    Flowable<Response<List<String>>> flowable = api.listAttaches(ucid).subscribeOn(Schedulers.io());
    return flowable;
  }

  public interface Api {
    @GET(path + pathKey)
    Flowable<Response<Usercreation>> get(@Path("ucid") Integer ucid, @Query("mask") String mask);

    @POST(path)
    Flowable<Response<Usercreation>> add(@Body Usercreation bean);

    @PUT(path + pathKey)
    Flowable<Response<Usercreation>> update(
        @Path("ucid") Integer ucid, @Body Usercreation bean, @Query("mask") String mask);

    @DELETE(path + pathKey)
    Flowable<Response<Void>> delete(@Path("ucid") Integer ucid);

    @GET(path)
    Flowable<Response<List<Usercreation>>> query(
        @Query("filter") String filter,
        @Query("orderBy") String orderBy,
        @Header("Range") String range,
        @Query("mask") String mask);

    @GET(path)
    Flowable<Response<Void>> count(
        @Query("filter") String filter, @Header("Range") String range, @Query("mask") String mask);

    @GET(attachPath + pathKey)
    Flowable<Response<ResponseBody>> downloadAttach(
        @Path("ucid") Integer ucid, @Query("name") String name, @Header("Accept") String accept);

    @PUT(attachPath + pathKey)
    Flowable<Response<Void>> uploadAttach(
        @Path("ucid") Integer ucid, @Query("name") String name, @Body RequestBody body);

    @DELETE(attachPath + pathKey)
    Flowable<Response<Void>> deleteAttach(@Path("ucid") Integer ucid, @Query("name") String name);

    @GET(attachPath + pathKey)
    Flowable<Response<List<String>>> listAttaches(@Path("ucid") Integer ucid);
  }
}
