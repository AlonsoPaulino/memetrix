package com.lpaulino.memetrix.presentation.navigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.lpaulino.memetrix.R;
import com.lpaulino.memetrix.data.local.PreferencesHelper;
import com.lpaulino.memetrix.presentation.about.AboutUsActivity;
import com.lpaulino.memetrix.presentation.auth.AuthenticationActivity;
import com.lpaulino.memetrix.presentation.common.MemetrixNavigationFragment;
import com.lpaulino.memetrix.presentation.groups.GroupsActivity;
import com.lpaulino.memetrix.presentation.memes.MemesActivity;

import java.util.List;

import butterknife.BindViews;
import butterknife.OnClick;

/**
 * @author Luis Alonso Paulino Flores on 3/02/17.
 */

public class NavigationFragment extends MemetrixNavigationFragment {

    private static final String ARG_NAVIGATION_ITEM = "_NAVIGATION_ITEM_";

    @BindViews({R.id.memes_button, R.id.my_grous_button, R.id.my_favorites_button, R.id.about_us_button, R.id.logout_button}) List<Button> mNavigationItems;

    public static NavigationFragment newInstance(NavigationItem item) {
        Bundle bundle = new Bundle();
        bundle.putString(ARG_NAVIGATION_ITEM, item.name());
        NavigationFragment fragment = new NavigationFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_navigation, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NavigationItem navigationItem = NavigationItem.valueOf(getArguments().getString(ARG_NAVIGATION_ITEM));
        int selected = navigationItem.ordinal();
        mNavigationItems.get(selected).setEnabled(false);
    }

    @OnClick({R.id.about_us_button, R.id.memes_button, R.id.my_grous_button, R.id.my_favorites_button, R.id.logout_button})
    public void onNavigationItemClicked(Button aboutUsButton) {
        Class destiny = null;
        switch (aboutUsButton.getId()) {
            case R.id.about_us_button: destiny = AboutUsActivity.class;
                break;
            case R.id.memes_button: destiny = MemesActivity.class;
                break;
            case R.id.my_grous_button: destiny = GroupsActivity.class;
                break;
            case R.id.my_favorites_button: destiny = MemesActivity.class;
                break;
            case R.id.logout_button: destiny = AuthenticationActivity.class;
                PreferencesHelper.setUserLoggedIn(null);
                break;
        }
        if (destiny != null) {
            mNavigationListener.onNavigationStart();
            Intent intent = new Intent(mContext, destiny);
            startActivity(intent);
            mNavigationListener.onNavigationFinish();
        }
    }
}
