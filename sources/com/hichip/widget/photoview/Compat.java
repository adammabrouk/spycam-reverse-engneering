package com.hichip.widget.photoview;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;

/* loaded from: classes.dex */
public class Compat {
    public static final int SIXTY_FPS_INTERVAL = 16;

    public static int getPointerIndex(int i2) {
        return Build.VERSION.SDK_INT >= 11 ? getPointerIndexHoneyComb(i2) : getPointerIndexEclair(i2);
    }

    @TargetApi(5)
    public static int getPointerIndexEclair(int i2) {
        return (i2 & 65280) >> 8;
    }

    @TargetApi(11)
    public static int getPointerIndexHoneyComb(int i2) {
        return (i2 & 65280) >> 8;
    }

    public static void postOnAnimation(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            postOnAnimationJellyBean(view, runnable);
        } else {
            view.postDelayed(runnable, 16L);
        }
    }

    @TargetApi(16)
    public static void postOnAnimationJellyBean(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }
}
