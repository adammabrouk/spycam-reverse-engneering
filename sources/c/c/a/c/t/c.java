package c.c.a.c.t;

import a.b.f.g0;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;

/* compiled from: MaterialResources.java */
/* loaded from: classes.dex */
public class c {
    public static ColorStateList a(Context context, TypedArray typedArray, int i2) {
        int color;
        int resourceId;
        ColorStateList b2;
        return (!typedArray.hasValue(i2) || (resourceId = typedArray.getResourceId(i2, 0)) == 0 || (b2 = a.b.b.a.a.b(context, resourceId)) == null) ? (Build.VERSION.SDK_INT > 15 || (color = typedArray.getColor(i2, -1)) == -1) ? typedArray.getColorStateList(i2) : ColorStateList.valueOf(color) : b2;
    }

    public static Drawable b(Context context, TypedArray typedArray, int i2) {
        int resourceId;
        Drawable c2;
        return (!typedArray.hasValue(i2) || (resourceId = typedArray.getResourceId(i2, 0)) == 0 || (c2 = a.b.b.a.a.c(context, resourceId)) == null) ? typedArray.getDrawable(i2) : c2;
    }

    public static d c(Context context, TypedArray typedArray, int i2) {
        int resourceId;
        if (!typedArray.hasValue(i2) || (resourceId = typedArray.getResourceId(i2, 0)) == 0) {
            return null;
        }
        return new d(context, resourceId);
    }

    public static ColorStateList a(Context context, g0 g0Var, int i2) {
        int a2;
        int g2;
        ColorStateList b2;
        if (g0Var.g(i2) && (g2 = g0Var.g(i2, 0)) != 0 && (b2 = a.b.b.a.a.b(context, g2)) != null) {
            return b2;
        }
        if (Build.VERSION.SDK_INT <= 15 && (a2 = g0Var.a(i2, -1)) != -1) {
            return ColorStateList.valueOf(a2);
        }
        return g0Var.a(i2);
    }

    public static int a(Context context, TypedArray typedArray, int i2, int i3) {
        TypedValue typedValue = new TypedValue();
        if (typedArray.getValue(i2, typedValue) && typedValue.type == 2) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{typedValue.data});
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, i3);
            obtainStyledAttributes.recycle();
            return dimensionPixelSize;
        }
        return typedArray.getDimensionPixelSize(i2, i3);
    }

    public static int a(TypedArray typedArray, int i2, int i3) {
        return typedArray.hasValue(i2) ? i2 : i3;
    }
}
