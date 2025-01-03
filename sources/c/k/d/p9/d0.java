package c.k.d.p9;

import c.k.d.l5;
import c.k.d.s4;
import com.xiaomi.push.service.XMPushService;

/* loaded from: classes.dex */
public class d0 extends XMPushService.i {

    /* renamed from: b, reason: collision with root package name */
    public XMPushService f7556b;

    /* renamed from: c, reason: collision with root package name */
    public s4 f7557c;

    public d0(XMPushService xMPushService, s4 s4Var) {
        super(4);
        this.f7556b = null;
        this.f7556b = xMPushService;
        this.f7557c = s4Var;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "send a message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    /* renamed from: a */
    public void mo224a() {
        try {
            if (this.f7557c != null) {
                this.f7556b.a(this.f7557c);
            }
        } catch (l5 e2) {
            c.k.a.a.a.c.a(e2);
            this.f7556b.a(10, e2);
        }
    }
}
