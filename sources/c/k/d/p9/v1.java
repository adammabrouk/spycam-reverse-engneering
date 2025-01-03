package c.k.d.p9;

import android.content.Context;
import c.k.d.l5;
import c.k.d.s7;
import com.xiaomi.push.service.XMPushService;

/* loaded from: classes.dex */
public final class v1 extends XMPushService.i {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ XMPushService f7722b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ s7 f7723c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f7724d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f7725e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v1(int i2, XMPushService xMPushService, s7 s7Var, String str, String str2) {
        super(i2);
        this.f7722b = xMPushService;
        this.f7723c = s7Var;
        this.f7724d = str;
        this.f7725e = str2;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "send wrong message ack for message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    /* renamed from: a */
    public void mo224a() {
        try {
            s7 a2 = o1.a((Context) this.f7722b, this.f7723c);
            a2.f7850a.a("error", this.f7724d);
            a2.f7850a.a("reason", this.f7725e);
            w1.a(this.f7722b, a2);
        } catch (l5 e2) {
            c.k.a.a.a.c.a(e2);
            this.f7722b.a(10, e2);
        }
    }
}
