package c.c.a.c.f;

import a.h.j.y;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import c.c.a.c.r.r;
import c.c.a.c.t.c;
import c.c.a.c.u.b;
import c.c.a.c.w.h;
import c.c.a.c.w.m;
import c.c.a.c.w.p;
import com.google.android.material.R$attr;
import com.google.android.material.R$styleable;
import com.google.android.material.button.MaterialButton;

/* compiled from: MaterialButtonHelper.java */
/* loaded from: classes.dex */
public class a {
    public static final boolean s;

    /* renamed from: a, reason: collision with root package name */
    public final MaterialButton f5362a;

    /* renamed from: b, reason: collision with root package name */
    public m f5363b;

    /* renamed from: c, reason: collision with root package name */
    public int f5364c;

    /* renamed from: d, reason: collision with root package name */
    public int f5365d;

    /* renamed from: e, reason: collision with root package name */
    public int f5366e;

    /* renamed from: f, reason: collision with root package name */
    public int f5367f;

    /* renamed from: g, reason: collision with root package name */
    public int f5368g;

    /* renamed from: h, reason: collision with root package name */
    public int f5369h;

    /* renamed from: i, reason: collision with root package name */
    public PorterDuff.Mode f5370i;
    public ColorStateList j;
    public ColorStateList k;
    public ColorStateList l;
    public Drawable m;
    public boolean n = false;
    public boolean o = false;
    public boolean p = false;
    public boolean q;
    public LayerDrawable r;

    static {
        s = Build.VERSION.SDK_INT >= 21;
    }

    public a(MaterialButton materialButton, m mVar) {
        this.f5362a = materialButton;
        this.f5363b = mVar;
    }

