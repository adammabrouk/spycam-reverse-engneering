package c.a.a.l.i.n;

import android.annotation.SuppressLint;
import c.a.a.l.i.k;
import c.a.a.l.i.n.h;

/* compiled from: LruResourceCache.java */
/* loaded from: classes.dex */
public class g extends c.a.a.r.e<c.a.a.l.c, k<?>> implements h {

    /* renamed from: d, reason: collision with root package name */
    public h.a f3169d;

    public g(int i2) {
        super(i2);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // c.a.a.l.i.n.h
    public /* bridge */ /* synthetic */ k a(c.a.a.l.c cVar, k kVar) {
        return (k) super.b((g) cVar, (c.a.a.l.c) kVar);
    }

    @Override // c.a.a.r.e
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(c.a.a.l.c cVar, k<?> kVar) {
        h.a aVar = this.f3169d;
        if (aVar != null) {
            aVar.a(kVar);
        }
    }

    @Override // c.a.a.l.i.n.h
    public /* bridge */ /* synthetic */ k a(c.a.a.l.c cVar) {
        return (k) super.c(cVar);
    }

    @Override // c.a.a.l.i.n.h
    public void a(h.a aVar) {
        this.f3169d = aVar;
    }

    @Override // c.a.a.r.e
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int b(k<?> kVar) {
        return kVar.b();
    }

    @Override // c.a.a.l.i.n.h
    @SuppressLint({"InlinedApi"})
    public void a(int i2) {
        if (i2 >= 60) {
            a();
        } else if (i2 >= 40) {
            b(c() / 2);
        }
    }
}
