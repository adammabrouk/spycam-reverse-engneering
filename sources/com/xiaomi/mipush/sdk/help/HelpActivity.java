package com.xiaomi.mipush.sdk.help;

import android.app.Activity;
import android.os.Bundle;
import c.k.c.a.c1;

/* loaded from: classes.dex */
public class HelpActivity extends Activity {
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        c1.a(this, getIntent(), null);
        finish();
    }
}
