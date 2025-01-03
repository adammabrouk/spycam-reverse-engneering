package c.c.a.a.j.w.k;

import android.content.Context;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
/* loaded from: classes.dex */
public final class f0 implements d.a.b<e0> {

    /* renamed from: a, reason: collision with root package name */
    public final e.a.a<Context> f3743a;

    /* renamed from: b, reason: collision with root package name */
    public final e.a.a<Integer> f3744b;

    public f0(e.a.a<Context> aVar, e.a.a<Integer> aVar2) {
        this.f3743a = aVar;
        this.f3744b = aVar2;
    }

    public static f0 a(e.a.a<Context> aVar, e.a.a<Integer> aVar2) {
        return new f0(aVar, aVar2);
    }

    @Override // e.a.a
    public e0 get() {
        return new e0(this.f3743a.get(), this.f3744b.get().intValue());
    }
}
