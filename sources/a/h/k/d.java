package a.h.k;

import android.os.Build;
import android.widget.EdgeEffect;

/* compiled from: EdgeEffectCompat.java */
/* loaded from: classes.dex */
public final class d {
    public static void a(EdgeEffect edgeEffect, float f2, float f3) {
        if (Build.VERSION.SDK_INT >= 21) {
            edgeEffect.onPull(f2, f3);
        } else {
            edgeEffect.onPull(f2);
        }
    }
}
