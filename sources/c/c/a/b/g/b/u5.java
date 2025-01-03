package c.c.a.b.g.b;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class u5 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f5119a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f5120b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f5121c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f5122d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ g5 f5123e;

    public u5(g5 g5Var, String str, String str2, String str3, long j) {
        this.f5123e = g5Var;
        this.f5119a = str;
        this.f5120b = str2;
        this.f5121c = str3;
        this.f5122d = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        l9 l9Var;
        l9 l9Var2;
        String str = this.f5119a;
        if (str == null) {
            l9Var2 = this.f5123e.f4739a;
            l9Var2.u().D().a(this.f5120b, (m7) null);
        } else {
            m7 m7Var = new m7(this.f5121c, str, this.f5122d);
            l9Var = this.f5123e.f4739a;
            l9Var.u().D().a(this.f5120b, m7Var);
        }
    }
}
