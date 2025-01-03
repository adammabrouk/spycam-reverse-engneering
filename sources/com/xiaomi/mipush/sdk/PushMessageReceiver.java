package com.xiaomi.mipush.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import c.k.a.a.a.c;
import c.k.c.a.n;
import c.k.c.a.o;
import c.k.d.j4;
import com.xiaomi.mipush.sdk.MessageHandleService;

/* loaded from: classes.dex */
public abstract class PushMessageReceiver extends BroadcastReceiver {
    public void onCommandResult(Context context, n nVar) {
    }

    public void onNotificationMessageArrived(Context context, o oVar) {
    }

    public void onNotificationMessageClicked(Context context, o oVar) {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        MessageHandleService.a(context.getApplicationContext(), new MessageHandleService.a(intent, this));
        try {
            int intExtra = intent.getIntExtra("eventMessageType", -1);
            if (intExtra == 2000) {
                j4.a(context.getApplicationContext()).a(context.getPackageName(), intent, 2003, (String) null);
            } else if (intExtra == 6000) {
                j4.a(context.getApplicationContext()).a(context.getPackageName(), intent, 6005, (String) null);
            }
        } catch (Exception e2) {
            c.a(e2);
        }
    }

    @Deprecated
    public void onReceiveMessage(Context context, o oVar) {
    }

    public void onReceivePassThroughMessage(Context context, o oVar) {
    }

    public void onReceiveRegisterResult(Context context, n nVar) {
    }

    public void onRequirePermissions(Context context, String[] strArr) {
    }
}
