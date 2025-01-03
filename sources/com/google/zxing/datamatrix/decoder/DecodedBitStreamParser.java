package com.google.zxing.datamatrix.decoder;

import androidx.recyclerview.widget.RecyclerView;
import com.google.zxing.FormatException;
import com.google.zxing.common.BitSource;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.StringUtils;
import com.google.zxing.datamatrix.encoder.HighLevelEncoder;
import com.google.zxing.oned.rss.expanded.decoders.DecodedChar;
import com.google.zxing.view.ViewfinderView;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class DecodedBitStreamParser {
    public static /* synthetic */ int[] $SWITCH_TABLE$com$google$zxing$datamatrix$decoder$DecodedBitStreamParser$Mode;
    public static final char[] C40_BASIC_SET_CHARS = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    public static final char[] C40_SHIFT2_SET_CHARS;
    public static final char[] TEXT_BASIC_SET_CHARS;
    public static final char[] TEXT_SHIFT2_SET_CHARS;
    public static final char[] TEXT_SHIFT3_SET_CHARS;

    public enum Mode {
        PAD_ENCODE,
        ASCII_ENCODE,
        C40_ENCODE,
        TEXT_ENCODE,
        ANSIX12_ENCODE,
        EDIFACT_ENCODE,
        BASE256_ENCODE;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static Mode[] valuesCustom() {
            Mode[] valuesCustom = values();
            int length = valuesCustom.length;
            Mode[] modeArr = new Mode[length];
            System.arraycopy(valuesCustom, 0, modeArr, 0, length);
            return modeArr;
        }
    }

    public static /* synthetic */ int[] $SWITCH_TABLE$com$google$zxing$datamatrix$decoder$DecodedBitStreamParser$Mode() {
        int[] iArr = $SWITCH_TABLE$com$google$zxing$datamatrix$decoder$DecodedBitStreamParser$Mode;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[Mode.valuesCustom().length];
        try {
            iArr2[Mode.ANSIX12_ENCODE.ordinal()] = 5;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[Mode.ASCII_ENCODE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[Mode.BASE256_ENCODE.ordinal()] = 7;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[Mode.C40_ENCODE.ordinal()] = 3;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[Mode.EDIFACT_ENCODE.ordinal()] = 6;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr2[Mode.PAD_ENCODE.ordinal()] = 1;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            iArr2[Mode.TEXT_ENCODE.ordinal()] = 4;
        } catch (NoSuchFieldError unused7) {
        }
        $SWITCH_TABLE$com$google$zxing$datamatrix$decoder$DecodedBitStreamParser$Mode = iArr2;
        return iArr2;
    }

    static {
        char[] cArr = {'!', '\"', '#', DecodedChar.FNC1, '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', ':', ';', '<', '=', '>', '?', '@', '[', '\\', ']', '^', '_'};
        C40_SHIFT2_SET_CHARS = cArr;
        TEXT_BASIC_SET_CHARS = new char[]{'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        TEXT_SHIFT2_SET_CHARS = cArr;
        TEXT_SHIFT3_SET_CHARS = new char[]{'`', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '{', '|', '}', '~', 127};
    }

    public static DecoderResult decode(byte[] bArr) throws FormatException {
        BitSource bitSource = new BitSource(bArr);
        StringBuilder sb = new StringBuilder(100);
        StringBuilder sb2 = new StringBuilder(0);
        ArrayList arrayList = new ArrayList(1);
        Mode mode = Mode.ASCII_ENCODE;
        do {
            if (mode == Mode.ASCII_ENCODE) {
                mode = decodeAsciiSegment(bitSource, sb, sb2);
            } else {
                int i2 = $SWITCH_TABLE$com$google$zxing$datamatrix$decoder$DecodedBitStreamParser$Mode()[mode.ordinal()];
                if (i2 == 3) {
                    decodeC40Segment(bitSource, sb);
                } else if (i2 == 4) {
                    decodeTextSegment(bitSource, sb);
                } else if (i2 == 5) {
                    decodeAnsiX12Segment(bitSource, sb);
                } else if (i2 == 6) {
                    decodeEdifactSegment(bitSource, sb);
                } else {
                    if (i2 != 7) {
                        throw FormatException.getFormatInstance();
                    }
                    decodeBase256Segment(bitSource, sb, arrayList);
                }
                mode = Mode.ASCII_ENCODE;
            }
            if (mode == Mode.PAD_ENCODE) {
                break;
            }
        } while (bitSource.available() > 0);
        if (sb2.length() > 0) {
            sb.append((CharSequence) sb2);
        }
        String sb3 = sb.toString();
        if (arrayList.isEmpty()) {
            arrayList = null;
        }
        return new DecoderResult(bArr, sb3, arrayList, null);
    }

    public static void decodeAnsiX12Segment(BitSource bitSource, StringBuilder sb) throws FormatException {
        int readBits;
        int[] iArr = new int[3];
        while (bitSource.available() != 8 && (readBits = bitSource.readBits(8)) != 254) {
            parseTwoBytes(readBits, bitSource.readBits(8), iArr);
            for (int i2 = 0; i2 < 3; i2++) {
                int i3 = iArr[i2];
                if (i3 == 0) {
                    sb.append('\r');
                } else if (i3 == 1) {
                    sb.append('*');
                } else if (i3 == 2) {
                    sb.append('>');
                } else if (i3 == 3) {
                    sb.append(' ');
                } else if (i3 < 14) {
                    sb.append((char) (i3 + 44));
                } else {
                    if (i3 >= 40) {
                        throw FormatException.getFormatInstance();
                    }
                    sb.append((char) (i3 + 51));
                }
            }
            if (bitSource.available() <= 0) {
                return;
            }
        }
    }

    public static Mode decodeAsciiSegment(BitSource bitSource, StringBuilder sb, StringBuilder sb2) throws FormatException {
        boolean z = false;
        do {
            int readBits = bitSource.readBits(8);
            if (readBits == 0) {
                throw FormatException.getFormatInstance();
            }
            if (readBits > 128) {
                if (readBits != 129) {
                    if (readBits > 229) {
                        switch (readBits) {
                            case 230:
                                return Mode.C40_ENCODE;
                            case 231:
                                return Mode.BASE256_ENCODE;
                            case 232:
                                sb.append(com.google.zxing.maxicode.decoder.DecodedBitStreamParser.GS);
                                break;
                            case 233:
                            case 234:
                            case 241:
                                break;
                            case 235:
                                z = true;
                                break;
                            case 236:
                                sb.append(HighLevelEncoder.MACRO_05_HEADER);
                                sb2.insert(0, HighLevelEncoder.MACRO_TRAILER);
                                break;
                            case 237:
                                sb.append(HighLevelEncoder.MACRO_06_HEADER);
                                sb2.insert(0, HighLevelEncoder.MACRO_TRAILER);
                                break;
                            case 238:
                                return Mode.ANSIX12_ENCODE;
                            case 239:
                                return Mode.TEXT_ENCODE;
                            case 240:
                                return Mode.EDIFACT_ENCODE;
                            default:
                                if (readBits != 254 || bitSource.available() != 0) {
                                    throw FormatException.getFormatInstance();
                                }
                                break;
                        }
                    } else {
                        int i2 = readBits - 130;
                        if (i2 < 10) {
                            sb.append('0');
                        }
                        sb.append(i2);
                    }
                } else {
                    return Mode.PAD_ENCODE;
                }
            } else {
                if (z) {
                    readBits += RecyclerView.c0.FLAG_IGNORE;
                }
                sb.append((char) (readBits - 1));
                return Mode.ASCII_ENCODE;
            }
        } while (bitSource.available() > 0);
        return Mode.ASCII_ENCODE;
    }

    public static void decodeBase256Segment(BitSource bitSource, StringBuilder sb, Collection<byte[]> collection) throws FormatException {
        int byteOffset = bitSource.getByteOffset() + 1;
        int i2 = byteOffset + 1;
        int unrandomize255State = unrandomize255State(bitSource.readBits(8), byteOffset);
        if (unrandomize255State == 0) {
            unrandomize255State = bitSource.available() / 8;
        } else if (unrandomize255State >= 250) {
            unrandomize255State = ((unrandomize255State - 249) * 250) + unrandomize255State(bitSource.readBits(8), i2);
            i2++;
        }
        if (unrandomize255State < 0) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[unrandomize255State];
        int i3 = 0;
        while (i3 < unrandomize255State) {
            if (bitSource.available() < 8) {
                throw FormatException.getFormatInstance();
            }
            bArr[i3] = (byte) unrandomize255State(bitSource.readBits(8), i2);
            i3++;
            i2++;
        }
        collection.add(bArr);
        try {
            sb.append(new String(bArr, StringUtils.ISO88591));
        } catch (UnsupportedEncodingException e2) {
            throw new IllegalStateException("Platform does not support required encoding: " + e2);
        }
    }

    public static void decodeC40Segment(BitSource bitSource, StringBuilder sb) throws FormatException {
        int readBits;
        int[] iArr = new int[3];
        boolean z = false;
        int i2 = 0;
        while (bitSource.available() != 8 && (readBits = bitSource.readBits(8)) != 254) {
            parseTwoBytes(readBits, bitSource.readBits(8), iArr);
            for (int i3 = 0; i3 < 3; i3++) {
                int i4 = iArr[i3];
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            char[] cArr = C40_SHIFT2_SET_CHARS;
                            if (i4 < cArr.length) {
                                char c2 = cArr[i4];
                                if (z) {
                                    sb.append((char) (c2 + 128));
                                    z = false;
                                } else {
                                    sb.append(c2);
                                }
                            } else if (i4 == 27) {
                                sb.append(com.google.zxing.maxicode.decoder.DecodedBitStreamParser.GS);
                            } else {
                                if (i4 != 30) {
                                    throw FormatException.getFormatInstance();
                                }
                                z = true;
                            }
                            i2 = 0;
                        } else {
                            if (i2 != 3) {
                                throw FormatException.getFormatInstance();
                            }
                            if (z) {
                                sb.append((char) (i4 + 224));
                                z = false;
                                i2 = 0;
                            } else {
                                sb.append((char) (i4 + 96));
                                i2 = 0;
                            }
                        }
                    } else if (z) {
                        sb.append((char) (i4 + RecyclerView.c0.FLAG_IGNORE));
                        z = false;
                        i2 = 0;
                    } else {
                        sb.append((char) i4);
                        i2 = 0;
                    }
                } else if (i4 < 3) {
                    i2 = i4 + 1;
                } else {
                    char[] cArr2 = C40_BASIC_SET_CHARS;
                    if (i4 >= cArr2.length) {
                        throw FormatException.getFormatInstance();
                    }
                    char c3 = cArr2[i4];
                    if (z) {
                        sb.append((char) (c3 + 128));
                        z = false;
                    } else {
                        sb.append(c3);
                    }
                }
            }
            if (bitSource.available() <= 0) {
                return;
            }
        }
    }

    public static void decodeEdifactSegment(BitSource bitSource, StringBuilder sb) {
        while (bitSource.available() > 16) {
            for (int i2 = 0; i2 < 4; i2++) {
                int readBits = bitSource.readBits(6);
                if (readBits == 31) {
                    int bitOffset = 8 - bitSource.getBitOffset();
                    if (bitOffset != 8) {
                        bitSource.readBits(bitOffset);
                        return;
                    }
                    return;
                }
                if ((readBits & 32) == 0) {
                    readBits |= 64;
                }
                sb.append((char) readBits);
            }
            if (bitSource.available() <= 0) {
                return;
            }
        }
    }

    public static void decodeTextSegment(BitSource bitSource, StringBuilder sb) throws FormatException {
        int readBits;
        int[] iArr = new int[3];
        boolean z = false;
        int i2 = 0;
        while (bitSource.available() != 8 && (readBits = bitSource.readBits(8)) != 254) {
            parseTwoBytes(readBits, bitSource.readBits(8), iArr);
            for (int i3 = 0; i3 < 3; i3++) {
                int i4 = iArr[i3];
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            char[] cArr = TEXT_SHIFT2_SET_CHARS;
                            if (i4 < cArr.length) {
                                char c2 = cArr[i4];
                                if (z) {
                                    sb.append((char) (c2 + 128));
                                    z = false;
                                } else {
                                    sb.append(c2);
                                }
                            } else if (i4 == 27) {
                                sb.append(com.google.zxing.maxicode.decoder.DecodedBitStreamParser.GS);
                            } else {
                                if (i4 != 30) {
                                    throw FormatException.getFormatInstance();
                                }
                                z = true;
                            }
                            i2 = 0;
                        } else {
                            if (i2 != 3) {
                                throw FormatException.getFormatInstance();
                            }
                            char[] cArr2 = TEXT_SHIFT3_SET_CHARS;
                            if (i4 >= cArr2.length) {
                                throw FormatException.getFormatInstance();
                            }
                            char c3 = cArr2[i4];
                            if (z) {
                                sb.append((char) (c3 + 128));
                                z = false;
                                i2 = 0;
                            } else {
                                sb.append(c3);
                                i2 = 0;
                            }
                        }
                    } else if (z) {
                        sb.append((char) (i4 + RecyclerView.c0.FLAG_IGNORE));
                        z = false;
                        i2 = 0;
                    } else {
                        sb.append((char) i4);
                        i2 = 0;
                    }
                } else if (i4 < 3) {
                    i2 = i4 + 1;
                } else {
                    char[] cArr3 = TEXT_BASIC_SET_CHARS;
                    if (i4 >= cArr3.length) {
                        throw FormatException.getFormatInstance();
                    }
                    char c4 = cArr3[i4];
                    if (z) {
                        sb.append((char) (c4 + 128));
                        z = false;
                    } else {
                        sb.append(c4);
                    }
                }
            }
            if (bitSource.available() <= 0) {
                return;
            }
        }
    }

    public static void parseTwoBytes(int i2, int i3, int[] iArr) {
        int i4 = ((i2 << 8) + i3) - 1;
        int i5 = i4 / 1600;
        iArr[0] = i5;
        int i6 = i4 - (i5 * 1600);
        int i7 = i6 / 40;
        iArr[1] = i7;
        iArr[2] = i6 - (i7 * 40);
    }

    public static int unrandomize255State(int i2, int i3) {
        int i4 = i2 - (((i3 * 149) % ViewfinderView.OPAQUE) + 1);
        return i4 >= 0 ? i4 : i4 + RecyclerView.c0.FLAG_TMP_DETACHED;
    }
}
