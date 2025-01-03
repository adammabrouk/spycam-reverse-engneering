package com.google.android.material.appbar;

import a.h.j.g0;
import a.h.j.s;
import a.h.j.y;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import c.c.a.c.r.l;
import com.google.android.material.R$id;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.appbar.AppBarLayout;
import com.google.zxing.view.ViewfinderView;
import com.shix.shixipc.utilcode.MemoryConstants;

/* loaded from: classes.dex */
public class CollapsingToolbarLayout extends FrameLayout {
    public static final int y = R$style.Widget_Design_CollapsingToolbar;

    /* renamed from: a, reason: collision with root package name */
    public boolean f10271a;

    /* renamed from: b, reason: collision with root package name */
    public int f10272b;

    /* renamed from: c, reason: collision with root package name */
    public Toolbar f10273c;

    /* renamed from: d, reason: collision with root package name */
    public View f10274d;

    /* renamed from: e, reason: collision with root package name */
    public View f10275e;

    /* renamed from: f, reason: collision with root package name */
    public int f10276f;

    /* renamed from: g, reason: collision with root package name */
    public int f10277g;

    /* renamed from: h, reason: collision with root package name */
    public int f10278h;

    /* renamed from: i, reason: collision with root package name */
    public int f10279i;
    public final Rect j;
    public final c.c.a.c.r.a k;
    public boolean l;
    public boolean m;
    public Drawable n;
    public Drawable o;
    public int p;
    public boolean q;
    public ValueAnimator r;
    public long t;
    public int u;
    public AppBarLayout.e v;
    public int w;
    public g0 x;

    public class a implements s {
        public a() {
        }

        @Override // a.h.j.s
        public g0 a(View view, g0 g0Var) {
            return CollapsingToolbarLayout.this.a(g0Var);
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            CollapsingToolbarLayout.this.setScrimAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    public class d implements AppBarLayout.e {
        public d() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.c
        public void a(AppBarLayout appBarLayout, int i2) {
            CollapsingToolbarLayout collapsingToolbarLayout = CollapsingToolbarLayout.this;
            collapsingToolbarLayout.w = i2;
            g0 g0Var = collapsingToolbarLayout.x;
            int h2 = g0Var != null ? g0Var.h() : 0;
            int childCount = CollapsingToolbarLayout.this.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = CollapsingToolbarLayout.this.getChildAt(i3);
                c cVar = (c) childAt.getLayoutParams();
                c.c.a.c.b.d e2 = CollapsingToolbarLayout.e(childAt);
                int i4 = cVar.f10282a;
                if (i4 == 1) {
                    e2.b(a.h.e.a.a(-i2, 0, CollapsingToolbarLayout.this.b(childAt)));
                } else if (i4 == 2) {
                    e2.b(Math.round((-i2) * cVar.f10283b));
                }
            }
            CollapsingToolbarLayout.this.d();
            CollapsingToolbarLayout collapsingToolbarLayout2 = CollapsingToolbarLayout.this;
            if (collapsingToolbarLayout2.o != null && h2 > 0) {
                y.N(collapsingToolbarLayout2);
            }
            CollapsingToolbarLayout.this.k.g(Math.abs(i2) / ((CollapsingToolbarLayout.this.getHeight() - y.r(CollapsingToolbarLayout.this)) - h2));
        }
    }

    public CollapsingToolbarLayout(Context context) {
        this(context, null);
    }

