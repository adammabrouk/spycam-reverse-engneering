package com.google.android.gms.common.internal;

import a.h.c.l.a;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Button;
import c.c.a.b.c.o.r;
import c.c.a.b.c.s.i;
import com.google.android.gms.base.R$color;
import com.google.android.gms.base.R$drawable;
import com.google.android.gms.base.R$string;

/* loaded from: classes.dex */
public final class SignInButtonImpl extends Button {
    public SignInButtonImpl(Context context) {
        this(context, null);
    }

    public final void a(Resources resources, int i2, int i3) {
        setTypeface(Typeface.DEFAULT_BOLD);
        setTextSize(14.0f);
        int i4 = (int) ((resources.getDisplayMetrics().density * 48.0f) + 0.5f);
        setMinHeight(i4);
        setMinWidth(i4);
        int i5 = R$drawable.common_google_signin_btn_icon_dark;
        int i6 = R$drawable.common_google_signin_btn_icon_light;
        int a2 = a(i3, i5, i6, i6);
        int i7 = R$drawable.common_google_signin_btn_text_dark;
        int i8 = R$drawable.common_google_signin_btn_text_light;
        int a3 = a(i3, i7, i8, i8);
        if (i2 == 0 || i2 == 1) {
            a2 = a3;
        } else if (i2 != 2) {
            StringBuilder sb = new StringBuilder(32);
            sb.append("Unknown button size: ");
            sb.append(i2);
            throw new IllegalStateException(sb.toString());
        }
        Drawable i9 = a.i(resources.getDrawable(a2));
        a.a(i9, resources.getColorStateList(R$color.common_google_signin_btn_tint));
        a.a(i9, PorterDuff.Mode.SRC_ATOP);
        setBackgroundDrawable(i9);
        int i10 = R$color.common_google_signin_btn_text_dark;
        int i11 = R$color.common_google_signin_btn_text_light;
        ColorStateList colorStateList = resources.getColorStateList(a(i3, i10, i11, i11));
        r.a(colorStateList);
        setTextColor(colorStateList);
        if (i2 == 0) {
            setText(resources.getString(R$string.common_signin_button_text));
        } else if (i2 == 1) {
            setText(resources.getString(R$string.common_signin_button_text_long));
        } else {
            if (i2 != 2) {
                StringBuilder sb2 = new StringBuilder(32);
                sb2.append("Unknown button size: ");
                sb2.append(i2);
                throw new IllegalStateException(sb2.toString());
            }
            setText((CharSequence) null);
        }
        setTransformationMethod(null);
        if (i.b(getContext())) {
            setGravity(19);
        }
    }

    public SignInButtonImpl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.buttonStyle);
    }

    public static int a(int i2, int i3, int i4, int i5) {
        if (i2 == 0) {
            return i3;
        }
        if (i2 == 1) {
            return i4;
        }
        if (i2 == 2) {
            return i5;
        }
        StringBuilder sb = new StringBuilder(33);
        sb.append("Unknown color scheme: ");
        sb.append(i2);
        throw new IllegalStateException(sb.toString());
    }
}
