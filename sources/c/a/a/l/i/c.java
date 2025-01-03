package c.a.a.l.i;

import android.os.Looper;
import android.os.MessageQueue;
import android.util.Log;
import c.a.a.l.i.a;
import c.a.a.l.i.h;
import c.a.a.l.i.n.a;
import c.a.a.l.i.n.h;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* compiled from: Engine.java */
/* loaded from: classes.dex */
public class c implements c.a.a.l.i.e, h.a, h.a {

    /* renamed from: a, reason: collision with root package name */
    public final Map<c.a.a.l.c, c.a.a.l.i.d> f3069a;

    /* renamed from: b, reason: collision with root package name */
    public final g f3070b;

    /* renamed from: c, reason: collision with root package name */
    public final c.a.a.l.i.n.h f3071c;

    /* renamed from: d, reason: collision with root package name */
    public final a f3072d;

    /* renamed from: e, reason: collision with root package name */
    public final Map<c.a.a.l.c, WeakReference<h<?>>> f3073e;

    /* renamed from: f, reason: collision with root package name */
    public final l f3074f;

    /* renamed from: g, reason: collision with root package name */
    public final b f3075g;

    /* renamed from: h, reason: collision with root package name */
    public ReferenceQueue<h<?>> f3076h;

    /* compiled from: Engine.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final ExecutorService f3077a;

        /* renamed from: b, reason: collision with root package name */
        public final ExecutorService f3078b;

        /* renamed from: c, reason: collision with root package name */
        public final c.a.a.l.i.e f3079c;

        public a(ExecutorService executorService, ExecutorService executorService2, c.a.a.l.i.e eVar) {
            this.f3077a = executorService;
            this.f3078b = executorService2;
            this.f3079c = eVar;
        }

