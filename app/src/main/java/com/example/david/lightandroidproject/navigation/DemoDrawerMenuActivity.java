package com.example.david.lightandroidproject.navigation;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.dmacan.lightandroid.navigation.activity.LightDrawerMenuActivity;
import com.dmacan.lightandroid.ui.drawer.DrawerSettings;
import com.dmacan.lightandroid.ui.presenter.LightAdapterItem;
import com.example.david.lightandroidproject.R;
import com.example.david.lightandroidproject.type.DrawerItem;
import com.example.david.lightandroidproject.type.TestFragment;

import net.simonvt.menudrawer.MenuDrawer;
import net.simonvt.menudrawer.Position;

/**
 * Created by David on 16.11.2014..
 */
public class DemoDrawerMenuActivity extends LightDrawerMenuActivity {

    @Override
    public void setDrawerSettings(DrawerSettings settings) {
        settings.type(MenuDrawer.Type.OVERLAY).dragMode(MenuDrawer.MENU_DRAG_CONTENT).position(Position.LEFT);
    }

    @Override
    public LightAdapterItem[] setDrawerItems() {
        return new LightAdapterItem[]{new DrawerItem("Ovo"), new DrawerItem("Je"), new DrawerItem("Navigational"), new DrawerItem("Menu"), new DrawerItem("Drawer")};
    }

    @Override
    public void onDrawerItemSelected(int position) {
        String tag = ((DrawerItem) getDrawerAdapter().getItem(position)).getLabel();
        TestFragment fragment = TestFragment.build(tag);
        getMenuDrawer().closeMenu();
        setupContentFragment(fragment, tag);
    }

    @Override
    public void init(Bundle savedInstanceState) {
        getDrawerList().setDivider(new ColorDrawable(Color.parseColor("#888888")));
        findViewById(R.id.btnToggleDrawer).setOnClickListener(getDrawerToggleListener());
    }

    @Override
    public int provideLayoutRes() {
        return R.layout.layout_drawer;
    }
}
