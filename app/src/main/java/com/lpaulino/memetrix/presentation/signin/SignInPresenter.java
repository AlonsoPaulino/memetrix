package com.lpaulino.memetrix.presentation.signin;

import com.lpaulino.memetrix.data.local.PreferencesHelper;
import com.lpaulino.memetrix.managers.UserManager;

/**
 * @author Luis Alonso Paulino Flores on 05/02/17.
 */

public class SignInPresenter implements SignInContract.Presenter {

    private SignInContract.View mView;
    private UserManager mUserManager;

    public SignInPresenter(SignInContract.View view, UserManager userManager) {
        mView = view;
        mUserManager = userManager;
        mView.setPresenter(this);
    }

    @Override
    public void authenticate(String email, String password) {
        mView.showLoader();
        mUserManager.authenticate(email, password, data -> {
            PreferencesHelper.setUserLoggedIn(data);
            mView.dismissLoader();
            mView.userIsAuthorized();
        }, exception -> {
            mView.dismissLoader();
            mView.userIsUnauthorized(exception);
        });
    }
}
