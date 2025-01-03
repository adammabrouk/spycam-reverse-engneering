package com.google.android.material.circularreveal.cardview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import c.c.a.c.j.b;
import c.c.a.c.j.c;
import com.google.android.material.card.MaterialCardView;

/* loaded from: classes.dex */
public class CircularRevealCardView extends MaterialCardView implements c {
    public final b t;

    public CircularRevealCardView(Context context) {
        this(context, null);
    }

    @Override // c.c.a.c.j.c
    public void a() {
        this.t.b();
    }

    @Override // c.c.a.c.j.c
    public void b() {
        this.t.a();
    }

    @Override // c.c.a.c.j.b.a
    public boolean c() {
        return super.isOpaque();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        b bVar = this.t;
        if (bVar != null) {
            bVar.a(canvas);
        } else {
            super.draw(canvas);
        }
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return this.t.c();
    }

    @Override // c.c.a.c.j.c
    public int getCircularRevealScrimColor() {
        return this.t.d();
    }

    @Override // c.c.a.c.j.c
    public c.e getRevealInfo() {
        return this.t.e();
    }

    @Override // android.view.View
    public boolean isOpaque() {
        b bVar = this.t;
        return bVar != null ? bVar.g() : super.isOpaque();
    }

    @Override // c.c.a.c.j.c
    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.t.a(drawable);
    }

    @Override // c.c.a.c.j.c
    public void setCircularRevealScrimColor(int i2) {
        this.t.a(i2);
    }

    @Override // c.c.a.c.j.c
    public void setRevealInfo(c.e eVar) {
        this.t.b(eVar);
    }

    public CircularRevealCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.t = new b(this);
    }

    @Override // c.c.a.c.j.b.a
    public void a(Canvas canvas) {
        super.draw(canvas);
    }
}
