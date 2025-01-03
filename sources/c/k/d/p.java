package c.k.d;

import android.os.Looper;

/* loaded from: classes.dex */
public class p {
    public static void a() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            throw new RuntimeException("can't do this on ui thread");
        }
    }
}
