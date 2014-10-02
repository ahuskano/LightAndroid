package com.dmacan.lightandroid.ui.drawer;

import android.content.Context;
import android.text.Html;

/**
 * Created by David on 17.8.2014..
 */
public class DrawerData {

    public static final String DEFAULT_TAG = "default";
    public static Context context;

    private static String getString(int id) {
        return context.getResources().getString(id);
    }

    public static DrawerItemSimple newItem(int labelID, int iconID) {
        return new DrawerItemSimple(getString(iconID), getString(labelID));
    }

    public static DrawerItemSimple newItem(String label, String icon) {
        return new DrawerItemSimple(Html.fromHtml(icon).toString(), label);
    }

    public static DrawerItemSimple newItem(int labelID, int iconID, boolean fragment) {
        return new DrawerItemSimple(getString(iconID), getString(labelID), fragment);
    }

    public static DrawerItemCategory newCategory(int labelID) {
        return new DrawerItemCategory(getString(labelID));
    }

}
