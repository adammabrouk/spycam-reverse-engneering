package com.google.zxing.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.common.GridSampler;
import com.google.zxing.common.PerspectiveTransform;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.qrcode.decoder.Version;
import java.util.Map;

/* loaded from: classes.dex */
public class Detector {
    public final BitMatrix image;
    public ResultPointCallback resultPointCallback;

    public Detector(BitMatrix bitMatrix) {
        this.image = bitMatrix;
    }

    private float calculateModuleSizeOneWay(ResultPoint resultPoint, ResultPoint resultPoint2) {
        float sizeOfBlackWhiteBlackRunBothWays = sizeOfBlackWhiteBlackRunBothWays((int) resultPoint.getX(), (int) resultPoint.getY(), (int) resultPoint2.getX(), (int) resultPoint2.getY());
        float sizeOfBlackWhiteBlackRunBothWays2 = sizeOfBlackWhiteBlackRunBothWays((int) resultPoint2.getX(), (int) resultPoint2.getY(), (int) resultPoint.getX(), (int) resultPoint.getY());
        return Float.isNaN(sizeOfBlackWhiteBlackRunBothWays) ? sizeOfBlackWhiteBlackRunBothWays2 / 7.0f : Float.isNaN(sizeOfBlackWhiteBlackRunBothWays2) ? sizeOfBlackWhiteBlackRunBothWays / 7.0f : (sizeOfBlackWhiteBlackRunBothWays + sizeOfBlackWhiteBlackRunBothWays2) / 14.0f;
    }

