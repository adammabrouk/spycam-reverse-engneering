package c.c.a.b.f.e;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class ib implements jb {

    /* renamed from: a, reason: collision with root package name */
    public static final a2<Long> f4228a;

    static {
        g2 g2Var = new g2(b2.a("com.google.android.gms.measurement"));
        g2Var.a("measurement.id.max_bundles_per_iteration", 0L);
        f4228a = g2Var.a("measurement.max_bundles_per_iteration", 2L);
    }

    @Override // c.c.a.b.f.e.jb
    public final long zza() {
        return f4228a.b().longValue();
    }
}
