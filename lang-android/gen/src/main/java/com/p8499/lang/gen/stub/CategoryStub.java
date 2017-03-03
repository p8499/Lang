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
import com.p8499.lang.gen.bean.Category;
import com.p8499.lang.gen.mask.CategoryMask;

public class CategoryStub {
  public static final String path = "api/category/";
  public static final String attachPath = "api/category_attachment/";
  public static final String pathKey = "{cgid}";

  private static CategoryStub service;

  public static CategoryStub getInstance(Context context) {
    if (service == null) {
      service = new CategoryStub(context);
    }
    return service;
  }

  private Api api;

  public CategoryStub(Context context) {
    api = RetrofitFactory.getInstance(context).create(Api.class);
  }

  public Flowable<Response<Category>> get(Integer cgid) {
    return get(cgid, null);
  }

  public Flowable<Response<Category>> get(Integer cgid, CategoryMask mask) {
    Flowable<Response<Category>> flowable = null;
    try {
      flowable =
          api.get(
                  cgid,
                  mask == null ? null : RetrofitFactory.getObjectMapper().writeValueAsString(mask))
              .subscribeOn(Schedulers.io());
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return flowable;
  }

  public Flowable<Response<Category>> add(Category bean) {
    Flowable<Response<Category>> flowable = api.add(bean).subscribeOn(Schedulers.io());
    return flowable;
  }

  public Flowable<Response<Category>> update(Category bean) {
    return update(bean, null);
  }

  public Flowable<Response<Category>> update(Category bean, CategoryMask mask) {
    Flowable<Response<Category>> flowable = null;
    try {
      flowable =
          api.update(
                  bean.getCgid(),
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
                      .writeValueAsString(new CategoryMask().setCgid(true)))
              .subscribeOn(Schedulers.io());
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return flowable;
  }

  public Flowable<Response<List<Category>>> query(FilterLogicExpr filter, RangeExpr range) {
    return query(filter, null, range, null);
  }

  public Flowable<Response<List<Category>>> query(
      FilterLogicExpr filter, OrderByListExpr orderBy, RangeExpr range) {
    return query(filter, orderBy, range, null);
  }

  public Flowable<Response<List<Category>>> query(
      FilterLogicExpr filter, RangeExpr range, CategoryMask mask) {
    return query(filter, null, range, mask);
  }

  public Flowable<Response<List<Category>>> query(
      FilterLogicExpr filter, OrderByListExpr orderBy, RangeExpr range, CategoryMask mask) {
    Flowable<Response<List<Category>>> flowable = null;
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

  public Flowable<Response<Void>> delete(Integer cgid) {
    return api.delete(cgid).subscribeOn(Schedulers.io());
  }

  public Flowable<Response<ResponseBody>> downloadAttach(Integer cgid, String name) {
    Flowable<Response<ResponseBody>> flowable =
        api.downloadAttach(cgid, name, "application/octet-stream").subscribeOn(Schedulers.io());
    return flowable;
  }

  public Flowable<Response<Void>> uploadAttach(Integer cgid, String name, byte[] bytes) {
    RequestBody body = RequestBody.create(MediaType.parse("multipart/form-data"), bytes);
    Flowable<Response<Void>> flowable =
        api.uploadAttach(cgid, name, body).subscribeOn(Schedulers.io());
    return flowable;
  }

  public Flowable<Response<Void>> deleteAttach(Integer cgid, String name) {
    Flowable<Response<Void>> flowable = api.deleteAttach(cgid, name).subscribeOn(Schedulers.io());
    return flowable;
  }

  public Flowable<Response<List<String>>> listAttaches(Integer cgid) {
    Flowable<Response<List<String>>> flowable = api.listAttaches(cgid).subscribeOn(Schedulers.io());
    return flowable;
  }

  public interface Api {
    @GET(path + pathKey)
    Flowable<Response<Category>> get(@Path("cgid") Integer cgid, @Query("mask") String mask);

    @POST(path)
    Flowable<Response<Category>> add(@Body Category bean);

    @PUT(path + pathKey)
    Flowable<Response<Category>> update(
        @Path("cgid") Integer cgid, @Body Category bean, @Query("mask") String mask);

    @DELETE(path + pathKey)
    Flowable<Response<Void>> delete(@Path("cgid") Integer cgid);

    @GET(path)
    Flowable<Response<List<Category>>> query(
        @Query("filter") String filter,
        @Query("orderBy") String orderBy,
        @Header("Range") String range,
        @Query("mask") String mask);

    @GET(path)
    Flowable<Response<Void>> count(
        @Query("filter") String filter, @Header("Range") String range, @Query("mask") String mask);

    @GET(attachPath + pathKey)
    Flowable<Response<ResponseBody>> downloadAttach(
        @Path("cgid") Integer cgid, @Query("name") String name, @Header("Accept") String accept);

    @PUT(attachPath + pathKey)
    Flowable<Response<Void>> uploadAttach(
        @Path("cgid") Integer cgid, @Query("name") String name, @Body RequestBody body);

    @DELETE(attachPath + pathKey)
    Flowable<Response<Void>> deleteAttach(@Path("cgid") Integer cgid, @Query("name") String name);

    @GET(attachPath + pathKey)
    Flowable<Response<List<String>>> listAttaches(@Path("cgid") Integer cgid);
  }
}
