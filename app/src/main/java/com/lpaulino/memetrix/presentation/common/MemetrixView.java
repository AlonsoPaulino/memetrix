package com.lpaulino.memetrix.presentation.common;

/**
 * @author Luis Alonso Paulino Flores on 3/02/17.
 */

public interface MemetrixView {

    void showLoader();

    void dismissLoader();

    void showErrorMessage(Exception exception);

    void showSuccessMessage(String message);

}
