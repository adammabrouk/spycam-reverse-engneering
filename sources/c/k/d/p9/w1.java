package c.k.d.p9;

import android.content.Context;
import android.os.Messenger;
import android.text.TextUtils;
import c.k.d.a2;
import c.k.d.h8;
import c.k.d.i8;
import c.k.d.j7;
import c.k.d.l5;
import c.k.d.l7;
import c.k.d.n8;
import c.k.d.p9.r;
import c.k.d.r5;
import c.k.d.s4;
import c.k.d.s7;
import c.k.d.v6;
import c.k.d.v7;
import c.k.d.z4;
import com.xiaomi.push.service.XMPushService;
import java.nio.ByteBuffer;
import java.util.Map;

/* loaded from: classes.dex */
public final class w1 {
    public static s4 a(i1 i1Var, Context context, s7 s7Var) {
        try {
            s4 s4Var = new s4();
            s4Var.a(5);
            s4Var.c(i1Var.f7606a);
            s4Var.b(a(s7Var));
            s4Var.a("SECMSG", "message");
            String str = i1Var.f7606a;
            s7Var.f93a.f55a = str.substring(0, str.indexOf("@"));
            s7Var.f93a.f7359c = str.substring(str.indexOf("/") + 1);
            s4Var.a(h8.a(s7Var), i1Var.f7608c);
            s4Var.a((short) 1);
            c.k.a.a.a.c.m6a("try send mi push message. packagename:" + s7Var.f7851b + " action:" + s7Var.f94a);
            return s4Var;
        } catch (NullPointerException e2) {
            c.k.a.a.a.c.a(e2);
            return null;
        }
    }

    public static s4 a(XMPushService xMPushService, byte[] bArr) {
        s7 s7Var = new s7();
        try {
            h8.a(s7Var, bArr);
            return a(j1.a((Context) xMPushService), xMPushService, s7Var);
        } catch (n8 e2) {
            c.k.a.a.a.c.a(e2);
            return null;
        }
    }

    public static s7 a(String str, String str2) {
        v7 v7Var = new v7();
        v7Var.b(str2);
        v7Var.c("package uninstalled");
        v7Var.a(r5.j());
        v7Var.a(false);
        return a(str, str2, v7Var, v6.Notification);
    }

    public static <T extends i8<T, ?>> s7 a(String str, String str2, T t, v6 v6Var) {
        byte[] a2 = h8.a(t);
        s7 s7Var = new s7();
        l7 l7Var = new l7();
        l7Var.f7357a = 5L;
        l7Var.f55a = "fakeid";
        s7Var.a(l7Var);
        s7Var.a(ByteBuffer.wrap(a2));
        s7Var.a(v6Var);
        s7Var.b(true);
        s7Var.b(str);
        s7Var.a(false);
        s7Var.a(str2);
        return s7Var;
    }

    public static String a(s7 s7Var) {
        Map<String, String> map;
        j7 j7Var = s7Var.f7850a;
        if (j7Var != null && (map = j7Var.f49b) != null) {
            String str = map.get("ext_traffic_source_pkg");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return s7Var.f7851b;
    }

    public static String a(String str) {
        return str + ".permission.MIPUSH_RECEIVE";
    }

    public static void a(XMPushService xMPushService) {
        i1 a2 = j1.a(xMPushService.getApplicationContext());
        if (a2 != null) {
            r.b a3 = j1.a(xMPushService.getApplicationContext()).a(xMPushService);
            a(xMPushService, a3);
            r.a().a(a3);
            j0.a(xMPushService).a(new x1("GAID", 172800L, xMPushService, a2));
            a(xMPushService, a2, 172800);
        }
    }

    public static void a(XMPushService xMPushService, i1 i1Var, int i2) {
        j0.a(xMPushService).a(new y1("MSAID", i2, xMPushService, i1Var));
    }

    public static void a(XMPushService xMPushService, r.b bVar) {
        bVar.a((Messenger) null);
        bVar.a(new z1(xMPushService));
    }

    public static void a(XMPushService xMPushService, s7 s7Var) {
        a2.a(s7Var.b(), xMPushService.getApplicationContext(), s7Var, -1);
        z4 m586a = xMPushService.m586a();
        if (m586a == null) {
            throw new l5("try send msg while connection is null.");
        }
        if (!m586a.mo545a()) {
            throw new l5("Don't support XMPP connection.");
        }
        s4 a2 = a(j1.a((Context) xMPushService), xMPushService, s7Var);
        if (a2 != null) {
            m586a.a(a2);
        }
    }

    public static void a(XMPushService xMPushService, String str, byte[] bArr) {
        a2.a(str, xMPushService.getApplicationContext(), bArr);
        z4 m586a = xMPushService.m586a();
        if (m586a == null) {
            throw new l5("try send msg while connection is null.");
        }
        if (!m586a.mo545a()) {
            throw new l5("Don't support XMPP connection.");
        }
        s4 a2 = a(xMPushService, bArr);
        if (a2 != null) {
            m586a.a(a2);
        } else {
            n1.a(xMPushService, str, bArr, 70000003, "not a valid message");
        }
    }
}
