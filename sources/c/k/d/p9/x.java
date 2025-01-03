package c.k.d.p9;

import android.content.Context;
import c.k.d.b4;
import c.k.d.g7;
import c.k.d.h8;
import c.k.d.s3;
import c.k.d.t6;
import c.k.d.v6;
import c.k.d.v7;
import c.k.d.x3;
import com.xiaomi.push.service.XMPushService;
import java.util.HashMap;

/* loaded from: classes.dex */
public class x implements b4 {
    @Override // c.k.d.b4
    public void a(Context context, HashMap<String, String> hashMap) {
        v7 v7Var = new v7();
        v7Var.b(x3.a(context).m525a());
        v7Var.d(x3.a(context).b());
        v7Var.c(g7.AwakeAppResponse.f30a);
        v7Var.a(p.a());
        v7Var.f105a = hashMap;
        byte[] a2 = h8.a(w1.a(v7Var.c(), v7Var.b(), v7Var, v6.Notification));
        if (!(context instanceof XMPushService)) {
            c.k.a.a.a.c.m6a("MoleInfo : context is not correct in pushLayer " + v7Var.a());
            return;
        }
        c.k.a.a.a.c.m6a("MoleInfo : send data directly in pushLayer " + v7Var.a());
        ((XMPushService) context).a(context.getPackageName(), a2, true);
    }

    @Override // c.k.d.b4
    public void b(Context context, HashMap<String, String> hashMap) {
        c.k.a.a.a.c.m6a("MoleInfo：\u3000" + s3.b(hashMap));
    }

    @Override // c.k.d.b4
    public void c(Context context, HashMap<String, String> hashMap) {
        t6 a2 = t6.a(context);
        if (a2 != null) {
            a2.a("category_awake_app", "wake_up_app", 1L, s3.a(hashMap));
        }
    }
}
