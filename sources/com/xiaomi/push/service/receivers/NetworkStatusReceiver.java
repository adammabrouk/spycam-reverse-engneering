package com.xiaomi.push.service.receivers;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import c.k.a.a.a.c;
import c.k.c.a.b;
import c.k.c.a.d;
import c.k.c.a.e;
import c.k.c.a.i0;
import c.k.c.a.l;
import c.k.c.a.n0;
import c.k.c.a.q0;
import c.k.c.a.z;
import c.k.d.g6;
import c.k.d.p9.e0;
import c.k.d.p9.r1.a;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class NetworkStatusReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public boolean f11309a;

    /* renamed from: e, reason: collision with root package name */
    public static BlockingQueue<Runnable> f11306e = new LinkedBlockingQueue();

    /* renamed from: b, reason: collision with root package name */
    public static int f11303b = 1;

    /* renamed from: c, reason: collision with root package name */
    public static int f11304c = 1;

    /* renamed from: d, reason: collision with root package name */
    public static int f11305d = 2;

    /* renamed from: f, reason: collision with root package name */
    public static ThreadPoolExecutor f11307f = new ThreadPoolExecutor(f11303b, f11304c, f11305d, TimeUnit.SECONDS, f11306e);

    /* renamed from: g, reason: collision with root package name */
    public static boolean f11308g = false;

    public NetworkStatusReceiver() {
        this.f11309a = false;
        this.f11309a = true;
    }

    public NetworkStatusReceiver(Object obj) {
        this.f11309a = false;
        f11308g = true;
    }

    public static boolean a() {
        return f11308g;
    }

    public final void a(Context context) {
        if (!i0.a(context).m27a() && q0.m45a(context).m52c() && !q0.m45a(context).m54e()) {
            try {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(context, "com.xiaomi.push.service.XMPushService"));
                intent.setAction("com.xiaomi.push.network_status_changed");
                e0.a(context).m368a(intent);
            } catch (Exception e2) {
                c.a(e2);
            }
        }
        g6.m178a(context);
        if (c.k.d.e0.b(context) && i0.a(context).m30b()) {
            i0.a(context).m31c();
        }
        if (c.k.d.e0.b(context)) {
            if ("syncing".equals(z.a(context).a(n0.DISABLE_PUSH))) {
                l.g(context);
            }
            if ("syncing".equals(z.a(context).a(n0.ENABLE_PUSH))) {
                l.h(context);
            }
            if ("syncing".equals(z.a(context).a(n0.UPLOAD_HUAWEI_TOKEN))) {
                l.F(context);
            }
            if ("syncing".equals(z.a(context).a(n0.UPLOAD_FCM_TOKEN))) {
                l.D(context);
            }
            if ("syncing".equals(z.a(context).a(n0.UPLOAD_COS_TOKEN))) {
                l.C(context);
            }
            if ("syncing".equals(z.a(context).a(n0.UPLOAD_FTOS_TOKEN))) {
                l.E(context);
            }
            if (e.a() && e.c(context)) {
                e.b(context);
                e.a(context);
            }
            b.a(context);
            d.b(context);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.f11309a) {
            return;
        }
        f11307f.execute(new a(this, context));
    }
}
