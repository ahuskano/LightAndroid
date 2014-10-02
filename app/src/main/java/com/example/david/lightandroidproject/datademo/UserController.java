package com.example.david.lightandroidproject.datademo;

import com.dmacan.lightandroid.api.LightRequest;
import com.dmacan.lightandroid.data.LightController;
import com.dmacan.lightandroid.util.LightAPIUtil;
import com.example.david.lightandroidproject.apidemo.DemoAPI;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by David on 17.9.2014..
 */
public class UserController extends LightController {


    /**
     * Napravi se request, dohvati se API i off you go :D
     *
     * @param username
     * @param password
     */
    public void readUser(String username, String password) {
        LightRequest readRequest = new LightRequest();
        readRequest.setMethod("userRead");
        User u = new User();
        u.setUsername(username);
        u.setPassword(password);
        readRequest.setData(u);
        LightAPIUtil.getRestAdapter(DemoAPI.API_LOCATION).create(DemoAPI.class).readUser(readRequest, readUserCallback);
    }


    /**
     * Iz nekog razloga nije dozvoljeno downCastati retrofitov GSON response, pa moramo za svaki objekt raditi ovako callback. Naravno, vjerojatno postoji rješenje al nisam stigao istražiti pa ćemo ovako :D
     */
    private Callback<User> readUserCallback = new Callback<User>() {
        @Override
        public void success(User user, Response response) {
         //   if (getOnDataReadListener() != null)
                //getOnDataReadListener().onDataRead(user);
        }

        @Override
        public void failure(RetrofitError error) {
            if (getOnErrorListener() != null)
                getOnErrorListener().onError(error);
        }
    };
}
