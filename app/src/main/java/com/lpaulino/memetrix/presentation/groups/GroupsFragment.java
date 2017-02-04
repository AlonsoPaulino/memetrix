package com.lpaulino.memetrix.presentation.groups;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lpaulino.memetrix.Memetrix;
import com.lpaulino.memetrix.R;
import com.lpaulino.memetrix.domain.Group;
import com.lpaulino.memetrix.presentation.common.MemetrixFragment;

import butterknife.BindView;

/**
 * @author Luis Alonso Paulino Flores on 3/02/17.
 */

public class GroupsFragment extends MemetrixFragment implements GroupsAdapter.GroupListener {

    @BindView(R.id.groups_recycler_view) RecyclerView mMemesRecyclerView;

    private GroupsAdapter mGroupsAdapter;

    public static GroupsFragment newInstance() {
        return new GroupsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_groups, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mGroupsAdapter = new GroupsAdapter();
        mGroupsAdapter.setGroupListener(this);
        mMemesRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mMemesRecyclerView.setAdapter(mGroupsAdapter);
        mGroupsAdapter.setGroups(Group.mocks());
    }

    @Override
    public void onGroupSelected(int position) {
        Memetrix.log("Group selected at position -> " + position);
    }
}
