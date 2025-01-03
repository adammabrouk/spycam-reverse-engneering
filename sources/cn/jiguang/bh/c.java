package cn.jiguang.bh;

import android.os.Looper;

/* loaded from: classes.dex */
public final class c {
    public static boolean a(long j) {
        return Looper.getMainLooper().getThread().getId() == j;
    }

    public static boolean a(Thread thread) {
        return a(thread.getId());
    }
}
