package com.example.david.lightandroidproject.datademo;

import com.dmacan.lightandroid.type.LightData;
import com.google.gson.annotations.Expose;

/**
 * Created by David on 17.9.2014..
 */
public class User extends LightData {

    // @Expose se dodaje na one atribute koji će se slati/dohvaćati putem JSON-a, tako da objekti po potrebi mogu imati i atribute koje ne treba slati
    @Expose
    private String username;
    @Expose
    private String password;
    @Expose
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
