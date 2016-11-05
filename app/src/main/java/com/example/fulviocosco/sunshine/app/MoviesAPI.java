package com.example.fulviocosco.sunshine.app;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by fulviocosco on 29/10/2016.
 */

public interface MoviesAPI {

    @GET("movie/{movie_id}")
    Call<Movie> getMovie(@Query("api_key") String api_key, @Path("movie_id") int id);

    @GET("movie/popular")
    Call<MovieResults> getPopular(@Query("api_key") String api_key);

    @GET("movie/top_rated")
    Call<MovieResults> getTopRated(@Query("api_key") String api_key);

}
