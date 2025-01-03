package c.c.a.b.f.e;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class ka implements la {

    /* renamed from: a, reason: collision with root package name */
    public static final a2<Boolean> f4260a;

    /* renamed from: b, reason: collision with root package name */
    public static final a2<Boolean> f4261b;

    static {
        g2 g2Var = new g2(b2.a("com.google.android.gms.measurement"));
        f4260a = g2Var.a("measurement.collection.efficient_engagement_reporting_enabled_2", true);
        f4261b = g2Var.a("measurement.collection.redundant_engagement_removal_enabled", false);
        g2Var.a("measurement.id.collection.redundant_engagement_removal_enabled", 0L);
    }

    @Override // c.c.a.b.f.e.la
    public final boolean zza() {
        return f4260a.b().booleanValue();
    }

    @Override // c.c.a.b.f.e.la
    public final boolean zzb() {
        return f4261b.b().booleanValue();
    }
}
