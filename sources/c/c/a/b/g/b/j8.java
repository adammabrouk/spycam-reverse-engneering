package c.c.a.b.g.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import c.c.a.b.c.o.c;
import com.google.android.gms.common.ConnectionResult;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class j8 implements ServiceConnection, c.a, c.b {

    /* renamed from: a, reason: collision with root package name */
    public volatile boolean f4837a;

    /* renamed from: b, reason: collision with root package name */
    public volatile x3 f4838b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ r7 f4839c;

    public j8(r7 r7Var) {
        this.f4839c = r7Var;
    }

    public final void a(Intent intent) {
        j8 j8Var;
        this.f4839c.g();
        Context d2 = this.f4839c.d();
        c.c.a.b.c.r.a a2 = c.c.a.b.c.r.a.a();
        synchronized (this) {
            if (this.f4837a) {
                this.f4839c.c().B().a("Connection attempt already in progress");
                return;
            }
            this.f4839c.c().B().a("Using local app measurement service");
            this.f4837a = true;
            j8Var = this.f4839c.f5044c;
            a2.a(d2, intent, j8Var, 129);
        }
    }

    public final void b() {
        this.f4839c.g();
        Context d2 = this.f4839c.d();
        synchronized (this) {
            if (this.f4837a) {
                this.f4839c.c().B().a("Connection attempt already in progress");
                return;
            }
            if (this.f4838b != null && (this.f4838b.e() || this.f4838b.a())) {
                this.f4839c.c().B().a("Already awaiting connection attempt");
                return;
            }
            this.f4838b = new x3(d2, Looper.getMainLooper(), this, this);
            this.f4839c.c().B().a("Connecting to remote service");
            this.f4837a = true;
            this.f4838b.l();
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        j8 j8Var;
        c.c.a.b.c.o.r.a("MeasurementServiceConnection.onServiceConnected");
        synchronized (this) {
            if (iBinder == null) {
                this.f4837a = false;
                this.f4839c.c().t().a("Service connected with null binder");
                return;
            }
            o3 o3Var = null;
            try {
                String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                    if (iBinder != null) {
                        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                        o3Var = queryLocalInterface instanceof o3 ? (o3) queryLocalInterface : new q3(iBinder);
                    }
                    this.f4839c.c().B().a("Bound to IMeasurementService interface");
                } else {
                    this.f4839c.c().t().a("Got binder with a wrong descriptor", interfaceDescriptor);
                }
            } catch (RemoteException unused) {
                this.f4839c.c().t().a("Service connect failed to get IMeasurementService");
            }
            if (o3Var == null) {
                this.f4837a = false;
                try {
                    c.c.a.b.c.r.a a2 = c.c.a.b.c.r.a.a();
                    Context d2 = this.f4839c.d();
                    j8Var = this.f4839c.f5044c;
                    a2.a(d2, j8Var);
                } catch (IllegalArgumentException unused2) {
                }
            } else {
                this.f4839c.a().a(new m8(this, o3Var));
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        c.c.a.b.c.o.r.a("MeasurementServiceConnection.onServiceDisconnected");
        this.f4839c.c().A().a("Service disconnected");
        this.f4839c.a().a(new l8(this, componentName));
    }

    public final void a() {
        if (this.f4838b != null && (this.f4838b.a() || this.f4838b.e())) {
            this.f4838b.h();
        }
        this.f4838b = null;
    }

    @Override // c.c.a.b.c.o.c.a
    public final void a(int i2) {
        c.c.a.b.c.o.r.a("MeasurementServiceConnection.onConnectionSuspended");
        this.f4839c.c().A().a("Service connection suspended");
        this.f4839c.a().a(new n8(this));
    }

    @Override // c.c.a.b.c.o.c.a
    public final void b(Bundle bundle) {
        c.c.a.b.c.o.r.a("MeasurementServiceConnection.onConnected");
        synchronized (this) {
            try {
                this.f4839c.a().a(new o8(this, this.f4838b.v()));
            } catch (DeadObjectException | IllegalStateException unused) {
                this.f4838b = null;
                this.f4837a = false;
            }
        }
    }

    @Override // c.c.a.b.c.o.c.b
    public final void a(ConnectionResult connectionResult) {
        c.c.a.b.c.o.r.a("MeasurementServiceConnection.onConnectionFailed");
        w3 q = this.f4839c.f5160a.q();
        if (q != null) {
            q.w().a("Service connection failed", connectionResult);
        }
        synchronized (this) {
            this.f4837a = false;
            this.f4838b = null;
        }
        this.f4839c.a().a(new q8(this));
    }

    public static /* synthetic */ boolean a(j8 j8Var, boolean z) {
        j8Var.f4837a = false;
        return false;
    }
}
