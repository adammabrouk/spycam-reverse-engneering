package c.k.d;

import com.xiaomi.push.service.XMPushService;

/* loaded from: classes.dex */
public class j6 extends XMPushService.i {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i6 f7291b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j6(i6 i6Var, int i2) {
        super(i2);
        this.f7291b = i6Var;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "Handling bind stats";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    /* renamed from: a */
    public void mo224a() {
        this.f7291b.c();
    }
}
