package com.example.david.lightandroidproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.dmacan.lightandroid.LightFragment;

import de.keyboardsurfer.android.widget.crouton.Crouton;

/**
 * Created by David on 21.9.2014..
 */
public class TestFragment extends LightFragment {
    @Override
    public int provideLayoutRes() {
        return R.layout.fragment_test;
    }

    @Override
    public void main() {
        LayoutInflater inflater = (LayoutInflater) getLightActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.crouton_test, null, false);
        Crouton.make(getLightActivity(), v, R.id.myViewGroup).show();
    }
}
