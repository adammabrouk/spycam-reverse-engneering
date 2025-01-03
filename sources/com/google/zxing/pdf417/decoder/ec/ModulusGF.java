package com.google.zxing.pdf417.decoder.ec;

import com.google.zxing.pdf417.PDF417Common;

/* loaded from: classes.dex */
public final class ModulusGF {
    public static final ModulusGF PDF417_GF = new ModulusGF(PDF417Common.NUMBER_OF_CODEWORDS, 3);
    public final int[] expTable;
    public final int[] logTable;
    public final int modulus;
    public final ModulusPoly one;
    public final ModulusPoly zero;

    public ModulusGF(int i2, int i3) {
        this.modulus = i2;
        this.expTable = new int[i2];
        this.logTable = new int[i2];
        int i4 = 1;
        for (int i5 = 0; i5 < i2; i5++) {
            this.expTable[i5] = i4;
            i4 = (i4 * i3) % i2;
        }
        for (int i6 = 0; i6 < i2 - 1; i6++) {
            this.logTable[this.expTable[i6]] = i6;
        }
        this.zero = new ModulusPoly(this, new int[1]);
        this.one = new ModulusPoly(this, new int[]{1});
    }

    public int add(int i2, int i3) {
        return (i2 + i3) % this.modulus;
    }

    public ModulusPoly buildMonomial(int i2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        }
        if (i3 == 0) {
            return this.zero;
        }
        int[] iArr = new int[i2 + 1];
        iArr[0] = i3;
        return new ModulusPoly(this, iArr);
    }

    public int exp(int i2) {
        return this.expTable[i2];
    }

    public ModulusPoly getOne() {
        return this.one;
    }

    public int getSize() {
        return this.modulus;
    }

    public ModulusPoly getZero() {
        return this.zero;
    }

    public int inverse(int i2) {
        if (i2 != 0) {
            return this.expTable[(this.modulus - this.logTable[i2]) - 1];
        }
        throw new ArithmeticException();
    }

    public int log(int i2) {
        if (i2 != 0) {
            return this.logTable[i2];
        }
        throw new IllegalArgumentException();
    }

    public int multiply(int i2, int i3) {
        if (i2 == 0 || i3 == 0) {
            return 0;
        }
        int[] iArr = this.expTable;
        int[] iArr2 = this.logTable;
        return iArr[(iArr2[i2] + iArr2[i3]) % (this.modulus - 1)];
    }

    public int subtract(int i2, int i3) {
        int i4 = this.modulus;
        return ((i2 + i4) - i3) % i4;
    }
}
