package com.lpaulino.memetrix.util.view.events;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Luis Alonso Paulino Flores on 07/03/17.
 */

public class TouchGroupDelegate extends TouchDelegate {

    private List<TouchDelegate> mTouchDelegates;
    private TouchDelegate mCurrentTouchDelegate;
    private boolean mEnabled;

    public TouchGroupDelegate(Rect bounds, View delegateView) {
        super(bounds, delegateView);
    }

    public void addTouchDelegate(TouchDelegate touchDelegate) {
        if (mTouchDelegates == null) {
            mTouchDelegates = new ArrayList<>();
        }
        mTouchDelegates.add(touchDelegate);
    }

    public void removeTouchDelegate(TouchDelegate touchDelegate) {
        if (mTouchDelegates != null) {
            mTouchDelegates.remove(touchDelegate);
            if (mTouchDelegates == mCurrentTouchDelegate) {
                mCurrentTouchDelegate = null;
            }
        }
    }

    public void clearTouchDelegates() {
        if (mTouchDelegates != null) {
            mTouchDelegates.clear();
        }
        mCurrentTouchDelegate = null;
    }

    public void setEnabled(boolean enabled) {
        mEnabled = enabled;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (!mEnabled) {
            return false;
        }

        TouchDelegate touchDelegate = null;

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (mTouchDelegates != null) {
                    for (int i = 0; i < mTouchDelegates.size(); ++i) {
                        TouchDelegate delegate = mTouchDelegates.get(i);
                        if (delegate.onTouchEvent(event)) {
                            mCurrentTouchDelegate = delegate;
                            return true;
                        }
                    }
                }
                break;

            case MotionEvent.ACTION_MOVE:
                touchDelegate = mCurrentTouchDelegate;
                break;
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                touchDelegate = mCurrentTouchDelegate;
                mCurrentTouchDelegate = null;
        }

        return touchDelegate != null && touchDelegate.onTouchEvent(event);
    }
}
