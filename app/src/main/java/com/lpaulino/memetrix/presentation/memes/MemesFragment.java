package com.lpaulino.memetrix.presentation.memes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lpaulino.memetrix.Memetrix;
import com.lpaulino.memetrix.R;
import com.lpaulino.memetrix.domain.Meme;
import com.lpaulino.memetrix.presentation.common.MemetrixFragment;

import butterknife.BindView;

/**
 * @author Luis Alonso Paulino Flores on 3/02/17.
 */

public class MemesFragment extends MemetrixFragment implements MemesAdapter.MemesListener {

    @BindView(R.id.memes_recycler_view) RecyclerView mMemesRecyclerView;

    private MemesAdapter mMemesAdapter;

    public static MemesFragment newInstance() {
        return new MemesFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_memes, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mMemesAdapter = new MemesAdapter();
        mMemesAdapter.setMemesListener(this);
        mMemesAdapter.setMemes(Meme.mocks());
        mMemesRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mMemesRecyclerView.setAdapter(mMemesAdapter);
    }

    @Override
    public void onMemeSelected(int position) {
        Memetrix.log("Meme selected at position -> " + position);
    }
}
