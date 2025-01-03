package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.EnumMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class UPCEANExtension5Support {
    public static final int[] CHECK_DIGIT_ENCODINGS = {24, 20, 18, 17, 12, 6, 3, 10, 9, 5};
    public final int[] decodeMiddleCounters = new int[4];
    public final StringBuilder decodeRowStringBuffer = new StringBuilder();

    private int decodeMiddle(BitArray bitArray, int[] iArr, StringBuilder sb) throws NotFoundException {
        int[] iArr2 = this.decodeMiddleCounters;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int size = bitArray.getSize();
        int i2 = iArr[1];
        int i3 = 0;
        for (int i4 = 0; i4 < 5 && i2 < size; i4++) {
            int decodeDigit = UPCEANReader.decodeDigit(bitArray, iArr2, i2, UPCEANReader.L_AND_G_PATTERNS);
            sb.append((char) ((decodeDigit % 10) + 48));
            for (int i5 : iArr2) {
                i2 += i5;
            }
            if (decodeDigit >= 10) {
                i3 |= 1 << (4 - i4);
            }
            if (i4 != 4) {
                i2 = bitArray.getNextUnset(bitArray.getNextSet(i2));
            }
        }
        if (sb.length() != 5) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (extensionChecksum(sb.toString()) == determineCheckDigit(i3)) {
            return i2;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public static int determineCheckDigit(int i2) throws NotFoundException {
        for (int i3 = 0; i3 < 10; i3++) {
            if (i2 == CHECK_DIGIT_ENCODINGS[i3]) {
                return i3;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public static int extensionChecksum(CharSequence charSequence) {
        int length = charSequence.length();
        int i2 = 0;
        for (int i3 = length - 2; i3 >= 0; i3 -= 2) {
            i2 += charSequence.charAt(i3) - '0';
        }
        int i4 = i2 * 3;
        for (int i5 = length - 1; i5 >= 0; i5 -= 2) {
            i4 += charSequence.charAt(i5) - '0';
        }
        return (i4 * 3) % 10;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static String parseExtension5String(String str) {
        String valueOf;
        char charAt = str.charAt(0);
        String str2 = "";
        if (charAt == '0') {
            str2 = "£";
        } else if (charAt == '5') {
            str2 = "$";
        } else if (charAt == '9') {
            switch (str.hashCode()) {
                case 54118329:
                    if (str.equals("90000")) {
                        return null;
                    }
                    break;
                case 54395376:
                    if (str.equals("99990")) {
                        return "Used";
                    }
                    break;
                case 54395377:
                    if (str.equals("99991")) {
                        return "0.00";
                    }
                    break;
            }
        }
        int parseInt = Integer.parseInt(str.substring(1));
        String valueOf2 = String.valueOf(parseInt / 100);
        int i2 = parseInt % 100;
        if (i2 < 10) {
            valueOf = "0" + i2;
        } else {
            valueOf = String.valueOf(i2);
        }
        return str2 + valueOf2 + '.' + valueOf;
    }

    public static Map<ResultMetadataType, Object> parseExtensionString(String str) {
        String parseExtension5String;
        if (str.length() != 5 || (parseExtension5String = parseExtension5String(str)) == null) {
            return null;
        }
        EnumMap enumMap = new EnumMap(ResultMetadataType.class);
        enumMap.put((EnumMap) ResultMetadataType.SUGGESTED_PRICE, (ResultMetadataType) parseExtension5String);
        return enumMap;
    }

    public Result decodeRow(int i2, BitArray bitArray, int[] iArr) throws NotFoundException {
        StringBuilder sb = this.decodeRowStringBuffer;
        sb.setLength(0);
        int decodeMiddle = decodeMiddle(bitArray, iArr, sb);
        String sb2 = sb.toString();
        Map<ResultMetadataType, Object> parseExtensionString = parseExtensionString(sb2);
        float f2 = i2;
        Result result = new Result(sb2, null, new ResultPoint[]{new ResultPoint((iArr[0] + iArr[1]) / 2.0f, f2), new ResultPoint(decodeMiddle, f2)}, BarcodeFormat.UPC_EAN_EXTENSION);
        if (parseExtensionString != null) {
            result.putAllMetadata(parseExtensionString);
        }
        return result;
    }
}
