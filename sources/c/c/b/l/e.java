package c.c.b.l;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: e, reason: collision with root package name */
    @GuardedBy("MessengerIpcClient.class")
    public static e f5930e;

    /* renamed from: a, reason: collision with root package name */
    public final Context f5931a;

    /* renamed from: b, reason: collision with root package name */
    public final ScheduledExecutorService f5932b;

    /* renamed from: c, reason: collision with root package name */
    @GuardedBy("this")
    public f f5933c = new f(this);

    /* renamed from: d, reason: collision with root package name */
    @GuardedBy("this")
    public int f5934d = 1;

    public e(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.f5932b = scheduledExecutorService;
        this.f5931a = context.getApplicationContext();
    }

    public static synchronized e a(Context context) {
        e eVar;
        synchronized (e.class) {
            if (f5930e == null) {
                f5930e = new e(context, c.c.a.b.f.d.a.a().a(1, new c.c.a.b.c.s.s.a("MessengerIpcClient"), c.c.a.b.f.d.f.f4052a));
            }
            eVar = f5930e;
        }
        return eVar;
    }

    public final c.c.a.b.j.h<Bundle> b(int i2, Bundle bundle) {
        return a(new s(a(), 1, bundle));
    }

    public final c.c.a.b.j.h<Void> a(int i2, Bundle bundle) {
        return a(new n(a(), 2, bundle));
    }

    public final synchronized <T> c.c.a.b.j.h<T> a(q<T> qVar) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(qVar);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 9);
            sb.append("Queueing ");
            sb.append(valueOf);
            Log.d("MessengerIpcClient", sb.toString());
        }
        if (!this.f5933c.a((q<?>) qVar)) {
            f fVar = new f(this);
            this.f5933c = fVar;
            fVar.a((q<?>) qVar);
        }
        return qVar.f5986b.a();
    }

    public final synchronized int a() {
        int i2;
        i2 = this.f5934d;
        this.f5934d = i2 + 1;
        return i2;
    }
}
