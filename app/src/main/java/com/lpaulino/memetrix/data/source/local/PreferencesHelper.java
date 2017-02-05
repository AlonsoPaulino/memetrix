package com.lpaulino.memetrix.data.source.local;

import com.lpaulino.memetrix.util.PreferencesUtils;

/**
 * @author Luis Alonso Paulino Flores on 3/02/17.
 */

public class PreferencesHelper {

    private static final String USER_LOGGED_IN = "_USER_LOGGED_IN_";

    private PreferencesHelper() {}

    public static void setUserLoggedIn(String userLoggedIn) {
        PreferencesUtils.setStringPreference(USER_LOGGED_IN, userLoggedIn);
    }

    public static String getUserLoggedIn() {
        return PreferencesUtils.getStringPreference(USER_LOGGED_IN);
    }
}



