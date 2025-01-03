package c.k.c.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import c.k.d.a2;
import c.k.d.a7;
import c.k.d.c8;
import c.k.d.g7;
import c.k.d.g9;
import c.k.d.h8;
import c.k.d.i8;
import c.k.d.j4;
import c.k.d.j7;
import c.k.d.s7;
import c.k.d.v6;
import c.k.d.v7;
import c.k.d.w6;
import c.k.d.w7;
import c.k.d.z6;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class i0 {
    public static i0 j = null;
    public static boolean k = false;
    public static final ArrayList<a> l = new ArrayList<>();

    /* renamed from: a, reason: collision with root package name */
    public boolean f6837a;

    /* renamed from: b, reason: collision with root package name */
    public Context f6838b;

    /* renamed from: d, reason: collision with root package name */
    public Messenger f6840d;

    /* renamed from: e, reason: collision with root package name */
    public Handler f6841e;

    /* renamed from: f, reason: collision with root package name */
    public List<Message> f6842f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    public boolean f6843g = false;

    /* renamed from: h, reason: collision with root package name */
    public Intent f6844h = null;

    /* renamed from: i, reason: collision with root package name */
    public Integer f6845i = null;

    /* renamed from: c, reason: collision with root package name */
    public String f6839c = null;

    public static class a<T extends i8<T, ?>> {

        /* renamed from: a, reason: collision with root package name */
        public T f6846a;

        /* renamed from: b, reason: collision with root package name */
        public v6 f6847b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f6848c;
    }

    public i0(Context context) {
        this.f6837a = false;
        this.f6841e = null;
        this.f6838b = context.getApplicationContext();
        this.f6837a = m32c();
        k = m34d();
        this.f6841e = new j0(this, Looper.getMainLooper());
        Intent b2 = b();
        if (b2 != null) {
            b(b2);
        }
    }

    public static synchronized i0 a(Context context) {
        i0 i0Var;
        synchronized (i0.class) {
            if (j == null) {
                j = new i0(context);
            }
            i0Var = j;
        }
        return i0Var;
    }

    public final synchronized int a() {
        return this.f6838b.getSharedPreferences("mipush_extra", 0).getInt("service_boot_mode", -1);
    }

    /* renamed from: a, reason: collision with other method in class */
    public final Intent m23a() {
        return (!m27a() || "com.xiaomi.xmsf".equals(this.f6838b.getPackageName())) ? e() : d();
    }

    public final Message a(Intent intent) {
        Message obtain = Message.obtain();
        obtain.what = 17;
        obtain.obj = intent;
        return obtain;
    }

    /* renamed from: a, reason: collision with other method in class */
    public final String m24a() {
        try {
            return this.f6838b.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 106 ? "com.xiaomi.push.service.XMPushService" : "com.xiaomi.xmsf.push.service.XMPushService";
        } catch (Exception unused) {
            return "com.xiaomi.xmsf.push.service.XMPushService";
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m25a() {
        b(m23a());
    }

    public void a(int i2) {
        Intent m23a = m23a();
        m23a.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        m23a.putExtra(c.k.d.p9.v.w, this.f6838b.getPackageName());
        m23a.putExtra(c.k.d.p9.v.x, i2);
        c(m23a);
    }

    public void a(int i2, String str) {
        Intent m23a = m23a();
        m23a.setAction("com.xiaomi.mipush.thirdparty");
        m23a.putExtra("com.xiaomi.mipush.thirdparty_LEVEL", i2);
        m23a.putExtra("com.xiaomi.mipush.thirdparty_DESC", str);
        b(m23a);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m26a(Intent intent) {
        intent.fillIn(m23a(), 24);
        c(intent);
    }

    public final void a(c8 c8Var) {
        byte[] a2 = h8.a(b0.a(this.f6838b, c8Var, v6.UnRegistration));
        if (a2 == null) {
            c.k.a.a.a.c.m6a("unregister fail, because msgBytes is null.");
            return;
        }
        Intent m23a = m23a();
        m23a.setAction("com.xiaomi.mipush.UNREGISTER_APP");
        m23a.putExtra("mipush_app_id", q0.m45a(this.f6838b).m46a());
        m23a.putExtra("mipush_payload", a2);
        c(m23a);
    }

    public final <T extends i8<T, ?>> void a(T t, v6 v6Var, j7 j7Var) {
        a((i0) t, v6Var, !v6Var.equals(v6.Registration), j7Var);
    }

    public <T extends i8<T, ?>> void a(T t, v6 v6Var, boolean z) {
        a aVar = new a();
        aVar.f6846a = t;
        aVar.f6847b = v6Var;
        aVar.f6848c = z;
        synchronized (l) {
            l.add(aVar);
            if (l.size() > 10) {
                l.remove(0);
            }
        }
    }

    public final <T extends i8<T, ?>> void a(T t, v6 v6Var, boolean z, j7 j7Var) {
        a(t, v6Var, z, true, j7Var, true);
    }

    public final <T extends i8<T, ?>> void a(T t, v6 v6Var, boolean z, j7 j7Var, boolean z2) {
        a(t, v6Var, z, true, j7Var, z2);
    }

    public final <T extends i8<T, ?>> void a(T t, v6 v6Var, boolean z, boolean z2, j7 j7Var, boolean z3) {
        a(t, v6Var, z, z2, j7Var, z3, this.f6838b.getPackageName(), q0.m45a(this.f6838b).m46a());
    }

    public final <T extends i8<T, ?>> void a(T t, v6 v6Var, boolean z, boolean z2, j7 j7Var, boolean z3, String str, String str2) {
        if (!q0.m45a(this.f6838b).m52c()) {
            if (z2) {
                a((i0) t, v6Var, z);
                return;
            } else {
                c.k.a.a.a.c.m6a("drop the message before initialization.");
                return;
            }
        }
        s7 a2 = b0.a(this.f6838b, t, v6Var, z, str, str2);
        if (j7Var != null) {
            a2.a(j7Var);
        }
        byte[] a3 = h8.a(a2);
        if (a3 == null) {
            c.k.a.a.a.c.m6a("send message fail, because msgBytes is null.");
            return;
        }
        a2.a(this.f6838b.getPackageName(), this.f6838b, t, v6Var, a3.length);
        Intent m23a = m23a();
        m23a.setAction("com.xiaomi.mipush.SEND_MESSAGE");
        m23a.putExtra("mipush_payload", a3);
        m23a.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", z3);
        c(m23a);
    }

    public final void a(w7 w7Var, boolean z) {
        j4.a(this.f6838b.getApplicationContext()).a(this.f6838b.getPackageName(), "E100003", w7Var.a(), 6001, null);
        this.f6844h = null;
        q0.m45a(this.f6838b).f6902d = w7Var.a();
        Intent m23a = m23a();
        byte[] a2 = h8.a(b0.a(this.f6838b, w7Var, v6.Registration));
        if (a2 == null) {
            c.k.a.a.a.c.m6a("register fail, because msgBytes is null.");
            return;
        }
        m23a.setAction("com.xiaomi.mipush.REGISTER_APP");
        m23a.putExtra("mipush_app_id", q0.m45a(this.f6838b).m46a());
        m23a.putExtra("mipush_payload", a2);
        m23a.putExtra("mipush_session", this.f6839c);
        m23a.putExtra("mipush_env_chanage", z);
        m23a.putExtra("mipush_env_type", q0.m45a(this.f6838b).a());
        if (c.k.d.e0.b(this.f6838b) && m30b()) {
            c(m23a);
        } else {
            this.f6844h = m23a;
        }
    }

    public final void a(z6 z6Var) {
        Intent m23a = m23a();
        byte[] a2 = h8.a(z6Var);
        if (a2 == null) {
            c.k.a.a.a.c.m6a("send TinyData failed, because tinyDataBytes is null.");
            return;
        }
        m23a.setAction("com.xiaomi.mipush.SEND_TINYDATA");
        m23a.putExtra("mipush_payload", a2);
        b(m23a);
    }

    public final void a(String str, n0 n0Var, s0 s0Var) {
        z.a(this.f6838b).a(n0Var, "syncing");
        a(str, n0Var, false, w0.a(this.f6838b, s0Var));
    }

    public final void a(String str, n0 n0Var, boolean z, HashMap<String, String> hashMap) {
        v7 v7Var;
        String str2;
        if (q0.m45a(this.f6838b).m50b() && c.k.d.e0.b(this.f6838b)) {
            v7 v7Var2 = new v7();
            v7Var2.a(true);
            Intent m23a = m23a();
            if (TextUtils.isEmpty(str)) {
                str = c.k.d.p9.p.a();
                v7Var2.a(str);
                v7Var = z ? new v7(str, true) : null;
                synchronized (z.class) {
                    z.a(this.f6838b).m62a(str);
                }
            } else {
                v7Var2.a(str);
                v7Var = z ? new v7(str, true) : null;
            }
            switch (m0.f6866a[n0Var.ordinal()]) {
                case 1:
                    v7Var2.c(g7.DisablePushMessage.f30a);
                    v7Var.c(g7.DisablePushMessage.f30a);
                    if (hashMap != null) {
                        v7Var2.a(hashMap);
                        v7Var.a(hashMap);
                    }
                    str2 = "com.xiaomi.mipush.DISABLE_PUSH_MESSAGE";
                    m23a.setAction(str2);
                    break;
                case 2:
                    v7Var2.c(g7.EnablePushMessage.f30a);
                    v7Var.c(g7.EnablePushMessage.f30a);
                    if (hashMap != null) {
                        v7Var2.a(hashMap);
                        v7Var.a(hashMap);
                    }
                    str2 = "com.xiaomi.mipush.ENABLE_PUSH_MESSAGE";
                    m23a.setAction(str2);
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                    v7Var2.c(g7.ThirdPartyRegUpdate.f30a);
                    if (hashMap != null) {
                        v7Var2.a(hashMap);
                        break;
                    }
                    break;
            }
            v7Var2.b(q0.m45a(this.f6838b).m46a());
            v7Var2.d(this.f6838b.getPackageName());
            a((i0) v7Var2, v6.Notification, false, (j7) null);
            if (z) {
                v7Var.b(q0.m45a(this.f6838b).m46a());
                v7Var.d(this.f6838b.getPackageName());
                Context context = this.f6838b;
                byte[] a2 = h8.a(b0.a(context, v7Var, v6.Notification, false, context.getPackageName(), q0.m45a(this.f6838b).m46a()));
                if (a2 != null) {
                    a2.a(this.f6838b.getPackageName(), this.f6838b, v7Var, v6.Notification, a2.length);
                    m23a.putExtra("mipush_payload", a2);
                    m23a.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
                    m23a.putExtra("mipush_app_id", q0.m45a(this.f6838b).m46a());
                    m23a.putExtra("mipush_app_token", q0.m45a(this.f6838b).b());
                    c(m23a);
                }
            }
            Message obtain = Message.obtain();
            obtain.what = 19;
            int ordinal = n0Var.ordinal();
            obtain.obj = str;
            obtain.arg1 = ordinal;
            this.f6841e.sendMessageDelayed(obtain, 5000L);
        }
    }

    public void a(String str, String str2) {
        Intent m23a = m23a();
        m23a.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        m23a.putExtra(c.k.d.p9.v.w, this.f6838b.getPackageName());
        m23a.putExtra(c.k.d.p9.v.B, str);
        m23a.putExtra(c.k.d.p9.v.C, str2);
        c(m23a);
    }

    public final void a(boolean z) {
        a(z, (String) null);
    }

    public final void a(boolean z, String str) {
        n0 n0Var;
        if (z) {
            z.a(this.f6838b).a(n0.DISABLE_PUSH, "syncing");
            z.a(this.f6838b).a(n0.ENABLE_PUSH, "");
            n0Var = n0.DISABLE_PUSH;
        } else {
            z.a(this.f6838b).a(n0.ENABLE_PUSH, "syncing");
            z.a(this.f6838b).a(n0.DISABLE_PUSH, "");
            n0Var = n0.ENABLE_PUSH;
        }
        a(str, n0Var, true, (HashMap<String, String>) null);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m27a() {
        return this.f6837a && 1 == q0.m45a(this.f6838b).a();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m28a(int i2) {
        if (!q0.m45a(this.f6838b).m50b()) {
            return false;
        }
        b(i2);
        v7 v7Var = new v7();
        v7Var.a(c.k.d.p9.p.a());
        v7Var.b(q0.m45a(this.f6838b).m46a());
        v7Var.d(this.f6838b.getPackageName());
        v7Var.c(g7.ClientABTest.f30a);
        HashMap hashMap = new HashMap();
        v7Var.f105a = hashMap;
        hashMap.put("boot_mode", i2 + "");
        a(this.f6838b).a((i0) v7Var, v6.Notification, false, (j7) null);
        return true;
    }

    public final Intent b() {
        if (!"com.xiaomi.xmsf".equals(this.f6838b.getPackageName())) {
            return c();
        }
        c.k.a.a.a.c.c("pushChannel xmsf create own channel");
        return e();
    }

    /* renamed from: b, reason: collision with other method in class */
    public final void m29b() {
        Intent m23a = m23a();
        m23a.setAction("com.xiaomi.mipush.DISABLE_PUSH");
        c(m23a);
    }

    public final synchronized void b(int i2) {
        this.f6838b.getSharedPreferences("mipush_extra", 0).edit().putInt("service_boot_mode", i2).commit();
    }

    public final void b(Intent intent) {
        try {
            if (g9.m183a() || Build.VERSION.SDK_INT < 26) {
                this.f6838b.startService(intent);
            } else {
                d(intent);
            }
        } catch (Exception e2) {
            c.k.a.a.a.c.a(e2);
        }
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m30b() {
        if (!m27a() || !m36e()) {
            return true;
        }
        if (this.f6845i == null) {
            Integer valueOf = Integer.valueOf(c.k.d.p9.y.a(this.f6838b).a());
            this.f6845i = valueOf;
            if (valueOf.intValue() == 0) {
                this.f6838b.getContentResolver().registerContentObserver(c.k.d.p9.y.a(this.f6838b).m410a(), false, new k0(this, new Handler(Looper.getMainLooper())));
            }
        }
        return this.f6845i.intValue() != 0;
    }

    public final Intent c() {
        if (m27a()) {
            c.k.a.a.a.c.c("pushChannel app start miui china channel");
            return d();
        }
        c.k.a.a.a.c.c("pushChannel app start  own channel");
        return e();
    }

    /* renamed from: c, reason: collision with other method in class */
    public void m31c() {
        Intent intent = this.f6844h;
        if (intent != null) {
            c(intent);
            this.f6844h = null;
        }
    }

    public final void c(Intent intent) {
        int a2 = c.k.d.p9.m.a(this.f6838b).a(a7.ServiceBootMode.a(), w6.START.a());
        int a3 = a();
        boolean z = a2 == w6.BIND.a() && k;
        int a4 = (z ? w6.BIND : w6.START).a();
        if (a4 != a3) {
            m28a(a4);
        }
        if (z) {
            d(intent);
        } else {
            b(intent);
        }
    }

    /* renamed from: c, reason: collision with other method in class */
    public final boolean m32c() {
        try {
            PackageInfo packageInfo = this.f6838b.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
            if (packageInfo == null) {
                return false;
            }
            return packageInfo.versionCode >= 105;
        } catch (Throwable unused) {
            return false;
        }
    }

    public final Intent d() {
        Intent intent = new Intent();
        String packageName = this.f6838b.getPackageName();
        intent.setPackage("com.xiaomi.xmsf");
        intent.setClassName("com.xiaomi.xmsf", m24a());
        intent.putExtra("mipush_app_package", packageName);
        f();
        return intent;
    }

    /* renamed from: d, reason: collision with other method in class */
    public void m33d() {
        synchronized (l) {
            Iterator<a> it = l.iterator();
            while (it.hasNext()) {
                a next = it.next();
                a(next.f6846a, next.f6847b, next.f6848c, false, null, true);
            }
            l.clear();
        }
    }

    public final synchronized void d(Intent intent) {
        if (this.f6843g) {
            Message a2 = a(intent);
            if (this.f6842f.size() >= 50) {
                this.f6842f.remove(0);
            }
            this.f6842f.add(a2);
            return;
        }
        if (this.f6840d == null) {
            this.f6838b.bindService(intent, new l0(this), 1);
            this.f6843g = true;
            this.f6842f.clear();
            this.f6842f.add(a(intent));
        } else {
            try {
                this.f6840d.send(a(intent));
            } catch (RemoteException unused) {
                this.f6840d = null;
                this.f6843g = false;
            }
        }
    }

    /* renamed from: d, reason: collision with other method in class */
    public final boolean m34d() {
        if (m27a()) {
            try {
                return this.f6838b.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 108;
            } catch (Exception unused) {
            }
        }
        return true;
    }

    public final Intent e() {
        Intent intent = new Intent();
        String packageName = this.f6838b.getPackageName();
        g();
        intent.setComponent(new ComponentName(this.f6838b, "com.xiaomi.push.service.XMPushService"));
        intent.putExtra("mipush_app_package", packageName);
        return intent;
    }

    /* renamed from: e, reason: collision with other method in class */
    public void m35e() {
        Intent m23a = m23a();
        m23a.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        m23a.putExtra(c.k.d.p9.v.w, this.f6838b.getPackageName());
        m23a.putExtra(c.k.d.p9.v.A, c.k.d.j0.b(this.f6838b.getPackageName()));
        c(m23a);
    }

    /* renamed from: e, reason: collision with other method in class */
    public final boolean m36e() {
        String packageName = this.f6838b.getPackageName();
        return packageName.contains("miui") || packageName.contains("xiaomi") || (this.f6838b.getApplicationInfo().flags & 1) != 0;
    }

    public final void f() {
        try {
            PackageManager packageManager = this.f6838b.getPackageManager();
            ComponentName componentName = new ComponentName(this.f6838b, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) == 2) {
                return;
            }
            packageManager.setComponentEnabledSetting(componentName, 2, 1);
        } catch (Throwable unused) {
        }
    }

    public final void g() {
        try {
            PackageManager packageManager = this.f6838b.getPackageManager();
            ComponentName componentName = new ComponentName(this.f6838b, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) == 1) {
                return;
            }
            packageManager.setComponentEnabledSetting(componentName, 1, 1);
        } catch (Throwable unused) {
        }
    }
}
