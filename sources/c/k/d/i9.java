package c.k.d;

import android.content.Context;
import android.preference.PreferenceManager;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class i9 {
    public static void a(Context context) {
    }

    public static void a(Context context, String str, boolean z) {
        a(context);
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean(str, z).commit();
    }

    public static void a(Map<String, String> map, String str, String str2) {
        if (map == null || str == null || str2 == null) {
            return;
        }
        map.put(str, str2);
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m231a(Context context, String str, boolean z) {
        a(context);
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(str, z);
    }
}
