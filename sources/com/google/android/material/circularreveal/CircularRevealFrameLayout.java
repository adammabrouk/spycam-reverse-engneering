package com.google.android.material.circularreveal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import c.c.a.c.j.b;
import c.c.a.c.j.c;

/* loaded from: classes.dex */
public class CircularRevealFrameLayout extends FrameLayout implements c {

    /* renamed from: a, reason: collision with root package name */
    public final b f10453a;

    public CircularRevealFrameLayout(Context context) {
        this(context, null);
    }

    @Override // c.c.a.c.j.c
    public void a() {
        this.f10453a.b();
    }

    @Override // c.c.a.c.j.c
    public void b() {
        this.f10453a.a();
    }

    @Override // c.c.a.c.j.b.a
    public boolean c() {
        return super.isOpaque();
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
        b bVar = this.f10453a;
        if (bVar != null) {
            bVar.a(canvas);
        } else {
            super.draw(canvas);
        }
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return this.f10453a.c();
    }

    @Override // c.c.a.c.j.c
    public int getCircularRevealScrimColor() {
        return this.f10453a.d();
    }

    @Override // c.c.a.c.j.c
    public c.e getRevealInfo() {
        return this.f10453a.e();
    }

    @Override // android.view.View
    public boolean isOpaque() {
        b bVar = this.f10453a;
        return bVar != null ? bVar.g() : super.isOpaque();
    }

    @Override // c.c.a.c.j.c
    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.f10453a.a(drawable);
    }

    @Override // c.c.a.c.j.c
    public void setCircularRevealScrimColor(int i2) {
        this.f10453a.a(i2);
    }

    @Override // c.c.a.c.j.c
    public void setRevealInfo(c.e eVar) {
        this.f10453a.b(eVar);
    }

    public CircularRevealFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10453a = new b(this);
    }

    @Override // c.c.a.c.j.b.a
    public void a(Canvas canvas) {
        super.draw(canvas);
    }
}
