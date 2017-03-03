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
import com.p8499.lang.gen.bean.Userrole;
import com.p8499.lang.gen.mask.UserroleMask;

public class UserroleStub {
  public static final String path = "api/userrole/";
  public static final String attachPath = "api/userrole_attachment/";
  public static final String pathKey = "{urid}";

  private static UserroleStub service;

  public static UserroleStub getInstance(Context context) {
    if (service == null) {
      service = new UserroleStub(context);
    }
    return service;
  }

  private Api api;

  public UserroleStub(Context context) {
    api = RetrofitFactory.getInstance(context).create(Api.class);
  }

  public Flowable<Response<Userrole>> get(Integer urid) {
    return get(urid, null);
  }

  public Flowable<Response<Userrole>> get(Integer urid, UserroleMask mask) {
    Flowable<Response<Userrole>> flowable = null;
    try {
      flowable =
          api.get(
                  urid,
                  mask == null ? null : RetrofitFactory.getObjectMapper().writeValueAsString(mask))
              .subscribeOn(Schedulers.io());
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return flowable;
  }

  public Flowable<Response<Userrole>> add(Userrole bean) {
    Flowable<Response<Userrole>> flowable = api.add(bean).subscribeOn(Schedulers.io());
    return flowable;
  }

  public Flowable<Response<Userrole>> update(Userrole bean) {
    return update(bean, null);
  }

  public Flowable<Response<Userrole>> update(Userrole bean, UserroleMask mask) {
    Flowable<Response<Userrole>> flowable = null;
    try {
      flowable =
          api.update(
                  bean.getUrid(),
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
                      .writeValueAsString(new UserroleMask().setUrid(true)))
              .subscribeOn(Schedulers.io());
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return flowable;
  }

  public Flowable<Response<List<Userrole>>> query(FilterLogicExpr filter, RangeExpr range) {
    return query(filter, null, range, null);
  }

  public Flowable<Response<List<Userrole>>> query(
      FilterLogicExpr filter, OrderByListExpr orderBy, RangeExpr range) {
    return query(filter, orderBy, range, null);
  }

  public Flowable<Response<List<Userrole>>> query(
      FilterLogicExpr filter, RangeExpr range, UserroleMask mask) {
    return query(filter, null, range, mask);
  }

  public Flowable<Response<List<Userrole>>> query(
      FilterLogicExpr filter, OrderByListExpr orderBy, RangeExpr range, UserroleMask mask) {
    Flowable<Response<List<Userrole>>> flowable = null;
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

  public Flowable<Response<Void>> delete(Integer urid) {
    return api.delete(urid).subscribeOn(Schedulers.io());
  }

  public Flowable<Response<ResponseBody>> downloadAttach(Integer urid, String name) {
    Flowable<Response<ResponseBody>> flowable =
        api.downloadAttach(urid, name, "application/octet-stream").subscribeOn(Schedulers.io());
    return flowable;
  }

  public Flowable<Response<Void>> uploadAttach(Integer urid, String name, byte[] bytes) {
    RequestBody body = RequestBody.create(MediaType.parse("multipart/form-data"), bytes);
    Flowable<Response<Void>> flowable =
        api.uploadAttach(urid, name, body).subscribeOn(Schedulers.io());
    return flowable;
  }

  public Flowable<Response<Void>> deleteAttach(Integer urid, String name) {
    Flowable<Response<Void>> flowable = api.deleteAttach(urid, name).subscribeOn(Schedulers.io());
    return flowable;
  }

  public Flowable<Response<List<String>>> listAttaches(Integer urid) {
    Flowable<Response<List<String>>> flowable = api.listAttaches(urid).subscribeOn(Schedulers.io());
    return flowable;
  }

  public interface Api {
    @GET(path + pathKey)
    Flowable<Response<Userrole>> get(@Path("urid") Integer urid, @Query("mask") String mask);

    @POST(path)
    Flowable<Response<Userrole>> add(@Body Userrole bean);

    @PUT(path + pathKey)
    Flowable<Response<Userrole>> update(
        @Path("urid") Integer urid, @Body Userrole bean, @Query("mask") String mask);

    @DELETE(path + pathKey)
    Flowable<Response<Void>> delete(@Path("urid") Integer urid);

    @GET(path)
    Flowable<Response<List<Userrole>>> query(
        @Query("filter") String filter,
        @Query("orderBy") String orderBy,
        @Header("Range") String range,
        @Query("mask") String mask);

    @GET(path)
    Flowable<Response<Void>> count(
        @Query("filter") String filter, @Header("Range") String range, @Query("mask") String mask);

    @GET(attachPath + pathKey)
    Flowable<Response<ResponseBody>> downloadAttach(
        @Path("urid") Integer urid, @Query("name") String name, @Header("Accept") String accept);

    @PUT(attachPath + pathKey)
    Flowable<Response<Void>> uploadAttach(
        @Path("urid") Integer urid, @Query("name") String name, @Body RequestBody body);

    @DELETE(attachPath + pathKey)
    Flowable<Response<Void>> deleteAttach(@Path("urid") Integer urid, @Query("name") String name);

    @GET(attachPath + pathKey)
    Flowable<Response<List<String>>> listAttaches(@Path("urid") Integer urid);
  }
}
