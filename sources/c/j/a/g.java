package c.j.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import c.j.a.z.f0;
import c.j.a.z.z;
import c.j.b.b;
import com.shix.shixipc.utilcode.NetworkUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: IPCManager.java */
/* loaded from: classes.dex */
public final class g implements ServiceConnection {

    /* renamed from: i, reason: collision with root package name */
    public static final Object f6537i = new Object();
    public static Map<String, g> j = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public boolean f6538a;

    /* renamed from: b, reason: collision with root package name */
    public String f6539b;

    /* renamed from: c, reason: collision with root package name */
    public Context f6540c;

    /* renamed from: e, reason: collision with root package name */
    public volatile c.j.b.b f6542e;

    /* renamed from: g, reason: collision with root package name */
    public String f6544g;

    /* renamed from: h, reason: collision with root package name */
    public Handler f6545h;

    /* renamed from: f, reason: collision with root package name */
    public Object f6543f = new Object();

    /* renamed from: d, reason: collision with root package name */
    public AtomicInteger f6541d = new AtomicInteger(1);

    public g(Context context, String str) {
        this.f6539b = null;
        this.f6545h = null;
        this.f6540c = context;
        this.f6544g = str;
        this.f6545h = new Handler(Looper.getMainLooper(), new i(this));
        String b2 = z.b(context);
        this.f6539b = b2;
        if (!TextUtils.isEmpty(b2) && !TextUtils.isEmpty(this.f6544g)) {
            this.f6538a = f0.a(context, this.f6539b) >= 1260;
            b();
            return;
        }
        c.j.a.z.v.c(this.f6540c, "init error : push pkgname is " + this.f6539b + " ; action is " + this.f6544g);
        this.f6538a = false;
    }

    public final void d() {
        this.f6545h.removeMessages(1);
        this.f6545h.sendEmptyMessageDelayed(1, NetworkUtils.SCAN_PERIOD_MILLIS);
    }

    public final void e() {
        this.f6545h.removeMessages(1);
    }

    public final void f() {
        try {
            this.f6540c.unbindService(this);
        } catch (Exception e2) {
            c.j.a.z.v.a("AidlManager", "On unBindServiceException:" + e2.getMessage());
        }
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        c.j.a.z.v.b("AidlManager", "onBindingDied : ".concat(String.valueOf(componentName)));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        e();
        this.f6542e = b.a.a(iBinder);
        if (this.f6542e == null) {
            c.j.a.z.v.d("AidlManager", "onServiceConnected error : aidl must not be null.");
            f();
            this.f6541d.set(1);
            return;
        }
        if (this.f6541d.get() == 2) {
            a(4);
        } else if (this.f6541d.get() != 4) {
            f();
        }
        synchronized (this.f6543f) {
            this.f6543f.notifyAll();
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f6542e = null;
        a(1);
    }

    public static g a(Context context, String str) {
        g gVar = j.get(str);
        if (gVar == null) {
            synchronized (f6537i) {
                gVar = j.get(str);
                if (gVar == null) {
                    gVar = new g(context, str);
                    j.put(str, gVar);
                }
            }
        }
        return gVar;
    }

    public final void b() {
        int i2 = this.f6541d.get();
        c.j.a.z.v.d("AidlManager", "Enter connect, Connection Status: ".concat(String.valueOf(i2)));
        if (i2 == 4 || i2 == 2 || i2 == 3 || i2 == 5 || !this.f6538a) {
            return;
        }
        a(2);
        if (c()) {
            d();
        } else {
            a(1);
            c.j.a.z.v.a("AidlManager", "bind core service fail");
        }
    }

    public final boolean c() {
        Intent intent = new Intent(this.f6544g);
        intent.setPackage(this.f6539b);
        try {
            return this.f6540c.bindService(intent, this, 1);
        } catch (Exception e2) {
            c.j.a.z.v.a("AidlManager", "bind core error", e2);
            return false;
        }
    }

    public final boolean a() {
        String b2 = z.b(this.f6540c);
        this.f6539b = b2;
        if (TextUtils.isEmpty(b2)) {
            c.j.a.z.v.c(this.f6540c, "push pkgname is null");
            return false;
        }
        boolean z = f0.a(this.f6540c, this.f6539b) >= 1260;
        this.f6538a = z;
        return z;
    }

    public final void a(int i2) {
        this.f6541d.set(i2);
    }

    public final boolean a(Bundle bundle) {
        b();
        if (this.f6541d.get() == 2) {
            synchronized (this.f6543f) {
                try {
                    this.f6543f.wait(2000L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
        try {
            int i2 = this.f6541d.get();
            if (i2 == 4) {
                this.f6545h.removeMessages(2);
                this.f6545h.sendEmptyMessageDelayed(2, 30000L);
                this.f6542e.a(bundle, null);
                return true;
            }
            c.j.a.z.v.d("AidlManager", "invoke error : connect status = ".concat(String.valueOf(i2)));
            return false;
        } catch (Exception e3) {
            c.j.a.z.v.a("AidlManager", "invoke error ", e3);
            int i3 = this.f6541d.get();
            c.j.a.z.v.d("AidlManager", "Enter disconnect, Connection Status: ".concat(String.valueOf(i3)));
            if (i3 == 2) {
                e();
                a(1);
                return false;
            }
            if (i3 == 3) {
                a(1);
                return false;
            }
            if (i3 != 4) {
                return false;
            }
            a(1);
            f();
            return false;
        }
    }
}
