package cn.jpush.android.s;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public Context f9844a;

    /* renamed from: b, reason: collision with root package name */
    public String f9845b;

    /* renamed from: c, reason: collision with root package name */
    public long f9846c;

    /* renamed from: d, reason: collision with root package name */
    public String f9847d;

    /* renamed from: e, reason: collision with root package name */
    public String f9848e;

    /* renamed from: f, reason: collision with root package name */
    public String f9849f;

    /* renamed from: g, reason: collision with root package name */
    public String f9850g;

    /* renamed from: h, reason: collision with root package name */
    public String f9851h;

    /* renamed from: i, reason: collision with root package name */
    public String f9852i;

    public a(Context context) {
        this.f9844a = context;
    }

    public String a() {
        if (!TextUtils.isEmpty(this.f9845b)) {
            return this.f9845b;
        }
        String c2 = cn.jpush.android.l.a.c(this.f9844a);
        this.f9845b = c2;
        return c2;
    }

    public long b() {
        long j = this.f9846c;
        if (j != 0) {
            return j;
        }
        long b2 = cn.jpush.android.l.a.b(this.f9844a);
        this.f9846c = b2;
        return b2;
    }

    public String c() {
        if (!TextUtils.isEmpty(this.f9848e)) {
            return this.f9848e;
        }
        String packageName = this.f9844a.getPackageName();
        this.f9848e = packageName;
        return packageName;
    }

    public String d() {
        if (TextUtils.isEmpty(this.f9849f)) {
            String c2 = c();
            if (!TextUtils.isEmpty(c2)) {
                try {
                    this.f9849f = this.f9844a.getPackageManager().getPackageInfo(c2, 0).versionName;
                } catch (Throwable unused) {
                }
            }
        }
        return this.f9849f;
    }

    public String e() {
        if (!TextUtils.isEmpty(this.f9850g)) {
            return this.f9850g;
        }
        String c2 = cn.jpush.android.m.a.c();
        this.f9850g = c2;
        return c2;
    }

    public String f() {
        if (!TextUtils.isEmpty(this.f9851h)) {
            return this.f9851h;
        }
        String d2 = cn.jpush.android.m.a.d();
        this.f9851h = d2;
        return d2;
    }

    public String g() {
        if (!TextUtils.isEmpty(this.f9852i)) {
            return this.f9852i;
        }
        String e2 = cn.jpush.android.l.a.e(this.f9844a);
        this.f9852i = e2;
        return e2;
    }

    public String h() {
        if (!TextUtils.isEmpty(this.f9847d)) {
            return this.f9847d;
        }
        String d2 = cn.jpush.android.l.a.d(this.f9844a);
        this.f9847d = d2;
        return d2;
    }
}
