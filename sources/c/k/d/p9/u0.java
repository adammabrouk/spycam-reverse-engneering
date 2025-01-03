package c.k.d.p9;

import c.k.d.p9.r;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.XMPushService.f;

/* loaded from: classes.dex */
public class u0 implements r.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ XMPushService f7708a;

    public u0(XMPushService xMPushService) {
        this.f7708a = xMPushService;
    }

    @Override // c.k.d.p9.r.a
    public void a() {
        this.f7708a.e();
        if (r.a().m401a() <= 0) {
            XMPushService xMPushService = this.f7708a;
            xMPushService.a(xMPushService.new f(12, null));
        }
    }
}
