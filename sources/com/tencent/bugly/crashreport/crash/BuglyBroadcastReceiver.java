package com.tencent.bugly.crashreport.crash;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.bugly.proguard.u;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;

/* compiled from: BUGLY */
/* loaded from: classes.dex */
public class BuglyBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: d, reason: collision with root package name */
    public static BuglyBroadcastReceiver f10900d;

    /* renamed from: b, reason: collision with root package name */
    public Context f10902b;

    /* renamed from: c, reason: collision with root package name */
    public String f10903c;

    /* renamed from: e, reason: collision with root package name */
    public boolean f10904e = true;

    /* renamed from: a, reason: collision with root package name */
    public IntentFilter f10901a = new IntentFilter();

    public static synchronized BuglyBroadcastReceiver getInstance() {
        BuglyBroadcastReceiver buglyBroadcastReceiver;
        synchronized (BuglyBroadcastReceiver.class) {
            if (f10900d == null) {
                f10900d = new BuglyBroadcastReceiver();
            }
            buglyBroadcastReceiver = f10900d;
        }
        return buglyBroadcastReceiver;
    }

    public synchronized void addFilter(String str) {
        if (!this.f10901a.hasAction(str)) {
            this.f10901a.addAction(str);
        }
        x.c("add action %s", str);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        try {
            a(context, intent);
        } catch (Throwable th) {
            if (x.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public synchronized void register(Context context) {
        this.f10902b = context;
        z.a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.BuglyBroadcastReceiver.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    x.a(BuglyBroadcastReceiver.f10900d.getClass(), "Register broadcast receiver of Bugly.", new Object[0]);
                    synchronized (this) {
                        BuglyBroadcastReceiver.this.f10902b.registerReceiver(BuglyBroadcastReceiver.f10900d, BuglyBroadcastReceiver.this.f10901a, "com.tencent.bugly.BuglyBroadcastReceiver.permission", null);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    public synchronized void unregister(Context context) {
        try {
            x.a(getClass(), "Unregister broadcast receiver of Bugly.", new Object[0]);
            context.unregisterReceiver(this);
            this.f10902b = context;
        } catch (Throwable th) {
            if (x.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    private synchronized boolean a(Context context, Intent intent) {
        if (context != null && intent != null) {
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                if (this.f10904e) {
                    this.f10904e = false;
                    return true;
                }
                String b2 = com.tencent.bugly.crashreport.common.info.b.b(this.f10902b);
                x.c("is Connect BC " + b2, new Object[0]);
                x.a("network %s changed to %s", this.f10903c, b2);
                if (b2 == null) {
                    this.f10903c = null;
                    return true;
                }
                String str = this.f10903c;
                this.f10903c = b2;
                long currentTimeMillis = System.currentTimeMillis();
                com.tencent.bugly.crashreport.common.strategy.a a2 = com.tencent.bugly.crashreport.common.strategy.a.a();
                u a3 = u.a();
                com.tencent.bugly.crashreport.common.info.a a4 = com.tencent.bugly.crashreport.common.info.a.a(context);
                if (a2 != null && a3 != null && a4 != null) {
                    if (!b2.equals(str) && currentTimeMillis - a3.a(c.f10963a) > 30000) {
                        x.a("try to upload crash on network changed.", new Object[0]);
                        c a5 = c.a();
                        if (a5 != null) {
                            a5.a(0L);
                        }
                        x.a("try to upload userinfo on network changed.", new Object[0]);
                        com.tencent.bugly.crashreport.biz.b.f10855a.b();
                    }
                    return true;
                }
                x.d("not inited BC not work", new Object[0]);
                return true;
            }
        }
        return false;
    }
}
