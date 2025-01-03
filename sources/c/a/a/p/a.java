package c.a.a.p;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import c.a.a.l.g;
import c.a.a.l.i.c;
import c.a.a.l.i.k;
import c.a.a.p.h.h;
import c.a.a.p.h.j;
import java.util.Queue;

/* compiled from: GenericRequest.java */
/* loaded from: classes.dex */
public final class a<A, T, Z, R> implements b, h, e {
    public static final Queue<a<?, ?, ?, ?>> D = c.a.a.r.h.a(0);
    public c.C0065c A;
    public long B;
    public EnumC0074a C;

    /* renamed from: a, reason: collision with root package name */
    public final String f3402a = String.valueOf(hashCode());

    /* renamed from: b, reason: collision with root package name */
    public c.a.a.l.c f3403b;

    /* renamed from: c, reason: collision with root package name */
    public Drawable f3404c;

    /* renamed from: d, reason: collision with root package name */
    public int f3405d;

    /* renamed from: e, reason: collision with root package name */
    public int f3406e;

    /* renamed from: f, reason: collision with root package name */
    public int f3407f;

    /* renamed from: g, reason: collision with root package name */
    public Context f3408g;

    /* renamed from: h, reason: collision with root package name */
    public g<Z> f3409h;

    /* renamed from: i, reason: collision with root package name */
    public c.a.a.o.f<A, T, Z, R> f3410i;
    public c j;
    public A k;
    public Class<R> l;
    public boolean m;
    public c.a.a.g n;
    public j<R> o;
    public d<? super A, R> p;
    public float q;
    public c.a.a.l.i.c r;
    public c.a.a.p.g.d<R> s;
    public int t;
    public int u;
    public c.a.a.l.i.b v;
    public Drawable w;
    public Drawable x;
    public boolean y;
    public k<?> z;

    /* compiled from: GenericRequest.java */
    /* renamed from: c.a.a.p.a$a, reason: collision with other inner class name */
    public enum EnumC0074a {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CANCELLED,
        CLEARED,
        PAUSED
    }

    public static <A, T, Z, R> a<A, T, Z, R> b(c.a.a.o.f<A, T, Z, R> fVar, A a2, c.a.a.l.c cVar, Context context, c.a.a.g gVar, j<R> jVar, float f2, Drawable drawable, int i2, Drawable drawable2, int i3, Drawable drawable3, int i4, d<? super A, R> dVar, c cVar2, c.a.a.l.i.c cVar3, g<Z> gVar2, Class<R> cls, boolean z, c.a.a.p.g.d<R> dVar2, int i5, int i6, c.a.a.l.i.b bVar) {
        a<A, T, Z, R> aVar = (a) D.poll();
        if (aVar == null) {
            aVar = new a<>();
        }
        aVar.a(fVar, a2, cVar, context, gVar, jVar, f2, drawable, i2, drawable2, i3, drawable3, i4, dVar, cVar2, cVar3, gVar2, cls, z, dVar2, i5, i6, bVar);
        return aVar;
    }

    @Override // c.a.a.p.b
    public void a() {
        this.f3410i = null;
        this.k = null;
        this.f3408g = null;
        this.o = null;
        this.w = null;
        this.x = null;
        this.f3404c = null;
        this.p = null;
        this.j = null;
        this.f3409h = null;
        this.s = null;
        this.y = false;
        this.A = null;
        D.offer(this);
    }

    @Override // c.a.a.p.b
    public void c() {
        clear();
        this.C = EnumC0074a.PAUSED;
    }

    @Override // c.a.a.p.b
    public void clear() {
        c.a.a.r.h.a();
        if (this.C == EnumC0074a.CLEARED) {
            return;
        }
        h();
        k<?> kVar = this.z;
        if (kVar != null) {
            b(kVar);
        }
        if (b()) {
            this.o.c(k());
        }
        this.C = EnumC0074a.CLEARED;
    }

    @Override // c.a.a.p.b
    public void d() {
        this.B = c.a.a.r.d.a();
        if (this.k == null) {
            a((Exception) null);
            return;
        }
        this.C = EnumC0074a.WAITING_FOR_SIZE;
        if (c.a.a.r.h.a(this.t, this.u)) {
            a(this.t, this.u);
        } else {
            this.o.a((h) this);
        }
        if (!f() && !l() && b()) {
            this.o.b(k());
        }
        if (Log.isLoggable("GenericRequest", 2)) {
            a("finished run method in " + c.a.a.r.d.a(this.B));
        }
    }

