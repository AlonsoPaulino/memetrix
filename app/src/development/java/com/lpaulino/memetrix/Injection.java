package com.lpaulino.memetrix;

import com.lpaulino.memetrix.data.local.UserLocalSource;
import com.lpaulino.memetrix.data.remote.UserRemoteSource;
import com.lpaulino.memetrix.managers.UserManager;

/**
 * @author Luis Alonso Paulino Flores on 06/02/17.
 */

public class Injection {

    public static UserManager proviceAuthManager() {
        return UserManager.getInstance(
                UserLocalSource.getInstance(),
                UserRemoteSource.getInstance()
        );
    }
}
