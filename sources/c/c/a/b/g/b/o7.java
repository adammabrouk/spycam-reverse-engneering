package c.c.a.b.g.b;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class o7 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m7 f4976a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m7 f4977b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f4978c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f4979d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ l7 f4980e;

    public o7(l7 l7Var, m7 m7Var, m7 m7Var2, long j, boolean z) {
        this.f4980e = l7Var;
        this.f4976a = m7Var;
        this.f4977b = m7Var2;
        this.f4978c = j;
        this.f4979d = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4980e.a(this.f4976a, this.f4977b, this.f4978c, this.f4979d, null);
    }
}
