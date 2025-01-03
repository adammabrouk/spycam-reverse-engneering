package cn.jpush.android.k;

import android.text.TextUtils;
import androidx.viewpager.widget.ViewPager;

/* loaded from: classes.dex */
public class a extends d {

    /* renamed from: a, reason: collision with root package name */
    public String f9761a;

    /* renamed from: b, reason: collision with root package name */
    public String f9762b;

    /* renamed from: c, reason: collision with root package name */
    public String f9763c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f9764d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f9765e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f9766f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f9767g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f9768h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f9769i = false;
    public int j;

    private cn.jpush.android.aw.e g() {
        cn.jpush.android.d.d a2 = f().a();
        a2.L = b();
        cn.jpush.android.aw.e eVar = new cn.jpush.android.aw.e(a2);
        eVar.f9433h = true;
        eVar.f9428c = b();
        eVar.f9431f = this.f9761a;
        eVar.f9432g = this.j;
        eVar.f9434i = this.f9762b;
        eVar.j = this.f9763c;
        eVar.k = this.f9764d;
        eVar.l = this.f9765e;
        eVar.m = this.f9766f;
        eVar.n = this.f9768h;
        eVar.o = this.f9767g;
        return eVar;
    }

    public int a() {
        String str;
        cn.jpush.android.r.b.b("JUnionAdDownloadPromote", "start download jump, url: " + b() + ", isH5Link: " + this.f9769i);
        if (this.f9769i) {
            if (cn.jpush.android.ar.d.a(cn.jpush.android.u.a.a(), this.j, b(), f().a())) {
                str = "download h5 link jump success";
                cn.jpush.android.r.b.b("JUnionAdDownloadPromote", str);
                return ViewPager.MIN_FLING_VELOCITY;
            }
            cn.jpush.android.r.b.f("JUnionAdDownloadPromote", "download h5 link jump failed");
            return 401;
        }
        if (cn.jpush.android.ar.d.c(cn.jpush.android.u.a.a(), g())) {
            str = "download apk link jump success";
            cn.jpush.android.r.b.b("JUnionAdDownloadPromote", str);
            return ViewPager.MIN_FLING_VELOCITY;
        }
        cn.jpush.android.r.b.f("JUnionAdDownloadPromote", "download h5 link jump failed");
        return 401;
    }

    @Override // cn.jpush.android.k.d
    public int a(int i2) {
        super.f(false);
        int c2 = super.c(i2);
        if (c2 != 0) {
            cn.jpush.android.r.b.b("JUnionAdDownloadPromote", "checkForOperation failed, operation: " + i2 + ", code: " + c2);
            return c2;
        }
        String b2 = b();
        if (TextUtils.isEmpty(b2) || TextUtils.isEmpty(this.f9761a)) {
            cn.jpush.android.r.b.f("JUnionAdDownloadPromote", "download package name param check failed, param is null");
            return 402;
        }
        this.f9769i = !b2.endsWith(".apk");
        if (!cn.jpush.android.af.a.a(b2) || (!this.f9769i && !b2.endsWith(".apk"))) {
            cn.jpush.android.r.b.f("JUnionAdDownloadPromote", "download url check failed, url is illegality, url: " + b2);
            return 403;
        }
        if ((i2 != 2 && i2 != 4) || !cn.jpush.android.bm.a.d(cn.jpush.android.u.a.a(), this.f9761a)) {
            super.f(true);
            return ViewPager.MIN_FLING_VELOCITY;
        }
        cn.jpush.android.r.b.f("JUnionAdDownloadPromote", "download package is installed, packageName: " + this.f9761a);
        return 404;
    }

    public void a(String str) {
        this.f9762b = str;
    }

    public void a(boolean z) {
        this.f9764d = z;
    }

    public void b(int i2) {
        this.j = i2;
    }

    public void b(String str) {
        this.f9763c = str;
    }

    public void b(boolean z) {
        this.f9765e = z;
    }

    public void c(String str) {
        this.f9761a = str;
    }

    public void c(boolean z) {
        this.f9766f = z;
    }

    public void d(boolean z) {
        this.f9767g = z;
    }

    public void e(boolean z) {
        this.f9768h = z;
    }
}
