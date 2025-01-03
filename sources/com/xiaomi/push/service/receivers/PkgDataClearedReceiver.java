package com.xiaomi.push.service.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import c.k.a.a.a.c;
import c.k.d.p9.e0;
import c.k.d.p9.z;
import com.xiaomi.push.service.XMPushService;

/* loaded from: classes.dex */
public class PkgDataClearedReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || !"android.intent.action.PACKAGE_DATA_CLEARED".equals(intent.getAction()) || intent.getData() == null) {
            return;
        }
        String encodedSchemeSpecificPart = intent.getData().getEncodedSchemeSpecificPart();
        if (TextUtils.isEmpty(encodedSchemeSpecificPart)) {
            return;
        }
        try {
            Intent intent2 = new Intent(context, (Class<?>) XMPushService.class);
            intent2.setAction(z.f7740b);
            intent2.putExtra("data_cleared_pkg_name", encodedSchemeSpecificPart);
            e0.a(context).m368a(intent2);
        } catch (Exception e2) {
            c.d("data cleared broadcast error: " + e2);
        }
    }
}
