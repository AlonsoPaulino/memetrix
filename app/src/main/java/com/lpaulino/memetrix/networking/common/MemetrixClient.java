package com.lpaulino.memetrix.networking.common;

/**
 * @author Luis Alonso Paulino Flores on 28/02/17.
 */

public interface MemetrixClient {

    <T> T provideApi(final Class<T> clazz);
}
