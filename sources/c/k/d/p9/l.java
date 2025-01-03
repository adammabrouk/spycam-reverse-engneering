package c.k.d.p9;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.text.TextUtils;
import java.util.List;

/* loaded from: classes.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f7640a = {"com.mi.globalbrowser", "com.android.browser"};

    /* renamed from: b, reason: collision with root package name */
    public static String f7641b;

    public static int a(Context context, String str) {
        ApplicationInfo applicationInfo;
        if (str.equals(context.getPackageName())) {
            applicationInfo = context.getApplicationInfo();
        } else {
            try {
                applicationInfo = context.getPackageManager().getApplicationInfo(str, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                c.k.a.a.a.c.m6a("not found app info " + str);
                applicationInfo = null;
            }
        }
        if (applicationInfo == null) {
            return 0;
        }
        int i2 = applicationInfo.icon;
        return (i2 != 0 || Build.VERSION.SDK_INT < 9) ? i2 : applicationInfo.logo;
    }

    public static String a(Notification notification) {
        Object a2;
        String str = null;
        try {
            if (Build.VERSION.SDK_INT >= 19 && notification.extras != null) {
                str = notification.extras.getString("target_package");
            }
            return (!TextUtils.isEmpty(str) || (a2 = c.k.d.f0.a(notification, "extraNotification")) == null) ? str : (String) c.k.d.f0.a(a2, "getTargetPkg", new Object[0]);
        } catch (Exception unused) {
            return str;
        }
    }

    public static void a(Notification notification, String str) {
        try {
            if (Build.VERSION.SDK_INT >= 19 && notification.extras != null) {
                notification.extras.putString("target_package", str);
            }
            Object a2 = c.k.d.f0.a(notification, "extraNotification");
            if (a2 != null) {
                c.k.d.f0.a(a2, "setTargetPkg", str);
            }
        } catch (Exception unused) {
        }
    }

    public static void a(Context context, Intent intent) {
        String str;
        int i2 = -1;
        while (true) {
            str = i2 < 0 ? f7641b : f7640a[i2];
            if (!TextUtils.isEmpty(str)) {
                intent.setPackage(str);
                try {
                    List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
                    if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
                        break;
                    }
                } catch (Exception e2) {
                    c.k.a.a.a.c.m6a("not found xm browser:" + e2);
                }
            }
            i2++;
            if (i2 >= f7640a.length) {
                str = null;
                break;
            }
        }
        intent.setPackage(str);
        f7641b = str;
    }

    public static boolean a(Context context) {
        return context != null && "com.xiaomi.xmsf".equals(context.getPackageName());
    }
}
