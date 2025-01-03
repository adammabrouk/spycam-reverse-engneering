package h.e0.f;

import h.c0;
import h.p;
import h.s;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/* compiled from: RouteSelector.java */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final h.a f11436a;

    /* renamed from: b, reason: collision with root package name */
    public final d f11437b;

    /* renamed from: c, reason: collision with root package name */
    public final h.e f11438c;

    /* renamed from: d, reason: collision with root package name */
    public final p f11439d;

    /* renamed from: f, reason: collision with root package name */
    public int f11441f;

    /* renamed from: e, reason: collision with root package name */
    public List<Proxy> f11440e = Collections.emptyList();

    /* renamed from: g, reason: collision with root package name */
    public List<InetSocketAddress> f11442g = Collections.emptyList();

    /* renamed from: h, reason: collision with root package name */
    public final List<c0> f11443h = new ArrayList();

    /* compiled from: RouteSelector.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final List<c0> f11444a;

        /* renamed from: b, reason: collision with root package name */
        public int f11445b = 0;

        public a(List<c0> list) {
            this.f11444a = list;
        }

        public List<c0> a() {
            return new ArrayList(this.f11444a);
        }

        public boolean b() {
            return this.f11445b < this.f11444a.size();
        }

        public c0 c() {
            if (!b()) {
                throw new NoSuchElementException();
            }
            List<c0> list = this.f11444a;
            int i2 = this.f11445b;
            this.f11445b = i2 + 1;
            return list.get(i2);
        }
    }

    public f(h.a aVar, d dVar, h.e eVar, p pVar) {
        this.f11436a = aVar;
        this.f11437b = dVar;
        this.f11438c = eVar;
        this.f11439d = pVar;
        a(aVar.k(), aVar.f());
    }

    public boolean a() {
        return b() || !this.f11443h.isEmpty();
    }

    public final boolean b() {
        return this.f11441f < this.f11440e.size();
    }

    public a c() throws IOException {
        if (!a()) {
            throw new NoSuchElementException();
        }
        ArrayList arrayList = new ArrayList();
        while (b()) {
            Proxy d2 = d();
            int size = this.f11442g.size();
            for (int i2 = 0; i2 < size; i2++) {
                c0 c0Var = new c0(this.f11436a, d2, this.f11442g.get(i2));
                if (this.f11437b.c(c0Var)) {
                    this.f11443h.add(c0Var);
                } else {
                    arrayList.add(c0Var);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.addAll(this.f11443h);
            this.f11443h.clear();
        }
        return new a(arrayList);
    }

    public final Proxy d() throws IOException {
        if (b()) {
            List<Proxy> list = this.f11440e;
            int i2 = this.f11441f;
            this.f11441f = i2 + 1;
            Proxy proxy = list.get(i2);
            a(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f11436a.k().g() + "; exhausted proxy configurations: " + this.f11440e);
    }

    public void a(c0 c0Var, IOException iOException) {
        if (c0Var.b().type() != Proxy.Type.DIRECT && this.f11436a.h() != null) {
            this.f11436a.h().connectFailed(this.f11436a.k().n(), c0Var.b().address(), iOException);
        }
        this.f11437b.b(c0Var);
    }

    public final void a(s sVar, Proxy proxy) {
        if (proxy != null) {
            this.f11440e = Collections.singletonList(proxy);
        } else {
            List<Proxy> select = this.f11436a.h().select(sVar.n());
            this.f11440e = (select == null || select.isEmpty()) ? h.e0.c.a(Proxy.NO_PROXY) : h.e0.c.a(select);
        }
        this.f11441f = 0;
    }

    public final void a(Proxy proxy) throws IOException {
        String g2;
        int j;
        this.f11442g = new ArrayList();
        if (proxy.type() != Proxy.Type.DIRECT && proxy.type() != Proxy.Type.SOCKS) {
            SocketAddress address = proxy.address();
            if (address instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                g2 = a(inetSocketAddress);
                j = inetSocketAddress.getPort();
            } else {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
            }
        } else {
            g2 = this.f11436a.k().g();
            j = this.f11436a.k().j();
        }
        if (j >= 1 && j <= 65535) {
            if (proxy.type() == Proxy.Type.SOCKS) {
                this.f11442g.add(InetSocketAddress.createUnresolved(g2, j));
                return;
            }
            this.f11439d.a(this.f11438c, g2);
            List<InetAddress> a2 = this.f11436a.c().a(g2);
            if (!a2.isEmpty()) {
                this.f11439d.a(this.f11438c, g2, a2);
                int size = a2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.f11442g.add(new InetSocketAddress(a2.get(i2), j));
                }
                return;
            }
            throw new UnknownHostException(this.f11436a.c() + " returned no addresses for " + g2);
        }
        throw new SocketException("No route to " + g2 + ":" + j + "; port is out of range");
    }

    public static String a(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        if (address == null) {
            return inetSocketAddress.getHostName();
        }
        return address.getHostAddress();
    }
}
