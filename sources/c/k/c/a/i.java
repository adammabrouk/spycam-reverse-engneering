package c.k.c.a;

import android.content.Context;
import android.text.TextUtils;
import c.k.d.f7;
import c.k.d.g9;
import c.k.d.j7;
import c.k.d.v6;
import c.k.d.v7;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class i implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        Context context5;
        Context context6;
        Context context7;
        Context context8;
        if (g9.d()) {
            return;
        }
        context = l.f6860b;
        if (f7.f(context) == null) {
            context8 = l.f6860b;
            if (!c.k.d.y.a(context8).mo415a()) {
                return;
            }
        }
        v7 v7Var = new v7();
        context2 = l.f6860b;
        v7Var.b(q0.m45a(context2).m46a());
        v7Var.c("client_info_update");
        v7Var.a(c.k.d.p9.p.a());
        v7Var.a(new HashMap());
        String str = "";
        context3 = l.f6860b;
        String f2 = f7.f(context3);
        if (!TextUtils.isEmpty(f2)) {
            str = "" + c.k.d.k0.a(f2);
        }
        context4 = l.f6860b;
        String h2 = f7.h(context4);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(h2)) {
            str = str + "," + h2;
        }
        if (!TextUtils.isEmpty(str)) {
            v7Var.m504a().put("imei_md5", str);
        }
        context5 = l.f6860b;
        c.k.d.y.a(context5).a(v7Var.m504a());
        context6 = l.f6860b;
        f7.a(context6, v7Var.f105a);
        int a2 = f7.a();
        if (a2 >= 0) {
            v7Var.m504a().put("space_id", Integer.toString(a2));
        }
        context7 = l.f6860b;
        i0.a(context7).a((i0) v7Var, v6.Notification, false, (j7) null);
    }
}
