package h;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

/* compiled from: ResponseBody.java */
/* loaded from: classes.dex */
public abstract class b0 implements Closeable {
    public Reader reader;

    /* compiled from: ResponseBody.java */
    public class a extends b0 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u f11364a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f11365b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ i.e f11366c;

        public a(u uVar, long j, i.e eVar) {
            this.f11364a = uVar;
            this.f11365b = j;
            this.f11366c = eVar;
        }

        @Override // h.b0
        public long contentLength() {
            return this.f11365b;
        }

        @Override // h.b0
        @Nullable
        public u contentType() {
            return this.f11364a;
        }

        @Override // h.b0
        public i.e source() {
            return this.f11366c;
        }
    }

    /* compiled from: ResponseBody.java */
    public static final class b extends Reader {

        /* renamed from: a, reason: collision with root package name */
        public final i.e f11367a;

        /* renamed from: b, reason: collision with root package name */
        public final Charset f11368b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f11369c;

        /* renamed from: d, reason: collision with root package name */
        public Reader f11370d;

        public b(i.e eVar, Charset charset) {
            this.f11367a = eVar;
            this.f11368b = charset;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f11369c = true;
            Reader reader = this.f11370d;
            if (reader != null) {
                reader.close();
            } else {
                this.f11367a.close();
            }
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i2, int i3) throws IOException {
            if (this.f11369c) {
                throw new IOException("Stream closed");
            }
            Reader reader = this.f11370d;
            if (reader == null) {
                InputStreamReader inputStreamReader = new InputStreamReader(this.f11367a.t(), h.e0.c.a(this.f11367a, this.f11368b));
                this.f11370d = inputStreamReader;
                reader = inputStreamReader;
            }
            return reader.read(cArr, i2, i3);
        }
    }

    private Charset charset() {
        u contentType = contentType();
        return contentType != null ? contentType.a(h.e0.c.j) : h.e0.c.j;
    }

    public static b0 create(@Nullable u uVar, String str) {
        Charset charset = h.e0.c.j;
        if (uVar != null && (charset = uVar.a()) == null) {
            charset = h.e0.c.j;
            uVar = u.b(uVar + "; charset=utf-8");
        }
        i.c cVar = new i.c();
        cVar.a(str, charset);
        return create(uVar, cVar.g(), cVar);
    }

    public final InputStream byteStream() {
        return source().t();
    }

    public final byte[] bytes() throws IOException {
        long contentLength = contentLength();
        if (contentLength > 2147483647L) {
            throw new IOException("Cannot buffer entire body for content length: " + contentLength);
        }
        i.e source = source();
        try {
            byte[] i2 = source.i();
            h.e0.c.a(source);
            if (contentLength == -1 || contentLength == i2.length) {
                return i2;
            }
            throw new IOException("Content-Length (" + contentLength + ") and stream length (" + i2.length + ") disagree");
        } catch (Throwable th) {
            h.e0.c.a(source);
            throw th;
        }
    }

    public final Reader charStream() {
        Reader reader = this.reader;
        if (reader != null) {
            return reader;
        }
        b bVar = new b(source(), charset());
        this.reader = bVar;
        return bVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        h.e0.c.a(source());
    }

    public abstract long contentLength();

    @Nullable
    public abstract u contentType();

    public abstract i.e source();

    public final String string() throws IOException {
        i.e source = source();
        try {
            return source.a(h.e0.c.a(source, charset()));
        } finally {
            h.e0.c.a(source);
        }
    }

    public static b0 create(@Nullable u uVar, byte[] bArr) {
        i.c cVar = new i.c();
        cVar.write(bArr);
        return create(uVar, bArr.length, cVar);
    }

    public static b0 create(@Nullable u uVar, i.f fVar) {
        i.c cVar = new i.c();
        cVar.a(fVar);
        return create(uVar, fVar.size(), cVar);
    }

    public static b0 create(@Nullable u uVar, long j, i.e eVar) {
        if (eVar != null) {
            return new a(uVar, j, eVar);
        }
        throw new NullPointerException("source == null");
    }
}
