package cn.jiguang.bk;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import cn.jiguang.e.f;
import cn.jiguang.internal.JConstants;
import java.util.UUID;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static int f8827a = 1;

    public static String a(Context context) {
        String str = (String) cn.jiguang.f.b.a(context, cn.jiguang.f.a.a());
        if (f.h(str)) {
            f8827a = 3;
            return str;
        }
        String b2 = b(context, str);
        if (f.h(b2)) {
            f8827a = 1;
            d(context, b2);
            cn.jiguang.f.b.a(context, (cn.jiguang.f.a<?>[]) new cn.jiguang.f.a[]{cn.jiguang.f.a.a().a((cn.jiguang.f.a<String>) b2)});
            return b2;
        }
        String b3 = b(context);
        if (f.h(b3)) {
            f8827a = 2;
            c(context, b3);
            cn.jiguang.f.b.a(context, (cn.jiguang.f.a<?>[]) new cn.jiguang.f.a[]{cn.jiguang.f.a.a().a((cn.jiguang.f.a<String>) b3)});
            return b3;
        }
        String e2 = Build.VERSION.SDK_INT < 23 ? cn.jiguang.e.a.e(context, b3) : "";
        String i2 = cn.jiguang.e.a.i(context);
        String g2 = cn.jiguang.e.a.g(context, "");
        String uuid = UUID.randomUUID().toString();
        String d2 = f.d(e2 + i2 + g2 + uuid);
        if (!TextUtils.isEmpty(d2)) {
            uuid = d2;
        }
        cn.jiguang.f.b.a(context, (cn.jiguang.f.a<?>[]) new cn.jiguang.f.a[]{cn.jiguang.f.a.a().a((cn.jiguang.f.a<String>) uuid)});
        f8827a = 0;
        c(context, uuid);
        d(context, uuid);
        return uuid;
    }

    public static void a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        c(context, str);
        d(context, str);
        cn.jiguang.f.b.a(context, (cn.jiguang.f.a<?>[]) new cn.jiguang.f.a[]{cn.jiguang.f.a.a().a((cn.jiguang.f.a<String>) str)});
    }

    public static String b(Context context) {
        JConstants.isAndroidQ(context, true, "do not get deviceId from SD");
        return null;
    }

    public static String b(Context context, String str) {
        return str;
    }

    public static String c(Context context, String str) {
        return null;
    }

    public static String d(Context context, String str) {
        if (JConstants.isAndroidQ(context, true, "not write deviceId to SD")) {
            return str;
        }
        return null;
    }
}
