package c.k.d.p9;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import androidx.recyclerview.widget.RecyclerView;
import c.k.d.a2;
import c.k.d.d5;
import c.k.d.g6;
import c.k.d.g7;
import c.k.d.h8;
import c.k.d.j4;
import c.k.d.j7;
import c.k.d.l5;
import c.k.d.m7;
import c.k.d.o5;
import c.k.d.p9.b;
import c.k.d.p9.r;
import c.k.d.q5;
import c.k.d.q9;
import c.k.d.r5;
import c.k.d.s4;
import c.k.d.s7;
import c.k.d.v6;
import c.k.d.v7;
import cn.jpush.android.service.WakedResultReceiver;
import com.shix.shixipc.activity.AddCameraActivity;
import com.xiaomi.push.service.XMPushService;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;

/* loaded from: classes.dex */
public class o1 {
    public static Intent a(byte[] bArr, long j) {
        s7 a2 = a(bArr);
        if (a2 == null) {
            return null;
        }
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.putExtra("mipush_payload", bArr);
        intent.putExtra("mrt", Long.toString(j));
        intent.setPackage(a2.f7851b);
        return intent;
    }

    public static s7 a(Context context, s7 s7Var) {
        m7 m7Var = new m7();
        m7Var.b(s7Var.m470a());
        j7 a2 = s7Var.a();
        if (a2 != null) {
            m7Var.a(a2.m246a());
            m7Var.a(a2.m244a());
            if (!TextUtils.isEmpty(a2.m251b())) {
                m7Var.c(a2.m251b());
            }
        }
        m7Var.a(h8.a(context, s7Var));
        s7 a3 = w1.a(s7Var.b(), s7Var.m470a(), m7Var, v6.AckMessage);
        j7 m245a = s7Var.a().m245a();
        m245a.a("mat", Long.toString(System.currentTimeMillis()));
        a3.a(m245a);
        return a3;
    }

    public static s7 a(byte[] bArr) {
        s7 s7Var = new s7();
        try {
            h8.a(s7Var, bArr);
            return s7Var;
        } catch (Throwable th) {
            c.k.a.a.a.c.a(th);
            return null;
        }
    }

    public static void a(XMPushService xMPushService, s7 s7Var) {
        xMPushService.a(new p1(4, xMPushService, s7Var));
    }

    public static void a(XMPushService xMPushService, s7 s7Var, String str) {
        xMPushService.a(new u1(4, xMPushService, s7Var, str));
    }

    public static void a(XMPushService xMPushService, s7 s7Var, String str, String str2) {
        xMPushService.a(new v1(4, xMPushService, s7Var, str, str2));
    }

