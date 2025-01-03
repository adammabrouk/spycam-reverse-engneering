package c.k.d.p9;

import c.k.d.p9.r;
import com.xiaomi.push.service.XMPushService;

/* loaded from: classes.dex */
public class u extends XMPushService.i {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ r.b.c f7707b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(r.b.c cVar, int i2) {
        super(i2);
        this.f7707b = cVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "check peer job";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    /* renamed from: a */
    public void mo224a() {
        r a2 = r.a();
        r.b bVar = this.f7707b.f7691a;
        if (a2.a(bVar.f7684h, bVar.f7678b).r == null) {
            XMPushService xMPushService = r.b.this.p;
            r.b bVar2 = this.f7707b.f7691a;
            xMPushService.a(bVar2.f7684h, bVar2.f7678b, 2, null, null);
        }
    }
}
