package com.dmacan.lightandroid.ui.drawer;

/**
 * Created by David on 17.8.2014..
 */
public class DrawerItem {

    private String label;
    private boolean fragment = true;

    public DrawerItem(String label) {
        this.label = label;
    }

    public DrawerItem(String label, boolean fragment) {
        this(label);
        this.fragment = fragment;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isFragment() {
        return fragment;
    }

    public void setFragment(boolean fragment) {
        this.fragment = fragment;
    }

    public static class Type {
        public static final int CATEGORY = 0;
        public static final int SIMPLE = 1;
        public static final int PROFILE = 2;
        public static final int HEADING = 3;
    }
}
