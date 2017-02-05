package com.lpaulino.memetrix.presentation.navigation;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lpaulino.memetrix.Constants;
import com.lpaulino.memetrix.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Luis Alonso Paulino Flores on 04/02/17.
 */

public class NavigationAdapter extends RecyclerView.Adapter<NavigationAdapter.NavigationViewHolder> {

    private NavigationItem [] mNavigationItems;
    private NavigationItem mNavigationItemSelected;
    private NavigationItemListener mNavigationItemListener;

    @Override
    public NavigationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_navigation, parent, false);
        return new NavigationViewHolder(view, mNavigationItemListener);
    }

    @Override
    public void onBindViewHolder(NavigationViewHolder holder, int position) {
        NavigationItem navigationItem = mNavigationItems[position];
        holder.itemView.setPressed(navigationItem != mNavigationItemSelected);
        if (navigationItem.getImageResource() != Constants.NO_RESOURCE) {
            holder.mItemNavigationImageView.setImageDrawable(
                    ContextCompat.getDrawable(holder.itemView.getContext(), navigationItem.getImageResource())
            );
        }
        holder.mItemNavigationTitleTextView.setText(
                holder.itemView.getContext().getString(navigationItem.getTitleResource())
        );
        holder.itemView.setTag(navigationItem);
    }

    @Override
    public int getItemCount() {
        return mNavigationItems != null ? mNavigationItems.length : 0;
    }

    static class NavigationViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_navigation_image_view) ImageView mItemNavigationImageView;
        @BindView(R.id.item_navigation_title_text_view) TextView mItemNavigationTitleTextView;

        private NavigationItemListener mNavigationItemListener;

        public NavigationViewHolder(View view, NavigationItemListener navigationItemListener) {
            super(view);
            ButterKnife.bind(this, view);
            mNavigationItemListener = navigationItemListener;
        }

        @OnClick(R.id.item_navigation_holder)
        public void onNavigationItemClicked(View item) {
            if (mNavigationItemListener != null) {
                mNavigationItemListener.onNavigationItemSelected((NavigationItem) itemView.getTag());
            }
        }
    }

    public interface NavigationItemListener {

        void onNavigationItemSelected(NavigationItem navigationItem);
    }

    public void setNavigationItems(NavigationItem [] items) {
        mNavigationItems = items;
        notifyDataSetChanged();
    }

    public void setNavigationItemSelected(NavigationItem navigationItemSelected) {
        mNavigationItemSelected = navigationItemSelected;
    }

    public void setNavigationItemListener(NavigationItemListener navigationItemListener) {
        mNavigationItemListener = navigationItemListener;
    }
}