    public static int d(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return view.getHeight();
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return view.getHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public static c.c.a.c.b.d e(View view) {
        c.c.a.c.b.d dVar = (c.c.a.c.b.d) view.getTag(R$id.view_offset_helper);
        if (dVar != null) {
            return dVar;
        }
        c.c.a.c.b.d dVar2 = new c.c.a.c.b.d(view);
        view.setTag(R$id.view_offset_helper, dVar2);
        return dVar2;
    }

    public g0 a(g0 g0Var) {
        g0 g0Var2 = y.n(this) ? g0Var : null;
        if (!a.h.i.c.a(this.x, g0Var2)) {
            this.x = g0Var2;
            requestLayout();
        }
        return g0Var.c();
    }

    public final int b(View view) {
        return ((getHeight() - e(view).b()) - view.getHeight()) - ((FrameLayout.LayoutParams) ((c) view.getLayoutParams())).bottomMargin;
    }

    public final boolean c(View view) {
        View view2 = this.f10274d;
        if (view2 == null || view2 == this) {
            if (view == this.f10273c) {
                return true;
            }
        } else if (view == view2) {
            return true;
        }
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Drawable drawable;
        super.draw(canvas);
        a();
        if (this.f10273c == null && (drawable = this.n) != null && this.p > 0) {
            drawable.mutate().setAlpha(this.p);
            this.n.draw(canvas);
        }
        if (this.l && this.m) {
            this.k.a(canvas);
        }
        if (this.o == null || this.p <= 0) {
            return;
        }
        g0 g0Var = this.x;
        int h2 = g0Var != null ? g0Var.h() : 0;
        if (h2 > 0) {
            this.o.setBounds(0, -this.w, getWidth(), h2 - this.w);
            this.o.mutate().setAlpha(this.p);
            this.o.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        boolean z;
        if (this.n == null || this.p <= 0 || !c(view)) {
            z = false;
        } else {
            this.n.mutate().setAlpha(this.p);
            this.n.draw(canvas);
            z = true;
        }
        return super.drawChild(canvas, view, j) || z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.o;
        boolean z = false;
        if (drawable != null && drawable.isStateful()) {
            z = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.n;
        if (drawable2 != null && drawable2.isStateful()) {
            z |= drawable2.setState(drawableState);
        }
        c.c.a.c.r.a aVar = this.k;
        if (aVar != null) {
            z |= aVar.a(drawableState);
        }
        if (z) {
            invalidate();
        }
    }

    public int getCollapsedTitleGravity() {
        return this.k.g();
    }

    public Typeface getCollapsedTitleTypeface() {
        return this.k.i();
    }

    public Drawable getContentScrim() {
        return this.n;
    }

    public int getExpandedTitleGravity() {
        return this.k.l();
    }

    public int getExpandedTitleMarginBottom() {
        return this.f10279i;
    }

    public int getExpandedTitleMarginEnd() {
        return this.f10278h;
    }

    public int getExpandedTitleMarginStart() {
        return this.f10276f;
    }

    public int getExpandedTitleMarginTop() {
        return this.f10277g;
    }

    public Typeface getExpandedTitleTypeface() {
        return this.k.n();
    }

    public int getMaxLines() {
        return this.k.p();
    }

    public int getScrimAlpha() {
        return this.p;
    }

    public long getScrimAnimationDuration() {
        return this.t;
    }

    public int getScrimVisibleHeightTrigger() {
        int i2 = this.u;
        if (i2 >= 0) {
            return i2;
        }
        g0 g0Var = this.x;
        int h2 = g0Var != null ? g0Var.h() : 0;
        int r = y.r(this);
        return r > 0 ? Math.min((r * 2) + h2, getHeight()) : getHeight() / 3;
    }

    public Drawable getStatusBarScrim() {
        return this.o;
    }

    public CharSequence getTitle() {
        if (this.l) {
            return this.k.q();
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Object parent = getParent();
        if (parent instanceof AppBarLayout) {
            y.b(this, y.n((View) parent));
            if (this.v == null) {
                this.v = new d();
            }
            ((AppBarLayout) parent).addOnOffsetChangedListener(this.v);
            y.O(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        ViewParent parent = getParent();
        AppBarLayout.e eVar = this.v;
        if (eVar != null && (parent instanceof AppBarLayout)) {
            ((AppBarLayout) parent).removeOnOffsetChangedListener(eVar);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        View view;
        super.onLayout(z, i2, i3, i4, i5);
        g0 g0Var = this.x;
        if (g0Var != null) {
            int h2 = g0Var.h();
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                if (!y.n(childAt) && childAt.getTop() < h2) {
                    y.e(childAt, h2);
                }
            }
        }
        int childCount2 = getChildCount();
        for (int i7 = 0; i7 < childCount2; i7++) {
            e(getChildAt(i7)).d();
        }
        if (this.l && (view = this.f10275e) != null) {
            boolean z2 = y.I(view) && this.f10275e.getVisibility() == 0;
            this.m = z2;
            if (z2) {
                boolean z3 = y.q(this) == 1;
                View view2 = this.f10274d;
                if (view2 == null) {
                    view2 = this.f10273c;
                }
                int b2 = b(view2);
                c.c.a.c.r.c.a(this, this.f10275e, this.j);
                this.k.a(this.j.left + (z3 ? this.f10273c.getTitleMarginEnd() : this.f10273c.getTitleMarginStart()), this.j.top + b2 + this.f10273c.getTitleMarginTop(), this.j.right - (z3 ? this.f10273c.getTitleMarginStart() : this.f10273c.getTitleMarginEnd()), (this.j.bottom + b2) - this.f10273c.getTitleMarginBottom());
                this.k.b(z3 ? this.f10278h : this.f10276f, this.j.top + this.f10277g, (i4 - i2) - (z3 ? this.f10276f : this.f10278h), (i5 - i3) - this.f10279i);
                this.k.u();
            }
        }
        if (this.f10273c != null) {
            if (this.l && TextUtils.isEmpty(this.k.q())) {
                setTitle(this.f10273c.getTitle());
            }
            View view3 = this.f10274d;
            if (view3 == null || view3 == this) {
                setMinimumHeight(d(this.f10273c));
            } else {
                setMinimumHeight(d(view3));
            }
        }
        d();
        int childCount3 = getChildCount();
        for (int i8 = 0; i8 < childCount3; i8++) {
            e(getChildAt(i8)).a();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        a();
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i3);
        g0 g0Var = this.x;
        int h2 = g0Var != null ? g0Var.h() : 0;
        if (mode != 0 || h2 <= 0) {
            return;
        }
        super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + h2, MemoryConstants.GB));
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        Drawable drawable = this.n;
        if (drawable != null) {
            drawable.setBounds(0, 0, i2, i3);
        }
    }

    public void setCollapsedTitleGravity(int i2) {
        this.k.b(i2);
    }

    public void setCollapsedTitleTextAppearance(int i2) {
        this.k.a(i2);
    }

    public void setCollapsedTitleTextColor(int i2) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i2));
    }

    public void setCollapsedTitleTypeface(Typeface typeface) {
        this.k.a(typeface);
    }

    public void setContentScrim(Drawable drawable) {
        Drawable drawable2 = this.n;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable mutate = drawable != null ? drawable.mutate() : null;
            this.n = mutate;
            if (mutate != null) {
                mutate.setBounds(0, 0, getWidth(), getHeight());
                this.n.setCallback(this);
                this.n.setAlpha(this.p);
            }
            y.N(this);
        }
    }

