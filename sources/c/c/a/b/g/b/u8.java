package c.c.a.b.g.b;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class u8 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l9 f5127a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Runnable f5128b;

    public u8(p8 p8Var, l9 l9Var, Runnable runnable) {
        this.f5127a = l9Var;
        this.f5128b = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5127a.s();
        this.f5127a.a(this.f5128b);
        this.f5127a.r();
    }
}
