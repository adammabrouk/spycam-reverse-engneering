package com.google.android.material.imageview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.appcompat.widget.AppCompatImageView;
import c.c.a.c.t.c;
import c.c.a.c.w.h;
import c.c.a.c.w.m;
import c.c.a.c.w.n;
import c.c.a.c.w.p;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;

/* loaded from: classes.dex */
public class ShapeableImageView extends AppCompatImageView implements p {
    public static final int l = R$style.Widget_MaterialComponents_ShapeableImageView;

    /* renamed from: a, reason: collision with root package name */
    public final n f10528a;

    /* renamed from: b, reason: collision with root package name */
    public final RectF f10529b;

    /* renamed from: c, reason: collision with root package name */
    public final RectF f10530c;

    /* renamed from: d, reason: collision with root package name */
    public final Paint f10531d;

    /* renamed from: e, reason: collision with root package name */
    public final Paint f10532e;

    /* renamed from: f, reason: collision with root package name */
    public final Path f10533f;

    /* renamed from: g, reason: collision with root package name */
    public ColorStateList f10534g;

    /* renamed from: h, reason: collision with root package name */
    public m f10535h;

    /* renamed from: i, reason: collision with root package name */
    public float f10536i;
    public Path j;
    public final h k;

    @TargetApi(21)
    public class a extends ViewOutlineProvider {

        /* renamed from: a, reason: collision with root package name */
        public final Rect f10537a = new Rect();

        public a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            if (ShapeableImageView.this.f10535h == null) {
                return;
            }
            ShapeableImageView.this.f10529b.round(this.f10537a);
            ShapeableImageView.this.k.setBounds(this.f10537a);
            ShapeableImageView.this.k.getOutline(outline);
        }
    }

    public ShapeableImageView(Context context) {
        this(context, null, 0);
    }

    public m getShapeAppearanceModel() {
        return this.f10535h;
    }

    public ColorStateList getStrokeColor() {
        return this.f10534g;
    }

    public float getStrokeWidth() {
        return this.f10536i;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setLayerType(2, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        setLayerType(0, null);
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.j, this.f10532e);
        a(canvas);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        a(i2, i3);
    }

    @Override // c.c.a.c.w.p
    public void setShapeAppearanceModel(m mVar) {
        this.f10535h = mVar;
        this.k.setShapeAppearanceModel(mVar);
        a(getWidth(), getHeight());
        invalidate();
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        this.f10534g = colorStateList;
        invalidate();
    }

    public void setStrokeColorResource(int i2) {
        setStrokeColor(a.b.b.a.a.b(getContext(), i2));
    }

    public void setStrokeWidth(float f2) {
        if (this.f10536i != f2) {
            this.f10536i = f2;
            invalidate();
        }
    }

    public void setStrokeWidthResource(int i2) {
        setStrokeWidth(getResources().getDimensionPixelSize(i2));
    }

    public ShapeableImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void a(int i2, int i3) {
        this.f10529b.set(getPaddingLeft(), getPaddingTop(), i2 - getPaddingRight(), i3 - getPaddingBottom());
        this.f10528a.a(this.f10535h, 1.0f, this.f10529b, this.f10533f);
        this.j.rewind();
        this.j.addPath(this.f10533f);
        this.f10530c.set(0.0f, 0.0f, i2, i3);
        this.j.addRect(this.f10530c, Path.Direction.CCW);
    }

    public ShapeableImageView(Context context, AttributeSet attributeSet, int i2) {
        super(c.c.a.c.a0.a.a.b(context, attributeSet, i2, l), attributeSet, i2);
        this.f10528a = new n();
        this.f10533f = new Path();
        Context context2 = getContext();
        Paint paint = new Paint();
        this.f10532e = paint;
        paint.setAntiAlias(true);
        this.f10532e.setColor(-1);
        this.f10532e.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.f10529b = new RectF();
        this.f10530c = new RectF();
        this.j = new Path();
        this.f10534g = c.a(context2, context2.obtainStyledAttributes(attributeSet, R$styleable.ShapeableImageView, i2, l), R$styleable.ShapeableImageView_strokeColor);
        this.f10536i = r0.getDimensionPixelSize(R$styleable.ShapeableImageView_strokeWidth, 0);
        Paint paint2 = new Paint();
        this.f10531d = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.f10531d.setAntiAlias(true);
        this.f10535h = m.a(context2, attributeSet, i2, l).a();
        this.k = new h(this.f10535h);
        if (Build.VERSION.SDK_INT >= 21) {
            setOutlineProvider(new a());
        }
    }

    public final void a(Canvas canvas) {
        if (this.f10534g == null) {
            return;
        }
        this.f10531d.setStrokeWidth(this.f10536i);
        int colorForState = this.f10534g.getColorForState(getDrawableState(), this.f10534g.getDefaultColor());
        if (this.f10536i <= 0.0f || colorForState == 0) {
            return;
        }
        this.f10531d.setColor(colorForState);
        canvas.drawPath(this.f10533f, this.f10531d);
    }
}
