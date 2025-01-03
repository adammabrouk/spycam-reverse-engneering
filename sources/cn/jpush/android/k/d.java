package cn.jpush.android.k;

import android.content.Context;
import android.os.SystemClock;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public String f9773a;

    /* renamed from: b, reason: collision with root package name */
    public int f9774b;

    /* renamed from: c, reason: collision with root package name */
    public String f9775c;

    /* renamed from: d, reason: collision with root package name */
    public long f9776d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f9777e = false;

    /* renamed from: f, reason: collision with root package name */
    public cn.jpush.android.x.b f9778f;

    private int a() {
        if (SystemClock.elapsedRealtime() <= d()) {
            return 0;
        }
        cn.jpush.android.r.b.f("JUnionAdPromote", "AD data is expired, expireTime: " + d());
        return 2;
    }

    private int a(Context context) {
        int max = Math.max(this.f9778f.ai, 0);
        long max2 = Math.max(this.f9778f.aj, 0) * 1000;
        if (max > 0) {
            cn.jpush.android.r.b.b("JUnionAdPromote", "set ad pos message LimitCount:" + max);
        }
        if (max2 > 0) {
            cn.jpush.android.r.b.b("JUnionAdPromote", "set ad pos message LimitInterval:" + max2);
        }
        int a2 = cn.jpush.android.ar.d.a(context, this.f9778f.ad, max, max2);
        if (a2 == -3) {
            return 1;
        }
        if (a2 != -2) {
            return a2 != -1 ? 0 : 5;
        }
        return 6;
    }

    public int a(int i2) {
        return 0;
    }

    public void a(long j) {
        this.f9776d = SystemClock.elapsedRealtime() + (j * 1000);
    }

    public void a(cn.jpush.android.x.b bVar) {
        this.f9778f = bVar;
    }

    public String b() {
        return this.f9775c;
    }

    public int c(int i2) {
        Context a2 = cn.jpush.android.u.a.a();
        if (i2 != 2) {
            if (i2 != 3) {
                return 0;
            }
            return a();
        }
        if (this.f9778f != null) {
            return a(a2);
        }
        return 0;
    }

    public boolean c() {
        return this.f9774b == 1;
    }

    public long d() {
        return this.f9776d;
    }

    public void d(int i2) {
        this.f9774b = i2;
    }

    public void d(String str) {
        this.f9773a = str;
    }

    public void e(String str) {
        this.f9775c = str;
    }

    public boolean e() {
        return this.f9777e;
    }

    public cn.jpush.android.x.b f() {
        return this.f9778f;
    }

    public void f(boolean z) {
        this.f9777e = z;
    }
}
