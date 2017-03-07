package com.lpaulino.memetrix.managers;

import com.lpaulino.memetrix.data.ErrorCallback;
import com.lpaulino.memetrix.data.SuccessCallback;
import com.lpaulino.memetrix.data.source.UserDataSource;
import com.lpaulino.memetrix.domain.User;

/**
 * @author Luis Alonso Paulino Flores on 05/02/17.
 */

public class UserManager {

    private static UserManager INSTANCE = null;
    private UserDataSource mUserLocalDataSource;
    private UserDataSource mUserRemoteDataSource;

    private UserManager(UserDataSource userLocalDataSource, UserDataSource userRemoteDataSource) {
        mUserLocalDataSource = userLocalDataSource;
        mUserRemoteDataSource = userRemoteDataSource;
    }

    public static synchronized UserManager getInstance(UserDataSource userLocalDataSource, UserDataSource userRemoteDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new UserManager(userLocalDataSource, userRemoteDataSource);
        }
        return INSTANCE;
    }

    public void authenticate(String email, String password, SuccessCallback<User> successCallback, ErrorCallback errorCallback) {
        mUserRemoteDataSource.authenticate(email, password, successCallback, errorCallback);
    }

    public void register(String email, String firstName, String lastName, String password, SuccessCallback<User> successCallback, ErrorCallback errorCallback) {
        mUserRemoteDataSource.register(email, firstName, lastName, password, data -> authenticate(email, password, successCallback, errorCallback), errorCallback);
    }
}
