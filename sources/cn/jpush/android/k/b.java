package cn.jpush.android.k;

import android.text.TextUtils;

/* loaded from: classes.dex */
public class b extends d {

    /* renamed from: a, reason: collision with root package name */
    public int f9770a;

    /* renamed from: b, reason: collision with root package name */
    public String f9771b;

    public int a() {
        if (cn.jpush.android.ar.d.a(cn.jpush.android.u.a.a(), this.f9770a, b(), f().a())) {
            cn.jpush.android.r.b.b("JUnionAdH5Promote", "h5 link jump success");
            return 100;
        }
        cn.jpush.android.r.b.f("JUnionAdH5Promote", "h5 link jump failed");
        return 101;
    }

    @Override // cn.jpush.android.k.d
    public int a(int i2) {
        super.f(false);
        int c2 = super.c(i2);
        if (c2 != 0) {
            cn.jpush.android.r.b.b("JUnionAdH5Promote", "checkForOperation failed, operation: " + i2 + ", code: " + c2);
            return c2;
        }
        String b2 = b();
        if (TextUtils.isEmpty(b2)) {
            cn.jpush.android.r.b.f("JUnionAdH5Promote", "h5 url check failed, url is empty, url: " + b2);
            return 102;
        }
        if (cn.jpush.android.af.a.a(b2)) {
            super.f(true);
            return 100;
        }
        cn.jpush.android.r.b.f("JUnionAdH5Promote", "h5 url check failed, url is illegality, url: " + b2);
        return 103;
    }

    public void a(String str) {
        this.f9771b = str;
    }

    public void b(int i2) {
        this.f9770a = i2;
    }
}
