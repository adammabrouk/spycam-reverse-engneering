package c.a.a.l.k.i;

import android.graphics.Bitmap;
import c.a.a.l.i.k;

/* compiled from: GifBitmapWrapper.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final k<c.a.a.l.k.h.b> f3335a;

    /* renamed from: b, reason: collision with root package name */
    public final k<Bitmap> f3336b;

    public a(k<Bitmap> kVar, k<c.a.a.l.k.h.b> kVar2) {
        if (kVar != null && kVar2 != null) {
            throw new IllegalArgumentException("Can only contain either a bitmap resource or a gif resource, not both");
        }
        if (kVar == null && kVar2 == null) {
            throw new IllegalArgumentException("Must contain either a bitmap resource or a gif resource");
        }
        this.f3336b = kVar;
        this.f3335a = kVar2;
    }

    public k<Bitmap> a() {
        return this.f3336b;
    }

    public k<c.a.a.l.k.h.b> b() {
        return this.f3335a;
    }

    public int c() {
        k<Bitmap> kVar = this.f3336b;
        return kVar != null ? kVar.b() : this.f3335a.b();
    }
}
