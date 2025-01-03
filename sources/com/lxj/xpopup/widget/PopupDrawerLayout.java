package com.lxj.xpopup.widget;

import a.h.j.y;
import a.j.a.c;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import androidx.viewpager.widget.ViewPager;
import c.e.b.b.f;
import c.e.b.d.b;
import c.e.b.d.d;
import c.e.b.g.e;

/* loaded from: classes.dex */
public class PopupDrawerLayout extends FrameLayout {
    public f bgAnimator;
    public c.AbstractC0037c callback;
    public boolean canChildScrollLeft;
    public float downX;
    public float downY;
    public c dragHelper;
    public boolean enableDrag;
    public boolean enableShadow;
    public float fraction;
    public boolean hasLayout;
    public boolean isDismissOnTouchOutside;
    public boolean isDrawStatusBarShadow;
    public boolean isIntercept;
    public boolean isToLeft;
    public OnCloseListener listener;
    public View mChild;
    public View placeHolder;
    public d position;
    public b status;
    public float ty;
    public float x;
    public float y;

    public interface OnCloseListener {
        void onClose();

        void onDrag(int i2, float f2, boolean z);

        void onOpen();
    }

    public PopupDrawerLayout(Context context) {
        this(context, null);
    }

    private boolean canScroll(ViewGroup viewGroup, float f2, float f3, int i2) {
        for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
            View childAt = viewGroup.getChildAt(i3);
            int[] iArr = new int[2];
            childAt.getLocationInWindow(iArr);
            if (e.a(f2, f3, new Rect(iArr[0], iArr[1], iArr[0] + childAt.getWidth(), iArr[1] + childAt.getHeight())) && (childAt instanceof ViewGroup)) {
                if (childAt instanceof ViewPager) {
                    ViewPager viewPager = (ViewPager) childAt;
                    return i2 == 0 ? viewPager.canScrollHorizontally(-1) || viewPager.canScrollHorizontally(1) : viewPager.canScrollHorizontally(i2);
                }
                if (!(childAt instanceof HorizontalScrollView)) {
                    return canScroll((ViewGroup) childAt, f2, f3, i2);
                }
                HorizontalScrollView horizontalScrollView = (HorizontalScrollView) childAt;
                return i2 == 0 ? horizontalScrollView.canScrollHorizontally(-1) || horizontalScrollView.canScrollHorizontally(1) : horizontalScrollView.canScrollHorizontally(i2);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int fixLeft(int i2) {
        d dVar = this.position;
        if (dVar == d.Left) {
            if (i2 < (-this.mChild.getMeasuredWidth())) {
                i2 = -this.mChild.getMeasuredWidth();
            }
            if (i2 > 0) {
                return 0;
            }
            return i2;
        }
        if (dVar != d.Right) {
            return i2;
        }
        if (i2 < getMeasuredWidth() - this.mChild.getMeasuredWidth()) {
            i2 = getMeasuredWidth() - this.mChild.getMeasuredWidth();
        }
        return i2 > getMeasuredWidth() ? getMeasuredWidth() : i2;
    }

    public void close() {
        post(new Runnable() { // from class: com.lxj.xpopup.widget.PopupDrawerLayout.3
            @Override // java.lang.Runnable
            public void run() {
                PopupDrawerLayout.this.dragHelper.a();
                PopupDrawerLayout popupDrawerLayout = PopupDrawerLayout.this;
                c cVar = popupDrawerLayout.dragHelper;
                View view = popupDrawerLayout.mChild;
                cVar.b(view, popupDrawerLayout.position == d.Left ? -view.getMeasuredWidth() : popupDrawerLayout.getMeasuredWidth(), 0);
                y.N(PopupDrawerLayout.this);
            }
        });
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.dragHelper.a(true)) {
            y.N(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.ty = getTranslationY();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.status = null;
        this.hasLayout = false;
        this.fraction = 0.0f;
        setTranslationY(this.ty);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.placeHolder = getChildAt(0);
        this.mChild = getChildAt(1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0042, code lost:
    
        if (r0 != 3) goto L28;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            boolean r0 = r5.enableDrag
            if (r0 != 0) goto L9
            boolean r6 = super.onInterceptTouchEvent(r6)
            return r6
        L9:
            a.j.a.c r0 = r5.dragHelper
            r1 = 1
            boolean r0 = r0.a(r1)
            if (r0 != 0) goto La3
            c.e.b.d.b r0 = r5.status
            c.e.b.d.b r2 = c.e.b.d.b.Close
            if (r0 != r2) goto L1a
            goto La3
        L1a:
            float r0 = r6.getX()
            float r2 = r5.x
            r3 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto L27
            r0 = 1
            goto L28
        L27:
            r0 = 0
        L28:
            r5.isToLeft = r0
            float r0 = r6.getX()
            r5.x = r0
            float r0 = r6.getY()
            r5.y = r0
            int r0 = r6.getAction()
            if (r0 == 0) goto L62
            if (r0 == r1) goto L5c
            r2 = 2
            if (r0 == r2) goto L45
            r2 = 3
            if (r0 == r2) goto L5c
            goto L6e
        L45:
            float r0 = r5.x
            float r2 = r5.downX
            float r0 = r0 - r2
            float r0 = java.lang.Math.abs(r0)
            float r2 = r5.y
            float r4 = r5.downY
            float r2 = r2 - r4
            float r2 = java.lang.Math.abs(r2)
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r0 <= 0) goto L6e
            return r3
        L5c:
            r0 = 0
            r5.x = r0
            r5.y = r0
            goto L6e
        L62:
            float r0 = r6.getX()
            r5.downX = r0
            float r0 = r6.getY()
            r5.downY = r0
        L6e:
            float r0 = r6.getX()
            float r2 = r6.getY()
            boolean r0 = r5.canScroll(r5, r0, r2, r1)
            r5.canChildScrollLeft = r0
            a.j.a.c r0 = r5.dragHelper
            boolean r0 = r0.c(r6)
            r5.isIntercept = r0
            boolean r1 = r5.isToLeft
            if (r1 == 0) goto L8d
            boolean r1 = r5.canChildScrollLeft
            if (r1 != 0) goto L8d
            return r0
        L8d:
            float r0 = r6.getX()
            float r1 = r6.getY()
            boolean r0 = r5.canScroll(r5, r0, r1)
            if (r0 != 0) goto L9e
            boolean r6 = r5.isIntercept
            return r6
        L9e:
            boolean r6 = super.onInterceptTouchEvent(r6)
            return r6
        La3:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lxj.xpopup.widget.PopupDrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        this.placeHolder.layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
        if (this.hasLayout) {
            View view = this.mChild;
            view.layout(view.getLeft(), this.mChild.getTop(), this.mChild.getRight(), this.mChild.getMeasuredHeight());
            return;
        }
        if (this.position == d.Left) {
            View view2 = this.mChild;
            view2.layout(-view2.getMeasuredWidth(), 0, 0, getMeasuredHeight());
        } else {
            this.mChild.layout(getMeasuredWidth(), 0, getMeasuredWidth() + this.mChild.getMeasuredWidth(), getMeasuredHeight());
        }
        this.hasLayout = true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.enableDrag) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.dragHelper.a(true)) {
            return true;
        }
        this.dragHelper.a(motionEvent);
        return true;
    }

    public void open() {
        post(new Runnable() { // from class: com.lxj.xpopup.widget.PopupDrawerLayout.2
            @Override // java.lang.Runnable
            public void run() {
                PopupDrawerLayout popupDrawerLayout = PopupDrawerLayout.this;
                c cVar = popupDrawerLayout.dragHelper;
                View view = popupDrawerLayout.mChild;
                cVar.b(view, popupDrawerLayout.position == d.Left ? 0 : view.getLeft() - PopupDrawerLayout.this.mChild.getMeasuredWidth(), 0);
                y.N(PopupDrawerLayout.this);
            }
        });
    }

    public void setDrawerPosition(d dVar) {
        this.position = dVar;
    }

    public void setOnCloseListener(OnCloseListener onCloseListener) {
        this.listener = onCloseListener;
    }

    public PopupDrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PopupDrawerLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.status = null;
        this.position = d.Left;
        this.bgAnimator = new f();
        this.isDrawStatusBarShadow = false;
        this.fraction = 0.0f;
        this.enableShadow = true;
        this.enableDrag = true;
        this.hasLayout = false;
        this.isIntercept = false;
        c.AbstractC0037c abstractC0037c = new c.AbstractC0037c() { // from class: com.lxj.xpopup.widget.PopupDrawerLayout.1
            private void calcFraction(int i3, int i4) {
                PopupDrawerLayout popupDrawerLayout = PopupDrawerLayout.this;
                d dVar = popupDrawerLayout.position;
                if (dVar == d.Left) {
                    popupDrawerLayout.fraction = ((popupDrawerLayout.mChild.getMeasuredWidth() + i3) * 1.0f) / PopupDrawerLayout.this.mChild.getMeasuredWidth();
                    if (i3 == (-PopupDrawerLayout.this.mChild.getMeasuredWidth()) && PopupDrawerLayout.this.listener != null) {
                        PopupDrawerLayout popupDrawerLayout2 = PopupDrawerLayout.this;
                        b bVar = popupDrawerLayout2.status;
                        b bVar2 = b.Close;
                        if (bVar != bVar2) {
                            popupDrawerLayout2.status = bVar2;
                            popupDrawerLayout2.listener.onClose();
                        }
                    }
                } else if (dVar == d.Right) {
                    popupDrawerLayout.fraction = ((popupDrawerLayout.getMeasuredWidth() - i3) * 1.0f) / PopupDrawerLayout.this.mChild.getMeasuredWidth();
                    if (i3 == PopupDrawerLayout.this.getMeasuredWidth() && PopupDrawerLayout.this.listener != null) {
                        PopupDrawerLayout popupDrawerLayout3 = PopupDrawerLayout.this;
                        b bVar3 = popupDrawerLayout3.status;
                        b bVar4 = b.Close;
                        if (bVar3 != bVar4) {
                            popupDrawerLayout3.status = bVar4;
                            popupDrawerLayout3.listener.onClose();
                        }
                    }
                }
                PopupDrawerLayout popupDrawerLayout4 = PopupDrawerLayout.this;
                if (popupDrawerLayout4.enableShadow) {
                    popupDrawerLayout4.setBackgroundColor(popupDrawerLayout4.bgAnimator.a(popupDrawerLayout4.fraction));
                }
                if (PopupDrawerLayout.this.listener != null) {
                    PopupDrawerLayout.this.listener.onDrag(i3, PopupDrawerLayout.this.fraction, i4 < 0);
                    PopupDrawerLayout popupDrawerLayout5 = PopupDrawerLayout.this;
                    if (popupDrawerLayout5.fraction == 1.0f) {
                        b bVar5 = popupDrawerLayout5.status;
                        b bVar6 = b.Open;
                        if (bVar5 != bVar6) {
                            popupDrawerLayout5.status = bVar6;
                            popupDrawerLayout5.listener.onOpen();
                        }
                    }
                }
            }

            @Override // a.j.a.c.AbstractC0037c
            public int clampViewPositionHorizontal(View view, int i3, int i4) {
                PopupDrawerLayout popupDrawerLayout = PopupDrawerLayout.this;
                return view == popupDrawerLayout.placeHolder ? i3 : popupDrawerLayout.fixLeft(i3);
            }

            @Override // a.j.a.c.AbstractC0037c
            public int getViewHorizontalDragRange(View view) {
                return 1;
            }

            @Override // a.j.a.c.AbstractC0037c
            public void onViewPositionChanged(View view, int i3, int i4, int i5, int i6) {
                super.onViewPositionChanged(view, i3, i4, i5, i6);
                View view2 = PopupDrawerLayout.this.placeHolder;
                if (view != view2) {
                    calcFraction(i3, i5);
                    return;
                }
                view2.layout(0, 0, view2.getMeasuredWidth(), PopupDrawerLayout.this.placeHolder.getMeasuredHeight());
                PopupDrawerLayout popupDrawerLayout = PopupDrawerLayout.this;
                int fixLeft = popupDrawerLayout.fixLeft(popupDrawerLayout.mChild.getLeft() + i5);
                View view3 = PopupDrawerLayout.this.mChild;
                view3.layout(fixLeft, view3.getTop(), PopupDrawerLayout.this.mChild.getMeasuredWidth() + fixLeft, PopupDrawerLayout.this.mChild.getBottom());
                calcFraction(fixLeft, i5);
            }

            @Override // a.j.a.c.AbstractC0037c
            public void onViewReleased(View view, float f2, float f3) {
                int measuredWidth;
                int measuredWidth2;
                super.onViewReleased(view, f2, f3);
                PopupDrawerLayout popupDrawerLayout = PopupDrawerLayout.this;
                if (view == popupDrawerLayout.placeHolder && f2 == 0.0f) {
                    if (popupDrawerLayout.isDismissOnTouchOutside) {
                        popupDrawerLayout.close();
                        return;
                    }
                    return;
                }
                PopupDrawerLayout popupDrawerLayout2 = PopupDrawerLayout.this;
                if (view == popupDrawerLayout2.mChild && popupDrawerLayout2.isToLeft && !popupDrawerLayout2.canChildScrollLeft && f2 < -500.0f) {
                    popupDrawerLayout2.close();
                    return;
                }
                PopupDrawerLayout popupDrawerLayout3 = PopupDrawerLayout.this;
                if (popupDrawerLayout3.position == d.Left) {
                    if (f2 < -1000.0f) {
                        measuredWidth2 = popupDrawerLayout3.mChild.getMeasuredWidth();
                    } else {
                        if (PopupDrawerLayout.this.mChild.getLeft() < (-popupDrawerLayout3.mChild.getMeasuredWidth()) / 2) {
                            measuredWidth2 = PopupDrawerLayout.this.mChild.getMeasuredWidth();
                        } else {
                            measuredWidth = 0;
                        }
                    }
                    measuredWidth = -measuredWidth2;
                } else if (f2 > 1000.0f) {
                    measuredWidth = popupDrawerLayout3.getMeasuredWidth();
                } else {
                    measuredWidth = view.getLeft() < popupDrawerLayout3.getMeasuredWidth() - (PopupDrawerLayout.this.mChild.getMeasuredWidth() / 2) ? PopupDrawerLayout.this.getMeasuredWidth() - PopupDrawerLayout.this.mChild.getMeasuredWidth() : PopupDrawerLayout.this.getMeasuredWidth();
                }
                PopupDrawerLayout popupDrawerLayout4 = PopupDrawerLayout.this;
                popupDrawerLayout4.dragHelper.b(popupDrawerLayout4.mChild, measuredWidth, view.getTop());
                y.N(PopupDrawerLayout.this);
            }

            @Override // a.j.a.c.AbstractC0037c
            public boolean tryCaptureView(View view, int i3) {
                return (PopupDrawerLayout.this.dragHelper.a(true) || PopupDrawerLayout.this.status == b.Close) ? false : true;
            }
        };
        this.callback = abstractC0037c;
        this.isDismissOnTouchOutside = true;
        this.dragHelper = c.a(this, abstractC0037c);
    }

    private boolean canScroll(ViewGroup viewGroup, float f2, float f3) {
        return canScroll(viewGroup, f2, f3, 0);
    }
}
