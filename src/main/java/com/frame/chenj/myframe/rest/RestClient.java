package com.frame.chenj.myframe.rest;


import com.frame.chenj.myframe.BuildConfig;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

/**
 * Created by ${ChenJ} on 2016/9/18.
 */
public class RestClient {
    private HttpAPI mHttpApi;

    public static RestClient getINSTANCE() {
        if (INSTANCE == null) {
            synchronized (RestClient.class) {
                if (INSTANCE == null) {
                    INSTANCE = new RestClient();
                }
            }
        }
        return INSTANCE;
    }

    private volatile static RestClient INSTANCE;

    private RestClient() {
        OkHttpClient client = new com.squareup.okhttp.OkHttpClient();
        client.setConnectTimeout(20, TimeUnit.SECONDS);
        client.setReadTimeout(30, TimeUnit.SECONDS);
//        client.interceptors().add(new AddTokenInterceptor());
        GsonBuilder builder = new GsonBuilder().setDateFormat("yyyy/MM/dd HH:mm:ss");
        RestAdapter restAdapter = new RestAdapter.Builder().setLogLevel(BuildConfig.DEBUG ? RestAdapter.LogLevel.FULL : RestAdapter.LogLevel.NONE)
                .setEndpoint(getBaseUrl()).setConverter(new GsonConverter(builder.create()))
              //  .setRequestInterceptor(new AddTokenInterceptor())//添加token
                .setClient(new OkClient(client)).build();

        this.mHttpApi=restAdapter.create(HttpAPI.class);

    }

    public static String getBaseUrl() {
//        return BuildConfig.DEBUG ? Cons.DEBUG_URL : Cons.RELEASE_URL;
        return "";//http地址
    }

    public HttpAPI getmHttpApi(){
        return mHttpApi;
    }


}
