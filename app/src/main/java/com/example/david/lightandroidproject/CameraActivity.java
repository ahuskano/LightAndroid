package com.example.david.lightandroidproject;

import com.lightandroid.navigation.activity.LightActivity;

/**
 * Created by David on 20.11.2014..
 */
public class CameraActivity extends LightActivity {
    @Override
    public int provideLayoutRes() {
        return R.layout.activity_container;
    }

    @Override
    public void main() {
        setupFragment(R.id.container, new CameraFragment());
    }
}
