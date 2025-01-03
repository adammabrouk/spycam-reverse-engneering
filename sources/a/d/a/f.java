package a.d.a;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* compiled from: RoundRectDrawable.java */
/* loaded from: classes.dex */
public class f extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    public float f647a;

    /* renamed from: c, reason: collision with root package name */
    public final RectF f649c;

    /* renamed from: d, reason: collision with root package name */
    public final Rect f650d;

    /* renamed from: e, reason: collision with root package name */
    public float f651e;

    /* renamed from: h, reason: collision with root package name */
    public ColorStateList f654h;

    /* renamed from: i, reason: collision with root package name */
    public PorterDuffColorFilter f655i;
    public ColorStateList j;

    /* renamed from: f, reason: collision with root package name */
    public boolean f652f = false;

    /* renamed from: g, reason: collision with root package name */
    public boolean f653g = true;
    public PorterDuff.Mode k = PorterDuff.Mode.SRC_IN;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f648b = new Paint(5);

    public f(ColorStateList colorStateList, float f2) {
        this.f647a = f2;
        a(colorStateList);
        this.f649c = new RectF();
        this.f650d = new Rect();
    }

    public final void a(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f654h = colorStateList;
        this.f648b.setColor(colorStateList.getColorForState(getState(), this.f654h.getDefaultColor()));
    }

    public float b() {
        return this.f651e;
    }

    public float c() {
        return this.f647a;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z;
        Paint paint = this.f648b;
        if (this.f655i == null || paint.getColorFilter() != null) {
            z = false;
        } else {
            paint.setColorFilter(this.f655i);
            z = true;
        }
        RectF rectF = this.f649c;
        float f2 = this.f647a;
        canvas.drawRoundRect(rectF, f2, f2, paint);
        if (z) {
            paint.setColorFilter(null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f650d, this.f647a);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.j;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f654h) != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        a(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f654h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        boolean z = colorForState != this.f648b.getColor();
        if (z) {
            this.f648b.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.j;
        if (colorStateList2 == null || (mode = this.k) == null) {
            return z;
        }
        this.f655i = a(colorStateList2, mode);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f648b.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f648b.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.j = colorStateList;
        this.f655i = a(colorStateList, this.k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.k = mode;
        this.f655i = a(this.j, mode);
        invalidateSelf();
    }

    public void b(ColorStateList colorStateList) {
        a(colorStateList);
        invalidateSelf();
    }

    public void a(float f2, boolean z, boolean z2) {
        if (f2 == this.f651e && this.f652f == z && this.f653g == z2) {
            return;
        }
        this.f651e = f2;
        this.f652f = z;
        this.f653g = z2;
        a((Rect) null);
        invalidateSelf();
    }

    public final void a(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f649c.set(rect.left, rect.top, rect.right, rect.bottom);
        this.f650d.set(rect);
        if (this.f652f) {
            this.f650d.inset((int) Math.ceil(g.a(this.f651e, this.f647a, this.f653g)), (int) Math.ceil(g.b(this.f651e, this.f647a, this.f653g)));
            this.f649c.set(this.f650d);
        }
    }

    public void a(float f2) {
        if (f2 == this.f647a) {
            return;
        }
        this.f647a = f2;
        a((Rect) null);
        invalidateSelf();
    }

    public ColorStateList a() {
        return this.f654h;
    }

    public final PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }
}
