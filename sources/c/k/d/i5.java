package c.k.d;

import com.xiaomi.push.service.XMPushService;

/* loaded from: classes.dex */
public class i5 extends XMPushService.i {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f7249b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ h5 f7250c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i5(h5 h5Var, int i2, long j) {
        super(i2);
        this.f7250c = h5Var;
        this.f7249b = j;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "check the ping-pong." + this.f7249b;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    /* renamed from: a, reason: collision with other method in class */
    public void mo224a() {
        Thread.yield();
        if (!this.f7250c.m549c() || this.f7250c.a(this.f7249b)) {
            return;
        }
        this.f7250c.u.a(22, (Exception) null);
    }
}
