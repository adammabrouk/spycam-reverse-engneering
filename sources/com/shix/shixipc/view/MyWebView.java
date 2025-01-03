package com.shix.shixipc.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.util.AttributeSet;
import android.webkit.WebView;

/* loaded from: classes.dex */
public class MyWebView extends WebView {
    public MyWebView(Context context) {
        super(getFixedContext(context));
    }

    public static Context getFixedContext(Context context) {
        int i2 = Build.VERSION.SDK_INT;
        return (i2 < 21 || i2 >= 23) ? context : context.createConfigurationContext(new Configuration());
    }

    public MyWebView(Context context, AttributeSet attributeSet) {
        super(getFixedContext(context), attributeSet);
    }

    public MyWebView(Context context, AttributeSet attributeSet, int i2) {
        super(getFixedContext(context), attributeSet, i2);
    }

    @TargetApi(21)
    public MyWebView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(getFixedContext(context), attributeSet, i2, i3);
    }

    public MyWebView(Context context, AttributeSet attributeSet, int i2, boolean z) {
        super(getFixedContext(context), attributeSet, i2, z);
    }
}
