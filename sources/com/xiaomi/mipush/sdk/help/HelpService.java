package com.xiaomi.mipush.sdk.help;

import android.app.IntentService;
import android.content.Intent;
import android.text.TextUtils;
import c.k.c.a.c1;

/* loaded from: classes.dex */
public class HelpService extends IntentService {
    public HelpService() {
        super("intentService");
    }

    @Override // android.app.IntentService
    public void onHandleIntent(Intent intent) {
        if (TextUtils.isEmpty(intent.getStringExtra("awake_info"))) {
            return;
        }
        c1.a(this, intent, null);
    }
}
