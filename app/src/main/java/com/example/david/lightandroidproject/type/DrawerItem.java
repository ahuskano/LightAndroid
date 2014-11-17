package com.example.david.lightandroidproject.type;

import android.view.View;
import android.widget.TextView;

import com.dmacan.lightandroid.ui.presenter.LightAdapterItem;
import com.example.david.lightandroidproject.R;

/**
 * Created by David on 16.11.2014..
 */
public class DrawerItem implements LightAdapterItem {

    private String label;

    public DrawerItem(String label) {
        this.label = label;
    }

    @Override
    public void display(View view, int position) {
        ((TextView) view.findViewById(R.id.txtDrawerItemLabel)).setText(label);
    }

    @Override
    public int provideItemLayoutRes() {
        return R.layout.item_drawer;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
