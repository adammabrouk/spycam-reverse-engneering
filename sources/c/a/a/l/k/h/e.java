package c.a.a.l.k.h;

import android.graphics.Bitmap;
import c.a.a.l.i.k;

/* compiled from: GifDrawableTransformation.java */
/* loaded from: classes.dex */
public class e implements c.a.a.l.g<b> {

    /* renamed from: a, reason: collision with root package name */
    public final c.a.a.l.g<Bitmap> f3304a;

    /* renamed from: b, reason: collision with root package name */
    public final c.a.a.l.i.m.c f3305b;

    public e(c.a.a.l.g<Bitmap> gVar, c.a.a.l.i.m.c cVar) {
        this.f3304a = gVar;
        this.f3305b = cVar;
    }

    @Override // c.a.a.l.g
    public k<b> a(k<b> kVar, int i2, int i3) {
        b bVar = kVar.get();
        Bitmap c2 = kVar.get().c();
        Bitmap bitmap = this.f3304a.a(new c.a.a.l.k.e.c(c2, this.f3305b), i2, i3).get();
        return !bitmap.equals(c2) ? new d(new b(bVar, bitmap, this.f3304a)) : kVar;
    }

    @Override // c.a.a.l.g
    public String c() {
        return this.f3304a.c();
    }
}
