package com.lpaulino.memetrix.presentation.memes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;

import com.lpaulino.memetrix.R;
import com.lpaulino.memetrix.presentation.navigation.NavigationActivity;
import com.lpaulino.memetrix.presentation.navigation.NavigationItem;

import butterknife.BindView;

/**
 * @author Luis Alonso Paulino Flores on 3/02/17.
 */

public class MemesActivity extends NavigationActivity {

    @BindView(R.id.add_meme_button) FloatingActionButton mAddMemeFloatingActionButton;

    @Override
    protected NavigationItem getCurrentNavigationItem() {
        return NavigationItem.MY_MEMES;
    }

    @Override
    protected int getNavigationLayout() {
        return R.layout.activity_memes;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MemesFragment memesFragment = (MemesFragment) findFragmentById(R.id.main_content);

        if (memesFragment == null) {
            memesFragment = MemesFragment.newInstance();
        }

        replaceFragment(R.id.main_content, memesFragment);

        mAddMemeFloatingActionButton.setOnClickListener(v -> {
            //TODO: Add meme
        });
    }
}
