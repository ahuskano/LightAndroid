package com.example.david.lightandroidproject.data.model;

import com.dmacan.lightandroid.type.LightData;
import com.google.gson.annotations.Expose;

/**
 * Created by David on 16.11.2014..
 */
public class SearchRequest extends LightData {

    @Expose
    private String query;

    public SearchRequest(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
