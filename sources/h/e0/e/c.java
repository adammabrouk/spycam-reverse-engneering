package h.e0.e;

import cn.jiguang.internal.JConstants;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import h.a0;
import h.e0.g.e;
import h.r;
import h.y;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* compiled from: CacheStrategy.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public final y f11411a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final a0 f11412b;

    public c(y yVar, a0 a0Var) {
        this.f11411a = yVar;
        this.f11412b = a0Var;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:
    
        if (r3.b().c() == false) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(h.a0 r3, h.y r4) {
        /*
            int r0 = r3.c()
            r1 = 200(0xc8, float:2.8E-43)
            r2 = 0
            if (r0 == r1) goto L5a
            r1 = 410(0x19a, float:5.75E-43)
            if (r0 == r1) goto L5a
            r1 = 414(0x19e, float:5.8E-43)
            if (r0 == r1) goto L5a
            r1 = 501(0x1f5, float:7.02E-43)
            if (r0 == r1) goto L5a
            r1 = 203(0xcb, float:2.84E-43)
            if (r0 == r1) goto L5a
            r1 = 204(0xcc, float:2.86E-43)
            if (r0 == r1) goto L5a
            r1 = 307(0x133, float:4.3E-43)
            if (r0 == r1) goto L31
            r1 = 308(0x134, float:4.32E-43)
            if (r0 == r1) goto L5a
            r1 = 404(0x194, float:5.66E-43)
            if (r0 == r1) goto L5a
            r1 = 405(0x195, float:5.68E-43)
            if (r0 == r1) goto L5a
            switch(r0) {
                case 300: goto L5a;
                case 301: goto L5a;
                case 302: goto L31;
                default: goto L30;
            }
        L30:
            goto L59
        L31:
            java.lang.String r0 = "Expires"
            java.lang.String r0 = r3.b(r0)
            if (r0 != 0) goto L5a
            h.d r0 = r3.b()
            int r0 = r0.e()
            r1 = -1
            if (r0 != r1) goto L5a
            h.d r0 = r3.b()
            boolean r0 = r0.d()
            if (r0 != 0) goto L5a
            h.d r0 = r3.b()
            boolean r0 = r0.c()
            if (r0 == 0) goto L59
            goto L5a
        L59:
            return r2
        L5a:
            h.d r3 = r3.b()
            boolean r3 = r3.j()
            if (r3 != 0) goto L6f
            h.d r3 = r4.b()
            boolean r3 = r3.j()
            if (r3 != 0) goto L6f
            r2 = 1
        L6f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: h.e0.e.c.a(h.a0, h.y):boolean");
    }

    /* compiled from: CacheStrategy.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final long f11413a;

        /* renamed from: b, reason: collision with root package name */
        public final y f11414b;

        /* renamed from: c, reason: collision with root package name */
        public final a0 f11415c;

        /* renamed from: d, reason: collision with root package name */
        public Date f11416d;

        /* renamed from: e, reason: collision with root package name */
        public String f11417e;

        /* renamed from: f, reason: collision with root package name */
        public Date f11418f;

        /* renamed from: g, reason: collision with root package name */
        public String f11419g;

        /* renamed from: h, reason: collision with root package name */
        public Date f11420h;

        /* renamed from: i, reason: collision with root package name */
        public long f11421i;
        public long j;
        public String k;
        public int l;

        public a(long j, y yVar, a0 a0Var) {
            this.l = -1;
            this.f11413a = j;
            this.f11414b = yVar;
            this.f11415c = a0Var;
            if (a0Var != null) {
                this.f11421i = a0Var.u();
                this.j = a0Var.o();
                r g2 = a0Var.g();
                int b2 = g2.b();
                for (int i2 = 0; i2 < b2; i2++) {
                    String a2 = g2.a(i2);
                    String b3 = g2.b(i2);
                    if (HttpHeaders.DATE.equalsIgnoreCase(a2)) {
                        this.f11416d = h.e0.g.d.a(b3);
                        this.f11417e = b3;
                    } else if (HttpHeaders.EXPIRES.equalsIgnoreCase(a2)) {
                        this.f11420h = h.e0.g.d.a(b3);
                    } else if (HttpHeaders.LAST_MODIFIED.equalsIgnoreCase(a2)) {
                        this.f11418f = h.e0.g.d.a(b3);
                        this.f11419g = b3;
                    } else if (HttpHeaders.ETAG.equalsIgnoreCase(a2)) {
                        this.k = b3;
                    } else if ("Age".equalsIgnoreCase(a2)) {
                        this.l = e.a(b3, -1);
                    }
                }
            }
        }

        public final long a() {
            Date date = this.f11416d;
            long max = date != null ? Math.max(0L, this.j - date.getTime()) : 0L;
            int i2 = this.l;
            if (i2 != -1) {
                max = Math.max(max, TimeUnit.SECONDS.toMillis(i2));
            }
            long j = this.j;
            return max + (j - this.f11421i) + (this.f11413a - j);
        }

        public final long b() {
            if (this.f11415c.b().e() != -1) {
                return TimeUnit.SECONDS.toMillis(r0.e());
            }
            if (this.f11420h != null) {
                Date date = this.f11416d;
                long time = this.f11420h.getTime() - (date != null ? date.getTime() : this.j);
                if (time > 0) {
                    return time;
                }
                return 0L;
            }
            if (this.f11418f == null || this.f11415c.r().g().k() != null) {
                return 0L;
            }
            Date date2 = this.f11416d;
            long time2 = (date2 != null ? date2.getTime() : this.f11421i) - this.f11418f.getTime();
            if (time2 > 0) {
                return time2 / 10;
            }
            return 0L;
        }

        public c c() {
            c d2 = d();
            return (d2.f11411a == null || !this.f11414b.b().k()) ? d2 : new c(null, null);
        }

        public final c d() {
            if (this.f11415c == null) {
                return new c(this.f11414b, null);
            }
            if (this.f11414b.d() && this.f11415c.e() == null) {
                return new c(this.f11414b, null);
            }
            if (!c.a(this.f11415c, this.f11414b)) {
                return new c(this.f11414b, null);
            }
            h.d b2 = this.f11414b.b();
            if (b2.i() || a(this.f11414b)) {
                return new c(this.f11414b, null);
            }
            h.d b3 = this.f11415c.b();
            if (b3.b()) {
                return new c(null, this.f11415c);
            }
            long a2 = a();
            long b4 = b();
            if (b2.e() != -1) {
                b4 = Math.min(b4, TimeUnit.SECONDS.toMillis(b2.e()));
            }
            long j = 0;
            long millis = b2.g() != -1 ? TimeUnit.SECONDS.toMillis(b2.g()) : 0L;
            if (!b3.h() && b2.f() != -1) {
                j = TimeUnit.SECONDS.toMillis(b2.f());
            }
            if (!b3.i()) {
                long j2 = millis + a2;
                if (j2 < j + b4) {
                    a0.a l = this.f11415c.l();
                    if (j2 >= b4) {
                        l.a("Warning", "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (a2 > JConstants.DAY && e()) {
                        l.a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return new c(null, l.a());
                }
            }
            String str = this.k;
            String str2 = "If-Modified-Since";
            if (str != null) {
                str2 = "If-None-Match";
            } else if (this.f11418f != null) {
                str = this.f11419g;
            } else {
                if (this.f11416d == null) {
                    return new c(this.f11414b, null);
                }
                str = this.f11417e;
            }
            r.a a3 = this.f11414b.c().a();
            h.e0.a.f11393a.a(a3, str2, str);
            y.a f2 = this.f11414b.f();
            f2.a(a3.a());
            return new c(f2.a(), this.f11415c);
        }

        public final boolean e() {
            return this.f11415c.b().e() == -1 && this.f11420h == null;
        }

        public static boolean a(y yVar) {
            return (yVar.a("If-Modified-Since") == null && yVar.a("If-None-Match") == null) ? false : true;
        }
    }
}
