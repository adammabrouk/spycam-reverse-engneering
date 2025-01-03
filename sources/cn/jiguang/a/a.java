package cn.jiguang.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.recyclerview.widget.RecyclerView;
import cn.jiguang.android.BuildConfig;
import cn.jiguang.android.IDataShare;
import cn.jiguang.ao.f;
import cn.jiguang.ap.e;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.as.d;
import cn.jiguang.az.c;
import cn.jiguang.bf.h;
import cn.jiguang.bf.i;
import cn.jiguang.e.b;
import cn.jiguang.internal.JConstants;
import cn.jiguang.internal.JCoreInternalHelper;
import cn.jiguang.union.ads.api.JUnionAdError;
import cn.jpush.android.service.DataShare;
import cn.jpush.android.service.JCommonService;
import cn.jpush.android.service.PushReceiver;
import java.util.Date;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static String f8097a = ".permission.JPUSH_MESSAGE";

    /* renamed from: b, reason: collision with root package name */
    public static String f8098b = "3.1.2";

    /* renamed from: c, reason: collision with root package name */
    public static int f8099c = 312;

    /* renamed from: d, reason: collision with root package name */
    public static String f8100d = "";

    /* renamed from: e, reason: collision with root package name */
    public static Boolean f8101e = null;

    /* renamed from: f, reason: collision with root package name */
    public static Boolean f8102f = null;

    /* renamed from: g, reason: collision with root package name */
    public static boolean f8103g = false;

    /* renamed from: h, reason: collision with root package name */
    public static final Date f8104h = b.c();

    /* renamed from: i, reason: collision with root package name */
    public static final String f8105i = cn.jiguang.p.a.b(new byte[]{85, 118, 97, 33, 60, 84, 32, 0, 98, 46, 73, 85, 85, 116, 18, 44});
    public static ServiceConnection j = new ServiceConnection() { // from class: cn.jiguang.a.a.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.c("JCoreGobal", "action - onServiceConnected, ComponentName:" + componentName);
            d.e("JCoreGobal", "Remote Service bind success.");
            try {
                DataShare.init(IDataShare.Stub.asInterface(iBinder), cn.jiguang.ao.d.a(JConstants.getAppContext(null)));
                if (JConstants.mApplicationContext != null) {
                    JCoreManager.init(JConstants.mApplicationContext);
                }
            } catch (Throwable th) {
                d.i("JCoreGobal", "onServiceConnected e:" + th);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.c("JCoreGobal", "action - onServiceDisconnected, ComponentName:" + componentName);
        }
    };

    /* renamed from: cn.jiguang.a.a$a, reason: collision with other inner class name */
    public static class C0131a extends cn.jiguang.bj.b {

        /* renamed from: a, reason: collision with root package name */
        public Context f8106a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f8107b;

        /* renamed from: c, reason: collision with root package name */
        public String f8108c;

        /* renamed from: d, reason: collision with root package name */
        public Bundle f8109d;

        public C0131a(Context context, boolean z, String str, Bundle bundle) {
            this.f8106a = context;
            this.f8107b = z;
            this.f8108c = str;
            this.f8109d = bundle;
            this.f8813h = "JCoreGlobal";
        }

        @Override // cn.jiguang.bj.b
        public void a() {
            String str;
            try {
                if (!cn.jiguang.bk.a.a()) {
                    d.i("JCoreGobal", "user don't auth, so return init");
                    return;
                }
                if (!this.f8107b) {
                    if (a.a(this.f8106a)) {
                        cn.jiguang.ao.d.a().a(this.f8106a, this.f8108c, this.f8109d);
                        return;
                    }
                    return;
                }
                if (this.f8108c.equals("a5")) {
                    cn.jiguang.az.b.a().a(this.f8106a, 2001, 1, "");
                    cn.jiguang.f.b.a(this.f8106a, (cn.jiguang.f.a<?>[]) new cn.jiguang.f.a[]{cn.jiguang.f.a.p().a((cn.jiguang.f.a<Boolean>) true)});
                    String string = this.f8109d.getString("appkey");
                    if (TextUtils.isEmpty(string)) {
                        cn.jiguang.az.b.a().a(this.f8106a, 0, 10003, "appkey is empty");
                        return;
                    }
                    String b2 = cn.jiguang.ao.a.b(this.f8106a);
                    if (!TextUtils.isEmpty(b2) && !b2.equals(string)) {
                        cn.jiguang.az.b.a().a(this.f8106a, 0, 10002, "appkey not same with meta appkey");
                        return;
                    }
                    cn.jiguang.e.a.h(this.f8106a);
                    JConstants.APP_KEY = string;
                    if (c.a(this.f8106a)) {
                        str = "tcp_a24";
                    } else {
                        String b3 = cn.jiguang.d.a.b(this.f8106a);
                        if (!TextUtils.isEmpty(b3)) {
                            cn.jiguang.az.b.a().a(this.f8106a, 2001, 0, b3);
                        }
                        str = "tcp_a1";
                    }
                    this.f8108c = str;
                } else if (this.f8108c.equals("tcp_a23")) {
                    cn.jiguang.az.b.a().a(this.f8106a, RecyclerView.MAX_SCROLL_DURATION, 0, JUnionAdError.Message.SUCCESS);
                } else if (this.f8108c.equals("a6")) {
                    f.a(this.f8106a);
                }
                if (a.b(this.f8106a)) {
                    cn.jiguang.ao.d.a().b(this.f8106a, this.f8108c, this.f8109d);
                }
            } catch (Throwable th) {
                d.i("JCoreGobal", "do action error:" + th.getMessage());
            }
        }
    }

    public static void a(Context context, String str, Bundle bundle) {
        try {
            String c2 = cn.jiguang.ao.d.c(context);
            String a2 = cn.jiguang.e.a.a(context);
            String a3 = cn.jiguang.e.a.a(context, Class.forName(c2));
            d.c("JCoreGobal", "curProcessName is " + a2 + ", remoteProcessName is " + a3);
            if (!TextUtils.isEmpty(c2) && context.getPackageName().equals(a2)) {
                cn.jiguang.bj.d.a("SDK_INIT", new C0131a(context, false, str, bundle));
            } else if (!TextUtils.isEmpty(a2) && a2.equals(a3)) {
                b(context, str, bundle);
            }
        } catch (Throwable th) {
            d.g("JCoreGobal", "sendToServiceAction failed, " + th.getMessage());
        }
    }

    public static void a(Context context, boolean z, long j2) {
        try {
            Bundle bundle = new Bundle();
            bundle.putBoolean("force", z);
            bundle.putLong("delay_time", j2);
            a(context, "tcp_a2", bundle);
        } catch (Throwable th) {
            d.h("JCoreGobal", "sendHeartBeat error:" + th);
        }
    }

    public static boolean a() {
        return false;
    }

    public static synchronized boolean a(Context context) {
        synchronized (a.class) {
            if (f8101e != null) {
                return f8101e.booleanValue();
            }
            if (context == null) {
                d.j("JCoreGobal", "init failed,context is null");
                return false;
            }
            if (JConstants.SDK_VERSION_INT < 290) {
                c(context);
            }
            JConstants.mApplicationContext = context.getApplicationContext();
            d.f("JCoreGobal", "action:init jcore,version:" + f8098b + ",build id:" + BuildConfig.Build_ID + ",l:" + JConstants.SDK_VERSION_INT);
            d.c("JCoreGobal", "build type:google_play");
            Context applicationContext = context.getApplicationContext();
            cn.jiguang.ao.c.a();
            String c2 = cn.jiguang.ao.d.c(applicationContext);
            if ((cn.jiguang.ao.c.a().c() || cn.jiguang.ao.c.a().b()) && TextUtils.isEmpty(c2)) {
                f8101e = false;
                d.j("JCoreGobal", "AndroidManifest.xml missing required service:" + JCommonService.class.getCanonicalName() + ",please custom one service and extends JCommonService");
                return false;
            }
            cn.jiguang.b.a.a().b();
            i.a(applicationContext);
            d(applicationContext);
            f(applicationContext);
            e.b(applicationContext);
            Boolean bool = true;
            f8101e = bool;
            return bool.booleanValue();
        }
    }

    public static void b(Context context, String str, Bundle bundle) {
        cn.jiguang.bj.d.a("SDK_SERVICE_INIT", new C0131a(context, true, str, bundle));
    }

    public static synchronized boolean b(Context context) {
        synchronized (a.class) {
            if (f8102f != null) {
                return f8102f.booleanValue();
            }
            if (context == null) {
                d.j("JCoreGobal", "init failed,context is null");
                return false;
            }
            if (JConstants.SDK_VERSION_INT < 290) {
                c(context);
            }
            d.c("JCoreGobal", "serviceInit...");
            JConstants.mApplicationContext = context.getApplicationContext();
            Context applicationContext = context.getApplicationContext();
            if (!cn.jiguang.ao.a.e(applicationContext)) {
                return false;
            }
            if (!cn.jiguang.ao.a.f(applicationContext)) {
                f8102f = false;
                return false;
            }
            if (a()) {
                try {
                    JCoreInternalHelper.getInstance().onEvent(applicationContext, JConstants.SDK_TYPE, 65, true, "", null, 1);
                } catch (Throwable unused) {
                    d.g("JCoreGobal", "u p call failed");
                }
            }
            cn.jiguang.ao.c.a();
            try {
                JConstants.isCallInit.set(true);
            } catch (Throwable unused2) {
            }
            e(applicationContext);
            f8102f = true;
            i.a(applicationContext);
            h.a().b(applicationContext);
            cn.jiguang.b.a.a().e(applicationContext);
            cn.jiguang.az.e.a(applicationContext, "service_create", null);
            if (Build.VERSION.SDK_INT >= 28) {
                cn.jiguang.ba.a.a().a(applicationContext);
            }
            cn.jiguang.as.a.a(applicationContext);
            return f8102f.booleanValue();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0078 A[Catch: all -> 0x00ac, TryCatch #0 {all -> 0x00ac, blocks: (B:6:0x000a, B:9:0x0022, B:11:0x0038, B:12:0x0053, B:13:0x0068, B:15:0x0078, B:17:0x008e, B:19:0x00a7, B:22:0x0057, B:23:0x005d), top: B:5:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void c(android.content.Context r11) {
        /*
            if (r11 != 0) goto L3
            return
        L3:
            java.lang.String r0 = "JCoreGobal"
            java.lang.String r1 = "setInternalDebug"
            cn.jiguang.as.d.c(r0, r1)
            cn.jiguang.f.a r1 = cn.jiguang.f.a.W()     // Catch: java.lang.Throwable -> Lac
            java.lang.Object r1 = cn.jiguang.f.b.a(r11, r1)     // Catch: java.lang.Throwable -> Lac
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch: java.lang.Throwable -> Lac
            int r1 = r1.intValue()     // Catch: java.lang.Throwable -> Lac
            java.lang.String r2 = "setInternalDebug is expire!"
            java.lang.String r3 = "setInternalDebug open"
            java.lang.String r4 = "FUTURE_TASK"
            r5 = 0
            r6 = 1
            if (r1 != r6) goto L5d
            long r7 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> Lac
            cn.jiguang.f.a r1 = cn.jiguang.f.a.Y()     // Catch: java.lang.Throwable -> Lac
            java.lang.Object r1 = cn.jiguang.f.b.a(r11, r1)     // Catch: java.lang.Throwable -> Lac
            java.lang.Long r1 = (java.lang.Long) r1     // Catch: java.lang.Throwable -> Lac
            long r9 = r1.longValue()     // Catch: java.lang.Throwable -> Lac
            int r1 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r1 <= 0) goto L57
            cn.jiguang.f.a[] r1 = new cn.jiguang.f.a[r6]     // Catch: java.lang.Throwable -> Lac
            cn.jiguang.f.a r7 = cn.jiguang.f.a.W()     // Catch: java.lang.Throwable -> Lac
            java.lang.Integer r8 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Throwable -> Lac
            cn.jiguang.f.a r7 = r7.a(r8)     // Catch: java.lang.Throwable -> Lac
            r1[r5] = r7     // Catch: java.lang.Throwable -> Lac
            cn.jiguang.f.b.a(r11, r1)     // Catch: java.lang.Throwable -> Lac
            cn.jiguang.as.d.c(r0, r2)     // Catch: java.lang.Throwable -> Lac
            cn.jiguang.a.a$2 r1 = new cn.jiguang.a.a$2     // Catch: java.lang.Throwable -> Lac
            r1.<init>()     // Catch: java.lang.Throwable -> Lac
        L53:
            cn.jiguang.bj.d.a(r4, r1)     // Catch: java.lang.Throwable -> Lac
            goto L68
        L57:
            cn.jiguang.as.d.c(r0, r3)     // Catch: java.lang.Throwable -> Lac
            cn.jiguang.a.a.f8103g = r6     // Catch: java.lang.Throwable -> Lac
            goto L68
        L5d:
            java.lang.String r1 = "setInternalDebug close and delete log file"
            cn.jiguang.as.d.c(r0, r1)     // Catch: java.lang.Throwable -> Lac
            cn.jiguang.a.a$3 r1 = new cn.jiguang.a.a$3     // Catch: java.lang.Throwable -> Lac
            r1.<init>()     // Catch: java.lang.Throwable -> Lac
            goto L53
        L68:
            cn.jiguang.f.a r1 = cn.jiguang.f.a.X()     // Catch: java.lang.Throwable -> Lac
            java.lang.Object r1 = cn.jiguang.f.b.a(r11, r1)     // Catch: java.lang.Throwable -> Lac
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch: java.lang.Throwable -> Lac
            int r1 = r1.intValue()     // Catch: java.lang.Throwable -> Lac
            if (r1 != r6) goto Lac
            long r7 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> Lac
            cn.jiguang.f.a r1 = cn.jiguang.f.a.Y()     // Catch: java.lang.Throwable -> Lac
            java.lang.Object r1 = cn.jiguang.f.b.a(r11, r1)     // Catch: java.lang.Throwable -> Lac
            java.lang.Long r1 = (java.lang.Long) r1     // Catch: java.lang.Throwable -> Lac
            long r9 = r1.longValue()     // Catch: java.lang.Throwable -> Lac
            int r1 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r1 <= 0) goto La7
            cn.jiguang.f.a[] r1 = new cn.jiguang.f.a[r6]     // Catch: java.lang.Throwable -> Lac
            cn.jiguang.f.a r3 = cn.jiguang.f.a.X()     // Catch: java.lang.Throwable -> Lac
            java.lang.Integer r4 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Throwable -> Lac
            cn.jiguang.f.a r3 = r3.a(r4)     // Catch: java.lang.Throwable -> Lac
            r1[r5] = r3     // Catch: java.lang.Throwable -> Lac
            cn.jiguang.f.b.a(r11, r1)     // Catch: java.lang.Throwable -> Lac
            cn.jiguang.internal.JConstants.CMD_TO_PRINT_ALL_LOG = r5     // Catch: java.lang.Throwable -> Lac
            cn.jiguang.as.d.c(r0, r2)     // Catch: java.lang.Throwable -> Lac
            goto Lac
        La7:
            cn.jiguang.as.d.c(r0, r3)     // Catch: java.lang.Throwable -> Lac
            cn.jiguang.internal.JConstants.CMD_TO_PRINT_ALL_LOG = r6     // Catch: java.lang.Throwable -> Lac
        Lac:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.a.a.c(android.content.Context):void");
    }

    public static void d(Context context) {
        String c2 = cn.jiguang.ao.d.c(context);
        if (TextUtils.isEmpty(c2)) {
            d.e("JCoreGobal", "not found commonServiceClass（JCommonService）");
            return;
        }
        try {
            context.startService(new Intent(context.getApplicationContext(), Class.forName(c2)));
            d.c("JCoreGobal", "start common service");
        } catch (Throwable unused) {
        }
    }

    public static void e(Context context) {
        try {
            IntentFilter intentFilter = new IntentFilter();
            PushReceiver pushReceiver = new PushReceiver();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            if (Build.VERSION.SDK_INT < 28) {
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            }
            context.registerReceiver(pushReceiver, intentFilter, context.getPackageName() + f8097a, null);
            cn.jiguang.e.a.b(context, (Class<?>) PushReceiver.class);
        } catch (Throwable th) {
            d.i("JCoreGobal", "registerPushReceiver fail:" + th);
        }
    }

    public static void f(Context context) {
        String str;
        String c2 = cn.jiguang.ao.d.c(context);
        if (TextUtils.isEmpty(c2)) {
            d.e("JCoreGobal", "not found commonServiceClass（JCommonService）");
            return;
        }
        if (DataShare.isBinding()) {
            d.c("JCoreGobal", "is binding service");
            return;
        }
        try {
            Intent intent = new Intent();
            intent.setClass(context, Class.forName(c2));
            if (context.bindService(intent, j, 1)) {
                d.a("JCoreGobal", "Remote Service on binding...");
                DataShare.setBinding();
            } else {
                d.a("JCoreGobal", "Remote Service bind failed");
            }
        } catch (SecurityException unused) {
            str = "Remote Service bind failed caused by SecurityException!";
            d.h("JCoreGobal", str);
        } catch (Throwable th) {
            str = "Remote Service bind failed :" + th;
            d.h("JCoreGobal", str);
        }
    }
}
