package com.lpaulino.memetrix.presentation.signin;

import com.lpaulino.memetrix.data.local.PreferencesHelper;
import com.lpaulino.memetrix.managers.AuthManager;

/**
 * @author Luis Alonso Paulino Flores on 05/02/17.
 */

public class SignInPresenter implements SignInContract.Presenter {

    private SignInContract.View mView;
    private AuthManager mAuthManager;

    public SignInPresenter(SignInContract.View view, AuthManager authManager) {
        mView = view;
        mAuthManager = authManager;
        mView.setPresenter(this);
    }

    @Override
    public void authenticate(String email, String password) {
        mView.showLoader();
        mAuthManager.authenticate(email, password, data -> {
            PreferencesHelper.setUserLoggedIn(data);
            mView.dismissLoader();
            mView.userIsAuthorized();
        }, exception -> {
            mView.dismissLoader();
            mView.userIsUnauthorized(exception);
        });
    }
}
