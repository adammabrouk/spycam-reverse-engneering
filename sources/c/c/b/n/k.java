package c.c.b.n;

import c.c.b.n.m;

/* compiled from: com.google.firebase:firebase-installations@@16.3.0 */
/* loaded from: classes.dex */
public class k implements o {

    /* renamed from: a, reason: collision with root package name */
    public final p f6054a;

    /* renamed from: b, reason: collision with root package name */
    public final c.c.a.b.j.i<m> f6055b;

    public k(p pVar, c.c.a.b.j.i<m> iVar) {
        this.f6054a = pVar;
        this.f6055b = iVar;
    }

    @Override // c.c.b.n.o
    public boolean a(c.c.b.n.q.d dVar) {
        if (!dVar.j() || this.f6054a.a(dVar)) {
            return false;
        }
        c.c.a.b.j.i<m> iVar = this.f6055b;
        m.a d2 = m.d();
        d2.a(dVar.a());
        d2.b(dVar.b());
        d2.a(dVar.g());
        iVar.a((c.c.a.b.j.i<m>) d2.a());
        return true;
    }

    @Override // c.c.b.n.o
    public boolean a(c.c.b.n.q.d dVar, Exception exc) {
        if (!dVar.h() && !dVar.i() && !dVar.k()) {
            return false;
        }
        this.f6055b.b(exc);
        return true;
    }
}
