package cn.jpush.android.aw;

import android.annotation.SuppressLint;

/* loaded from: classes.dex */
public class c extends e {
    public double A;
    public float B;
    public float C;
    public float D;
    public int E;
    public int F;
    public int z;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f9410a;

        /* renamed from: b, reason: collision with root package name */
        public double f9411b;

        /* renamed from: c, reason: collision with root package name */
        public float f9412c;

        /* renamed from: d, reason: collision with root package name */
        public float f9413d;

        /* renamed from: e, reason: collision with root package name */
        public float f9414e;

        /* renamed from: f, reason: collision with root package name */
        public int f9415f;

        /* renamed from: g, reason: collision with root package name */
        public int f9416g;

        /* renamed from: h, reason: collision with root package name */
        public cn.jpush.android.d.d f9417h;

        public a a(float f2) {
            this.f9411b = Math.min(Math.max(f2, 0.0f), 1.0f);
            return this;
        }

        @SuppressLint({"RtlHardcoded"})
        public a a(int i2) {
            int i3;
            if (i2 > 1 || i2 < 0) {
                i2 = 0;
            }
            if (i2 != 0) {
                i3 = i2 == 1 ? 51 : 53;
                return this;
            }
            this.f9410a = i3;
            return this;
        }

        public a a(cn.jpush.android.d.d dVar) {
            this.f9417h = dVar;
            return this;
        }

        public c a() {
            cn.jpush.android.r.b.b("InAppFloatMessage", "build InAppFloatMessage object, floatMarginYPer: " + this.f9411b);
            return new c(this.f9410a, this.f9411b, this.f9412c, this.f9413d, this.f9414e, this.f9415f, this.f9416g, this.f9417h);
        }

        public a b(float f2) {
            this.f9412c = f2 * 1000.0f;
            return this;
        }

        public a b(int i2) {
            this.f9415f = i2;
            return this;
        }

        public a c(float f2) {
            this.f9413d = f2 * 1000.0f;
            return this;
        }

        public a c(int i2) {
            this.f9416g = i2;
            return this;
        }

        public a d(float f2) {
            this.f9414e = f2 * 1000.0f;
            return this;
        }
    }

    public c(int i2, double d2, float f2, float f3, float f4, int i3, int i4, cn.jpush.android.d.d dVar) {
        super(dVar);
        this.z = i2;
        this.A = d2;
        this.B = f2;
        this.C = f3;
        this.D = f4;
        this.E = i3;
        this.F = i4;
    }

    public static a f() {
        return new a();
    }

    public float a() {
        return this.B;
    }

    public float b() {
        return this.C;
    }

    public float c() {
        return this.D;
    }

    public int d() {
        return this.E;
    }

    public int e() {
        return this.F;
    }
}
