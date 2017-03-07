package com.lpaulino.memetrix.data.local;

import com.lpaulino.memetrix.data.ErrorCallback;
import com.lpaulino.memetrix.data.SuccessCallback;
import com.lpaulino.memetrix.data.source.UserDataSource;
import com.lpaulino.memetrix.domain.User;

/**
 * @author Luis Alonso Paulino Flores on 05/02/17.
 */

public class UserLocalSource implements UserDataSource {

    private static UserLocalSource INSTANCE = null;

    private UserLocalSource() {}

    public static UserLocalSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UserLocalSource();
        }
        return INSTANCE;
    }

    @Override
    public void authenticate(String email, String password, SuccessCallback<User> successCallback,
                             ErrorCallback errorCallback) {

    }

    @Override
    public void register(String email, String firstName, String lastName, String password, SuccessCallback<User> successCallback, ErrorCallback errorCallback) {

    }
}
