package c.c.a.b.c.s;

import com.shix.shixipc.utilcode.ThreadUtils;

/* loaded from: classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f4013a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: b, reason: collision with root package name */
    public static final char[] f4014b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String a(byte[] bArr, boolean z) {
        int length = bArr.length;
        StringBuilder sb = new StringBuilder(length << 1);
        for (int i2 = 0; i2 < length && (!z || i2 != length - 1 || (bArr[i2] & ThreadUtils.TYPE_SINGLE) != 0); i2++) {
            sb.append(f4013a[(bArr[i2] & 240) >>> 4]);
            sb.append(f4013a[bArr[i2] & 15]);
        }
        return sb.toString();
    }

    public static String a(byte[] bArr) {
        char[] cArr = new char[bArr.length << 1];
        int i2 = 0;
        for (byte b2 : bArr) {
            int i3 = b2 & ThreadUtils.TYPE_SINGLE;
            int i4 = i2 + 1;
            char[] cArr2 = f4014b;
            cArr[i2] = cArr2[i3 >>> 4];
            i2 = i4 + 1;
            cArr[i4] = cArr2[i3 & 15];
        }
        return new String(cArr);
    }
}
