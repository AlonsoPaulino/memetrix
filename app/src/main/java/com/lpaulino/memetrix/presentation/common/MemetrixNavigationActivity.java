package com.lpaulino.memetrix.presentation.common;

import android.support.annotation.NonNull;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;

import com.lpaulino.memetrix.R;

import butterknife.BindView;

/**
 * @author Luis Alonso Paulino Flores on 3/02/17.
 */

public abstract class MemetrixNavigationActivity extends MemetrixActivity implements MemetrixNavigationListener {

    @NonNull @BindView(R.id.drawer_layout) protected DrawerLayout mDrawerLayout;

    @Override
    public void onNavigationStart() {
        mDrawerLayout.closeDrawer(GravityCompat.START, true);
    }

    @Override
    public void onNavigationFinish() {
        finish();
    }
}
