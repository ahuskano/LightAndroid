package com.example.david.lightandroidproject.navigation;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.astuetz.PagerSlidingTabStrip;
import com.dmacan.lightandroid.navigation.activity.LightTabbedActivity;

/**
 * Created by David on 16.11.2014..
 */
public class DemoNetworkingActivity extends LightTabbedActivity {
    @Override
    public ViewPager provideViewPager() {
        return null;
    }

    @Override
    public Fragment[] provideFragments() {
        return new Fragment[0];
    }

    @Override
    public PagerSlidingTabStrip providePagerSlidingTabStrip() {
        return null;
    }

    @Override
    public int provideLayoutRes() {
        return 0;
    }
}
