package c.k.b.b;

/* loaded from: classes.dex */
public class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c.k.b.a.c f6787a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f6788b;

    public d(b bVar, c.k.b.a.c cVar) {
        this.f6788b = bVar;
        this.f6787a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f6788b.b(this.f6787a);
    }
}
