package com.google.android.material.snackbar;

import a.h.j.y;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import c.c.a.c.r.r;
import c.c.a.c.y.b;
import c.c.a.c.y.c;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$styleable;

/* loaded from: classes.dex */
public class BaseTransientBottomBar$SnackbarBaseLayout extends FrameLayout {

    /* renamed from: h, reason: collision with root package name */
    public static final View.OnTouchListener f10588h = new a();

    /* renamed from: a, reason: collision with root package name */
    public c f10589a;

    /* renamed from: b, reason: collision with root package name */
    public b f10590b;

    /* renamed from: c, reason: collision with root package name */
    public int f10591c;

    /* renamed from: d, reason: collision with root package name */
    public final float f10592d;

    /* renamed from: e, reason: collision with root package name */
    public final float f10593e;

    /* renamed from: f, reason: collision with root package name */
    public ColorStateList f10594f;

    /* renamed from: g, reason: collision with root package name */
    public PorterDuff.Mode f10595g;

    public static class a implements View.OnTouchListener {
        @Override // android.view.View.OnTouchListener
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    public BaseTransientBottomBar$SnackbarBaseLayout(Context context) {
        this(context, null);
    }

    public final Drawable a() {
        float dimension = getResources().getDimension(R$dimen.mtrl_snackbar_background_corner_radius);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(dimension);
        gradientDrawable.setColor(c.c.a.c.k.a.a(this, R$attr.colorSurface, R$attr.colorOnSurface, getBackgroundOverlayColorAlpha()));
        if (this.f10594f == null) {
            return a.h.c.l.a.i(gradientDrawable);
        }
        Drawable i2 = a.h.c.l.a.i(gradientDrawable);
        a.h.c.l.a.a(i2, this.f10594f);
        return i2;
    }

    public float getActionTextColorAlpha() {
        return this.f10593e;
    }

    public int getAnimationMode() {
        return this.f10591c;
    }

    public float getBackgroundOverlayColorAlpha() {
        return this.f10592d;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        b bVar = this.f10590b;
        if (bVar != null) {
            bVar.onViewAttachedToWindow(this);
        }
        y.O(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b bVar = this.f10590b;
        if (bVar != null) {
            bVar.onViewDetachedFromWindow(this);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        c cVar = this.f10589a;
        if (cVar != null) {
            cVar.a(this, i2, i3, i4, i5);
        }
    }

    public void setAnimationMode(int i2) {
        this.f10591c = i2;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable != null && this.f10594f != null) {
            drawable = a.h.c.l.a.i(drawable.mutate());
            a.h.c.l.a.a(drawable, this.f10594f);
            a.h.c.l.a.a(drawable, this.f10595g);
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        this.f10594f = colorStateList;
        if (getBackground() != null) {
            Drawable i2 = a.h.c.l.a.i(getBackground().mutate());
            a.h.c.l.a.a(i2, colorStateList);
            a.h.c.l.a.a(i2, this.f10595g);
            if (i2 != getBackground()) {
                super.setBackgroundDrawable(i2);
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        this.f10595g = mode;
        if (getBackground() != null) {
            Drawable i2 = a.h.c.l.a.i(getBackground().mutate());
            a.h.c.l.a.a(i2, mode);
            if (i2 != getBackground()) {
                super.setBackgroundDrawable(i2);
            }
        }
    }

    public void setOnAttachStateChangeListener(b bVar) {
        this.f10590b = bVar;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        setOnTouchListener(onClickListener != null ? null : f10588h);
        super.setOnClickListener(onClickListener);
    }

    public void setOnLayoutChangeListener(c cVar) {
        this.f10589a = cVar;
    }

    public BaseTransientBottomBar$SnackbarBaseLayout(Context context, AttributeSet attributeSet) {
        super(c.c.a.c.a0.a.a.b(context, attributeSet, 0, 0), attributeSet);
        Context context2 = getContext();
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R$styleable.SnackbarLayout);
        if (obtainStyledAttributes.hasValue(R$styleable.SnackbarLayout_elevation)) {
            y.a(this, obtainStyledAttributes.getDimensionPixelSize(R$styleable.SnackbarLayout_elevation, 0));
        }
        this.f10591c = obtainStyledAttributes.getInt(R$styleable.SnackbarLayout_animationMode, 0);
        this.f10592d = obtainStyledAttributes.getFloat(R$styleable.SnackbarLayout_backgroundOverlayColorAlpha, 1.0f);
        setBackgroundTintList(c.c.a.c.t.c.a(context2, obtainStyledAttributes, R$styleable.SnackbarLayout_backgroundTint));
        setBackgroundTintMode(r.a(obtainStyledAttributes.getInt(R$styleable.SnackbarLayout_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN));
        this.f10593e = obtainStyledAttributes.getFloat(R$styleable.SnackbarLayout_actionTextColorAlpha, 1.0f);
        obtainStyledAttributes.recycle();
        setOnTouchListener(f10588h);
        setFocusable(true);
        if (getBackground() == null) {
            y.a(this, a());
        }
    }
}
