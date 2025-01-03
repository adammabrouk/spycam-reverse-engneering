package a.r.a;

import a.h.i.h;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.google.zxing.view.ViewfinderView;

/* compiled from: CircularProgressDrawable.java */
/* loaded from: classes.dex */
public class b extends Drawable implements Animatable {

    /* renamed from: g, reason: collision with root package name */
    public static final Interpolator f1717g = new LinearInterpolator();

    /* renamed from: h, reason: collision with root package name */
    public static final Interpolator f1718h = new a.l.a.a.b();

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f1719i = {-16777216};

    /* renamed from: a, reason: collision with root package name */
    public final c f1720a;

    /* renamed from: b, reason: collision with root package name */
    public float f1721b;

    /* renamed from: c, reason: collision with root package name */
    public Resources f1722c;

    /* renamed from: d, reason: collision with root package name */
    public Animator f1723d;

    /* renamed from: e, reason: collision with root package name */
    public float f1724e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f1725f;

    /* compiled from: CircularProgressDrawable.java */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f1726a;

        public a(c cVar) {
            this.f1726a = cVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            b.this.b(floatValue, this.f1726a);
            b.this.a(floatValue, this.f1726a, false);
            b.this.invalidateSelf();
        }
    }

    /* compiled from: CircularProgressDrawable.java */
    /* renamed from: a.r.a.b$b, reason: collision with other inner class name */
    public class C0051b implements Animator.AnimatorListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f1728a;

        public C0051b(c cVar) {
            this.f1728a = cVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            b.this.a(1.0f, this.f1728a, true);
            this.f1728a.l();
            this.f1728a.j();
            b bVar = b.this;
            if (!bVar.f1725f) {
                bVar.f1724e += 1.0f;
                return;
            }
            bVar.f1725f = false;
            animator.cancel();
            animator.setDuration(1332L);
            animator.start();
            this.f1728a.a(false);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            b.this.f1724e = 0.0f;
        }
    }

    /* compiled from: CircularProgressDrawable.java */
    public static class c {

        /* renamed from: i, reason: collision with root package name */
        public int[] f1738i;
        public int j;
        public float k;
        public float l;
        public float m;
        public boolean n;
        public Path o;
        public float q;
        public int r;
        public int s;
        public int u;

        /* renamed from: a, reason: collision with root package name */
        public final RectF f1730a = new RectF();

        /* renamed from: b, reason: collision with root package name */
        public final Paint f1731b = new Paint();

        /* renamed from: c, reason: collision with root package name */
        public final Paint f1732c = new Paint();

        /* renamed from: d, reason: collision with root package name */
        public final Paint f1733d = new Paint();

        /* renamed from: e, reason: collision with root package name */
        public float f1734e = 0.0f;

        /* renamed from: f, reason: collision with root package name */
        public float f1735f = 0.0f;

        /* renamed from: g, reason: collision with root package name */
        public float f1736g = 0.0f;

        /* renamed from: h, reason: collision with root package name */
        public float f1737h = 5.0f;
        public float p = 1.0f;
        public int t = ViewfinderView.OPAQUE;

        public c() {
            this.f1731b.setStrokeCap(Paint.Cap.SQUARE);
            this.f1731b.setAntiAlias(true);
            this.f1731b.setStyle(Paint.Style.STROKE);
            this.f1732c.setStyle(Paint.Style.FILL);
            this.f1732c.setAntiAlias(true);
            this.f1733d.setColor(0);
        }

        public void a(float f2, float f3) {
            this.r = (int) f2;
            this.s = (int) f3;
        }

        public void b(int i2) {
            this.u = i2;
        }

        public void c(int i2) {
            this.j = i2;
            this.u = this.f1738i[i2];
        }

        public int d() {
            return (this.j + 1) % this.f1738i.length;
        }

        public void e(float f2) {
            this.f1734e = f2;
        }

        public void f(float f2) {
            this.f1737h = f2;
            this.f1731b.setStrokeWidth(f2);
        }

        public float g() {
            return this.l;
        }

        public float h() {
            return this.m;
        }

        public float i() {
            return this.k;
        }

        public void j() {
            c(d());
        }

        public void k() {
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 0.0f;
            e(0.0f);
            c(0.0f);
            d(0.0f);
        }

        public void l() {
            this.k = this.f1734e;
            this.l = this.f1735f;
            this.m = this.f1736g;
        }

        public float b() {
            return this.f1735f;
        }

        public void d(float f2) {
            this.f1736g = f2;
        }

        public float e() {
            return this.f1734e;
        }

        public void a(Canvas canvas, Rect rect) {
            RectF rectF = this.f1730a;
            float f2 = this.q;
            float f3 = (this.f1737h / 2.0f) + f2;
            if (f2 <= 0.0f) {
                f3 = (Math.min(rect.width(), rect.height()) / 2.0f) - Math.max((this.r * this.p) / 2.0f, this.f1737h / 2.0f);
            }
            rectF.set(rect.centerX() - f3, rect.centerY() - f3, rect.centerX() + f3, rect.centerY() + f3);
            float f4 = this.f1734e;
            float f5 = this.f1736g;
            float f6 = (f4 + f5) * 360.0f;
            float f7 = ((this.f1735f + f5) * 360.0f) - f6;
            this.f1731b.setColor(this.u);
            this.f1731b.setAlpha(this.t);
            float f8 = this.f1737h / 2.0f;
            rectF.inset(f8, f8);
            canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, this.f1733d);
            float f9 = -f8;
            rectF.inset(f9, f9);
            canvas.drawArc(rectF, f6, f7, false, this.f1731b);
            a(canvas, f6, f7, rectF);
        }

        public void b(float f2) {
            this.q = f2;
        }

        public int c() {
            return this.f1738i[d()];
        }

        public int f() {
            return this.f1738i[this.j];
        }

        public void c(float f2) {
            this.f1735f = f2;
        }

        public void a(Canvas canvas, float f2, float f3, RectF rectF) {
            if (this.n) {
                Path path = this.o;
                if (path == null) {
                    Path path2 = new Path();
                    this.o = path2;
                    path2.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    path.reset();
                }
                float min = Math.min(rectF.width(), rectF.height()) / 2.0f;
                float f4 = (this.r * this.p) / 2.0f;
                this.o.moveTo(0.0f, 0.0f);
                this.o.lineTo(this.r * this.p, 0.0f);
                Path path3 = this.o;
                float f5 = this.r;
                float f6 = this.p;
                path3.lineTo((f5 * f6) / 2.0f, this.s * f6);
                this.o.offset((min + rectF.centerX()) - f4, rectF.centerY() + (this.f1737h / 2.0f));
                this.o.close();
                this.f1732c.setColor(this.u);
                this.f1732c.setAlpha(this.t);
                canvas.save();
                canvas.rotate(f2 + f3, rectF.centerX(), rectF.centerY());
                canvas.drawPath(this.o, this.f1732c);
                canvas.restore();
            }
        }

        public void a(int[] iArr) {
            this.f1738i = iArr;
            c(0);
        }

        public void a(ColorFilter colorFilter) {
            this.f1731b.setColorFilter(colorFilter);
        }

        public void a(int i2) {
            this.t = i2;
        }

        public int a() {
            return this.t;
        }

        public void a(boolean z) {
            if (this.n != z) {
                this.n = z;
            }
        }

        public void a(float f2) {
            if (f2 != this.p) {
                this.p = f2;
            }
        }
    }

    public b(Context context) {
        h.a(context);
        this.f1722c = context.getResources();
        c cVar = new c();
        this.f1720a = cVar;
        cVar.a(f1719i);
        d(2.5f);
        a();
    }

    public final int a(float f2, int i2, int i3) {
        return ((((i2 >> 24) & ViewfinderView.OPAQUE) + ((int) ((((i3 >> 24) & ViewfinderView.OPAQUE) - r0) * f2))) << 24) | ((((i2 >> 16) & ViewfinderView.OPAQUE) + ((int) ((((i3 >> 16) & ViewfinderView.OPAQUE) - r1) * f2))) << 16) | ((((i2 >> 8) & ViewfinderView.OPAQUE) + ((int) ((((i3 >> 8) & ViewfinderView.OPAQUE) - r2) * f2))) << 8) | ((i2 & ViewfinderView.OPAQUE) + ((int) (f2 * ((i3 & ViewfinderView.OPAQUE) - r8))));
    }

    public final void a(float f2, float f3, float f4, float f5) {
        c cVar = this.f1720a;
        float f6 = this.f1722c.getDisplayMetrics().density;
        cVar.f(f3 * f6);
        cVar.b(f2 * f6);
        cVar.c(0);
        cVar.a(f4 * f6, f5 * f6);
    }

    public void b(float f2) {
        this.f1720a.d(f2);
        invalidateSelf();
    }

    public final void c(float f2) {
        this.f1721b = f2;
    }

    public void d(float f2) {
        this.f1720a.f(f2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.f1721b, bounds.exactCenterX(), bounds.exactCenterY());
        this.f1720a.a(canvas, bounds);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f1720a.a();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f1723d.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f1720a.a(i2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f1720a.a(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f1723d.cancel();
        this.f1720a.l();
        if (this.f1720a.b() != this.f1720a.e()) {
            this.f1725f = true;
            this.f1723d.setDuration(666L);
            this.f1723d.start();
        } else {
            this.f1720a.c(0);
            this.f1720a.k();
            this.f1723d.setDuration(1332L);
            this.f1723d.start();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f1723d.cancel();
        c(0.0f);
        this.f1720a.a(false);
        this.f1720a.c(0);
        this.f1720a.k();
        invalidateSelf();
    }

    public void b(float f2, c cVar) {
        if (f2 > 0.75f) {
            cVar.b(a((f2 - 0.75f) / 0.25f, cVar.f(), cVar.c()));
        } else {
            cVar.b(cVar.f());
        }
    }

    public void a(int i2) {
        if (i2 == 0) {
            a(11.0f, 3.0f, 12.0f, 6.0f);
        } else {
            a(7.5f, 2.5f, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    public void a(boolean z) {
        this.f1720a.a(z);
        invalidateSelf();
    }

    public void a(float f2) {
        this.f1720a.a(f2);
        invalidateSelf();
    }

    public void a(float f2, float f3) {
        this.f1720a.e(f2);
        this.f1720a.c(f3);
        invalidateSelf();
    }

    public void a(int... iArr) {
        this.f1720a.a(iArr);
        this.f1720a.c(0);
        invalidateSelf();
    }

    public final void a(float f2, c cVar) {
        b(f2, cVar);
        float floor = (float) (Math.floor(cVar.h() / 0.8f) + 1.0d);
        cVar.e(cVar.i() + (((cVar.g() - 0.01f) - cVar.i()) * f2));
        cVar.c(cVar.g());
        cVar.d(cVar.h() + ((floor - cVar.h()) * f2));
    }

    public void a(float f2, c cVar, boolean z) {
        float interpolation;
        float f3;
        if (this.f1725f) {
            a(f2, cVar);
            return;
        }
        if (f2 != 1.0f || z) {
            float h2 = cVar.h();
            if (f2 < 0.5f) {
                interpolation = cVar.i();
                f3 = (f1718h.getInterpolation(f2 / 0.5f) * 0.79f) + 0.01f + interpolation;
            } else {
                float i2 = cVar.i() + 0.79f;
                interpolation = i2 - (((1.0f - f1718h.getInterpolation((f2 - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
                f3 = i2;
            }
            float f4 = h2 + (0.20999998f * f2);
            float f5 = (f2 + this.f1724e) * 216.0f;
            cVar.e(interpolation);
            cVar.c(f3);
            cVar.d(f4);
            c(f5);
        }
    }

    public final void a() {
        c cVar = this.f1720a;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new a(cVar));
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setInterpolator(f1717g);
        ofFloat.addListener(new C0051b(cVar));
        this.f1723d = ofFloat;
    }
}
