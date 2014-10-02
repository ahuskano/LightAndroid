package com.dmacan.lightandroid.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.dmacan.lightandroid.R;
import com.dmacan.lightandroid.util.LightFont;

import de.keyboardsurfer.android.widget.crouton.Configuration;
import de.keyboardsurfer.android.widget.crouton.Crouton;

/**
 * Created by David on 17.9.2014..
 */
public class LightMessenger {

    private Activity activity;
    private boolean displayOnTop = true;
    private int bindViewGroupRes;
    private Configuration configurationInfinite;
    private Configuration configurationDefault;

    public LightMessenger(Activity activity) {
        this.activity = activity;
        init();
    }

    public LightMessenger(Activity activity, int bindViewGroupRes) {
        this.activity = activity;
        this.displayOnTop = false;
        this.bindViewGroupRes = bindViewGroupRes;
        init();
    }

    private void init() {
        configurationInfinite = new Configuration.Builder()
                .setDuration(Configuration.DURATION_INFINITE)
                .build();
        configurationDefault = new Configuration.Builder().setDuration(1800).build();
    }

    public void showLoading(String message, boolean dismissOthers) {
        if (dismissOthers)
            Crouton.clearCroutonsForActivity(activity);
        View view = inflateMessengerLayout();
        view.setBackgroundColor(activity.getResources().getColor(R.color.messenger_message));
        TextView txtIcon = inflateMessengerIconView(view);
        TextView txtLabel = inflateMessengerTextView(view);
        txtIcon.setText(activity.getResources().getString(R.string.fa_spinner));
        txtLabel.setText(message);
        LightFont.setFont("fontawesome.ttf", txtIcon);
        animateView(txtIcon, R.anim.rotate);
        final Crouton crouton = initCrouton(view);
        crouton.setConfiguration(configurationInfinite);
        crouton.show();
    }

    public void showSuccess(String message, boolean dismissOthers) {
        if (dismissOthers)
            Crouton.clearCroutonsForActivity(activity);
        View view = inflateMessengerLayout();
        view.setBackgroundColor(activity.getResources().getColor(R.color.messenger_success));
        TextView txtIcon = inflateMessengerIconView(view);
        TextView txtLabel = inflateMessengerTextView(view);
        txtIcon.setText(activity.getResources().getString(R.string.fa_check_circle_o));
        txtLabel.setText(message);
        LightFont.setFont("fontawesome.ttf", txtIcon);
        final Crouton crouton = initCrouton(view);
        crouton.setConfiguration(configurationDefault);
        crouton.show();
    }

    public void showError(String message, boolean dismissOthers) {
        if (dismissOthers)
            Crouton.clearCroutonsForActivity(activity);
        View view = inflateMessengerLayout();
        view.setBackgroundColor(activity.getResources().getColor(R.color.messenger_error));
        TextView txtIcon = inflateMessengerIconView(view);
        TextView txtLabel = inflateMessengerTextView(view);
        txtIcon.setText(activity.getResources().getString(R.string.fa_close));
        txtLabel.setText(message);
        LightFont.setFont("fontawesome.ttf", txtIcon);
        final Crouton crouton = initCrouton(view);
        crouton.setConfiguration(configurationDefault);
        crouton.show();
    }

    public void showLoading(String message) {
        showLoading(message, true);
    }

    public void showSuccess(String message) {
        showSuccess(message, true);
    }

    public void showError(String message) {
        showError(message, true);
    }

    public void showError(int messageId) {
        showError(activity.getResources().getString(messageId), true);
    }

    public void dismissAll() {
        Crouton.clearCroutonsForActivity(activity);
    }

    private View inflateMessengerLayout() {
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return inflater.inflate(R.layout.layout_light_messenger, null, false);
    }

    private TextView inflateMessengerIconView(View view) {
        return (TextView) view.findViewById(R.id.messengerLoadingIcon);
    }

    private TextView inflateMessengerTextView(View view) {
        return (TextView) view.findViewById(R.id.txtMessengerLoadingMessage);
    }

    private void animateView(View view, int animationRes) {
        Animation anim = AnimationUtils.loadAnimation(activity, animationRes);
        view.startAnimation(anim);
    }

    private Crouton initCrouton(View view) {
        if (displayOnTop) {
            return Crouton.make(activity, view);
        } else {
            return Crouton.make(activity, view, bindViewGroupRes);
        }
    }

}
