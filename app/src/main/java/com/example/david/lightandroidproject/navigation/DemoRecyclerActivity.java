package com.example.david.lightandroidproject.navigation;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dmacan.lightandroid.navigation.activity.LightActivity;
import com.dmacan.lightandroid.ui.presenter.LightRecyclerViewAdapter;
import com.example.david.lightandroidproject.R;
import com.example.david.lightandroidproject.type.RecyclerItem;

import butterknife.InjectView;

/**
 * Created by David on 16.11.2014..
 */
public class DemoRecyclerActivity extends LightActivity {

    @InjectView(R.id.recycler)
    RecyclerView recyclerView;
    String[] cards = {"Kartica", "Martica", "Dartica", "Katica", "Kumica"};
    LightRecyclerViewAdapter adapter;

    @Override
    public int provideLayoutRes() {
        return R.layout.layout_recycler;
    }

    @Override
    public void main() {
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        adapter = new LightRecyclerViewAdapter(getBaseContext(), R.layout.item_card);
        recyclerView.setAdapter(adapter);
        for (String c : cards)
            adapter.addItem(new RecyclerItem(c));
    }
}
