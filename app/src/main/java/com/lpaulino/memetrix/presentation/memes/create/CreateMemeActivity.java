package com.lpaulino.memetrix.presentation.memes.create;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.lpaulino.memetrix.R;
import com.lpaulino.memetrix.presentation.common.MemetrixActivity;

/**
 * @author Luis Alonso Paulino Flores on 7/03/17.
 */

public class CreateMemeActivity extends MemetrixActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_meme);

        CreateMemeFragment createMemeFragment = (CreateMemeFragment) findFragmentById(R.id.main_content);

        if (createMemeFragment == null) {
            createMemeFragment = CreateMemeFragment.newInstance();
        }

        replaceFragment(createMemeFragment);
    }
}
