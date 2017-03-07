package com.lpaulino.memetrix.presentation.memes.add;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.lpaulino.memetrix.R;
import com.lpaulino.memetrix.presentation.common.MemetrixActivity;

/**
 * @author Luis Alonso Paulino Flores on 7/03/17.
 */

public class AddMemeActivity extends MemetrixActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meme);
        setDefaultToolbar(true, true);

        AddMemeFragment addMemeFragment = (AddMemeFragment) findFragmentById(R.id.main_content);

        if (addMemeFragment == null) {
            addMemeFragment = AddMemeFragment.newInstance();
        }

        replaceFragment(addMemeFragment);
    }
}
