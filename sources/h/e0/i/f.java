package h.e0.i;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import h.a0;
import h.b0;
import h.r;
import h.t;
import h.v;
import h.w;
import h.y;
import i.r;
import i.s;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* compiled from: Http2Codec.java */
/* loaded from: classes.dex */
public final class f implements h.e0.g.c {

    /* renamed from: f, reason: collision with root package name */
    public static final i.f f11538f = i.f.encodeUtf8("connection");

    /* renamed from: g, reason: collision with root package name */
    public static final i.f f11539g = i.f.encodeUtf8("host");

    /* renamed from: h, reason: collision with root package name */
    public static final i.f f11540h = i.f.encodeUtf8("keep-alive");

    /* renamed from: i, reason: collision with root package name */
    public static final i.f f11541i = i.f.encodeUtf8("proxy-connection");
    public static final i.f j = i.f.encodeUtf8("transfer-encoding");
    public static final i.f k = i.f.encodeUtf8("te");
    public static final i.f l = i.f.encodeUtf8("encoding");
    public static final i.f m;
    public static final List<i.f> n;
    public static final List<i.f> o;

    /* renamed from: a, reason: collision with root package name */
    public final t.a f11542a;

    /* renamed from: b, reason: collision with root package name */
    public final h.e0.f.g f11543b;

    /* renamed from: c, reason: collision with root package name */
    public final g f11544c;

    /* renamed from: d, reason: collision with root package name */
    public i f11545d;

    /* renamed from: e, reason: collision with root package name */
    public final w f11546e;

    /* compiled from: Http2Codec.java */
    public class a extends i.h {

        /* renamed from: a, reason: collision with root package name */
        public boolean f11547a;

        /* renamed from: b, reason: collision with root package name */
        public long f11548b;

        public a(s sVar) {
            super(sVar);
            this.f11547a = false;
            this.f11548b = 0L;
        }

        public final void a(IOException iOException) {
            if (this.f11547a) {
                return;
            }
            this.f11547a = true;
            f fVar = f.this;
            fVar.f11543b.a(false, fVar, this.f11548b, iOException);
        }

        @Override // i.h, i.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            a(null);
        }

        @Override // i.h, i.s
        public long read(i.c cVar, long j) throws IOException {
            try {
                long read = delegate().read(cVar, j);
                if (read > 0) {
                    this.f11548b += read;
                }
                return read;
            } catch (IOException e2) {
                a(e2);
                throw e2;
            }
        }
    }

    static {
        i.f encodeUtf8 = i.f.encodeUtf8("upgrade");
        m = encodeUtf8;
        n = h.e0.c.a(f11538f, f11539g, f11540h, f11541i, k, j, l, encodeUtf8, c.f11508f, c.f11509g, c.f11510h, c.f11511i);
        o = h.e0.c.a(f11538f, f11539g, f11540h, f11541i, k, j, l, m);
    }

    public f(v vVar, t.a aVar, h.e0.f.g gVar, g gVar2) {
        this.f11542a = aVar;
        this.f11543b = gVar;
        this.f11544c = gVar2;
        this.f11546e = vVar.r().contains(w.H2_PRIOR_KNOWLEDGE) ? w.H2_PRIOR_KNOWLEDGE : w.HTTP_2;
    }

    @Override // h.e0.g.c
    public r a(y yVar, long j2) {
        return this.f11545d.d();
    }

    @Override // h.e0.g.c
    public void b() throws IOException {
        this.f11544c.flush();
    }

    @Override // h.e0.g.c
    public void cancel() {
        i iVar = this.f11545d;
        if (iVar != null) {
            iVar.c(b.CANCEL);
        }
    }

    public static List<c> b(y yVar) {
        h.r c2 = yVar.c();
        ArrayList arrayList = new ArrayList(c2.b() + 4);
        arrayList.add(new c(c.f11508f, yVar.e()));
        arrayList.add(new c(c.f11509g, h.e0.g.i.a(yVar.g())));
        String a2 = yVar.a(HttpHeaders.HOST);
        if (a2 != null) {
            arrayList.add(new c(c.f11511i, a2));
        }
        arrayList.add(new c(c.f11510h, yVar.g().m()));
        int b2 = c2.b();
        for (int i2 = 0; i2 < b2; i2++) {
            i.f encodeUtf8 = i.f.encodeUtf8(c2.a(i2).toLowerCase(Locale.US));
            if (!n.contains(encodeUtf8)) {
                arrayList.add(new c(encodeUtf8, c2.b(i2)));
            }
        }
        return arrayList;
    }

    @Override // h.e0.g.c
    public void a(y yVar) throws IOException {
        if (this.f11545d != null) {
            return;
        }
        i a2 = this.f11544c.a(b(yVar), yVar.a() != null);
        this.f11545d = a2;
        a2.h().a(this.f11542a.c(), TimeUnit.MILLISECONDS);
        this.f11545d.l().a(this.f11542a.d(), TimeUnit.MILLISECONDS);
    }

    @Override // h.e0.g.c
    public void a() throws IOException {
        this.f11545d.d().close();
    }

    @Override // h.e0.g.c
    public a0.a a(boolean z) throws IOException {
        a0.a a2 = a(this.f11545d.j(), this.f11546e);
        if (z && h.e0.a.f11393a.a(a2) == 100) {
            return null;
        }
        return a2;
    }

    public static a0.a a(List<c> list, w wVar) throws IOException {
        r.a aVar = new r.a();
        int size = list.size();
        h.e0.g.k kVar = null;
        for (int i2 = 0; i2 < size; i2++) {
            c cVar = list.get(i2);
            if (cVar == null) {
                if (kVar != null && kVar.f11480b == 100) {
                    aVar = new r.a();
                    kVar = null;
                }
            } else {
                i.f fVar = cVar.f11512a;
                String utf8 = cVar.f11513b.utf8();
                if (fVar.equals(c.f11507e)) {
                    kVar = h.e0.g.k.a("HTTP/1.1 " + utf8);
                } else if (!o.contains(fVar)) {
                    h.e0.a.f11393a.a(aVar, fVar.utf8(), utf8);
                }
            }
        }
        if (kVar != null) {
            a0.a aVar2 = new a0.a();
            aVar2.a(wVar);
            aVar2.a(kVar.f11480b);
            aVar2.a(kVar.f11481c);
            aVar2.a(aVar.a());
            return aVar2;
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    @Override // h.e0.g.c
    public b0 a(a0 a0Var) throws IOException {
        h.e0.f.g gVar = this.f11543b;
        gVar.f11451f.e(gVar.f11450e);
        return new h.e0.g.h(a0Var.b(HttpHeaders.CONTENT_TYPE), h.e0.g.e.a(a0Var), i.l.a(new a(this.f11545d.e())));
    }
}
