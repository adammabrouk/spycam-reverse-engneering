package c.k.d.p9;

import c.k.d.h8;
import c.k.d.j;
import c.k.d.v6;
import c.k.d.v7;
import com.xiaomi.push.service.XMPushService;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class b0 extends j.a {

    /* renamed from: a, reason: collision with root package name */
    public v7 f7542a;

    /* renamed from: b, reason: collision with root package name */
    public WeakReference<XMPushService> f7543b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f7544c;

    public b0(v7 v7Var, WeakReference<XMPushService> weakReference, boolean z) {
        this.f7544c = false;
        this.f7542a = v7Var;
        this.f7543b = weakReference;
        this.f7544c = z;
    }

    @Override // c.k.d.j.a
    public int a() {
        return 22;
    }

    @Override // java.lang.Runnable
    public void run() {
        XMPushService xMPushService;
        WeakReference<XMPushService> weakReference = this.f7543b;
        if (weakReference == null || this.f7542a == null || (xMPushService = weakReference.get()) == null) {
            return;
        }
        this.f7542a.a(p.a());
        this.f7542a.a(false);
        c.k.a.a.a.c.c("MoleInfo aw_ping : send aw_Ping msg " + this.f7542a.a());
        try {
            String c2 = this.f7542a.c();
            xMPushService.a(c2, h8.a(w1.a(c2, this.f7542a.b(), this.f7542a, v6.Notification)), this.f7544c);
        } catch (Exception e2) {
            c.k.a.a.a.c.d("MoleInfo aw_ping : send help app ping error" + e2.toString());
        }
    }
}
