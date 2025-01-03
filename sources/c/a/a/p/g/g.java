package c.a.a.p.g;

import c.a.a.p.g.f;

/* compiled from: ViewAnimationFactory.java */
/* loaded from: classes.dex */
public class g<R> implements d<R> {

    /* renamed from: a, reason: collision with root package name */
    public final f.a f3425a;

    /* renamed from: b, reason: collision with root package name */
    public c<R> f3426b;

    public g(f.a aVar) {
        this.f3425a = aVar;
    }

    @Override // c.a.a.p.g.d
    public c<R> a(boolean z, boolean z2) {
        if (z || !z2) {
            return e.b();
        }
        if (this.f3426b == null) {
            this.f3426b = new f(this.f3425a);
        }
        return this.f3426b;
    }
}
