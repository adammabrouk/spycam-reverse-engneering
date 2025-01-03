package h.e0.f;

import h.a0;
import h.t;
import h.v;
import h.y;
import java.io.IOException;

/* compiled from: ConnectInterceptor.java */
/* loaded from: classes.dex */
public final class a implements t {

    /* renamed from: a, reason: collision with root package name */
    public final v f11422a;

    public a(v vVar) {
        this.f11422a = vVar;
    }

    @Override // h.t
    public a0 intercept(t.a aVar) throws IOException {
        h.e0.g.g gVar = (h.e0.g.g) aVar;
        y a2 = gVar.a();
        g i2 = gVar.i();
        return gVar.a(a2, i2, i2.a(this.f11422a, aVar, !a2.e().equals("GET")), i2.c());
    }
}
