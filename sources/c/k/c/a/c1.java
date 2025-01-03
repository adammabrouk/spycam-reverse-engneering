package c.k.c.a;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import c.k.d.a7;
import c.k.d.g7;
import c.k.d.g9;
import c.k.d.h8;
import c.k.d.i8;
import c.k.d.j;
import c.k.d.v7;
import c.k.d.x3;
import c.k.d.z3;
import java.util.HashMap;

/* loaded from: classes.dex */
public class c1 {
    public static void a(Context context, Intent intent, Uri uri) {
        x3 a2;
        z3 z3Var;
        if (context == null) {
            return;
        }
        i0.a(context).m25a();
        if (x3.a(context.getApplicationContext()).m524a() == null) {
            x3.a(context.getApplicationContext()).a(q0.m45a(context.getApplicationContext()).m46a(), context.getPackageName(), c.k.d.p9.m.a(context.getApplicationContext()).a(a7.AwakeInfoUploadWaySwitch.a(), 0), new r0());
            c.k.d.p9.m.a(context).a(new e1(102, "awake online config", context));
        }
        if ((context instanceof Activity) && intent != null) {
            a2 = x3.a(context.getApplicationContext());
            z3Var = z3.ACTIVITY;
        } else {
            if (!(context instanceof Service) || intent == null) {
                if (uri == null || TextUtils.isEmpty(uri.toString())) {
                    return;
                }
                x3.a(context.getApplicationContext()).a(z3.PROVIDER, context, (Intent) null, uri.toString());
                return;
            }
            if ("com.xiaomi.mipush.sdk.WAKEUP".equals(intent.getAction())) {
                a2 = x3.a(context.getApplicationContext());
                z3Var = z3.SERVICE_COMPONENT;
            } else {
                a2 = x3.a(context.getApplicationContext());
                z3Var = z3.SERVICE_ACTION;
            }
        }
        a2.a(z3Var, context, intent, (String) null);
    }

    public static final <T extends i8<T, ?>> void a(Context context, T t, boolean z, int i2) {
        byte[] a2 = h8.a(t);
        if (a2 == null) {
            c.k.a.a.a.c.m6a("send message fail, because msgBytes is null.");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("action_help_ping");
        intent.putExtra("extra_help_ping_switch", z);
        intent.putExtra("extra_help_ping_frequency", i2);
        intent.putExtra("mipush_payload", a2);
        intent.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
        i0.a(context).m26a(intent);
    }

    public static void a(Context context, v7 v7Var) {
        boolean a2 = c.k.d.p9.m.a(context).a(a7.AwakeAppPingSwitch.a(), false);
        int a3 = c.k.d.p9.m.a(context).a(a7.AwakeAppPingFrequency.a(), 0);
        if (a3 >= 0 && a3 < 30) {
            c.k.a.a.a.c.c("aw_ping: frquency need > 30s.");
            a3 = 30;
        }
        boolean z = a3 >= 0 ? a2 : false;
        if (!g9.m183a()) {
            a(context, v7Var, z, a3);
        } else if (z) {
            c.k.d.j.a(context.getApplicationContext()).a((j.a) new d1(v7Var, context), a3);
        }
    }

    public static void a(Context context, String str) {
        c.k.a.a.a.c.m6a("aw_ping : send aw_ping cmd and content to push service from 3rd app");
        HashMap hashMap = new HashMap();
        hashMap.put("awake_info", str);
        hashMap.put("event_type", String.valueOf(9999));
        hashMap.put("description", "ping message");
        v7 v7Var = new v7();
        v7Var.b(q0.m45a(context).m46a());
        v7Var.d(context.getPackageName());
        v7Var.c(g7.AwakeAppResponse.f30a);
        v7Var.a(c.k.d.p9.p.a());
        v7Var.f105a = hashMap;
        a(context, v7Var);
    }

    public static void a(Context context, String str, int i2, String str2) {
        v7 v7Var = new v7();
        v7Var.b(str);
        v7Var.a(new HashMap());
        v7Var.m504a().put("extra_aw_app_online_cmd", String.valueOf(i2));
        v7Var.m504a().put("extra_help_aw_info", str2);
        v7Var.a(c.k.d.p9.p.a());
        byte[] a2 = h8.a(v7Var);
        if (a2 == null) {
            c.k.a.a.a.c.m6a("send message fail, because msgBytes is null.");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("action_aw_app_logic");
        intent.putExtra("mipush_payload", a2);
        i0.a(context).m26a(intent);
    }
}
