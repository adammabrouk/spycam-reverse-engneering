package com.google.android.material.appbar;

import a.h.j.y;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.Toolbar;
import c.c.a.c.a0.a.a;
import c.c.a.c.w.h;
import c.c.a.c.w.i;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;

/* loaded from: classes.dex */
public class MaterialToolbar extends Toolbar {
    public static final int Q = R$style.Widget_MaterialComponents_Toolbar;

    public MaterialToolbar(Context context) {
        this(context, null);
    }

    public final void a(Context context) {
        Drawable background = getBackground();
        if (background == null || (background instanceof ColorDrawable)) {
            h hVar = new h();
            hVar.a(ColorStateList.valueOf(background != null ? ((ColorDrawable) background).getColor() : 0));
            hVar.a(context);
            hVar.b(y.l(this));
            y.a(this, hVar);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        i.a(this);
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        super.setElevation(f2);
        i.a(this, f2);
    }

    public MaterialToolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.toolbarStyle);
    }

    public MaterialToolbar(Context context, AttributeSet attributeSet, int i2) {
        super(a.b(context, attributeSet, i2, Q), attributeSet, i2);
        a(getContext());
    }
}
