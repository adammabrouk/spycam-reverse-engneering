package c.a.a.l.k.i;

import android.graphics.Bitmap;
import c.a.a.l.i.k;

/* compiled from: GifBitmapWrapperTransformation.java */
/* loaded from: classes.dex */
public class f implements c.a.a.l.g<a> {

    /* renamed from: a, reason: collision with root package name */
    public final c.a.a.l.g<Bitmap> f3350a;

    /* renamed from: b, reason: collision with root package name */
    public final c.a.a.l.g<c.a.a.l.k.h.b> f3351b;

    public f(c.a.a.l.i.m.c cVar, c.a.a.l.g<Bitmap> gVar) {
        this(gVar, new c.a.a.l.k.h.e(gVar, cVar));
    }

    @Override // c.a.a.l.g
    public k<a> a(k<a> kVar, int i2, int i3) {
        c.a.a.l.g<c.a.a.l.k.h.b> gVar;
        c.a.a.l.g<Bitmap> gVar2;
        k<Bitmap> a2 = kVar.get().a();
        k<c.a.a.l.k.h.b> b2 = kVar.get().b();
        if (a2 != null && (gVar2 = this.f3350a) != null) {
            k<Bitmap> a3 = gVar2.a(a2, i2, i3);
            return !a2.equals(a3) ? new b(new a(a3, kVar.get().b())) : kVar;
        }
        if (b2 == null || (gVar = this.f3351b) == null) {
            return kVar;
        }
        k<c.a.a.l.k.h.b> a4 = gVar.a(b2, i2, i3);
        return !b2.equals(a4) ? new b(new a(kVar.get().a(), a4)) : kVar;
    }

    @Override // c.a.a.l.g
    public String c() {
        return this.f3350a.c();
    }

    public f(c.a.a.l.g<Bitmap> gVar, c.a.a.l.g<c.a.a.l.k.h.b> gVar2) {
        this.f3350a = gVar;
        this.f3351b = gVar2;
    }
}
