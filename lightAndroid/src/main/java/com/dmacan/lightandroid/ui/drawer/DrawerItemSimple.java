package com.dmacan.lightandroid.ui.drawer;

/**
 * Created by David on 17.8.2014..
 */
public class DrawerItemSimple extends DrawerItem {

    private String icon;
    private int iconRes;

    public DrawerItemSimple(String icon, String label) {
        super(label);
        this.icon = icon;
    }

    public DrawerItemSimple(int icon, String label) {
        super(label);
        this.iconRes = icon;
    }

    public DrawerItemSimple(String icon, String label, boolean fragment) {
        super(label, fragment);
        this.icon = icon;
    }

    public DrawerItemSimple(int icon, String label, boolean fragment) {
        super(label, fragment);
        this.iconRes = icon;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getIconRes() {
        return iconRes;
    }

    public void setIconRes(int iconRes) {
        this.iconRes = iconRes;
    }
}
