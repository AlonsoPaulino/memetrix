package com.lpaulino.memetrix.presentation.about;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lpaulino.memetrix.R;
import com.lpaulino.memetrix.presentation.common.MemetrixFragment;

/**
 * @author Luis Alonso Paulino Flores on 3/02/17.
 */

public class AboutUsFragment extends MemetrixFragment {

    public static AboutUsFragment newInstance() {
        return new AboutUsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_about_us, container, false);
    }
}
