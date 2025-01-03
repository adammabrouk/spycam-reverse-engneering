package com.google.zxing.aztec.decoder;

import c.a.a.j.a;
import cn.jpush.android.service.WakedResultReceiver;
import com.alibaba.sdk.android.oss.common.utils.OSSUtils;
import com.google.zxing.FormatException;
import com.google.zxing.aztec.AztecDetectorResult;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import com.shix.shixipc.utilcode.LogUtils;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class Decoder {
    public static /* synthetic */ int[] $SWITCH_TABLE$com$google$zxing$aztec$decoder$Decoder$Table;
    public AztecDetectorResult ddata;
    public static final String[] UPPER_TABLE = {"CTRL_PS", LogUtils.PLACEHOLDER, "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    public static final String[] LOWER_TABLE = {"CTRL_PS", LogUtils.PLACEHOLDER, a.o, "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    public static final String[] MIXED_TABLE = {"CTRL_PS", LogUtils.PLACEHOLDER, "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", OSSUtils.NEW_LINE, "\u000b", "\f", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", "_", "`", "|", "~", "\u007f", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};
    public static final String[] PUNCT_TABLE = {"", "\r", "\r\n", ". ", ", ", ": ", "!", "\"", "#", "$", "%", "&", "'", "(", ")", "*", "+", ",", "-", ".", "/", ":", ";", "<", "=", ">", "?", "[", "]", "{", "}", "CTRL_UL"};
    public static final String[] DIGIT_TABLE = {"CTRL_PS", LogUtils.PLACEHOLDER, "0", "1", WakedResultReceiver.WAKE_TYPE_KEY, "3", "4", "5", "6", "7", "8", "9", ",", ".", "CTRL_UL", "CTRL_US"};

    public enum Table {
        UPPER,
        LOWER,
        MIXED,
        DIGIT,
        PUNCT,
        BINARY;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static Table[] valuesCustom() {
            Table[] valuesCustom = values();
            int length = valuesCustom.length;
            Table[] tableArr = new Table[length];
            System.arraycopy(valuesCustom, 0, tableArr, 0, length);
            return tableArr;
        }
    }

    public static /* synthetic */ int[] $SWITCH_TABLE$com$google$zxing$aztec$decoder$Decoder$Table() {
        int[] iArr = $SWITCH_TABLE$com$google$zxing$aztec$decoder$Decoder$Table;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[Table.valuesCustom().length];
        try {
            iArr2[Table.BINARY.ordinal()] = 6;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[Table.DIGIT.ordinal()] = 4;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[Table.LOWER.ordinal()] = 2;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[Table.MIXED.ordinal()] = 3;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[Table.PUNCT.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr2[Table.UPPER.ordinal()] = 1;
        } catch (NoSuchFieldError unused6) {
        }
        $SWITCH_TABLE$com$google$zxing$aztec$decoder$Decoder$Table = iArr2;
        return iArr2;
    }

    public static byte[] convertBoolArrayToByteArray(boolean[] zArr) {
        int length = (zArr.length + 7) / 8;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            bArr[i2] = readByte(zArr, i2 * 8);
        }
        return bArr;
    }

    private boolean[] correctBits(boolean[] zArr) throws FormatException {
        GenericGF genericGF;
        int i2 = 8;
        if (this.ddata.getNbLayers() <= 2) {
            i2 = 6;
            genericGF = GenericGF.AZTEC_DATA_6;
        } else if (this.ddata.getNbLayers() <= 8) {
            genericGF = GenericGF.AZTEC_DATA_8;
        } else if (this.ddata.getNbLayers() <= 22) {
            i2 = 10;
            genericGF = GenericGF.AZTEC_DATA_10;
        } else {
            i2 = 12;
            genericGF = GenericGF.AZTEC_DATA_12;
        }
        int nbDatablocks = this.ddata.getNbDatablocks();
        int length = zArr.length / i2;
        if (length < nbDatablocks) {
            throw FormatException.getFormatInstance();
        }
        int length2 = zArr.length % i2;
        int[] iArr = new int[length];
        int i3 = 0;
        while (i3 < length) {
            iArr[i3] = readCode(zArr, length2, i2);
            i3++;
            length2 += i2;
        }
        try {
            new ReedSolomonDecoder(genericGF).decode(iArr, length - nbDatablocks);
            int i4 = (1 << i2) - 1;
            int i5 = 0;
            for (int i6 = 0; i6 < nbDatablocks; i6++) {
                int i7 = iArr[i6];
                if (i7 == 0 || i7 == i4) {
                    throw FormatException.getFormatInstance();
                }
                if (i7 == 1 || i7 == i4 - 1) {
                    i5++;
                }
            }
            boolean[] zArr2 = new boolean[(nbDatablocks * i2) - i5];
            int i8 = 0;
            for (int i9 = 0; i9 < nbDatablocks; i9++) {
                int i10 = iArr[i9];
                if (i10 == 1 || i10 == i4 - 1) {
                    Arrays.fill(zArr2, i8, (i8 + i2) - 1, i10 > 1);
                    i8 += i2 - 1;
                } else {
                    int i11 = i2 - 1;
                    while (i11 >= 0) {
                        int i12 = i8 + 1;
                        zArr2[i8] = ((1 << i11) & i10) != 0;
                        i11--;
                        i8 = i12;
                    }
                }
            }
            return zArr2;
        } catch (ReedSolomonException e2) {
            throw FormatException.getFormatInstance(e2);
        }
    }

    private boolean[] extractBits(BitMatrix bitMatrix) {
        boolean isCompact = this.ddata.isCompact();
        int nbLayers = this.ddata.getNbLayers();
        int i2 = (isCompact ? 11 : 14) + (nbLayers * 4);
        int[] iArr = new int[i2];
        boolean[] zArr = new boolean[totalBitsInLayer(nbLayers, isCompact)];
        int i3 = 2;
        if (isCompact) {
            for (int i4 = 0; i4 < i2; i4++) {
                iArr[i4] = i4;
            }
        } else {
            int i5 = i2 / 2;
            int i6 = ((i2 + 1) + (((i5 - 1) / 15) * 2)) / 2;
            int i7 = 0;
            while (i7 < i5) {
                iArr[(i5 - i7) - 1] = (i6 - r0) - 1;
                iArr[i5 + i7] = (i7 / 15) + i7 + i6 + 1;
                i7++;
                i3 = 2;
            }
        }
        int i8 = 0;
        for (int i9 = 0; i9 < nbLayers; i9++) {
            int i10 = ((nbLayers - i9) * 4) + (isCompact ? 9 : 12);
            int i11 = i9 * 2;
            int i12 = (i2 - 1) - i11;
            for (int i13 = 0; i13 < i10; i13++) {
                int i14 = i13 * 2;
                int i15 = 0;
                while (i15 < i3) {
                    int i16 = i11 + i15;
                    int i17 = i11 + i13;
                    zArr[i8 + i14 + i15] = bitMatrix.get(iArr[i16], iArr[i17]);
                    int i18 = i12 - i15;
                    zArr[(i10 * 2) + i8 + i14 + i15] = bitMatrix.get(iArr[i17], iArr[i18]);
                    int i19 = i12 - i13;
                    zArr[(i10 * 4) + i8 + i14 + i15] = bitMatrix.get(iArr[i18], iArr[i19]);
                    zArr[(i10 * 6) + i8 + i14 + i15] = bitMatrix.get(iArr[i19], iArr[i16]);
                    i15++;
                    i3 = 2;
                }
            }
            i8 += i10 * 8;
        }
        return zArr;
    }

    public static String getCharacter(Table table, int i2) {
        int i3 = $SWITCH_TABLE$com$google$zxing$aztec$decoder$Decoder$Table()[table.ordinal()];
        if (i3 == 1) {
            return UPPER_TABLE[i2];
        }
        if (i3 == 2) {
            return LOWER_TABLE[i2];
        }
        if (i3 == 3) {
            return MIXED_TABLE[i2];
        }
        if (i3 == 4) {
            return DIGIT_TABLE[i2];
        }
        if (i3 == 5) {
            return PUNCT_TABLE[i2];
        }
        throw new IllegalStateException("Bad table");
    }

    public static String getEncodedData(boolean[] zArr) {
        int length = zArr.length;
        Table table = Table.UPPER;
        StringBuilder sb = new StringBuilder(20);
        Table table2 = table;
        int i2 = 0;
        while (i2 < length) {
            if (table != Table.BINARY) {
                int i3 = table == Table.DIGIT ? 4 : 5;
                if (length - i2 < i3) {
                    break;
                }
                int readCode = readCode(zArr, i2, i3);
                i2 += i3;
                String character = getCharacter(table, readCode);
                if (character.startsWith("CTRL_")) {
                    table2 = getTable(character.charAt(5));
                    if (character.charAt(6) != 'L') {
                        table2 = table;
                        table = table2;
                    }
                } else {
                    sb.append(character);
                }
                table = table2;
            } else {
                if (length - i2 < 5) {
                    break;
                }
                int readCode2 = readCode(zArr, i2, 5);
                i2 += 5;
                if (readCode2 == 0) {
                    if (length - i2 < 11) {
                        break;
                    }
                    readCode2 = readCode(zArr, i2, 11) + 31;
                    i2 += 11;
                }
                int i4 = readCode2;
                int i5 = 0;
                while (true) {
                    if (i5 >= i4) {
                        break;
                    }
                    if (length - i2 < 8) {
                        i2 = length;
                        break;
                    }
                    sb.append((char) readCode(zArr, i2, 8));
                    i2 += 8;
                    i5++;
                }
                table = table2;
            }
        }
        return sb.toString();
    }

    public static Table getTable(char c2) {
        return c2 != 'B' ? c2 != 'D' ? c2 != 'P' ? c2 != 'L' ? c2 != 'M' ? Table.UPPER : Table.MIXED : Table.LOWER : Table.PUNCT : Table.DIGIT : Table.BINARY;
    }

    public static String highLevelDecode(boolean[] zArr) {
        return getEncodedData(zArr);
    }

    public static byte readByte(boolean[] zArr, int i2) {
        int length = zArr.length - i2;
        return (byte) (length >= 8 ? readCode(zArr, i2, 8) : readCode(zArr, i2, length) << (8 - length));
    }

    public static int readCode(boolean[] zArr, int i2, int i3) {
        int i4 = 0;
        for (int i5 = i2; i5 < i2 + i3; i5++) {
            i4 <<= 1;
            if (zArr[i5]) {
                i4 |= 1;
            }
        }
        return i4;
    }

    public static int totalBitsInLayer(int i2, boolean z) {
        return ((z ? 88 : 112) + (i2 * 16)) * i2;
    }

    public DecoderResult decode(AztecDetectorResult aztecDetectorResult) throws FormatException {
        this.ddata = aztecDetectorResult;
        boolean[] correctBits = correctBits(extractBits(aztecDetectorResult.getBits()));
        DecoderResult decoderResult = new DecoderResult(convertBoolArrayToByteArray(correctBits), getEncodedData(correctBits), null, null);
        decoderResult.setNumBits(correctBits.length);
        return decoderResult;
    }
}
