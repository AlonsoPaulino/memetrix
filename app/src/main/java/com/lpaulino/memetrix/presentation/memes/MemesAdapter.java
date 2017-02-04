package com.lpaulino.memetrix.presentation.memes;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lpaulino.memetrix.R;
import com.lpaulino.memetrix.domain.Meme;
import com.lpaulino.memetrix.util.ImageUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Luis Alonso Paulino Flores on 3/02/17.
 */

public class MemesAdapter extends RecyclerView.Adapter<MemesAdapter.MemeViewHolder> {

    private List<Meme> mMemes;
    private MemesListener mMemesListener;

    @Override
    public MemeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_meme, parent, false);
        return new MemeViewHolder(view, mMemesListener);
    }

    @Override
    public void onBindViewHolder(MemeViewHolder holder, int position) {
        Meme meme = mMemes.get(position);
        holder.mMemeDescriptionTextView.setText(meme.getDescription());
        holder.mMemeGroupTextView.setText(meme.getGroup().getName());
        holder.mMemeTitleTextView.setText(meme.getTitle());
        ImageUtils.loadImage(holder.itemView.getContext(), meme.getImage(), holder.mMemeImageView);
    }

    @Override
    public int getItemCount() {
        return (mMemes != null) ? mMemes.size() : 0;
    }

    static class MemeViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.meme_title) TextView mMemeTitleTextView;
        @BindView(R.id.meme_description) TextView mMemeDescriptionTextView;
        @BindView(R.id.meme_group) TextView mMemeGroupTextView;
        @BindView(R.id.meme_image) ImageView mMemeImageView;

        private MemesListener mMemesListener;

        MemeViewHolder(View view, MemesListener memesListener) {
            super(view);
            mMemesListener = memesListener;
            ButterKnife.bind(this, view);
        }

        @OnClick(R.id.meme_holder)
        public void onMemeItemClicked(View item) {
            if (mMemesListener != null) {
                mMemesListener.onMemeSelected(getLayoutPosition());
            }
        }
    }

    public interface MemesListener {
        void onMemeSelected(int position);
    }

    public void setMemes(List<Meme> memes) {
        if (mMemes == null) {
            mMemes = new ArrayList<>();
        } else {
            mMemes.clear();
        }
        if (memes != null) {
            mMemes.addAll(memes);
        }
        notifyDataSetChanged();
    }

    public void setMemesListener(MemesListener memesListener) {
        mMemesListener = memesListener;
        notifyDataSetChanged();
    }
}
