package c.a.a.l.k.i;

import android.graphics.Bitmap;
import c.a.a.l.i.k;
import c.a.a.l.k.e.n;
import com.bumptech.glide.load.resource.bitmap.ImageHeaderParser;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: GifBitmapWrapperResourceDecoder.java */
/* loaded from: classes.dex */
public class c implements c.a.a.l.e<c.a.a.l.j.g, c.a.a.l.k.i.a> {

    /* renamed from: g, reason: collision with root package name */
    public static final b f3338g = new b();

    /* renamed from: h, reason: collision with root package name */
    public static final a f3339h = new a();

    /* renamed from: a, reason: collision with root package name */
    public final c.a.a.l.e<c.a.a.l.j.g, Bitmap> f3340a;

    /* renamed from: b, reason: collision with root package name */
    public final c.a.a.l.e<InputStream, c.a.a.l.k.h.b> f3341b;

    /* renamed from: c, reason: collision with root package name */
    public final c.a.a.l.i.m.c f3342c;

    /* renamed from: d, reason: collision with root package name */
    public final b f3343d;

    /* renamed from: e, reason: collision with root package name */
    public final a f3344e;

    /* renamed from: f, reason: collision with root package name */
    public String f3345f;

    /* compiled from: GifBitmapWrapperResourceDecoder.java */
    public static class a {
        public InputStream a(InputStream inputStream, byte[] bArr) {
            return new n(inputStream, bArr);
        }
    }

    /* compiled from: GifBitmapWrapperResourceDecoder.java */
    public static class b {
        public ImageHeaderParser.ImageType a(InputStream inputStream) throws IOException {
            return new ImageHeaderParser(inputStream).c();
        }
    }

    public c(c.a.a.l.e<c.a.a.l.j.g, Bitmap> eVar, c.a.a.l.e<InputStream, c.a.a.l.k.h.b> eVar2, c.a.a.l.i.m.c cVar) {
        this(eVar, eVar2, cVar, f3338g, f3339h);
    }

    public final c.a.a.l.k.i.a b(c.a.a.l.j.g gVar, int i2, int i3, byte[] bArr) throws IOException {
        InputStream a2 = this.f3344e.a(gVar.b(), bArr);
        a2.mark(2048);
        ImageHeaderParser.ImageType a3 = this.f3343d.a(a2);
        a2.reset();
        c.a.a.l.k.i.a a4 = a3 == ImageHeaderParser.ImageType.GIF ? a(a2, i2, i3) : null;
        return a4 == null ? b(new c.a.a.l.j.g(a2, gVar.a()), i2, i3) : a4;
    }

    @Override // c.a.a.l.e
    public String c() {
        if (this.f3345f == null) {
            this.f3345f = this.f3341b.c() + this.f3340a.c();
        }
        return this.f3345f;
    }

    public c(c.a.a.l.e<c.a.a.l.j.g, Bitmap> eVar, c.a.a.l.e<InputStream, c.a.a.l.k.h.b> eVar2, c.a.a.l.i.m.c cVar, b bVar, a aVar) {
        this.f3340a = eVar;
        this.f3341b = eVar2;
        this.f3342c = cVar;
        this.f3343d = bVar;
        this.f3344e = aVar;
    }

    @Override // c.a.a.l.e
    public k<c.a.a.l.k.i.a> a(c.a.a.l.j.g gVar, int i2, int i3) throws IOException {
        c.a.a.r.a b2 = c.a.a.r.a.b();
        byte[] a2 = b2.a();
        try {
            c.a.a.l.k.i.a a3 = a(gVar, i2, i3, a2);
            if (a3 != null) {
                return new c.a.a.l.k.i.b(a3);
            }
            return null;
        } finally {
            b2.a(a2);
        }
    }

    public final c.a.a.l.k.i.a a(c.a.a.l.j.g gVar, int i2, int i3, byte[] bArr) throws IOException {
        if (gVar.b() != null) {
            return b(gVar, i2, i3, bArr);
        }
        return b(gVar, i2, i3);
    }

    public final c.a.a.l.k.i.a b(c.a.a.l.j.g gVar, int i2, int i3) throws IOException {
        k<Bitmap> a2 = this.f3340a.a(gVar, i2, i3);
        if (a2 != null) {
            return new c.a.a.l.k.i.a(a2, null);
        }
        return null;
    }

    public final c.a.a.l.k.i.a a(InputStream inputStream, int i2, int i3) throws IOException {
        c.a.a.l.k.i.a aVar;
        k<c.a.a.l.k.h.b> a2 = this.f3341b.a(inputStream, i2, i3);
        if (a2 == null) {
            return null;
        }
        c.a.a.l.k.h.b bVar = a2.get();
        if (bVar.d() > 1) {
            aVar = new c.a.a.l.k.i.a(null, a2);
        } else {
            aVar = new c.a.a.l.k.i.a(new c.a.a.l.k.e.c(bVar.c(), this.f3342c), null);
        }
        return aVar;
    }
}
