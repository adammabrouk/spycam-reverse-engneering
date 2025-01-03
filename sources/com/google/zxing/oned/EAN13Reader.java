package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

/* loaded from: classes.dex */
public final class EAN13Reader extends UPCEANReader {
    public static final int[] FIRST_DIGIT_ENCODINGS = {0, 11, 13, 14, 19, 25, 28, 21, 22, 26};
    public final int[] decodeMiddleCounters = new int[4];

    public static void determineFirstDigit(StringBuilder sb, int i2) throws NotFoundException {
        for (int i3 = 0; i3 < 10; i3++) {
            if (i2 == FIRST_DIGIT_ENCODINGS[i3]) {
                sb.insert(0, (char) (i3 + 48));
                return;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // com.google.zxing.oned.UPCEANReader
    public int decodeMiddle(BitArray bitArray, int[] iArr, StringBuilder sb) throws NotFoundException {
        int[] iArr2 = this.decodeMiddleCounters;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int size = bitArray.getSize();
        int i2 = iArr[1];
        int i3 = 0;
        for (int i4 = 0; i4 < 6 && i2 < size; i4++) {
            int decodeDigit = UPCEANReader.decodeDigit(bitArray, iArr2, i2, UPCEANReader.L_AND_G_PATTERNS);
            sb.append((char) ((decodeDigit % 10) + 48));
            for (int i5 : iArr2) {
                i2 += i5;
            }
            if (decodeDigit >= 10) {
                i3 |= 1 << (5 - i4);
            }
        }
        determineFirstDigit(sb, i3);
        int i6 = UPCEANReader.findGuardPattern(bitArray, i2, true, UPCEANReader.MIDDLE_PATTERN)[1];
        for (int i7 = 0; i7 < 6 && i6 < size; i7++) {
            sb.append((char) (UPCEANReader.decodeDigit(bitArray, iArr2, i6, UPCEANReader.L_PATTERNS) + 48));
            for (int i8 : iArr2) {
                i6 += i8;
            }
        }
        return i6;
    }

    @Override // com.google.zxing.oned.UPCEANReader
    public BarcodeFormat getBarcodeFormat() {
        return BarcodeFormat.EAN_13;
    }
}
