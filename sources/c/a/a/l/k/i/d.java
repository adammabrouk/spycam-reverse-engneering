package c.a.a.l.k.i;

import android.graphics.Bitmap;
import c.a.a.l.i.k;
import java.io.OutputStream;

/* compiled from: GifBitmapWrapperResourceEncoder.java */
/* loaded from: classes.dex */
public class d implements c.a.a.l.f<a> {

    /* renamed from: a, reason: collision with root package name */
    public final c.a.a.l.f<Bitmap> f3346a;

    /* renamed from: b, reason: collision with root package name */
    public final c.a.a.l.f<c.a.a.l.k.h.b> f3347b;

    /* renamed from: c, reason: collision with root package name */
    public String f3348c;

    public d(c.a.a.l.f<Bitmap> fVar, c.a.a.l.f<c.a.a.l.k.h.b> fVar2) {
        this.f3346a = fVar;
        this.f3347b = fVar2;
    }

    @Override // c.a.a.l.b
    public String c() {
        if (this.f3348c == null) {
            this.f3348c = this.f3346a.c() + this.f3347b.c();
        }
        return this.f3348c;
    }

    @Override // c.a.a.l.b
    public boolean a(k<a> kVar, OutputStream outputStream) {
        a aVar = kVar.get();
        k<Bitmap> a2 = aVar.a();
        return a2 != null ? this.f3346a.a(a2, outputStream) : this.f3347b.a(aVar.b(), outputStream);
    }
}
