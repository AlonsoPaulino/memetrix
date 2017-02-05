package com.lpaulino.memetrix.managers;

import com.lpaulino.memetrix.data.ErrorCallback;
import com.lpaulino.memetrix.data.SuccessCallback;
import com.lpaulino.memetrix.data.source.UserDataSource;
import com.lpaulino.memetrix.domain.User;

/**
 * @author Luis Alonso Paulino Flores on 05/02/17.
 */

public class AuthManager {

    private static AuthManager INSTANCE = null;
    private UserDataSource mUserDataSource;

    private AuthManager() {}

    public static synchronized AuthManager getInstance(UserDataSource userDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new AuthManager();
        }
        INSTANCE.setUserDataSource(userDataSource);
        return INSTANCE;
    }

    private void setUserDataSource(UserDataSource userDataSource) {
        mUserDataSource = userDataSource;
    }

    public void authenticate(String email, String password, SuccessCallback<User> successCallback, ErrorCallback errorCallback) {
        mUserDataSource.authenticate(email, password, successCallback, errorCallback);
    }
}
