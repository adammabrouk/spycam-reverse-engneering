package c.c.a.b.f.e;

import androidx.recyclerview.widget.RecyclerView;
import com.google.zxing.camera.CameraManager;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public final class z7 extends u7 {
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00b6, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0061, code lost:
    
        return -1;
     */
    @Override // c.c.a.b.f.e.u7
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int a(int r16, byte[] r17, int r18, int r19) {
        /*
            Method dump skipped, instructions count: 219
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.b.f.e.z7.a(int, byte[], int, int):int");
    }

    @Override // c.c.a.b.f.e.u7
    public final String b(byte[] bArr, int i2, int i3) throws c5 {
        boolean d2;
        boolean d3;
        boolean e2;
        boolean f2;
        boolean d4;
        if ((i2 | i3 | ((bArr.length - i2) - i3)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)));
        }
        int i4 = i2 + i3;
        char[] cArr = new char[i3];
        int i5 = 0;
        while (i2 < i4) {
            byte a2 = q7.a(bArr, i2);
            d4 = v7.d(a2);
            if (!d4) {
                break;
            }
            i2++;
            v7.b(a2, cArr, i5);
            i5++;
        }
        int i6 = i5;
        while (i2 < i4) {
            int i7 = i2 + 1;
            byte a3 = q7.a(bArr, i2);
            d2 = v7.d(a3);
            if (d2) {
                int i8 = i6 + 1;
                v7.b(a3, cArr, i6);
                while (i7 < i4) {
                    byte a4 = q7.a(bArr, i7);
                    d3 = v7.d(a4);
                    if (!d3) {
                        break;
                    }
                    i7++;
                    v7.b(a4, cArr, i8);
                    i8++;
                }
                i2 = i7;
                i6 = i8;
            } else {
                e2 = v7.e(a3);
                if (!e2) {
                    f2 = v7.f(a3);
                    if (f2) {
                        if (i7 >= i4 - 1) {
                            throw c5.zzh();
                        }
                        int i9 = i7 + 1;
                        v7.b(a3, q7.a(bArr, i7), q7.a(bArr, i9), cArr, i6);
                        i2 = i9 + 1;
                        i6++;
                    } else {
                        if (i7 >= i4 - 2) {
                            throw c5.zzh();
                        }
                        int i10 = i7 + 1;
                        byte a5 = q7.a(bArr, i7);
                        int i11 = i10 + 1;
                        v7.b(a3, a5, q7.a(bArr, i10), q7.a(bArr, i11), cArr, i6);
                        i2 = i11 + 1;
                        i6 = i6 + 1 + 1;
                    }
                } else {
                    if (i7 >= i4) {
                        throw c5.zzh();
                    }
                    v7.b(a3, q7.a(bArr, i7), cArr, i6);
                    i2 = i7 + 1;
                    i6++;
                }
            }
        }
        return new String(cArr, 0, i6);
    }

    @Override // c.c.a.b.f.e.u7
    public final int a(CharSequence charSequence, byte[] bArr, int i2, int i3) {
        char c2;
        long j;
        long j2;
        long j3;
        int i4;
        char charAt;
        long j4 = i2;
        long j5 = i3 + j4;
        int length = charSequence.length();
        if (length > i3 || bArr.length - i3 < i2) {
            char charAt2 = charSequence.charAt(length - 1);
            StringBuilder sb = new StringBuilder(37);
            sb.append("Failed writing ");
            sb.append(charAt2);
            sb.append(" at index ");
            sb.append(i2 + i3);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        int i5 = 0;
        while (true) {
            c2 = 128;
            j = 1;
            if (i5 >= length || (charAt = charSequence.charAt(i5)) >= 128) {
                break;
            }
            q7.a(bArr, j4, (byte) charAt);
            i5++;
            j4 = 1 + j4;
        }
        if (i5 == length) {
            return (int) j4;
        }
        while (i5 < length) {
            char charAt3 = charSequence.charAt(i5);
            if (charAt3 >= c2 || j4 >= j5) {
                if (charAt3 < 2048 && j4 <= j5 - 2) {
                    long j6 = j4 + j;
                    q7.a(bArr, j4, (byte) ((charAt3 >>> 6) | 960));
                    q7.a(bArr, j6, (byte) ((charAt3 & '?') | RecyclerView.c0.FLAG_IGNORE));
                    j2 = j6 + j;
                    j3 = j;
                } else {
                    if ((charAt3 >= 55296 && 57343 >= charAt3) || j4 > j5 - 3) {
                        if (j4 <= j5 - 4) {
                            int i6 = i5 + 1;
                            if (i6 != length) {
                                char charAt4 = charSequence.charAt(i6);
                                if (Character.isSurrogatePair(charAt3, charAt4)) {
                                    int codePoint = Character.toCodePoint(charAt3, charAt4);
                                    long j7 = j4 + 1;
                                    q7.a(bArr, j4, (byte) ((codePoint >>> 18) | 240));
                                    long j8 = j7 + 1;
                                    q7.a(bArr, j7, (byte) (((codePoint >>> 12) & 63) | RecyclerView.c0.FLAG_IGNORE));
                                    long j9 = j8 + 1;
                                    q7.a(bArr, j8, (byte) (((codePoint >>> 6) & 63) | RecyclerView.c0.FLAG_IGNORE));
                                    j3 = 1;
                                    j2 = j9 + 1;
                                    q7.a(bArr, j9, (byte) ((codePoint & 63) | RecyclerView.c0.FLAG_IGNORE));
                                    i5 = i6;
                                } else {
                                    i5 = i6;
                                }
                            }
                            throw new w7(i5 - 1, length);
                        }
                        if (55296 <= charAt3 && charAt3 <= 57343 && ((i4 = i5 + 1) == length || !Character.isSurrogatePair(charAt3, charSequence.charAt(i4)))) {
                            throw new w7(i5, length);
                        }
                        StringBuilder sb2 = new StringBuilder(46);
                        sb2.append("Failed writing ");
                        sb2.append(charAt3);
                        sb2.append(" at index ");
                        sb2.append(j4);
                        throw new ArrayIndexOutOfBoundsException(sb2.toString());
                    }
                    long j10 = j4 + j;
                    q7.a(bArr, j4, (byte) ((charAt3 >>> '\f') | CameraManager.MAX_FRAME_WIDTH));
                    long j11 = j10 + j;
                    q7.a(bArr, j10, (byte) (((charAt3 >>> 6) & 63) | RecyclerView.c0.FLAG_IGNORE));
                    q7.a(bArr, j11, (byte) ((charAt3 & '?') | RecyclerView.c0.FLAG_IGNORE));
                    j2 = j11 + 1;
                    j3 = 1;
                }
                i5++;
                c2 = 128;
                long j12 = j3;
                j4 = j2;
                j = j12;
            } else {
                long j13 = j4 + j;
                q7.a(bArr, j4, (byte) charAt3);
                j3 = j;
                j2 = j13;
            }
            i5++;
            c2 = 128;
            long j122 = j3;
            j4 = j2;
            j = j122;
        }
        return (int) j4;
    }

    public static int a(byte[] bArr, int i2, long j, int i3) {
        int b2;
        int b3;
        int b4;
        if (i3 == 0) {
            b2 = t7.b(i2);
            return b2;
        }
        if (i3 == 1) {
            b3 = t7.b(i2, q7.a(bArr, j));
            return b3;
        }
        if (i3 == 2) {
            b4 = t7.b(i2, q7.a(bArr, j), q7.a(bArr, j + 1));
            return b4;
        }
        throw new AssertionError();
    }
}
