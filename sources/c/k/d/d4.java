package c.k.d;

/* loaded from: classes.dex */
public final class d4 {
    static {
        a(1, 3);
        a(1, 4);
        a(2, 0);
        a(3, 2);
    }

    public static int a(int i2) {
        return i2 & 7;
    }

    public static int a(int i2, int i3) {
        return (i2 << 3) | i3;
    }

    public static int b(int i2) {
        return i2 >>> 3;
    }
}
