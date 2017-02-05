package com.lpaulino.memetrix.presentation.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.lpaulino.memetrix.Constants;
import com.lpaulino.memetrix.data.source.local.PreferencesHelper;
import com.lpaulino.memetrix.presentation.signin.SignInActivity;
import com.lpaulino.memetrix.util.StringUtils;

/**
 * @author Luis Alonso Paulino Flores on 3/02/17.
 */

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String userLoggedIn = PreferencesHelper.getUserLoggedIn();
        Class destiny = (StringUtils.isEmpty(userLoggedIn)) ? SignInActivity.class : Constants.MAIN_ACTIVITY;
        startActivity(new Intent(this, destiny));
        finish();
    }
}
