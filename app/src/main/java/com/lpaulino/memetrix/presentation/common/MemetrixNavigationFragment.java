package com.lpaulino.memetrix.presentation.common;

import android.content.Context;

/**
 * @author Luis Alonso Paulino Flores on 3/02/17.
 */

public abstract class MemetrixNavigationFragment extends MemetrixFragment {

    protected MemetrixNavigationListener mNavigationListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mNavigationListener = (MemetrixNavigationListener) context;
    }
}
