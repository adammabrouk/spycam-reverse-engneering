package cn.jpush.android.cache;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import cn.jiguang.api.MultiSpHelper;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.helper.Logger;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static SharedPreferences f9693a;

    public static void a(Context context) {
        f9693a = context.getSharedPreferences("cn.jpush.config", 0);
    }

    public static void a(Context context, int i2) {
        s(context).edit().putInt("service_stoped", i2).apply();
    }

    public static void a(Context context, long j) {
        if (j < 0) {
            Logger.w("PushConfig", "freeze end time was incorrect!");
            return;
        }
        if (j > 1800) {
            Logger.i("PushConfig", "freeze end time was greate than half an hour");
            j = 1800;
        }
        s(context).edit().putLong("TAFreezeSetTime", System.currentTimeMillis()).putLong("TAFreezeEndTime", j * 1000).apply();
    }

    public static void a(Context context, String str) {
        s(context).edit().putString("mobile_number", str).apply();
    }

    public static void a(Context context, String str, String str2) {
        s(context).edit().putString("jpush_save_custom_builder" + str, str2).apply();
    }

    public static void a(Context context, boolean z) {
        s(context).edit().putBoolean("ups_state", z).apply();
    }

    public static int b(Context context) {
        SharedPreferences reload = Sp.reload(context, "cn.jpush.config");
        if (reload == null) {
            reload = s(context);
        }
        int i2 = reload.getInt("service_stoped", -1);
        if (i2 >= 0) {
            return i2;
        }
        int i3 = context.getSharedPreferences(MultiSpHelper.SP_FILE, 0).getInt("service_stoped", 0);
        a(context, i3);
        return i3;
    }

    public static void b(Context context, long j) {
        s(context).edit().putLong("geofence_interval", j).apply();
    }

    public static void b(Context context, String str) {
        s(context).edit().putString("setting_push_time", str).apply();
    }

    public static void b(Context context, boolean z) {
        s(context).edit().putBoolean("notification_enabled", z).apply();
    }

    public static boolean b(Context context, int i2) {
        String str;
        if (i2 != 0 && b(context) >= 1) {
            str = "The service is stopped, it will give up all the actions until you call resumePush method to resume the service.";
        } else if (i2 != 1 && !d(context)) {
            str = "The service is stopped, it will give up all the actions until you call JPushUPSManager.trunOn method to resume the service.";
        } else {
            if (i2 == 2 || ((Boolean) Sp.get(context, Key.UPSRegister())).booleanValue()) {
                return false;
            }
            str = "The service is stopped, it will give up all the actions until you call JPushUPSManager.registerToken method to resume the service.";
        }
        Logger.ww("PushConfig", str);
        return true;
    }

    public static long c(Context context, long j) {
        long j2 = s(context).getLong("geofence_interval", -1L);
        if (j2 == -1) {
            j2 = context.getSharedPreferences(MultiSpHelper.SP_FILE, 0).getLong("geofence_interval", -1L);
            if (j2 != -1) {
                b(context, j2);
            }
        }
        return j2 == -1 ? j : j2;
    }

    public static void c(Context context, int i2) {
        s(context).edit().putInt("notification_num", i2).apply();
    }

    public static void c(Context context, String str) {
        s(context).edit().putString("setting_silence_push_time", str).apply();
    }

    public static void c(Context context, boolean z) {
        s(context).edit().putBoolean("geofence_pull_enable", z).apply();
    }

    public static boolean c(Context context) {
        boolean z = b(context) >= 1;
        if (z) {
            Logger.dd("PushConfig", "The service is stopped, it will give up all the actions until you call resumePush method to resume the service.");
        }
        return z;
    }

    public static String d(Context context, String str) {
        String string = s(context).getString("jpush_save_custom_builder" + str, "");
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        String string2 = context.getSharedPreferences(MultiSpHelper.SP_FILE, 0).getString("jpush_save_custom_builder" + str, "");
        a(context, str, string2);
        return string2;
    }

    public static void d(Context context, int i2) {
        s(context).edit().putInt("geofence_max_num", i2).apply();
    }

    public static void d(Context context, boolean z) {
        s(context).edit().putBoolean("push_lbs_enable", z).apply();
    }

    public static boolean d(Context context) {
        return s(context).getBoolean("ups_state", true);
    }

    public static int e(Context context, int i2) {
        int i3 = s(context).getInt("geofence_max_num", -1);
        if (i3 == -1 && (i3 = context.getSharedPreferences(MultiSpHelper.SP_FILE, 0).getInt("geofence_max_num", -1)) != -1) {
            d(context, i3);
        }
        return i3 == -1 ? i2 : i3;
    }

    public static void e(Context context, String str) {
        s(context).edit().putString("geofence_pull_limit", str).apply();
    }

    public static boolean e(Context context) {
        String str;
        if (b(context) >= 1) {
            str = "The service is stopped, it will give up all the actions until you call resumePush method to resume the service.";
        } else if (!d(context)) {
            str = "The service is stopped, it will give up all the actions until you call JPushUPSManager.trunOn method to resume the service.";
        } else {
            if (((Boolean) Sp.get(context, Key.UPSRegister())).booleanValue()) {
                return false;
            }
            str = "The service is stopped, it will give up all the actions until you call JPushUPSManager.registerToken method to resume the service.";
        }
        Logger.dd("PushConfig", str);
        return true;
    }

    public static String f(Context context) {
        return s(context).getString("mobile_number", null);
    }

    public static void f(Context context, String str) {
        s(context).edit().putString("geofence_last_pull_state", str).apply();
    }

    public static void g(Context context, String str) {
        s(context).edit().putString("push_inapp_last_state", str).apply();
    }

    public static boolean g(Context context) {
        return s(context).getBoolean("notification_enabled", true);
    }

    public static String h(Context context) {
        return s(context).getString("setting_push_time", "");
    }

    public static void h(Context context, String str) {
        s(context).edit().putString("push_inapp_pos_state", str).apply();
    }

    public static String i(Context context) {
        return s(context).getString("setting_silence_push_time", "");
    }

    public static void i(Context context, String str) {
        s(context).edit().putString("push_inapp_last_info", str).apply();
    }

    public static int j(Context context) {
        return s(context).getInt("notification_num", JPushInterface.DEFAULT_NOTIFICATION_NUM);
    }

    public static boolean k(Context context) {
        long j = s(context).getLong("TAFreezeEndTime", -1L);
        if (j > 1800) {
            j = 0;
        }
        long j2 = s(context).getLong("TAFreezeSetTime", -1L);
        if (j == -1 || j2 == -1) {
            return false;
        }
        if (System.currentTimeMillis() - j2 >= 0 && System.currentTimeMillis() - j2 <= j) {
            return false;
        }
        s(context).edit().putLong("TAFreezeSetTime", -1L).putLong("TAFreezeEndTime", -1L).apply();
        Logger.w("PushConfig", "incorrect timestamp");
        return true;
    }

    public static boolean l(Context context) {
        return s(context).getBoolean("geofence_pull_enable", false);
    }

    public static String m(Context context) {
        return s(context).getString("geofence_pull_limit", "");
    }

    public static String n(Context context) {
        return s(context).getString("geofence_last_pull_state", "");
    }

    public static boolean o(Context context) {
        return s(context).getBoolean("push_lbs_enable", true);
    }

    public static String p(Context context) {
        return s(context).getString("push_inapp_last_state", "0,0");
    }

    public static String q(Context context) {
        return s(context).getString("push_inapp_pos_state", "");
    }

    public static String r(Context context) {
        SharedPreferences reload = Sp.reload(context, "cn.jpush.config");
        if (reload == null) {
            reload = s(context);
        }
        return reload.getString("push_inapp_last_info", ",0");
    }

    public static SharedPreferences s(Context context) {
        if (f9693a == null) {
            a(context);
        }
        return f9693a;
    }
}
