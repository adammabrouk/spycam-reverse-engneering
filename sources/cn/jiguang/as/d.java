package cn.jiguang.as;

import cn.jiguang.internal.JConstants;

/* loaded from: classes.dex */
public class d {
    public static void a(String str, String str2) {
        b.a(JConstants.SDK_TYPE, str, true, 2, str2, null);
    }

    public static void a(String str, String str2, Throwable th) {
        b.a(JConstants.SDK_TYPE, str, false, 3, str2, th);
    }

    public static void b(String str, String str2) {
        b.a(JConstants.SDK_TYPE, str, false, 2, str2, null);
    }

    public static void b(String str, String str2, Throwable th) {
        b.a(JConstants.SDK_TYPE, str, true, 5, str2, th);
    }

    public static void c(String str, String str2) {
        b.a(JConstants.SDK_TYPE, str, true, 3, str2, null);
    }

    public static void c(String str, String str2, Throwable th) {
        b.a(JConstants.SDK_TYPE, str, false, 5, str2, th);
    }

    public static void d(String str, String str2) {
        b.a(JConstants.SDK_TYPE, str, false, 3, str2, null);
    }

    public static void d(String str, String str2, Throwable th) {
        b.a(JConstants.SDK_TYPE, str, true, 6, str2, th);
    }

    public static void e(String str, String str2) {
        b.a(JConstants.SDK_TYPE, str, true, 4, str2, null);
    }

    public static void e(String str, String str2, Throwable th) {
        b.a(JConstants.SDK_TYPE, str, false, 6, str2, th);
    }

    public static void f(String str, String str2) {
        b.a(JConstants.SDK_TYPE, str, false, 4, str2, null);
    }

    public static void f(String str, String str2, Throwable th) {
        e(str, str2, th);
    }

    public static void g(String str, String str2) {
        b.a(JConstants.SDK_TYPE, str, true, 5, str2, null);
    }

    public static void h(String str, String str2) {
        b.a(JConstants.SDK_TYPE, str, false, 5, str2, null);
    }

    public static void i(String str, String str2) {
        b.a(JConstants.SDK_TYPE, str, true, 6, str2, null);
    }

    public static void j(String str, String str2) {
        b.a(JConstants.SDK_TYPE, str, false, 6, str2, null);
    }
}
