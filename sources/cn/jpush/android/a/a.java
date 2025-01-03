package cn.jpush.android.a;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static SharedPreferences f9082a;

    public static void a(Context context) {
        if (f9082a == null) {
            f9082a = context.getSharedPreferences("asus_push_sdk_preferences", 0);
        }
    }

    public static void a(String str, String str2) {
        SharedPreferences sharedPreferences = f9082a;
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString(str, str2);
            edit.apply();
        }
    }

    public static void a(String str, boolean z) {
        SharedPreferences sharedPreferences = f9082a;
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putBoolean(str, false);
            edit.apply();
        }
    }

    public static Boolean b(String str, boolean z) {
        SharedPreferences sharedPreferences = f9082a;
        if (sharedPreferences != null) {
            return Boolean.valueOf(sharedPreferences.getBoolean(str, true));
        }
        return true;
    }

    public static String b(String str, String str2) {
        SharedPreferences sharedPreferences = f9082a;
        return sharedPreferences != null ? sharedPreferences.getString(str, str2) : str2;
    }
}
