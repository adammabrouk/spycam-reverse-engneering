package c.c.a.b.f.e;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class a9 implements b9 {

    /* renamed from: a, reason: collision with root package name */
    public static final a2<Boolean> f4074a;

    /* renamed from: b, reason: collision with root package name */
    public static final a2<Boolean> f4075b;

    static {
        g2 g2Var = new g2(b2.a("com.google.android.gms.measurement"));
        f4074a = g2Var.a("measurement.sdk.dynamite.allow_remote_dynamite", false);
        g2Var.a("measurement.collection.init_params_control_enabled", true);
        f4075b = g2Var.a("measurement.sdk.dynamite.use_dynamite3", true);
        g2Var.a("measurement.id.sdk.dynamite.use_dynamite", 0L);
    }

    @Override // c.c.a.b.f.e.b9
    public final boolean zza() {
        return f4074a.b().booleanValue();
    }

    @Override // c.c.a.b.f.e.b9
    public final boolean zzb() {
        return f4075b.b().booleanValue();
    }
}
