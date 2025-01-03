package h.e0.e;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import h.a0;
import h.b0;
import h.e0.e.c;
import h.e0.g.f;
import h.e0.g.h;
import h.r;
import h.t;
import h.w;
import h.y;
import i.e;
import i.l;
import i.r;
import i.s;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* compiled from: CacheInterceptor.java */
/* loaded from: classes.dex */
public final class a implements t {

    /* renamed from: a, reason: collision with root package name */
    public final d f11406a;

    /* compiled from: CacheInterceptor.java */
    /* renamed from: h.e0.e.a$a, reason: collision with other inner class name */
    public class C0167a implements s {

        /* renamed from: a, reason: collision with root package name */
        public boolean f11407a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f11408b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f11409c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ i.d f11410d;

        public C0167a(a aVar, e eVar, b bVar, i.d dVar) {
            this.f11408b = eVar;
            this.f11409c = bVar;
            this.f11410d = dVar;
        }

        @Override // i.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!this.f11407a && !h.e0.c.a(this, 100, TimeUnit.MILLISECONDS)) {
                this.f11407a = true;
                this.f11409c.b();
            }
            this.f11408b.close();
        }

        @Override // i.s
        public long read(i.c cVar, long j) throws IOException {
            try {
                long read = this.f11408b.read(cVar, j);
                if (read != -1) {
                    cVar.a(this.f11410d.d(), cVar.g() - read, read);
                    this.f11410d.q();
                    return read;
                }
                if (!this.f11407a) {
                    this.f11407a = true;
                    this.f11410d.close();
                }
                return -1L;
            } catch (IOException e2) {
                if (!this.f11407a) {
                    this.f11407a = true;
                    this.f11409c.b();
                }
                throw e2;
            }
        }

        @Override // i.s
        public i.t timeout() {
            return this.f11408b.timeout();
        }
    }

    public a(d dVar) {
        this.f11406a = dVar;
    }

    public static a0 a(a0 a0Var) {
        if (a0Var == null || a0Var.a() == null) {
            return a0Var;
        }
        a0.a l = a0Var.l();
        l.a((b0) null);
        return l.a();
    }

    public static boolean b(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }

    @Override // h.t
    public a0 intercept(t.a aVar) throws IOException {
        d dVar = this.f11406a;
        a0 a2 = dVar != null ? dVar.a(aVar.a()) : null;
        c c2 = new c.a(System.currentTimeMillis(), aVar.a(), a2).c();
        y yVar = c2.f11411a;
        a0 a0Var = c2.f11412b;
        d dVar2 = this.f11406a;
        if (dVar2 != null) {
            dVar2.a(c2);
        }
        if (a2 != null && a0Var == null) {
            h.e0.c.a(a2.a());
        }
        if (yVar == null && a0Var == null) {
            a0.a aVar2 = new a0.a();
            aVar2.a(aVar.a());
            aVar2.a(w.HTTP_1_1);
            aVar2.a(504);
            aVar2.a("Unsatisfiable Request (only-if-cached)");
            aVar2.a(h.e0.c.f11397c);
            aVar2.b(-1L);
            aVar2.a(System.currentTimeMillis());
            return aVar2.a();
        }
        if (yVar == null) {
            a0.a l = a0Var.l();
            l.a(a(a0Var));
            return l.a();
        }
        try {
            a0 a3 = aVar.a(yVar);
            if (a3 == null && a2 != null) {
            }
            if (a0Var != null) {
                if (a3.c() == 304) {
                    a0.a l2 = a0Var.l();
                    l2.a(a(a0Var.g(), a3.g()));
                    l2.b(a3.u());
                    l2.a(a3.o());
                    l2.a(a(a0Var));
                    l2.c(a(a3));
                    a0 a4 = l2.a();
                    a3.a().close();
                    this.f11406a.a();
                    this.f11406a.a(a0Var, a4);
                    return a4;
                }
                h.e0.c.a(a0Var.a());
            }
            a0.a l3 = a3.l();
            l3.a(a(a0Var));
            l3.c(a(a3));
            a0 a5 = l3.a();
            if (this.f11406a != null) {
                if (h.e0.g.e.b(a5) && c.a(a5, yVar)) {
                    return a(this.f11406a.a(a5), a5);
                }
                if (f.a(yVar.e())) {
                    try {
                        this.f11406a.b(yVar);
                    } catch (IOException unused) {
                    }
                }
            }
            return a5;
        } finally {
            if (a2 != null) {
                h.e0.c.a(a2.a());
            }
        }
    }

    public final a0 a(b bVar, a0 a0Var) throws IOException {
        r a2;
        if (bVar == null || (a2 = bVar.a()) == null) {
            return a0Var;
        }
        C0167a c0167a = new C0167a(this, a0Var.a().source(), bVar, l.a(a2));
        String b2 = a0Var.b(HttpHeaders.CONTENT_TYPE);
        long contentLength = a0Var.a().contentLength();
        a0.a l = a0Var.l();
        l.a(new h(b2, contentLength, l.a(c0167a)));
        return l.a();
    }

    public static h.r a(h.r rVar, h.r rVar2) {
        r.a aVar = new r.a();
        int b2 = rVar.b();
        for (int i2 = 0; i2 < b2; i2++) {
            String a2 = rVar.a(i2);
            String b3 = rVar.b(i2);
            if ((!"Warning".equalsIgnoreCase(a2) || !b3.startsWith("1")) && (a(a2) || !b(a2) || rVar2.a(a2) == null)) {
                h.e0.a.f11393a.a(aVar, a2, b3);
            }
        }
        int b4 = rVar2.b();
        for (int i3 = 0; i3 < b4; i3++) {
            String a3 = rVar2.a(i3);
            if (!a(a3) && b(a3)) {
                h.e0.a.f11393a.a(aVar, a3, rVar2.b(i3));
            }
        }
        return aVar.a();
    }

    public static boolean a(String str) {
        return HttpHeaders.CONTENT_LENGTH.equalsIgnoreCase(str) || HttpHeaders.CONTENT_ENCODING.equalsIgnoreCase(str) || HttpHeaders.CONTENT_TYPE.equalsIgnoreCase(str);
    }
}