    public static void a(XMPushService xMPushService, String str, byte[] bArr, Intent intent) {
        j4 a2;
        String b2;
        String m246a;
        int i2;
        String str2;
        String str3;
        j4 a3;
        String b3;
        String b4;
        String m246a2;
        String str4;
        boolean z;
        s7 a4 = a(bArr);
        j7 a5 = a4.a();
        if (bArr != null) {
            a2.a(a4.b(), xMPushService.getApplicationContext(), null, a4.m469a(), bArr.length);
        }
        if (c(a4) && a(xMPushService, str)) {
            if (b.e(a4)) {
                j4.a(xMPushService.getApplicationContext()).a(a4.b(), b.b(a4), a5.m246a(), "5");
            }
            c(xMPushService, a4);
            return;
        }
        if (a(a4) && !a(xMPushService, str) && !b(a4)) {
            if (b.e(a4)) {
                j4.a(xMPushService.getApplicationContext()).a(a4.b(), b.b(a4), a5.m246a(), "6");
            }
            d(xMPushService, a4);
            return;
        }
        if ((!b.m359a(a4) || !d5.m130b((Context) xMPushService, a4.f7851b)) && !a(xMPushService, intent)) {
            if (!d5.m130b((Context) xMPushService, a4.f7851b)) {
                if (b.e(a4)) {
                    j4.a(xMPushService.getApplicationContext()).b(a4.b(), b.b(a4), a5.m246a(), WakedResultReceiver.WAKE_TYPE_KEY);
                }
                a(xMPushService, a4);
                return;
            } else {
                c.k.a.a.a.c.m6a("receive a mipush message, we can see the app, but we can't see the receiver.");
                if (b.e(a4)) {
                    j4.a(xMPushService.getApplicationContext()).b(a4.b(), b.b(a4), a5.m246a(), "3");
                    return;
                }
                return;
            }
        }
        if (v6.Registration == a4.m469a()) {
            String b5 = a4.b();
            SharedPreferences.Editor edit = xMPushService.getSharedPreferences("pref_registered_pkg_names", 0).edit();
            edit.putString(b5, a4.f95a);
            edit.commit();
            j4.a(xMPushService.getApplicationContext()).a(b5, "E100003", a5.m246a(), 6003, null);
            if (!TextUtils.isEmpty(a5.m246a())) {
                intent.putExtra("messageId", a5.m246a());
                intent.putExtra("eventMessageType", 6000);
            }
        }
        if (b.c(a4)) {
            j4.a(xMPushService.getApplicationContext()).a(a4.b(), b.b(a4), a5.m246a(), 1001, System.currentTimeMillis(), null);
            if (!TextUtils.isEmpty(a5.m246a())) {
                intent.putExtra("messageId", a5.m246a());
                intent.putExtra("eventMessageType", 1000);
            }
        }
        if (b.m363b(a4)) {
            j4.a(xMPushService.getApplicationContext()).a(a4.b(), b.b(a4), a5.m246a(), 2001, System.currentTimeMillis(), null);
            if (!TextUtils.isEmpty(a5.m246a())) {
                intent.putExtra("messageId", a5.m246a());
                intent.putExtra("eventMessageType", RecyclerView.MAX_SCROLL_DURATION);
            }
        }
        if (b.m359a(a4)) {
            j4.a(xMPushService.getApplicationContext()).a(a4.b(), b.b(a4), a5.m246a(), 3001, System.currentTimeMillis(), null);
            if (!TextUtils.isEmpty(a5.m246a())) {
                intent.putExtra("messageId", a5.m246a());
                intent.putExtra("eventMessageType", AddCameraActivity.SEARCH_TIME);
            }
        }
        if (a5 != null && !TextUtils.isEmpty(a5.m254c()) && !TextUtils.isEmpty(a5.d()) && a5.f7297b != 1 && (b.m360a(a5.m247a()) || !b.m358a((Context) xMPushService, a4.f7851b))) {
            if (a5 != null) {
                Map<String, String> map = a5.f46a;
                r1 = map != null ? map.get("jobkey") : null;
                if (TextUtils.isEmpty(r1)) {
                    r1 = a5.m246a();
                }
                z = d.a(xMPushService, a4.f7851b, r1);
            } else {
                z = false;
            }
            if (z) {
                j4.a(xMPushService.getApplicationContext()).c(a4.b(), b.b(a4), a5.m246a(), "1:" + r1);
                c.k.a.a.a.c.m6a("drop a duplicate message, key=" + r1);
            } else {
                b.c m356a = b.m356a((Context) xMPushService, a4, bArr);
                if (m356a.f7541b > 0 && !TextUtils.isEmpty(m356a.f7540a)) {
                    g6.a(xMPushService, m356a.f7540a, m356a.f7541b, true, false, System.currentTimeMillis());
                }
                if (!b.m359a(a4)) {
                    Intent intent2 = new Intent("com.xiaomi.mipush.MESSAGE_ARRIVED");
                    intent2.putExtra("mipush_payload", bArr);
                    intent2.setPackage(a4.f7851b);
                    try {
                        List<ResolveInfo> queryBroadcastReceivers = xMPushService.getPackageManager().queryBroadcastReceivers(intent2, 0);
                        if (queryBroadcastReceivers != null && !queryBroadcastReceivers.isEmpty()) {
                            xMPushService.sendBroadcast(intent2, w1.a(a4.f7851b));
                        }
                    } catch (Exception unused) {
                        xMPushService.sendBroadcast(intent2, w1.a(a4.f7851b));
                        j4.a(xMPushService.getApplicationContext()).b(a4.b(), b.b(a4), a5.m246a(), "1");
                    }
                }
            }
            b(xMPushService, a4);
        } else if ("com.xiaomi.xmsf".contains(a4.f7851b) && !a4.m477b() && a5 != null && a5.m247a() != null && a5.m247a().containsKey("ab")) {
            b(xMPushService, a4);
            c.k.a.a.a.c.c("receive abtest message. ack it." + a5.m246a());
        } else if (a(xMPushService, str, a4, a5)) {
            if (a5 != null && !TextUtils.isEmpty(a5.m246a())) {
                if (b.m363b(a4)) {
                    a2 = j4.a(xMPushService.getApplicationContext());
                    b2 = a4.b();
                    str3 = b.b(a4);
                    m246a = a5.m246a();
                    i2 = 2002;
                    str2 = null;
                } else {
                    if (b.m359a(a4)) {
                        a3 = j4.a(xMPushService.getApplicationContext());
                        b3 = a4.b();
                        b4 = b.b(a4);
                        m246a2 = a5.m246a();
                        str4 = "7";
                    } else if (b.c(a4)) {
                        a3 = j4.a(xMPushService.getApplicationContext());
                        b3 = a4.b();
                        b4 = b.b(a4);
                        m246a2 = a5.m246a();
                        str4 = "8";
                    } else if (b.d(a4)) {
                        a2 = j4.a(xMPushService.getApplicationContext());
                        b2 = a4.b();
                        m246a = a5.m246a();
                        i2 = 6004;
                        str2 = null;
                        str3 = "E100003";
                    }
                    a3.a(b3, b4, m246a2, str4);
                }
                a2.a(b2, str3, m246a, i2, str2);
            }
            xMPushService.sendBroadcast(intent, w1.a(a4.f7851b));
        } else {
            j4.a(xMPushService.getApplicationContext()).a(a4.b(), b.b(a4), a5.m246a(), "9");
        }
        if (a4.m469a() != v6.UnRegistration || "com.xiaomi.xmsf".equals(xMPushService.getPackageName())) {
            return;
        }
        xMPushService.stopSelf();
    }

