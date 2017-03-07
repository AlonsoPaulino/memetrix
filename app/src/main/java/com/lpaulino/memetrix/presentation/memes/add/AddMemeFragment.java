package com.lpaulino.memetrix.presentation.memes.add;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lpaulino.memetrix.R;
import com.lpaulino.memetrix.presentation.common.MemetrixFragment;

/**
 * @author Luis Alonso Paulino Flores on 7/03/17.
 */

public class AddMemeFragment extends MemetrixFragment {

    public static AddMemeFragment newInstance() {
        return new AddMemeFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_meme, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mFragmentListener.setToolbarTitle(getString(R.string.add_meme));
    }
}
