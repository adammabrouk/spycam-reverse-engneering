package a.d.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.cardview.R$color;
import androidx.cardview.R$dimen;

/* compiled from: RoundRectDrawableWithShadow.java */
/* loaded from: classes.dex */
public class g extends Drawable {
    public static final double q = Math.cos(Math.toRadians(45.0d));
    public static a r;

    /* renamed from: a, reason: collision with root package name */
    public final int f656a;

    /* renamed from: c, reason: collision with root package name */
    public Paint f658c;

    /* renamed from: d, reason: collision with root package name */
    public Paint f659d;

    /* renamed from: e, reason: collision with root package name */
    public final RectF f660e;

    /* renamed from: f, reason: collision with root package name */
    public float f661f;

    /* renamed from: g, reason: collision with root package name */
    public Path f662g;

    /* renamed from: h, reason: collision with root package name */
    public float f663h;

    /* renamed from: i, reason: collision with root package name */
    public float f664i;
    public float j;
    public ColorStateList k;
    public final int m;
    public final int n;
    public boolean l = true;
    public boolean o = true;
    public boolean p = false;

    /* renamed from: b, reason: collision with root package name */
    public Paint f657b = new Paint(5);

    /* compiled from: RoundRectDrawableWithShadow.java */
    public interface a {
        void a(Canvas canvas, RectF rectF, float f2, Paint paint);
    }

    public g(Resources resources, ColorStateList colorStateList, float f2, float f3, float f4) {
        this.m = resources.getColor(R$color.cardview_shadow_start_color);
        this.n = resources.getColor(R$color.cardview_shadow_end_color);
        this.f656a = resources.getDimensionPixelSize(R$dimen.cardview_compat_inset_shadow);
        a(colorStateList);
        Paint paint = new Paint(5);
        this.f658c = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f661f = (int) (f2 + 0.5f);
        this.f660e = new RectF();
        Paint paint2 = new Paint(this.f658c);
        this.f659d = paint2;
        paint2.setAntiAlias(false);
        a(f3, f4);
    }

    public static float b(float f2, float f3, boolean z) {
        if (!z) {
            return f2 * 1.5f;
        }
        double d2 = f2 * 1.5f;
        double d3 = 1.0d - q;
        double d4 = f3;
        Double.isNaN(d4);
        Double.isNaN(d2);
        return (float) (d2 + (d3 * d4));
    }

    public final void a(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.k = colorStateList;
        this.f657b.setColor(colorStateList.getColorForState(getState(), this.k.getDefaultColor()));
    }

    public float c() {
        return this.f661f;
    }

