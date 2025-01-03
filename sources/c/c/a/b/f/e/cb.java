package c.c.a.b.f.e;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class cb implements db {

    /* renamed from: a, reason: collision with root package name */
    public static final a2<Boolean> f4125a;

    /* renamed from: b, reason: collision with root package name */
    public static final a2<Boolean> f4126b;

    /* renamed from: c, reason: collision with root package name */
    public static final a2<Boolean> f4127c;

    static {
        g2 g2Var = new g2(b2.a("com.google.android.gms.measurement"));
        g2Var.a("measurement.id.lifecycle.app_in_background_parameter", 0L);
        f4125a = g2Var.a("measurement.lifecycle.app_backgrounded_engagement", false);
        f4126b = g2Var.a("measurement.lifecycle.app_backgrounded_tracking", true);
        f4127c = g2Var.a("measurement.lifecycle.app_in_background_parameter", false);
        g2Var.a("measurement.id.lifecycle.app_backgrounded_tracking", 0L);
    }

    @Override // c.c.a.b.f.e.db
    public final boolean C() {
        return f4127c.b().booleanValue();
    }

    @Override // c.c.a.b.f.e.db
    public final boolean zza() {
        return f4125a.b().booleanValue();
    }

    @Override // c.c.a.b.f.e.db
    public final boolean zzb() {
        return f4126b.b().booleanValue();
    }
}
