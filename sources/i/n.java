package i;

import androidx.recyclerview.widget.RecyclerView;
import com.shix.shixipc.utilcode.ThreadUtils;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* compiled from: RealBufferedSource.java */
/* loaded from: classes.dex */
public final class n implements e {

    /* renamed from: a, reason: collision with root package name */
    public final c f11841a = new c();

    /* renamed from: b, reason: collision with root package name */
    public final s f11842b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f11843c;

    public n(s sVar) {
        if (sVar == null) {
            throw new NullPointerException("source == null");
        }
        this.f11842b = sVar;
    }

    public boolean a(long j) throws IOException {
        c cVar;
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.f11843c) {
            throw new IllegalStateException("closed");
        }
        do {
            cVar = this.f11841a;
            if (cVar.f11820b >= j) {
                return true;
            }
        } while (this.f11842b.read(cVar, 8192L) != -1);
        return false;
    }

    @Override // i.e
    public f c(long j) throws IOException {
        g(j);
        return this.f11841a.c(j);
    }

    @Override // i.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f11843c) {
            return;
        }
        this.f11843c = true;
        this.f11842b.close();
        this.f11841a.a();
    }

    @Override // i.e, i.d
    public c d() {
        return this.f11841a;
    }

    @Override // i.e
    public String e(long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("limit < 0: " + j);
        }
        long j2 = j == RecyclerView.FOREVER_NS ? Long.MAX_VALUE : j + 1;
        long a2 = a((byte) 10, 0L, j2);
        if (a2 != -1) {
            return this.f11841a.h(a2);
        }
        if (j2 < RecyclerView.FOREVER_NS && a(j2) && this.f11841a.a(j2 - 1) == 13 && a(1 + j2) && this.f11841a.a(j2) == 10) {
            return this.f11841a.h(j2);
        }
        c cVar = new c();
        c cVar2 = this.f11841a;
        cVar2.a(cVar, 0L, Math.min(32L, cVar2.g()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.f11841a.g(), j) + " content=" + cVar.c().hex() + (char) 8230);
    }

    @Override // i.e
    public void g(long j) throws IOException {
        if (!a(j)) {
            throw new EOFException();
        }
    }

    @Override // i.e
    public String h() throws IOException {
        return e(RecyclerView.FOREVER_NS);
    }

    @Override // i.e
    public byte[] i() throws IOException {
        this.f11841a.a(this.f11842b);
        return this.f11841a.i();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f11843c;
    }

    @Override // i.e
    public int j() throws IOException {
        g(4L);
        return this.f11841a.j();
    }

    @Override // i.e
    public boolean k() throws IOException {
        if (this.f11843c) {
            throw new IllegalStateException("closed");
        }
        return this.f11841a.k() && this.f11842b.read(this.f11841a, 8192L) == -1;
    }

    @Override // i.e
    public short p() throws IOException {
        g(2L);
        return this.f11841a.p();
    }

    @Override // i.s
    public long read(c cVar, long j) throws IOException {
        if (cVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.f11843c) {
            throw new IllegalStateException("closed");
        }
        c cVar2 = this.f11841a;
        if (cVar2.f11820b == 0 && this.f11842b.read(cVar2, 8192L) == -1) {
            return -1L;
        }
        return this.f11841a.read(cVar, Math.min(j, this.f11841a.f11820b));
    }

    @Override // i.e
    public byte readByte() throws IOException {
        g(1L);
        return this.f11841a.readByte();
    }

    @Override // i.e
    public void readFully(byte[] bArr) throws IOException {
        try {
            g(bArr.length);
            this.f11841a.readFully(bArr);
        } catch (EOFException e2) {
            int i2 = 0;
            while (true) {
                c cVar = this.f11841a;
                long j = cVar.f11820b;
                if (j <= 0) {
                    throw e2;
                }
                int a2 = cVar.a(bArr, i2, (int) j);
                if (a2 == -1) {
                    throw new AssertionError();
                }
                i2 += a2;
            }
        }
    }

    @Override // i.e
    public int readInt() throws IOException {
        g(4L);
        return this.f11841a.readInt();
    }

    @Override // i.e
    public short readShort() throws IOException {
        g(2L);
        return this.f11841a.readShort();
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0032, code lost:
    
        if (r1 == 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0049, code lost:
    
        throw new java.lang.NumberFormatException(java.lang.String.format("Expected leading [0-9a-fA-F] character but was %#x", java.lang.Byte.valueOf(r3)));
     */
    @Override // i.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long s() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 1
            r6.g(r0)
            r0 = 0
            r1 = 0
        L7:
            int r2 = r1 + 1
            long r3 = (long) r2
            boolean r3 = r6.a(r3)
            if (r3 == 0) goto L4a
            i.c r3 = r6.f11841a
            long r4 = (long) r1
            byte r3 = r3.a(r4)
            r4 = 48
            if (r3 < r4) goto L1f
            r4 = 57
            if (r3 <= r4) goto L30
        L1f:
            r4 = 97
            if (r3 < r4) goto L27
            r4 = 102(0x66, float:1.43E-43)
            if (r3 <= r4) goto L30
        L27:
            r4 = 65
            if (r3 < r4) goto L32
            r4 = 70
            if (r3 <= r4) goto L30
            goto L32
        L30:
            r1 = r2
            goto L7
        L32:
            if (r1 == 0) goto L35
            goto L4a
        L35:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Byte r3 = java.lang.Byte.valueOf(r3)
            r2[r0] = r3
            java.lang.String r0 = "Expected leading [0-9a-fA-F] character but was %#x"
            java.lang.String r0 = java.lang.String.format(r0, r2)
            r1.<init>(r0)
            throw r1
        L4a:
            i.c r0 = r6.f11841a
            long r0 = r0.s()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: i.n.s():long");
    }

    @Override // i.e
    public void skip(long j) throws IOException {
        if (this.f11843c) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            c cVar = this.f11841a;
            if (cVar.f11820b == 0 && this.f11842b.read(cVar, 8192L) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j, this.f11841a.g());
            this.f11841a.skip(min);
            j -= min;
        }
    }

    @Override // i.e
    public InputStream t() {
        return new a();
    }

    @Override // i.s
    public t timeout() {
        return this.f11842b.timeout();
    }

    public String toString() {
        return "buffer(" + this.f11842b + ")";
    }

    @Override // i.e
    public byte[] d(long j) throws IOException {
        g(j);
        return this.f11841a.d(j);
    }

    /* compiled from: RealBufferedSource.java */
    public class a extends InputStream {
        public a() {
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            n nVar = n.this;
            if (nVar.f11843c) {
                throw new IOException("closed");
            }
            return (int) Math.min(nVar.f11841a.f11820b, 2147483647L);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            n.this.close();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            n nVar = n.this;
            if (nVar.f11843c) {
                throw new IOException("closed");
            }
            c cVar = nVar.f11841a;
            if (cVar.f11820b == 0 && nVar.f11842b.read(cVar, 8192L) == -1) {
                return -1;
            }
            return n.this.f11841a.readByte() & ThreadUtils.TYPE_SINGLE;
        }

        public String toString() {
            return n.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i2, int i3) throws IOException {
            if (!n.this.f11843c) {
                u.a(bArr.length, i2, i3);
                n nVar = n.this;
                c cVar = nVar.f11841a;
                if (cVar.f11820b == 0 && nVar.f11842b.read(cVar, 8192L) == -1) {
                    return -1;
                }
                return n.this.f11841a.a(bArr, i2, i3);
            }
            throw new IOException("closed");
        }
    }

    @Override // i.e
    public String a(Charset charset) throws IOException {
        if (charset != null) {
            this.f11841a.a(this.f11842b);
            return this.f11841a.a(charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    @Override // i.e
    public long a(byte b2) throws IOException {
        return a(b2, 0L, RecyclerView.FOREVER_NS);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        c cVar = this.f11841a;
        if (cVar.f11820b == 0 && this.f11842b.read(cVar, 8192L) == -1) {
            return -1;
        }
        return this.f11841a.read(byteBuffer);
    }

    public long a(byte b2, long j, long j2) throws IOException {
        if (this.f11843c) {
            throw new IllegalStateException("closed");
        }
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", Long.valueOf(j), Long.valueOf(j2)));
        }
        while (j < j2) {
            long a2 = this.f11841a.a(b2, j, j2);
            if (a2 == -1) {
                c cVar = this.f11841a;
                long j3 = cVar.f11820b;
                if (j3 >= j2 || this.f11842b.read(cVar, 8192L) == -1) {
                    break;
                }
                j = Math.max(j, j3);
            } else {
                return a2;
            }
        }
        return -1L;
    }

    @Override // i.e
    public boolean a(long j, f fVar) throws IOException {
        return a(j, fVar, 0, fVar.size());
    }

    public boolean a(long j, f fVar, int i2, int i3) throws IOException {
        if (!this.f11843c) {
            if (j < 0 || i2 < 0 || i3 < 0 || fVar.size() - i2 < i3) {
                return false;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                long j2 = i4 + j;
                if (!a(1 + j2) || this.f11841a.a(j2) != fVar.getByte(i2 + i4)) {
                    return false;
                }
            }
            return true;
        }
        throw new IllegalStateException("closed");
    }
}
