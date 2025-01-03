package c.j.a;

/* compiled from: PushClientManager.java */
/* loaded from: classes.dex */
public final class p implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c.j.a.f.a f6630a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f6631b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ m f6632c;

    public p(m mVar, c.j.a.f.a aVar, String str) {
        this.f6632c = mVar;
        this.f6630a = aVar;
        this.f6631b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6632c.a(this.f6630a);
        this.f6632c.e(this.f6631b);
    }
}
