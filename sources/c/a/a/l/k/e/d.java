package c.a.a.l.k.e;

import android.graphics.Bitmap;

/* compiled from: BitmapTransformation.java */
/* loaded from: classes.dex */
public abstract class d implements c.a.a.l.g<Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    public c.a.a.l.i.m.c f3230a;

    public d(c.a.a.l.i.m.c cVar) {
        this.f3230a = cVar;
    }

    public abstract Bitmap a(c.a.a.l.i.m.c cVar, Bitmap bitmap, int i2, int i3);

    @Override // c.a.a.l.g
    public final c.a.a.l.i.k<Bitmap> a(c.a.a.l.i.k<Bitmap> kVar, int i2, int i3) {
        if (c.a.a.r.h.a(i2, i3)) {
            Bitmap bitmap = kVar.get();
            if (i2 == Integer.MIN_VALUE) {
                i2 = bitmap.getWidth();
            }
            if (i3 == Integer.MIN_VALUE) {
                i3 = bitmap.getHeight();
            }
            Bitmap a2 = a(this.f3230a, bitmap, i2, i3);
            return bitmap.equals(a2) ? kVar : c.a(a2, this.f3230a);
        }
        throw new IllegalArgumentException("Cannot apply transformation on width: " + i2 + " or height: " + i3 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
    }
}
