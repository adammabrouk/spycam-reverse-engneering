package c.c.b.n;

/* compiled from: com.google.firebase:firebase-installations@@16.3.0 */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final g f6035a;

    public c(g gVar) {
        this.f6035a = gVar;
    }

    public static Runnable a(g gVar) {
        return new c(gVar);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f6035a.f();
    }
}
