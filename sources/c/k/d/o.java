package c.k.d;

import c.k.d.m;

/* loaded from: classes.dex */
public class o implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m.b f7440a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m f7441b;

    public o(m mVar, m.b bVar) {
        this.f7441b = mVar;
        this.f7440a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f7441b.a(this.f7440a);
    }
}
