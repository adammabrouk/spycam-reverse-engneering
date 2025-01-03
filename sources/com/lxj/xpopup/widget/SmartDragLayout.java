package com.lxj.xpopup.widget;

import a.h.j.q;
import a.h.j.y;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.OverScroller;
import c.e.b.a;
import c.e.b.d.b;

/* loaded from: classes.dex */
public class SmartDragLayout extends LinearLayout implements q {
    public View child;
    public boolean dismissOnTouchOutside;
    public boolean enableDrag;
    public boolean isScrollUp;
    public boolean isThreeDrag;
    public boolean isUserClose;
    public int lastHeight;
    public OnCloseListener listener;
    public int maxY;
    public int minY;
    public OverScroller scroller;
    public b status;
    public float touchX;
    public float touchY;
    public VelocityTracker tracker;

    public interface OnCloseListener {
        void onClose();

        void onDrag(int i2, float f2, boolean z);

        void onOpen();
    }

    public SmartDragLayout(Context context) {
        this(context, null);
    }

    private void finishScroll() {
        int scrollY;
        if (this.enableDrag) {
            int scrollY2 = (getScrollY() > (this.isScrollUp ? this.maxY - this.minY : (this.maxY - this.minY) * 2) / 3 ? this.maxY : this.minY) - getScrollY();
            if (this.isThreeDrag) {
                int i2 = this.maxY / 3;
                float f2 = i2;
                float f3 = 2.5f * f2;
                if (getScrollY() > f3) {
                    i2 = this.maxY;
                    scrollY = getScrollY();
                } else if (getScrollY() <= f3 && getScrollY() > f2 * 1.5f) {
                    i2 *= 2;
                    scrollY = getScrollY();
                } else if (getScrollY() > i2) {
                    scrollY = getScrollY();
                } else {
                    i2 = this.minY;
                    scrollY = getScrollY();
                }
                scrollY2 = i2 - scrollY;
            }
            this.scroller.startScroll(getScrollX(), getScrollY(), 0, scrollY2, a.a());
            y.N(this);
        }
    }

