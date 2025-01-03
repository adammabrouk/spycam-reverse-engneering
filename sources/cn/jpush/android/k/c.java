package cn.jpush.android.k;

import android.text.TextUtils;

/* loaded from: classes.dex */
public class c extends d {

    /* renamed from: a, reason: collision with root package name */
    public String f9772a;

    public int a() {
        if (cn.jpush.android.bg.b.a(cn.jpush.android.u.a.a(), b(), this.f9772a)) {
            cn.jpush.android.r.b.b("JUnionAdLinkPromote", "deeplink jump success");
            return 200;
        }
        cn.jpush.android.r.b.f("JUnionAdLinkPromote", "deeplink jump failed, url: " + b() + ", packageName: " + this.f9772a);
        return 201;
    }

    @Override // cn.jpush.android.k.d
    public int a(int i2) {
        super.f(false);
        int c2 = super.c(i2);
        if (c2 != 0) {
            cn.jpush.android.r.b.b("JUnionAdLinkPromote", "checkForOperation failed, operation: " + i2 + ", code: " + c2);
            return c2;
        }
        String b2 = b();
        if (TextUtils.isEmpty(b2) || TextUtils.isEmpty(this.f9772a)) {
            cn.jpush.android.r.b.f("JUnionAdLinkPromote", "deeplink param check failed, param is null, url: " + b2 + ", packageName: " + this.f9772a);
            return 202;
        }
        if ((i2 == 2 || i2 == 4) && !cn.jpush.android.bm.a.a(cn.jpush.android.u.a.a(), this.f9772a, b2)) {
            cn.jpush.android.r.b.f("JUnionAdLinkPromote", "deeplink jump package not install");
            return 204;
        }
        super.f(true);
        return 200;
    }

    public void a(String str) {
        this.f9772a = str;
    }
}
