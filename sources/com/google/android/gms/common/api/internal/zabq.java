package com.google.android.gms.common.api.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import c.c.a.b.c.l.m.s;

/* loaded from: classes.dex */
public final class zabq extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public Context f10049a;

    /* renamed from: b, reason: collision with root package name */
    public final s f10050b;

    public final synchronized void a() {
        if (this.f10049a != null) {
            this.f10049a.unregisterReceiver(this);
        }
        this.f10049a = null;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        if ("com.google.android.gms".equals(data != null ? data.getSchemeSpecificPart() : null)) {
            this.f10050b.a();
            a();
        }
    }
}
