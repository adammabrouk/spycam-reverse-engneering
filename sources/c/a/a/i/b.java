package c.a.a.i;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* compiled from: StrictLineReader.java */
/* loaded from: classes.dex */
public class b implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public final InputStream f2974a;

    /* renamed from: b, reason: collision with root package name */
    public final Charset f2975b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f2976c;

    /* renamed from: d, reason: collision with root package name */
    public int f2977d;

    /* renamed from: e, reason: collision with root package name */
    public int f2978e;

    /* compiled from: StrictLineReader.java */
    public class a extends ByteArrayOutputStream {
        public a(int i2) {
            super(i2);
        }

        @Override // java.io.ByteArrayOutputStream
        public String toString() {
            int i2 = ((ByteArrayOutputStream) this).count;
            try {
                return new String(((ByteArrayOutputStream) this).buf, 0, (i2 <= 0 || ((ByteArrayOutputStream) this).buf[i2 + (-1)] != 13) ? ((ByteArrayOutputStream) this).count : i2 - 1, b.this.f2975b.name());
            } catch (UnsupportedEncodingException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    public b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    public boolean b() {
        return this.f2978e == -1;
    }

    public String c() throws IOException {
        int i2;
        int i3;
        synchronized (this.f2974a) {
            if (this.f2976c == null) {
                throw new IOException("LineReader is closed");
            }
            if (this.f2977d >= this.f2978e) {
                a();
            }
            for (int i4 = this.f2977d; i4 != this.f2978e; i4++) {
                if (this.f2976c[i4] == 10) {
                    if (i4 != this.f2977d) {
                        i3 = i4 - 1;
                        if (this.f2976c[i3] == 13) {
                            String str = new String(this.f2976c, this.f2977d, i3 - this.f2977d, this.f2975b.name());
                            this.f2977d = i4 + 1;
                            return str;
                        }
                    }
                    i3 = i4;
                    String str2 = new String(this.f2976c, this.f2977d, i3 - this.f2977d, this.f2975b.name());
                    this.f2977d = i4 + 1;
                    return str2;
                }
            }
            a aVar = new a((this.f2978e - this.f2977d) + 80);
            loop1: while (true) {
                aVar.write(this.f2976c, this.f2977d, this.f2978e - this.f2977d);
                this.f2978e = -1;
                a();
                i2 = this.f2977d;
                while (i2 != this.f2978e) {
                    if (this.f2976c[i2] == 10) {
                        break loop1;
                    }
                    i2++;
                }
            }
            if (i2 != this.f2977d) {
                aVar.write(this.f2976c, this.f2977d, i2 - this.f2977d);
            }
            this.f2977d = i2 + 1;
            return aVar.toString();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.f2974a) {
            if (this.f2976c != null) {
                this.f2976c = null;
                this.f2974a.close();
            }
        }
    }

    public b(InputStream inputStream, int i2, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(c.f2980a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f2974a = inputStream;
        this.f2975b = charset;
        this.f2976c = new byte[i2];
    }

    public final void a() throws IOException {
        InputStream inputStream = this.f2974a;
        byte[] bArr = this.f2976c;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.f2977d = 0;
        this.f2978e = read;
    }
}
