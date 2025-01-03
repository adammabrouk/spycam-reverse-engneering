package com.google.zxing.qrcode.decoder;

import androidx.recyclerview.widget.RecyclerView;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.BitSource;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.StringUtils;
import com.google.zxing.view.ViewfinderView;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* loaded from: classes.dex */
public final class DecodedBitStreamParser {
    public static /* synthetic */ int[] $SWITCH_TABLE$com$google$zxing$qrcode$decoder$Mode = null;
    public static final char[] ALPHANUMERIC_CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".toCharArray();
    public static final int GB2312_SUBSET = 1;

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

    public static DecoderResult decode(byte[] bArr, Version version, ErrorCorrectionLevel errorCorrectionLevel, Map<DecodeHintType, ?> map) throws FormatException {
        Mode mode;
        BitSource bitSource = new BitSource(bArr);
        StringBuilder sb = new StringBuilder(50);
        ArrayList arrayList = new ArrayList(1);
        boolean z = false;
        int i2 = -1;
        int i3 = -1;
        CharacterSetECI characterSetECI = null;
        do {
            try {
                Mode forBits = bitSource.available() < 4 ? Mode.TERMINATOR : Mode.forBits(bitSource.readBits(4));
                int i4 = $SWITCH_TABLE$com$google$zxing$qrcode$decoder$Mode()[forBits.ordinal()];
                if (i4 != 1) {
                    if (i4 == 4) {
                        mode = forBits;
                        if (bitSource.available() < 16) {
                            throw FormatException.getFormatInstance();
                        }
                        int readBits = bitSource.readBits(8);
                        i3 = bitSource.readBits(8);
                        i2 = readBits;
                    } else if (i4 != 6) {
                        switch (i4) {
                            case 8:
                            case 9:
                                mode = forBits;
                                z = true;
                                break;
                            case 10:
                                mode = forBits;
                                int readBits2 = bitSource.readBits(4);
                                int readBits3 = bitSource.readBits(mode.getCharacterCountBits(version));
                                if (readBits2 == 1) {
                                    decodeHanziSegment(bitSource, sb, readBits3);
                                    break;
                                }
                                break;
                            default:
                                int readBits4 = bitSource.readBits(forBits.getCharacterCountBits(version));
                                int i5 = $SWITCH_TABLE$com$google$zxing$qrcode$decoder$Mode()[forBits.ordinal()];
                                if (i5 == 2) {
                                    mode = forBits;
                                    decodeNumericSegment(bitSource, sb, readBits4);
                                    break;
                                } else if (i5 == 3) {
                                    mode = forBits;
                                    decodeAlphanumericSegment(bitSource, sb, readBits4, z);
                                    break;
                                } else if (i5 == 5) {
                                    mode = forBits;
                                    decodeByteSegment(bitSource, sb, readBits4, characterSetECI, arrayList, map);
                                    break;
                                } else {
                                    if (i5 != 7) {
                                        throw FormatException.getFormatInstance();
                                    }
                                    decodeKanjiSegment(bitSource, sb, readBits4);
                                    break;
                                }
                        }
                    } else {
                        mode = forBits;
                        characterSetECI = CharacterSetECI.getCharacterSetECIByValue(parseECIValue(bitSource));
                        if (characterSetECI == null) {
                            throw FormatException.getFormatInstance();
                        }
                    }
                }
                mode = forBits;
            } catch (IllegalArgumentException unused) {
                throw FormatException.getFormatInstance();
            }
        } while (mode != Mode.TERMINATOR);
        return new DecoderResult(bArr, sb.toString(), arrayList.isEmpty() ? null : arrayList, errorCorrectionLevel == null ? null : errorCorrectionLevel.toString(), i2, i3);
    }

    public static void decodeAlphanumericSegment(BitSource bitSource, StringBuilder sb, int i2, boolean z) throws FormatException {
        while (i2 > 1) {
            if (bitSource.available() < 11) {
                throw FormatException.getFormatInstance();
            }
            int readBits = bitSource.readBits(11);
            sb.append(toAlphaNumericChar(readBits / 45));
            sb.append(toAlphaNumericChar(readBits % 45));
            i2 -= 2;
        }
        if (i2 == 1) {
            if (bitSource.available() < 6) {
                throw FormatException.getFormatInstance();
            }
            sb.append(toAlphaNumericChar(bitSource.readBits(6)));
        }
        if (z) {
            for (int length = sb.length(); length < sb.length(); length++) {
                if (sb.charAt(length) == '%') {
                    if (length < sb.length() - 1) {
                        int i3 = length + 1;
                        if (sb.charAt(i3) == '%') {
                            sb.deleteCharAt(i3);
                        }
                    }
                    sb.setCharAt(length, com.google.zxing.maxicode.decoder.DecodedBitStreamParser.GS);
                }
            }
        }
    }

