package com.lpaulino.memetrix.presentation.groups;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lpaulino.memetrix.R;
import com.lpaulino.memetrix.domain.Group;
import com.lpaulino.memetrix.util.media.ImageFactory;
import com.lpaulino.memetrix.util.media.loaders.GlideLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Luis Alonso Paulino Flores on 3/02/17.
 */

public class GroupsAdapter extends RecyclerView.Adapter<GroupsAdapter.GroupViewHolder> {

    private List<Group> mGroups;
    private GroupListener mGroupListener;

    @Override
    public GroupViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_group, parent, false);
        return new GroupViewHolder(view, mGroupListener);
    }

    @Override
    public void onBindViewHolder(GroupViewHolder holder, int position) {
        Group group = mGroups.get(position);
        holder.mGroupNameTextView.setText(group.getName());
        holder.mGroupMemebersTextView.setText(String.valueOf(group.getMembers()));
        ImageFactory.createImageLoader().loadWebImage(group.getImage(), holder.mGroupImageView);
    }

    @Override
    public int getItemCount() {
        return (mGroups != null) ? mGroups.size() : 0;
    }

    static class GroupViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.group_name) TextView mGroupNameTextView;
        @BindView(R.id.group_image) ImageView mGroupImageView;
        @BindView(R.id.group_members) TextView mGroupMemebersTextView;

        private GroupListener mGroupListener;

        public GroupViewHolder(View view, GroupListener groupListener) {
            super(view);
            ButterKnife.bind(this, view);
            mGroupListener = groupListener;
        }

        @OnClick(R.id.group_holder)
        public void onGroupItemClicked(View item) {
            if (mGroupListener != null) {
                mGroupListener.onGroupSelected(getLayoutPosition());
            }
        }
    }

    public interface GroupListener {
        void onGroupSelected(int position);
    }

    public void setGroups(List<Group> grous) {
        if (mGroups == null) {
            mGroups = new ArrayList<>();
        } else {
            mGroups.clear();
        }
        if (grous != null) {
            mGroups.addAll(grous);
        }
        notifyDataSetChanged();
    }

    public void setGroupListener(GroupListener groupListener) {
        mGroupListener = groupListener;
    }
}
