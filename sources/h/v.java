package h;

import h.a0;
import h.p;
import h.r;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* compiled from: OkHttpClient.java */
/* loaded from: classes.dex */
public class v implements Cloneable {
    public static final List<w> C = h.e0.c.a(w.HTTP_2, w.HTTP_1_1);
    public static final List<k> D = h.e0.c.a(k.f11704g, k.f11705h);
    public final int A;
    public final int B;

    /* renamed from: a, reason: collision with root package name */
    public final n f11761a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final Proxy f11762b;

    /* renamed from: c, reason: collision with root package name */
    public final List<w> f11763c;

    /* renamed from: d, reason: collision with root package name */
    public final List<k> f11764d;

    /* renamed from: e, reason: collision with root package name */
    public final List<t> f11765e;

    /* renamed from: f, reason: collision with root package name */
    public final List<t> f11766f;

    /* renamed from: g, reason: collision with root package name */
    public final p.c f11767g;

    /* renamed from: h, reason: collision with root package name */
    public final ProxySelector f11768h;

    /* renamed from: i, reason: collision with root package name */
    public final m f11769i;

    @Nullable
    public final c j;

    @Nullable
    public final h.e0.e.d k;
    public final SocketFactory l;

    @Nullable
    public final SSLSocketFactory m;

    @Nullable
    public final h.e0.k.c n;
    public final HostnameVerifier o;
    public final g p;
    public final h.b q;
    public final h.b r;
    public final j t;
    public final o u;
    public final boolean v;
    public final boolean w;
    public final boolean x;
    public final int y;
    public final int z;

    /* compiled from: OkHttpClient.java */
    public class a extends h.e0.a {
        @Override // h.e0.a
        public void a(r.a aVar, String str) {
            aVar.a(str);
        }

        @Override // h.e0.a
        public void b(j jVar, h.e0.f.c cVar) {
            jVar.b(cVar);
        }

        @Override // h.e0.a
        public void a(r.a aVar, String str, String str2) {
            aVar.b(str, str2);
        }

        @Override // h.e0.a
        public boolean a(j jVar, h.e0.f.c cVar) {
            return jVar.a(cVar);
        }

        @Override // h.e0.a
        public h.e0.f.c a(j jVar, h.a aVar, h.e0.f.g gVar, c0 c0Var) {
            return jVar.a(aVar, gVar, c0Var);
        }

        @Override // h.e0.a
        public boolean a(h.a aVar, h.a aVar2) {
            return aVar.a(aVar2);
        }

        @Override // h.e0.a
        public Socket a(j jVar, h.a aVar, h.e0.f.g gVar) {
            return jVar.a(aVar, gVar);
        }

        @Override // h.e0.a
        public h.e0.f.d a(j jVar) {
            return jVar.f11699e;
        }

        @Override // h.e0.a
        public int a(a0.a aVar) {
            return aVar.f11356c;
        }

        @Override // h.e0.a
        public void a(k kVar, SSLSocket sSLSocket, boolean z) {
            kVar.a(sSLSocket, z);
        }
    }

    /* compiled from: OkHttpClient.java */
    public static final class b {
        public int A;

        /* renamed from: a, reason: collision with root package name */
        public n f11770a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public Proxy f11771b;

        /* renamed from: c, reason: collision with root package name */
        public List<w> f11772c;

        /* renamed from: d, reason: collision with root package name */
        public List<k> f11773d;

        /* renamed from: e, reason: collision with root package name */
        public final List<t> f11774e;

        /* renamed from: f, reason: collision with root package name */
        public final List<t> f11775f;

        /* renamed from: g, reason: collision with root package name */
        public p.c f11776g;

        /* renamed from: h, reason: collision with root package name */
        public ProxySelector f11777h;

        /* renamed from: i, reason: collision with root package name */
        public m f11778i;

        @Nullable
        public c j;

        @Nullable
        public h.e0.e.d k;
        public SocketFactory l;

        @Nullable
        public SSLSocketFactory m;

        @Nullable
        public h.e0.k.c n;
        public HostnameVerifier o;
        public g p;
        public h.b q;
        public h.b r;
        public j s;
        public o t;
        public boolean u;
        public boolean v;
        public boolean w;
        public int x;
        public int y;
        public int z;

        public b() {
            this.f11774e = new ArrayList();
            this.f11775f = new ArrayList();
            this.f11770a = new n();
            this.f11772c = v.C;
            this.f11773d = v.D;
            this.f11776g = p.a(p.f11732a);
            this.f11777h = ProxySelector.getDefault();
            this.f11778i = m.f11723a;
            this.l = SocketFactory.getDefault();
            this.o = h.e0.k.d.f11676a;
            this.p = g.f11677c;
            h.b bVar = h.b.f11363a;
            this.q = bVar;
            this.r = bVar;
            this.s = new j();
            this.t = o.f11731a;
            this.u = true;
            this.v = true;
            this.w = true;
            this.x = 10000;
            this.y = 10000;
            this.z = 10000;
            this.A = 0;
        }

        public b a(long j, TimeUnit timeUnit) {
            this.x = h.e0.c.a("timeout", j, timeUnit);
            return this;
        }

        public b b(long j, TimeUnit timeUnit) {
            this.y = h.e0.c.a("timeout", j, timeUnit);
            return this;
        }

        public b c(long j, TimeUnit timeUnit) {
            this.z = h.e0.c.a("timeout", j, timeUnit);
            return this;
        }

        public b a(@Nullable Proxy proxy) {
            this.f11771b = proxy;
            return this;
        }

        public b b(boolean z) {
            this.u = z;
            return this;
        }

