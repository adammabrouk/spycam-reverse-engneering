package c.c.a.b.f.e;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class f9 implements c9 {

    /* renamed from: a, reason: collision with root package name */
    public static final a2<Boolean> f4169a;

    /* renamed from: b, reason: collision with root package name */
    public static final a2<Boolean> f4170b;

    /* renamed from: c, reason: collision with root package name */
    public static final a2<Boolean> f4171c;

    /* renamed from: d, reason: collision with root package name */
    public static final a2<Boolean> f4172d;

    /* renamed from: e, reason: collision with root package name */
    public static final a2<Boolean> f4173e;

    /* renamed from: f, reason: collision with root package name */
    public static final a2<Boolean> f4174f;

    static {
        g2 g2Var = new g2(b2.a("com.google.android.gms.measurement"));
        f4169a = g2Var.a("measurement.gold.enhanced_ecommerce.format_logs", false);
        g2Var.a("measurement.id.gold.enhanced_ecommerce.service", 0L);
        f4170b = g2Var.a("measurement.gold.enhanced_ecommerce.log_nested_complex_events", true);
        f4171c = g2Var.a("measurement.gold.enhanced_ecommerce.nested_param_daily_event_count", false);
        f4172d = g2Var.a("measurement.gold.enhanced_ecommerce.updated_schema.client", true);
        f4173e = g2Var.a("measurement.gold.enhanced_ecommerce.updated_schema.service", false);
        f4174f = g2Var.a("measurement.gold.enhanced_ecommerce.upload_nested_complex_events", false);
    }

    @Override // c.c.a.b.f.e.c9
    public final boolean C() {
        return f4170b.b().booleanValue();
    }

    @Override // c.c.a.b.f.e.c9
    public final boolean D() {
        return f4171c.b().booleanValue();
    }

    @Override // c.c.a.b.f.e.c9
    public final boolean E() {
        return f4172d.b().booleanValue();
    }

    @Override // c.c.a.b.f.e.c9
    public final boolean e() {
        return f4173e.b().booleanValue();
    }

    @Override // c.c.a.b.f.e.c9
    public final boolean f() {
        return f4174f.b().booleanValue();
    }

    @Override // c.c.a.b.f.e.c9
    public final boolean zza() {
        return true;
    }

    @Override // c.c.a.b.f.e.c9
    public final boolean zzb() {
        return f4169a.b().booleanValue();
    }
}
