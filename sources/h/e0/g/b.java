package h.e0.g;

import h.a0;
import h.t;
import h.y;
import i.l;
import i.r;
import java.io.IOException;
import java.net.ProtocolException;

/* compiled from: CallServerInterceptor.java */
/* loaded from: classes.dex */
public final class b implements t {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f11457a;

    /* compiled from: CallServerInterceptor.java */
    public static final class a extends i.g {

        /* renamed from: b, reason: collision with root package name */
        public long f11458b;

        public a(r rVar) {
            super(rVar);
        }

        @Override // i.g, i.r
        public void a(i.c cVar, long j) throws IOException {
            super.a(cVar, j);
            this.f11458b += j;
        }
    }

    public b(boolean z) {
        this.f11457a = z;
    }

    @Override // h.t
    public a0 intercept(t.a aVar) throws IOException {
        a0 a2;
        g gVar = (g) aVar;
        c h2 = gVar.h();
        h.e0.f.g i2 = gVar.i();
        h.e0.f.c cVar = (h.e0.f.c) gVar.f();
        y a3 = gVar.a();
        long currentTimeMillis = System.currentTimeMillis();
        gVar.g().d(gVar.e());
        h2.a(a3);
        gVar.g().a(gVar.e(), a3);
        a0.a aVar2 = null;
        if (f.b(a3.e()) && a3.a() != null) {
            if ("100-continue".equalsIgnoreCase(a3.a("Expect"))) {
                h2.b();
                gVar.g().f(gVar.e());
                aVar2 = h2.a(true);
            }
            if (aVar2 == null) {
                gVar.g().c(gVar.e());
                a aVar3 = new a(h2.a(a3, a3.a().contentLength()));
                i.d a4 = l.a(aVar3);
                a3.a().writeTo(a4);
                a4.close();
                gVar.g().a(gVar.e(), aVar3.f11458b);
            } else if (!cVar.d()) {
                i2.e();
            }
        }
        h2.a();
        if (aVar2 == null) {
            gVar.g().f(gVar.e());
            aVar2 = h2.a(false);
        }
        aVar2.a(a3);
        aVar2.a(i2.c().c());
        aVar2.b(currentTimeMillis);
        aVar2.a(System.currentTimeMillis());
        a0 a5 = aVar2.a();
        int c2 = a5.c();
        if (c2 == 100) {
            a0.a a6 = h2.a(false);
            a6.a(a3);
            a6.a(i2.c().c());
            a6.b(currentTimeMillis);
            a6.a(System.currentTimeMillis());
            a5 = a6.a();
            c2 = a5.c();
        }
        gVar.g().a(gVar.e(), a5);
        if (this.f11457a && c2 == 101) {
            a0.a l = a5.l();
            l.a(h.e0.c.f11397c);
            a2 = l.a();
        } else {
            a0.a l2 = a5.l();
            l2.a(h2.a(a5));
            a2 = l2.a();
        }
        if ("close".equalsIgnoreCase(a2.r().a("Connection")) || "close".equalsIgnoreCase(a2.b("Connection"))) {
            i2.e();
        }
        if ((c2 != 204 && c2 != 205) || a2.a().contentLength() <= 0) {
            return a2;
        }
        throw new ProtocolException("HTTP " + c2 + " had non-zero Content-Length: " + a2.a().contentLength());
    }
}
