package com.example.david.lightandroidproject.type;

import android.view.View;
import android.widget.TextView;

import com.dmacan.lightandroid.ui.presenter.LightRecyclerPresenter;
import com.example.david.lightandroidproject.R;

/**
 * Created by David on 16.11.2014..
 */
public class RecyclerItem implements LightRecyclerPresenter {

    TextView txtLabel;
    private String label;

    public RecyclerItem(String label) {
        this.label = label;
    }

    @Override
    public void initViews(View view) {
        txtLabel = (TextView) view.findViewById(R.id.txtCardLabel);
    }

    @Override
    public void display(View view, int position) {
        txtLabel.setText(label);
    }
}
