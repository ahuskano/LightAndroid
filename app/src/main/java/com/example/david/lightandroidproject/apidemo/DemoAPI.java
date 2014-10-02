package com.example.david.lightandroidproject.apidemo;

import com.dmacan.lightandroid.api.LightRequest;
import com.example.david.lightandroidproject.datademo.User;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.POST;

/**
 * Created by David on 17.9.2014..
 */
public interface DemoAPI {

    public static final String API_LOCATION = "http://ars-pingo.com/oakmind/src/api";

    @POST("/demo_user.php")
    public void readUser(@Body LightRequest request, Callback<User> callback);

}
