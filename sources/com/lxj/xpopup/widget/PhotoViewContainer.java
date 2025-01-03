package com.lxj.xpopup.widget;

import a.h.j.y;
import a.j.a.c;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.viewpager.widget.ViewPager;
import c.e.b.e.d;
import c.e.b.f.k;
import com.lxj.xpopup.photoview.PhotoView;

/* loaded from: classes.dex */
public class PhotoViewContainer extends FrameLayout {
    public static final String TAG = "PhotoViewContainer";
    public int HideTopThreshold;
    public c.AbstractC0037c cb;
    public d dragChangeListener;
    public c dragHelper;
    public boolean isReleasing;
    public boolean isVertical;
    public int maxOffset;
    public float touchX;
    public float touchY;
    public ViewPager viewPager;

    public PhotoViewContainer(Context context) {
        this(context, null);
    }

    private PhotoView getCurrentPhotoView() {
        ViewPager viewPager = this.viewPager;
        return (PhotoView) viewPager.getChildAt(viewPager.getCurrentItem());
    }

    private void init() {
        this.HideTopThreshold = dip2px(this.HideTopThreshold);
        this.dragHelper = c.a(this, this.cb);
        setBackgroundColor(0);
    }

    private boolean isTopOrBottomEnd() {
        PhotoView currentPhotoView = getCurrentPhotoView();
        if (currentPhotoView != null) {
            k kVar = currentPhotoView.f10797a;
            if (kVar.D || kVar.E) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.dragHelper.a(false)) {
            y.N(this);
        }
    }

    public int dip2px(float f2) {
        return (int) ((f2 * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        if (motionEvent.getPointerCount() > 1) {
            return super.dispatchTouchEvent(motionEvent);
        }
        try {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        float x = motionEvent.getX() - this.touchX;
                        float y = motionEvent.getY() - this.touchY;
                        this.viewPager.dispatchTouchEvent(motionEvent);
                        if (Math.abs(y) <= Math.abs(x)) {
                            z = false;
                        }
                        this.isVertical = z;
                        this.touchX = motionEvent.getX();
                        this.touchY = motionEvent.getY();
                    } else if (action != 3) {
                    }
                }
                this.touchX = 0.0f;
                this.touchY = 0.0f;
                this.isVertical = false;
            } else {
                this.touchX = motionEvent.getX();
                this.touchY = motionEvent.getY();
            }
        } catch (Exception unused) {
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.isReleasing = false;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.viewPager = (ViewPager) getChildAt(0);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean c2 = this.dragHelper.c(motionEvent);
        if (motionEvent.getPointerCount() > 1 && motionEvent.getAction() == 2) {
            return false;
        }
        if (isTopOrBottomEnd() && this.isVertical) {
            return true;
        }
        return c2 && this.isVertical;
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.maxOffset = getHeight() / 3;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() > 1) {
            return false;
        }
        try {
            this.dragHelper.a(motionEvent);
        } catch (Exception unused) {
        }
        return true;
    }

    public void setOnDragChangeListener(d dVar) {
        this.dragChangeListener = dVar;
    }

    public PhotoViewContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhotoViewContainer(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.HideTopThreshold = 80;
        this.isReleasing = false;
        this.isVertical = false;
        this.cb = new c.AbstractC0037c() { // from class: com.lxj.xpopup.widget.PhotoViewContainer.1
            @Override // a.j.a.c.AbstractC0037c
            public int clampViewPositionVertical(View view, int i3, int i4) {
                int top = PhotoViewContainer.this.viewPager.getTop() + (i4 / 2);
                return top >= 0 ? Math.min(top, PhotoViewContainer.this.maxOffset) : -Math.min(-top, PhotoViewContainer.this.maxOffset);
            }

            @Override // a.j.a.c.AbstractC0037c
            public int getViewVerticalDragRange(View view) {
                return 1;
            }

            @Override // a.j.a.c.AbstractC0037c
            public void onViewPositionChanged(View view, int i3, int i4, int i5, int i6) {
                super.onViewPositionChanged(view, i3, i4, i5, i6);
                ViewPager viewPager = PhotoViewContainer.this.viewPager;
                if (view != viewPager) {
                    viewPager.offsetTopAndBottom(i6);
                }
                float abs = (Math.abs(i4) * 1.0f) / PhotoViewContainer.this.maxOffset;
                float f2 = 1.0f - (0.2f * abs);
                PhotoViewContainer.this.viewPager.setScaleX(f2);
                PhotoViewContainer.this.viewPager.setScaleY(f2);
                view.setScaleX(f2);
                view.setScaleY(f2);
                if (PhotoViewContainer.this.dragChangeListener != null) {
                    PhotoViewContainer.this.dragChangeListener.a(i6, f2, abs);
                }
            }

            @Override // a.j.a.c.AbstractC0037c
            public void onViewReleased(View view, float f2, float f3) {
                super.onViewReleased(view, f2, f3);
                if (Math.abs(view.getTop()) > PhotoViewContainer.this.HideTopThreshold) {
                    if (PhotoViewContainer.this.dragChangeListener != null) {
                        PhotoViewContainer.this.dragChangeListener.a();
                    }
                } else {
                    PhotoViewContainer.this.dragHelper.b(PhotoViewContainer.this.viewPager, 0, 0);
                    PhotoViewContainer.this.dragHelper.b(view, 0, 0);
                    y.N(PhotoViewContainer.this);
                }
            }

            @Override // a.j.a.c.AbstractC0037c
            public boolean tryCaptureView(View view, int i3) {
                return !PhotoViewContainer.this.isReleasing;
            }
        };
        init();
    }
}
