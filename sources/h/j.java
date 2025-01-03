package h;

import h.e0.f.g;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* compiled from: ConnectionPool.java */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: g, reason: collision with root package name */
    public static final Executor f11694g = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), h.e0.c.a("OkHttp ConnectionPool", true));

    /* renamed from: a, reason: collision with root package name */
    public final int f11695a;

    /* renamed from: b, reason: collision with root package name */
    public final long f11696b;

    /* renamed from: c, reason: collision with root package name */
    public final Runnable f11697c;

    /* renamed from: d, reason: collision with root package name */
    public final Deque<h.e0.f.c> f11698d;

    /* renamed from: e, reason: collision with root package name */
    public final h.e0.f.d f11699e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f11700f;

    /* compiled from: ConnectionPool.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                long a2 = j.this.a(System.nanoTime());
                if (a2 == -1) {
                    return;
                }
                if (a2 > 0) {
                    long j = a2 / 1000000;
                    long j2 = a2 - (1000000 * j);
                    synchronized (j.this) {
                        try {
                            j.this.wait(j, (int) j2);
                        } catch (InterruptedException unused) {
                        }
                    }
                }
            }
        }
    }

    public j() {
        this(5, 5L, TimeUnit.MINUTES);
    }

    @Nullable
    public h.e0.f.c a(h.a aVar, h.e0.f.g gVar, c0 c0Var) {
        for (h.e0.f.c cVar : this.f11698d) {
            if (cVar.a(aVar, c0Var)) {
                gVar.a(cVar, true);
                return cVar;
            }
        }
        return null;
    }

    public void b(h.e0.f.c cVar) {
        if (!this.f11700f) {
            this.f11700f = true;
            f11694g.execute(this.f11697c);
        }
        this.f11698d.add(cVar);
    }

    public j(int i2, long j, TimeUnit timeUnit) {
        this.f11697c = new a();
        this.f11698d = new ArrayDeque();
        this.f11699e = new h.e0.f.d();
        this.f11695a = i2;
        this.f11696b = timeUnit.toNanos(j);
        if (j > 0) {
            return;
        }
        throw new IllegalArgumentException("keepAliveDuration <= 0: " + j);
    }

    @Nullable
    public Socket a(h.a aVar, h.e0.f.g gVar) {
        for (h.e0.f.c cVar : this.f11698d) {
            if (cVar.a(aVar, null) && cVar.d() && cVar != gVar.c()) {
                return gVar.b(cVar);
            }
        }
        return null;
    }

    public boolean a(h.e0.f.c cVar) {
        if (!cVar.k && this.f11695a != 0) {
            notifyAll();
            return false;
        }
        this.f11698d.remove(cVar);
        return true;
    }

    public long a(long j) {
        synchronized (this) {
            h.e0.f.c cVar = null;
            long j2 = Long.MIN_VALUE;
            int i2 = 0;
            int i3 = 0;
            for (h.e0.f.c cVar2 : this.f11698d) {
                if (a(cVar2, j) > 0) {
                    i3++;
                } else {
                    i2++;
                    long j3 = j - cVar2.o;
                    if (j3 > j2) {
                        cVar = cVar2;
                        j2 = j3;
                    }
                }
            }
            if (j2 < this.f11696b && i2 <= this.f11695a) {
                if (i2 > 0) {
                    return this.f11696b - j2;
                }
                if (i3 > 0) {
                    return this.f11696b;
                }
                this.f11700f = false;
                return -1L;
            }
            this.f11698d.remove(cVar);
            h.e0.c.a(cVar.f());
            return 0L;
        }
    }

    public final int a(h.e0.f.c cVar, long j) {
        List<Reference<h.e0.f.g>> list = cVar.n;
        int i2 = 0;
        while (i2 < list.size()) {
            Reference<h.e0.f.g> reference = list.get(i2);
            if (reference.get() != null) {
                i2++;
            } else {
                h.e0.j.f.c().a("A connection to " + cVar.e().a().k() + " was leaked. Did you forget to close a response body?", ((g.a) reference).f11455a);
                list.remove(i2);
                cVar.k = true;
                if (list.isEmpty()) {
                    cVar.o = j - this.f11696b;
                    return 0;
                }
            }
        }
        return list.size();
    }
}