    public static void a(XMPushService xMPushService, byte[] bArr, long j) {
        Map<String, String> m247a;
        s7 a2 = a(bArr);
        if (a2 == null) {
            return;
        }
        if (TextUtils.isEmpty(a2.f7851b)) {
            c.k.a.a.a.c.m6a("receive a mipush message without package name");
            return;
        }
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        Intent a3 = a(bArr, valueOf.longValue());
        String a4 = b.a(a2);
        g6.a(xMPushService, a4, j, true, true, System.currentTimeMillis());
        j7 a5 = a2.a();
        if (a5 != null) {
            a5.a("mrt", Long.toString(valueOf.longValue()));
        }
        String str = "";
        if (v6.SendMessage == a2.m469a() && k1.a(xMPushService).m398a(a2.f7851b) && !b.m359a(a2)) {
            if (a5 != null) {
                str = a5.m246a();
                if (b.e(a2)) {
                    j4.a(xMPushService.getApplicationContext()).a(a2.b(), b.b(a2), str, "1");
                }
            }
            c.k.a.a.a.c.m6a("Drop a message for unregistered, msgid=" + str);
            a(xMPushService, a2, a2.f7851b);
            return;
        }
        if (v6.SendMessage == a2.m469a() && k1.a(xMPushService).m400c(a2.f7851b) && !b.m359a(a2)) {
            if (a5 != null) {
                str = a5.m246a();
                if (b.e(a2)) {
                    j4.a(xMPushService.getApplicationContext()).a(a2.b(), b.b(a2), str, WakedResultReceiver.WAKE_TYPE_KEY);
                }
            }
            c.k.a.a.a.c.m6a("Drop a message for push closed, msgid=" + str);
            a(xMPushService, a2, a2.f7851b);
            return;
        }
        if (v6.SendMessage == a2.m469a() && !TextUtils.equals(xMPushService.getPackageName(), "com.xiaomi.xmsf") && !TextUtils.equals(xMPushService.getPackageName(), a2.f7851b)) {
            c.k.a.a.a.c.m6a("Receive a message with wrong package name, expect " + xMPushService.getPackageName() + ", received " + a2.f7851b);
            a(xMPushService, a2, "unmatched_package", "package should be " + xMPushService.getPackageName() + ", but got " + a2.f7851b);
            if (a5 == null || !b.e(a2)) {
                return;
            }
            j4.a(xMPushService.getApplicationContext()).a(a2.b(), b.b(a2), a5.m246a(), "3");
            return;
        }
        if (a5 != null && a5.m246a() != null) {
            c.k.a.a.a.c.m6a(String.format("receive a message, appid=%1$s, msgid= %2$s", a2.m470a(), a5.m246a()));
        }
        if (a5 != null && (m247a = a5.m247a()) != null && m247a.containsKey("hide") && "true".equalsIgnoreCase(m247a.get("hide"))) {
            b(xMPushService, a2);
            return;
        }
        if (a5 != null && a5.m247a() != null && a5.m247a().containsKey("__miid")) {
            String str2 = a5.m247a().get("__miid");
            String a6 = q9.a(xMPushService.getApplicationContext());
            if (TextUtils.isEmpty(a6) || !TextUtils.equals(str2, a6)) {
                if (b.e(a2)) {
                    j4.a(xMPushService.getApplicationContext()).a(a2.b(), b.b(a2), a5.m246a(), "4");
                }
                c.k.a.a.a.c.m6a(str2 + " should be login, but got " + a6);
                a(xMPushService, a2, "miid already logout or anther already login", str2 + " should be login, but got " + a6);
                return;
            }
        }
        a(xMPushService, a4, bArr, a3);
    }

