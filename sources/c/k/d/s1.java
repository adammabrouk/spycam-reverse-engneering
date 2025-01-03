package c.k.d;

import java.net.InetSocketAddress;

/* loaded from: classes.dex */
public final class s1 {

    /* renamed from: a, reason: collision with root package name */
    public String f7834a;

    /* renamed from: b, reason: collision with root package name */
    public int f7835b;

    public s1(String str, int i2) {
        this.f7834a = str;
        this.f7835b = i2;
    }

    public static s1 a(String str, int i2) {
        int lastIndexOf = str.lastIndexOf(":");
        if (lastIndexOf != -1) {
            String substring = str.substring(0, lastIndexOf);
            try {
                int parseInt = Integer.parseInt(str.substring(lastIndexOf + 1));
                if (parseInt > 0) {
                    i2 = parseInt;
                }
            } catch (NumberFormatException unused) {
            }
            str = substring;
        }
        return new s1(str, i2);
    }

    /* renamed from: a, reason: collision with other method in class */
    public static InetSocketAddress m457a(String str, int i2) {
        s1 a2 = a(str, i2);
        return new InetSocketAddress(a2.m458a(), a2.a());
    }

    public int a() {
        return this.f7835b;
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m458a() {
        return this.f7834a;
    }

    public String toString() {
        if (this.f7835b <= 0) {
            return this.f7834a;
        }
        return this.f7834a + ":" + this.f7835b;
    }
}
