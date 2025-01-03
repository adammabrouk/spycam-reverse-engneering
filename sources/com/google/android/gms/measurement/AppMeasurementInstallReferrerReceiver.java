package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import c.c.a.b.f.e.c;

/* compiled from: com.google.android.gms:play-services-measurement-api@@17.4.1 */
@Deprecated
/* loaded from: classes.dex */
public final class AppMeasurementInstallReferrerReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (c.b(context)) {
            c.a(context).a(5, "Install Referrer Broadcast deprecated", (Object) null, (Object) null, (Object) null);
        } else {
            Log.w("FA", "Install Referrer Broadcast deprecated");
        }
    }
}
