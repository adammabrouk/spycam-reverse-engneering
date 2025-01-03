package i;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

/* compiled from: SegmentedByteString.java */
/* loaded from: classes.dex */
public final class q extends f {
    public final transient int[] directory;
    public final transient byte[][] segments;

    public q(c cVar, int i2) {
        super(null);
        u.a(cVar.f11820b, 0L, i2);
        o oVar = cVar.f11819a;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i2) {
            int i6 = oVar.f11847c;
            int i7 = oVar.f11846b;
            if (i6 == i7) {
                throw new AssertionError("s.limit == s.pos");
            }
            i4 += i6 - i7;
            i5++;
            oVar = oVar.f11850f;
        }
        this.segments = new byte[i5][];
        this.directory = new int[i5 * 2];
        o oVar2 = cVar.f11819a;
        int i8 = 0;
        while (i3 < i2) {
            this.segments[i8] = oVar2.f11845a;
            i3 += oVar2.f11847c - oVar2.f11846b;
            if (i3 > i2) {
                i3 = i2;
            }
            int[] iArr = this.directory;
            iArr[i8] = i3;
            iArr[this.segments.length + i8] = oVar2.f11846b;
            oVar2.f11848d = true;
            i8++;
            oVar2 = oVar2.f11850f;
        }
    }

    private Object writeReplace() {
        return a();
    }

    public final int a(int i2) {
        int binarySearch = Arrays.binarySearch(this.directory, 0, this.segments.length, i2 + 1);
        return binarySearch >= 0 ? binarySearch : binarySearch ^ (-1);
    }

    @Override // i.f
    public ByteBuffer asByteBuffer() {
        return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
    }

    @Override // i.f
    public String base64() {
        return a().base64();
    }

    @Override // i.f
    public String base64Url() {
        return a().base64Url();
    }

    @Override // i.f
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (fVar.size() == size() && rangeEquals(0, fVar, 0, size())) {
                return true;
            }
        }
        return false;
    }

    @Override // i.f
    public byte getByte(int i2) {
        u.a(this.directory[this.segments.length - 1], i2, 1L);
        int a2 = a(i2);
        int i3 = a2 == 0 ? 0 : this.directory[a2 - 1];
        int[] iArr = this.directory;
        byte[][] bArr = this.segments;
        return bArr[a2][(i2 - i3) + iArr[bArr.length + a2]];
    }

    @Override // i.f
    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 != 0) {
            return i2;
        }
        int length = this.segments.length;
        int i3 = 0;
        int i4 = 0;
        int i5 = 1;
        while (i3 < length) {
            byte[] bArr = this.segments[i3];
            int[] iArr = this.directory;
            int i6 = iArr[length + i3];
            int i7 = iArr[i3];
            int i8 = (i7 - i4) + i6;
            while (i6 < i8) {
                i5 = (i5 * 31) + bArr[i6];
                i6++;
            }
            i3++;
            i4 = i7;
        }
        this.hashCode = i5;
        return i5;
    }

    @Override // i.f
    public String hex() {
        return a().hex();
    }

    @Override // i.f
    public f hmacSha1(f fVar) {
        return a().hmacSha1(fVar);
    }

    @Override // i.f
    public f hmacSha256(f fVar) {
        return a().hmacSha256(fVar);
    }

    @Override // i.f
    public int indexOf(byte[] bArr, int i2) {
        return a().indexOf(bArr, i2);
    }

    @Override // i.f
    public byte[] internalArray() {
        return toByteArray();
    }

    @Override // i.f
    public int lastIndexOf(byte[] bArr, int i2) {
        return a().lastIndexOf(bArr, i2);
    }

    @Override // i.f
    public f md5() {
        return a().md5();
    }

    @Override // i.f
    public boolean rangeEquals(int i2, f fVar, int i3, int i4) {
        if (i2 < 0 || i2 > size() - i4) {
            return false;
        }
        int a2 = a(i2);
        while (i4 > 0) {
            int i5 = a2 == 0 ? 0 : this.directory[a2 - 1];
            int min = Math.min(i4, ((this.directory[a2] - i5) + i5) - i2);
            int[] iArr = this.directory;
            byte[][] bArr = this.segments;
            if (!fVar.rangeEquals(i3, bArr[a2], (i2 - i5) + iArr[bArr.length + a2], min)) {
                return false;
            }
            i2 += min;
            i3 += min;
            i4 -= min;
            a2++;
        }
        return true;
    }

    @Override // i.f
    public f sha1() {
        return a().sha1();
    }

    @Override // i.f
    public f sha256() {
        return a().sha256();
    }

    @Override // i.f
    public int size() {
        return this.directory[this.segments.length - 1];
    }

    @Override // i.f
    public String string(Charset charset) {
        return a().string(charset);
    }

    @Override // i.f
    public f substring(int i2) {
        return a().substring(i2);
    }

    @Override // i.f
    public f toAsciiLowercase() {
        return a().toAsciiLowercase();
    }

    @Override // i.f
    public f toAsciiUppercase() {
        return a().toAsciiUppercase();
    }

    @Override // i.f
    public byte[] toByteArray() {
        int[] iArr = this.directory;
        byte[][] bArr = this.segments;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int[] iArr2 = this.directory;
            int i4 = iArr2[length + i2];
            int i5 = iArr2[i2];
            System.arraycopy(this.segments[i2], i4, bArr2, i3, i5 - i3);
            i2++;
            i3 = i5;
        }
        return bArr2;
    }

    @Override // i.f
    public String toString() {
        return a().toString();
    }

    @Override // i.f
    public String utf8() {
        return a().utf8();
    }

    @Override // i.f
    public void write(OutputStream outputStream) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        int length = this.segments.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int[] iArr = this.directory;
            int i4 = iArr[length + i2];
            int i5 = iArr[i2];
            outputStream.write(this.segments[i2], i4, i5 - i3);
            i2++;
            i3 = i5;
        }
    }

    public final f a() {
        return new f(toByteArray());
    }

    @Override // i.f
    public f substring(int i2, int i3) {
        return a().substring(i2, i3);
    }

    @Override // i.f
    public void write(c cVar) {
        int length = this.segments.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int[] iArr = this.directory;
            int i4 = iArr[length + i2];
            int i5 = iArr[i2];
            o oVar = new o(this.segments[i2], i4, (i4 + i5) - i3, true, false);
            o oVar2 = cVar.f11819a;
            if (oVar2 == null) {
                oVar.f11851g = oVar;
                oVar.f11850f = oVar;
                cVar.f11819a = oVar;
            } else {
                oVar2.f11851g.a(oVar);
            }
            i2++;
            i3 = i5;
        }
        cVar.f11820b += i3;
    }

    @Override // i.f
    public boolean rangeEquals(int i2, byte[] bArr, int i3, int i4) {
        if (i2 < 0 || i2 > size() - i4 || i3 < 0 || i3 > bArr.length - i4) {
            return false;
        }
        int a2 = a(i2);
        while (i4 > 0) {
            int i5 = a2 == 0 ? 0 : this.directory[a2 - 1];
            int min = Math.min(i4, ((this.directory[a2] - i5) + i5) - i2);
            int[] iArr = this.directory;
            byte[][] bArr2 = this.segments;
            if (!u.a(bArr2[a2], (i2 - i5) + iArr[bArr2.length + a2], bArr, i3, min)) {
                return false;
            }
            i2 += min;
            i3 += min;
            i4 -= min;
            a2++;
        }
        return true;
    }
}