    public void setContentScrimColor(int i2) {
        setContentScrim(new ColorDrawable(i2));
    }

    public void setContentScrimResource(int i2) {
        setContentScrim(a.h.b.a.c(getContext(), i2));
    }

    public void setExpandedTitleColor(int i2) {
        setExpandedTitleTextColor(ColorStateList.valueOf(i2));
    }

    public void setExpandedTitleGravity(int i2) {
        this.k.d(i2);
    }

    public void setExpandedTitleMarginBottom(int i2) {
        this.f10279i = i2;
        requestLayout();
    }

    public void setExpandedTitleMarginEnd(int i2) {
        this.f10278h = i2;
        requestLayout();
    }

    public void setExpandedTitleMarginStart(int i2) {
        this.f10276f = i2;
        requestLayout();
    }

    public void setExpandedTitleMarginTop(int i2) {
        this.f10277g = i2;
        requestLayout();
    }

    public void setExpandedTitleTextAppearance(int i2) {
        this.k.c(i2);
    }

    public void setExpandedTitleTextColor(ColorStateList colorStateList) {
        this.k.c(colorStateList);
    }

    public void setExpandedTitleTypeface(Typeface typeface) {
        this.k.c(typeface);
    }

    public void setMaxLines(int i2) {
        this.k.e(i2);
    }

    public void setScrimAlpha(int i2) {
        Toolbar toolbar;
        if (i2 != this.p) {
            if (this.n != null && (toolbar = this.f10273c) != null) {
                y.N(toolbar);
            }
            this.p = i2;
            y.N(this);
        }
    }

    public void setScrimAnimationDuration(long j) {
        this.t = j;
    }

    public void setScrimVisibleHeightTrigger(int i2) {
        if (this.u != i2) {
            this.u = i2;
            d();
        }
    }

    public void setScrimsShown(boolean z) {
        a(z, y.J(this) && !isInEditMode());
    }

