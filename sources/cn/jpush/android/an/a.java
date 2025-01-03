package cn.jpush.android.an;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import cn.jpush.android.ap.a;
import cn.jpush.android.ar.i;
import cn.jpush.android.as.d;
import cn.jpush.android.aw.e;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.p.c;
import cn.jpush.android.r.b;
import com.shix.shixipc.system.ContentCommon;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a extends cn.jpush.android.as.a {

    /* renamed from: a, reason: collision with root package name */
    public static volatile a f9142a;

    /* renamed from: d, reason: collision with root package name */
    public cn.jpush.android.ap.a f9145d;

    /* renamed from: c, reason: collision with root package name */
    public int f9144c = 0;

    /* renamed from: b, reason: collision with root package name */
    public ConcurrentHashMap<Integer, d> f9143b = new ConcurrentHashMap<>();

    public static a a() {
        if (f9142a == null) {
            synchronized (a.class) {
                if (f9142a == null) {
                    f9142a = new a();
                }
            }
        }
        return f9142a;
    }

    private d a(int i2) {
        d dVar = this.f9143b.get(Integer.valueOf(i2));
        if (dVar == null) {
            synchronized (a.class) {
                if (i2 == 200) {
                    dVar = new cn.jpush.android.ar.a(this);
                } else if (i2 == 201) {
                    dVar = new i(this);
                }
                if (dVar != null) {
                    this.f9143b.put(Integer.valueOf(i2), dVar);
                }
            }
            b.b("InAppMessagingManager", "init in app message, type: " + i2);
        }
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, Bundle bundle) {
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, str, bundle);
    }

    public static void a(Context context, String str, cn.jpush.android.d.d dVar, boolean z) {
        if (context != null && dVar != null) {
            if (dVar.aN == 1 || z) {
                cn.jpush.android.bg.b.a(context, str, dVar, (Intent) null);
                return;
            }
            return;
        }
        b.f("InAppMessagingManager", "[sendInAppMsgToUserReceiver] unexpected error, context: " + context + ", message: " + dVar);
    }

    private void b(Context context, int i2, int i3, int i4) {
        Bundle bundle = new Bundle();
        bundle.putInt("display_state", i2);
        bundle.putInt("in_app_type", i3);
        bundle.putInt("display_style", i4);
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "in_app_display_state", bundle);
    }

    private void b(Context context, String str, int i2, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString("activity_name", str);
        bundle.putInt("state", i2);
        bundle.putBoolean(ContentCommon.TYPE, z);
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "handle_life_resume", bundle);
    }

    private void b(Context context, String str, boolean z) {
        Iterator<Integer> it = this.f9143b.keySet().iterator();
        while (it.hasNext()) {
            d a2 = a(it.next().intValue());
            if (a2 != null) {
                a2.a(context, str, z);
            }
        }
    }

    private boolean b(int i2) {
        Iterator<Integer> it = this.f9143b.keySet().iterator();
        while (it.hasNext()) {
            d a2 = a(it.next().intValue());
            if (a2 != null && a2.a(i2) != 0) {
                this.f9144c = a2.a();
                b.b("InAppMessagingManager", "current display position is occupied, type is " + this.f9144c);
                return false;
            }
        }
        return true;
    }

    private void c(Context context) {
        Iterator<Integer> it = this.f9143b.keySet().iterator();
        while (it.hasNext()) {
            d dVar = this.f9143b.get(Integer.valueOf(it.next().intValue()));
            if (dVar != null) {
                dVar.d(context);
            }
        }
    }

    private void c(Context context, String str, boolean z) {
        for (d dVar : this.f9143b.values()) {
            if (dVar != null) {
                if (z) {
                    dVar.c(context, str);
                } else {
                    dVar.d(context, str);
                }
            }
        }
    }

    private void d(final Context context) {
        try {
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                b.b("InAppMessagingManager", "change to foreground, start delay to deal cache message, delay time: 5000");
                e(context);
                cn.jpush.android.ap.a aVar = new cn.jpush.android.ap.a();
                this.f9145d = aVar;
                aVar.a(new a.InterfaceC0143a() { // from class: cn.jpush.android.an.a.1
                    @Override // cn.jpush.android.ap.a.InterfaceC0143a
                    public void a() {
                        b.b("InAppMessagingManager", "timer time-up to process cache message");
                        a.this.a(context, "in_app_msg_handle", (Bundle) null);
                    }
                }, 5000L, 1000L);
            } else {
                b.b("InAppMessagingManager", "redirect to process cache message");
                a(context, "in_app_msg_handle", (Bundle) null);
            }
        } catch (Throwable th) {
            b.f("InAppMessagingManager", "start delay timer failed: " + th.getMessage());
        }
    }

    private void e(Context context) {
        cn.jpush.android.ap.a aVar = this.f9145d;
        if (aVar != null) {
            aVar.a();
        }
    }

    private void e(Context context, cn.jpush.android.d.d dVar) {
        if (dVar == null) {
            b.b("InAppMessagingManager", "message is null, no message to deal");
            return;
        }
        d a2 = a(dVar.bq);
        if (a2 == null) {
            b.f("InAppMessagingManager", "[processMessage] unexpected error infs is null");
            return;
        }
        int a3 = cn.jpush.android.ar.d.a(dVar.aC, dVar.aE);
        if (!b(a3)) {
            boolean z = dVar.bq == this.f9144c;
            if (!dVar.bs && !a2.a(context, z, dVar)) {
                b.b("InAppMessagingManager", "message not display, cache recv message, type: " + dVar.bq);
                a2.b(context, dVar);
                return;
            }
            if (!z) {
                cn.jpush.android.d.d dVar2 = new cn.jpush.android.d.d();
                dVar2.bq = this.f9144c;
                dVar2.r = a3;
                a(context, "cn.jpush.android.intent.DISPLAYED_STOP", dVar2, true);
            }
        }
        a2.a(context, dVar);
    }

    private synchronized cn.jpush.android.d.d f(Context context, cn.jpush.android.d.d dVar) {
        d a2;
        int a3;
        try {
            Iterator<Integer> it = this.f9143b.keySet().iterator();
            int i2 = 0;
            int i3 = 0;
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                d dVar2 = this.f9143b.get(Integer.valueOf(intValue));
                if (dVar2 != null && i3 <= (a3 = dVar2.a(context)) && dVar2.c(context)) {
                    if (i3 != a3 || i2 == 0) {
                        i2 = intValue;
                        i3 = a3;
                    } else if (intValue == 200) {
                        i2 = intValue;
                    }
                }
            }
            if (this.f9143b.size() <= 0 || i2 == 0) {
                b.b("InAppMessagingManager", "first start create notify to check file cache");
                a2 = a(201);
            } else {
                a2 = this.f9143b.get(Integer.valueOf(i2));
            }
            if (a2 == null) {
                b.b("InAppMessagingManager", "no other in app message to deal, type: " + i2);
                return dVar;
            }
            cn.jpush.android.d.d b2 = a2.b(context);
            if (dVar != null) {
                if (b2 == null) {
                    return dVar;
                }
                b2.av = dVar.av;
                if (a2.a(context) <= dVar.br) {
                    a2.b(context, b2);
                    return dVar;
                }
                d a4 = a(dVar.bq);
                if (a4 != null) {
                    a4.b(context, dVar);
                }
            }
            b.b("InAppMessagingManager", "deal cache message, type: " + i2 + ", priority: " + i3);
            return b2;
        } catch (Throwable th) {
            b.f("InAppMessagingManager", "get message for priority failed, " + th.getMessage());
            return null;
        }
    }

    public void a(Context context) {
        b.b("InAppMessagingManager", "back to background for service");
        c(context);
    }

    public void a(Context context, int i2) {
        Iterator<Integer> it = this.f9143b.keySet().iterator();
        while (it.hasNext()) {
            d a2 = a(it.next().intValue());
            if (a2 != null) {
                a2.a(context, i2);
            }
        }
    }

    public void a(Context context, int i2, int i3) {
        b.b("InAppMessagingManager", "Sync to main process to stop the display style inapp, inappType: " + i2 + ", displayStyle: " + i3);
        d dVar = this.f9143b.get(Integer.valueOf(i2));
        if (dVar != null) {
            dVar.b(context, i3);
        }
    }

    @Override // cn.jpush.android.as.a
    public void a(Context context, int i2, int i3, int i4) {
        String str;
        b.c("InAppMessagingManager", "message status changed, type: " + i2 + ", displayStyle: " + i3 + ", status: " + i4);
        b(context, i4, i2, i3);
        if (i4 == 0) {
            if (!cn.jpush.android.bm.a.k(context)) {
                str = "not in foreground, handle next in app stop";
            } else {
                if (!cn.jpush.android.ar.d.c(context)) {
                    a(context, "in_app_msg_handle", (Bundle) null);
                    return;
                }
                str = "current black list not handle inapp msg";
            }
            b.b("InAppMessagingManager", str);
        }
    }

    public void a(Context context, Bundle bundle) {
        if (cn.jpush.android.cache.a.e(context)) {
            b.d("InAppMessagingManager", "Service is stopped, give up all the cache message");
        } else if (JPushConstants.isTcpConnected()) {
            e(context, f(context, null));
        } else {
            b.d("InAppMessagingManager", "tcp is disconnected, give up to deal cache message");
        }
    }

    public void a(Context context, e eVar, int i2) {
        if (eVar == null) {
            b.f("InAppMessagingManager", "[onJsLoadedCallback] message is null");
            return;
        }
        try {
            d a2 = a(eVar.t().bq);
            if (a2 == null) {
                b.f("InAppMessagingManager", "unexpected error of infs is null");
            } else {
                a2.a(context, eVar, i2);
            }
        } catch (Throwable unused) {
        }
    }

    public void a(Context context, e eVar, String str) {
        if (eVar == null) {
            b.f("InAppMessagingManager", "[onJsDataReport] message is null");
            return;
        }
        try {
            d a2 = a(eVar.t().bq);
            if (a2 == null) {
                b.f("InAppMessagingManager", "unexpected error of infs is null");
            } else {
                a2.a(context, eVar, str);
            }
        } catch (Throwable unused) {
        }
    }

    public void a(Context context, cn.jpush.android.d.d dVar) {
        e(context, f(context, dVar));
    }

    public void a(Context context, String str) {
        Iterator<Integer> it = this.f9143b.keySet().iterator();
        while (it.hasNext()) {
            d dVar = this.f9143b.get(Integer.valueOf(it.next().intValue()));
            if (dVar != null) {
                dVar.b(context.getApplicationContext(), str);
            }
        }
        a(context.getApplicationContext(), str, 0, true);
    }

    @Override // cn.jpush.android.as.a
    public void a(Context context, String str, int i2) {
        cn.jpush.android.d.d dVar = new cn.jpush.android.d.d();
        dVar.f9700d = str;
        dVar.bq = i2;
        a(context, "cn.jpush.android.intent.NOTIFY_INAPP_CANCEL", dVar, true);
    }

    public void a(Context context, String str, int i2, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("sync current page status, page: ");
        sb.append(str);
        sb.append(", isEnter: ");
        sb.append(i2 == 1);
        sb.append(", isActivity: ");
        sb.append(z);
        b.b("InAppMessagingManager", sb.toString());
        cn.jpush.android.ar.d.a(str, i2, z);
        b(context, str, i2, z);
        if (i2 == 1) {
            b.b("InAppMessagingManager", "enter page reset page time");
            c.c();
        }
    }

    public void a(Context context, String str, boolean z) {
        a(context, str, z ? 1 : 0, false);
        c(context, str, z);
        b.b("InAppMessagingManager", "[setCurrentPageByUser] set fragment page by user, pageName: " + str + ", isEnter: " + z);
        b(context, str, z);
    }

    public void a(Context context, JSONObject jSONObject) {
        try {
            String optString = jSONObject.getJSONObject("content").optString("ids");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            b.b("InAppMessagingManager", "dealCancelInAppMessage ids=" + optString);
            d a2 = a(201);
            if (a2 == null) {
                b.g("InAppMessagingManager", "unexpected error, infs is null");
            } else {
                a2.f(context, optString);
            }
        } catch (Throwable th) {
            b.f("InAppMessagingManager", "[cancelInAppMessage] parse ids json failed, " + th.getMessage());
        }
    }

    public void a(e eVar, int i2, String str) {
        if (eVar == null) {
            b.f("InAppMessagingManager", "[onWebInAppClick] message is null");
            return;
        }
        try {
            d a2 = a(eVar.t().bq);
            if (a2 == null) {
                b.f("InAppMessagingManager", "unexpected error of infs is null");
            } else {
                a2.a(eVar, i2, str);
            }
        } catch (Throwable unused) {
        }
    }

    public void b(Context context) {
        d a2 = a(200);
        if (a2 != null) {
            a2.f(context);
        }
    }

    public void b(Context context, int i2) {
        if (i2 == 0) {
            c(context);
        } else if (i2 == 1 || i2 == 2) {
            d(context);
        }
    }

    public void b(Context context, Bundle bundle) {
        if (bundle != null) {
            int i2 = bundle.getInt("display_state");
            int i3 = bundle.getInt("in_app_type");
            int i4 = bundle.getInt("display_style");
            d a2 = a(i3);
            if (a2 != null) {
                a2.a(i4, i2);
            }
        }
    }

    public void b(Context context, cn.jpush.android.d.d dVar) {
        if (dVar == null) {
            b.f("InAppMessagingManager", "[handleInAppMessage] message is null");
            return;
        }
        try {
            d a2 = a(dVar.bq);
            if (a2 == null) {
                b.f("InAppMessagingManager", "[handleInAppMessage] unexpected error of infs is null");
            } else {
                a2.c(context, dVar);
            }
        } catch (Throwable unused) {
        }
    }

    public void b(Context context, String str) {
        Iterator<Integer> it = this.f9143b.keySet().iterator();
        while (it.hasNext()) {
            d dVar = this.f9143b.get(Integer.valueOf(it.next().intValue()));
            if (dVar != null) {
                dVar.a(context.getApplicationContext(), str);
            }
        }
        a(context.getApplicationContext(), str, 1, true);
    }

    public void c(Context context, cn.jpush.android.d.d dVar) {
        if (dVar == null) {
            b.f("InAppMessagingManager", "[dismissInAppMessage] message is null");
            return;
        }
        try {
            d a2 = a(dVar.bq);
            if (a2 == null) {
                b.f("InAppMessagingManager", "[dismissInAppMessage] unexpected error of infs is null");
            } else {
                a2.d(context, dVar);
            }
        } catch (Throwable unused) {
        }
    }

    public void c(Context context, String str) {
        Iterator<Integer> it = this.f9143b.keySet().iterator();
        while (it.hasNext()) {
            d dVar = this.f9143b.get(Integer.valueOf(it.next().intValue()));
            if (dVar != null) {
                dVar.e(context, str);
            }
        }
    }

    public boolean c(Context context, int i2) {
        try {
            d a2 = a(i2);
            if (a2 != null) {
                return a2.e(context);
            }
            b.f("InAppMessagingManager", "unexpected error of infs is null");
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public void d(Context context, cn.jpush.android.d.d dVar) {
        if (context == null || dVar == null) {
            return;
        }
        cn.jpush.android.d.b.a(context, dVar);
    }
}
