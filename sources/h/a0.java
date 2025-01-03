package h;

import h.r;
import java.io.Closeable;
import javax.annotation.Nullable;

/* compiled from: Response.java */
/* loaded from: classes.dex */
public final class a0 implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public final y f11345a;

    /* renamed from: b, reason: collision with root package name */
    public final w f11346b;

    /* renamed from: c, reason: collision with root package name */
    public final int f11347c;

    /* renamed from: d, reason: collision with root package name */
    public final String f11348d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public final q f11349e;

    /* renamed from: f, reason: collision with root package name */
    public final r f11350f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public final b0 f11351g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public final a0 f11352h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public final a0 f11353i;

    @Nullable
    public final a0 j;
    public final long k;
    public final long l;
    public volatile d m;

    /* compiled from: Response.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public y f11354a;

        /* renamed from: b, reason: collision with root package name */
        public w f11355b;

        /* renamed from: c, reason: collision with root package name */
        public int f11356c;

        /* renamed from: d, reason: collision with root package name */
        public String f11357d;

        /* renamed from: e, reason: collision with root package name */
        @Nullable
        public q f11358e;

        /* renamed from: f, reason: collision with root package name */
        public r.a f11359f;

        /* renamed from: g, reason: collision with root package name */
        public b0 f11360g;

        /* renamed from: h, reason: collision with root package name */
        public a0 f11361h;

        /* renamed from: i, reason: collision with root package name */
        public a0 f11362i;
        public a0 j;
        public long k;
        public long l;

        public a() {
            this.f11356c = -1;
            this.f11359f = new r.a();
        }

        public a a(y yVar) {
            this.f11354a = yVar;
            return this;
        }

        public final void b(a0 a0Var) {
            if (a0Var.f11351g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public a c(@Nullable a0 a0Var) {
            if (a0Var != null) {
                a("networkResponse", a0Var);
            }
            this.f11361h = a0Var;
            return this;
        }

        public a d(@Nullable a0 a0Var) {
            if (a0Var != null) {
                b(a0Var);
            }
            this.j = a0Var;
            return this;
        }

        public a a(w wVar) {
            this.f11355b = wVar;
            return this;
        }

        public a a(int i2) {
            this.f11356c = i2;
            return this;
        }

        public a b(long j) {
            this.k = j;
            return this;
        }

        public a(a0 a0Var) {
            this.f11356c = -1;
            this.f11354a = a0Var.f11345a;
            this.f11355b = a0Var.f11346b;
            this.f11356c = a0Var.f11347c;
            this.f11357d = a0Var.f11348d;
            this.f11358e = a0Var.f11349e;
            this.f11359f = a0Var.f11350f.a();
            this.f11360g = a0Var.f11351g;
            this.f11361h = a0Var.f11352h;
            this.f11362i = a0Var.f11353i;
            this.j = a0Var.j;
            this.k = a0Var.k;
            this.l = a0Var.l;
        }

        public a a(String str) {
            this.f11357d = str;
            return this;
        }

        public a a(@Nullable q qVar) {
            this.f11358e = qVar;
            return this;
        }

        public a a(String str, String str2) {
            this.f11359f.a(str, str2);
            return this;
        }

        public a a(r rVar) {
            this.f11359f = rVar.a();
            return this;
        }

        public a a(@Nullable b0 b0Var) {
            this.f11360g = b0Var;
            return this;
        }

        public a a(@Nullable a0 a0Var) {
            if (a0Var != null) {
                a("cacheResponse", a0Var);
            }
            this.f11362i = a0Var;
            return this;
        }

        public final void a(String str, a0 a0Var) {
            if (a0Var.f11351g == null) {
                if (a0Var.f11352h == null) {
                    if (a0Var.f11353i == null) {
                        if (a0Var.j == null) {
                            return;
                        }
                        throw new IllegalArgumentException(str + ".priorResponse != null");
                    }
                    throw new IllegalArgumentException(str + ".cacheResponse != null");
                }
                throw new IllegalArgumentException(str + ".networkResponse != null");
            }
            throw new IllegalArgumentException(str + ".body != null");
        }

        public a a(long j) {
            this.l = j;
            return this;
        }

        public a0 a() {
            if (this.f11354a != null) {
                if (this.f11355b != null) {
                    if (this.f11356c >= 0) {
                        if (this.f11357d != null) {
                            return new a0(this);
                        }
                        throw new IllegalStateException("message == null");
                    }
                    throw new IllegalStateException("code < 0: " + this.f11356c);
                }
                throw new IllegalStateException("protocol == null");
            }
            throw new IllegalStateException("request == null");
        }
    }

    public a0(a aVar) {
        this.f11345a = aVar.f11354a;
        this.f11346b = aVar.f11355b;
        this.f11347c = aVar.f11356c;
        this.f11348d = aVar.f11357d;
        this.f11349e = aVar.f11358e;
        this.f11350f = aVar.f11359f.a();
        this.f11351g = aVar.f11360g;
        this.f11352h = aVar.f11361h;
        this.f11353i = aVar.f11362i;
        this.j = aVar.j;
        this.k = aVar.k;
        this.l = aVar.l;
    }

    @Nullable
    public String a(String str, @Nullable String str2) {
        String a2 = this.f11350f.a(str);
        return a2 != null ? a2 : str2;
    }

    @Nullable
    public String b(String str) {
        return a(str, null);
    }

    public int c() {
        return this.f11347c;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        b0 b0Var = this.f11351g;
        if (b0Var == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        b0Var.close();
    }

    public q e() {
        return this.f11349e;
    }

    public r g() {
        return this.f11350f;
    }

    public a l() {
        return new a(this);
    }

    @Nullable
    public a0 m() {
        return this.j;
    }

    public long o() {
        return this.l;
    }

    public y r() {
        return this.f11345a;
    }

    public String toString() {
        return "Response{protocol=" + this.f11346b + ", code=" + this.f11347c + ", message=" + this.f11348d + ", url=" + this.f11345a.g() + '}';
    }

    public long u() {
        return this.k;
    }

    @Nullable
    public b0 a() {
        return this.f11351g;
    }

    public d b() {
        d dVar = this.m;
        if (dVar != null) {
            return dVar;
        }
        d a2 = d.a(this.f11350f);
        this.m = a2;
        return a2;
    }
}
