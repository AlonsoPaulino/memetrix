package com.lpaulino.memetrix;

import com.lpaulino.memetrix.data.local.UserLocalSource;
import com.lpaulino.memetrix.data.remote.UserRemoteSource;
import com.lpaulino.memetrix.managers.AuthManager;

/**
 * @author Luis Alonso Paulino Flores on 6/02/17.
 */

public class Injection {

    public static AuthManager proviceAuthManager() {
        return AuthManager.getInstance(
                UserLocalSource.getInstance(),
                UserRemoteSource.getInstance()
        );
    }
}
