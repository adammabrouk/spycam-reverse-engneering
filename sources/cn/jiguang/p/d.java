package cn.jiguang.p;

import android.text.TextUtils;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static long f9030a = 1;

    public static long a() {
        long j = f9030a + 1;
        f9030a = j;
        if (j >= 2147483647L) {
            f9030a = 1L;
        }
        return f9030a;
    }

    public static byte[] a(long j, String str) {
        cn.jiguang.q.a aVar = new cn.jiguang.q.a(20480);
        aVar.a(0);
        aVar.a(j);
        if (str != null && !TextUtils.isEmpty(str)) {
            aVar.a(cn.jiguang.l.d.e(str));
        }
        return aVar.a();
    }
}
