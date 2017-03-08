package com.lpaulino.memetrix.util.view.components;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.TextView;

import com.lpaulino.memetrix.R;
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
    private static final String ROTATION_PROPERTY = "rotation";

    private FloatingMenuListener mFloatingMenuListener;
    private FloatingButton mRootFloatingButton;
    private TouchGroupDelegate mTouchGroupDelegate;
    private State mState;

    private AnimatorSet mExpandAnimation;
    private AnimatorSet mCollapseAnimation;

    private int mTotalButtons;
    private int mMaxButtonWith;
    private int mMaxButtonHeight;
    private int mButtonSpacing;
    private int mLabelsMargin;
    private int mLabelsVerticalOffset;

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
        mButtonSpacing = (int) (getResources().getDimension(R.dimen.fab_actions_spacing)
                - getResources().getDimension(R.dimen.fab_shadow_radius)
                - getResources().getDimension(R.dimen.fab_shadow_offset));
        mLabelsMargin = getResources().getDimensionPixelSize(R.dimen.fab_labels_margin);
        mLabelsVerticalOffset = getResources().getDimensionPixelSize(R.dimen.fab_shadow_offset);

        mTouchGroupDelegate = new TouchGroupDelegate(new Rect(), this);
        mExpandAnimation = new AnimatorSet().setDuration(ANIMATION_DURATION);
        mCollapseAnimation = new AnimatorSet().setDuration(ANIMATION_DURATION);
        setTouchDelegate(mTouchGroupDelegate);
        setUpRootFloatingButton(context);
    }

    private void setUpRootFloatingButton(Context context) {
        mRootFloatingButton = new FloatingButton(context);
        mRootFloatingButton.setIconDrawable(
                createRootIconDrawable(context, mRootFloatingButton.getIconDrawable())
        );
        mRootFloatingButton.setSize(FloatingButton.SIZE_NORMAL);
        mRootFloatingButton.setOnClickListener(v -> toogle());
        addView(mRootFloatingButton, super.generateDefaultLayoutParams());
        ++mTotalButtons;
    }

    private Drawable createRootIconDrawable(Context context, @NonNull Drawable drawable) {
        final RotatingDrawable rotatingDrawable = new RotatingDrawable(drawable);
        final OvershootInterpolator interpolator = new OvershootInterpolator();

        final ObjectAnimator collapseAnimator = ObjectAnimator.ofFloat(rotatingDrawable, ROTATION_PROPERTY, EXPANDED_ROTATION, COLLAPSED_ROTATION);
        final ObjectAnimator expandAnimator = ObjectAnimator.ofFloat(rotatingDrawable, ROTATION_PROPERTY, COLLAPSED_ROTATION, EXPANDED_ROTATION);

        collapseAnimator.setInterpolator(interpolator);
        expandAnimator.setInterpolator(interpolator);

        mExpandAnimation.play(expandAnimator);
        mCollapseAnimation.play(expandAnimator);

        return rotatingDrawable;
    }

    public void setFloatingMenuListener(FloatingMenuListener listener) {
        mFloatingMenuListener = listener;
    }

    public void addButton(FloatingButton button) {
        addView(button, mTotalButtons);
        ++mTotalButtons;
    }

    public void removeButton(FloatingButton button) {
        removeView(button);
        --mTotalButtons;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        measureChildren(widthMeasureSpec, heightMeasureSpec);

        int width, height = 0, maxLabelWith = 0;
        mMaxButtonWith = mMaxButtonHeight = 0;

        for (int i = 0; i < mTotalButtons; ++i) {
            View child = getChildAt(i);

            if (child.getVisibility() == GONE) {
                continue;
            }

            mMaxButtonWith = Math.max(mMaxButtonWith, child.getMeasuredWidth());
            height += child.getMeasuredHeight();

            TextView label = (TextView) child.getTag();
            if (label != null) {
                maxLabelWith = Math.max(maxLabelWith, label.getMeasuredWidth());
            }
        }

        width = mMaxButtonWith + (maxLabelWith > 0 ? maxLabelWith + mLabelsMargin : 0);
        height += mButtonSpacing * (mTotalButtons - 1);
        height = height * 12 / 10;

        setMeasuredDimension(width, height);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        if (changed) {
            mTouchGroupDelegate.clearTouchDelegates();
        }

        int addButtonY = bottom - top - mRootFloatingButton.getMeasuredHeight();
        int buttonsHorizontalCenter = right - left - mMaxButtonWith / 2;
        int addButtonLeft = buttonsHorizontalCenter - mRootFloatingButton.getMeasuredWidth() / 2;

        mRootFloatingButton.layout(addButtonLeft,
                addButtonY,
                addButtonLeft + mRootFloatingButton.getMeasuredWidth(),
                addButtonY + mRootFloatingButton.getMeasuredHeight()
        );

        int labelsOffset = mMaxButtonWith / 2 + mLabelsMargin;
        int labelsXNearButton = buttonsHorizontalCenter - labelsOffset;
        int nextY = addButtonY - mButtonSpacing;

        for (int i = mTotalButtons - 1; i >= 0; --i) {
            final View child = getChildAt(i);

            if (child == mRootFloatingButton || child.getVisibility() == GONE) {
                continue;
            }

            int childX = buttonsHorizontalCenter - child.getMeasuredWidth() / 2;

        }
    }

    public void toogle() {

    }
}
