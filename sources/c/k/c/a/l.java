package c.k.c.a;

import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import c.k.c.a.p;
import c.k.d.a7;
import c.k.d.a8;
import c.k.d.c8;
import c.k.d.d5;
import c.k.d.e8;
import c.k.d.f7;
import c.k.d.g4;
import c.k.d.g7;
import c.k.d.g9;
import c.k.d.h4;
import c.k.d.i4;
import c.k.d.i9;
import c.k.d.j7;
import c.k.d.k7;
import c.k.d.l2;
import c.k.d.n4;
import c.k.d.n9;
import c.k.d.q7;
import c.k.d.q9;
import c.k.d.v6;
import c.k.d.v7;
import c.k.d.w7;
import cn.jiguang.internal.JConstants;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import com.xiaomi.push.service.receivers.NetworkStatusReceiver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f6859a = false;

    /* renamed from: b, reason: collision with root package name */
    public static Context f6860b;

    public interface a<R> {
    }

    @Deprecated
    public static abstract class b {

        /* renamed from: a, reason: collision with root package name */
        public String f6861a;

        public String a() {
            return this.f6861a;
        }

        public void a(long j, String str, String str2) {
        }

        public void a(o oVar) {
        }

        public void a(String str, long j, String str2, List<String> list) {
        }

        public void a(String str, String str2, String str3, boolean z) {
        }

        public void b(long j, String str, String str2) {
        }

        public void c(long j, String str, String str2) {
        }
    }

    static {
        System.currentTimeMillis();
    }

    public static boolean A(Context context) {
        return Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_reg_request", -1L)) > 5000;
    }

    public static boolean B(Context context) {
        return i0.a(context).m27a();
    }

    public static void C(Context context) {
        i0.a(context).a((String) null, n0.UPLOAD_COS_TOKEN, s0.ASSEMBLE_PUSH_COS);
    }

    public static void D(Context context) {
        i0.a(context).a((String) null, n0.UPLOAD_FCM_TOKEN, s0.ASSEMBLE_PUSH_FCM);
    }

    public static void E(Context context) {
        i0.a(context).a((String) null, n0.UPLOAD_FTOS_TOKEN, s0.ASSEMBLE_PUSH_FTOS);
    }

    public static void F(Context context) {
        i0.a(context).a((String) null, n0.UPLOAD_HUAWEI_TOKEN, s0.ASSEMBLE_PUSH_HUAWEI);
    }

    public static void G(Context context) {
        w0.c(context);
        c.k.d.p9.m.a(context).a();
        if (q0.m45a(context).m50b()) {
            c8 c8Var = new c8();
            c8Var.a(c.k.d.p9.p.a());
            c8Var.b(q0.m45a(context).m46a());
            c8Var.c(q0.m45a(context).c());
            c8Var.e(q0.m45a(context).b());
            c8Var.d(context.getPackageName());
            i0.a(context).a(c8Var);
            PushMessageHandler.a();
            PushMessageHandler.b();
            q0.m45a(context).m49b();
            e(context);
            f(context);
            d(context);
        }
    }

    public static long a(Context context, String str) {
        return context.getSharedPreferences("mipush_extra", 0).getLong("account_" + str, -1L);
    }

    public static void a(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.putLong("last_pull_notification", System.currentTimeMillis());
        n9.a(edit);
    }

    public static void a(Context context, int i2) {
        i0.a(context).a(i2);
    }

    public static void a(Context context, k7 k7Var) {
        if (q0.m45a(context).m52c()) {
            String a2 = c.k.d.k0.a(6);
            String m46a = q0.m45a(context).m46a();
            String b2 = q0.m45a(context).b();
            q0.m45a(context).m47a();
            q0.m45a(context).a(c.a());
            q0.m45a(context).a(m46a, b2, a2);
            w7 w7Var = new w7();
            w7Var.a(c.k.d.p9.p.a());
            w7Var.b(m46a);
            w7Var.e(b2);
            w7Var.f(a2);
            w7Var.d(context.getPackageName());
            w7Var.c(d5.m127a(context, context.getPackageName()));
            w7Var.a(k7Var);
            i0.a(context).a(w7Var, false);
        }
    }

    public static void a(Context context, String str, j7 j7Var, String str2) {
        v7 v7Var = new v7();
        if (TextUtils.isEmpty(str2)) {
            if (!q0.m45a(context).m50b()) {
                c.k.a.a.a.c.d("do not report clicked message");
                return;
            }
            str2 = q0.m45a(context).m46a();
        }
        v7Var.b(str2);
        v7Var.c("bar:click");
        v7Var.a(str);
        v7Var.a(false);
        i0.a(context).a((i0) v7Var, v6.Notification, false, j7Var);
    }

    public static void a(Context context, String str, j7 j7Var, String str2, String str3) {
        v7 v7Var = new v7();
        if (TextUtils.isEmpty(str3)) {
            c.k.a.a.a.c.d("do not report clicked message");
            return;
        }
        v7Var.b(str3);
        v7Var.c("bar:click");
        v7Var.a(str);
        v7Var.a(false);
        i0.a(context).a(v7Var, v6.Notification, false, true, j7Var, true, str2, str3);
    }

    public static synchronized void a(Context context, String str, String str2) {
        synchronized (l.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putString("accept_time", str + "," + str2);
            n9.a(edit);
        }
    }

    public static void a(Context context, String str, String str2, q qVar) {
        a(context, str, str2, qVar, (String) null, (a) null);
    }

    public static void a(Context context, String str, String str2, q qVar, String str3, a aVar) {
        a((Object) context, "context");
        a(str, "appID");
        a(str2, "appToken");
        Context applicationContext = context.getApplicationContext();
        f6860b = applicationContext;
        if (applicationContext == null) {
            f6860b = context;
        }
        Context context2 = f6860b;
        q9.m434a(context2);
        if (!NetworkStatusReceiver.a()) {
            t(f6860b);
        }
        t0.a(f6860b).a(qVar);
        c.k.d.j.a(context2).a(new g(str, str2, str3, aVar));
    }

    public static void a(Context context, String str, String str2, String str3) {
        StringBuilder sb;
        String str4;
        n4 n4Var;
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
        }
        if (n4.COMMAND_SET_ALIAS.f67a.equalsIgnoreCase(str) && Math.abs(System.currentTimeMillis() - e(context, str2)) < JConstants.DAY) {
            if (1 != r.a(context)) {
                n4Var = n4.COMMAND_SET_ALIAS;
                r.a(context, r.a(n4Var.f67a, arrayList, 0L, null, str3));
                return;
            }
            PushMessageHandler.a(context, str3, str, 0L, null, arrayList);
            return;
        }
        if (n4.COMMAND_UNSET_ALIAS.f67a.equalsIgnoreCase(str) && e(context, str2) < 0) {
            sb = new StringBuilder();
            str4 = "Don't cancel alias for ";
        } else {
            if (n4.COMMAND_SET_ACCOUNT.f67a.equalsIgnoreCase(str) && Math.abs(System.currentTimeMillis() - a(context, str2)) < JConstants.HOUR) {
                if (1 != r.a(context)) {
                    n4Var = n4.COMMAND_SET_ACCOUNT;
                    r.a(context, r.a(n4Var.f67a, arrayList, 0L, null, str3));
                    return;
                }
                PushMessageHandler.a(context, str3, str, 0L, null, arrayList);
                return;
            }
            if (!n4.COMMAND_UNSET_ACCOUNT.f67a.equalsIgnoreCase(str) || a(context, str2) >= 0) {
                a(context, str, (ArrayList<String>) arrayList, str3);
                return;
            } else {
                sb = new StringBuilder();
                str4 = "Don't cancel account for ";
            }
        }
        sb.append(str4);
        sb.append(c.k.d.k0.a(arrayList.toString(), 3));
        sb.append(" is unseted");
        c.k.a.a.a.c.m6a(sb.toString());
    }

    public static void a(Context context, String str, ArrayList<String> arrayList, String str2) {
        if (TextUtils.isEmpty(q0.m45a(context).m46a())) {
            return;
        }
        q7 q7Var = new q7();
        q7Var.a(c.k.d.p9.p.a());
        q7Var.b(q0.m45a(context).m46a());
        q7Var.c(str);
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            q7Var.m429a(it.next());
        }
        q7Var.e(str2);
        q7Var.d(context.getPackageName());
        i0.a(context).a((i0) q7Var, v6.Command, (j7) null);
    }

    public static void a(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw new IllegalArgumentException("param " + str + " is not nullable");
    }

    public static void b() {
        boolean a2 = c.k.d.p9.m.a(f6860b).a(a7.ForceHandleCrashSwitch.a(), false);
        if (f6859a || !a2) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(new k1(f6860b));
    }

    public static void b(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.putLong("last_reg_request", System.currentTimeMillis());
        n9.a(edit);
    }

    public static synchronized void b(Context context, String str) {
        synchronized (l.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().putLong("account_" + str, System.currentTimeMillis()).commit();
        }
    }

    public static void b(Context context, String str, String str2) {
        i0.a(context).a(str, str2);
    }

    public static void b(Context context, String str, String str2, b bVar, String str3, a aVar) {
        try {
            c.k.a.a.a.c.m6a("sdk_version = 3_7_6");
            if (bVar != null) {
                PushMessageHandler.a(bVar);
            }
            if (aVar != null) {
                PushMessageHandler.a(aVar);
            }
            if (q9.m436a(f6860b)) {
                m1.a(f6860b);
            }
            if (q0.m45a(f6860b).a(str, str2) || c(f6860b)) {
                boolean z = q0.m45a(f6860b).a() != c.a();
                if (!z && !A(f6860b)) {
                    i0.a(f6860b).m25a();
                    c.k.a.a.a.c.m6a("Could not send  register message within 5s repeatly .");
                    return;
                }
                if (z || !q0.m45a(f6860b).a(str, str2) || q0.m45a(f6860b).m54e()) {
                    String a2 = c.k.d.k0.a(6);
                    q0.m45a(f6860b).m47a();
                    q0.m45a(f6860b).a(c.a());
                    q0.m45a(f6860b).a(str, str2, a2);
                    p.a.a().a("com.xiaomi.xmpushsdk.tinydataPending.appId");
                    d(f6860b);
                    w7 w7Var = new w7();
                    w7Var.a(c.k.d.p9.p.a());
                    w7Var.b(str);
                    w7Var.e(str2);
                    w7Var.d(f6860b.getPackageName());
                    w7Var.f(a2);
                    w7Var.c(d5.m127a(f6860b, f6860b.getPackageName()));
                    w7Var.b(d5.a(f6860b, f6860b.getPackageName()));
                    w7Var.h("3_7_6");
                    w7Var.a(30706);
                    w7Var.i(f7.e(f6860b));
                    w7Var.a(k7.Init);
                    if (!TextUtils.isEmpty(str3)) {
                        w7Var.g(str3);
                    }
                    if (!g9.d()) {
                        String g2 = f7.g(f6860b);
                        if (!TextUtils.isEmpty(g2)) {
                            w7Var.k(c.k.d.k0.a(g2) + "," + f7.j(f6860b));
                        }
                    }
                    w7Var.j(f7.m151a());
                    int a3 = f7.a();
                    if (a3 >= 0) {
                        w7Var.c(a3);
                    }
                    i0.a(f6860b).a(w7Var, z);
                    f6860b.getSharedPreferences("mipush_extra", 4).getBoolean("mipush_registed", true);
                } else {
                    if (1 == r.a(f6860b)) {
                        a(bVar, "callback");
                        bVar.a(0L, null, q0.m45a(f6860b).c());
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(q0.m45a(f6860b).c());
                        r.a(f6860b, r.a(n4.COMMAND_REGISTER.f67a, arrayList, 0L, null, null));
                    }
                    i0.a(f6860b).m25a();
                    if (q0.m45a(f6860b).m48a()) {
                        v7 v7Var = new v7();
                        v7Var.b(q0.m45a(f6860b).m46a());
                        v7Var.c("client_info_update");
                        v7Var.a(c.k.d.p9.p.a());
                        HashMap hashMap = new HashMap();
                        v7Var.f105a = hashMap;
                        hashMap.put("app_version", d5.m127a(f6860b, f6860b.getPackageName()));
                        v7Var.f105a.put("app_version_code", Integer.toString(d5.a(f6860b, f6860b.getPackageName())));
                        v7Var.f105a.put("push_sdk_vn", "3_7_6");
                        v7Var.f105a.put("push_sdk_vc", Integer.toString(30706));
                        f7.a(f6860b, v7Var.f105a);
                        String e2 = q0.m45a(f6860b).e();
                        if (!TextUtils.isEmpty(e2)) {
                            v7Var.f105a.put("deviceid", e2);
                        }
                        i0.a(f6860b).a((i0) v7Var, v6.Notification, false, (j7) null);
                    }
                    if (!i9.m231a(f6860b, "update_devId", false)) {
                        e();
                        i9.a(f6860b, "update_devId", true);
                    }
                    String d2 = f7.d(f6860b);
                    if (!TextUtils.isEmpty(d2)) {
                        q7 q7Var = new q7();
                        q7Var.a(c.k.d.p9.p.a());
                        q7Var.b(str);
                        q7Var.c(n4.COMMAND_CHK_VDEVID.f67a);
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(f7.c(f6860b));
                        arrayList2.add(d2);
                        arrayList2.add(Build.MODEL != null ? Build.MODEL : "");
                        arrayList2.add(Build.BOARD != null ? Build.BOARD : "");
                        q7Var.a(arrayList2);
                        i0.a(f6860b).a((i0) q7Var, v6.Command, false, (j7) null);
                    }
                    if (B(f6860b) && z(f6860b)) {
                        v7 v7Var2 = new v7();
                        v7Var2.b(q0.m45a(f6860b).m46a());
                        v7Var2.c(g7.PullOfflineMessage.f30a);
                        v7Var2.a(c.k.d.p9.p.a());
                        v7Var2.a(false);
                        i0.a(f6860b).a((i0) v7Var2, v6.Notification, false, (j7) null, false);
                        a(f6860b);
                    }
                }
                b(f6860b);
                d();
                y(f6860b);
                r(f6860b);
                o0.a(f6860b);
                b();
                if (!f6860b.getPackageName().equals("com.xiaomi.xmsf")) {
                    if (f.a() != null) {
                        f.a(f6860b, f.a());
                    }
                    c.k.a.a.a.c.a(2);
                }
                s(context);
            }
        } catch (Throwable th) {
            c.k.a.a.a.c.a(th);
        }
    }

    public static synchronized void c(Context context, String str) {
        synchronized (l.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().putLong("alias_" + str, System.currentTimeMillis()).commit();
        }
    }

    public static void c(Context context, String str, String str2) {
        a(context, str, str2, new q());
    }

    public static boolean c() {
        return g9.m184b();
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x004e, code lost:
    
        if (c.k.d.y.a(r5).mo415a() == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0063, code lost:
    
        if (android.text.TextUtils.isEmpty(r4) != false) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean c(android.content.Context r5) {
        /*
            java.lang.String r0 = "android.permission.WRITE_EXTERNAL_STORAGE"
            java.lang.String r1 = "android.permission.READ_PHONE_STATE"
            r2 = 1
            if (r5 == 0) goto L66
            boolean r3 = c.k.d.g9.m183a()
            if (r3 != 0) goto L67
            java.lang.String r3 = r5.getPackageName()
            java.lang.String r4 = "com.xiaomi.xmsf"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L1a
            goto L67
        L1a:
            java.lang.String r3 = c.k.d.f7.b(r5)
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L25
            goto L67
        L25:
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 29
            if (r3 < r4) goto L2c
            goto L67
        L2c:
            android.content.pm.ApplicationInfo r3 = r5.getApplicationInfo()
            int r3 = r3.targetSdkVersion
            r4 = 23
            if (r3 < r4) goto L51
            int r3 = android.os.Build.VERSION.SDK_INT
            if (r3 < r4) goto L51
            boolean r3 = c.k.d.h9.a(r5, r1)
            if (r3 != 0) goto L67
            boolean r3 = c.k.d.h9.a(r5, r0)
            if (r3 != 0) goto L67
            c.k.d.y r3 = c.k.d.y.a(r5)
            boolean r3 = r3.mo415a()
            if (r3 == 0) goto L66
            goto L67
        L51:
            java.lang.String r3 = c.k.d.f7.f(r5)
            java.lang.String r4 = c.k.d.f7.m151a()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L67
            boolean r3 = android.text.TextUtils.isEmpty(r4)
            if (r3 != 0) goto L66
            goto L67
        L66:
            r2 = 0
        L67:
            if (r2 != 0) goto Lba
            java.lang.String r3 = "Because of lack of necessary information, mi push can't be initialized"
            c.k.a.a.a.c.d(r3)
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            boolean r4 = c.k.d.h9.a(r5, r1)
            if (r4 != 0) goto L7c
            r3.add(r1)
        L7c:
            boolean r1 = c.k.d.h9.a(r5, r0)
            if (r1 != 0) goto L85
            r3.add(r0)
        L85:
            boolean r0 = r3.isEmpty()
            if (r0 != 0) goto Lba
            int r0 = r3.size()
            java.lang.String[] r0 = new java.lang.String[r0]
            r3.toArray(r0)
            android.content.Intent r1 = new android.content.Intent
            r1.<init>()
            java.lang.String r3 = "com.xiaomi.mipush.ERROR"
            r1.setAction(r3)
            java.lang.String r3 = r5.getPackageName()
            r1.setPackage(r3)
            r3 = 5
            java.lang.String r4 = "message_type"
            r1.putExtra(r4, r3)
            java.lang.String r3 = "error_type"
            java.lang.String r4 = "error_lack_of_permission"
            r1.putExtra(r3, r4)
            java.lang.String r3 = "error_message"
            r1.putExtra(r3, r0)
            r5.sendBroadcast(r1)
        Lba:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: c.k.c.a.l.c(android.content.Context):boolean");
    }

    public static void d() {
        c.k.d.j.a(f6860b).a(new y(f6860b), c.k.d.p9.m.a(f6860b).a(a7.OcVersionCheckFrequency.a(), 86400), 5);
    }

    public static void d(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.clear();
        edit.commit();
    }

    public static synchronized void d(Context context, String str) {
        synchronized (l.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().putLong("topic_" + str, System.currentTimeMillis()).commit();
        }
    }

    public static void d(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a(context, n4.COMMAND_SET_ALIAS.f67a, str, str2);
    }

    public static long e(Context context, String str) {
        return context.getSharedPreferences("mipush_extra", 0).getLong("alias_" + str, -1L);
    }

    public static void e() {
        new Thread(new i()).start();
    }

    public static void e(Context context) {
        i0.a(context).m35e();
    }

    public static void e(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a(context, n4.COMMAND_SET_ACCOUNT.f67a, str, str2);
    }

    public static void f(Context context) {
        i0.a(context).a(-1);
    }

    public static synchronized void f(Context context, String str) {
        synchronized (l.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().remove("account_" + str).commit();
        }
    }

    public static void f(Context context, String str, String str2) {
        if (TextUtils.isEmpty(q0.m45a(context).m46a()) || TextUtils.isEmpty(str)) {
            return;
        }
        if (Math.abs(System.currentTimeMillis() - i(context, str)) <= JConstants.DAY) {
            if (1 == r.a(context)) {
                PushMessageHandler.a(context, str2, 0L, null, str);
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            r.a(context, r.a(n4.COMMAND_SUBSCRIBE_TOPIC.f67a, arrayList, 0L, null, null));
            return;
        }
        a8 a8Var = new a8();
        a8Var.a(c.k.d.p9.p.a());
        a8Var.b(q0.m45a(context).m46a());
        a8Var.c(str);
        a8Var.d(context.getPackageName());
        a8Var.e(str2);
        i0.a(context).a((i0) a8Var, v6.Subscription, (j7) null);
    }

    public static void g(Context context) {
        i0.a(context).a(true);
    }

    public static synchronized void g(Context context, String str) {
        synchronized (l.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().remove("alias_" + str).commit();
        }
    }

    public static void g(Context context, String str, String str2) {
        if (q0.m45a(context).m50b()) {
            if (i(context, str) < 0) {
                c.k.a.a.a.c.m6a("Don't cancel subscribe for " + str + " is unsubscribed");
                return;
            }
            e8 e8Var = new e8();
            e8Var.a(c.k.d.p9.p.a());
            e8Var.b(q0.m45a(context).m46a());
            e8Var.c(str);
            e8Var.d(context.getPackageName());
            e8Var.e(str2);
            i0.a(context).a((i0) e8Var, v6.UnSubscription, (j7) null);
        }
    }

    public static void h(Context context) {
        i0.a(context).a(false);
    }

    public static synchronized void h(Context context, String str) {
        synchronized (l.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().remove("topic_" + str).commit();
        }
    }

    public static long i(Context context, String str) {
        return context.getSharedPreferences("mipush_extra", 0).getLong("topic_" + str, -1L);
    }

    public static String i(Context context) {
        return context.getSharedPreferences("mipush_extra", 0).getString("accept_time", "00:00-23:59");
    }

    public static List<String> j(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String str : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (str.startsWith("alias_")) {
                arrayList.add(str.substring(6));
            }
        }
        return arrayList;
    }

    public static List<String> k(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String str : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (str.startsWith("topic_") && !str.contains("**ALL**")) {
                arrayList.add(str.substring(6));
            }
        }
        return arrayList;
    }

    public static List<String> l(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String str : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (str.startsWith("account_")) {
                arrayList.add(str.substring(8));
            }
        }
        return arrayList;
    }

    public static boolean m(Context context) {
        a((Object) context, "context");
        return t0.a(context).b(s0.ASSEMBLE_PUSH_FCM);
    }

    public static boolean n(Context context) {
        a((Object) context, "context");
        return t0.a(context).b(s0.ASSEMBLE_PUSH_HUAWEI);
    }

    public static boolean o(Context context) {
        a((Object) context, "context");
        return t0.a(context).b(s0.ASSEMBLE_PUSH_COS);
    }

    public static boolean p(Context context) {
        return t0.a(context).b(s0.ASSEMBLE_PUSH_FTOS);
    }

    public static String q(Context context) {
        if (q0.m45a(context).m52c()) {
            return q0.m45a(context).c();
        }
        return null;
    }

    public static void r(Context context) {
        i4.a(new j());
        c.k.b.a.a a2 = i4.a(context);
        c.k.b.b.b.a(context).a("3_7_6");
        c.k.b.b.a.a(context, a2, new g4(context), new h4(context));
        s.a(context);
        g1.a(context, a2);
        c.k.d.p9.m.a(context).a(new k(100, "perf event job update", context));
    }

    public static void s(Context context) {
        if ("syncing".equals(z.a(f6860b).a(n0.DISABLE_PUSH))) {
            g(f6860b);
        }
        if ("syncing".equals(z.a(f6860b).a(n0.ENABLE_PUSH))) {
            h(f6860b);
        }
        if ("syncing".equals(z.a(f6860b).a(n0.UPLOAD_HUAWEI_TOKEN))) {
            F(f6860b);
        }
        if ("syncing".equals(z.a(f6860b).a(n0.UPLOAD_FCM_TOKEN))) {
            D(f6860b);
        }
        if ("syncing".equals(z.a(f6860b).a(n0.UPLOAD_COS_TOKEN))) {
            C(context);
        }
        if ("syncing".equals(z.a(f6860b).a(n0.UPLOAD_FTOS_TOKEN))) {
            E(context);
        }
    }

    public static void t(Context context) {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            intentFilter.addCategory("android.intent.category.DEFAULT");
            context.getApplicationContext().registerReceiver(new NetworkStatusReceiver(null), intentFilter);
        } catch (Throwable th) {
            c.k.a.a.a.c.a(th);
        }
    }

    public static synchronized void u(Context context) {
        synchronized (l.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.remove("accept_time");
            n9.a(edit);
        }
    }

    public static synchronized void v(Context context) {
        synchronized (l.class) {
            Iterator<String> it = l(context).iterator();
            while (it.hasNext()) {
                f(context, it.next());
            }
        }
    }

    public static synchronized void w(Context context) {
        synchronized (l.class) {
            Iterator<String> it = j(context).iterator();
            while (it.hasNext()) {
                g(context, it.next());
            }
        }
    }

    public static synchronized void x(Context context) {
        synchronized (l.class) {
            Iterator<String> it = k(context).iterator();
            while (it.hasNext()) {
                h(context, it.next());
            }
        }
    }

    public static void y(Context context) {
        if (c.k.d.p9.m.a(f6860b).a(a7.DataCollectionSwitch.a(), c())) {
            l2.a().a(new f1(context));
            c.k.d.j.a(f6860b).a(new h(), 10);
        }
    }

    public static boolean z(Context context) {
        return Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_pull_notification", -1L)) > 300000;
    }
}
