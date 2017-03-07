package com.lpaulino.memetrix.presentation.memes;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;

import com.lpaulino.memetrix.R;
import com.lpaulino.memetrix.presentation.memes.add.AddMemeActivity;
import com.lpaulino.memetrix.presentation.memes.create.CreateMemeActivity;
import com.lpaulino.memetrix.presentation.navigation.NavigationActivity;
import com.lpaulino.memetrix.presentation.navigation.NavigationItem;

import butterknife.OnClick;

/**
 * @author Luis Alonso Paulino Flores on 3/02/17.
 */

public class MemesActivity extends NavigationActivity {

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
    }

     @OnClick(R.id.add_meme_button)
     public void onAddMemeButtonClicked(FloatingActionButton floatingActionButton) {
         AlertDialog alert = new AlertDialog.Builder(this)
                 .setMessage(R.string.add_meme_options)
                 .setCancelable(true)
                 .setPositiveButton(R.string.pick_existing_meme, (dialog, which) -> {
                     startActivity(new Intent(MemesActivity.this, AddMemeActivity.class));
                 })
                 .setNegativeButton(R.string.create_meme, (dialog, which) -> {
                     startActivity(new Intent(MemesActivity.this, CreateMemeActivity.class));
                 })
                 .create();
         alert.show();
     }
}
