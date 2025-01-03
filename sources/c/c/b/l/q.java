package c.c.b.l;

import android.os.Bundle;
import android.util.Log;

/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
/* loaded from: classes.dex */
public abstract class q<T> {

    /* renamed from: a, reason: collision with root package name */
    public final int f5985a;

    /* renamed from: b, reason: collision with root package name */
    public final c.c.a.b.j.i<T> f5986b = new c.c.a.b.j.i<>();

    /* renamed from: c, reason: collision with root package name */
    public final int f5987c;

    /* renamed from: d, reason: collision with root package name */
    public final Bundle f5988d;

    public q(int i2, int i3, Bundle bundle) {
        this.f5985a = i2;
        this.f5987c = i3;
        this.f5988d = bundle;
    }

    public abstract void a(Bundle bundle);

    public final void a(T t) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(t);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 16 + String.valueOf(valueOf2).length());
            sb.append("Finishing ");
            sb.append(valueOf);
            sb.append(" with ");
            sb.append(valueOf2);
            Log.d("MessengerIpcClient", sb.toString());
        }
        this.f5986b.a((c.c.a.b.j.i<T>) t);
    }

    public abstract boolean a();

    public String toString() {
        int i2 = this.f5987c;
        int i3 = this.f5985a;
        boolean a2 = a();
        StringBuilder sb = new StringBuilder(55);
        sb.append("Request { what=");
        sb.append(i2);
        sb.append(" id=");
        sb.append(i3);
        sb.append(" oneWay=");
        sb.append(a2);
        sb.append("}");
        return sb.toString();
    }

    public final void a(p pVar) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(pVar);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 14 + String.valueOf(valueOf2).length());
            sb.append("Failing ");
            sb.append(valueOf);
            sb.append(" with ");
            sb.append(valueOf2);
            Log.d("MessengerIpcClient", sb.toString());
        }
        this.f5986b.a(pVar);
    }
}
