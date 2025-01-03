package c.k.c.a;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import c.k.d.a2;
import c.k.d.a7;
import c.k.d.b8;
import c.k.d.d8;
import c.k.d.f7;
import c.k.d.f8;
import c.k.d.g7;
import c.k.d.h8;
import c.k.d.i4;
import c.k.d.i7;
import c.k.d.i8;
import c.k.d.j4;
import c.k.d.j7;
import c.k.d.k7;
import c.k.d.m7;
import c.k.d.n4;
import c.k.d.n7;
import c.k.d.n8;
import c.k.d.n9;
import c.k.d.r7;
import c.k.d.s7;
import c.k.d.t7;
import c.k.d.u7;
import c.k.d.v6;
import c.k.d.v7;
import c.k.d.x7;
import c.k.d.z7;
import cn.jpush.android.service.WakedResultReceiver;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TimeZone;

/* loaded from: classes.dex */
public class f0 {

    /* renamed from: b, reason: collision with root package name */
    public static f0 f6821b;

    /* renamed from: c, reason: collision with root package name */
    public static Queue<String> f6822c;

    /* renamed from: d, reason: collision with root package name */
    public static Object f6823d = new Object();

    /* renamed from: a, reason: collision with root package name */
    public Context f6824a;

    public f0(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f6824a = applicationContext;
        if (applicationContext == null) {
            this.f6824a = context;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x013b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.content.Intent a(android.content.Context r6, java.lang.String r7, java.util.Map<java.lang.String, java.lang.String> r8) {
        /*
            Method dump skipped, instructions count: 383
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.k.c.a.f0.a(android.content.Context, java.lang.String, java.util.Map):android.content.Intent");
    }

    public static f0 a(Context context) {
        if (f6821b == null) {
            f6821b = new f0(context);
        }
        return f6821b;
    }

    public static boolean a(Context context, String str) {
        synchronized (f6823d) {
            q0.m45a(context);
            SharedPreferences a2 = q0.a(context);
            if (f6822c == null) {
                String[] split = a2.getString("pref_msg_ids", "").split(",");
                f6822c = new LinkedList();
                for (String str2 : split) {
                    f6822c.add(str2);
                }
            }
            if (f6822c.contains(str)) {
                return true;
            }
            f6822c.add(str);
            if (f6822c.size() > 25) {
                f6822c.poll();
            }
            String a3 = c.k.d.k0.a(f6822c, ",");
            SharedPreferences.Editor edit = a2.edit();
            edit.putString("pref_msg_ids", a3);
            n9.a(edit);
            return false;
        }
    }

    public PushMessageHandler.a a(Intent intent) {
        String str;
        j4 a2;
        String packageName;
        String str2;
        j4 a3;
        String packageName2;
        String format;
        String action = intent.getAction();
        c.k.a.a.a.c.m6a("receive an intent from server, action=" + action);
        String stringExtra = intent.getStringExtra("mrt");
        if (stringExtra == null) {
            stringExtra = Long.toString(System.currentTimeMillis());
        }
        String stringExtra2 = intent.getStringExtra("messageId");
        int intExtra = intent.getIntExtra("eventMessageType", -1);
        if ("com.xiaomi.mipush.RECEIVE_MESSAGE".equals(action)) {
            byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
            boolean booleanExtra = intent.getBooleanExtra("mipush_notified", false);
            if (byteArrayExtra == null) {
                c.k.a.a.a.c.d("receiving an empty message, drop");
                j4.a(this.f6824a).a(this.f6824a.getPackageName(), intent, "12");
                return null;
            }
            s7 s7Var = new s7();
            try {
                h8.a(s7Var, byteArrayExtra);
                q0 m45a = q0.m45a(this.f6824a);
                j7 a4 = s7Var.a();
                if (s7Var.m469a() == v6.SendMessage && a4 != null && !m45a.m53d() && !booleanExtra) {
                    a4.a("mrt", stringExtra);
                    a4.a("mat", Long.toString(System.currentTimeMillis()));
                    if (m19a(s7Var)) {
                        c.k.a.a.a.c.b("this is a mina's message, ack later");
                        a4.a("__hybrid_message_ts", String.valueOf(a4.m244a()));
                        a4.a("__hybrid_device_status", String.valueOf((int) h8.a(this.f6824a, s7Var)));
                    } else {
                        b(s7Var);
                    }
                }
                if (s7Var.m469a() == v6.SendMessage && !s7Var.m477b()) {
                    if (c.k.d.p9.b.m359a(s7Var)) {
                        Object[] objArr = new Object[2];
                        objArr[0] = s7Var.b();
                        objArr[1] = a4 != null ? a4.m246a() : "";
                        c.k.a.a.a.c.m6a(String.format("drop an un-encrypted wake-up messages. %1$s, %2$s", objArr));
                        a3 = j4.a(this.f6824a);
                        packageName2 = this.f6824a.getPackageName();
                        format = String.format("13: %1$s", s7Var.b());
                    } else {
                        Object[] objArr2 = new Object[2];
                        objArr2[0] = s7Var.b();
                        objArr2[1] = a4 != null ? a4.m246a() : "";
                        c.k.a.a.a.c.m6a(String.format("drop an un-encrypted messages. %1$s, %2$s", objArr2));
                        a3 = j4.a(this.f6824a);
                        packageName2 = this.f6824a.getPackageName();
                        format = String.format("14: %1$s", s7Var.b());
                    }
                    a3.a(packageName2, intent, format);
                    return null;
                }
                if (s7Var.m469a() == v6.SendMessage && s7Var.m477b() && c.k.d.p9.b.m359a(s7Var) && (!booleanExtra || a4 == null || a4.m247a() == null || !a4.m247a().containsKey("notify_effect"))) {
                    Object[] objArr3 = new Object[2];
                    objArr3[0] = s7Var.b();
                    objArr3[1] = a4 != null ? a4.m246a() : "";
                    c.k.a.a.a.c.m6a(String.format("drop a wake-up messages which not has 'notify_effect' attr. %1$s, %2$s", objArr3));
                    j4.a(this.f6824a).a(this.f6824a.getPackageName(), intent, String.format("25: %1$s", s7Var.b()));
                    return null;
                }
                if (m45a.m52c() || s7Var.f94a == v6.Registration) {
                    if (!m45a.m52c() || !m45a.m54e()) {
                        return a(s7Var, booleanExtra, byteArrayExtra, stringExtra2, intExtra);
                    }
                    if (s7Var.f94a == v6.UnRegistration) {
                        m45a.m47a();
                        l.d(this.f6824a);
                        PushMessageHandler.a();
                    } else {
                        l.G(this.f6824a);
                    }
                } else {
                    if (c.k.d.p9.b.m359a(s7Var)) {
                        return a(s7Var, booleanExtra, byteArrayExtra, stringExtra2, intExtra);
                    }
                    c.k.a.a.a.c.d("receive message without registration. need re-register!");
                    j4.a(this.f6824a).a(this.f6824a.getPackageName(), intent, "15");
                    a();
                }
            } catch (n8 e2) {
                e = e2;
                a2 = j4.a(this.f6824a);
                packageName = this.f6824a.getPackageName();
                str2 = "16";
                a2.a(packageName, intent, str2);
                c.k.a.a.a.c.a(e);
                return null;
            } catch (Exception e3) {
                e = e3;
                a2 = j4.a(this.f6824a);
                packageName = this.f6824a.getPackageName();
                str2 = "17";
                a2.a(packageName, intent, str2);
                c.k.a.a.a.c.a(e);
                return null;
            }
        } else {
            if ("com.xiaomi.mipush.ERROR".equals(action)) {
                n nVar = new n();
                s7 s7Var2 = new s7();
                try {
                    byte[] byteArrayExtra2 = intent.getByteArrayExtra("mipush_payload");
                    if (byteArrayExtra2 != null) {
                        h8.a(s7Var2, byteArrayExtra2);
                    }
                } catch (n8 unused) {
                }
                nVar.setCommand(String.valueOf(s7Var2.m469a()));
                nVar.setResultCode(intent.getIntExtra("mipush_error_code", 0));
                nVar.setReason(intent.getStringExtra("mipush_error_msg"));
                c.k.a.a.a.c.d("receive a error message. code = " + intent.getIntExtra("mipush_error_code", 0) + ", msg= " + intent.getStringExtra("mipush_error_msg"));
                return nVar;
            }
            if ("com.xiaomi.mipush.MESSAGE_ARRIVED".equals(action)) {
                byte[] byteArrayExtra3 = intent.getByteArrayExtra("mipush_payload");
                if (byteArrayExtra3 == null) {
                    c.k.a.a.a.c.d("message arrived: receiving an empty message, drop");
                    return null;
                }
                s7 s7Var3 = new s7();
                try {
                    h8.a(s7Var3, byteArrayExtra3);
                    q0 m45a2 = q0.m45a(this.f6824a);
                    if (c.k.d.p9.b.m359a(s7Var3)) {
                        str = "message arrived: receive ignore reg message, ignore!";
                    } else if (!m45a2.m52c()) {
                        str = "message arrived: receive message without registration. need unregister or re-register!";
                    } else {
                        if (!m45a2.m52c() || !m45a2.m54e()) {
                            return a(s7Var3, byteArrayExtra3);
                        }
                        str = "message arrived: app info is invalidated";
                    }
                    c.k.a.a.a.c.d(str);
                } catch (n8 | Exception e4) {
                    c.k.a.a.a.c.a(e4);
                }
            }
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final PushMessageHandler.a a(s7 s7Var, boolean z, byte[] bArr, String str, int i2) {
        j4 a2;
        String packageName;
        String m221a;
        int i3;
        String str2;
        o oVar = null;
        oVar = null;
        oVar = null;
        oVar = null;
        oVar = null;
        oVar = null;
        oVar = null;
        oVar = null;
        oVar = null;
        oVar = null;
        oVar = null;
        oVar = null;
        oVar = null;
        oVar = null;
        oVar = null;
        oVar = null;
        oVar = null;
        oVar = null;
        oVar = null;
        oVar = null;
        oVar = null;
        oVar = null;
        oVar = null;
        oVar = null;
        oVar = null;
        oVar = null;
        oVar = null;
        oVar = null;
        oVar = null;
        oVar = null;
        oVar = null;
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        oVar = null;
        ArrayList arrayList3 = null;
        oVar = null;
        try {
            i8 a3 = b0.a(this.f6824a, s7Var);
            if (a3 == null) {
                c.k.a.a.a.c.d("receiving an un-recognized message. " + s7Var.f94a);
                j4.a(this.f6824a).b(this.f6824a.getPackageName(), i4.m221a(i2), str, "18");
                return null;
            }
            v6 m469a = s7Var.m469a();
            c.k.a.a.a.c.m6a("processing a message, action=" + m469a);
            switch (h0.f6833a[m469a.ordinal()]) {
                case 1:
                    if (!s7Var.m477b()) {
                        c.k.a.a.a.c.d("receiving an un-encrypt message(SendMessage).");
                        return null;
                    }
                    if (q0.m45a(this.f6824a).m53d() && !z) {
                        c.k.a.a.a.c.m6a("receive a message in pause state. drop it");
                        j4.a(this.f6824a).a(this.f6824a.getPackageName(), i4.m221a(i2), str, "12");
                        return null;
                    }
                    z7 z7Var = (z7) a3;
                    i7 a4 = z7Var.a();
                    if (a4 == null) {
                        c.k.a.a.a.c.d("receive an empty message without push content, drop it");
                        j4.a(this.f6824a).b(this.f6824a.getPackageName(), i4.m221a(i2), str, "22");
                        return null;
                    }
                    if (z) {
                        if (c.k.d.p9.b.m359a(s7Var)) {
                            l.a(this.f6824a, a4.m225a(), s7Var.a(), s7Var.f7851b, a4.b());
                        } else {
                            l.a(this.f6824a, a4.m225a(), s7Var.a(), a4.b());
                        }
                    }
                    if (!z) {
                        if (!TextUtils.isEmpty(z7Var.d()) && l.e(this.f6824a, z7Var.d()) < 0) {
                            l.c(this.f6824a, z7Var.d());
                        } else if (!TextUtils.isEmpty(z7Var.c()) && l.i(this.f6824a, z7Var.c()) < 0) {
                            l.d(this.f6824a, z7Var.c());
                        }
                    }
                    j7 j7Var = s7Var.f7850a;
                    String str3 = (j7Var == null || j7Var.m247a() == null) ? null : s7Var.f7850a.f46a.get("jobkey");
                    if (TextUtils.isEmpty(str3)) {
                        str3 = a4.m225a();
                    }
                    if (z || !a(this.f6824a, str3)) {
                        o a5 = r.a(z7Var, s7Var.a(), z);
                        if (a5.getPassThrough() == 0 && !z && c.k.d.p9.b.m360a(a5.getExtra())) {
                            c.k.d.p9.b.m356a(this.f6824a, s7Var, bArr);
                            return null;
                        }
                        c.k.a.a.a.c.m6a("receive a message, msgid=" + a4.m225a() + ", jobkey=" + str3);
                        if (z && a5.getExtra() != null && a5.getExtra().containsKey("notify_effect")) {
                            Map<String, String> extra = a5.getExtra();
                            String str4 = extra.get("notify_effect");
                            if (c.k.d.p9.b.m359a(s7Var)) {
                                Intent a6 = a(this.f6824a, s7Var.f7851b, extra);
                                a6.putExtra("eventMessageType", i2);
                                a6.putExtra("messageId", str);
                                if (a6 == null) {
                                    c.k.a.a.a.c.m6a("Getting Intent fail from ignore reg message. ");
                                    j4.a(this.f6824a).b(this.f6824a.getPackageName(), i4.m221a(i2), str, "23");
                                    return null;
                                }
                                String c2 = a4.c();
                                if (!TextUtils.isEmpty(c2)) {
                                    a6.putExtra("payload", c2);
                                }
                                this.f6824a.startActivity(a6);
                                j4.a(this.f6824a).a(this.f6824a.getPackageName(), i4.m221a(i2), str, 3006, str4);
                            } else {
                                Context context = this.f6824a;
                                Intent a7 = a(context, context.getPackageName(), extra);
                                if (a7 != null) {
                                    if (!str4.equals(c.k.d.p9.v.f7714c)) {
                                        a7.putExtra("key_message", a5);
                                        a7.putExtra("eventMessageType", i2);
                                        a7.putExtra("messageId", str);
                                    }
                                    this.f6824a.startActivity(a7);
                                    c.k.a.a.a.c.m6a("start activity succ");
                                    j4.a(this.f6824a).a(this.f6824a.getPackageName(), i4.m221a(i2), str, 1006, str4);
                                    if (str4.equals(c.k.d.p9.v.f7714c)) {
                                        j4.a(this.f6824a).a(this.f6824a.getPackageName(), i4.m221a(i2), str, "13");
                                    }
                                }
                            }
                            return null;
                        }
                        oVar = a5;
                    } else {
                        c.k.a.a.a.c.m6a("drop a duplicate message, key=" + str3);
                        j4.a(this.f6824a).c(this.f6824a.getPackageName(), i4.m221a(i2), str, "2:" + str3);
                    }
                    if (s7Var.a() == null && !z) {
                        a(z7Var, s7Var);
                    }
                    return oVar;
                case 2:
                    x7 x7Var = (x7) a3;
                    String str5 = q0.m45a(this.f6824a).f6902d;
                    if (TextUtils.isEmpty(str5) || !TextUtils.equals(str5, x7Var.m528a())) {
                        c.k.a.a.a.c.m6a("bad Registration result:");
                        j4.a(this.f6824a).b(this.f6824a.getPackageName(), i4.m221a(i2), str, "21");
                        return null;
                    }
                    q0.m45a(this.f6824a).f6902d = null;
                    long j = x7Var.f121a;
                    Context context2 = this.f6824a;
                    if (j == 0) {
                        q0.m45a(context2).b(x7Var.f8019e, x7Var.f8020f, x7Var.l);
                        a2 = j4.a(this.f6824a);
                        packageName = this.f6824a.getPackageName();
                        m221a = i4.m221a(i2);
                        i3 = 6006;
                        str2 = "1";
                    } else {
                        a2 = j4.a(context2);
                        packageName = this.f6824a.getPackageName();
                        m221a = i4.m221a(i2);
                        i3 = 6006;
                        str2 = WakedResultReceiver.WAKE_TYPE_KEY;
                    }
                    a2.a(packageName, m221a, str, i3, str2);
                    if (!TextUtils.isEmpty(x7Var.f8019e)) {
                        arrayList3 = new ArrayList();
                        arrayList3.add(x7Var.f8019e);
                    }
                    n a8 = r.a(n4.COMMAND_REGISTER.f67a, arrayList3, x7Var.f121a, x7Var.f8018d, null);
                    i0.a(this.f6824a).m33d();
                    return a8;
                case 3:
                    if (((d8) a3).f7079a == 0) {
                        q0.m45a(this.f6824a).m47a();
                        l.d(this.f6824a);
                    }
                    PushMessageHandler.a();
                    return oVar;
                case 4:
                    b8 b8Var = (b8) a3;
                    if (b8Var.f6996a == 0) {
                        l.d(this.f6824a, b8Var.a());
                    }
                    if (!TextUtils.isEmpty(b8Var.a())) {
                        arrayList2 = new ArrayList();
                        arrayList2.add(b8Var.a());
                    }
                    return r.a(n4.COMMAND_SUBSCRIBE_TOPIC.f67a, arrayList2, b8Var.f6996a, b8Var.f6999d, b8Var.b());
                case 5:
                    f8 f8Var = (f8) a3;
                    if (f8Var.f7132a == 0) {
                        l.h(this.f6824a, f8Var.a());
                    }
                    if (!TextUtils.isEmpty(f8Var.a())) {
                        arrayList = new ArrayList();
                        arrayList.add(f8Var.a());
                    }
                    return r.a(n4.COMMAND_UNSUBSCRIBE_TOPIC.f67a, arrayList, f8Var.f7132a, f8Var.f7135d, f8Var.b());
                case 6:
                    a2.a(this.f6824a.getPackageName(), this.f6824a, a3, v6.Command, bArr.length);
                    r7 r7Var = (r7) a3;
                    String a9 = r7Var.a();
                    List<String> m450a = r7Var.m450a();
                    if (r7Var.f7815a == 0) {
                        if (TextUtils.equals(a9, n4.COMMAND_SET_ACCEPT_TIME.f67a) && m450a != null && m450a.size() > 1) {
                            l.a(this.f6824a, m450a.get(0), m450a.get(1));
                            if ("00:00".equals(m450a.get(0)) && "00:00".equals(m450a.get(1))) {
                                q0.m45a(this.f6824a).a(true);
                            } else {
                                q0.m45a(this.f6824a).a(false);
                            }
                            m450a = a(TimeZone.getTimeZone("GMT+08"), TimeZone.getDefault(), m450a);
                        } else if (TextUtils.equals(a9, n4.COMMAND_SET_ALIAS.f67a) && m450a != null && m450a.size() > 0) {
                            l.c(this.f6824a, m450a.get(0));
                        } else if (TextUtils.equals(a9, n4.COMMAND_UNSET_ALIAS.f67a) && m450a != null && m450a.size() > 0) {
                            l.g(this.f6824a, m450a.get(0));
                        } else if (TextUtils.equals(a9, n4.COMMAND_SET_ACCOUNT.f67a) && m450a != null && m450a.size() > 0) {
                            l.b(this.f6824a, m450a.get(0));
                        } else if (TextUtils.equals(a9, n4.COMMAND_UNSET_ACCOUNT.f67a) && m450a != null && m450a.size() > 0) {
                            l.f(this.f6824a, m450a.get(0));
                        } else if (TextUtils.equals(a9, n4.COMMAND_CHK_VDEVID.f67a)) {
                            if (m450a != null && m450a.size() > 0) {
                                f7.a(this.f6824a, m450a.get(0));
                            }
                            return null;
                        }
                    }
                    return r.a(a9, m450a, r7Var.f7815a, r7Var.f7818d, r7Var.b());
                case 7:
                    a2.a(this.f6824a.getPackageName(), this.f6824a, a3, v6.Notification, bArr.length);
                    if (a3 instanceof n7) {
                        n7 n7Var = (n7) a3;
                        String a10 = n7Var.a();
                        if (g7.DisablePushMessage.f30a.equalsIgnoreCase(n7Var.f7436d)) {
                            if (n7Var.f7433a == 0) {
                                synchronized (z.class) {
                                    if (z.a(this.f6824a).m63a(a10)) {
                                        z.a(this.f6824a).c(a10);
                                        if ("syncing".equals(z.a(this.f6824a).a(n0.DISABLE_PUSH))) {
                                            z.a(this.f6824a).a(n0.DISABLE_PUSH, "synced");
                                            l.f(this.f6824a);
                                            l.e(this.f6824a);
                                            PushMessageHandler.a();
                                            i0.a(this.f6824a).m29b();
                                        }
                                    }
                                }
                            } else if ("syncing".equals(z.a(this.f6824a).a(n0.DISABLE_PUSH))) {
                                synchronized (z.class) {
                                    if (z.a(this.f6824a).m63a(a10)) {
                                        if (z.a(this.f6824a).a(a10) < 10) {
                                            z.a(this.f6824a).b(a10);
                                            i0.a(this.f6824a).a(true, a10);
                                        } else {
                                            z.a(this.f6824a).c(a10);
                                        }
                                    }
                                }
                            }
                        } else if (g7.EnablePushMessage.f30a.equalsIgnoreCase(n7Var.f7436d)) {
                            if (n7Var.f7433a == 0) {
                                synchronized (z.class) {
                                    if (z.a(this.f6824a).m63a(a10)) {
                                        z.a(this.f6824a).c(a10);
                                        if ("syncing".equals(z.a(this.f6824a).a(n0.ENABLE_PUSH))) {
                                            z.a(this.f6824a).a(n0.ENABLE_PUSH, "synced");
                                        }
                                    }
                                }
                            } else if ("syncing".equals(z.a(this.f6824a).a(n0.ENABLE_PUSH))) {
                                synchronized (z.class) {
                                    if (z.a(this.f6824a).m63a(a10)) {
                                        if (z.a(this.f6824a).a(a10) < 10) {
                                            z.a(this.f6824a).b(a10);
                                            i0.a(this.f6824a).a(false, a10);
                                        } else {
                                            z.a(this.f6824a).c(a10);
                                        }
                                    }
                                }
                            }
                        } else if (g7.ThirdPartyRegUpdate.f30a.equalsIgnoreCase(n7Var.f7436d)) {
                            b(n7Var);
                        } else if (g7.UploadTinyData.f30a.equalsIgnoreCase(n7Var.f7436d)) {
                            a(n7Var);
                        }
                        z.a(this.f6824a).c(a10);
                    } else if (a3 instanceof v7) {
                        v7 v7Var = (v7) a3;
                        if ("registration id expired".equalsIgnoreCase(v7Var.f7963d)) {
                            List<String> j2 = l.j(this.f6824a);
                            List<String> k = l.k(this.f6824a);
                            List<String> l = l.l(this.f6824a);
                            String i4 = l.i(this.f6824a);
                            l.a(this.f6824a, k7.RegIdExpired);
                            for (String str6 : j2) {
                                l.g(this.f6824a, str6);
                                l.d(this.f6824a, str6, null);
                            }
                            for (String str7 : k) {
                                l.h(this.f6824a, str7);
                                l.f(this.f6824a, str7, null);
                            }
                            for (String str8 : l) {
                                l.f(this.f6824a, str8);
                                l.e(this.f6824a, str8, null);
                            }
                            String[] split = i4.split(",");
                            if (split.length == 2) {
                                l.u(this.f6824a);
                                l.a(this.f6824a, split[0], split[1]);
                            }
                        } else if ("client_info_update_ok".equalsIgnoreCase(v7Var.f7963d)) {
                            if (v7Var.m504a() != null && v7Var.m504a().containsKey("app_version")) {
                                q0.m45a(this.f6824a).a(v7Var.m504a().get("app_version"));
                            }
                        } else if (!g7.AwakeApp.f30a.equalsIgnoreCase(v7Var.f7963d)) {
                            try {
                                if (g7.NormalClientConfigUpdate.f30a.equalsIgnoreCase(v7Var.f7963d)) {
                                    u7 u7Var = new u7();
                                    h8.a(u7Var, v7Var.m509a());
                                    c.k.d.p9.n.a(c.k.d.p9.m.a(this.f6824a), u7Var);
                                } else if (g7.CustomClientConfigUpdate.f30a.equalsIgnoreCase(v7Var.f7963d)) {
                                    t7 t7Var = new t7();
                                    h8.a(t7Var, v7Var.m509a());
                                    c.k.d.p9.n.a(c.k.d.p9.m.a(this.f6824a), t7Var);
                                } else if (g7.SyncInfoResult.f30a.equalsIgnoreCase(v7Var.f7963d)) {
                                    o0.a(this.f6824a, v7Var);
                                } else if (g7.ForceSync.f30a.equalsIgnoreCase(v7Var.f7963d)) {
                                    c.k.a.a.a.c.m6a("receive force sync notification");
                                    o0.a(this.f6824a, false);
                                } else if (g7.CancelPushMessage.f30a.equals(v7Var.f7963d)) {
                                    if (v7Var.m504a() != null) {
                                        int i5 = -2;
                                        if (v7Var.m504a().containsKey(c.k.d.p9.v.G)) {
                                            String str9 = v7Var.m504a().get(c.k.d.p9.v.G);
                                            if (!TextUtils.isEmpty(str9)) {
                                                try {
                                                    i5 = Integer.parseInt(str9);
                                                } catch (NumberFormatException e2) {
                                                    e2.printStackTrace();
                                                }
                                            }
                                        }
                                        if (i5 >= -1) {
                                            l.a(this.f6824a, i5);
                                        } else {
                                            l.b(this.f6824a, v7Var.m504a().containsKey(c.k.d.p9.v.E) ? v7Var.m504a().get(c.k.d.p9.v.E) : "", v7Var.m504a().containsKey(c.k.d.p9.v.F) ? v7Var.m504a().get(c.k.d.p9.v.F) : "");
                                        }
                                    }
                                } else if (g7.HybridRegisterResult.f30a.equals(v7Var.f7963d)) {
                                    x7 x7Var2 = new x7();
                                    h8.a(x7Var2, v7Var.m509a());
                                    m.a(this.f6824a, x7Var2);
                                } else if (g7.HybridUnregisterResult.f30a.equals(v7Var.f7963d)) {
                                    d8 d8Var = new d8();
                                    h8.a(d8Var, v7Var.m509a());
                                    m.a(this.f6824a, d8Var);
                                } else if (g7.PushLogUpload.f30a.equals(v7Var.f7963d) && v7Var.m504a() != null && v7Var.m504a().containsKey("packages")) {
                                    String[] split2 = v7Var.m504a().get("packages").split(",");
                                    if (TextUtils.equals(this.f6824a.getPackageName(), "com.xiaomi.xmsf")) {
                                        f.a(this.f6824a, true);
                                        a(this.f6824a, split2);
                                    } else {
                                        f.a(this.f6824a, false);
                                    }
                                }
                            } catch (n8 e3) {
                                c.k.a.a.a.c.a(e3);
                            }
                        } else if (s7Var.m477b() && v7Var.m504a() != null && v7Var.m504a().containsKey("awake_info")) {
                            String str10 = v7Var.m504a().get("awake_info");
                            Context context3 = this.f6824a;
                            c1.a(context3, q0.m45a(context3).m46a(), c.k.d.p9.m.a(this.f6824a).a(a7.AwakeInfoUploadWaySwitch.a(), 0), str10);
                        }
                    }
                    return oVar;
                default:
                    return oVar;
            }
        } catch (i1 e4) {
            c.k.a.a.a.c.a(e4);
            a(s7Var);
            j4.a(this.f6824a).b(this.f6824a.getPackageName(), i4.m221a(i2), str, "19");
            return null;
        } catch (n8 e5) {
            c.k.a.a.a.c.a(e5);
            c.k.a.a.a.c.d("receive a message which action string is not valid. is the reg expired?");
            j4.a(this.f6824a).b(this.f6824a.getPackageName(), i4.m221a(i2), str, "20");
            return null;
        }
    }

    public final PushMessageHandler.a a(s7 s7Var, byte[] bArr) {
        String str;
        i8 a2;
        String str2 = null;
        try {
            a2 = b0.a(this.f6824a, s7Var);
        } catch (i1 e2) {
            c.k.a.a.a.c.a(e2);
            str = "message arrived: receive a message but decrypt failed. report when click.";
        } catch (n8 e3) {
            c.k.a.a.a.c.a(e3);
            str = "message arrived: receive a message which action string is not valid. is the reg expired?";
        }
        if (a2 == null) {
            c.k.a.a.a.c.d("message arrived: receiving an un-recognized message. " + s7Var.f94a);
            return null;
        }
        v6 m469a = s7Var.m469a();
        c.k.a.a.a.c.m6a("message arrived: processing an arrived message, action=" + m469a);
        if (h0.f6833a[m469a.ordinal()] != 1) {
            return null;
        }
        if (s7Var.m477b()) {
            z7 z7Var = (z7) a2;
            i7 a3 = z7Var.a();
            if (a3 != null) {
                j7 j7Var = s7Var.f7850a;
                if (j7Var != null && j7Var.m247a() != null) {
                    str2 = s7Var.f7850a.f46a.get("jobkey");
                }
                o a4 = r.a(z7Var, s7Var.a(), false);
                a4.setArrivedMessage(true);
                c.k.a.a.a.c.m6a("message arrived: receive a message, msgid=" + a3.m225a() + ", jobkey=" + str2);
                return a4;
            }
            str = "message arrived: receive an empty message without push content, drop it";
        } else {
            str = "message arrived: receiving an un-encrypt message(SendMessage).";
        }
        c.k.a.a.a.c.d(str);
        return null;
    }

    public List<String> a(TimeZone timeZone, TimeZone timeZone2, List<String> list) {
        if (timeZone.equals(timeZone2)) {
            return list;
        }
        long rawOffset = ((timeZone.getRawOffset() - timeZone2.getRawOffset()) / 1000) / 60;
        long parseLong = ((((Long.parseLong(list.get(0).split(":")[0]) * 60) + Long.parseLong(list.get(0).split(":")[1])) - rawOffset) + 1440) % 1440;
        long parseLong2 = ((((Long.parseLong(list.get(1).split(":")[0]) * 60) + Long.parseLong(list.get(1).split(":")[1])) - rawOffset) + 1440) % 1440;
        ArrayList arrayList = new ArrayList();
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(parseLong / 60), Long.valueOf(parseLong % 60)));
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(parseLong2 / 60), Long.valueOf(parseLong2 % 60)));
        return arrayList;
    }

    public final void a() {
        SharedPreferences sharedPreferences = this.f6824a.getSharedPreferences("mipush_extra", 0);
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - sharedPreferences.getLong("last_reinitialize", 0L)) > 1800000) {
            l.a(this.f6824a, k7.PackageUnregistered);
            sharedPreferences.edit().putLong("last_reinitialize", currentTimeMillis).commit();
        }
    }

    public final void a(Context context, PackageInfo packageInfo) {
        ServiceInfo[] serviceInfoArr = packageInfo.services;
        if (serviceInfoArr != null) {
            for (ServiceInfo serviceInfo : serviceInfoArr) {
                if (serviceInfo.exported && serviceInfo.enabled && "com.xiaomi.mipush.sdk.PushMessageHandler".equals(serviceInfo.name) && !context.getPackageName().equals(serviceInfo.packageName)) {
                    try {
                        Intent intent = new Intent();
                        intent.setClassName(serviceInfo.packageName, serviceInfo.name);
                        intent.setAction("com.xiaomi.mipush.sdk.SYNC_LOG");
                        PushMessageHandler.a(context, intent);
                        return;
                    } catch (Throwable unused) {
                        return;
                    }
                }
            }
        }
    }

    public final void a(Context context, String[] strArr) {
        c.k.d.j.a(context).a(new g0(this, strArr, context));
    }

    public final void a(n7 n7Var) {
        String a2 = n7Var.a();
        c.k.a.a.a.c.b("receive ack " + a2);
        Map<String, String> m313a = n7Var.m313a();
        if (m313a != null) {
            String str = m313a.get("real_source");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            c.k.a.a.a.c.b("receive ack : messageId = " + a2 + "  realSource = " + str);
            c.k.d.u0.a(this.f6824a).a(a2, str, Boolean.valueOf(n7Var.f7433a == 0));
        }
    }

    public final void a(s7 s7Var) {
        c.k.a.a.a.c.m6a("receive a message but decrypt failed. report now.");
        v7 v7Var = new v7(s7Var.a().f44a, false);
        v7Var.c(g7.DecryptMessageFail.f30a);
        v7Var.b(s7Var.m470a());
        v7Var.d(s7Var.f7851b);
        HashMap hashMap = new HashMap();
        v7Var.f105a = hashMap;
        hashMap.put("regid", l.q(this.f6824a));
        i0.a(this.f6824a).a((i0) v7Var, v6.Notification, false, (j7) null);
    }

    public final void a(z7 z7Var, s7 s7Var) {
        j7 a2 = s7Var.a();
        m7 m7Var = new m7();
        m7Var.b(z7Var.b());
        m7Var.a(z7Var.m564a());
        m7Var.a(z7Var.a().a());
        if (!TextUtils.isEmpty(z7Var.c())) {
            m7Var.c(z7Var.c());
        }
        if (!TextUtils.isEmpty(z7Var.d())) {
            m7Var.d(z7Var.d());
        }
        m7Var.a(h8.a(this.f6824a, s7Var));
        i0.a(this.f6824a).a((i0) m7Var, v6.AckMessage, a2);
    }

    public final void a(String str, long j, s0 s0Var) {
        n0 a2 = z0.a(s0Var);
        if (a2 == null) {
            return;
        }
        if (j == 0) {
            synchronized (z.class) {
                if (z.a(this.f6824a).m63a(str)) {
                    z.a(this.f6824a).c(str);
                    if ("syncing".equals(z.a(this.f6824a).a(a2))) {
                        z.a(this.f6824a).a(a2, "synced");
                    }
                }
            }
            return;
        }
        if (!"syncing".equals(z.a(this.f6824a).a(a2))) {
            z.a(this.f6824a).c(str);
            return;
        }
        synchronized (z.class) {
            if (z.a(this.f6824a).m63a(str)) {
                if (z.a(this.f6824a).a(str) < 10) {
                    z.a(this.f6824a).b(str);
                    i0.a(this.f6824a).a(str, a2, s0Var);
                } else {
                    z.a(this.f6824a).c(str);
                }
            }
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public final boolean m19a(s7 s7Var) {
        if (!TextUtils.equals("com.miui.hybrid", s7Var.b()) && !TextUtils.equals("com.miui.hybrid.loader", s7Var.b())) {
            return false;
        }
        Map<String, String> m247a = s7Var.a() == null ? null : s7Var.a().m247a();
        if (m247a == null) {
            return false;
        }
        String str = m247a.get("push_server_action");
        return TextUtils.equals(str, "hybrid_message") || TextUtils.equals(str, "platform_message");
    }

    public final void b(n7 n7Var) {
        long j;
        s0 s0Var;
        c.k.a.a.a.c.c("ASSEMBLE_PUSH : " + n7Var.toString());
        String a2 = n7Var.a();
        Map<String, String> m313a = n7Var.m313a();
        if (m313a != null) {
            String str = m313a.get("RegInfo");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (str.contains("brand:" + a0.FCM.name())) {
                c.k.a.a.a.c.m6a("ASSEMBLE_PUSH : receive fcm token sync ack");
                w0.a(this.f6824a, s0.ASSEMBLE_PUSH_FCM, str);
                j = n7Var.f7433a;
                s0Var = s0.ASSEMBLE_PUSH_FCM;
            } else {
                if (str.contains("brand:" + a0.HUAWEI.name())) {
                    c.k.a.a.a.c.m6a("ASSEMBLE_PUSH : receive hw token sync ack");
                    w0.a(this.f6824a, s0.ASSEMBLE_PUSH_HUAWEI, str);
                    j = n7Var.f7433a;
                    s0Var = s0.ASSEMBLE_PUSH_HUAWEI;
                } else {
                    if (str.contains("brand:" + a0.OPPO.name())) {
                        c.k.a.a.a.c.m6a("ASSEMBLE_PUSH : receive COS token sync ack");
                        w0.a(this.f6824a, s0.ASSEMBLE_PUSH_COS, str);
                        j = n7Var.f7433a;
                        s0Var = s0.ASSEMBLE_PUSH_COS;
                    } else {
                        if (!str.contains("brand:" + a0.VIVO.name())) {
                            return;
                        }
                        c.k.a.a.a.c.m6a("ASSEMBLE_PUSH : receive FTOS token sync ack");
                        w0.a(this.f6824a, s0.ASSEMBLE_PUSH_FTOS, str);
                        j = n7Var.f7433a;
                        s0Var = s0.ASSEMBLE_PUSH_FTOS;
                    }
                }
            }
            a(a2, j, s0Var);
        }
    }

    public final void b(s7 s7Var) {
        j7 a2 = s7Var.a();
        m7 m7Var = new m7();
        m7Var.b(s7Var.m470a());
        m7Var.a(a2.m246a());
        m7Var.a(a2.m244a());
        if (!TextUtils.isEmpty(a2.m251b())) {
            m7Var.c(a2.m251b());
        }
        m7Var.a(h8.a(this.f6824a, s7Var));
        i0.a(this.f6824a).a((i0) m7Var, v6.AckMessage, false, s7Var.a());
    }
}
