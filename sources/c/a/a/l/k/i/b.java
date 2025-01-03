package c.a.a.l.k.i;

import android.graphics.Bitmap;
import c.a.a.l.i.k;

/* compiled from: GifBitmapWrapperResource.java */
/* loaded from: classes.dex */
public class b implements k<a> {

    /* renamed from: a, reason: collision with root package name */
    public final a f3337a;

    public b(a aVar) {
        if (aVar == null) {
            throw new NullPointerException("Data must not be null");
        }
        this.f3337a = aVar;
    }

    @Override // c.a.a.l.i.k
    public void a() {
        k<Bitmap> a2 = this.f3337a.a();
        if (a2 != null) {
            a2.a();
        }
        k<c.a.a.l.k.h.b> b2 = this.f3337a.b();
        if (b2 != null) {
            b2.a();
        }
    }

    @Override // c.a.a.l.i.k
    public int b() {
        return this.f3337a.c();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // c.a.a.l.i.k
    public a get() {
        return this.f3337a;
    }
}
