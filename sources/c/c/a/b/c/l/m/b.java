package c.c.a.b.c.l.m;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import c.c.a.b.c.l.a;
import c.c.a.b.c.o.c;
import c.c.a.b.c.o.q;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public class b implements Handler.Callback {
    public static final Status m = new Status(4, "Sign-out occurred while this API call was in progress.");
    public static final Status n = new Status(4, "The user must be signed in to make this API call.");
    public static final Object o = new Object();

    @GuardedBy("lock")
    public static b p;

    /* renamed from: a, reason: collision with root package name */
    public long f3841a = 5000;

    /* renamed from: b, reason: collision with root package name */
    public long f3842b = 120000;

    /* renamed from: c, reason: collision with root package name */
    public long f3843c = 10000;

    /* renamed from: d, reason: collision with root package name */
    public final Context f3844d;

    /* renamed from: e, reason: collision with root package name */
    public final c.c.a.b.c.c f3845e;

    /* renamed from: f, reason: collision with root package name */
    public final c.c.a.b.c.o.j f3846f;

    /* renamed from: g, reason: collision with root package name */
    public final AtomicInteger f3847g;

    /* renamed from: h, reason: collision with root package name */
    public final Map<e0<?>, a<?>> f3848h;

    /* renamed from: i, reason: collision with root package name */
    @GuardedBy("lock")
    public j f3849i;

    @GuardedBy("lock")
    public final Set<e0<?>> j;
    public final Set<e0<?>> k;
    public final Handler l;

    public class c implements z, c.InterfaceC0088c {

        /* renamed from: a, reason: collision with root package name */
        public final a.f f3861a;

        /* renamed from: b, reason: collision with root package name */
        public final e0<?> f3862b;

        /* renamed from: c, reason: collision with root package name */
        public c.c.a.b.c.o.k f3863c = null;

        /* renamed from: d, reason: collision with root package name */
        public Set<Scope> f3864d = null;

        /* renamed from: e, reason: collision with root package name */
        public boolean f3865e = false;

        public c(a.f fVar, e0<?> e0Var) {
            this.f3861a = fVar;
            this.f3862b = e0Var;
        }

        @Override // c.c.a.b.c.o.c.InterfaceC0088c
        public final void a(ConnectionResult connectionResult) {
            b.this.l.post(new r(this, connectionResult));
        }

        @Override // c.c.a.b.c.l.m.z
        public final void b(ConnectionResult connectionResult) {
            ((a) b.this.f3848h.get(this.f3862b)).b(connectionResult);
        }

        @Override // c.c.a.b.c.l.m.z
        public final void a(c.c.a.b.c.o.k kVar, Set<Scope> set) {
            if (kVar == null || set == null) {
                Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
                b(new ConnectionResult(4));
            } else {
                this.f3863c = kVar;
                this.f3864d = set;
                a();
            }
        }

        public final void a() {
            c.c.a.b.c.o.k kVar;
            if (!this.f3865e || (kVar = this.f3863c) == null) {
                return;
            }
            this.f3861a.a(kVar, this.f3864d);
        }

        public static /* synthetic */ boolean a(c cVar, boolean z) {
            cVar.f3865e = true;
            return true;
        }
    }

    public b(Context context, Looper looper, c.c.a.b.c.c cVar) {
        new AtomicInteger(1);
        this.f3847g = new AtomicInteger(0);
        this.f3848h = new ConcurrentHashMap(5, 0.75f, 1);
        this.f3849i = null;
        this.j = new a.e.b();
        this.k = new a.e.b();
        this.f3844d = context;
        this.l = new c.c.a.b.f.b.e(looper, this);
        this.f3845e = cVar;
        this.f3846f = new c.c.a.b.c.o.j(cVar);
        Handler handler = this.l;
        handler.sendMessage(handler.obtainMessage(6));
    }

    public static b a(Context context) {
        b bVar;
        synchronized (o) {
            if (p == null) {
                HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
                handlerThread.start();
                p = new b(context.getApplicationContext(), handlerThread.getLooper(), c.c.a.b.c.c.a());
            }
            bVar = p;
        }
        return bVar;
    }

    public final boolean b(ConnectionResult connectionResult, int i2) {
        return this.f3845e.a(this.f3844d, connectionResult, i2);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i2 = message.what;
        a<?> aVar = null;
        switch (i2) {
            case 1:
                this.f3843c = ((Boolean) message.obj).booleanValue() ? 10000L : 300000L;
                this.l.removeMessages(12);
                for (e0<?> e0Var : this.f3848h.keySet()) {
                    Handler handler = this.l;
                    handler.sendMessageDelayed(handler.obtainMessage(12, e0Var), this.f3843c);
                }
                return true;
            case 2:
                f0 f0Var = (f0) message.obj;
                Iterator<e0<?>> it = f0Var.a().iterator();
                while (true) {
                    if (it.hasNext()) {
                        e0<?> next = it.next();
                        a<?> aVar2 = this.f3848h.get(next);
                        if (aVar2 == null) {
                            f0Var.a(next, new ConnectionResult(13), null);
                        } else if (aVar2.c()) {
                            f0Var.a(next, ConnectionResult.f10017e, aVar2.f().g());
                        } else if (aVar2.n() != null) {
                            f0Var.a(next, aVar2.n(), null);
                        } else {
                            aVar2.a(f0Var);
                            aVar2.a();
                        }
                    }
                }
                return true;
            case 3:
                for (a<?> aVar3 : this.f3848h.values()) {
                    aVar3.m();
                    aVar3.a();
                }
                return true;
            case 4:
            case 8:
            case 13:
                t tVar = (t) message.obj;
                a<?> aVar4 = this.f3848h.get(tVar.f3898c.c());
                if (aVar4 == null) {
                    a(tVar.f3898c);
                    aVar4 = this.f3848h.get(tVar.f3898c.c());
                }
                if (!aVar4.d() || this.f3847g.get() == tVar.f3897b) {
                    aVar4.a(tVar.f3896a);
                } else {
                    tVar.f3896a.a(m);
                    aVar4.k();
                }
                return true;
            case 5:
                int i3 = message.arg1;
                ConnectionResult connectionResult = (ConnectionResult) message.obj;
                Iterator<a<?>> it2 = this.f3848h.values().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        a<?> next2 = it2.next();
                        if (next2.b() == i3) {
                            aVar = next2;
                        }
                    }
                }
                if (aVar != null) {
                    String a2 = this.f3845e.a(connectionResult.u());
                    String v = connectionResult.v();
                    StringBuilder sb = new StringBuilder(String.valueOf(a2).length() + 69 + String.valueOf(v).length());
                    sb.append("Error resolution was canceled by the user, original error message: ");
                    sb.append(a2);
                    sb.append(": ");
                    sb.append(v);
                    aVar.a(new Status(17, sb.toString()));
                } else {
                    StringBuilder sb2 = new StringBuilder(76);
                    sb2.append("Could not find API instance ");
                    sb2.append(i3);
                    sb2.append(" while trying to fail enqueued calls.");
                    Log.wtf("GoogleApiManager", sb2.toString(), new Exception());
                }
                return true;
            case 6:
                if (c.c.a.b.c.s.n.a() && (this.f3844d.getApplicationContext() instanceof Application)) {
                    c.c.a.b.c.l.m.a.a((Application) this.f3844d.getApplicationContext());
                    c.c.a.b.c.l.m.a.b().a(new m(this));
                    if (!c.c.a.b.c.l.m.a.b().b(true)) {
                        this.f3843c = 300000L;
                    }
                }
                return true;
            case 7:
                a((c.c.a.b.c.l.e<?>) message.obj);
                return true;
            case 9:
                if (this.f3848h.containsKey(message.obj)) {
                    this.f3848h.get(message.obj).e();
                }
                return true;
            case 10:
                Iterator<e0<?>> it3 = this.k.iterator();
                while (it3.hasNext()) {
                    this.f3848h.remove(it3.next()).k();
                }
                this.k.clear();
                return true;
            case 11:
                if (this.f3848h.containsKey(message.obj)) {
                    this.f3848h.get(message.obj).g();
                }
                return true;
            case 12:
                if (this.f3848h.containsKey(message.obj)) {
                    this.f3848h.get(message.obj).q();
                }
                return true;
            case 14:
                k kVar = (k) message.obj;
                e0<?> b2 = kVar.b();
                if (this.f3848h.containsKey(b2)) {
                    kVar.a().a((c.c.a.b.j.i<Boolean>) Boolean.valueOf(a.a((a) this.f3848h.get(b2), false)));
                } else {
                    kVar.a().a((c.c.a.b.j.i<Boolean>) false);
                }
                return true;
            case 15:
                C0087b c0087b = (C0087b) message.obj;
                if (this.f3848h.containsKey(c0087b.f3859a)) {
                    this.f3848h.get(c0087b.f3859a).a(c0087b);
                }
                return true;
            case 16:
                C0087b c0087b2 = (C0087b) message.obj;
                if (this.f3848h.containsKey(c0087b2.f3859a)) {
                    this.f3848h.get(c0087b2.f3859a).b(c0087b2);
                }
                return true;
            default:
                StringBuilder sb3 = new StringBuilder(31);
                sb3.append("Unknown message id: ");
                sb3.append(i2);
                Log.w("GoogleApiManager", sb3.toString());
                return false;
        }
    }

    public class a<O extends a.d> implements c.c.a.b.c.l.f, c.c.a.b.c.l.g, i0 {

        /* renamed from: b, reason: collision with root package name */
        public final a.f f3851b;

        /* renamed from: c, reason: collision with root package name */
        public final a.b f3852c;

        /* renamed from: d, reason: collision with root package name */
        public final e0<O> f3853d;

        /* renamed from: e, reason: collision with root package name */
        public final i f3854e;

        /* renamed from: h, reason: collision with root package name */
        public final int f3857h;

        /* renamed from: i, reason: collision with root package name */
        public final w f3858i;
        public boolean j;

        /* renamed from: a, reason: collision with root package name */
        public final Queue<l> f3850a = new LinkedList();

        /* renamed from: f, reason: collision with root package name */
        public final Set<f0> f3855f = new HashSet();

        /* renamed from: g, reason: collision with root package name */
        public final Map<f<?>, u> f3856g = new HashMap();
        public final List<C0087b> k = new ArrayList();
        public ConnectionResult l = null;

        public a(c.c.a.b.c.l.e<O> eVar) {
            a.f a2 = eVar.a(b.this.l.getLooper(), this);
            this.f3851b = a2;
            if (a2 instanceof c.c.a.b.c.o.t) {
                this.f3852c = ((c.c.a.b.c.o.t) a2).B();
            } else {
                this.f3852c = a2;
            }
            this.f3853d = eVar.c();
            this.f3854e = new i();
            this.f3857h = eVar.b();
            if (this.f3851b.j()) {
                this.f3858i = eVar.a(b.this.f3844d, b.this.l);
            } else {
                this.f3858i = null;
            }
        }

        @Override // c.c.a.b.c.l.f
        public final void a(int i2) {
            if (Looper.myLooper() == b.this.l.getLooper()) {
                i();
            } else {
                b.this.l.post(new o(this));
            }
        }

        @Override // c.c.a.b.c.l.f
        public final void b(Bundle bundle) {
            if (Looper.myLooper() == b.this.l.getLooper()) {
                h();
            } else {
                b.this.l.post(new n(this));
            }
        }

        public final boolean c(ConnectionResult connectionResult) {
            synchronized (b.o) {
                if (b.this.f3849i != null && b.this.j.contains(this.f3853d)) {
                    b.this.f3849i.a(connectionResult, this.f3857h);
                    throw null;
                }
            }
            return false;
        }

        public final void d(ConnectionResult connectionResult) {
            for (f0 f0Var : this.f3855f) {
                String str = null;
                if (c.c.a.b.c.o.q.a(connectionResult, ConnectionResult.f10017e)) {
                    str = this.f3851b.g();
                }
                f0Var.a(this.f3853d, connectionResult, str);
            }
            this.f3855f.clear();
        }

        public final void e() {
            c.c.a.b.c.o.r.a(b.this.l);
            if (this.j) {
                a();
            }
        }

        public final a.f f() {
            return this.f3851b;
        }

        public final void g() {
            c.c.a.b.c.o.r.a(b.this.l);
            if (this.j) {
                o();
                a(b.this.f3845e.b(b.this.f3844d) == 18 ? new Status(8, "Connection timed out while waiting for Google Play services update to complete.") : new Status(8, "API failed to connect while resuming due to an unknown error."));
                this.f3851b.h();
            }
        }

        public final void h() {
            m();
            d(ConnectionResult.f10017e);
            o();
            Iterator<u> it = this.f3856g.values().iterator();
            while (it.hasNext()) {
                u next = it.next();
                if (a(next.f3899a.b()) != null) {
                    it.remove();
                } else {
                    try {
                        next.f3899a.a(this.f3852c, new c.c.a.b.j.i<>());
                    } catch (DeadObjectException unused) {
                        a(1);
                        this.f3851b.h();
                    } catch (RemoteException unused2) {
                        it.remove();
                    }
                }
            }
            j();
            p();
        }

        public final void i() {
            m();
            this.j = true;
            this.f3854e.c();
            b.this.l.sendMessageDelayed(Message.obtain(b.this.l, 9, this.f3853d), b.this.f3841a);
            b.this.l.sendMessageDelayed(Message.obtain(b.this.l, 11, this.f3853d), b.this.f3842b);
            b.this.f3846f.a();
        }

        public final void j() {
            ArrayList arrayList = new ArrayList(this.f3850a);
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                l lVar = (l) obj;
                if (!this.f3851b.a()) {
                    return;
                }
                if (b(lVar)) {
                    this.f3850a.remove(lVar);
                }
            }
        }

        public final void k() {
            c.c.a.b.c.o.r.a(b.this.l);
            a(b.m);
            this.f3854e.b();
            for (f fVar : (f[]) this.f3856g.keySet().toArray(new f[this.f3856g.size()])) {
                a(new d0(fVar, new c.c.a.b.j.i()));
            }
            d(new ConnectionResult(4));
            if (this.f3851b.a()) {
                this.f3851b.a(new p(this));
            }
        }

        public final Map<f<?>, u> l() {
            return this.f3856g;
        }

        public final void m() {
            c.c.a.b.c.o.r.a(b.this.l);
            this.l = null;
        }

        public final ConnectionResult n() {
            c.c.a.b.c.o.r.a(b.this.l);
            return this.l;
        }

        public final void o() {
            if (this.j) {
                b.this.l.removeMessages(11, this.f3853d);
                b.this.l.removeMessages(9, this.f3853d);
                this.j = false;
            }
        }

        public final void p() {
            b.this.l.removeMessages(12, this.f3853d);
            b.this.l.sendMessageDelayed(b.this.l.obtainMessage(12, this.f3853d), b.this.f3843c);
        }

        public final boolean q() {
            return a(true);
        }

        @Override // c.c.a.b.c.l.g
        public final void a(ConnectionResult connectionResult) {
            c.c.a.b.c.o.r.a(b.this.l);
            w wVar = this.f3858i;
            if (wVar != null) {
                wVar.f();
            }
            m();
            b.this.f3846f.a();
            d(connectionResult);
            if (connectionResult.u() == 4) {
                a(b.n);
                return;
            }
            if (this.f3850a.isEmpty()) {
                this.l = connectionResult;
                return;
            }
            if (c(connectionResult) || b.this.b(connectionResult, this.f3857h)) {
                return;
            }
            if (connectionResult.u() == 18) {
                this.j = true;
            }
            if (this.j) {
                b.this.l.sendMessageDelayed(Message.obtain(b.this.l, 9, this.f3853d), b.this.f3841a);
                return;
            }
            String a2 = this.f3853d.a();
            StringBuilder sb = new StringBuilder(String.valueOf(a2).length() + 38);
            sb.append("API: ");
            sb.append(a2);
            sb.append(" is not available on this device.");
            a(new Status(17, sb.toString()));
        }

        public final void b(ConnectionResult connectionResult) {
            c.c.a.b.c.o.r.a(b.this.l);
            this.f3851b.h();
            a(connectionResult);
        }

        public final void c(l lVar) {
            lVar.a(this.f3854e, d());
            try {
                lVar.a((a<?>) this);
            } catch (DeadObjectException unused) {
                a(1);
                this.f3851b.h();
            }
        }

        public final boolean d() {
            return this.f3851b.j();
        }

        public final boolean b(l lVar) {
            if (!(lVar instanceof v)) {
                c(lVar);
                return true;
            }
            v vVar = (v) lVar;
            Feature a2 = a(vVar.b((a<?>) this));
            if (a2 == null) {
                c(lVar);
                return true;
            }
            if (vVar.c(this)) {
                C0087b c0087b = new C0087b(this.f3853d, a2, null);
                int indexOf = this.k.indexOf(c0087b);
                if (indexOf >= 0) {
                    C0087b c0087b2 = this.k.get(indexOf);
                    b.this.l.removeMessages(15, c0087b2);
                    b.this.l.sendMessageDelayed(Message.obtain(b.this.l, 15, c0087b2), b.this.f3841a);
                    return false;
                }
                this.k.add(c0087b);
                b.this.l.sendMessageDelayed(Message.obtain(b.this.l, 15, c0087b), b.this.f3841a);
                b.this.l.sendMessageDelayed(Message.obtain(b.this.l, 16, c0087b), b.this.f3842b);
                ConnectionResult connectionResult = new ConnectionResult(2, null);
                if (c(connectionResult)) {
                    return false;
                }
                b.this.b(connectionResult, this.f3857h);
                return false;
            }
            vVar.a(new c.c.a.b.c.l.l(a2));
            return false;
        }

        public final boolean c() {
            return this.f3851b.a();
        }

        public final void a(l lVar) {
            c.c.a.b.c.o.r.a(b.this.l);
            if (this.f3851b.a()) {
                if (b(lVar)) {
                    p();
                    return;
                } else {
                    this.f3850a.add(lVar);
                    return;
                }
            }
            this.f3850a.add(lVar);
            ConnectionResult connectionResult = this.l;
            if (connectionResult != null && connectionResult.x()) {
                a(this.l);
            } else {
                a();
            }
        }

        public final int b() {
            return this.f3857h;
        }

        public final void b(C0087b c0087b) {
            Feature[] b2;
            if (this.k.remove(c0087b)) {
                b.this.l.removeMessages(15, c0087b);
                b.this.l.removeMessages(16, c0087b);
                Feature feature = c0087b.f3860b;
                ArrayList arrayList = new ArrayList(this.f3850a.size());
                for (l lVar : this.f3850a) {
                    if ((lVar instanceof v) && (b2 = ((v) lVar).b((a<?>) this)) != null && c.c.a.b.c.s.b.a(b2, feature)) {
                        arrayList.add(lVar);
                    }
                }
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList.get(i2);
                    i2++;
                    l lVar2 = (l) obj;
                    this.f3850a.remove(lVar2);
                    lVar2.a(new c.c.a.b.c.l.l(feature));
                }
            }
        }

        public final void a(Status status) {
            c.c.a.b.c.o.r.a(b.this.l);
            Iterator<l> it = this.f3850a.iterator();
            while (it.hasNext()) {
                it.next().a(status);
            }
            this.f3850a.clear();
        }

        public final boolean a(boolean z) {
            c.c.a.b.c.o.r.a(b.this.l);
            if (!this.f3851b.a() || this.f3856g.size() != 0) {
                return false;
            }
            if (!this.f3854e.a()) {
                this.f3851b.h();
                return true;
            }
            if (z) {
                p();
            }
            return false;
        }

        public final void a() {
            c.c.a.b.c.o.r.a(b.this.l);
            if (this.f3851b.a() || this.f3851b.e()) {
                return;
            }
            int a2 = b.this.f3846f.a(b.this.f3844d, this.f3851b);
            if (a2 != 0) {
                a(new ConnectionResult(a2, null));
                return;
            }
            c cVar = b.this.new c(this.f3851b, this.f3853d);
            if (this.f3851b.j()) {
                this.f3858i.a(cVar);
            }
            this.f3851b.a(cVar);
        }

        public final void a(f0 f0Var) {
            c.c.a.b.c.o.r.a(b.this.l);
            this.f3855f.add(f0Var);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final Feature a(Feature[] featureArr) {
            if (featureArr != null && featureArr.length != 0) {
                Feature[] f2 = this.f3851b.f();
                if (f2 == null) {
                    f2 = new Feature[0];
                }
                a.e.a aVar = new a.e.a(f2.length);
                for (Feature feature : f2) {
                    aVar.put(feature.u(), Long.valueOf(feature.v()));
                }
                for (Feature feature2 : featureArr) {
                    if (!aVar.containsKey(feature2.u()) || ((Long) aVar.get(feature2.u())).longValue() < feature2.v()) {
                        return feature2;
                    }
                }
            }
            return null;
        }

        public final void a(C0087b c0087b) {
            if (this.k.contains(c0087b) && !this.j) {
                if (!this.f3851b.a()) {
                    a();
                } else {
                    j();
                }
            }
        }

        public static /* synthetic */ boolean a(a aVar, boolean z) {
            return aVar.a(false);
        }
    }

    /* renamed from: c.c.a.b.c.l.m.b$b, reason: collision with other inner class name */
    public static class C0087b {

        /* renamed from: a, reason: collision with root package name */
        public final e0<?> f3859a;

        /* renamed from: b, reason: collision with root package name */
        public final Feature f3860b;

        public C0087b(e0<?> e0Var, Feature feature) {
            this.f3859a = e0Var;
            this.f3860b = feature;
        }

        public final boolean equals(Object obj) {
            if (obj != null && (obj instanceof C0087b)) {
                C0087b c0087b = (C0087b) obj;
                if (c.c.a.b.c.o.q.a(this.f3859a, c0087b.f3859a) && c.c.a.b.c.o.q.a(this.f3860b, c0087b.f3860b)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return c.c.a.b.c.o.q.a(this.f3859a, this.f3860b);
        }

        public final String toString() {
            q.a a2 = c.c.a.b.c.o.q.a(this);
            a2.a("key", this.f3859a);
            a2.a("feature", this.f3860b);
            return a2.toString();
        }

        public /* synthetic */ C0087b(e0 e0Var, Feature feature, m mVar) {
            this(e0Var, feature);
        }
    }

    public final void a(c.c.a.b.c.l.e<?> eVar) {
        e0<?> c2 = eVar.c();
        a<?> aVar = this.f3848h.get(c2);
        if (aVar == null) {
            aVar = new a<>(eVar);
            this.f3848h.put(c2, aVar);
        }
        if (aVar.d()) {
            this.k.add(c2);
        }
        aVar.a();
    }

    public final void a() {
        Handler handler = this.l;
        handler.sendMessage(handler.obtainMessage(3));
    }

    public final void a(ConnectionResult connectionResult, int i2) {
        if (b(connectionResult, i2)) {
            return;
        }
        Handler handler = this.l;
        handler.sendMessage(handler.obtainMessage(5, i2, 0, connectionResult));
    }
}
