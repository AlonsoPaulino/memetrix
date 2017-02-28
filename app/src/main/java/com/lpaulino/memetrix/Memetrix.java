package com.lpaulino.memetrix;

import android.app.Application;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * @author Luis Alonso Paulino Flores on 3/02/17.
 */

public class Memetrix extends Application {

    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static void log(@Nullable Object body) {
        Memetrix.log("Memetrix -> ", body);
    }

    public static void log(String tag, @Nullable  Object body) {
        String message = (body != null) ? body.toString() : "null";
        if (BuildConfig.DEBUG) {
            Log.d(tag, message);
        }
    }
}
