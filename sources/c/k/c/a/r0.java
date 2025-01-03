package c.k.c.a;

import android.content.Context;
import c.k.d.b4;
import c.k.d.g7;
import c.k.d.j7;
import c.k.d.s3;
import c.k.d.v6;
import c.k.d.v7;
import c.k.d.x3;
import java.util.HashMap;

/* loaded from: classes.dex */
public class r0 implements b4 {
    @Override // c.k.d.b4
    public void a(Context context, HashMap<String, String> hashMap) {
        v7 v7Var = new v7();
        v7Var.b(x3.a(context).m525a());
        v7Var.d(x3.a(context).b());
        v7Var.c(g7.AwakeAppResponse.f30a);
        v7Var.a(c.k.d.p9.p.a());
        v7Var.f105a = hashMap;
        i0.a(context).a((i0) v7Var, v6.Notification, true, (j7) null, true);
        c.k.a.a.a.c.m6a("MoleInfo：\u3000send data in app layer");
    }

    @Override // c.k.d.b4
    public void b(Context context, HashMap<String, String> hashMap) {
        c.k.a.a.a.c.m6a("MoleInfo：\u3000" + s3.b(hashMap));
        String str = hashMap.get("event_type");
        String str2 = hashMap.get("awake_info");
        if (String.valueOf(1007).equals(str)) {
            c1.a(context, str2);
        }
    }

    @Override // c.k.d.b4
    public void c(Context context, HashMap<String, String> hashMap) {
        p.a("category_awake_app", "wake_up_app", 1L, s3.a(hashMap));
        c.k.a.a.a.c.m6a("MoleInfo：\u3000send data in app layer");
    }
}
