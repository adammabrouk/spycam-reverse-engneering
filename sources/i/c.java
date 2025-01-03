package i;

import androidx.recyclerview.widget.RecyclerView;
import com.google.zxing.view.ViewfinderView;
import com.shix.shixipc.utilcode.ThreadUtils;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

/* compiled from: Buffer.java */
/* loaded from: classes.dex */
public final class c implements e, d, Cloneable, ByteChannel {

    /* renamed from: c, reason: collision with root package name */
    public static final byte[] f11818c = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public o f11819a;

    /* renamed from: b, reason: collision with root package name */
    public long f11820b;

    /* compiled from: Buffer.java */
    public class a extends InputStream {
        public a() {
        }

        @Override // java.io.InputStream
        public int available() {
            return (int) Math.min(c.this.f11820b, 2147483647L);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.InputStream
        public int read() {
            c cVar = c.this;
            if (cVar.f11820b > 0) {
                return cVar.readByte() & ThreadUtils.TYPE_SINGLE;
            }
            return -1;
        }

        public String toString() {
            return c.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i2, int i3) {
            return c.this.a(bArr, i2, i3);
        }
    }

    @Override // i.d
    public /* bridge */ /* synthetic */ d a(f fVar) throws IOException {
        a(fVar);
        return this;
    }

    @Override // i.d
    public /* bridge */ /* synthetic */ d b(long j) throws IOException {
        b(j);
        return this;
    }

    public f c() {
        return new f(i());
    }

    @Override // i.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // i.e, i.d
    public c d() {
        return this;
    }

