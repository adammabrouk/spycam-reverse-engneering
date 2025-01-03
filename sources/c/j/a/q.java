package c.j.a;

import c.j.a.m;

/* compiled from: PushClientManager.java */
/* loaded from: classes.dex */
public final class q implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f6633a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m f6634b;

    public q(m mVar, String str) {
        this.f6634b = mVar;
        this.f6633a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        m.a d2;
        d2 = this.f6634b.d(this.f6633a);
        if (d2 != null) {
            d2.a(1003, new Object[0]);
        }
    }
}
