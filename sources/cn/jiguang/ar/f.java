package cn.jiguang.ar;

import cn.jiguang.api.JCoreManager;

/* loaded from: classes.dex */
public class f {
    public static void a(int i2, boolean z, String str, String str2, Throwable th) {
        JCoreManager.onEvent(null, "JOperate", 18, str, null, Integer.valueOf(i2), Boolean.valueOf(z), str2, th);
    }

    public static void a(String str, String str2) {
        a(3, true, str, str2, null);
    }

    public static void a(String str, String str2, Throwable th) {
        a(6, true, str, str2, th);
    }

    public static void b(String str, String str2) {
        a(3, false, str, str2, null);
    }

    public static void b(String str, String str2, Throwable th) {
        a(6, false, str, str2, th);
    }

    public static void c(String str, String str2) {
        a(5, true, str, str2, null);
    }

    public static void d(String str, String str2) {
        a(5, false, str, str2, null);
    }

    public static void e(String str, String str2) {
        a(6, true, str, str2, null);
    }

    public static void f(String str, String str2) {
        a(6, false, str, str2, null);
    }
}
