package c.a.a.l.k.e;

import android.graphics.Bitmap;

/* compiled from: BitmapResource.java */
/* loaded from: classes.dex */
public class c implements c.a.a.l.i.k<Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    public final Bitmap f3228a;

    /* renamed from: b, reason: collision with root package name */
    public final c.a.a.l.i.m.c f3229b;

    public c(Bitmap bitmap, c.a.a.l.i.m.c cVar) {
        if (bitmap == null) {
            throw new NullPointerException("Bitmap must not be null");
        }
        if (cVar == null) {
            throw new NullPointerException("BitmapPool must not be null");
        }
        this.f3228a = bitmap;
        this.f3229b = cVar;
    }

    public static c a(Bitmap bitmap, c.a.a.l.i.m.c cVar) {
        if (bitmap == null) {
            return null;
        }
        return new c(bitmap, cVar);
    }

    @Override // c.a.a.l.i.k
    public int b() {
        return c.a.a.r.h.a(this.f3228a);
    }

    @Override // c.a.a.l.i.k
    public void a() {
        if (this.f3229b.a(this.f3228a)) {
            return;
        }
        this.f3228a.recycle();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // c.a.a.l.i.k
    public Bitmap get() {
        return this.f3228a;
    }
}
