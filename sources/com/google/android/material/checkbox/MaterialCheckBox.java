package com.google.android.material.checkbox;

import a.h.k.c;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatCheckBox;
import c.c.a.c.k.a;
import c.c.a.c.r.l;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;

/* loaded from: classes.dex */
public class MaterialCheckBox extends AppCompatCheckBox {

    /* renamed from: f, reason: collision with root package name */
    public static final int f10433f = R$style.Widget_MaterialComponents_CompoundButton_CheckBox;

    /* renamed from: g, reason: collision with root package name */
    public static final int[][] f10434g = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};

    /* renamed from: d, reason: collision with root package name */
    public ColorStateList f10435d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f10436e;

    public MaterialCheckBox(Context context) {
        this(context, null);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f10435d == null) {
            int[] iArr = new int[f10434g.length];
            int a2 = a.a(this, R$attr.colorControlActivated);
            int a3 = a.a(this, R$attr.colorSurface);
            int a4 = a.a(this, R$attr.colorOnSurface);
            iArr[0] = a.a(a3, a2, 1.0f);
            iArr[1] = a.a(a3, a4, 0.54f);
            iArr[2] = a.a(a3, a4, 0.38f);
            iArr[3] = a.a(a3, a4, 0.38f);
            this.f10435d = new ColorStateList(f10434g, iArr);
        }
        return this.f10435d;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f10436e && c.b(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.f10436e = z;
        if (z) {
            c.a(this, getMaterialThemeColorsTintList());
        } else {
            c.a(this, (ColorStateList) null);
        }
    }

    public MaterialCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.checkboxStyle);
    }

    public MaterialCheckBox(Context context, AttributeSet attributeSet, int i2) {
        super(c.c.a.c.a0.a.a.b(context, attributeSet, i2, f10433f), attributeSet, i2);
        Context context2 = getContext();
        TypedArray c2 = l.c(context2, attributeSet, R$styleable.MaterialCheckBox, i2, f10433f, new int[0]);
        if (c2.hasValue(R$styleable.MaterialCheckBox_buttonTint)) {
            c.a(this, c.c.a.c.t.c.a(context2, c2, R$styleable.MaterialCheckBox_buttonTint));
        }
        this.f10436e = c2.getBoolean(R$styleable.MaterialCheckBox_useMaterialThemeColors, false);
        c2.recycle();
    }
}
