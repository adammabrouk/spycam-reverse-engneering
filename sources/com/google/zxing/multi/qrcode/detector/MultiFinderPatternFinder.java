package com.google.zxing.multi.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.detector.FinderPattern;
import com.google.zxing.qrcode.detector.FinderPatternFinder;
import com.google.zxing.qrcode.detector.FinderPatternInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class MultiFinderPatternFinder extends FinderPatternFinder {
    public static final float DIFF_MODSIZE_CUTOFF = 0.5f;
    public static final float DIFF_MODSIZE_CUTOFF_PERCENT = 0.05f;
    public static final FinderPatternInfo[] EMPTY_RESULT_ARRAY = new FinderPatternInfo[0];
    public static final float MAX_MODULE_COUNT_PER_EDGE = 180.0f;
    public static final float MIN_MODULE_COUNT_PER_EDGE = 9.0f;

    public static final class ModuleSizeComparator implements Comparator<FinderPattern>, Serializable {
        public ModuleSizeComparator() {
        }

        public /* synthetic */ ModuleSizeComparator(ModuleSizeComparator moduleSizeComparator) {
            this();
        }

        @Override // java.util.Comparator
        public int compare(FinderPattern finderPattern, FinderPattern finderPattern2) {
            double estimatedModuleSize = finderPattern2.getEstimatedModuleSize() - finderPattern.getEstimatedModuleSize();
            if (estimatedModuleSize < 0.0d) {
                return -1;
            }
            return estimatedModuleSize > 0.0d ? 1 : 0;
        }
    }

    public MultiFinderPatternFinder(BitMatrix bitMatrix) {
        super(bitMatrix);
    }

    private FinderPattern[][] selectMutipleBestPatterns() throws NotFoundException {
        List<FinderPattern> possibleCenters = getPossibleCenters();
        int size = possibleCenters.size();
        int i2 = 3;
        if (size < 3) {
            throw NotFoundException.getNotFoundInstance();
        }
        char c2 = 0;
        if (size == 3) {
            return new FinderPattern[][]{new FinderPattern[]{possibleCenters.get(0), possibleCenters.get(1), possibleCenters.get(2)}};
        }
        Collections.sort(possibleCenters, new ModuleSizeComparator(null));
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < size - 2; i3++) {
            FinderPattern finderPattern = possibleCenters.get(i3);
            if (finderPattern != null) {
                for (int i4 = i3 + 1; i4 < size - 1; i4++) {
                    FinderPattern finderPattern2 = possibleCenters.get(i4);
                    if (finderPattern2 != null) {
                        float estimatedModuleSize = (finderPattern.getEstimatedModuleSize() - finderPattern2.getEstimatedModuleSize()) / Math.min(finderPattern.getEstimatedModuleSize(), finderPattern2.getEstimatedModuleSize());
                        float f2 = 0.05f;
                        float f3 = 0.5f;
                        if (Math.abs(finderPattern.getEstimatedModuleSize() - finderPattern2.getEstimatedModuleSize()) <= 0.5f || estimatedModuleSize < 0.05f) {
                            int i5 = i4 + 1;
                            while (i5 < size) {
                                FinderPattern finderPattern3 = possibleCenters.get(i5);
                                if (finderPattern3 != null) {
                                    float estimatedModuleSize2 = (finderPattern2.getEstimatedModuleSize() - finderPattern3.getEstimatedModuleSize()) / Math.min(finderPattern2.getEstimatedModuleSize(), finderPattern3.getEstimatedModuleSize());
                                    if (Math.abs(finderPattern2.getEstimatedModuleSize() - finderPattern3.getEstimatedModuleSize()) <= f3 || estimatedModuleSize2 < f2) {
                                        FinderPattern[] finderPatternArr = new FinderPattern[i2];
                                        finderPatternArr[c2] = finderPattern;
                                        finderPatternArr[1] = finderPattern2;
                                        finderPatternArr[2] = finderPattern3;
                                        ResultPoint.orderBestPatterns(finderPatternArr);
                                        FinderPatternInfo finderPatternInfo = new FinderPatternInfo(finderPatternArr);
                                        float distance = ResultPoint.distance(finderPatternInfo.getTopLeft(), finderPatternInfo.getBottomLeft());
                                        float distance2 = ResultPoint.distance(finderPatternInfo.getTopRight(), finderPatternInfo.getBottomLeft());
                                        float distance3 = ResultPoint.distance(finderPatternInfo.getTopLeft(), finderPatternInfo.getTopRight());
                                        float estimatedModuleSize3 = (distance + distance3) / (finderPattern.getEstimatedModuleSize() * 2.0f);
                                        if (estimatedModuleSize3 <= 180.0f && estimatedModuleSize3 >= 9.0f && Math.abs((distance - distance3) / Math.min(distance, distance3)) < 0.1f) {
                                            double d2 = distance;
                                            Double.isNaN(d2);
                                            Double.isNaN(d2);
                                            double d3 = distance3;
                                            Double.isNaN(d3);
                                            Double.isNaN(d3);
                                            float sqrt = (float) Math.sqrt((d2 * d2) + (d3 * d3));
                                            if (Math.abs((distance2 - sqrt) / Math.min(distance2, sqrt)) < 0.1f) {
                                                arrayList.add(finderPatternArr);
                                            }
                                        }
                                    }
                                }
                                i5++;
                                i2 = 3;
                                c2 = 0;
                                f2 = 0.05f;
                                f3 = 0.5f;
                            }
                        }
                    }
                }
            }
        }
        if (arrayList.isEmpty()) {
            throw NotFoundException.getNotFoundInstance();
        }
        return (FinderPattern[][]) arrayList.toArray(new FinderPattern[arrayList.size()][]);
    }

    public FinderPatternInfo[] findMulti(Map<DecodeHintType, ?> map) throws NotFoundException {
        boolean z = map != null && map.containsKey(DecodeHintType.TRY_HARDER);
        BitMatrix image = getImage();
        int height = image.getHeight();
        int width = image.getWidth();
        int i2 = (height * 3) / 388;
        if (i2 < 3 || z) {
            i2 = 3;
        }
        int[] iArr = new int[5];
        for (int i3 = i2 - 1; i3 < height; i3 += i2) {
            clearCounts(iArr);
            int i4 = 0;
            for (int i5 = 0; i5 < width; i5++) {
                if (image.get(i5, i3)) {
                    if ((i4 & 1) == 1) {
                        i4++;
                    }
                    iArr[i4] = iArr[i4] + 1;
                } else if ((i4 & 1) != 0) {
                    iArr[i4] = iArr[i4] + 1;
                } else if (i4 != 4) {
                    i4++;
                    iArr[i4] = iArr[i4] + 1;
                } else if (FinderPatternFinder.foundPatternCross(iArr) && handlePossibleCenter(iArr, i3, i5)) {
                    clearCounts(iArr);
                    i4 = 0;
                } else {
                    shiftCounts2(iArr);
                    i4 = 3;
                }
            }
            if (FinderPatternFinder.foundPatternCross(iArr)) {
                handlePossibleCenter(iArr, i3, width);
            }
        }
        FinderPattern[][] selectMutipleBestPatterns = selectMutipleBestPatterns();
        ArrayList arrayList = new ArrayList();
        for (FinderPattern[] finderPatternArr : selectMutipleBestPatterns) {
            ResultPoint.orderBestPatterns(finderPatternArr);
            arrayList.add(new FinderPatternInfo(finderPatternArr));
        }
        return arrayList.isEmpty() ? EMPTY_RESULT_ARRAY : (FinderPatternInfo[]) arrayList.toArray(new FinderPatternInfo[arrayList.size()]);
    }

    public MultiFinderPatternFinder(BitMatrix bitMatrix, ResultPointCallback resultPointCallback) {
        super(bitMatrix, resultPointCallback);
    }
}
