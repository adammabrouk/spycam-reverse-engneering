package com.google.zxing.common.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;

/* loaded from: classes.dex */
public final class WhiteRectangleDetector {
    public static final int CORR = 1;
    public static final int INIT_SIZE = 10;
    public final int downInit;
    public final int height;
    public final BitMatrix image;
    public final int leftInit;
    public final int rightInit;
    public final int upInit;
    public final int width;

    public WhiteRectangleDetector(BitMatrix bitMatrix) throws NotFoundException {
        this(bitMatrix, 10, bitMatrix.getWidth() / 2, bitMatrix.getHeight() / 2);
    }

    private ResultPoint[] centerEdges(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4) {
        float x = resultPoint.getX();
        float y = resultPoint.getY();
        float x2 = resultPoint2.getX();
        float y2 = resultPoint2.getY();
        float x3 = resultPoint3.getX();
        float y3 = resultPoint3.getY();
        float x4 = resultPoint4.getX();
        float y4 = resultPoint4.getY();
        return x < ((float) this.width) / 2.0f ? new ResultPoint[]{new ResultPoint(x4 - 1.0f, y4 + 1.0f), new ResultPoint(x2 + 1.0f, y2 + 1.0f), new ResultPoint(x3 - 1.0f, y3 - 1.0f), new ResultPoint(x + 1.0f, y - 1.0f)} : new ResultPoint[]{new ResultPoint(x4 + 1.0f, y4 + 1.0f), new ResultPoint(x2 + 1.0f, y2 - 1.0f), new ResultPoint(x3 - 1.0f, y3 + 1.0f), new ResultPoint(x - 1.0f, y - 1.0f)};
    }

    private boolean containsBlackPoint(int i2, int i3, int i4, boolean z) {
        if (z) {
            while (i2 <= i3) {
                if (this.image.get(i2, i4)) {
                    return true;
                }
                i2++;
            }
            return false;
        }
        while (i2 <= i3) {
            if (this.image.get(i4, i2)) {
                return true;
            }
            i2++;
        }
        return false;
    }

    private ResultPoint getBlackPointOnSegment(float f2, float f3, float f4, float f5) {
        int round = MathUtils.round(MathUtils.distance(f2, f3, f4, f5));
        float f6 = round;
        float f7 = (f4 - f2) / f6;
        float f8 = (f5 - f3) / f6;
        for (int i2 = 0; i2 < round; i2++) {
            float f9 = i2;
            int round2 = MathUtils.round((f9 * f7) + f2);
            int round3 = MathUtils.round((f9 * f8) + f3);
            if (this.image.get(round2, round3)) {
                return new ResultPoint(round2, round3);
            }
        }
        return null;
    }

    public ResultPoint[] detect() throws NotFoundException {
        int i2 = this.leftInit;
        int i3 = this.rightInit;
        int i4 = this.upInit;
        int i5 = this.downInit;
        boolean z = false;
        boolean z2 = true;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        while (z2) {
            boolean z8 = true;
            boolean z9 = false;
            while (true) {
                if ((z8 || !z3) && i3 < this.width) {
                    z8 = containsBlackPoint(i4, i5, i3, false);
                    if (z8) {
                        i3++;
                        z3 = true;
                        z9 = true;
                    } else if (!z3) {
                        i3++;
                    }
                }
            }
            if (i3 < this.width) {
                boolean z10 = true;
                while (true) {
                    if ((z10 || !z4) && i5 < this.height) {
                        z10 = containsBlackPoint(i2, i3, i5, true);
                        if (z10) {
                            i5++;
                            z4 = true;
                            z9 = true;
                        } else if (!z4) {
                            i5++;
                        }
                    }
                }
                if (i5 < this.height) {
                    boolean z11 = true;
                    while (true) {
                        if ((z11 || !z5) && i2 >= 0) {
                            z11 = containsBlackPoint(i4, i5, i2, false);
                            if (z11) {
                                i2--;
                                z5 = true;
                                z9 = true;
                            } else if (!z5) {
                                i2--;
                            }
                        }
                    }
                    if (i2 >= 0) {
                        z2 = z9;
                        boolean z12 = true;
                        while (true) {
                            if ((z12 || !z7) && i4 >= 0) {
                                z12 = containsBlackPoint(i2, i3, i4, true);
                                if (z12) {
                                    i4--;
                                    z2 = true;
                                    z7 = true;
                                } else if (!z7) {
                                    i4--;
                                }
                            }
                        }
                        if (i4 >= 0) {
                            if (z2) {
                                z6 = true;
                            }
                        }
                    }
                }
            }
            z = true;
            break;
        }
        if (z || !z6) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i6 = i3 - i2;
        ResultPoint resultPoint = null;
        ResultPoint resultPoint2 = null;
        for (int i7 = 1; resultPoint2 == null && i7 < i6; i7++) {
            resultPoint2 = getBlackPointOnSegment(i2, i5 - i7, i2 + i7, i5);
        }
        if (resultPoint2 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        ResultPoint resultPoint3 = null;
        for (int i8 = 1; resultPoint3 == null && i8 < i6; i8++) {
            resultPoint3 = getBlackPointOnSegment(i2, i4 + i8, i2 + i8, i4);
        }
        if (resultPoint3 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        ResultPoint resultPoint4 = null;
        for (int i9 = 1; resultPoint4 == null && i9 < i6; i9++) {
            resultPoint4 = getBlackPointOnSegment(i3, i4 + i9, i3 - i9, i4);
        }
        if (resultPoint4 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        for (int i10 = 1; resultPoint == null && i10 < i6; i10++) {
            resultPoint = getBlackPointOnSegment(i3, i5 - i10, i3 - i10, i5);
        }
        if (resultPoint != null) {
            return centerEdges(resultPoint, resultPoint2, resultPoint4, resultPoint3);
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public WhiteRectangleDetector(BitMatrix bitMatrix, int i2, int i3, int i4) throws NotFoundException {
        this.image = bitMatrix;
        this.height = bitMatrix.getHeight();
        int width = bitMatrix.getWidth();
        this.width = width;
        int i5 = i2 / 2;
        int i6 = i3 - i5;
        this.leftInit = i6;
        int i7 = i3 + i5;
        this.rightInit = i7;
        int i8 = i4 - i5;
        this.upInit = i8;
        int i9 = i4 + i5;
        this.downInit = i9;
        if (i8 < 0 || i6 < 0 || i9 >= this.height || i7 >= width) {
            throw NotFoundException.getNotFoundInstance();
        }
    }
}
