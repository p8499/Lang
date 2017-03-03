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
import com.p8499.lang.gen.bean.Language;
import com.p8499.lang.gen.mask.LanguageMask;

public class LanguageStub {
  public static final String path = "api/language/";
  public static final String attachPath = "api/language_attachment/";
  public static final String pathKey = "{lsid}";

  private static LanguageStub service;

  public static LanguageStub getInstance(Context context) {
    if (service == null) {
      service = new LanguageStub(context);
    }
    return service;
  }

  private Api api;

  public LanguageStub(Context context) {
    api = RetrofitFactory.getInstance(context).create(Api.class);
  }

  public Flowable<Response<Language>> get(String lsid) {
    return get(lsid, null);
  }

  public Flowable<Response<Language>> get(String lsid, LanguageMask mask) {
    Flowable<Response<Language>> flowable = null;
    try {
      flowable =
          api.get(
                  lsid,
                  mask == null ? null : RetrofitFactory.getObjectMapper().writeValueAsString(mask))
              .subscribeOn(Schedulers.io());
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return flowable;
  }

  public Flowable<Response<Language>> add(Language bean) {
    Flowable<Response<Language>> flowable =
        api.add(bean.getLsid(), bean).subscribeOn(Schedulers.io());
    return flowable;
  }

  public Flowable<Response<Language>> update(Language bean) {
    return update(bean, null);
  }

  public Flowable<Response<Language>> update(Language bean, LanguageMask mask) {
    Flowable<Response<Language>> flowable = null;
    try {
      flowable =
          api.update(
                  bean.getLsid(),
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
                      .writeValueAsString(new LanguageMask().setLsid(true)))
              .subscribeOn(Schedulers.io());
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return flowable;
  }

  public Flowable<Response<List<Language>>> query(FilterLogicExpr filter, RangeExpr range) {
    return query(filter, null, range, null);
  }

  public Flowable<Response<List<Language>>> query(
      FilterLogicExpr filter, OrderByListExpr orderBy, RangeExpr range) {
    return query(filter, orderBy, range, null);
  }

  public Flowable<Response<List<Language>>> query(
      FilterLogicExpr filter, RangeExpr range, LanguageMask mask) {
    return query(filter, null, range, mask);
  }

  public Flowable<Response<List<Language>>> query(
      FilterLogicExpr filter, OrderByListExpr orderBy, RangeExpr range, LanguageMask mask) {
    Flowable<Response<List<Language>>> flowable = null;
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

  public Flowable<Response<Void>> delete(String lsid) {
    return api.delete(lsid).subscribeOn(Schedulers.io());
  }

  public Flowable<Response<ResponseBody>> downloadAttach(String lsid, String name) {
    Flowable<Response<ResponseBody>> flowable =
        api.downloadAttach(lsid, name, "application/octet-stream").subscribeOn(Schedulers.io());
    return flowable;
  }

  public Flowable<Response<Void>> uploadAttach(String lsid, String name, byte[] bytes) {
    RequestBody body = RequestBody.create(MediaType.parse("multipart/form-data"), bytes);
    Flowable<Response<Void>> flowable =
        api.uploadAttach(lsid, name, body).subscribeOn(Schedulers.io());
    return flowable;
  }

  public Flowable<Response<Void>> deleteAttach(String lsid, String name) {
    Flowable<Response<Void>> flowable = api.deleteAttach(lsid, name).subscribeOn(Schedulers.io());
    return flowable;
  }

  public Flowable<Response<List<String>>> listAttaches(String lsid) {
    Flowable<Response<List<String>>> flowable = api.listAttaches(lsid).subscribeOn(Schedulers.io());
    return flowable;
  }

  public interface Api {
    @GET(path + pathKey)
    Flowable<Response<Language>> get(@Path("lsid") String lsid, @Query("mask") String mask);

    @POST(path + pathKey)
    Flowable<Response<Language>> add(@Path("lsid") String lsid, @Body Language bean);

    @PUT(path + pathKey)
    Flowable<Response<Language>> update(
        @Path("lsid") String lsid, @Body Language bean, @Query("mask") String mask);

    @DELETE(path + pathKey)
    Flowable<Response<Void>> delete(@Path("lsid") String lsid);

    @GET(path)
    Flowable<Response<List<Language>>> query(
        @Query("filter") String filter,
        @Query("orderBy") String orderBy,
        @Header("Range") String range,
        @Query("mask") String mask);

    @GET(path)
    Flowable<Response<Void>> count(
        @Query("filter") String filter, @Header("Range") String range, @Query("mask") String mask);

    @GET(attachPath + pathKey)
    Flowable<Response<ResponseBody>> downloadAttach(
        @Path("lsid") String lsid, @Query("name") String name, @Header("Accept") String accept);

    @PUT(attachPath + pathKey)
    Flowable<Response<Void>> uploadAttach(
        @Path("lsid") String lsid, @Query("name") String name, @Body RequestBody body);

    @DELETE(attachPath + pathKey)
    Flowable<Response<Void>> deleteAttach(@Path("lsid") String lsid, @Query("name") String name);

    @GET(attachPath + pathKey)
    Flowable<Response<List<String>>> listAttaches(@Path("lsid") String lsid);
  }
}
