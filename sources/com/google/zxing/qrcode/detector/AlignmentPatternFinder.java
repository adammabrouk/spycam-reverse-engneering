package com.google.zxing.qrcode.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class AlignmentPatternFinder {
    public final int height;
    public final BitMatrix image;
    public final float moduleSize;
    public final ResultPointCallback resultPointCallback;
    public final int startX;
    public final int startY;
    public final int width;
    public final List<AlignmentPattern> possibleCenters = new ArrayList(5);
    public final int[] crossCheckStateCount = new int[3];

    public AlignmentPatternFinder(BitMatrix bitMatrix, int i2, int i3, int i4, int i5, float f2, ResultPointCallback resultPointCallback) {
        this.image = bitMatrix;
        this.startX = i2;
        this.startY = i3;
        this.width = i4;
        this.height = i5;
        this.moduleSize = f2;
        this.resultPointCallback = resultPointCallback;
    }

    public static float centerFromEnd(int[] iArr, int i2) {
        return (i2 - iArr[2]) - (iArr[1] / 2.0f);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0065, code lost:
    
        if (r2[1] <= r12) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0068, code lost:
    
        if (r10 >= r1) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x006e, code lost:
    
        if (r0.get(r11, r10) != false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0072, code lost:
    
        if (r2[2] <= r12) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0075, code lost:
    
        r2[2] = r2[2] + 1;
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x007f, code lost:
    
        if (r2[2] <= r12) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0081, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0093, code lost:
    
        if ((java.lang.Math.abs(((r2[0] + r2[1]) + r2[2]) - r13) * 5) < (r13 * 2)) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0095, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x009a, code lost:
    
        if (foundPatternCross(r2) == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a0, code lost:
    
        return centerFromEnd(r2, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:?, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:?, code lost:
    
        return Float.NaN;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private float crossCheckVertical(int r10, int r11, int r12, int r13) {
        /*
            r9 = this;
            com.google.zxing.common.BitMatrix r0 = r9.image
            int r1 = r0.getHeight()
            int[] r2 = r9.crossCheckStateCount
            r3 = 0
            r2[r3] = r3
            r4 = 1
            r2[r4] = r3
            r5 = 2
            r2[r5] = r3
            r6 = r10
        L12:
            if (r6 < 0) goto L27
            boolean r7 = r0.get(r11, r6)
            if (r7 == 0) goto L27
            r7 = r2[r4]
            if (r7 <= r12) goto L1f
            goto L27
        L1f:
            r7 = r2[r4]
            int r7 = r7 + r4
            r2[r4] = r7
            int r6 = r6 + (-1)
            goto L12
        L27:
            r7 = 2143289344(0x7fc00000, float:NaN)
            if (r6 < 0) goto La0
            r8 = r2[r4]
            if (r8 <= r12) goto L31
            goto La0
        L31:
            if (r6 < 0) goto L46
            boolean r8 = r0.get(r11, r6)
            if (r8 != 0) goto L46
            r8 = r2[r3]
            if (r8 <= r12) goto L3e
            goto L46
        L3e:
            r8 = r2[r3]
            int r8 = r8 + r4
            r2[r3] = r8
            int r6 = r6 + (-1)
            goto L31
        L46:
            r6 = r2[r3]
            if (r6 <= r12) goto L4b
            return r7
        L4b:
            int r10 = r10 + r4
        L4c:
            if (r10 >= r1) goto L61
            boolean r6 = r0.get(r11, r10)
            if (r6 == 0) goto L61
            r6 = r2[r4]
            if (r6 <= r12) goto L59
            goto L61
        L59:
            r6 = r2[r4]
            int r6 = r6 + r4
            r2[r4] = r6
            int r10 = r10 + 1
            goto L4c
        L61:
            if (r10 == r1) goto La0
            r6 = r2[r4]
            if (r6 <= r12) goto L68
            goto La0
        L68:
            if (r10 >= r1) goto L7d
            boolean r6 = r0.get(r11, r10)
            if (r6 != 0) goto L7d
            r6 = r2[r5]
            if (r6 <= r12) goto L75
            goto L7d
        L75:
            r6 = r2[r5]
            int r6 = r6 + r4
            r2[r5] = r6
            int r10 = r10 + 1
            goto L68
        L7d:
            r11 = r2[r5]
            if (r11 <= r12) goto L82
            return r7
        L82:
            r11 = r2[r3]
            r12 = r2[r4]
            int r11 = r11 + r12
            r12 = r2[r5]
            int r11 = r11 + r12
            int r11 = r11 - r13
            int r11 = java.lang.Math.abs(r11)
            int r11 = r11 * 5
            int r13 = r13 * 2
            if (r11 < r13) goto L96
            return r7
        L96:
            boolean r11 = r9.foundPatternCross(r2)
            if (r11 == 0) goto La0
            float r7 = centerFromEnd(r2, r10)
        La0:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.detector.AlignmentPatternFinder.crossCheckVertical(int, int, int, int):float");
    }

    private boolean foundPatternCross(int[] iArr) {
        float f2 = this.moduleSize;
        float f3 = f2 / 2.0f;
        for (int i2 = 0; i2 < 3; i2++) {
            if (Math.abs(f2 - iArr[i2]) >= f3) {
                return false;
            }
        }
        return true;
    }

    private AlignmentPattern handlePossibleCenter(int[] iArr, int i2, int i3) {
        int i4 = iArr[0] + iArr[1] + iArr[2];
        float centerFromEnd = centerFromEnd(iArr, i3);
        float crossCheckVertical = crossCheckVertical(i2, (int) centerFromEnd, iArr[1] * 2, i4);
        if (Float.isNaN(crossCheckVertical)) {
            return null;
        }
        float f2 = ((iArr[0] + iArr[1]) + iArr[2]) / 3.0f;
        for (AlignmentPattern alignmentPattern : this.possibleCenters) {
            if (alignmentPattern.aboutEquals(f2, crossCheckVertical, centerFromEnd)) {
                return alignmentPattern.combineEstimate(crossCheckVertical, centerFromEnd, f2);
            }
        }
        AlignmentPattern alignmentPattern2 = new AlignmentPattern(centerFromEnd, crossCheckVertical, f2);
        this.possibleCenters.add(alignmentPattern2);
        ResultPointCallback resultPointCallback = this.resultPointCallback;
        if (resultPointCallback == null) {
            return null;
        }
        resultPointCallback.foundPossibleResultPoint(alignmentPattern2);
        return null;
    }

    public AlignmentPattern find() throws NotFoundException {
        AlignmentPattern handlePossibleCenter;
        AlignmentPattern handlePossibleCenter2;
        int i2 = this.startX;
        int i3 = this.height;
        int i4 = this.width + i2;
        int i5 = this.startY + (i3 / 2);
        int[] iArr = new int[3];
        for (int i6 = 0; i6 < i3; i6++) {
            int i7 = ((i6 & 1) == 0 ? (i6 + 1) / 2 : -((i6 + 1) / 2)) + i5;
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            int i8 = i2;
            while (i8 < i4 && !this.image.get(i8, i7)) {
                i8++;
            }
            int i9 = 0;
            while (i8 < i4) {
                if (!this.image.get(i8, i7)) {
                    if (i9 == 1) {
                        i9++;
                    }
                    iArr[i9] = iArr[i9] + 1;
                } else if (i9 == 1) {
                    iArr[1] = iArr[1] + 1;
                } else if (i9 != 2) {
                    i9++;
                    iArr[i9] = iArr[i9] + 1;
                } else {
                    if (foundPatternCross(iArr) && (handlePossibleCenter2 = handlePossibleCenter(iArr, i7, i8)) != null) {
                        return handlePossibleCenter2;
                    }
                    iArr[0] = iArr[2];
                    iArr[1] = 1;
                    iArr[2] = 0;
                    i9 = 1;
                }
                i8++;
            }
            if (foundPatternCross(iArr) && (handlePossibleCenter = handlePossibleCenter(iArr, i7, i4)) != null) {
                return handlePossibleCenter;
            }
        }
        if (this.possibleCenters.isEmpty()) {
            throw NotFoundException.getNotFoundInstance();
        }
        return this.possibleCenters.get(0);
    }
}
