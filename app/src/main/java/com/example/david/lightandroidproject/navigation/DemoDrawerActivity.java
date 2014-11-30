package com.example.david.lightandroidproject.navigation;

import android.os.Bundle;
import android.view.View;

import com.example.david.lightandroidproject.R;
import com.lightandroid.navigation.activity.LightDrawerActivity;
import com.lightandroid.ui.drawer.DrawerSettings;

import net.simonvt.menudrawer.MenuDrawer;
import net.simonvt.menudrawer.Position;

/**
 * Created by David on 16.11.2014..
 */
public class DemoDrawerActivity extends LightDrawerActivity {

    @Override
    public DrawerSettings setDrawerSettings() {
        return new DrawerSettings().dragMode(MenuDrawer.MENU_DRAG_WINDOW).layoutRes(R.layout.layout_demo).position(Position.BOTTOM).type(MenuDrawer.Type.STATIC);
    }

    @Override
    public void init(Bundle savedInstanceState) {
        (findViewById(R.id.btnToggleDrawer)).setOnClickListener(getDrawerToggleListener());
        setupDrawerFragment(new DemoFragment());
        setupContentFragment(new DemoFragment());
    }

    @Override
    public void setupDrawerView(Bundle savedInstanceState, View menuView) {
    }

    @Override
    public int provideLayoutRes() {
        return R.layout.layout_drawer;
    }

}
