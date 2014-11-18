package com.example.david.lightandroidproject.data.presenter;

import android.view.View;
import android.widget.TextView;

import com.example.david.lightandroidproject.R;
import com.example.david.lightandroidproject.data.model.Musician;
import com.lightandroid.ui.presenter.LightRecyclerPresenter;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by David on 16.11.2014..
 */
public class MusicianPresenter implements LightRecyclerPresenter {

    @InjectView(R.id.txtCardLabel)
    TextView txtLabel;

    private Musician musician;

    public MusicianPresenter(Musician musician) {
        this.musician = musician;
    }

    @Override
    public void initViews(View view) {
        ButterKnife.inject(this, view);
    }

    @Override
    public void display(View view, int position) {
        txtLabel.setText(musician.getName());
    }
}
