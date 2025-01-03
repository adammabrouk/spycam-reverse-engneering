package c.a.a.p;

/* compiled from: ThumbnailRequestCoordinator.java */
/* loaded from: classes.dex */
public class f implements c, b {

    /* renamed from: a, reason: collision with root package name */
    public b f3412a;

    /* renamed from: b, reason: collision with root package name */
    public b f3413b;

    /* renamed from: c, reason: collision with root package name */
    public c f3414c;

    public f(c cVar) {
        this.f3414c = cVar;
    }

    public void a(b bVar, b bVar2) {
        this.f3412a = bVar;
        this.f3413b = bVar2;
    }

    @Override // c.a.a.p.c
    public boolean b(b bVar) {
        return h() && (bVar.equals(this.f3412a) || !this.f3412a.e());
    }

    @Override // c.a.a.p.c
    public void c(b bVar) {
        if (bVar.equals(this.f3413b)) {
            return;
        }
        c cVar = this.f3414c;
        if (cVar != null) {
            cVar.c(this);
        }
        if (this.f3413b.f()) {
            return;
        }
        this.f3413b.clear();
    }

    @Override // c.a.a.p.b
    public void clear() {
        this.f3413b.clear();
        this.f3412a.clear();
    }

    @Override // c.a.a.p.b
    public void d() {
        if (!this.f3413b.isRunning()) {
            this.f3413b.d();
        }
        if (this.f3412a.isRunning()) {
            return;
        }
        this.f3412a.d();
    }

    @Override // c.a.a.p.b
    public boolean e() {
        return this.f3412a.e() || this.f3413b.e();
    }

    @Override // c.a.a.p.b
    public boolean f() {
        return this.f3412a.f() || this.f3413b.f();
    }

    public final boolean g() {
        c cVar = this.f3414c;
        return cVar == null || cVar.a(this);
    }

    public final boolean h() {
        c cVar = this.f3414c;
        return cVar == null || cVar.b(this);
    }

    public final boolean i() {
        c cVar = this.f3414c;
        return cVar != null && cVar.b();
    }

    @Override // c.a.a.p.b
    public boolean isCancelled() {
        return this.f3412a.isCancelled();
    }

    @Override // c.a.a.p.b
    public boolean isRunning() {
        return this.f3412a.isRunning();
    }

    @Override // c.a.a.p.c
    public boolean b() {
        return i() || e();
    }

    @Override // c.a.a.p.c
    public boolean a(b bVar) {
        return g() && bVar.equals(this.f3412a) && !b();
    }

    @Override // c.a.a.p.b
    public void a() {
        this.f3412a.a();
        this.f3413b.a();
    }

    @Override // c.a.a.p.b
    public void c() {
        this.f3412a.c();
        this.f3413b.c();
    }
}