    public void a(TypedArray typedArray) {
        this.f5364c = typedArray.getDimensionPixelOffset(R$styleable.MaterialButton_android_insetLeft, 0);
        this.f5365d = typedArray.getDimensionPixelOffset(R$styleable.MaterialButton_android_insetRight, 0);
        this.f5366e = typedArray.getDimensionPixelOffset(R$styleable.MaterialButton_android_insetTop, 0);
        this.f5367f = typedArray.getDimensionPixelOffset(R$styleable.MaterialButton_android_insetBottom, 0);
        if (typedArray.hasValue(R$styleable.MaterialButton_cornerRadius)) {
            int dimensionPixelSize = typedArray.getDimensionPixelSize(R$styleable.MaterialButton_cornerRadius, -1);
            this.f5368g = dimensionPixelSize;
            a(this.f5363b.a(dimensionPixelSize));
            this.p = true;
        }
        this.f5369h = typedArray.getDimensionPixelSize(R$styleable.MaterialButton_strokeWidth, 0);
        this.f5370i = r.a(typedArray.getInt(R$styleable.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.j = c.a(this.f5362a.getContext(), typedArray, R$styleable.MaterialButton_backgroundTint);
        this.k = c.a(this.f5362a.getContext(), typedArray, R$styleable.MaterialButton_strokeColor);
        this.l = c.a(this.f5362a.getContext(), typedArray, R$styleable.MaterialButton_rippleColor);
        this.q = typedArray.getBoolean(R$styleable.MaterialButton_android_checkable, false);
        int dimensionPixelSize2 = typedArray.getDimensionPixelSize(R$styleable.MaterialButton_elevation, 0);
        int w = y.w(this.f5362a);
        int paddingTop = this.f5362a.getPaddingTop();
        int v = y.v(this.f5362a);
        int paddingBottom = this.f5362a.getPaddingBottom();
        if (typedArray.hasValue(R$styleable.MaterialButton_android_background)) {
            n();
        } else {
            this.f5362a.setInternalBackground(a());
            h d2 = d();
            if (d2 != null) {
                d2.b(dimensionPixelSize2);
            }
        }
        y.a(this.f5362a, w + this.f5364c, paddingTop + this.f5366e, v + this.f5365d, paddingBottom + this.f5367f);
    }

    public void b(ColorStateList colorStateList) {
        if (this.k != colorStateList) {
            this.k = colorStateList;
            o();
        }
    }

    public void c(ColorStateList colorStateList) {
        if (this.j != colorStateList) {
            this.j = colorStateList;
            if (d() != null) {
                a.h.c.l.a.a(d(), this.j);
            }
        }
    }

    public h d() {
        return a(false);
    }

    public ColorStateList e() {
        return this.l;
    }

    public m f() {
        return this.f5363b;
    }

    public ColorStateList g() {
        return this.k;
    }

    public int h() {
        return this.f5369h;
    }

    public ColorStateList i() {
        return this.j;
    }

    public PorterDuff.Mode j() {
        return this.f5370i;
    }

    public final h k() {
        return a(true);
    }

    public boolean l() {
        return this.o;
    }

    public boolean m() {
        return this.q;
    }

    public void n() {
        this.o = true;
        this.f5362a.setSupportBackgroundTintList(this.j);
        this.f5362a.setSupportBackgroundTintMode(this.f5370i);
    }

    public final void o() {
        h d2 = d();
        h k = k();
        if (d2 != null) {
            d2.a(this.f5369h, this.k);
            if (k != null) {
                k.a(this.f5369h, this.n ? c.c.a.c.k.a.a(this.f5362a, R$attr.colorSurface) : 0);
            }
        }
    }

    public void b(int i2) {
        if (this.p && this.f5368g == i2) {
            return;
        }
        this.f5368g = i2;
        this.p = true;
        a(this.f5363b.a(i2));
    }

    public void c(boolean z) {
        this.n = z;
        o();
    }

    public void c(int i2) {
        if (this.f5369h != i2) {
            this.f5369h = i2;
            o();
        }
    }

    public int b() {
        return this.f5368g;
    }

    public void b(boolean z) {
        this.q = z;
    }

    public final void b(m mVar) {
        if (d() != null) {
            d().setShapeAppearanceModel(mVar);
        }
        if (k() != null) {
            k().setShapeAppearanceModel(mVar);
        }
        if (c() != null) {
            c().setShapeAppearanceModel(mVar);
        }
    }

    public p c() {
        LayerDrawable layerDrawable = this.r;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        if (this.r.getNumberOfLayers() > 2) {
            return (p) this.r.getDrawable(2);
        }
        return (p) this.r.getDrawable(1);
    }

    public final InsetDrawable a(Drawable drawable) {
        return new InsetDrawable(drawable, this.f5364c, this.f5366e, this.f5365d, this.f5367f);
    }

    public void a(PorterDuff.Mode mode) {
        if (this.f5370i != mode) {
            this.f5370i = mode;
            if (d() == null || this.f5370i == null) {
                return;
            }
            a.h.c.l.a.a(d(), this.f5370i);
        }
    }

    public final Drawable a() {
        h hVar = new h(this.f5363b);
        hVar.a(this.f5362a.getContext());
        a.h.c.l.a.a(hVar, this.j);
        PorterDuff.Mode mode = this.f5370i;
        if (mode != null) {
            a.h.c.l.a.a(hVar, mode);
        }
        hVar.a(this.f5369h, this.k);
        h hVar2 = new h(this.f5363b);
        hVar2.setTint(0);
        hVar2.a(this.f5369h, this.n ? c.c.a.c.k.a.a(this.f5362a, R$attr.colorSurface) : 0);
        if (s) {
            h hVar3 = new h(this.f5363b);
            this.m = hVar3;
            a.h.c.l.a.b(hVar3, -1);
            RippleDrawable rippleDrawable = new RippleDrawable(b.b(this.l), a(new LayerDrawable(new Drawable[]{hVar2, hVar})), this.m);
            this.r = rippleDrawable;
            return rippleDrawable;
        }
        c.c.a.c.u.a aVar = new c.c.a.c.u.a(this.f5363b);
        this.m = aVar;
        a.h.c.l.a.a(aVar, b.b(this.l));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{hVar2, hVar, this.m});
        this.r = layerDrawable;
        return a(layerDrawable);
    }

    public void a(int i2, int i3) {
        Drawable drawable = this.m;
        if (drawable != null) {
            drawable.setBounds(this.f5364c, this.f5366e, i3 - this.f5365d, i2 - this.f5367f);
        }
    }

    public void a(int i2) {
        if (d() != null) {
            d().setTint(i2);
        }
    }

    public void a(ColorStateList colorStateList) {
        if (this.l != colorStateList) {
            this.l = colorStateList;
            if (s && (this.f5362a.getBackground() instanceof RippleDrawable)) {
                ((RippleDrawable) this.f5362a.getBackground()).setColor(b.b(colorStateList));
            } else {
                if (s || !(this.f5362a.getBackground() instanceof c.c.a.c.u.a)) {
                    return;
                }
                ((c.c.a.c.u.a) this.f5362a.getBackground()).setTintList(b.b(colorStateList));
            }
        }
    }

    public final h a(boolean z) {
        LayerDrawable layerDrawable = this.r;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        if (s) {
            return (h) ((LayerDrawable) ((InsetDrawable) this.r.getDrawable(0)).getDrawable()).getDrawable(!z ? 1 : 0);
        }
        return (h) this.r.getDrawable(!z ? 1 : 0);
    }

    public void a(m mVar) {
        this.f5363b = mVar;
        b(mVar);
    }
}
