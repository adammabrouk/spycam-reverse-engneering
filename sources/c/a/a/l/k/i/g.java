package c.a.a.l.k.i;

import android.graphics.Bitmap;
import java.io.File;
import java.io.InputStream;

/* compiled from: ImageVideoGifDrawableLoadProvider.java */
/* loaded from: classes.dex */
public class g implements c.a.a.o.b<c.a.a.l.j.g, a> {

    /* renamed from: a, reason: collision with root package name */
    public final c.a.a.l.e<File, a> f3352a;

    /* renamed from: b, reason: collision with root package name */
    public final c.a.a.l.e<c.a.a.l.j.g, a> f3353b;

    /* renamed from: c, reason: collision with root package name */
    public final c.a.a.l.f<a> f3354c;

    /* renamed from: d, reason: collision with root package name */
    public final c.a.a.l.b<c.a.a.l.j.g> f3355d;

    public g(c.a.a.o.b<c.a.a.l.j.g, Bitmap> bVar, c.a.a.o.b<InputStream, c.a.a.l.k.h.b> bVar2, c.a.a.l.i.m.c cVar) {
        c cVar2 = new c(bVar.f(), bVar2.f(), cVar);
        this.f3352a = new c.a.a.l.k.g.c(new e(cVar2));
        this.f3353b = cVar2;
        this.f3354c = new d(bVar.e(), bVar2.e());
        this.f3355d = bVar.b();
    }

    @Override // c.a.a.o.b
    public c.a.a.l.e<File, a> a() {
        return this.f3352a;
    }

    @Override // c.a.a.o.b
    public c.a.a.l.b<c.a.a.l.j.g> b() {
        return this.f3355d;
    }

    @Override // c.a.a.o.b
    public c.a.a.l.f<a> e() {
        return this.f3354c;
    }

    @Override // c.a.a.o.b
    public c.a.a.l.e<c.a.a.l.j.g, a> f() {
        return this.f3353b;
    }
}
