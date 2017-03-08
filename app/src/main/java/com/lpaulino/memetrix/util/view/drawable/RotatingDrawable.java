package com.lpaulino.memetrix.util.view.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;

/**
 * @author Luis Alonso Paulino Flores on 07/03/17.
 */

public class RotatingDrawable extends LayerDrawable {

    private float mRotationDegree;

    public RotatingDrawable(Drawable drawable) {
        super(new Drawable[] {drawable});
    }

    public float getRotationDegree() {
        return mRotationDegree;
    }

    public void setRotationDegree(float degree) {
        mRotationDegree = degree;
        invalidateSelf();
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.save();
        canvas.rotate(mRotationDegree, getBounds().centerX(), getBounds().centerY());
        super.draw(canvas);
        canvas.restore();
    }
}
