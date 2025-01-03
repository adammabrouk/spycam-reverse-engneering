package com.shix.shixipc.utils;

import androidx.recyclerview.widget.RecyclerView;
import com.google.zxing.view.ViewfinderView;

/* loaded from: classes.dex */
public class BitReader {
    public byte[] buffer;
    public int position;

    public BitReader(byte[] bArr) {
        this.buffer = bArr;
    }

    public int readBits(int i2) {
        int i3 = this.buffer[this.position / 8];
        if (i3 < 0) {
            i3 += RecyclerView.c0.FLAG_TMP_DETACHED;
        }
        int i4 = this.position;
        int i5 = 8 - (i4 % 8);
        if (i2 > i5) {
            int i6 = i2 - i5;
            return (readBits(i5) << i6) + readBits(i6);
        }
        int i7 = ((i3 << (i4 % 8)) & ViewfinderView.OPAQUE) >> ((i4 % 8) + (i5 - i2));
        this.position = i4 + i2;
        return i7;
    }
}
