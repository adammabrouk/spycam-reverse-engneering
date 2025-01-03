package c.c.b.p;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/* compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
/* loaded from: classes.dex */
public final class f extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public g f6138a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g f6139b;

    public f(g gVar, g gVar2) {
        this.f6139b = gVar;
        this.f6138a = gVar2;
    }

    @Override // android.content.BroadcastReceiver
    public final synchronized void onReceive(Context context, Intent intent) {
        boolean a2;
        boolean c2;
        e eVar;
        if (this.f6138a == null) {
            return;
        }
        a2 = this.f6138a.a();
        if (a2) {
            c2 = g.c();
            if (c2) {
                Log.d("FirebaseMessaging", "Connectivity changed. Starting background sync.");
            }
            eVar = this.f6138a.f6146d;
            eVar.a(this.f6138a, 0L);
            context.unregisterReceiver(this);
            this.f6138a = null;
        }
    }
}
