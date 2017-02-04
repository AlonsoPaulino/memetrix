package com.lpaulino.memetrix.presentation.common;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import butterknife.ButterKnife;

/**
 * @author Luis Alonso Paulino Flores on 3/02/17.
 */

public abstract class MemetrixFragment extends Fragment implements MemetrixView {

    protected Context mContext;
    protected MemetrixFragmentListener mFragmentListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
        mFragmentListener = (MemetrixFragmentListener) context;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mFragmentListener = null;
    }

    @Override
    public void showLoader() {
        if (mFragmentListener != null) {
            mFragmentListener.showLoader();
        }
    }

    @Override
    public void dismissLoader() {
        if (mFragmentListener != null) {
            mFragmentListener.dismissLoader();
        }
    }

    @Override
    public void showErrorMessage(Exception exception) {
        if (mFragmentListener != null) {
            mFragmentListener.showErrorMessage(exception);
        }
    }

    @Override
    public void showSuccessMessage(String message) {
        if (mFragmentListener != null) {
            mFragmentListener.showSuccessMessage(message);
        }
    }
}
