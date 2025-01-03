package c.a.a.r;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ContentLengthInputStream.java */
/* loaded from: classes.dex */
public final class b extends FilterInputStream {

    /* renamed from: a, reason: collision with root package name */
    public final long f3450a;

    /* renamed from: b, reason: collision with root package name */
    public int f3451b;

    public b(InputStream inputStream, long j) {
        super(inputStream);
        this.f3450a = j;
    }

    public static InputStream a(InputStream inputStream, long j) {
        return new b(inputStream, j);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        return (int) Math.max(this.f3450a - this.f3451b, ((FilterInputStream) this).in.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        int read;
        read = super.read();
        a(read);
        return read;
    }

    public final int a(int i2) throws IOException {
        if (i2 >= 0) {
            this.f3451b += i2;
        } else if (this.f3450a - this.f3451b > 0) {
            throw new IOException("Failed to read all expected data, expected: " + this.f3450a + ", but read: " + this.f3451b);
        }
        return i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i2, int i3) throws IOException {
        int read;
        read = super.read(bArr, i2, i3);
        a(read);
        return read;
    }
}
