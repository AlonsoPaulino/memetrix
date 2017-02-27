package com.lpaulino.memetrix.data.remote;

import com.lpaulino.memetrix.data.ErrorCallback;
import com.lpaulino.memetrix.data.SuccessCallback;
import com.lpaulino.memetrix.data.source.UserDataSource;
import com.lpaulino.memetrix.domain.User;
import com.lpaulino.memetrix.networking.ServerRequest;
import com.lpaulino.memetrix.networking.ServiceFactory;
import com.lpaulino.memetrix.networking.api.UserApi;
import com.lpaulino.memetrix.networking.requests.AuthenticationParams;

/**
 * @author Luis Alonso Paulino Flores on 05/02/17.
 */

public class UserRemoteSource implements UserDataSource {

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
        AuthenticationParams body = new AuthenticationParams(email, password);
        ServerRequest<User> request = new ServerRequest<>(ServiceFactory.create(UserApi.class).authenticate(body));
        request.enqueue(successCallback, errorCallback);
    }
}
