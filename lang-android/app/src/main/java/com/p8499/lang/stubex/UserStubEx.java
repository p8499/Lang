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

public class UserStubEx {
    private static UserStubEx service;
    private Api api;

    public UserStubEx(Context context) {
        api = RetrofitFactory.getInstance(context).create(Api.class);
    }

    public static UserStubEx getInstance(Context context) {
        if (service == null) {
            service = new UserStubEx(context);
        }
        return service;
    }

    public Flowable<Response<Integer>> signin(String uscell, String uspswd) {
        return api.signin(uscell, uspswd).subscribeOn(Schedulers.io());
    }

    public Flowable<Response<Integer>> status() {
        return api.status().subscribeOn(Schedulers.io());
    }

    public Flowable<Response<Void>> signout() {
        return api.signout().subscribeOn(Schedulers.io());
    }

    public interface Api {
        @GET(UserStub.path + "signin/")
        Flowable<Response<Integer>> signin(@Query("uscell") String uscell, @Query("uspswd") String uspswd);

        @GET(UserStub.path + "status/")
        Flowable<Response<Integer>> status();

        @GET(UserStub.path + "signout/")
        Flowable<Response<Void>> signout();
    }
}
