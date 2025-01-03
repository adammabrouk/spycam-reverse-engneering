package c.k.d.p9;

import c.k.d.l5;
import c.k.d.s7;
import com.xiaomi.push.service.XMPushService;

/* loaded from: classes.dex */
public final class p1 extends XMPushService.i {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ XMPushService f7668b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ s7 f7669c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p1(int i2, XMPushService xMPushService, s7 s7Var) {
        super(i2);
        this.f7668b = xMPushService;
        this.f7669c = s7Var;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "send app absent message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    /* renamed from: a */
    public void mo224a() {
        try {
            w1.a(this.f7668b, w1.a(this.f7669c.b(), this.f7669c.m470a()));
        } catch (l5 e2) {
            c.k.a.a.a.c.a(e2);
            this.f7668b.a(10, e2);
        }
    }
}
