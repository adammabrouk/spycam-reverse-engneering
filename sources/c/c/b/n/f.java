package c.c.b.n;

/* compiled from: com.google.firebase:firebase-installations@@16.3.0 */
/* loaded from: classes.dex */
public final /* synthetic */ class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final g f6038a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f6039b;

    public f(g gVar, boolean z) {
        this.f6038a = gVar;
        this.f6039b = z;
    }

    public static Runnable a(g gVar, boolean z) {
        return new f(gVar, z);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f6038a.b(this.f6039b);
    }
}
