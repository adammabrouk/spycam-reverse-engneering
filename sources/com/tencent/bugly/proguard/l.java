package com.tencent.bugly.proguard;

import androidx.recyclerview.widget.RecyclerView;
import java.nio.ByteBuffer;

/* compiled from: BUGLY */
/* loaded from: classes.dex */
public final class l {
    static {
        byte[] bArr = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};
        byte[] bArr2 = new byte[RecyclerView.c0.FLAG_TMP_DETACHED];
        byte[] bArr3 = new byte[RecyclerView.c0.FLAG_TMP_DETACHED];
        for (int i2 = 0; i2 < 256; i2++) {
            bArr2[i2] = bArr[i2 >>> 4];
            bArr3[i2] = bArr[i2 & 15];
        }
    }

    public static boolean a(int i2, int i3) {
        return i2 == i3;
    }

    public static boolean a(long j, long j2) {
        return j == j2;
    }

    public static boolean a(Object obj, Object obj2) {
        return obj.equals(obj2);
    }

    public static boolean a(boolean z, boolean z2) {
        return z == z2;
    }

    public static byte[] a(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        byte[] bArr = new byte[position];
        System.arraycopy(byteBuffer.array(), 0, bArr, 0, position);
        return bArr;
    }
}
