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
import com.p8499.lang.gen.bean.Segmentflow;
import com.p8499.lang.gen.mask.SegmentflowMask;

public class SegmentflowStub {
  public static final String path = "api/segmentflow/";
  public static final String attachPath = "api/segmentflow_attachment/";
  public static final String pathKey = "{taid}";

  private static SegmentflowStub service;

  public static SegmentflowStub getInstance(Context context) {
    if (service == null) {
      service = new SegmentflowStub(context);
    }
    return service;
  }

  private Api api;

  public SegmentflowStub(Context context) {
    api = RetrofitFactory.getInstance(context).create(Api.class);
  }

  public Flowable<Response<Segmentflow>> get(Integer taid) {
    return get(taid, null);
  }

  public Flowable<Response<Segmentflow>> get(Integer taid, SegmentflowMask mask) {
    Flowable<Response<Segmentflow>> flowable = null;
    try {
      flowable =
          api.get(
                  taid,
                  mask == null ? null : RetrofitFactory.getObjectMapper().writeValueAsString(mask))
              .subscribeOn(Schedulers.io());
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return flowable;
  }

  public Flowable<Response<Segmentflow>> add(Segmentflow bean) {
    Flowable<Response<Segmentflow>> flowable = api.add(bean).subscribeOn(Schedulers.io());
    return flowable;
  }

  public Flowable<Response<Segmentflow>> update(Segmentflow bean) {
    return update(bean, null);
  }

  public Flowable<Response<Segmentflow>> update(Segmentflow bean, SegmentflowMask mask) {
    Flowable<Response<Segmentflow>> flowable = null;
    try {
      flowable =
          api.update(
                  bean.getTaid(),
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
                      .writeValueAsString(new SegmentflowMask().setTaid(true)))
              .subscribeOn(Schedulers.io());
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return flowable;
  }

  public Flowable<Response<List<Segmentflow>>> query(FilterLogicExpr filter, RangeExpr range) {
    return query(filter, null, range, null);
  }

  public Flowable<Response<List<Segmentflow>>> query(
      FilterLogicExpr filter, OrderByListExpr orderBy, RangeExpr range) {
    return query(filter, orderBy, range, null);
  }

  public Flowable<Response<List<Segmentflow>>> query(
      FilterLogicExpr filter, RangeExpr range, SegmentflowMask mask) {
    return query(filter, null, range, mask);
  }

  public Flowable<Response<List<Segmentflow>>> query(
      FilterLogicExpr filter, OrderByListExpr orderBy, RangeExpr range, SegmentflowMask mask) {
    Flowable<Response<List<Segmentflow>>> flowable = null;
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

  public Flowable<Response<Void>> delete(Integer taid) {
    return api.delete(taid).subscribeOn(Schedulers.io());
  }

  public Flowable<Response<ResponseBody>> downloadAttach(Integer taid, String name) {
    Flowable<Response<ResponseBody>> flowable =
        api.downloadAttach(taid, name, "application/octet-stream").subscribeOn(Schedulers.io());
    return flowable;
  }

  public Flowable<Response<Void>> uploadAttach(Integer taid, String name, byte[] bytes) {
    RequestBody body = RequestBody.create(MediaType.parse("multipart/form-data"), bytes);
    Flowable<Response<Void>> flowable =
        api.uploadAttach(taid, name, body).subscribeOn(Schedulers.io());
    return flowable;
  }

  public Flowable<Response<Void>> deleteAttach(Integer taid, String name) {
    Flowable<Response<Void>> flowable = api.deleteAttach(taid, name).subscribeOn(Schedulers.io());
    return flowable;
  }

  public Flowable<Response<List<String>>> listAttaches(Integer taid) {
    Flowable<Response<List<String>>> flowable = api.listAttaches(taid).subscribeOn(Schedulers.io());
    return flowable;
  }

  public interface Api {
    @GET(path + pathKey)
    Flowable<Response<Segmentflow>> get(@Path("taid") Integer taid, @Query("mask") String mask);

    @POST(path)
    Flowable<Response<Segmentflow>> add(@Body Segmentflow bean);

    @PUT(path + pathKey)
    Flowable<Response<Segmentflow>> update(
        @Path("taid") Integer taid, @Body Segmentflow bean, @Query("mask") String mask);

    @DELETE(path + pathKey)
    Flowable<Response<Void>> delete(@Path("taid") Integer taid);

    @GET(path)
    Flowable<Response<List<Segmentflow>>> query(
        @Query("filter") String filter,
        @Query("orderBy") String orderBy,
        @Header("Range") String range,
        @Query("mask") String mask);

    @GET(path)
    Flowable<Response<Void>> count(
        @Query("filter") String filter, @Header("Range") String range, @Query("mask") String mask);

    @GET(attachPath + pathKey)
    Flowable<Response<ResponseBody>> downloadAttach(
        @Path("taid") Integer taid, @Query("name") String name, @Header("Accept") String accept);

    @PUT(attachPath + pathKey)
    Flowable<Response<Void>> uploadAttach(
        @Path("taid") Integer taid, @Query("name") String name, @Body RequestBody body);

    @DELETE(attachPath + pathKey)
    Flowable<Response<Void>> deleteAttach(@Path("taid") Integer taid, @Query("name") String name);

    @GET(attachPath + pathKey)
    Flowable<Response<List<String>>> listAttaches(@Path("taid") Integer taid);
  }
}
