package com.lpaulino.memetrix.networking;

import com.lpaulino.memetrix.BuildConfig;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Luis Alonso Paulino Flores on 27/02/17.
 */

public class ServiceFactory {

    private static Retrofit retrofit;

    public synchronized static <T> T create(final Class<T> clazz) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BuildConfig.SERVER_URL)
                    .build();
        }
        return retrofit.create(clazz);
    }
}
