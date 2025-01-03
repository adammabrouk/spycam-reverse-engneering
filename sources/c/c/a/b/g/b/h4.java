package c.c.a.b.g.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public class h4 extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public final l9 f4760a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f4761b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f4762c;

    public h4(l9 l9Var) {
        c.c.a.b.c.o.r.a(l9Var);
        this.f4760a = l9Var;
    }

    public final void a() {
        this.f4760a.q();
        this.f4760a.a().g();
        if (this.f4761b) {
            return;
        }
        this.f4760a.d().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        this.f4762c = this.f4760a.j().t();
        this.f4760a.c().B().a("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.f4762c));
        this.f4761b = true;
    }

    public final void b() {
        this.f4760a.q();
        this.f4760a.a().g();
        this.f4760a.a().g();
        if (this.f4761b) {
            this.f4760a.c().B().a("Unregistering connectivity change receiver");
            this.f4761b = false;
            this.f4762c = false;
            try {
                this.f4760a.d().unregisterReceiver(this);
            } catch (IllegalArgumentException e2) {
                this.f4760a.c().t().a("Failed to unregister the network broadcast receiver", e2);
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.f4760a.q();
        String action = intent.getAction();
        this.f4760a.c().B().a("NetworkBroadcastReceiver received action", action);
        if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            this.f4760a.c().w().a("NetworkBroadcastReceiver received unknown action", action);
            return;
        }
        boolean t = this.f4760a.j().t();
        if (this.f4762c != t) {
            this.f4762c = t;
            this.f4760a.a().a(new k4(this, t));
        }
    }
}
