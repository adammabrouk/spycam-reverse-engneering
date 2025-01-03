package androidx.appcompat.widget;

import a.b.f.b;
import a.h.j.y;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;

/* loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public boolean f2179a;

    /* renamed from: b, reason: collision with root package name */
    public View f2180b;

    /* renamed from: c, reason: collision with root package name */
    public View f2181c;

    /* renamed from: d, reason: collision with root package name */
    public View f2182d;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f2183e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f2184f;

    /* renamed from: g, reason: collision with root package name */
    public Drawable f2185g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f2186h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f2187i;
    public int j;

    public ActionBarContainer(Context context) {
        this(context, null);
    }

    public final int a(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    public final boolean b(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f2183e;
        if (drawable != null && drawable.isStateful()) {
            this.f2183e.setState(getDrawableState());
        }
        Drawable drawable2 = this.f2184f;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f2184f.setState(getDrawableState());
        }
        Drawable drawable3 = this.f2185g;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.f2185g.setState(getDrawableState());
    }

    public View getTabContainer() {
        return this.f2180b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f2183e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f2184f;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f2185g;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f2181c = findViewById(R$id.action_bar);
        this.f2182d = findViewById(R$id.action_context_bar);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f2179a || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Drawable drawable;
        super.onLayout(z, i2, i3, i4, i5);
        View view = this.f2180b;
        boolean z2 = true;
        boolean z3 = false;
        boolean z4 = (view == null || view.getVisibility() == 8) ? false : true;
        if (view != null && view.getVisibility() != 8) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            int measuredHeight2 = measuredHeight - view.getMeasuredHeight();
            int i6 = layoutParams.bottomMargin;
            view.layout(i2, measuredHeight2 - i6, i4, measuredHeight - i6);
        }
        if (this.f2186h) {
            Drawable drawable2 = this.f2185g;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z2 = false;
            }
        } else {
            if (this.f2183e != null) {
                if (this.f2181c.getVisibility() == 0) {
                    this.f2183e.setBounds(this.f2181c.getLeft(), this.f2181c.getTop(), this.f2181c.getRight(), this.f2181c.getBottom());
                } else {
                    View view2 = this.f2182d;
                    if (view2 == null || view2.getVisibility() != 0) {
                        this.f2183e.setBounds(0, 0, 0, 0);
                    } else {
                        this.f2183e.setBounds(this.f2182d.getLeft(), this.f2182d.getTop(), this.f2182d.getRight(), this.f2182d.getBottom());
                    }
                }
                z3 = true;
            }
            this.f2187i = z4;
            if (!z4 || (drawable = this.f2184f) == null) {
                z2 = z3;
            } else {
                drawable.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        }
        if (z2) {
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        if (this.f2181c == null && View.MeasureSpec.getMode(i3) == Integer.MIN_VALUE && (i4 = this.j) >= 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(Math.min(i4, View.MeasureSpec.getSize(i3)), Integer.MIN_VALUE);
        }
        super.onMeasure(i2, i3);
        if (this.f2181c == null) {
            return;
        }
        int mode = View.MeasureSpec.getMode(i3);
        View view = this.f2180b;
        if (view == null || view.getVisibility() == 8 || mode == 1073741824) {
            return;
        }
        setMeasuredDimension(getMeasuredWidth(), Math.min((!b(this.f2181c) ? a(this.f2181c) : !b(this.f2182d) ? a(this.f2182d) : 0) + a(this.f2180b), mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i3) : Integer.MAX_VALUE));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f2183e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f2183e);
        }
        this.f2183e = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f2181c;
            if (view != null) {
                this.f2183e.setBounds(view.getLeft(), this.f2181c.getTop(), this.f2181c.getRight(), this.f2181c.getBottom());
            }
        }
        boolean z = true;
        if (!this.f2186h ? this.f2183e != null || this.f2184f != null : this.f2185g != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f2185g;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f2185g);
        }
        this.f2185g = drawable;
        boolean z = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f2186h && (drawable2 = this.f2185g) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.f2186h ? !(this.f2183e != null || this.f2184f != null) : this.f2185g == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f2184f;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f2184f);
        }
        this.f2184f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f2187i && (drawable2 = this.f2184f) != null) {
                drawable2.setBounds(this.f2180b.getLeft(), this.f2180b.getTop(), this.f2180b.getRight(), this.f2180b.getBottom());
            }
        }
        boolean z = true;
        if (!this.f2186h ? this.f2183e != null || this.f2184f != null : this.f2185g != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setTabContainer(ScrollingTabContainerView scrollingTabContainerView) {
        View view = this.f2180b;
        if (view != null) {
            removeView(view);
        }
        this.f2180b = scrollingTabContainerView;
        if (scrollingTabContainerView != null) {
            addView(scrollingTabContainerView);
            ViewGroup.LayoutParams layoutParams = scrollingTabContainerView.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            scrollingTabContainerView.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z) {
        this.f2179a = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z = i2 == 0;
        Drawable drawable = this.f2183e;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
        Drawable drawable2 = this.f2184f;
        if (drawable2 != null) {
            drawable2.setVisible(z, false);
        }
        Drawable drawable3 = this.f2185g;
        if (drawable3 != null) {
            drawable3.setVisible(z, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i2) {
        if (i2 != 0) {
            return super.startActionModeForChild(view, callback, i2);
        }
        return null;
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f2183e && !this.f2186h) || (drawable == this.f2184f && this.f2187i) || ((drawable == this.f2185g && this.f2186h) || super.verifyDrawable(drawable));
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        y.a(this, new b(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ActionBar);
        this.f2183e = obtainStyledAttributes.getDrawable(R$styleable.ActionBar_background);
        this.f2184f = obtainStyledAttributes.getDrawable(R$styleable.ActionBar_backgroundStacked);
        this.j = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ActionBar_height, -1);
        boolean z = true;
        if (getId() == R$id.split_action_bar) {
            this.f2186h = true;
            this.f2185g = obtainStyledAttributes.getDrawable(R$styleable.ActionBar_backgroundSplit);
        }
        obtainStyledAttributes.recycle();
        if (!this.f2186h ? this.f2183e != null || this.f2184f != null : this.f2185g != null) {
            z = false;
        }
        setWillNotDraw(z);
    }
}
