package cn.jiguang.ar;

import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.shix.shixipc.utils.CommonUtil;

/* loaded from: classes.dex */
public class g {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v5, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    public static int a(Context context) {
        StringBuilder sb;
        String str;
        if (cn.jiguang.ap.f.m(context).booleanValue()) {
            f.d("NotificationHelper", "sdk is banned, call failed");
            return 0;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 24) {
            try {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                if (notificationManager == null) {
                    return -1;
                }
                boolean areNotificationsEnabled = notificationManager.areNotificationsEnabled();
                f.a("NotificationHelper", "from NotificationManager enable=" + areNotificationsEnabled);
                return areNotificationsEnabled ? 1 : 0;
            } catch (Throwable th) {
                th = th;
                sb = new StringBuilder();
                str = "isNotificationEnabled e:";
            }
        } else {
            if (i2 < 19) {
                f.a("NotificationHelper", "below 19 return true");
                return 1;
            }
            try {
                AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                String packageName = context.getApplicationContext().getPackageName();
                int i3 = applicationInfo.uid;
                Class<?> cls = Class.forName(AppOpsManager.class.getName());
                ?? r1 = ((Integer) cls.getMethod(CommonUtil.CHECK_OP_NO_THROW, Integer.TYPE, Integer.TYPE, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls.getDeclaredField(CommonUtil.OP_POST_NOTIFICATION).get(Integer.class)).intValue()), Integer.valueOf(i3), packageName)).intValue() == 0 ? 1 : 0;
                f.a("NotificationHelper", "from AppOpsManager enable=" + ((boolean) r1));
                return r1;
            } catch (Throwable th2) {
                th = th2;
                sb = new StringBuilder();
                str = "appOps check e:";
            }
        }
        sb.append(str);
        sb.append(th);
        f.c("NotificationHelper", sb.toString());
        return -1;
    }
}
