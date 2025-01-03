package c.c.a.b.j;

/* loaded from: classes.dex */
public final class s implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f5289a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ r f5290b;

    public s(r rVar, h hVar) {
        this.f5290b = rVar;
        this.f5289a = hVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        c cVar;
        c cVar2;
        obj = this.f5290b.f5287b;
        synchronized (obj) {
            cVar = this.f5290b.f5288c;
            if (cVar != null) {
                cVar2 = this.f5290b.f5288c;
                cVar2.onComplete(this.f5289a);
            }
        }
    }
}
