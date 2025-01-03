package cn.jpush.android.bm;

/* loaded from: classes.dex */
public class d {
    public static byte[] a(byte[] bArr) {
        try {
            byte[] bArr2 = {32, 25, 8, 22, 17, 48};
            byte[] bArr3 = new byte[bArr.length];
            for (int i2 = 0; i2 < bArr.length; i2++) {
                bArr3[i2] = (byte) (bArr[i2] ^ bArr2[(bArr.length + i2) % 6]);
            }
            return bArr3;
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    public static String b(byte[] bArr) {
        return new String(a(bArr));
    }
}