    public static void decodeByteSegment(BitSource bitSource, StringBuilder sb, int i2, CharacterSetECI characterSetECI, Collection<byte[]> collection, Map<DecodeHintType, ?> map) throws FormatException {
        if (i2 * 8 > bitSource.available()) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            bArr[i3] = (byte) bitSource.readBits(8);
        }
        try {
            sb.append(new String(bArr, characterSetECI == null ? StringUtils.guessEncoding(bArr, map) : characterSetECI.name()));
            collection.add(bArr);
        } catch (UnsupportedEncodingException unused) {
            throw FormatException.getFormatInstance();
        }
    }

    public static void decodeHanziSegment(BitSource bitSource, StringBuilder sb, int i2) throws FormatException {
        if (i2 * 13 > bitSource.available()) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[i2 * 2];
        int i3 = 0;
        while (i2 > 0) {
            int readBits = bitSource.readBits(13);
            int i4 = (readBits % 96) | ((readBits / 96) << 8);
            int i5 = i4 + (i4 < 2560 ? 41377 : 42657);
            bArr[i3] = (byte) ((i5 >> 8) & ViewfinderView.OPAQUE);
            bArr[i3 + 1] = (byte) (i5 & ViewfinderView.OPAQUE);
            i3 += 2;
            i2--;
        }
        try {
            sb.append(new String(bArr, StringUtils.GB2312));
        } catch (UnsupportedEncodingException unused) {
            throw FormatException.getFormatInstance();
        }
    }

    public static void decodeKanjiSegment(BitSource bitSource, StringBuilder sb, int i2) throws FormatException {
        if (i2 * 13 > bitSource.available()) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[i2 * 2];
        int i3 = 0;
        while (i2 > 0) {
            int readBits = bitSource.readBits(13);
            int i4 = (readBits % 192) | ((readBits / 192) << 8);
            int i5 = i4 + (i4 < 7936 ? 33088 : 49472);
            bArr[i3] = (byte) (i5 >> 8);
            bArr[i3 + 1] = (byte) i5;
            i3 += 2;
            i2--;
        }
        try {
            sb.append(new String(bArr, StringUtils.SHIFT_JIS));
        } catch (UnsupportedEncodingException unused) {
            throw FormatException.getFormatInstance();
        }
    }

    public static void decodeNumericSegment(BitSource bitSource, StringBuilder sb, int i2) throws FormatException {
        while (i2 >= 3) {
            if (bitSource.available() < 10) {
                throw FormatException.getFormatInstance();
            }
            int readBits = bitSource.readBits(10);
            if (readBits >= 1000) {
                throw FormatException.getFormatInstance();
            }
            sb.append(toAlphaNumericChar(readBits / 100));
            sb.append(toAlphaNumericChar((readBits / 10) % 10));
            sb.append(toAlphaNumericChar(readBits % 10));
            i2 -= 3;
        }
        if (i2 == 2) {
            if (bitSource.available() < 7) {
                throw FormatException.getFormatInstance();
            }
            int readBits2 = bitSource.readBits(7);
            if (readBits2 >= 100) {
                throw FormatException.getFormatInstance();
            }
            sb.append(toAlphaNumericChar(readBits2 / 10));
            sb.append(toAlphaNumericChar(readBits2 % 10));
            return;
        }
        if (i2 == 1) {
            if (bitSource.available() < 4) {
                throw FormatException.getFormatInstance();
            }
            int readBits3 = bitSource.readBits(4);
            if (readBits3 >= 10) {
                throw FormatException.getFormatInstance();
            }
            sb.append(toAlphaNumericChar(readBits3));
        }
    }

    public static int parseECIValue(BitSource bitSource) throws FormatException {
        int readBits = bitSource.readBits(8);
        if ((readBits & RecyclerView.c0.FLAG_IGNORE) == 0) {
            return readBits & 127;
        }
        if ((readBits & 192) == 128) {
            return bitSource.readBits(8) | ((readBits & 63) << 8);
        }
        if ((readBits & 224) == 192) {
            return bitSource.readBits(16) | ((readBits & 31) << 16);
        }
        throw FormatException.getFormatInstance();
    }

    public static char toAlphaNumericChar(int i2) throws FormatException {
        char[] cArr = ALPHANUMERIC_CHARS;
        if (i2 < cArr.length) {
            return cArr[i2];
        }
        throw FormatException.getFormatInstance();
    }
}
