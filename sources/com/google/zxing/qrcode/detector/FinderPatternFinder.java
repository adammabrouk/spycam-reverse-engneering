package com.google.zxing.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class FinderPatternFinder {
    public static final int CENTER_QUORUM = 2;
    public static final int MAX_MODULES = 97;
    public static final int MIN_SKIP = 3;
    public final int[] crossCheckStateCount;
    public boolean hasSkipped;
    public final BitMatrix image;
    public final List<FinderPattern> possibleCenters;
    public final ResultPointCallback resultPointCallback;

    public static final class CenterComparator implements Comparator<FinderPattern>, Serializable {
        public final float average;

        public CenterComparator(float f2) {
            this.average = f2;
        }

        @Override // java.util.Comparator
        public int compare(FinderPattern finderPattern, FinderPattern finderPattern2) {
            int compare = Integer.compare(finderPattern2.getCount(), finderPattern.getCount());
            return compare == 0 ? Float.compare(Math.abs(finderPattern.getEstimatedModuleSize() - this.average), Math.abs(finderPattern2.getEstimatedModuleSize() - this.average)) : compare;
        }

        public /* synthetic */ CenterComparator(float f2, CenterComparator centerComparator) {
            this(f2);
        }
    }

    public static final class FurthestFromAverageComparator implements Comparator<FinderPattern>, Serializable {
        public final float average;

        public FurthestFromAverageComparator(float f2) {
            this.average = f2;
        }

        @Override // java.util.Comparator
        public int compare(FinderPattern finderPattern, FinderPattern finderPattern2) {
            return Float.compare(Math.abs(finderPattern2.getEstimatedModuleSize() - this.average), Math.abs(finderPattern.getEstimatedModuleSize() - this.average));
        }

        public /* synthetic */ FurthestFromAverageComparator(float f2, FurthestFromAverageComparator furthestFromAverageComparator) {
            this(f2);
        }
    }

    public FinderPatternFinder(BitMatrix bitMatrix) {
        this(bitMatrix, null);
    }

    public static float centerFromEnd(int[] iArr, int i2) {
        return ((i2 - iArr[4]) - iArr[3]) - (iArr[2] / 2.0f);
    }

    private boolean crossCheckDiagonal(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int[] crossCheckStateCount = getCrossCheckStateCount();
        int i7 = 0;
        while (i2 >= i7 && i3 >= i7 && this.image.get(i3 - i7, i2 - i7)) {
            crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
            i7++;
        }
        if (crossCheckStateCount[2] == 0) {
            return false;
        }
        while (i2 >= i7 && i3 >= i7 && !this.image.get(i3 - i7, i2 - i7)) {
            crossCheckStateCount[1] = crossCheckStateCount[1] + 1;
            i7++;
        }
        if (crossCheckStateCount[1] == 0) {
            return false;
        }
        while (i2 >= i7 && i3 >= i7 && this.image.get(i3 - i7, i2 - i7)) {
            crossCheckStateCount[0] = crossCheckStateCount[0] + 1;
            i7++;
        }
        if (crossCheckStateCount[0] == 0) {
            return false;
        }
        int height = this.image.getHeight();
        int width = this.image.getWidth();
        int i8 = 1;
        while (true) {
            int i9 = i2 + i8;
            if (i9 >= height || (i6 = i3 + i8) >= width || !this.image.get(i6, i9)) {
                break;
            }
            crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
            i8++;
        }
        while (true) {
            int i10 = i2 + i8;
            if (i10 >= height || (i5 = i3 + i8) >= width || this.image.get(i5, i10)) {
                break;
            }
            crossCheckStateCount[3] = crossCheckStateCount[3] + 1;
            i8++;
        }
        if (crossCheckStateCount[3] == 0) {
            return false;
        }
        while (true) {
            int i11 = i2 + i8;
            if (i11 >= height || (i4 = i3 + i8) >= width || !this.image.get(i4, i11)) {
                break;
            }
            crossCheckStateCount[4] = crossCheckStateCount[4] + 1;
            i8++;
        }
        if (crossCheckStateCount[4] == 0) {
            return false;
        }
        return foundPatternDiagonal(crossCheckStateCount);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003c, code lost:
    
        if (r2[1] <= r13) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0041, code lost:
    
        if (r3 < 0) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0047, code lost:
    
        if (r0.get(r3, r12) == false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004b, code lost:
    
        if (r2[0] <= r13) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004e, code lost:
    
        r2[0] = r2[0] + 1;
        r3 = r3 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0058, code lost:
    
        if (r2[0] <= r13) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005a, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x005b, code lost:
    
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x005c, code lost:
    
        if (r11 >= r1) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0062, code lost:
    
        if (r0.get(r11, r12) != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0065, code lost:
    
        r2[2] = r2[2] + 1;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x006d, code lost:
    
        if (r11 != r1) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x006f, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0071, code lost:
    
        if (r11 >= r1) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0077, code lost:
    
        if (r0.get(r11, r12) != false) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x007b, code lost:
    
        if (r2[3] < r13) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x007e, code lost:
    
        r2[3] = r2[3] + 1;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0086, code lost:
    
        if (r11 == r1) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x008a, code lost:
    
        if (r2[3] < r13) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x008e, code lost:
    
        if (r11 >= r1) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0094, code lost:
    
        if (r0.get(r11, r12) == false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0098, code lost:
    
        if (r2[4] < r13) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x009b, code lost:
    
        r2[4] = r2[4] + 1;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00a5, code lost:
    
        if (r2[4] < r13) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00a7, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00bd, code lost:
    
        if ((java.lang.Math.abs(((((r2[0] + r2[1]) + r2[2]) + r2[3]) + r2[4]) - r14) * 5) < r14) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00bf, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00c4, code lost:
    
        if (foundPatternCross(r2) == false) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00ca, code lost:
    
        return centerFromEnd(r2, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:?, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:?, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:?, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:?, code lost:
    
        return Float.NaN;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private float crossCheckHorizontal(int r11, int r12, int r13, int r14) {
        /*
            Method dump skipped, instructions count: 203
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.detector.FinderPatternFinder.crossCheckHorizontal(int, int, int, int):float");
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003c, code lost:
    
        if (r2[1] <= r13) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0041, code lost:
    
        if (r3 < 0) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0047, code lost:
    
        if (r0.get(r12, r3) == false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004b, code lost:
    
        if (r2[0] <= r13) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004e, code lost:
    
        r2[0] = r2[0] + 1;
        r3 = r3 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0058, code lost:
    
        if (r2[0] <= r13) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005a, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x005b, code lost:
    
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x005c, code lost:
    
        if (r11 >= r1) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0062, code lost:
    
        if (r0.get(r12, r11) != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0065, code lost:
    
        r2[2] = r2[2] + 1;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x006d, code lost:
    
        if (r11 != r1) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x006f, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0071, code lost:
    
        if (r11 >= r1) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0077, code lost:
    
        if (r0.get(r12, r11) != false) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x007b, code lost:
    
        if (r2[3] < r13) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x007e, code lost:
    
        r2[3] = r2[3] + 1;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0086, code lost:
    
        if (r11 == r1) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x008a, code lost:
    
        if (r2[3] < r13) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x008e, code lost:
    
        if (r11 >= r1) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0094, code lost:
    
        if (r0.get(r12, r11) == false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0098, code lost:
    
        if (r2[4] < r13) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x009b, code lost:
    
        r2[4] = r2[4] + 1;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00a5, code lost:
    
        if (r2[4] < r13) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00a7, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00bf, code lost:
    
        if ((java.lang.Math.abs(((((r2[0] + r2[1]) + r2[2]) + r2[3]) + r2[4]) - r14) * 5) < (r14 * 2)) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00c1, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00c6, code lost:
    
        if (foundPatternCross(r2) == false) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00cc, code lost:
    
        return centerFromEnd(r2, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:?, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:?, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:?, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:?, code lost:
    
        return Float.NaN;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private float crossCheckVertical(int r11, int r12, int r13, int r14) {
        /*
            Method dump skipped, instructions count: 205
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.detector.FinderPatternFinder.crossCheckVertical(int, int, int, int):float");
    }

    private int findRowSkip() {
        if (this.possibleCenters.size() <= 1) {
            return 0;
        }
        FinderPattern finderPattern = null;
        for (FinderPattern finderPattern2 : this.possibleCenters) {
            if (finderPattern2.getCount() >= 2) {
                if (finderPattern != null) {
                    this.hasSkipped = true;
                    return ((int) (Math.abs(finderPattern.getX() - finderPattern2.getX()) - Math.abs(finderPattern.getY() - finderPattern2.getY()))) / 2;
                }
                finderPattern = finderPattern2;
            }
        }
        return 0;
    }

    public static boolean foundPatternCross(int[] iArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < 5; i3++) {
            int i4 = iArr[i3];
            if (i4 == 0) {
                return false;
            }
            i2 += i4;
        }
        if (i2 < 7) {
            return false;
        }
        float f2 = i2 / 7.0f;
        float f3 = f2 / 2.0f;
        return Math.abs(f2 - ((float) iArr[0])) < f3 && Math.abs(f2 - ((float) iArr[1])) < f3 && Math.abs((f2 * 3.0f) - ((float) iArr[2])) < 3.0f * f3 && Math.abs(f2 - ((float) iArr[3])) < f3 && Math.abs(f2 - ((float) iArr[4])) < f3;
    }

    public static boolean foundPatternDiagonal(int[] iArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < 5; i3++) {
            int i4 = iArr[i3];
            if (i4 == 0) {
                return false;
            }
            i2 += i4;
        }
        if (i2 < 7) {
            return false;
        }
        float f2 = i2 / 7.0f;
        float f3 = f2 / 1.333f;
        return Math.abs(f2 - ((float) iArr[0])) < f3 && Math.abs(f2 - ((float) iArr[1])) < f3 && Math.abs((f2 * 3.0f) - ((float) iArr[2])) < 3.0f * f3 && Math.abs(f2 - ((float) iArr[3])) < f3 && Math.abs(f2 - ((float) iArr[4])) < f3;
    }

    private int[] getCrossCheckStateCount() {
        clearCounts(this.crossCheckStateCount);
        return this.crossCheckStateCount;
    }

    private boolean haveMultiplyConfirmedCenters() {
        int size = this.possibleCenters.size();
        float f2 = 0.0f;
        int i2 = 0;
        float f3 = 0.0f;
        for (FinderPattern finderPattern : this.possibleCenters) {
            if (finderPattern.getCount() >= 2) {
                i2++;
                f3 += finderPattern.getEstimatedModuleSize();
            }
        }
        if (i2 < 3) {
            return false;
        }
        float f4 = f3 / size;
        Iterator<FinderPattern> it = this.possibleCenters.iterator();
        while (it.hasNext()) {
            f2 += Math.abs(it.next().getEstimatedModuleSize() - f4);
        }
        return f2 <= f3 * 0.05f;
    }

    private FinderPattern[] selectBestPatterns() throws NotFoundException {
        int size = this.possibleCenters.size();
        if (size < 3) {
            throw NotFoundException.getNotFoundInstance();
        }
        FurthestFromAverageComparator furthestFromAverageComparator = null;
        byte b2 = 0;
        if (size > 3) {
            Iterator<FinderPattern> it = this.possibleCenters.iterator();
            double d2 = 0.0d;
            double d3 = 0.0d;
            while (it.hasNext()) {
                float estimatedModuleSize = it.next().getEstimatedModuleSize();
                double d4 = estimatedModuleSize;
                Double.isNaN(d4);
                d2 += d4;
                double d5 = estimatedModuleSize * estimatedModuleSize;
                Double.isNaN(d5);
                d3 += d5;
            }
            double d6 = size;
            Double.isNaN(d6);
            double d7 = d2 / d6;
            Double.isNaN(d6);
            float sqrt = (float) Math.sqrt((d3 / d6) - (d7 * d7));
            float f2 = (float) d7;
            Collections.sort(this.possibleCenters, new FurthestFromAverageComparator(f2, furthestFromAverageComparator));
            float max = Math.max(f2 * 0.2f, sqrt);
            int i2 = 0;
            while (i2 < this.possibleCenters.size() && this.possibleCenters.size() > 3) {
                double estimatedModuleSize2 = this.possibleCenters.get(i2).getEstimatedModuleSize();
                Double.isNaN(estimatedModuleSize2);
                if (Math.abs(estimatedModuleSize2 - d7) > max) {
                    this.possibleCenters.remove(i2);
                    i2--;
                }
                i2++;
            }
        }
        if (this.possibleCenters.size() > 3) {
            float f3 = 0.0f;
            Iterator<FinderPattern> it2 = this.possibleCenters.iterator();
            while (it2.hasNext()) {
                f3 += it2.next().getEstimatedModuleSize();
            }
            Collections.sort(this.possibleCenters, new CenterComparator(f3 / this.possibleCenters.size(), b2 == true ? 1 : 0));
            List<FinderPattern> list = this.possibleCenters;
            list.subList(3, list.size()).clear();
        }
        return new FinderPattern[]{this.possibleCenters.get(0), this.possibleCenters.get(1), this.possibleCenters.get(2)};
    }

    public final void clearCounts(int[] iArr) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr[i2] = 0;
        }
    }

    public final FinderPatternInfo find(Map<DecodeHintType, ?> map) throws NotFoundException {
        boolean z = map != null && map.containsKey(DecodeHintType.TRY_HARDER);
        int height = this.image.getHeight();
        int width = this.image.getWidth();
        int i2 = (height * 3) / 388;
        if (i2 < 3 || z) {
            i2 = 3;
        }
        int[] iArr = new int[5];
        int i3 = i2 - 1;
        boolean z2 = false;
        while (i3 < height && !z2) {
            clearCounts(iArr);
            int i4 = 0;
            int i5 = 0;
            while (i4 < width) {
                if (this.image.get(i4, i3)) {
                    if ((i5 & 1) == 1) {
                        i5++;
                    }
                    iArr[i5] = iArr[i5] + 1;
                } else if ((i5 & 1) != 0) {
                    iArr[i5] = iArr[i5] + 1;
                } else if (i5 == 4) {
                    if (!foundPatternCross(iArr)) {
                        shiftCounts2(iArr);
                    } else if (handlePossibleCenter(iArr, i3, i4)) {
                        if (this.hasSkipped) {
                            z2 = haveMultiplyConfirmedCenters();
                        } else {
                            int findRowSkip = findRowSkip();
                            if (findRowSkip > iArr[2]) {
                                i3 += (findRowSkip - iArr[2]) - 2;
                                i4 = width - 1;
                            }
                        }
                        clearCounts(iArr);
                        i2 = 2;
                        i5 = 0;
                    } else {
                        shiftCounts2(iArr);
                    }
                    i5 = 3;
                } else {
                    i5++;
                    iArr[i5] = iArr[i5] + 1;
                }
                i4++;
            }
            if (foundPatternCross(iArr) && handlePossibleCenter(iArr, i3, width)) {
                i2 = iArr[0];
                if (this.hasSkipped) {
                    z2 = haveMultiplyConfirmedCenters();
                }
            }
            i3 += i2;
        }
        FinderPattern[] selectBestPatterns = selectBestPatterns();
        ResultPoint.orderBestPatterns(selectBestPatterns);
        return new FinderPatternInfo(selectBestPatterns);
    }

    public final BitMatrix getImage() {
        return this.image;
    }

    public final List<FinderPattern> getPossibleCenters() {
        return this.possibleCenters;
    }

    @Deprecated
    public final boolean handlePossibleCenter(int[] iArr, int i2, int i3, boolean z) {
        return handlePossibleCenter(iArr, i2, i3);
    }

    public final void shiftCounts2(int[] iArr) {
        iArr[0] = iArr[2];
        iArr[1] = iArr[3];
        iArr[2] = iArr[4];
        iArr[3] = 1;
        iArr[4] = 0;
    }

    public FinderPatternFinder(BitMatrix bitMatrix, ResultPointCallback resultPointCallback) {
        this.image = bitMatrix;
        this.possibleCenters = new ArrayList();
        this.crossCheckStateCount = new int[5];
        this.resultPointCallback = resultPointCallback;
    }

    public final boolean handlePossibleCenter(int[] iArr, int i2, int i3) {
        boolean z = false;
        int i4 = iArr[0] + iArr[1] + iArr[2] + iArr[3] + iArr[4];
        int centerFromEnd = (int) centerFromEnd(iArr, i3);
        float crossCheckVertical = crossCheckVertical(i2, centerFromEnd, iArr[2], i4);
        if (!Float.isNaN(crossCheckVertical)) {
            int i5 = (int) crossCheckVertical;
            float crossCheckHorizontal = crossCheckHorizontal(centerFromEnd, i5, iArr[2], i4);
            if (!Float.isNaN(crossCheckHorizontal) && crossCheckDiagonal(i5, (int) crossCheckHorizontal)) {
                float f2 = i4 / 7.0f;
                int i6 = 0;
                while (true) {
                    if (i6 >= this.possibleCenters.size()) {
                        break;
                    }
                    FinderPattern finderPattern = this.possibleCenters.get(i6);
                    if (finderPattern.aboutEquals(f2, crossCheckVertical, crossCheckHorizontal)) {
                        this.possibleCenters.set(i6, finderPattern.combineEstimate(crossCheckVertical, crossCheckHorizontal, f2));
                        z = true;
                        break;
                    }
                    i6++;
                }
                if (!z) {
                    FinderPattern finderPattern2 = new FinderPattern(crossCheckHorizontal, crossCheckVertical, f2);
                    this.possibleCenters.add(finderPattern2);
                    ResultPointCallback resultPointCallback = this.resultPointCallback;
                    if (resultPointCallback != null) {
                        resultPointCallback.foundPossibleResultPoint(finderPattern2);
                    }
                }
                return true;
            }
        }
        return false;
    }
}
