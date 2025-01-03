package c.k.d.p9;

import android.content.Context;
import c.k.d.l5;
import c.k.d.s7;
import com.xiaomi.push.service.XMPushService;

/* loaded from: classes.dex */
public final class s1 extends XMPushService.i {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ XMPushService f7702b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ s7 f7703c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s1(int i2, XMPushService xMPushService, s7 s7Var) {
        super(i2);
        this.f7702b = xMPushService;
        this.f7703c = s7Var;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "send ack message for obsleted message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    /* renamed from: a */
    public void mo224a() {
        try {
            s7 a2 = o1.a((Context) this.f7702b, this.f7703c);
            a2.a().a("message_obsleted", "1");
            w1.a(this.f7702b, a2);
        } catch (l5 e2) {
            c.k.a.a.a.c.a(e2);
            this.f7702b.a(10, e2);
        }
    }
}
