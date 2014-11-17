package com.example.david.lightandroidproject.data.api;

import com.example.david.lightandroidproject.data.model.Musician;
import com.example.david.lightandroidproject.data.model.SearchRequest;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by David on 17.9.2014..
 */
public interface DemoAPI {

    public static final String API_LOCATION = "http://light-android.appspot.com";

    @GET("/api/get_test.jsp")
    public void getMusicians(Callback<Musician[]> response);

    @POST("/api/post_test.jsp")
    public void searchMusician(@Body SearchRequest request, Callback<Musician> response);

}
