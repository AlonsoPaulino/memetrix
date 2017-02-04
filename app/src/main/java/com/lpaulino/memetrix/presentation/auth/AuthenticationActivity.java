package com.lpaulino.memetrix.presentation.auth;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.lpaulino.memetrix.R;
import com.lpaulino.memetrix.presentation.common.MemetrixActivity;

/**
 * @author Luis Alonso Paulino Flores on 3/02/17.
 */

public class AuthenticationActivity extends MemetrixActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);

        SignInFragment signInFragment = (SignInFragment) findFragmentById(R.id.main_content);

        if (signInFragment == null) {
            signInFragment = SignInFragment.newInstance();
        }

        replaceFragment(signInFragment);
    }
}
