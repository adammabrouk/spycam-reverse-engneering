package c.k.d.p9;

import c.k.d.l5;
import c.k.d.s4;
import com.xiaomi.push.service.XMPushService;

/* loaded from: classes.dex */
public class a1 extends XMPushService.i {

    /* renamed from: b, reason: collision with root package name */
    public XMPushService f7530b;

    /* renamed from: c, reason: collision with root package name */
    public s4[] f7531c;

    public a1(XMPushService xMPushService, s4[] s4VarArr) {
        super(4);
        this.f7530b = null;
        this.f7530b = xMPushService;
        this.f7531c = s4VarArr;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "batch send message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    /* renamed from: a */
    public void mo224a() {
        try {
            if (this.f7531c != null) {
                this.f7530b.a(this.f7531c);
            }
        } catch (l5 e2) {
            c.k.a.a.a.c.a(e2);
            this.f7530b.a(10, e2);
        }
    }
}
