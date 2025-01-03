package c.a.a.l.k.e;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import java.io.File;

/* compiled from: FileDescriptorBitmapDataLoadProvider.java */
/* loaded from: classes.dex */
public class g implements c.a.a.o.b<ParcelFileDescriptor, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    public final c.a.a.l.e<File, Bitmap> f3234a;

    /* renamed from: b, reason: collision with root package name */
    public final h f3235b;

    /* renamed from: c, reason: collision with root package name */
    public final b f3236c = new b();

    /* renamed from: d, reason: collision with root package name */
    public final c.a.a.l.b<ParcelFileDescriptor> f3237d = c.a.a.l.k.a.a();

    public g(c.a.a.l.i.m.c cVar, c.a.a.l.a aVar) {
        this.f3234a = new c.a.a.l.k.g.c(new p(cVar, aVar));
        this.f3235b = new h(cVar, aVar);
    }

    @Override // c.a.a.o.b
    public c.a.a.l.e<File, Bitmap> a() {
        return this.f3234a;
    }

    @Override // c.a.a.o.b
    public c.a.a.l.b<ParcelFileDescriptor> b() {
        return this.f3237d;
    }

    @Override // c.a.a.o.b
    public c.a.a.l.f<Bitmap> e() {
        return this.f3236c;
    }

    @Override // c.a.a.o.b
    public c.a.a.l.e<ParcelFileDescriptor, Bitmap> f() {
        return this.f3235b;
    }
}