    public static boolean a(Context context, Intent intent) {
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 32);
            if (queryBroadcastReceivers != null) {
                if (!queryBroadcastReceivers.isEmpty()) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    public static boolean a(Context context, String str) {
        Intent intent = new Intent("com.xiaomi.mipush.miui.CLICK_MESSAGE");
        intent.setPackage(str);
        Intent intent2 = new Intent("com.xiaomi.mipush.miui.RECEIVE_MESSAGE");
        intent2.setPackage(str);
        PackageManager packageManager = context.getPackageManager();
        try {
            List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 32);
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 32);
            if (queryBroadcastReceivers.isEmpty()) {
                if (queryIntentServices.isEmpty()) {
                    return false;
                }
            }
            return true;
        } catch (Exception e2) {
            c.k.a.a.a.c.a(e2);
            return false;
        }
    }

    public static boolean a(s7 s7Var) {
        return "com.xiaomi.xmsf".equals(s7Var.f7851b) && s7Var.a() != null && s7Var.a().m247a() != null && s7Var.a().m247a().containsKey("miui_package_name");
    }

    public static boolean a(XMPushService xMPushService, String str, s7 s7Var, j7 j7Var) {
        boolean z = true;
        if (j7Var != null && j7Var.m247a() != null && j7Var.m247a().containsKey("__check_alive") && j7Var.m247a().containsKey("__awake")) {
            v7 v7Var = new v7();
            v7Var.b(s7Var.m470a());
            v7Var.d(str);
            v7Var.c(g7.AwakeSystemApp.f30a);
            v7Var.a(j7Var.m246a());
            v7Var.f105a = new HashMap();
            boolean m129a = d5.m129a(xMPushService.getApplicationContext(), str);
            v7Var.f105a.put("app_running", Boolean.toString(m129a));
            if (!m129a) {
                boolean parseBoolean = Boolean.parseBoolean(j7Var.m247a().get("__awake"));
                v7Var.f105a.put("awaked", Boolean.toString(parseBoolean));
                if (!parseBoolean) {
                    z = false;
                }
            }
            try {
                w1.a(xMPushService, w1.a(s7Var.b(), s7Var.m470a(), v7Var, v6.Notification));
            } catch (l5 e2) {
                c.k.a.a.a.c.a(e2);
            }
        }
        return z;
    }

    public static void b(XMPushService xMPushService, s7 s7Var) {
        xMPushService.a(new q1(4, xMPushService, s7Var));
    }

    public static boolean b(s7 s7Var) {
        Map<String, String> m247a = s7Var.a().m247a();
        return m247a != null && m247a.containsKey("notify_effect");
    }

    public static void c(XMPushService xMPushService, s7 s7Var) {
        xMPushService.a(new s1(4, xMPushService, s7Var));
    }

    public static boolean c(s7 s7Var) {
        if (s7Var.a() == null || s7Var.a().m247a() == null) {
            return false;
        }
        return "1".equals(s7Var.a().m247a().get("obslete_ads_message"));
    }

    public static void d(XMPushService xMPushService, s7 s7Var) {
        xMPushService.a(new t1(4, xMPushService, s7Var));
    }

    public void a(Context context, r.b bVar, boolean z, int i2, String str) {
        i1 a2;
        if (z || (a2 = j1.a(context)) == null || !"token-expired".equals(str)) {
            return;
        }
        try {
            j1.a(context, a2.f7611f, a2.f7609d, a2.f7610e);
        } catch (IOException | JSONException e2) {
            c.k.a.a.a.c.a(e2);
        }
    }

    public void a(XMPushService xMPushService, r5 r5Var, r.b bVar) {
        if (!(r5Var instanceof q5)) {
            c.k.a.a.a.c.m6a("not a mipush message");
            return;
        }
        q5 q5Var = (q5) r5Var;
        o5 a2 = q5Var.a("s");
        if (a2 != null) {
            try {
                a(xMPushService, a0.a(a0.a(bVar.f7685i, q5Var.c()), a2.c()), g6.a(r5Var.mo336a()));
            } catch (IllegalArgumentException e2) {
                c.k.a.a.a.c.a(e2);
            }
        }
    }

    public void a(XMPushService xMPushService, s4 s4Var, r.b bVar) {
        try {
            a(xMPushService, s4Var.m466a(bVar.f7685i), s4Var.c());
        } catch (IllegalArgumentException e2) {
            c.k.a.a.a.c.a(e2);
        }
    }
}
