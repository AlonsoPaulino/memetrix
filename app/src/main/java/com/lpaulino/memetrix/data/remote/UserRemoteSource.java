package com.lpaulino.memetrix.data.remote;

import com.lpaulino.memetrix.data.ErrorCallback;
import com.lpaulino.memetrix.data.SuccessCallback;
import com.lpaulino.memetrix.data.source.UserDataSource;
import com.lpaulino.memetrix.domain.User;

/**
 * @author Luis Alonso Paulino Flores on 05/02/17.
 */

public class UserRemoteSource implements UserDataSource{

    private static UserRemoteSource INSTANCE = null;

    private UserRemoteSource() {}

    public static UserRemoteSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UserRemoteSource();
        }
        return INSTANCE;
    }

    @Override
    public void authenticate(String email, String password, SuccessCallback<User> successCallback, ErrorCallback errorCallback) {
        FirebaseHelper.getFirebaseAuthInstance().signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
            if (!task.isSuccessful()) {
                errorCallback.onError(new Exception("Authentication failed!!"));
            } else {
                successCallback.onSuccess(new User(email));
            }
        });
    }
}
