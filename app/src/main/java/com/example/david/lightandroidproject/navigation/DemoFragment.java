package com.example.david.lightandroidproject.navigation;

import android.widget.TextView;
import android.widget.Toast;

import com.dmacan.lightandroid.data.api.listener.OnDataResponseListener;
import com.dmacan.lightandroid.data.api.listener.OnErrorListener;
import com.dmacan.lightandroid.navigation.fragment.LightFragment;
import com.dmacan.lightandroid.type.LightData;
import com.dmacan.lightandroid.type.property.Labeled;
import com.example.david.lightandroidproject.R;

import butterknife.InjectView;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by David on 17.9.2014..
 */
public class DemoFragment extends LightFragment implements OnDataResponseListener, OnErrorListener, Labeled {

    @InjectView(R.id.etUsername)
    TextView etUsername;
    @InjectView(R.id.etPassword)
    TextView etPassword;

    @Override
    public int provideLayoutRes() {
        return R.layout.fragment_demo;
    }

    @Override
    public void main() {

    }

    @Override
    public void onError(RetrofitError error) {
        Toast.makeText(getActivity(), "Error: " + error.getMessage(), Toast.LENGTH_LONG).show();
    }

    @Override
    public String provideLabel() {
        return "Demo";
    }

    @Override
    public void onResponse(LightData response, Response retrofitResponse) {
    }
}
