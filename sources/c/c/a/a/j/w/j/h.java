package c.c.a.a.j.w.j;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
/* loaded from: classes.dex */
public final /* synthetic */ class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final m f3677a;

    /* renamed from: b, reason: collision with root package name */
    public final c.c.a.a.j.l f3678b;

    /* renamed from: c, reason: collision with root package name */
    public final int f3679c;

    /* renamed from: d, reason: collision with root package name */
    public final Runnable f3680d;

    public h(m mVar, c.c.a.a.j.l lVar, int i2, Runnable runnable) {
        this.f3677a = mVar;
        this.f3678b = lVar;
        this.f3679c = i2;
        this.f3680d = runnable;
    }

    public static Runnable a(m mVar, c.c.a.a.j.l lVar, int i2, Runnable runnable) {
        return new h(mVar, lVar, i2, runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        m.a(this.f3677a, this.f3678b, this.f3679c, this.f3680d);
    }
}
