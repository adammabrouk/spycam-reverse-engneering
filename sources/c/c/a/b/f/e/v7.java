package c.c.a.b.f.e;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public final class v7 {
    public static void b(byte b2, char[] cArr, int i2) {
        cArr[i2] = (char) b2;
    }

    public static boolean d(byte b2) {
        return b2 >= 0;
    }

    public static boolean e(byte b2) {
        return b2 < -32;
    }

    public static boolean f(byte b2) {
        return b2 < -16;
    }

    public static boolean g(byte b2) {
        return b2 > -65;
    }

    public static void b(byte b2, byte b3, char[] cArr, int i2) throws c5 {
        if (b2 < -62 || g(b3)) {
            throw c5.zzh();
        }
        cArr[i2] = (char) (((b2 & 31) << 6) | (b3 & 63));
    }

    public static void b(byte b2, byte b3, byte b4, char[] cArr, int i2) throws c5 {
        if (!g(b3) && ((b2 != -32 || b3 >= -96) && ((b2 != -19 || b3 < -96) && !g(b4)))) {
            cArr[i2] = (char) (((b2 & 15) << 12) | ((b3 & 63) << 6) | (b4 & 63));
            return;
        }
        throw c5.zzh();
    }

    public static void b(byte b2, byte b3, byte b4, byte b5, char[] cArr, int i2) throws c5 {
        if (!g(b3) && (((b2 << 28) + (b3 + 112)) >> 30) == 0 && !g(b4) && !g(b5)) {
            int i3 = ((b2 & 7) << 18) | ((b3 & 63) << 12) | ((b4 & 63) << 6) | (b5 & 63);
            cArr[i2] = (char) ((i3 >>> 10) + 55232);
            cArr[i2 + 1] = (char) ((i3 & 1023) + 56320);
            return;
        }
        throw c5.zzh();
    }
}
