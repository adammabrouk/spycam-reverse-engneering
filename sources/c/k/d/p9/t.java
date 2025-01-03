package c.k.d.p9;

import c.k.d.p9.r;
import com.xiaomi.push.service.XMPushService;

/* loaded from: classes.dex */
public class t extends XMPushService.i {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ r.b.c f7704b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(r.b.c cVar, int i2) {
        super(i2);
        this.f7704b = cVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "clear peer job";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    /* renamed from: a */
    public void mo224a() {
        r.b.c cVar = this.f7704b;
        if (cVar.f7692b == cVar.f7691a.r) {
            c.k.a.a.a.c.b("clean peer, chid = " + this.f7704b.f7691a.f7684h);
            this.f7704b.f7691a.r = null;
        }
    }
}
