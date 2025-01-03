package com.google.zxing.qrcode.decoder;

import com.google.zxing.common.BitMatrix;

/* loaded from: classes.dex */
public enum DataMask {
    DATA_MASK_000 { // from class: com.google.zxing.qrcode.decoder.DataMask.1
        @Override // com.google.zxing.qrcode.decoder.DataMask
        public boolean isMasked(int i2, int i3) {
            return ((i2 + i3) & 1) == 0;
        }
    },
    DATA_MASK_001 { // from class: com.google.zxing.qrcode.decoder.DataMask.2
        @Override // com.google.zxing.qrcode.decoder.DataMask
        public boolean isMasked(int i2, int i3) {
            return (i2 & 1) == 0;
        }
    },
    DATA_MASK_010 { // from class: com.google.zxing.qrcode.decoder.DataMask.3
        @Override // com.google.zxing.qrcode.decoder.DataMask
        public boolean isMasked(int i2, int i3) {
            return i3 % 3 == 0;
        }
    },
    DATA_MASK_011 { // from class: com.google.zxing.qrcode.decoder.DataMask.4
        @Override // com.google.zxing.qrcode.decoder.DataMask
        public boolean isMasked(int i2, int i3) {
            return (i2 + i3) % 3 == 0;
        }
    },
    DATA_MASK_100 { // from class: com.google.zxing.qrcode.decoder.DataMask.5
        @Override // com.google.zxing.qrcode.decoder.DataMask
        public boolean isMasked(int i2, int i3) {
            return (((i2 / 2) + (i3 / 3)) & 1) == 0;
        }
    },
    DATA_MASK_101 { // from class: com.google.zxing.qrcode.decoder.DataMask.6
        @Override // com.google.zxing.qrcode.decoder.DataMask
        public boolean isMasked(int i2, int i3) {
            return (i2 * i3) % 6 == 0;
        }
    },
    DATA_MASK_110 { // from class: com.google.zxing.qrcode.decoder.DataMask.7
        @Override // com.google.zxing.qrcode.decoder.DataMask
        public boolean isMasked(int i2, int i3) {
            return (i2 * i3) % 6 < 3;
        }
    },
    DATA_MASK_111 { // from class: com.google.zxing.qrcode.decoder.DataMask.8
        @Override // com.google.zxing.qrcode.decoder.DataMask
        public boolean isMasked(int i2, int i3) {
            return (((i2 + i3) + ((i2 * i3) % 3)) & 1) == 0;
        }
    };

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static DataMask[] valuesCustom() {
        DataMask[] valuesCustom = values();
        int length = valuesCustom.length;
        DataMask[] dataMaskArr = new DataMask[length];
        System.arraycopy(valuesCustom, 0, dataMaskArr, 0, length);
        return dataMaskArr;
    }

    public abstract boolean isMasked(int i2, int i3);

    public final void unmaskBitMatrix(BitMatrix bitMatrix, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i2; i4++) {
                if (isMasked(i3, i4)) {
                    bitMatrix.flip(i4, i3);
                }
            }
        }
    }

    /* synthetic */ DataMask(DataMask dataMask) {
        this();
    }
}
