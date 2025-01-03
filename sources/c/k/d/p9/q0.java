package c.k.d.p9;

import com.xiaomi.push.service.XMPushService;

/* loaded from: classes.dex */
public class q0 extends XMPushService.i {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ XMPushService f7671b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q0(XMPushService xMPushService, int i2) {
        super(i2);
        this.f7671b = xMPushService;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "disconnect for service destroy.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    /* renamed from: a */
    public void mo224a() {
        if (this.f7671b.j != null) {
            this.f7671b.j.a(15, (Exception) null);
            this.f7671b.j = null;
        }
    }
}
