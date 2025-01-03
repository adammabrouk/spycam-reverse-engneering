package c.a.a.l.i;

import android.os.Looper;

/* compiled from: EngineResource.java */
/* loaded from: classes.dex */
public class h<Z> implements k<Z> {

    /* renamed from: a, reason: collision with root package name */
    public final k<Z> f3105a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f3106b;

    /* renamed from: c, reason: collision with root package name */
    public a f3107c;

    /* renamed from: d, reason: collision with root package name */
    public c.a.a.l.c f3108d;

    /* renamed from: e, reason: collision with root package name */
    public int f3109e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f3110f;

    /* compiled from: EngineResource.java */
    public interface a {
        void b(c.a.a.l.c cVar, h<?> hVar);
    }

    public h(k<Z> kVar, boolean z) {
        if (kVar == null) {
            throw new NullPointerException("Wrapped resource must not be null");
        }
        this.f3105a = kVar;
        this.f3106b = z;
    }

    public void a(c.a.a.l.c cVar, a aVar) {
        this.f3108d = cVar;
        this.f3107c = aVar;
    }

    @Override // c.a.a.l.i.k
    public int b() {
        return this.f3105a.b();
    }

    public void c() {
        if (this.f3110f) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        if (!Looper.getMainLooper().equals(Looper.myLooper())) {
            throw new IllegalThreadStateException("Must call acquire on the main thread");
        }
        this.f3109e++;
    }

    public boolean d() {
        return this.f3106b;
    }

    public void e() {
        if (this.f3109e <= 0) {
            throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
        }
        if (!Looper.getMainLooper().equals(Looper.myLooper())) {
            throw new IllegalThreadStateException("Must call release on the main thread");
        }
        int i2 = this.f3109e - 1;
        this.f3109e = i2;
        if (i2 == 0) {
            this.f3107c.b(this.f3108d, this);
        }
    }

    @Override // c.a.a.l.i.k
    public Z get() {
        return this.f3105a.get();
    }

    @Override // c.a.a.l.i.k
    public void a() {
        if (this.f3109e <= 0) {
            if (!this.f3110f) {
                this.f3110f = true;
                this.f3105a.a();
                return;
            }
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
    }
}
