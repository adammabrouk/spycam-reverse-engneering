package com.shix.shixipc.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes.dex */
public class MyTextView extends TextView {
    public MyTextView(Context context) {
        super(context);
    }

    @Override // android.view.View
    public boolean isFocused() {
        return true;
    }

    public MyTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MyTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
