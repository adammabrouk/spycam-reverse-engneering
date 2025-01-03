package a.h.k;

import a.h.j.y;
import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

/* compiled from: AutoScrollHelper.java */
/* loaded from: classes.dex */
public abstract class a implements View.OnTouchListener {
    public static final int r = ViewConfiguration.getTapTimeout();

    /* renamed from: c, reason: collision with root package name */
    public final View f1232c;

    /* renamed from: d, reason: collision with root package name */
    public Runnable f1233d;

    /* renamed from: g, reason: collision with root package name */
    public int f1236g;

    /* renamed from: h, reason: collision with root package name */
    public int f1237h;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;

    /* renamed from: a, reason: collision with root package name */
    public final C0033a f1230a = new C0033a();

    /* renamed from: b, reason: collision with root package name */
    public final Interpolator f1231b = new AccelerateInterpolator();

    /* renamed from: e, reason: collision with root package name */
    public float[] f1234e = {0.0f, 0.0f};

    /* renamed from: f, reason: collision with root package name */
    public float[] f1235f = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: i, reason: collision with root package name */
    public float[] f1238i = {0.0f, 0.0f};
    public float[] j = {0.0f, 0.0f};
    public float[] k = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* compiled from: AutoScrollHelper.java */
    /* renamed from: a.h.k.a$a, reason: collision with other inner class name */
    public static class C0033a {

        /* renamed from: a, reason: collision with root package name */
        public int f1239a;

        /* renamed from: b, reason: collision with root package name */
        public int f1240b;

        /* renamed from: c, reason: collision with root package name */
        public float f1241c;

        /* renamed from: d, reason: collision with root package name */
        public float f1242d;
        public float j;
        public int k;

        /* renamed from: e, reason: collision with root package name */
        public long f1243e = Long.MIN_VALUE;

        /* renamed from: i, reason: collision with root package name */
        public long f1247i = -1;

        /* renamed from: f, reason: collision with root package name */
        public long f1244f = 0;

        /* renamed from: g, reason: collision with root package name */
        public int f1245g = 0;

        /* renamed from: h, reason: collision with root package name */
        public int f1246h = 0;

        public final float a(float f2) {
            return ((-4.0f) * f2 * f2) + (f2 * 4.0f);
        }

        public void a(int i2) {
            this.f1240b = i2;
        }

        public void b(int i2) {
            this.f1239a = i2;
        }

        public int c() {
            return this.f1246h;
        }

        public int d() {
            float f2 = this.f1241c;
            return (int) (f2 / Math.abs(f2));
        }

        public int e() {
            float f2 = this.f1242d;
            return (int) (f2 / Math.abs(f2));
        }

        public boolean f() {
            return this.f1247i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f1247i + ((long) this.k);
        }

        public void g() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.k = a.a((int) (currentAnimationTimeMillis - this.f1243e), 0, this.f1240b);
            this.j = a(currentAnimationTimeMillis);
            this.f1247i = currentAnimationTimeMillis;
        }

