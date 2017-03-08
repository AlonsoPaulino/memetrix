package com.lpaulino.memetrix.util.view.components;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageButton;

/**
 * @author Luis Alonso Paulino Flores on 07/03/17.
 */

public class FloatingButton extends ImageButton {

    public FloatingButton(Context context) {
        super(context);
    }

    public FloatingButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setUpView(context, attrs);
    }

    public FloatingButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setUpView(context, attrs);
    }

    private void setUpView(Context context, AttributeSet attrs) {

    }

    public void setIconDrawable(Drawable drawable) {

    }

    public Drawable getIconDrawable() {
        return null;
    }
}
