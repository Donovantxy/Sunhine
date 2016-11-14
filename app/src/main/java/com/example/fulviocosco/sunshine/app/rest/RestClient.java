package com.example.fulviocosco.sunshine.app.rest;

import com.example.fulviocosco.sunshine.app.rest.service.ApiMovie;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by fulvio on 06/11/2016.
 */

public class RestClient {

    private static final String BASE_URL = "https://api.themoviedb.org/3/";
    public static final String KEY_API = "c4637c00d2d0a9d2d183af069b0c7c21";
    private static Retrofit client = null;

    public RestClient(){
        if( client == null ) {
            client = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(getHttpClient())
                    .build();
        }
    }

    public Retrofit getClient(){
        return client;
    }

    private static OkHttpClient getHttpClient(){
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request originalRequest = chain.request();
                        HttpUrl originalHttpUrl = originalRequest.url();

                        HttpUrl newHttpUrl = originalHttpUrl
                                .newBuilder()
                                .addQueryParameter("api_key", RestClient.KEY_API)
                                .build();

                        Request newRequest = originalRequest
                                .newBuilder()
                                .url(newHttpUrl)
                                .build();

                        return chain.proceed(newRequest);

                    }
        });

        return httpClientBuilder.build();
    }

    public ApiMovie getApiMovie(){
        return client.create(ApiMovie.class);
    }


}