    @Override // i.e
    public byte[] d(long j) throws EOFException {
        u.a(this.f11820b, 0L, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[(int) j];
            readFully(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
    }

    public String e() {
        try {
            return a(this.f11820b, u.f11858a);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        long j = this.f11820b;
        if (j != cVar.f11820b) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        o oVar = this.f11819a;
        o oVar2 = cVar.f11819a;
        int i2 = oVar.f11846b;
        int i3 = oVar2.f11846b;
        while (j2 < this.f11820b) {
            long min = Math.min(oVar.f11847c - i2, oVar2.f11847c - i3);
            int i4 = 0;
            while (i4 < min) {
                int i5 = i2 + 1;
                int i6 = i3 + 1;
                if (oVar.f11845a[i2] != oVar2.f11845a[i3]) {
                    return false;
                }
                i4++;
                i2 = i5;
                i3 = i6;
            }
            if (i2 == oVar.f11847c) {
                oVar = oVar.f11850f;
                i2 = oVar.f11846b;
            }
            if (i3 == oVar2.f11847c) {
                oVar2 = oVar2.f11850f;
                i3 = oVar2.f11846b;
            }
            j2 += min;
        }
        return true;
    }

    public String f(long j) throws EOFException {
        return a(j, u.f11858a);
    }

    @Override // i.d, i.r, java.io.Flushable
    public void flush() {
    }

    public long g() {
        return this.f11820b;
    }

    @Override // i.e
    public String h() throws EOFException {
        return e(RecyclerView.FOREVER_NS);
    }

    public int hashCode() {
        o oVar = this.f11819a;
        if (oVar == null) {
            return 0;
        }
        int i2 = 1;
        do {
            int i3 = oVar.f11847c;
            for (int i4 = oVar.f11846b; i4 < i3; i4++) {
                i2 = (i2 * 31) + oVar.f11845a[i4];
            }
            oVar = oVar.f11850f;
        } while (oVar != this.f11819a);
        return i2;
    }

    @Override // i.e
    public byte[] i() {
        try {
            return d(this.f11820b);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    @Override // i.e
    public int j() {
        return u.a(readInt());
    }

    @Override // i.e
    public boolean k() {
        return this.f11820b == 0;
    }

    public f l() {
        long j = this.f11820b;
        if (j <= 2147483647L) {
            return a((int) j);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.f11820b);
    }

    @Override // i.e
    public short p() {
        return u.a(readShort());
    }

    @Override // i.d
    public c q() {
        return this;
    }

    @Override // i.d
    public /* bridge */ /* synthetic */ d q() throws IOException {
        q();
        return this;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        o oVar = this.f11819a;
        if (oVar == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), oVar.f11847c - oVar.f11846b);
        byteBuffer.put(oVar.f11845a, oVar.f11846b, min);
        int i2 = oVar.f11846b + min;
        oVar.f11846b = i2;
        this.f11820b -= min;
        if (i2 == oVar.f11847c) {
            this.f11819a = oVar.b();
            p.a(oVar);
        }
        return min;
    }

    @Override // i.e
    public byte readByte() {
        long j = this.f11820b;
        if (j == 0) {
            throw new IllegalStateException("size == 0");
        }
        o oVar = this.f11819a;
        int i2 = oVar.f11846b;
        int i3 = oVar.f11847c;
        int i4 = i2 + 1;
        byte b2 = oVar.f11845a[i2];
        this.f11820b = j - 1;
        if (i4 == i3) {
            this.f11819a = oVar.b();
            p.a(oVar);
        } else {
            oVar.f11846b = i4;
        }
        return b2;
    }

    @Override // i.e
    public void readFully(byte[] bArr) throws EOFException {
        int i2 = 0;
        while (i2 < bArr.length) {
            int a2 = a(bArr, i2, bArr.length - i2);
            if (a2 == -1) {
                throw new EOFException();
            }
            i2 += a2;
        }
    }

    @Override // i.e
    public int readInt() {
        long j = this.f11820b;
        if (j < 4) {
            throw new IllegalStateException("size < 4: " + this.f11820b);
        }
        o oVar = this.f11819a;
        int i2 = oVar.f11846b;
        int i3 = oVar.f11847c;
        if (i3 - i2 < 4) {
            return ((readByte() & ThreadUtils.TYPE_SINGLE) << 24) | ((readByte() & ThreadUtils.TYPE_SINGLE) << 16) | ((readByte() & ThreadUtils.TYPE_SINGLE) << 8) | (readByte() & ThreadUtils.TYPE_SINGLE);
        }
        byte[] bArr = oVar.f11845a;
        int i4 = i2 + 1;
        int i5 = i4 + 1;
        int i6 = ((bArr[i2] & ThreadUtils.TYPE_SINGLE) << 24) | ((bArr[i4] & ThreadUtils.TYPE_SINGLE) << 16);
        int i7 = i5 + 1;
        int i8 = i6 | ((bArr[i5] & ThreadUtils.TYPE_SINGLE) << 8);
        int i9 = i7 + 1;
        int i10 = i8 | (bArr[i7] & ThreadUtils.TYPE_SINGLE);
        this.f11820b = j - 4;
        if (i9 == i3) {
            this.f11819a = oVar.b();
            p.a(oVar);
        } else {
            oVar.f11846b = i9;
        }
        return i10;
    }

    @Override // i.e
    public short readShort() {
        long j = this.f11820b;
        if (j < 2) {
            throw new IllegalStateException("size < 2: " + this.f11820b);
        }
        o oVar = this.f11819a;
        int i2 = oVar.f11846b;
        int i3 = oVar.f11847c;
        if (i3 - i2 < 2) {
            return (short) (((readByte() & ThreadUtils.TYPE_SINGLE) << 8) | (readByte() & ThreadUtils.TYPE_SINGLE));
        }
        byte[] bArr = oVar.f11845a;
        int i4 = i2 + 1;
        int i5 = i4 + 1;
        int i6 = ((bArr[i2] & ThreadUtils.TYPE_SINGLE) << 8) | (bArr[i4] & ThreadUtils.TYPE_SINGLE);
        this.f11820b = j - 2;
        if (i5 == i3) {
            this.f11819a = oVar.b();
            p.a(oVar);
        } else {
            oVar.f11846b = i5;
        }
        return (short) i6;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a3 A[EDGE_INSN: B:41:0x00a3->B:38:0x00a3 BREAK  A[LOOP:0: B:4:0x000b->B:40:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x009b  */
    @Override // i.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long s() {
        /*
            r15 = this;
            long r0 = r15.f11820b
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto Laa
            r0 = 0
            r4 = r2
            r1 = 0
        Lb:
            i.o r6 = r15.f11819a
            byte[] r7 = r6.f11845a
            int r8 = r6.f11846b
            int r9 = r6.f11847c
        L13:
            if (r8 >= r9) goto L8f
            r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L22
            r11 = 57
            if (r10 > r11) goto L22
            int r11 = r10 + (-48)
            goto L3a
        L22:
            r11 = 97
            if (r10 < r11) goto L2f
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L2f
            int r11 = r10 + (-97)
        L2c:
            int r11 = r11 + 10
            goto L3a
        L2f:
            r11 = 65
            if (r10 < r11) goto L70
            r11 = 70
            if (r10 > r11) goto L70
            int r11 = r10 + (-65)
            goto L2c
        L3a:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L4a
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L13
        L4a:
            i.c r0 = new i.c
            r0.<init>()
            r0.b(r4)
            r0.writeByte(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            r2.append(r3)
            java.lang.String r0 = r0.e()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L70:
            if (r0 == 0) goto L74
            r1 = 1
            goto L8f
        L74:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.append(r2)
            java.lang.String r2 = java.lang.Integer.toHexString(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L8f:
            if (r8 != r9) goto L9b
            i.o r7 = r6.b()
            r15.f11819a = r7
            i.p.a(r6)
            goto L9d
        L9b:
            r6.f11846b = r8
        L9d:
            if (r1 != 0) goto La3
            i.o r6 = r15.f11819a
            if (r6 != 0) goto Lb
        La3:
            long r1 = r15.f11820b
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.f11820b = r1
            return r4
        Laa:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "size == 0"
            r0.<init>(r1)
            goto Lb3
        Lb2:
            throw r0
        Lb3:
            goto Lb2
        */
        throw new UnsupportedOperationException("Method not decompiled: i.c.s():long");
    }

    @Override // i.e
    public void skip(long j) throws EOFException {
        while (j > 0) {
            if (this.f11819a == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j, r0.f11847c - r0.f11846b);
            long j2 = min;
            this.f11820b -= j2;
            j -= j2;
            o oVar = this.f11819a;
            int i2 = oVar.f11846b + min;
            oVar.f11846b = i2;
            if (i2 == oVar.f11847c) {
                this.f11819a = oVar.b();
                p.a(oVar);
            }
        }
    }

    @Override // i.e
    public InputStream t() {
        return new a();
    }

    @Override // i.s
    public t timeout() {
        return t.f11854d;
    }

    public String toString() {
        return l().toString();
    }

    @Override // i.d
    public /* bridge */ /* synthetic */ d write(byte[] bArr) throws IOException {
        write(bArr);
        return this;
    }

    @Override // i.d
    public /* bridge */ /* synthetic */ d writeByte(int i2) throws IOException {
        writeByte(i2);
        return this;
    }

    @Override // i.d
    public /* bridge */ /* synthetic */ d writeInt(int i2) throws IOException {
        writeInt(i2);
        return this;
    }

    @Override // i.d
    public /* bridge */ /* synthetic */ d writeShort(int i2) throws IOException {
        writeShort(i2);
        return this;
    }

    @Override // i.d
    public /* bridge */ /* synthetic */ d a(String str) throws IOException {
        a(str);
        return this;
    }

    public long b() {
        long j = this.f11820b;
        if (j == 0) {
            return 0L;
        }
        o oVar = this.f11819a.f11851g;
        return (oVar.f11847c >= 8192 || !oVar.f11849e) ? j : j - (r3 - oVar.f11846b);
    }

    @Override // i.e
    public f c(long j) throws EOFException {
        return new f(d(j));
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public c m603clone() {
        c cVar = new c();
        if (this.f11820b == 0) {
            return cVar;
        }
        o c2 = this.f11819a.c();
        cVar.f11819a = c2;
        c2.f11851g = c2;
        c2.f11850f = c2;
        o oVar = this.f11819a;
        while (true) {
            oVar = oVar.f11850f;
            if (oVar == this.f11819a) {
                cVar.f11820b = this.f11820b;
                return cVar;
            }
            cVar.f11819a.f11851g.a(oVar.c());
        }
    }

    @Override // i.e
    public void g(long j) throws EOFException {
        if (this.f11820b < j) {
            throw new EOFException();
        }
    }

    public String h(long j) throws EOFException {
        if (j > 0) {
            long j2 = j - 1;
            if (a(j2) == 13) {
                String f2 = f(j2);
                skip(2L);
                return f2;
            }
        }
        String f3 = f(j);
        skip(1L);
        return f3;
    }

    @Override // i.d
    public /* bridge */ /* synthetic */ d write(byte[] bArr, int i2, int i3) throws IOException {
        write(bArr, i2, i3);
        return this;
    }

    @Override // i.d
    public c writeByte(int i2) {
        o b2 = b(1);
        byte[] bArr = b2.f11845a;
        int i3 = b2.f11847c;
        b2.f11847c = i3 + 1;
        bArr[i3] = (byte) i2;
        this.f11820b++;
        return this;
    }

    @Override // i.d
    public c writeInt(int i2) {
        o b2 = b(4);
        byte[] bArr = b2.f11845a;
        int i3 = b2.f11847c;
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i2 >>> 24) & ViewfinderView.OPAQUE);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i2 >>> 16) & ViewfinderView.OPAQUE);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((i2 >>> 8) & ViewfinderView.OPAQUE);
        bArr[i6] = (byte) (i2 & ViewfinderView.OPAQUE);
        b2.f11847c = i6 + 1;
        this.f11820b += 4;
        return this;
    }

    @Override // i.d
    public c writeShort(int i2) {
        o b2 = b(2);
        byte[] bArr = b2.f11845a;
        int i3 = b2.f11847c;
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i2 >>> 8) & ViewfinderView.OPAQUE);
        bArr[i4] = (byte) (i2 & ViewfinderView.OPAQUE);
        b2.f11847c = i4 + 1;
        this.f11820b += 2;
        return this;
    }

    public c a(c cVar, long j, long j2) {
        if (cVar != null) {
            u.a(this.f11820b, j, j2);
            if (j2 == 0) {
                return this;
            }
            cVar.f11820b += j2;
            o oVar = this.f11819a;
            while (true) {
                int i2 = oVar.f11847c;
                int i3 = oVar.f11846b;
                if (j < i2 - i3) {
                    break;
                }
                j -= i2 - i3;
                oVar = oVar.f11850f;
            }
            while (j2 > 0) {
                o c2 = oVar.c();
                int i4 = (int) (c2.f11846b + j);
                c2.f11846b = i4;
                c2.f11847c = Math.min(i4 + ((int) j2), c2.f11847c);
                o oVar2 = cVar.f11819a;
                if (oVar2 == null) {
                    c2.f11851g = c2;
                    c2.f11850f = c2;
                    cVar.f11819a = c2;
                } else {
                    oVar2.f11851g.a(c2);
                }
                j2 -= c2.f11847c - c2.f11846b;
                oVar = oVar.f11850f;
                j = 0;
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    public c c(int i2) {
        if (i2 < 128) {
            writeByte(i2);
        } else if (i2 < 2048) {
            writeByte((i2 >> 6) | 192);
            writeByte((i2 & 63) | RecyclerView.c0.FLAG_IGNORE);
        } else if (i2 < 65536) {
            if (i2 >= 55296 && i2 <= 57343) {
                writeByte(63);
            } else {
                writeByte((i2 >> 12) | 224);
                writeByte(((i2 >> 6) & 63) | RecyclerView.c0.FLAG_IGNORE);
                writeByte((i2 & 63) | RecyclerView.c0.FLAG_IGNORE);
            }
        } else if (i2 <= 1114111) {
            writeByte((i2 >> 18) | 240);
            writeByte(((i2 >> 12) & 63) | RecyclerView.c0.FLAG_IGNORE);
            writeByte(((i2 >> 6) & 63) | RecyclerView.c0.FLAG_IGNORE);
            writeByte((i2 & 63) | RecyclerView.c0.FLAG_IGNORE);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i2));
        }
        return this;
    }

    @Override // i.e
    public String e(long j) throws EOFException {
        if (j >= 0) {
            long j2 = RecyclerView.FOREVER_NS;
            if (j != RecyclerView.FOREVER_NS) {
                j2 = j + 1;
            }
            long a2 = a((byte) 10, 0L, j2);
            if (a2 != -1) {
                return h(a2);
            }
            if (j2 < g() && a(j2 - 1) == 13 && a(j2) == 10) {
                return h(j2);
            }
            c cVar = new c();
            a(cVar, 0L, Math.min(32L, g()));
            throw new EOFException("\\n not found: limit=" + Math.min(g(), j) + " content=" + cVar.c().hex() + (char) 8230);
        }
        throw new IllegalArgumentException("limit < 0: " + j);
    }

    @Override // i.d
    public c write(byte[] bArr) {
        if (bArr != null) {
            write(bArr, 0, bArr.length);
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // i.d
    public c write(byte[] bArr, int i2, int i3) {
        if (bArr != null) {
            long j = i3;
            u.a(bArr.length, i2, j);
            int i4 = i3 + i2;
            while (i2 < i4) {
                o b2 = b(1);
                int min = Math.min(i4 - i2, 8192 - b2.f11847c);
                System.arraycopy(bArr, i2, b2.f11845a, b2.f11847c, min);
                i2 += min;
                b2.f11847c += min;
            }
            this.f11820b += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // i.d
    public c b(long j) {
        if (j == 0) {
            writeByte(48);
            return this;
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        o b2 = b(numberOfTrailingZeros);
        byte[] bArr = b2.f11845a;
        int i2 = b2.f11847c;
        for (int i3 = (i2 + numberOfTrailingZeros) - 1; i3 >= i2; i3--) {
            bArr[i3] = f11818c[(int) (15 & j)];
            j >>>= 4;
        }
        b2.f11847c += numberOfTrailingZeros;
        this.f11820b += numberOfTrailingZeros;
        return this;
    }

    @Override // i.s
    public long read(c cVar, long j) {
        if (cVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j >= 0) {
            long j2 = this.f11820b;
            if (j2 == 0) {
                return -1L;
            }
            if (j > j2) {
                j = j2;
            }
            cVar.a(this, j);
            return j;
        }
        throw new IllegalArgumentException("byteCount < 0: " + j);
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer != null) {
            int remaining = byteBuffer.remaining();
            int i2 = remaining;
            while (i2 > 0) {
                o b2 = b(1);
                int min = Math.min(i2, 8192 - b2.f11847c);
                byteBuffer.get(b2.f11845a, b2.f11847c, min);
                i2 -= min;
                b2.f11847c += min;
            }
            this.f11820b += remaining;
            return remaining;
        }
        throw new IllegalArgumentException("source == null");
    }

    public o b(int i2) {
        if (i2 >= 1 && i2 <= 8192) {
            o oVar = this.f11819a;
            if (oVar == null) {
                o a2 = p.a();
                this.f11819a = a2;
                a2.f11851g = a2;
                a2.f11850f = a2;
                return a2;
            }
            o oVar2 = oVar.f11851g;
            if (oVar2.f11847c + i2 <= 8192 && oVar2.f11849e) {
                return oVar2;
            }
            o a3 = p.a();
            oVar2.a(a3);
            return a3;
        }
        throw new IllegalArgumentException();
    }

    public byte a(long j) {
        int i2;
        u.a(this.f11820b, j, 1L);
        long j2 = this.f11820b;
        if (j2 - j > j) {
            o oVar = this.f11819a;
            while (true) {
                int i3 = oVar.f11847c;
                int i4 = oVar.f11846b;
                long j3 = i3 - i4;
                if (j < j3) {
                    return oVar.f11845a[i4 + ((int) j)];
                }
                j -= j3;
                oVar = oVar.f11850f;
            }
        } else {
            long j4 = j - j2;
            o oVar2 = this.f11819a;
            do {
                oVar2 = oVar2.f11851g;
                int i5 = oVar2.f11847c;
                i2 = oVar2.f11846b;
                j4 += i5 - i2;
            } while (j4 < 0);
            return oVar2.f11845a[i2 + ((int) j4)];
        }
    }

    @Override // i.e
    public String a(Charset charset) {
        try {
            return a(this.f11820b, charset);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public String a(long j, Charset charset) throws EOFException {
        u.a(this.f11820b, 0L, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        if (j == 0) {
            return "";
        }
        o oVar = this.f11819a;
        if (oVar.f11846b + j > oVar.f11847c) {
            return new String(d(j), charset);
        }
        String str = new String(oVar.f11845a, oVar.f11846b, (int) j, charset);
        int i2 = (int) (oVar.f11846b + j);
        oVar.f11846b = i2;
        this.f11820b -= j;
        if (i2 == oVar.f11847c) {
            this.f11819a = oVar.b();
            p.a(oVar);
        }
        return str;
    }

    public int a(byte[] bArr, int i2, int i3) {
        u.a(bArr.length, i2, i3);
        o oVar = this.f11819a;
        if (oVar == null) {
            return -1;
        }
        int min = Math.min(i3, oVar.f11847c - oVar.f11846b);
        System.arraycopy(oVar.f11845a, oVar.f11846b, bArr, i2, min);
        int i4 = oVar.f11846b + min;
        oVar.f11846b = i4;
        this.f11820b -= min;
        if (i4 == oVar.f11847c) {
            this.f11819a = oVar.b();
            p.a(oVar);
        }
        return min;
    }

    public void a() {
        try {
            skip(this.f11820b);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // i.d
    public c a(f fVar) {
        if (fVar != null) {
            fVar.write(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    @Override // i.d
    public c a(String str) {
        a(str, 0, str.length());
        return this;
    }

    public c a(String str, int i2, int i3) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("beginIndex < 0: " + i2);
        }
        if (i3 >= i2) {
            if (i3 > str.length()) {
                throw new IllegalArgumentException("endIndex > string.length: " + i3 + " > " + str.length());
            }
            while (i2 < i3) {
                char charAt = str.charAt(i2);
                if (charAt < 128) {
                    o b2 = b(1);
                    byte[] bArr = b2.f11845a;
                    int i4 = b2.f11847c - i2;
                    int min = Math.min(i3, 8192 - i4);
                    int i5 = i2 + 1;
                    bArr[i2 + i4] = (byte) charAt;
                    while (i5 < min) {
                        char charAt2 = str.charAt(i5);
                        if (charAt2 >= 128) {
                            break;
                        }
                        bArr[i5 + i4] = (byte) charAt2;
                        i5++;
                    }
                    int i6 = b2.f11847c;
                    int i7 = (i4 + i5) - i6;
                    b2.f11847c = i6 + i7;
                    this.f11820b += i7;
                    i2 = i5;
                } else {
                    if (charAt < 2048) {
                        writeByte((charAt >> 6) | 192);
                        writeByte((charAt & '?') | RecyclerView.c0.FLAG_IGNORE);
                    } else if (charAt >= 55296 && charAt <= 57343) {
                        int i8 = i2 + 1;
                        char charAt3 = i8 < i3 ? str.charAt(i8) : (char) 0;
                        if (charAt <= 56319 && charAt3 >= 56320 && charAt3 <= 57343) {
                            int i9 = (((charAt & 10239) << 10) | (9215 & charAt3)) + 65536;
                            writeByte((i9 >> 18) | 240);
                            writeByte(((i9 >> 12) & 63) | RecyclerView.c0.FLAG_IGNORE);
                            writeByte(((i9 >> 6) & 63) | RecyclerView.c0.FLAG_IGNORE);
                            writeByte((i9 & 63) | RecyclerView.c0.FLAG_IGNORE);
                            i2 += 2;
                        } else {
                            writeByte(63);
                            i2 = i8;
                        }
                    } else {
                        writeByte((charAt >> '\f') | 224);
                        writeByte(((charAt >> 6) & 63) | RecyclerView.c0.FLAG_IGNORE);
                        writeByte((charAt & '?') | RecyclerView.c0.FLAG_IGNORE);
                    }
                    i2++;
                }
            }
            return this;
        }
        throw new IllegalArgumentException("endIndex < beginIndex: " + i3 + " < " + i2);
    }

    public c a(String str, Charset charset) {
        a(str, 0, str.length(), charset);
        return this;
    }

    public c a(String str, int i2, int i3, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i2 < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i2);
        }
        if (i3 >= i2) {
            if (i3 > str.length()) {
                throw new IllegalArgumentException("endIndex > string.length: " + i3 + " > " + str.length());
            }
            if (charset != null) {
                if (charset.equals(u.f11858a)) {
                    a(str, i2, i3);
                    return this;
                }
                byte[] bytes = str.substring(i2, i3).getBytes(charset);
                write(bytes, 0, bytes.length);
                return this;
            }
            throw new IllegalArgumentException("charset == null");
        }
        throw new IllegalArgumentException("endIndex < beginIndex: " + i3 + " < " + i2);
    }

    @Override // i.d
    public long a(s sVar) throws IOException {
        if (sVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long read = sVar.read(this, 8192L);
            if (read == -1) {
                return j;
            }
            j += read;
        }
    }

    @Override // i.r
    public void a(c cVar, long j) {
        if (cVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (cVar != this) {
            u.a(cVar.f11820b, 0L, j);
            while (j > 0) {
                o oVar = cVar.f11819a;
                if (j < oVar.f11847c - oVar.f11846b) {
                    o oVar2 = this.f11819a;
                    o oVar3 = oVar2 != null ? oVar2.f11851g : null;
                    if (oVar3 != null && oVar3.f11849e) {
                        if ((oVar3.f11847c + j) - (oVar3.f11848d ? 0 : oVar3.f11846b) <= 8192) {
                            cVar.f11819a.a(oVar3, (int) j);
                            cVar.f11820b -= j;
                            this.f11820b += j;
                            return;
                        }
                    }
                    cVar.f11819a = cVar.f11819a.a((int) j);
                }
                o oVar4 = cVar.f11819a;
                long j2 = oVar4.f11847c - oVar4.f11846b;
                cVar.f11819a = oVar4.b();
                o oVar5 = this.f11819a;
                if (oVar5 == null) {
                    this.f11819a = oVar4;
                    oVar4.f11851g = oVar4;
                    oVar4.f11850f = oVar4;
                } else {
                    oVar5.f11851g.a(oVar4);
                    oVar4.a();
                }
                cVar.f11820b -= j2;
                this.f11820b += j2;
                j -= j2;
            }
            return;
        }
        throw new IllegalArgumentException("source == this");
    }

    @Override // i.e
    public long a(byte b2) {
        return a(b2, 0L, RecyclerView.FOREVER_NS);
    }

    public long a(byte b2, long j, long j2) {
        o oVar;
        long j3 = 0;
        if (j >= 0 && j2 >= j) {
            long j4 = this.f11820b;
            if (j2 <= j4) {
                j4 = j2;
            }
            if (j == j4 || (oVar = this.f11819a) == null) {
                return -1L;
            }
            long j5 = this.f11820b;
            if (j5 - j < j) {
                while (j5 > j) {
                    oVar = oVar.f11851g;
                    j5 -= oVar.f11847c - oVar.f11846b;
                }
            } else {
                while (true) {
                    long j6 = (oVar.f11847c - oVar.f11846b) + j3;
                    if (j6 >= j) {
                        break;
                    }
                    oVar = oVar.f11850f;
                    j3 = j6;
                }
                j5 = j3;
            }
            long j7 = j;
            while (j5 < j4) {
                byte[] bArr = oVar.f11845a;
                int min = (int) Math.min(oVar.f11847c, (oVar.f11846b + j4) - j5);
                for (int i2 = (int) ((oVar.f11846b + j7) - j5); i2 < min; i2++) {
                    if (bArr[i2] == b2) {
                        return (i2 - oVar.f11846b) + j5;
                    }
                }
                j5 += oVar.f11847c - oVar.f11846b;
                oVar = oVar.f11850f;
                j7 = j5;
            }
            return -1L;
        }
        throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.f11820b), Long.valueOf(j), Long.valueOf(j2)));
    }

    @Override // i.e
    public boolean a(long j, f fVar) {
        return a(j, fVar, 0, fVar.size());
    }

    public boolean a(long j, f fVar, int i2, int i3) {
        if (j < 0 || i2 < 0 || i3 < 0 || this.f11820b - j < i3 || fVar.size() - i2 < i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (a(i4 + j) != fVar.getByte(i2 + i4)) {
                return false;
            }
        }
        return true;
    }

    public f a(int i2) {
        if (i2 == 0) {
            return f.EMPTY;
        }
        return new q(this, i2);
    }
}
