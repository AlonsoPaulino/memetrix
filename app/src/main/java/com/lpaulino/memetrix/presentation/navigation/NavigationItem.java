package com.lpaulino.memetrix.presentation.navigation;

import com.lpaulino.memetrix.Constants;
import com.lpaulino.memetrix.R;
import com.lpaulino.memetrix.presentation.about.AboutUsActivity;
import com.lpaulino.memetrix.presentation.groups.GroupsActivity;
import com.lpaulino.memetrix.presentation.memes.MemesActivity;
import com.lpaulino.memetrix.presentation.signin.SignInActivity;

/**
 * @author Luis Alonso Paulino Flores on 3/02/17.
 */

public enum NavigationItem {

    MY_MEMES(R.string.menu_memes, Constants.NO_RESOURCE, MemesActivity.class),

    MY_GROUPS(R.string.menu_my_groups, Constants.NO_RESOURCE, GroupsActivity.class),

    FAVORITES(R.string.menu_favorites, Constants.NO_RESOURCE, MemesActivity.class),

    ABOUT_US(R.string.menu_about_us, Constants.NO_RESOURCE, AboutUsActivity.class),

    LOGOUT(R.string.menu_about_us, Constants.NO_RESOURCE, SignInActivity.class);

    private int mTitleResource;
    private int mImageResource;
    private Class mDestiny;

    NavigationItem(int titleResource, int imageResource, Class destiny) {
        mTitleResource = titleResource;
        mImageResource = imageResource;
        mDestiny = destiny;
    }

    public int getTitleResource() {
        return mTitleResource;
    }

    public int getImageResource() {
        return mImageResource;
    }

    public Class getDestiny() {
        return mDestiny;
    }
}
