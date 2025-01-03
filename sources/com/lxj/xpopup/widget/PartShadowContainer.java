package com.lxj.xpopup.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import c.e.b.e.b;
import c.e.b.g.e;

/* loaded from: classes.dex */
public class PartShadowContainer extends FrameLayout {
    public boolean isDismissOnTouchOutside;
    public b listener;
    public float x;
    public float y;

    public PartShadowContainer(Context context) {
        super(context);
        this.isDismissOnTouchOutside = true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        b bVar;
        View childAt = getChildAt(0);
        int[] iArr = new int[2];
        childAt.getLocationInWindow(iArr);
        if (!e.a(motionEvent.getRawX(), motionEvent.getRawY(), new Rect(iArr[0], iArr[1], iArr[0] + childAt.getMeasuredWidth(), iArr[1] + childAt.getMeasuredHeight()))) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.x = motionEvent.getX();
                this.y = motionEvent.getY();
            } else if (action == 1 || action == 2 || action == 3) {
                if (((float) Math.sqrt(Math.pow(motionEvent.getX() - this.x, 2.0d) + Math.pow(motionEvent.getY() - this.y, 2.0d))) < ViewConfiguration.get(getContext()).getScaledTouchSlop() && this.isDismissOnTouchOutside && (bVar = this.listener) != null) {
                    bVar.a();
                }
                this.x = 0.0f;
                this.y = 0.0f;
            }
        }
        return true;
    }

    public void setOnClickOutsideListener(b bVar) {
        this.listener = bVar;
    }

    public PartShadowContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PartShadowContainer(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.isDismissOnTouchOutside = true;
    }
}
