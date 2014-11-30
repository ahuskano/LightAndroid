package com.example.david.lightandroidproject.type;

import android.widget.TextView;

import com.example.david.lightandroidproject.R;
import com.lightandroid.navigation.fragment.LightFragment;

import butterknife.InjectView;

/**
 * Created by David on 16.11.2014..
 */
public class TestFragment extends LightFragment {


    @InjectView(R.id.txtDisplay)
    TextView txtDisplay;
    private String label;

    public static TestFragment build(String label) {
        TestFragment fragment = new TestFragment();
        fragment.setLabel(label);
        return fragment;
    }

    @Override
    public int provideLayoutRes() {
        return R.layout.fragment_test;
    }

    @Override
    public void main() {
        txtDisplay.setText(label);
    }

    private void setLabel(String label) {
        this.label = label;
    }
}
