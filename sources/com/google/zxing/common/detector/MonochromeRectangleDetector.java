package com.google.zxing.common.detector;

import androidx.recyclerview.widget.RecyclerView;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;

@Deprecated
/* loaded from: classes.dex */
public final class MonochromeRectangleDetector {
    public static final int MAX_MODULES = 32;
    public final BitMatrix image;

    public MonochromeRectangleDetector(BitMatrix bitMatrix) {
        this.image = bitMatrix;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0069 A[EDGE_INSN: B:67:0x0069->B:47:0x0069 BREAK  A[LOOP:3: B:39:0x0055->B:61:0x0055], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0032 A[EDGE_INSN: B:81:0x0032->B:21:0x0032 BREAK  A[LOOP:1: B:13:0x001d->B:75:0x001d], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int[] blackWhiteRange(int r6, int r7, int r8, int r9, boolean r10) {
        /*
            r5 = this;
            int r0 = r8 + r9
            r1 = 2
            int r0 = r0 / r1
            r2 = r0
        L5:
            if (r2 >= r8) goto L8
            goto L3b
        L8:
            com.google.zxing.common.BitMatrix r3 = r5.image
            if (r10 == 0) goto L13
            boolean r3 = r3.get(r2, r6)
            if (r3 == 0) goto L1c
            goto L19
        L13:
            boolean r3 = r3.get(r6, r2)
            if (r3 == 0) goto L1c
        L19:
            int r2 = r2 + (-1)
            goto L5
        L1c:
            r3 = r2
        L1d:
            int r3 = r3 + (-1)
            if (r3 < r8) goto L32
            com.google.zxing.common.BitMatrix r4 = r5.image
            if (r10 == 0) goto L2c
            boolean r4 = r4.get(r3, r6)
            if (r4 == 0) goto L1d
            goto L32
        L2c:
            boolean r4 = r4.get(r6, r3)
            if (r4 == 0) goto L1d
        L32:
            int r4 = r2 - r3
            if (r3 < r8) goto L3b
            if (r4 <= r7) goto L39
            goto L3b
        L39:
            r2 = r3
            goto L5
        L3b:
            r8 = 1
            int r2 = r2 + r8
        L3d:
            if (r0 < r9) goto L40
            goto L72
        L40:
            com.google.zxing.common.BitMatrix r3 = r5.image
            if (r10 == 0) goto L4b
            boolean r3 = r3.get(r0, r6)
            if (r3 == 0) goto L54
            goto L51
        L4b:
            boolean r3 = r3.get(r6, r0)
            if (r3 == 0) goto L54
        L51:
            int r0 = r0 + 1
            goto L3d
        L54:
            r3 = r0
        L55:
            int r3 = r3 + r8
            if (r3 >= r9) goto L69
            com.google.zxing.common.BitMatrix r4 = r5.image
            if (r10 == 0) goto L63
            boolean r4 = r4.get(r3, r6)
            if (r4 == 0) goto L55
            goto L69
        L63:
            boolean r4 = r4.get(r6, r3)
            if (r4 == 0) goto L55
        L69:
            int r4 = r3 - r0
            if (r3 >= r9) goto L72
            if (r4 <= r7) goto L70
            goto L72
        L70:
            r0 = r3
            goto L3d
        L72:
            int r0 = r0 + (-1)
            if (r0 <= r2) goto L7e
            int[] r6 = new int[r1]
            r7 = 0
            r6[r7] = r2
            r6[r8] = r0
            goto L7f
        L7e:
            r6 = 0
        L7f:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.common.detector.MonochromeRectangleDetector.blackWhiteRange(int, int, int, int, boolean):int[]");
    }

    private ResultPoint findCornerFromCenter(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) throws NotFoundException {
        int[] iArr = null;
        int i11 = i2;
        int i12 = i6;
        while (i12 < i9 && i12 >= i8 && i11 < i5 && i11 >= i4) {
            int[] blackWhiteRange = i3 == 0 ? blackWhiteRange(i12, i10, i4, i5, true) : blackWhiteRange(i11, i10, i8, i9, false);
            if (blackWhiteRange == null) {
                if (iArr == null) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (i3 == 0) {
                    int i13 = i12 - i7;
                    if (iArr[0] >= i2) {
                        return new ResultPoint(iArr[1], i13);
                    }
                    if (iArr[1] > i2) {
                        return new ResultPoint(iArr[i7 > 0 ? (char) 0 : (char) 1], i13);
                    }
                    return new ResultPoint(iArr[0], i13);
                }
                int i14 = i11 - i3;
                if (iArr[0] >= i6) {
                    return new ResultPoint(i14, iArr[1]);
                }
                if (iArr[1] > i6) {
                    return new ResultPoint(i14, iArr[i3 < 0 ? (char) 0 : (char) 1]);
                }
                return new ResultPoint(i14, iArr[0]);
            }
            i12 += i7;
            i11 += i3;
            iArr = blackWhiteRange;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public ResultPoint[] detect() throws NotFoundException {
        int height = this.image.getHeight();
        int width = this.image.getWidth();
        int i2 = height / 2;
        int i3 = width / 2;
        int max = Math.max(1, height / RecyclerView.c0.FLAG_TMP_DETACHED);
        int max2 = Math.max(1, width / RecyclerView.c0.FLAG_TMP_DETACHED);
        int i4 = -max;
        int i5 = i3 / 2;
        int y = ((int) findCornerFromCenter(i3, 0, 0, width, i2, i4, 0, height, i5).getY()) - 1;
        int i6 = i2 / 2;
        ResultPoint findCornerFromCenter = findCornerFromCenter(i3, -max2, 0, width, i2, 0, y, height, i6);
        int x = ((int) findCornerFromCenter.getX()) - 1;
        ResultPoint findCornerFromCenter2 = findCornerFromCenter(i3, max2, x, width, i2, 0, y, height, i6);
        int x2 = ((int) findCornerFromCenter2.getX()) + 1;
        ResultPoint findCornerFromCenter3 = findCornerFromCenter(i3, 0, x, x2, i2, max, y, height, i5);
        return new ResultPoint[]{findCornerFromCenter(i3, 0, x, x2, i2, i4, y, ((int) findCornerFromCenter3.getY()) + 1, i3 / 4), findCornerFromCenter, findCornerFromCenter2, findCornerFromCenter3};
    }
}
