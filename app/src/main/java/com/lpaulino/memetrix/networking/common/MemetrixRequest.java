package com.lpaulino.memetrix.networking.common;

/**
 * @author Luis Alonso Paulino Flores on 7/02/17.
 */

import com.lpaulino.memetrix.data.ErrorCallback;
import com.lpaulino.memetrix.data.SuccessCallback;

public interface MemetrixRequest<T> {

    void enqueue(SuccessCallback<T> successCallback, ErrorCallback errorCallback);

    void cancel();
}
