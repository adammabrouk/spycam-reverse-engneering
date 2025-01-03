package com.xiaomi.push.service.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import c.k.a.a.a.c;
import c.k.d.p9.e0;
import c.k.d.p9.z;
import com.xiaomi.push.service.XMPushService;

/* loaded from: classes.dex */
public class PkgUninstallReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || !"android.intent.action.PACKAGE_REMOVED".equals(intent.getAction())) {
            return;
        }
        boolean z = intent.getExtras().getBoolean("android.intent.extra.REPLACING");
        Uri data = intent.getData();
        if (data == null || z) {
            return;
        }
        try {
            Intent intent2 = new Intent(context, (Class<?>) XMPushService.class);
            intent2.setAction(z.f7739a);
            intent2.putExtra("uninstall_pkg_name", data.getEncodedSchemeSpecificPart());
            e0.a(context).m368a(intent2);
        } catch (Exception e2) {
            c.a(e2);
        }
    }
}
