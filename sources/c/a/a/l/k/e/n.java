package c.a.a.l.k.e;

import android.util.Log;
import com.shix.shixipc.utilcode.ThreadUtils;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: RecyclableBufferedInputStream.java */
/* loaded from: classes.dex */
public class n extends FilterInputStream {

    /* renamed from: a, reason: collision with root package name */
    public volatile byte[] f3258a;

    /* renamed from: b, reason: collision with root package name */
    public int f3259b;

    /* renamed from: c, reason: collision with root package name */
    public int f3260c;

    /* renamed from: d, reason: collision with root package name */
    public int f3261d;

    /* renamed from: e, reason: collision with root package name */
    public int f3262e;

    /* compiled from: RecyclableBufferedInputStream.java */
    public static class a extends RuntimeException {
        public static final long serialVersionUID = -4338378848813561757L;

        public a(String str) {
            super(str);
        }
    }

    public n(InputStream inputStream, byte[] bArr) {
        super(inputStream);
        this.f3261d = -1;
        if (bArr == null || bArr.length == 0) {
            throw new IllegalArgumentException("buffer is null or empty");
        }
        this.f3258a = bArr;
    }

    public static IOException b() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    public synchronized void a() {
        this.f3260c = this.f3258a.length;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        InputStream inputStream;
        inputStream = ((FilterInputStream) this).in;
        if (this.f3258a == null || inputStream == null) {
            b();
            throw null;
        }
        return (this.f3259b - this.f3262e) + inputStream.available();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f3258a = null;
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i2) {
        this.f3260c = Math.max(this.f3260c, i2);
        this.f3261d = this.f3262e;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        byte[] bArr = this.f3258a;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr == null || inputStream == null) {
            b();
            throw null;
        }
        if (this.f3262e >= this.f3259b && a(inputStream, bArr) == -1) {
            return -1;
        }
        if (bArr != this.f3258a && (bArr = this.f3258a) == null) {
            b();
            throw null;
        }
        if (this.f3259b - this.f3262e <= 0) {
            return -1;
        }
        int i2 = this.f3262e;
        this.f3262e = i2 + 1;
        return bArr[i2] & ThreadUtils.TYPE_SINGLE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        if (this.f3258a == null) {
            throw new IOException("Stream is closed");
        }
        if (-1 == this.f3261d) {
            throw new a("Mark has been invalidated");
        }
        this.f3262e = this.f3261d;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j) throws IOException {
        byte[] bArr = this.f3258a;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr == null) {
            b();
            throw null;
        }
        if (j < 1) {
            return 0L;
        }
        if (inputStream == null) {
            b();
            throw null;
        }
        if (this.f3259b - this.f3262e >= j) {
            this.f3262e = (int) (this.f3262e + j);
            return j;
        }
        long j2 = this.f3259b - this.f3262e;
        this.f3262e = this.f3259b;
        if (this.f3261d == -1 || j > this.f3260c) {
            return j2 + inputStream.skip(j - j2);
        }
        if (a(inputStream, bArr) == -1) {
            return j2;
        }
        long j3 = j - j2;
        if (this.f3259b - this.f3262e >= j3) {
            this.f3262e = (int) (this.f3262e + j3);
            return j;
        }
        long j4 = (j2 + this.f3259b) - this.f3262e;
        this.f3262e = this.f3259b;
        return j4;
    }

    public final int a(InputStream inputStream, byte[] bArr) throws IOException {
        int i2 = this.f3261d;
        if (i2 != -1) {
            int i3 = this.f3262e - i2;
            int i4 = this.f3260c;
            if (i3 < i4) {
                if (i2 == 0 && i4 > bArr.length && this.f3259b == bArr.length) {
                    int length = bArr.length * 2;
                    if (length <= i4) {
                        i4 = length;
                    }
                    if (Log.isLoggable("BufferedIs", 3)) {
                        Log.d("BufferedIs", "allocate buffer of length: " + i4);
                    }
                    byte[] bArr2 = new byte[i4];
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.f3258a = bArr2;
                    bArr = bArr2;
                } else {
                    int i5 = this.f3261d;
                    if (i5 > 0) {
                        System.arraycopy(bArr, i5, bArr, 0, bArr.length - i5);
                    }
                }
                int i6 = this.f3262e - this.f3261d;
                this.f3262e = i6;
                this.f3261d = 0;
                this.f3259b = 0;
                int read = inputStream.read(bArr, i6, bArr.length - i6);
                int i7 = this.f3262e;
                if (read > 0) {
                    i7 += read;
                }
                this.f3259b = i7;
                return read;
            }
        }
        int read2 = inputStream.read(bArr);
        if (read2 > 0) {
            this.f3261d = -1;
            this.f3262e = 0;
            this.f3259b = read2;
        }
        return read2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4;
        int i5;
        byte[] bArr2 = this.f3258a;
        if (bArr2 == null) {
            b();
            throw null;
        }
        if (i3 == 0) {
            return 0;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream != null) {
            if (this.f3262e < this.f3259b) {
                int i6 = this.f3259b - this.f3262e >= i3 ? i3 : this.f3259b - this.f3262e;
                System.arraycopy(bArr2, this.f3262e, bArr, i2, i6);
                this.f3262e += i6;
                if (i6 == i3 || inputStream.available() == 0) {
                    return i6;
                }
                i2 += i6;
                i4 = i3 - i6;
            } else {
                i4 = i3;
            }
            while (true) {
                if (this.f3261d == -1 && i4 >= bArr2.length) {
                    i5 = inputStream.read(bArr, i2, i4);
                    if (i5 == -1) {
                        return i4 != i3 ? i3 - i4 : -1;
                    }
                } else {
                    if (a(inputStream, bArr2) == -1) {
                        return i4 != i3 ? i3 - i4 : -1;
                    }
                    if (bArr2 != this.f3258a && (bArr2 = this.f3258a) == null) {
                        b();
                        throw null;
                    }
                    i5 = this.f3259b - this.f3262e >= i4 ? i4 : this.f3259b - this.f3262e;
                    System.arraycopy(bArr2, this.f3262e, bArr, i2, i5);
                    this.f3262e += i5;
                }
                i4 -= i5;
                if (i4 == 0) {
                    return i3;
                }
                if (inputStream.available() == 0) {
                    return i3 - i4;
                }
                i2 += i5;
            }
        } else {
            b();
            throw null;
        }
    }
}
