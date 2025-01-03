package c.k.d.p9;

import c.k.d.n6;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.XMPushService.d;

/* loaded from: classes.dex */
public class c0 {

    /* renamed from: f, reason: collision with root package name */
    public static int f7548f = 300000;

    /* renamed from: a, reason: collision with root package name */
    public XMPushService f7549a;

    /* renamed from: d, reason: collision with root package name */
    public int f7552d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f7553e = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f7550b = 500;

    /* renamed from: c, reason: collision with root package name */
    public long f7551c = 0;

    public c0(XMPushService xMPushService) {
        this.f7549a = xMPushService;
    }

    public final int a() {
        if (this.f7552d > 8) {
            return 300000;
        }
        double random = (Math.random() * 2.0d) + 1.0d;
        int i2 = this.f7552d;
        if (i2 > 4) {
            return (int) (random * 60000.0d);
        }
        if (i2 > 1) {
            return (int) (random * 10000.0d);
        }
        if (this.f7551c == 0) {
            return 0;
        }
        if (System.currentTimeMillis() - this.f7551c >= 310000) {
            this.f7550b = 1000;
            this.f7553e = 0;
            return 0;
        }
        int i3 = this.f7550b;
        int i4 = f7548f;
        if (i3 >= i4) {
            return i3;
        }
        int i5 = this.f7553e + 1;
        this.f7553e = i5;
        if (i5 >= 4) {
            return i4;
        }
        double d2 = i3;
        Double.isNaN(d2);
        this.f7550b = (int) (d2 * 1.5d);
        return i3;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m364a() {
        this.f7551c = System.currentTimeMillis();
        this.f7549a.a(1);
        this.f7552d = 0;
    }

    public void a(boolean z) {
        if (!this.f7549a.m589a()) {
            c.k.a.a.a.c.c("should not reconnect as no client or network.");
            return;
        }
        if (z) {
            if (!this.f7549a.m590a(1)) {
                this.f7552d++;
            }
            this.f7549a.a(1);
            XMPushService xMPushService = this.f7549a;
            xMPushService.getClass();
            xMPushService.a(xMPushService.new d());
            return;
        }
        if (this.f7549a.m590a(1)) {
            return;
        }
        int a2 = a();
        this.f7552d++;
        c.k.a.a.a.c.m6a("schedule reconnect in " + a2 + "ms");
        XMPushService xMPushService2 = this.f7549a;
        xMPushService2.getClass();
        xMPushService2.a(xMPushService2.new d(), (long) a2);
        if (this.f7552d == 2 && n6.m307a().m312a()) {
            e.b();
        }
        if (this.f7552d == 3) {
            e.a();
        }
    }
}
