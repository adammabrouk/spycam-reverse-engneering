package c.a.a.l.k.g;

import c.a.a.l.e;
import c.a.a.l.f;
import c.a.a.l.i.k;
import c.a.a.l.j.o;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: StreamFileDataLoadProvider.java */
/* loaded from: classes.dex */
public class d implements c.a.a.o.b<InputStream, File> {

    /* renamed from: c, reason: collision with root package name */
    public static final b f3278c = new b();

    /* renamed from: a, reason: collision with root package name */
    public final e<File, File> f3279a = new c.a.a.l.k.g.a();

    /* renamed from: b, reason: collision with root package name */
    public final c.a.a.l.b<InputStream> f3280b = new o();

    /* compiled from: StreamFileDataLoadProvider.java */
    public static class b implements e<InputStream, File> {
        public b() {
        }

        @Override // c.a.a.l.e
        public /* bridge */ /* synthetic */ k<File> a(InputStream inputStream, int i2, int i3) throws IOException {
            a2(inputStream, i2, i3);
            throw null;
        }

        @Override // c.a.a.l.e
        public String c() {
            return "";
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        public k<File> a2(InputStream inputStream, int i2, int i3) {
            throw new Error("You cannot decode a File from an InputStream by default, try either #diskCacheStratey(DiskCacheStrategy.SOURCE) to avoid this call or #decoder(ResourceDecoder) to replace this Decoder");
        }
    }

    @Override // c.a.a.o.b
    public e<File, File> a() {
        return this.f3279a;
    }

    @Override // c.a.a.o.b
    public c.a.a.l.b<InputStream> b() {
        return this.f3280b;
    }

    @Override // c.a.a.o.b
    public f<File> e() {
        return c.a.a.l.k.b.a();
    }

    @Override // c.a.a.o.b
    public e<InputStream, File> f() {
        return f3278c;
    }
}
