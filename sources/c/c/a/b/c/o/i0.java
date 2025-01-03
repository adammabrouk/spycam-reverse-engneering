package c.c.a.b.c.o;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import c.c.a.b.c.o.h;
import java.util.HashMap;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class i0 extends h implements Handler.Callback {

    /* renamed from: d, reason: collision with root package name */
    public final Context f3967d;

    /* renamed from: e, reason: collision with root package name */
    public final Handler f3968e;

    /* renamed from: c, reason: collision with root package name */
    @GuardedBy("mConnectionStatus")
    public final HashMap<h.a, j0> f3966c = new HashMap<>();

    /* renamed from: f, reason: collision with root package name */
    public final c.c.a.b.c.r.a f3969f = c.c.a.b.c.r.a.a();

    /* renamed from: g, reason: collision with root package name */
    public final long f3970g = 5000;

    /* renamed from: h, reason: collision with root package name */
    public final long f3971h = 300000;

    public i0(Context context) {
        this.f3967d = context.getApplicationContext();
        this.f3968e = new c.c.a.b.f.c.d(context.getMainLooper(), this);
    }

    @Override // c.c.a.b.c.o.h
    public final boolean a(h.a aVar, ServiceConnection serviceConnection, String str) {
        boolean d2;
        r.a(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f3966c) {
            j0 j0Var = this.f3966c.get(aVar);
            if (j0Var == null) {
                j0Var = new j0(this, aVar);
                j0Var.a(serviceConnection, str);
                j0Var.a(str);
                this.f3966c.put(aVar, j0Var);
            } else {
                this.f3968e.removeMessages(0, aVar);
                if (j0Var.a(serviceConnection)) {
                    String valueOf = String.valueOf(aVar);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 81);
                    sb.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
                    sb.append(valueOf);
                    throw new IllegalStateException(sb.toString());
                }
                j0Var.a(serviceConnection, str);
                int c2 = j0Var.c();
                if (c2 == 1) {
                    serviceConnection.onServiceConnected(j0Var.b(), j0Var.a());
                } else if (c2 == 2) {
                    j0Var.a(str);
                }
            }
            d2 = j0Var.d();
        }
        return d2;
    }

    @Override // c.c.a.b.c.o.h
    public final void b(h.a aVar, ServiceConnection serviceConnection, String str) {
        r.a(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f3966c) {
            j0 j0Var = this.f3966c.get(aVar);
            if (j0Var == null) {
                String valueOf = String.valueOf(aVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 50);
                sb.append("Nonexistent connection status for service config: ");
                sb.append(valueOf);
                throw new IllegalStateException(sb.toString());
            }
            if (!j0Var.a(serviceConnection)) {
                String valueOf2 = String.valueOf(aVar);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 76);
                sb2.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
                sb2.append(valueOf2);
                throw new IllegalStateException(sb2.toString());
            }
            j0Var.b(serviceConnection, str);
            if (j0Var.e()) {
                this.f3968e.sendMessageDelayed(this.f3968e.obtainMessage(0, aVar), this.f3970g);
            }
        }
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 0) {
            synchronized (this.f3966c) {
                h.a aVar = (h.a) message.obj;
                j0 j0Var = this.f3966c.get(aVar);
                if (j0Var != null && j0Var.e()) {
                    if (j0Var.d()) {
                        j0Var.b("GmsClientSupervisor");
                    }
                    this.f3966c.remove(aVar);
                }
            }
            return true;
        }
        if (i2 != 1) {
            return false;
        }
        synchronized (this.f3966c) {
            h.a aVar2 = (h.a) message.obj;
            j0 j0Var2 = this.f3966c.get(aVar2);
            if (j0Var2 != null && j0Var2.c() == 3) {
                String valueOf = String.valueOf(aVar2);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
                sb.append("Timeout waiting for ServiceConnection callback ");
                sb.append(valueOf);
                Log.e("GmsClientSupervisor", sb.toString(), new Exception());
                ComponentName b2 = j0Var2.b();
                if (b2 == null) {
                    b2 = aVar2.a();
                }
                if (b2 == null) {
                    b2 = new ComponentName(aVar2.b(), "unknown");
                }
                j0Var2.onServiceDisconnected(b2);
            }
        }
        return true;
    }
}
