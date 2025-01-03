package c.k.d.p9;

import android.content.Context;
import c.k.d.l5;
import c.k.d.p9.r;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.XMPushService.a;
import java.io.IOException;
import java.util.Collection;
import org.json.JSONException;

/* loaded from: classes.dex */
public class m1 extends XMPushService.i {

    /* renamed from: b, reason: collision with root package name */
    public XMPushService f7651b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f7652c;

    /* renamed from: d, reason: collision with root package name */
    public String f7653d;

    /* renamed from: e, reason: collision with root package name */
    public String f7654e;

    /* renamed from: f, reason: collision with root package name */
    public String f7655f;

    public m1(XMPushService xMPushService, String str, String str2, String str3, byte[] bArr) {
        super(9);
        this.f7651b = xMPushService;
        this.f7653d = str;
        this.f7652c = bArr;
        this.f7654e = str2;
        this.f7655f = str3;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "register app";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    /* renamed from: a */
    public void mo224a() {
        r.b next;
        i1 a2 = j1.a((Context) this.f7651b);
        if (a2 == null) {
            try {
                a2 = j1.a(this.f7651b, this.f7653d, this.f7654e, this.f7655f);
            } catch (IOException | JSONException e2) {
                c.k.a.a.a.c.a(e2);
            }
        }
        if (a2 == null) {
            c.k.a.a.a.c.d("no account for mipush");
            n1.a(this.f7651b, 70000002, "no account.");
            return;
        }
        Collection<r.b> m403a = r.a().m403a("5");
        if (m403a.isEmpty()) {
            next = a2.a(this.f7651b);
            w1.a(this.f7651b, next);
            r.a().a(next);
        } else {
            next = m403a.iterator().next();
        }
        if (!this.f7651b.m595c()) {
            this.f7651b.a(true);
            return;
        }
        try {
            if (next.m == r.c.binded) {
                w1.a(this.f7651b, this.f7653d, this.f7652c);
            } else if (next.m == r.c.unbind) {
                XMPushService xMPushService = this.f7651b;
                XMPushService xMPushService2 = this.f7651b;
                xMPushService2.getClass();
                xMPushService.a(xMPushService2.new a(next));
            }
        } catch (l5 e3) {
            c.k.a.a.a.c.a(e3);
            this.f7651b.a(10, e3);
        }
    }
}
