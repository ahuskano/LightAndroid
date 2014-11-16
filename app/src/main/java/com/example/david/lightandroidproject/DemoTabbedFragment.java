package com.example.david.lightandroidproject;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.astuetz.PagerSlidingTabStrip;
import com.dmacan.lightandroid.navigation.fragment.LightTabbedFragment;

import butterknife.InjectView;

/**
 * Created by David on 16.11.2014..
 */
public class DemoTabbedFragment extends LightTabbedFragment {

    @InjectView(R.id.pager)
    ViewPager pager;
    @InjectView(R.id.tabs)
    PagerSlidingTabStrip tabs;

    @Override
    public ViewPager provideViewPager() {
        return pager;
    }

    @Override
    public Fragment[] provideFragments() {
        return new Fragment[]{new DemoFragment(), new DemoFragment(), new DemoFragment(), new DemoFragment()};
    }

    @Override
    public PagerSlidingTabStrip providePagerSlidingTabStrip() {
        return tabs;
    }

    @Override
    public int provideLayoutRes() {
        return R.layout.fragment_tabbed;
    }
}