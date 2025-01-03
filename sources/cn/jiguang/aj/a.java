package cn.jiguang.aj;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import cn.jiguang.l.b;
import cn.jiguang.l.d;
import com.shix.shixipc.utils.CommonUtil;
import java.lang.reflect.InvocationTargetException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {
    public static void a(Context context, int i2) {
        boolean z;
        boolean z2;
        if (cn.jiguang.h.a.a().a(1800)) {
            String g2 = b.g(context);
            boolean a2 = new a().a(context);
            boolean z3 = true;
            if (!TextUtils.isEmpty(g2)) {
                if (TextUtils.equals("ON", g2)) {
                    z = false;
                    z2 = true;
                } else {
                    z = !TextUtils.equals("OFF", g2);
                    z2 = false;
                }
                if (z) {
                    cn.jiguang.ai.a.a("JNotificationState", "notification state do not changed");
                    z3 = z;
                } else if (z2 == a2) {
                    z3 = false;
                }
            }
            cn.jiguang.ai.a.a("JNotificationState", "lastCacheNotificationState:" + g2 + ",currentNotificationSate:" + a2 + ",isNeedReport:" + z3 + ",triggerScene:" + i2);
            if (!z3) {
                cn.jiguang.ai.a.a("JNotificationState", "do not need report notification state");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("notification_state", a2);
                if (cn.jiguang.h.a.a().a(1802)) {
                    jSONObject.put("device_id", d.h(context));
                }
                jSONObject.put("trigger_scene", i2);
                d.a(context, jSONObject, "android_notification_state");
                d.a(context, jSONObject);
                b.t(context, a2 ? "ON" : "OFF");
            } catch (Throwable th) {
                cn.jiguang.ai.a.d("JNotificationState", "report notification state failed, error:" + th.getMessage());
            }
        }
    }

    private boolean a(Context context) {
        return Build.VERSION.SDK_INT >= 24 ? b(context) : c(context);
    }

    @TargetApi(24)
    private boolean b(Context context) {
        try {
            return ((NotificationManager) context.getSystemService("notification")).areNotificationsEnabled();
        } catch (Throwable th) {
            cn.jiguang.ai.a.d("JNotificationState", "invoke areNotificationsEnabled method failed, error:" + th.getMessage());
            return true;
        }
    }

    private boolean c(Context context) {
        try {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            String packageName = context.getApplicationContext().getPackageName();
            int i2 = applicationInfo.uid;
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            return ((Integer) cls.getMethod(CommonUtil.CHECK_OP_NO_THROW, Integer.TYPE, Integer.TYPE, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls.getDeclaredField(CommonUtil.OP_POST_NOTIFICATION).get(Integer.class)).intValue()), Integer.valueOf(i2), packageName)).intValue() == 0;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            return true;
        } catch (Throwable th) {
            cn.jiguang.ai.a.d("JNotificationState", "getNotificationStateCommon failed, other error:" + th.getMessage());
            return true;
        }
    }
}
