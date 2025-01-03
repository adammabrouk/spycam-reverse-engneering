package com.xiaomi.push.service.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import c.k.a.a.a.c;
import c.k.d.k4;
import c.k.d.p9.e0;
import c.k.d.p9.v;
import com.xiaomi.push.service.XMPushService;

/* loaded from: classes.dex */
public class PingReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        c.c(intent.getPackage() + " is the package name");
        if (!v.m.equals(intent.getAction())) {
            c.m6a("cancel the old ping timer");
            k4.a();
        } else if (TextUtils.equals(context.getPackageName(), intent.getPackage())) {
            c.c("Ping XMChannelService on timer");
            try {
                Intent intent2 = new Intent(context, (Class<?>) XMPushService.class);
                intent2.putExtra("time_stamp", System.currentTimeMillis());
                intent2.setAction("com.xiaomi.push.timer");
                e0.a(context).m368a(intent2);
            } catch (Exception e2) {
                c.a(e2);
            }
        }
    }
}
