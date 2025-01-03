package c.j.a;

import c.j.a.m;
import c.j.a.z.h;

/* compiled from: PushClientManager.java */
/* loaded from: classes.dex */
public final class o implements a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m.a f6628a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m f6629b;

    public o(m mVar, m.a aVar) {
        this.f6629b = mVar;
        this.f6628a = aVar;
    }

    @Override // c.j.a.a
    public final void onStateChanged(int i2) {
        h hVar;
        if (i2 != 0) {
            this.f6629b.f6617g = null;
            hVar = this.f6629b.f6616f;
            hVar.b("APP_TOKEN");
        } else {
            Object[] b2 = this.f6628a.b();
            if (b2 == null || b2.length == 0) {
                c.j.a.z.v.a("PushClientManager", "bind app result is null");
            } else {
                this.f6629b.a((String) this.f6628a.b()[0]);
            }
        }
    }
}
