package c.k.b.b;

/* loaded from: classes.dex */
public class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c.k.b.a.b f6785a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f6786b;

    public c(b bVar, c.k.b.a.b bVar2) {
        this.f6786b = bVar;
        this.f6785a = bVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f6786b.b(this.f6785a);
    }
}
