package c.c.a.b.j;

/* loaded from: classes.dex */
public final class q implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f5285a;

    public q(p pVar) {
        this.f5285a = pVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        b bVar;
        b bVar2;
        obj = this.f5285a.f5283b;
        synchronized (obj) {
            bVar = this.f5285a.f5284c;
            if (bVar != null) {
                bVar2 = this.f5285a.f5284c;
                bVar2.a();
            }
        }
    }
}
