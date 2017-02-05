package com.lpaulino.memetrix.presentation.common;

/**
 * @author Luis Alonso Paulino Flores on 05/02/17.
 */

public interface MemetrixViewPresenter<T> extends MemetrixView {

    void setPresenter(T presenter);
}
