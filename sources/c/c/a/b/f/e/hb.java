package c.c.a.b.f.e;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class hb implements eb {

    /* renamed from: a, reason: collision with root package name */
    public static final a2<Boolean> f4216a;

    /* renamed from: b, reason: collision with root package name */
    public static final a2<Boolean> f4217b;

    static {
        g2 g2Var = new g2(b2.a("com.google.android.gms.measurement"));
        f4216a = g2Var.a("measurement.sdk.screen.manual_screen_view_logging", true);
        f4217b = g2Var.a("measurement.sdk.screen.disabling_automatic_reporting", true);
    }

    @Override // c.c.a.b.f.e.eb
    public final boolean C() {
        return f4217b.b().booleanValue();
    }

    @Override // c.c.a.b.f.e.eb
    public final boolean zza() {
        return true;
    }

    @Override // c.c.a.b.f.e.eb
    public final boolean zzb() {
        return f4216a.b().booleanValue();
    }
}
