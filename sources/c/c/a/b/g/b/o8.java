package c.c.a.b.g.b;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class o8 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o3 f4981a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j8 f4982b;

    public o8(j8 j8Var, o3 o3Var) {
        this.f4982b = j8Var;
        this.f4981a = o3Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f4982b) {
            j8.a(this.f4982b, false);
            if (!this.f4982b.f4839c.A()) {
                this.f4982b.f4839c.c().A().a("Connected to remote service");
                this.f4982b.f4839c.a(this.f4981a);
            }
        }
    }
}
