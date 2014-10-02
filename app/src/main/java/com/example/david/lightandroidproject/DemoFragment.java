package com.example.david.lightandroidproject;

import android.widget.TextView;

import com.dmacan.lightandroid.LightFragment;
import com.dmacan.lightandroid.api.LightResponse;
import com.dmacan.lightandroid.api.listener.OnDataReadListener;
import com.dmacan.lightandroid.api.listener.OnErrorListener;
import com.example.david.lightandroidproject.datademo.UserController;

import butterknife.InjectView;
import butterknife.OnClick;
import retrofit.RetrofitError;

/**
 * Created by David on 17.9.2014..
 */
public class DemoFragment extends LightFragment implements OnDataReadListener, OnErrorListener {

    /**
     * Predlažem da korisitmo Butterknife jer je puno jednostavnije
     */

    @InjectView(R.id.etUsername)
    TextView etUsername; // ne smije biti private, al ko ga jebe :D
    @InjectView(R.id.etPassword)
    TextView etPassword;

    private UserController userController;

    @Override
    public int provideLayoutRes() {
        return R.layout.fragment_demo;
    }

    @Override
    public void main() {
        userController = new UserController();
    }

    /**
     * Ova metoda izvršava se kad se klikne na gumb
     */
    @OnClick(R.id.btnFindUser)
    void findUser() {
        userController.readUser(etUsername.getText().toString(), etPassword.getText().toString());
        userController.setOnDataReadListener(this); // naravno, ovo se mora postaviti ako se želi osluškivati response
        userController.setOnErrorListener(this);
    }

    /**
     * Ova metoda dolazi s OnDataReadListener-om. Kada dođe success response od servera, ovo se poziva
     * Ako je došlo do greške u response-u, odnosno RetrofitError, tada se zove onError metoda u OnError listeneru ako takva postoji
     *
     * @param data
     */
    @Override
    public void onDataRead(LightResponse data) {
      /*  User user = (User) data.ge;
        if (user == null) // došlo je do pogreške jer api nije našao usera u bazi
            getLightMessenger().showError("Ovo je error!");
        else {
            getLightMessenger().showSuccess(user.getEmail());
        }*/
    }

    @Override
    public void onError(RetrofitError error) {
        getLightMessenger().showError("Došlo je do neke greške");
    }

}
