package com.lpaulino.memetrix.networking.api;

import com.lpaulino.memetrix.domain.User;
import com.lpaulino.memetrix.networking.ServerConstants;
import com.lpaulino.memetrix.networking.requests.AuthenticationParams;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @author Luis Alonso Paulino Flores on 27/02/17.
 */

public interface UserApi {

    @POST(ServerConstants.LOGIN_PATH)
    Call<User> authenticate(@Body AuthenticationParams request);
}
