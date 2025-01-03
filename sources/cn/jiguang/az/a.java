package cn.jiguang.az;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import cn.jpush.android.service.AlarmReceiver;

/* loaded from: classes.dex */
public class a {
    public static void a(Context context) {
        if (Build.VERSION.SDK_INT >= 31 && context.getApplicationInfo().targetSdkVersion >= 31) {
            cn.jiguang.as.d.c("AlarmHelper", "sdk is android 12, return");
            return;
        }
        try {
            ((AlarmManager) context.getSystemService("alarm")).cancel(PendingIntent.getBroadcast(context, 0, new Intent(context, (Class<?>) AlarmReceiver.class), 67108864));
        } catch (Throwable unused) {
            cn.jiguang.as.d.g("AlarmHelper", "Cancel heartbeat alarm failed.");
        }
    }

    public static void b(Context context) {
        if (Build.VERSION.SDK_INT >= 31 && context.getApplicationInfo().targetSdkVersion >= 31) {
            cn.jiguang.as.d.c("AlarmHelper", "sdk is android 12, return");
            return;
        }
        h.a().e();
        long h2 = h.a().h() * 1000;
        long currentTimeMillis = System.currentTimeMillis() + h2;
        cn.jiguang.as.d.e("AlarmHelper", "Reset heartbeat alarm, wait " + h2 + "ms.");
        try {
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, new Intent(context, (Class<?>) AlarmReceiver.class), 67108864);
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            if (Build.VERSION.SDK_INT >= 19) {
                alarmManager.setWindow(0, currentTimeMillis, 0L, broadcast);
            } else {
                alarmManager.setInexactRepeating(0, currentTimeMillis, h2, broadcast);
            }
        } catch (Throwable th) {
            cn.jiguang.as.d.h("AlarmHelper", "can't trigger alarm cause by exception:" + th);
        }
    }
}
