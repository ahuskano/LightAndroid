package com.example.david.lightandroidproject.data.model;

import com.dmacan.lightandroid.type.LightData;
import com.google.gson.annotations.Expose;

/**
 * Created by David on 16.11.2014..
 */
public class Musician extends LightData {

    @Expose
    private String name;

    @Expose
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
