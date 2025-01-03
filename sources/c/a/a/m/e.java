package c.a.a.m;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import c.a.a.m.c;

/* compiled from: DefaultConnectivityMonitor.java */
/* loaded from: classes.dex */
public class e implements c {

    /* renamed from: a, reason: collision with root package name */
    public final Context f3365a;

    /* renamed from: b, reason: collision with root package name */
    public final c.a f3366b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f3367c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f3368d;

    /* renamed from: e, reason: collision with root package name */
    public final BroadcastReceiver f3369e = new a();

    /* compiled from: DefaultConnectivityMonitor.java */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean z = e.this.f3367c;
            e eVar = e.this;
            eVar.f3367c = eVar.a(context);
            if (z != e.this.f3367c) {
                e.this.f3366b.a(e.this.f3367c);
            }
        }
    }

    public e(Context context, c.a aVar) {
        this.f3365a = context.getApplicationContext();
        this.f3366b = aVar;
    }

    public final void c() {
        if (this.f3368d) {
            return;
        }
        this.f3367c = a(this.f3365a);
        this.f3365a.registerReceiver(this.f3369e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        this.f3368d = true;
    }

    public final void d() {
        if (this.f3368d) {
            this.f3365a.unregisterReceiver(this.f3369e);
            this.f3368d = false;
        }
    }

    @Override // c.a.a.m.h
    public void f() {
    }

    @Override // c.a.a.m.h
    public void b() {
        d();
    }

    public final boolean a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override // c.a.a.m.h
    public void a() {
        c();
    }
}
