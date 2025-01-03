package i;

import com.google.zxing.view.ViewfinderView;
import java.nio.charset.Charset;

/* compiled from: Util.java */
/* loaded from: classes.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f11858a = Charset.forName("UTF-8");

    public static int a(int i2) {
        return ((i2 & ViewfinderView.OPAQUE) << 24) | (((-16777216) & i2) >>> 24) | ((16711680 & i2) >>> 8) | ((65280 & i2) << 8);
    }

    public static short a(short s) {
        int i2 = s & 65535;
        return (short) (((i2 & ViewfinderView.OPAQUE) << 8) | ((65280 & i2) >>> 8));
    }

    public static void a(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException(String.format("size=%s offset=%s byteCount=%s", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)));
        }
    }

    public static <T extends Throwable> void b(Throwable th) throws Throwable {
        throw th;
    }

    public static void a(Throwable th) {
        b(th);
        throw null;
    }

    public static boolean a(byte[] bArr, int i2, byte[] bArr2, int i3, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            if (bArr[i5 + i2] != bArr2[i5 + i3]) {
                return false;
            }
        }
        return true;
    }
}
