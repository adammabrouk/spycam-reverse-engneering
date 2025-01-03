package c.a.a.l.i;

import android.util.Log;

/* compiled from: EngineRunnable.java */
/* loaded from: classes.dex */
public class i implements Runnable, c.a.a.l.i.o.b {

    /* renamed from: a, reason: collision with root package name */
    public final c.a.a.g f3111a;

    /* renamed from: b, reason: collision with root package name */
    public final a f3112b;

    /* renamed from: c, reason: collision with root package name */
    public final c.a.a.l.i.a<?, ?, ?> f3113c;

    /* renamed from: d, reason: collision with root package name */
    public b f3114d = b.CACHE;

    /* renamed from: e, reason: collision with root package name */
    public volatile boolean f3115e;

    /* compiled from: EngineRunnable.java */
    public interface a extends c.a.a.p.e {
        void a(i iVar);
    }

    /* compiled from: EngineRunnable.java */
    public enum b {
        CACHE,
        SOURCE
    }

    public i(a aVar, c.a.a.l.i.a<?, ?, ?> aVar2, c.a.a.g gVar) {
        this.f3112b = aVar;
        this.f3113c = aVar2;
        this.f3111a = gVar;
    }

    public final void a(k kVar) {
        this.f3112b.a((k<?>) kVar);
    }

    public void b() {
        this.f3115e = true;
        this.f3113c.a();
    }

    public final k<?> c() throws Exception {
        return f() ? d() : e();
    }

    public final k<?> d() throws Exception {
        k<?> kVar;
        try {
            kVar = this.f3113c.c();
        } catch (Exception e2) {
            if (Log.isLoggable("EngineRunnable", 3)) {
                Log.d("EngineRunnable", "Exception decoding result from cache: " + e2);
            }
            kVar = null;
        }
        return kVar == null ? this.f3113c.e() : kVar;
    }

    public final k<?> e() throws Exception {
        return this.f3113c.b();
    }

    public final boolean f() {
        return this.f3114d == b.CACHE;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3115e) {
            return;
        }
        k<?> kVar = null;
        try {
            e = null;
            kVar = c();
        } catch (Exception e2) {
            e = e2;
            if (Log.isLoggable("EngineRunnable", 2)) {
                Log.v("EngineRunnable", "Exception decoding", e);
            }
        }
        if (this.f3115e) {
            if (kVar != null) {
                kVar.a();
            }
        } else if (kVar == null) {
            a(e);
        } else {
            a(kVar);
        }
    }

    public final void a(Exception exc) {
        if (!f()) {
            this.f3112b.a(exc);
        } else {
            this.f3114d = b.SOURCE;
            this.f3112b.a(this);
        }
    }

    @Override // c.a.a.l.i.o.b
    public int a() {
        return this.f3111a.ordinal();
    }
}
