package com.dmacan.lightandroid.data;

import com.dmacan.lightandroid.api.LightResponse;
import com.dmacan.lightandroid.api.listener.OnDataCreateListener;
import com.dmacan.lightandroid.api.listener.OnDataReadListener;
import com.dmacan.lightandroid.api.listener.OnDataUpdateListener;
import com.dmacan.lightandroid.api.listener.OnErrorListener;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


/**
 * Created by David on 17.9.2014..
 */
public class LightController {

    private OnDataCreateListener onDataCreateListener;
    private OnDataReadListener onDataReadListener;
    private OnDataUpdateListener onDataUpdateListener;
    private OnErrorListener onErrorListener;
    private Callback<LightResponse> lightResponseCallback = new Callback<LightResponse>() {
        @Override
        public void success(LightResponse response, Response response2) {
            if (onDataCreateListener != null)
                onDataCreateListener.onDataCreate(response);
            if (onDataUpdateListener != null)
                onDataUpdateListener.onDataUpdate(response);
        }

        @Override
        public void failure(RetrofitError error) {
            if (onErrorListener != null)
                onErrorListener.onError(error);
        }
    };

    public OnDataCreateListener getOnDataCreateListener() {
        return onDataCreateListener;
    }

    public void setOnDataCreateListener(OnDataCreateListener onDataCreateListener) {
        this.onDataCreateListener = onDataCreateListener;
    }

    public OnDataReadListener getOnDataReadListener() {
        return onDataReadListener;
    }

    public void setOnDataReadListener(OnDataReadListener onDataReadListener) {
        this.onDataReadListener = onDataReadListener;
    }

    public OnDataUpdateListener getOnDataUpdateListener() {
        return onDataUpdateListener;
    }

    public void setOnDataUpdateListener(OnDataUpdateListener onDataUpdateListener) {
        this.onDataUpdateListener = onDataUpdateListener;
    }

    public OnErrorListener getOnErrorListener() {
        return onErrorListener;
    }

    public void setOnErrorListener(OnErrorListener onErrorListener) {
        this.onErrorListener = onErrorListener;
    }

    public Callback<LightResponse> getLightResponseCallback() {
        return lightResponseCallback;
    }

    public void setLightResponseCallback(Callback<LightResponse> lightResponseCallback) {
        this.lightResponseCallback = lightResponseCallback;
    }
}
