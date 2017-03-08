package com.lpaulino.memetrix.util.view.components;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageButton;

/**
 * @author Luis Alonso Paulino Flores on 07/03/17.
 */

public class FloatingButton extends ImageButton {

    public static final int SIZE_NORMAL = 0;
    public static final int SIZE_MINI = 1;

    private int mSize;

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

    private void setUpCircleSize() {

    }

    private void setUpDrawableSize() {

    }

    private void setUpBackground() {

    }

    public void setIconDrawable(Drawable drawable) {

    }

    public void setSize(int size) {
        if (size != SIZE_NORMAL && size != SIZE_MINI) {
            throw new IllegalArgumentException("User SIZE_NORMAL or SIZE_MINI constants defined for FloatingButton");
        }

        if (mSize != size) {
            mSize = size;
            setUpCircleSize();
            setUpDrawableSize();
            setUpBackground();
        }
    }

    public int getSize() {
        return mSize;
    }

    public Drawable getIconDrawable() {
        return null;
    }
}
