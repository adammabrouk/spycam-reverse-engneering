package c.c.a.b.f.e;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class bb implements ya {

    /* renamed from: a, reason: collision with root package name */
    public static final a2<Boolean> f4093a;

    /* renamed from: b, reason: collision with root package name */
    public static final a2<Boolean> f4094b;

    /* renamed from: c, reason: collision with root package name */
    public static final a2<Boolean> f4095c;

    /* renamed from: d, reason: collision with root package name */
    public static final a2<Boolean> f4096d;

    static {
        g2 g2Var = new g2(b2.a("com.google.android.gms.measurement"));
        f4093a = g2Var.a("measurement.sdk.collection.enable_extend_user_property_size", true);
        f4094b = g2Var.a("measurement.sdk.collection.last_deep_link_referrer2", true);
        f4095c = g2Var.a("measurement.sdk.collection.last_deep_link_referrer_campaign2", false);
        f4096d = g2Var.a("measurement.sdk.collection.last_gclid_from_referrer2", false);
        g2Var.a("measurement.id.sdk.collection.last_deep_link_referrer2", 0L);
    }

    @Override // c.c.a.b.f.e.ya
    public final boolean C() {
        return f4095c.b().booleanValue();
    }

    @Override // c.c.a.b.f.e.ya
    public final boolean D() {
        return f4096d.b().booleanValue();
    }

    @Override // c.c.a.b.f.e.ya
    public final boolean zza() {
        return f4093a.b().booleanValue();
    }

    @Override // c.c.a.b.f.e.ya
    public final boolean zzb() {
        return f4094b.b().booleanValue();
    }
}
