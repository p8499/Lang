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
import com.p8499.lang.gen.bean.Dictionary;
import com.p8499.lang.gen.mask.DictionaryMask;

public class DictionaryStub {
  public static final String path = "api/dictionary/";
  public static final String attachPath = "api/dictionary_attachment/";
  public static final String pathKey = "{dcid}";

  private static DictionaryStub service;

  public static DictionaryStub getInstance(Context context) {
    if (service == null) {
      service = new DictionaryStub(context);
    }
    return service;
  }

  private Api api;

  public DictionaryStub(Context context) {
    api = RetrofitFactory.getInstance(context).create(Api.class);
  }

  public Flowable<Response<Dictionary>> get(Integer dcid) {
    return get(dcid, null);
  }

  public Flowable<Response<Dictionary>> get(Integer dcid, DictionaryMask mask) {
    Flowable<Response<Dictionary>> flowable = null;
    try {
      flowable =
          api.get(
                  dcid,
                  mask == null ? null : RetrofitFactory.getObjectMapper().writeValueAsString(mask))
              .subscribeOn(Schedulers.io());
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return flowable;
  }

  public Flowable<Response<Dictionary>> add(Dictionary bean) {
    Flowable<Response<Dictionary>> flowable = api.add(bean).subscribeOn(Schedulers.io());
    return flowable;
  }

  public Flowable<Response<Dictionary>> update(Dictionary bean) {
    return update(bean, null);
  }

  public Flowable<Response<Dictionary>> update(Dictionary bean, DictionaryMask mask) {
    Flowable<Response<Dictionary>> flowable = null;
    try {
      flowable =
          api.update(
                  bean.getDcid(),
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
                      .writeValueAsString(new DictionaryMask().setDcid(true)))
              .subscribeOn(Schedulers.io());
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return flowable;
  }

  public Flowable<Response<List<Dictionary>>> query(FilterLogicExpr filter, RangeExpr range) {
    return query(filter, null, range, null);
  }

  public Flowable<Response<List<Dictionary>>> query(
      FilterLogicExpr filter, OrderByListExpr orderBy, RangeExpr range) {
    return query(filter, orderBy, range, null);
  }

  public Flowable<Response<List<Dictionary>>> query(
      FilterLogicExpr filter, RangeExpr range, DictionaryMask mask) {
    return query(filter, null, range, mask);
  }

  public Flowable<Response<List<Dictionary>>> query(
      FilterLogicExpr filter, OrderByListExpr orderBy, RangeExpr range, DictionaryMask mask) {
    Flowable<Response<List<Dictionary>>> flowable = null;
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

  public Flowable<Response<Void>> delete(Integer dcid) {
    return api.delete(dcid).subscribeOn(Schedulers.io());
  }

  public Flowable<Response<ResponseBody>> downloadAttach(Integer dcid, String name) {
    Flowable<Response<ResponseBody>> flowable =
        api.downloadAttach(dcid, name, "application/octet-stream").subscribeOn(Schedulers.io());
    return flowable;
  }

  public Flowable<Response<Void>> uploadAttach(Integer dcid, String name, byte[] bytes) {
    RequestBody body = RequestBody.create(MediaType.parse("multipart/form-data"), bytes);
    Flowable<Response<Void>> flowable =
        api.uploadAttach(dcid, name, body).subscribeOn(Schedulers.io());
    return flowable;
  }

  public Flowable<Response<Void>> deleteAttach(Integer dcid, String name) {
    Flowable<Response<Void>> flowable = api.deleteAttach(dcid, name).subscribeOn(Schedulers.io());
    return flowable;
  }

  public Flowable<Response<List<String>>> listAttaches(Integer dcid) {
    Flowable<Response<List<String>>> flowable = api.listAttaches(dcid).subscribeOn(Schedulers.io());
    return flowable;
  }

  public interface Api {
    @GET(path + pathKey)
    Flowable<Response<Dictionary>> get(@Path("dcid") Integer dcid, @Query("mask") String mask);

    @POST(path)
    Flowable<Response<Dictionary>> add(@Body Dictionary bean);

    @PUT(path + pathKey)
    Flowable<Response<Dictionary>> update(
        @Path("dcid") Integer dcid, @Body Dictionary bean, @Query("mask") String mask);

    @DELETE(path + pathKey)
    Flowable<Response<Void>> delete(@Path("dcid") Integer dcid);

    @GET(path)
    Flowable<Response<List<Dictionary>>> query(
        @Query("filter") String filter,
        @Query("orderBy") String orderBy,
        @Header("Range") String range,
        @Query("mask") String mask);

    @GET(path)
    Flowable<Response<Void>> count(
        @Query("filter") String filter, @Header("Range") String range, @Query("mask") String mask);

    @GET(attachPath + pathKey)
    Flowable<Response<ResponseBody>> downloadAttach(
        @Path("dcid") Integer dcid, @Query("name") String name, @Header("Accept") String accept);

    @PUT(attachPath + pathKey)
    Flowable<Response<Void>> uploadAttach(
        @Path("dcid") Integer dcid, @Query("name") String name, @Body RequestBody body);

    @DELETE(attachPath + pathKey)
    Flowable<Response<Void>> deleteAttach(@Path("dcid") Integer dcid, @Query("name") String name);

    @GET(attachPath + pathKey)
    Flowable<Response<List<String>>> listAttaches(@Path("dcid") Integer dcid);
  }
}
