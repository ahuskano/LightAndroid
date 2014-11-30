package com.example.david.lightandroidproject;

import android.widget.Toast;

import com.example.david.lightandroidproject.data.controller.MusicianController;
import com.example.david.lightandroidproject.data.model.Musician;
import com.example.david.lightandroidproject.data.presenter.MusicianPresenter;
import com.lightandroid.data.api.listener.OnDataMultipleResponseListener;
import com.lightandroid.data.api.listener.OnErrorListener;
import com.lightandroid.navigation.fragment.LightFragment;
import com.lightandroid.type.LightData;
import com.lightandroid.type.property.Labeled;
import com.lightandroid.ui.presenter.LightRecyclerViewAdapter;

import org.lucasr.twowayview.widget.TwoWayView;

import butterknife.InjectView;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by David on 16.11.2014..
 * <p/>
 * In this fragment, we are demonstrating how to create GET requests to the API and then do something with the response
 */
public class DemoGETMusiciansFragment extends LightFragment implements Labeled, OnDataMultipleResponseListener, OnErrorListener {

    @InjectView(R.id.twoWay)
    TwoWayView recycler;

    // Adapter for the RecyclerView
    private LightRecyclerViewAdapter adapter;
    // Since this fragment uses MusicianController class, it is best that the controller is declared globally for easier access
    private MusicianController musicianController;

    @Override
    public int provideLayoutRes() {
        return R.layout.fragment_get_musicians;
    }

    @Override
    public void main() {
        // Instantiate the controller for further usage
        musicianController = new MusicianController();
        // Set the listener to listen for data responses from the API
        musicianController.setOnDataMultipleResponseListener(this);
        // Set the listener to listen for request errors
        musicianController.setOnErrorListener(this);
        // Instantiate the adapter for the RecyclerView
        adapter = new LightRecyclerViewAdapter(getLightActivity(), R.layout.item_card);
        // Assign adapter to the RecyclerView
        recycler.setAdapter(adapter);
        // Call API request to load all musicians
        musicianController.loadMusicians();
    }

    @Override
    public String provideLabel() {
        return "GET";
    }

    /**
     * This method is called after the server sends a response
     *
     * @param response         Response returned by the server
     * @param retrofitResponse Response generated by Retrofit
     */
    @Override
    public void onMultipleResponse(LightData[] response, Response retrofitResponse) {
        // First we need to cast an array that the server returned to the model class we need
        Musician[] musicians = (Musician[]) response;
        for (Musician musician : musicians)
            adapter.addItem(new MusicianPresenter(musician));
    }

    /**
     * This method is called if an error with the request or response occurs
     *
     * @param error Error generated by Retrofit
     */
    @Override
    public void onError(RetrofitError error) {
        Toast.makeText(getLightActivity(), "An error has occured", Toast.LENGTH_SHORT).show();
    }

}