    @Override // c.a.a.p.b
    public boolean e() {
        return f();
    }

    @Override // c.a.a.p.b
    public boolean f() {
        return this.C == EnumC0074a.COMPLETE;
    }

    public final boolean g() {
        c cVar = this.j;
        return cVar == null || cVar.b(this);
    }

    public void h() {
        this.C = EnumC0074a.CANCELLED;
        c.C0065c c0065c = this.A;
        if (c0065c != null) {
            c0065c.a();
            this.A = null;
        }
    }

    public final Drawable i() {
        if (this.x == null && this.f3407f > 0) {
            this.x = this.f3408g.getResources().getDrawable(this.f3407f);
        }
        return this.x;
    }

    @Override // c.a.a.p.b
    public boolean isCancelled() {
        EnumC0074a enumC0074a = this.C;
        return enumC0074a == EnumC0074a.CANCELLED || enumC0074a == EnumC0074a.CLEARED;
    }

    @Override // c.a.a.p.b
    public boolean isRunning() {
        EnumC0074a enumC0074a = this.C;
        return enumC0074a == EnumC0074a.RUNNING || enumC0074a == EnumC0074a.WAITING_FOR_SIZE;
    }

    public final Drawable j() {
        if (this.f3404c == null && this.f3405d > 0) {
            this.f3404c = this.f3408g.getResources().getDrawable(this.f3405d);
        }
        return this.f3404c;
    }

    public final Drawable k() {
        if (this.w == null && this.f3406e > 0) {
            this.w = this.f3408g.getResources().getDrawable(this.f3406e);
        }
        return this.w;
    }

    public boolean l() {
        return this.C == EnumC0074a.FAILED;
    }

    public final boolean m() {
        c cVar = this.j;
        return cVar == null || !cVar.b();
    }

    public final void n() {
        c cVar = this.j;
        if (cVar != null) {
            cVar.c(this);
        }
    }

    public final void b(k kVar) {
        this.r.b(kVar);
        this.z = null;
    }

    public final void b(Exception exc) {
        if (b()) {
            Drawable j = this.k == null ? j() : null;
            if (j == null) {
                j = i();
            }
            if (j == null) {
                j = k();
            }
            this.o.a(exc, j);
        }
    }

    public final boolean b() {
        c cVar = this.j;
        return cVar == null || cVar.a(this);
    }

    public final void a(c.a.a.o.f<A, T, Z, R> fVar, A a2, c.a.a.l.c cVar, Context context, c.a.a.g gVar, j<R> jVar, float f2, Drawable drawable, int i2, Drawable drawable2, int i3, Drawable drawable3, int i4, d<? super A, R> dVar, c cVar2, c.a.a.l.i.c cVar3, g<Z> gVar2, Class<R> cls, boolean z, c.a.a.p.g.d<R> dVar2, int i5, int i6, c.a.a.l.i.b bVar) {
        this.f3410i = fVar;
        this.k = a2;
        this.f3403b = cVar;
        this.f3404c = drawable3;
        this.f3405d = i4;
        this.f3408g = context.getApplicationContext();
        this.n = gVar;
        this.o = jVar;
        this.q = f2;
        this.w = drawable;
        this.f3406e = i2;
        this.x = drawable2;
        this.f3407f = i3;
        this.p = dVar;
        this.j = cVar2;
        this.r = cVar3;
        this.f3409h = gVar2;
        this.l = cls;
        this.m = z;
        this.s = dVar2;
        this.t = i5;
        this.u = i6;
        this.v = bVar;
        this.C = EnumC0074a.PENDING;
        if (a2 != null) {
            a("ModelLoader", fVar.d(), "try .using(ModelLoader)");
            a("Transcoder", fVar.c(), "try .as*(Class).transcode(ResourceTranscoder)");
            a("Transformation", gVar2, "try .transform(UnitTransformation.get())");
            if (bVar.cacheSource()) {
                a("SourceEncoder", fVar.b(), "try .sourceEncoder(Encoder) or .diskCacheStrategy(NONE/RESULT)");
            } else {
                a("SourceDecoder", fVar.f(), "try .decoder/.imageDecoder/.videoDecoder(ResourceDecoder) or .diskCacheStrategy(ALL/SOURCE)");
            }
            if (bVar.cacheSource() || bVar.cacheResult()) {
                a("CacheDecoder", fVar.a(), "try .cacheDecoder(ResouceDecoder) or .diskCacheStrategy(NONE)");
            }
            if (bVar.cacheResult()) {
                a("Encoder", fVar.e(), "try .encode(ResourceEncoder) or .diskCacheStrategy(NONE/SOURCE)");
            }
        }
    }

