package c.c.a.c.g;

import android.graphics.Canvas;
import android.os.Build;

/* compiled from: CanvasCompat.java */
/* loaded from: classes.dex */
public class a {
    public static int a(Canvas canvas, float f2, float f3, float f4, float f5, int i2) {
        return Build.VERSION.SDK_INT > 21 ? canvas.saveLayerAlpha(f2, f3, f4, f5, i2) : canvas.saveLayerAlpha(f2, f3, f4, f5, i2, 31);
    }
}
