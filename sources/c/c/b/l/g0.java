package c.c.b.l;

import android.os.Binder;
import android.os.Process;
import android.util.Log;

/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
/* loaded from: classes.dex */
public final class g0 extends Binder {

    /* renamed from: a, reason: collision with root package name */
    public final i0 f5952a;

    public g0(i0 i0Var) {
        this.f5952a = i0Var;
    }

    public final void a(final k0 k0Var) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException("Binding only allowed within app");
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "service received new intent via bind strategy");
        }
        this.f5952a.a(k0Var.f5965a).a(t0.a(), new c.c.a.b.j.c(k0Var) { // from class: c.c.b.l.j0

            /* renamed from: a, reason: collision with root package name */
            public final k0 f5961a;

            {
                this.f5961a = k0Var;
            }

            @Override // c.c.a.b.j.c
            public final void onComplete(c.c.a.b.j.h hVar) {
                this.f5961a.b();
            }
        });
    }
}
