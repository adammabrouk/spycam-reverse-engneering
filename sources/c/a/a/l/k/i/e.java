package c.a.a.l.k.i;

import c.a.a.l.i.k;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: GifBitmapWrapperStreamResourceDecoder.java */
/* loaded from: classes.dex */
public class e implements c.a.a.l.e<InputStream, a> {

    /* renamed from: a, reason: collision with root package name */
    public final c.a.a.l.e<c.a.a.l.j.g, a> f3349a;

    public e(c.a.a.l.e<c.a.a.l.j.g, a> eVar) {
        this.f3349a = eVar;
    }

    @Override // c.a.a.l.e
    public String c() {
        return this.f3349a.c();
    }

    @Override // c.a.a.l.e
    public k<a> a(InputStream inputStream, int i2, int i3) throws IOException {
        return this.f3349a.a(new c.a.a.l.j.g(inputStream, null), i2, i3);
    }
}
