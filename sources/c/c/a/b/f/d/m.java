package c.c.a.b.f.d;

/* compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
/* loaded from: classes.dex */
public final class m {
    public static int a(int i2, int i3) {
        long j = i2 << 1;
        if (j > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j;
    }
}
