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
import com.p8499.lang.gen.bean.Segmentvote;
import com.p8499.lang.gen.mask.SegmentvoteMask;

public class SegmentvoteStub {
  public static final String path = "api/segmentvote/";
  public static final String attachPath = "api/segmentvote_attachment/";
  public static final String pathKey = "{tvid}";

  private static SegmentvoteStub service;

  public static SegmentvoteStub getInstance(Context context) {
    if (service == null) {
      service = new SegmentvoteStub(context);
    }
    return service;
  }

  private Api api;

  public SegmentvoteStub(Context context) {
    api = RetrofitFactory.getInstance(context).create(Api.class);
  }

  public Flowable<Response<Segmentvote>> get(Integer tvid) {
    return get(tvid, null);
  }

  public Flowable<Response<Segmentvote>> get(Integer tvid, SegmentvoteMask mask) {
    Flowable<Response<Segmentvote>> flowable = null;
    try {
      flowable =
          api.get(
                  tvid,
                  mask == null ? null : RetrofitFactory.getObjectMapper().writeValueAsString(mask))
              .subscribeOn(Schedulers.io());
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return flowable;
  }

  public Flowable<Response<Segmentvote>> add(Segmentvote bean) {
    Flowable<Response<Segmentvote>> flowable = api.add(bean).subscribeOn(Schedulers.io());
    return flowable;
  }

  public Flowable<Response<Segmentvote>> update(Segmentvote bean) {
    return update(bean, null);
  }

  public Flowable<Response<Segmentvote>> update(Segmentvote bean, SegmentvoteMask mask) {
    Flowable<Response<Segmentvote>> flowable = null;
    try {
      flowable =
          api.update(
                  bean.getTvid(),
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
                      .writeValueAsString(new SegmentvoteMask().setTvid(true)))
              .subscribeOn(Schedulers.io());
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return flowable;
  }

  public Flowable<Response<List<Segmentvote>>> query(FilterLogicExpr filter, RangeExpr range) {
    return query(filter, null, range, null);
  }

  public Flowable<Response<List<Segmentvote>>> query(
      FilterLogicExpr filter, OrderByListExpr orderBy, RangeExpr range) {
    return query(filter, orderBy, range, null);
  }

  public Flowable<Response<List<Segmentvote>>> query(
      FilterLogicExpr filter, RangeExpr range, SegmentvoteMask mask) {
    return query(filter, null, range, mask);
  }

  public Flowable<Response<List<Segmentvote>>> query(
      FilterLogicExpr filter, OrderByListExpr orderBy, RangeExpr range, SegmentvoteMask mask) {
    Flowable<Response<List<Segmentvote>>> flowable = null;
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

  public Flowable<Response<Void>> delete(Integer tvid) {
    return api.delete(tvid).subscribeOn(Schedulers.io());
  }

  public Flowable<Response<ResponseBody>> downloadAttach(Integer tvid, String name) {
    Flowable<Response<ResponseBody>> flowable =
        api.downloadAttach(tvid, name, "application/octet-stream").subscribeOn(Schedulers.io());
    return flowable;
  }

  public Flowable<Response<Void>> uploadAttach(Integer tvid, String name, byte[] bytes) {
    RequestBody body = RequestBody.create(MediaType.parse("multipart/form-data"), bytes);
    Flowable<Response<Void>> flowable =
        api.uploadAttach(tvid, name, body).subscribeOn(Schedulers.io());
    return flowable;
  }

  public Flowable<Response<Void>> deleteAttach(Integer tvid, String name) {
    Flowable<Response<Void>> flowable = api.deleteAttach(tvid, name).subscribeOn(Schedulers.io());
    return flowable;
  }

  public Flowable<Response<List<String>>> listAttaches(Integer tvid) {
    Flowable<Response<List<String>>> flowable = api.listAttaches(tvid).subscribeOn(Schedulers.io());
    return flowable;
  }

  public interface Api {
    @GET(path + pathKey)
    Flowable<Response<Segmentvote>> get(@Path("tvid") Integer tvid, @Query("mask") String mask);

    @POST(path)
    Flowable<Response<Segmentvote>> add(@Body Segmentvote bean);

    @PUT(path + pathKey)
    Flowable<Response<Segmentvote>> update(
        @Path("tvid") Integer tvid, @Body Segmentvote bean, @Query("mask") String mask);

    @DELETE(path + pathKey)
    Flowable<Response<Void>> delete(@Path("tvid") Integer tvid);

    @GET(path)
    Flowable<Response<List<Segmentvote>>> query(
        @Query("filter") String filter,
        @Query("orderBy") String orderBy,
        @Header("Range") String range,
        @Query("mask") String mask);

    @GET(path)
    Flowable<Response<Void>> count(
        @Query("filter") String filter, @Header("Range") String range, @Query("mask") String mask);

    @GET(attachPath + pathKey)
    Flowable<Response<ResponseBody>> downloadAttach(
        @Path("tvid") Integer tvid, @Query("name") String name, @Header("Accept") String accept);

    @PUT(attachPath + pathKey)
    Flowable<Response<Void>> uploadAttach(
        @Path("tvid") Integer tvid, @Query("name") String name, @Body RequestBody body);

    @DELETE(attachPath + pathKey)
    Flowable<Response<Void>> deleteAttach(@Path("tvid") Integer tvid, @Query("name") String name);

    @GET(attachPath + pathKey)
    Flowable<Response<List<String>>> listAttaches(@Path("tvid") Integer tvid);
  }
}
