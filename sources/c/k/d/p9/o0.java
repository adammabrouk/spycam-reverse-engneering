package c.k.d.p9;

import c.k.d.f5;
import c.k.d.r5;
import c.k.d.s4;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.XMPushService.c;
import com.xiaomi.push.service.XMPushService.k;

/* loaded from: classes.dex */
public class o0 implements f5 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ XMPushService f7662a;

    public o0(XMPushService xMPushService) {
        this.f7662a = xMPushService;
    }

    @Override // c.k.d.f5
    public void a(r5 r5Var) {
        XMPushService xMPushService = this.f7662a;
        xMPushService.a(xMPushService.new k(r5Var));
    }

    @Override // c.k.d.f5
    public void a(s4 s4Var) {
        XMPushService xMPushService = this.f7662a;
        xMPushService.a(xMPushService.new c(s4Var));
    }
}
