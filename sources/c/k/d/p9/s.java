package c.k.d.p9;

import c.k.d.p9.r;
import cn.jiguang.internal.JConstants;
import com.xiaomi.push.service.XMPushService;

/* loaded from: classes.dex */
public class s implements r.b.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r.b f7700a;

    public s(r.b bVar) {
        this.f7700a = bVar;
    }

    @Override // c.k.d.p9.r.b.a
    public void a(r.c cVar, r.c cVar2, int i2) {
        XMPushService.b bVar;
        XMPushService.b bVar2;
        if (cVar2 == r.c.binding) {
            XMPushService xMPushService = this.f7700a.p;
            bVar2 = this.f7700a.t;
            xMPushService.a(bVar2, JConstants.MIN);
        } else {
            XMPushService xMPushService2 = this.f7700a.p;
            bVar = this.f7700a.t;
            xMPushService2.b(bVar);
        }
    }
}
