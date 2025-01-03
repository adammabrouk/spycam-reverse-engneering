package c.c.a.a.j.w;

import android.content.Context;
import c.c.a.a.j.w.j.s;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
/* loaded from: classes.dex */
public final class i implements d.a.b<s> {

    /* renamed from: a, reason: collision with root package name */
    public final e.a.a<Context> f3651a;

    /* renamed from: b, reason: collision with root package name */
    public final e.a.a<c.c.a.a.j.w.k.c> f3652b;

    /* renamed from: c, reason: collision with root package name */
    public final e.a.a<c.c.a.a.j.w.j.g> f3653c;

    /* renamed from: d, reason: collision with root package name */
    public final e.a.a<c.c.a.a.j.y.a> f3654d;

    public i(e.a.a<Context> aVar, e.a.a<c.c.a.a.j.w.k.c> aVar2, e.a.a<c.c.a.a.j.w.j.g> aVar3, e.a.a<c.c.a.a.j.y.a> aVar4) {
        this.f3651a = aVar;
        this.f3652b = aVar2;
        this.f3653c = aVar3;
        this.f3654d = aVar4;
    }

    public static i a(e.a.a<Context> aVar, e.a.a<c.c.a.a.j.w.k.c> aVar2, e.a.a<c.c.a.a.j.w.j.g> aVar3, e.a.a<c.c.a.a.j.y.a> aVar4) {
        return new i(aVar, aVar2, aVar3, aVar4);
    }

    public static s a(Context context, c.c.a.a.j.w.k.c cVar, c.c.a.a.j.w.j.g gVar, c.c.a.a.j.y.a aVar) {
        s a2 = h.a(context, cVar, gVar, aVar);
        d.a.d.a(a2, "Cannot return null from a non-@Nullable @Provides method");
        return a2;
    }

    @Override // e.a.a
    public s get() {
        return a(this.f3651a.get(), this.f3652b.get(), this.f3653c.get(), this.f3654d.get());
    }
}
