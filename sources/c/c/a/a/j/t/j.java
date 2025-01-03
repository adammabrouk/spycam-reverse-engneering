package c.c.a.a.j.t;

import android.content.Context;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
/* loaded from: classes.dex */
public final class j implements d.a.b<i> {

    /* renamed from: a, reason: collision with root package name */
    public final e.a.a<Context> f3622a;

    /* renamed from: b, reason: collision with root package name */
    public final e.a.a<c.c.a.a.j.y.a> f3623b;

    /* renamed from: c, reason: collision with root package name */
    public final e.a.a<c.c.a.a.j.y.a> f3624c;

    public j(e.a.a<Context> aVar, e.a.a<c.c.a.a.j.y.a> aVar2, e.a.a<c.c.a.a.j.y.a> aVar3) {
        this.f3622a = aVar;
        this.f3623b = aVar2;
        this.f3624c = aVar3;
    }

    public static j a(e.a.a<Context> aVar, e.a.a<c.c.a.a.j.y.a> aVar2, e.a.a<c.c.a.a.j.y.a> aVar3) {
        return new j(aVar, aVar2, aVar3);
    }

    @Override // e.a.a
    public i get() {
        return new i(this.f3622a.get(), this.f3623b.get(), this.f3624c.get());
    }
}
