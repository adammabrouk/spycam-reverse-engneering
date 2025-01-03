package com.google.zxing.qrcode.decoder;

import com.google.zxing.qrcode.decoder.Version;

/* loaded from: classes.dex */
public final class DataBlock {
    public final byte[] codewords;
    public final int numDataCodewords;

    public DataBlock(int i2, byte[] bArr) {
        this.numDataCodewords = i2;
        this.codewords = bArr;
    }

    public static DataBlock[] getDataBlocks(byte[] bArr, Version version, ErrorCorrectionLevel errorCorrectionLevel) {
        if (bArr.length != version.getTotalCodewords()) {
            throw new IllegalArgumentException();
        }
        Version.ECBlocks eCBlocksForLevel = version.getECBlocksForLevel(errorCorrectionLevel);
        Version.ECB[] eCBlocks = eCBlocksForLevel.getECBlocks();
        int i2 = 0;
        for (Version.ECB ecb : eCBlocks) {
            i2 += ecb.getCount();
        }
        DataBlock[] dataBlockArr = new DataBlock[i2];
        int i3 = 0;
        for (Version.ECB ecb2 : eCBlocks) {
            int i4 = 0;
            while (i4 < ecb2.getCount()) {
                int dataCodewords = ecb2.getDataCodewords();
                dataBlockArr[i3] = new DataBlock(dataCodewords, new byte[eCBlocksForLevel.getECCodewordsPerBlock() + dataCodewords]);
                i4++;
                i3++;
            }
        }
        int length = dataBlockArr[0].codewords.length;
        int i5 = i2 - 1;
        while (i5 >= 0 && dataBlockArr[i5].codewords.length != length) {
            i5--;
        }
        int i6 = i5 + 1;
        int eCCodewordsPerBlock = length - eCBlocksForLevel.getECCodewordsPerBlock();
        int i7 = 0;
        for (int i8 = 0; i8 < eCCodewordsPerBlock; i8++) {
            int i9 = 0;
            while (i9 < i3) {
                dataBlockArr[i9].codewords[i8] = bArr[i7];
                i9++;
                i7++;
            }
        }
        int i10 = i6;
        while (i10 < i3) {
            dataBlockArr[i10].codewords[eCCodewordsPerBlock] = bArr[i7];
            i10++;
            i7++;
        }
        int length2 = dataBlockArr[0].codewords.length;
        for (int i11 = eCCodewordsPerBlock; i11 < length2; i11++) {
            int i12 = 0;
            while (i12 < i3) {
                dataBlockArr[i12].codewords[i12 < i6 ? i11 : i11 + 1] = bArr[i7];
                i12++;
                i7++;
            }
        }
        return dataBlockArr;
    }

    public byte[] getCodewords() {
        return this.codewords;
    }

    public int getNumDataCodewords() {
        return this.numDataCodewords;
    }
}
