package c.e.b.f;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;

/* compiled from: Compat.java */
/* loaded from: classes.dex */
public class a {
    public static void a(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            b(view, runnable);
        } else {
            view.postDelayed(runnable, 16L);
        }
    }

    @TargetApi(16)
    public static void b(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }
}
