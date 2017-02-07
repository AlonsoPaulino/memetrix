package com.lpaulino.memetrix.networking.common;

import com.lpaulino.memetrix.data.ErrorCallback;
import com.lpaulino.memetrix.data.SuccessCallback;
import com.lpaulino.memetrix.networking.ServerRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Luis Alonso Paulino Flores on 7/02/17.
 */

public abstract class MemetrixService {

    private List<ServerRequest> mServerRequests;

    protected <T> void enqueue(final ServerRequest<T> serverRequest, final SuccessCallback<T> successCallback, final ErrorCallback errorCallback) {
        if (mServerRequests == null) {
            mServerRequests = new ArrayList<>();
        }
        mServerRequests.add(serverRequest);
        serverRequest.enqueue(data -> {
            dequeue(serverRequest);
            successCallback.onSuccess(data);
        }, exception -> {
            dequeue(serverRequest);
            errorCallback.onError(exception);
        });
    }

    protected void dequeue(ServerRequest serverRequest) {
        if (mServerRequests != null) {
            mServerRequests.remove(serverRequest);
        }
    }

    protected void cancellAll() {
        if (mServerRequests != null && !mServerRequests.isEmpty()) {
            for (ServerRequest request : mServerRequests) {
                request.cancel();
            }
            mServerRequests.clear();
        }
    }
}
