package c.a.a.l.k.j;

import android.content.res.Resources;
import android.graphics.Bitmap;
import c.a.a.l.i.k;
import c.a.a.l.k.e.j;

/* compiled from: GlideBitmapDrawableTranscoder.java */
/* loaded from: classes.dex */
public class b implements c<Bitmap, j> {

    /* renamed from: a, reason: collision with root package name */
    public final Resources f3357a;

    /* renamed from: b, reason: collision with root package name */
    public final c.a.a.l.i.m.c f3358b;

    public b(Resources resources, c.a.a.l.i.m.c cVar) {
        this.f3357a = resources;
        this.f3358b = cVar;
    }

    @Override // c.a.a.l.k.j.c
    public k<j> a(k<Bitmap> kVar) {
        return new c.a.a.l.k.e.k(new j(this.f3357a, kVar.get()), this.f3358b);
    }

    @Override // c.a.a.l.k.j.c
    public String c() {
        return "GlideBitmapDrawableTranscoder.com.bumptech.glide.load.resource.transcode";
    }
}
