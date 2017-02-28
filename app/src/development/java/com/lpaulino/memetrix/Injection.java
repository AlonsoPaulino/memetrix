package com.lpaulino.memetrix;

import com.lpaulino.memetrix.data.local.UserLocalSource;
import com.lpaulino.memetrix.data.remote.UserRemoteSource;
import com.lpaulino.memetrix.managers.UserManager;
import com.lpaulino.memetrix.networking.api.UserService;
import com.lpaulino.memetrix.networking.client.RetrofitClient;

/**
 * @author Luis Alonso Paulino Flores on 06/02/17.
 */

public class Injection {

    public static UserManager provideUserManager() {
        return UserManager.getInstance(
                UserLocalSource.getInstance(),
                UserRemoteSource.getInstance(RetrofitClient.getInstance())
        );
    }
}
