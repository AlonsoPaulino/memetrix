package com.lpaulino.memetrix.util.view.components;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;

import com.lpaulino.memetrix.util.view.drawable.RotatingDrawable;
import com.lpaulino.memetrix.util.view.events.TouchGroupDelegate;

/**
 * @author Luis Alonso Paulino Flores on 07/03/17.
 */

public class FloatingMenu extends ViewGroup {

    enum State {
        OPENED,
        COLLAPSED
    }

    public interface FloatingMenuListener {
        void onMenuOpened();
        void onMenuCollapsed();
    }

    private static final int ANIMATION_DURATION = 300;
    private static final float COLLAPSED_ROTATION = 0f;
    private static final float EXPANDED_ROTATION = 90f + 45f;

    private FloatingMenuListener mFloatingMenuListener;
    private FloatingButton mRootFloatingButton;
    private TouchGroupDelegate mGroupDelegate;
    private State mState;

    private AnimatorSet mExpandAnimation;
    private AnimatorSet mCollapseAnimation;


    public FloatingMenu(Context context) {
        super(context);
    }

    public FloatingMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
        setUpView(context, attrs);
    }

    public FloatingMenu(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setUpView(context, attrs);
    }

    private void setUpView(Context context, AttributeSet attrs) {
        mGroupDelegate = new TouchGroupDelegate(new Rect(), this);
        mExpandAnimation = new AnimatorSet().setDuration(ANIMATION_DURATION);
        mCollapseAnimation = new AnimatorSet().setDuration(ANIMATION_DURATION);
        setTouchDelegate(mGroupDelegate);
        setUpRootFloatingButton(context);
    }

    private void setUpRootFloatingButton(Context context) {
        mRootFloatingButton = new FloatingButton(context);
        mRootFloatingButton.setIconDrawable(
                createRootIconDrawable(context, mRootFloatingButton.getIconDrawable())
        );
    }

    private Drawable createRootIconDrawable(Context context, @NonNull Drawable drawable) {
        final RotatingDrawable rotatingDrawable = new RotatingDrawable(drawable);
        final OvershootInterpolator interpolator = new OvershootInterpolator();

        final ObjectAnimator collapseAnimator = ObjectAnimator.ofFloat(rotatingDrawable, "rotation", EXPANDED_ROTATION, COLLAPSED_ROTATION);
        final ObjectAnimator expandAnimator = ObjectAnimator.ofFloat(rotatingDrawable, "rotation", COLLAPSED_ROTATION, EXPANDED_ROTATION);

        collapseAnimator.setInterpolator(interpolator);
        expandAnimator.setInterpolator(interpolator);

        mExpandAnimation.play(expandAnimator);
        mCollapseAnimation.play(expandAnimator);

        return rotatingDrawable;
    }

    public void setFloatingMenuListener(FloatingMenuListener listener) {
        mFloatingMenuListener = listener;
    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {

    }
}
