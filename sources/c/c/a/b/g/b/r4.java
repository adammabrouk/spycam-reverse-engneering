package c.c.a.b.g.b;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class r4 implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final String f5038a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s4 f5039b;

    public r4(s4 s4Var, String str) {
        this.f5039b = s4Var;
        this.f5038a = str;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder == null) {
            this.f5039b.f5060a.c().w().a("Install Referrer connection returned with null binder");
            return;
        }
        try {
            c.c.a.b.f.e.k2 a2 = c.c.a.b.f.e.j5.a(iBinder);
            if (a2 == null) {
                this.f5039b.f5060a.c().w().a("Install Referrer Service implementation was not found");
            } else {
                this.f5039b.f5060a.c().B().a("Install Referrer Service connected");
                this.f5039b.f5060a.a().a(new u4(this, a2, this));
            }
        } catch (Exception e2) {
            this.f5039b.f5060a.c().w().a("Exception occurred while calling Install Referrer API", e2);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f5039b.f5060a.c().B().a("Install Referrer Service disconnected");
    }
}
