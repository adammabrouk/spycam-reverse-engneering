package com.google.android.material.radiobutton;

import a.h.k.c;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatRadioButton;
import c.c.a.c.k.a;
import c.c.a.c.r.l;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;

/* loaded from: classes.dex */
public class MaterialRadioButton extends AppCompatRadioButton {

    /* renamed from: f, reason: collision with root package name */
    public static final int f10565f = R$style.Widget_MaterialComponents_CompoundButton_RadioButton;

    /* renamed from: g, reason: collision with root package name */
    public static final int[][] f10566g = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};

    /* renamed from: d, reason: collision with root package name */
    public ColorStateList f10567d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f10568e;

    public MaterialRadioButton(Context context) {
        this(context, null);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f10567d == null) {
            int a2 = a.a(this, R$attr.colorControlActivated);
            int a3 = a.a(this, R$attr.colorOnSurface);
            int a4 = a.a(this, R$attr.colorSurface);
            int[] iArr = new int[f10566g.length];
            iArr[0] = a.a(a4, a2, 1.0f);
            iArr[1] = a.a(a4, a3, 0.54f);
            iArr[2] = a.a(a4, a3, 0.38f);
            iArr[3] = a.a(a4, a3, 0.38f);
            this.f10567d = new ColorStateList(f10566g, iArr);
        }
        return this.f10567d;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f10568e && c.b(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.f10568e = z;
        if (z) {
            c.a(this, getMaterialThemeColorsTintList());
        } else {
            c.a(this, (ColorStateList) null);
        }
    }

    public MaterialRadioButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.radioButtonStyle);
    }

    public MaterialRadioButton(Context context, AttributeSet attributeSet, int i2) {
        super(c.c.a.c.a0.a.a.b(context, attributeSet, i2, f10565f), attributeSet, i2);
        Context context2 = getContext();
        TypedArray c2 = l.c(context2, attributeSet, R$styleable.MaterialRadioButton, i2, f10565f, new int[0]);
        if (c2.hasValue(R$styleable.MaterialRadioButton_buttonTint)) {
            c.a(this, c.c.a.c.t.c.a(context2, c2, R$styleable.MaterialRadioButton_buttonTint));
        }
        this.f10568e = c2.getBoolean(R$styleable.MaterialRadioButton_useMaterialThemeColors, false);
        c2.recycle();
    }
}
