package cn.jiguang.api;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

/* loaded from: classes.dex */
public class MultiSpHelper {
    public static final String SP_FILE = "cn.jpush.android.user.profile";
    public static final String TAG = "MultiSpHelper";
    public static SharedPreferences sharedPref;

    public static void commitBoolean(Context context, String str, boolean z) {
        getSp(context).edit().putBoolean(str, z).apply();
    }

    public static void commitInt(Context context, String str, int i2) {
        getSp(context).edit().putInt(str, i2).apply();
    }

    public static void commitLong(Context context, String str, long j) {
        getSp(context).edit().putLong(str, j).apply();
    }

    public static void commitString(Context context, String str, String str2) {
        getSp(context).edit().putString(str, str2).apply();
    }

    public static boolean getBoolean(Context context, String str, boolean z) {
        return getSp(context).getBoolean(str, z);
    }

    public static int getInt(Context context, String str, int i2) {
        SharedPreferences reload;
        return ((str.equals("jpush_register_code") || str.equals("service_stoped")) && (reload = reload(context)) != null) ? reload.getInt(str, i2) : getSp(context).getInt(str, i2);
    }

    public static long getLong(Context context, String str, long j) {
        return getSp(context).getLong(str, j);
    }

    public static SharedPreferences getSp(Context context) {
        if (sharedPref == null) {
            init(context);
        }
        return sharedPref;
    }

    public static String getString(Context context, String str, String str2) {
        return getSp(context).getString(str, str2);
    }

    public static void init(Context context) {
        sharedPref = context.getSharedPreferences(SP_FILE, 0);
    }

    public static SharedPreferences reload(Context context) {
        if (context == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 11) {
            context.getSharedPreferences(SP_FILE, 4);
        }
        return context.getSharedPreferences(SP_FILE, 0);
    }
}
