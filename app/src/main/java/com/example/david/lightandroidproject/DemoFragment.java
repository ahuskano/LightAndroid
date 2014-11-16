package com.example.david.lightandroidproject;

import android.widget.TextView;
import android.widget.Toast;

import com.dmacan.lightandroid.data.api.listener.OnDataResponseListener;
import com.dmacan.lightandroid.data.api.listener.OnErrorListener;
import com.dmacan.lightandroid.navigation.fragment.LightFragment;
import com.dmacan.lightandroid.type.LightData;
import com.dmacan.lightandroid.type.property.Labeled;
import com.example.david.lightandroidproject.datademo.User;
import com.example.david.lightandroidproject.datademo.UserController;

import butterknife.InjectView;
import butterknife.OnClick;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by David on 17.9.2014..
 */
public class DemoFragment extends LightFragment implements OnDataResponseListener, OnErrorListener, Labeled {

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
        Toast.makeText(getLightActivity(), "Klik", Toast.LENGTH_SHORT).show();
        userController.setOnDataResponseListener(this); // naravno, ovo se mora postaviti ako se želi osluškivati response
        userController.setOnErrorListener(this);
        userController.readUser(etUsername.getText().toString(), etPassword.getText().toString());
    }


    @Override
    public void onError(RetrofitError error) {
        Toast.makeText(getActivity(), "Error: " + error.getMessage(), Toast.LENGTH_LONG).show();
    }

    @Override
    public String provideLabel() {
        return "Demo";
    }

    @Override
    public void onResponse(LightData response, Response retrofitResponse) {
        User user = (User) response;
        Toast.makeText(getActivity(), user.getUsername(), Toast.LENGTH_SHORT).show();
    }
}
