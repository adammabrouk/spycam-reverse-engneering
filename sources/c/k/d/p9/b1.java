package c.k.d.p9;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import c.k.d.g9;
import c.k.d.p5;
import c.k.d.p9.r;
import c.k.d.q5;
import c.k.d.r5;
import c.k.d.s4;
import c.k.d.t5;
import com.xiaomi.push.service.XMPushService;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
public class b1 {

    /* renamed from: a, reason: collision with root package name */
    public o1 f7545a = new o1();

    public static String a(r.b bVar) {
        StringBuilder sb;
        String str;
        if ("9".equals(bVar.f7684h)) {
            sb = new StringBuilder();
            sb.append(bVar.f7677a);
            str = ".permission.MIMC_RECEIVE";
        } else {
            sb = new StringBuilder();
            sb.append(bVar.f7677a);
            str = ".permission.MIPUSH_RECEIVE";
        }
        sb.append(str);
        return sb.toString();
    }

    public static void a(Context context, Intent intent, r.b bVar) {
        if ("com.xiaomi.xmsf".equals(context.getPackageName())) {
            context.sendBroadcast(intent);
        } else {
            context.sendBroadcast(intent, a(bVar));
        }
    }

    public r.b a(r5 r5Var) {
        Collection<r.b> m403a = r.a().m403a(r5Var.d());
        if (m403a.isEmpty()) {
            return null;
        }
        Iterator<r.b> it = m403a.iterator();
        if (m403a.size() == 1) {
            return it.next();
        }
        String f2 = r5Var.f();
        String e2 = r5Var.e();
        while (it.hasNext()) {
            r.b next = it.next();
            if (TextUtils.equals(f2, next.f7678b) || TextUtils.equals(e2, next.f7678b)) {
                return next;
            }
        }
        return null;
    }

    public r.b a(s4 s4Var) {
        Collection<r.b> m403a = r.a().m403a(Integer.toString(s4Var.a()));
        if (m403a.isEmpty()) {
            return null;
        }
        Iterator<r.b> it = m403a.iterator();
        if (m403a.size() == 1) {
            return it.next();
        }
        String f2 = s4Var.f();
        while (it.hasNext()) {
            r.b next = it.next();
            if (TextUtils.equals(f2, next.f7678b)) {
                return next;
            }
        }
        return null;
    }

    @SuppressLint({"WrongConstant"})
    public void a(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.service_started");
        if (g9.c()) {
            intent.addFlags(16777216);
        }
        context.sendBroadcast(intent);
    }

    public void a(Context context, r.b bVar, int i2) {
        if ("5".equalsIgnoreCase(bVar.f7684h)) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.channel_closed");
        intent.setPackage(bVar.f7677a);
        intent.putExtra(v.p, bVar.f7684h);
        intent.putExtra("ext_reason", i2);
        intent.putExtra(v.n, bVar.f7678b);
        intent.putExtra(v.z, bVar.j);
        if (bVar.r == null || !"9".equals(bVar.f7684h)) {
            a(context, intent, bVar);
            return;
        }
        try {
            bVar.r.send(Message.obtain(null, 17, intent));
        } catch (RemoteException unused) {
            bVar.r = null;
            StringBuilder sb = new StringBuilder();
            sb.append("peer may died: ");
            String str = bVar.f7678b;
            sb.append(str.substring(str.lastIndexOf(64)));
            c.k.a.a.a.c.m6a(sb.toString());
        }
    }

    public void a(Context context, r.b bVar, String str, String str2) {
        if ("5".equalsIgnoreCase(bVar.f7684h)) {
            c.k.a.a.a.c.d("mipush kicked by server");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.kicked");
        intent.setPackage(bVar.f7677a);
        intent.putExtra("ext_kick_type", str);
        intent.putExtra("ext_kick_reason", str2);
        intent.putExtra("ext_chid", bVar.f7684h);
        intent.putExtra(v.n, bVar.f7678b);
        intent.putExtra(v.z, bVar.j);
        a(context, intent, bVar);
    }

    public void a(Context context, r.b bVar, boolean z, int i2, String str) {
        if ("5".equalsIgnoreCase(bVar.f7684h)) {
            this.f7545a.a(context, bVar, z, i2, str);
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.channel_opened");
        intent.setPackage(bVar.f7677a);
        intent.putExtra("ext_succeeded", z);
        if (!z) {
            intent.putExtra("ext_reason", i2);
        }
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("ext_reason_msg", str);
        }
        intent.putExtra("ext_chid", bVar.f7684h);
        intent.putExtra(v.n, bVar.f7678b);
        intent.putExtra(v.z, bVar.j);
        a(context, intent, bVar);
    }

    public void a(XMPushService xMPushService, String str, r5 r5Var) {
        String str2;
        String str3;
        r.b a2 = a(r5Var);
        if (a2 != null) {
            if ("5".equalsIgnoreCase(str)) {
                this.f7545a.a(xMPushService, r5Var, a2);
                return;
            }
            String str4 = a2.f7677a;
            if (r5Var instanceof q5) {
                str3 = "com.xiaomi.push.new_msg";
            } else if (r5Var instanceof p5) {
                str3 = "com.xiaomi.push.new_iq";
            } else if (r5Var instanceof t5) {
                str3 = "com.xiaomi.push.new_pres";
            } else {
                str2 = "unknown packet type, drop it";
            }
            Intent intent = new Intent();
            intent.setAction(str3);
            intent.setPackage(str4);
            intent.putExtra("ext_chid", str);
            intent.putExtra("ext_packet", r5Var.a());
            intent.putExtra(v.z, a2.j);
            intent.putExtra(v.s, a2.f7685i);
            a(xMPushService, intent, a2);
            return;
        }
        str2 = "error while notify channel closed! channel " + str + " not registered";
        c.k.a.a.a.c.d(str2);
    }

    public void a(XMPushService xMPushService, String str, s4 s4Var) {
        r.b a2 = a(s4Var);
        if (a2 == null) {
            c.k.a.a.a.c.d("error while notify channel closed! channel " + str + " not registered");
            return;
        }
        if ("5".equalsIgnoreCase(str)) {
            this.f7545a.a(xMPushService, s4Var, a2);
            return;
        }
        String str2 = a2.f7677a;
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.new_msg");
        intent.setPackage(str2);
        intent.putExtra("ext_chid", str);
        intent.putExtra("ext_raw_packet", s4Var.m466a(a2.f7685i));
        intent.putExtra(v.z, a2.j);
        intent.putExtra(v.s, a2.f7685i);
        if (a2.r != null) {
            try {
                a2.r.send(Message.obtain(null, 17, intent));
                return;
            } catch (RemoteException unused) {
                a2.r = null;
                StringBuilder sb = new StringBuilder();
                sb.append("peer may died: ");
                String str3 = a2.f7678b;
                sb.append(str3.substring(str3.lastIndexOf(64)));
                c.k.a.a.a.c.m6a(sb.toString());
            }
        }
        if ("com.xiaomi.xmsf".equals(str2)) {
            return;
        }
        a(xMPushService, intent, a2);
    }
}
