package com.google.zxing.pdf417.detector;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class Detector {
    public static final int BARCODE_MIN_HEIGHT = 10;
    public static final float MAX_AVG_VARIANCE = 0.42f;
    public static final float MAX_INDIVIDUAL_VARIANCE = 0.8f;
    public static final int MAX_PATTERN_DRIFT = 5;
    public static final int MAX_PIXEL_DRIFT = 3;
    public static final int ROW_STEP = 5;
    public static final int SKIPPED_ROW_COUNT_MAX = 25;
    public static final int[] INDEXES_START_PATTERN = {0, 4, 1, 5};
    public static final int[] INDEXES_STOP_PATTERN = {6, 2, 7, 3};
    public static final int[] START_PATTERN = {8, 1, 1, 1, 1, 1, 1, 3};
    public static final int[] STOP_PATTERN = {7, 1, 1, 3, 1, 1, 1, 2, 1};

    public static void copyToResult(ResultPoint[] resultPointArr, ResultPoint[] resultPointArr2, int[] iArr) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            resultPointArr[iArr[i2]] = resultPointArr2[i2];
        }
    }

    public static PDF417DetectorResult detect(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map, boolean z) throws NotFoundException {
        BitMatrix blackMatrix = binaryBitmap.getBlackMatrix();
        List<ResultPoint[]> detect = detect(z, blackMatrix);
        if (detect.isEmpty()) {
            blackMatrix = blackMatrix.m575clone();
            blackMatrix.rotate180();
            detect = detect(z, blackMatrix);
        }
        return new PDF417DetectorResult(blackMatrix, detect);
    }

    public static int[] findGuardPattern(BitMatrix bitMatrix, int i2, int i3, int i4, boolean z, int[] iArr, int[] iArr2) {
        Arrays.fill(iArr2, 0, iArr2.length, 0);
        int i5 = 0;
        while (bitMatrix.get(i2, i3) && i2 > 0) {
            int i6 = i5 + 1;
            if (i5 >= 3) {
                break;
            }
            i2--;
            i5 = i6;
        }
        int length = iArr.length;
        boolean z2 = z;
        int i7 = 0;
        int i8 = i2;
        while (i2 < i4) {
            if (bitMatrix.get(i2, i3) != z2) {
                iArr2[i7] = iArr2[i7] + 1;
            } else {
                if (i7 != length - 1) {
                    i7++;
                } else {
                    if (patternMatchVariance(iArr2, iArr, 0.8f) < 0.42f) {
                        return new int[]{i8, i2};
                    }
                    i8 += iArr2[0] + iArr2[1];
                    int i9 = i7 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i9);
                    iArr2[i9] = 0;
                    iArr2[i7] = 0;
                    i7--;
                }
                iArr2[i7] = 1;
                z2 = !z2;
            }
            i2++;
        }
        if (i7 != length - 1 || patternMatchVariance(iArr2, iArr, 0.8f) >= 0.42f) {
            return null;
        }
        return new int[]{i8, i2 - 1};
    }

    public static ResultPoint[] findRowsWithPattern(BitMatrix bitMatrix, int i2, int i3, int i4, int i5, int[] iArr) {
        boolean z;
        int i6;
        int i7;
        int i8;
        ResultPoint[] resultPointArr = new ResultPoint[4];
        int[] iArr2 = new int[iArr.length];
        int i9 = i4;
        while (true) {
            if (i9 >= i2) {
                z = false;
                break;
            }
            int[] findGuardPattern = findGuardPattern(bitMatrix, i5, i9, i3, false, iArr, iArr2);
            if (findGuardPattern != null) {
                int i10 = i9;
                int[] iArr3 = findGuardPattern;
                int i11 = i10;
                while (true) {
                    if (i11 > 0) {
                        int i12 = i11 - 1;
                        int[] findGuardPattern2 = findGuardPattern(bitMatrix, i5, i12, i3, false, iArr, iArr2);
                        if (findGuardPattern2 == null) {
                            i8 = i12 + 1;
                            break;
                        }
                        iArr3 = findGuardPattern2;
                        i11 = i12;
                    } else {
                        i8 = i11;
                        break;
                    }
                }
                float f2 = i8;
                resultPointArr[0] = new ResultPoint(iArr3[0], f2);
                resultPointArr[1] = new ResultPoint(iArr3[1], f2);
                i9 = i8;
                z = true;
            } else {
                i9 += 5;
            }
        }
        int i13 = i9 + 1;
        if (z) {
            int[] iArr4 = {(int) resultPointArr[0].getX(), (int) resultPointArr[1].getX()};
            int i14 = i13;
            int i15 = 0;
            while (true) {
                if (i14 >= i2) {
                    i6 = i15;
                    i7 = i14;
                    break;
                }
                i6 = i15;
                i7 = i14;
                int[] findGuardPattern3 = findGuardPattern(bitMatrix, iArr4[0], i14, i3, false, iArr, iArr2);
                if (findGuardPattern3 != null && Math.abs(iArr4[0] - findGuardPattern3[0]) < 5 && Math.abs(iArr4[1] - findGuardPattern3[1]) < 5) {
                    iArr4 = findGuardPattern3;
                    i15 = 0;
                } else {
                    if (i6 > 25) {
                        break;
                    }
                    i15 = i6 + 1;
                }
                i14 = i7 + 1;
            }
            i13 = i7 - (i6 + 1);
            float f3 = i13;
            resultPointArr[2] = new ResultPoint(iArr4[0], f3);
            resultPointArr[3] = new ResultPoint(iArr4[1], f3);
        }
        if (i13 - i9 < 10) {
            Arrays.fill(resultPointArr, (Object) null);
        }
        return resultPointArr;
    }

    public static ResultPoint[] findVertices(BitMatrix bitMatrix, int i2, int i3) {
        int height = bitMatrix.getHeight();
        int width = bitMatrix.getWidth();
        ResultPoint[] resultPointArr = new ResultPoint[8];
        copyToResult(resultPointArr, findRowsWithPattern(bitMatrix, height, width, i2, i3, START_PATTERN), INDEXES_START_PATTERN);
        if (resultPointArr[4] != null) {
            i3 = (int) resultPointArr[4].getX();
            i2 = (int) resultPointArr[4].getY();
        }
        copyToResult(resultPointArr, findRowsWithPattern(bitMatrix, height, width, i2, i3, STOP_PATTERN), INDEXES_STOP_PATTERN);
        return resultPointArr;
    }

    public static float patternMatchVariance(int[] iArr, int[] iArr2, float f2) {
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            i2 += iArr[i4];
            i3 += iArr2[i4];
        }
        if (i2 < i3) {
            return Float.POSITIVE_INFINITY;
        }
        float f3 = i2;
        float f4 = f3 / i3;
        float f5 = f2 * f4;
        float f6 = 0.0f;
        for (int i5 = 0; i5 < length; i5++) {
            float f7 = iArr2[i5] * f4;
            float f8 = iArr[i5];
            float f9 = f8 > f7 ? f8 - f7 : f7 - f8;
            if (f9 > f5) {
                return Float.POSITIVE_INFINITY;
            }
            f6 += f9;
        }
        return f6 / f3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001e, code lost:
    
        if (r5 != false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0021, code lost:
    
        r5 = r0.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0029, code lost:
    
        if (r5.hasNext() != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002e, code lost:
    
        r4 = (com.google.zxing.ResultPoint[]) r5.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0036, code lost:
    
        if (r4[1] == null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0038, code lost:
    
        r3 = (int) java.lang.Math.max(r3, r4[1].getY());
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0046, code lost:
    
        if (r4[3] == null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0048, code lost:
    
        r3 = java.lang.Math.max(r3, (int) r4[3].getY());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<com.google.zxing.ResultPoint[]> detect(boolean r8, com.google.zxing.common.BitMatrix r9) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 1
            r2 = 0
            r3 = 0
        L8:
            r4 = 0
            r5 = 0
        La:
            int r6 = r9.getHeight()
            if (r3 < r6) goto L11
            goto L59
        L11:
            com.google.zxing.ResultPoint[] r4 = findVertices(r9, r3, r4)
            r6 = r4[r2]
            if (r6 != 0) goto L54
            r6 = 3
            r7 = r4[r6]
            if (r7 != 0) goto L54
            if (r5 != 0) goto L21
            goto L59
        L21:
            java.util.Iterator r5 = r0.iterator()
        L25:
            boolean r4 = r5.hasNext()
            if (r4 != 0) goto L2e
            int r3 = r3 + 5
            goto L8
        L2e:
            java.lang.Object r4 = r5.next()
            com.google.zxing.ResultPoint[] r4 = (com.google.zxing.ResultPoint[]) r4
            r7 = r4[r1]
            if (r7 == 0) goto L44
            float r3 = (float) r3
            r7 = r4[r1]
            float r7 = r7.getY()
            float r3 = java.lang.Math.max(r3, r7)
            int r3 = (int) r3
        L44:
            r7 = r4[r6]
            if (r7 == 0) goto L25
            r4 = r4[r6]
            float r4 = r4.getY()
            int r4 = (int) r4
            int r3 = java.lang.Math.max(r3, r4)
            goto L25
        L54:
            r0.add(r4)
            if (r8 != 0) goto L5a
        L59:
            return r0
        L5a:
            r3 = 2
            r5 = r4[r3]
            if (r5 == 0) goto L6d
            r5 = r4[r3]
            float r5 = r5.getX()
            int r5 = (int) r5
            r3 = r4[r3]
            float r3 = r3.getY()
            goto L7b
        L6d:
            r3 = 4
            r5 = r4[r3]
            float r5 = r5.getX()
            int r5 = (int) r5
            r3 = r4[r3]
            float r3 = r3.getY()
        L7b:
            int r3 = (int) r3
            r4 = r5
            r5 = 1
            goto La
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.detector.Detector.detect(boolean, com.google.zxing.common.BitMatrix):java.util.List");
    }
}
