package com.lpaulino.memetrix.presentation.about;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.lpaulino.memetrix.R;
import com.lpaulino.memetrix.presentation.navigation.NavigationActivity;
import com.lpaulino.memetrix.presentation.navigation.NavigationItem;

/**
 * @author Luis Alonso Paulino Flores on 3/02/17.
 */

public class AboutUsActivity extends NavigationActivity {

    @Override
    protected NavigationItem getCurrentNavigationItem() {
        return NavigationItem.ABOUT_US;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AboutUsFragment aboutUsFragment = (AboutUsFragment) findFragmentById(R.id.main_content);

        if (aboutUsFragment == null) {
            aboutUsFragment = AboutUsFragment.newInstance();
        }

        replaceFragment(aboutUsFragment);
    }
}
