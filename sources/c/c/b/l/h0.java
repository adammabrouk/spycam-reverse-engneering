package c.c.b.l;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
/* loaded from: classes.dex */
public final class h0 {

    /* renamed from: a, reason: collision with root package name */
    public static final long f5955a = TimeUnit.MINUTES.toMillis(1);

    /* renamed from: b, reason: collision with root package name */
    public static final Object f5956b = new Object();

    /* renamed from: c, reason: collision with root package name */
    @GuardedBy("WakeLockHolder.syncObject")
    public static c.c.a.b.i.a f5957c;

    public static ComponentName a(Context context, Intent intent) {
        synchronized (f5956b) {
            if (f5957c == null) {
                c.c.a.b.i.a aVar = new c.c.a.b.i.a(context, 1, "wake:com.google.firebase.iid.WakeLockHolder");
                f5957c = aVar;
                aVar.a(true);
            }
            boolean booleanExtra = intent.getBooleanExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false);
            a(intent, true);
            ComponentName startService = context.startService(intent);
            if (startService == null) {
                return null;
            }
            if (!booleanExtra) {
                f5957c.a(f5955a);
            }
            return startService;
        }
    }

    public static void a(Intent intent, boolean z) {
        intent.putExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", z);
    }

    public static void a(Intent intent) {
        synchronized (f5956b) {
            if (f5957c != null && intent.getBooleanExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false)) {
                a(intent, false);
                f5957c.a();
            }
        }
    }
}
