package com.example.david.lightandroidproject.datademo;

import com.dmacan.lightandroid.data.LightController;
import com.dmacan.lightandroid.data.api.LightRequest;
import com.dmacan.lightandroid.event.LightDataResponseCallback;
import com.dmacan.lightandroid.util.LightAPIUtil;
import com.example.david.lightandroidproject.apidemo.DemoAPI;

/**
 * Created by David on 17.9.2014..
 */
public class UserController extends LightController {

    private LightDataResponseCallback<User> userCallback;

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
        if (userCallback == null)
            userCallback = new LightDataResponseCallback<User>(getOnDataResponseListener(), getOnErrorListener());
        LightAPIUtil.getRestAdapter(DemoAPI.API_LOCATION).create(DemoAPI.class).readUser(readRequest, userCallback);
    }


}
