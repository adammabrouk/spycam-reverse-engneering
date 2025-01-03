package com.google.android.gms.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import c.c.a.b.c.o.s;
import c.c.a.b.d.c;
import com.google.android.gms.base.R$styleable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.SignInButtonImpl;

/* loaded from: classes.dex */
public final class SignInButton extends FrameLayout implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public int f10025a;

    /* renamed from: b, reason: collision with root package name */
    public int f10026b;

    /* renamed from: c, reason: collision with root package name */
    public View f10027c;

    /* renamed from: d, reason: collision with root package name */
    public View.OnClickListener f10028d;

    public SignInButton(Context context) {
        this(context, null);
    }

    public final void a(int i2, int i3) {
        this.f10025a = i2;
        this.f10026b = i3;
        Context context = getContext();
        View view = this.f10027c;
        if (view != null) {
            removeView(view);
        }
        try {
            this.f10027c = s.b(context, this.f10025a, this.f10026b);
        } catch (c.a unused) {
            Log.w("SignInButton", "Sign in button not found, using placeholder instead");
            int i4 = this.f10025a;
            int i5 = this.f10026b;
            SignInButtonImpl signInButtonImpl = new SignInButtonImpl(context);
            signInButtonImpl.a(context.getResources(), i4, i5);
            this.f10027c = signInButtonImpl;
        }
        addView(this.f10027c);
        this.f10027c.setEnabled(isEnabled());
        this.f10027c.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        View.OnClickListener onClickListener = this.f10028d;
        if (onClickListener == null || view != this.f10027c) {
            return;
        }
        onClickListener.onClick(this);
    }

    public final void setColorScheme(int i2) {
        a(this.f10025a, i2);
    }

    @Override // android.view.View
    public final void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f10027c.setEnabled(z);
    }

    @Override // android.view.View
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.f10028d = onClickListener;
        View view = this.f10027c;
        if (view != null) {
            view.setOnClickListener(this);
        }
    }

    @Deprecated
    public final void setScopes(Scope[] scopeArr) {
        a(this.f10025a, this.f10026b);
    }

    public final void setSize(int i2) {
        a(i2, this.f10026b);
    }

    public SignInButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SignInButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f10028d = null;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.SignInButton, 0, 0);
        try {
            this.f10025a = obtainStyledAttributes.getInt(R$styleable.SignInButton_buttonSize, 0);
            this.f10026b = obtainStyledAttributes.getInt(R$styleable.SignInButton_colorScheme, 2);
            obtainStyledAttributes.recycle();
            a(this.f10025a, this.f10026b);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }
}
