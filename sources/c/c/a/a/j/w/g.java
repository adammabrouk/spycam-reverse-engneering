package c.c.a.a.j.w;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
/* loaded from: classes.dex */
public final class g implements d.a.b<c.c.a.a.j.w.j.g> {

    /* renamed from: a, reason: collision with root package name */
    public final e.a.a<c.c.a.a.j.y.a> f3650a;

    public g(e.a.a<c.c.a.a.j.y.a> aVar) {
        this.f3650a = aVar;
    }

    public static g a(e.a.a<c.c.a.a.j.y.a> aVar) {
        return new g(aVar);
    }

    public static c.c.a.a.j.w.j.g a(c.c.a.a.j.y.a aVar) {
        c.c.a.a.j.w.j.g a2 = f.a(aVar);
        d.a.d.a(a2, "Cannot return null from a non-@Nullable @Provides method");
        return a2;
    }

    @Override // e.a.a
    public c.c.a.a.j.w.j.g get() {
        return a(this.f3650a.get());
    }
}
