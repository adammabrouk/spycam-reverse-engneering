package cn.jiguang.bk;

import com.google.zxing.view.ViewfinderView;
import com.shix.shixipc.utilcode.ThreadUtils;
import java.util.Arrays;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f8828a = {-42, -112, -23, -2, -52, -31, 61, -73, 22, -74, 20, -62, 40, -5, 44, 5, 43, 103, -102, 118, 42, -66, 4, -61, -86, 68, 19, 38, 73, -122, 6, -103, -100, 66, 80, -12, -111, -17, -104, 122, 51, 84, 11, 67, -19, -49, -84, 98, -28, -77, 28, -87, -55, 8, -24, -107, Byte.MIN_VALUE, -33, -108, -6, 117, -113, 63, -90, 71, 7, -89, -4, -13, 115, 23, -70, -125, 89, 60, 25, -26, -123, 79, -88, 104, 107, -127, -78, 113, 100, -38, -117, -8, -21, 15, 75, 112, 86, -99, 53, 30, 36, 14, 94, 99, 88, -47, -94, 37, 34, 124, 59, 1, 33, 120, -121, -44, 0, 70, 87, -97, -45, 39, 82, 76, 54, 2, -25, -96, -60, -56, -98, -22, -65, -118, -46, 64, -57, 56, -75, -93, -9, -14, -50, -7, 97, 21, -95, -32, -82, 93, -92, -101, 52, 26, 85, -83, -109, 50, 48, -11, -116, -79, -29, 29, -10, -30, 46, -126, 102, -54, 96, -64, 41, 35, -85, 13, 83, 78, 111, -43, -37, 55, 69, -34, -3, -114, 47, 3, -1, 106, 114, 109, 108, 91, 81, -115, 27, -81, -110, -69, -35, -68, Byte.MAX_VALUE, 17, -39, 92, 65, 31, 16, 90, -40, 10, -63, 49, -120, -91, -51, 123, -67, 45, 116, -48, 18, -72, -27, -76, -80, -119, 105, -105, 74, 12, -106, 119, 126, 101, -71, -15, 9, -59, 110, -58, -124, 24, -16, 125, -20, 58, -36, 77, 32, 121, -18, 95, 62, -41, -53, 57, 72};

    /* renamed from: b, reason: collision with root package name */
    public int[] f8829b = {462357, 472066609, 943670861, 1415275113, 1886879365, -1936483679, -1464879427, -993275175, -521670923, -66909679, 404694573, 876298825, 1347903077, 1819507329, -2003855715, -1532251463, -1060647211, -589042959, -117504499, 337322537, 808926789, 1280531041, 1752135293, -2071227751, -1599623499, -1128019247, -656414995, -184876535, 269950501, 741554753, 1213159005, 1684763257};

    public static int a(char c2) {
        return (byte) "0123456789abcdef".indexOf(c2);
    }

    private int a(int i2) {
        byte[] bArr = this.f8828a;
        return (bArr[i2 & ViewfinderView.OPAQUE] & ThreadUtils.TYPE_SINGLE) | ((bArr[(i2 >>> 24) & ViewfinderView.OPAQUE] & ThreadUtils.TYPE_SINGLE) << 24) | ((bArr[(i2 >>> 16) & ViewfinderView.OPAQUE] & ThreadUtils.TYPE_SINGLE) << 16) | ((bArr[(i2 >>> 8) & ViewfinderView.OPAQUE] & ThreadUtils.TYPE_SINGLE) << 8);
    }

    private int a(int i2, int i3) {
        return (i2 >>> (32 - i3)) | (i2 << i3);
    }

    public static void a(byte[] bArr, byte[] bArr2) {
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr[i2] = (byte) (bArr[i2] ^ bArr2[i2]);
        }
    }

    public static byte[] a(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        char[] charArray = str.toLowerCase().toCharArray();
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            bArr[i2] = (byte) (a(charArray[i3 + 1]) | (a(charArray[i3]) << 4));
        }
        return bArr;
    }

    private int[] a(byte[] bArr) {
        int[] iArr = new int[4];
        for (int i2 = 0; i2 < 4; i2++) {
            int i3 = i2 * 4;
            iArr[i2] = (bArr[i3 + 3] & ThreadUtils.TYPE_SINGLE) | ((bArr[i3] & ThreadUtils.TYPE_SINGLE) << 24) | ((bArr[i3 + 1] & ThreadUtils.TYPE_SINGLE) << 16) | ((bArr[i3 + 2] & ThreadUtils.TYPE_SINGLE) << 8);
        }
        return iArr;
    }

    private int b(int i2) {
        return a(i2, 24) ^ (((a(i2, 2) ^ i2) ^ a(i2, 10)) ^ a(i2, 18));
    }

    public static byte[] b(byte[] bArr) {
        int length = 16 - (bArr.length % 16);
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length + length);
        for (int i2 = 0; i2 < length; i2++) {
            copyOf[bArr.length + i2] = (byte) length;
        }
        return copyOf;
    }

    private int c(int i2) {
        return a(i2, 23) ^ (a(i2, 13) ^ i2);
    }

    public static byte[] c(byte[] bArr) {
        int length = bArr.length - bArr[bArr.length - 1];
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    public void a(byte[] bArr, byte[] bArr2, int[] iArr) {
        int[] a2 = a(bArr);
        for (int i2 = 0; i2 < 32; i2 += 4) {
            a2[0] = a2[0] ^ b(a(((a2[1] ^ a2[2]) ^ a2[3]) ^ iArr[i2]));
            a2[1] = a2[1] ^ b(a(((a2[2] ^ a2[3]) ^ a2[0]) ^ iArr[i2 + 1]));
            a2[2] = a2[2] ^ b(a(((a2[3] ^ a2[0]) ^ a2[1]) ^ iArr[i2 + 2]));
            a2[3] = a2[3] ^ b(a(((a2[1] ^ a2[0]) ^ a2[2]) ^ iArr[i2 + 3]));
        }
        for (int i3 = 0; i3 < 16; i3 += 4) {
            int i4 = 3 - (i3 / 4);
            bArr2[i3] = (byte) ((a2[i4] >>> 24) & ViewfinderView.OPAQUE);
            bArr2[i3 + 1] = (byte) ((a2[i4] >>> 16) & ViewfinderView.OPAQUE);
            bArr2[i3 + 2] = (byte) ((a2[i4] >>> 8) & ViewfinderView.OPAQUE);
            bArr2[i3 + 3] = (byte) (a2[i4] & ViewfinderView.OPAQUE);
        }
    }

    public byte[] a(byte[] bArr, String str) {
        byte[] a2 = a(str);
        String substring = str.substring(0, 16);
        cn.jiguang.as.d.c("SM4", "seed=" + str);
        return a(bArr, a2, substring.getBytes("utf-8"));
    }

    public byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        if (bArr2 == null || bArr2.length != 16) {
            throw new IllegalArgumentException("key's length should be 16");
        }
        if (bArr3 != null && bArr3.length != 16) {
            bArr3 = null;
        }
        byte[] b2 = b(bArr);
        int[] a2 = a(bArr2, false);
        byte[] bArr4 = new byte[16];
        byte[] bArr5 = new byte[b2.length];
        int i2 = 0;
        while (true) {
            int i3 = i2 + 16;
            if (i3 > b2.length) {
                return bArr5;
            }
            System.arraycopy(b2, i2, bArr4, 0, 16);
            if (bArr3 != null) {
                a(bArr4, bArr3);
            } else {
                bArr3 = new byte[16];
            }
            a(bArr4, bArr3, a2);
            System.arraycopy(bArr3, 0, bArr5, i2, bArr3.length);
            i2 = i3;
        }
    }

    public int[] a(byte[] bArr, boolean z) {
        int[] a2 = a(bArr);
        a2[0] = a2[0] ^ (-1548633402);
        a2[1] = a2[1] ^ 1453994832;
        a2[2] = a2[2] ^ 1736282519;
        a2[3] = a2[3] ^ (-1301273892);
        int[] iArr = new int[32];
        for (int i2 = 0; i2 < 32; i2 += 4) {
            int c2 = a2[0] ^ c(a(((a2[1] ^ a2[2]) ^ a2[3]) ^ this.f8829b[i2]));
            a2[0] = c2;
            iArr[i2] = c2;
            int i3 = i2 + 1;
            int c3 = a2[1] ^ c(a(((a2[2] ^ a2[3]) ^ a2[0]) ^ this.f8829b[i3]));
            a2[1] = c3;
            iArr[i3] = c3;
            int i4 = i2 + 2;
            int c4 = a2[2] ^ c(a(((a2[3] ^ a2[0]) ^ a2[1]) ^ this.f8829b[i4]));
            a2[2] = c4;
            iArr[i4] = c4;
            int i5 = i2 + 3;
            int c5 = a2[3] ^ c(a(((a2[0] ^ a2[1]) ^ a2[2]) ^ this.f8829b[i5]));
            a2[3] = c5;
            iArr[i5] = c5;
        }
        if (z) {
            for (int i6 = 0; i6 < 16; i6++) {
                int i7 = iArr[i6];
                int i8 = 31 - i6;
                iArr[i6] = iArr[i8];
                iArr[i8] = i7;
            }
        }
        return iArr;
    }

    public byte[] b(byte[] bArr, String str) {
        return b(bArr, a(str), str.substring(0, 16).getBytes("utf-8"));
    }

    public byte[] b(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        if (bArr2 == null || bArr2.length != 16) {
            throw new IllegalArgumentException("key's length should be 16");
        }
        if (bArr3 != null && bArr3.length != 16) {
            bArr3 = null;
        }
        int[] a2 = a(bArr2, true);
        byte[] bArr4 = new byte[16];
        byte[] bArr5 = new byte[16];
        byte[] bArr6 = new byte[bArr.length];
        int i2 = 0;
        while (true) {
            int i3 = i2 + 16;
            if (i3 > bArr.length) {
                return c(bArr6);
            }
            System.arraycopy(bArr, i2, bArr4, 0, 16);
            a(bArr4, bArr5, a2);
            if (bArr3 != null) {
                a(bArr5, bArr3);
            } else {
                bArr3 = new byte[16];
            }
            System.arraycopy(bArr, i2, bArr3, 0, 16);
            System.arraycopy(bArr5, 0, bArr6, i2, 16);
            i2 = i3;
        }
    }
}
