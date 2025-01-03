package com.vivo.push.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import c.j.a.m;
import c.j.a.z.c;
import c.j.a.z.f;
import c.j.a.z.v;
import c.j.a.z.x;

/* loaded from: classes.dex */
public class PushServiceReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static HandlerThread f11245a;

    /* renamed from: b, reason: collision with root package name */
    public static Handler f11246b;

    /* renamed from: c, reason: collision with root package name */
    public static a f11247c = new a();

    public static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public Context f11248a;

        /* renamed from: b, reason: collision with root package name */
        public String f11249b;

        public static /* synthetic */ void a(a aVar, Context context, String str) {
            aVar.f11248a = c.c(context);
            aVar.f11249b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            NetworkInfo a2 = x.a(this.f11248a);
            if (!(a2 != null ? a2.isConnectedOrConnecting() : false)) {
                v.d("PushServiceReceiver", this.f11248a.getPackageName() + ": 无网络  by " + this.f11249b);
                v.a(this.f11248a, "触发静态广播:无网络(" + this.f11249b + "," + this.f11248a.getPackageName() + ")");
                return;
            }
            v.d("PushServiceReceiver", this.f11248a.getPackageName() + ": 执行开始出发动作: " + this.f11249b);
            v.a(this.f11248a, "触发静态广播(" + this.f11249b + "," + this.f11248a.getPackageName() + ")");
            m.m().a(this.f11248a);
            if (c.j.a.j.a.a(this.f11248a).b()) {
                return;
            }
            try {
                c.j.a.c.a(this.f11248a).d();
            } catch (f e2) {
                e2.printStackTrace();
                v.a(this.f11248a, " 初始化异常 error= " + e2.getMessage());
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Context c2 = c.c(context);
        String action = intent.getAction();
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action) || "android.intent.action.ACTION_POWER_CONNECTED".equals(action) || "android.intent.action.ACTION_POWER_DISCONNECTED".equals(action)) {
            if (f11245a == null) {
                HandlerThread handlerThread = new HandlerThread("PushServiceReceiver");
                f11245a = handlerThread;
                handlerThread.start();
                f11246b = new Handler(f11245a.getLooper());
            }
            v.d("PushServiceReceiver", c2.getPackageName() + ": start PushSerevice for by " + action + "  ; handler : " + f11246b);
            a.a(f11247c, c2, action);
            f11246b.removeCallbacks(f11247c);
            f11246b.postDelayed(f11247c, 2000L);
        }
    }
}
