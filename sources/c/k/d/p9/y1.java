package c.k.d.p9;

import android.text.TextUtils;
import c.k.d.g7;
import c.k.d.h8;
import c.k.d.p9.j0;
import c.k.d.v6;
import c.k.d.v7;
import com.xiaomi.push.service.XMPushService;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class y1 extends j0.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ XMPushService f7737c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ i1 f7738d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y1(String str, long j, XMPushService xMPushService, i1 i1Var) {
        super(str, j);
        this.f7737c = xMPushService;
        this.f7738d = i1Var;
    }

    @Override // c.k.d.p9.j0.a
    public void a(j0 j0Var) {
        c.k.d.y a2 = c.k.d.y.a(this.f7737c);
        String a3 = j0Var.a("MSAID", "msaid");
        String str = a2.a() + a2.b() + a2.c() + a2.d();
        if (TextUtils.isEmpty(str) || TextUtils.equals(a3, str)) {
            return;
        }
        j0Var.a("MSAID", "msaid", str);
        v7 v7Var = new v7();
        v7Var.b(this.f7738d.f7609d);
        v7Var.c(g7.ClientInfoUpdate.f30a);
        v7Var.a(p.a());
        v7Var.a(new HashMap());
        a2.a(v7Var.m504a());
        byte[] a4 = h8.a(w1.a(this.f7737c.getPackageName(), this.f7738d.f7609d, v7Var, v6.Notification));
        XMPushService xMPushService = this.f7737c;
        xMPushService.a(xMPushService.getPackageName(), a4, true);
    }
}