        public b c(boolean z) {
            this.w = z;
            return this;
        }

        public b a(@Nullable c cVar) {
            this.j = cVar;
            this.k = null;
            return this;
        }

        public b a(HostnameVerifier hostnameVerifier) {
            if (hostnameVerifier != null) {
                this.o = hostnameVerifier;
                return this;
            }
            throw new NullPointerException("hostnameVerifier == null");
        }

        public b a(boolean z) {
            this.v = z;
            return this;
        }

        public b a(n nVar) {
            if (nVar != null) {
                this.f11770a = nVar;
                return this;
            }
            throw new IllegalArgumentException("dispatcher == null");
        }

        public b a(t tVar) {
            if (tVar != null) {
                this.f11775f.add(tVar);
                return this;
            }
            throw new IllegalArgumentException("interceptor == null");
        }

        public v a() {
            return new v(this);
        }

        public b(v vVar) {
            this.f11774e = new ArrayList();
            this.f11775f = new ArrayList();
            this.f11770a = vVar.f11761a;
            this.f11771b = vVar.f11762b;
            this.f11772c = vVar.f11763c;
            this.f11773d = vVar.f11764d;
            this.f11774e.addAll(vVar.f11765e);
            this.f11775f.addAll(vVar.f11766f);
            this.f11776g = vVar.f11767g;
            this.f11777h = vVar.f11768h;
            this.f11778i = vVar.f11769i;
            this.k = vVar.k;
            this.j = vVar.j;
            this.l = vVar.l;
            this.m = vVar.m;
            this.n = vVar.n;
            this.o = vVar.o;
            this.p = vVar.p;
            this.q = vVar.q;
            this.r = vVar.r;
            this.s = vVar.t;
            this.t = vVar.u;
            this.u = vVar.v;
            this.v = vVar.w;
            this.w = vVar.x;
            this.x = vVar.y;
            this.y = vVar.z;
            this.z = vVar.A;
            this.A = vVar.B;
        }
    }

    static {
        h.e0.a.f11393a = new a();
    }

    public v() {
        this(new b());
    }

    public static SSLSocketFactory a(X509TrustManager x509TrustManager) {
        try {
            SSLContext a2 = h.e0.j.f.c().a();
            a2.init(null, new TrustManager[]{x509TrustManager}, null);
            return a2.getSocketFactory();
        } catch (GeneralSecurityException e2) {
            throw h.e0.c.a("No System TLS", (Exception) e2);
        }
    }

    public g b() {
        return this.p;
    }

    public int c() {
        return this.y;
    }

    public j d() {
        return this.t;
    }

    public List<k> e() {
        return this.f11764d;
    }

    public m f() {
        return this.f11769i;
    }

    public n g() {
        return this.f11761a;
    }

    public o h() {
        return this.u;
    }

    public p.c i() {
        return this.f11767g;
    }

    public boolean j() {
        return this.w;
    }

    public boolean k() {
        return this.v;
    }

    public HostnameVerifier l() {
        return this.o;
    }

    public List<t> m() {
        return this.f11765e;
    }

    public h.e0.e.d n() {
        c cVar = this.j;
        return cVar != null ? cVar.f11371a : this.k;
    }

    public List<t> o() {
        return this.f11766f;
    }

    public b p() {
        return new b(this);
    }

    public int q() {
        return this.B;
    }

    public List<w> r() {
        return this.f11763c;
    }

    public Proxy s() {
        return this.f11762b;
    }

    public h.b t() {
        return this.q;
    }

    public ProxySelector u() {
        return this.f11768h;
    }

    public int v() {
        return this.z;
    }

    public boolean w() {
        return this.x;
    }

    public SocketFactory x() {
        return this.l;
    }

    public SSLSocketFactory y() {
        return this.m;
    }

    public int z() {
        return this.A;
    }

    public v(b bVar) {
        boolean z;
        this.f11761a = bVar.f11770a;
        this.f11762b = bVar.f11771b;
        this.f11763c = bVar.f11772c;
        this.f11764d = bVar.f11773d;
        this.f11765e = h.e0.c.a(bVar.f11774e);
        this.f11766f = h.e0.c.a(bVar.f11775f);
        this.f11767g = bVar.f11776g;
        this.f11768h = bVar.f11777h;
        this.f11769i = bVar.f11778i;
        this.j = bVar.j;
        this.k = bVar.k;
        this.l = bVar.l;
        Iterator<k> it = this.f11764d.iterator();
        loop0: while (true) {
            while (it.hasNext()) {
                z = z || it.next().b();
            }
        }
        if (bVar.m == null && z) {
            X509TrustManager a2 = h.e0.c.a();
            this.m = a(a2);
            this.n = h.e0.k.c.a(a2);
        } else {
            this.m = bVar.m;
            this.n = bVar.n;
        }
        if (this.m != null) {
            h.e0.j.f.c().a(this.m);
        }
        this.o = bVar.o;
        this.p = bVar.p.a(this.n);
        this.q = bVar.q;
        this.r = bVar.r;
        this.t = bVar.s;
        this.u = bVar.t;
        this.v = bVar.u;
        this.w = bVar.v;
        this.x = bVar.w;
        this.y = bVar.x;
        this.z = bVar.y;
        this.A = bVar.z;
        this.B = bVar.A;
        if (this.f11765e.contains(null)) {
            throw new IllegalStateException("Null interceptor: " + this.f11765e);
        }
        if (this.f11766f.contains(null)) {
            throw new IllegalStateException("Null network interceptor: " + this.f11766f);
        }
    }

    public h.b a() {
        return this.r;
    }

    public e a(y yVar) {
        return x.a(this, yVar, false);
    }
}
