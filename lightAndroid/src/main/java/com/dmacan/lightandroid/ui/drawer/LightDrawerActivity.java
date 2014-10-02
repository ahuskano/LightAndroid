package com.dmacan.lightandroid.ui.drawer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.dmacan.lightandroid.LightActivity;
import com.dmacan.lightandroid.R;
import com.dmacan.lightandroid.type.LightIconDrawable;

import net.simonvt.menudrawer.MenuDrawer;
import net.simonvt.menudrawer.Position;

import java.util.List;

/**
 * Created by David on 17.8.2014..
 */
public abstract class LightDrawerActivity extends LightActivity implements DrawerAdapter.DrawerListener {

    private static final String STATE_ACTIVE_POSITION = "net.simonvt.menudrawer.samples.LeftDrawerSample.activePosition";
    private static final String STATE_CURRENT_FRAGMENT = "net.simonvt.menudrawer.samples.fragmentSample";

    protected MenuDrawer menuDrawer;
    protected DrawerAdapter drawerAdapter;
    protected ListView listView;

    private String currentFragmentTag;

    private int activePosition = 0;
    private AdapterView.OnItemClickListener drawerItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            activePosition = position;
            menuDrawer.setActiveView(view, position);
            drawerAdapter.setActivePosition(position);
            onMenuItemClicked(position, drawerAdapter.getItem(position));
        }
    };
    private android.support.v4.app.FragmentTransaction fragmentTransaction;
    private FragmentManager fragmentManager;
    private boolean tabletLandscape;
    private MenuDrawer.OnDrawerStateChangeListener stateChangeListener = new MenuDrawer.OnDrawerStateChangeListener() {
        @Override
        public void onDrawerStateChange(int oldState, int newState) {
            if (newState == MenuDrawer.STATE_CLOSED)
                commitTransactions();
        }

        @Override
        public void onDrawerSlide(float v, int i) {
            // Do nothing
        }
    };
    private OnMenuItemSelectedListener onMenuItemSelectedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        menuDrawer = MenuDrawer.attach(this, MenuDrawer.Type.BEHIND, getDrawerPosition(), getDragMode());
        //menuDrawer.setDropShadowColor(getResources().getColor(R.color.blue));
        menuDrawer.setDropShadow(R.drawable.drawer_shadow);
        initDrawerItems();
        initFragment(savedInstanceState);
        initActionBar();
        menuDrawer.setOnDrawerStateChangeListener(stateChangeListener);
        main(savedInstanceState, true);
    }

    @Override
    public void onActiveViewChanged(View v) {
        menuDrawer.setActiveView(v, activePosition);
    }

    private void initDrawerItems() {

        listView = new ListView(this);
        listView.setBackgroundColor(getResources().getColor(R.color.drawer_background));
        drawerAdapter = new DrawerAdapter(provideDrawerItems(), this);
        drawerAdapter.setListener(this);
        drawerAdapter.setActivePosition(activePosition);

        listView.setAdapter(drawerAdapter);
        listView.setOnItemClickListener(drawerItemClickListener);

        menuDrawer.setMenuView(listView);
    }

    public abstract List<DrawerItem> provideDrawerItems();

    private void initFragment(Bundle savedInstanceState) {
        fragmentManager = getLightFragmentManager();
        if (savedInstanceState != null) {
            currentFragmentTag = savedInstanceState.getString(STATE_CURRENT_FRAGMENT);
        } else {
            currentFragmentTag = DrawerData.DEFAULT_TAG;
            attachFragment(menuDrawer.getContentContainer().getId(), getFragment(currentFragmentTag), currentFragmentTag);
            commitTransactions();
        }
    }

    protected void onMenuItemClicked(int position, DrawerItem item) {
        if (currentFragmentTag != null) {
            detachFragment(getFragment(currentFragmentTag));
        }
        if (item.isFragment()) {
            attachFragment(menuDrawer.getContentContainer().getId(), getFragment(item.getLabel()), item.getLabel());
            currentFragmentTag = item.getLabel();
        } else {
            provideFragment(item.getLabel());
        }
        menuDrawer.closeMenu();
    }

    protected abstract int getDragMode();

    protected abstract Position getDrawerPosition();

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(STATE_ACTIVE_POSITION, activePosition);
        outState.putString(STATE_CURRENT_FRAGMENT, getCurrentFragmentTag());
    }

    public android.support.v4.app.FragmentTransaction ensureTransaction() {
        if (fragmentTransaction == null) {
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.setTransition(android.support.v4.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        }
        return fragmentTransaction;
    }

    public void attachFragment(int layout, Fragment fragment, String tag) {
        if (fragment != null) {
            if (fragment.isDetached()) {
                ensureTransaction();
                fragmentTransaction.attach(fragment);
            } else if (!fragment.isAdded()) {
                ensureTransaction();
                fragmentTransaction.replace(layout, fragment, tag);
            }
        }
    }

    public void attachFragment(Fragment fragment, String tag) {
        attachFragment(menuDrawer.getContentContainer().getId(), fragment, tag);
    }

    public void detachFragment(Fragment fragment) {
        if (fragment != null && !fragment.isDetached()) {
            ensureTransaction();
            if (fragmentTransaction != null && !fragmentTransaction.isEmpty()) {
                fragmentTransaction.commit();
                fragmentTransaction = null;
            }
        }
    }

    public void commitTransactions() {
        if (fragmentTransaction != null && !fragmentTransaction.isEmpty()) {
            fragmentTransaction.commit();
            getSupportFragmentManager().executePendingTransactions();
            fragmentTransaction = null;
        }
    }

    public String getCurrentFragmentTag() {
        return currentFragmentTag;
    }

    public void setCurrentFragmentTag(String currentFragmentTag) {
        this.currentFragmentTag = currentFragmentTag;
    }

    public FragmentManager getLightFragmentManager() {
        if (fragmentManager == null)
            fragmentManager = getSupportFragmentManager();
        return fragmentManager;
    }

    public void setLightFragmentManager(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    public void initActionBar() {
        LightIconDrawable icon = new LightIconDrawable(this, Html.fromHtml(getResources().getString(R.string.light_fa_bar_icon)).toString()).colorRes(R.color.frame_background).actionBarSize();
        icon.setBounds(50, 0, 50, 0);
        getSupportActionBar().setIcon(icon);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    @Override
    public void main() {

    }

    public abstract void main(Bundle savedInstanceState, boolean drawerActivity);

    public String getLightString(int id) {
        return getResources().getString(id);
    }

    public Fragment getFragment(String tag) {
        Fragment fragment = getLightFragmentManager().findFragmentByTag(tag);
        if (fragment == null) {
            fragment = provideFragment(tag);
        }
        return fragment;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            menuDrawer.openMenu();
        else if (onMenuItemSelectedListener != null)
            onMenuItemSelectedListener.onMenuItemSelected(item);
        return true;
    }

    public abstract Fragment provideFragment(String tag);

    public OnMenuItemSelectedListener getOnMenuItemSelectedListener() {
        return onMenuItemSelectedListener;
    }

    public void setOnMenuItemSelectedListener(OnMenuItemSelectedListener onMenuItemSelectedListener) {
        this.onMenuItemSelectedListener = onMenuItemSelectedListener;
    }

    public interface OnMenuItemSelectedListener {
        public void onMenuItemSelected(MenuItem item);
    }
}
