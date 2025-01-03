package com.google.zxing.qrcode.encoder;

import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitArray;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonEncoder;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.Version;
import com.shix.shixipc.utilcode.ThreadUtils;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class Encoder {
    public static /* synthetic */ int[] $SWITCH_TABLE$com$google$zxing$qrcode$decoder$Mode = null;
    public static final int[] ALPHANUMERIC_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};
    public static final String DEFAULT_BYTE_MODE_ENCODING = "ISO-8859-1";

    public static /* synthetic */ int[] $SWITCH_TABLE$com$google$zxing$qrcode$decoder$Mode() {
        int[] iArr = $SWITCH_TABLE$com$google$zxing$qrcode$decoder$Mode;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[Mode.valuesCustom().length];
        try {
            iArr2[Mode.ALPHANUMERIC.ordinal()] = 3;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[Mode.BYTE.ordinal()] = 5;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[Mode.ECI.ordinal()] = 6;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[Mode.FNC1_FIRST_POSITION.ordinal()] = 8;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[Mode.FNC1_SECOND_POSITION.ordinal()] = 9;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr2[Mode.HANZI.ordinal()] = 10;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            iArr2[Mode.KANJI.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            iArr2[Mode.NUMERIC.ordinal()] = 2;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            iArr2[Mode.STRUCTURED_APPEND.ordinal()] = 4;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            iArr2[Mode.TERMINATOR.ordinal()] = 1;
        } catch (NoSuchFieldError unused10) {
        }
        $SWITCH_TABLE$com$google$zxing$qrcode$decoder$Mode = iArr2;
        return iArr2;
    }

    public static void append8BitBytes(String str, BitArray bitArray, String str2) throws WriterException {
        try {
            for (byte b2 : str.getBytes(str2)) {
                bitArray.appendBits(b2, 8);
            }
        } catch (UnsupportedEncodingException e2) {
            throw new WriterException(e2);
        }
    }

    public static void appendAlphanumericBytes(CharSequence charSequence, BitArray bitArray) throws WriterException {
        int length = charSequence.length();
        int i2 = 0;
        while (i2 < length) {
            int alphanumericCode = getAlphanumericCode(charSequence.charAt(i2));
            if (alphanumericCode == -1) {
                throw new WriterException();
            }
            int i3 = i2 + 1;
            if (i3 < length) {
                int alphanumericCode2 = getAlphanumericCode(charSequence.charAt(i3));
                if (alphanumericCode2 == -1) {
                    throw new WriterException();
                }
                bitArray.appendBits((alphanumericCode * 45) + alphanumericCode2, 11);
                i2 += 2;
            } else {
                bitArray.appendBits(alphanumericCode, 6);
                i2 = i3;
            }
        }
    }

    public static void appendBytes(String str, Mode mode, BitArray bitArray, String str2) throws WriterException {
        int i2 = $SWITCH_TABLE$com$google$zxing$qrcode$decoder$Mode()[mode.ordinal()];
        if (i2 == 2) {
            appendNumericBytes(str, bitArray);
            return;
        }
        if (i2 == 3) {
            appendAlphanumericBytes(str, bitArray);
            return;
        }
        if (i2 == 5) {
            append8BitBytes(str, bitArray, str2);
        } else if (i2 == 7) {
            appendKanjiBytes(str, bitArray);
        } else {
            throw new WriterException("Invalid mode: " + mode);
        }
    }

    public static void appendECI(CharacterSetECI characterSetECI, BitArray bitArray) {
        bitArray.appendBits(Mode.ECI.getBits(), 4);
        bitArray.appendBits(characterSetECI.getValue(), 8);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003d A[LOOP:0: B:6:0x000f->B:13:0x003d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void appendKanjiBytes(java.lang.String r6, com.google.zxing.common.BitArray r7) throws com.google.zxing.WriterException {
        /*
            java.lang.String r0 = "Shift_JIS"
            byte[] r6 = r6.getBytes(r0)     // Catch: java.io.UnsupportedEncodingException -> L5c
            int r0 = r6.length
            int r0 = r0 % 2
            if (r0 != 0) goto L54
            int r0 = r6.length
            int r0 = r0 + (-1)
            r1 = 0
        Lf:
            if (r1 < r0) goto L12
            return
        L12:
            r2 = r6[r1]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r3 = r1 + 1
            r3 = r6[r3]
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r2 = r2 << 8
            r2 = r2 | r3
            r3 = 33088(0x8140, float:4.6366E-41)
            r4 = -1
            if (r2 < r3) goto L2c
            r5 = 40956(0x9ffc, float:5.7392E-41)
            if (r2 > r5) goto L2c
        L2a:
            int r2 = r2 - r3
            goto L3b
        L2c:
            r3 = 57408(0xe040, float:8.0446E-41)
            if (r2 < r3) goto L3a
            r3 = 60351(0xebbf, float:8.457E-41)
            if (r2 > r3) goto L3a
            r3 = 49472(0xc140, float:6.9325E-41)
            goto L2a
        L3a:
            r2 = -1
        L3b:
            if (r2 == r4) goto L4c
            int r3 = r2 >> 8
            int r3 = r3 * 192
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r3 = r3 + r2
            r2 = 13
            r7.appendBits(r3, r2)
            int r1 = r1 + 2
            goto Lf
        L4c:
            com.google.zxing.WriterException r6 = new com.google.zxing.WriterException
            java.lang.String r7 = "Invalid byte sequence"
            r6.<init>(r7)
            throw r6
        L54:
            com.google.zxing.WriterException r6 = new com.google.zxing.WriterException
            java.lang.String r7 = "Kanji byte size not even"
            r6.<init>(r7)
            throw r6
        L5c:
            r6 = move-exception
            com.google.zxing.WriterException r7 = new com.google.zxing.WriterException
            r7.<init>(r6)
            goto L64
        L63:
            throw r7
        L64:
            goto L63
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.encoder.Encoder.appendKanjiBytes(java.lang.String, com.google.zxing.common.BitArray):void");
    }

    public static void appendLengthInfo(int i2, Version version, Mode mode, BitArray bitArray) throws WriterException {
        int characterCountBits = mode.getCharacterCountBits(version);
        int i3 = 1 << characterCountBits;
        if (i2 < i3) {
            bitArray.appendBits(i2, characterCountBits);
            return;
        }
        throw new WriterException(String.valueOf(i2) + " is bigger than " + (i3 - 1));
    }

    public static void appendModeInfo(Mode mode, BitArray bitArray) {
        bitArray.appendBits(mode.getBits(), 4);
    }

    public static void appendNumericBytes(CharSequence charSequence, BitArray bitArray) {
        int length = charSequence.length();
        int i2 = 0;
        while (i2 < length) {
            int charAt = charSequence.charAt(i2) - '0';
            int i3 = i2 + 2;
            if (i3 < length) {
                bitArray.appendBits((charAt * 100) + ((charSequence.charAt(i2 + 1) - '0') * 10) + (charSequence.charAt(i3) - '0'), 10);
                i2 += 3;
            } else {
                i2++;
                if (i2 < length) {
                    bitArray.appendBits((charAt * 10) + (charSequence.charAt(i2) - '0'), 7);
                    i2 = i3;
                } else {
                    bitArray.appendBits(charAt, 4);
                }
            }
        }
    }

    public static int calculateBitsNeeded(Mode mode, BitArray bitArray, BitArray bitArray2, Version version) {
        return bitArray.getSize() + mode.getCharacterCountBits(version) + bitArray2.getSize();
    }

    public static int calculateMaskPenalty(ByteMatrix byteMatrix) {
        return MaskUtil.applyMaskPenaltyRule1(byteMatrix) + MaskUtil.applyMaskPenaltyRule2(byteMatrix) + MaskUtil.applyMaskPenaltyRule3(byteMatrix) + MaskUtil.applyMaskPenaltyRule4(byteMatrix);
    }

    public static int chooseMaskPattern(BitArray bitArray, ErrorCorrectionLevel errorCorrectionLevel, Version version, ByteMatrix byteMatrix) throws WriterException {
        int i2 = Integer.MAX_VALUE;
        int i3 = -1;
        for (int i4 = 0; i4 < 8; i4++) {
            MatrixUtil.buildMatrix(bitArray, errorCorrectionLevel, version, i4, byteMatrix);
            int calculateMaskPenalty = calculateMaskPenalty(byteMatrix);
            if (calculateMaskPenalty < i2) {
                i3 = i4;
                i2 = calculateMaskPenalty;
            }
        }
        return i3;
    }

    public static Mode chooseMode(String str) {
        return chooseMode(str, null);
    }

    public static Version chooseVersion(int i2, ErrorCorrectionLevel errorCorrectionLevel) throws WriterException {
        for (int i3 = 1; i3 <= 40; i3++) {
            Version versionForNumber = Version.getVersionForNumber(i3);
            if (willFit(i2, versionForNumber, errorCorrectionLevel)) {
                return versionForNumber;
            }
        }
        throw new WriterException("Data too big");
    }

    public static QRCode encode(String str, ErrorCorrectionLevel errorCorrectionLevel) throws WriterException {
        return encode(str, errorCorrectionLevel, null);
    }

    public static byte[] generateECBytes(byte[] bArr, int i2) {
        int length = bArr.length;
        int[] iArr = new int[length + i2];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = bArr[i3] & ThreadUtils.TYPE_SINGLE;
        }
        new ReedSolomonEncoder(GenericGF.QR_CODE_FIELD_256).encode(iArr, i2);
        byte[] bArr2 = new byte[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            bArr2[i4] = (byte) iArr[length + i4];
        }
        return bArr2;
    }

    public static int getAlphanumericCode(int i2) {
        int[] iArr = ALPHANUMERIC_TABLE;
        if (i2 < iArr.length) {
            return iArr[i2];
        }
        return -1;
    }

    public static void getNumDataBytesAndNumECBytesForBlockID(int i2, int i3, int i4, int i5, int[] iArr, int[] iArr2) throws WriterException {
        if (i5 >= i4) {
            throw new WriterException("Block ID too large");
        }
        int i6 = i2 % i4;
        int i7 = i4 - i6;
        int i8 = i2 / i4;
        int i9 = i8 + 1;
        int i10 = i3 / i4;
        int i11 = i10 + 1;
        int i12 = i8 - i10;
        int i13 = i9 - i11;
        if (i12 != i13) {
            throw new WriterException("EC bytes mismatch");
        }
        if (i4 != i7 + i6) {
            throw new WriterException("RS blocks mismatch");
        }
        if (i2 != ((i10 + i12) * i7) + ((i11 + i13) * i6)) {
            throw new WriterException("Total bytes mismatch");
        }
        if (i5 < i7) {
            iArr[0] = i10;
            iArr2[0] = i12;
        } else {
            iArr[0] = i11;
            iArr2[0] = i13;
        }
    }

    public static BitArray interleaveWithECBytes(BitArray bitArray, int i2, int i3, int i4) throws WriterException {
        if (bitArray.getSizeInBytes() != i3) {
            throw new WriterException("Number of bits and data bytes does not match");
        }
        ArrayList arrayList = new ArrayList(i4);
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < i4; i8++) {
            int[] iArr = new int[1];
            int[] iArr2 = new int[1];
            getNumDataBytesAndNumECBytesForBlockID(i2, i3, i4, i8, iArr, iArr2);
            int i9 = iArr[0];
            byte[] bArr = new byte[i9];
            bitArray.toBytes(i5 * 8, bArr, 0, i9);
            byte[] generateECBytes = generateECBytes(bArr, iArr2[0]);
            arrayList.add(new BlockPair(bArr, generateECBytes));
            i6 = Math.max(i6, i9);
            i7 = Math.max(i7, generateECBytes.length);
            i5 += iArr[0];
        }
        if (i3 != i5) {
            throw new WriterException("Data bytes does not match offset");
        }
        BitArray bitArray2 = new BitArray();
        for (int i10 = 0; i10 < i6; i10++) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                byte[] dataBytes = ((BlockPair) it.next()).getDataBytes();
                if (i10 < dataBytes.length) {
                    bitArray2.appendBits(dataBytes[i10], 8);
                }
            }
        }
        for (int i11 = 0; i11 < i7; i11++) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                byte[] errorCorrectionBytes = ((BlockPair) it2.next()).getErrorCorrectionBytes();
                if (i11 < errorCorrectionBytes.length) {
                    bitArray2.appendBits(errorCorrectionBytes[i11], 8);
                }
            }
        }
        if (i2 == bitArray2.getSizeInBytes()) {
            return bitArray2;
        }
        throw new WriterException("Interleaving error: " + i2 + " and " + bitArray2.getSizeInBytes() + " differ.");
    }

    public static boolean isOnlyDoubleByteKanji(String str) {
        byte[] bytes;
        int length;
        int i2;
        try {
            bytes = str.getBytes("Shift_JIS");
            length = bytes.length;
        } catch (UnsupportedEncodingException unused) {
        }
        if (length % 2 != 0) {
            return false;
        }
        while (i2 < length) {
            int i3 = bytes[i2] & ThreadUtils.TYPE_SINGLE;
            i2 = ((i3 >= 129 && i3 <= 159) || (i3 >= 224 && i3 <= 235)) ? i2 + 2 : 0;
            return false;
        }
        return true;
    }

    public static Version recommendVersion(ErrorCorrectionLevel errorCorrectionLevel, Mode mode, BitArray bitArray, BitArray bitArray2) throws WriterException {
        return chooseVersion(calculateBitsNeeded(mode, bitArray, bitArray2, chooseVersion(calculateBitsNeeded(mode, bitArray, bitArray2, Version.getVersionForNumber(1)), errorCorrectionLevel)), errorCorrectionLevel);
    }

    public static void terminateBits(int i2, BitArray bitArray) throws WriterException {
        int i3 = i2 * 8;
        if (bitArray.getSize() > i3) {
            throw new WriterException("data bits cannot fit in the QR Code" + bitArray.getSize() + " > " + i3);
        }
        for (int i4 = 0; i4 < 4 && bitArray.getSize() < i3; i4++) {
            bitArray.appendBit(false);
        }
        int size = bitArray.getSize() & 7;
        if (size > 0) {
            while (size < 8) {
                bitArray.appendBit(false);
                size++;
            }
        }
        int sizeInBytes = i2 - bitArray.getSizeInBytes();
        for (int i5 = 0; i5 < sizeInBytes; i5++) {
            bitArray.appendBits((i5 & 1) == 0 ? 236 : 17, 8);
        }
        if (bitArray.getSize() != i3) {
            throw new WriterException("Bits size does not equal capacity");
        }
    }

    public static boolean willFit(int i2, Version version, ErrorCorrectionLevel errorCorrectionLevel) {
        return version.getTotalCodewords() - version.getECBlocksForLevel(errorCorrectionLevel).getTotalECCodewords() >= (i2 + 7) / 8;
    }

    public static Mode chooseMode(String str, String str2) {
        if ("Shift_JIS".equals(str2) && isOnlyDoubleByteKanji(str)) {
            return Mode.KANJI;
        }
        boolean z = false;
        boolean z2 = false;
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (charAt >= '0' && charAt <= '9') {
                z2 = true;
            } else {
                if (getAlphanumericCode(charAt) == -1) {
                    return Mode.BYTE;
                }
                z = true;
            }
        }
        return z ? Mode.ALPHANUMERIC : z2 ? Mode.NUMERIC : Mode.BYTE;
    }

    public static QRCode encode(String str, ErrorCorrectionLevel errorCorrectionLevel, Map<EncodeHintType, ?> map) throws WriterException {
        Version recommendVersion;
        CharacterSetECI characterSetECIByName;
        boolean z = map != null && map.containsKey(EncodeHintType.CHARACTER_SET);
        String obj = z ? map.get(EncodeHintType.CHARACTER_SET).toString() : DEFAULT_BYTE_MODE_ENCODING;
        Mode chooseMode = chooseMode(str, obj);
        BitArray bitArray = new BitArray();
        if (chooseMode == Mode.BYTE && z && (characterSetECIByName = CharacterSetECI.getCharacterSetECIByName(obj)) != null) {
            appendECI(characterSetECIByName, bitArray);
        }
        if ((map != null && map.containsKey(EncodeHintType.GS1_FORMAT)) && Boolean.valueOf(map.get(EncodeHintType.GS1_FORMAT).toString()).booleanValue()) {
            appendModeInfo(Mode.FNC1_FIRST_POSITION, bitArray);
        }
        appendModeInfo(chooseMode, bitArray);
        BitArray bitArray2 = new BitArray();
        appendBytes(str, chooseMode, bitArray2, obj);
        if (map == null || !map.containsKey(EncodeHintType.QR_VERSION)) {
            recommendVersion = recommendVersion(errorCorrectionLevel, chooseMode, bitArray, bitArray2);
        } else {
            recommendVersion = Version.getVersionForNumber(Integer.parseInt(map.get(EncodeHintType.QR_VERSION).toString()));
            if (!willFit(calculateBitsNeeded(chooseMode, bitArray, bitArray2, recommendVersion), recommendVersion, errorCorrectionLevel)) {
                throw new WriterException("Data too big for requested version");
            }
        }
        BitArray bitArray3 = new BitArray();
        bitArray3.appendBitArray(bitArray);
        appendLengthInfo(chooseMode == Mode.BYTE ? bitArray2.getSizeInBytes() : str.length(), recommendVersion, chooseMode, bitArray3);
        bitArray3.appendBitArray(bitArray2);
        Version.ECBlocks eCBlocksForLevel = recommendVersion.getECBlocksForLevel(errorCorrectionLevel);
        int totalCodewords = recommendVersion.getTotalCodewords() - eCBlocksForLevel.getTotalECCodewords();
        terminateBits(totalCodewords, bitArray3);
        BitArray interleaveWithECBytes = interleaveWithECBytes(bitArray3, recommendVersion.getTotalCodewords(), totalCodewords, eCBlocksForLevel.getNumBlocks());
        QRCode qRCode = new QRCode();
        qRCode.setECLevel(errorCorrectionLevel);
        qRCode.setMode(chooseMode);
        qRCode.setVersion(recommendVersion);
        int dimensionForVersion = recommendVersion.getDimensionForVersion();
        ByteMatrix byteMatrix = new ByteMatrix(dimensionForVersion, dimensionForVersion);
        int chooseMaskPattern = chooseMaskPattern(interleaveWithECBytes, errorCorrectionLevel, recommendVersion, byteMatrix);
        qRCode.setMaskPattern(chooseMaskPattern);
        MatrixUtil.buildMatrix(interleaveWithECBytes, errorCorrectionLevel, recommendVersion, chooseMaskPattern, byteMatrix);
        qRCode.setMatrix(byteMatrix);
        return qRCode;
    }
}
