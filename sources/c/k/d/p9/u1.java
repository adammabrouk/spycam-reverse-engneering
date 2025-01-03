package c.k.d.p9;

import android.content.Context;
import c.k.d.l5;
import c.k.d.s7;
import com.xiaomi.push.service.XMPushService;

/* loaded from: classes.dex */
public final class u1 extends XMPushService.i {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ XMPushService f7709b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ s7 f7710c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f7711d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u1(int i2, XMPushService xMPushService, s7 s7Var, String str) {
        super(i2);
        this.f7709b = xMPushService;
        this.f7710c = s7Var;
        this.f7711d = str;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "send app absent ack message for message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    /* renamed from: a */
    public void mo224a() {
        try {
            s7 a2 = o1.a((Context) this.f7709b, this.f7710c);
            a2.a().a("absent_target_package", this.f7711d);
            w1.a(this.f7709b, a2);
        } catch (l5 e2) {
            c.k.a.a.a.c.a(e2);
            this.f7709b.a(10, e2);
        }
    }
}
