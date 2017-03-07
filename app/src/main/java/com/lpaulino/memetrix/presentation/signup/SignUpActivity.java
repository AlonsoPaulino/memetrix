package com.lpaulino.memetrix.presentation.signup;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.lpaulino.memetrix.Injection;
import com.lpaulino.memetrix.R;
import com.lpaulino.memetrix.presentation.common.MemetrixActivity;

/**
 * @author Luis Alonso Paulino Flores on 04/02/17.
 */

public class SignUpActivity extends MemetrixActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setDefaultToolbar(true);

        SignUpFragment signUpFragment = (SignUpFragment) findFragmentById(R.id.main_content);

        if (signUpFragment == null) {
            signUpFragment = SignUpFragment.newInstance();
        }

        new SignUpPresenter(signUpFragment, Injection.provideUserManager());
        replaceFragment(signUpFragment);
    }
}
