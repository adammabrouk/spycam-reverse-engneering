package c.c.a.b.f.e;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public final class h3 {

    /* renamed from: a, reason: collision with root package name */
    public static final Class<?> f4199a = a("libcore.io.Memory");

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f4200b;

    static {
        f4200b = a("org.robolectric.Robolectric") != null;
    }

    public static boolean a() {
        return (f4199a == null || f4200b) ? false : true;
    }

    public static Class<?> b() {
        return f4199a;
    }

    public static <T> Class<T> a(String str) {
        try {
            return (Class<T>) Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
