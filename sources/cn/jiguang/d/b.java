package cn.jiguang.d;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.as.d;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static volatile Long f8847a;

    /* renamed from: b, reason: collision with root package name */
    public static volatile Long f8848b;

    public static long a(Context context, long j) {
        return (j + c(context)) / 1000;
    }

    public static boolean a(Context context) {
        String str;
        if (((Long) cn.jiguang.f.b.a(context, cn.jiguang.f.a.c())).longValue() <= 0) {
            str = "isValidRegistered uid <= 0";
        } else {
            if (!TextUtils.isEmpty((String) cn.jiguang.f.b.a(context, cn.jiguang.f.a.d()))) {
                return true;
            }
            str = "isValidRegistered regId is empty";
        }
        d.a("SpHelper", str);
        return false;
    }

    public static long b(Context context) {
        return a(context, System.currentTimeMillis());
    }

    public static void b(Context context, long j) {
        if (j > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            f8847a = Long.valueOf(j);
            f8848b = Long.valueOf(currentTimeMillis);
            cn.jiguang.f.b.a(context, (cn.jiguang.f.a<?>[]) new cn.jiguang.f.a[]{cn.jiguang.f.a.j().a((cn.jiguang.f.a<Long>) Long.valueOf(j)), cn.jiguang.f.a.i().a((cn.jiguang.f.a<Long>) Long.valueOf(currentTimeMillis))});
        }
    }

    public static long c(Context context) {
        if (f8847a != null && f8848b != null) {
            return f8847a.longValue() - f8848b.longValue();
        }
        long longValue = ((Long) cn.jiguang.f.b.a(context, cn.jiguang.f.a.i())).longValue();
        long longValue2 = ((Long) cn.jiguang.f.b.a(context, cn.jiguang.f.a.j())).longValue();
        if (longValue == 0 || longValue2 == 0) {
            return 0L;
        }
        f8847a = Long.valueOf(longValue2);
        f8848b = Long.valueOf(longValue);
        return longValue2 - longValue;
    }
}
