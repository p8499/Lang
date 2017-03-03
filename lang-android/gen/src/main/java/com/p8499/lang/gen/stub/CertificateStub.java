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
import com.p8499.lang.gen.bean.Certificate;
import com.p8499.lang.gen.mask.CertificateMask;

public class CertificateStub {
  public static final String path = "api/certificate/";
  public static final String attachPath = "api/certificate_attachment/";
  public static final String pathKey = "{crid}";

  private static CertificateStub service;

  public static CertificateStub getInstance(Context context) {
    if (service == null) {
      service = new CertificateStub(context);
    }
    return service;
  }

  private Api api;

  public CertificateStub(Context context) {
    api = RetrofitFactory.getInstance(context).create(Api.class);
  }

  public Flowable<Response<Certificate>> get(Integer crid) {
    return get(crid, null);
  }

  public Flowable<Response<Certificate>> get(Integer crid, CertificateMask mask) {
    Flowable<Response<Certificate>> flowable = null;
    try {
      flowable =
          api.get(
                  crid,
                  mask == null ? null : RetrofitFactory.getObjectMapper().writeValueAsString(mask))
              .subscribeOn(Schedulers.io());
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return flowable;
  }

  public Flowable<Response<Certificate>> add(Certificate bean) {
    Flowable<Response<Certificate>> flowable = api.add(bean).subscribeOn(Schedulers.io());
    return flowable;
  }

  public Flowable<Response<Certificate>> update(Certificate bean) {
    return update(bean, null);
  }

  public Flowable<Response<Certificate>> update(Certificate bean, CertificateMask mask) {
    Flowable<Response<Certificate>> flowable = null;
    try {
      flowable =
          api.update(
                  bean.getCrid(),
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
                      .writeValueAsString(new CertificateMask().setCrid(true)))
              .subscribeOn(Schedulers.io());
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return flowable;
  }

  public Flowable<Response<List<Certificate>>> query(FilterLogicExpr filter, RangeExpr range) {
    return query(filter, null, range, null);
  }

  public Flowable<Response<List<Certificate>>> query(
      FilterLogicExpr filter, OrderByListExpr orderBy, RangeExpr range) {
    return query(filter, orderBy, range, null);
  }

  public Flowable<Response<List<Certificate>>> query(
      FilterLogicExpr filter, RangeExpr range, CertificateMask mask) {
    return query(filter, null, range, mask);
  }

  public Flowable<Response<List<Certificate>>> query(
      FilterLogicExpr filter, OrderByListExpr orderBy, RangeExpr range, CertificateMask mask) {
    Flowable<Response<List<Certificate>>> flowable = null;
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

  public Flowable<Response<Void>> delete(Integer crid) {
    return api.delete(crid).subscribeOn(Schedulers.io());
  }

  public Flowable<Response<ResponseBody>> downloadAttach(Integer crid, String name) {
    Flowable<Response<ResponseBody>> flowable =
        api.downloadAttach(crid, name, "application/octet-stream").subscribeOn(Schedulers.io());
    return flowable;
  }

  public Flowable<Response<Void>> uploadAttach(Integer crid, String name, byte[] bytes) {
    RequestBody body = RequestBody.create(MediaType.parse("multipart/form-data"), bytes);
    Flowable<Response<Void>> flowable =
        api.uploadAttach(crid, name, body).subscribeOn(Schedulers.io());
    return flowable;
  }

  public Flowable<Response<Void>> deleteAttach(Integer crid, String name) {
    Flowable<Response<Void>> flowable = api.deleteAttach(crid, name).subscribeOn(Schedulers.io());
    return flowable;
  }

  public Flowable<Response<List<String>>> listAttaches(Integer crid) {
    Flowable<Response<List<String>>> flowable = api.listAttaches(crid).subscribeOn(Schedulers.io());
    return flowable;
  }

  public interface Api {
    @GET(path + pathKey)
    Flowable<Response<Certificate>> get(@Path("crid") Integer crid, @Query("mask") String mask);

    @POST(path)
    Flowable<Response<Certificate>> add(@Body Certificate bean);

    @PUT(path + pathKey)
    Flowable<Response<Certificate>> update(
        @Path("crid") Integer crid, @Body Certificate bean, @Query("mask") String mask);

    @DELETE(path + pathKey)
    Flowable<Response<Void>> delete(@Path("crid") Integer crid);

    @GET(path)
    Flowable<Response<List<Certificate>>> query(
        @Query("filter") String filter,
        @Query("orderBy") String orderBy,
        @Header("Range") String range,
        @Query("mask") String mask);

    @GET(path)
    Flowable<Response<Void>> count(
        @Query("filter") String filter, @Header("Range") String range, @Query("mask") String mask);

    @GET(attachPath + pathKey)
    Flowable<Response<ResponseBody>> downloadAttach(
        @Path("crid") Integer crid, @Query("name") String name, @Header("Accept") String accept);

    @PUT(attachPath + pathKey)
    Flowable<Response<Void>> uploadAttach(
        @Path("crid") Integer crid, @Query("name") String name, @Body RequestBody body);

    @DELETE(attachPath + pathKey)
    Flowable<Response<Void>> deleteAttach(@Path("crid") Integer crid, @Query("name") String name);

    @GET(attachPath + pathKey)
    Flowable<Response<List<String>>> listAttaches(@Path("crid") Integer crid);
  }
}