        public c.a.a.l.i.d a(c.a.a.l.c cVar, boolean z) {
            return new c.a.a.l.i.d(cVar, this.f3077a, this.f3078b, z, this.f3079c);
        }
    }

    /* compiled from: Engine.java */
    public static class b implements a.InterfaceC0064a {

        /* renamed from: a, reason: collision with root package name */
        public final a.InterfaceC0067a f3080a;

        /* renamed from: b, reason: collision with root package name */
        public volatile c.a.a.l.i.n.a f3081b;

        public b(a.InterfaceC0067a interfaceC0067a) {
            this.f3080a = interfaceC0067a;
        }

        @Override // c.a.a.l.i.a.InterfaceC0064a
        public c.a.a.l.i.n.a a() {
            if (this.f3081b == null) {
                synchronized (this) {
                    if (this.f3081b == null) {
                        this.f3081b = this.f3080a.a();
                    }
                    if (this.f3081b == null) {
                        this.f3081b = new c.a.a.l.i.n.b();
                    }
                }
            }
            return this.f3081b;
        }
    }

    /* compiled from: Engine.java */
    /* renamed from: c.a.a.l.i.c$c, reason: collision with other inner class name */
    public static class C0065c {

        /* renamed from: a, reason: collision with root package name */
        public final c.a.a.l.i.d f3082a;

        /* renamed from: b, reason: collision with root package name */
        public final c.a.a.p.e f3083b;

        public C0065c(c.a.a.p.e eVar, c.a.a.l.i.d dVar) {
            this.f3083b = eVar;
            this.f3082a = dVar;
        }

        public void a() {
            this.f3082a.d(this.f3083b);
        }
    }

    /* compiled from: Engine.java */
    public static class d implements MessageQueue.IdleHandler {

        /* renamed from: a, reason: collision with root package name */
        public final Map<c.a.a.l.c, WeakReference<h<?>>> f3084a;

        /* renamed from: b, reason: collision with root package name */
        public final ReferenceQueue<h<?>> f3085b;

        public d(Map<c.a.a.l.c, WeakReference<h<?>>> map, ReferenceQueue<h<?>> referenceQueue) {
            this.f3084a = map;
            this.f3085b = referenceQueue;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            e eVar = (e) this.f3085b.poll();
            if (eVar == null) {
                return true;
            }
            this.f3084a.remove(eVar.f3086a);
            return true;
        }
    }

    /* compiled from: Engine.java */
    public static class e extends WeakReference<h<?>> {

        /* renamed from: a, reason: collision with root package name */
        public final c.a.a.l.c f3086a;

        public e(c.a.a.l.c cVar, h<?> hVar, ReferenceQueue<? super h<?>> referenceQueue) {
            super(hVar, referenceQueue);
            this.f3086a = cVar;
        }
    }

    public c(c.a.a.l.i.n.h hVar, a.InterfaceC0067a interfaceC0067a, ExecutorService executorService, ExecutorService executorService2) {
        this(hVar, interfaceC0067a, executorService, executorService2, null, null, null, null, null);
    }

    public <T, Z, R> C0065c a(c.a.a.l.c cVar, int i2, int i3, c.a.a.l.h.c<T> cVar2, c.a.a.o.b<T, Z> bVar, c.a.a.l.g<Z> gVar, c.a.a.l.k.j.c<Z, R> cVar3, c.a.a.g gVar2, boolean z, c.a.a.l.i.b bVar2, c.a.a.p.e eVar) {
        c.a.a.r.h.a();
        long a2 = c.a.a.r.d.a();
        f a3 = this.f3070b.a(cVar2.c(), cVar, i2, i3, bVar.a(), bVar.f(), gVar, bVar.e(), cVar3, bVar.b());
        h<?> b2 = b(a3, z);
        if (b2 != null) {
            eVar.a(b2);
            if (Log.isLoggable("Engine", 2)) {
                a("Loaded resource from cache", a2, a3);
            }
            return null;
        }
        h<?> a4 = a(a3, z);
        if (a4 != null) {
            eVar.a(a4);
            if (Log.isLoggable("Engine", 2)) {
                a("Loaded resource from active resources", a2, a3);
            }
            return null;
        }
        c.a.a.l.i.d dVar = this.f3069a.get(a3);
        if (dVar != null) {
            dVar.a(eVar);
            if (Log.isLoggable("Engine", 2)) {
                a("Added to existing load", a2, a3);
            }
            return new C0065c(eVar, dVar);
        }
        c.a.a.l.i.d a5 = this.f3072d.a(a3, z);
        i iVar = new i(a5, new c.a.a.l.i.a(a3, i2, i3, cVar2, bVar, gVar, cVar3, this.f3075g, bVar2, gVar2), gVar2);
        this.f3069a.put(a3, a5);
        a5.a(eVar);
        a5.b(iVar);
        if (Log.isLoggable("Engine", 2)) {
            a("Started new load", a2, a3);
        }
        return new C0065c(eVar, a5);
    }

    public final h<?> b(c.a.a.l.c cVar, boolean z) {
        if (!z) {
            return null;
        }
        h<?> a2 = a(cVar);
        if (a2 != null) {
            a2.c();
            this.f3073e.put(cVar, new e(cVar, a2, a()));
        }
        return a2;
    }

    public c(c.a.a.l.i.n.h hVar, a.InterfaceC0067a interfaceC0067a, ExecutorService executorService, ExecutorService executorService2, Map<c.a.a.l.c, c.a.a.l.i.d> map, g gVar, Map<c.a.a.l.c, WeakReference<h<?>>> map2, a aVar, l lVar) {
        this.f3071c = hVar;
        this.f3075g = new b(interfaceC0067a);
        this.f3073e = map2 == null ? new HashMap<>() : map2;
        this.f3070b = gVar == null ? new g() : gVar;
        this.f3069a = map == null ? new HashMap<>() : map;
        this.f3072d = aVar == null ? new a(executorService, executorService2, this) : aVar;
        this.f3074f = lVar == null ? new l() : lVar;
        hVar.a(this);
    }

    public void b(k kVar) {
        c.a.a.r.h.a();
        if (kVar instanceof h) {
            ((h) kVar).e();
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    @Override // c.a.a.l.i.h.a
    public void b(c.a.a.l.c cVar, h hVar) {
        c.a.a.r.h.a();
        this.f3073e.remove(cVar);
        if (hVar.d()) {
            this.f3071c.a(cVar, hVar);
        } else {
            this.f3074f.a(hVar);
        }
    }

    public static void a(String str, long j, c.a.a.l.c cVar) {
        Log.v("Engine", str + " in " + c.a.a.r.d.a(j) + "ms, key: " + cVar);
    }

    public final h<?> a(c.a.a.l.c cVar, boolean z) {
        h<?> hVar = null;
        if (!z) {
            return null;
        }
        WeakReference<h<?>> weakReference = this.f3073e.get(cVar);
        if (weakReference != null) {
            hVar = weakReference.get();
            if (hVar != null) {
                hVar.c();
            } else {
                this.f3073e.remove(cVar);
            }
        }
        return hVar;
    }

    public final h<?> a(c.a.a.l.c cVar) {
        k<?> a2 = this.f3071c.a(cVar);
        if (a2 == null) {
            return null;
        }
        if (a2 instanceof h) {
            return (h) a2;
        }
        return new h<>(a2, true);
    }

    @Override // c.a.a.l.i.e
    public void a(c.a.a.l.c cVar, h<?> hVar) {
        c.a.a.r.h.a();
        if (hVar != null) {
            hVar.a(cVar, this);
            if (hVar.d()) {
                this.f3073e.put(cVar, new e(cVar, hVar, a()));
            }
        }
        this.f3069a.remove(cVar);
    }

    @Override // c.a.a.l.i.e
    public void a(c.a.a.l.i.d dVar, c.a.a.l.c cVar) {
        c.a.a.r.h.a();
        if (dVar.equals(this.f3069a.get(cVar))) {
            this.f3069a.remove(cVar);
        }
    }

    @Override // c.a.a.l.i.n.h.a
    public void a(k<?> kVar) {
        c.a.a.r.h.a();
        this.f3074f.a(kVar);
    }

    public final ReferenceQueue<h<?>> a() {
        if (this.f3076h == null) {
            this.f3076h = new ReferenceQueue<>();
            Looper.myQueue().addIdleHandler(new d(this.f3073e, this.f3076h));
        }
        return this.f3076h;
    }
}
