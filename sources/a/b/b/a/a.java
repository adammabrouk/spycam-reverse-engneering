package a.b.b.a;

import a.b.f.x;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.util.WeakHashMap;

/* compiled from: AppCompatResources.java */
@SuppressLint({"RestrictedAPI"})
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<TypedValue> f220a = new ThreadLocal<>();

    /* renamed from: b, reason: collision with root package name */
    public static final WeakHashMap<Context, SparseArray<C0002a>> f221b = new WeakHashMap<>(0);

    /* renamed from: c, reason: collision with root package name */
    public static final Object f222c = new Object();

    /* compiled from: AppCompatResources.java */
    /* renamed from: a.b.b.a.a$a, reason: collision with other inner class name */
    public static class C0002a {

        /* renamed from: a, reason: collision with root package name */
        public final ColorStateList f223a;

        /* renamed from: b, reason: collision with root package name */
        public final Configuration f224b;

        public C0002a(ColorStateList colorStateList, Configuration configuration) {
            this.f223a = colorStateList;
            this.f224b = configuration;
        }
    }

    public static ColorStateList a(Context context, int i2) {
        C0002a c0002a;
        synchronized (f222c) {
            SparseArray<C0002a> sparseArray = f221b.get(context);
            if (sparseArray != null && sparseArray.size() > 0 && (c0002a = sparseArray.get(i2)) != null) {
                if (c0002a.f224b.equals(context.getResources().getConfiguration())) {
                    return c0002a.f223a;
                }
                sparseArray.remove(i2);
            }
            return null;
        }
    }

    public static ColorStateList b(Context context, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i2);
        }
        ColorStateList a2 = a(context, i2);
        if (a2 != null) {
            return a2;
        }
        ColorStateList d2 = d(context, i2);
        if (d2 == null) {
            return a.h.b.a.b(context, i2);
        }
        a(context, i2, d2);
        return d2;
    }

    public static Drawable c(Context context, int i2) {
        return x.a().b(context, i2);
    }

    public static ColorStateList d(Context context, int i2) {
        if (e(context, i2)) {
            return null;
        }
        Resources resources = context.getResources();
        try {
            return a.h.b.d.a.a(resources, resources.getXml(i2), context.getTheme());
        } catch (Exception e2) {
            Log.e("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", e2);
            return null;
        }
    }

    public static boolean e(Context context, int i2) {
        Resources resources = context.getResources();
        TypedValue a2 = a();
        resources.getValue(i2, a2, true);
        int i3 = a2.type;
        return i3 >= 28 && i3 <= 31;
    }

    public static void a(Context context, int i2, ColorStateList colorStateList) {
        synchronized (f222c) {
            SparseArray<C0002a> sparseArray = f221b.get(context);
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                f221b.put(context, sparseArray);
            }
            sparseArray.append(i2, new C0002a(colorStateList, context.getResources().getConfiguration()));
        }
    }

    public static TypedValue a() {
        TypedValue typedValue = f220a.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        f220a.set(typedValue2);
        return typedValue2;
    }
}