    public void setStatusBarScrim(Drawable drawable) {
        Drawable drawable2 = this.o;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable mutate = drawable != null ? drawable.mutate() : null;
            this.o = mutate;
            if (mutate != null) {
                if (mutate.isStateful()) {
                    this.o.setState(getDrawableState());
                }
                a.h.c.l.a.a(this.o, y.q(this));
                this.o.setVisible(getVisibility() == 0, false);
                this.o.setCallback(this);
                this.o.setAlpha(this.p);
            }
            y.N(this);
        }
    }

    public void setStatusBarScrimColor(int i2) {
        setStatusBarScrim(new ColorDrawable(i2));
    }

    public void setStatusBarScrimResource(int i2) {
        setStatusBarScrim(a.h.b.a.c(getContext(), i2));
    }

    public void setTitle(CharSequence charSequence) {
        this.k.b(charSequence);
        b();
    }

    public void setTitleEnabled(boolean z) {
        if (z != this.l) {
            this.l = z;
            b();
            c();
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z = i2 == 0;
        Drawable drawable = this.o;
        if (drawable != null && drawable.isVisible() != z) {
            this.o.setVisible(z, false);
        }
        Drawable drawable2 = this.n;
        if (drawable2 == null || drawable2.isVisible() == z) {
            return;
        }
        this.n.setVisible(z, false);
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.n || drawable == this.o;
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void c() {
        View view;
        if (!this.l && (view = this.f10275e) != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f10275e);
            }
        }
        if (!this.l || this.f10273c == null) {
            return;
        }
        if (this.f10275e == null) {
            this.f10275e = new View(getContext());
        }
        if (this.f10275e.getParent() == null) {
            this.f10273c.addView(this.f10275e, -1, -1);
        }
    }

