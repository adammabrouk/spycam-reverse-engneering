package com.google.zxing.datamatrix.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.common.GridSampler;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.common.detector.WhiteRectangleDetector;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class Detector {
    public final BitMatrix image;
    public final WhiteRectangleDetector rectangleDetector;

    public static final class ResultPointsAndTransitionsComparator implements Comparator<ResultPointsAndTransitions>, Serializable {
        public ResultPointsAndTransitionsComparator() {
        }

        public /* synthetic */ ResultPointsAndTransitionsComparator(ResultPointsAndTransitionsComparator resultPointsAndTransitionsComparator) {
            this();
        }

        @Override // java.util.Comparator
        public int compare(ResultPointsAndTransitions resultPointsAndTransitions, ResultPointsAndTransitions resultPointsAndTransitions2) {
            return resultPointsAndTransitions.getTransitions() - resultPointsAndTransitions2.getTransitions();
        }
    }

    public Detector(BitMatrix bitMatrix) throws NotFoundException {
        this.image = bitMatrix;
        this.rectangleDetector = new WhiteRectangleDetector(bitMatrix);
    }

    private ResultPoint correctTopRight(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i2) {
        float f2 = i2;
        float distance = distance(resultPoint, resultPoint2) / f2;
        float distance2 = distance(resultPoint3, resultPoint4);
        ResultPoint resultPoint5 = new ResultPoint(resultPoint4.getX() + (((resultPoint4.getX() - resultPoint3.getX()) / distance2) * distance), resultPoint4.getY() + (distance * ((resultPoint4.getY() - resultPoint3.getY()) / distance2)));
        float distance3 = distance(resultPoint, resultPoint3) / f2;
        float distance4 = distance(resultPoint2, resultPoint4);
        ResultPoint resultPoint6 = new ResultPoint(resultPoint4.getX() + (((resultPoint4.getX() - resultPoint2.getX()) / distance4) * distance3), resultPoint4.getY() + (distance3 * ((resultPoint4.getY() - resultPoint2.getY()) / distance4)));
        if (isValid(resultPoint5)) {
            return (isValid(resultPoint6) && Math.abs(transitionsBetween(resultPoint3, resultPoint5).getTransitions() - transitionsBetween(resultPoint2, resultPoint5).getTransitions()) > Math.abs(transitionsBetween(resultPoint3, resultPoint6).getTransitions() - transitionsBetween(resultPoint2, resultPoint6).getTransitions())) ? resultPoint6 : resultPoint5;
        }
        if (isValid(resultPoint6)) {
            return resultPoint6;
        }
        return null;
    }

    private ResultPoint correctTopRightRectangular(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i2, int i3) {
        float distance = distance(resultPoint, resultPoint2) / i2;
        float distance2 = distance(resultPoint3, resultPoint4);
        ResultPoint resultPoint5 = new ResultPoint(resultPoint4.getX() + (((resultPoint4.getX() - resultPoint3.getX()) / distance2) * distance), resultPoint4.getY() + (distance * ((resultPoint4.getY() - resultPoint3.getY()) / distance2)));
        float distance3 = distance(resultPoint, resultPoint3) / i3;
        float distance4 = distance(resultPoint2, resultPoint4);
        ResultPoint resultPoint6 = new ResultPoint(resultPoint4.getX() + (((resultPoint4.getX() - resultPoint2.getX()) / distance4) * distance3), resultPoint4.getY() + (distance3 * ((resultPoint4.getY() - resultPoint2.getY()) / distance4)));
        if (isValid(resultPoint5)) {
            return (isValid(resultPoint6) && Math.abs(i2 - transitionsBetween(resultPoint3, resultPoint5).getTransitions()) + Math.abs(i3 - transitionsBetween(resultPoint2, resultPoint5).getTransitions()) > Math.abs(i2 - transitionsBetween(resultPoint3, resultPoint6).getTransitions()) + Math.abs(i3 - transitionsBetween(resultPoint2, resultPoint6).getTransitions())) ? resultPoint6 : resultPoint5;
        }
        if (isValid(resultPoint6)) {
            return resultPoint6;
        }
        return null;
    }

    public static int distance(ResultPoint resultPoint, ResultPoint resultPoint2) {
        return MathUtils.round(ResultPoint.distance(resultPoint, resultPoint2));
    }

    public static void increment(Map<ResultPoint, Integer> map, ResultPoint resultPoint) {
        Integer num = map.get(resultPoint);
        map.put(resultPoint, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    private boolean isValid(ResultPoint resultPoint) {
        return resultPoint.getX() >= 0.0f && resultPoint.getX() < ((float) this.image.getWidth()) && resultPoint.getY() > 0.0f && resultPoint.getY() < ((float) this.image.getHeight());
    }

    public static BitMatrix sampleGrid(BitMatrix bitMatrix, ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i2, int i3) throws NotFoundException {
        float f2 = i2 - 0.5f;
        float f3 = i3 - 0.5f;
        return GridSampler.getInstance().sampleGrid(bitMatrix, i2, i3, 0.5f, 0.5f, f2, 0.5f, f2, f3, 0.5f, f3, resultPoint.getX(), resultPoint.getY(), resultPoint4.getX(), resultPoint4.getY(), resultPoint3.getX(), resultPoint3.getY(), resultPoint2.getX(), resultPoint2.getY());
    }

    private ResultPointsAndTransitions transitionsBetween(ResultPoint resultPoint, ResultPoint resultPoint2) {
        int x = (int) resultPoint.getX();
        int y = (int) resultPoint.getY();
        int x2 = (int) resultPoint2.getX();
        int y2 = (int) resultPoint2.getY();
        int i2 = 0;
        boolean z = Math.abs(y2 - y) > Math.abs(x2 - x);
        if (z) {
            y = x;
            x = y;
            y2 = x2;
            x2 = y2;
        }
        int abs = Math.abs(x2 - x);
        int abs2 = Math.abs(y2 - y);
        int i3 = (-abs) / 2;
        int i4 = y < y2 ? 1 : -1;
        int i5 = x >= x2 ? -1 : 1;
        boolean z2 = this.image.get(z ? y : x, z ? x : y);
        while (x != x2) {
            boolean z3 = this.image.get(z ? y : x, z ? x : y);
            if (z3 != z2) {
                i2++;
                z2 = z3;
            }
            i3 += abs2;
            if (i3 > 0) {
                if (y == y2) {
                    break;
                }
                y += i4;
                i3 -= abs;
            }
            x += i5;
        }
        return new ResultPointsAndTransitions(resultPoint, resultPoint2, i2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v3, types: [com.google.zxing.ResultPoint] */
    /* JADX WARN: Type inference failed for: r16v3, types: [com.google.zxing.ResultPoint] */
    /* JADX WARN: Type inference failed for: r22v0, types: [com.google.zxing.ResultPoint] */
    /* JADX WARN: Type inference failed for: r23v0, types: [com.google.zxing.datamatrix.detector.Detector] */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.google.zxing.ResultPoint[]] */
    /* JADX WARN: Type inference failed for: r4v6, types: [com.google.zxing.ResultPoint[]] */
    /* JADX WARN: Type inference failed for: r6v2, types: [com.google.zxing.ResultPoint] */
    public DetectorResult detect() throws NotFoundException {
        ResultPoint resultPoint;
        BitMatrix sampleGrid;
        ResultPoint[] detect = this.rectangleDetector.detect();
        ResultPoint resultPoint2 = detect[0];
        ResultPoint resultPoint3 = detect[1];
        ResultPoint resultPoint4 = detect[2];
        ResultPoint resultPoint5 = detect[3];
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(transitionsBetween(resultPoint2, resultPoint3));
        arrayList.add(transitionsBetween(resultPoint2, resultPoint4));
        arrayList.add(transitionsBetween(resultPoint3, resultPoint5));
        arrayList.add(transitionsBetween(resultPoint4, resultPoint5));
        ResultPointsAndTransitionsComparator resultPointsAndTransitionsComparator = null;
        Collections.sort(arrayList, new ResultPointsAndTransitionsComparator(resultPointsAndTransitionsComparator));
        ResultPointsAndTransitions resultPointsAndTransitions = (ResultPointsAndTransitions) arrayList.get(0);
        ResultPointsAndTransitions resultPointsAndTransitions2 = (ResultPointsAndTransitions) arrayList.get(1);
        HashMap hashMap = new HashMap();
        increment(hashMap, resultPointsAndTransitions.getFrom());
        increment(hashMap, resultPointsAndTransitions.getTo());
        increment(hashMap, resultPointsAndTransitions2.getFrom());
        increment(hashMap, resultPointsAndTransitions2.getTo());
        Object obj = null;
        Object obj2 = null;
        for (Map.Entry entry : hashMap.entrySet()) {
            ?? r16 = (ResultPoint) entry.getKey();
            if (((Integer) entry.getValue()).intValue() == 2) {
                obj = r16;
            } else if (resultPointsAndTransitionsComparator == null) {
                resultPointsAndTransitionsComparator = r16;
            } else {
                obj2 = r16;
            }
        }
        if (resultPointsAndTransitionsComparator == null || obj == null || obj2 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        ?? r4 = {resultPointsAndTransitionsComparator, obj, obj2};
        ResultPoint.orderBestPatterns(r4);
        ?? r14 = r4[0];
        ?? r22 = r4[1];
        ?? r6 = r4[2];
        ResultPoint resultPoint6 = !hashMap.containsKey(resultPoint2) ? resultPoint2 : !hashMap.containsKey(resultPoint3) ? resultPoint3 : !hashMap.containsKey(resultPoint4) ? resultPoint4 : resultPoint5;
        int transitions = transitionsBetween(r6, resultPoint6).getTransitions();
        int transitions2 = transitionsBetween(r14, resultPoint6).getTransitions();
        if ((transitions & 1) == 1) {
            transitions++;
        }
        int i2 = transitions + 2;
        if ((transitions2 & 1) == 1) {
            transitions2++;
        }
        int i3 = transitions2 + 2;
        if (i2 * 4 >= i3 * 7 || i3 * 4 >= i2 * 7) {
            resultPoint = r6;
            ResultPoint correctTopRightRectangular = correctTopRightRectangular(r22, r14, r6, resultPoint6, i2, i3);
            if (correctTopRightRectangular != null) {
                resultPoint6 = correctTopRightRectangular;
            }
            int transitions3 = transitionsBetween(resultPoint, resultPoint6).getTransitions();
            int transitions4 = transitionsBetween(r14, resultPoint6).getTransitions();
            if ((transitions3 & 1) == 1) {
                transitions3++;
            }
            int i4 = transitions3;
            if ((transitions4 & 1) == 1) {
                transitions4++;
            }
            sampleGrid = sampleGrid(this.image, resultPoint, r22, r14, resultPoint6, i4, transitions4);
        } else {
            ResultPoint correctTopRight = correctTopRight(r22, r14, r6, resultPoint6, Math.min(i3, i2));
            if (correctTopRight != null) {
                resultPoint6 = correctTopRight;
            }
            int max = Math.max(transitionsBetween(r6, resultPoint6).getTransitions(), transitionsBetween(r14, resultPoint6).getTransitions()) + 1;
            if ((max & 1) == 1) {
                max++;
            }
            int i5 = max;
            sampleGrid = sampleGrid(this.image, r6, r22, r14, resultPoint6, i5, i5);
            resultPoint = r6;
        }
        return new DetectorResult(sampleGrid, new ResultPoint[]{resultPoint, r22, r14, resultPoint6});
    }

    public static final class ResultPointsAndTransitions {
        public final ResultPoint from;
        public final ResultPoint to;
        public final int transitions;

        public ResultPointsAndTransitions(ResultPoint resultPoint, ResultPoint resultPoint2, int i2) {
            this.from = resultPoint;
            this.to = resultPoint2;
            this.transitions = i2;
        }

        public ResultPoint getFrom() {
            return this.from;
        }

        public ResultPoint getTo() {
            return this.to;
        }

        public int getTransitions() {
            return this.transitions;
        }

        public String toString() {
            return this.from + "/" + this.to + '/' + this.transitions;
        }

        public /* synthetic */ ResultPointsAndTransitions(ResultPoint resultPoint, ResultPoint resultPoint2, int i2, ResultPointsAndTransitions resultPointsAndTransitions) {
            this(resultPoint, resultPoint2, i2);
        }
    }
}
