package c.a.a.l.k.e;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import java.io.File;
import java.io.InputStream;

/* compiled from: ImageVideoDataLoadProvider.java */
/* loaded from: classes.dex */
public class m implements c.a.a.o.b<c.a.a.l.j.g, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    public final l f3254a;

    /* renamed from: b, reason: collision with root package name */
    public final c.a.a.l.e<File, Bitmap> f3255b;

    /* renamed from: c, reason: collision with root package name */
    public final c.a.a.l.f<Bitmap> f3256c;

    /* renamed from: d, reason: collision with root package name */
    public final c.a.a.l.j.h f3257d;

    public m(c.a.a.o.b<InputStream, Bitmap> bVar, c.a.a.o.b<ParcelFileDescriptor, Bitmap> bVar2) {
        this.f3256c = bVar.e();
        this.f3257d = new c.a.a.l.j.h(bVar.b(), bVar2.b());
        this.f3255b = bVar.a();
        this.f3254a = new l(bVar.f(), bVar2.f());
    }

    @Override // c.a.a.o.b
    public c.a.a.l.e<File, Bitmap> a() {
        return this.f3255b;
    }

    @Override // c.a.a.o.b
    public c.a.a.l.b<c.a.a.l.j.g> b() {
        return this.f3257d;
    }

    @Override // c.a.a.o.b
    public c.a.a.l.f<Bitmap> e() {
        return this.f3256c;
    }

    @Override // c.a.a.o.b
    public c.a.a.l.e<c.a.a.l.j.g, Bitmap> f() {
        return this.f3254a;
    }
}
