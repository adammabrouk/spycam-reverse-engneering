package com.google.android.material.circularreveal.coordinatorlayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import c.c.a.c.j.b;
import c.c.a.c.j.c;

/* loaded from: classes.dex */
public class CircularRevealCoordinatorLayout extends CoordinatorLayout implements c {
    public final b A;

    public CircularRevealCoordinatorLayout(Context context) {
        this(context, null);
    }

    @Override // c.c.a.c.j.c
    public void a() {
        this.A.b();
    }

    @Override // c.c.a.c.j.c
    public void b() {
        this.A.a();
    }

    @Override // c.c.a.c.j.b.a
    public boolean c() {
        return super.isOpaque();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        b bVar = this.A;
        if (bVar != null) {
            bVar.a(canvas);
        } else {
            super.draw(canvas);
        }
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return this.A.c();
    }

    @Override // c.c.a.c.j.c
    public int getCircularRevealScrimColor() {
        return this.A.d();
    }

    @Override // c.c.a.c.j.c
    public c.e getRevealInfo() {
        return this.A.e();
    }

    @Override // android.view.View
    public boolean isOpaque() {
        b bVar = this.A;
        return bVar != null ? bVar.g() : super.isOpaque();
    }

    @Override // c.c.a.c.j.c
    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.A.a(drawable);
    }

    @Override // c.c.a.c.j.c
    public void setCircularRevealScrimColor(int i2) {
        this.A.a(i2);
    }

    @Override // c.c.a.c.j.c
    public void setRevealInfo(c.e eVar) {
        this.A.b(eVar);
    }

    public CircularRevealCoordinatorLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.A = new b(this);
    }

    @Override // c.c.a.c.j.b.a
    public void a(Canvas canvas) {
        super.draw(canvas);
    }
}
