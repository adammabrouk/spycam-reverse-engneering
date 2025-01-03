package com.google.zxing.common;

import com.google.zxing.view.ViewfinderView;
import com.shix.shixipc.utilcode.ThreadUtils;

/* loaded from: classes.dex */
public final class BitSource {
    public int bitOffset;
    public int byteOffset;
    public final byte[] bytes;

    public BitSource(byte[] bArr) {
        this.bytes = bArr;
    }

    public int available() {
        return ((this.bytes.length - this.byteOffset) * 8) - this.bitOffset;
    }

    public int getBitOffset() {
        return this.bitOffset;
    }

    public int getByteOffset() {
        return this.byteOffset;
    }

    public int readBits(int i2) {
        if (i2 < 1 || i2 > 32 || i2 > available()) {
            throw new IllegalArgumentException(String.valueOf(i2));
        }
        int i3 = this.bitOffset;
        int i4 = 0;
        if (i3 > 0) {
            int i5 = 8 - i3;
            int i6 = i2 < i5 ? i2 : i5;
            int i7 = i5 - i6;
            int i8 = (ViewfinderView.OPAQUE >> (8 - i6)) << i7;
            byte[] bArr = this.bytes;
            int i9 = this.byteOffset;
            int i10 = (i8 & bArr[i9]) >> i7;
            i2 -= i6;
            int i11 = this.bitOffset + i6;
            this.bitOffset = i11;
            if (i11 == 8) {
                this.bitOffset = 0;
                this.byteOffset = i9 + 1;
            }
            i4 = i10;
        }
        if (i2 <= 0) {
            return i4;
        }
        while (i2 >= 8) {
            int i12 = i4 << 8;
            byte[] bArr2 = this.bytes;
            int i13 = this.byteOffset;
            i4 = (bArr2[i13] & ThreadUtils.TYPE_SINGLE) | i12;
            this.byteOffset = i13 + 1;
            i2 -= 8;
        }
        if (i2 <= 0) {
            return i4;
        }
        int i14 = 8 - i2;
        int i15 = (i4 << i2) | ((((ViewfinderView.OPAQUE >> i14) << i14) & this.bytes[this.byteOffset]) >> i14);
        this.bitOffset += i2;
        return i15;
    }
}
