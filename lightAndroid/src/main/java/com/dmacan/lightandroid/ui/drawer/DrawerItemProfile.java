package com.dmacan.lightandroid.ui.drawer;

/**
 * Created by David on 17.8.2014..
 */
public class DrawerItemProfile extends DrawerItem {

    private String image;

    public DrawerItemProfile(String label, String image) {
        super(label);
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
