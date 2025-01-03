package c.c.a.c.u;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import c.c.a.c.w.h;
import c.c.a.c.w.m;
import c.c.a.c.w.p;

/* compiled from: RippleDrawableCompat.java */
/* loaded from: classes.dex */
public class a extends Drawable implements p, a.h.c.l.b {

    /* renamed from: a, reason: collision with root package name */
    public b f5623a;

    /* compiled from: RippleDrawableCompat.java */
    public static final class b extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        public h f5624a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f5625b;

        public b(h hVar) {
            this.f5624a = hVar;
            this.f5625b = false;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public a newDrawable() {
            return new a(new b(this));
        }

        public b(b bVar) {
            this.f5624a = (h) bVar.f5624a.getConstantState().newDrawable();
            this.f5625b = bVar.f5625b;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        b bVar = this.f5623a;
        if (bVar.f5625b) {
            bVar.f5624a.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f5623a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f5623a.f5624a.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable mutate() {
        mutate();
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f5623a.f5624a.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        if (this.f5623a.f5624a.setState(iArr)) {
            onStateChange = true;
        }
        boolean a2 = c.c.a.c.u.b.a(iArr);
        b bVar = this.f5623a;
        if (bVar.f5625b == a2) {
            return onStateChange;
        }
        bVar.f5625b = a2;
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f5623a.f5624a.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f5623a.f5624a.setColorFilter(colorFilter);
    }

    @Override // c.c.a.c.w.p
    public void setShapeAppearanceModel(m mVar) {
        this.f5623a.f5624a.setShapeAppearanceModel(mVar);
    }

    @Override // android.graphics.drawable.Drawable, a.h.c.l.b
    public void setTint(int i2) {
        this.f5623a.f5624a.setTint(i2);
    }

    @Override // android.graphics.drawable.Drawable, a.h.c.l.b
    public void setTintList(ColorStateList colorStateList) {
        this.f5623a.f5624a.setTintList(colorStateList);
    }

    @Override // android.graphics.drawable.Drawable, a.h.c.l.b
    public void setTintMode(PorterDuff.Mode mode) {
        this.f5623a.f5624a.setTintMode(mode);
    }

    public a(m mVar) {
        this(new b(new h(mVar)));
    }

    @Override // android.graphics.drawable.Drawable
    public a mutate() {
        this.f5623a = new b(this.f5623a);
        return this;
    }

    public a(b bVar) {
        this.f5623a = bVar;
    }
}
