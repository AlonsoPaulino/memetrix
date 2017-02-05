package com.lpaulino.memetrix.data.local;

import com.google.gson.Gson;
import com.lpaulino.memetrix.domain.User;
import com.lpaulino.memetrix.util.PreferencesUtils;
import com.lpaulino.memetrix.util.StringUtils;

/**
 * @author Luis Alonso Paulino Flores on 3/02/17.
 */

public class PreferencesHelper {

    private static final String USER_LOGGED_IN = "_USER_LOGGED_IN_";

    private PreferencesHelper() {}

    public static void setUserLoggedIn(User user) {
        String userString = new Gson().toJson(user);
        PreferencesUtils.setStringPreference(USER_LOGGED_IN, userString);
    }

    public static User getUserLoggedIn() {
        String userString = PreferencesUtils.getStringPreference(USER_LOGGED_IN);
        if (StringUtils.isEmpty(userString)) {
            return null;
        }
        return new Gson().fromJson(userString, User.class);
    }
}



