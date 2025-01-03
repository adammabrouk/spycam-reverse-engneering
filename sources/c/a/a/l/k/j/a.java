package c.a.a.l.k.j;

import android.graphics.Bitmap;
import c.a.a.l.i.k;
import c.a.a.l.k.e.j;

/* compiled from: GifBitmapWrapperDrawableTranscoder.java */
/* loaded from: classes.dex */
public class a implements c<c.a.a.l.k.i.a, c.a.a.l.k.f.b> {

    /* renamed from: a, reason: collision with root package name */
    public final c<Bitmap, j> f3356a;

    public a(c<Bitmap, j> cVar) {
        this.f3356a = cVar;
    }

    @Override // c.a.a.l.k.j.c
    public k<c.a.a.l.k.f.b> a(k<c.a.a.l.k.i.a> kVar) {
        c.a.a.l.k.i.a aVar = kVar.get();
        k<Bitmap> a2 = aVar.a();
        return a2 != null ? this.f3356a.a(a2) : aVar.b();
    }

    @Override // c.a.a.l.k.j.c
    public String c() {
        return "GifBitmapWrapperDrawableTranscoder.com.bumptech.glide.load.resource.transcode";
    }
}
