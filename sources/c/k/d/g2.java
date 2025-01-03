package c.k.d;

/* loaded from: classes.dex */
public class g2 implements c.k.a.a.a.a {

    /* renamed from: a, reason: collision with root package name */
    public c.k.a.a.a.a f7145a;

    /* renamed from: b, reason: collision with root package name */
    public c.k.a.a.a.a f7146b;

    public g2(c.k.a.a.a.a aVar, c.k.a.a.a.a aVar2) {
        this.f7145a = null;
        this.f7146b = null;
        this.f7145a = aVar;
        this.f7146b = aVar2;
    }

    @Override // c.k.a.a.a.a
    public void a(String str) {
        c.k.a.a.a.a aVar = this.f7145a;
        if (aVar != null) {
            aVar.a(str);
        }
        c.k.a.a.a.a aVar2 = this.f7146b;
        if (aVar2 != null) {
            aVar2.a(str);
        }
    }

    @Override // c.k.a.a.a.a
    public void a(String str, Throwable th) {
        c.k.a.a.a.a aVar = this.f7145a;
        if (aVar != null) {
            aVar.a(str, th);
        }
        c.k.a.a.a.a aVar2 = this.f7146b;
        if (aVar2 != null) {
            aVar2.a(str, th);
        }
    }
}
