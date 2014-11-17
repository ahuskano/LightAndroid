package com.example.david.lightandroidproject.data.controller;

import com.dmacan.lightandroid.data.LightController;
import com.dmacan.lightandroid.event.LightDataMultipleResponseCallback;
import com.dmacan.lightandroid.event.LightDataResponseCallback;
import com.dmacan.lightandroid.util.LightAPIUtil;
import com.example.david.lightandroidproject.data.api.DemoAPI;
import com.example.david.lightandroidproject.data.model.Musician;
import com.example.david.lightandroidproject.data.model.SearchRequest;

/**
 * Created by David on 16.11.2014..
 */
public class MusicianController extends LightController {

    private LightDataMultipleResponseCallback<Musician[]> musiciansResponseCallback;
    private LightDataResponseCallback<Musician> musicianResponseCallback;

    public MusicianController() {
        musiciansResponseCallback = new LightDataMultipleResponseCallback<Musician[]>();
        musicianResponseCallback = new LightDataResponseCallback<Musician>();
    }

    public void loadMusicians() {
        musiciansResponseCallback.setOnDataMultipleResponseListener(getOnDataMultipleResponseListener());
        musiciansResponseCallback.setOnErrorListener(getOnErrorListener());
        LightAPIUtil.getRestAdapter(DemoAPI.API_LOCATION).create(DemoAPI.class).getMusicians(musiciansResponseCallback);
    }

    public void searchMusician(String query) {
        SearchRequest request = new SearchRequest(query);
        musicianResponseCallback.setOnDataResponseListener(getOnDataResponseListener());
        musicianResponseCallback.setOnErrorListener(getOnErrorListener());
        LightAPIUtil.getRestAdapter(DemoAPI.API_LOCATION).create(DemoAPI.class).searchMusician(request, musicianResponseCallback);
    }

}
