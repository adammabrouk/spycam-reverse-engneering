package c.a.a.l.i;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import c.a.a.l.i.i;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* compiled from: EngineJob.java */
/* loaded from: classes.dex */
public class d implements i.a {
    public static final b q = new b();
    public static final Handler r = new Handler(Looper.getMainLooper(), new c());

    /* renamed from: a, reason: collision with root package name */
    public final List<c.a.a.p.e> f3087a;

    /* renamed from: b, reason: collision with root package name */
    public final b f3088b;

    /* renamed from: c, reason: collision with root package name */
    public final e f3089c;

    /* renamed from: d, reason: collision with root package name */
    public final c.a.a.l.c f3090d;

    /* renamed from: e, reason: collision with root package name */
    public final ExecutorService f3091e;

    /* renamed from: f, reason: collision with root package name */
    public final ExecutorService f3092f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f3093g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f3094h;

    /* renamed from: i, reason: collision with root package name */
    public k<?> f3095i;
    public boolean j;
    public Exception k;
    public boolean l;
    public Set<c.a.a.p.e> m;
    public i n;
    public h<?> o;
    public volatile Future<?> p;

    /* compiled from: EngineJob.java */
    public static class b {
        public <R> h<R> a(k<R> kVar, boolean z) {
            return new h<>(kVar, z);
        }
    }

    /* compiled from: EngineJob.java */
    public static class c implements Handler.Callback {
        public c() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (1 != i2 && 2 != i2) {
                return false;
            }
            d dVar = (d) message.obj;
            if (1 == message.what) {
                dVar.c();
            } else {
                dVar.b();
            }
            return true;
        }
    }

    public d(c.a.a.l.c cVar, ExecutorService executorService, ExecutorService executorService2, boolean z, e eVar) {
        this(cVar, executorService, executorService2, z, eVar, q);
    }

    public final boolean c(c.a.a.p.e eVar) {
        Set<c.a.a.p.e> set = this.m;
        return set != null && set.contains(eVar);
    }

    public void d(c.a.a.p.e eVar) {
        c.a.a.r.h.a();
        if (this.j || this.l) {
            b(eVar);
            return;
        }
        this.f3087a.remove(eVar);
        if (this.f3087a.isEmpty()) {
            a();
        }
    }

    public d(c.a.a.l.c cVar, ExecutorService executorService, ExecutorService executorService2, boolean z, e eVar, b bVar) {
        this.f3087a = new ArrayList();
        this.f3090d = cVar;
        this.f3091e = executorService;
        this.f3092f = executorService2;
        this.f3093g = z;
        this.f3089c = eVar;
        this.f3088b = bVar;
    }

    @Override // c.a.a.l.i.i.a
    public void a(i iVar) {
        this.p = this.f3092f.submit(iVar);
    }

    public void b(i iVar) {
        this.n = iVar;
        this.p = this.f3091e.submit(iVar);
    }

    public final void c() {
        if (this.f3094h) {
            this.f3095i.a();
            return;
        }
        if (this.f3087a.isEmpty()) {
            throw new IllegalStateException("Received a resource without any callbacks to notify");
        }
        h<?> a2 = this.f3088b.a(this.f3095i, this.f3093g);
        this.o = a2;
        this.j = true;
        a2.c();
        this.f3089c.a(this.f3090d, this.o);
        for (c.a.a.p.e eVar : this.f3087a) {
            if (!c(eVar)) {
                this.o.c();
                eVar.a(this.o);
            }
        }
        this.o.e();
    }

    public void a(c.a.a.p.e eVar) {
        c.a.a.r.h.a();
        if (this.j) {
            eVar.a(this.o);
        } else if (this.l) {
            eVar.a(this.k);
        } else {
            this.f3087a.add(eVar);
        }
    }

    public final void b(c.a.a.p.e eVar) {
        if (this.m == null) {
            this.m = new HashSet();
        }
        this.m.add(eVar);
    }

    public final void b() {
        if (this.f3094h) {
            return;
        }
        if (!this.f3087a.isEmpty()) {
            this.l = true;
            this.f3089c.a(this.f3090d, (h<?>) null);
            for (c.a.a.p.e eVar : this.f3087a) {
                if (!c(eVar)) {
                    eVar.a(this.k);
                }
            }
            return;
        }
        throw new IllegalStateException("Received an exception without any callbacks to notify");
    }

    public void a() {
        if (this.l || this.j || this.f3094h) {
            return;
        }
        this.n.b();
        Future<?> future = this.p;
        if (future != null) {
            future.cancel(true);
        }
        this.f3094h = true;
        this.f3089c.a(this, this.f3090d);
    }

    @Override // c.a.a.p.e
    public void a(k<?> kVar) {
        this.f3095i = kVar;
        r.obtainMessage(1, this).sendToTarget();
    }

    @Override // c.a.a.p.e
    public void a(Exception exc) {
        this.k = exc;
        r.obtainMessage(2, this).sendToTarget();
    }
}
