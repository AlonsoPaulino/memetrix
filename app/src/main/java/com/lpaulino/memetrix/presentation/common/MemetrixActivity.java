package com.lpaulino.memetrix.presentation.common;

import android.app.ProgressDialog;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.lpaulino.memetrix.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Luis Alonso Paulino Flores on 3/02/17.
 */

public abstract class MemetrixActivity extends AppCompatActivity implements MemetrixFragmentListener {

    private ProgressDialog mProgressDialog;
    @NonNull @BindView(R.id.root_view) protected View mRootView;
    @Nullable @BindView(R.id.toolbar) protected Toolbar mToolbar;

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }

    @Override
    public void replaceFragment(Fragment fragment) {
        replaceFragment(fragment, false);
    }

    @Override
    public void replaceFragment(Fragment fragment, boolean addToBackStack) {
        replaceFragment(R.id.main_content, fragment, addToBackStack);
    }

    @Override
    public void replaceFragment(int frameId, Fragment fragment) {
        replaceFragment(frameId, fragment, false);
    }

    @Override
    public void replaceFragment(int frameId, Fragment fragment, boolean addToBackStack) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(frameId, fragment, null);
        if (addToBackStack) {
            transaction.addToBackStack(fragment.getClass().getSimpleName());
        }
        transaction.commit();
    }

    @Override
    public void showLoader() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setMessage(getString(R.string.loading));
        }
        if (!mProgressDialog.isShowing()) {
            mProgressDialog.show();
        }
    }

    @Override
    public void dismissLoader() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void setDefaultToolbar() {
        setDefaultToolbar(false);
    }

    @Override
    public void setDefaultToolbar(boolean homeEnabled) {
        setCustomToolbar(mToolbar, homeEnabled, true);
    }

    @Override
    public void setDefaultToolbar(boolean homeEnabled, boolean backActionEnabled) {
        setCustomToolbar(mToolbar, homeEnabled, backActionEnabled);
    }

    @Override
    public void setCustomToolbar(Toolbar toolbar) {
        setCustomToolbar(toolbar, true);
    }

    @Override
    public void setCustomToolbar(Toolbar toolbar, boolean homeButtonEnabled) {
        setCustomToolbar(toolbar, homeButtonEnabled, true);
    }

    @Override
    public void setCustomToolbar(Toolbar toolbar, boolean homeButtonEnabled, boolean backActionEnabled) {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(homeButtonEnabled);
            actionBar.setDisplayShowHomeEnabled(homeButtonEnabled);
            if (homeButtonEnabled && backActionEnabled) {
                toolbar.setNavigationOnClickListener(view -> onBackPressed());
            }
        }
    }

    @Override
    public void setToolbarTitle(String title) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setTitle(title);
        }
    }

    @Override
    public void showErrorMessage(Exception exception) {
        String message = (exception != null) ? exception.getMessage() : null;
        if (message == null) {
            message = getString(R.string.message_error_default);
        }
        Snackbar.make(mRootView, message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showSuccessMessage(String message) {
        if (message == null) {
            message = getString(R.string.message_success_default);
        }
        Snackbar.make(mRootView, message, Snackbar.LENGTH_LONG).show();
    }

    protected Fragment findFragmentById(int id) {
        return getSupportFragmentManager().findFragmentById(id);
    }

    protected Fragment findFragmentByTag(String tag) {
        return getSupportFragmentManager().findFragmentByTag(tag);
    }

    @Override
    public void dismissActivity() {
        finish();
    }
}
