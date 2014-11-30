package com.example.david.lightandroidproject.data.controller;

import com.example.david.lightandroidproject.data.api.DemoAPI;
import com.example.david.lightandroidproject.data.model.Musician;
import com.example.david.lightandroidproject.data.model.SearchRequest;
import com.lightandroid.data.LightController;
import com.lightandroid.event.LightDataMultipleResponseCallback;
import com.lightandroid.event.LightDataResponseCallback;
import com.lightandroid.util.LightAPIUtil;

/**
 * Created by David on 16.11.2014..
 * <p/>
 * This class is a standard example of best practice LightAndroid network part usage
 * Here we have declared all the required callbacks and all the methods we should call to send/fetch certain data
 * If we wish, for instance, to get an array of musicians in our activity, we simply instantiate this controller, implement OnDataMultipleResponseListener and assign it to this controller
 * If the request was successful, then the onDataRead() method will be called
 */
public class MusicianController extends LightController {

    private LightDataMultipleResponseCallback<Musician[]> musiciansResponseCallback;
    private LightDataResponseCallback<Musician> musicianResponseCallback;

    /**
     * On instantiation of MusicianController class, I've immediately instantiated both callbacks, so I wouldn't need to do it later
     */
    public MusicianController() {
        musiciansResponseCallback = new LightDataMultipleResponseCallback<Musician[]>();
        musicianResponseCallback = new LightDataResponseCallback<Musician>();
    }

    /**
     * Send GET request to API to get array of musicians
     */
    public void loadMusicians() {
        // To call onDataMultipleResponse() method after the result has completed successfully
        musiciansResponseCallback.setOnDataMultipleResponseListener(getOnDataMultipleResponseListener());
        // To call onError() method in case the result hasn't completed successfully
        musiciansResponseCallback.setOnErrorListener(getOnErrorListener());
        // This is the standard procedure. First we create API (in our case DemoAPI) and we call the method we need (in this case it is getMusicians)
        LightAPIUtil.getRestAdapter(DemoAPI.API_LOCATION).create(DemoAPI.class).getMusicians(musiciansResponseCallback);
    }

    /**
     * Send POST request to API to get a musician whose name contains query string
     *
     * @param query The string that the musician name should contain
     */
    public void searchMusician(String query) {
        // This time we had to create request with query parameter
        SearchRequest request = new SearchRequest(query);
        // To call onDataResponse() method after the result has completed successfully
        musicianResponseCallback.setOnDataResponseListener(getOnDataResponseListener());
        // To call onError() method in case the result hasn't completed successfully
        musicianResponseCallback.setOnErrorListener(getOnErrorListener());
        // This is the standard procedure. First we create API (in our case DemoAPI) and we call the method we need (in this case it is searchMusician)
        LightAPIUtil.getRestAdapter(DemoAPI.API_LOCATION).create(DemoAPI.class).searchMusician(request, musicianResponseCallback);
    }

}
