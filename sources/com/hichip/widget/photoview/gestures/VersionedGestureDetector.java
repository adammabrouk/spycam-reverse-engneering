package com.hichip.widget.photoview.gestures;

import android.content.Context;
import android.os.Build;

/* loaded from: classes.dex */
public final class VersionedGestureDetector {
    public static GestureDetector newInstance(Context context, OnGestureListener onGestureListener) {
        int i2 = Build.VERSION.SDK_INT;
        GestureDetector cupcakeGestureDetector = i2 < 5 ? new CupcakeGestureDetector(context) : i2 < 8 ? new EclairGestureDetector(context) : new FroyoGestureDetector(context);
        cupcakeGestureDetector.setOnGestureListener(onGestureListener);
        return cupcakeGestureDetector;
    }
}
