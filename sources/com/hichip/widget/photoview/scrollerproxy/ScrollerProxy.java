package com.hichip.widget.photoview.scrollerproxy;

import android.content.Context;
import android.os.Build;

/* loaded from: classes.dex */
public abstract class ScrollerProxy {
    public static ScrollerProxy getScroller(Context context) {
        int i2 = Build.VERSION.SDK_INT;
        return i2 < 9 ? new PreGingerScroller(context) : i2 < 14 ? new GingerScroller(context) : new IcsScroller(context);
    }

    public abstract boolean computeScrollOffset();

    public abstract void fling(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11);

    public abstract void forceFinished(boolean z);

    public abstract int getCurrX();

    public abstract int getCurrY();

    public abstract boolean isFinished();
}
