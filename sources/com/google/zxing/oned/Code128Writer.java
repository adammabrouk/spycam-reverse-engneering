package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class Code128Writer extends OneDimensionalCodeWriter {
    public static final int CODE_CODE_A = 101;
    public static final int CODE_CODE_B = 100;
    public static final int CODE_CODE_C = 99;
    public static final int CODE_FNC_1 = 102;
    public static final int CODE_FNC_2 = 97;
    public static final int CODE_FNC_3 = 96;
    public static final int CODE_FNC_4_A = 101;
    public static final int CODE_FNC_4_B = 100;
    public static final int CODE_START_A = 103;
    public static final int CODE_START_B = 104;
    public static final int CODE_START_C = 105;
    public static final int CODE_STOP = 106;
    public static final char ESCAPE_FNC_1 = 241;
    public static final char ESCAPE_FNC_2 = 242;
    public static final char ESCAPE_FNC_3 = 243;
    public static final char ESCAPE_FNC_4 = 244;

    public enum CType {
        UNCODABLE,
        ONE_DIGIT,
        TWO_DIGITS,
        FNC_1;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static CType[] valuesCustom() {
            CType[] valuesCustom = values();
            int length = valuesCustom.length;
            CType[] cTypeArr = new CType[length];
            System.arraycopy(valuesCustom, 0, cTypeArr, 0, length);
            return cTypeArr;
        }
    }

    public static int chooseCode(CharSequence charSequence, int i2, int i3) {
        CType findCType;
        CType findCType2;
        char charAt;
        CType findCType3 = findCType(charSequence, i2);
        if (findCType3 == CType.ONE_DIGIT) {
            return 100;
        }
        if (findCType3 == CType.UNCODABLE) {
            return (i2 >= charSequence.length() || ((charAt = charSequence.charAt(i2)) >= ' ' && (i3 != 101 || charAt >= '`'))) ? 100 : 101;
        }
        if (i3 == 99) {
            return 99;
        }
        if (i3 != 100) {
            if (findCType3 == CType.FNC_1) {
                findCType3 = findCType(charSequence, i2 + 1);
            }
            return findCType3 == CType.TWO_DIGITS ? 99 : 100;
        }
        if (findCType3 == CType.FNC_1 || (findCType = findCType(charSequence, i2 + 2)) == CType.UNCODABLE || findCType == CType.ONE_DIGIT) {
            return 100;
        }
        if (findCType == CType.FNC_1) {
            return findCType(charSequence, i2 + 3) == CType.TWO_DIGITS ? 99 : 100;
        }
        int i4 = i2 + 4;
        while (true) {
            findCType2 = findCType(charSequence, i4);
            if (findCType2 != CType.TWO_DIGITS) {
                break;
            }
            i4 += 2;
        }
        return findCType2 == CType.ONE_DIGIT ? 100 : 99;
    }

    public static CType findCType(CharSequence charSequence, int i2) {
        int length = charSequence.length();
        if (i2 >= length) {
            return CType.UNCODABLE;
        }
        char charAt = charSequence.charAt(i2);
        if (charAt == 241) {
            return CType.FNC_1;
        }
        if (charAt < '0' || charAt > '9') {
            return CType.UNCODABLE;
        }
        int i3 = i2 + 1;
        if (i3 >= length) {
            return CType.ONE_DIGIT;
        }
        char charAt2 = charSequence.charAt(i3);
        return (charAt2 < '0' || charAt2 > '9') ? CType.ONE_DIGIT : CType.TWO_DIGITS;
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.CODE_128) {
            return super.encode(str, barcodeFormat, i2, i3, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_128, but got " + barcodeFormat);
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(String str) {
        int length = str.length();
        if (length >= 1 && length <= 80) {
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                char charAt = str.charAt(i3);
                switch (charAt) {
                    case 241:
                    case 242:
                    case 243:
                    case 244:
                        break;
                    default:
                        if (charAt > 127) {
                            throw new IllegalArgumentException("Bad character in input: " + charAt);
                        }
                        break;
                }
            }
            ArrayList<int[]> arrayList = new ArrayList();
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 1;
            while (true) {
                int i8 = 103;
                if (i4 >= length) {
                    arrayList.add(Code128Reader.CODE_PATTERNS[i6 % 103]);
                    arrayList.add(Code128Reader.CODE_PATTERNS[106]);
                    int i9 = 0;
                    for (int[] iArr : arrayList) {
                        for (int i10 : iArr) {
                            i9 += i10;
                        }
                    }
                    boolean[] zArr = new boolean[i9];
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        i2 += OneDimensionalCodeWriter.appendPattern(zArr, i2, (int[]) it.next(), true);
                    }
                    return zArr;
                }
                int chooseCode = chooseCode(str, i4, i5);
                int i11 = 100;
                if (chooseCode == i5) {
                    switch (str.charAt(i4)) {
                        case 241:
                            i11 = 102;
                            break;
                        case 242:
                            i11 = 97;
                            break;
                        case 243:
                            i11 = 96;
                            break;
                        case 244:
                            if (i5 == 101) {
                                i11 = 101;
                                break;
                            }
                            break;
                        default:
                            if (i5 != 100) {
                                if (i5 == 101) {
                                    i11 = str.charAt(i4) - ' ';
                                    if (i11 < 0) {
                                        i11 += 96;
                                        break;
                                    }
                                } else {
                                    i11 = Integer.parseInt(str.substring(i4, i4 + 2));
                                    i4++;
                                    break;
                                }
                            } else {
                                i11 = str.charAt(i4) - ' ';
                                break;
                            }
                            break;
                    }
                    i4++;
                } else {
                    if (i5 != 0) {
                        i8 = chooseCode;
                    } else if (chooseCode == 100) {
                        i8 = 104;
                    } else if (chooseCode != 101) {
                        i8 = 105;
                    }
                    i11 = i8;
                    i5 = chooseCode;
                }
                arrayList.add(Code128Reader.CODE_PATTERNS[i11]);
                i6 += i11 * i7;
                if (i4 != 0) {
                    i7++;
                }
            }
        } else {
            throw new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got " + length);
        }
    }
}
