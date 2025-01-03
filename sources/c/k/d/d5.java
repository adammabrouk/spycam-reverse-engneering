package c.k.d;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.shix.shixipc.utils.CommonUtil;
import com.tencent.bugly.BuglyStrategy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class d5 {

    public enum a {
        UNKNOWN(0),
        ALLOWED(1),
        NOT_ALLOWED(2);


        /* renamed from: a, reason: collision with other field name */
        public final int f13a;

        a(int i2) {
            this.f13a = i2;
        }

        public int a() {
            return this.f13a;
        }
    }

    public static int a(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
        } catch (Exception e2) {
            c.k.a.a.a.c.a(e2);
            packageInfo = null;
        }
        if (packageInfo != null) {
            return packageInfo.versionCode;
        }
        return 0;
    }

    public static a a(Context context, ApplicationInfo applicationInfo) {
        int i2 = Build.VERSION.SDK_INT;
        if (applicationInfo == null || i2 < 24) {
            return a.UNKNOWN;
        }
        Boolean bool = null;
        try {
            if (applicationInfo.packageName.equals(context.getPackageName())) {
                bool = Boolean.valueOf(((NotificationManager) context.getSystemService("notification")).areNotificationsEnabled());
            } else {
                Object a2 = i2 >= 29 ? f0.a(context.getSystemService("notification"), "getService", new Object[0]) : context.getSystemService("security");
                if (a2 != null) {
                    bool = (Boolean) f0.b(a2, "areNotificationsEnabledForPackage", applicationInfo.packageName, Integer.valueOf(applicationInfo.uid));
                }
            }
            if (bool != null) {
                return bool.booleanValue() ? a.ALLOWED : a.NOT_ALLOWED;
            }
        } catch (Exception e2) {
            c.k.a.a.a.c.m6a("are notifications enabled error " + e2);
        }
        return a.UNKNOWN;
    }

    @TargetApi(19)
    public static a a(Context context, String str, boolean z) {
        ApplicationInfo applicationInfo;
        a a2;
        if (context == null || TextUtils.isEmpty(str) || Build.VERSION.SDK_INT < 19) {
            return a.UNKNOWN;
        }
        try {
            applicationInfo = str.equals(context.getPackageName()) ? context.getApplicationInfo() : context.getPackageManager().getApplicationInfo(str, 0);
            a2 = a(context, applicationInfo);
        } catch (Throwable th) {
            c.k.a.a.a.c.m6a("get app op error " + th);
        }
        if (a2 != a.UNKNOWN) {
            return a2;
        }
        Integer num = (Integer) f0.a((Class<? extends Object>) AppOpsManager.class, CommonUtil.OP_POST_NOTIFICATION);
        if (num == null) {
            return a.UNKNOWN;
        }
        Integer num2 = (Integer) f0.a((AppOpsManager) context.getSystemService("appops"), CommonUtil.CHECK_OP_NO_THROW, num, Integer.valueOf(applicationInfo.uid), str);
        int i2 = (Integer) f0.a((Class<? extends Object>) AppOpsManager.class, "MODE_ALLOWED");
        int i3 = (Integer) f0.a((Class<? extends Object>) AppOpsManager.class, "MODE_IGNORED");
        c.k.a.a.a.c.b(String.format("get app mode %s|%s|%s", num2, i2, i3));
        if (i2 == null) {
            i2 = 0;
        }
        if (i3 == null) {
            i3 = 1;
        }
        if (num2 != null) {
            return z ? !num2.equals(i3) ? a.ALLOWED : a.NOT_ALLOWED : num2.equals(i2) ? a.ALLOWED : a.NOT_ALLOWED;
        }
        return a.UNKNOWN;
    }

    public static String a(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context == null || (runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) == null) {
            return null;
        }
        int myPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static String m127a(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
        } catch (Exception e2) {
            c.k.a.a.a.c.a(e2);
            packageInfo = null;
        }
        return packageInfo != null ? packageInfo.versionName : "1.0";
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m128a(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null && runningAppProcesses.size() >= 1) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == Process.myPid() && runningAppProcessInfo.processName.equals(context.getPackageName())) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m129a(Context context, String str) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
        while (it.hasNext()) {
            if (Arrays.asList(it.next().pkgList).contains(str)) {
                return true;
            }
        }
        return false;
    }

    public static String b(Context context) {
        String str;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        if (runningAppProcesses != null && runningAppProcesses.size() > 0) {
            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
            while (it.hasNext()) {
                String[] strArr = it.next().pkgList;
                for (int i2 = 0; strArr != null && i2 < strArr.length; i2++) {
                    if (!arrayList.contains(strArr[i2])) {
                        arrayList.add(strArr[i2]);
                        if (arrayList.size() == 1) {
                            str = (String) arrayList.get(0);
                        } else {
                            sb.append("#");
                            str = strArr[i2];
                        }
                        sb.append(str.hashCode() % BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH);
                    }
                }
            }
        }
        return sb.toString();
    }

    public static String b(Context context, String str) {
        ApplicationInfo applicationInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            return (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null) ? str : packageManager.getApplicationLabel(applicationInfo).toString();
        } catch (PackageManager.NameNotFoundException e2) {
            c.k.a.a.a.c.a(e2);
            return str;
        }
    }

    /* renamed from: b, reason: collision with other method in class */
    public static boolean m130b(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    public static boolean c(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }
}
