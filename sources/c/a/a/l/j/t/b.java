package c.a.a.l.j.t;

import android.content.Context;
import c.a.a.l.j.l;
import c.a.a.l.j.m;
import java.io.InputStream;

/* compiled from: StreamByteArrayLoader.java */
/* loaded from: classes.dex */
public class b implements d<byte[]> {

    /* renamed from: a, reason: collision with root package name */
    public final String f3221a;

    /* compiled from: StreamByteArrayLoader.java */
    public static class a implements m<byte[], InputStream> {
        @Override // c.a.a.l.j.m
        public l<byte[], InputStream> a(Context context, c.a.a.l.j.c cVar) {
            return new b();
        }

        @Override // c.a.a.l.j.m
        public void a() {
        }
    }

    public b() {
        this("");
    }

    @Deprecated
    public b(String str) {
        this.f3221a = str;
    }

    @Override // c.a.a.l.j.l
    public c.a.a.l.h.c<InputStream> a(byte[] bArr, int i2, int i3) {
        return new c.a.a.l.h.b(bArr, this.f3221a);
    }
}
