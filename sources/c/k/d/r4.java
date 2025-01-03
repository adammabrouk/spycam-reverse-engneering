package c.k.d;

import android.text.TextUtils;
import c.k.d.p9.r;
import cn.jpush.android.api.JThirdPlatFormInterface;
import java.util.HashMap;

/* loaded from: classes.dex */
public class r4 {
    public static void a(r.b bVar, String str, z4 z4Var) {
        String a2;
        j3 j3Var = new j3();
        if (!TextUtils.isEmpty(bVar.f7679c)) {
            j3Var.a(bVar.f7679c);
        }
        if (!TextUtils.isEmpty(bVar.f7682f)) {
            j3Var.d(bVar.f7682f);
        }
        if (!TextUtils.isEmpty(bVar.f7683g)) {
            j3Var.e(bVar.f7683g);
        }
        j3Var.b(bVar.f7681e ? "1" : "0");
        if (TextUtils.isEmpty(bVar.f7680d)) {
            j3Var.c("XIAOMI-SASL");
        } else {
            j3Var.c(bVar.f7680d);
        }
        s4 s4Var = new s4();
        s4Var.c(bVar.f7678b);
        s4Var.a(Integer.parseInt(bVar.f7684h));
        s4Var.b(bVar.f7677a);
        s4Var.a("BIND", (String) null);
        s4Var.a(s4Var.d());
        c.k.a.a.a.c.m6a("[Slim]: bind id=" + s4Var.d());
        HashMap hashMap = new HashMap();
        hashMap.put("challenge", str);
        hashMap.put(JThirdPlatFormInterface.KEY_TOKEN, bVar.f7679c);
        hashMap.put("chid", bVar.f7684h);
        hashMap.put("from", bVar.f7678b);
        hashMap.put("id", s4Var.d());
        hashMap.put("to", "xiaomi.com");
        if (bVar.f7681e) {
            hashMap.put("kick", "1");
        } else {
            hashMap.put("kick", "0");
        }
        if (TextUtils.isEmpty(bVar.f7682f)) {
            hashMap.put("client_attrs", "");
        } else {
            hashMap.put("client_attrs", bVar.f7682f);
        }
        if (TextUtils.isEmpty(bVar.f7683g)) {
            hashMap.put("cloud_attrs", "");
        } else {
            hashMap.put("cloud_attrs", bVar.f7683g);
        }
        if (bVar.f7680d.equals("XIAOMI-PASS") || bVar.f7680d.equals("XMPUSH-PASS")) {
            a2 = i0.a(bVar.f7680d, null, hashMap, bVar.f7685i);
        } else {
            bVar.f7680d.equals("XIAOMI-SASL");
            a2 = null;
        }
        j3Var.f(a2);
        s4Var.a(j3Var.m460a(), (String) null);
        z4Var.a(s4Var);
    }

    public static void a(String str, String str2, z4 z4Var) {
        s4 s4Var = new s4();
        s4Var.c(str2);
        s4Var.a(Integer.parseInt(str));
        s4Var.a("UBND", (String) null);
        z4Var.a(s4Var);
    }
}
