package c.k.d.p9;

import android.content.Context;
import android.text.TextUtils;
import c.k.d.f7;
import c.k.d.g7;
import c.k.d.h8;
import c.k.d.p9.j0;
import c.k.d.v6;
import c.k.d.v7;
import com.xiaomi.push.service.XMPushService;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class x1 extends j0.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ XMPushService f7730c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ i1 f7731d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x1(String str, long j, XMPushService xMPushService, i1 i1Var) {
        super(str, j);
        this.f7730c = xMPushService;
        this.f7731d = i1Var;
    }

    @Override // c.k.d.p9.j0.a
    public void a(j0 j0Var) {
        String a2 = j0Var.a("GAID", "gaid");
        String b2 = f7.b((Context) this.f7730c);
        c.k.a.a.a.c.c("gaid :" + b2);
        if (TextUtils.isEmpty(b2) || TextUtils.equals(a2, b2)) {
            return;
        }
        j0Var.a("GAID", "gaid", b2);
        v7 v7Var = new v7();
        v7Var.b(this.f7731d.f7609d);
        v7Var.c(g7.ClientInfoUpdate.f30a);
        v7Var.a(p.a());
        v7Var.a(new HashMap());
        v7Var.m504a().put("gaid", b2);
        byte[] a3 = h8.a(w1.a(this.f7730c.getPackageName(), this.f7731d.f7609d, v7Var, v6.Notification));
        XMPushService xMPushService = this.f7730c;
        xMPushService.a(xMPushService.getPackageName(), a3, true);
    }
}
