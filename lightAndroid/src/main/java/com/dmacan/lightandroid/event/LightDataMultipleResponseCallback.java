package com.dmacan.lightandroid.event;

import com.dmacan.lightandroid.data.api.listener.OnDataMultipleResponseListener;
import com.dmacan.lightandroid.data.api.listener.OnErrorListener;
import com.dmacan.lightandroid.type.LightData;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by David on 16.11.2014..
 */
public class LightDataMultipleResponseCallback implements Callback<LightData[]> {

    private OnDataMultipleResponseListener onDataMultipleResponseListener;
    private OnErrorListener onErrorListener;

    public LightDataMultipleResponseCallback(OnDataMultipleResponseListener onDataMultipleResponseListener) {
        this.onDataMultipleResponseListener = onDataMultipleResponseListener;
    }

    public LightDataMultipleResponseCallback(OnDataMultipleResponseListener onDataMultipleResponseListener, OnErrorListener onErrorListener) {
        this.onDataMultipleResponseListener = onDataMultipleResponseListener;
        this.onErrorListener = onErrorListener;
    }

    public OnDataMultipleResponseListener getOnDataMultipleResponseListener() {
        return onDataMultipleResponseListener;
    }

    public void setOnDataMultipleResponseListener(OnDataMultipleResponseListener onDataMultipleResponseListener) {
        this.onDataMultipleResponseListener = onDataMultipleResponseListener;
    }

    public OnErrorListener getOnErrorListener() {
        return onErrorListener;
    }

    public void setOnErrorListener(OnErrorListener onErrorListener) {
        this.onErrorListener = onErrorListener;
    }

    @Override
    public void success(LightData[] data, Response response) {
        if (onDataMultipleResponseListener != null)
            onDataMultipleResponseListener.onMultipleResponse(data, response);
    }

    @Override
    public void failure(RetrofitError error) {
        if (onErrorListener != null)
            onErrorListener.onError(error);
    }
}
