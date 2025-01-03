package c.c.a.c.a0.a;

import a.b.e.d;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.R$attr;

/* compiled from: MaterialThemeOverlay.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f5329a = {R.attr.theme, R$attr.theme};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f5330b = {R$attr.materialThemeOverlay};

    public static int a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f5329a);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(1, 0);
        obtainStyledAttributes.recycle();
        return resourceId != 0 ? resourceId : resourceId2;
    }

    public static Context b(Context context, AttributeSet attributeSet, int i2, int i3) {
        int a2 = a(context, attributeSet, i2, i3);
        boolean z = (context instanceof d) && ((d) context).b() == a2;
        if (a2 == 0 || z) {
            return context;
        }
        d dVar = new d(context, a2);
        int a3 = a(context, attributeSet);
        if (a3 != 0) {
            dVar.getTheme().applyStyle(a3, true);
        }
        return dVar;
    }

    public static int a(Context context, AttributeSet attributeSet, int i2, int i3) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f5330b, i2, i3);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        return resourceId;
    }
}
