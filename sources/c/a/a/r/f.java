package c.a.a.r;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: MarkEnforcingInputStream.java */
/* loaded from: classes.dex */
public class f extends FilterInputStream {

    /* renamed from: a, reason: collision with root package name */
    public int f3459a;

    public f(InputStream inputStream) {
        super(inputStream);
        this.f3459a = Integer.MIN_VALUE;
    }

    public final long a(long j) {
        int i2 = this.f3459a;
        if (i2 == 0) {
            return -1L;
        }
        return (i2 == Integer.MIN_VALUE || j <= ((long) i2)) ? j : i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        int i2 = this.f3459a;
        return i2 == Integer.MIN_VALUE ? super.available() : Math.min(i2, super.available());
    }

    public final void f(long j) {
        int i2 = this.f3459a;
        if (i2 == Integer.MIN_VALUE || j == -1) {
            return;
        }
        this.f3459a = (int) (i2 - j);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i2) {
        super.mark(i2);
        this.f3459a = i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (a(1L) == -1) {
            return -1;
        }
        int read = super.read();
        f(1L);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        super.reset();
        this.f3459a = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        long a2 = a(j);
        if (a2 == -1) {
            return -1L;
        }
        long skip = super.skip(a2);
        f(skip);
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int a2 = (int) a(i3);
        if (a2 == -1) {
            return -1;
        }
        int read = super.read(bArr, i2, a2);
        f(read);
        return read;
    }
}