    public static int computeDimension(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, float f2) throws NotFoundException {
        int round = ((MathUtils.round(ResultPoint.distance(resultPoint, resultPoint2) / f2) + MathUtils.round(ResultPoint.distance(resultPoint, resultPoint3) / f2)) / 2) + 7;
        int i2 = round & 3;
        if (i2 == 0) {
            return round + 1;
        }
        if (i2 == 2) {
            return round - 1;
        }
        if (i2 != 3) {
            return round;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public static PerspectiveTransform createTransform(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i2) {
        float x;
        float y;
        float f2;
        float f3 = i2 - 3.5f;
        if (resultPoint4 != null) {
            x = resultPoint4.getX();
            y = resultPoint4.getY();
            f2 = f3 - 3.0f;
        } else {
            x = (resultPoint2.getX() - resultPoint.getX()) + resultPoint3.getX();
            y = (resultPoint2.getY() - resultPoint.getY()) + resultPoint3.getY();
            f2 = f3;
        }
        return PerspectiveTransform.quadrilateralToQuadrilateral(3.5f, 3.5f, f3, 3.5f, f2, f2, 3.5f, f3, resultPoint.getX(), resultPoint.getY(), resultPoint2.getX(), resultPoint2.getY(), x, y, resultPoint3.getX(), resultPoint3.getY());
    }

    public static BitMatrix sampleGrid(BitMatrix bitMatrix, PerspectiveTransform perspectiveTransform, int i2) throws NotFoundException {
        return GridSampler.getInstance().sampleGrid(bitMatrix, i2, i2, perspectiveTransform);
    }

    private float sizeOfBlackWhiteBlackRun(int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        Detector detector;
        boolean z;
        int i11;
        boolean z2;
        int i12 = 1;
        boolean z3 = Math.abs(i5 - i3) > Math.abs(i4 - i2);
        if (z3) {
            i7 = i2;
            i6 = i3;
            i9 = i4;
            i8 = i5;
        } else {
            i6 = i2;
            i7 = i3;
            i8 = i4;
            i9 = i5;
        }
        int abs = Math.abs(i8 - i6);
        int abs2 = Math.abs(i9 - i7);
        int i13 = (-abs) / 2;
        int i14 = i6 < i8 ? 1 : -1;
        int i15 = i7 < i9 ? 1 : -1;
        int i16 = i8 + i14;
        int i17 = i6;
        int i18 = i7;
        int i19 = 0;
        while (true) {
            if (i17 == i16) {
                i10 = 2;
                break;
            }
            int i20 = z3 ? i18 : i17;
            int i21 = z3 ? i17 : i18;
            if (i19 == i12) {
                detector = this;
                z = z3;
                i11 = i14;
                z2 = true;
            } else {
                detector = this;
                z = z3;
                i11 = i14;
                z2 = false;
            }
            if (z2 == detector.image.get(i20, i21)) {
                i10 = 2;
                if (i19 == 2) {
                    return MathUtils.distance(i17, i18, i6, i7);
                }
                i19++;
            } else {
                i10 = 2;
            }
            i13 += abs2;
            if (i13 > 0) {
                if (i18 == i9) {
                    break;
                }
                i18 += i15;
                i13 -= abs;
            }
            i17 += i11;
            i14 = i11;
            z3 = z;
            i12 = 1;
        }
        if (i19 == i10) {
            return MathUtils.distance(i16, i9, i6, i7);
        }
        return Float.NaN;
    }

    private float sizeOfBlackWhiteBlackRunBothWays(int i2, int i3, int i4, int i5) {
        float f2;
        float f3;
        float sizeOfBlackWhiteBlackRun = sizeOfBlackWhiteBlackRun(i2, i3, i4, i5);
        int i6 = i2 - (i4 - i2);
        int i7 = 0;
        if (i6 < 0) {
            f2 = i2 / (i2 - i6);
            i6 = 0;
        } else if (i6 >= this.image.getWidth()) {
            f2 = ((this.image.getWidth() - 1) - i2) / (i6 - i2);
            i6 = this.image.getWidth() - 1;
        } else {
            f2 = 1.0f;
        }
        float f4 = i3;
        int i8 = (int) (f4 - ((i5 - i3) * f2));
        if (i8 < 0) {
            f3 = f4 / (i3 - i8);
        } else if (i8 >= this.image.getHeight()) {
            f3 = ((this.image.getHeight() - 1) - i3) / (i8 - i3);
            i7 = this.image.getHeight() - 1;
        } else {
            i7 = i8;
            f3 = 1.0f;
        }
        return (sizeOfBlackWhiteBlackRun + sizeOfBlackWhiteBlackRun(i2, i3, (int) (i2 + ((i6 - i2) * f3)), i7)) - 1.0f;
    }

    public final float calculateModuleSize(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3) {
        return (calculateModuleSizeOneWay(resultPoint, resultPoint2) + calculateModuleSizeOneWay(resultPoint, resultPoint3)) / 2.0f;
    }

    public DetectorResult detect() throws NotFoundException, FormatException {
        return detect(null);
    }

    public final AlignmentPattern findAlignmentInRegion(float f2, int i2, int i3, float f3) throws NotFoundException {
        int i4 = (int) (f3 * f2);
        int max = Math.max(0, i2 - i4);
        int min = Math.min(this.image.getWidth() - 1, i2 + i4) - max;
        float f4 = 3.0f * f2;
        if (min < f4) {
            throw NotFoundException.getNotFoundInstance();
        }
        int max2 = Math.max(0, i3 - i4);
        int min2 = Math.min(this.image.getHeight() - 1, i3 + i4) - max2;
        if (min2 >= f4) {
            return new AlignmentPatternFinder(this.image, max, max2, min, min2, f2, this.resultPointCallback).find();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public final BitMatrix getImage() {
        return this.image;
    }

    public final ResultPointCallback getResultPointCallback() {
        return this.resultPointCallback;
    }

    public final DetectorResult processFinderPatternInfo(FinderPatternInfo finderPatternInfo) throws NotFoundException, FormatException {
        FinderPattern topLeft = finderPatternInfo.getTopLeft();
        FinderPattern topRight = finderPatternInfo.getTopRight();
        FinderPattern bottomLeft = finderPatternInfo.getBottomLeft();
        float calculateModuleSize = calculateModuleSize(topLeft, topRight, bottomLeft);
        if (calculateModuleSize < 1.0f) {
            throw NotFoundException.getNotFoundInstance();
        }
        int computeDimension = computeDimension(topLeft, topRight, bottomLeft, calculateModuleSize);
        Version provisionalVersionForDimension = Version.getProvisionalVersionForDimension(computeDimension);
        int dimensionForVersion = provisionalVersionForDimension.getDimensionForVersion() - 7;
        AlignmentPattern alignmentPattern = null;
        if (provisionalVersionForDimension.getAlignmentPatternCenters().length > 0) {
            float x = (topRight.getX() - topLeft.getX()) + bottomLeft.getX();
            float y = (topRight.getY() - topLeft.getY()) + bottomLeft.getY();
            float f2 = 1.0f - (3.0f / dimensionForVersion);
            int x2 = (int) (topLeft.getX() + ((x - topLeft.getX()) * f2));
            int y2 = (int) (topLeft.getY() + (f2 * (y - topLeft.getY())));
            for (int i2 = 4; i2 <= 16; i2 <<= 1) {
                try {
                    alignmentPattern = findAlignmentInRegion(calculateModuleSize, x2, y2, i2);
                    break;
                } catch (NotFoundException unused) {
                }
            }
        }
        return new DetectorResult(sampleGrid(this.image, createTransform(topLeft, topRight, bottomLeft, alignmentPattern, computeDimension), computeDimension), alignmentPattern == null ? new ResultPoint[]{bottomLeft, topLeft, topRight} : new ResultPoint[]{bottomLeft, topLeft, topRight, alignmentPattern});
    }

    public final DetectorResult detect(Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        ResultPointCallback resultPointCallback = map == null ? null : (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        this.resultPointCallback = resultPointCallback;
        return processFinderPatternInfo(new FinderPatternFinder(this.image, resultPointCallback).find(map));
    }
}
