package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.IBinder;
import android.text.TextUtils;
import c.k.a.a.a.c;
import c.k.c.a.c1;
import c.k.c.a.e0;
import c.k.c.a.f;
import c.k.c.a.f0;
import c.k.c.a.l;
import c.k.c.a.n;
import c.k.c.a.o;
import c.k.c.a.p;
import c.k.c.a.r;
import c.k.d.h8;
import c.k.d.j4;
import c.k.d.n4;
import c.k.d.q9;
import c.k.d.z6;
import com.xiaomi.mipush.sdk.MessageHandleService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class PushMessageHandler extends BaseService {

    /* renamed from: b, reason: collision with root package name */
    public static List<l.a> f11256b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public static List<l.b> f11257c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public static ThreadPoolExecutor f11258d = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    public interface a extends Serializable {
    }

    public static void a() {
        synchronized (f11257c) {
            f11257c.clear();
        }
    }

    public static void a(long j, String str, String str2) {
        synchronized (f11257c) {
            Iterator<l.b> it = f11257c.iterator();
            while (it.hasNext()) {
                it.next().a(j, str, str2);
            }
        }
    }

    public static void a(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, (Class<?>) PushMessageHandler.class));
        try {
            context.startService(intent);
        } catch (Exception e2) {
            c.m6a(e2.getMessage());
        }
    }

    public static void a(Context context, Intent intent) {
        c.c("addjob PushMessageHandler " + intent);
        if (intent != null) {
            c(context, intent);
            a(context);
        }
    }

    public static void a(Context context, Intent intent, ResolveInfo resolveInfo) {
        try {
            MessageHandleService.a(context.getApplicationContext(), new MessageHandleService.a(intent, (PushMessageReceiver) q9.a(context, resolveInfo.activityInfo.name).newInstance()));
            MessageHandleService.a(context, new Intent(context.getApplicationContext(), (Class<?>) MessageHandleService.class));
        } catch (Throwable th) {
            c.a(th);
        }
    }

    public static void a(Context context, n nVar) {
        synchronized (f11256b) {
            for (l.a aVar : f11256b) {
            }
        }
    }

    public static void a(Context context, o oVar) {
        synchronized (f11257c) {
            for (l.b bVar : f11257c) {
                if (a(oVar.getCategory(), bVar.a())) {
                    bVar.a(oVar.getContent(), oVar.getAlias(), oVar.getTopic(), oVar.isNotified());
                    bVar.a(oVar);
                }
            }
        }
    }

    public static void a(Context context, a aVar) {
        if (aVar instanceof o) {
            a(context, (o) aVar);
            return;
        }
        if (aVar instanceof n) {
            n nVar = (n) aVar;
            String command = nVar.getCommand();
            String str = null;
            if (n4.COMMAND_REGISTER.f67a.equals(command)) {
                List<String> commandArguments = nVar.getCommandArguments();
                if (commandArguments != null && !commandArguments.isEmpty()) {
                    str = commandArguments.get(0);
                }
                a(nVar.getResultCode(), nVar.getReason(), str);
                return;
            }
            if (n4.COMMAND_SET_ALIAS.f67a.equals(command) || n4.COMMAND_UNSET_ALIAS.f67a.equals(command) || n4.COMMAND_SET_ACCEPT_TIME.f67a.equals(command)) {
                a(context, nVar.getCategory(), command, nVar.getResultCode(), nVar.getReason(), nVar.getCommandArguments());
                return;
            }
            if (n4.COMMAND_SUBSCRIBE_TOPIC.f67a.equals(command)) {
                List<String> commandArguments2 = nVar.getCommandArguments();
                if (commandArguments2 != null && !commandArguments2.isEmpty()) {
                    str = commandArguments2.get(0);
                }
                a(context, nVar.getCategory(), nVar.getResultCode(), nVar.getReason(), str);
                return;
            }
            if (n4.COMMAND_UNSUBSCRIBE_TOPIC.f67a.equals(command)) {
                List<String> commandArguments3 = nVar.getCommandArguments();
                if (commandArguments3 != null && !commandArguments3.isEmpty()) {
                    str = commandArguments3.get(0);
                }
                b(context, nVar.getCategory(), nVar.getResultCode(), nVar.getReason(), str);
            }
        }
    }

    public static void a(Context context, String str, long j, String str2, String str3) {
        synchronized (f11257c) {
            for (l.b bVar : f11257c) {
                if (a(str, bVar.a())) {
                    bVar.b(j, str2, str3);
                }
            }
        }
    }

    public static void a(Context context, String str, String str2, long j, String str3, List<String> list) {
        synchronized (f11257c) {
            for (l.b bVar : f11257c) {
                if (a(str, bVar.a())) {
                    bVar.a(str2, j, str3, list);
                }
            }
        }
    }

    public static void a(l.a aVar) {
        synchronized (f11256b) {
            if (!f11256b.contains(aVar)) {
                f11256b.add(aVar);
            }
        }
    }

    public static void a(l.b bVar) {
        synchronized (f11257c) {
            if (!f11257c.contains(bVar)) {
                f11257c.add(bVar);
            }
        }
    }

    public static boolean a(String str, String str2) {
        return (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || TextUtils.equals(str, str2);
    }

    public static void b() {
        synchronized (f11256b) {
            f11256b.clear();
        }
    }

    public static void b(Context context, Intent intent) {
        try {
            ResolveInfo resolveInfo = null;
            if ("com.xiaomi.mipush.sdk.WAKEUP".equals(intent.getAction())) {
                c1.a(context, intent, null);
                return;
            }
            if ("com.xiaomi.mipush.SEND_TINYDATA".equals(intent.getAction())) {
                z6 z6Var = new z6();
                h8.a(z6Var, intent.getByteArrayExtra("mipush_payload"));
                c.c("PushMessageHandler.onHandleIntent " + z6Var.d());
                p.a(context, z6Var);
                return;
            }
            if (1 == r.a(context)) {
                if (m577b()) {
                    c.d("receive a message before application calling initialize");
                    return;
                }
                a a2 = f0.a(context).a(intent);
                if (a2 != null) {
                    a(context, a2);
                    return;
                }
                return;
            }
            if ("com.xiaomi.mipush.sdk.SYNC_LOG".equals(intent.getAction())) {
                f.a(context, false);
                return;
            }
            Intent intent2 = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
            intent2.setPackage(context.getPackageName());
            intent2.putExtras(intent);
            try {
                List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent2, 32);
                if (queryBroadcastReceivers != null) {
                    Iterator<ResolveInfo> it = queryBroadcastReceivers.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ResolveInfo next = it.next();
                        if (next.activityInfo != null && next.activityInfo.packageName.equals(context.getPackageName()) && PushMessageReceiver.class.isAssignableFrom(q9.a(context, next.activityInfo.name))) {
                            resolveInfo = next;
                            break;
                        }
                    }
                }
                if (resolveInfo != null) {
                    a(context, intent2, resolveInfo);
                } else {
                    c.d("cannot find the receiver to handler this message, check your manifest");
                    j4.a(context).a(context.getPackageName(), intent, "11");
                }
            } catch (Exception e2) {
                c.a(e2);
                j4.a(context).a(context.getPackageName(), intent, "9");
            }
        } catch (Throwable th) {
            c.a(th);
            j4.a(context).a(context.getPackageName(), intent, "10");
        }
    }

    public static void b(Context context, String str, long j, String str2, String str3) {
        synchronized (f11257c) {
            for (l.b bVar : f11257c) {
                if (a(str, bVar.a())) {
                    bVar.c(j, str2, str3);
                }
            }
        }
    }

    /* renamed from: b, reason: collision with other method in class */
    public static boolean m577b() {
        return f11257c.isEmpty();
    }

    public static void c(Context context, Intent intent) {
        if (intent == null || f11258d.isShutdown()) {
            return;
        }
        f11258d.execute(new e0(context, intent));
    }

    @Override // com.xiaomi.mipush.sdk.BaseService
    /* renamed from: a, reason: collision with other method in class */
    public boolean mo578a() {
        ThreadPoolExecutor threadPoolExecutor = f11258d;
        return (threadPoolExecutor == null || threadPoolExecutor.getQueue() == null || f11258d.getQueue().size() <= 0) ? false : true;
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public void onStart(Intent intent, int i2) {
        super.onStart(intent, i2);
        c(getApplicationContext(), intent);
    }
}
