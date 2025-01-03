package com.google.zxing.common;

import com.google.zxing.NotFoundException;

/* loaded from: classes.dex */
public final class DefaultGridSampler extends GridSampler {
    @Override // com.google.zxing.common.GridSampler
    public BitMatrix sampleGrid(BitMatrix bitMatrix, int i2, int i3, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) throws NotFoundException {
        return sampleGrid(bitMatrix, i2, i3, PerspectiveTransform.quadrilateralToQuadrilateral(f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17));
    }

    @Override // com.google.zxing.common.GridSampler
    public BitMatrix sampleGrid(BitMatrix bitMatrix, int i2, int i3, PerspectiveTransform perspectiveTransform) throws NotFoundException {
        if (i2 > 0 && i3 > 0) {
            BitMatrix bitMatrix2 = new BitMatrix(i2, i3);
            int i4 = i2 * 2;
            float[] fArr = new float[i4];
            for (int i5 = 0; i5 < i3; i5++) {
                float f2 = i5 + 0.5f;
                for (int i6 = 0; i6 < i4; i6 += 2) {
                    fArr[i6] = (i6 / 2) + 0.5f;
                    fArr[i6 + 1] = f2;
                }
                perspectiveTransform.transformPoints(fArr);
                GridSampler.checkAndNudgePoints(bitMatrix, fArr);
                for (int i7 = 0; i7 < i4; i7 += 2) {
                    try {
                        if (bitMatrix.get((int) fArr[i7], (int) fArr[i7 + 1])) {
                            bitMatrix2.set(i7 / 2, i5);
                        }
                    } catch (ArrayIndexOutOfBoundsException unused) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                }
            }
            return bitMatrix2;
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
