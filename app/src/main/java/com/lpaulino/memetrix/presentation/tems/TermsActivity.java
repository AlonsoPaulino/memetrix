package com.lpaulino.memetrix.presentation.tems;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.lpaulino.memetrix.R;
import com.lpaulino.memetrix.presentation.common.MemetrixActivity;

/**
 * @author Luis Alonso Paulino Flores on 7/03/17.
 */

public class TermsActivity extends MemetrixActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms);
        setDefaultToolbar(true, true);

        TermsFragment termsFragment = (TermsFragment) findFragmentById(R.id.main_content);

        if (termsFragment == null) {
            termsFragment = TermsFragment.newInstance();
        }

        replaceFragment(termsFragment);
    }
}
