package com.example.fulviocosco.sunshine.app;

import java.util.List;

/**
 * Created by fulviocosco on 29/10/2016.
 */

public class Movie {

    private boolean adult;
    private String backdrop_path;
    private int budget;
    private List<?> genres;
    private String homepage;
    private int id;
    private String imbd_id;
    private String original_language;
    private String original_title;
    private String overview;
    private float popularity;
    private String poster_path;
    private List<?> production_countries;
    private List<?> production_companies;
    private String release_date;
    private int revenue;
    private int runtime;
    private List<?> spoken_languages;
    private String status;
    private String tagline;
    private String title;
    private boolean video;
    private float vote_average;

    Movie( boolean adult,
           String backdrop_path,
           int budget,
           List<?> genres,
           String homepage,
           int id,
           String imbd_id,
           String original_language,
           String original_title,
           String overview,
           float popularity,
           String poster_path,
           List<?> production_countries,
           List<?> production_companies,
           String release_date,
           int revenue,
           int runtime,
           List<?> spoken_languages,
           String status,
           String tagline,
           String title,
           boolean video,
           float vote_average
    ){

         this.adult = adult;
         this.backdrop_path = backdrop_path;
         this.budget = budget;
         this.genres = genres;
         this.homepage = homepage;
         this.id = id;
         this.imbd_id = imbd_id;
         this.original_language = original_language;
         this.original_title = original_title;
         this.overview = overview;
         this.popularity = popularity;
         this.poster_path = poster_path;
         this.production_countries = production_countries;
         this.production_companies = production_companies;
         this.release_date = release_date;
         this.revenue = revenue;
         this.runtime = runtime;
         this.spoken_languages = spoken_languages;
         this.status = status;
         this.tagline = tagline;
         this.title = title;
         this.video = video;
         this.vote_average = vote_average;

    }

    public boolean isAdult() {
        return adult;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public int getBudget() {
        return budget;
    }

    public List<?> getGenres() {
        return genres;
    }

    public String getHomepage() {
        return homepage;
    }

    public int getId() {
        return id;
    }

    public String getImbd_id() {
        return imbd_id;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public String getOverview() {
        return overview;
    }

    public float getPopularity() {
        return popularity;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public List<?> getProduction_countries() {
        return production_countries;
    }

    public List<?> getProduction_companies() {
        return production_companies;
    }

    public String getRelease_date() {
        return release_date;
    }

    public int getRevenue() {
        return revenue;
    }

    public int getRuntime() {
        return runtime;
    }

    public List<?> getSpoken_languages() {
        return spoken_languages;
    }

    public String getStatus() {
        return status;
    }

    public String getTagline() {
        return tagline;
    }

    public String getTitle() {
        return title;
    }

    public boolean isVideo() {
        return video;
    }

    public float getVote_average() {
        return vote_average;
    }

    public int getVote_count() {
        return vote_count;
    }

    private int vote_count;

}