    public void close() {
        this.isUserClose = true;
        post(new Runnable() { // from class: com.lxj.xpopup.widget.SmartDragLayout.2
            @Override // java.lang.Runnable
            public void run() {
                SmartDragLayout.this.scroller.abortAnimation();
                SmartDragLayout smartDragLayout = SmartDragLayout.this;
                smartDragLayout.smoothScroll(smartDragLayout.minY - smartDragLayout.getScrollY(), false);
                SmartDragLayout.this.status = b.Closing;
            }
        });
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.scroller.computeScrollOffset()) {
            scrollTo(this.scroller.getCurrX(), this.scroller.getCurrY());
            y.N(this);
        }
    }

    public void dismissOnTouchOutside(boolean z) {
        this.dismissOnTouchOutside = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.isUserClose = true;
        return super.dispatchTouchEvent(motionEvent);
    }

    public void enableDrag(boolean z) {
        this.enableDrag = z;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return 2;
    }

    public void isThreeDrag(boolean z) {
        this.isThreeDrag = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.isScrollUp = false;
        this.isUserClose = false;
        setTranslationY(0.0f);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        this.maxY = this.child.getMeasuredHeight();
        this.minY = 0;
        int measuredWidth = (getMeasuredWidth() / 2) - (this.child.getMeasuredWidth() / 2);
        this.child.layout(measuredWidth, getMeasuredHeight(), this.child.getMeasuredWidth() + measuredWidth, getMeasuredHeight() + this.maxY);
        if (this.status == b.Open) {
            if (this.isThreeDrag) {
                scrollTo(getScrollX(), getScrollY() - (this.lastHeight - this.maxY));
            } else {
                scrollTo(getScrollX(), getScrollY() - (this.lastHeight - this.maxY));
            }
        }
        this.lastHeight = this.maxY;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.h.j.q
    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        if ((getScrollY() > this.minY && getScrollY() < this.maxY) && f3 < -1500.0f && !this.isThreeDrag) {
            close();
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.h.j.q
    public boolean onNestedPreFling(View view, float f2, float f3) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.h.j.q
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        if (i3 > 0) {
            int scrollY = getScrollY() + i3;
            if (scrollY < this.maxY) {
                iArr[1] = i3;
            }
            scrollTo(getScrollX(), scrollY);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.h.j.q
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        scrollTo(getScrollX(), getScrollY() + i5);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.h.j.q
    public void onNestedScrollAccepted(View view, View view2, int i2) {
        this.scroller.abortAnimation();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.h.j.q
    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return i2 == 2 && this.enableDrag;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.h.j.q
    public void onStopNestedScroll(View view) {
        finishScroll();
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001f, code lost:
    
        if (r0 != 3) goto L46;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r9) {
        /*
            r8 = this;
            boolean r0 = r8.enableDrag
            r1 = 1
            if (r0 == 0) goto L13
            android.widget.OverScroller r0 = r8.scroller
            boolean r0 = r0.computeScrollOffset()
            if (r0 == 0) goto L13
            r9 = 0
            r8.touchX = r9
            r8.touchY = r9
            return r1
        L13:
            int r0 = r9.getAction()
            if (r0 == 0) goto Lc3
            if (r0 == r1) goto L51
            r2 = 2
            if (r0 == r2) goto L23
            r2 = 3
            if (r0 == r2) goto L51
            goto Le0
        L23:
            boolean r0 = r8.enableDrag
            if (r0 == 0) goto Le0
            android.view.VelocityTracker r0 = r8.tracker
            if (r0 == 0) goto Le0
            r0.addMovement(r9)
            android.view.VelocityTracker r0 = r8.tracker
            r2 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r2)
            float r0 = r9.getY()
            float r2 = r8.touchY
            float r0 = r0 - r2
            int r0 = (int) r0
            int r2 = r8.getScrollX()
            int r3 = r8.getScrollY()
            int r3 = r3 - r0
            r8.scrollTo(r2, r3)
            float r9 = r9.getY()
            r8.touchY = r9
            goto Le0
        L51:
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            android.view.View r2 = r8.child
            r2.getGlobalVisibleRect(r0)
            float r2 = r9.getRawX()
            float r3 = r9.getRawY()
            boolean r0 = c.e.b.g.e.a(r2, r3, r0)
            if (r0 != 0) goto La1
            boolean r0 = r8.dismissOnTouchOutside
            if (r0 == 0) goto La1
            float r0 = r9.getX()
            float r2 = r8.touchX
            float r0 = r0 - r2
            double r2 = (double) r0
            r4 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r2 = java.lang.Math.pow(r2, r4)
            float r9 = r9.getY()
            float r0 = r8.touchY
            float r9 = r9 - r0
            double r6 = (double) r9
            double r4 = java.lang.Math.pow(r6, r4)
            double r2 = r2 + r4
            double r2 = java.lang.Math.sqrt(r2)
            float r9 = (float) r2
            android.content.Context r0 = r8.getContext()
            android.view.ViewConfiguration r0 = android.view.ViewConfiguration.get(r0)
            int r0 = r0.getScaledTouchSlop()
            float r0 = (float) r0
            int r9 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r9 >= 0) goto La1
            r8.performClick()
        La1:
            boolean r9 = r8.enableDrag
            if (r9 == 0) goto Le0
            android.view.VelocityTracker r9 = r8.tracker
            if (r9 == 0) goto Le0
            float r9 = r9.getYVelocity()
            r0 = 1153138688(0x44bb8000, float:1500.0)
            int r9 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r9 <= 0) goto Lbc
            boolean r9 = r8.isThreeDrag
            if (r9 != 0) goto Lbc
            r8.close()
            goto Lbf
        Lbc:
            r8.finishScroll()
        Lbf:
            r9 = 0
            r8.tracker = r9
            goto Le0
        Lc3:
            boolean r0 = r8.enableDrag
            if (r0 == 0) goto Ld4
            android.view.VelocityTracker r0 = r8.tracker
            if (r0 == 0) goto Lce
            r0.clear()
        Lce:
            android.view.VelocityTracker r0 = android.view.VelocityTracker.obtain()
            r8.tracker = r0
        Ld4:
            float r0 = r9.getX()
            r8.touchX = r0
            float r9 = r9.getY()
            r8.touchY = r9
        Le0:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lxj.xpopup.widget.SmartDragLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        this.child = view;
    }

    public void open() {
        post(new Runnable() { // from class: com.lxj.xpopup.widget.SmartDragLayout.1
            @Override // java.lang.Runnable
            public void run() {
                SmartDragLayout smartDragLayout = SmartDragLayout.this;
                int scrollY = smartDragLayout.maxY - smartDragLayout.getScrollY();
                SmartDragLayout smartDragLayout2 = SmartDragLayout.this;
                if (smartDragLayout2.enableDrag && smartDragLayout2.isThreeDrag) {
                    scrollY /= 3;
                }
                smartDragLayout2.smoothScroll(scrollY, true);
                SmartDragLayout.this.status = b.Opening;
            }
        });
    }

    @Override // android.view.View
    public void scrollTo(int i2, int i3) {
        int i4 = this.maxY;
        if (i3 > i4) {
            i3 = i4;
        }
        int i5 = this.minY;
        if (i3 < i5) {
            i3 = i5;
        }
        int i6 = this.minY;
        float f2 = ((i3 - i6) * 1.0f) / (this.maxY - i6);
        this.isScrollUp = i3 > getScrollY();
        OnCloseListener onCloseListener = this.listener;
        if (onCloseListener != null) {
            if (this.isUserClose && f2 == 0.0f) {
                b bVar = this.status;
                b bVar2 = b.Close;
                if (bVar != bVar2) {
                    this.status = bVar2;
                    onCloseListener.onClose();
                    this.listener.onDrag(i3, f2, this.isScrollUp);
                }
            }
            if (f2 == 1.0f) {
                b bVar3 = this.status;
                b bVar4 = b.Open;
                if (bVar3 != bVar4) {
                    this.status = bVar4;
                    this.listener.onOpen();
                }
            }
            this.listener.onDrag(i3, f2, this.isScrollUp);
        }
        super.scrollTo(i2, i3);
    }

    public void setOnCloseListener(OnCloseListener onCloseListener) {
        this.listener = onCloseListener;
    }

    public void smoothScroll(final int i2, final boolean z) {
        post(new Runnable() { // from class: com.lxj.xpopup.widget.SmartDragLayout.3
            @Override // java.lang.Runnable
            public void run() {
                SmartDragLayout smartDragLayout = SmartDragLayout.this;
                smartDragLayout.scroller.startScroll(smartDragLayout.getScrollX(), SmartDragLayout.this.getScrollY(), 0, i2, (int) (z ? a.a() : a.a() * 0.8f));
                y.N(SmartDragLayout.this);
            }
        });
    }

    public SmartDragLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SmartDragLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.enableDrag = true;
        this.dismissOnTouchOutside = true;
        this.isUserClose = false;
        this.isThreeDrag = false;
        this.status = b.Close;
        if (1 != 0) {
            this.scroller = new OverScroller(context);
        }
    }
}
