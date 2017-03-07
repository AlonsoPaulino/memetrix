package com.lpaulino.memetrix.presentation.signup;

import com.lpaulino.memetrix.presentation.common.MemetrixViewPresenter;

/**
 * @author Luis Alonso Paulino Flores on 7/03/17.
 */

public interface SignUpContract {

    interface Presenter {

        void register(String email, String firstName, String lastName, String password);
    }

    interface View extends MemetrixViewPresenter<Presenter> {

        void navigateToMainScreen();
    }
}
