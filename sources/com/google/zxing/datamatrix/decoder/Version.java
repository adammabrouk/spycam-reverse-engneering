package com.google.zxing.datamatrix.decoder;

import com.google.zxing.FormatException;
import com.shix.shixipc.system.ContentCommon;

/* loaded from: classes.dex */
public final class Version {
    public static final Version[] VERSIONS = buildVersions();
    public final int dataRegionSizeColumns;
    public final int dataRegionSizeRows;
    public final ECBlocks ecBlocks;
    public final int symbolSizeColumns;
    public final int symbolSizeRows;
    public final int totalCodewords;
    public final int versionNumber;

    public Version(int i2, int i3, int i4, int i5, int i6, ECBlocks eCBlocks) {
        this.versionNumber = i2;
        this.symbolSizeRows = i3;
        this.symbolSizeColumns = i4;
        this.dataRegionSizeRows = i5;
        this.dataRegionSizeColumns = i6;
        this.ecBlocks = eCBlocks;
        int eCCodewords = eCBlocks.getECCodewords();
        int i7 = 0;
        for (ECB ecb : eCBlocks.getECBlocks()) {
            i7 += ecb.getCount() * (ecb.getDataCodewords() + eCCodewords);
        }
        this.totalCodewords = i7;
    }

    public static Version[] buildVersions() {
        int i2 = 1;
        int i3 = 5;
        int i4 = 8;
        Version version = new Version(3, 14, 14, 12, 12, new ECBlocks(10, new ECB(i2, i4, 0 == true ? 1 : 0), (ECBlocks) (0 == true ? 1 : 0)));
        int i5 = 2;
        int i6 = 12;
        int i7 = 18;
        Version version2 = new Version(7, 22, 22, 20, 20, new ECBlocks(20, new ECB(i2, 30, 0 == true ? 1 : 0), (ECBlocks) (0 == true ? 1 : 0)));
        int i8 = 6;
        int i9 = 36;
        int i10 = 62;
        int i11 = 56;
        int i12 = 68;
        ECB ecb = new ECB(i2, 5, 0 == true ? 1 : 0);
        ECB ecb2 = new ECB(i2, 10, 0 == true ? 1 : 0);
        ECB ecb3 = new ECB(i2, 16, 0 == true ? 1 : 0);
        return new Version[]{new Version(1, 10, 10, 8, 8, new ECBlocks(i3, new ECB(i2, 3, null), (ECBlocks) (0 == true ? 1 : 0))), new Version(2, 12, 12, 10, 10, new ECBlocks(7, new ECB(i2, i3, 0 == true ? 1 : 0), (ECBlocks) (0 == true ? 1 : 0))), version, new Version(4, 16, 16, 14, 14, new ECBlocks(i6, new ECB(i2, i6, 0 == true ? 1 : 0), (ECBlocks) (0 == true ? 1 : 0))), new Version(5, 18, 18, 16, 16, new ECBlocks(14, new ECB(i2, i7, 0 == true ? 1 : 0), (ECBlocks) (0 == true ? 1 : 0))), new Version(6, 20, 20, 18, 18, new ECBlocks(i7, new ECB(i2, 22, 0 == true ? 1 : 0), (ECBlocks) (0 == true ? 1 : 0))), version2, new Version(8, 24, 24, 22, 22, new ECBlocks(24, new ECB(i2, i9, 0 == true ? 1 : 0), (ECBlocks) (0 == true ? 1 : 0))), new Version(9, 26, 26, 24, 24, new ECBlocks(28, new ECB(i2, 44, 0 == true ? 1 : 0), (ECBlocks) (0 == true ? 1 : 0))), new Version(10, 32, 32, 14, 14, new ECBlocks(i9, new ECB(i2, i10, 0 == true ? 1 : 0), (ECBlocks) (0 == true ? 1 : 0))), new Version(11, 36, 36, 16, 16, new ECBlocks(42, new ECB(i2, 86, 0 == true ? 1 : 0), (ECBlocks) (0 == true ? 1 : 0))), new Version(12, 40, 40, 18, 18, new ECBlocks(48, new ECB(i2, 114, 0 == true ? 1 : 0), (ECBlocks) (0 == true ? 1 : 0))), new Version(13, 44, 44, 20, 20, new ECBlocks(i11, new ECB(i2, 144, 0 == true ? 1 : 0), (ECBlocks) (0 == true ? 1 : 0))), new Version(14, 48, 48, 22, 22, new ECBlocks(i12, new ECB(i2, 174, 0 == true ? 1 : 0), (ECBlocks) (0 == true ? 1 : 0))), new Version(15, 52, 52, 24, 24, new ECBlocks(42, new ECB(i5, 102, 0 == true ? 1 : 0), (ECBlocks) (0 == true ? 1 : 0))), new Version(16, 64, 64, 14, 14, new ECBlocks(i11, new ECB(i5, 140, 0 == true ? 1 : 0), (ECBlocks) (0 == true ? 1 : 0))), new Version(17, 72, 72, 16, 16, new ECBlocks(i9, new ECB(4, 92, 0 == true ? 1 : 0), (ECBlocks) (0 == true ? 1 : 0))), new Version(18, 80, 80, 18, 18, new ECBlocks(48, new ECB(4, 114, 0 == true ? 1 : 0), (ECBlocks) (0 == true ? 1 : 0))), new Version(19, 88, 88, 20, 20, new ECBlocks(i11, new ECB(4, 144, 0 == true ? 1 : 0), (ECBlocks) (0 == true ? 1 : 0))), new Version(20, 96, 96, 22, 22, new ECBlocks(i12, new ECB(4, 174, 0 == true ? 1 : 0), (ECBlocks) (0 == true ? 1 : 0))), new Version(21, 104, 104, 24, 24, new ECBlocks(i11, new ECB(i8, 136, 0 == true ? 1 : 0), (ECBlocks) (0 == true ? 1 : 0))), new Version(22, 120, 120, 18, 18, new ECBlocks(i12, new ECB(i8, 175, 0 == true ? 1 : 0), (ECBlocks) (0 == true ? 1 : 0))), new Version(23, ContentCommon.CMD_PTZ_RESET, ContentCommon.CMD_PTZ_RESET, 20, 20, new ECBlocks(i10, new ECB(i4, 163, 0 == true ? 1 : 0), (ECBlocks) (0 == true ? 1 : 0))), new Version(24, 144, 144, 22, 22, new ECBlocks(i10, new ECB(i4, 156, 0 == true ? 1 : 0), new ECB(i5, 155, 0 == true ? 1 : 0), 0 == true ? 1 : 0)), new Version(25, 8, 18, 6, 16, new ECBlocks(7, ecb, (ECBlocks) (0 == true ? 1 : 0))), new Version(26, 8, 32, 6, 14, new ECBlocks(11, ecb2, (ECBlocks) (0 == true ? 1 : 0))), new Version(27, 12, 26, 10, 24, new ECBlocks(14, ecb3, (ECBlocks) (0 == true ? 1 : 0))), new Version(28, 12, 36, 10, 16, new ECBlocks(i7, new ECB(i2, 22, 0 == true ? 1 : 0), (ECBlocks) (0 == true ? 1 : 0))), new Version(29, 16, 36, 14, 16, new ECBlocks(24, new ECB(i2, 32, 0 == true ? 1 : 0), (ECBlocks) (0 == true ? 1 : 0))), new Version(30, 16, 48, 14, 22, new ECBlocks(28, new ECB(i2, 49, 0 == true ? 1 : 0), (ECBlocks) (0 == true ? 1 : 0)))};
    }

