package c.c.a.c.b0;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import c.c.a.c.r.j;
import c.c.a.c.r.l;
import c.c.a.c.t.c;
import c.c.a.c.t.d;
import c.c.a.c.w.f;
import c.c.a.c.w.g;
import c.c.a.c.w.h;
import c.c.a.c.w.m;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$styleable;

/* compiled from: TooltipDrawable.java */
/* loaded from: classes.dex */
public class a extends h implements j.b {
    public final Context A;
    public final Paint.FontMetrics B;
    public final j C;
    public final View.OnLayoutChangeListener D;
    public final Rect E;
    public int F;
    public int G;
    public int H;
    public int I;
    public int J;
    public int K;
    public CharSequence z;

    /* compiled from: TooltipDrawable.java */
    /* renamed from: c.c.a.c.b0.a$a, reason: collision with other inner class name */
    public class ViewOnLayoutChangeListenerC0098a implements View.OnLayoutChangeListener {
        public ViewOnLayoutChangeListenerC0098a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            a.this.c(view);
        }
    }

    public a(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.B = new Paint.FontMetrics();
        this.C = new j(this);
        this.D = new ViewOnLayoutChangeListenerC0098a();
        this.E = new Rect();
        this.A = context;
        this.C.b().density = context.getResources().getDisplayMetrics().density;
        this.C.b().setTextAlign(Paint.Align.CENTER);
    }

    public final float D() {
        int i2;
        if (((this.E.right - getBounds().right) - this.K) - this.I < 0) {
            i2 = ((this.E.right - getBounds().right) - this.K) - this.I;
        } else {
            if (((this.E.left - getBounds().left) - this.K) + this.I <= 0) {
                return 0.0f;
            }
            i2 = ((this.E.left - getBounds().left) - this.K) + this.I;
        }
        return i2;
    }

    public final float E() {
        this.C.b().getFontMetrics(this.B);
        Paint.FontMetrics fontMetrics = this.B;
        return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
    }

    public final f F() {
        float f2 = -D();
        double width = getBounds().width();
        double d2 = this.J;
        double sqrt = Math.sqrt(2.0d);
        Double.isNaN(d2);
        Double.isNaN(width);
        float f3 = ((float) (width - (d2 * sqrt))) / 2.0f;
        return new c.c.a.c.w.j(new g(this.J), Math.min(Math.max(f2, -f3), f3));
    }

    public final float G() {
        CharSequence charSequence = this.z;
        if (charSequence == null) {
            return 0.0f;
        }
        return this.C.a(charSequence.toString());
    }

    public void b(View view) {
        if (view == null) {
            return;
        }
        c(view);
        view.addOnLayoutChangeListener(this.D);
    }

    public final void c(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        this.K = iArr[0];
        view.getWindowVisibleDisplayFrame(this.E);
    }

    @Override // c.c.a.c.w.h, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.save();
        float D = D();
        double d2 = this.J;
        double sqrt = Math.sqrt(2.0d);
        Double.isNaN(d2);
        double d3 = d2 * sqrt;
        double d4 = this.J;
        Double.isNaN(d4);
        canvas.translate(D, (float) (-(d3 - d4)));
        super.draw(canvas);
        f(canvas);
        canvas.restore();
    }

    public final void f(Canvas canvas) {
        if (this.z == null) {
            return;
        }
        int a2 = (int) a(getBounds());
        if (this.C.a() != null) {
            this.C.b().drawableState = getState();
            this.C.a(this.A);
        }
        CharSequence charSequence = this.z;
        canvas.drawText(charSequence, 0, charSequence.length(), r0.centerX(), a2, this.C.b());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) Math.max(this.C.b().getTextSize(), this.H);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) Math.max((this.F * 2) + G(), this.G);
    }

    @Override // c.c.a.c.w.h, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        m.b m = n().m();
        m.a(F());
        setShapeAppearanceModel(m.a());
    }

    @Override // c.c.a.c.w.h, android.graphics.drawable.Drawable, c.c.a.c.r.j.b
    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    public static a a(Context context, AttributeSet attributeSet, int i2, int i3) {
        a aVar = new a(context, attributeSet, i2, i3);
        aVar.a(attributeSet, i2, i3);
        return aVar;
    }

    public final void a(AttributeSet attributeSet, int i2, int i3) {
        TypedArray c2 = l.c(this.A, attributeSet, R$styleable.Tooltip, i2, i3, new int[0]);
        this.J = this.A.getResources().getDimensionPixelSize(R$dimen.mtrl_tooltip_arrowSize);
        m.b m = n().m();
        m.a(F());
        setShapeAppearanceModel(m.a());
        a(c2.getText(R$styleable.Tooltip_android_text));
        a(c.c(this.A, c2, R$styleable.Tooltip_android_textAppearance));
        a(ColorStateList.valueOf(c2.getColor(R$styleable.Tooltip_backgroundTint, c.c.a.c.k.a.a(a.h.c.a.c(c.c.a.c.k.a.a(this.A, R.attr.colorBackground, a.class.getCanonicalName()), 229), a.h.c.a.c(c.c.a.c.k.a.a(this.A, R$attr.colorOnBackground, a.class.getCanonicalName()), 153)))));
        b(ColorStateList.valueOf(c.c.a.c.k.a.a(this.A, R$attr.colorSurface, a.class.getCanonicalName())));
        this.F = c2.getDimensionPixelSize(R$styleable.Tooltip_android_padding, 0);
        this.G = c2.getDimensionPixelSize(R$styleable.Tooltip_android_minWidth, 0);
        this.H = c2.getDimensionPixelSize(R$styleable.Tooltip_android_minHeight, 0);
        this.I = c2.getDimensionPixelSize(R$styleable.Tooltip_android_layout_margin, 0);
        c2.recycle();
    }

    public void a(CharSequence charSequence) {
        if (TextUtils.equals(this.z, charSequence)) {
            return;
        }
        this.z = charSequence;
        this.C.a(true);
        invalidateSelf();
    }

    public void a(d dVar) {
        this.C.a(dVar, this.A);
    }

    public void a(View view) {
        if (view == null) {
            return;
        }
        view.removeOnLayoutChangeListener(this.D);
    }

    @Override // c.c.a.c.r.j.b
    public void a() {
        invalidateSelf();
    }

    public final float a(Rect rect) {
        return rect.centerY() - E();
    }
}
