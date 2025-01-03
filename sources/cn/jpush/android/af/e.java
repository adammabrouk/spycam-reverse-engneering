package cn.jpush.android.af;

import android.app.ActivityManager;
import android.content.Context;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f9099a = {119, Byte.MAX_VALUE, 84, 82, 118, 97, 114, 63, 81, 80, 105, 38, 87, 114, 68, 73, 111, 97, 98, 104, 125, 65, 119, 105, 113, 116, 66};

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f9100b = {118, 85, 84, 75, 125, 120, Byte.MAX_VALUE, 89, 78, 126, 73, 102, 97, 96, 82, 118, 107, 115, 98, 67, 69, 106};

    public static boolean a(Context context) {
        Boolean isAllowRunningProcess = cn.jpush.android.u.a.c().isAllowRunningProcess();
        if (isAllowRunningProcess == null || !isAllowRunningProcess.booleanValue()) {
            cn.jpush.android.r.b.b("AndroidUtil", "check foreground by lifecycle");
            return cn.jpush.android.o.b.a();
        }
        cn.jpush.android.r.b.b("AndroidUtil", "check foreground by process");
        return b(context);
    }

    public static boolean b(Context context) {
        if (context == null) {
            cn.jpush.android.r.b.f("AndroidUtil", "get rp context is null");
            return cn.jpush.android.o.b.a();
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            boolean z = false;
            Method declaredMethod = Class.forName(cn.jpush.android.bm.d.b(f9099a)).getDeclaredMethod(cn.jpush.android.bm.d.b(f9100b), new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(activityManager, new Object[0]);
            if (invoke instanceof List) {
                Iterator it = ((List) invoke).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ActivityManager.RunningAppProcessInfo runningAppProcessInfo = (ActivityManager.RunningAppProcessInfo) it.next();
                    if (runningAppProcessInfo.processName.equals(context.getPackageName()) && runningAppProcessInfo.importance == 100) {
                        z = true;
                        break;
                    }
                }
                cn.jpush.android.r.b.b("AndroidUtil", "current process is foreground by process, status: " + z);
                return z;
            }
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("AndroidUtil", "get rp is failed, " + th.getMessage());
        }
        return cn.jpush.android.o.b.a();
    }
}
