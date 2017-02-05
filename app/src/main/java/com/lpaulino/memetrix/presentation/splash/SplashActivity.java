package com.lpaulino.memetrix.presentation.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.lpaulino.memetrix.Constants;
import com.lpaulino.memetrix.data.local.PreferencesHelper;
import com.lpaulino.memetrix.domain.User;
import com.lpaulino.memetrix.presentation.signin.SignInActivity;

/**
 * @author Luis Alonso Paulino Flores on 3/02/17.
 */

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        User user = PreferencesHelper.getUserLoggedIn();
        Class destiny = (user == null) ? SignInActivity.class : Constants.MAIN_ACTIVITY;
        startActivity(new Intent(this, destiny));
        finish();
    }
}
