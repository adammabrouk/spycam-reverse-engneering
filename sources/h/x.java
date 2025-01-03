package h;

import java.io.IOException;
import java.util.ArrayList;

/* compiled from: RealCall.java */
/* loaded from: classes.dex */
public final class x implements e {

    /* renamed from: a, reason: collision with root package name */
    public final v f11780a;

    /* renamed from: b, reason: collision with root package name */
    public final h.e0.g.j f11781b;

    /* renamed from: c, reason: collision with root package name */
    public p f11782c;

    /* renamed from: d, reason: collision with root package name */
    public final y f11783d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f11784e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f11785f;

    /* compiled from: RealCall.java */
    public final class a extends h.e0.b {

        /* renamed from: b, reason: collision with root package name */
        public final f f11786b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ x f11787c;

        @Override // h.e0.b
        public void b() {
            IOException e2;
            boolean z = true;
            try {
                try {
                    a0 b2 = this.f11787c.b();
                    try {
                        if (this.f11787c.f11781b.b()) {
                            this.f11786b.a(this.f11787c, new IOException("Canceled"));
                        } else {
                            this.f11786b.a(this.f11787c, b2);
                        }
                    } catch (IOException e3) {
                        e2 = e3;
                        if (z) {
                            h.e0.j.f.c().a(4, "Callback failure for " + this.f11787c.d(), e2);
                        } else {
                            this.f11787c.f11782c.a(this.f11787c, e2);
                            this.f11786b.a(this.f11787c, e2);
                        }
                    }
                } finally {
                    this.f11787c.f11780a.g().a(this);
                }
            } catch (IOException e4) {
                e2 = e4;
                z = false;
            }
        }

        public x c() {
            return this.f11787c;
        }

        public String d() {
            return this.f11787c.f11783d.g().g();
        }
    }

    public x(v vVar, y yVar, boolean z) {
        this.f11780a = vVar;
        this.f11783d = yVar;
        this.f11784e = z;
        this.f11781b = new h.e0.g.j(vVar, z);
    }

    @Override // h.e
    public a0 G() throws IOException {
        synchronized (this) {
            if (this.f11785f) {
                throw new IllegalStateException("Already Executed");
            }
            this.f11785f = true;
        }
        a();
        this.f11782c.b(this);
        try {
            try {
                this.f11780a.g().a(this);
                a0 b2 = b();
                if (b2 != null) {
                    return b2;
                }
                throw new IOException("Canceled");
            } catch (IOException e2) {
                this.f11782c.a(this, e2);
                throw e2;
            }
        } finally {
            this.f11780a.g().b(this);
        }
    }

    @Override // h.e
    public boolean I() {
        return this.f11781b.b();
    }

    public a0 b() throws IOException {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f11780a.m());
        arrayList.add(this.f11781b);
        arrayList.add(new h.e0.g.a(this.f11780a.f()));
        arrayList.add(new h.e0.e.a(this.f11780a.n()));
        arrayList.add(new h.e0.f.a(this.f11780a));
        if (!this.f11784e) {
            arrayList.addAll(this.f11780a.o());
        }
        arrayList.add(new h.e0.g.b(this.f11784e));
        return new h.e0.g.g(arrayList, null, null, null, 0, this.f11783d, this, this.f11782c, this.f11780a.c(), this.f11780a.v(), this.f11780a.z()).a(this.f11783d);
    }

    public String c() {
        return this.f11783d.g().l();
    }

    @Override // h.e
    public void cancel() {
        this.f11781b.a();
    }

    public String d() {
        StringBuilder sb = new StringBuilder();
        sb.append(I() ? "canceled " : "");
        sb.append(this.f11784e ? "web socket" : "call");
        sb.append(" to ");
        sb.append(c());
        return sb.toString();
    }

    public static x a(v vVar, y yVar, boolean z) {
        x xVar = new x(vVar, yVar, z);
        xVar.f11782c = vVar.i().a(xVar);
        return xVar;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public x m602clone() {
        return a(this.f11780a, this.f11783d, this.f11784e);
    }

    public final void a() {
        this.f11781b.a(h.e0.j.f.c().a("response.body().close()"));
    }
}
