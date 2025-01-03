package h;

import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* compiled from: CacheControl.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f11375a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f11376b;

    /* renamed from: c, reason: collision with root package name */
    public final int f11377c;

    /* renamed from: d, reason: collision with root package name */
    public final int f11378d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f11379e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f11380f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f11381g;

    /* renamed from: h, reason: collision with root package name */
    public final int f11382h;

    /* renamed from: i, reason: collision with root package name */
    public final int f11383i;
    public final boolean j;
    public final boolean k;
    public final boolean l;

    @Nullable
    public String m;

    static {
        a aVar = new a();
        aVar.b();
        aVar.a();
        a aVar2 = new a();
        aVar2.c();
        aVar2.a(Integer.MAX_VALUE, TimeUnit.SECONDS);
        aVar2.a();
    }

    public d(boolean z, boolean z2, int i2, int i3, boolean z3, boolean z4, boolean z5, int i4, int i5, boolean z6, boolean z7, boolean z8, @Nullable String str) {
        this.f11375a = z;
        this.f11376b = z2;
        this.f11377c = i2;
        this.f11378d = i3;
        this.f11379e = z3;
        this.f11380f = z4;
        this.f11381g = z5;
        this.f11382h = i4;
        this.f11383i = i5;
        this.j = z6;
        this.k = z7;
        this.l = z8;
        this.m = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static h.d a(h.r r22) {
        /*
            Method dump skipped, instructions count: 333
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: h.d.a(h.r):h.d");
    }

    public boolean b() {
        return this.l;
    }

    public boolean c() {
        return this.f11379e;
    }

    public boolean d() {
        return this.f11380f;
    }

    public int e() {
        return this.f11377c;
    }

    public int f() {
        return this.f11382h;
    }

    public int g() {
        return this.f11383i;
    }

    public boolean h() {
        return this.f11381g;
    }

    public boolean i() {
        return this.f11375a;
    }

    public boolean j() {
        return this.f11376b;
    }

    public boolean k() {
        return this.j;
    }

    public String toString() {
        String str = this.m;
        if (str != null) {
            return str;
        }
        String a2 = a();
        this.m = a2;
        return a2;
    }

    /* compiled from: CacheControl.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f11384a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f11385b;

        /* renamed from: c, reason: collision with root package name */
        public int f11386c = -1;

        /* renamed from: d, reason: collision with root package name */
        public int f11387d = -1;

        /* renamed from: e, reason: collision with root package name */
        public int f11388e = -1;

        /* renamed from: f, reason: collision with root package name */
        public boolean f11389f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f11390g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f11391h;

        public a a(int i2, TimeUnit timeUnit) {
            if (i2 >= 0) {
                long seconds = timeUnit.toSeconds(i2);
                this.f11387d = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("maxStale < 0: " + i2);
        }

        public a b() {
            this.f11384a = true;
            return this;
        }

        public a c() {
            this.f11389f = true;
            return this;
        }

        public d a() {
            return new d(this);
        }
    }

    public d(a aVar) {
        this.f11375a = aVar.f11384a;
        this.f11376b = aVar.f11385b;
        this.f11377c = aVar.f11386c;
        this.f11378d = -1;
        this.f11379e = false;
        this.f11380f = false;
        this.f11381g = false;
        this.f11382h = aVar.f11387d;
        this.f11383i = aVar.f11388e;
        this.j = aVar.f11389f;
        this.k = aVar.f11390g;
        this.l = aVar.f11391h;
    }

    public final String a() {
        StringBuilder sb = new StringBuilder();
        if (this.f11375a) {
            sb.append("no-cache, ");
        }
        if (this.f11376b) {
            sb.append("no-store, ");
        }
        if (this.f11377c != -1) {
            sb.append("max-age=");
            sb.append(this.f11377c);
            sb.append(", ");
        }
        if (this.f11378d != -1) {
            sb.append("s-maxage=");
            sb.append(this.f11378d);
            sb.append(", ");
        }
        if (this.f11379e) {
            sb.append("private, ");
        }
        if (this.f11380f) {
            sb.append("public, ");
        }
        if (this.f11381g) {
            sb.append("must-revalidate, ");
        }
        if (this.f11382h != -1) {
            sb.append("max-stale=");
            sb.append(this.f11382h);
            sb.append(", ");
        }
        if (this.f11383i != -1) {
            sb.append("min-fresh=");
            sb.append(this.f11383i);
            sb.append(", ");
        }
        if (this.j) {
            sb.append("only-if-cached, ");
        }
        if (this.k) {
            sb.append("no-transform, ");
        }
        if (this.l) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }
}
