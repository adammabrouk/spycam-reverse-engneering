package c.c.b.l;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.google.firebase.iid.FirebaseInstanceId;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
/* loaded from: classes.dex */
public final class e0 extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public f0 f5935a;

    public e0(f0 f0Var) {
        this.f5935a = f0Var;
    }

    public final void a() {
        if (FirebaseInstanceId.p()) {
            Log.d("FirebaseInstanceId", "Connectivity change received registered");
        }
        this.f5935a.a().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        f0 f0Var = this.f5935a;
        if (f0Var != null && f0Var.b()) {
            if (FirebaseInstanceId.p()) {
                Log.d("FirebaseInstanceId", "Connectivity changed. Starting background sync.");
            }
            FirebaseInstanceId.a(this.f5935a, 0L);
            this.f5935a.a().unregisterReceiver(this);
            this.f5935a = null;
        }
    }
}
