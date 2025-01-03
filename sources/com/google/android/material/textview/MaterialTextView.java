package com.google.android.material.textview;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import c.c.a.c.a0.a.a;
import c.c.a.c.t.b;
import c.c.a.c.t.c;
import com.google.android.material.R$attr;
import com.google.android.material.R$styleable;

/* loaded from: classes.dex */
public class MaterialTextView extends AppCompatTextView {
    public MaterialTextView(Context context) {
        this(context, null);
    }

    public final void a(Resources.Theme theme, int i2) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(i2, R$styleable.MaterialTextAppearance);
        int a2 = a(getContext(), obtainStyledAttributes, R$styleable.MaterialTextAppearance_android_lineHeight, R$styleable.MaterialTextAppearance_lineHeight);
        obtainStyledAttributes.recycle();
        if (a2 >= 0) {
            setLineHeight(a2);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        if (a(context)) {
            a(context.getTheme(), i2);
        }
    }

    public MaterialTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    public MaterialTextView(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public MaterialTextView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(a.b(context, attributeSet, i2, i3), attributeSet, i2);
        int a2;
        Context context2 = getContext();
        if (a(context2)) {
            Resources.Theme theme = context2.getTheme();
            if (a(context2, theme, attributeSet, i2, i3) || (a2 = a(theme, attributeSet, i2, i3)) == -1) {
                return;
            }
            a(theme, a2);
        }
    }

    public static boolean a(Context context) {
        return b.a(context, R$attr.textAppearanceLineHeightEnabled, true);
    }

    public static int a(Context context, TypedArray typedArray, int... iArr) {
        int i2 = -1;
        for (int i3 = 0; i3 < iArr.length && i2 < 0; i3++) {
            i2 = c.a(context, typedArray, iArr[i3], -1);
        }
        return i2;
    }

    public static boolean a(Context context, Resources.Theme theme, AttributeSet attributeSet, int i2, int i3) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, R$styleable.MaterialTextView, i2, i3);
        int a2 = a(context, obtainStyledAttributes, R$styleable.MaterialTextView_android_lineHeight, R$styleable.MaterialTextView_lineHeight);
        obtainStyledAttributes.recycle();
        return a2 != -1;
    }

    public static int a(Resources.Theme theme, AttributeSet attributeSet, int i2, int i3) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, R$styleable.MaterialTextView, i2, i3);
        int resourceId = obtainStyledAttributes.getResourceId(R$styleable.MaterialTextView_android_textAppearance, -1);
        obtainStyledAttributes.recycle();
        return resourceId;
    }
}
