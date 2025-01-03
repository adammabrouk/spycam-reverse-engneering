package com.google.zxing.common;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class BitArray implements Cloneable {
    public int[] bits;
    public int size;

    public BitArray() {
        this.size = 0;
        this.bits = new int[1];
    }

    private void ensureCapacity(int i2) {
        if (i2 > this.bits.length * 32) {
            int[] makeArray = makeArray(i2);
            int[] iArr = this.bits;
            System.arraycopy(iArr, 0, makeArray, 0, iArr.length);
            this.bits = makeArray;
        }
    }

    public static int[] makeArray(int i2) {
        return new int[(i2 + 31) / 32];
    }

    public void appendBit(boolean z) {
        ensureCapacity(this.size + 1);
        if (z) {
            int[] iArr = this.bits;
            int i2 = this.size;
            int i3 = i2 / 32;
            iArr[i3] = (1 << (i2 & 31)) | iArr[i3];
        }
        this.size++;
    }

    public void appendBitArray(BitArray bitArray) {
        int i2 = bitArray.size;
        ensureCapacity(this.size + i2);
        for (int i3 = 0; i3 < i2; i3++) {
            appendBit(bitArray.get(i3));
        }
    }

    public void appendBits(int i2, int i3) {
        if (i3 < 0 || i3 > 32) {
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        }
        ensureCapacity(this.size + i3);
        while (i3 > 0) {
            boolean z = true;
            if (((i2 >> (i3 - 1)) & 1) != 1) {
                z = false;
            }
            appendBit(z);
            i3--;
        }
    }

    public void clear() {
        int length = this.bits.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.bits[i2] = 0;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BitArray)) {
            return false;
        }
        BitArray bitArray = (BitArray) obj;
        return this.size == bitArray.size && Arrays.equals(this.bits, bitArray.bits);
    }

    public void flip(int i2) {
        int[] iArr = this.bits;
        int i3 = i2 / 32;
        iArr[i3] = (1 << (i2 & 31)) ^ iArr[i3];
    }

    public boolean get(int i2) {
        return ((1 << (i2 & 31)) & this.bits[i2 / 32]) != 0;
    }

    public int[] getBitArray() {
        return this.bits;
    }

    public int getNextSet(int i2) {
        int i3 = this.size;
        if (i2 >= i3) {
            return i3;
        }
        int i4 = i2 / 32;
        int i5 = (((1 << (i2 & 31)) - 1) ^ (-1)) & this.bits[i4];
        while (i5 == 0) {
            i4++;
            int[] iArr = this.bits;
            if (i4 == iArr.length) {
                return this.size;
            }
            i5 = iArr[i4];
        }
        int numberOfTrailingZeros = (i4 * 32) + Integer.numberOfTrailingZeros(i5);
        int i6 = this.size;
        return numberOfTrailingZeros > i6 ? i6 : numberOfTrailingZeros;
    }

    public int getNextUnset(int i2) {
        int i3 = this.size;
        if (i2 >= i3) {
            return i3;
        }
        int i4 = i2 / 32;
        int i5 = (((1 << (i2 & 31)) - 1) ^ (-1)) & (this.bits[i4] ^ (-1));
        while (i5 == 0) {
            i4++;
            int[] iArr = this.bits;
            if (i4 == iArr.length) {
                return this.size;
            }
            i5 = iArr[i4] ^ (-1);
        }
        int numberOfTrailingZeros = (i4 * 32) + Integer.numberOfTrailingZeros(i5);
        int i6 = this.size;
        return numberOfTrailingZeros > i6 ? i6 : numberOfTrailingZeros;
    }

    public int getSize() {
        return this.size;
    }

    public int getSizeInBytes() {
        return (this.size + 7) / 8;
    }

    public int hashCode() {
        return (this.size * 31) + Arrays.hashCode(this.bits);
    }

    public boolean isRange(int i2, int i3, boolean z) {
        if (i3 < i2 || i2 < 0 || i3 > this.size) {
            throw new IllegalArgumentException();
        }
        if (i3 == i2) {
            return true;
        }
        int i4 = i3 - 1;
        int i5 = i2 / 32;
        int i6 = i4 / 32;
        int i7 = i5;
        while (i7 <= i6) {
            int i8 = (2 << (i7 >= i6 ? 31 & i4 : 31)) - (1 << (i7 > i5 ? 0 : i2 & 31));
            int i9 = this.bits[i7] & i8;
            if (!z) {
                i8 = 0;
            }
            if (i9 != i8) {
                return false;
            }
            i7++;
        }
        return true;
    }

    public void reverse() {
        int[] iArr = new int[this.bits.length];
        int i2 = (this.size - 1) / 32;
        int i3 = i2 + 1;
        for (int i4 = 0; i4 < i3; i4++) {
            long j = this.bits[i4];
            long j2 = ((j & 1431655765) << 1) | ((j >> 1) & 1431655765);
            long j3 = ((j2 & 858993459) << 2) | ((j2 >> 2) & 858993459);
            long j4 = ((j3 & 252645135) << 4) | ((j3 >> 4) & 252645135);
            long j5 = ((j4 & 16711935) << 8) | ((j4 >> 8) & 16711935);
            iArr[i2 - i4] = (int) (((j5 & 65535) << 16) | ((j5 >> 16) & 65535));
        }
        int i5 = this.size;
        int i6 = i3 * 32;
        if (i5 != i6) {
            int i7 = i6 - i5;
            int i8 = iArr[0] >>> i7;
            for (int i9 = 1; i9 < i3; i9++) {
                int i10 = iArr[i9];
                iArr[i9 - 1] = i8 | (i10 << (32 - i7));
                i8 = i10 >>> i7;
            }
            iArr[i3 - 1] = i8;
        }
        this.bits = iArr;
    }

    public void set(int i2) {
        int[] iArr = this.bits;
        int i3 = i2 / 32;
        iArr[i3] = (1 << (i2 & 31)) | iArr[i3];
    }

    public void setBulk(int i2, int i3) {
        this.bits[i2 / 32] = i3;
    }

    public void setRange(int i2, int i3) {
        if (i3 < i2 || i2 < 0 || i3 > this.size) {
            throw new IllegalArgumentException();
        }
        if (i3 == i2) {
            return;
        }
        int i4 = i3 - 1;
        int i5 = i2 / 32;
        int i6 = i4 / 32;
        int i7 = i5;
        while (i7 <= i6) {
            int i8 = 31;
            int i9 = i7 > i5 ? 0 : i2 & 31;
            if (i7 >= i6) {
                i8 = 31 & i4;
            }
            int i10 = (2 << i8) - (1 << i9);
            int[] iArr = this.bits;
            iArr[i7] = i10 | iArr[i7];
            i7++;
        }
    }

    public void toBytes(int i2, byte[] bArr, int i3, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = 0;
            for (int i7 = 0; i7 < 8; i7++) {
                if (get(i2)) {
                    i6 |= 1 << (7 - i7);
                }
                i2++;
            }
            bArr[i3 + i5] = (byte) i6;
        }
    }

    public String toString() {
        int i2 = this.size;
        StringBuilder sb = new StringBuilder(i2 + (i2 / 8) + 1);
        for (int i3 = 0; i3 < this.size; i3++) {
            if ((i3 & 7) == 0) {
                sb.append(' ');
            }
            sb.append(get(i3) ? 'X' : '.');
        }
        return sb.toString();
    }

    public void xor(BitArray bitArray) {
        if (this.size != bitArray.size) {
            throw new IllegalArgumentException("Sizes don't match");
        }
        int i2 = 0;
        while (true) {
            int[] iArr = this.bits;
            if (i2 >= iArr.length) {
                return;
            }
            iArr[i2] = iArr[i2] ^ bitArray.bits[i2];
            i2++;
        }
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public BitArray m574clone() {
        return new BitArray((int[]) this.bits.clone(), this.size);
    }

    public BitArray(int i2) {
        this.size = i2;
        this.bits = makeArray(i2);
    }

    public BitArray(int[] iArr, int i2) {
        this.bits = iArr;
        this.size = i2;
    }
}
