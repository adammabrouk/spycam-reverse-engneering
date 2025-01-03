package c.a.a.l.k.e;

import android.graphics.Bitmap;
import java.io.InputStream;

/* compiled from: StreamBitmapDecoder.java */
/* loaded from: classes.dex */
public class p implements c.a.a.l.e<InputStream, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    public final f f3267a;

    /* renamed from: b, reason: collision with root package name */
    public c.a.a.l.i.m.c f3268b;

    /* renamed from: c, reason: collision with root package name */
    public c.a.a.l.a f3269c;

    /* renamed from: d, reason: collision with root package name */
    public String f3270d;

    public p(c.a.a.l.i.m.c cVar, c.a.a.l.a aVar) {
        this(f.f3233c, cVar, aVar);
    }

    @Override // c.a.a.l.e
    public String c() {
        if (this.f3270d == null) {
            this.f3270d = "StreamBitmapDecoder.com.bumptech.glide.load.resource.bitmap" + this.f3267a.c() + this.f3269c.name();
        }
        return this.f3270d;
    }

    public p(f fVar, c.a.a.l.i.m.c cVar, c.a.a.l.a aVar) {
        this.f3267a = fVar;
        this.f3268b = cVar;
        this.f3269c = aVar;
    }

    @Override // c.a.a.l.e
    public c.a.a.l.i.k<Bitmap> a(InputStream inputStream, int i2, int i3) {
        return c.a(this.f3267a.a(inputStream, this.f3268b, i2, i3, this.f3269c), this.f3268b);
    }
}
