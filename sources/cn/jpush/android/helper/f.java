package cn.jpush.android.helper;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public static long f9757a = 1;

    public static long a() {
        long j = f9757a + 1;
        f9757a = j;
        if (j >= 2147483647L) {
            f9757a = 1L;
        }
        return f9757a;
    }
}
