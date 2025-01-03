package c.c.a.c.i;

import a.h.c.l.b;
import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextUtils;
import android.util.AttributeSet;
import c.c.a.c.r.j;
import c.c.a.c.r.l;
import c.c.a.c.t.c;
import c.c.a.c.t.d;
import c.c.a.c.w.h;
import com.google.android.material.R$styleable;
import com.google.zxing.client.j2se.DecodeWorker;
import com.google.zxing.view.ViewfinderView;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* compiled from: ChipDrawable.java */
/* loaded from: classes.dex */
public class a extends h implements b, Drawable.Callback, j.b {
    public static final int[] J0 = {R.attr.state_enabled};
    public static final ShapeDrawable K0 = new ShapeDrawable(new OvalShape());
    public ColorStateList A;
    public PorterDuff.Mode A0;
    public float B;
    public int[] B0;
    public float C;
    public boolean C0;
    public ColorStateList D;
    public ColorStateList D0;
    public float E;
    public WeakReference<InterfaceC0100a> E0;
    public ColorStateList F;
    public TextUtils.TruncateAt F0;
    public CharSequence G;
    public boolean G0;
    public boolean H;
    public int H0;
    public Drawable I;
    public boolean I0;
    public ColorStateList J;
    public float K;
    public boolean L;
    public boolean M;
    public Drawable N;
    public Drawable O;
    public ColorStateList P;
    public float Q;
    public CharSequence R;
    public boolean S;
    public boolean T;
    public Drawable U;
    public ColorStateList V;
    public c.c.a.c.a.h W;
    public c.c.a.c.a.h X;
    public float Y;
    public float Z;
    public float a0;
    public float b0;
    public float c0;
    public float d0;
    public float e0;
    public float f0;
    public final Context g0;
    public final Paint h0;
    public final Paint i0;
    public final Paint.FontMetrics j0;
    public final RectF k0;
    public final PointF l0;
    public final Path m0;
    public final j n0;
    public int o0;
    public int p0;
    public int q0;
    public int r0;
    public int s0;
    public int t0;
    public boolean u0;
    public int v0;
    public int w0;
    public ColorFilter x0;
    public PorterDuffColorFilter y0;
    public ColorStateList z;
    public ColorStateList z0;

    /* compiled from: ChipDrawable.java */
    /* renamed from: c.c.a.c.i.a$a, reason: collision with other inner class name */
    public interface InterfaceC0100a {
        void a();
    }

    public a(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.C = -1.0f;
        this.h0 = new Paint(1);
        this.j0 = new Paint.FontMetrics();
        this.k0 = new RectF();
        this.l0 = new PointF();
        this.m0 = new Path();
        this.w0 = ViewfinderView.OPAQUE;
        this.A0 = PorterDuff.Mode.SRC_IN;
        Paint paint = null;
        this.E0 = new WeakReference<>(null);
        a(context);
        this.g0 = context;
        j jVar = new j(this);
        this.n0 = jVar;
        this.G = "";
        jVar.b().density = context.getResources().getDisplayMetrics().density;
        this.i0 = null;
        if (0 != 0) {
            paint.setStyle(Paint.Style.STROKE);
        }
        setState(J0);
        b(J0);
        this.G0 = true;
        if (c.c.a.c.u.b.f5626a) {
            K0.setTint(-1);
        }
    }

    public static a a(Context context, AttributeSet attributeSet, int i2, int i3) {
        a aVar = new a(context, attributeSet, i2, i3);
        aVar.a(attributeSet, i2, i3);
        return aVar;
    }

