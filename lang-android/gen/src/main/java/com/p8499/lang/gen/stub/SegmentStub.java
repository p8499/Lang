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
import com.p8499.lang.gen.bean.Segment;
import com.p8499.lang.gen.mask.SegmentMask;

public class SegmentStub {
  public static final String path = "api/segment/";
  public static final String attachPath = "api/segment_attachment/";
  public static final String pathKey = "{trasid}";

  private static SegmentStub service;

  public static SegmentStub getInstance(Context context) {
    if (service == null) {
      service = new SegmentStub(context);
    }
    return service;
  }

  private Api api;

  public SegmentStub(Context context) {
    api = RetrofitFactory.getInstance(context).create(Api.class);
  }

  public Flowable<Response<Segment>> get(Integer trasid) {
    return get(trasid, null);
  }

  public Flowable<Response<Segment>> get(Integer trasid, SegmentMask mask) {
    Flowable<Response<Segment>> flowable = null;
    try {
      flowable =
          api.get(
                  trasid,
                  mask == null ? null : RetrofitFactory.getObjectMapper().writeValueAsString(mask))
              .subscribeOn(Schedulers.io());
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return flowable;
  }

  public Flowable<Response<Segment>> add(Segment bean) {
    Flowable<Response<Segment>> flowable =
        api.add(bean.getTrasid(), bean).subscribeOn(Schedulers.io());
    return flowable;
  }

  public Flowable<Response<Segment>> update(Segment bean) {
    return update(bean, null);
  }

  public Flowable<Response<Segment>> update(Segment bean, SegmentMask mask) {
    Flowable<Response<Segment>> flowable = null;
    try {
      flowable =
          api.update(
                  bean.getTrasid(),
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
                      .writeValueAsString(new SegmentMask().setTrasid(true)))
              .subscribeOn(Schedulers.io());
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return flowable;
  }

  public Flowable<Response<List<Segment>>> query(FilterLogicExpr filter, RangeExpr range) {
    return query(filter, null, range, null);
  }

  public Flowable<Response<List<Segment>>> query(
      FilterLogicExpr filter, OrderByListExpr orderBy, RangeExpr range) {
    return query(filter, orderBy, range, null);
  }

  public Flowable<Response<List<Segment>>> query(
      FilterLogicExpr filter, RangeExpr range, SegmentMask mask) {
    return query(filter, null, range, mask);
  }

  public Flowable<Response<List<Segment>>> query(
      FilterLogicExpr filter, OrderByListExpr orderBy, RangeExpr range, SegmentMask mask) {
    Flowable<Response<List<Segment>>> flowable = null;
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

  public Flowable<Response<Void>> delete(Integer trasid) {
    return api.delete(trasid).subscribeOn(Schedulers.io());
  }

  public Flowable<Response<ResponseBody>> downloadAttach(Integer trasid, String name) {
    Flowable<Response<ResponseBody>> flowable =
        api.downloadAttach(trasid, name, "application/octet-stream").subscribeOn(Schedulers.io());
    return flowable;
  }

  public Flowable<Response<Void>> uploadAttach(Integer trasid, String name, byte[] bytes) {
    RequestBody body = RequestBody.create(MediaType.parse("multipart/form-data"), bytes);
    Flowable<Response<Void>> flowable =
        api.uploadAttach(trasid, name, body).subscribeOn(Schedulers.io());
    return flowable;
  }

  public Flowable<Response<Void>> deleteAttach(Integer trasid, String name) {
    Flowable<Response<Void>> flowable = api.deleteAttach(trasid, name).subscribeOn(Schedulers.io());
    return flowable;
  }

  public Flowable<Response<List<String>>> listAttaches(Integer trasid) {
    Flowable<Response<List<String>>> flowable =
        api.listAttaches(trasid).subscribeOn(Schedulers.io());
    return flowable;
  }

  public interface Api {
    @GET(path + pathKey)
    Flowable<Response<Segment>> get(@Path("trasid") Integer trasid, @Query("mask") String mask);

    @POST(path + pathKey)
    Flowable<Response<Segment>> add(@Path("trasid") Integer trasid, @Body Segment bean);

    @PUT(path + pathKey)
    Flowable<Response<Segment>> update(
        @Path("trasid") Integer trasid, @Body Segment bean, @Query("mask") String mask);

    @DELETE(path + pathKey)
    Flowable<Response<Void>> delete(@Path("trasid") Integer trasid);

    @GET(path)
    Flowable<Response<List<Segment>>> query(
        @Query("filter") String filter,
        @Query("orderBy") String orderBy,
        @Header("Range") String range,
        @Query("mask") String mask);

    @GET(path)
    Flowable<Response<Void>> count(
        @Query("filter") String filter, @Header("Range") String range, @Query("mask") String mask);

    @GET(attachPath + pathKey)
    Flowable<Response<ResponseBody>> downloadAttach(
        @Path("trasid") Integer trasid,
        @Query("name") String name,
        @Header("Accept") String accept);

    @PUT(attachPath + pathKey)
    Flowable<Response<Void>> uploadAttach(
        @Path("trasid") Integer trasid, @Query("name") String name, @Body RequestBody body);

    @DELETE(attachPath + pathKey)
    Flowable<Response<Void>> deleteAttach(
        @Path("trasid") Integer trasid, @Query("name") String name);

    @GET(attachPath + pathKey)
    Flowable<Response<List<String>>> listAttaches(@Path("trasid") Integer trasid);
  }
}
