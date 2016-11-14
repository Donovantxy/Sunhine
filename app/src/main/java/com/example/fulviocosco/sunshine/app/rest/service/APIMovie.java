package com.example.fulviocosco.sunshine.app.rest.service;

import com.example.fulviocosco.sunshine.app.rest.model.MovieResults;
import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by fulviocosco on 29/10/2016.
 */

public interface ApiMovie {

//    @GET("movie/{movie_id}")
//    Movie getMovie(@Query("api_key") String api_key, @Path("movie_id") int id);

//    @GET("/movie/popular")
//    MovieResults getPopularSync(@Query("api_key") String api_key);
//
//    @GET("/movie/top_rated")
//    MovieResults getTopRatedSync(@Query("api_key") String api_key);

//      @GET("movie/popular")
//      Call<MovieResults> getPopular();

//    @GET("/movie/top_rated")
//    Call<MovieResults> getTopRated(@Query("api_key") String api_key);

    @GET("movie/popular")
    Observable<MovieResults> getPopular();

    @GET("movie/top_rated")
    Observable<MovieResults> getTopRated();

    //for each POST/PUT/DELETE just put before annotations -> @FormUrlEncoded

}
