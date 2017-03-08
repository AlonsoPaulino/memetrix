package com.lpaulino.memetrix.util.view.events;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;

/**
 * @author Luis Alonso Paulino Flores on 07/03/17.
 */

public class TouchGroupDelegate extends TouchDelegate {

    public TouchGroupDelegate(Rect bounds, View delegateView) {
        super(bounds, delegateView);
    }
}
