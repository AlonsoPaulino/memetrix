package com.lpaulino.memetrix.networking.client;

import com.lpaulino.memetrix.BuildConfig;
import com.lpaulino.memetrix.networking.common.MemetrixClient;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Luis Alonso Paulino Flores on 28/02/17.
 */

public class RetrofitClient implements MemetrixClient {

    private static RetrofitClient INSTANCE = null;
    private Retrofit retrofit;

    private RetrofitClient() {
        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BuildConfig.SERVER_URL)
                .build();
    }

    public synchronized static RetrofitClient getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RetrofitClient();
        }
        return INSTANCE;
    }

    @Override
    public <T> T provideApi(Class<T> clazz) {
        return retrofit.create(clazz);
    }
}
