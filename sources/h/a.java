package h;

import h.s;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: Address.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final s f11336a;

    /* renamed from: b, reason: collision with root package name */
    public final o f11337b;

    /* renamed from: c, reason: collision with root package name */
    public final SocketFactory f11338c;

    /* renamed from: d, reason: collision with root package name */
    public final b f11339d;

    /* renamed from: e, reason: collision with root package name */
    public final List<w> f11340e;

    /* renamed from: f, reason: collision with root package name */
    public final List<k> f11341f;

    /* renamed from: g, reason: collision with root package name */
    public final ProxySelector f11342g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public final Proxy f11343h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public final SSLSocketFactory f11344i;

    @Nullable
    public final HostnameVerifier j;

    @Nullable
    public final g k;

    public a(String str, int i2, o oVar, SocketFactory socketFactory, @Nullable SSLSocketFactory sSLSocketFactory, @Nullable HostnameVerifier hostnameVerifier, @Nullable g gVar, b bVar, @Nullable Proxy proxy, List<w> list, List<k> list2, ProxySelector proxySelector) {
        s.a aVar = new s.a();
        aVar.f(sSLSocketFactory != null ? "https" : "http");
        aVar.b(str);
        aVar.a(i2);
        this.f11336a = aVar.a();
        if (oVar == null) {
            throw new NullPointerException("dns == null");
        }
        this.f11337b = oVar;
        if (socketFactory == null) {
            throw new NullPointerException("socketFactory == null");
        }
        this.f11338c = socketFactory;
        if (bVar == null) {
            throw new NullPointerException("proxyAuthenticator == null");
        }
        this.f11339d = bVar;
        if (list == null) {
            throw new NullPointerException("protocols == null");
        }
        this.f11340e = h.e0.c.a(list);
        if (list2 == null) {
            throw new NullPointerException("connectionSpecs == null");
        }
        this.f11341f = h.e0.c.a(list2);
        if (proxySelector == null) {
            throw new NullPointerException("proxySelector == null");
        }
        this.f11342g = proxySelector;
        this.f11343h = proxy;
        this.f11344i = sSLSocketFactory;
        this.j = hostnameVerifier;
        this.k = gVar;
    }

    @Nullable
    public g a() {
        return this.k;
    }

    public List<k> b() {
        return this.f11341f;
    }

    public o c() {
        return this.f11337b;
    }

    @Nullable
    public HostnameVerifier d() {
        return this.j;
    }

    public List<w> e() {
        return this.f11340e;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.f11336a.equals(aVar.f11336a) && a(aVar)) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public Proxy f() {
        return this.f11343h;
    }

    public b g() {
        return this.f11339d;
    }

    public ProxySelector h() {
        return this.f11342g;
    }

    public int hashCode() {
        int hashCode = (((((((((((527 + this.f11336a.hashCode()) * 31) + this.f11337b.hashCode()) * 31) + this.f11339d.hashCode()) * 31) + this.f11340e.hashCode()) * 31) + this.f11341f.hashCode()) * 31) + this.f11342g.hashCode()) * 31;
        Proxy proxy = this.f11343h;
        int hashCode2 = (hashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.f11344i;
        int hashCode3 = (hashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.j;
        int hashCode4 = (hashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        g gVar = this.k;
        return hashCode4 + (gVar != null ? gVar.hashCode() : 0);
    }

    public SocketFactory i() {
        return this.f11338c;
    }

    @Nullable
    public SSLSocketFactory j() {
        return this.f11344i;
    }

    public s k() {
        return this.f11336a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Address{");
        sb.append(this.f11336a.g());
        sb.append(":");
        sb.append(this.f11336a.j());
        if (this.f11343h != null) {
            sb.append(", proxy=");
            sb.append(this.f11343h);
        } else {
            sb.append(", proxySelector=");
            sb.append(this.f11342g);
        }
        sb.append("}");
        return sb.toString();
    }

    public boolean a(a aVar) {
        return this.f11337b.equals(aVar.f11337b) && this.f11339d.equals(aVar.f11339d) && this.f11340e.equals(aVar.f11340e) && this.f11341f.equals(aVar.f11341f) && this.f11342g.equals(aVar.f11342g) && h.e0.c.a(this.f11343h, aVar.f11343h) && h.e0.c.a(this.f11344i, aVar.f11344i) && h.e0.c.a(this.j, aVar.j) && h.e0.c.a(this.k, aVar.k) && k().j() == aVar.k().j();
    }
}
