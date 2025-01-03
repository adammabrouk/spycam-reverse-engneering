package com.google.zxing.common;

import com.google.zxing.NotFoundException;

/* loaded from: classes.dex */
public abstract class GridSampler {
    public static GridSampler gridSampler = new DefaultGridSampler();

    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void checkAndNudgePoints(com.google.zxing.common.BitMatrix r10, float[] r11) throws com.google.zxing.NotFoundException {
        /*
            int r0 = r10.getWidth()
            int r10 = r10.getHeight()
            int r1 = r11.length
            r2 = 1
            int r1 = r1 - r2
            r3 = 0
            r4 = 0
            r5 = 1
        Le:
            r6 = 0
            r7 = -1
            if (r4 >= r1) goto L4a
            if (r5 != 0) goto L15
            goto L4a
        L15:
            r5 = r11[r4]
            int r5 = (int) r5
            int r8 = r4 + 1
            r9 = r11[r8]
            int r9 = (int) r9
            if (r5 < r7) goto L45
            if (r5 > r0) goto L45
            if (r9 < r7) goto L45
            if (r9 > r10) goto L45
            if (r5 != r7) goto L2b
            r11[r4] = r6
        L29:
            r5 = 1
            goto L34
        L2b:
            if (r5 != r0) goto L33
            int r5 = r0 + (-1)
            float r5 = (float) r5
            r11[r4] = r5
            goto L29
        L33:
            r5 = 0
        L34:
            if (r9 != r7) goto L3a
            r11[r8] = r6
        L38:
            r5 = 1
            goto L42
        L3a:
            if (r9 != r10) goto L42
            int r5 = r10 + (-1)
            float r5 = (float) r5
            r11[r8] = r5
            goto L38
        L42:
            int r4 = r4 + 2
            goto Le
        L45:
            com.google.zxing.NotFoundException r10 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r10
        L4a:
            int r1 = r11.length
            int r1 = r1 + (-2)
            r4 = 1
        L4e:
            if (r1 < 0) goto L88
            if (r4 != 0) goto L53
            goto L88
        L53:
            r4 = r11[r1]
            int r4 = (int) r4
            int r5 = r1 + 1
            r8 = r11[r5]
            int r8 = (int) r8
            if (r4 < r7) goto L83
            if (r4 > r0) goto L83
            if (r8 < r7) goto L83
            if (r8 > r10) goto L83
            if (r4 != r7) goto L69
            r11[r1] = r6
        L67:
            r4 = 1
            goto L72
        L69:
            if (r4 != r0) goto L71
            int r4 = r0 + (-1)
            float r4 = (float) r4
            r11[r1] = r4
            goto L67
        L71:
            r4 = 0
        L72:
            if (r8 != r7) goto L78
            r11[r5] = r6
        L76:
            r4 = 1
            goto L80
        L78:
            if (r8 != r10) goto L80
            int r4 = r10 + (-1)
            float r4 = (float) r4
            r11[r5] = r4
            goto L76
        L80:
            int r1 = r1 + (-2)
            goto L4e
        L83:
            com.google.zxing.NotFoundException r10 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r10
        L88:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.common.GridSampler.checkAndNudgePoints(com.google.zxing.common.BitMatrix, float[]):void");
    }

    public static GridSampler getInstance() {
        return gridSampler;
    }

    public static void setGridSampler(GridSampler gridSampler2) {
        gridSampler = gridSampler2;
    }

    public abstract BitMatrix sampleGrid(BitMatrix bitMatrix, int i2, int i3, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) throws NotFoundException;

    public abstract BitMatrix sampleGrid(BitMatrix bitMatrix, int i2, int i3, PerspectiveTransform perspectiveTransform) throws NotFoundException;
}
