package cn.jpush.android.af;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static volatile HandlerThread f9096a;

    /* renamed from: b, reason: collision with root package name */
    public static volatile Handler f9097b;

    /* renamed from: c, reason: collision with root package name */
    public static volatile Handler f9098c;

    public static Handler a() {
        if (f9096a == null || !f9096a.isAlive()) {
            synchronized (c.class) {
                if (f9096a == null || !f9096a.isAlive()) {
                    f9096a = new HandlerThread("jg_union_thread_load", 10);
                    f9096a.start();
                    f9098c = new Handler(f9096a.getLooper());
                }
            }
        }
        return f9098c;
    }

    public static Handler b() {
        if (f9097b == null) {
            synchronized (c.class) {
                if (f9097b == null) {
                    try {
                        f9097b = new Handler(Looper.getMainLooper());
                    } catch (Throwable unused) {
                        f9097b = new Handler(Looper.getMainLooper());
                    }
                }
            }
        }
        return f9097b;
    }
}