    public void setCollapsedTitleTextColor(ColorStateList colorStateList) {
        this.k.b(colorStateList);
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet, int i2) {
        super(c.c.a.c.a0.a.a.b(context, attributeSet, i2, y), attributeSet, i2);
        this.f10271a = true;
        this.j = new Rect();
        this.u = -1;
        Context context2 = getContext();
        c.c.a.c.r.a aVar = new c.c.a.c.r.a(this);
        this.k = aVar;
        aVar.b(c.c.a.c.a.a.f5310e);
        TypedArray c2 = l.c(context2, attributeSet, R$styleable.CollapsingToolbarLayout, i2, y, new int[0]);
        this.k.d(c2.getInt(R$styleable.CollapsingToolbarLayout_expandedTitleGravity, 8388691));
        this.k.b(c2.getInt(R$styleable.CollapsingToolbarLayout_collapsedTitleGravity, 8388627));
        int dimensionPixelSize = c2.getDimensionPixelSize(R$styleable.CollapsingToolbarLayout_expandedTitleMargin, 0);
        this.f10279i = dimensionPixelSize;
        this.f10278h = dimensionPixelSize;
        this.f10277g = dimensionPixelSize;
        this.f10276f = dimensionPixelSize;
        if (c2.hasValue(R$styleable.CollapsingToolbarLayout_expandedTitleMarginStart)) {
            this.f10276f = c2.getDimensionPixelSize(R$styleable.CollapsingToolbarLayout_expandedTitleMarginStart, 0);
        }
        if (c2.hasValue(R$styleable.CollapsingToolbarLayout_expandedTitleMarginEnd)) {
            this.f10278h = c2.getDimensionPixelSize(R$styleable.CollapsingToolbarLayout_expandedTitleMarginEnd, 0);
        }
        if (c2.hasValue(R$styleable.CollapsingToolbarLayout_expandedTitleMarginTop)) {
            this.f10277g = c2.getDimensionPixelSize(R$styleable.CollapsingToolbarLayout_expandedTitleMarginTop, 0);
        }
        if (c2.hasValue(R$styleable.CollapsingToolbarLayout_expandedTitleMarginBottom)) {
            this.f10279i = c2.getDimensionPixelSize(R$styleable.CollapsingToolbarLayout_expandedTitleMarginBottom, 0);
        }
        this.l = c2.getBoolean(R$styleable.CollapsingToolbarLayout_titleEnabled, true);
        setTitle(c2.getText(R$styleable.CollapsingToolbarLayout_title));
        this.k.c(R$style.TextAppearance_Design_CollapsingToolbar_Expanded);
        this.k.a(androidx.appcompat.R$style.TextAppearance_AppCompat_Widget_ActionBar_Title);
        if (c2.hasValue(R$styleable.CollapsingToolbarLayout_expandedTitleTextAppearance)) {
            this.k.c(c2.getResourceId(R$styleable.CollapsingToolbarLayout_expandedTitleTextAppearance, 0));
        }
        if (c2.hasValue(R$styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance)) {
            this.k.a(c2.getResourceId(R$styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance, 0));
        }
        this.u = c2.getDimensionPixelSize(R$styleable.CollapsingToolbarLayout_scrimVisibleHeightTrigger, -1);
        if (c2.hasValue(R$styleable.CollapsingToolbarLayout_maxLines)) {
            this.k.e(c2.getInt(R$styleable.CollapsingToolbarLayout_maxLines, 1));
        }
        this.t = c2.getInt(R$styleable.CollapsingToolbarLayout_scrimAnimationDuration, ViewPager.MAX_SETTLE_DURATION);
        setContentScrim(c2.getDrawable(R$styleable.CollapsingToolbarLayout_contentScrim));
        setStatusBarScrim(c2.getDrawable(R$styleable.CollapsingToolbarLayout_statusBarScrim));
        this.f10272b = c2.getResourceId(R$styleable.CollapsingToolbarLayout_toolbarId, -1);
        c2.recycle();
        setWillNotDraw(false);
        y.a(this, new a());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public c generateDefaultLayoutParams() {
        return new c(-1, -1);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    public final void b() {
        setContentDescription(getTitle());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new c(layoutParams);
    }

    public final void a() {
        if (this.f10271a) {
            Toolbar toolbar = null;
            this.f10273c = null;
            this.f10274d = null;
            int i2 = this.f10272b;
            if (i2 != -1) {
                Toolbar toolbar2 = (Toolbar) findViewById(i2);
                this.f10273c = toolbar2;
                if (toolbar2 != null) {
                    this.f10274d = a(toolbar2);
                }
            }
            if (this.f10273c == null) {
                int childCount = getChildCount();
                int i3 = 0;
                while (true) {
                    if (i3 >= childCount) {
                        break;
                    }
                    View childAt = getChildAt(i3);
                    if (childAt instanceof Toolbar) {
                        toolbar = (Toolbar) childAt;
                        break;
                    }
                    i3++;
                }
                this.f10273c = toolbar;
            }
            c();
            this.f10271a = false;
        }
    }

    public final void d() {
        if (this.n == null && this.o == null) {
            return;
        }
        setScrimsShown(getHeight() + this.w < getScrimVisibleHeightTrigger());
    }

    public static class c extends FrameLayout.LayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public int f10282a;

        /* renamed from: b, reason: collision with root package name */
        public float f10283b;

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f10282a = 0;
            this.f10283b = 0.5f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CollapsingToolbarLayout_Layout);
            this.f10282a = obtainStyledAttributes.getInt(R$styleable.CollapsingToolbarLayout_Layout_layout_collapseMode, 0);
            a(obtainStyledAttributes.getFloat(R$styleable.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, 0.5f));
            obtainStyledAttributes.recycle();
        }

        public void a(float f2) {
            this.f10283b = f2;
        }

        public c(int i2, int i3) {
            super(i2, i3);
            this.f10282a = 0;
            this.f10283b = 0.5f;
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f10282a = 0;
            this.f10283b = 0.5f;
        }
    }

    public final View a(View view) {
        for (ViewParent parent = view.getParent(); parent != this && parent != null; parent = parent.getParent()) {
            if (parent instanceof View) {
                view = parent;
            }
        }
        return view;
    }

    public void a(boolean z, boolean z2) {
        if (this.q != z) {
            int i2 = ViewfinderView.OPAQUE;
            if (z2) {
                if (!z) {
                    i2 = 0;
                }
                a(i2);
            } else {
                if (!z) {
                    i2 = 0;
                }
                setScrimAlpha(i2);
            }
            this.q = z;
        }
    }

    public final void a(int i2) {
        a();
        ValueAnimator valueAnimator = this.r;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.r = valueAnimator2;
            valueAnimator2.setDuration(this.t);
            this.r.setInterpolator(i2 > this.p ? c.c.a.c.a.a.f5308c : c.c.a.c.a.a.f5309d);
            this.r.addUpdateListener(new b());
        } else if (valueAnimator.isRunning()) {
            this.r.cancel();
        }
        this.r.setIntValues(this.p, i2);
        this.r.start();
    }
}
