package androidx.lifecycle;

import a.m.f;
import a.m.g;
import a.m.i;
import a.m.o;

/* loaded from: classes.dex */
public abstract class LiveData<T> {
    public static final Object j = new Object();

    /* renamed from: d, reason: collision with root package name */
    public boolean f2651d;

    /* renamed from: e, reason: collision with root package name */
    public volatile Object f2652e;

    /* renamed from: g, reason: collision with root package name */
    public int f2654g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f2655h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f2656i;

    /* renamed from: a, reason: collision with root package name */
    public final Object f2648a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public a.c.a.b.b<o<? super T>, LiveData<T>.c> f2649b = new a.c.a.b.b<>();

    /* renamed from: c, reason: collision with root package name */
    public int f2650c = 0;

    /* renamed from: f, reason: collision with root package name */
    public volatile Object f2653f = j;

    public class a implements Runnable {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            synchronized (LiveData.this.f2648a) {
                obj = LiveData.this.f2653f;
                LiveData.this.f2653f = LiveData.j;
            }
            LiveData.this.a((LiveData) obj);
        }
    }

    public class b extends LiveData<T>.c {
        public b(LiveData liveData, o<? super T> oVar) {
            super(oVar);
        }

        @Override // androidx.lifecycle.LiveData.c
        public boolean b() {
            return true;
        }
    }

    public abstract class c {

        /* renamed from: a, reason: collision with root package name */
        public final o<? super T> f2660a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f2661b;

        /* renamed from: c, reason: collision with root package name */
        public int f2662c = -1;

        public c(o<? super T> oVar) {
            this.f2660a = oVar;
        }

        public void a() {
        }

        public void a(boolean z) {
            if (z == this.f2661b) {
                return;
            }
            this.f2661b = z;
            LiveData.this.a(z ? 1 : -1);
            if (this.f2661b) {
                LiveData.this.b(this);
            }
        }

        public abstract boolean b();

        public boolean g(i iVar) {
            return false;
        }
    }

    public LiveData() {
        new a();
        this.f2652e = j;
        this.f2654g = -1;
    }

    public final void a(LiveData<T>.c cVar) {
        if (cVar.f2661b) {
            if (!cVar.b()) {
                cVar.a(false);
                return;
            }
            int i2 = cVar.f2662c;
            int i3 = this.f2654g;
            if (i2 >= i3) {
                return;
            }
            cVar.f2662c = i3;
            cVar.f2660a.a((Object) this.f2652e);
        }
    }

    public void b(LiveData<T>.c cVar) {
        if (this.f2655h) {
            this.f2656i = true;
            return;
        }
        this.f2655h = true;
        do {
            this.f2656i = false;
            if (cVar != null) {
                a((c) cVar);
                cVar = null;
            } else {
                a.c.a.b.b<o<? super T>, LiveData<T>.c>.d e2 = this.f2649b.e();
                while (e2.hasNext()) {
                    a((c) e2.next().getValue());
                    if (this.f2656i) {
                        break;
                    }
                }
            }
        } while (this.f2656i);
        this.f2655h = false;
    }

    public void c() {
    }

    public void d() {
    }

    public class LifecycleBoundObserver extends LiveData<T>.c implements g {

        /* renamed from: e, reason: collision with root package name */
        public final i f2657e;

        public LifecycleBoundObserver(i iVar, o<? super T> oVar) {
            super(oVar);
            this.f2657e = iVar;
        }

        @Override // a.m.g
        public void a(i iVar, f.b bVar) {
            f.c a2 = this.f2657e.getLifecycle().a();
            if (a2 == f.c.DESTROYED) {
                LiveData.this.b(this.f2660a);
                return;
            }
            f.c cVar = null;
            while (cVar != a2) {
                a(b());
                cVar = a2;
                a2 = this.f2657e.getLifecycle().a();
            }
        }

        @Override // androidx.lifecycle.LiveData.c
        public boolean b() {
            return this.f2657e.getLifecycle().a().isAtLeast(f.c.STARTED);
        }

        @Override // androidx.lifecycle.LiveData.c
        public boolean g(i iVar) {
            return this.f2657e == iVar;
        }

        @Override // androidx.lifecycle.LiveData.c
        public void a() {
            this.f2657e.getLifecycle().b(this);
        }
    }

    public void a(i iVar, o<? super T> oVar) {
        a("observe");
        if (iVar.getLifecycle().a() == f.c.DESTROYED) {
            return;
        }
        LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(iVar, oVar);
        LiveData<T>.c b2 = this.f2649b.b(oVar, lifecycleBoundObserver);
        if (b2 != null && !b2.g(iVar)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (b2 != null) {
            return;
        }
        iVar.getLifecycle().a(lifecycleBoundObserver);
    }

    public void b(o<? super T> oVar) {
        a("removeObserver");
        LiveData<T>.c remove = this.f2649b.remove(oVar);
        if (remove == null) {
            return;
        }
        remove.a();
        remove.a(false);
    }

    public void a(o<? super T> oVar) {
        a("observeForever");
        b bVar = new b(this, oVar);
        LiveData<T>.c b2 = this.f2649b.b(oVar, bVar);
        if (b2 instanceof LifecycleBoundObserver) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (b2 != null) {
            return;
        }
        bVar.a(true);
    }

    public boolean b() {
        return this.f2650c > 0;
    }

    public void a(T t) {
        a("setValue");
        this.f2654g++;
        this.f2652e = t;
        b((c) null);
    }

    public T a() {
        T t = (T) this.f2652e;
        if (t != j) {
            return t;
        }
        return null;
    }

    public void a(int i2) {
        int i3 = this.f2650c;
        this.f2650c = i2 + i3;
        if (this.f2651d) {
            return;
        }
        this.f2651d = true;
        while (true) {
            try {
                if (i3 == this.f2650c) {
                    return;
                }
                boolean z = i3 == 0 && this.f2650c > 0;
                boolean z2 = i3 > 0 && this.f2650c == 0;
                int i4 = this.f2650c;
                if (z) {
                    c();
                } else if (z2) {
                    d();
                }
                i3 = i4;
            } finally {
                this.f2651d = false;
            }
        }
    }

    public static void a(String str) {
        if (a.c.a.a.a.b().a()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }
}
