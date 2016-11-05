package com.example.fulviocosco.sunshine.app;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by fulvio on 29/10/2016.
 */

public class MoviePopular {
    @SerializedName("page")
    private int page;
    @SerializedName("results")
    private List<Movie> results;
    @SerializedName("total_results")
    private int total_results;
    @SerializedName("total_pages")
    private int total_pages;


    MoviePopular(int page, List<Movie> results, int total_results, int total_pages){
        this.page = page;
        this.results = results;
        this.total_results = total_results;
        this.total_pages = total_pages;
    }


    public int getPage() {
        return page;
    }

    public List<Movie> getResults() {
        return results;
    }

    public int getTotal_results() {
        return total_results;
    }

    public int getTotal_pages() {
        return total_pages;
    }



}
