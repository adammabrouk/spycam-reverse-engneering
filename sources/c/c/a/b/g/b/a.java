package c.c.a.b.g.b;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f4560a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f4561b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ z f4562c;

    public a(z zVar, String str, long j) {
        this.f4562c = zVar;
        this.f4560a = str;
        this.f4561b = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4562c.c(this.f4560a, this.f4561b);
    }
}
