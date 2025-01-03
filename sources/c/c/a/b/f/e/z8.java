package c.c.a.b.f.e;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class z8 implements w8 {

    /* renamed from: a, reason: collision with root package name */
    public static final a2<Boolean> f4553a;

    /* renamed from: b, reason: collision with root package name */
    public static final a2<Boolean> f4554b;

    static {
        g2 g2Var = new g2(b2.a("com.google.android.gms.measurement"));
        f4553a = g2Var.a("measurement.service.configurable_service_limits", false);
        f4554b = g2Var.a("measurement.client.configurable_service_limits", false);
    }

    @Override // c.c.a.b.f.e.w8
    public final boolean C() {
        return f4554b.b().booleanValue();
    }

    @Override // c.c.a.b.f.e.w8
    public final boolean zza() {
        return true;
    }

    @Override // c.c.a.b.f.e.w8
    public final boolean zzb() {
        return f4553a.b().booleanValue();
    }
}
