package com.google.android.material.internal;

import a.h.j.g0;
import a.h.j.s;
import a.h.j.y;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import c.c.a.c.r.l;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;

/* loaded from: classes.dex */
public class ScrimInsetsFrameLayout extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public Drawable f10551a;

    /* renamed from: b, reason: collision with root package name */
    public Rect f10552b;

    /* renamed from: c, reason: collision with root package name */
    public Rect f10553c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f10554d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f10555e;

    public class a implements s {
        public a() {
        }

        @Override // a.h.j.s
        public g0 a(View view, g0 g0Var) {
            ScrimInsetsFrameLayout scrimInsetsFrameLayout = ScrimInsetsFrameLayout.this;
            if (scrimInsetsFrameLayout.f10552b == null) {
                scrimInsetsFrameLayout.f10552b = new Rect();
            }
            ScrimInsetsFrameLayout.this.f10552b.set(g0Var.f(), g0Var.h(), g0Var.g(), g0Var.e());
            ScrimInsetsFrameLayout.this.a(g0Var);
            ScrimInsetsFrameLayout.this.setWillNotDraw(!g0Var.i() || ScrimInsetsFrameLayout.this.f10551a == null);
            y.N(ScrimInsetsFrameLayout.this);
            return g0Var.c();
        }
    }

    public ScrimInsetsFrameLayout(Context context) {
        this(context, null);
    }

    public void a(g0 g0Var) {
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.f10552b == null || this.f10551a == null) {
            return;
        }
        int save = canvas.save();
        canvas.translate(getScrollX(), getScrollY());
        if (this.f10554d) {
            this.f10553c.set(0, 0, width, this.f10552b.top);
            this.f10551a.setBounds(this.f10553c);
            this.f10551a.draw(canvas);
        }
        if (this.f10555e) {
            this.f10553c.set(0, height - this.f10552b.bottom, width, height);
            this.f10551a.setBounds(this.f10553c);
            this.f10551a.draw(canvas);
        }
        Rect rect = this.f10553c;
        Rect rect2 = this.f10552b;
        rect.set(0, rect2.top, rect2.left, height - rect2.bottom);
        this.f10551a.setBounds(this.f10553c);
        this.f10551a.draw(canvas);
        Rect rect3 = this.f10553c;
        Rect rect4 = this.f10552b;
        rect3.set(width - rect4.right, rect4.top, width, height - rect4.bottom);
        this.f10551a.setBounds(this.f10553c);
        this.f10551a.draw(canvas);
        canvas.restoreToCount(save);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable drawable = this.f10551a;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable drawable = this.f10551a;
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public void setDrawBottomInsetForeground(boolean z) {
        this.f10555e = z;
    }

    public void setDrawTopInsetForeground(boolean z) {
        this.f10554d = z;
    }

    public void setScrimInsetForeground(Drawable drawable) {
        this.f10551a = drawable;
    }

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f10553c = new Rect();
        this.f10554d = true;
        this.f10555e = true;
        TypedArray c2 = l.c(context, attributeSet, R$styleable.ScrimInsetsFrameLayout, i2, R$style.Widget_Design_ScrimInsetsFrameLayout, new int[0]);
        this.f10551a = c2.getDrawable(R$styleable.ScrimInsetsFrameLayout_insetForeground);
        c2.recycle();
        setWillNotDraw(true);
        y.a(this, new a());
    }
}
