package com.google.zxing.oned.rss;

/* loaded from: classes.dex */
public final class RSSUtils {
    public static int combins(int i2, int i3) {
        int i4 = i2 - i3;
        if (i4 > i3) {
            i4 = i3;
            i3 = i4;
        }
        int i5 = 1;
        int i6 = 1;
        while (i2 > i3) {
            i5 *= i2;
            if (i6 <= i4) {
                i5 /= i6;
                i6++;
            }
            i2--;
        }
        while (i6 <= i4) {
            i5 /= i6;
            i6++;
        }
        return i5;
    }

    public static int getRSSvalue(int[] iArr, int i2, boolean z) {
        int i3;
        int i4 = 0;
        for (int i5 : iArr) {
            i4 += i5;
        }
        int length = iArr.length;
        int i6 = i4;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (true) {
            int i10 = length - 1;
            if (i9 >= i10) {
                return i8;
            }
            int i11 = 1 << i9;
            i7 |= i11;
            int i12 = 1;
            while (i12 < iArr[i9]) {
                int i13 = i6 - i12;
                int i14 = length - i9;
                int i15 = i14 - 2;
                int combins = combins(i13 - 1, i15);
                if (z && i7 == 0) {
                    int i16 = i14 - 1;
                    if (i13 - i16 >= i16) {
                        combins -= combins(i13 - i14, i15);
                    }
                }
                if (i14 - 1 > 1) {
                    int i17 = i13 - i15;
                    int i18 = 0;
                    while (i17 > i2) {
                        i18 += combins((i13 - i17) - 1, i14 - 3);
                        i17--;
                        length = length;
                    }
                    combins -= i18 * (i10 - i9);
                    i3 = length;
                } else {
                    i3 = length;
                    if (i13 > i2) {
                        combins--;
                    }
                }
                i8 += combins;
                i12++;
                i7 &= i11 ^ (-1);
                length = i3;
            }
            i6 -= i12;
            i9++;
        }
    }
}
