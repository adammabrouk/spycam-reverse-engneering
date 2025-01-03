package c.c.a.b.f.e;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class ub implements rb {

    /* renamed from: a, reason: collision with root package name */
    public static final a2<Boolean> f4479a;

    /* renamed from: b, reason: collision with root package name */
    public static final a2<Double> f4480b;

    /* renamed from: c, reason: collision with root package name */
    public static final a2<Long> f4481c;

    /* renamed from: d, reason: collision with root package name */
    public static final a2<Long> f4482d;

    /* renamed from: e, reason: collision with root package name */
    public static final a2<String> f4483e;

    static {
        g2 g2Var = new g2(b2.a("com.google.android.gms.measurement"));
        f4479a = g2Var.a("measurement.test.boolean_flag", false);
        f4480b = g2Var.a("measurement.test.double_flag", -3.0d);
        f4481c = g2Var.a("measurement.test.int_flag", -2L);
        f4482d = g2Var.a("measurement.test.long_flag", -1L);
        f4483e = g2Var.a("measurement.test.string_flag", "---");
    }

    @Override // c.c.a.b.f.e.rb
    public final long C() {
        return f4481c.b().longValue();
    }

    @Override // c.c.a.b.f.e.rb
    public final long D() {
        return f4482d.b().longValue();
    }

    @Override // c.c.a.b.f.e.rb
    public final String E() {
        return f4483e.b();
    }

    @Override // c.c.a.b.f.e.rb
    public final boolean zza() {
        return f4479a.b().booleanValue();
    }

    @Override // c.c.a.b.f.e.rb
    public final double zzb() {
        return f4480b.b().doubleValue();
    }
}
