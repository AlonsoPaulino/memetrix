package com.lpaulino.memetrix.presentation.signin;

import com.lpaulino.memetrix.presentation.common.MemetrixViewPresenter;

/**
 * @author Luis Alonso Paulino Flores on 05/02/17.
 */

public interface SignInContract {

    interface Presenter {

        void authenticate(String email, String password);
    }

    interface View extends MemetrixViewPresenter<Presenter> {

        void userIsAuthorized();
        void userIsUnauthorized(Exception exception);
    }
}
