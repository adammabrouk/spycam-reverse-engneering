package com.google.zxing.qrcode.encoder;

import java.lang.reflect.Array;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class ByteMatrix {
    public final byte[][] bytes;
    public final int height;
    public final int width;

    public ByteMatrix(int i2, int i3) {
        this.bytes = (byte[][]) Array.newInstance((Class<?>) byte.class, i3, i2);
        this.width = i2;
        this.height = i3;
    }

    public void clear(byte b2) {
        for (byte[] bArr : this.bytes) {
            Arrays.fill(bArr, b2);
        }
    }

    public byte get(int i2, int i3) {
        return this.bytes[i3][i2];
    }

    public byte[][] getArray() {
        return this.bytes;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public void set(int i2, int i3, byte b2) {
        this.bytes[i3][i2] = b2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((this.width * 2 * this.height) + 2);
        for (int i2 = 0; i2 < this.height; i2++) {
            byte[] bArr = this.bytes[i2];
            for (int i3 = 0; i3 < this.width; i3++) {
                byte b2 = bArr[i3];
                if (b2 == 0) {
                    sb.append(" 0");
                } else if (b2 != 1) {
                    sb.append("  ");
                } else {
                    sb.append(" 1");
                }
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public void set(int i2, int i3, int i4) {
        this.bytes[i3][i2] = (byte) i4;
    }

    public void set(int i2, int i3, boolean z) {
        this.bytes[i3][i2] = z ? (byte) 1 : (byte) 0;
    }
}
