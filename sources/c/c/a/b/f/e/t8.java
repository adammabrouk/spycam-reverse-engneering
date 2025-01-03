package c.c.a.b.f.e;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class t8 implements q8 {

    /* renamed from: a, reason: collision with root package name */
    public static final a2<Boolean> f4443a;

    /* renamed from: b, reason: collision with root package name */
    public static final a2<Long> f4444b;

    static {
        g2 g2Var = new g2(b2.a("com.google.android.gms.measurement"));
        f4443a = g2Var.a("measurement.sdk.attribution.cache", true);
        f4444b = g2Var.a("measurement.sdk.attribution.cache.ttl", 604800000L);
    }

    @Override // c.c.a.b.f.e.q8
    public final boolean zza() {
        return f4443a.b().booleanValue();
    }

    @Override // c.c.a.b.f.e.q8
    public final long zzb() {
        return f4444b.b().longValue();
    }
}
