package com.google.zxing.pdf417.decoder.ec;

import com.google.zxing.ChecksumException;

/* loaded from: classes.dex */
public final class ErrorCorrection {
    public final ModulusGF field = ModulusGF.PDF417_GF;

    private int[] findErrorLocations(ModulusPoly modulusPoly) throws ChecksumException {
        int degree = modulusPoly.getDegree();
        int[] iArr = new int[degree];
        int i2 = 0;
        for (int i3 = 1; i3 < this.field.getSize() && i2 < degree; i3++) {
            if (modulusPoly.evaluateAt(i3) == 0) {
                iArr[i2] = this.field.inverse(i3);
                i2++;
            }
        }
        if (i2 == degree) {
            return iArr;
        }
        throw ChecksumException.getChecksumInstance();
    }

    private int[] findErrorMagnitudes(ModulusPoly modulusPoly, ModulusPoly modulusPoly2, int[] iArr) {
        int degree = modulusPoly2.getDegree();
        int[] iArr2 = new int[degree];
        for (int i2 = 1; i2 <= degree; i2++) {
            iArr2[degree - i2] = this.field.multiply(i2, modulusPoly2.getCoefficient(i2));
        }
        ModulusPoly modulusPoly3 = new ModulusPoly(this.field, iArr2);
        int length = iArr.length;
        int[] iArr3 = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            int inverse = this.field.inverse(iArr[i3]);
            iArr3[i3] = this.field.multiply(this.field.subtract(0, modulusPoly.evaluateAt(inverse)), this.field.inverse(modulusPoly3.evaluateAt(inverse)));
        }
        return iArr3;
    }

    private ModulusPoly[] runEuclideanAlgorithm(ModulusPoly modulusPoly, ModulusPoly modulusPoly2, int i2) throws ChecksumException {
        if (modulusPoly.getDegree() < modulusPoly2.getDegree()) {
            modulusPoly2 = modulusPoly;
            modulusPoly = modulusPoly2;
        }
        ModulusPoly zero = this.field.getZero();
        ModulusPoly one = this.field.getOne();
        ModulusPoly modulusPoly3 = modulusPoly2;
        ModulusPoly modulusPoly4 = modulusPoly;
        ModulusPoly modulusPoly5 = modulusPoly3;
        while (modulusPoly5.getDegree() >= i2 / 2) {
            if (modulusPoly5.isZero()) {
                throw ChecksumException.getChecksumInstance();
            }
            ModulusPoly zero2 = this.field.getZero();
            int inverse = this.field.inverse(modulusPoly5.getCoefficient(modulusPoly5.getDegree()));
            while (modulusPoly4.getDegree() >= modulusPoly5.getDegree() && !modulusPoly4.isZero()) {
                int degree = modulusPoly4.getDegree() - modulusPoly5.getDegree();
                int multiply = this.field.multiply(modulusPoly4.getCoefficient(modulusPoly4.getDegree()), inverse);
                zero2 = zero2.add(this.field.buildMonomial(degree, multiply));
                modulusPoly4 = modulusPoly4.subtract(modulusPoly5.multiplyByMonomial(degree, multiply));
            }
            ModulusPoly modulusPoly6 = modulusPoly4;
            modulusPoly4 = modulusPoly5;
            modulusPoly5 = modulusPoly6;
            ModulusPoly modulusPoly7 = one;
            one = zero2.multiply(one).subtract(zero).negative();
            zero = modulusPoly7;
        }
        int coefficient = one.getCoefficient(0);
        if (coefficient == 0) {
            throw ChecksumException.getChecksumInstance();
        }
        int inverse2 = this.field.inverse(coefficient);
        return new ModulusPoly[]{one.multiply(inverse2), modulusPoly5.multiply(inverse2)};
    }

    public int decode(int[] iArr, int i2, int[] iArr2) throws ChecksumException {
        ModulusPoly modulusPoly = new ModulusPoly(this.field, iArr);
        int[] iArr3 = new int[i2];
        boolean z = false;
        for (int i3 = i2; i3 > 0; i3--) {
            int evaluateAt = modulusPoly.evaluateAt(this.field.exp(i3));
            iArr3[i2 - i3] = evaluateAt;
            if (evaluateAt != 0) {
                z = true;
            }
        }
        if (!z) {
            return 0;
        }
        ModulusPoly one = this.field.getOne();
        if (iArr2 != null) {
            for (int i4 : iArr2) {
                int exp = this.field.exp((iArr.length - 1) - i4);
                ModulusGF modulusGF = this.field;
                one = one.multiply(new ModulusPoly(modulusGF, new int[]{modulusGF.subtract(0, exp), 1}));
            }
        }
        ModulusPoly[] runEuclideanAlgorithm = runEuclideanAlgorithm(this.field.buildMonomial(i2, 1), new ModulusPoly(this.field, iArr3), i2);
        ModulusPoly modulusPoly2 = runEuclideanAlgorithm[0];
        ModulusPoly modulusPoly3 = runEuclideanAlgorithm[1];
        int[] findErrorLocations = findErrorLocations(modulusPoly2);
        int[] findErrorMagnitudes = findErrorMagnitudes(modulusPoly3, modulusPoly2, findErrorLocations);
        for (int i5 = 0; i5 < findErrorLocations.length; i5++) {
            int length = (iArr.length - 1) - this.field.log(findErrorLocations[i5]);
            if (length < 0) {
                throw ChecksumException.getChecksumInstance();
            }
            iArr[length] = this.field.subtract(iArr[length], findErrorMagnitudes[i5]);
        }
        return findErrorLocations.length;
    }
}
