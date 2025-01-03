package c.k.d.p9;

import android.os.SystemClock;
import androidx.recyclerview.widget.RecyclerView;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes.dex */
public class e1 {

    /* renamed from: c, reason: collision with root package name */
    public static long f7565c;

    /* renamed from: d, reason: collision with root package name */
    public static long f7566d;

    /* renamed from: a, reason: collision with root package name */
    public final c f7567a;

    /* renamed from: b, reason: collision with root package name */
    public final a f7568b;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final c f7569a;

        public a(c cVar) {
            this.f7569a = cVar;
        }

        public void finalize() {
            try {
                synchronized (this.f7569a) {
                    this.f7569a.f7575e = true;
                    this.f7569a.notify();
                }
            } finally {
                super.finalize();
            }
        }
    }

    public static abstract class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public int f7570a;

        public b(int i2) {
            this.f7570a = i2;
        }
    }

    public static final class c extends Thread {

        /* renamed from: d, reason: collision with root package name */
        public boolean f7574d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f7575e;

        /* renamed from: a, reason: collision with root package name */
        public volatile long f7571a = 0;

        /* renamed from: b, reason: collision with root package name */
        public volatile boolean f7572b = false;

        /* renamed from: c, reason: collision with root package name */
        public long f7573c = 50;

        /* renamed from: f, reason: collision with root package name */
        public a f7576f = new a();

        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            public int f7577a;

            /* renamed from: b, reason: collision with root package name */
            public d[] f7578b;

            /* renamed from: c, reason: collision with root package name */
            public int f7579c;

            /* renamed from: d, reason: collision with root package name */
            public int f7580d;

            public a() {
                this.f7577a = RecyclerView.c0.FLAG_TMP_DETACHED;
                this.f7578b = new d[RecyclerView.c0.FLAG_TMP_DETACHED];
                this.f7579c = 0;
                this.f7580d = 0;
            }

            public final int a(d dVar) {
                int i2 = 0;
                while (true) {
                    d[] dVarArr = this.f7578b;
                    if (i2 >= dVarArr.length) {
                        return -1;
                    }
                    if (dVarArr[i2] == dVar) {
                        return i2;
                    }
                    i2++;
                }
            }

            public d a() {
                return this.f7578b[0];
            }

            /* renamed from: a, reason: collision with other method in class */
            public void m374a() {
                this.f7578b = new d[this.f7577a];
                this.f7579c = 0;
            }

            public void a(int i2) {
                for (int i3 = 0; i3 < this.f7579c; i3++) {
                    d[] dVarArr = this.f7578b;
                    if (dVarArr[i3].f7585e == i2) {
                        dVarArr[i3].a();
                    }
                }
                b();
            }

            public void a(int i2, b bVar) {
                for (int i3 = 0; i3 < this.f7579c; i3++) {
                    d[] dVarArr = this.f7578b;
                    if (dVarArr[i3].f7584d == bVar) {
                        dVarArr[i3].a();
                    }
                }
                b();
            }

            /* renamed from: a, reason: collision with other method in class */
            public void m375a(d dVar) {
                d[] dVarArr = this.f7578b;
                int length = dVarArr.length;
                int i2 = this.f7579c;
                if (length == i2) {
                    d[] dVarArr2 = new d[i2 * 2];
                    System.arraycopy(dVarArr, 0, dVarArr2, 0, i2);
                    this.f7578b = dVarArr2;
                }
                d[] dVarArr3 = this.f7578b;
                int i3 = this.f7579c;
                this.f7579c = i3 + 1;
                dVarArr3[i3] = dVar;
                c();
            }

            /* renamed from: a, reason: collision with other method in class */
            public boolean m376a() {
                return this.f7579c == 0;
            }

            /* renamed from: a, reason: collision with other method in class */
            public boolean m377a(int i2) {
                for (int i3 = 0; i3 < this.f7579c; i3++) {
                    if (this.f7578b[i3].f7585e == i2) {
                        return true;
                    }
                }
                return false;
            }

            public void b() {
                int i2 = 0;
                while (i2 < this.f7579c) {
                    if (this.f7578b[i2].f7582b) {
                        this.f7580d++;
                        b(i2);
                        i2--;
                    }
                    i2++;
                }
            }

            public void b(int i2) {
                int i3;
                if (i2 < 0 || i2 >= (i3 = this.f7579c)) {
                    return;
                }
                d[] dVarArr = this.f7578b;
                int i4 = i3 - 1;
                this.f7579c = i4;
                dVarArr[i2] = dVarArr[i4];
                dVarArr[i4] = null;
                c(i2);
            }

            public final void c() {
                int i2 = this.f7579c - 1;
                int i3 = (i2 - 1) / 2;
                while (true) {
                    d[] dVarArr = this.f7578b;
                    if (dVarArr[i2].f7583c >= dVarArr[i3].f7583c) {
                        return;
                    }
                    d dVar = dVarArr[i2];
                    dVarArr[i2] = dVarArr[i3];
                    dVarArr[i3] = dVar;
                    int i4 = i3;
                    i3 = (i3 - 1) / 2;
                    i2 = i4;
                }
            }

            public final void c(int i2) {
                int i3 = (i2 * 2) + 1;
                while (true) {
                    int i4 = this.f7579c;
                    if (i3 >= i4 || i4 <= 0) {
                        return;
                    }
                    int i5 = i3 + 1;
                    if (i5 < i4) {
                        d[] dVarArr = this.f7578b;
                        if (dVarArr[i5].f7583c < dVarArr[i3].f7583c) {
                            i3 = i5;
                        }
                    }
                    d[] dVarArr2 = this.f7578b;
                    if (dVarArr2[i2].f7583c < dVarArr2[i3].f7583c) {
                        return;
                    }
                    d dVar = dVarArr2[i2];
                    dVarArr2[i2] = dVarArr2[i3];
                    dVarArr2[i3] = dVar;
                    int i6 = i3;
                    i3 = (i3 * 2) + 1;
                    i2 = i6;
                }
            }
        }

        public c(String str, boolean z) {
            setName(str);
            setDaemon(z);
            start();
        }

        public synchronized void a() {
            this.f7574d = true;
            this.f7576f.m374a();
            notify();
        }

        public final void a(d dVar) {
            this.f7576f.m375a(dVar);
            notify();
        }

        /* renamed from: a, reason: collision with other method in class */
        public boolean m373a() {
            return this.f7572b && SystemClock.uptimeMillis() - this.f7571a > 600000;
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x0093, code lost:
        
            r10.f7571a = android.os.SystemClock.uptimeMillis();
            r10.f7572b = true;
            r2.f7584d.run();
            r10.f7572b = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x00a4, code lost:
        
            r1 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x00a5, code lost:
        
            monitor-enter(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x00a6, code lost:
        
            r10.f7574d = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x00a9, code lost:
        
            throw r1;
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 184
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: c.k.d.p9.e1.c.run():void");
        }
    }

    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final Object f7581a = new Object();

        /* renamed from: b, reason: collision with root package name */
        public boolean f7582b;

        /* renamed from: c, reason: collision with root package name */
        public long f7583c;

        /* renamed from: d, reason: collision with root package name */
        public b f7584d;

        /* renamed from: e, reason: collision with root package name */
        public int f7585e;

        public void a(long j) {
            synchronized (this.f7581a) {
            }
        }

        public boolean a() {
            boolean z;
            synchronized (this.f7581a) {
                z = !this.f7582b && this.f7583c > 0;
                this.f7582b = true;
            }
            return z;
        }
    }

    static {
        long elapsedRealtime = SystemClock.elapsedRealtime() > 0 ? SystemClock.elapsedRealtime() : 0L;
        f7565c = elapsedRealtime;
        f7566d = elapsedRealtime;
    }

    public e1(String str) {
        this(str, false);
    }

    public e1(String str, boolean z) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        c cVar = new c(str, z);
        this.f7567a = cVar;
        this.f7568b = new a(cVar);
    }

    public static synchronized long a() {
        long j;
        synchronized (e1.class) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime > f7566d) {
                f7565c += elapsedRealtime - f7566d;
            }
            f7566d = elapsedRealtime;
            j = f7565c;
        }
        return j;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m369a() {
        c.k.a.a.a.c.m6a("quit. finalizer:" + this.f7568b);
        this.f7567a.a();
    }

    public void a(int i2) {
        synchronized (this.f7567a) {
            this.f7567a.f7576f.a(i2);
        }
    }

    public void a(int i2, b bVar) {
        synchronized (this.f7567a) {
            this.f7567a.f7576f.a(i2, bVar);
        }
    }

    public void a(b bVar) {
        if (c.k.a.a.a.c.a() >= 1 || Thread.currentThread() == this.f7567a) {
            bVar.run();
        } else {
            c.k.a.a.a.c.d("run job outside job job thread");
            throw new RejectedExecutionException("Run job outside job thread");
        }
    }

    public void a(b bVar, long j) {
        if (j >= 0) {
            b(bVar, j);
            return;
        }
        throw new IllegalArgumentException("delay < 0: " + j);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m370a() {
        return this.f7567a.m373a();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m371a(int i2) {
        boolean m377a;
        synchronized (this.f7567a) {
            m377a = this.f7567a.f7576f.m377a(i2);
        }
        return m377a;
    }

    public void b() {
        synchronized (this.f7567a) {
            this.f7567a.f7576f.m374a();
        }
    }

    public final void b(b bVar, long j) {
        synchronized (this.f7567a) {
            if (this.f7567a.f7574d) {
                throw new IllegalStateException("Timer was canceled");
            }
            long a2 = j + a();
            if (a2 < 0) {
                throw new IllegalArgumentException("Illegal delay to start the TimerTask: " + a2);
            }
            d dVar = new d();
            dVar.f7585e = bVar.f7570a;
            dVar.f7584d = bVar;
            dVar.f7583c = a2;
            this.f7567a.a(dVar);
        }
    }
}
