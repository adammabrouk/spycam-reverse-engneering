package cn.jpush.android.m;

import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.o.b;

/* loaded from: classes.dex */
public class a {
    public static int a() {
        try {
            return b.f9824a;
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("JUnionAdPushHelper", "getUserActiveType failed, error: " + th.getMessage());
            return 0;
        }
    }

    public static String b() {
        return JPushConstants.SDK_TYPE;
    }

    public static String c() {
        try {
            return cn.jpush.android.bc.b.f9502b;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String d() {
        try {
            return JPushConstants.SDK_VERSION_NAME;
        } catch (Throwable unused) {
            return "";
        }
    }
}
