package c.k.d.p9;

import com.xiaomi.push.service.XMPushService;

/* loaded from: classes.dex */
public class x0 extends XMPushService.i {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ XMPushService f7729b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x0(XMPushService xMPushService, int i2) {
        super(i2);
        this.f7729b = xMPushService;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "prepare the mi push account.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    /* renamed from: a */
    public void mo224a() {
        w1.a(this.f7729b);
        if (c.k.d.e0.b(this.f7729b)) {
            this.f7729b.a(true);
        }
    }
}
