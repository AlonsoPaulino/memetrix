package com.lpaulino.memetrix.presentation.navigation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;

import com.lpaulino.memetrix.R;
import com.lpaulino.memetrix.presentation.common.MemetrixNavigationActivity;

/**
 * @author Luis Alonso Paulino Flores on 3/02/17.
 */

public abstract class NavigationActivity extends MemetrixNavigationActivity {

    protected abstract NavigationItem getCurrentNavigationItem();

    protected int getNavigationLayout() {
        return R.layout.activity_navigation;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getNavigationLayout());
        setDefaultToolbar(true, false);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white);
        }

        NavigationFragment navigationFragment = (NavigationFragment) findFragmentById(R.id.navigation_content);

        if (navigationFragment == null) {
            navigationFragment = NavigationFragment.newInstance(getCurrentNavigationItem());
        }

        replaceFragment(R.id.navigation_content, navigationFragment);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            mDrawerLayout.openDrawer(GravityCompat.START);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
