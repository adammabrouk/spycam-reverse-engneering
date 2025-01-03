package com.google.android.material.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes.dex */
public class VisibilityAwareImageButton extends ImageButton {

    /* renamed from: a, reason: collision with root package name */
    public int f10557a;

    public VisibilityAwareImageButton(Context context) {
        this(context, null);
    }

    public final void a(int i2, boolean z) {
        super.setVisibility(i2);
        if (z) {
            this.f10557a = i2;
        }
    }

    public final int getUserSetVisibility() {
        return this.f10557a;
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i2) {
        a(i2, true);
    }

    public VisibilityAwareImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VisibilityAwareImageButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f10557a = getVisibility();
    }
}
