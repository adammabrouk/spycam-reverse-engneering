package c.k.d.p9;

import android.content.Context;
import c.k.d.l5;
import c.k.d.s7;
import com.xiaomi.push.service.XMPushService;

/* loaded from: classes.dex */
public final class t1 extends XMPushService.i {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ XMPushService f7705b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ s7 f7706c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t1(int i2, XMPushService xMPushService, s7 s7Var) {
        super(i2);
        this.f7705b = xMPushService;
        this.f7706c = s7Var;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "send ack message for unrecognized new miui message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    /* renamed from: a */
    public void mo224a() {
        try {
            s7 a2 = o1.a((Context) this.f7705b, this.f7706c);
            a2.a().a("miui_message_unrecognized", "1");
            w1.a(this.f7705b, a2);
        } catch (l5 e2) {
            c.k.a.a.a.c.a(e2);
            this.f7705b.a(10, e2);
        }
    }
}
