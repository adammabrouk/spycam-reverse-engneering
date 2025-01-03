package c.a.a.l.k.h;

import android.graphics.Bitmap;
import android.util.Log;
import c.a.a.j.a;
import c.a.a.l.i.k;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: GifResourceEncoder.java */
/* loaded from: classes.dex */
public class j implements c.a.a.l.f<b> {

    /* renamed from: d, reason: collision with root package name */
    public static final a f3331d = new a();

    /* renamed from: a, reason: collision with root package name */
    public final a.InterfaceC0063a f3332a;

    /* renamed from: b, reason: collision with root package name */
    public final c.a.a.l.i.m.c f3333b;

    /* renamed from: c, reason: collision with root package name */
    public final a f3334c;

    /* compiled from: GifResourceEncoder.java */
    public static class a {
        public c.a.a.j.a a(a.InterfaceC0063a interfaceC0063a) {
            return new c.a.a.j.a(interfaceC0063a);
        }

        public c.a.a.j.d b() {
            return new c.a.a.j.d();
        }

        public c.a.a.k.a a() {
            return new c.a.a.k.a();
        }

        public k<Bitmap> a(Bitmap bitmap, c.a.a.l.i.m.c cVar) {
            return new c.a.a.l.k.e.c(bitmap, cVar);
        }
    }

    public j(c.a.a.l.i.m.c cVar) {
        this(cVar, f3331d);
    }

    @Override // c.a.a.l.b
    public String c() {
        return "";
    }

    public j(c.a.a.l.i.m.c cVar, a aVar) {
        this.f3333b = cVar;
        this.f3332a = new c.a.a.l.k.h.a(cVar);
        this.f3334c = aVar;
    }

    @Override // c.a.a.l.b
    public boolean a(k<b> kVar, OutputStream outputStream) {
        long a2 = c.a.a.r.d.a();
        b bVar = kVar.get();
        c.a.a.l.g<Bitmap> e2 = bVar.e();
        if (e2 instanceof c.a.a.l.k.d) {
            return a(bVar.b(), outputStream);
        }
        c.a.a.j.a a3 = a(bVar.b());
        c.a.a.k.a a4 = this.f3334c.a();
        if (!a4.a(outputStream)) {
            return false;
        }
        for (int i2 = 0; i2 < a3.d(); i2++) {
            k<Bitmap> a5 = a(a3.h(), e2, bVar);
            try {
                if (!a4.a(a5.get())) {
                    return false;
                }
                a4.b(a3.a(a3.c()));
                a3.a();
                a5.a();
            } finally {
                a5.a();
            }
        }
        boolean b2 = a4.b();
        if (Log.isLoggable("GifEncoder", 2)) {
            Log.v("GifEncoder", "Encoded gif with " + a3.d() + " frames and " + bVar.b().length + " bytes in " + c.a.a.r.d.a(a2) + " ms");
        }
        return b2;
    }

    public final boolean a(byte[] bArr, OutputStream outputStream) {
        try {
            outputStream.write(bArr);
            return true;
        } catch (IOException e2) {
            if (Log.isLoggable("GifEncoder", 3)) {
                Log.d("GifEncoder", "Failed to write data to output stream in GifResourceEncoder", e2);
            }
            return false;
        }
    }

    public final c.a.a.j.a a(byte[] bArr) {
        c.a.a.j.d b2 = this.f3334c.b();
        b2.a(bArr);
        c.a.a.j.c c2 = b2.c();
        c.a.a.j.a a2 = this.f3334c.a(this.f3332a);
        a2.a(c2, bArr);
        a2.a();
        return a2;
    }

    public final k<Bitmap> a(Bitmap bitmap, c.a.a.l.g<Bitmap> gVar, b bVar) {
        k<Bitmap> a2 = this.f3334c.a(bitmap, this.f3333b);
        k<Bitmap> a3 = gVar.a(a2, bVar.getIntrinsicWidth(), bVar.getIntrinsicHeight());
        if (!a2.equals(a3)) {
            a2.a();
        }
        return a3;
    }
}
