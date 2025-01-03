package com.google.zxing.pdf417.encoder;

import androidx.recyclerview.widget.RecyclerView;
import com.google.zxing.WriterException;
import com.google.zxing.common.CharacterSetECI;
import com.shix.shixipc.utilcode.ThreadUtils;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class PDF417HighLevelEncoder {
    public static /* synthetic */ int[] $SWITCH_TABLE$com$google$zxing$pdf417$encoder$Compaction = null;
    public static final int BYTE_COMPACTION = 1;
    public static final int ECI_CHARSET = 927;
    public static final int ECI_GENERAL_PURPOSE = 926;
    public static final int ECI_USER_DEFINED = 925;
    public static final int LATCH_TO_BYTE = 924;
    public static final int LATCH_TO_BYTE_PADDED = 901;
    public static final int LATCH_TO_NUMERIC = 902;
    public static final int LATCH_TO_TEXT = 900;
    public static final int NUMERIC_COMPACTION = 2;
    public static final int SHIFT_TO_BYTE = 913;
    public static final int SUBMODE_ALPHA = 0;
    public static final int SUBMODE_LOWER = 1;
    public static final int SUBMODE_MIXED = 2;
    public static final int SUBMODE_PUNCTUATION = 3;
    public static final int TEXT_COMPACTION = 0;
    public static final byte[] TEXT_MIXED_RAW = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 38, 13, 9, 44, 58, 35, 45, 46, 36, 47, 43, 37, 42, 61, 94, 0, 32, 0, 0, 0};
    public static final byte[] TEXT_PUNCTUATION_RAW = {59, 60, 62, 64, 91, 92, 93, 95, 96, 126, 33, 13, 9, 44, 58, 10, 45, 46, 36, 47, 34, 124, 42, 40, 41, 63, 123, 125, 39, 0};
    public static final byte[] MIXED = new byte[RecyclerView.c0.FLAG_IGNORE];
    public static final byte[] PUNCTUATION = new byte[RecyclerView.c0.FLAG_IGNORE];
    public static final Charset DEFAULT_ENCODING = StandardCharsets.ISO_8859_1;

    public static /* synthetic */ int[] $SWITCH_TABLE$com$google$zxing$pdf417$encoder$Compaction() {
        int[] iArr = $SWITCH_TABLE$com$google$zxing$pdf417$encoder$Compaction;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[Compaction.valuesCustom().length];
        try {
            iArr2[Compaction.AUTO.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[Compaction.BYTE.ordinal()] = 3;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[Compaction.NUMERIC.ordinal()] = 4;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[Compaction.TEXT.ordinal()] = 2;
        } catch (NoSuchFieldError unused4) {
        }
        $SWITCH_TABLE$com$google$zxing$pdf417$encoder$Compaction = iArr2;
        return iArr2;
    }

    static {
        int i2 = 0;
        Arrays.fill(MIXED, (byte) -1);
        int i3 = 0;
        while (true) {
            byte[] bArr = TEXT_MIXED_RAW;
            if (i3 >= bArr.length) {
                break;
            }
            byte b2 = bArr[i3];
            if (b2 > 0) {
                MIXED[b2] = (byte) i3;
            }
            i3++;
        }
        Arrays.fill(PUNCTUATION, (byte) -1);
        while (true) {
            byte[] bArr2 = TEXT_PUNCTUATION_RAW;
            if (i2 >= bArr2.length) {
                return;
            }
            byte b3 = bArr2[i2];
            if (b3 > 0) {
                PUNCTUATION[b3] = (byte) i2;
            }
            i2++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x002c, code lost:
    
        return r1 - r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int determineConsecutiveBinaryCount(java.lang.String r5, int r6, java.nio.charset.Charset r7) throws com.google.zxing.WriterException {
        /*
            java.nio.charset.CharsetEncoder r7 = r7.newEncoder()
            int r0 = r5.length()
            r1 = r6
        L9:
            if (r1 < r0) goto Ld
            int r1 = r1 - r6
            return r1
        Ld:
            char r2 = r5.charAt(r1)
            r3 = 0
        L12:
            r4 = 13
            if (r3 >= r4) goto L29
            boolean r2 = isDigit(r2)
            if (r2 != 0) goto L1d
            goto L29
        L1d:
            int r3 = r3 + 1
            int r2 = r1 + r3
            if (r2 < r0) goto L24
            goto L29
        L24:
            char r2 = r5.charAt(r2)
            goto L12
        L29:
            if (r3 < r4) goto L2d
            int r1 = r1 - r6
            return r1
        L2d:
            char r2 = r5.charAt(r1)
            boolean r3 = r7.canEncode(r2)
            if (r3 == 0) goto L3a
            int r1 = r1 + 1
            goto L9
        L3a:
            com.google.zxing.WriterException r5 = new com.google.zxing.WriterException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "Non-encodable character detected: "
            r6.<init>(r7)
            r6.append(r2)
            java.lang.String r7 = " (Unicode: "
            r6.append(r7)
            r6.append(r2)
            r7 = 41
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            goto L5c
        L5b:
            throw r5
        L5c:
            goto L5b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.encoder.PDF417HighLevelEncoder.determineConsecutiveBinaryCount(java.lang.String, int, java.nio.charset.Charset):int");
    }

    public static int determineConsecutiveDigitCount(CharSequence charSequence, int i2) {
        int length = charSequence.length();
        int i3 = 0;
        if (i2 < length) {
            char charAt = charSequence.charAt(i2);
            while (isDigit(charAt) && i2 < length) {
                i3++;
                i2++;
                if (i2 < length) {
                    charAt = charSequence.charAt(i2);
                }
            }
        }
        return i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0029, code lost:
    
        return (r1 - r7) - r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int determineConsecutiveTextCount(java.lang.CharSequence r6, int r7) {
        /*
            int r0 = r6.length()
            r1 = r7
        L5:
            if (r1 < r0) goto L8
            goto L37
        L8:
            char r2 = r6.charAt(r1)
            r3 = 0
        Ld:
            r4 = 13
            if (r3 >= r4) goto L25
            boolean r5 = isDigit(r2)
            if (r5 == 0) goto L25
            if (r1 < r0) goto L1a
            goto L25
        L1a:
            int r3 = r3 + 1
            int r1 = r1 + 1
            if (r1 >= r0) goto Ld
            char r2 = r6.charAt(r1)
            goto Ld
        L25:
            if (r3 < r4) goto L2a
            int r1 = r1 - r7
            int r1 = r1 - r3
            return r1
        L2a:
            if (r3 <= 0) goto L2d
            goto L5
        L2d:
            char r2 = r6.charAt(r1)
            boolean r2 = isText(r2)
            if (r2 != 0) goto L39
        L37:
            int r1 = r1 - r7
            return r1
        L39:
            int r1 = r1 + 1
            goto L5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.encoder.PDF417HighLevelEncoder.determineConsecutiveTextCount(java.lang.CharSequence, int):int");
    }

    public static void encodeBinary(byte[] bArr, int i2, int i3, int i4, StringBuilder sb) {
        int i5;
        if (i3 == 1 && i4 == 0) {
            sb.append((char) 913);
        } else if (i3 % 6 == 0) {
            sb.append((char) 924);
        } else {
            sb.append((char) 901);
        }
        if (i3 >= 6) {
            char[] cArr = new char[5];
            i5 = i2;
            while ((i2 + i3) - i5 >= 6) {
                long j = 0;
                for (int i6 = 0; i6 < 6; i6++) {
                    j = (j << 8) + (bArr[i5 + i6] & ThreadUtils.TYPE_SINGLE);
                }
                for (int i7 = 0; i7 < 5; i7++) {
                    cArr[i7] = (char) (j % 900);
                    j /= 900;
                }
                for (int i8 = 4; i8 >= 0; i8--) {
                    sb.append(cArr[i8]);
                }
                i5 += 6;
            }
        } else {
            i5 = i2;
        }
        while (i5 < i2 + i3) {
            sb.append((char) (bArr[i5] & ThreadUtils.TYPE_SINGLE));
            i5++;
        }
    }

    public static String encodeHighLevel(String str, Compaction compaction, Charset charset) throws WriterException {
        CharacterSetECI characterSetECIByName;
        StringBuilder sb = new StringBuilder(str.length());
        if (charset == null) {
            charset = DEFAULT_ENCODING;
        } else if (!DEFAULT_ENCODING.equals(charset) && (characterSetECIByName = CharacterSetECI.getCharacterSetECIByName(charset.name())) != null) {
            encodingECI(characterSetECIByName.getValue(), sb);
        }
        int length = str.length();
        int i2 = $SWITCH_TABLE$com$google$zxing$pdf417$encoder$Compaction()[compaction.ordinal()];
        if (i2 == 2) {
            encodeText(str, 0, length, sb, 0);
        } else if (i2 == 3) {
            byte[] bytes = str.getBytes(charset);
            encodeBinary(bytes, 0, bytes.length, 1, sb);
        } else if (i2 != 4) {
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (i3 < length) {
                int determineConsecutiveDigitCount = determineConsecutiveDigitCount(str, i3);
                if (determineConsecutiveDigitCount >= 13) {
                    sb.append((char) 902);
                    encodeNumeric(str, i3, determineConsecutiveDigitCount, sb);
                    i3 += determineConsecutiveDigitCount;
                    i4 = 0;
                    i5 = 2;
                } else {
                    int determineConsecutiveTextCount = determineConsecutiveTextCount(str, i3);
                    if (determineConsecutiveTextCount >= 5 || determineConsecutiveDigitCount == length) {
                        if (i5 != 0) {
                            sb.append((char) 900);
                            i4 = 0;
                            i5 = 0;
                        }
                        i4 = encodeText(str, i3, determineConsecutiveTextCount, sb, i4);
                        i3 += determineConsecutiveTextCount;
                    } else {
                        int determineConsecutiveBinaryCount = determineConsecutiveBinaryCount(str, i3, charset);
                        if (determineConsecutiveBinaryCount == 0) {
                            determineConsecutiveBinaryCount = 1;
                        }
                        int i6 = determineConsecutiveBinaryCount + i3;
                        byte[] bytes2 = str.substring(i3, i6).getBytes(charset);
                        if (bytes2.length == 1 && i5 == 0) {
                            encodeBinary(bytes2, 0, 1, 0, sb);
                        } else {
                            encodeBinary(bytes2, 0, bytes2.length, i5, sb);
                            i4 = 0;
                            i5 = 1;
                        }
                        i3 = i6;
                    }
                }
            }
        } else {
            sb.append((char) 902);
            encodeNumeric(str, 0, length, sb);
        }
        return sb.toString();
    }

    public static void encodeNumeric(String str, int i2, int i3, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder((i3 / 3) + 1);
        BigInteger valueOf = BigInteger.valueOf(900L);
        BigInteger valueOf2 = BigInteger.valueOf(0L);
        int i4 = 0;
        while (i4 < i3) {
            sb2.setLength(0);
            int min = Math.min(44, i3 - i4);
            StringBuilder sb3 = new StringBuilder(String.valueOf('1'));
            int i5 = i2 + i4;
            sb3.append(str.substring(i5, i5 + min));
            BigInteger bigInteger = new BigInteger(sb3.toString());
            do {
                sb2.append((char) bigInteger.mod(valueOf).intValue());
                bigInteger = bigInteger.divide(valueOf);
            } while (!bigInteger.equals(valueOf2));
            for (int length = sb2.length() - 1; length >= 0; length--) {
                sb.append(sb2.charAt(length));
            }
            i4 += min;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00f6 A[EDGE_INSN: B:21:0x00f6->B:22:0x00f6 BREAK  A[LOOP:0: B:2:0x0011->B:16:0x0011], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0011 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int encodeText(java.lang.CharSequence r16, int r17, int r18, java.lang.StringBuilder r19, int r20) {
        /*
            Method dump skipped, instructions count: 293
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.encoder.PDF417HighLevelEncoder.encodeText(java.lang.CharSequence, int, int, java.lang.StringBuilder, int):int");
    }

    public static void encodingECI(int i2, StringBuilder sb) throws WriterException {
        if (i2 >= 0 && i2 < 900) {
            sb.append((char) 927);
            sb.append((char) i2);
            return;
        }
        if (i2 < 810900) {
            sb.append((char) 926);
            sb.append((char) ((i2 / 900) - 1));
            sb.append((char) (i2 % 900));
        } else if (i2 < 811800) {
            sb.append((char) 925);
            sb.append((char) (810900 - i2));
        } else {
            throw new WriterException("ECI number not in valid range from 0..811799, but was " + i2);
        }
    }

    public static boolean isAlphaLower(char c2) {
        if (c2 != ' ') {
            return c2 >= 'a' && c2 <= 'z';
        }
        return true;
    }

    public static boolean isAlphaUpper(char c2) {
        if (c2 != ' ') {
            return c2 >= 'A' && c2 <= 'Z';
        }
        return true;
    }

    public static boolean isDigit(char c2) {
        return c2 >= '0' && c2 <= '9';
    }

    public static boolean isMixed(char c2) {
        return MIXED[c2] != -1;
    }

    public static boolean isPunctuation(char c2) {
        return PUNCTUATION[c2] != -1;
    }

    public static boolean isText(char c2) {
        if (c2 == '\t' || c2 == '\n' || c2 == '\r') {
            return true;
        }
        return c2 >= ' ' && c2 <= '~';
    }
}
