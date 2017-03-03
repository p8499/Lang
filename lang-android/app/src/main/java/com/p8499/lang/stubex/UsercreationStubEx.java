package com.p8499.lang.stubex;

import android.content.Context;

import com.p8499.lang.gen.RetrofitFactory;
import com.p8499.lang.gen.stub.UserStub;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2/27/2017.
 */

public class UsercreationStubEx {
    private static UsercreationStubEx service;
    private Api api;

    public UsercreationStubEx(Context context) {
        api = RetrofitFactory.getInstance(context).create(Api.class);
    }

    public static UsercreationStubEx getInstance(Context context) {
        if (service == null) {
            service = new UsercreationStubEx(context);
        }
        return service;
    }

    public Flowable<Response<Void>> checkUcpv(Integer ucid, String ucpv) {
        return api.checkUcpv(ucid, ucpv).subscribeOn(Schedulers.io());
    }

    public Flowable<Response<Void>> checkUcmv(Integer ucid, String ucmv) {
        return api.checkUcmv(ucid, ucmv).subscribeOn(Schedulers.io());
    }

    public interface Api {
        @GET(UserStub.path + "check_ucpv/")
        Flowable<Response<Void>> checkUcpv(@Query("ucid") Integer ucid, @Query("ucpv") String ucpv);

        @GET(UserStub.path + "check_ucmv/")
        Flowable<Response<Void>> checkUcmv(@Query("ucid") Integer ucid, @Query("ucmv") String ucmv);
    }
}
