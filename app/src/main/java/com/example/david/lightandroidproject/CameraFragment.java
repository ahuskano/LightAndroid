package com.example.david.lightandroidproject;

import android.hardware.Camera;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.lightandroid.util.camera.LightCameraFragment;
import com.lightandroid.util.camera.LightCameraPreview;

import butterknife.InjectView;

/**
 * Created by David on 20.11.2014..
 */
public class CameraFragment extends LightCameraFragment {

    @InjectView(R.id.preview)
    LinearLayout preview;

    @Override
    public void main(LightCameraPreview cameraPreview) {

    }

    @Override
    public ViewGroup setPreview() {
        return preview;
    }

    @Override
    public int provideLayoutRes(LightCameraPreview preview) {
        return R.layout.fragment_camera;
    }

    @Override
    public void cancel() {

    }

    @Override
    public void onPreviewFrame(byte[] bytes, Camera camera) {

    }
}
