package com.lpaulino.memetrix.data.remote;

import com.lpaulino.memetrix.data.ErrorCallback;
import com.lpaulino.memetrix.data.SuccessCallback;
import com.lpaulino.memetrix.data.source.UserDataSource;
import com.lpaulino.memetrix.domain.User;
import com.lpaulino.memetrix.networking.ServerRequest;
import com.lpaulino.memetrix.networking.api.UserService;
import com.lpaulino.memetrix.networking.common.MemetrixClient;
import com.lpaulino.memetrix.networking.requests.AuthenticationBody;
import com.lpaulino.memetrix.networking.requests.RegistrationBody;

/**
 * @author Luis Alonso Paulino Flores on 05/02/17.
 */

public class UserRemoteSource implements UserDataSource {

    private static UserRemoteSource INSTANCE = null;
    private UserService mUserService;

    private UserRemoteSource(MemetrixClient memetrixClient) {
        mUserService = memetrixClient.provideApi(UserService.class);
    }

    public static UserRemoteSource getInstance(MemetrixClient memetrixClient) {
        if (INSTANCE == null) {
            INSTANCE = new UserRemoteSource(memetrixClient);
        }
        return INSTANCE;
    }

    @Override
    public void authenticate(String email, String password, SuccessCallback<User> successCallback, ErrorCallback errorCallback) {
        AuthenticationBody body = new AuthenticationBody(email, password);
        ServerRequest<User> request = new ServerRequest<>(mUserService.authenticate(body));
        request.enqueue(successCallback, errorCallback);
    }

    @Override
    public void register(String email, String firstName, String lastName, String password, SuccessCallback<User> successCallback, ErrorCallback errorCallback) {
        RegistrationBody body = new RegistrationBody(email, firstName, lastName, password);
        ServerRequest<User> request = new ServerRequest<>(mUserService.register(body));
        request.enqueue(successCallback, errorCallback);
    }
}
