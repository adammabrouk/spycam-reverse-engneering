package c.k.d;

import com.xiaomi.push.service.XMPushService;

/* loaded from: classes.dex */
public class j5 extends XMPushService.i {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f7288b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Exception f7289c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ h5 f7290d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j5(h5 h5Var, int i2, int i3, Exception exc) {
        super(i2);
        this.f7290d = h5Var;
        this.f7288b = i3;
        this.f7289c = exc;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "shutdown the connection. " + this.f7288b + ", " + this.f7289c;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    /* renamed from: a */
    public void mo224a() {
        this.f7290d.u.a(this.f7288b, this.f7289c);
    }
}
