package c.c.a.b.g.b;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class m6 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f4931a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f4932b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f4933c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f4934d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ h6 f4935e;

    public m6(h6 h6Var, String str, String str2, Object obj, long j) {
        this.f4935e = h6Var;
        this.f4931a = str;
        this.f4932b = str2;
        this.f4933c = obj;
        this.f4934d = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4935e.a(this.f4931a, this.f4932b, this.f4933c, this.f4934d);
    }
}
