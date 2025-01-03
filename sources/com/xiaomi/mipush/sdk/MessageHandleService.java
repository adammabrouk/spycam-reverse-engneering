package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import c.k.a.a.a.c;
import c.k.c.a.f0;
import c.k.c.a.n;
import c.k.c.a.o;
import c.k.c.a.t;
import c.k.c.a.u;
import c.k.c.a.w0;
import c.k.d.j;
import c.k.d.j4;
import c.k.d.n4;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class MessageHandleService extends BaseService {

    /* renamed from: b, reason: collision with root package name */
    public static ConcurrentLinkedQueue<a> f11252b = new ConcurrentLinkedQueue<>();

    /* renamed from: c, reason: collision with root package name */
    public static ExecutorService f11253c = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public PushMessageReceiver f11254a;

        /* renamed from: b, reason: collision with root package name */
        public Intent f11255b;

        public a(Intent intent, PushMessageReceiver pushMessageReceiver) {
            this.f11254a = pushMessageReceiver;
            this.f11255b = intent;
        }

        public Intent a() {
            return this.f11255b;
        }

        /* renamed from: a, reason: collision with other method in class */
        public PushMessageReceiver m576a() {
            return this.f11254a;
        }
    }

    public static void a(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        b(context);
    }

    public static void a(Context context, a aVar) {
        if (aVar != null) {
            f11252b.add(aVar);
            b(context);
            d(context);
        }
    }

    public static void b(Context context) {
        if (f11253c.isShutdown()) {
            return;
        }
        f11253c.execute(new u(context));
    }

    public static void c(Context context) {
        String[] stringArrayExtra;
        try {
            a poll = f11252b.poll();
            if (poll == null) {
                return;
            }
            PushMessageReceiver m576a = poll.m576a();
            Intent a2 = poll.a();
            int intExtra = a2.getIntExtra("message_type", 1);
            if (intExtra == 1) {
                PushMessageHandler.a a3 = f0.a(context).a(a2);
                int intExtra2 = a2.getIntExtra("eventMessageType", -1);
                if (a3 == null) {
                    return;
                }
                if (a3 instanceof o) {
                    o oVar = (o) a3;
                    if (!oVar.isArrivedMessage()) {
                        m576a.onReceiveMessage(context, oVar);
                    }
                    if (oVar.getPassThrough() == 1) {
                        j4.a(context.getApplicationContext()).a(context.getPackageName(), a2, 2004, (String) null);
                        c.m6a("begin execute onReceivePassThroughMessage from " + oVar.getMessageId());
                        m576a.onReceivePassThroughMessage(context, oVar);
                        return;
                    }
                    if (!oVar.isNotified()) {
                        m576a.onNotificationMessageArrived(context, oVar);
                        return;
                    }
                    if (intExtra2 == 1000) {
                        j4.a(context.getApplicationContext()).a(context.getPackageName(), a2, 1007, (String) null);
                    } else {
                        j4.a(context.getApplicationContext()).a(context.getPackageName(), a2, 3007, (String) null);
                    }
                    c.m6a("begin execute onNotificationMessageClicked from\u3000" + oVar.getMessageId());
                    m576a.onNotificationMessageClicked(context, oVar);
                    return;
                }
                if (!(a3 instanceof n)) {
                    return;
                }
                n nVar = (n) a3;
                c.m6a("begin execute onCommandResult, command=" + nVar.getCommand() + ", resultCode=" + nVar.getResultCode() + ", reason=" + nVar.getReason());
                m576a.onCommandResult(context, nVar);
                if (!TextUtils.equals(nVar.getCommand(), n4.COMMAND_REGISTER.f67a)) {
                    return;
                }
                m576a.onReceiveRegisterResult(context, nVar);
                PushMessageHandler.a(context, nVar);
                if (nVar.getResultCode() != 0) {
                    return;
                }
            } else {
                if (intExtra != 3) {
                    if (intExtra == 5 && "error_lack_of_permission".equals(a2.getStringExtra("error_type")) && (stringArrayExtra = a2.getStringArrayExtra("error_message")) != null) {
                        c.m6a("begin execute onRequirePermissions, lack of necessary permissions");
                        m576a.onRequirePermissions(context, stringArrayExtra);
                        return;
                    }
                    return;
                }
                n nVar2 = (n) a2.getSerializableExtra("key_command");
                c.m6a("(Local) begin execute onCommandResult, command=" + nVar2.getCommand() + ", resultCode=" + nVar2.getResultCode() + ", reason=" + nVar2.getReason());
                m576a.onCommandResult(context, nVar2);
                if (!TextUtils.equals(nVar2.getCommand(), n4.COMMAND_REGISTER.f67a)) {
                    return;
                }
                m576a.onReceiveRegisterResult(context, nVar2);
                PushMessageHandler.a(context, nVar2);
                if (nVar2.getResultCode() != 0) {
                    return;
                }
            }
            w0.b(context);
        } catch (RuntimeException e2) {
            c.a(e2);
        }
    }

    public static void d(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, (Class<?>) MessageHandleService.class));
        j.a(context).a(new t(context, intent));
    }

    @Override // com.xiaomi.mipush.sdk.BaseService
    /* renamed from: a */
    public boolean mo578a() {
        ConcurrentLinkedQueue<a> concurrentLinkedQueue = f11252b;
        return concurrentLinkedQueue != null && concurrentLinkedQueue.size() > 0;
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public void onStart(Intent intent, int i2) {
        super.onStart(intent, i2);
    }
}