        public void h() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f1243e = currentAnimationTimeMillis;
            this.f1247i = -1L;
            this.f1244f = currentAnimationTimeMillis;
            this.j = 0.5f;
            this.f1245g = 0;
            this.f1246h = 0;
        }

        public final float a(long j) {
            if (j < this.f1243e) {
                return 0.0f;
            }
            long j2 = this.f1247i;
            if (j2 < 0 || j < j2) {
                return a.a((j - this.f1243e) / this.f1239a, 0.0f, 1.0f) * 0.5f;
            }
            long j3 = j - j2;
            float f2 = this.j;
            return (1.0f - f2) + (f2 * a.a(j3 / this.k, 0.0f, 1.0f));
        }

        public int b() {
            return this.f1245g;
        }

        public void a() {
            if (this.f1244f != 0) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                float a2 = a(a(currentAnimationTimeMillis));
                long j = currentAnimationTimeMillis - this.f1244f;
                this.f1244f = currentAnimationTimeMillis;
                float f2 = j * a2;
                this.f1245g = (int) (this.f1241c * f2);
                this.f1246h = (int) (f2 * this.f1242d);
                return;
            }
            throw new RuntimeException("Cannot compute scroll delta before calling start()");
        }

        public void a(float f2, float f3) {
            this.f1241c = f2;
            this.f1242d = f3;
        }
    }

    /* compiled from: AutoScrollHelper.java */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            if (aVar.o) {
                if (aVar.m) {
                    aVar.m = false;
                    aVar.f1230a.h();
                }
                C0033a c0033a = a.this.f1230a;
                if (c0033a.f() || !a.this.c()) {
                    a.this.o = false;
                    return;
                }
                a aVar2 = a.this;
                if (aVar2.n) {
                    aVar2.n = false;
                    aVar2.a();
                }
                c0033a.a();
                a.this.a(c0033a.b(), c0033a.c());
                y.a(a.this.f1232c, this);
            }
        }
    }

    public a(View view) {
        this.f1232c = view;
        float f2 = Resources.getSystem().getDisplayMetrics().density;
        float f3 = (int) ((1575.0f * f2) + 0.5f);
        c(f3, f3);
        float f4 = (int) ((f2 * 315.0f) + 0.5f);
        d(f4, f4);
        d(1);
        b(Float.MAX_VALUE, Float.MAX_VALUE);
        e(0.2f, 0.2f);
        f(1.0f, 1.0f);
        c(r);
        f(500);
        e(500);
    }

    public static float a(float f2, float f3, float f4) {
        return f2 > f4 ? f4 : f2 < f3 ? f3 : f2;
    }

    public static int a(int i2, int i3, int i4) {
        return i2 > i4 ? i4 : i2 < i3 ? i3 : i2;
    }

    public a a(boolean z) {
        if (this.p && !z) {
            b();
        }
        this.p = z;
        return this;
    }

    public abstract void a(int i2, int i3);

    public abstract boolean a(int i2);

    public a b(float f2, float f3) {
        float[] fArr = this.f1235f;
        fArr[0] = f2;
        fArr[1] = f3;
        return this;
    }

    public abstract boolean b(int i2);

    public a c(float f2, float f3) {
        float[] fArr = this.k;
        fArr[0] = f2 / 1000.0f;
        fArr[1] = f3 / 1000.0f;
        return this;
    }

    public a d(float f2, float f3) {
        float[] fArr = this.j;
        fArr[0] = f2 / 1000.0f;
        fArr[1] = f3 / 1000.0f;
        return this;
    }

    public a e(float f2, float f3) {
        float[] fArr = this.f1234e;
        fArr[0] = f2;
        fArr[1] = f3;
        return this;
    }

    public a f(float f2, float f3) {
        float[] fArr = this.f1238i;
        fArr[0] = f2 / 1000.0f;
        fArr[1] = f3 / 1000.0f;
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0013, code lost:
    
        if (r0 != 3) goto L20;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            boolean r0 = r5.p
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            int r0 = r7.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L1a
            if (r0 == r2) goto L16
            r3 = 2
            if (r0 == r3) goto L1e
            r6 = 3
            if (r0 == r6) goto L16
            goto L58
        L16:
            r5.b()
            goto L58
        L1a:
            r5.n = r2
            r5.l = r1
        L1e:
            float r0 = r7.getX()
            int r3 = r6.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r5.f1232c
            int r4 = r4.getWidth()
            float r4 = (float) r4
            float r0 = r5.a(r1, r0, r3, r4)
            float r7 = r7.getY()
            int r6 = r6.getHeight()
            float r6 = (float) r6
            android.view.View r3 = r5.f1232c
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r6 = r5.a(r2, r7, r6, r3)
            a.h.k.a$a r7 = r5.f1230a
            r7.a(r0, r6)
            boolean r6 = r5.o
            if (r6 != 0) goto L58
            boolean r6 = r5.c()
            if (r6 == 0) goto L58
            r5.d()
        L58:
            boolean r6 = r5.q
            if (r6 == 0) goto L61
            boolean r6 = r5.o
            if (r6 == 0) goto L61
            r1 = 1
        L61:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: a.h.k.a.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public final void b() {
        if (this.m) {
            this.o = false;
        } else {
            this.f1230a.g();
        }
    }

    public a c(int i2) {
        this.f1237h = i2;
        return this;
    }

    public a d(int i2) {
        this.f1236g = i2;
        return this;
    }

    public a e(int i2) {
        this.f1230a.a(i2);
        return this;
    }

    public a f(int i2) {
        this.f1230a.b(i2);
        return this;
    }

    public final float a(int i2, float f2, float f3, float f4) {
        float a2 = a(this.f1234e[i2], f3, this.f1235f[i2], f2);
        if (a2 == 0.0f) {
            return 0.0f;
        }
        float f5 = this.f1238i[i2];
        float f6 = this.j[i2];
        float f7 = this.k[i2];
        float f8 = f5 * f4;
        if (a2 > 0.0f) {
            return a(a2 * f8, f6, f7);
        }
        return -a((-a2) * f8, f6, f7);
    }

    public boolean c() {
        C0033a c0033a = this.f1230a;
        int e2 = c0033a.e();
        int d2 = c0033a.d();
        return (e2 != 0 && b(e2)) || (d2 != 0 && a(d2));
    }

    public final void d() {
        int i2;
        if (this.f1233d == null) {
            this.f1233d = new b();
        }
        this.o = true;
        this.m = true;
        if (!this.l && (i2 = this.f1237h) > 0) {
            y.a(this.f1232c, this.f1233d, i2);
        } else {
            this.f1233d.run();
        }
        this.l = true;
    }

    public final float a(float f2, float f3, float f4, float f5) {
        float interpolation;
        float a2 = a(f2 * f3, 0.0f, f4);
        float a3 = a(f3 - f5, a2) - a(f5, a2);
        if (a3 < 0.0f) {
            interpolation = -this.f1231b.getInterpolation(-a3);
        } else {
            if (a3 <= 0.0f) {
                return 0.0f;
            }
            interpolation = this.f1231b.getInterpolation(a3);
        }
        return a(interpolation, -1.0f, 1.0f);
    }

    public final float a(float f2, float f3) {
        if (f3 == 0.0f) {
            return 0.0f;
        }
        int i2 = this.f1236g;
        if (i2 == 0 || i2 == 1) {
            if (f2 < f3) {
                if (f2 >= 0.0f) {
                    return 1.0f - (f2 / f3);
                }
                if (this.o && this.f1236g == 1) {
                    return 1.0f;
                }
            }
        } else if (i2 == 2 && f2 < 0.0f) {
            return f2 / (-f3);
        }
        return 0.0f;
    }

    public void a() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f1232c.onTouchEvent(obtain);
        obtain.recycle();
    }
}
