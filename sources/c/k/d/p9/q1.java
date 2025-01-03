package c.k.d.p9;

import android.content.Context;
import c.k.d.l5;
import c.k.d.s7;
import com.xiaomi.push.service.XMPushService;

/* loaded from: classes.dex */
public final class q1 extends XMPushService.i {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ XMPushService f7672b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ s7 f7673c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q1(int i2, XMPushService xMPushService, s7 s7Var) {
        super(i2);
        this.f7672b = xMPushService;
        this.f7673c = s7Var;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "send ack message for message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    /* renamed from: a */
    public void mo224a() {
        try {
            w1.a(this.f7672b, o1.a((Context) this.f7672b, this.f7673c));
        } catch (l5 e2) {
            c.k.a.a.a.c.a(e2);
            this.f7672b.a(10, e2);
        }
    }
}
