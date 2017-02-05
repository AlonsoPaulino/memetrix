package com.lpaulino.memetrix.presentation.navigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lpaulino.memetrix.Constants;
import com.lpaulino.memetrix.R;
import com.lpaulino.memetrix.data.local.PreferencesHelper;
import com.lpaulino.memetrix.domain.User;
import com.lpaulino.memetrix.presentation.common.MemetrixNavigationFragment;
import com.lpaulino.memetrix.util.media.ImageFactory;
import com.lpaulino.memetrix.util.media.loaders.ImageLoader;

import butterknife.BindView;

/**
 * @author Luis Alonso Paulino Flores on 3/02/17.
 */

public class NavigationFragment extends MemetrixNavigationFragment implements NavigationAdapter.NavigationItemListener {

    private static final String ARG_NAVIGATION_ITEM = "_NAVIGATION_ITEM_";

    @BindView(R.id.profile_image_view) ImageView mProfileImageView;
    @BindView(R.id.user_text_view) TextView mUserTextView;
    @BindView(R.id.email_text_view) TextView mEmailTextView;
    @BindView(R.id.navigation_recycler_view) RecyclerView mNavigationRecyclerView;

    private NavigationAdapter mNavigationAdapter;

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

        NavigationItem navigationItemSelected = NavigationItem.valueOf(getArguments().getString(ARG_NAVIGATION_ITEM));
        mNavigationAdapter = new NavigationAdapter();
        mNavigationAdapter.setNavigationItemListener(this);
        mNavigationAdapter.setNavigationItems(NavigationItem.values());
        mNavigationAdapter.setNavigationItemSelected(navigationItemSelected);
        mNavigationRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mNavigationRecyclerView.setNestedScrollingEnabled(false);
        mNavigationRecyclerView.setAdapter(mNavigationAdapter);

        User user = PreferencesHelper.getUserLoggedIn();
        if (user != null) {
            ImageFactory.createImageLoader().loadWebImage(user.getProfileImage(),
                    mProfileImageView, Constants.NO_RESOURCE, ImageLoader.Transformation.CIRCLE);
        }
    }

    @Override
    public void onNavigationItemSelected(NavigationItem navigationItem) {
        mNavigationListener.closeDrawer();
        Class currentActivity = getActivity().getClass();
        Class destiny = navigationItem.getDestiny();
        if (!currentActivity.equals(destiny)) {
            Intent intent = new Intent(mContext, destiny);
            startActivity(intent);
            if (navigationItem == NavigationItem.LOGOUT) {
                PreferencesHelper.setUserLoggedIn(null);
            }
            mFragmentListener.dismissActivity();
        }
    }
}
