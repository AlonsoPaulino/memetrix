package com.lpaulino.memetrix.networking;

import android.support.annotation.NonNull;
import android.support.v4.app.SharedElementCallback;

import com.google.gson.Gson;
import com.lpaulino.memetrix.Memetrix;
import com.lpaulino.memetrix.data.ErrorCallback;
import com.lpaulino.memetrix.data.SuccessCallback;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author Luis Alonso Paulino Flores on 7/02/17.
 */

public class ServerCallback<T> implements Callback<T> {

    private SuccessCallback<T> mSuccessCallback;
    private ErrorCallback mErrorCallback;

    public ServerCallback(@NonNull SuccessCallback<T> successCallback, @NonNull ErrorCallback errorCallback) {
        mSuccessCallback = successCallback;
        mErrorCallback = errorCallback;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            Memetrix.log("ServerCallback successfull", response.body());
            mSuccessCallback.onSuccess(response.body());
        } else {
            ServerError serverError = null;
            if (response.errorBody() != null) {
                Gson gson = new Gson();
                try {
                    serverError = gson.fromJson(response.errorBody().string(), ServerError.class);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (serverError == null) {
                serverError = new ServerError(ServerError.UNKNOWN, "Something went wrong :(");
            }
            mErrorCallback.onError(serverError.createException(null));
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        Memetrix.log("ServerCallbak onFailure", t.getMessage());
        ServerError serverError;
        if (call.isCanceled()) {
            serverError = new ServerError(ServerError.CANCELLED, "Request cancelled by client");
        } else {
            serverError = new ServerError(ServerError.UNKNOWN, "Something went wrong :(");
        }
        mErrorCallback.onError(serverError.createException(t));
    }
}
