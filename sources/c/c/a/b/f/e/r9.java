package c.c.a.b.f.e;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class r9 implements o9 {

    /* renamed from: a, reason: collision with root package name */
    public static final a2<Boolean> f4407a;

    /* renamed from: b, reason: collision with root package name */
    public static final a2<Boolean> f4408b;

    /* renamed from: c, reason: collision with root package name */
    public static final a2<Boolean> f4409c;

    /* renamed from: d, reason: collision with root package name */
    public static final a2<Boolean> f4410d;

    static {
        g2 g2Var = new g2(b2.a("com.google.android.gms.measurement"));
        f4407a = g2Var.a("measurement.service.audience.fix_skip_audience_with_failed_filters", true);
        f4408b = g2Var.a("measurement.audience.refresh_event_count_filters_timestamp", false);
        f4409c = g2Var.a("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", false);
        f4410d = g2Var.a("measurement.audience.use_bundle_timestamp_for_event_count_filters", false);
    }

    @Override // c.c.a.b.f.e.o9
    public final boolean C() {
        return f4408b.b().booleanValue();
    }

    @Override // c.c.a.b.f.e.o9
    public final boolean D() {
        return f4409c.b().booleanValue();
    }

    @Override // c.c.a.b.f.e.o9
    public final boolean E() {
        return f4410d.b().booleanValue();
    }

    @Override // c.c.a.b.f.e.o9
    public final boolean zza() {
        return true;
    }

    @Override // c.c.a.b.f.e.o9
    public final boolean zzb() {
        return f4407a.b().booleanValue();
    }
}
