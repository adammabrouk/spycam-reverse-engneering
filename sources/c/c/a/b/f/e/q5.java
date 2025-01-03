package c.c.a.b.f.e;

import c.c.a.b.f.e.s4;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public final class q5 implements v6 {

    /* renamed from: b, reason: collision with root package name */
    public static final a6 f4372b = new t5();

    /* renamed from: a, reason: collision with root package name */
    public final a6 f4373a;

    public q5() {
        this(new s5(t4.a(), a()));
    }

    @Override // c.c.a.b.f.e.v6
    public final <T> t6<T> a(Class<T> cls) {
        u6.a((Class<?>) cls);
        b6 b2 = this.f4373a.b(cls);
        return b2.zzb() ? s4.class.isAssignableFrom(cls) ? j6.a(u6.c(), h4.a(), b2.C()) : j6.a(u6.a(), h4.b(), b2.C()) : s4.class.isAssignableFrom(cls) ? a(b2) ? h6.a(cls, b2, o6.b(), n5.b(), u6.c(), h4.a(), y5.b()) : h6.a(cls, b2, o6.b(), n5.b(), u6.c(), (g4<?>) null, y5.b()) : a(b2) ? h6.a(cls, b2, o6.a(), n5.a(), u6.a(), h4.b(), y5.a()) : h6.a(cls, b2, o6.a(), n5.a(), u6.b(), (g4<?>) null, y5.a());
    }

    public q5(a6 a6Var) {
        u4.a(a6Var, "messageInfoFactory");
        this.f4373a = a6Var;
    }

    public static boolean a(b6 b6Var) {
        return b6Var.zza() == s4.e.f4427i;
    }

    public static a6 a() {
        try {
            return (a6) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return f4372b;
        }
    }
}
