package c.c.a.b.f.e;

import com.google.zxing.qrcode.encoder.Encoder;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public final class u4 {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f4458a = Charset.forName("UTF-8");

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f4459b;

    static {
        Charset.forName(Encoder.DEFAULT_BYTE_MODE_ENCODING);
        byte[] bArr = new byte[0];
        f4459b = bArr;
        ByteBuffer.wrap(bArr);
        byte[] bArr2 = f4459b;
        w3.a(bArr2, 0, bArr2.length, false);
    }

    public static int a(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static int a(boolean z) {
        return z ? 1231 : 1237;
    }

    public static <T> T a(T t) {
        if (t != null) {
            return t;
        }
        throw null;
    }

    public static String b(byte[] bArr) {
        return new String(bArr, f4458a);
    }

    public static int c(byte[] bArr) {
        int length = bArr.length;
        int a2 = a(length, bArr, 0, length);
        if (a2 == 0) {
            return 1;
        }
        return a2;
    }

    public static <T> T a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static boolean a(byte[] bArr) {
        return t7.a(bArr);
    }

    public static int a(int i2, byte[] bArr, int i3, int i4) {
        for (int i5 = i3; i5 < i3 + i4; i5++) {
            i2 = (i2 * 31) + bArr[i5];
        }
        return i2;
    }

    public static boolean a(d6 d6Var) {
        if (!(d6Var instanceof c3)) {
            return false;
        }
        return false;
    }

    public static Object a(Object obj, Object obj2) {
        return ((d6) obj).f().a((d6) obj2).H();
    }
}
