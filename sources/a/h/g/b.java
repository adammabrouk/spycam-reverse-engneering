package a.h.g;

import android.os.Handler;
import android.os.Looper;

/* compiled from: CalleeHandler.java */
/* loaded from: classes.dex */
public class b {
    public static Handler a() {
        return Looper.myLooper() == null ? new Handler(Looper.getMainLooper()) : new Handler();
    }
}
