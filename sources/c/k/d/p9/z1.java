package c.k.d.p9;

import c.k.d.p9.r;
import com.xiaomi.push.service.XMPushService;

/* loaded from: classes.dex */
public final class z1 implements r.b.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ XMPushService f7745a;

    public z1(XMPushService xMPushService) {
        this.f7745a = xMPushService;
    }

    @Override // c.k.d.p9.r.b.a
    public void a(r.c cVar, r.c cVar2, int i2) {
        if (cVar2 == r.c.binded) {
            n1.a(this.f7745a);
            n1.b(this.f7745a);
        } else if (cVar2 == r.c.unbind) {
            n1.a(this.f7745a, 70000001, " the push is not connected.");
        }
    }
}
