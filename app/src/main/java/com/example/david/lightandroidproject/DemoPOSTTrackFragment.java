package com.example.david.lightandroidproject;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dmacan.lightandroid.data.api.listener.OnDataResponseListener;
import com.dmacan.lightandroid.navigation.fragment.LightFragment;
import com.dmacan.lightandroid.type.LightData;
import com.dmacan.lightandroid.type.property.Labeled;
import com.dmacan.lightandroid.util.LightFont;
import com.example.david.lightandroidproject.data.controller.MusicianController;
import com.example.david.lightandroidproject.data.model.Musician;

import butterknife.InjectView;
import butterknife.OnClick;
import retrofit.client.Response;

/**
 * Created by David on 16.11.2014..
 */
public class DemoPOSTTrackFragment extends LightFragment implements Labeled, OnDataResponseListener {

    @InjectView(R.id.etQuery)
    EditText etQuery;
    @InjectView(R.id.btnSearch)
    Button btnSearch;

    private MusicianController musicianController;

    @Override
    public int provideLayoutRes() {
        return R.layout.fragment_post_musicians;
    }

    @Override
    public void main() {
        LightFont.setFont(btnSearch);
        musicianController = new MusicianController();
        musicianController.setOnDataResponseListener(this);
    }

    @Override
    public String provideLabel() {
        return "POST";
    }

    @OnClick(R.id.btnSearch)
    void search() {
        musicianController.searchMusician(etQuery.getText().toString());
    }

    @Override
    public void onResponse(LightData response, Response retrofitResponse) {
        Musician musician = (Musician) response;
        Toast.makeText(getLightActivity(), musician.getName(), Toast.LENGTH_SHORT).show();
    }
}
