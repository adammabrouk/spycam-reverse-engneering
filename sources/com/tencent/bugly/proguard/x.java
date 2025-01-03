package com.tencent.bugly.proguard;

import android.util.Log;
import com.shix.shixipc.utilcode.LogUtils;
import java.util.Locale;

/* compiled from: BUGLY */
/* loaded from: classes.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public static String f11209a = "CrashReport";

    /* renamed from: b, reason: collision with root package name */
    public static boolean f11210b = false;

    /* renamed from: c, reason: collision with root package name */
    public static String f11211c = "CrashReportInfo";

    public static boolean a(int i2, String str, Object... objArr) {
        if (!f11210b) {
            return false;
        }
        if (str == null) {
            str = LogUtils.NULL;
        } else if (objArr != null && objArr.length != 0) {
            str = String.format(Locale.US, str, objArr);
        }
        if (i2 == 0) {
            Log.i(f11209a, str);
            return true;
        }
        if (i2 == 1) {
            Log.d(f11209a, str);
            return true;
        }
        if (i2 == 2) {
            Log.w(f11209a, str);
            return true;
        }
        if (i2 == 3) {
            Log.e(f11209a, str);
            return true;
        }
        if (i2 != 5) {
            return false;
        }
        Log.i(f11211c, str);
        return true;
    }

    public static boolean b(String str, Object... objArr) {
        return a(5, str, objArr);
    }

    public static boolean c(String str, Object... objArr) {
        return a(1, str, objArr);
    }

    public static boolean d(String str, Object... objArr) {
        return a(2, str, objArr);
    }

    public static boolean e(String str, Object... objArr) {
        return a(3, str, objArr);
    }

    public static boolean b(Class cls, String str, Object... objArr) {
        return a(1, String.format(Locale.US, "[%s] %s", cls.getSimpleName(), str), objArr);
    }

    public static boolean b(Throwable th) {
        if (f11210b) {
            return a(3, z.a(th), new Object[0]);
        }
        return false;
    }

    public static boolean a(String str, Object... objArr) {
        return a(0, str, objArr);
    }

    public static boolean a(Class cls, String str, Object... objArr) {
        return a(0, String.format(Locale.US, "[%s] %s", cls.getSimpleName(), str), objArr);
    }

    public static boolean a(Throwable th) {
        if (f11210b) {
            return a(2, z.a(th), new Object[0]);
        }
        return false;
    }
}
