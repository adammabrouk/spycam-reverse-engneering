package c.k.d.p9;

import android.text.TextUtils;

/* loaded from: classes.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    public static long f7663a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static String f7664b = "";

    public static String a() {
        if (TextUtils.isEmpty(f7664b)) {
            f7664b = c.k.d.k0.a(4);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(f7664b);
        long j = f7663a;
        f7663a = 1 + j;
        sb.append(j);
        return sb.toString();
    }
}
