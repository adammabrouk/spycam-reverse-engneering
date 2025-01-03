package c.c.a.b.f.e;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class ea implements fa {

    /* renamed from: a, reason: collision with root package name */
    public static final a2<Boolean> f4153a;

    static {
        g2 g2Var = new g2(b2.a("com.google.android.gms.measurement"));
        f4153a = g2Var.a("measurement.client.sessions.check_on_reset_and_enable2", true);
        g2Var.a("measurement.client.sessions.check_on_startup", true);
        g2Var.a("measurement.client.sessions.start_session_before_view_screen", true);
    }

    @Override // c.c.a.b.f.e.fa
    public final boolean zza() {
        return true;
    }

    @Override // c.c.a.b.f.e.fa
    public final boolean zzb() {
        return f4153a.b().booleanValue();
    }
}
