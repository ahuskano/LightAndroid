package com.example.david.lightandroidproject;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.dmacan.lightandroid.data.api.listener.OnDataMultipleResponseListener;
import com.dmacan.lightandroid.data.api.listener.OnErrorListener;
import com.dmacan.lightandroid.navigation.fragment.LightFragment;
import com.dmacan.lightandroid.type.LightData;
import com.dmacan.lightandroid.type.property.Labeled;
import com.dmacan.lightandroid.ui.presenter.LightRecyclerViewAdapter;
import com.example.david.lightandroidproject.data.controller.MusicianController;
import com.example.david.lightandroidproject.data.model.Musician;
import com.example.david.lightandroidproject.data.presenter.MusicianPresenter;

import butterknife.InjectView;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by David on 16.11.2014..
 */
public class DemoGETMusiciansFragment extends LightFragment implements Labeled, OnDataMultipleResponseListener, OnErrorListener {

    @InjectView(R.id.rv)
    RecyclerView recycler;

    private LightRecyclerViewAdapter adapter;
    private MusicianController musicianController;

    @Override
    public int provideLayoutRes() {
        return R.layout.fragment_get_musicians;
    }

    @Override
    public void main() {
        musicianController = new MusicianController();
        musicianController.setOnDataMultipleResponseListener(this);
        musicianController.setOnErrorListener(this);
        recycler.setItemAnimator(new DefaultItemAnimator());
        recycler.setLayoutManager(new LinearLayoutManager(getLightActivity()));
        adapter = new LightRecyclerViewAdapter(getLightActivity(), R.layout.item_card);
        recycler.setAdapter(adapter);
        musicianController.loadMusicians();
    }

    @Override
    public String provideLabel() {
        return "GET";
    }

    @Override
    public void onMultipleResponse(LightData[] response, Response retrofitResponse) {
        Musician[] musicians = (Musician[]) response;
        for (Musician musician : musicians)
            Log.d("DAM", "Musician is null: " + (musician == null));
        for (Musician musician : musicians)
            adapter.addItem(new MusicianPresenter(musician));
    }

    @Override
    public void onError(RetrofitError error) {
        Toast.makeText(getLightActivity(), "An error has occured", Toast.LENGTH_SHORT).show();
    }
}
