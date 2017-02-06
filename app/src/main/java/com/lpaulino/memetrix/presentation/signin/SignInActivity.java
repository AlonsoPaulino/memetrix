package com.lpaulino.memetrix.presentation.signin;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.lpaulino.memetrix.Injection;
import com.lpaulino.memetrix.R;
import com.lpaulino.memetrix.presentation.common.MemetrixActivity;

/**
 * @author Luis Alonso Paulino Flores on 3/02/17.
 */

public class SignInActivity extends MemetrixActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        SignInFragment signInFragment = (SignInFragment) findFragmentById(R.id.main_content);

        if (signInFragment == null) {
            signInFragment = SignInFragment.newInstance();
        }

        new SignInPresenter(signInFragment, Injection.proviceAuthManager());
        replaceFragment(signInFragment);
    }
}
