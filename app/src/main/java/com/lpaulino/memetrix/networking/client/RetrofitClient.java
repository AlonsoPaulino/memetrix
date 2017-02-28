package com.lpaulino.memetrix.networking.client;

import com.lpaulino.memetrix.BuildConfig;
import com.lpaulino.memetrix.networking.common.MemetrixClient;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Luis Alonso Paulino Flores on 28/02/17.
 */

public class RetrofitClient implements MemetrixClient {

    private static RetrofitClient INSTANCE = null;

    private Retrofit retrofit;

    private RetrofitClient() {
        OkHttpClient okHttpClient = new OkHttpClient();
        OkHttpClient.Builder builder = okHttpClient.newBuilder();

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(loggingInterceptor);
        }

        builder.addInterceptor(chain -> {
            Request request = chain.request().newBuilder()
                    .addHeader("application-id", BuildConfig.BACKENDLESS_APP_ID)
                    .addHeader("secret-key", BuildConfig.BACKENDLESS_API_KEY)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("application-type", "REST")
                    .build();

            return chain.proceed(request);
        });

        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BuildConfig.SERVER_URL)
                .client(builder.build())
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
