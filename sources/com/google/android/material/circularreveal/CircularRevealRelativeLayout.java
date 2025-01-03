package com.google.android.material.circularreveal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import c.c.a.c.j.b;
import c.c.a.c.j.c;

/* loaded from: classes.dex */
public class CircularRevealRelativeLayout extends RelativeLayout implements c {

    /* renamed from: a, reason: collision with root package name */
    public final b f10456a;

    public CircularRevealRelativeLayout(Context context) {
        this(context, null);
    }

    @Override // c.c.a.c.j.c
    public void a() {
        this.f10456a.b();
    }

    @Override // c.c.a.c.j.c
    public void b() {
        this.f10456a.a();
    }

    @Override // c.c.a.c.j.b.a
    public boolean c() {
        return super.isOpaque();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        b bVar = this.f10456a;
        if (bVar != null) {
            bVar.a(canvas);
        } else {
            super.draw(canvas);
        }
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return this.f10456a.c();
    }

    @Override // c.c.a.c.j.c
    public int getCircularRevealScrimColor() {
        return this.f10456a.d();
    }

    @Override // c.c.a.c.j.c
    public c.e getRevealInfo() {
        return this.f10456a.e();
    }

    @Override // android.view.View
    public boolean isOpaque() {
        b bVar = this.f10456a;
        return bVar != null ? bVar.g() : super.isOpaque();
    }

    @Override // c.c.a.c.j.c
    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.f10456a.a(drawable);
    }

    @Override // c.c.a.c.j.c
    public void setCircularRevealScrimColor(int i2) {
        this.f10456a.a(i2);
    }

    @Override // c.c.a.c.j.c
    public void setRevealInfo(c.e eVar) {
        this.f10456a.b(eVar);
    }

    public CircularRevealRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10456a = new b(this);
    }

    @Override // c.c.a.c.j.b.a
    public void a(Canvas canvas) {
        super.draw(canvas);
    }
}
