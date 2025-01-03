package cn.jiguang.al;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import cn.jiguang.l.e;
import cn.jiguang.p.g;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a extends e {

    /* renamed from: a, reason: collision with root package name */
    public Context f8184a;

    /* renamed from: c, reason: collision with root package name */
    public cn.jiguang.am.a f8185c;

    /* renamed from: d, reason: collision with root package name */
    public String f8186d;

    /* renamed from: cn.jiguang.al.a$a, reason: collision with other inner class name */
    public static class C0134a extends e {

        /* renamed from: a, reason: collision with root package name */
        public Context f8187a;

        public C0134a(Context context) {
            this.f8187a = context;
            this.f8954b = "JWake#RequestConfigAction";
        }

        @Override // cn.jiguang.l.e
        public void a() {
            a.d(this.f8187a);
        }
    }

    public static class b implements ServiceConnection {

        /* renamed from: a, reason: collision with root package name */
        public Context f8188a;

        public b(Context context) {
            this.f8188a = context;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                cn.jiguang.ai.a.a("JWake", "unbind wake ServiceConnection");
                this.f8188a.getApplicationContext().unbindService(this);
            } catch (Throwable th) {
                cn.jiguang.ai.a.d("JWake", "onServiceConnected throwable" + th.getMessage());
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public a(Context context, String str) {
        this.f8184a = context;
        this.f8186d = str;
        this.f8954b = "JWake";
    }

    public static Intent a(String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Intent parseUri = Intent.parseUri(str, i2);
        Intent intent = new Intent(parseUri);
        parseUri.addCategory("android.intent.category.BROWSABLE");
        parseUri.setComponent(null);
        if (Build.VERSION.SDK_INT >= 15) {
            parseUri.setSelector(null);
        }
        return intent;
    }

    public static Object a(Context context, Object obj) {
        if (!(obj instanceof List)) {
            return obj;
        }
        return cn.jiguang.an.c.a(cn.jiguang.an.b.b(context), (List<String>) obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x015b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0165  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<cn.jiguang.am.b> a(android.content.Context r23, java.util.List<cn.jiguang.am.c> r24) {
        /*
            Method dump skipped, instructions count: 827
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.al.a.a(android.content.Context, java.util.List):java.util.List");
    }

    public static void a(Context context) {
        try {
            cn.jiguang.l.d.a(new C0134a(context));
        } catch (Throwable th) {
            cn.jiguang.ai.a.d("JWake", "[requestConfig failed] " + th.getMessage());
        }
    }

    public static void a(Context context, cn.jiguang.am.a aVar) {
        boolean z = aVar.f8195b && aVar.f8197d;
        if (!aVar.f8198e) {
            z = z && cn.jiguang.l.b.b(context);
        }
        cn.jiguang.an.a.a(context, z);
    }

    public static void a(Context context, String str) {
        try {
            cn.jiguang.l.d.a(new a(context, str));
        } catch (Throwable th) {
            cn.jiguang.ai.a.d("JWake", "[doAction failed] " + str + " :" + th.getMessage());
        }
    }

    public static boolean a(Context context, Bundle bundle, Intent intent) {
        String str;
        try {
            if (intent == null) {
                cn.jiguang.ai.a.d("JWake", "Fail to start activity ,activityIntent is null !!");
                return false;
            }
            intent.addFlags(276824064);
            intent.putExtras(bundle);
            context.startActivity(intent);
            if (intent.getComponent() == null) {
                return true;
            }
            String className = intent.getComponent().getClassName();
            if (!"cn.jpush.android.service.DActivity".equals(className) && !"cn.jpush.android.service.BActivity".equals(className)) {
                str = "JWake_activity";
                cn.jiguang.l.b.d(context, str);
                return true;
            }
            str = "JWake_dactivity";
            cn.jiguang.l.b.d(context, str);
            return true;
        } catch (Throwable th) {
            cn.jiguang.ai.a.a("JWake", "Fail to start activity caused by:" + th);
            return false;
        }
    }

    private boolean a(Intent intent, String str, boolean z) {
        return cn.jiguang.an.a.a(this.f8184a, str, intent, z);
    }

    private boolean a(String str) {
        StringBuilder sb;
        String str2;
        List<String> list = this.f8185c.p;
        if (list != null && list.contains(str)) {
            sb = new StringBuilder();
            sb.append(str);
            str2 = " is in black list";
        } else {
            if (TextUtils.isEmpty(this.f8185c.n)) {
                return false;
            }
            if (this.f8185c.n.equals("exclude")) {
                if (!this.f8185c.o.contains(str)) {
                    return false;
                }
                sb = new StringBuilder();
                sb.append(str);
                str2 = " is in excloude list";
            } else {
                if (!this.f8185c.n.equals("include") || this.f8185c.o.contains(str)) {
                    return false;
                }
                sb = new StringBuilder();
                sb.append(str);
                str2 = " is not in include list";
            }
        }
        sb.append(str2);
        cn.jiguang.ai.a.a("JWake", sb.toString());
        return true;
    }

    private boolean a(List<String> list) {
        if (list == null) {
            return true;
        }
        try {
            if (list.size() <= 0) {
                return true;
            }
            for (String str : list) {
                if (cn.jiguang.e.a.h(this.f8184a, str)) {
                    cn.jiguang.ai.a.a("JWake", "checkSafeStatus blackPkgName = " + str);
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            cn.jiguang.ai.a.d("JWake", "checkSafeStatus error:" + th);
            return true;
        }
    }

    public static Object b(Context context) {
        boolean z = cn.jiguang.an.b.b(context).f8198e || cn.jiguang.l.b.b(context);
        cn.jiguang.ai.a.a("JWake", "isActionUserEnable :" + z);
        return Boolean.valueOf(z);
    }

    private boolean b() {
        boolean z = this.f8185c.f8198e || cn.jiguang.l.b.b(this.f8184a);
        cn.jiguang.ai.a.a("JWake", "isActionUserEnable :" + z);
        return z;
    }

    private void c() {
        long j = this.f8185c.l;
        long e2 = cn.jiguang.l.b.e(this.f8184a, "JWakeConfigHelper");
        long currentTimeMillis = System.currentTimeMillis();
        cn.jiguang.ai.a.a("JWake", "[refeshWakeConfig] currentTimeMillis:" + currentTimeMillis + ",lastBusinessTime:" + e2 + ",wakeConfigInterval:" + j);
        if (currentTimeMillis - e2 < j) {
            cn.jiguang.ai.a.a("JWake", "need not get wake config");
            return;
        }
        cn.jiguang.am.a d2 = d(this.f8184a);
        if (d2 != null) {
            this.f8185c = d2;
        }
        c.a(this.f8184a);
    }

    public static cn.jiguang.am.a d(Context context) {
        try {
            JSONObject a2 = cn.jiguang.an.b.a(context);
            if (a2 == null) {
                return null;
            }
            cn.jiguang.an.b.a(context, g.b(a2.toString()));
            return cn.jiguang.an.b.a(context, a2);
        } catch (Throwable th) {
            cn.jiguang.ai.a.d("JWake", "[requestConfigNow] failed:" + th.getMessage());
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0198 A[ADDED_TO_REGION] */
    @android.annotation.TargetApi(15)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List<cn.jiguang.am.c> d() {
        /*
            Method dump skipped, instructions count: 683
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.al.a.d():java.util.List");
    }

    @Override // cn.jiguang.l.e
    public void a() {
        try {
            cn.jiguang.ai.a.a("JWake", "wake with:" + this.f8186d);
            if (!cn.jiguang.l.d.e(this.f8184a)) {
                cn.jiguang.ai.a.d("JWake", "can't w because not r yet");
                return;
            }
            long f2 = cn.jiguang.l.d.f(this.f8184a);
            this.f8185c = cn.jiguang.an.b.b(this.f8184a);
            c();
            cn.jiguang.ai.a.a("JWake", "use config:" + this.f8185c);
            a(this.f8184a, this.f8185c);
            if (System.currentTimeMillis() < f2 + 604800000) {
                cn.jiguang.ai.a.a("JWake", "can't w because r time");
                return;
            }
            if (!b()) {
                cn.jiguang.ai.a.a("JWake", "wake is disabled by user");
                return;
            }
            if (this.f8185c.f8194a && this.f8185c.f8196c) {
                if (!a(this.f8185c.w)) {
                    cn.jiguang.ai.a.a("JWake", "wake is disabled by unsafe package");
                    return;
                }
                if (this.f8185c.v == 7) {
                    cn.jiguang.ai.a.a("JWake", "all wakeup type is unsupported of app, not wakeup any package");
                    return;
                }
                if (this.f8185c.f8202i && this.f8186d.equals("start")) {
                    cn.jiguang.an.c.a(this.f8184a, this.f8185c, a(this.f8184a, d()));
                    return;
                }
                if (!this.f8185c.f8201h) {
                    cn.jiguang.ai.a.a("JWake", "time disabled");
                    return;
                }
                long e2 = cn.jiguang.l.b.e(this.f8184a, "JWake");
                long j = this.f8185c.f8200g;
                long currentTimeMillis = System.currentTimeMillis();
                cn.jiguang.ai.a.a("JWake", "[wakeUp]currentTimeMillis:" + currentTimeMillis + ",lastBusinessTime:" + e2 + ",wakeInterval:" + j);
                if (currentTimeMillis - e2 < j) {
                    cn.jiguang.ai.a.a("JWake", "need not wake up");
                    return;
                }
                cn.jiguang.an.c.a(this.f8184a, this.f8185c, a(this.f8184a, d()));
                return;
            }
            cn.jiguang.ai.a.a("JWake", "wake is disabled by server");
        } catch (Throwable th) {
            cn.jiguang.ai.a.d("JWake", "wake failed:" + th.getMessage());
        }
    }
}
