package c.k.d.p9;

import c.k.d.l5;
import com.xiaomi.push.service.XMPushService;

/* loaded from: classes.dex */
public class p0 extends XMPushService.i {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f7665b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ byte[] f7666c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ XMPushService f7667d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p0(XMPushService xMPushService, int i2, String str, byte[] bArr) {
        super(i2);
        this.f7667d = xMPushService;
        this.f7665b = str;
        this.f7666c = bArr;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "send mi push message";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    /* renamed from: a */
    public void mo224a() {
        try {
            w1.a(this.f7667d, this.f7665b, this.f7666c);
        } catch (l5 e2) {
            c.k.a.a.a.c.a(e2);
            this.f7667d.a(10, e2);
        }
    }
}
