package c.c.a.b.f.e;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public abstract class w3 {
    public w3() {
    }

    public static int a(int i2) {
        return (-(i2 & 1)) ^ (i2 >>> 1);
    }

    public static long a(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static w3 a(byte[] bArr, int i2, int i3, boolean z) {
        y3 y3Var = new y3(bArr, 0, i3, false);
        try {
            y3Var.b(i3);
            return y3Var;
        } catch (c5 e2) {
            throw new IllegalArgumentException(e2);
        }
    }
}
