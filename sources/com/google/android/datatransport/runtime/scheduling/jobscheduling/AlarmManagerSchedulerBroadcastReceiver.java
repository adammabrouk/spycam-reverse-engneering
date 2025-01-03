package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import c.c.a.a.j.l;
import c.c.a.a.j.q;
import c.c.a.a.j.w.j.b;
import c.c.a.a.j.z.a;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
/* loaded from: classes.dex */
public class AlarmManagerSchedulerBroadcastReceiver extends BroadcastReceiver {
    public static /* synthetic */ void a() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String queryParameter = intent.getData().getQueryParameter("backendName");
        String queryParameter2 = intent.getData().getQueryParameter("extras");
        int intValue = Integer.valueOf(intent.getData().getQueryParameter("priority")).intValue();
        int i2 = intent.getExtras().getInt("attemptNumber");
        q.a(context);
        l.a d2 = l.d();
        d2.a(queryParameter);
        d2.a(a.a(intValue));
        if (queryParameter2 != null) {
            d2.a(Base64.decode(queryParameter2, 0));
        }
        q.b().a().a(d2.a(), i2, b.a());
    }
}
