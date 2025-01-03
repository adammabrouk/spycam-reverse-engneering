package h;

import h.x;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* compiled from: Dispatcher.java */
/* loaded from: classes.dex */
public final class n {

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public Runnable f11726c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public ExecutorService f11727d;

    /* renamed from: a, reason: collision with root package name */
    public int f11724a = 64;

    /* renamed from: b, reason: collision with root package name */
    public int f11725b = 5;

    /* renamed from: e, reason: collision with root package name */
    public final Deque<x.a> f11728e = new ArrayDeque();

    /* renamed from: f, reason: collision with root package name */
    public final Deque<x.a> f11729f = new ArrayDeque();

    /* renamed from: g, reason: collision with root package name */
    public final Deque<x> f11730g = new ArrayDeque();

    public synchronized ExecutorService a() {
        if (this.f11727d == null) {
            this.f11727d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), h.e0.c.a("OkHttp Dispatcher", false));
        }
        return this.f11727d;
    }

    public final void b() {
        if (this.f11729f.size() < this.f11724a && !this.f11728e.isEmpty()) {
            Iterator<x.a> it = this.f11728e.iterator();
            while (it.hasNext()) {
                x.a next = it.next();
                if (b(next) < this.f11725b) {
                    it.remove();
                    this.f11729f.add(next);
                    a().execute(next);
                }
                if (this.f11729f.size() >= this.f11724a) {
                    return;
                }
            }
        }
    }

    public synchronized int c() {
        return this.f11729f.size() + this.f11730g.size();
    }

    public synchronized void a(int i2) {
        if (i2 >= 1) {
            this.f11724a = i2;
            b();
        } else {
            throw new IllegalArgumentException("max < 1: " + i2);
        }
    }

    public synchronized void a(x xVar) {
        this.f11730g.add(xVar);
    }

    public final int b(x.a aVar) {
        int i2 = 0;
        for (x.a aVar2 : this.f11729f) {
            if (!aVar2.c().f11784e && aVar2.d().equals(aVar.d())) {
                i2++;
            }
        }
        return i2;
    }

    public void a(x.a aVar) {
        a(this.f11729f, aVar, true);
    }

    public final <T> void a(Deque<T> deque, T t, boolean z) {
        int c2;
        Runnable runnable;
        synchronized (this) {
            if (deque.remove(t)) {
                if (z) {
                    b();
                }
                c2 = c();
                runnable = this.f11726c;
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        if (c2 != 0 || runnable == null) {
            return;
        }
        runnable.run();
    }

    public void b(x xVar) {
        a(this.f11730g, xVar, false);
    }
}
