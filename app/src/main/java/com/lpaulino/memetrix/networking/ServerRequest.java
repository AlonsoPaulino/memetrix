package com.lpaulino.memetrix.networking;

import android.support.annotation.NonNull;

import com.lpaulino.memetrix.data.ErrorCallback;
import com.lpaulino.memetrix.data.SuccessCallback;
import com.lpaulino.memetrix.networking.common.MemetrixRequest;

import retrofit2.Call;

/**
 * @author Luis Alonso Paulino Flores on 7/02/17.
 */

public class ServerRequest<T> implements MemetrixRequest<T> {

    private Call<T> mCall;

    public ServerRequest(@NonNull Call<T> call) {
        mCall = call;
    }

    @Override
    public void enqueue(@NonNull SuccessCallback<T> successCallback, @NonNull ErrorCallback errorCallback) {
        mCall.enqueue(new ServerCallback<>(successCallback, errorCallback));
    }

    @Override
    public void cancel() {
        mCall.cancel();
    }
}
