package c.c.a.b.j;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class c0<TResult> extends h<TResult> {

    /* renamed from: a, reason: collision with root package name */
    public final Object f5259a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final a0<TResult> f5260b = new a0<>();

    /* renamed from: c, reason: collision with root package name */
    @GuardedBy("mLock")
    public boolean f5261c;

    /* renamed from: d, reason: collision with root package name */
    public volatile boolean f5262d;

    /* renamed from: e, reason: collision with root package name */
    @GuardedBy("mLock")
    public TResult f5263e;

    /* renamed from: f, reason: collision with root package name */
    @GuardedBy("mLock")
    public Exception f5264f;

    @Override // c.c.a.b.j.h
    public final <X extends Throwable> TResult a(Class<X> cls) throws Throwable {
        TResult tresult;
        synchronized (this.f5259a) {
            g();
            i();
            if (cls.isInstance(this.f5264f)) {
                throw cls.cast(this.f5264f);
            }
            if (this.f5264f != null) {
                throw new f(this.f5264f);
            }
            tresult = this.f5263e;
        }
        return tresult;
    }

    @Override // c.c.a.b.j.h
    public final TResult b() {
        TResult tresult;
        synchronized (this.f5259a) {
            g();
            i();
            if (this.f5264f != null) {
                throw new f(this.f5264f);
            }
            tresult = this.f5263e;
        }
        return tresult;
    }

    @Override // c.c.a.b.j.h
    public final boolean c() {
        return this.f5262d;
    }

    @Override // c.c.a.b.j.h
    public final boolean d() {
        boolean z;
        synchronized (this.f5259a) {
            z = this.f5261c;
        }
        return z;
    }

    @Override // c.c.a.b.j.h
    public final boolean e() {
        boolean z;
        synchronized (this.f5259a) {
            z = this.f5261c && !this.f5262d && this.f5264f == null;
        }
        return z;
    }

    public final boolean f() {
        synchronized (this.f5259a) {
            if (this.f5261c) {
                return false;
            }
            this.f5261c = true;
            this.f5262d = true;
            this.f5260b.a(this);
            return true;
        }
    }

    @GuardedBy("mLock")
    public final void g() {
        c.c.a.b.c.o.r.b(this.f5261c, "Task is not yet complete");
    }

    @GuardedBy("mLock")
    public final void h() {
        c.c.a.b.c.o.r.b(!this.f5261c, "Task is already complete");
    }

    @GuardedBy("mLock")
    public final void i() {
        if (this.f5262d) {
            throw new CancellationException("Task is already canceled.");
        }
    }

    public final void j() {
        synchronized (this.f5259a) {
            if (this.f5261c) {
                this.f5260b.a(this);
            }
        }
    }

    @Override // c.c.a.b.j.h
    public final <TContinuationResult> h<TContinuationResult> b(Executor executor, a<TResult, h<TContinuationResult>> aVar) {
        c0 c0Var = new c0();
        this.f5260b.a(new n(executor, aVar, c0Var));
        j();
        return c0Var;
    }

    @Override // c.c.a.b.j.h
    public final Exception a() {
        Exception exc;
        synchronized (this.f5259a) {
            exc = this.f5264f;
        }
        return exc;
    }

    public final boolean b(TResult tresult) {
        synchronized (this.f5259a) {
            if (this.f5261c) {
                return false;
            }
            this.f5261c = true;
            this.f5263e = tresult;
            this.f5260b.a(this);
            return true;
        }
    }

    @Override // c.c.a.b.j.h
    public final h<TResult> a(Executor executor, e<? super TResult> eVar) {
        this.f5260b.a(new v(executor, eVar));
        j();
        return this;
    }

    @Override // c.c.a.b.j.h
    public final h<TResult> a(Executor executor, d dVar) {
        this.f5260b.a(new t(executor, dVar));
        j();
        return this;
    }

    @Override // c.c.a.b.j.h
    public final h<TResult> a(c<TResult> cVar) {
        a(j.f5268a, cVar);
        return this;
    }

    @Override // c.c.a.b.j.h
    public final h<TResult> a(Executor executor, c<TResult> cVar) {
        this.f5260b.a(new r(executor, cVar));
        j();
        return this;
    }

    public final boolean b(Exception exc) {
        c.c.a.b.c.o.r.a(exc, "Exception must not be null");
        synchronized (this.f5259a) {
            if (this.f5261c) {
                return false;
            }
            this.f5261c = true;
            this.f5264f = exc;
            this.f5260b.a(this);
            return true;
        }
    }

    @Override // c.c.a.b.j.h
    public final <TContinuationResult> h<TContinuationResult> a(Executor executor, a<TResult, TContinuationResult> aVar) {
        c0 c0Var = new c0();
        this.f5260b.a(new l(executor, aVar, c0Var));
        j();
        return c0Var;
    }

    @Override // c.c.a.b.j.h
    public final h<TResult> a(Executor executor, b bVar) {
        this.f5260b.a(new p(executor, bVar));
        j();
        return this;
    }

    @Override // c.c.a.b.j.h
    public final <TContinuationResult> h<TContinuationResult> a(Executor executor, g<TResult, TContinuationResult> gVar) {
        c0 c0Var = new c0();
        this.f5260b.a(new x(executor, gVar, c0Var));
        j();
        return c0Var;
    }

    public final void a(TResult tresult) {
        synchronized (this.f5259a) {
            h();
            this.f5261c = true;
            this.f5263e = tresult;
        }
        this.f5260b.a(this);
    }

    public final void a(Exception exc) {
        c.c.a.b.c.o.r.a(exc, "Exception must not be null");
        synchronized (this.f5259a) {
            h();
            this.f5261c = true;
            this.f5264f = exc;
        }
        this.f5260b.a(this);
    }
}
