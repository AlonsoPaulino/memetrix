package com.lpaulino.memetrix.presentation.navigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.lpaulino.memetrix.R;
import com.lpaulino.memetrix.data.local.PreferencesHelper;
import com.lpaulino.memetrix.presentation.about.AboutUsActivity;
import com.lpaulino.memetrix.presentation.signin.SignInActivity;
import com.lpaulino.memetrix.presentation.common.MemetrixNavigationFragment;
import com.lpaulino.memetrix.presentation.groups.GroupsActivity;
import com.lpaulino.memetrix.presentation.memes.MemesActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.OnClick;

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
    }

    @Override
    public void onNavigationItemSelected(NavigationItem navigationItem) {
        mNavigationListener.closeDrawer();
        if (!navigationItem.getDestiny().equals(getActivity().getClass())) {
            Intent intent = new Intent(mContext, navigationItem.getDestiny());
            startActivity(intent);
            mFragmentListener.dismissActivity();
        }
    }
}
