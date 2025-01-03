package com.google.android.material.switchmaterial;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.SwitchCompat;
import c.c.a.c.o.a;
import c.c.a.c.r.l;
import c.c.a.c.r.r;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;

/* loaded from: classes.dex */
public class SwitchMaterial extends SwitchCompat {
    public static final int U = R$style.Widget_MaterialComponents_CompoundButton_Switch;
    public static final int[][] V = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};
    public final a Q;
    public ColorStateList R;
    public ColorStateList S;
    public boolean T;

    public SwitchMaterial(Context context) {
        this(context, null);
    }

    private ColorStateList getMaterialThemeColorsThumbTintList() {
        if (this.R == null) {
            int a2 = c.c.a.c.k.a.a(this, R$attr.colorSurface);
            int a3 = c.c.a.c.k.a.a(this, R$attr.colorControlActivated);
            float dimension = getResources().getDimension(R$dimen.mtrl_switch_thumb_elevation);
            if (this.Q.a()) {
                dimension += r.d(this);
            }
            int b2 = this.Q.b(a2, dimension);
            int[] iArr = new int[V.length];
            iArr[0] = c.c.a.c.k.a.a(a2, a3, 1.0f);
            iArr[1] = b2;
            iArr[2] = c.c.a.c.k.a.a(a2, a3, 0.38f);
            iArr[3] = b2;
            this.R = new ColorStateList(V, iArr);
        }
        return this.R;
    }

    private ColorStateList getMaterialThemeColorsTrackTintList() {
        if (this.S == null) {
            int[] iArr = new int[V.length];
            int a2 = c.c.a.c.k.a.a(this, R$attr.colorSurface);
            int a3 = c.c.a.c.k.a.a(this, R$attr.colorControlActivated);
            int a4 = c.c.a.c.k.a.a(this, R$attr.colorOnSurface);
            iArr[0] = c.c.a.c.k.a.a(a2, a3, 0.54f);
            iArr[1] = c.c.a.c.k.a.a(a2, a4, 0.32f);
            iArr[2] = c.c.a.c.k.a.a(a2, a3, 0.12f);
            iArr[3] = c.c.a.c.k.a.a(a2, a4, 0.12f);
            this.S = new ColorStateList(V, iArr);
        }
        return this.S;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.T && getThumbTintList() == null) {
            setThumbTintList(getMaterialThemeColorsThumbTintList());
        }
        if (this.T && getTrackTintList() == null) {
            setTrackTintList(getMaterialThemeColorsTrackTintList());
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.T = z;
        if (z) {
            setThumbTintList(getMaterialThemeColorsThumbTintList());
            setTrackTintList(getMaterialThemeColorsTrackTintList());
        } else {
            setThumbTintList(null);
            setTrackTintList(null);
        }
    }

    public SwitchMaterial(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.switchStyle);
    }

    public SwitchMaterial(Context context, AttributeSet attributeSet, int i2) {
        super(c.c.a.c.a0.a.a.b(context, attributeSet, i2, U), attributeSet, i2);
        Context context2 = getContext();
        this.Q = new a(context2);
        TypedArray c2 = l.c(context2, attributeSet, R$styleable.SwitchMaterial, i2, U, new int[0]);
        this.T = c2.getBoolean(R$styleable.SwitchMaterial_useMaterialThemeColors, false);
        c2.recycle();
    }
}
