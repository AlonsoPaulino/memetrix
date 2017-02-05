package com.lpaulino.memetrix.data.source;

import com.lpaulino.memetrix.data.ErrorCallback;
import com.lpaulino.memetrix.data.SuccessCallback;
import com.lpaulino.memetrix.domain.User;

/**
 * @author Luis Alonso Paulino Flores on 05/02/17.
 */

public interface UserDataSource {

    void authenticate(String email, String password, SuccessCallback<User> successCallback, ErrorCallback errorCallback);
}
