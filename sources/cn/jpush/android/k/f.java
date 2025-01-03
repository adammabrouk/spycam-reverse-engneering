package cn.jpush.android.k;

import android.text.TextUtils;
import com.google.zxing.datamatrix.encoder.ErrorCorrection;
import com.google.zxing.decoding.InactivityTimer;
import com.shix.shixipc.utils.ShareSystemFileUtils;

/* loaded from: classes.dex */
public class f extends d {

    /* renamed from: a, reason: collision with root package name */
    public String f9788a;

    /* renamed from: b, reason: collision with root package name */
    public String f9789b;

    /* renamed from: c, reason: collision with root package name */
    public int f9790c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f9791d;

    /* renamed from: e, reason: collision with root package name */
    public String f9792e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f9793f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f9794g;

    public int a() {
        if (cn.jpush.android.bg.b.a(cn.jpush.android.u.a.a(), this.f9788a, this.f9789b, g(), this.f9790c)) {
            cn.jpush.android.r.b.b("JUnionAdWechatPromote", "wechat mini jump success");
            return InactivityTimer.INACTIVITY_DELAY_SECONDS;
        }
        cn.jpush.android.r.b.f("JUnionAdWechatPromote", "wechat mini jump failed");
        return ErrorCorrection.MODULO_VALUE;
    }

    @Override // cn.jpush.android.k.d
    public int a(int i2) {
        super.f(false);
        int c2 = super.c(i2);
        if (c2 != 0) {
            cn.jpush.android.r.b.b("JUnionAdWechatPromote", "checkForOperation failed, operation: " + i2 + ", code: " + c2);
            return c2;
        }
        String b2 = b();
        if (TextUtils.isEmpty(b2) || TextUtils.isEmpty(this.f9788a) || TextUtils.isEmpty(this.f9789b) || TextUtils.isEmpty(this.f9792e)) {
            cn.jpush.android.r.b.f("JUnionAdWechatPromote", "wechat param check failed, param is null, url: " + b2 + ", wxAppId: " + this.f9788a + ", wxOriginId: " + this.f9789b + ", wxSign: " + this.f9792e);
            return 302;
        }
        if (i2 == 2 || i2 == 4) {
            if (!cn.jpush.android.bm.a.d(cn.jpush.android.u.a.a(), ShareSystemFileUtils.PACKAGE_WECHAT)) {
                cn.jpush.android.r.b.f("JUnionAdWechatPromote", "wechat not install");
                return 304;
            }
            if (this.f9793f) {
                String n = cn.jpush.android.bm.a.n(cn.jpush.android.u.a.a());
                cn.jpush.android.r.b.b("JUnionAdWechatPromote", "wehcat localAppId: " + n + ", wxAppId: " + this.f9788a);
                if (!TextUtils.equals(n, this.f9788a)) {
                    return 303;
                }
            }
            if (this.f9794g) {
                String g2 = cn.jpush.android.bm.a.g(cn.jpush.android.u.a.a(), ShareSystemFileUtils.PACKAGE_WECHAT);
                cn.jpush.android.r.b.b("JUnionAdWechatPromote", "wehcat localSign: " + g2 + ", wxAppSign: " + this.f9792e);
                if (!TextUtils.equals(g2, this.f9792e)) {
                    return 303;
                }
            }
        }
        super.f(true);
        return InactivityTimer.INACTIVITY_DELAY_SECONDS;
    }

    public void a(String str) {
        this.f9788a = str;
    }

    public void a(boolean z) {
        this.f9791d = z;
    }

    public void b(int i2) {
        this.f9790c = i2;
    }

    public void b(String str) {
        this.f9789b = str;
    }

    public void b(boolean z) {
        this.f9793f = z;
    }

    public void c(String str) {
        this.f9792e = str;
    }

    public void c(boolean z) {
        this.f9794g = z;
    }

    public String g() {
        return b();
    }
}
