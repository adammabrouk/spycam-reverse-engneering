package c.c.a.c.h;

import a.h.j.y;
import android.R;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import c.c.a.c.t.c;
import c.c.a.c.u.b;
import c.c.a.c.w.d;
import c.c.a.c.w.e;
import c.c.a.c.w.h;
import c.c.a.c.w.l;
import c.c.a.c.w.m;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.card.MaterialCardView;

/* compiled from: MaterialCardViewHelper.java */
/* loaded from: classes.dex */
public class a {
    public static final int[] t = {R.attr.state_checked};
    public static final double u = Math.cos(Math.toRadians(45.0d));

    /* renamed from: a, reason: collision with root package name */
    public final MaterialCardView f5371a;

    /* renamed from: c, reason: collision with root package name */
    public final h f5373c;

    /* renamed from: d, reason: collision with root package name */
    public final h f5374d;

    /* renamed from: e, reason: collision with root package name */
    public final int f5375e;

    /* renamed from: f, reason: collision with root package name */
    public final int f5376f;

    /* renamed from: g, reason: collision with root package name */
    public int f5377g;

    /* renamed from: h, reason: collision with root package name */
    public Drawable f5378h;

    /* renamed from: i, reason: collision with root package name */
    public Drawable f5379i;
    public ColorStateList j;
    public ColorStateList k;
    public m l;
    public ColorStateList m;
    public Drawable n;
    public LayerDrawable o;
    public h p;
    public h q;
    public boolean s;

    /* renamed from: b, reason: collision with root package name */
    public final Rect f5372b = new Rect();
    public boolean r = false;

    /* compiled from: MaterialCardViewHelper.java */
    /* renamed from: c.c.a.c.h.a$a, reason: collision with other inner class name */
    public class C0099a extends InsetDrawable {
        public C0099a(a aVar, Drawable drawable, int i2, int i3, int i4, int i5) {
            super(drawable, i2, i3, i4, i5);
        }

        @Override // android.graphics.drawable.Drawable
        public int getMinimumHeight() {
            return -1;
        }

        @Override // android.graphics.drawable.Drawable
        public int getMinimumWidth() {
            return -1;
        }

