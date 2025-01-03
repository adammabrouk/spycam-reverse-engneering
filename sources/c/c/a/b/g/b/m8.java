package c.c.a.b.g.b;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class m8 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o3 f4941a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j8 f4942b;

    public m8(j8 j8Var, o3 o3Var) {
        this.f4942b = j8Var;
        this.f4941a = o3Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f4942b) {
            j8.a(this.f4942b, false);
            if (!this.f4942b.f4839c.A()) {
                this.f4942b.f4839c.c().B().a("Connected to service");
                this.f4942b.f4839c.a(this.f4941a);
            }
        }
    }
}
