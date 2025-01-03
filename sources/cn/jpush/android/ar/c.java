package cn.jpush.android.ar;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import cn.jpush.android.ap.a;
import cn.jpush.android.aq.c;
import cn.jpush.android.local.JPushConstants;
import com.hjq.permissions.XXPermissions;
import com.tencent.bugly.CrashModule;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class c implements Handler.Callback, c.a, cn.jpush.android.as.c {

    /* renamed from: a, reason: collision with root package name */
    public static Map<String, cn.jpush.android.au.c> f9277a;

    /* renamed from: c, reason: collision with root package name */
    public Handler f9279c;

    /* renamed from: d, reason: collision with root package name */
    public cn.jpush.android.aq.c f9280d;

    /* renamed from: e, reason: collision with root package name */
    public cn.jpush.android.ap.a f9281e;

    /* renamed from: f, reason: collision with root package name */
    public long f9282f;

    /* renamed from: g, reason: collision with root package name */
    public cn.jpush.android.as.b f9283g;

    /* renamed from: i, reason: collision with root package name */
    public cn.jpush.android.aw.e f9285i;

    /* renamed from: h, reason: collision with root package name */
    public int f9284h = 0;

    /* renamed from: b, reason: collision with root package name */
    public h f9278b = new h();

    public c(cn.jpush.android.as.b bVar) {
        f9277a = new HashMap();
        this.f9283g = bVar;
        this.f9279c = new Handler(Looper.getMainLooper(), this);
    }

    private int a(int i2, boolean z) {
        if (i2 == 1) {
            return z ? 1026 : 1027;
        }
        if (i2 == 3) {
            return 1031;
        }
        if (i2 != 4) {
            return 1029;
        }
        return z ? 1032 : 1033;
    }

    public static void a(Context context, int i2, cn.jpush.android.aw.e eVar) {
        if (context == null) {
            cn.jpush.android.r.b.b("InAppDisplayHelper", "set layout config failed with context is null.");
            return;
        }
        try {
            DisplayMetrics a2 = cn.jpush.android.af.a.a(context);
            cn.jpush.android.aw.g gVar = new cn.jpush.android.aw.g();
            String a3 = cn.jpush.android.aw.g.a(i2, 1);
            cn.jpush.android.au.c cVar = null;
            if (a3 != null && f9277a != null) {
                cn.jpush.android.au.c c2 = i2 != 1 ? i2 != 2 ? i2 != 3 ? null : gVar.c(context, a2, eVar) : gVar.e(context, a2, eVar) : gVar.a(context, a2, eVar);
                if (c2 != null) {
                    f9277a.put(a3, c2);
                }
            }
            String a4 = cn.jpush.android.aw.g.a(i2, 2);
            if (a4 == null || f9277a == null) {
                return;
            }
            if (i2 == 1) {
                cVar = gVar.b(context, a2, eVar);
            } else if (i2 == 2) {
                cVar = gVar.f(context, a2, eVar);
            } else if (i2 == 3) {
                cVar = gVar.d(context, a2, eVar);
            }
            if (cVar != null) {
                f9277a.put(a4, cVar);
            }
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("InAppDisplayHelper", "[setInAppLayoutConfig] failed, error: " + th.getMessage());
        }
    }

    private void a(Context context, long j, cn.jpush.android.aw.e eVar) {
        if (this.f9279c.hasMessages(1000)) {
            cn.jpush.android.r.b.b("InAppDisplayHelper", "remove delaying message");
            this.f9279c.removeMessages(1000);
            cn.jpush.android.aw.e eVar2 = this.f9285i;
            if (eVar2 != null) {
                a(context, 1034, eVar2, false, new Object[0]);
            }
        }
        Message message = new Message();
        message.what = 1000;
        message.arg1 = eVar.t().bq;
        message.arg2 = (int) j;
        Bundle bundle = new Bundle();
        bundle.putString("msg_data", eVar.u());
        message.setData(bundle);
        this.f9279c.sendMessageDelayed(message, j);
        this.f9285i = eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Context context, final cn.jpush.android.aw.e eVar) {
        b();
        this.f9282f = System.currentTimeMillis();
        cn.jpush.android.ap.a aVar = new cn.jpush.android.ap.a();
        this.f9281e = aVar;
        aVar.a(new a.InterfaceC0143a() { // from class: cn.jpush.android.ar.c.2
            @Override // cn.jpush.android.ap.a.InterfaceC0143a
            public void a() {
                cn.jpush.android.r.b.g("InAppDisplayHelper", "js load callback timeout, time: " + (System.currentTimeMillis() - c.this.f9282f));
                c.this.a(context, 1006, eVar, true, new Object[0]);
            }
        }, 10000L, 1000L);
    }

    private void a(Context context, cn.jpush.android.aw.e eVar, long j) {
        try {
            if (context == null || eVar == null) {
                a(context, 1018, (cn.jpush.android.aw.e) null, true, new Object[0]);
                return;
            }
            if (!eVar.o() && !cn.jpush.android.af.e.a(context)) {
                cn.jpush.android.r.b.c("InAppDisplayHelper", "delay time up, is in background");
                a(context, j <= 0 ? 1009 : 1010, eVar, true, new Object[0]);
                return;
            }
            if (a(context, 1012, eVar, false, new Object[0])) {
                a(context, 1015, eVar, true, new Object[0]);
                cn.jpush.android.r.b.c("InAppDisplayHelper", "message is intercepted, not to show");
                return;
            }
            if (d.c(context)) {
                cn.jpush.android.r.b.c("InAppDisplayHelper", "message not display in black page");
                a(context, 1028, eVar, true, new Object[0]);
                return;
            }
            if (!d.a(eVar.t().bx)) {
                cn.jpush.android.r.b.c("InAppDisplayHelper", "message not display for current page not in srv specified pages");
                a(context, 1030, eVar, true, new Object[0]);
                return;
            }
            cn.jpush.android.r.b.c("InAppDisplayHelper", "ready to display message");
            if (cn.jpush.android.bm.a.c(context)) {
                eVar.k();
            }
            Activity a2 = cn.jpush.android.p.c.a(context);
            int a3 = a2 != null ? this.f9278b.a((Context) a2, this.f9280d, false) : 100;
            int i2 = 1013;
            if (a3 != 0) {
                a(context, 1015, eVar, true, new Object[0]);
                cn.jpush.android.r.b.g("InAppDisplayHelper", "show in app message failed. displayCode: " + a3);
            } else {
                i2 = 1014;
            }
            a(context, i2, eVar, false, Integer.valueOf(a3), false, Long.valueOf(j));
            if (i2 == 1014) {
                cn.jpush.android.r.b.d("InAppDisplayHelper", "display AD message, time: " + System.currentTimeMillis());
                cn.jpush.android.an.a.a(context, "cn.jpush.android.intent.IN_APP_MSG_ARRIVED_INTERVAL", eVar.t(), false);
            }
        } catch (Throwable th) {
            cn.jpush.android.r.b.g("InAppDisplayHelper", "in app message show failed" + th.getMessage());
            a(context, 1008, eVar, true, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Context context, int i2, cn.jpush.android.aw.e eVar, boolean z, Object... objArr) {
        cn.jpush.android.as.b bVar;
        boolean z2 = true;
        if (eVar != null) {
            cn.jpush.android.r.b.b("InAppDisplayHelper", "dispatch display action, eventType: " + i2 + ", inAppType: " + eVar.t().bq + ", dismiss: " + z);
            cn.jpush.android.as.b bVar2 = this.f9283g;
            if (bVar2 != null && i2 != 1015) {
                z2 = bVar2.a(context, i2, eVar, objArr).booleanValue();
            }
            if (z && e(context) && (bVar = this.f9283g) != null) {
                bVar.a(context, 1015, eVar, new Object[0]);
            }
        }
        return z2;
    }

    private long b(Context context, cn.jpush.android.aw.e eVar) {
        String str = eVar.t().bx;
        String a2 = d.a();
        long max = Math.max(System.currentTimeMillis() - cn.jpush.android.p.c.a(), 0L);
        boolean z = !TextUtils.isEmpty(str) && TextUtils.equals(a2, str);
        if (z) {
            cn.jpush.android.r.b.b("InAppDisplayHelper", "current in aim page, start count aim page delay time");
            max = Math.max(System.currentTimeMillis() - cn.jpush.android.p.c.b(), 0L);
        }
        long max2 = Math.max(eVar.p(), 0);
        cn.jpush.android.r.b.b("InAppDisplayHelper", "stayForegroundOrPageTime: " + max + ", delayDisTime: " + max2);
        if (max2 <= 0 || max >= max2) {
            cn.jpush.android.r.b.b("InAppDisplayHelper", "notify in-app message display directory, stay foreground time: " + max + ", server delay time: " + max2 + ", aim page: " + z);
            return 0L;
        }
        long j = max2 - max;
        cn.jpush.android.r.b.b("InAppDisplayHelper", "notify in-app message should delay to show, delay time: " + j + ", server delay time: " + max2 + ", aim page delay time: " + z);
        a(context, 1007, eVar, false, new Object[0]);
        return j;
    }

    public static cn.jpush.android.aw.e b(Context context, cn.jpush.android.d.d dVar) {
        if (dVar == null) {
            return null;
        }
        try {
            cn.jpush.android.r.b.b("InAppDisplayHelper", "start buildAppMessage, message type: " + dVar.aC);
            int i2 = dVar.aC;
            if (i2 == 1) {
                return d(context, dVar);
            }
            if (i2 != 2) {
                if (i2 != 3) {
                    return null;
                }
                return c(context, dVar);
            }
            cn.jpush.android.aw.e eVar = new cn.jpush.android.aw.e(dVar);
            a(context, eVar.n(), eVar);
            return eVar;
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("InAppDisplayHelper", "in-app message buildAppMessage failed, " + th.getMessage());
            return null;
        }
    }

    private void b() {
        if (this.f9281e != null) {
            cn.jpush.android.r.b.b("InAppDisplayHelper", "cancel js load timer");
            this.f9281e.a();
        }
    }

    private boolean b(Context context) {
        h hVar = this.f9278b;
        return hVar != null && hVar.a(this.f9280d);
    }

    public static cn.jpush.android.au.c c(Context context, int i2) {
        cn.jpush.android.au.c cVar = null;
        if (context == null) {
            cn.jpush.android.r.b.b("InAppDisplayHelper", "[getLayoutConfig] context is null");
            return null;
        }
        try {
            if (f9277a == null) {
                return null;
            }
            int d2 = d(context);
            if (d2 < 0) {
                cn.jpush.android.r.b.b("InAppDisplayHelper", "[getLayoutConfig] get screen orientation failed, curOrientation: " + d2);
                return null;
            }
            cn.jpush.android.au.c cVar2 = f9277a.get(cn.jpush.android.aw.g.a(i2, d2));
            if (cVar2 != null) {
                return cVar2;
            }
            try {
                cn.jpush.android.r.b.b("InAppDisplayHelper", "get in-app layout config failed, orientation config not exist");
                return null;
            } catch (Throwable th) {
                cVar = cVar2;
                th = th;
                cn.jpush.android.r.b.f("InAppDisplayHelper", "[getLayoutConfig] failed. err: " + th.getMessage());
                return cVar;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static cn.jpush.android.aw.e c(Context context, cn.jpush.android.d.d dVar) {
        try {
            cn.jpush.android.aw.c a2 = cn.jpush.android.aw.c.f().a(dVar.aE).a(dVar.bh).b(dVar.aY).c(dVar.aZ).d(dVar.ba).b(dVar.bB).c(dVar.bC).a(dVar).a();
            a(context, a2.n(), (cn.jpush.android.aw.e) a2);
            return a2;
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("InAppDisplayHelper", "build banner style message failed, err: " + th.getMessage());
            return null;
        }
    }

    private boolean c() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(Context context) {
        h hVar = this.f9278b;
        return hVar != null && hVar.b(this.f9280d);
    }

    public static int d(Context context) {
        if (context == null) {
            return -1;
        }
        return context.getResources().getConfiguration().orientation;
    }

    public static cn.jpush.android.aw.e d(Context context, cn.jpush.android.d.d dVar) {
        try {
            cn.jpush.android.aw.b a2 = cn.jpush.android.aw.b.j().a(dVar.aY).b(dVar.aZ).c(dVar.ba).a(dVar.aF).d(dVar.bn).e(dVar.bo).c(dVar.aE).b(dVar.aG).a(dVar).a();
            a(context, a2.n(), (cn.jpush.android.aw.e) a2);
            return a2;
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("InAppDisplayHelper", "build banner style message failed, err: " + th.getMessage());
            return null;
        }
    }

    private boolean e(final Context context) {
        try {
            b();
            if (c()) {
                f(context);
                return true;
            }
            cn.jpush.android.r.b.b("InAppDisplayHelper", "dismiss in app change to main thread, curThread: " + Thread.currentThread().getName());
            if (this.f9279c == null) {
                return true;
            }
            this.f9279c.post(new cn.jpush.android.bm.e("dismissInApp") { // from class: cn.jpush.android.ar.c.3
                @Override // cn.jpush.android.bm.e
                public void a() {
                    c.this.f(context);
                }
            });
            return true;
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("InAppDisplayHelper", "dismiss in app message failed, " + th.getMessage());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Context context) {
        h hVar = this.f9278b;
        if (hVar != null) {
            try {
                long a2 = hVar.a(context, this.f9280d);
                if (this.f9283g != null && a2 > 0) {
                    this.f9283g.a(context, 1038, this.f9280d.c(), Long.valueOf(a2));
                }
                this.f9280d.a((c.a) null);
                this.f9280d = null;
            } catch (Throwable unused) {
            }
            cn.jpush.android.r.b.b("InAppDisplayHelper", "[destroy] windowManager destroy completed. thread: " + Thread.currentThread().getName());
        }
    }

    private void f(Context context, String str) {
        cn.jpush.android.aw.e eVar;
        Handler handler = this.f9279c;
        if (handler == null || !handler.hasMessages(1000) || (eVar = this.f9285i) == null) {
            return;
        }
        String str2 = eVar.t().bx;
        cn.jpush.android.r.b.b("InAppDisplayHelper", "removeDelayADForPagePause, serverPageName: " + str2 + ", lastPageName: " + str);
        if (TextUtils.equals(str2, str)) {
            cn.jpush.android.r.b.b("InAppDisplayHelper", "onPage pause, remove delaying message");
            this.f9279c.removeMessages(1000);
            cn.jpush.android.aw.e eVar2 = this.f9285i;
            if (eVar2 != null) {
                a(context, 1036, eVar2, true, new Object[0]);
            }
        }
    }

    @Override // cn.jpush.android.as.c
    public int a() {
        return this.f9284h;
    }

    @Override // cn.jpush.android.as.c
    public void a(int i2) {
        this.f9284h = i2;
    }

    @Override // cn.jpush.android.as.c
    public void a(Context context) {
        if (context == null || this.f9278b == null || this.f9280d == null || !b(context)) {
            return;
        }
        if (!this.f9278b.a()) {
            a(context, 1024, this.f9280d.c(), false, new Object[0]);
            return;
        }
        cn.jpush.android.aw.e c2 = this.f9280d.c();
        c2.v = 4;
        a(context, 1015, c2, true, new Object[0]);
    }

    @Override // cn.jpush.android.as.c
    public void a(Context context, int i2) {
        try {
            if (!c(context)) {
                cn.jpush.android.r.b.b("InAppDisplayHelper", "in app not inflate ready");
                return;
            }
            if (this.f9279c == null || !this.f9279c.hasMessages(1000)) {
                if (b(context)) {
                    a(context, a(i2, true), this.f9280d.c(), true, new Object[0]);
                }
            } else {
                cn.jpush.android.r.b.b("InAppDisplayHelper", "in app is in display delaying, drop it");
                this.f9279c.removeMessages(1000);
                a(context, a(i2, false), this.f9280d.c(), true, new Object[0]);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // cn.jpush.android.aq.c.a
    public void a(Context context, View view) {
        cn.jpush.android.aq.c cVar;
        h hVar = this.f9278b;
        if (hVar == null || (cVar = this.f9280d) == null) {
            return;
        }
        if (hVar.a(context, cVar, view)) {
            a(context, 1037, this.f9280d.c(), false, new Object[0]);
        } else {
            cn.jpush.android.r.b.f("InAppDisplayHelper", "onDisplayCompleted - check display view not in screen");
        }
    }

    @Override // cn.jpush.android.aq.c.a
    public void a(Context context, View view, Object obj) {
        a(context, 1015, obj instanceof cn.jpush.android.aw.e ? (cn.jpush.android.aw.e) obj : null, true, new Object[0]);
    }

    @Override // cn.jpush.android.as.c
    public void a(Context context, cn.jpush.android.aw.e eVar, int i2) {
        b();
        if (context != null && eVar != null) {
            if (i2 != 0) {
                a(context, 1005, eVar, true, Integer.valueOf(i2));
                return;
            }
            cn.jpush.android.r.b.c("InAppDisplayHelper", "tpl load success will display");
            a(context, CrashModule.MODULE_ID, eVar, false, new Object[0]);
            a(context, b(context, eVar), eVar);
            return;
        }
        cn.jpush.android.r.b.f("InAppDisplayHelper", "unexpected param is null, context is " + context + ", message is " + eVar);
        a(JPushConstants.mApplicationContext, 1018, eVar, true, new Object[0]);
    }

    @Override // cn.jpush.android.as.c
    public void a(Context context, String str) {
        h hVar;
        if (b(context) && (hVar = this.f9278b) != null && hVar.b(str)) {
            a(context, XXPermissions.REQUEST_CODE, this.f9280d.c(), false, new Object[0]);
        }
    }

    @Override // cn.jpush.android.as.c
    public void a(Context context, String str, boolean z) {
        if (!z) {
            if (d.d(context)) {
                return;
            }
            a(context, 1);
        } else {
            if (d.b(context, str)) {
                a(context, 1);
            }
            if (d.a(this.f9280d.c().t().bx)) {
                return;
            }
            a(context, 4);
        }
    }

    @Override // cn.jpush.android.as.c
    public void a(Context context, String str, boolean z, boolean z2, int i2) {
        cn.jpush.android.aq.c cVar;
        if (!z2) {
            if (c(context) && (cVar = this.f9280d) != null && cVar.c().m().equals(str)) {
                cn.jpush.android.r.b.c("InAppDisplayHelper", "cancel notify message, msgId: " + str);
                Handler handler = this.f9279c;
                if (handler != null && handler.hasMessages(1000)) {
                    cn.jpush.android.r.b.b("InAppDisplayHelper", "remove delaying message");
                    this.f9279c.removeMessages(1000);
                }
                a(context, 1016, this.f9280d.c(), true, new Object[0]);
                return;
            }
            return;
        }
        h hVar = this.f9278b;
        if (hVar == null || !hVar.a() || !b(context)) {
            if (z) {
                cn.jpush.android.d.d dVar = new cn.jpush.android.d.d();
                dVar.f9700d = str;
                dVar.bq = i2;
                a(context, 1022, new cn.jpush.android.aw.e(dVar), false, new Object[0]);
                return;
            }
            return;
        }
        cn.jpush.android.aq.c cVar2 = this.f9280d;
        if (cVar2 == null || !cVar2.c().m().equals(str)) {
            return;
        }
        cn.jpush.android.r.b.c("InAppDisplayHelper", "cancel alert notify message, msgId: " + str);
        a(context, 1016, this.f9280d.c(), true, new Object[0]);
    }

    @Override // cn.jpush.android.as.c
    public void a(cn.jpush.android.aw.e eVar, int i2, String str) {
        Context context = JPushConstants.mApplicationContext;
        if (eVar == null || context == null) {
            cn.jpush.android.r.b.g("InAppDisplayHelper", "onclick message or context is null");
            a(context, 1020, (cn.jpush.android.aw.e) null, true, new Object[0]);
            return;
        }
        int i3 = i2 != 0 ? 1019 : 1021;
        if (i2 != 0) {
            cn.jpush.android.an.a.a(context, "cn.jpush.android.intent.IN_APP_MSG_CLICK_INTERVAL", eVar.t(), false);
        }
        cn.jpush.android.aq.c cVar = this.f9280d;
        if (cVar != null) {
            eVar.y = cVar.f9231d;
        }
        a(context, i3, eVar, i2 != 1, Integer.valueOf(i2), str);
    }

    @Override // cn.jpush.android.as.c
    public boolean a(final Context context, cn.jpush.android.d.d dVar) {
        if (context == null || dVar == null) {
            cn.jpush.android.r.b.f("InAppDisplayHelper", "unexpected error, context is null");
            a(JPushConstants.mApplicationContext, 1000, dVar != null ? new cn.jpush.android.aw.e(dVar) : null, false, new Object[0]);
            return false;
        }
        cn.jpush.android.r.b.b("InAppDisplayHelper", "inflate message: type: " + dVar.aC + ", showPos: " + dVar.aE + ", messageType: " + dVar.bq);
        final cn.jpush.android.aw.e b2 = b(context, dVar);
        if (b2 != null) {
            this.f9279c.post(new cn.jpush.android.bm.e("inflateInAppMessage") { // from class: cn.jpush.android.ar.c.1
                /* JADX WARN: Removed duplicated region for block: B:14:0x0079  */
                /* JADX WARN: Removed duplicated region for block: B:16:0x0084  */
                /* JADX WARN: Removed duplicated region for block: B:19:0x0087  */
                /* JADX WARN: Removed duplicated region for block: B:20:0x007e  */
                @Override // cn.jpush.android.bm.e
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void a() {
                    /*
                        r10 = this;
                        cn.jpush.android.ar.c r0 = cn.jpush.android.ar.c.this
                        android.content.Context r1 = r3
                        boolean r0 = cn.jpush.android.ar.c.a(r0, r1)
                        java.lang.String r1 = "InAppDisplayHelper"
                        r2 = 0
                        if (r0 == 0) goto L32
                        cn.jpush.android.ar.c r0 = cn.jpush.android.ar.c.this
                        cn.jpush.android.aq.c r0 = cn.jpush.android.ar.c.a(r0)
                        cn.jpush.android.aw.e r0 = r0.c()
                        java.lang.String r0 = r0.m()
                        java.lang.String r3 = "has message display now, drop the new one"
                        cn.jpush.android.r.b.f(r1, r3)
                        cn.jpush.android.ar.c r4 = cn.jpush.android.ar.c.this
                        android.content.Context r5 = r3
                        r6 = 1035(0x40b, float:1.45E-42)
                        cn.jpush.android.aw.e r7 = r4
                        r8 = 0
                        r1 = 1
                        java.lang.Object[] r9 = new java.lang.Object[r1]
                        r9[r2] = r0
                        cn.jpush.android.ar.c.a(r4, r5, r6, r7, r8, r9)
                        return
                    L32:
                        android.content.Context r0 = r3
                        cn.jpush.android.aw.e r3 = r4
                        int r3 = r3.n()
                        cn.jpush.android.au.c r0 = cn.jpush.android.ar.c.b(r0, r3)
                        if (r0 == 0) goto L76
                        cn.jpush.android.ar.c r3 = cn.jpush.android.ar.c.this
                        cn.jpush.android.aw.e r4 = r4
                        cn.jpush.android.aq.c r0 = cn.jpush.android.aq.d.a(r0, r4)
                        cn.jpush.android.ar.c.a(r3, r0)
                        cn.jpush.android.ar.c r0 = cn.jpush.android.ar.c.this
                        cn.jpush.android.aq.c r0 = cn.jpush.android.ar.c.a(r0)
                        if (r0 == 0) goto L76
                        cn.jpush.android.ar.c r0 = cn.jpush.android.ar.c.this
                        cn.jpush.android.aq.c r0 = cn.jpush.android.ar.c.a(r0)
                        android.content.Context r3 = r3
                        boolean r0 = r0.c(r3)
                        if (r0 == 0) goto L77
                        cn.jpush.android.ar.c r3 = cn.jpush.android.ar.c.this
                        android.content.Context r4 = r3
                        cn.jpush.android.aw.e r5 = r4
                        cn.jpush.android.ar.c.a(r3, r4, r5)
                        cn.jpush.android.ar.c r3 = cn.jpush.android.ar.c.this
                        cn.jpush.android.aq.c r3 = cn.jpush.android.ar.c.a(r3)
                        cn.jpush.android.ar.c r4 = cn.jpush.android.ar.c.this
                        r3.a(r4)
                        goto L77
                    L76:
                        r0 = 0
                    L77:
                        if (r0 == 0) goto L7e
                        r3 = 1003(0x3eb, float:1.406E-42)
                        r6 = 1003(0x3eb, float:1.406E-42)
                        goto L82
                    L7e:
                        r3 = 1002(0x3ea, float:1.404E-42)
                        r6 = 1002(0x3ea, float:1.404E-42)
                    L82:
                        if (r0 == 0) goto L87
                        java.lang.String r0 = "wb inflate success"
                        goto L89
                    L87:
                        java.lang.String r0 = "wb inflate failed"
                    L89:
                        cn.jpush.android.r.b.c(r1, r0)
                        cn.jpush.android.ar.c r4 = cn.jpush.android.ar.c.this
                        android.content.Context r5 = r3
                        cn.jpush.android.aw.e r7 = r4
                        r8 = 0
                        java.lang.Object[] r9 = new java.lang.Object[r2]
                        cn.jpush.android.ar.c.a(r4, r5, r6, r7, r8, r9)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.ar.c.AnonymousClass1.a():void");
                }
            });
            return true;
        }
        cn.jpush.android.r.b.f("InAppDisplayHelper", "in-app message build message failed");
        a(context, 1001, new cn.jpush.android.aw.e(dVar), false, new Object[0]);
        return false;
    }

    @Override // cn.jpush.android.as.c
    public void b(Context context, String str) {
        h hVar;
        if (b(context) && (hVar = this.f9278b) != null && hVar.b(str)) {
            a(context, 1023, this.f9280d.c(), false, new Object[0]);
        }
        f(context, str);
    }

    @Override // cn.jpush.android.as.c
    public void c(Context context, String str) {
    }

    @Override // cn.jpush.android.as.c
    public void d(Context context, String str) {
        String str2;
        Activity a2 = cn.jpush.android.p.c.a(context);
        if (a2 != null) {
            str2 = a2.getClass().getCanonicalName();
            f(context, str2 + "&" + str);
        } else {
            str2 = "";
        }
        cn.jpush.android.r.b.b("InAppDisplayHelper", "onFragmentPause, last activityName: " + str2);
    }

    @Override // cn.jpush.android.as.c
    public void e(Context context, String str) {
        h hVar;
        if (context == null || (hVar = this.f9278b) == null || this.f9280d == null || !hVar.a(str) || !b(context)) {
            return;
        }
        cn.jpush.android.r.b.b("InAppDisplayHelper", "[onActivityDestroyed], to dismiss in app, activityName: " + str);
        cn.jpush.android.aw.e c2 = this.f9280d.c();
        c2.v = 3;
        a(context, 1015, c2, true, new Object[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x005f  */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean handleMessage(android.os.Message r10) {
        /*
            r9 = this;
            java.lang.String r0 = "InAppDisplayHelper"
            r1 = 0
            if (r10 == 0) goto L73
            int r2 = r10.what
            r3 = 1000(0x3e8, float:1.401E-42)
            if (r2 != r3) goto L73
            int r2 = r10.arg1
            int r2 = r10.arg2
            android.content.Context r4 = cn.jpush.android.local.JPushConstants.mApplicationContext
            android.os.Bundle r10 = r10.getData()     // Catch: java.lang.Throwable -> L43
            if (r10 == 0) goto L41
            if (r4 == 0) goto L41
            java.lang.String r3 = "msg_data"
            java.lang.String r10 = r10.getString(r3)     // Catch: java.lang.Throwable -> L43
            cn.jpush.android.aw.e r10 = cn.jpush.android.aw.e.a(r10)     // Catch: java.lang.Throwable -> L43
            if (r10 == 0) goto L41
            r3 = 1
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3f
            r5.<init>()     // Catch: java.lang.Throwable -> L3f
            java.lang.String r6 = "message delay up, start to display, delayTime: "
            r5.append(r6)     // Catch: java.lang.Throwable -> L3f
            r5.append(r2)     // Catch: java.lang.Throwable -> L3f
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L3f
            cn.jpush.android.r.b.b(r0, r5)     // Catch: java.lang.Throwable -> L3f
            long r5 = (long) r2     // Catch: java.lang.Throwable -> L3f
            r9.a(r4, r10, r5)     // Catch: java.lang.Throwable -> L3f
            goto L5d
        L3f:
            r10 = move-exception
            goto L45
        L41:
            r3 = 0
            goto L5d
        L43:
            r10 = move-exception
            r3 = 0
        L45:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "handle message failed, "
            r2.append(r5)
            java.lang.String r10 = r10.getMessage()
            r2.append(r10)
            java.lang.String r10 = r2.toString()
            cn.jpush.android.r.b.f(r0, r10)
        L5d:
            if (r3 != 0) goto L73
            cn.jpush.android.aq.c r10 = r9.f9280d
            if (r10 == 0) goto L68
            cn.jpush.android.aw.e r10 = r10.c()
            goto L69
        L68:
            r10 = 0
        L69:
            r6 = r10
            r5 = 1018(0x3fa, float:1.427E-42)
            r7 = 1
            java.lang.Object[] r8 = new java.lang.Object[r1]
            r3 = r9
            r3.a(r4, r5, r6, r7, r8)
        L73:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.ar.c.handleMessage(android.os.Message):boolean");
    }
}