        @Override // android.graphics.drawable.InsetDrawable, android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public boolean getPadding(Rect rect) {
            return false;
        }
    }

    public a(MaterialCardView materialCardView, AttributeSet attributeSet, int i2, int i3) {
        this.f5371a = materialCardView;
        h hVar = new h(materialCardView.getContext(), attributeSet, i2, i3);
        this.f5373c = hVar;
        hVar.a(materialCardView.getContext());
        this.f5373c.b(-12303292);
        m.b m = this.f5373c.n().m();
        TypedArray obtainStyledAttributes = materialCardView.getContext().obtainStyledAttributes(attributeSet, R$styleable.CardView, i2, R$style.CardView);
        if (obtainStyledAttributes.hasValue(R$styleable.CardView_cardCornerRadius)) {
            m.a(obtainStyledAttributes.getDimension(R$styleable.CardView_cardCornerRadius, 0.0f));
        }
        this.f5374d = new h();
        a(m.a());
        Resources resources = materialCardView.getResources();
        this.f5375e = resources.getDimensionPixelSize(R$dimen.mtrl_card_checked_icon_margin);
        this.f5376f = resources.getDimensionPixelSize(R$dimen.mtrl_card_checked_icon_size);
        obtainStyledAttributes.recycle();
    }

    public final boolean A() {
        return this.f5371a.getPreventCornerOverlap() && !d();
    }

    public final boolean B() {
        return this.f5371a.getPreventCornerOverlap() && d() && this.f5371a.getUseCompatPadding();
    }

    public void C() {
        Drawable drawable = this.f5378h;
        Drawable o = this.f5371a.isClickable() ? o() : this.f5374d;
        this.f5378h = o;
        if (drawable != o) {
            c(o);
        }
    }

    public void D() {
        int a2 = (int) ((A() || B() ? a() : 0.0f) - q());
        MaterialCardView materialCardView = this.f5371a;
        Rect rect = this.f5372b;
        materialCardView.b(rect.left + a2, rect.top + a2, rect.right + a2, rect.bottom + a2);
    }

    public void E() {
        this.f5373c.b(this.f5371a.getCardElevation());
    }

    public void F() {
        if (!y()) {
            this.f5371a.setBackgroundInternal(a(this.f5373c));
        }
        this.f5371a.setForeground(a(this.f5378h));
    }

    public final void G() {
        Drawable drawable;
        if (b.f5626a && (drawable = this.n) != null) {
            ((RippleDrawable) drawable).setColor(this.j);
            return;
        }
        h hVar = this.p;
        if (hVar != null) {
            hVar.a(this.j);
        }
    }

    public void H() {
        this.f5374d.a(this.f5377g, this.m);
    }

    public void a(TypedArray typedArray) {
        ColorStateList a2 = c.a(this.f5371a.getContext(), typedArray, R$styleable.MaterialCardView_strokeColor);
        this.m = a2;
        if (a2 == null) {
            this.m = ColorStateList.valueOf(-1);
        }
        this.f5377g = typedArray.getDimensionPixelSize(R$styleable.MaterialCardView_strokeWidth, 0);
        boolean z = typedArray.getBoolean(R$styleable.MaterialCardView_android_checkable, false);
        this.s = z;
        this.f5371a.setLongClickable(z);
        this.k = c.a(this.f5371a.getContext(), typedArray, R$styleable.MaterialCardView_checkedIconTint);
        b(c.b(this.f5371a.getContext(), typedArray, R$styleable.MaterialCardView_checkedIcon));
        ColorStateList a3 = c.a(this.f5371a.getContext(), typedArray, R$styleable.MaterialCardView_rippleColor);
        this.j = a3;
        if (a3 == null) {
            this.j = ColorStateList.valueOf(c.c.a.c.k.a.a(this.f5371a, R$attr.colorControlHighlight));
        }
        b(c.a(this.f5371a.getContext(), typedArray, R$styleable.MaterialCardView_cardForegroundColor));
        G();
        E();
        H();
        this.f5371a.setBackgroundInternal(a(this.f5373c));
        Drawable o = this.f5371a.isClickable() ? o() : this.f5374d;
        this.f5378h = o;
        this.f5371a.setForeground(a(o));
    }

    public void b(ColorStateList colorStateList) {
        h hVar = this.f5374d;
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        hVar.a(colorStateList);
    }

    public void c(ColorStateList colorStateList) {
        this.k = colorStateList;
        Drawable drawable = this.f5379i;
        if (drawable != null) {
            a.h.c.l.a.a(drawable, colorStateList);
        }
    }

    public void d(ColorStateList colorStateList) {
        this.j = colorStateList;
        G();
    }

    public void e(ColorStateList colorStateList) {
        if (this.m == colorStateList) {
            return;
        }
        this.m = colorStateList;
        H();
    }

    public final Drawable f() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        h h2 = h();
        this.p = h2;
        h2.a(this.j);
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, this.p);
        return stateListDrawable;
    }

    public final Drawable g() {
        if (!b.f5626a) {
            return f();
        }
        this.q = h();
        return new RippleDrawable(this.j, null, this.q);
    }

    public final h h() {
        return new h(this.l);
    }

    public void i() {
        Drawable drawable = this.n;
        if (drawable != null) {
            Rect bounds = drawable.getBounds();
            int i2 = bounds.bottom;
            this.n.setBounds(bounds.left, bounds.top, bounds.right, i2 - 1);
            this.n.setBounds(bounds.left, bounds.top, bounds.right, i2);
        }
    }

    public h j() {
        return this.f5373c;
    }

    public ColorStateList k() {
        return this.f5373c.h();
    }

    public ColorStateList l() {
        return this.f5374d.h();
    }

    public Drawable m() {
        return this.f5379i;
    }

    public ColorStateList n() {
        return this.k;
    }

    public final Drawable o() {
        if (this.n == null) {
            this.n = g();
        }
        if (this.o == null) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.n, this.f5374d, e()});
            this.o = layerDrawable;
            layerDrawable.setId(2, R$id.mtrl_card_checked_layer_id);
        }
        return this.o;
    }

    public float p() {
        return this.f5373c.q();
    }

    public final float q() {
        if (!this.f5371a.getPreventCornerOverlap()) {
            return 0.0f;
        }
        if (Build.VERSION.SDK_INT >= 21 && !this.f5371a.getUseCompatPadding()) {
            return 0.0f;
        }
        double d2 = 1.0d - u;
        double cardViewRadius = this.f5371a.getCardViewRadius();
        Double.isNaN(cardViewRadius);
        return (float) (d2 * cardViewRadius);
    }

    public float r() {
        return this.f5373c.i();
    }

    public ColorStateList s() {
        return this.j;
    }

    public m t() {
        return this.l;
    }

    public int u() {
        ColorStateList colorStateList = this.m;
        if (colorStateList == null) {
            return -1;
        }
        return colorStateList.getDefaultColor();
    }

    public ColorStateList v() {
        return this.m;
    }

    public int w() {
        return this.f5377g;
    }

    public Rect x() {
        return this.f5372b;
    }

    public boolean y() {
        return this.r;
    }

    public boolean z() {
        return this.s;
    }

    public final boolean d() {
        return Build.VERSION.SDK_INT >= 21 && this.f5373c.z();
    }

    public void b(float f2) {
        this.f5373c.c(f2);
        h hVar = this.f5374d;
        if (hVar != null) {
            hVar.c(f2);
        }
        h hVar2 = this.q;
        if (hVar2 != null) {
            hVar2.c(f2);
        }
    }

    public final void c(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 23 && (this.f5371a.getForeground() instanceof InsetDrawable)) {
            ((InsetDrawable) this.f5371a.getForeground()).setDrawable(drawable);
        } else {
            this.f5371a.setForeground(a(drawable));
        }
    }

    public final Drawable e() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable drawable = this.f5379i;
        if (drawable != null) {
            stateListDrawable.addState(t, drawable);
        }
        return stateListDrawable;
    }

    public final float c() {
        return (this.f5371a.getMaxCardElevation() * 1.5f) + (B() ? a() : 0.0f);
    }

    public void b(boolean z) {
        this.s = z;
    }

    public void b(Drawable drawable) {
        this.f5379i = drawable;
        if (drawable != null) {
            Drawable i2 = a.h.c.l.a.i(drawable.mutate());
            this.f5379i = i2;
            a.h.c.l.a.a(i2, this.k);
        }
        if (this.o != null) {
            this.o.setDrawableByLayerId(R$id.mtrl_card_checked_layer_id, e());
        }
    }

    public final float b() {
        return this.f5371a.getMaxCardElevation() + (B() ? a() : 0.0f);
    }

    public void a(boolean z) {
        this.r = z;
    }

    public void a(int i2) {
        if (i2 == this.f5377g) {
            return;
        }
        this.f5377g = i2;
        H();
    }

    public void a(ColorStateList colorStateList) {
        this.f5373c.a(colorStateList);
    }

    public void a(int i2, int i3, int i4, int i5) {
        this.f5372b.set(i2, i3, i4, i5);
        D();
    }

    public void a(float f2) {
        a(this.l.a(f2));
        this.f5378h.invalidateSelf();
        if (B() || A()) {
            D();
        }
        if (B()) {
            F();
        }
    }

    public void a(int i2, int i3) {
        int i4;
        int i5;
        if (this.o != null) {
            int i6 = this.f5375e;
            int i7 = this.f5376f;
            int i8 = (i2 - i6) - i7;
            int i9 = (i3 - i6) - i7;
            if ((Build.VERSION.SDK_INT < 21) || this.f5371a.getUseCompatPadding()) {
                i9 -= (int) Math.ceil(c() * 2.0f);
                i8 -= (int) Math.ceil(b() * 2.0f);
            }
            int i10 = i9;
            int i11 = this.f5375e;
            if (y.q(this.f5371a) == 1) {
                i5 = i8;
                i4 = i11;
            } else {
                i4 = i8;
                i5 = i11;
            }
            this.o.setLayerInset(2, i4, this.f5375e, i5, i10);
        }
    }

    public void a(m mVar) {
        this.l = mVar;
        this.f5373c.setShapeAppearanceModel(mVar);
        this.f5373c.a(!r0.z());
        h hVar = this.f5374d;
        if (hVar != null) {
            hVar.setShapeAppearanceModel(mVar);
        }
        h hVar2 = this.q;
        if (hVar2 != null) {
            hVar2.setShapeAppearanceModel(mVar);
        }
        h hVar3 = this.p;
        if (hVar3 != null) {
            hVar3.setShapeAppearanceModel(mVar);
        }
    }

    public final Drawable a(Drawable drawable) {
        int ceil;
        int i2;
        if ((Build.VERSION.SDK_INT < 21) || this.f5371a.getUseCompatPadding()) {
            int ceil2 = (int) Math.ceil(c());
            ceil = (int) Math.ceil(b());
            i2 = ceil2;
        } else {
            ceil = 0;
            i2 = 0;
        }
        return new C0099a(this, drawable, ceil, i2, ceil, i2);
    }

    public final float a() {
        return Math.max(Math.max(a(this.l.i(), this.f5373c.q()), a(this.l.k(), this.f5373c.r())), Math.max(a(this.l.d(), this.f5373c.d()), a(this.l.b(), this.f5373c.c())));
    }

    public final float a(d dVar, float f2) {
        if (dVar instanceof l) {
            double d2 = 1.0d - u;
            double d3 = f2;
            Double.isNaN(d3);
            return (float) (d2 * d3);
        }
        if (dVar instanceof e) {
            return f2 / 2.0f;
        }
        return 0.0f;
    }
}
