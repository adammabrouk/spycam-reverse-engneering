package c.k.d.p9;

import android.text.TextUtils;
import c.k.d.a5;
import c.k.d.d2;
import c.k.d.g6;
import c.k.d.i3;
import c.k.d.k3;
import c.k.d.n3;
import c.k.d.o3;
import c.k.d.o4;
import c.k.d.o5;
import c.k.d.p3;
import c.k.d.p5;
import c.k.d.p6;
import c.k.d.p9.r;
import c.k.d.q3;
import c.k.d.q5;
import c.k.d.r3;
import c.k.d.r5;
import c.k.d.s4;
import com.shix.shixipc.system.ContentCommon;
import com.xiaomi.push.service.XMPushService;
import java.util.Date;

/* loaded from: classes.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    public XMPushService f7670a;

    public q(XMPushService xMPushService) {
        this.f7670a = xMPushService;
    }

    public final void a(o5 o5Var) {
        String c2 = o5Var.c();
        if (TextUtils.isEmpty(c2)) {
            return;
        }
        String[] split = c2.split(";");
        c.k.d.p1 a2 = c.k.d.u1.a().a(a5.a(), false);
        if (a2 == null || split.length <= 0) {
            return;
        }
        a2.a(split);
        this.f7670a.a(20, (Exception) null);
        this.f7670a.a(true);
    }

    public void a(r5 r5Var) {
        if (!"5".equals(r5Var.d())) {
            b(r5Var);
        }
        String d2 = r5Var.d();
        if (TextUtils.isEmpty(d2)) {
            d2 = "1";
            r5Var.c("1");
        }
        if (d2.equals("0")) {
            c.k.a.a.a.c.m6a("Received wrong packet with chid = 0 : " + r5Var.mo336a());
        }
        if (r5Var instanceof p5) {
            o5 a2 = r5Var.a("kick");
            if (a2 != null) {
                String e2 = r5Var.e();
                String a3 = a2.a(ContentCommon.TYPE);
                String a4 = a2.a("reason");
                c.k.a.a.a.c.m6a("kicked by server, chid=" + d2 + " res=" + r.b.a(e2) + " type=" + a3 + " reason=" + a4);
                if (!"wait".equals(a3)) {
                    this.f7670a.a(d2, e2, 3, a4, a3);
                    r.a().m407a(d2, e2);
                    return;
                }
                r.b a5 = r.a().a(d2, e2);
                if (a5 != null) {
                    this.f7670a.a(a5);
                    a5.a(r.c.unbind, 3, 0, a4, a3);
                    return;
                }
                return;
            }
        } else if (r5Var instanceof q5) {
            q5 q5Var = (q5) r5Var;
            if ("redir".equals(q5Var.b())) {
                o5 a6 = q5Var.a("hosts");
                if (a6 != null) {
                    a(a6);
                    return;
                }
                return;
            }
        }
        this.f7670a.b().a(this.f7670a, d2, r5Var);
    }

    public void a(s4 s4Var) {
        if (5 != s4Var.a()) {
            c(s4Var);
        }
        try {
            b(s4Var);
        } catch (Exception e2) {
            c.k.a.a.a.c.a("handle Blob chid = " + s4Var.a() + " cmd = " + s4Var.m461a() + " packetid = " + s4Var.d() + " failure ", e2);
        }
    }

    public final void b(r5 r5Var) {
        r.b a2;
        String e2 = r5Var.e();
        String d2 = r5Var.d();
        if (TextUtils.isEmpty(e2) || TextUtils.isEmpty(d2) || (a2 = r.a().a(d2, e2)) == null) {
            return;
        }
        g6.a(this.f7670a, a2.f7677a, g6.a(r5Var.mo336a()), true, true, System.currentTimeMillis());
    }

    public void b(s4 s4Var) {
        StringBuilder sb;
        String m319a;
        String str;
        r.c cVar;
        int i2;
        int i3;
        String m461a = s4Var.m461a();
        if (s4Var.a() != 0) {
            String num = Integer.toString(s4Var.a());
            if (!"SECMSG".equals(s4Var.m461a())) {
                if (!"BIND".equals(m461a)) {
                    if ("KICK".equals(m461a)) {
                        n3 a2 = n3.a(s4Var.m465a());
                        String f2 = s4Var.f();
                        String m302a = a2.m302a();
                        String m304b = a2.m304b();
                        c.k.a.a.a.c.m6a("kicked by server, chid=" + num + " res= " + r.b.a(f2) + " type=" + m302a + " reason=" + m304b);
                        if (!"wait".equals(m302a)) {
                            this.f7670a.a(num, f2, 3, m304b, m302a);
                            r.a().m407a(num, f2);
                            return;
                        }
                        r.b a3 = r.a().a(num, f2);
                        if (a3 != null) {
                            this.f7670a.a(a3);
                            a3.a(r.c.unbind, 3, 0, m304b, m302a);
                            return;
                        }
                        return;
                    }
                    return;
                }
                k3 a4 = k3.a(s4Var.m465a());
                String f3 = s4Var.f();
                r.b a5 = r.a().a(num, f3);
                if (a5 == null) {
                    return;
                }
                if (a4.m263a()) {
                    c.k.a.a.a.c.m6a("SMACK: channel bind succeeded, chid=" + s4Var.a());
                    a5.a(r.c.binded, 1, 0, (String) null, (String) null);
                    return;
                }
                String m262a = a4.m262a();
                if ("auth".equals(m262a)) {
                    if ("invalid-sig".equals(a4.m264b())) {
                        c.k.a.a.a.c.m6a("SMACK: bind error invalid-sig token = " + a5.f7679c + " sec = " + a5.f7685i);
                        p6.a(0, o4.BIND_INVALID_SIG.a(), 1, null, 0);
                    }
                    cVar = r.c.unbind;
                    i2 = 1;
                    i3 = 5;
                } else {
                    if (!"cancel".equals(m262a)) {
                        if ("wait".equals(m262a)) {
                            this.f7670a.a(a5);
                            a5.a(r.c.unbind, 1, 7, a4.m264b(), m262a);
                        }
                        str = "SMACK: channel bind failed, chid=" + num + " reason=" + a4.m264b();
                        c.k.a.a.a.c.m6a(str);
                    }
                    cVar = r.c.unbind;
                    i2 = 1;
                    i3 = 7;
                }
                a5.a(cVar, i2, i3, a4.m264b(), m262a);
                r.a().m407a(num, f3);
                str = "SMACK: channel bind failed, chid=" + num + " reason=" + a4.m264b();
                c.k.a.a.a.c.m6a(str);
            }
            if (!s4Var.m464a()) {
                this.f7670a.b().a(this.f7670a, num, s4Var);
                return;
            }
            sb = new StringBuilder();
            sb.append("Recv SECMSG errCode = ");
            sb.append(s4Var.b());
            sb.append(" errStr = ");
            m319a = s4Var.m468c();
        } else {
            if ("PING".equals(m461a)) {
                byte[] m465a = s4Var.m465a();
                if (m465a != null && m465a.length > 0) {
                    q3 a6 = q3.a(m465a);
                    if (a6.m424b()) {
                        h0.a().a(a6.m422a());
                    }
                }
                if (!"com.xiaomi.xmsf".equals(this.f7670a.getPackageName())) {
                    this.f7670a.m588a();
                }
                if ("1".equals(s4Var.d())) {
                    c.k.a.a.a.c.m6a("received a server ping");
                } else {
                    p6.b();
                }
                this.f7670a.m593b();
                return;
            }
            if ("SYNC".equals(m461a)) {
                if ("CONF".equals(s4Var.m467b())) {
                    h0.a().a(i3.a(s4Var.m465a()));
                    return;
                }
                if (TextUtils.equals("U", s4Var.m467b())) {
                    r3 a7 = r3.a(s4Var.m465a());
                    d2.a(this.f7670a).a(a7.m441a(), a7.m444b(), new Date(a7.m440a()), new Date(a7.m443b()), a7.c() * 1024, a7.e());
                    s4 s4Var2 = new s4();
                    s4Var2.a(0);
                    s4Var2.a(s4Var.m461a(), "UCA");
                    s4Var2.a(s4Var.d());
                    XMPushService xMPushService = this.f7670a;
                    xMPushService.a(new d0(xMPushService, s4Var2));
                    return;
                }
                if (!TextUtils.equals("P", s4Var.m467b())) {
                    return;
                }
                p3 a8 = p3.a(s4Var.m465a());
                s4 s4Var3 = new s4();
                s4Var3.a(0);
                s4Var3.a(s4Var.m461a(), "PCA");
                s4Var3.a(s4Var.d());
                p3 p3Var = new p3();
                if (a8.m332a()) {
                    p3Var.a(a8.m331a());
                }
                s4Var3.a(p3Var.m460a(), (String) null);
                XMPushService xMPushService2 = this.f7670a;
                xMPushService2.a(new d0(xMPushService2, s4Var3));
                sb = new StringBuilder();
                sb.append("ACK msgP: id = ");
                m319a = s4Var.d();
            } else {
                if (!"NOTIFY".equals(s4Var.m461a())) {
                    return;
                }
                o3 a9 = o3.a(s4Var.m465a());
                sb = new StringBuilder();
                sb.append("notify by server err = ");
                sb.append(a9.c());
                sb.append(" desc = ");
                m319a = a9.m319a();
            }
        }
        sb.append(m319a);
        str = sb.toString();
        c.k.a.a.a.c.m6a(str);
    }

    public final void c(s4 s4Var) {
        r.b a2;
        String f2 = s4Var.f();
        String num = Integer.toString(s4Var.a());
        if (TextUtils.isEmpty(f2) || TextUtils.isEmpty(num) || (a2 = r.a().a(num, f2)) == null) {
            return;
        }
        g6.a(this.f7670a, a2.f7677a, s4Var.c(), true, true, System.currentTimeMillis());
    }
}
