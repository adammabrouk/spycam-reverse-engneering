package c.c.b.l;

import android.content.Intent;
import android.util.Log;

/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
/* loaded from: classes.dex */
public final class k0 {

    /* renamed from: a, reason: collision with root package name */
    public final Intent f5965a;

    /* renamed from: b, reason: collision with root package name */
    public final c.c.a.b.j.i<Void> f5966b = new c.c.a.b.j.i<>();

    public k0(Intent intent) {
        this.f5965a = intent;
    }

    public final c.c.a.b.j.h<Void> a() {
        return this.f5966b.a();
    }

    public final void b() {
        this.f5966b.b((c.c.a.b.j.i<Void>) null);
    }

    public final /* synthetic */ void c() {
        String action = this.f5965a.getAction();
        StringBuilder sb = new StringBuilder(String.valueOf(action).length() + 61);
        sb.append("Service took too long to process intent: ");
        sb.append(action);
        sb.append(" App may get closed.");
        Log.w("FirebaseInstanceId", sb.toString());
        b();
    }
}
