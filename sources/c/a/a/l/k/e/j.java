package c.a.a.l.k.e;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.Gravity;

/* compiled from: GlideBitmapDrawable.java */
/* loaded from: classes.dex */
public class j extends c.a.a.l.k.f.b {

    /* renamed from: a, reason: collision with root package name */
    public final Rect f3241a;

    /* renamed from: b, reason: collision with root package name */
    public int f3242b;

    /* renamed from: c, reason: collision with root package name */
    public int f3243c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f3244d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f3245e;

    /* renamed from: f, reason: collision with root package name */
    public a f3246f;

    /* compiled from: GlideBitmapDrawable.java */
    public static class a extends Drawable.ConstantState {

        /* renamed from: d, reason: collision with root package name */
        public static final Paint f3247d = new Paint(6);

        /* renamed from: a, reason: collision with root package name */
        public final Bitmap f3248a;

        /* renamed from: b, reason: collision with root package name */
        public int f3249b;

        /* renamed from: c, reason: collision with root package name */
        public Paint f3250c;

        public a(Bitmap bitmap) {
            this.f3250c = f3247d;
            this.f3248a = bitmap;
        }

        public void a(ColorFilter colorFilter) {
            a();
            this.f3250c.setColorFilter(colorFilter);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new j((Resources) null, this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new j(resources, this);
        }

        public void a(int i2) {
            a();
            this.f3250c.setAlpha(i2);
        }

        public a(a aVar) {
            this(aVar.f3248a);
            this.f3249b = aVar.f3249b;
        }

        public void a() {
            if (f3247d == this.f3250c) {
                this.f3250c = new Paint(6);
            }
        }
    }

    public j(Resources resources, Bitmap bitmap) {
        this(resources, new a(bitmap));
    }

    @Override // c.a.a.l.k.f.b
    public boolean a() {
        return false;
    }

    public Bitmap b() {
        return this.f3246f.f3248a;
    }

    @Override // c.a.a.l.k.f.b
    public void b(int i2) {
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f3244d) {
            Gravity.apply(119, this.f3242b, this.f3243c, getBounds(), this.f3241a);
            this.f3244d = false;
        }
        a aVar = this.f3246f;
        canvas.drawBitmap(aVar.f3248a, (Rect) null, this.f3241a, aVar.f3250c);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f3246f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f3243c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f3242b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Bitmap bitmap = this.f3246f.f3248a;
        return (bitmap == null || bitmap.hasAlpha() || this.f3246f.f3250c.getAlpha() < 255) ? -3 : -1;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f3245e && super.mutate() == this) {
            this.f3246f = new a(this.f3246f);
            this.f3245e = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f3244d = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        if (this.f3246f.f3250c.getAlpha() != i2) {
            this.f3246f.a(i2);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f3246f.a(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
    }

    public j(Resources resources, a aVar) {
        int i2;
        this.f3241a = new Rect();
        if (aVar == null) {
            throw new NullPointerException("BitmapState must not be null");
        }
        this.f3246f = aVar;
        if (resources != null) {
            i2 = resources.getDisplayMetrics().densityDpi;
            i2 = i2 == 0 ? 160 : i2;
            aVar.f3249b = i2;
        } else {
            i2 = aVar.f3249b;
        }
        this.f3242b = aVar.f3248a.getScaledWidth(i2);
        this.f3243c = aVar.f3248a.getScaledHeight(i2);
    }
}
