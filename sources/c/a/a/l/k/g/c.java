package c.a.a.l.k.g;

import c.a.a.l.e;
import c.a.a.l.i.k;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: FileToStreamDecoder.java */
/* loaded from: classes.dex */
public class c<T> implements e<File, T> {

    /* renamed from: c, reason: collision with root package name */
    public static final a f3275c = new a();

    /* renamed from: a, reason: collision with root package name */
    public e<InputStream, T> f3276a;

    /* renamed from: b, reason: collision with root package name */
    public final a f3277b;

    /* compiled from: FileToStreamDecoder.java */
    public static class a {
        public InputStream a(File file) throws FileNotFoundException {
            return new FileInputStream(file);
        }
    }

    public c(e<InputStream, T> eVar) {
        this(eVar, f3275c);
    }

    @Override // c.a.a.l.e
    public String c() {
        return "";
    }

    public c(e<InputStream, T> eVar, a aVar) {
        this.f3276a = eVar;
        this.f3277b = aVar;
    }

    @Override // c.a.a.l.e
    public k<T> a(File file, int i2, int i3) throws IOException {
        InputStream inputStream = null;
        try {
            inputStream = this.f3277b.a(file);
            k<T> a2 = this.f3276a.a(inputStream, i2, i3);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
            }
            return a2;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }
}
