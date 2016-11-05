package com.example.fulviocosco.sunshine.app;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by fulviocosco on 29/10/2016.
 */

public interface MoviesAPI {

    //@GET("movie/{movie_id}")
    //Call<JSONObject> getMovie(@Path("movie_id") int id, @Query("api_key") String api_key);

    @GET("movie/popular")
    Call<MoviePopular> getPopular(@Query("api_key") String api_key);

}
