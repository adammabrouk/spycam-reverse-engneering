package a.t;

import android.animation.ObjectAnimator;
import android.animation.TypeConverter;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build;
import android.util.Property;

/* compiled from: ObjectAnimatorUtils.java */
/* loaded from: classes.dex */
public class q {
    public static <T> ObjectAnimator a(T t, Property<T, PointF> property, Path path) {
        return Build.VERSION.SDK_INT >= 21 ? ObjectAnimator.ofObject(t, property, (TypeConverter) null, path) : ObjectAnimator.ofFloat(t, new s(property, path), 0.0f, 1.0f);
    }
}
