package c.c.a.b.f.e;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public final class x7 extends u7 {
    @Override // c.c.a.b.f.e.u7
    public final int a(int i2, byte[] bArr, int i3, int i4) {
        int d2;
        int d3;
        while (i3 < i4 && bArr[i3] >= 0) {
            i3++;
        }
        if (i3 >= i4) {
            return 0;
        }
        while (i3 < i4) {
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            if (b2 < 0) {
                if (b2 < -32) {
                    if (i5 >= i4) {
                        return b2;
                    }
                    if (b2 >= -62) {
                        i3 = i5 + 1;
                        if (bArr[i5] > -65) {
                        }
                    }
                    return -1;
                }
                if (b2 >= -16) {
                    if (i5 >= i4 - 2) {
                        d3 = t7.d(bArr, i5, i4);
                        return d3;
                    }
                    int i6 = i5 + 1;
                    byte b3 = bArr[i5];
                    if (b3 <= -65 && (((b2 << 28) + (b3 + 112)) >> 30) == 0) {
                        int i7 = i6 + 1;
                        if (bArr[i6] <= -65) {
                            i5 = i7 + 1;
                            if (bArr[i7] > -65) {
                            }
                        }
                    }
                    return -1;
                }
                if (i5 >= i4 - 1) {
                    d2 = t7.d(bArr, i5, i4);
                    return d2;
                }
                int i8 = i5 + 1;
                byte b4 = bArr[i5];
                if (b4 <= -65 && ((b2 != -32 || b4 >= -96) && (b2 != -19 || b4 < -96))) {
                    i3 = i8 + 1;
                    if (bArr[i8] > -65) {
                    }
                }
                return -1;
            }
            i3 = i5;
        }
        return 0;
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
            byte b2 = bArr[i2];
            d4 = v7.d(b2);
            if (!d4) {
                break;
            }
            i2++;
            v7.b(b2, cArr, i5);
            i5++;
        }
        int i6 = i5;
        while (i2 < i4) {
            int i7 = i2 + 1;
            byte b3 = bArr[i2];
            d2 = v7.d(b3);
            if (d2) {
                int i8 = i6 + 1;
                v7.b(b3, cArr, i6);
                while (i7 < i4) {
                    byte b4 = bArr[i7];
                    d3 = v7.d(b4);
                    if (!d3) {
                        break;
                    }
                    i7++;
                    v7.b(b4, cArr, i8);
                    i8++;
                }
                i2 = i7;
                i6 = i8;
            } else {
                e2 = v7.e(b3);
                if (!e2) {
                    f2 = v7.f(b3);
                    if (f2) {
                        if (i7 >= i4 - 1) {
                            throw c5.zzh();
                        }
                        int i9 = i7 + 1;
                        v7.b(b3, bArr[i7], bArr[i9], cArr, i6);
                        i2 = i9 + 1;
                        i6++;
                    } else {
                        if (i7 >= i4 - 2) {
                            throw c5.zzh();
                        }
                        int i10 = i7 + 1;
                        byte b5 = bArr[i7];
                        int i11 = i10 + 1;
                        v7.b(b3, b5, bArr[i10], bArr[i11], cArr, i6);
                        i2 = i11 + 1;
                        i6 = i6 + 1 + 1;
                    }
                } else {
                    if (i7 >= i4) {
                        throw c5.zzh();
                    }
                    v7.b(b3, bArr[i7], cArr, i6);
                    i2 = i7 + 1;
                    i6++;
                }
            }
        }
        return new String(cArr, 0, i6);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
    
        return r10 + r0;
     */
    @Override // c.c.a.b.f.e.u7
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int a(java.lang.CharSequence r8, byte[] r9, int r10, int r11) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.b.f.e.x7.a(java.lang.CharSequence, byte[], int, int):int");
    }
}
