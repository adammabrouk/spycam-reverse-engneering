package c.c.a.b.f.e;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class n8 implements k8 {

    /* renamed from: a, reason: collision with root package name */
    public static final a2<Boolean> f4329a;

    static {
        g2 g2Var = new g2(b2.a("com.google.android.gms.measurement"));
        f4329a = g2Var.a("measurement.androidId.delete_feature", true);
        g2Var.a("measurement.log_androidId_enabled", false);
    }

    @Override // c.c.a.b.f.e.k8
    public final boolean zza() {
        return f4329a.b().booleanValue();
    }
}
