package a.b.f;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import androidx.appcompat.R$styleable;

/* compiled from: ThemeUtils.java */
/* loaded from: classes.dex */
public class b0 {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<TypedValue> f431a = new ThreadLocal<>();

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f432b = {-16842910};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f433c = {R.attr.state_focused};

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f434d = {R.attr.state_pressed};

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f435e = {R.attr.state_checked};

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f436f = new int[0];

    /* renamed from: g, reason: collision with root package name */
    public static final int[] f437g = new int[1];

    public static int a(Context context, int i2) {
        ColorStateList c2 = c(context, i2);
        if (c2 != null && c2.isStateful()) {
            return c2.getColorForState(f432b, c2.getDefaultColor());
        }
        TypedValue a2 = a();
        context.getTheme().resolveAttribute(R.attr.disabledAlpha, a2, true);
        return a(context, i2, a2.getFloat());
    }

    public static int b(Context context, int i2) {
        int[] iArr = f437g;
        iArr[0] = i2;
        g0 a2 = g0.a(context, (AttributeSet) null, iArr);
        try {
            return a2.a(0, 0);
        } finally {
            a2.b();
        }
    }

    public static ColorStateList c(Context context, int i2) {
        int[] iArr = f437g;
        iArr[0] = i2;
        g0 a2 = g0.a(context, (AttributeSet) null, iArr);
        try {
            return a2.a(0);
        } finally {
            a2.b();
        }
    }

    public static TypedValue a() {
        TypedValue typedValue = f431a.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        f431a.set(typedValue2);
        return typedValue2;
    }

    public static int a(Context context, int i2, float f2) {
        return a.h.c.a.c(b(context, i2), Math.round(Color.alpha(r0) * f2));
    }

    public static void a(View view, Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(R$styleable.AppCompatTheme);
        try {
            if (!obtainStyledAttributes.hasValue(R$styleable.AppCompatTheme_windowActionBar)) {
                Log.e("ThemeUtils", "View " + view.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }
}
