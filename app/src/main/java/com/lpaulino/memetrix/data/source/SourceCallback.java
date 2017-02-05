package com.lpaulino.memetrix.data.source;

/**
 * @author Luis Alonso Paulino Flores on 05/02/17.
 */

public interface SourceCallback<T> {

    void onSuccess(T data);

    void onFailure(Exception exception);
}
