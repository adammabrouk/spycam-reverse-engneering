package i;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* compiled from: AsyncTimeout.java */
/* loaded from: classes.dex */
public class a extends t {

    /* renamed from: h, reason: collision with root package name */
    public static final long f11807h = TimeUnit.SECONDS.toMillis(60);

    /* renamed from: i, reason: collision with root package name */
    public static final long f11808i = TimeUnit.MILLISECONDS.toNanos(f11807h);

    @Nullable
    public static a j;

    /* renamed from: e, reason: collision with root package name */
    public boolean f11809e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public a f11810f;

    /* renamed from: g, reason: collision with root package name */
    public long f11811g;

    /* compiled from: AsyncTimeout.java */
    /* renamed from: i.a$a, reason: collision with other inner class name */
    public class C0171a implements r {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r f11812a;

        public C0171a(r rVar) {
            this.f11812a = rVar;
        }

        @Override // i.r
        public void a(i.c cVar, long j) throws IOException {
            u.a(cVar.f11820b, 0L, j);
            while (true) {
                long j2 = 0;
                if (j <= 0) {
                    return;
                }
                o oVar = cVar.f11819a;
                while (true) {
                    if (j2 >= 65536) {
                        break;
                    }
                    j2 += oVar.f11847c - oVar.f11846b;
                    if (j2 >= j) {
                        j2 = j;
                        break;
                    }
                    oVar = oVar.f11850f;
                }
                a.this.g();
                try {
                    try {
                        this.f11812a.a(cVar, j2);
                        j -= j2;
                        a.this.a(true);
                    } catch (IOException e2) {
                        throw a.this.a(e2);
                    }
                } catch (Throwable th) {
                    a.this.a(false);
                    throw th;
                }
            }
        }

        @Override // i.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            a.this.g();
            try {
                try {
                    this.f11812a.close();
                    a.this.a(true);
                } catch (IOException e2) {
                    throw a.this.a(e2);
                }
            } catch (Throwable th) {
                a.this.a(false);
                throw th;
            }
        }

        @Override // i.r, java.io.Flushable
        public void flush() throws IOException {
            a.this.g();
            try {
                try {
                    this.f11812a.flush();
                    a.this.a(true);
                } catch (IOException e2) {
                    throw a.this.a(e2);
                }
            } catch (Throwable th) {
                a.this.a(false);
                throw th;
            }
        }

        @Override // i.r
        public t timeout() {
            return a.this;
        }

        public String toString() {
            return "AsyncTimeout.sink(" + this.f11812a + ")";
        }
    }

    /* compiled from: AsyncTimeout.java */
    public class b implements s {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s f11814a;

        public b(s sVar) {
            this.f11814a = sVar;
        }

        @Override // i.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            try {
                try {
                    this.f11814a.close();
                    a.this.a(true);
                } catch (IOException e2) {
                    throw a.this.a(e2);
                }
            } catch (Throwable th) {
                a.this.a(false);
                throw th;
            }
        }

        @Override // i.s
        public long read(i.c cVar, long j) throws IOException {
            a.this.g();
            try {
                try {
                    long read = this.f11814a.read(cVar, j);
                    a.this.a(true);
                    return read;
                } catch (IOException e2) {
                    throw a.this.a(e2);
                }
            } catch (Throwable th) {
                a.this.a(false);
                throw th;
            }
        }

        @Override // i.s
        public t timeout() {
            return a.this;
        }

        public String toString() {
            return "AsyncTimeout.source(" + this.f11814a + ")";
        }
    }

    /* compiled from: AsyncTimeout.java */
    public static final class c extends Thread {
        public c() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0015, code lost:
        
            r1.i();
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r3 = this;
            L0:
                java.lang.Class<i.a> r0 = i.a.class
                monitor-enter(r0)     // Catch: java.lang.InterruptedException -> L0
                i.a r1 = i.a.j()     // Catch: java.lang.Throwable -> L19
                if (r1 != 0) goto Lb
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                goto L0
            Lb:
                i.a r2 = i.a.j     // Catch: java.lang.Throwable -> L19
                if (r1 != r2) goto L14
                r1 = 0
                i.a.j = r1     // Catch: java.lang.Throwable -> L19
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                return
            L14:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                r1.i()     // Catch: java.lang.InterruptedException -> L0
                goto L0
            L19:
                r1 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                goto L1d
            L1c:
                throw r1
            L1d:
                goto L1c
            */
            throw new UnsupportedOperationException("Method not decompiled: i.a.c.run():void");
        }
    }

    public static synchronized void a(a aVar, long j2, boolean z) {
        synchronized (a.class) {
            if (j == null) {
                j = new a();
                new c().start();
            }
            long nanoTime = System.nanoTime();
            if (j2 != 0 && z) {
                aVar.f11811g = Math.min(j2, aVar.c() - nanoTime) + nanoTime;
            } else if (j2 != 0) {
                aVar.f11811g = j2 + nanoTime;
            } else {
                if (!z) {
                    throw new AssertionError();
                }
                aVar.f11811g = aVar.c();
            }
            long b2 = aVar.b(nanoTime);
            a aVar2 = j;
            while (aVar2.f11810f != null && b2 >= aVar2.f11810f.b(nanoTime)) {
                aVar2 = aVar2.f11810f;
            }
            aVar.f11810f = aVar2.f11810f;
            aVar2.f11810f = aVar;
            if (aVar2 == j) {
                a.class.notify();
            }
        }
    }

    @Nullable
    public static a j() throws InterruptedException {
        a aVar = j.f11810f;
        if (aVar == null) {
            long nanoTime = System.nanoTime();
            a.class.wait(f11807h);
            if (j.f11810f != null || System.nanoTime() - nanoTime < f11808i) {
                return null;
            }
            return j;
        }
        long b2 = aVar.b(System.nanoTime());
        if (b2 > 0) {
            long j2 = b2 / 1000000;
            a.class.wait(j2, (int) (b2 - (1000000 * j2)));
            return null;
        }
        j.f11810f = aVar.f11810f;
        aVar.f11810f = null;
        return aVar;
    }

    public final long b(long j2) {
        return this.f11811g - j2;
    }

    public final void g() {
        if (this.f11809e) {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long f2 = f();
        boolean d2 = d();
        if (f2 != 0 || d2) {
            this.f11809e = true;
            a(this, f2, d2);
        }
    }

    public final boolean h() {
        if (!this.f11809e) {
            return false;
        }
        this.f11809e = false;
        return a(this);
    }

    public void i() {
    }

    public IOException b(@Nullable IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public static synchronized boolean a(a aVar) {
        synchronized (a.class) {
            for (a aVar2 = j; aVar2 != null; aVar2 = aVar2.f11810f) {
                if (aVar2.f11810f == aVar) {
                    aVar2.f11810f = aVar.f11810f;
                    aVar.f11810f = null;
                    return false;
                }
            }
            return true;
        }
    }

    public final r a(r rVar) {
        return new C0171a(rVar);
    }

    public final s a(s sVar) {
        return new b(sVar);
    }

    public final void a(boolean z) throws IOException {
        if (h() && z) {
            throw b((IOException) null);
        }
    }

    public final IOException a(IOException iOException) throws IOException {
        return !h() ? iOException : b(iOException);
    }
}
