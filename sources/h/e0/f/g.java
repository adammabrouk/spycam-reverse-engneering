package h.e0.f;

import h.c0;
import h.e0.f.f;
import h.e0.i.n;
import h.j;
import h.p;
import h.t;
import h.v;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;

/* compiled from: StreamAllocation.java */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final h.a f11446a;

    /* renamed from: b, reason: collision with root package name */
    public f.a f11447b;

    /* renamed from: c, reason: collision with root package name */
    public c0 f11448c;

    /* renamed from: d, reason: collision with root package name */
    public final j f11449d;

    /* renamed from: e, reason: collision with root package name */
    public final h.e f11450e;

    /* renamed from: f, reason: collision with root package name */
    public final p f11451f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f11452g;

    /* renamed from: h, reason: collision with root package name */
    public final f f11453h;

    /* renamed from: i, reason: collision with root package name */
    public int f11454i;
    public c j;
    public boolean k;
    public boolean l;
    public boolean m;
    public h.e0.g.c n;

    /* compiled from: StreamAllocation.java */
    public static final class a extends WeakReference<g> {

        /* renamed from: a, reason: collision with root package name */
        public final Object f11455a;

        public a(g gVar, Object obj) {
            super(gVar);
            this.f11455a = obj;
        }
    }

    public g(j jVar, h.a aVar, h.e eVar, p pVar, Object obj) {
        this.f11449d = jVar;
        this.f11446a = aVar;
        this.f11450e = eVar;
        this.f11451f = pVar;
        this.f11453h = new f(aVar, i(), eVar, pVar);
        this.f11452g = obj;
    }

    public h.e0.g.c a(v vVar, t.a aVar, boolean z) {
        try {
            h.e0.g.c a2 = a(aVar.b(), aVar.c(), aVar.d(), vVar.q(), vVar.w(), z).a(vVar, aVar, this);
            synchronized (this.f11449d) {
                this.n = a2;
            }
            return a2;
        } catch (IOException e2) {
            throw new e(e2);
        }
    }

    public h.e0.g.c b() {
        h.e0.g.c cVar;
        synchronized (this.f11449d) {
            cVar = this.n;
        }
        return cVar;
    }

    public synchronized c c() {
        return this.j;
    }

    public boolean d() {
        f.a aVar;
        return this.f11448c != null || ((aVar = this.f11447b) != null && aVar.b()) || this.f11453h.a();
    }

    public void e() {
        c cVar;
        Socket a2;
        synchronized (this.f11449d) {
            cVar = this.j;
            a2 = a(true, false, false);
            if (this.j != null) {
                cVar = null;
            }
        }
        h.e0.c.a(a2);
        if (cVar != null) {
            this.f11451f.b(this.f11450e, cVar);
        }
    }

    public void f() {
        c cVar;
        Socket a2;
        synchronized (this.f11449d) {
            cVar = this.j;
            a2 = a(false, true, false);
            if (this.j != null) {
                cVar = null;
            }
        }
        h.e0.c.a(a2);
        if (cVar != null) {
            this.f11451f.b(this.f11450e, cVar);
            this.f11451f.a(this.f11450e);
        }
    }

    public final Socket g() {
        c cVar = this.j;
        if (cVar == null || !cVar.k) {
            return null;
        }
        return a(false, false, true);
    }

    public c0 h() {
        return this.f11448c;
    }

    public final d i() {
        return h.e0.a.f11393a.a(this.f11449d);
    }

    public String toString() {
        c c2 = c();
        return c2 != null ? c2.toString() : this.f11446a.toString();
    }

    public Socket b(c cVar) {
        if (this.n == null && this.j.n.size() == 1) {
            Reference<g> reference = this.j.n.get(0);
            Socket a2 = a(true, false, false);
            this.j = cVar;
            cVar.n.add(reference);
            return a2;
        }
        throw new IllegalStateException();
    }

    public final c a(int i2, int i3, int i4, int i5, boolean z, boolean z2) throws IOException {
        while (true) {
            c a2 = a(i2, i3, i4, i5, z);
            synchronized (this.f11449d) {
                if (a2.l == 0) {
                    return a2;
                }
                if (a2.a(z2)) {
                    return a2;
                }
                e();
            }
        }
    }

    public final c a(int i2, int i3, int i4, int i5, boolean z) throws IOException {
        Socket g2;
        Socket socket;
        c cVar;
        c cVar2;
        c0 c0Var;
        boolean z2;
        boolean z3;
        f.a aVar;
        synchronized (this.f11449d) {
            if (!this.l) {
                if (this.n == null) {
                    if (!this.m) {
                        c cVar3 = this.j;
                        g2 = g();
                        socket = null;
                        if (this.j != null) {
                            cVar2 = this.j;
                            cVar = null;
                        } else {
                            cVar = cVar3;
                            cVar2 = null;
                        }
                        if (!this.k) {
                            cVar = null;
                        }
                        if (cVar2 == null) {
                            h.e0.a.f11393a.a(this.f11449d, this.f11446a, this, null);
                            if (this.j != null) {
                                cVar2 = this.j;
                                c0Var = null;
                                z2 = true;
                            } else {
                                c0Var = this.f11448c;
                            }
                        } else {
                            c0Var = null;
                        }
                        z2 = false;
                    } else {
                        throw new IOException("Canceled");
                    }
                } else {
                    throw new IllegalStateException("codec != null");
                }
            } else {
                throw new IllegalStateException("released");
            }
        }
        h.e0.c.a(g2);
        if (cVar != null) {
            this.f11451f.b(this.f11450e, cVar);
        }
        if (z2) {
            this.f11451f.a(this.f11450e, cVar2);
        }
        if (cVar2 != null) {
            return cVar2;
        }
        if (c0Var != null || ((aVar = this.f11447b) != null && aVar.b())) {
            z3 = false;
        } else {
            this.f11447b = this.f11453h.c();
            z3 = true;
        }
        synchronized (this.f11449d) {
            if (this.m) {
                throw new IOException("Canceled");
            }
            if (z3) {
                List<c0> a2 = this.f11447b.a();
                int size = a2.size();
                int i6 = 0;
                while (true) {
                    if (i6 >= size) {
                        break;
                    }
                    c0 c0Var2 = a2.get(i6);
                    h.e0.a.f11393a.a(this.f11449d, this.f11446a, this, c0Var2);
                    if (this.j != null) {
                        cVar2 = this.j;
                        this.f11448c = c0Var2;
                        z2 = true;
                        break;
                    }
                    i6++;
                }
            }
            if (!z2) {
                if (c0Var == null) {
                    c0Var = this.f11447b.c();
                }
                this.f11448c = c0Var;
                this.f11454i = 0;
                cVar2 = new c(this.f11449d, c0Var);
                a(cVar2, false);
            }
        }
        if (z2) {
            this.f11451f.a(this.f11450e, cVar2);
            return cVar2;
        }
        cVar2.a(i2, i3, i4, i5, z, this.f11450e, this.f11451f);
        i().a(cVar2.e());
        synchronized (this.f11449d) {
            this.k = true;
            h.e0.a.f11393a.b(this.f11449d, cVar2);
            if (cVar2.d()) {
                socket = h.e0.a.f11393a.a(this.f11449d, this.f11446a, this);
                cVar2 = this.j;
            }
        }
        h.e0.c.a(socket);
        this.f11451f.a(this.f11450e, cVar2);
        return cVar2;
    }

    public void a(boolean z, h.e0.g.c cVar, long j, IOException iOException) {
        c cVar2;
        Socket a2;
        boolean z2;
        this.f11451f.b(this.f11450e, j);
        synchronized (this.f11449d) {
            if (cVar != null) {
                if (cVar == this.n) {
                    if (!z) {
                        this.j.l++;
                    }
                    cVar2 = this.j;
                    a2 = a(z, false, true);
                    if (this.j != null) {
                        cVar2 = null;
                    }
                    z2 = this.l;
                }
            }
            throw new IllegalStateException("expected " + this.n + " but was " + cVar);
        }
        h.e0.c.a(a2);
        if (cVar2 != null) {
            this.f11451f.b(this.f11450e, cVar2);
        }
        if (iOException != null) {
            this.f11451f.a(this.f11450e, iOException);
        } else if (z2) {
            this.f11451f.a(this.f11450e);
        }
    }

    public final Socket a(boolean z, boolean z2, boolean z3) {
        Socket socket;
        if (z3) {
            this.n = null;
        }
        if (z2) {
            this.l = true;
        }
        c cVar = this.j;
        if (cVar == null) {
            return null;
        }
        if (z) {
            cVar.k = true;
        }
        if (this.n != null) {
            return null;
        }
        if (!this.l && !this.j.k) {
            return null;
        }
        a(this.j);
        if (this.j.n.isEmpty()) {
            this.j.o = System.nanoTime();
            if (h.e0.a.f11393a.a(this.f11449d, this.j)) {
                socket = this.j.f();
                this.j = null;
                return socket;
            }
        }
        socket = null;
        this.j = null;
        return socket;
    }

    public void a() {
        h.e0.g.c cVar;
        c cVar2;
        synchronized (this.f11449d) {
            this.m = true;
            cVar = this.n;
            cVar2 = this.j;
        }
        if (cVar != null) {
            cVar.cancel();
        } else if (cVar2 != null) {
            cVar2.a();
        }
    }

    public void a(IOException iOException) {
        c cVar;
        boolean z;
        Socket a2;
        synchronized (this.f11449d) {
            cVar = null;
            if (iOException instanceof n) {
                h.e0.i.b bVar = ((n) iOException).errorCode;
                if (bVar == h.e0.i.b.REFUSED_STREAM) {
                    int i2 = this.f11454i + 1;
                    this.f11454i = i2;
                    if (i2 > 1) {
                        this.f11448c = null;
                        z = true;
                    }
                    z = false;
                } else {
                    if (bVar != h.e0.i.b.CANCEL) {
                        this.f11448c = null;
                        z = true;
                    }
                    z = false;
                }
            } else {
                if (this.j != null && (!this.j.d() || (iOException instanceof h.e0.i.a))) {
                    if (this.j.l == 0) {
                        if (this.f11448c != null && iOException != null) {
                            this.f11453h.a(this.f11448c, iOException);
                        }
                        this.f11448c = null;
                    }
                    z = true;
                }
                z = false;
            }
            c cVar2 = this.j;
            a2 = a(z, false, true);
            if (this.j == null && this.k) {
                cVar = cVar2;
            }
        }
        h.e0.c.a(a2);
        if (cVar != null) {
            this.f11451f.b(this.f11450e, cVar);
        }
    }

    public void a(c cVar, boolean z) {
        if (this.j == null) {
            this.j = cVar;
            this.k = z;
            cVar.n.add(new a(this, this.f11452g));
            return;
        }
        throw new IllegalStateException();
    }

    public final void a(c cVar) {
        int size = cVar.n.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (cVar.n.get(i2).get() == this) {
                cVar.n.remove(i2);
                return;
            }
        }
        throw new IllegalStateException();
    }
}
