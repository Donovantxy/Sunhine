package com.example.fulviocosco.sunshine.app;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by fulviocosco on 02/11/2016.
 */

public class ApiClient {

    private static final String BASE_URL = "https://api.themoviedb.org/3/";
    public static final String KEY_API = "c4637c00d2d0a9d2d183af069b0c7c21";

    private static Retrofit client = null;

    public static Retrofit getClient() {
        if( client == null ) {
            client = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return client;
    }

}
