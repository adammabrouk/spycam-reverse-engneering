package c.k.d;

import android.content.Context;

/* loaded from: classes.dex */
public class v {

    /* renamed from: a, reason: collision with root package name */
    public static volatile boolean f7940a = false;

    public static void a(Class<?> cls, Context context) {
        if (f7940a) {
            return;
        }
        try {
            f7940a = true;
            cls.getDeclaredMethod("InitEntry", Context.class).invoke(cls, context);
        } catch (Throwable th) {
            c.k.a.a.a.c.m6a("mdid:load lib error " + th);
        }
    }

    public static boolean a(Context context) {
        try {
            Class<?> a2 = q9.a(context, "com.bun.miitmdid.core.JLibrary");
            if (a2 == null) {
                return false;
            }
            a(a2, context);
            return true;
        } catch (Throwable th) {
            c.k.a.a.a.c.m6a("mdid:check error " + th);
            return false;
        }
    }
}
