package c.c.a.a.j.t;

import android.content.Context;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
/* loaded from: classes.dex */
public final class l implements d.a.b<k> {

    /* renamed from: a, reason: collision with root package name */
    public final e.a.a<Context> f3630a;

    /* renamed from: b, reason: collision with root package name */
    public final e.a.a<i> f3631b;

    public l(e.a.a<Context> aVar, e.a.a<i> aVar2) {
        this.f3630a = aVar;
        this.f3631b = aVar2;
    }

    public static l a(e.a.a<Context> aVar, e.a.a<i> aVar2) {
        return new l(aVar, aVar2);
    }

    @Override // e.a.a
    public k get() {
        return new k(this.f3630a.get(), this.f3631b.get());
    }
}
