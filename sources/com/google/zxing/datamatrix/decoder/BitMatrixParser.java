package com.google.zxing.datamatrix.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;

/* loaded from: classes.dex */
public final class BitMatrixParser {
    public final BitMatrix mappingBitMatrix;
    public final BitMatrix readMappingMatrix;
    public final Version version;

    public BitMatrixParser(BitMatrix bitMatrix) throws FormatException {
        int height = bitMatrix.getHeight();
        if (height < 8 || height > 144 || (height & 1) != 0) {
            throw FormatException.getFormatInstance();
        }
        this.version = readVersion(bitMatrix);
        BitMatrix extractDataRegion = extractDataRegion(bitMatrix);
        this.mappingBitMatrix = extractDataRegion;
        this.readMappingMatrix = new BitMatrix(extractDataRegion.getWidth(), this.mappingBitMatrix.getHeight());
    }

    private BitMatrix extractDataRegion(BitMatrix bitMatrix) {
        int symbolSizeRows = this.version.getSymbolSizeRows();
        int symbolSizeColumns = this.version.getSymbolSizeColumns();
        if (bitMatrix.getHeight() != symbolSizeRows) {
            throw new IllegalArgumentException("Dimension of bitMatrix must match the version size");
        }
        int dataRegionSizeRows = this.version.getDataRegionSizeRows();
        int dataRegionSizeColumns = this.version.getDataRegionSizeColumns();
        int i2 = symbolSizeRows / dataRegionSizeRows;
        int i3 = symbolSizeColumns / dataRegionSizeColumns;
        BitMatrix bitMatrix2 = new BitMatrix(i3 * dataRegionSizeColumns, i2 * dataRegionSizeRows);
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = i4 * dataRegionSizeRows;
            for (int i6 = 0; i6 < i3; i6++) {
                int i7 = i6 * dataRegionSizeColumns;
                for (int i8 = 0; i8 < dataRegionSizeRows; i8++) {
                    int i9 = ((dataRegionSizeRows + 2) * i4) + 1 + i8;
                    int i10 = i5 + i8;
                    for (int i11 = 0; i11 < dataRegionSizeColumns; i11++) {
                        if (bitMatrix.get(((dataRegionSizeColumns + 2) * i6) + 1 + i11, i9)) {
                            bitMatrix2.set(i7 + i11, i10);
                        }
                    }
                }
            }
        }
        return bitMatrix2;
    }

    private int readCorner1(int i2, int i3) {
        int i4 = i2 - 1;
        int i5 = (readModule(i4, 0, i2, i3) ? 1 : 0) << 1;
        if (readModule(i4, 1, i2, i3)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        if (readModule(i4, 2, i2, i3)) {
            i6 |= 1;
        }
        int i7 = i6 << 1;
        if (readModule(0, i3 - 2, i2, i3)) {
            i7 |= 1;
        }
        int i8 = i7 << 1;
        int i9 = i3 - 1;
        if (readModule(0, i9, i2, i3)) {
            i8 |= 1;
        }
        int i10 = i8 << 1;
        if (readModule(1, i9, i2, i3)) {
            i10 |= 1;
        }
        int i11 = i10 << 1;
        if (readModule(2, i9, i2, i3)) {
            i11 |= 1;
        }
        int i12 = i11 << 1;
        return readModule(3, i9, i2, i3) ? i12 | 1 : i12;
    }

    private int readCorner2(int i2, int i3) {
        int i4 = (readModule(i2 + (-3), 0, i2, i3) ? 1 : 0) << 1;
        if (readModule(i2 - 2, 0, i2, i3)) {
            i4 |= 1;
        }
        int i5 = i4 << 1;
        if (readModule(i2 - 1, 0, i2, i3)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        if (readModule(0, i3 - 4, i2, i3)) {
            i6 |= 1;
        }
        int i7 = i6 << 1;
        if (readModule(0, i3 - 3, i2, i3)) {
            i7 |= 1;
        }
        int i8 = i7 << 1;
        if (readModule(0, i3 - 2, i2, i3)) {
            i8 |= 1;
        }
        int i9 = i8 << 1;
        int i10 = i3 - 1;
        if (readModule(0, i10, i2, i3)) {
            i9 |= 1;
        }
        int i11 = i9 << 1;
        return readModule(1, i10, i2, i3) ? i11 | 1 : i11;
    }

    private int readCorner3(int i2, int i3) {
        int i4 = i2 - 1;
        int i5 = (readModule(i4, 0, i2, i3) ? 1 : 0) << 1;
        int i6 = i3 - 1;
        if (readModule(i4, i6, i2, i3)) {
            i5 |= 1;
        }
        int i7 = i5 << 1;
        int i8 = i3 - 3;
        if (readModule(0, i8, i2, i3)) {
            i7 |= 1;
        }
        int i9 = i7 << 1;
        int i10 = i3 - 2;
        if (readModule(0, i10, i2, i3)) {
            i9 |= 1;
        }
        int i11 = i9 << 1;
        if (readModule(0, i6, i2, i3)) {
            i11 |= 1;
        }
        int i12 = i11 << 1;
        if (readModule(1, i8, i2, i3)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        if (readModule(1, i10, i2, i3)) {
            i13 |= 1;
        }
        int i14 = i13 << 1;
        return readModule(1, i6, i2, i3) ? i14 | 1 : i14;
    }

    private int readCorner4(int i2, int i3) {
        int i4 = (readModule(i2 + (-3), 0, i2, i3) ? 1 : 0) << 1;
        if (readModule(i2 - 2, 0, i2, i3)) {
            i4 |= 1;
        }
        int i5 = i4 << 1;
        if (readModule(i2 - 1, 0, i2, i3)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        if (readModule(0, i3 - 2, i2, i3)) {
            i6 |= 1;
        }
        int i7 = i6 << 1;
        int i8 = i3 - 1;
        if (readModule(0, i8, i2, i3)) {
            i7 |= 1;
        }
        int i9 = i7 << 1;
        if (readModule(1, i8, i2, i3)) {
            i9 |= 1;
        }
        int i10 = i9 << 1;
        if (readModule(2, i8, i2, i3)) {
            i10 |= 1;
        }
        int i11 = i10 << 1;
        return readModule(3, i8, i2, i3) ? i11 | 1 : i11;
    }

    private boolean readModule(int i2, int i3, int i4, int i5) {
        if (i2 < 0) {
            i2 += i4;
            i3 += 4 - ((i4 + 4) & 7);
        }
        if (i3 < 0) {
            i3 += i5;
            i2 += 4 - ((i5 + 4) & 7);
        }
        this.readMappingMatrix.set(i3, i2);
        return this.mappingBitMatrix.get(i3, i2);
    }

    private int readUtah(int i2, int i3, int i4, int i5) {
        int i6 = i2 - 2;
        int i7 = i3 - 2;
        int i8 = (readModule(i6, i7, i4, i5) ? 1 : 0) << 1;
        int i9 = i3 - 1;
        if (readModule(i6, i9, i4, i5)) {
            i8 |= 1;
        }
        int i10 = i8 << 1;
        int i11 = i2 - 1;
        if (readModule(i11, i7, i4, i5)) {
            i10 |= 1;
        }
        int i12 = i10 << 1;
        if (readModule(i11, i9, i4, i5)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        if (readModule(i11, i3, i4, i5)) {
            i13 |= 1;
        }
        int i14 = i13 << 1;
        if (readModule(i2, i7, i4, i5)) {
            i14 |= 1;
        }
        int i15 = i14 << 1;
        if (readModule(i2, i9, i4, i5)) {
            i15 |= 1;
        }
        int i16 = i15 << 1;
        return readModule(i2, i3, i4, i5) ? i16 | 1 : i16;
    }

    public static Version readVersion(BitMatrix bitMatrix) throws FormatException {
        return Version.getVersionForDimensions(bitMatrix.getHeight(), bitMatrix.getWidth());
    }

    public Version getVersion() {
        return this.version;
    }

    public byte[] readCodewords() throws FormatException {
        byte[] bArr = new byte[this.version.getTotalCodewords()];
        int height = this.mappingBitMatrix.getHeight();
        int width = this.mappingBitMatrix.getWidth();
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        int i4 = 4;
        while (true) {
            if (i4 == height && i2 == 0 && !z) {
                bArr[i3] = (byte) readCorner1(height, width);
                i4 -= 2;
                i2 += 2;
                i3++;
                z = true;
            } else {
                int i5 = height - 2;
                if (i4 == i5 && i2 == 0 && (width & 3) != 0 && !z2) {
                    bArr[i3] = (byte) readCorner2(height, width);
                    i4 -= 2;
                    i2 += 2;
                    i3++;
                    z2 = true;
                } else if (i4 == height + 4 && i2 == 2 && (width & 7) == 0 && !z3) {
                    bArr[i3] = (byte) readCorner3(height, width);
                    i4 -= 2;
                    i2 += 2;
                    i3++;
                    z3 = true;
                } else if (i4 == i5 && i2 == 0 && (width & 7) == 4 && !z4) {
                    bArr[i3] = (byte) readCorner4(height, width);
                    i4 -= 2;
                    i2 += 2;
                    i3++;
                    z4 = true;
                } else {
                    do {
                        if (i4 < height && i2 >= 0 && !this.readMappingMatrix.get(i2, i4)) {
                            bArr[i3] = (byte) readUtah(i4, i2, height, width);
                            i3++;
                        }
                        i4 -= 2;
                        i2 += 2;
                        if (i4 < 0) {
                            break;
                        }
                    } while (i2 < width);
                    int i6 = i4 + 1;
                    int i7 = i2 + 3;
                    do {
                        if (i6 >= 0 && i7 < width && !this.readMappingMatrix.get(i7, i6)) {
                            bArr[i3] = (byte) readUtah(i6, i7, height, width);
                            i3++;
                        }
                        i6 += 2;
                        i7 -= 2;
                        if (i6 >= height) {
                            break;
                        }
                    } while (i7 >= 0);
                    i4 = i6 + 3;
                    i2 = i7 + 1;
                }
            }
            if (i4 >= height && i2 >= width) {
                break;
            }
        }
        if (i3 == this.version.getTotalCodewords()) {
            return bArr;
        }
        throw FormatException.getFormatInstance();
    }
}
