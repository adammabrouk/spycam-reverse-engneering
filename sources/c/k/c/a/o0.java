package c.k.c.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import c.k.d.a7;
import c.k.d.v7;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class o0 {
    public static void a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        long j = sharedPreferences.getLong("last_sync_info", -1L);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        long a2 = c.k.d.p9.m.a(context).a(a7.SyncInfoFrequency.a(), 1209600);
        if (j != -1) {
            if (Math.abs(currentTimeMillis - j) <= a2) {
                return;
            } else {
                a(context, true);
            }
        }
        sharedPreferences.edit().putLong("last_sync_info", currentTimeMillis).commit();
    }

    public static void a(Context context, v7 v7Var) {
        c.k.a.a.a.c.m6a("need to update local info with: " + v7Var.m504a());
        String str = v7Var.m504a().get("accept_time");
        if (str != null) {
            l.u(context);
            String[] split = str.split("-");
            if (split.length == 2) {
                l.a(context, split[0], split[1]);
                if ("00:00".equals(split[0]) && "00:00".equals(split[1])) {
                    q0.m45a(context).a(true);
                } else {
                    q0.m45a(context).a(false);
                }
            }
        }
        String str2 = v7Var.m504a().get("aliases");
        if (str2 != null) {
            l.w(context);
            if (!"".equals(str2)) {
                for (String str3 : str2.split(",")) {
                    l.c(context, str3);
                }
            }
        }
        String str4 = v7Var.m504a().get("topics");
        if (str4 != null) {
            l.x(context);
            if (!"".equals(str4)) {
                for (String str5 : str4.split(",")) {
                    l.d(context, str5);
                }
            }
        }
        String str6 = v7Var.m504a().get("user_accounts");
        if (str6 != null) {
            l.v(context);
            if ("".equals(str6)) {
                return;
            }
            for (String str7 : str6.split(",")) {
                l.b(context, str7);
            }
        }
    }

    public static void a(Context context, boolean z) {
        c.k.d.j.a(context).a(new p0(context, z));
    }

    public static String c(List<String> list) {
        String a2 = c.k.d.k0.a(d(list));
        return (TextUtils.isEmpty(a2) || a2.length() <= 4) ? "" : a2.substring(0, 4).toLowerCase();
    }

    public static String d(List<String> list) {
        String str = "";
        if (c.k.d.e.a(list)) {
            return "";
        }
        ArrayList<String> arrayList = new ArrayList(list);
        Collections.sort(arrayList, Collator.getInstance(Locale.CHINA));
        for (String str2 : arrayList) {
            if (!TextUtils.isEmpty(str)) {
                str = str + ",";
            }
            str = str + str2;
        }
        return str;
    }
}
