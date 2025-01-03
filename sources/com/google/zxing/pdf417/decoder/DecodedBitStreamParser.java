package com.google.zxing.pdf417.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.pdf417.PDF417ResultMetadata;
import java.math.BigInteger;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class DecodedBitStreamParser {
    public static /* synthetic */ int[] $SWITCH_TABLE$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode = null;
    public static final int AL = 28;
    public static final int AS = 27;
    public static final int BEGIN_MACRO_PDF417_CONTROL_BLOCK = 928;
    public static final int BEGIN_MACRO_PDF417_OPTIONAL_FIELD = 923;
    public static final int BYTE_COMPACTION_MODE_LATCH = 901;
    public static final int BYTE_COMPACTION_MODE_LATCH_6 = 924;
    public static final int ECI_CHARSET = 927;
    public static final int ECI_GENERAL_PURPOSE = 926;
    public static final int ECI_USER_DEFINED = 925;
    public static final BigInteger[] EXP900;
    public static final int LL = 27;
    public static final int MACRO_PDF417_OPTIONAL_FIELD_ADDRESSEE = 4;
    public static final int MACRO_PDF417_OPTIONAL_FIELD_CHECKSUM = 6;
    public static final int MACRO_PDF417_OPTIONAL_FIELD_FILE_NAME = 0;
    public static final int MACRO_PDF417_OPTIONAL_FIELD_FILE_SIZE = 5;
    public static final int MACRO_PDF417_OPTIONAL_FIELD_SEGMENT_COUNT = 1;
    public static final int MACRO_PDF417_OPTIONAL_FIELD_SENDER = 3;
    public static final int MACRO_PDF417_OPTIONAL_FIELD_TIME_STAMP = 2;
    public static final int MACRO_PDF417_TERMINATOR = 922;
    public static final int MAX_NUMERIC_CODEWORDS = 15;
    public static final int ML = 28;
    public static final int MODE_SHIFT_TO_BYTE_COMPACTION_MODE = 913;
    public static final int NUMBER_OF_SEQUENCE_CODEWORDS = 2;
    public static final int NUMERIC_COMPACTION_MODE_LATCH = 902;
    public static final int PAL = 29;
    public static final int PL = 25;
    public static final int PS = 29;
    public static final int TEXT_COMPACTION_MODE_LATCH = 900;
    public static final char[] PUNCT_CHARS = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();
    public static final char[] MIXED_CHARS = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();

    public enum Mode {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static Mode[] valuesCustom() {
            Mode[] valuesCustom = values();
            int length = valuesCustom.length;
            Mode[] modeArr = new Mode[length];
            System.arraycopy(valuesCustom, 0, modeArr, 0, length);
            return modeArr;
        }
    }

    public static /* synthetic */ int[] $SWITCH_TABLE$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode() {
        int[] iArr = $SWITCH_TABLE$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[Mode.valuesCustom().length];
        try {
            iArr2[Mode.ALPHA.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[Mode.ALPHA_SHIFT.ordinal()] = 5;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[Mode.LOWER.ordinal()] = 2;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[Mode.MIXED.ordinal()] = 3;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[Mode.PUNCT.ordinal()] = 4;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr2[Mode.PUNCT_SHIFT.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        $SWITCH_TABLE$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode = iArr2;
        return iArr2;
    }

    static {
        BigInteger[] bigIntegerArr = new BigInteger[16];
        EXP900 = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger valueOf = BigInteger.valueOf(900L);
        EXP900[1] = valueOf;
        int i2 = 2;
        while (true) {
            BigInteger[] bigIntegerArr2 = EXP900;
            if (i2 >= bigIntegerArr2.length) {
                return;
            }
            bigIntegerArr2[i2] = bigIntegerArr2[i2 - 1].multiply(valueOf);
            i2++;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:45:0x007b. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:46:0x007e. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0048 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0021 A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00ab A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int byteCompaction(int r16, int[] r17, java.nio.charset.Charset r18, int r19, java.lang.StringBuilder r20) {
        /*
            Method dump skipped, instructions count: 268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.DecodedBitStreamParser.byteCompaction(int, int[], java.nio.charset.Charset, int, java.lang.StringBuilder):int");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.zxing.common.DecoderResult decode(int[] r7, java.lang.String r8) throws com.google.zxing.FormatException {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            int r1 = r7.length
            r2 = 2
            int r1 = r1 * 2
            r0.<init>(r1)
            java.nio.charset.Charset r1 = java.nio.charset.StandardCharsets.ISO_8859_1
            r3 = 1
            r3 = r7[r3]
            com.google.zxing.pdf417.PDF417ResultMetadata r4 = new com.google.zxing.pdf417.PDF417ResultMetadata
            r4.<init>()
        L13:
            r5 = 0
            r5 = r7[r5]
            if (r2 < r5) goto L31
            int r7 = r0.length()
            if (r7 == 0) goto L2c
            com.google.zxing.common.DecoderResult r7 = new com.google.zxing.common.DecoderResult
            java.lang.String r0 = r0.toString()
            r1 = 0
            r7.<init>(r1, r0, r1, r8)
            r7.setOther(r4)
            return r7
        L2c:
            com.google.zxing.FormatException r7 = com.google.zxing.FormatException.getFormatInstance()
            throw r7
        L31:
            r5 = 913(0x391, float:1.28E-42)
            if (r3 == r5) goto L75
            switch(r3) {
                case 900: goto L70;
                case 901: goto L6b;
                case 902: goto L66;
                default: goto L38;
            }
        L38:
            switch(r3) {
                case 922: goto L61;
                case 923: goto L61;
                case 924: goto L6b;
                case 925: goto L5e;
                case 926: goto L5b;
                case 927: goto L47;
                case 928: goto L42;
                default: goto L3b;
            }
        L3b:
            int r2 = r2 + (-1)
            int r2 = textCompaction(r7, r2, r0)
            goto L7e
        L42:
            int r2 = decodeMacroBlock(r7, r2, r4)
            goto L7e
        L47:
            int r1 = r2 + 1
            r2 = r7[r2]
            com.google.zxing.common.CharacterSetECI r2 = com.google.zxing.common.CharacterSetECI.getCharacterSetECIByValue(r2)
            java.lang.String r2 = r2.name()
            java.nio.charset.Charset r2 = java.nio.charset.Charset.forName(r2)
            r6 = r2
            r2 = r1
            r1 = r6
            goto L7e
        L5b:
            int r2 = r2 + 2
            goto L7e
        L5e:
            int r2 = r2 + 1
            goto L7e
        L61:
            com.google.zxing.FormatException r7 = com.google.zxing.FormatException.getFormatInstance()
            throw r7
        L66:
            int r2 = numericCompaction(r7, r2, r0)
            goto L7e
        L6b:
            int r2 = byteCompaction(r3, r7, r1, r2, r0)
            goto L7e
        L70:
            int r2 = textCompaction(r7, r2, r0)
            goto L7e
        L75:
            int r3 = r2 + 1
            r2 = r7[r2]
            char r2 = (char) r2
            r0.append(r2)
            r2 = r3
        L7e:
            int r3 = r7.length
            if (r2 >= r3) goto L89
            int r3 = r2 + 1
            r2 = r7[r2]
            r6 = r3
            r3 = r2
            r2 = r6
            goto L13
        L89:
            com.google.zxing.FormatException r7 = com.google.zxing.FormatException.getFormatInstance()
            goto L8f
        L8e:
            throw r7
        L8f:
            goto L8e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.DecodedBitStreamParser.decode(int[], java.lang.String):com.google.zxing.common.DecoderResult");
    }

    public static String decodeBase900toBase10(int[] iArr, int i2) throws FormatException {
        BigInteger bigInteger = BigInteger.ZERO;
        for (int i3 = 0; i3 < i2; i3++) {
            bigInteger = bigInteger.add(EXP900[(i2 - i3) - 1].multiply(BigInteger.valueOf(iArr[i3])));
        }
        String bigInteger2 = bigInteger.toString();
        if (bigInteger2.charAt(0) == '1') {
            return bigInteger2.substring(1);
        }
        throw FormatException.getFormatInstance();
    }

    public static int decodeMacroBlock(int[] iArr, int i2, PDF417ResultMetadata pDF417ResultMetadata) throws FormatException {
        if (i2 + 2 > iArr[0]) {
            throw FormatException.getFormatInstance();
        }
        int[] iArr2 = new int[2];
        int i3 = 0;
        while (i3 < 2) {
            iArr2[i3] = iArr[i2];
            i3++;
            i2++;
        }
        pDF417ResultMetadata.setSegmentIndex(Integer.parseInt(decodeBase900toBase10(iArr2, 2)));
        StringBuilder sb = new StringBuilder();
        int textCompaction = textCompaction(iArr, i2, sb);
        pDF417ResultMetadata.setFileId(sb.toString());
        int i4 = iArr[textCompaction] == 923 ? textCompaction + 1 : -1;
        while (textCompaction < iArr[0]) {
            int i5 = iArr[textCompaction];
            if (i5 == 922) {
                textCompaction++;
                pDF417ResultMetadata.setLastSegment(true);
            } else {
                if (i5 != 923) {
                    throw FormatException.getFormatInstance();
                }
                int i6 = textCompaction + 1;
                switch (iArr[i6]) {
                    case 0:
                        StringBuilder sb2 = new StringBuilder();
                        textCompaction = textCompaction(iArr, i6 + 1, sb2);
                        pDF417ResultMetadata.setFileName(sb2.toString());
                        break;
                    case 1:
                        StringBuilder sb3 = new StringBuilder();
                        textCompaction = numericCompaction(iArr, i6 + 1, sb3);
                        pDF417ResultMetadata.setSegmentCount(Integer.parseInt(sb3.toString()));
                        break;
                    case 2:
                        StringBuilder sb4 = new StringBuilder();
                        textCompaction = numericCompaction(iArr, i6 + 1, sb4);
                        pDF417ResultMetadata.setTimestamp(Long.parseLong(sb4.toString()));
                        break;
                    case 3:
                        StringBuilder sb5 = new StringBuilder();
                        textCompaction = textCompaction(iArr, i6 + 1, sb5);
                        pDF417ResultMetadata.setSender(sb5.toString());
                        break;
                    case 4:
                        StringBuilder sb6 = new StringBuilder();
                        textCompaction = textCompaction(iArr, i6 + 1, sb6);
                        pDF417ResultMetadata.setAddressee(sb6.toString());
                        break;
                    case 5:
                        StringBuilder sb7 = new StringBuilder();
                        textCompaction = numericCompaction(iArr, i6 + 1, sb7);
                        pDF417ResultMetadata.setFileSize(Long.parseLong(sb7.toString()));
                        break;
                    case 6:
                        StringBuilder sb8 = new StringBuilder();
                        textCompaction = numericCompaction(iArr, i6 + 1, sb8);
                        pDF417ResultMetadata.setChecksum(Integer.parseInt(sb8.toString()));
                        break;
                    default:
                        throw FormatException.getFormatInstance();
                }
            }
        }
        if (i4 != -1) {
            int i7 = textCompaction - i4;
            if (pDF417ResultMetadata.isLastSegment()) {
                i7--;
            }
            pDF417ResultMetadata.setOptionalData(Arrays.copyOfRange(iArr, i4, i7 + i4));
        }
        return textCompaction;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void decodeTextCompaction(int[] iArr, int[] iArr2, int i2, StringBuilder sb) {
        Mode mode;
        int i3;
        Mode mode2 = Mode.ALPHA;
        Mode mode3 = mode2;
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = iArr[i4];
            char c2 = ' ';
            switch ($SWITCH_TABLE$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode()[mode2.ordinal()]) {
                case 1:
                    if (i5 < 26) {
                        i3 = i5 + 65;
                        c2 = (char) i3;
                        break;
                    } else {
                        if (i5 == 900) {
                            mode2 = Mode.ALPHA;
                        } else if (i5 != 913) {
                            switch (i5) {
                                case 27:
                                    mode2 = Mode.LOWER;
                                    break;
                                case 28:
                                    mode2 = Mode.MIXED;
                                    break;
                                case 29:
                                    mode = Mode.PUNCT_SHIFT;
                                    c2 = 0;
                                    Mode mode4 = mode;
                                    mode3 = mode2;
                                    mode2 = mode4;
                                    break;
                            }
                        } else {
                            sb.append((char) iArr2[i4]);
                        }
                        c2 = 0;
                        break;
                    }
                case 2:
                    if (i5 < 26) {
                        i3 = i5 + 97;
                        c2 = (char) i3;
                        break;
                    } else {
                        if (i5 == 900) {
                            mode2 = Mode.ALPHA;
                        } else if (i5 != 913) {
                            switch (i5) {
                                case 27:
                                    mode = Mode.ALPHA_SHIFT;
                                    c2 = 0;
                                    Mode mode42 = mode;
                                    mode3 = mode2;
                                    mode2 = mode42;
                                    break;
                                case 28:
                                    mode2 = Mode.MIXED;
                                    break;
                                case 29:
                                    mode = Mode.PUNCT_SHIFT;
                                    c2 = 0;
                                    Mode mode422 = mode;
                                    mode3 = mode2;
                                    mode2 = mode422;
                                    break;
                            }
                        } else {
                            sb.append((char) iArr2[i4]);
                        }
                        c2 = 0;
                        break;
                    }
                case 3:
                    if (i5 < 25) {
                        c2 = MIXED_CHARS[i5];
                        break;
                    } else {
                        if (i5 == 900) {
                            mode2 = Mode.ALPHA;
                        } else if (i5 != 913) {
                            switch (i5) {
                                case 25:
                                    mode2 = Mode.PUNCT;
                                    break;
                                case 27:
                                    mode2 = Mode.LOWER;
                                    break;
                                case 28:
                                    mode2 = Mode.ALPHA;
                                    break;
                                case 29:
                                    mode = Mode.PUNCT_SHIFT;
                                    c2 = 0;
                                    Mode mode4222 = mode;
                                    mode3 = mode2;
                                    mode2 = mode4222;
                                    break;
                            }
                        } else {
                            sb.append((char) iArr2[i4]);
                        }
                        c2 = 0;
                        break;
                    }
                    break;
                case 4:
                    if (i5 < 29) {
                        c2 = PUNCT_CHARS[i5];
                        break;
                    } else {
                        if (i5 == 29) {
                            mode2 = Mode.ALPHA;
                        } else if (i5 == 900) {
                            mode2 = Mode.ALPHA;
                        } else if (i5 == 913) {
                            sb.append((char) iArr2[i4]);
                        }
                        c2 = 0;
                        break;
                    }
                case 5:
                    if (i5 < 26) {
                        c2 = (char) (i5 + 65);
                    } else if (i5 != 26) {
                        if (i5 == 900) {
                            mode2 = Mode.ALPHA;
                            c2 = 0;
                            break;
                        }
                        mode2 = mode3;
                        c2 = 0;
                    }
                    mode2 = mode3;
                    break;
                case 6:
                    if (i5 < 29) {
                        c2 = PUNCT_CHARS[i5];
                        mode2 = mode3;
                        break;
                    } else {
                        if (i5 == 29) {
                            mode2 = Mode.ALPHA;
                        } else if (i5 != 900) {
                            if (i5 == 913) {
                                sb.append((char) iArr2[i4]);
                            }
                            mode2 = mode3;
                        } else {
                            mode2 = Mode.ALPHA;
                        }
                        c2 = 0;
                        break;
                    }
                default:
                    c2 = 0;
                    break;
            }
            if (c2 != 0) {
                sb.append(c2);
            }
        }
    }

    public static int numericCompaction(int[] iArr, int i2, StringBuilder sb) throws FormatException {
        int i3;
        int[] iArr2 = new int[15];
        boolean z = false;
        while (true) {
            int i4 = 0;
            while (i2 < iArr[0] && !z) {
                i3 = i2 + 1;
                int i5 = iArr[i2];
                if (i3 == iArr[0]) {
                    z = true;
                }
                if (i5 < 900) {
                    iArr2[i4] = i5;
                    i4++;
                } else {
                    if (i5 != 900 && i5 != 901 && i5 != 928) {
                        switch (i5) {
                        }
                    }
                    i3--;
                    z = true;
                }
                if ((i4 % 15 == 0 || i5 == 902 || z) && i4 > 0) {
                    break;
                }
                i2 = i3;
            }
            sb.append(decodeBase900toBase10(iArr2, i4));
            i2 = i3;
        }
        return i2;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:16:0x0035. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:17:0x0038. Please report as an issue. */
    public static int textCompaction(int[] iArr, int i2, StringBuilder sb) {
        int[] iArr2 = new int[(iArr[0] - i2) * 2];
        int[] iArr3 = new int[(iArr[0] - i2) * 2];
        boolean z = false;
        int i3 = 0;
        while (i2 < iArr[0] && !z) {
            int i4 = i2 + 1;
            int i5 = iArr[i2];
            if (i5 < 900) {
                iArr2[i3] = i5 / 30;
                iArr2[i3 + 1] = i5 % 30;
                i3 += 2;
            } else if (i5 != 913) {
                if (i5 != 928) {
                    switch (i5) {
                        case 900:
                            iArr2[i3] = 900;
                            i3++;
                            break;
                        case 901:
                        case 902:
                            break;
                        default:
                            switch (i5) {
                            }
                    }
                }
                i2 = i4 - 1;
                z = true;
            } else {
                iArr2[i3] = 913;
                i2 = i4 + 1;
                iArr3[i3] = iArr[i4];
                i3++;
            }
            i2 = i4;
        }
        decodeTextCompaction(iArr2, iArr3, i3, sb);
        return i2;
    }
}
