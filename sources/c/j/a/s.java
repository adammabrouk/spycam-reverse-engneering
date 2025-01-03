package c.j.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/* compiled from: PushClientThread.java */
/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public static final Handler f6638a = new Handler(Looper.getMainLooper());

    /* renamed from: b, reason: collision with root package name */
    public static final HandlerThread f6639b;

    /* renamed from: c, reason: collision with root package name */
    public static final Handler f6640c;

    static {
        HandlerThread handlerThread = new HandlerThread("push_client_thread");
        f6639b = handlerThread;
        handlerThread.start();
        f6640c = new u(f6639b.getLooper());
    }

    public static void a(r rVar) {
        if (rVar == null) {
            c.j.a.z.v.a("PushClientThread", "client thread error, task is null!");
            return;
        }
        int a2 = rVar.a();
        Message message = new Message();
        message.what = a2;
        message.obj = rVar;
        f6640c.sendMessageDelayed(message, 0L);
    }

    public static void b(Runnable runnable) {
        f6638a.post(runnable);
    }

    public static void c(Runnable runnable) {
        Handler handler = f6640c;
        if (handler != null) {
            handler.post(runnable);
        }
    }

    public static void a(Runnable runnable) {
        f6640c.removeCallbacks(runnable);
        f6640c.postDelayed(runnable, 15000L);
    }
}
