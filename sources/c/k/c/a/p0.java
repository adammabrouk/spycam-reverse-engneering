package c.k.c.a;

import android.content.Context;
import android.text.TextUtils;
import c.k.d.d5;
import c.k.d.f7;
import c.k.d.g7;
import c.k.d.g9;
import c.k.d.i9;
import c.k.d.j7;
import c.k.d.v6;
import c.k.d.v7;
import cn.jpush.android.api.JThirdPlatFormInterface;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class p0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f6891a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f6892b;

    public p0(Context context, boolean z) {
        this.f6891a = context;
        this.f6892b = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        String d2;
        String d3;
        Map<String, String> map;
        String d4;
        String str;
        String c2;
        String c3;
        c.k.a.a.a.c.m6a("do sync info");
        v7 v7Var = new v7(c.k.d.p9.p.a(), false);
        q0 m45a = q0.m45a(this.f6891a);
        v7Var.c(g7.SyncInfo.f30a);
        v7Var.b(m45a.m46a());
        v7Var.d(this.f6891a.getPackageName());
        HashMap hashMap = new HashMap();
        v7Var.f105a = hashMap;
        Context context = this.f6891a;
        i9.a(hashMap, "app_version", d5.m127a(context, context.getPackageName()));
        Map<String, String> map2 = v7Var.f105a;
        Context context2 = this.f6891a;
        i9.a(map2, "app_version_code", Integer.toString(d5.a(context2, context2.getPackageName())));
        i9.a(v7Var.f105a, "push_sdk_vn", "3_7_6");
        i9.a(v7Var.f105a, "push_sdk_vc", Integer.toString(30706));
        i9.a(v7Var.f105a, JThirdPlatFormInterface.KEY_TOKEN, m45a.b());
        f7.a(this.f6891a, v7Var.f105a);
        if (!g9.d()) {
            String a2 = c.k.d.k0.a(f7.f(this.f6891a));
            String h2 = f7.h(this.f6891a);
            if (!TextUtils.isEmpty(h2)) {
                a2 = a2 + "," + h2;
            }
            if (!TextUtils.isEmpty(a2)) {
                i9.a(v7Var.f105a, "imei_md5", a2);
            }
        }
        c.k.d.y.a(this.f6891a).a(v7Var.f105a);
        i9.a(v7Var.f105a, "reg_id", m45a.c());
        i9.a(v7Var.f105a, "reg_secret", m45a.d());
        i9.a(v7Var.f105a, "accept_time", l.i(this.f6891a).replace(",", "-"));
        if (this.f6892b) {
            Map<String, String> map3 = v7Var.f105a;
            c2 = o0.c(l.j(this.f6891a));
            i9.a(map3, "aliases_md5", c2);
            Map<String, String> map4 = v7Var.f105a;
            c3 = o0.c(l.k(this.f6891a));
            i9.a(map4, "topics_md5", c3);
            map = v7Var.f105a;
            d4 = o0.c(l.l(this.f6891a));
            str = "accounts_md5";
        } else {
            Map<String, String> map5 = v7Var.f105a;
            d2 = o0.d(l.j(this.f6891a));
            i9.a(map5, "aliases", d2);
            Map<String, String> map6 = v7Var.f105a;
            d3 = o0.d(l.k(this.f6891a));
            i9.a(map6, "topics", d3);
            map = v7Var.f105a;
            d4 = o0.d(l.l(this.f6891a));
            str = "user_accounts";
        }
        i9.a(map, str, d4);
        i0.a(this.f6891a).a((i0) v7Var, v6.Notification, false, (j7) null);
    }
}