    public static void a(String str, Object obj, String str2) {
        if (obj == null) {
            StringBuilder sb = new StringBuilder(str);
            sb.append(" must not be null");
            if (str2 != null) {
                sb.append(", ");
                sb.append(str2);
            }
            throw new NullPointerException(sb.toString());
        }
    }

    @Override // c.a.a.p.h.h
    public void a(int i2, int i3) {
        if (Log.isLoggable("GenericRequest", 2)) {
            a("Got onSizeReady in " + c.a.a.r.d.a(this.B));
        }
        if (this.C != EnumC0074a.WAITING_FOR_SIZE) {
            return;
        }
        this.C = EnumC0074a.RUNNING;
        int round = Math.round(this.q * i2);
        int round2 = Math.round(this.q * i3);
        c.a.a.l.h.c<T> a2 = this.f3410i.d().a(this.k, round, round2);
        if (a2 == null) {
            a(new Exception("Failed to load model: '" + this.k + "'"));
            return;
        }
        c.a.a.l.k.j.c<Z, R> c2 = this.f3410i.c();
        if (Log.isLoggable("GenericRequest", 2)) {
            a("finished setup for calling load in " + c.a.a.r.d.a(this.B));
        }
        this.y = true;
        this.A = this.r.a(this.f3403b, round, round2, a2, this.f3410i, this.f3409h, c2, this.n, this.m, this.v, this);
        this.y = this.z != null;
        if (Log.isLoggable("GenericRequest", 2)) {
            a("finished onSizeReady in " + c.a.a.r.d.a(this.B));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // c.a.a.p.e
    public void a(k<?> kVar) {
        if (kVar == null) {
            a(new Exception("Expected to receive a Resource<R> with an object of " + this.l + " inside, but instead got null."));
            return;
        }
        Object obj = kVar.get();
        if (obj != null && this.l.isAssignableFrom(obj.getClass())) {
            if (!g()) {
                b(kVar);
                this.C = EnumC0074a.COMPLETE;
                return;
            } else {
                a(kVar, (k<?>) obj);
                return;
            }
        }
        b(kVar);
        StringBuilder sb = new StringBuilder();
        sb.append("Expected to receive an object of ");
        sb.append(this.l);
        sb.append(" but instead got ");
        sb.append(obj != null ? obj.getClass() : "");
        sb.append("{");
        sb.append(obj);
        sb.append("}");
        sb.append(" inside Resource{");
        sb.append(kVar);
        sb.append("}.");
        sb.append(obj == null ? " To indicate failure return a null Resource object, rather than a Resource object containing null data." : "");
        a(new Exception(sb.toString()));
    }

    public final void a(k<?> kVar, R r) {
        boolean m = m();
        this.C = EnumC0074a.COMPLETE;
        this.z = kVar;
        d<? super A, R> dVar = this.p;
        if (dVar == null || !dVar.a(r, this.k, this.o, this.y, m)) {
            this.o.a((j<R>) r, (c.a.a.p.g.c<? super j<R>>) this.s.a(this.y, m));
        }
        n();
        if (Log.isLoggable("GenericRequest", 2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Resource ready in ");
            sb.append(c.a.a.r.d.a(this.B));
            sb.append(" size: ");
            double b2 = kVar.b();
            Double.isNaN(b2);
            sb.append(b2 * 9.5367431640625E-7d);
            sb.append(" fromCache: ");
            sb.append(this.y);
            a(sb.toString());
        }
    }

    @Override // c.a.a.p.e
    public void a(Exception exc) {
        if (Log.isLoggable("GenericRequest", 3)) {
            Log.d("GenericRequest", "load failed", exc);
        }
        this.C = EnumC0074a.FAILED;
        d<? super A, R> dVar = this.p;
        if (dVar == null || !dVar.a(exc, this.k, this.o, m())) {
            b(exc);
        }
    }

    public final void a(String str) {
        Log.v("GenericRequest", str + " this: " + this.f3402a);
    }
}
