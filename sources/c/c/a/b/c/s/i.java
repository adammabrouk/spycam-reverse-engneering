package c.c.a.b.c.s;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static Boolean f4010a;

    /* renamed from: b, reason: collision with root package name */
    public static Boolean f4011b;

    /* renamed from: c, reason: collision with root package name */
    public static Boolean f4012c;

    @TargetApi(21)
    public static boolean a(Context context) {
        if (f4011b == null) {
            f4011b = Boolean.valueOf(n.g() && context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return f4011b.booleanValue();
    }

    @TargetApi(20)
    public static boolean b(Context context) {
        if (f4010a == null) {
            f4010a = Boolean.valueOf(n.f() && context.getPackageManager().hasSystemFeature("android.hardware.type.watch"));
        }
        return f4010a.booleanValue();
    }

    @TargetApi(26)
    public static boolean c(Context context) {
        if (!b(context)) {
            return false;
        }
        if (n.h()) {
            return a(context) && !n.i();
        }
        return true;
    }

    public static boolean d(Context context) {
        if (f4012c == null) {
            f4012c = Boolean.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.type.iot") || context.getPackageManager().hasSystemFeature("android.hardware.type.embedded"));
        }
        return f4012c.booleanValue();
    }

    public static boolean a() {
        return "user".equals(Build.TYPE);
    }
}
