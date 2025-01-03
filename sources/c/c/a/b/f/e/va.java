package c.c.a.b.f.e;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class va implements sa {

    /* renamed from: a, reason: collision with root package name */
    public static final a2<Boolean> f4494a;

    /* renamed from: b, reason: collision with root package name */
    public static final a2<Boolean> f4495b;

    static {
        g2 g2Var = new g2(b2.a("com.google.android.gms.measurement"));
        f4494a = g2Var.a("measurement.client.global_params.dev", false);
        f4495b = g2Var.a("measurement.service.global_params", false);
    }

    @Override // c.c.a.b.f.e.sa
    public final boolean C() {
        return f4495b.b().booleanValue();
    }

    @Override // c.c.a.b.f.e.sa
    public final boolean zza() {
        return true;
    }

    @Override // c.c.a.b.f.e.sa
    public final boolean zzb() {
        return f4494a.b().booleanValue();
    }
}
