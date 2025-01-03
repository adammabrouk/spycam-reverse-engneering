package c.c.a.b.c.o;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import c.c.a.b.c.o.h;
import c.c.a.b.c.o.l;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.GetServiceRequest;
import com.google.android.gms.common.internal.zzb;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public abstract class c<T extends IInterface> {
    public static final Feature[] v = new Feature[0];

    /* renamed from: a, reason: collision with root package name */
    public l0 f3915a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f3916b;

    /* renamed from: c, reason: collision with root package name */
    public final c.c.a.b.c.o.h f3917c;

    /* renamed from: d, reason: collision with root package name */
    public final c.c.a.b.c.d f3918d;

    /* renamed from: e, reason: collision with root package name */
    public final Handler f3919e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f3920f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f3921g;

    /* renamed from: h, reason: collision with root package name */
    @GuardedBy("mServiceBrokerLock")
    public n f3922h;

    /* renamed from: i, reason: collision with root package name */
    public InterfaceC0088c f3923i;

    @GuardedBy("mLock")
    public T j;
    public final ArrayList<h<?>> k;

    @GuardedBy("mLock")
    public j l;

    @GuardedBy("mLock")
    public int m;
    public final a n;
    public final b o;
    public final int p;
    public final String q;
    public ConnectionResult r;
    public boolean s;
    public volatile zzb t;
    public AtomicInteger u;

    public interface a {
        void a(int i2);

        void b(Bundle bundle);
    }

    public interface b {
        void a(ConnectionResult connectionResult);
    }

    /* renamed from: c.c.a.b.c.o.c$c, reason: collision with other inner class name */
    public interface InterfaceC0088c {
        void a(ConnectionResult connectionResult);
    }

    public class d implements InterfaceC0088c {
        public d() {
        }

        @Override // c.c.a.b.c.o.c.InterfaceC0088c
        public void a(ConnectionResult connectionResult) {
            if (connectionResult.y()) {
                c cVar = c.this;
                cVar.a((c.c.a.b.c.o.k) null, cVar.u());
            } else if (c.this.o != null) {
                c.this.o.a(connectionResult);
            }
        }
    }

    public interface e {
        void a();
    }

    public abstract class f extends h<Boolean> {

        /* renamed from: d, reason: collision with root package name */
        public final int f3925d;

        /* renamed from: e, reason: collision with root package name */
        public final Bundle f3926e;

        public f(int i2, Bundle bundle) {
            super(true);
            this.f3925d = i2;
            this.f3926e = bundle;
        }

        public abstract void a(ConnectionResult connectionResult);

        @Override // c.c.a.b.c.o.c.h
        public final /* synthetic */ void a(Boolean bool) {
            if (bool == null) {
                c.this.c(1, null);
                return;
            }
            int i2 = this.f3925d;
            if (i2 == 0) {
                if (e()) {
                    return;
                }
                c.this.c(1, null);
                a(new ConnectionResult(8, null));
                return;
            }
            if (i2 == 10) {
                c.this.c(1, null);
                throw new IllegalStateException(String.format("A fatal developer error has occurred. Class name: %s. Start service action: %s. Service Descriptor: %s. ", getClass().getSimpleName(), c.this.k(), c.this.b()));
            }
            c.this.c(1, null);
            Bundle bundle = this.f3926e;
            a(new ConnectionResult(this.f3925d, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null));
        }

        @Override // c.c.a.b.c.o.c.h
        public final void c() {
        }

        public abstract boolean e();
    }

    public final class g extends c.c.a.b.f.c.d {
        public g(Looper looper) {
            super(looper);
        }

        public static void a(Message message) {
            h hVar = (h) message.obj;
            hVar.c();
            hVar.b();
        }

        public static boolean b(Message message) {
            int i2 = message.what;
            return i2 == 2 || i2 == 1 || i2 == 7;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (c.this.u.get() != message.arg1) {
                if (b(message)) {
                    a(message);
                    return;
                }
                return;
            }
            int i2 = message.what;
            if ((i2 == 1 || i2 == 7 || ((i2 == 4 && !c.this.n()) || message.what == 5)) && !c.this.e()) {
                a(message);
                return;
            }
            int i3 = message.what;
            if (i3 == 4) {
                c.this.r = new ConnectionResult(message.arg2);
                if (c.this.A() && !c.this.s) {
                    c.this.c(3, null);
                    return;
                }
                ConnectionResult connectionResult = c.this.r != null ? c.this.r : new ConnectionResult(8);
                c.this.f3923i.a(connectionResult);
                c.this.a(connectionResult);
                return;
            }
            if (i3 == 5) {
                ConnectionResult connectionResult2 = c.this.r != null ? c.this.r : new ConnectionResult(8);
                c.this.f3923i.a(connectionResult2);
                c.this.a(connectionResult2);
                return;
            }
            if (i3 == 3) {
                Object obj = message.obj;
                ConnectionResult connectionResult3 = new ConnectionResult(message.arg2, obj instanceof PendingIntent ? (PendingIntent) obj : null);
                c.this.f3923i.a(connectionResult3);
                c.this.a(connectionResult3);
                return;
            }
            if (i3 == 6) {
                c.this.c(5, null);
                if (c.this.n != null) {
                    c.this.n.a(message.arg2);
                }
                c.this.a(message.arg2);
                c.this.a(5, 1, (int) null);
                return;
            }
            if (i3 == 2 && !c.this.a()) {
                a(message);
                return;
            }
            if (b(message)) {
                ((h) message.obj).d();
                return;
            }
            int i4 = message.what;
            StringBuilder sb = new StringBuilder(45);
            sb.append("Don't know how to handle message: ");
            sb.append(i4);
            Log.wtf("GmsClient", sb.toString(), new Exception());
        }
    }

    public abstract class h<TListener> {

        /* renamed from: a, reason: collision with root package name */
        public TListener f3929a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f3930b = false;

        public h(TListener tlistener) {
            this.f3929a = tlistener;
        }

        public final void a() {
            synchronized (this) {
                this.f3929a = null;
            }
        }

        public abstract void a(TListener tlistener);

        public final void b() {
            a();
            synchronized (c.this.k) {
                c.this.k.remove(this);
            }
        }

        public abstract void c();

        public final void d() {
            TListener tlistener;
            synchronized (this) {
                tlistener = this.f3929a;
                if (this.f3930b) {
                    String valueOf = String.valueOf(this);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
                    sb.append("Callback proxy ");
                    sb.append(valueOf);
                    sb.append(" being reused. This is not safe.");
                    Log.w("GmsClient", sb.toString());
                }
            }
            if (tlistener != null) {
                try {
                    a(tlistener);
                } catch (RuntimeException e2) {
                    c();
                    throw e2;
                }
            } else {
                c();
            }
            synchronized (this) {
                this.f3930b = true;
            }
            b();
        }
    }

    public static final class i extends l.a {

        /* renamed from: a, reason: collision with root package name */
        public c f3932a;

        /* renamed from: b, reason: collision with root package name */
        public final int f3933b;

        public i(c cVar, int i2) {
            this.f3932a = cVar;
            this.f3933b = i2;
        }

        @Override // c.c.a.b.c.o.l
        public final void a(int i2, Bundle bundle) {
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        }

        @Override // c.c.a.b.c.o.l
        public final void a(int i2, IBinder iBinder, Bundle bundle) {
            r.a(this.f3932a, "onPostInitComplete can be called only once per call to getRemoteService");
            this.f3932a.a(i2, iBinder, bundle, this.f3933b);
            this.f3932a = null;
        }

        @Override // c.c.a.b.c.o.l
        public final void a(int i2, IBinder iBinder, zzb zzbVar) {
            r.a(this.f3932a, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
            r.a(zzbVar);
            this.f3932a.a(zzbVar);
            a(i2, iBinder, zzbVar.f10120a);
        }
    }

    public final class j implements ServiceConnection {

        /* renamed from: a, reason: collision with root package name */
        public final int f3934a;

        public j(int i2) {
            this.f3934a = i2;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            n mVar;
            if (iBinder == null) {
                c.this.c(16);
                return;
            }
            synchronized (c.this.f3921g) {
                c cVar = c.this;
                if (iBinder == null) {
                    mVar = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    mVar = (queryLocalInterface == null || !(queryLocalInterface instanceof n)) ? new m(iBinder) : (n) queryLocalInterface;
                }
                cVar.f3922h = mVar;
            }
            c.this.a(0, (Bundle) null, this.f3934a);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            synchronized (c.this.f3921g) {
                c.this.f3922h = null;
            }
            Handler handler = c.this.f3919e;
            handler.sendMessage(handler.obtainMessage(6, this.f3934a, 1));
        }
    }

    public final class k extends f {

        /* renamed from: g, reason: collision with root package name */
        public final IBinder f3936g;

        public k(int i2, IBinder iBinder, Bundle bundle) {
            super(i2, bundle);
            this.f3936g = iBinder;
        }

        @Override // c.c.a.b.c.o.c.f
        public final void a(ConnectionResult connectionResult) {
            if (c.this.o != null) {
                c.this.o.a(connectionResult);
            }
            c.this.a(connectionResult);
        }

        @Override // c.c.a.b.c.o.c.f
        public final boolean e() {
            try {
                String interfaceDescriptor = this.f3936g.getInterfaceDescriptor();
                if (!c.this.b().equals(interfaceDescriptor)) {
                    String b2 = c.this.b();
                    StringBuilder sb = new StringBuilder(String.valueOf(b2).length() + 34 + String.valueOf(interfaceDescriptor).length());
                    sb.append("service descriptor mismatch: ");
                    sb.append(b2);
                    sb.append(" vs. ");
                    sb.append(interfaceDescriptor);
                    Log.e("GmsClient", sb.toString());
                    return false;
                }
                IInterface a2 = c.this.a(this.f3936g);
                if (a2 == null || !(c.this.a(2, 4, (int) a2) || c.this.a(3, 4, (int) a2))) {
                    return false;
                }
                c.this.r = null;
                Bundle q = c.this.q();
                if (c.this.n == null) {
                    return true;
                }
                c.this.n.b(q);
                return true;
            } catch (RemoteException unused) {
                Log.w("GmsClient", "service probably died");
                return false;
            }
        }
    }

    public final class l extends f {
        public l(int i2, Bundle bundle) {
            super(i2, null);
        }

        @Override // c.c.a.b.c.o.c.f
        public final void a(ConnectionResult connectionResult) {
            if (c.this.n() && c.this.A()) {
                c.this.c(16);
            } else {
                c.this.f3923i.a(connectionResult);
                c.this.a(connectionResult);
            }
        }

        @Override // c.c.a.b.c.o.c.f
        public final boolean e() {
            c.this.f3923i.a(ConnectionResult.f10017e);
            return true;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public c(android.content.Context r10, android.os.Looper r11, int r12, c.c.a.b.c.o.c.a r13, c.c.a.b.c.o.c.b r14, java.lang.String r15) {
        /*
            r9 = this;
            c.c.a.b.c.o.h r3 = c.c.a.b.c.o.h.a(r10)
            c.c.a.b.c.d r4 = c.c.a.b.c.d.a()
            c.c.a.b.c.o.r.a(r13)
            r6 = r13
            c.c.a.b.c.o.c$a r6 = (c.c.a.b.c.o.c.a) r6
            c.c.a.b.c.o.r.a(r14)
            r7 = r14
            c.c.a.b.c.o.c$b r7 = (c.c.a.b.c.o.c.b) r7
            r0 = r9
            r1 = r10
            r2 = r11
            r5 = r12
            r8 = r15
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.b.c.o.c.<init>(android.content.Context, android.os.Looper, int, c.c.a.b.c.o.c$a, c.c.a.b.c.o.c$b, java.lang.String):void");
    }

    public final boolean A() {
        if (this.s || TextUtils.isEmpty(b()) || TextUtils.isEmpty(t())) {
            return false;
        }
        try {
            Class.forName(b());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public abstract T a(IBinder iBinder);

    public final void a(zzb zzbVar) {
        this.t = zzbVar;
    }

    public abstract String b();

    public void b(int i2) {
        Handler handler = this.f3919e;
        handler.sendMessage(handler.obtainMessage(6, this.u.get(), i2));
    }

    public void b(int i2, T t) {
    }

    public final void c(int i2, T t) {
        r.a((i2 == 4) == (t != null));
        synchronized (this.f3920f) {
            this.m = i2;
            this.j = t;
            b(i2, t);
            if (i2 != 1) {
                if (i2 == 2 || i2 == 3) {
                    if (this.l != null && this.f3915a != null) {
                        String c2 = this.f3915a.c();
                        String a2 = this.f3915a.a();
                        StringBuilder sb = new StringBuilder(String.valueOf(c2).length() + 70 + String.valueOf(a2).length());
                        sb.append("Calling connect() while still connected, missing disconnect() for ");
                        sb.append(c2);
                        sb.append(" on ");
                        sb.append(a2);
                        Log.e("GmsClient", sb.toString());
                        this.f3917c.a(this.f3915a.c(), this.f3915a.a(), this.f3915a.b(), this.l, y());
                        this.u.incrementAndGet();
                    }
                    this.l = new j(this.u.get());
                    l0 l0Var = (this.m != 3 || t() == null) ? new l0(w(), k(), false, 129) : new l0(r().getPackageName(), t(), true, 129);
                    this.f3915a = l0Var;
                    if (!this.f3917c.a(new h.a(l0Var.c(), this.f3915a.a(), this.f3915a.b()), this.l, y())) {
                        String c3 = this.f3915a.c();
                        String a3 = this.f3915a.a();
                        StringBuilder sb2 = new StringBuilder(String.valueOf(c3).length() + 34 + String.valueOf(a3).length());
                        sb2.append("unable to connect to service: ");
                        sb2.append(c3);
                        sb2.append(" on ");
                        sb2.append(a3);
                        Log.e("GmsClient", sb2.toString());
                        a(16, (Bundle) null, this.u.get());
                    }
                } else if (i2 == 4) {
                    a((c<T>) t);
                }
            } else if (this.l != null) {
                this.f3917c.a(this.f3915a.c(), this.f3915a.a(), this.f3915a.b(), this.l, y());
                this.l = null;
            }
        }
    }

    public boolean c() {
        return true;
    }

    public int d() {
        return c.c.a.b.c.d.f3814a;
    }

    public boolean e() {
        boolean z;
        synchronized (this.f3920f) {
            z = this.m == 2 || this.m == 3;
        }
        return z;
    }

    public final Feature[] f() {
        zzb zzbVar = this.t;
        if (zzbVar == null) {
            return null;
        }
        return zzbVar.f10121b;
    }

    public String g() {
        l0 l0Var;
        if (!a() || (l0Var = this.f3915a) == null) {
            throw new RuntimeException("Failed to connect when checking package");
        }
        return l0Var.a();
    }

    public void h() {
        this.u.incrementAndGet();
        synchronized (this.k) {
            int size = this.k.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.k.get(i2).a();
            }
            this.k.clear();
        }
        synchronized (this.f3921g) {
            this.f3922h = null;
        }
        c(1, null);
    }

    public boolean j() {
        return false;
    }

    public abstract String k();

    public void l() {
        int a2 = this.f3918d.a(this.f3916b, d());
        if (a2 == 0) {
            a(new d());
        } else {
            c(1, null);
            a(new d(), a2, (PendingIntent) null);
        }
    }

    public final void m() {
        if (!a()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public boolean n() {
        return false;
    }

    public Account o() {
        return null;
    }

    public Feature[] p() {
        return v;
    }

    public Bundle q() {
        return null;
    }

    public final Context r() {
        return this.f3916b;
    }

    public Bundle s() {
        return new Bundle();
    }

    public String t() {
        return null;
    }

    public Set<Scope> u() {
        return Collections.EMPTY_SET;
    }

    public final T v() throws DeadObjectException {
        T t;
        synchronized (this.f3920f) {
            if (this.m == 5) {
                throw new DeadObjectException();
            }
            m();
            r.b(this.j != null, "Client is connected but service is null");
            t = this.j;
        }
        return t;
    }

    public String w() {
        return "com.google.android.gms";
    }

    public boolean x() {
        return false;
    }

    public final String y() {
        String str = this.q;
        return str == null ? this.f3916b.getClass().getName() : str;
    }

    public final boolean z() {
        boolean z;
        synchronized (this.f3920f) {
            z = this.m == 3;
        }
        return z;
    }

    public void a(T t) {
        System.currentTimeMillis();
    }

    public void a(int i2) {
        System.currentTimeMillis();
    }

    public void a(ConnectionResult connectionResult) {
        connectionResult.u();
        System.currentTimeMillis();
    }

    public c(Context context, Looper looper, c.c.a.b.c.o.h hVar, c.c.a.b.c.d dVar, int i2, a aVar, b bVar, String str) {
        this.f3920f = new Object();
        this.f3921g = new Object();
        this.k = new ArrayList<>();
        this.m = 1;
        this.r = null;
        this.s = false;
        this.t = null;
        this.u = new AtomicInteger(0);
        r.a(context, "Context must not be null");
        this.f3916b = context;
        r.a(looper, "Looper must not be null");
        r.a(hVar, "Supervisor must not be null");
        this.f3917c = hVar;
        r.a(dVar, "API availability must not be null");
        this.f3918d = dVar;
        this.f3919e = new g(looper);
        this.p = i2;
        this.n = aVar;
        this.o = bVar;
        this.q = str;
    }

    public final boolean a(int i2, int i3, T t) {
        synchronized (this.f3920f) {
            if (this.m != i2) {
                return false;
            }
            c(i3, t);
            return true;
        }
    }

    public void a(InterfaceC0088c interfaceC0088c) {
        r.a(interfaceC0088c, "Connection progress callbacks cannot be null.");
        this.f3923i = interfaceC0088c;
        c(2, null);
    }

    public boolean a() {
        boolean z;
        synchronized (this.f3920f) {
            z = this.m == 4;
        }
        return z;
    }

    public void a(InterfaceC0088c interfaceC0088c, int i2, PendingIntent pendingIntent) {
        r.a(interfaceC0088c, "Connection progress callbacks cannot be null.");
        this.f3923i = interfaceC0088c;
        Handler handler = this.f3919e;
        handler.sendMessage(handler.obtainMessage(3, this.u.get(), i2, pendingIntent));
    }

    public void a(int i2, IBinder iBinder, Bundle bundle, int i3) {
        Handler handler = this.f3919e;
        handler.sendMessage(handler.obtainMessage(1, i3, -1, new k(i2, iBinder, bundle)));
    }

    public final void a(int i2, Bundle bundle, int i3) {
        Handler handler = this.f3919e;
        handler.sendMessage(handler.obtainMessage(7, i3, -1, new l(i2, null)));
    }

    public void a(c.c.a.b.c.o.k kVar, Set<Scope> set) {
        Bundle s = s();
        GetServiceRequest getServiceRequest = new GetServiceRequest(this.p);
        getServiceRequest.f10101d = this.f3916b.getPackageName();
        getServiceRequest.f10104g = s;
        if (set != null) {
            getServiceRequest.f10103f = (Scope[]) set.toArray(new Scope[set.size()]);
        }
        if (j()) {
            getServiceRequest.f10105h = o() != null ? o() : new Account("<<default account>>", "com.google");
            if (kVar != null) {
                getServiceRequest.f10102e = kVar.asBinder();
            }
        } else if (x()) {
            getServiceRequest.f10105h = o();
        }
        getServiceRequest.f10106i = v;
        getServiceRequest.j = p();
        try {
            synchronized (this.f3921g) {
                if (this.f3922h != null) {
                    this.f3922h.a(new i(this, this.u.get()), getServiceRequest);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (DeadObjectException e2) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e2);
            b(1);
        } catch (RemoteException e3) {
            e = e3;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            a(8, (IBinder) null, (Bundle) null, this.u.get());
        } catch (SecurityException e4) {
            throw e4;
        } catch (RuntimeException e5) {
            e = e5;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            a(8, (IBinder) null, (Bundle) null, this.u.get());
        }
    }

    public final void c(int i2) {
        int i3;
        if (z()) {
            i3 = 5;
            this.s = true;
        } else {
            i3 = 4;
        }
        Handler handler = this.f3919e;
        handler.sendMessage(handler.obtainMessage(i3, this.u.get(), 16));
    }

    public void a(e eVar) {
        eVar.a();
    }
}
