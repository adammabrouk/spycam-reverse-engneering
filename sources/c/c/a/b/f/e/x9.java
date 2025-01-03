package c.c.a.b.f.e;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class x9 implements u9 {

    /* renamed from: a, reason: collision with root package name */
    public static final a2<Boolean> f4525a;

    static {
        g2 g2Var = new g2(b2.a("com.google.android.gms.measurement"));
        f4525a = g2Var.a("measurement.sdk.referrer.delayed_install_referrer_api", false);
        g2Var.a("measurement.id.sdk.referrer.delayed_install_referrer_api", 0L);
    }

    @Override // c.c.a.b.f.e.u9
    public final boolean zza() {
        return true;
    }

    @Override // c.c.a.b.f.e.u9
    public final boolean zzb() {
        return f4525a.b().booleanValue();
    }
}
