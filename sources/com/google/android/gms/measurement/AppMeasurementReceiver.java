package com.google.android.gms.measurement;

import android.content.Context;
import android.content.Intent;
import androidx.legacy.content.WakefulBroadcastReceiver;
import c.c.a.b.g.b.t4;
import c.c.a.b.g.b.w4;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class AppMeasurementReceiver extends WakefulBroadcastReceiver implements w4 {

    /* renamed from: c, reason: collision with root package name */
    public t4 f10198c;

    @Override // c.c.a.b.g.b.w4
    public final void a(Context context, Intent intent) {
        WakefulBroadcastReceiver.b(context, intent);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (this.f10198c == null) {
            this.f10198c = new t4(this);
        }
        this.f10198c.a(context, intent);
    }
}
