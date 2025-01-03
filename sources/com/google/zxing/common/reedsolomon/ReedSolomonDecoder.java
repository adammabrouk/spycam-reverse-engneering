package com.google.zxing.common.reedsolomon;

/* loaded from: classes.dex */
public final class ReedSolomonDecoder {
    public final GenericGF field;

    public ReedSolomonDecoder(GenericGF genericGF) {
        this.field = genericGF;
    }

    private int[] findErrorLocations(GenericGFPoly genericGFPoly) throws ReedSolomonException {
        int degree = genericGFPoly.getDegree();
        int i2 = 0;
        if (degree == 1) {
            return new int[]{genericGFPoly.getCoefficient(1)};
        }
        int[] iArr = new int[degree];
        for (int i3 = 1; i3 < this.field.getSize() && i2 < degree; i3++) {
            if (genericGFPoly.evaluateAt(i3) == 0) {
                iArr[i2] = this.field.inverse(i3);
                i2++;
            }
        }
        if (i2 == degree) {
            return iArr;
        }
        throw new ReedSolomonException("Error locator degree does not match number of roots");
    }

    private int[] findErrorMagnitudes(GenericGFPoly genericGFPoly, int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            int inverse = this.field.inverse(iArr[i2]);
            int i3 = 1;
            for (int i4 = 0; i4 < length; i4++) {
                if (i2 != i4) {
                    int multiply = this.field.multiply(iArr[i4], inverse);
                    i3 = this.field.multiply(i3, (multiply & 1) == 0 ? multiply | 1 : multiply & (-2));
                }
            }
            iArr2[i2] = this.field.multiply(genericGFPoly.evaluateAt(inverse), this.field.inverse(i3));
            if (this.field.getGeneratorBase() != 0) {
                iArr2[i2] = this.field.multiply(iArr2[i2], inverse);
            }
        }
        return iArr2;
    }

    private GenericGFPoly[] runEuclideanAlgorithm(GenericGFPoly genericGFPoly, GenericGFPoly genericGFPoly2, int i2) throws ReedSolomonException {
        if (genericGFPoly.getDegree() < genericGFPoly2.getDegree()) {
            genericGFPoly2 = genericGFPoly;
            genericGFPoly = genericGFPoly2;
        }
        GenericGFPoly zero = this.field.getZero();
        GenericGFPoly one = this.field.getOne();
        GenericGFPoly genericGFPoly3 = genericGFPoly2;
        GenericGFPoly genericGFPoly4 = genericGFPoly;
        GenericGFPoly genericGFPoly5 = genericGFPoly3;
        while (genericGFPoly5.getDegree() >= i2 / 2) {
            if (genericGFPoly5.isZero()) {
                throw new ReedSolomonException("r_{i-1} was zero");
            }
            GenericGFPoly zero2 = this.field.getZero();
            int inverse = this.field.inverse(genericGFPoly5.getCoefficient(genericGFPoly5.getDegree()));
            while (genericGFPoly4.getDegree() >= genericGFPoly5.getDegree() && !genericGFPoly4.isZero()) {
                int degree = genericGFPoly4.getDegree() - genericGFPoly5.getDegree();
                int multiply = this.field.multiply(genericGFPoly4.getCoefficient(genericGFPoly4.getDegree()), inverse);
                zero2 = zero2.addOrSubtract(this.field.buildMonomial(degree, multiply));
                genericGFPoly4 = genericGFPoly4.addOrSubtract(genericGFPoly5.multiplyByMonomial(degree, multiply));
            }
            GenericGFPoly addOrSubtract = zero2.multiply(one).addOrSubtract(zero);
            if (genericGFPoly4.getDegree() >= genericGFPoly5.getDegree()) {
                throw new IllegalStateException("Division algorithm failed to reduce polynomial?");
            }
            GenericGFPoly genericGFPoly6 = genericGFPoly4;
            genericGFPoly4 = genericGFPoly5;
            genericGFPoly5 = genericGFPoly6;
            GenericGFPoly genericGFPoly7 = one;
            one = addOrSubtract;
            zero = genericGFPoly7;
        }
        int coefficient = one.getCoefficient(0);
        if (coefficient == 0) {
            throw new ReedSolomonException("sigmaTilde(0) was zero");
        }
        int inverse2 = this.field.inverse(coefficient);
        return new GenericGFPoly[]{one.multiply(inverse2), genericGFPoly5.multiply(inverse2)};
    }

    public void decode(int[] iArr, int i2) throws ReedSolomonException {
        GenericGFPoly genericGFPoly = new GenericGFPoly(this.field, iArr);
        int[] iArr2 = new int[i2];
        boolean z = true;
        for (int i3 = 0; i3 < i2; i3++) {
            GenericGF genericGF = this.field;
            int evaluateAt = genericGFPoly.evaluateAt(genericGF.exp(genericGF.getGeneratorBase() + i3));
            iArr2[(i2 - 1) - i3] = evaluateAt;
            if (evaluateAt != 0) {
                z = false;
            }
        }
        if (z) {
            return;
        }
        GenericGFPoly[] runEuclideanAlgorithm = runEuclideanAlgorithm(this.field.buildMonomial(i2, 1), new GenericGFPoly(this.field, iArr2), i2);
        GenericGFPoly genericGFPoly2 = runEuclideanAlgorithm[0];
        GenericGFPoly genericGFPoly3 = runEuclideanAlgorithm[1];
        int[] findErrorLocations = findErrorLocations(genericGFPoly2);
        int[] findErrorMagnitudes = findErrorMagnitudes(genericGFPoly3, findErrorLocations);
        for (int i4 = 0; i4 < findErrorLocations.length; i4++) {
            int length = (iArr.length - 1) - this.field.log(findErrorLocations[i4]);
            if (length < 0) {
                throw new ReedSolomonException("Bad error location");
            }
            iArr[length] = GenericGF.addOrSubtract(iArr[length], findErrorMagnitudes[i4]);
        }
    }
}
