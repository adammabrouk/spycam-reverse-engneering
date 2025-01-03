package c.j.a.z;

import android.os.Looper;
import android.util.Log;

/* compiled from: DebugUtil.java */
/* loaded from: classes.dex */
public final class m {
    public static void a(String str) {
        if (v.a() && Looper.myLooper() == Looper.getMainLooper()) {
            Log.w("DebugUtil", "Operation: " + str + " in main thread!", new Throwable());
        }
    }
}
