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
import com.p8499.lang.gen.bean.Role;
import com.p8499.lang.gen.mask.RoleMask;

public class RoleStub {
  public static final String path = "api/role/";
  public static final String attachPath = "api/role_attachment/";
  public static final String pathKey = "{rlid}";

  private static RoleStub service;

  public static RoleStub getInstance(Context context) {
    if (service == null) {
      service = new RoleStub(context);
    }
    return service;
  }

  private Api api;

  public RoleStub(Context context) {
    api = RetrofitFactory.getInstance(context).create(Api.class);
  }

  public Flowable<Response<Role>> get(String rlid) {
    return get(rlid, null);
  }

  public Flowable<Response<Role>> get(String rlid, RoleMask mask) {
    Flowable<Response<Role>> flowable = null;
    try {
      flowable =
          api.get(
                  rlid,
                  mask == null ? null : RetrofitFactory.getObjectMapper().writeValueAsString(mask))
              .subscribeOn(Schedulers.io());
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return flowable;
  }

  public Flowable<Response<Role>> add(Role bean) {
    Flowable<Response<Role>> flowable = api.add(bean.getRlid(), bean).subscribeOn(Schedulers.io());
    return flowable;
  }

  public Flowable<Response<Role>> update(Role bean) {
    return update(bean, null);
  }

  public Flowable<Response<Role>> update(Role bean, RoleMask mask) {
    Flowable<Response<Role>> flowable = null;
    try {
      flowable =
          api.update(
                  bean.getRlid(),
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
                      .writeValueAsString(new RoleMask().setRlid(true)))
              .subscribeOn(Schedulers.io());
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return flowable;
  }

  public Flowable<Response<List<Role>>> query(FilterLogicExpr filter, RangeExpr range) {
    return query(filter, null, range, null);
  }

  public Flowable<Response<List<Role>>> query(
      FilterLogicExpr filter, OrderByListExpr orderBy, RangeExpr range) {
    return query(filter, orderBy, range, null);
  }

  public Flowable<Response<List<Role>>> query(
      FilterLogicExpr filter, RangeExpr range, RoleMask mask) {
    return query(filter, null, range, mask);
  }

  public Flowable<Response<List<Role>>> query(
      FilterLogicExpr filter, OrderByListExpr orderBy, RangeExpr range, RoleMask mask) {
    Flowable<Response<List<Role>>> flowable = null;
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

  public Flowable<Response<Void>> delete(String rlid) {
    return api.delete(rlid).subscribeOn(Schedulers.io());
  }

  public Flowable<Response<ResponseBody>> downloadAttach(String rlid, String name) {
    Flowable<Response<ResponseBody>> flowable =
        api.downloadAttach(rlid, name, "application/octet-stream").subscribeOn(Schedulers.io());
    return flowable;
  }

  public Flowable<Response<Void>> uploadAttach(String rlid, String name, byte[] bytes) {
    RequestBody body = RequestBody.create(MediaType.parse("multipart/form-data"), bytes);
    Flowable<Response<Void>> flowable =
        api.uploadAttach(rlid, name, body).subscribeOn(Schedulers.io());
    return flowable;
  }

  public Flowable<Response<Void>> deleteAttach(String rlid, String name) {
    Flowable<Response<Void>> flowable = api.deleteAttach(rlid, name).subscribeOn(Schedulers.io());
    return flowable;
  }

  public Flowable<Response<List<String>>> listAttaches(String rlid) {
    Flowable<Response<List<String>>> flowable = api.listAttaches(rlid).subscribeOn(Schedulers.io());
    return flowable;
  }

  public interface Api {
    @GET(path + pathKey)
    Flowable<Response<Role>> get(@Path("rlid") String rlid, @Query("mask") String mask);

    @POST(path + pathKey)
    Flowable<Response<Role>> add(@Path("rlid") String rlid, @Body Role bean);

    @PUT(path + pathKey)
    Flowable<Response<Role>> update(
        @Path("rlid") String rlid, @Body Role bean, @Query("mask") String mask);

    @DELETE(path + pathKey)
    Flowable<Response<Void>> delete(@Path("rlid") String rlid);

    @GET(path)
    Flowable<Response<List<Role>>> query(
        @Query("filter") String filter,
        @Query("orderBy") String orderBy,
        @Header("Range") String range,
        @Query("mask") String mask);

    @GET(path)
    Flowable<Response<Void>> count(
        @Query("filter") String filter, @Header("Range") String range, @Query("mask") String mask);

    @GET(attachPath + pathKey)
    Flowable<Response<ResponseBody>> downloadAttach(
        @Path("rlid") String rlid, @Query("name") String name, @Header("Accept") String accept);

    @PUT(attachPath + pathKey)
    Flowable<Response<Void>> uploadAttach(
        @Path("rlid") String rlid, @Query("name") String name, @Body RequestBody body);

    @DELETE(attachPath + pathKey)
    Flowable<Response<Void>> deleteAttach(@Path("rlid") String rlid, @Query("name") String name);

    @GET(attachPath + pathKey)
    Flowable<Response<List<String>>> listAttaches(@Path("rlid") String rlid);
  }
}
