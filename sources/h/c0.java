package h;

import java.net.InetSocketAddress;
import java.net.Proxy;
import javax.annotation.Nullable;

/* compiled from: Route.java */
/* loaded from: classes.dex */
public final class c0 {

    /* renamed from: a, reason: collision with root package name */
    public final a f11372a;

    /* renamed from: b, reason: collision with root package name */
    public final Proxy f11373b;

    /* renamed from: c, reason: collision with root package name */
    public final InetSocketAddress f11374c;

    public c0(a aVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (aVar == null) {
            throw new NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new NullPointerException("proxy == null");
        }
        if (inetSocketAddress == null) {
            throw new NullPointerException("inetSocketAddress == null");
        }
        this.f11372a = aVar;
        this.f11373b = proxy;
        this.f11374c = inetSocketAddress;
    }

    public a a() {
        return this.f11372a;
    }

    public Proxy b() {
        return this.f11373b;
    }

    public boolean c() {
        return this.f11372a.f11344i != null && this.f11373b.type() == Proxy.Type.HTTP;
    }

    public InetSocketAddress d() {
        return this.f11374c;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof c0) {
            c0 c0Var = (c0) obj;
            if (c0Var.f11372a.equals(this.f11372a) && c0Var.f11373b.equals(this.f11373b) && c0Var.f11374c.equals(this.f11374c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((527 + this.f11372a.hashCode()) * 31) + this.f11373b.hashCode()) * 31) + this.f11374c.hashCode();
    }

    public String toString() {
        return "Route{" + this.f11374c + "}";
    }
}