    public static boolean j(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    public void A(int i2) {
        p(this.g0.getResources().getDimension(i2));
    }

    public void B(int i2) {
        this.H0 = i2;
    }

    public void C(int i2) {
        i(a.b.b.a.a.b(this.g0, i2));
    }

    public float D() {
        if (s0() || r0()) {
            return this.Z + this.K + this.a0;
        }
        return 0.0f;
    }

    public float E() {
        if (t0()) {
            return this.d0 + this.Q + this.e0;
        }
        return 0.0f;
    }

    public final float F() {
        this.n0.b().getFontMetrics(this.j0);
        Paint.FontMetrics fontMetrics = this.j0;
        return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
    }

    public final boolean G() {
        return this.T && this.U != null && this.S;
    }

    public Drawable H() {
        return this.U;
    }

    public ColorStateList I() {
        return this.V;
    }

    public ColorStateList J() {
        return this.A;
    }

    public float K() {
        return this.I0 ? q() : this.C;
    }

    public float L() {
        return this.f0;
    }

    public Drawable M() {
        Drawable drawable = this.I;
        if (drawable != null) {
            return a.h.c.l.a.h(drawable);
        }
        return null;
    }

    public float N() {
        return this.K;
    }

    public ColorStateList O() {
        return this.J;
    }

    public float P() {
        return this.B;
    }

    public float Q() {
        return this.Y;
    }

    public ColorStateList R() {
        return this.D;
    }

    public float S() {
        return this.E;
    }

    public Drawable T() {
        Drawable drawable = this.N;
        if (drawable != null) {
            return a.h.c.l.a.h(drawable);
        }
        return null;
    }

    public CharSequence U() {
        return this.R;
    }

    public float V() {
        return this.e0;
    }

    public float W() {
        return this.Q;
    }

    public float X() {
        return this.d0;
    }

    public int[] Y() {
        return this.B0;
    }

    public ColorStateList Z() {
        return this.P;
    }

    public TextUtils.TruncateAt a0() {
        return this.F0;
    }

    public final void b(Canvas canvas, Rect rect) {
        if (this.I0) {
            return;
        }
        this.h0.setColor(this.p0);
        this.h0.setStyle(Paint.Style.FILL);
        this.h0.setColorFilter(k0());
        this.k0.set(rect);
        canvas.drawRoundRect(this.k0, K(), K(), this.h0);
    }

    public c.c.a.c.a.h b0() {
        return this.X;
    }

    public final void c(Canvas canvas, Rect rect) {
        if (s0()) {
            a(rect, this.k0);
            RectF rectF = this.k0;
            float f2 = rectF.left;
            float f3 = rectF.top;
            canvas.translate(f2, f3);
            this.I.setBounds(0, 0, (int) this.k0.width(), (int) this.k0.height());
            this.I.draw(canvas);
            canvas.translate(-f2, -f3);
        }
    }

    public float c0() {
        return this.a0;
    }

    public final void d(Canvas canvas, Rect rect) {
        if (this.E <= 0.0f || this.I0) {
            return;
        }
        this.h0.setColor(this.r0);
        this.h0.setStyle(Paint.Style.STROKE);
        if (!this.I0) {
            this.h0.setColorFilter(k0());
        }
        RectF rectF = this.k0;
        float f2 = rect.left;
        float f3 = this.E;
        rectF.set(f2 + (f3 / 2.0f), rect.top + (f3 / 2.0f), rect.right - (f3 / 2.0f), rect.bottom - (f3 / 2.0f));
        float f4 = this.C - (this.E / 2.0f);
        canvas.drawRoundRect(this.k0, f4, f4, this.h0);
    }

    public float d0() {
        return this.Z;
    }

    @Override // c.c.a.c.w.h, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        if (bounds.isEmpty() || getAlpha() == 0) {
            return;
        }
        int i2 = this.w0;
        int a2 = i2 < 255 ? c.c.a.c.g.a.a(canvas, bounds.left, bounds.top, bounds.right, bounds.bottom, i2) : 0;
        e(canvas, bounds);
        b(canvas, bounds);
        if (this.I0) {
            super.draw(canvas);
        }
        d(canvas, bounds);
        g(canvas, bounds);
        c(canvas, bounds);
        a(canvas, bounds);
        if (this.G0) {
            i(canvas, bounds);
        }
        f(canvas, bounds);
        h(canvas, bounds);
        if (this.w0 < 255) {
            canvas.restoreToCount(a2);
        }
    }

    public final void e(Canvas canvas, Rect rect) {
        if (this.I0) {
            return;
        }
        this.h0.setColor(this.o0);
        this.h0.setStyle(Paint.Style.FILL);
        this.k0.set(rect);
        canvas.drawRoundRect(this.k0, K(), K(), this.h0);
    }

    public ColorStateList e0() {
        return this.F;
    }

    public final void f(Canvas canvas, Rect rect) {
        if (t0()) {
            c(rect, this.k0);
            RectF rectF = this.k0;
            float f2 = rectF.left;
            float f3 = rectF.top;
            canvas.translate(f2, f3);
            this.N.setBounds(0, 0, (int) this.k0.width(), (int) this.k0.height());
            if (c.c.a.c.u.b.f5626a) {
                this.O.setBounds(this.N.getBounds());
                this.O.jumpToCurrentState();
                this.O.draw(canvas);
            } else {
                this.N.draw(canvas);
            }
            canvas.translate(-f2, -f3);
        }
    }

    public c.c.a.c.a.h f0() {
        return this.W;
    }

    public void g(boolean z) {
        if (this.C0 != z) {
            this.C0 = z;
            u0();
            onStateChange(getState());
        }
    }

    public CharSequence g0() {
        return this.G;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.w0;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.x0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.B;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.min(Math.round(this.Y + D() + this.b0 + this.n0.a(g0().toString()) + this.c0 + E() + this.f0), this.H0);
    }

    @Override // c.c.a.c.w.h, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // c.c.a.c.w.h, android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(Outline outline) {
        if (this.I0) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (bounds.isEmpty()) {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.C);
        } else {
            outline.setRoundRect(bounds, this.C);
        }
        outline.setAlpha(getAlpha() / 255.0f);
    }

    public final void h(Canvas canvas, Rect rect) {
        Paint paint = this.i0;
        if (paint != null) {
            paint.setColor(a.h.c.a.c(-16777216, 127));
            canvas.drawRect(rect, this.i0);
            if (s0() || r0()) {
                a(rect, this.k0);
                canvas.drawRect(this.k0, this.i0);
            }
            if (this.G != null) {
                canvas.drawLine(rect.left, rect.exactCenterY(), rect.right, rect.exactCenterY(), this.i0);
            }
            if (t0()) {
                c(rect, this.k0);
                canvas.drawRect(this.k0, this.i0);
            }
            this.i0.setColor(a.h.c.a.c(DecodeWorker.RED, 127));
            b(rect, this.k0);
            canvas.drawRect(this.k0, this.i0);
            this.i0.setColor(a.h.c.a.c(-16711936, 127));
            d(rect, this.k0);
            canvas.drawRect(this.k0, this.i0);
        }
    }

    public d h0() {
        return this.n0.a();
    }

    public final void i(Canvas canvas, Rect rect) {
        if (this.G != null) {
            Paint.Align a2 = a(rect, this.l0);
            e(rect, this.k0);
            if (this.n0.a() != null) {
                this.n0.b().drawableState = getState();
                this.n0.a(this.g0);
            }
            this.n0.b().setTextAlign(a2);
            int i2 = 0;
            boolean z = Math.round(this.n0.a(g0().toString())) > Math.round(this.k0.width());
            if (z) {
                i2 = canvas.save();
                canvas.clipRect(this.k0);
            }
            CharSequence charSequence = this.G;
            if (z && this.F0 != null) {
                charSequence = TextUtils.ellipsize(charSequence, this.n0.b(), this.k0.width(), this.F0);
            }
            CharSequence charSequence2 = charSequence;
            int length = charSequence2.length();
            PointF pointF = this.l0;
            canvas.drawText(charSequence2, 0, length, pointF.x, pointF.y, this.n0.b());
            if (z) {
                canvas.restoreToCount(i2);
            }
        }
    }

    public float i0() {
        return this.c0;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // c.c.a.c.w.h, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return j(this.z) || j(this.A) || j(this.D) || (this.C0 && j(this.D0)) || b(this.n0.a()) || G() || f(this.I) || f(this.U) || j(this.z0);
    }

    public float j0() {
        return this.b0;
    }

    public void k(float f2) {
        if (this.E != f2) {
            this.E = f2;
            this.h0.setStrokeWidth(f2);
            if (this.I0) {
                super.e(f2);
            }
            invalidateSelf();
        }
    }

    public final ColorFilter k0() {
        ColorFilter colorFilter = this.x0;
        return colorFilter != null ? colorFilter : this.y0;
    }

    public void l(int i2) {
        c(a.b.b.a.a.c(this.g0, i2));
    }

    public boolean l0() {
        return this.C0;
    }

    public void m(int i2) {
        h(this.g0.getResources().getDimension(i2));
    }

    public boolean m0() {
        return this.S;
    }

    public void n(int i2) {
        e(a.b.b.a.a.b(this.g0, i2));
    }

    public boolean n0() {
        return f(this.N);
    }

    public void o(int i2) {
        d(this.g0.getResources().getBoolean(i2));
    }

    public boolean o0() {
        return this.M;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i2) {
        boolean onLayoutDirectionChanged = super.onLayoutDirectionChanged(i2);
        if (s0()) {
            onLayoutDirectionChanged |= a.h.c.l.a.a(this.I, i2);
        }
        if (r0()) {
            onLayoutDirectionChanged |= a.h.c.l.a.a(this.U, i2);
        }
        if (t0()) {
            onLayoutDirectionChanged |= a.h.c.l.a.a(this.N, i2);
        }
        if (!onLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i2) {
        boolean onLevelChange = super.onLevelChange(i2);
        if (s0()) {
            onLevelChange |= this.I.setLevel(i2);
        }
        if (r0()) {
            onLevelChange |= this.U.setLevel(i2);
        }
        if (t0()) {
            onLevelChange |= this.N.setLevel(i2);
        }
        if (onLevelChange) {
            invalidateSelf();
        }
        return onLevelChange;
    }

    @Override // c.c.a.c.w.h, android.graphics.drawable.Drawable, c.c.a.c.r.j.b
    public boolean onStateChange(int[] iArr) {
        if (this.I0) {
            super.onStateChange(iArr);
        }
        return a(iArr, Y());
    }

    public void p(int i2) {
        i(this.g0.getResources().getDimension(i2));
    }

    public void p0() {
        InterfaceC0100a interfaceC0100a = this.E0.get();
        if (interfaceC0100a != null) {
            interfaceC0100a.a();
        }
    }

    public void q(int i2) {
        j(this.g0.getResources().getDimension(i2));
    }

    public boolean q0() {
        return this.G0;
    }

    public void r(int i2) {
        f(a.b.b.a.a.b(this.g0, i2));
    }

    public final boolean r0() {
        return this.T && this.U != null && this.u0;
    }

    public void s(int i2) {
        k(this.g0.getResources().getDimension(i2));
    }

    public final boolean s0() {
        return this.H && this.I != null;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    @Override // c.c.a.c.w.h, android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        if (this.w0 != i2) {
            this.w0 = i2;
            invalidateSelf();
        }
    }

    @Override // c.c.a.c.w.h, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.x0 != colorFilter) {
            this.x0 = colorFilter;
            invalidateSelf();
        }
    }

    @Override // c.c.a.c.w.h, android.graphics.drawable.Drawable, a.h.c.l.b
    public void setTintList(ColorStateList colorStateList) {
        if (this.z0 != colorStateList) {
            this.z0 = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // c.c.a.c.w.h, android.graphics.drawable.Drawable, a.h.c.l.b
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.A0 != mode) {
            this.A0 = mode;
            this.y0 = c.c.a.c.n.a.a(this, this.z0, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (s0()) {
            visible |= this.I.setVisible(z, z2);
        }
        if (r0()) {
            visible |= this.U.setVisible(z, z2);
        }
        if (t0()) {
            visible |= this.N.setVisible(z, z2);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    public void t(int i2) {
        l(this.g0.getResources().getDimension(i2));
    }

    public final boolean t0() {
        return this.M && this.N != null;
    }

    public void u(int i2) {
        d(a.b.b.a.a.c(this.g0, i2));
    }

    public final void u0() {
        this.D0 = this.C0 ? c.c.a.c.u.b.b(this.F) : null;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public void v(int i2) {
        m(this.g0.getResources().getDimension(i2));
    }

    @TargetApi(21)
    public final void v0() {
        this.O = new RippleDrawable(c.c.a.c.u.b.b(e0()), this.N, K0);
    }

    public void w(int i2) {
        n(this.g0.getResources().getDimension(i2));
    }

    public void x(int i2) {
        h(a.b.b.a.a.b(this.g0, i2));
    }

    public void y(int i2) {
        a(c.c.a.c.a.h.a(this.g0, i2));
    }

    public void z(int i2) {
        o(this.g0.getResources().getDimension(i2));
    }

    public void G(int i2) {
        r(this.g0.getResources().getDimension(i2));
    }

    @Deprecated
    public void j(int i2) {
        f(this.g0.getResources().getDimension(i2));
    }

    public void l(float f2) {
        if (this.e0 != f2) {
            this.e0 = f2;
            invalidateSelf();
            if (t0()) {
                p0();
            }
        }
    }

    public void m(float f2) {
        if (this.Q != f2) {
            this.Q = f2;
            invalidateSelf();
            if (t0()) {
                p0();
            }
        }
    }

    public void n(float f2) {
        if (this.d0 != f2) {
            this.d0 = f2;
            invalidateSelf();
            if (t0()) {
                p0();
            }
        }
    }

    public void o(float f2) {
        if (this.a0 != f2) {
            float D = D();
            this.a0 = f2;
            float D2 = D();
            invalidateSelf();
            if (D != D2) {
                p0();
            }
        }
    }

    public void p(float f2) {
        if (this.Z != f2) {
            float D = D();
            this.Z = f2;
            float D2 = D();
            invalidateSelf();
            if (D != D2) {
                p0();
            }
        }
    }

    public void q(float f2) {
        if (this.c0 != f2) {
            this.c0 = f2;
            invalidateSelf();
            p0();
        }
    }

    public void r(float f2) {
        if (this.b0 != f2) {
            this.b0 = f2;
            invalidateSelf();
            p0();
        }
    }

    public void D(int i2) {
        b(c.c.a.c.a.h.a(this.g0, i2));
    }

    public void E(int i2) {
        a(new d(this.g0, i2));
    }

    public void F(int i2) {
        q(this.g0.getResources().getDimension(i2));
    }

    public final void a(AttributeSet attributeSet, int i2, int i3) {
        TypedArray c2 = l.c(this.g0, attributeSet, R$styleable.Chip, i2, i3, new int[0]);
        this.I0 = c2.hasValue(R$styleable.Chip_shapeAppearance);
        g(c.a(this.g0, c2, R$styleable.Chip_chipSurfaceColor));
        d(c.a(this.g0, c2, R$styleable.Chip_chipBackgroundColor));
        i(c2.getDimension(R$styleable.Chip_chipMinHeight, 0.0f));
        if (c2.hasValue(R$styleable.Chip_chipCornerRadius)) {
            f(c2.getDimension(R$styleable.Chip_chipCornerRadius, 0.0f));
        }
        f(c.a(this.g0, c2, R$styleable.Chip_chipStrokeColor));
        k(c2.getDimension(R$styleable.Chip_chipStrokeWidth, 0.0f));
        i(c.a(this.g0, c2, R$styleable.Chip_rippleColor));
        b(c2.getText(R$styleable.Chip_android_text));
        a(c.c(this.g0, c2, R$styleable.Chip_android_textAppearance));
        int i4 = c2.getInt(R$styleable.Chip_android_ellipsize, 0);
        if (i4 == 1) {
            a(TextUtils.TruncateAt.START);
        } else if (i4 == 2) {
            a(TextUtils.TruncateAt.MIDDLE);
        } else if (i4 == 3) {
            a(TextUtils.TruncateAt.END);
        }
        d(c2.getBoolean(R$styleable.Chip_chipIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") == null) {
            d(c2.getBoolean(R$styleable.Chip_chipIconEnabled, false));
        }
        c(c.b(this.g0, c2, R$styleable.Chip_chipIcon));
        if (c2.hasValue(R$styleable.Chip_chipIconTint)) {
            e(c.a(this.g0, c2, R$styleable.Chip_chipIconTint));
        }
        h(c2.getDimension(R$styleable.Chip_chipIconSize, 0.0f));
        e(c2.getBoolean(R$styleable.Chip_closeIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") == null) {
            e(c2.getBoolean(R$styleable.Chip_closeIconEnabled, false));
        }
        d(c.b(this.g0, c2, R$styleable.Chip_closeIcon));
        h(c.a(this.g0, c2, R$styleable.Chip_closeIconTint));
        m(c2.getDimension(R$styleable.Chip_closeIconSize, 0.0f));
        b(c2.getBoolean(R$styleable.Chip_android_checkable, false));
        c(c2.getBoolean(R$styleable.Chip_checkedIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") == null) {
            c(c2.getBoolean(R$styleable.Chip_checkedIconEnabled, false));
        }
        b(c.b(this.g0, c2, R$styleable.Chip_checkedIcon));
        if (c2.hasValue(R$styleable.Chip_checkedIconTint)) {
            c(c.a(this.g0, c2, R$styleable.Chip_checkedIconTint));
        }
        b(c.c.a.c.a.h.a(this.g0, c2, R$styleable.Chip_showMotionSpec));
        a(c.c.a.c.a.h.a(this.g0, c2, R$styleable.Chip_hideMotionSpec));
        j(c2.getDimension(R$styleable.Chip_chipStartPadding, 0.0f));
        p(c2.getDimension(R$styleable.Chip_iconStartPadding, 0.0f));
        o(c2.getDimension(R$styleable.Chip_iconEndPadding, 0.0f));
        r(c2.getDimension(R$styleable.Chip_textStartPadding, 0.0f));
        q(c2.getDimension(R$styleable.Chip_textEndPadding, 0.0f));
        n(c2.getDimension(R$styleable.Chip_closeIconStartPadding, 0.0f));
        l(c2.getDimension(R$styleable.Chip_closeIconEndPadding, 0.0f));
        g(c2.getDimension(R$styleable.Chip_chipEndPadding, 0.0f));
        B(c2.getDimensionPixelSize(R$styleable.Chip_android_maxWidth, Integer.MAX_VALUE));
        c2.recycle();
    }

    public void j(float f2) {
        if (this.Y != f2) {
            this.Y = f2;
            invalidateSelf();
            p0();
        }
    }

    public final void g(Canvas canvas, Rect rect) {
        this.h0.setColor(this.s0);
        this.h0.setStyle(Paint.Style.FILL);
        this.k0.set(rect);
        if (!this.I0) {
            canvas.drawRoundRect(this.k0, K(), K(), this.h0);
        } else {
            b(new RectF(rect), this.m0);
            super.a(canvas, this.h0, this.m0, e());
        }
    }

    public final void e(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (this.G != null) {
            float D = this.Y + D() + this.b0;
            float E = this.f0 + E() + this.c0;
            if (a.h.c.l.a.e(this) == 0) {
                rectF.left = rect.left + D;
                rectF.right = rect.right - E;
            } else {
                rectF.left = rect.left + E;
                rectF.right = rect.right - D;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    public final void b(Rect rect, RectF rectF) {
        rectF.set(rect);
        if (t0()) {
            float f2 = this.f0 + this.e0 + this.Q + this.d0 + this.c0;
            if (a.h.c.l.a.e(this) == 0) {
                rectF.right = rect.right - f2;
            } else {
                rectF.left = rect.left + f2;
            }
        }
    }

    public void k(int i2) {
        g(this.g0.getResources().getDimension(i2));
    }

    public final void c(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (t0()) {
            float f2 = this.f0 + this.e0;
            if (a.h.c.l.a.e(this) == 0) {
                float f3 = rect.right - f2;
                rectF.right = f3;
                rectF.left = f3 - this.Q;
            } else {
                float f4 = rect.left + f2;
                rectF.left = f4;
                rectF.right = f4 + this.Q;
            }
            float exactCenterY = rect.exactCenterY();
            float f5 = this.Q;
            float f6 = exactCenterY - (f5 / 2.0f);
            rectF.top = f6;
            rectF.bottom = f6 + f5;
        }
    }

    public final void d(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (t0()) {
            float f2 = this.f0 + this.e0 + this.Q + this.d0 + this.c0;
            if (a.h.c.l.a.e(this) == 0) {
                float f3 = rect.right;
                rectF.right = f3;
                rectF.left = f3 - f2;
            } else {
                int i2 = rect.left;
                rectF.left = i2;
                rectF.right = i2 + f2;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    public final void g(ColorStateList colorStateList) {
        if (this.z != colorStateList) {
            this.z = colorStateList;
            onStateChange(getState());
        }
    }

    public static boolean f(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    public boolean b(int[] iArr) {
        if (Arrays.equals(this.B0, iArr)) {
            return false;
        }
        this.B0 = iArr;
        if (t0()) {
            return a(getState(), iArr);
        }
        return false;
    }

    @Deprecated
    public void f(float f2) {
        if (this.C != f2) {
            this.C = f2;
            setShapeAppearanceModel(n().a(f2));
        }
    }

    public void g(int i2) {
        c(a.b.b.a.a.b(this.g0, i2));
    }

    public void g(float f2) {
        if (this.f0 != f2) {
            this.f0 = f2;
            invalidateSelf();
            p0();
        }
    }

    public static boolean b(d dVar) {
        ColorStateList colorStateList;
        return (dVar == null || (colorStateList = dVar.f5609b) == null || !colorStateList.isStateful()) ? false : true;
    }

    public final void e(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public void f(ColorStateList colorStateList) {
        if (this.D != colorStateList) {
            this.D = colorStateList;
            if (this.I0) {
                b(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void e(ColorStateList colorStateList) {
        this.L = true;
        if (this.J != colorStateList) {
            this.J = colorStateList;
            if (s0()) {
                a.h.c.l.a.a(this.I, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void b(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (TextUtils.equals(this.G, charSequence)) {
            return;
        }
        this.G = charSequence;
        this.n0.a(true);
        invalidateSelf();
        p0();
    }

    public void c(Drawable drawable) {
        Drawable M = M();
        if (M != drawable) {
            float D = D();
            this.I = drawable != null ? a.h.c.l.a.i(drawable).mutate() : null;
            float D2 = D();
            e(M);
            if (s0()) {
                a(this.I);
            }
            invalidateSelf();
            if (D != D2) {
                p0();
            }
        }
    }

    public void d(ColorStateList colorStateList) {
        if (this.A != colorStateList) {
            this.A = colorStateList;
            onStateChange(getState());
        }
    }

    public void h(float f2) {
        if (this.K != f2) {
            float D = D();
            this.K = f2;
            float D2 = D();
            invalidateSelf();
            if (D != D2) {
                p0();
            }
        }
    }

    public void i(int i2) {
        d(a.b.b.a.a.b(this.g0, i2));
    }

    public void i(float f2) {
        if (this.B != f2) {
            this.B = f2;
            invalidateSelf();
            p0();
        }
    }

    public void d(boolean z) {
        if (this.H != z) {
            boolean s0 = s0();
            this.H = z;
            boolean s02 = s0();
            if (s0 != s02) {
                if (s02) {
                    a(this.I);
                } else {
                    e(this.I);
                }
                invalidateSelf();
                p0();
            }
        }
    }

    public void f(int i2) {
        b(a.b.b.a.a.c(this.g0, i2));
    }

    public void f(boolean z) {
        this.G0 = z;
    }

    public void b(boolean z) {
        if (this.S != z) {
            this.S = z;
            float D = D();
            if (!z && this.u0) {
                this.u0 = false;
            }
            float D2 = D();
            invalidateSelf();
            if (D != D2) {
                p0();
            }
        }
    }

    public void e(boolean z) {
        if (this.M != z) {
            boolean t0 = t0();
            this.M = z;
            boolean t02 = t0();
            if (t0 != t02) {
                if (t02) {
                    a(this.N);
                } else {
                    e(this.N);
                }
                invalidateSelf();
                p0();
            }
        }
    }

    public void i(ColorStateList colorStateList) {
        if (this.F != colorStateList) {
            this.F = colorStateList;
            u0();
            onStateChange(getState());
        }
    }

    public void h(ColorStateList colorStateList) {
        if (this.P != colorStateList) {
            this.P = colorStateList;
            if (t0()) {
                a.h.c.l.a.a(this.N, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void c(boolean z) {
        if (this.T != z) {
            boolean r0 = r0();
            this.T = z;
            boolean r02 = r0();
            if (r0 != r02) {
                if (r02) {
                    a(this.U);
                } else {
                    e(this.U);
                }
                invalidateSelf();
                p0();
            }
        }
    }

    public void d(Drawable drawable) {
        Drawable T = T();
        if (T != drawable) {
            float E = E();
            this.N = drawable != null ? a.h.c.l.a.i(drawable).mutate() : null;
            if (c.c.a.c.u.b.f5626a) {
                v0();
            }
            float E2 = E();
            e(T);
            if (t0()) {
                a(this.N);
            }
            invalidateSelf();
            if (E != E2) {
                p0();
            }
        }
    }

    public void h(int i2) {
        c(this.g0.getResources().getBoolean(i2));
    }

    public void b(Drawable drawable) {
        if (this.U != drawable) {
            float D = D();
            this.U = drawable;
            float D2 = D();
            e(this.U);
            a(this.U);
            invalidateSelf();
            if (D != D2) {
                p0();
            }
        }
    }

    public void e(int i2) {
        b(this.g0.getResources().getBoolean(i2));
    }

    public void c(ColorStateList colorStateList) {
        if (this.V != colorStateList) {
            this.V = colorStateList;
            if (G()) {
                a.h.c.l.a.a(this.U, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void b(c.c.a.c.a.h hVar) {
        this.W = hVar;
    }

    public void a(InterfaceC0100a interfaceC0100a) {
        this.E0 = new WeakReference<>(interfaceC0100a);
    }

    public void a(RectF rectF) {
        d(getBounds(), rectF);
    }

    public final void a(Canvas canvas, Rect rect) {
        if (r0()) {
            a(rect, this.k0);
            RectF rectF = this.k0;
            float f2 = rectF.left;
            float f3 = rectF.top;
            canvas.translate(f2, f3);
            this.U.setBounds(0, 0, (int) this.k0.width(), (int) this.k0.height());
            this.U.draw(canvas);
            canvas.translate(-f2, -f3);
        }
    }

    public final void a(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (s0() || r0()) {
            float f2 = this.Y + this.Z;
            if (a.h.c.l.a.e(this) == 0) {
                float f3 = rect.left + f2;
                rectF.left = f3;
                rectF.right = f3 + this.K;
            } else {
                float f4 = rect.right - f2;
                rectF.right = f4;
                rectF.left = f4 - this.K;
            }
            float exactCenterY = rect.exactCenterY();
            float f5 = this.K;
            float f6 = exactCenterY - (f5 / 2.0f);
            rectF.top = f6;
            rectF.bottom = f6 + f5;
        }
    }

    public Paint.Align a(Rect rect, PointF pointF) {
        pointF.set(0.0f, 0.0f);
        Paint.Align align = Paint.Align.LEFT;
        if (this.G != null) {
            float D = this.Y + D() + this.b0;
            if (a.h.c.l.a.e(this) == 0) {
                pointF.x = rect.left + D;
                align = Paint.Align.LEFT;
            } else {
                pointF.x = rect.right - D;
                align = Paint.Align.RIGHT;
            }
            pointF.y = rect.centerY() - F();
        }
        return align;
    }

    @Override // c.c.a.c.r.j.b
    public void a() {
        p0();
        invalidateSelf();
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(int[] r7, int[] r8) {
        /*
            Method dump skipped, instructions count: 334
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.c.i.a.a(int[], int[]):boolean");
    }

    public final void a(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        a.h.c.l.a.a(drawable, a.h.c.l.a.e(this));
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.N) {
            if (drawable.isStateful()) {
                drawable.setState(Y());
            }
            a.h.c.l.a.a(drawable, this.P);
            return;
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
        Drawable drawable2 = this.I;
        if (drawable == drawable2 && this.L) {
            a.h.c.l.a.a(drawable2, this.J);
        }
    }

    public static boolean a(int[] iArr, int i2) {
        if (iArr == null) {
            return false;
        }
        for (int i3 : iArr) {
            if (i3 == i2) {
                return true;
            }
        }
        return false;
    }

    public void a(d dVar) {
        this.n0.a(dVar, this.g0);
    }

    public void a(TextUtils.TruncateAt truncateAt) {
        this.F0 = truncateAt;
    }

    public void a(CharSequence charSequence) {
        if (this.R != charSequence) {
            this.R = a.h.h.a.b().a(charSequence);
            invalidateSelf();
        }
    }

    public void a(c.c.a.c.a.h hVar) {
        this.X = hVar;
    }
}
