package c.c.a.b.f.e;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public final class h4 {

    /* renamed from: a, reason: collision with root package name */
    public static final g4<?> f4201a = new i4();

    /* renamed from: b, reason: collision with root package name */
    public static final g4<?> f4202b = c();

    public static g4<?> a() {
        return f4201a;
    }

    public static g4<?> b() {
        g4<?> g4Var = f4202b;
        if (g4Var != null) {
            return g4Var;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    public static g4<?> c() {
        try {
            return (g4) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
