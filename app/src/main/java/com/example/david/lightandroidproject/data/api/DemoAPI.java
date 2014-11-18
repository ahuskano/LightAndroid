package com.example.david.lightandroidproject.data.api;

import com.example.david.lightandroidproject.data.model.Musician;
import com.example.david.lightandroidproject.data.model.SearchRequest;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;

/**
 * Created by David on 17.9.2014..
 * <p/>
 * This class represents an interface towards the LightAndroid API at http://light-android.appspot.com/api
 */
public interface DemoAPI {

    /**
     * A constant containing url of the API
     */
    public static final String API_LOCATION = "http://light-android.appspot.com/api";

    /**
     * Sends GET request to the get_test.jsp in API and requests the response callback to be called on result
     *
     * @param response Callback that is called after the server sends response
     */
    @GET("/get_test.jsp")
    public void getMusicians(Callback<Musician[]> response);

    /**
     * Sends POST request to the post_test.jsp in API, providing body request and requesting the response callback to be called on result
     *
     * @param request  Object that represents JSON in the POST request parameters
     * @param response Callback that is called after the server sends response
     */
    @POST("/post_test.jsp")
    public void searchMusician(@Body SearchRequest request, Callback<Musician> response);

    /**
     * Sends POST request to the post_test.jsp in API, providing query and requesting the response callback to be called on result
     *
     * @param request  String parameter in POST
     * @param response Callback that is called after the server sends response
     */
    @POST("/post_test.jsp")
    public void searchMusician(@Query("query") String request, Callback<Musician> response);

}
