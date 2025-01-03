package c.k.d;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;

/* loaded from: classes.dex */
public class t3 {
    public static void a(Context context, String str, int i2, String str2) {
        j.a(context).a(new u3(context, str, i2, str2));
    }

    public static void a(Context context, HashMap<String, String> hashMap) {
        b4 m524a = x3.a(context).m524a();
        if (m524a != null) {
            m524a.a(context, hashMap);
        }
    }

    public static void b(Context context, HashMap<String, String> hashMap) {
        b4 m524a = x3.a(context).m524a();
        if (m524a != null) {
            m524a.b(context, hashMap);
        }
    }

    public static void c(Context context, String str, int i2, String str2) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("awake_info", str);
            hashMap.put("event_type", String.valueOf(i2));
            hashMap.put("description", str2);
            int a2 = x3.a(context).a();
            if (a2 != 1) {
                if (a2 != 2) {
                    if (a2 == 3) {
                        a(context, hashMap);
                    }
                }
                c(context, hashMap);
            } else {
                a(context, hashMap);
            }
            b(context, hashMap);
        } catch (Exception e2) {
            c.k.a.a.a.c.a(e2);
        }
    }

    public static void c(Context context, HashMap<String, String> hashMap) {
        b4 m524a = x3.a(context).m524a();
        if (m524a != null) {
            m524a.c(context, hashMap);
        }
    }
}
