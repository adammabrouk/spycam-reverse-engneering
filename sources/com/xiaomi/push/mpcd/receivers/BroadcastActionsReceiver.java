package com.xiaomi.push.mpcd.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import c.k.d.r2;

/* loaded from: classes.dex */
public class BroadcastActionsReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public r2 f11259a;

    public BroadcastActionsReceiver(r2 r2Var) {
        this.f11259a = r2Var;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        r2 r2Var = this.f11259a;
        if (r2Var != null) {
            r2Var.a(context, intent);
        }
    }
}
