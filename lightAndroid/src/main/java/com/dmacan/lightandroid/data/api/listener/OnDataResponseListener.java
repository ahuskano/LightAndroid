package com.dmacan.lightandroid.data.api.listener;

import com.dmacan.lightandroid.type.LightData;

import retrofit.client.Response;

/**
 * Created by David on 16.11.2014..
 */
public interface OnDataResponseListener {

    public void onResponse(LightData response, Response retrofitResponse);

}
