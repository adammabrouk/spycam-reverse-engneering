package com.hichip.widget.photoview.gestures;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.hichip.widget.photoview.log.LogManager;

/* loaded from: classes.dex */
public class CupcakeGestureDetector implements GestureDetector {
    public static final String LOG_TAG = "CupcakeGestureDetector";
    public boolean mIsDragging;
    public float mLastTouchX;
    public float mLastTouchY;
    public OnGestureListener mListener;
    public final float mMinimumVelocity;
    public final float mTouchSlop;
    public VelocityTracker mVelocityTracker;

    public CupcakeGestureDetector(Context context) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
    }

    public float getActiveX(MotionEvent motionEvent) {
        return motionEvent.getX();
    }

    public float getActiveY(MotionEvent motionEvent) {
        return motionEvent.getY();
    }

    @Override // com.hichip.widget.photoview.gestures.GestureDetector
    public boolean isDragging() {
        return this.mIsDragging;
    }

    @Override // com.hichip.widget.photoview.gestures.GestureDetector
    public boolean isScaling() {
        return false;
    }

    @Override // com.hichip.widget.photoview.gestures.GestureDetector
    public boolean onTouchEvent(MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        int action = motionEvent.getAction();
        if (action == 0) {
            VelocityTracker obtain = VelocityTracker.obtain();
            this.mVelocityTracker = obtain;
            if (obtain != null) {
                obtain.addMovement(motionEvent);
            } else {
                LogManager.getLogger().i(LOG_TAG, "Velocity tracker is null");
            }
            this.mLastTouchX = getActiveX(motionEvent);
            this.mLastTouchY = getActiveY(motionEvent);
            this.mIsDragging = false;
        } else if (action == 1) {
            if (this.mIsDragging && this.mVelocityTracker != null) {
                this.mLastTouchX = getActiveX(motionEvent);
                this.mLastTouchY = getActiveY(motionEvent);
                this.mVelocityTracker.addMovement(motionEvent);
                this.mVelocityTracker.computeCurrentVelocity(1000);
                float xVelocity = this.mVelocityTracker.getXVelocity();
                float yVelocity = this.mVelocityTracker.getYVelocity();
                if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.mMinimumVelocity) {
                    this.mListener.onFling(this.mLastTouchX, this.mLastTouchY, -xVelocity, -yVelocity);
                }
            }
            VelocityTracker velocityTracker2 = this.mVelocityTracker;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.mVelocityTracker = null;
            }
        } else if (action == 2) {
            float activeX = getActiveX(motionEvent);
            float activeY = getActiveY(motionEvent);
            float f2 = activeX - this.mLastTouchX;
            float f3 = activeY - this.mLastTouchY;
            if (!this.mIsDragging) {
                this.mIsDragging = Math.sqrt((double) ((f2 * f2) + (f3 * f3))) >= ((double) this.mTouchSlop);
            }
            if (this.mIsDragging) {
                this.mListener.onDrag(f2, f3);
                this.mLastTouchX = activeX;
                this.mLastTouchY = activeY;
                VelocityTracker velocityTracker3 = this.mVelocityTracker;
                if (velocityTracker3 != null) {
                    velocityTracker3.addMovement(motionEvent);
                }
            }
        } else if (action == 3 && (velocityTracker = this.mVelocityTracker) != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
        return true;
    }

    @Override // com.hichip.widget.photoview.gestures.GestureDetector
    public void setOnGestureListener(OnGestureListener onGestureListener) {
        this.mListener = onGestureListener;
    }
}
