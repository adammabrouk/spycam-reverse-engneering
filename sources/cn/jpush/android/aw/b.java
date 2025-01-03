package cn.jpush.android.aw;

/* loaded from: classes.dex */
public class b extends e {
    public float A;
    public float B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public float z;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f9401a = 0;

        /* renamed from: b, reason: collision with root package name */
        public float f9402b;

        /* renamed from: c, reason: collision with root package name */
        public float f9403c;

        /* renamed from: d, reason: collision with root package name */
        public float f9404d;

        /* renamed from: e, reason: collision with root package name */
        public int f9405e;

        /* renamed from: f, reason: collision with root package name */
        public int f9406f;

        /* renamed from: g, reason: collision with root package name */
        public int f9407g;

        /* renamed from: h, reason: collision with root package name */
        public int f9408h;

        /* renamed from: i, reason: collision with root package name */
        public cn.jpush.android.d.d f9409i;

        public a a(float f2) {
            this.f9402b = f2 * 1000.0f;
            return this;
        }

        public a a(int i2) {
            this.f9405e = i2;
            return this;
        }

        public a a(cn.jpush.android.d.d dVar) {
            this.f9409i = dVar;
            return this;
        }

        public b a() {
            cn.jpush.android.r.b.b("InAppBannerMessage", "build InAppBannerMessage object");
            return new b(this.f9402b, this.f9403c, this.f9404d, this.f9405e, this.f9406f, this.f9407g, this.f9408h, this.f9401a, this.f9409i);
        }

        public a b(float f2) {
            this.f9403c = f2 * 1000.0f;
            return this;
        }

        public a b(int i2) {
            this.f9406f = i2;
            return this;
        }

        public a c(float f2) {
            this.f9404d = f2 * 1000.0f;
            return this;
        }

        public a c(int i2) {
            this.f9407g = i2;
            return this;
        }

        public a d(int i2) {
            this.f9408h = i2;
            return this;
        }

        public a e(int i2) {
            this.f9401a = i2;
            return this;
        }
    }

    public b(float f2, float f3, float f4, int i2, int i3, int i4, int i5, int i6, cn.jpush.android.d.d dVar) {
        super(dVar);
        this.z = f2;
        this.A = f3;
        this.B = f4;
        this.C = i2;
        this.D = i3;
        this.E = i4;
        this.F = i5;
        this.G = i6;
    }

    public static a j() {
        return new a();
    }

    public boolean a() {
        return this.F == 1;
    }

    public boolean b() {
        return this.G == 1;
    }

    public int c() {
        return this.C;
    }

    public int d() {
        return this.D;
    }

    public int e() {
        return this.E;
    }

    public boolean f() {
        return this.z > 0.0f;
    }

    public float g() {
        return this.z;
    }

    public float h() {
        return this.A;
    }

    public float i() {
        return this.B;
    }
}
