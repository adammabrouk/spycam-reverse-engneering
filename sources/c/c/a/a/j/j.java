package c.c.a.a.j;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
/* loaded from: classes.dex */
public final class j implements d.a.b<Executor> {

    /* renamed from: a, reason: collision with root package name */
    public static final j f3588a = new j();

    public static j a() {
        return f3588a;
    }

    public static Executor b() {
        Executor a2 = i.a();
        d.a.d.a(a2, "Cannot return null from a non-@Nullable @Provides method");
        return a2;
    }

    @Override // e.a.a
    public Executor get() {
        return b();
    }
}
