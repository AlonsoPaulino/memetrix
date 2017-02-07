package com.lpaulino.memetrix.networking;

import android.support.annotation.NonNull;

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
            if (response.errorBody() != null) {
                //TODO: handle error messages and code status
            }
            mErrorCallback.onError(new Exception("Server error, something went wrong :("));
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        Memetrix.log("ServerCallbak onFailure", t.getMessage());
        if (call.isCanceled()) {
            mErrorCallback.onError(new Exception("Request cancelled by client", t));
        } else {
            mErrorCallback.onError(new Exception("Unknown error", t));
        }
    }
}
