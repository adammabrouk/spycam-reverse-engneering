package c.c.a.b.c.o;

import android.os.Looper;
import android.util.Log;

/* loaded from: classes.dex */
public final class b {
    public static void a(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("null reference");
        }
    }

    public static void b(String str) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            return;
        }
        String valueOf = String.valueOf(Thread.currentThread());
        String valueOf2 = String.valueOf(Looper.getMainLooper().getThread());
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 56 + String.valueOf(valueOf2).length());
        sb.append("checkNotMainThread: current thread ");
        sb.append(valueOf);
        sb.append(" IS the main thread ");
        sb.append(valueOf2);
        sb.append("!");
        Log.e("Asserts", sb.toString());
        throw new IllegalStateException(str);
    }

    public static void a(String str) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            return;
        }
        String valueOf = String.valueOf(Thread.currentThread());
        String valueOf2 = String.valueOf(Looper.getMainLooper().getThread());
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 57 + String.valueOf(valueOf2).length());
        sb.append("checkMainThread: current thread ");
        sb.append(valueOf);
        sb.append(" IS NOT the main thread ");
        sb.append(valueOf2);
        sb.append("!");
        Log.e("Asserts", sb.toString());
        throw new IllegalStateException(str);
    }
}
