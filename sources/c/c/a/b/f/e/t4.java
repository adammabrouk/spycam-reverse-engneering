package c.c.a.b.f.e;

import c.c.a.b.f.e.s4;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public final class t4 implements a6 {

    /* renamed from: a, reason: collision with root package name */
    public static final t4 f4441a = new t4();

    public static t4 a() {
        return f4441a;
    }

    @Override // c.c.a.b.f.e.a6
    public final b6 b(Class<?> cls) {
        if (!s4.class.isAssignableFrom(cls)) {
            String valueOf = String.valueOf(cls.getName());
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Unsupported message type: ".concat(valueOf) : new String("Unsupported message type: "));
        }
        try {
            return (b6) s4.a(cls.asSubclass(s4.class)).a(s4.e.f4421c, (Object) null, (Object) null);
        } catch (Exception e2) {
            String valueOf2 = String.valueOf(cls.getName());
            throw new RuntimeException(valueOf2.length() != 0 ? "Unable to get message info for ".concat(valueOf2) : new String("Unable to get message info for "), e2);
        }
    }

    @Override // c.c.a.b.f.e.a6
    public final boolean a(Class<?> cls) {
        return s4.class.isAssignableFrom(cls);
    }
}
