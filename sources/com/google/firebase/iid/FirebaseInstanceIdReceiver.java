package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Parcelable;
import androidx.legacy.content.WakefulBroadcastReceiver;
import c.c.a.b.j.h;
import c.c.b.l.c;
import c.c.b.l.d0;
import c.c.b.l.k1;
import c.c.b.l.t0;
import com.google.firebase.iid.FirebaseInstanceIdReceiver;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
/* loaded from: classes.dex */
public final class FirebaseInstanceIdReceiver extends WakefulBroadcastReceiver {

    /* renamed from: c, reason: collision with root package name */
    public final ExecutorService f10722c = t0.b();

    public static final /* synthetic */ void a(boolean z, BroadcastReceiver.PendingResult pendingResult, h hVar) {
        if (z) {
            pendingResult.setResultCode(hVar.e() ? ((Integer) hVar.b()).intValue() : 500);
        }
        pendingResult.finish();
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        Parcelable parcelableExtra = intent.getParcelableExtra("wrapped_intent");
        Intent intent2 = parcelableExtra instanceof Intent ? (Intent) parcelableExtra : null;
        if (intent2 != null) {
            intent = intent2;
        }
        intent.setComponent(null);
        intent.setPackage(context.getPackageName());
        if (Build.VERSION.SDK_INT <= 18) {
            intent.removeCategory(context.getPackageName());
        }
        d0 k1Var = "google.com/iid".equals(intent.getStringExtra("from")) ? new k1(this.f10722c) : new c(context, this.f10722c);
        final boolean isOrderedBroadcast = isOrderedBroadcast();
        final BroadcastReceiver.PendingResult goAsync = goAsync();
        k1Var.a(intent).a(this.f10722c, new c.c.a.b.j.c(isOrderedBroadcast, goAsync) { // from class: c.c.b.l.c1

            /* renamed from: a, reason: collision with root package name */
            public final boolean f5920a;

            /* renamed from: b, reason: collision with root package name */
            public final BroadcastReceiver.PendingResult f5921b;

            {
                this.f5920a = isOrderedBroadcast;
                this.f5921b = goAsync;
            }

            @Override // c.c.a.b.j.c
            public final void onComplete(c.c.a.b.j.h hVar) {
                FirebaseInstanceIdReceiver.a(this.f5920a, this.f5921b, hVar);
            }
        });
    }
}
