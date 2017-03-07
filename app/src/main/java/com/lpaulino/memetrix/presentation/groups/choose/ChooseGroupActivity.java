package com.lpaulino.memetrix.presentation.groups.choose;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.lpaulino.memetrix.R;
import com.lpaulino.memetrix.presentation.common.MemetrixActivity;

/**
 * @author Luis Alonso Paulino Flores on 7/03/17.
 */

public class ChooseGroupActivity extends MemetrixActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_group);

        ChooseGroupFragment chooseGroupFragment = (ChooseGroupFragment) findFragmentById(R.id.main_content);

        if (chooseGroupFragment == null) {
            chooseGroupFragment = ChooseGroupFragment.newInstance();
        }

        replaceFragment(chooseGroupFragment);
    }
}
