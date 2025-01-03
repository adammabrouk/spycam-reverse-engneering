package c.a.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import c.a.a.l.j.l;
import c.a.a.m.c;
import c.a.a.m.m;

/* compiled from: RequestManager.java */
/* loaded from: classes.dex */
public class h implements c.a.a.m.h {

    /* renamed from: a, reason: collision with root package name */
    public final Context f2933a;

    /* renamed from: b, reason: collision with root package name */
    public final c.a.a.m.g f2934b;

    /* renamed from: c, reason: collision with root package name */
    public final m f2935c;

    /* renamed from: d, reason: collision with root package name */
    public final c.a.a.e f2936d;

    /* renamed from: e, reason: collision with root package name */
    public final d f2937e;

    /* renamed from: f, reason: collision with root package name */
    public b f2938f;

    /* compiled from: RequestManager.java */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c.a.a.m.g f2939a;

        public a(c.a.a.m.g gVar) {
            this.f2939a = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2939a.a(h.this);
        }
    }

    /* compiled from: RequestManager.java */
    public interface b {
        <T> void a(c.a.a.c<T, ?, ?, ?> cVar);
    }

    /* compiled from: RequestManager.java */
    public final class c<A, T> {

        /* renamed from: a, reason: collision with root package name */
        public final l<A, T> f2941a;

        /* renamed from: b, reason: collision with root package name */
        public final Class<T> f2942b;

        /* compiled from: RequestManager.java */
        public final class a {

            /* renamed from: a, reason: collision with root package name */
            public final A f2944a;

            /* renamed from: b, reason: collision with root package name */
            public final Class<A> f2945b;

            /* renamed from: c, reason: collision with root package name */
            public final boolean f2946c = true;

            public a(A a2) {
                this.f2944a = a2;
                this.f2945b = h.b(a2);
            }

            public <Z> c.a.a.d<A, T, Z> a(Class<Z> cls) {
                d dVar = h.this.f2937e;
                c.a.a.d<A, T, Z> dVar2 = new c.a.a.d<>(h.this.f2933a, h.this.f2936d, this.f2945b, c.this.f2941a, c.this.f2942b, cls, h.this.f2935c, h.this.f2934b, h.this.f2937e);
                dVar.a(dVar2);
                c.a.a.d<A, T, Z> dVar3 = dVar2;
                if (this.f2946c) {
                    dVar3.a((c.a.a.d<A, T, Z>) this.f2944a);
                }
                return dVar3;
            }
        }

        public c(l<A, T> lVar, Class<T> cls) {
            this.f2941a = lVar;
            this.f2942b = cls;
        }

        public c<A, T>.a a(A a2) {
            return new a(a2);
        }
    }

    /* compiled from: RequestManager.java */
    public class d {
        public d() {
        }

        public <A, X extends c.a.a.c<A, ?, ?, ?>> X a(X x) {
            if (h.this.f2938f != null) {
                h.this.f2938f.a(x);
            }
            return x;
        }
    }

    /* compiled from: RequestManager.java */
    public static class e implements c.a {

        /* renamed from: a, reason: collision with root package name */
        public final m f2949a;

        public e(m mVar) {
            this.f2949a = mVar;
        }

        @Override // c.a.a.m.c.a
        public void a(boolean z) {
            if (z) {
                this.f2949a.c();
            }
        }
    }

    public h(Context context, c.a.a.m.g gVar, c.a.a.m.l lVar) {
        this(context, gVar, lVar, new m(), new c.a.a.m.d());
    }

    public void g() {
        this.f2936d.a();
    }

    public void h() {
        c.a.a.r.h.a();
        this.f2935c.b();
    }

    public void i() {
        c.a.a.r.h.a();
        this.f2935c.d();
    }

    public h(Context context, c.a.a.m.g gVar, c.a.a.m.l lVar, m mVar, c.a.a.m.d dVar) {
        this.f2933a = context.getApplicationContext();
        this.f2934b = gVar;
        this.f2935c = mVar;
        this.f2936d = c.a.a.e.a(context);
        this.f2937e = new d();
        c.a.a.m.c a2 = dVar.a(context, new e(mVar));
        if (c.a.a.r.h.b()) {
            new Handler(Looper.getMainLooper()).post(new a(gVar));
        } else {
            gVar.a(this);
        }
        gVar.a(a2);
    }

    @Override // c.a.a.m.h
    public void b() {
        h();
    }

    public c.a.a.b<Integer> c() {
        c.a.a.b<Integer> a2 = a(Integer.class);
        a2.a(c.a.a.q.a.a(this.f2933a));
        return a2;
    }

    public c.a.a.b<String> d() {
        return a(String.class);
    }

    @Override // c.a.a.m.h
    public void f() {
        this.f2935c.a();
    }

    public static <T> Class<T> b(T t) {
        if (t != null) {
            return (Class<T>) t.getClass();
        }
        return null;
    }

    public void a(int i2) {
        this.f2936d.a(i2);
    }

    @Override // c.a.a.m.h
    public void a() {
        i();
    }

    public <A, T> c<A, T> a(l<A, T> lVar, Class<T> cls) {
        return new c<>(lVar, cls);
    }

    public c.a.a.b<String> a(String str) {
        c.a.a.b<String> d2 = d();
        d2.a((c.a.a.b<String>) str);
        return d2;
    }

    public c.a.a.b<Integer> a(Integer num) {
        c.a.a.b<Integer> c2 = c();
        c2.a((c.a.a.b<Integer>) num);
        return c2;
    }

    public final <T> c.a.a.b<T> a(Class<T> cls) {
        l b2 = c.a.a.e.b(cls, this.f2933a);
        l a2 = c.a.a.e.a(cls, this.f2933a);
        if (cls != null && b2 == null && a2 == null) {
            throw new IllegalArgumentException("Unknown type " + cls + ". You must provide a Model of a type for which there is a registered ModelLoader, if you are using a custom model, you must first call Glide#register with a ModelLoaderFactory for your custom model class");
        }
        d dVar = this.f2937e;
        c.a.a.b<T> bVar = new c.a.a.b<>(cls, b2, a2, this.f2933a, this.f2936d, this.f2935c, this.f2934b, dVar);
        dVar.a(bVar);
        return bVar;
    }
}
