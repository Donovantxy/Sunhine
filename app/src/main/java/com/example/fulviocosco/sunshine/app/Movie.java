package com.example.fulviocosco.sunshine.app;

import android.support.annotation.Nullable;

import java.util.List;

//([\w\d]+)\s+(string|integer|number|boolean|array\[.+\])
public class Movie {

    private boolean adult;
    private String      s_backdrop_path;
    private Nullable    n_backdrop_path;
    private Nullable    belongs_to_collection;
    private int         budget;
    private List<Genre> genres;
    private String      homepage;
    private int         id;
    private String      imbd_id;
    private String      original_language;
    private String      original_title;
    private String      overview;
    private Float       popularity;
    private String      poster_path;
    private List<ProductionCompany> production_companies;
    private List<ProductionCountry> production_countries;
    private String      release_date;
    private int         revenue;
    private int         runtime;
    private List<SpokenLanguage> spoken_languages;
    private String      status;
    private String      tagline;
    private String      title;
    private boolean     video;
    private Float       vote_average;
    private int         vote_count;

    public boolean isAdult() {
        return adult;
    }

    public String getS_backdrop_path() {
        return s_backdrop_path;
    }

    public Nullable getN_backdrop_path() {
        return n_backdrop_path;
    }

    public Nullable getBelongs_to_collection() {
        return belongs_to_collection;
    }

    public int getBudget() {
        return budget;
    }

    public List<Genre> getGenres() {
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

    public Float getPopularity() {
        return popularity;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public List<ProductionCompany> getProduction_companies() {
        return production_companies;
    }

    public List<ProductionCountry> getProduction_countries() {
        return production_countries;
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

    public List<SpokenLanguage> getSpoken_languages() {
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

    public Float getVote_average() {
        return vote_average;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setAdult(boolean adult) {

        this.adult = adult;
    }

    public void setS_backdrop_path(String s_backdrop_path) {
        this.s_backdrop_path = s_backdrop_path;
    }

    public void setN_backdrop_path(Nullable n_backdrop_path) {
        this.n_backdrop_path = n_backdrop_path;
    }

    public void setBelongs_to_collection(Nullable belongs_to_collection) {
        this.belongs_to_collection = belongs_to_collection;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImbd_id(String imbd_id) {
        this.imbd_id = imbd_id;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public void setPopularity(Float popularity) {
        this.popularity = popularity;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public void setProduction_companies(List<ProductionCompany> production_companies) {
        this.production_companies = production_companies;
    }

    public void setProduction_countries(List<ProductionCountry> production_countries) {
        this.production_countries = production_countries;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public void setSpoken_languages(List<SpokenLanguage> spoken_languages) {
        this.spoken_languages = spoken_languages;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public void setVote_average(Float vote_average) {
        this.vote_average = vote_average;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }


}
