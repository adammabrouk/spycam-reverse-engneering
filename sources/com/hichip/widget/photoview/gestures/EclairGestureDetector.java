package com.hichip.widget.photoview.gestures;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.MotionEvent;
import com.google.zxing.view.ViewfinderView;
import com.hichip.widget.photoview.Compat;

@TargetApi(5)
/* loaded from: classes.dex */
public class EclairGestureDetector extends CupcakeGestureDetector {
    public static final int INVALID_POINTER_ID = -1;
    public int mActivePointerId;
    public int mActivePointerIndex;

    public EclairGestureDetector(Context context) {
        super(context);
        this.mActivePointerId = -1;
        this.mActivePointerIndex = 0;
    }

    @Override // com.hichip.widget.photoview.gestures.CupcakeGestureDetector
    public float getActiveX(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(this.mActivePointerIndex);
        } catch (Exception unused) {
            return motionEvent.getX();
        }
    }

    @Override // com.hichip.widget.photoview.gestures.CupcakeGestureDetector
    public float getActiveY(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(this.mActivePointerIndex);
        } catch (Exception unused) {
            return motionEvent.getY();
        }
    }

    @Override // com.hichip.widget.photoview.gestures.CupcakeGestureDetector, com.hichip.widget.photoview.gestures.GestureDetector
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & ViewfinderView.OPAQUE;
        if (action != 0) {
            if (action == 1 || action == 3) {
                this.mActivePointerId = -1;
            } else if (action == 6) {
                int pointerIndex = Compat.getPointerIndex(motionEvent.getAction());
                if (motionEvent.getPointerId(pointerIndex) == this.mActivePointerId) {
                    int i2 = pointerIndex != 0 ? 0 : 1;
                    this.mActivePointerId = motionEvent.getPointerId(i2);
                    this.mLastTouchX = motionEvent.getX(i2);
                    this.mLastTouchY = motionEvent.getY(i2);
                }
            }
        } else {
            this.mActivePointerId = motionEvent.getPointerId(0);
        }
        int i3 = this.mActivePointerId;
        this.mActivePointerIndex = motionEvent.findPointerIndex(i3 != -1 ? i3 : 0);
        return super.onTouchEvent(motionEvent);
    }
}
