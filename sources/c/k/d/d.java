package c.k.d;

import com.shix.shixipc.utilcode.ThreadUtils;

/* loaded from: classes.dex */
public class d {
    public static int a(byte[] bArr) {
        if (bArr.length != 4) {
            throw new IllegalArgumentException("the length of bytes must be 4");
        }
        return (bArr[3] & ThreadUtils.TYPE_SINGLE) | 0 | ((bArr[0] & ThreadUtils.TYPE_SINGLE) << 24) | ((bArr[1] & ThreadUtils.TYPE_SINGLE) << 16) | ((bArr[2] & ThreadUtils.TYPE_SINGLE) << 8);
    }

    public static byte[] a(int i2) {
        return new byte[]{(byte) (i2 >> 24), (byte) (i2 >> 16), (byte) (i2 >> 8), (byte) i2};
    }
}
