package c.k.c.a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import c.k.d.f7;
import c.k.d.g9;
import java.util.HashMap;

/* loaded from: classes.dex */
public class v {
    public static HashMap<String, String> a(Context context, String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            hashMap.put("appToken", q0.m45a(context).b());
            hashMap.put("regId", l.q(context));
            hashMap.put("appId", q0.m45a(context).m46a());
            hashMap.put("regResource", q0.m45a(context).e());
            if (!g9.d()) {
                String g2 = f7.g(context);
                if (!TextUtils.isEmpty(g2)) {
                    hashMap.put("imeiMd5", c.k.d.k0.a(g2));
                }
            }
            hashMap.put("isMIUI", String.valueOf(g9.m183a()));
            hashMap.put("miuiVersion", g9.m180a());
            hashMap.put("devId", f7.a(context, true));
            hashMap.put("model", Build.MODEL);
            hashMap.put("pkgName", context.getPackageName());
            hashMap.put("sdkVersion", "3_7_6");
            hashMap.put("androidVersion", String.valueOf(Build.VERSION.SDK_INT));
            hashMap.put("os", Build.VERSION.RELEASE + "-" + Build.VERSION.INCREMENTAL);
            hashMap.put("andId", f7.e(context));
            if (!TextUtils.isEmpty(str)) {
                hashMap.put("clientInterfaceId", str);
            }
        } catch (Throwable unused) {
        }
        return hashMap;
    }
}
