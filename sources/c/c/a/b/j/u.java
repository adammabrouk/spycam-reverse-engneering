package c.c.a.b.j;

/* loaded from: classes.dex */
public final class u implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f5294a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ t f5295b;

    public u(t tVar, h hVar) {
        this.f5295b = tVar;
        this.f5294a = hVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        d dVar;
        d dVar2;
        obj = this.f5295b.f5292b;
        synchronized (obj) {
            dVar = this.f5295b.f5293c;
            if (dVar != null) {
                dVar2 = this.f5295b.f5293c;
                dVar2.a(this.f5294a.a());
            }
        }
    }
}
