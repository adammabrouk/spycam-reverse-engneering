package c.c.a.c.q;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import c.c.a.c.w.m;
import c.c.a.c.w.n;

/* compiled from: BorderDrawable.java */
/* loaded from: classes.dex */
public class c extends Drawable {

    /* renamed from: b, reason: collision with root package name */
    public final Paint f5494b;

    /* renamed from: h, reason: collision with root package name */
    public float f5500h;

    /* renamed from: i, reason: collision with root package name */
    public int f5501i;
    public int j;
    public int k;
    public int l;
    public int m;
    public m o;
    public ColorStateList p;

    /* renamed from: a, reason: collision with root package name */
    public final n f5493a = new n();

    /* renamed from: c, reason: collision with root package name */
    public final Path f5495c = new Path();

    /* renamed from: d, reason: collision with root package name */
    public final Rect f5496d = new Rect();

    /* renamed from: e, reason: collision with root package name */
    public final RectF f5497e = new RectF();

    /* renamed from: f, reason: collision with root package name */
    public final RectF f5498f = new RectF();

    /* renamed from: g, reason: collision with root package name */
    public final b f5499g = new b();
    public boolean n = true;

    /* compiled from: BorderDrawable.java */
    public class b extends Drawable.ConstantState {
        public b() {
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return c.this;
        }
    }

    public c(m mVar) {
        this.o = mVar;
        Paint paint = new Paint(1);
        this.f5494b = paint;
        paint.setStyle(Paint.Style.STROKE);
    }

    public void a(float f2) {
        if (this.f5500h != f2) {
            this.f5500h = f2;
            this.f5494b.setStrokeWidth(f2 * 1.3333f);
            this.n = true;
            invalidateSelf();
        }
    }

    public RectF b() {
        this.f5498f.set(getBounds());
        return this.f5498f;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.n) {
            this.f5494b.setShader(a());
            this.n = false;
        }
        float strokeWidth = this.f5494b.getStrokeWidth() / 2.0f;
        copyBounds(this.f5496d);
        this.f5497e.set(this.f5496d);
        float min = Math.min(this.o.j().a(b()), this.f5497e.width() / 2.0f);
        if (this.o.a(b())) {
            this.f5497e.inset(strokeWidth, strokeWidth);
            canvas.drawRoundRect(this.f5497e, min, min, this.f5494b);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f5499g;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f5500h > 0.0f ? -3 : -2;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(Outline outline) {
        if (this.o.a(b())) {
            outline.setRoundRect(getBounds(), this.o.j().a(b()));
            return;
        }
        copyBounds(this.f5496d);
        this.f5497e.set(this.f5496d);
        this.f5493a.a(this.o, 1.0f, this.f5497e, this.f5495c);
        if (this.f5495c.isConvex()) {
            outline.setConvexPath(this.f5495c);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        if (!this.o.a(b())) {
            return true;
        }
        int round = Math.round(this.f5500h);
        rect.set(round, round, round, round);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.p;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.n = true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        int colorForState;
        ColorStateList colorStateList = this.p;
        if (colorStateList != null && (colorForState = colorStateList.getColorForState(iArr, this.m)) != this.m) {
            this.n = true;
            this.m = colorForState;
        }
        if (this.n) {
            invalidateSelf();
        }
        return this.n;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f5494b.setAlpha(i2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f5494b.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void a(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.m = colorStateList.getColorForState(getState(), this.m);
        }
        this.p = colorStateList;
        this.n = true;
        invalidateSelf();
    }

    public void a(int i2, int i3, int i4, int i5) {
        this.f5501i = i2;
        this.j = i3;
        this.k = i4;
        this.l = i5;
    }

    public void a(m mVar) {
        this.o = mVar;
        invalidateSelf();
    }

    public final Shader a() {
        copyBounds(this.f5496d);
        float height = this.f5500h / r0.height();
        return new LinearGradient(0.0f, r0.top, 0.0f, r0.bottom, new int[]{a.h.c.a.b(this.f5501i, this.m), a.h.c.a.b(this.j, this.m), a.h.c.a.b(a.h.c.a.c(this.j, 0), this.m), a.h.c.a.b(a.h.c.a.c(this.l, 0), this.m), a.h.c.a.b(this.l, this.m), a.h.c.a.b(this.k, this.m)}, new float[]{0.0f, height, 0.5f, 0.5f, 1.0f - height, 1.0f}, Shader.TileMode.CLAMP);
    }
}
