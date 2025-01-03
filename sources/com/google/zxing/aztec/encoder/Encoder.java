package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonEncoder;

/* loaded from: classes.dex */
public final class Encoder {
    public static final int DEFAULT_AZTEC_LAYERS = 0;
    public static final int DEFAULT_EC_PERCENT = 33;
    public static final int MAX_NB_BITS = 32;
    public static final int MAX_NB_BITS_COMPACT = 4;
    public static final int[] WORD_SIZE = {4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    public static int[] bitsToWords(BitArray bitArray, int i2, int i3) {
        int[] iArr = new int[i3];
        int size = bitArray.getSize() / i2;
        for (int i4 = 0; i4 < size; i4++) {
            int i5 = 0;
            for (int i6 = 0; i6 < i2; i6++) {
                i5 |= bitArray.get((i4 * i2) + i6) ? 1 << ((i2 - i6) - 1) : 0;
            }
            iArr[i4] = i5;
        }
        return iArr;
    }

    public static void drawBullsEye(BitMatrix bitMatrix, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4 += 2) {
            int i5 = i2 - i4;
            int i6 = i5;
            while (true) {
                int i7 = i2 + i4;
                if (i6 > i7) {
                    break;
                }
                bitMatrix.set(i6, i5);
                bitMatrix.set(i6, i7);
                bitMatrix.set(i5, i6);
                bitMatrix.set(i7, i6);
                i6++;
            }
        }
        int i8 = i2 - i3;
        bitMatrix.set(i8, i8);
        int i9 = i8 + 1;
        bitMatrix.set(i9, i8);
        bitMatrix.set(i8, i9);
        int i10 = i2 + i3;
        bitMatrix.set(i10, i8);
        bitMatrix.set(i10, i9);
        bitMatrix.set(i10, i10 - 1);
    }

    public static void drawModeMessage(BitMatrix bitMatrix, boolean z, int i2, BitArray bitArray) {
        int i3 = i2 / 2;
        int i4 = 0;
        if (z) {
            while (i4 < 7) {
                int i5 = (i3 - 3) + i4;
                if (bitArray.get(i4)) {
                    bitMatrix.set(i5, i3 - 5);
                }
                if (bitArray.get(i4 + 7)) {
                    bitMatrix.set(i3 + 5, i5);
                }
                if (bitArray.get(20 - i4)) {
                    bitMatrix.set(i5, i3 + 5);
                }
                if (bitArray.get(27 - i4)) {
                    bitMatrix.set(i3 - 5, i5);
                }
                i4++;
            }
            return;
        }
        while (i4 < 10) {
            int i6 = (i3 - 5) + i4 + (i4 / 5);
            if (bitArray.get(i4)) {
                bitMatrix.set(i6, i3 - 7);
            }
            if (bitArray.get(i4 + 10)) {
                bitMatrix.set(i3 + 7, i6);
            }
            if (bitArray.get(29 - i4)) {
                bitMatrix.set(i6, i3 + 7);
            }
            if (bitArray.get(39 - i4)) {
                bitMatrix.set(i3 - 7, i6);
            }
            i4++;
        }
    }

    public static AztecCode encode(byte[] bArr) {
        return encode(bArr, 33, 0);
    }

    public static BitArray generateCheckWords(BitArray bitArray, int i2, int i3) {
        int size = bitArray.getSize() / i3;
        ReedSolomonEncoder reedSolomonEncoder = new ReedSolomonEncoder(getGF(i3));
        int i4 = i2 / i3;
        int[] bitsToWords = bitsToWords(bitArray, i3, i4);
        reedSolomonEncoder.encode(bitsToWords, i4 - size);
        BitArray bitArray2 = new BitArray();
        bitArray2.appendBits(0, i2 % i3);
        for (int i5 : bitsToWords) {
            bitArray2.appendBits(i5, i3);
        }
        return bitArray2;
    }

    public static BitArray generateModeMessage(boolean z, int i2, int i3) {
        BitArray bitArray = new BitArray();
        if (z) {
            bitArray.appendBits(i2 - 1, 2);
            bitArray.appendBits(i3 - 1, 6);
            return generateCheckWords(bitArray, 28, 4);
        }
        bitArray.appendBits(i2 - 1, 5);
        bitArray.appendBits(i3 - 1, 11);
        return generateCheckWords(bitArray, 40, 4);
    }

    public static GenericGF getGF(int i2) {
        if (i2 == 4) {
            return GenericGF.AZTEC_PARAM;
        }
        if (i2 == 6) {
            return GenericGF.AZTEC_DATA_6;
        }
        if (i2 == 8) {
            return GenericGF.AZTEC_DATA_8;
        }
        if (i2 == 10) {
            return GenericGF.AZTEC_DATA_10;
        }
        if (i2 == 12) {
            return GenericGF.AZTEC_DATA_12;
        }
        throw new IllegalArgumentException("Unsupported word size " + i2);
    }

    public static BitArray stuffBits(BitArray bitArray, int i2) {
        BitArray bitArray2 = new BitArray();
        int size = bitArray.getSize();
        int i3 = (1 << i2) - 2;
        int i4 = 0;
        while (i4 < size) {
            int i5 = 0;
            for (int i6 = 0; i6 < i2; i6++) {
                int i7 = i4 + i6;
                if (i7 >= size || bitArray.get(i7)) {
                    i5 |= 1 << ((i2 - 1) - i6);
                }
            }
            int i8 = i5 & i3;
            if (i8 == i3) {
                bitArray2.appendBits(i8, i2);
            } else if (i8 == 0) {
                bitArray2.appendBits(i5 | 1, i2);
            } else {
                bitArray2.appendBits(i5, i2);
                i4 += i2;
            }
            i4--;
            i4 += i2;
        }
        return bitArray2;
    }

