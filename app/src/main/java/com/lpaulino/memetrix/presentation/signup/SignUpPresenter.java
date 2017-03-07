package com.lpaulino.memetrix.presentation.signup;

import com.lpaulino.memetrix.data.local.PreferencesHelper;
import com.lpaulino.memetrix.managers.UserManager;

/**
 * @author Luis Alonso Paulino Flores on 7/03/17.
 */

public class SignUpPresenter implements SignUpContract.Presenter {

    private SignUpContract.View mView;
    private UserManager mUserManager;

    public SignUpPresenter(SignUpContract.View view, UserManager userManager) {
        mView = view;
        mUserManager = userManager;
        mView.setPresenter(this);
    }

    @Override
    public void register(String email, String firstName, String lastName, String password) {
        mView.showLoader();
        mUserManager.register(email, firstName, lastName, password, data -> {
            PreferencesHelper.setUserLoggedIn(data);
            mView.dismissLoader();
            mView.navigateToMainScreen();
        }, exception -> {
            mView.dismissLoader();
            mView.showErrorMessage(exception);
        });
    }
}
