package com.google.zxing.pdf417.decoder;

import java.util.Formatter;

/* loaded from: classes.dex */
public class DetectionResultColumn {
    public static final int MAX_NEARBY_DISTANCE = 5;
    public final BoundingBox boundingBox;
    public final Codeword[] codewords;

    public DetectionResultColumn(BoundingBox boundingBox) {
        this.boundingBox = new BoundingBox(boundingBox);
        this.codewords = new Codeword[(boundingBox.getMaxY() - boundingBox.getMinY()) + 1];
    }

    public final BoundingBox getBoundingBox() {
        return this.boundingBox;
    }

    public final Codeword getCodeword(int i2) {
        return this.codewords[imageRowToCodewordIndex(i2)];
    }

    public final Codeword getCodewordNearby(int i2) {
        Codeword codeword;
        Codeword codeword2;
        Codeword codeword3 = getCodeword(i2);
        if (codeword3 != null) {
            return codeword3;
        }
        for (int i3 = 1; i3 < 5; i3++) {
            int imageRowToCodewordIndex = imageRowToCodewordIndex(i2) - i3;
            if (imageRowToCodewordIndex >= 0 && (codeword2 = this.codewords[imageRowToCodewordIndex]) != null) {
                return codeword2;
            }
            int imageRowToCodewordIndex2 = imageRowToCodewordIndex(i2) + i3;
            Codeword[] codewordArr = this.codewords;
            if (imageRowToCodewordIndex2 < codewordArr.length && (codeword = codewordArr[imageRowToCodewordIndex2]) != null) {
                return codeword;
            }
        }
        return null;
    }

    public final Codeword[] getCodewords() {
        return this.codewords;
    }

    public final int imageRowToCodewordIndex(int i2) {
        return i2 - this.boundingBox.getMinY();
    }

    public final void setCodeword(int i2, Codeword codeword) {
        this.codewords[imageRowToCodewordIndex(i2)] = codeword;
    }

    public String toString() {
        Throwable th = null;
        try {
            Formatter formatter = new Formatter();
            try {
                int i2 = 0;
                for (Codeword codeword : this.codewords) {
                    if (codeword == null) {
                        formatter.format("%3d:    |   %n", Integer.valueOf(i2));
                        i2++;
                    } else {
                        int i3 = i2 + 1;
                        formatter.format("%3d: %3d|%3d%n", Integer.valueOf(i2), Integer.valueOf(codeword.getRowNumber()), Integer.valueOf(codeword.getValue()));
                        i2 = i3;
                    }
                }
                return formatter.toString();
            } finally {
                formatter.close();
            }
        } catch (Throwable th2) {
            if (0 == 0) {
                throw th2;
            }
            if (null == th2) {
                throw null;
            }
            th.addSuppressed(th2);
            throw null;
        }
    }
}