    public static int totalBitsInLayer(int i2, boolean z) {
        return ((z ? 88 : 112) + (i2 * 16)) * i2;
    }

    public static AztecCode encode(byte[] bArr, int i2, int i3) {
        boolean z;
        int i4;
        BitArray bitArray;
        int i5;
        int i6;
        int i7;
        BitArray encode = new HighLevelEncoder(bArr).encode();
        int size = ((encode.getSize() * i2) / 100) + 11;
        int size2 = encode.getSize() + size;
        if (i3 == 0) {
            BitArray bitArray2 = null;
            int i8 = 0;
            int i9 = 0;
            while (i8 <= 32) {
                z = i8 <= 3;
                i4 = z ? i8 + 1 : i8;
                int i10 = totalBitsInLayer(i4, z);
                if (size2 <= i10) {
                    if (bitArray2 == null || i9 != WORD_SIZE[i4]) {
                        int i11 = WORD_SIZE[i4];
                        i9 = i11;
                        bitArray2 = stuffBits(encode, i11);
                    }
                    int i12 = i10 - (i10 % i9);
                    if ((!z || bitArray2.getSize() <= i9 * 64) && bitArray2.getSize() + size <= i12) {
                        bitArray = bitArray2;
                        i5 = i9;
                        i6 = i10;
                    }
                }
                i8++;
            }
            throw new IllegalArgumentException("Data too large for an Aztec code");
        }
        boolean z2 = i3 < 0;
        int abs = Math.abs(i3);
        if (abs > (z2 ? 4 : 32)) {
            throw new IllegalArgumentException(String.format("Illegal value %s for layers", Integer.valueOf(i3)));
        }
        i6 = totalBitsInLayer(abs, z2);
        i5 = WORD_SIZE[abs];
        int i13 = i6 - (i6 % i5);
        bitArray = stuffBits(encode, i5);
        if (bitArray.getSize() + size > i13) {
            throw new IllegalArgumentException("Data to large for user specified layer");
        }
        if (z2 && bitArray.getSize() > i5 * 64) {
            throw new IllegalArgumentException("Data to large for user specified layer");
        }
        z = z2;
        i4 = abs;
        BitArray generateCheckWords = generateCheckWords(bitArray, i6, i5);
        int size3 = bitArray.getSize() / i5;
        BitArray generateModeMessage = generateModeMessage(z, i4, size3);
        int i14 = (z ? 11 : 14) + (i4 * 4);
        int[] iArr = new int[i14];
        int i15 = 2;
        if (z) {
            for (int i16 = 0; i16 < i14; i16++) {
                iArr[i16] = i16;
            }
            i7 = i14;
        } else {
            int i17 = i14 / 2;
            int i18 = i14 + 1 + (((i17 - 1) / 15) * 2);
            int i19 = i18 / 2;
            int i20 = 0;
            while (i20 < i17) {
                int i21 = (i20 / 15) + i20;
                iArr[(i17 - i20) - 1] = (i19 - i21) - 1;
                iArr[i17 + i20] = i19 + i21 + 1;
                i20++;
                i15 = 2;
            }
            i7 = i18;
        }
        BitMatrix bitMatrix = new BitMatrix(i7);
        int i22 = 0;
        for (int i23 = 0; i23 < i4; i23++) {
            int i24 = ((i4 - i23) * 4) + (z ? 9 : 12);
            for (int i25 = 0; i25 < i24; i25++) {
                int i26 = i25 * 2;
                int i27 = 0;
                while (i27 < i15) {
                    if (generateCheckWords.get(i22 + i26 + i27)) {
                        int i28 = i23 * 2;
                        bitMatrix.set(iArr[i28 + i27], iArr[i28 + i25]);
                    }
                    if (generateCheckWords.get(i22 + (i24 * 2) + i26 + i27)) {
                        int i29 = i23 * 2;
                        bitMatrix.set(iArr[i29 + i25], iArr[((i14 - 1) - i29) - i27]);
                    }
                    if (generateCheckWords.get(i22 + (i24 * 4) + i26 + i27)) {
                        int i30 = (i14 - 1) - (i23 * 2);
                        bitMatrix.set(iArr[i30 - i27], iArr[i30 - i25]);
                    }
                    if (generateCheckWords.get(i22 + (i24 * 6) + i26 + i27)) {
                        int i31 = i23 * 2;
                        bitMatrix.set(iArr[((i14 - 1) - i31) - i25], iArr[i31 + i27]);
                    }
                    i27++;
                    i15 = 2;
                }
            }
            i22 += i24 * 8;
        }
        drawModeMessage(bitMatrix, z, i7, generateModeMessage);
        if (z) {
            drawBullsEye(bitMatrix, i7 / 2, 5);
        } else {
            int i32 = i7 / 2;
            drawBullsEye(bitMatrix, i32, 7);
            int i33 = 0;
            int i34 = 0;
            while (i33 < (i14 / 2) - 1) {
                for (int i35 = i32 & 1; i35 < i7; i35 += 2) {
                    int i36 = i32 - i34;
                    bitMatrix.set(i36, i35);
                    int i37 = i32 + i34;
                    bitMatrix.set(i37, i35);
                    bitMatrix.set(i35, i36);
                    bitMatrix.set(i35, i37);
                }
                i33 += 15;
                i34 += 16;
            }
        }
        AztecCode aztecCode = new AztecCode();
        aztecCode.setCompact(z);
        aztecCode.setSize(i7);
        aztecCode.setLayers(i4);
        aztecCode.setCodeWords(size3);
        aztecCode.setMatrix(bitMatrix);
        return aztecCode;
    }
}
