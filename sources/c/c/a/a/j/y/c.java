package c.c.a.a.j.y;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
/* loaded from: classes.dex */
public final class c implements d.a.b<a> {

    /* renamed from: a, reason: collision with root package name */
    public static final c f3776a = new c();

    public static c a() {
        return f3776a;
    }

    public static a b() {
        a a2 = b.a();
        d.a.d.a(a2, "Cannot return null from a non-@Nullable @Provides method");
        return a2;
    }

    @Override // e.a.a
    public a get() {
        return b();
    }
}