    public static Version getVersionForDimensions(int i2, int i3) throws FormatException {
        if ((i2 & 1) != 0 || (i3 & 1) != 0) {
            throw FormatException.getFormatInstance();
        }
        for (Version version : VERSIONS) {
            if (version.symbolSizeRows == i2 && version.symbolSizeColumns == i3) {
                return version;
            }
        }
        throw FormatException.getFormatInstance();
    }

    public int getDataRegionSizeColumns() {
        return this.dataRegionSizeColumns;
    }

    public int getDataRegionSizeRows() {
        return this.dataRegionSizeRows;
    }

    public ECBlocks getECBlocks() {
        return this.ecBlocks;
    }

    public int getSymbolSizeColumns() {
        return this.symbolSizeColumns;
    }

    public int getSymbolSizeRows() {
        return this.symbolSizeRows;
    }

    public int getTotalCodewords() {
        return this.totalCodewords;
    }

    public int getVersionNumber() {
        return this.versionNumber;
    }

    public String toString() {
        return String.valueOf(this.versionNumber);
    }

    public static final class ECB {
        public final int count;
        public final int dataCodewords;

        public ECB(int i2, int i3) {
            this.count = i2;
            this.dataCodewords = i3;
        }

        public int getCount() {
            return this.count;
        }

        public int getDataCodewords() {
            return this.dataCodewords;
        }

        public /* synthetic */ ECB(int i2, int i3, ECB ecb) {
            this(i2, i3);
        }
    }

    public static final class ECBlocks {
        public final ECB[] ecBlocks;
        public final int ecCodewords;

        public ECBlocks(int i2, ECB ecb) {
            this.ecCodewords = i2;
            this.ecBlocks = new ECB[]{ecb};
        }

        public ECB[] getECBlocks() {
            return this.ecBlocks;
        }

        public int getECCodewords() {
            return this.ecCodewords;
        }

        public /* synthetic */ ECBlocks(int i2, ECB ecb, ECBlocks eCBlocks) {
            this(i2, ecb);
        }

        public ECBlocks(int i2, ECB ecb, ECB ecb2) {
            this.ecCodewords = i2;
            this.ecBlocks = new ECB[]{ecb, ecb2};
        }

        public /* synthetic */ ECBlocks(int i2, ECB ecb, ECB ecb2, ECBlocks eCBlocks) {
            this(i2, ecb, ecb2);
        }
    }
}
