package c.c.a.b.g.b;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class b2 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f4599a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f4600b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ z f4601c;

    public b2(z zVar, String str, long j) {
        this.f4601c = zVar;
        this.f4599a = str;
        this.f4600b = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4601c.d(this.f4599a, this.f4600b);
    }
}
