package c.j.a.z;

import android.content.Context;

/* compiled from: LogUtil.java */
/* loaded from: classes.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    public static final u f6737a = new t();

    /* renamed from: b, reason: collision with root package name */
    public static boolean f6738b;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f6739c;

    static {
        b();
    }

    public static boolean a() {
        return f6738b && f6739c;
    }

    public static void b() {
        f6738b = f0.b("persist.sys.log.ctrl", "no").equals("yes");
    }

    public static int c(String str, String str2) {
        return f6737a.c(str, str2);
    }

    public static int d(String str, String str2) {
        return f6737a.d(str, str2);
    }

    public static int e(String str, String str2) {
        return f6737a.e(str, str2);
    }

    public static int b(String str, String str2) {
        return f6737a.a(str, str2);
    }

    public static void c(Context context, String str) {
        f6737a.c(context, str);
    }

    public static void a(boolean z) {
        b();
        f6739c = z;
    }

    public static int b(String str, String str2, Throwable th) {
        return f6737a.a(str, str2, th);
    }

    public static void b(Context context, String str) {
        f6737a.b(context, str);
    }

    public static int a(String str, String str2) {
        return f6737a.b(str, str2);
    }

    public static int a(String str, Throwable th) {
        return f6737a.a(str, th);
    }

    public static int a(String str, String str2, Throwable th) {
        return f6737a.b(str, str2, th);
    }

    public static String a(Throwable th) {
        return f6737a.a(th);
    }

    public static void a(Context context, String str) {
        f6737a.a(context, str);
    }
}
