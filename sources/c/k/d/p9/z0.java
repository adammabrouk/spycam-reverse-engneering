package c.k.d.p9;

import android.content.Context;
import c.k.d.a5;
import com.xiaomi.push.service.XMPushService;

/* loaded from: classes.dex */
public class z0 extends XMPushService.i {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f7741b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ byte[] f7742c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f7743d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ XMPushService f7744e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z0(XMPushService xMPushService, int i2, int i3, byte[] bArr, String str) {
        super(i2);
        this.f7744e = xMPushService;
        this.f7741b = i3;
        this.f7742c = bArr;
        this.f7743d = str;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "clear account cache.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    /* renamed from: a */
    public void mo224a() {
        a5 a5Var;
        j1.m390a((Context) this.f7744e);
        r.a().m406a("5");
        c.k.d.c.a(this.f7741b);
        a5Var = this.f7744e.f11267a;
        a5Var.b(a5.a());
        this.f7744e.a(this.f7742c, this.f7743d);
    }
}
