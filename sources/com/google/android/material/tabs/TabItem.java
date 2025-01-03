package com.google.android.material.tabs;

import a.b.f.g0;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.material.R$styleable;

/* loaded from: classes.dex */
public class TabItem extends View {

    /* renamed from: a, reason: collision with root package name */
    public final CharSequence f10601a;

    /* renamed from: b, reason: collision with root package name */
    public final Drawable f10602b;

    /* renamed from: c, reason: collision with root package name */
    public final int f10603c;

    public TabItem(Context context) {
        this(context, null);
    }

    public TabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        g0 a2 = g0.a(context, attributeSet, R$styleable.TabItem);
        this.f10601a = a2.e(R$styleable.TabItem_android_text);
        this.f10602b = a2.b(R$styleable.TabItem_android_icon);
        this.f10603c = a2.g(R$styleable.TabItem_android_layout, 0);
        a2.b();
    }
}
