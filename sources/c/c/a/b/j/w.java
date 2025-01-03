package c.c.a.b.j;

/* loaded from: classes.dex */
public final class w implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f5299a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ v f5300b;

    public w(v vVar, h hVar) {
        this.f5300b = vVar;
        this.f5299a = hVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        e eVar;
        e eVar2;
        obj = this.f5300b.f5297b;
        synchronized (obj) {
            eVar = this.f5300b.f5298c;
            if (eVar != null) {
                eVar2 = this.f5300b.f5298c;
                eVar2.a(this.f5299a.b());
            }
        }
    }
}