    public final int d(float f2) {
        int i2 = (int) (f2 + 0.5f);
        return i2 % 2 == 1 ? i2 - 1 : i2;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.l) {
            a(getBounds());
            this.l = false;
        }
        canvas.translate(0.0f, this.j / 2.0f);
        a(canvas);
        canvas.translate(0.0f, (-this.j) / 2.0f);
        r.a(canvas, this.f660e, this.f661f, this.f657b);
    }

    public float e() {
        float f2 = this.f663h;
        return (Math.max(f2, this.f661f + this.f656a + ((f2 * 1.5f) / 2.0f)) * 2.0f) + (((this.f663h * 1.5f) + this.f656a) * 2.0f);
    }

    public float f() {
        float f2 = this.f663h;
        return (Math.max(f2, this.f661f + this.f656a + (f2 / 2.0f)) * 2.0f) + ((this.f663h + this.f656a) * 2.0f);
    }

    public float g() {
        return this.j;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil(b(this.f663h, this.f661f, this.o));
        int ceil2 = (int) Math.ceil(a(this.f663h, this.f661f, this.o));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.k;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.l = true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        ColorStateList colorStateList = this.k;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.f657b.getColor() == colorForState) {
            return false;
        }
        this.f657b.setColor(colorForState);
        this.l = true;
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f657b.setAlpha(i2);
        this.f658c.setAlpha(i2);
        this.f659d.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f657b.setColorFilter(colorFilter);
    }

    public void b(Rect rect) {
        getPadding(rect);
    }

    public void c(float f2) {
        a(f2, this.f663h);
    }

    public float d() {
        return this.f663h;
    }

    public void a(boolean z) {
        this.o = z;
        invalidateSelf();
    }

    public void b(float f2) {
        a(this.j, f2);
    }

    public void b(ColorStateList colorStateList) {
        a(colorStateList);
        invalidateSelf();
    }

    public final void a(float f2, float f3) {
        if (f2 < 0.0f) {
            throw new IllegalArgumentException("Invalid shadow size " + f2 + ". Must be >= 0");
        }
        if (f3 >= 0.0f) {
            float d2 = d(f2);
            float d3 = d(f3);
            if (d2 > d3) {
                if (!this.p) {
                    this.p = true;
                }
                d2 = d3;
            }
            if (this.j == d2 && this.f663h == d3) {
                return;
            }
            this.j = d2;
            this.f663h = d3;
            this.f664i = (int) ((d2 * 1.5f) + this.f656a + 0.5f);
            this.l = true;
            invalidateSelf();
            return;
        }
        throw new IllegalArgumentException("Invalid max shadow size " + f3 + ". Must be >= 0");
    }

    public ColorStateList b() {
        return this.k;
    }

    public static float a(float f2, float f3, boolean z) {
        if (!z) {
            return f2;
        }
        double d2 = f2;
        double d3 = 1.0d - q;
        double d4 = f3;
        Double.isNaN(d4);
        Double.isNaN(d2);
        return (float) (d2 + (d3 * d4));
    }

    public void a(float f2) {
        if (f2 < 0.0f) {
            throw new IllegalArgumentException("Invalid radius " + f2 + ". Must be >= 0");
        }
        float f3 = (int) (f2 + 0.5f);
        if (this.f661f == f3) {
            return;
        }
        this.f661f = f3;
        this.l = true;
        invalidateSelf();
    }

    public final void a(Canvas canvas) {
        float f2 = this.f661f;
        float f3 = (-f2) - this.f664i;
        float f4 = f2 + this.f656a + (this.j / 2.0f);
        float f5 = f4 * 2.0f;
        boolean z = this.f660e.width() - f5 > 0.0f;
        boolean z2 = this.f660e.height() - f5 > 0.0f;
        int save = canvas.save();
        RectF rectF = this.f660e;
        canvas.translate(rectF.left + f4, rectF.top + f4);
        canvas.drawPath(this.f662g, this.f658c);
        if (z) {
            canvas.drawRect(0.0f, f3, this.f660e.width() - f5, -this.f661f, this.f659d);
        }
        canvas.restoreToCount(save);
        int save2 = canvas.save();
        RectF rectF2 = this.f660e;
        canvas.translate(rectF2.right - f4, rectF2.bottom - f4);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f662g, this.f658c);
        if (z) {
            canvas.drawRect(0.0f, f3, this.f660e.width() - f5, (-this.f661f) + this.f664i, this.f659d);
        }
        canvas.restoreToCount(save2);
        int save3 = canvas.save();
        RectF rectF3 = this.f660e;
        canvas.translate(rectF3.left + f4, rectF3.bottom - f4);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f662g, this.f658c);
        if (z2) {
            canvas.drawRect(0.0f, f3, this.f660e.height() - f5, -this.f661f, this.f659d);
        }
        canvas.restoreToCount(save3);
        int save4 = canvas.save();
        RectF rectF4 = this.f660e;
        canvas.translate(rectF4.right - f4, rectF4.top + f4);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f662g, this.f658c);
        if (z2) {
            canvas.drawRect(0.0f, f3, this.f660e.height() - f5, -this.f661f, this.f659d);
        }
        canvas.restoreToCount(save4);
    }

    public final void a() {
        float f2 = this.f661f;
        RectF rectF = new RectF(-f2, -f2, f2, f2);
        RectF rectF2 = new RectF(rectF);
        float f3 = this.f664i;
        rectF2.inset(-f3, -f3);
        Path path = this.f662g;
        if (path == null) {
            this.f662g = new Path();
        } else {
            path.reset();
        }
        this.f662g.setFillType(Path.FillType.EVEN_ODD);
        this.f662g.moveTo(-this.f661f, 0.0f);
        this.f662g.rLineTo(-this.f664i, 0.0f);
        this.f662g.arcTo(rectF2, 180.0f, 90.0f, false);
        this.f662g.arcTo(rectF, 270.0f, -90.0f, false);
        this.f662g.close();
        float f4 = this.f661f;
        float f5 = f4 / (this.f664i + f4);
        Paint paint = this.f658c;
        float f6 = this.f661f + this.f664i;
        int i2 = this.m;
        paint.setShader(new RadialGradient(0.0f, 0.0f, f6, new int[]{i2, i2, this.n}, new float[]{0.0f, f5, 1.0f}, Shader.TileMode.CLAMP));
        Paint paint2 = this.f659d;
        float f7 = this.f661f;
        float f8 = this.f664i;
        int i3 = this.m;
        paint2.setShader(new LinearGradient(0.0f, (-f7) + f8, 0.0f, (-f7) - f8, new int[]{i3, i3, this.n}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.f659d.setAntiAlias(false);
    }

    public final void a(Rect rect) {
        float f2 = this.f663h;
        float f3 = 1.5f * f2;
        this.f660e.set(rect.left + f2, rect.top + f3, rect.right - f2, rect.bottom - f3);
        a();
    }
}
