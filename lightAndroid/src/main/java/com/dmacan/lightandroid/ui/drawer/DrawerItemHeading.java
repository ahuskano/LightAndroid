package com.dmacan.lightandroid.ui.drawer;

import android.graphics.drawable.Drawable;

/**
 * Created by David on 24.8.2014..
 */
public class DrawerItemHeading extends DrawerItem {

    private String label;
    private int color;
    private Drawable image;

    public DrawerItemHeading(String label, int color, Drawable image) {
        super(label);
        this.label = label;
        this.color = color;
        this.image = image;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }
}
