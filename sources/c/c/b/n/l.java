package c.c.b.n;

/* compiled from: com.google.firebase:firebase-installations@@16.3.0 */
/* loaded from: classes.dex */
public class l implements o {

    /* renamed from: a, reason: collision with root package name */
    public final c.c.a.b.j.i<String> f6056a;

    public l(c.c.a.b.j.i<String> iVar) {
        this.f6056a = iVar;
    }

    @Override // c.c.b.n.o
    public boolean a(c.c.b.n.q.d dVar) {
        if (!dVar.k() && !dVar.j() && !dVar.h()) {
            return false;
        }
        this.f6056a.b((c.c.a.b.j.i<String>) dVar.c());
        return true;
    }

    @Override // c.c.b.n.o
    public boolean a(c.c.b.n.q.d dVar, Exception exc) {
        return false;
    }
}
