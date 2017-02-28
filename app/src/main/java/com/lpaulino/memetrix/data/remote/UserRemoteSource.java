package com.lpaulino.memetrix.data.remote;

import com.lpaulino.memetrix.data.ErrorCallback;
import com.lpaulino.memetrix.data.SuccessCallback;
import com.lpaulino.memetrix.data.source.UserDataSource;
import com.lpaulino.memetrix.domain.User;
import com.lpaulino.memetrix.networking.ServerRequest;
import com.lpaulino.memetrix.networking.api.UserService;
import com.lpaulino.memetrix.networking.common.MemetrixClient;
import com.lpaulino.memetrix.networking.requests.AuthenticationBody;

/**
 * @author Luis Alonso Paulino Flores on 05/02/17.
 */

public class UserRemoteSource implements UserDataSource {

    private static UserRemoteSource INSTANCE = null;
    private MemetrixClient mHttpClient;

    private UserRemoteSource(MemetrixClient httpClient) {
        mHttpClient = httpClient;
    }

    public static UserRemoteSource getInstance(MemetrixClient httpClient) {
        if (INSTANCE == null) {
            INSTANCE = new UserRemoteSource(httpClient);
        }
        return INSTANCE;
    }

    @Override
    public void authenticate(String email, String password, SuccessCallback<User> successCallback, ErrorCallback errorCallback) {
        UserService userService = mHttpClient.provideApi(UserService.class);
        ServerRequest<User> request = new ServerRequest<>(userService.authenticate(
                new AuthenticationBody(email, password)
        ));
        request.enqueue(successCallback, errorCallback);
    }
}
