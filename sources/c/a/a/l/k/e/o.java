package c.a.a.l.k.e;

import android.graphics.Bitmap;
import java.io.File;
import java.io.InputStream;

/* compiled from: StreamBitmapDataLoadProvider.java */
/* loaded from: classes.dex */
public class o implements c.a.a.o.b<InputStream, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    public final p f3263a;

    /* renamed from: d, reason: collision with root package name */
    public final c.a.a.l.k.g.c<Bitmap> f3266d;

    /* renamed from: c, reason: collision with root package name */
    public final c.a.a.l.j.o f3265c = new c.a.a.l.j.o();

    /* renamed from: b, reason: collision with root package name */
    public final b f3264b = new b();

    public o(c.a.a.l.i.m.c cVar, c.a.a.l.a aVar) {
        this.f3263a = new p(cVar, aVar);
        this.f3266d = new c.a.a.l.k.g.c<>(this.f3263a);
    }

    @Override // c.a.a.o.b
    public c.a.a.l.e<File, Bitmap> a() {
        return this.f3266d;
    }

    @Override // c.a.a.o.b
    public c.a.a.l.b<InputStream> b() {
        return this.f3265c;
    }

    @Override // c.a.a.o.b
    public c.a.a.l.f<Bitmap> e() {
        return this.f3264b;
    }

    @Override // c.a.a.o.b
    public c.a.a.l.e<InputStream, Bitmap> f() {
        return this.f3263a;
    }
}
