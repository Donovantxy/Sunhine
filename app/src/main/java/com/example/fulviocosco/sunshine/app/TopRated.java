package com.example.fulviocosco.sunshine.app;

import java.util.List;

/**
 * Created by fulviocosco on 01/11/2016.
 */

public class TopRated {

    private int page;
    private List<Movie> results;
    private int total_result;
    private int total_pages;

    public List<Movie> getResults() {
        return results;
    }

    public int getTotal_result() {
        return total_result;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }

    public void setTotal_result(int total_result) {
        this.total_result = total_result;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }
}
