package h.e0.i;

import com.shix.shixipc.system.ContentCommon;
import h.e0.i.h;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Http2Connection.java */
/* loaded from: classes.dex */
public final class g implements Closeable {
    public static final ExecutorService v = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), h.e0.c.a("OkHttp Http2Connection", true));

    /* renamed from: a, reason: collision with root package name */
    public final boolean f11550a;

    /* renamed from: b, reason: collision with root package name */
    public final h f11551b;

    /* renamed from: d, reason: collision with root package name */
    public final String f11553d;

    /* renamed from: e, reason: collision with root package name */
    public int f11554e;

    /* renamed from: f, reason: collision with root package name */
    public int f11555f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f11556g;

    /* renamed from: h, reason: collision with root package name */
    public final ScheduledExecutorService f11557h;

    /* renamed from: i, reason: collision with root package name */
    public final ExecutorService f11558i;
    public final l j;
    public boolean k;
    public long m;
    public final Socket q;
    public final h.e0.i.j r;
    public final j t;

    /* renamed from: c, reason: collision with root package name */
    public final Map<Integer, h.e0.i.i> f11552c = new LinkedHashMap();
    public long l = 0;
    public m n = new m();
    public final m o = new m();
    public boolean p = false;
    public final Set<Integer> u = new LinkedHashSet();

    /* compiled from: Http2Connection.java */
    public class a extends h.e0.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f11559b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ h.e0.i.b f11560c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, Object[] objArr, int i2, h.e0.i.b bVar) {
            super(str, objArr);
            this.f11559b = i2;
            this.f11560c = bVar;
        }

        @Override // h.e0.b
        public void b() {
            try {
                g.this.b(this.f11559b, this.f11560c);
            } catch (IOException unused) {
                g.this.a();
            }
        }
    }

    /* compiled from: Http2Connection.java */
    public class b extends h.e0.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f11562b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f11563c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, Object[] objArr, int i2, long j) {
            super(str, objArr);
            this.f11562b = i2;
            this.f11563c = j;
        }

        @Override // h.e0.b
        public void b() {
            try {
                g.this.r.a(this.f11562b, this.f11563c);
            } catch (IOException unused) {
                g.this.a();
            }
        }
    }

    /* compiled from: Http2Connection.java */
    public class c extends h.e0.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f11565b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ List f11566c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, Object[] objArr, int i2, List list) {
            super(str, objArr);
            this.f11565b = i2;
            this.f11566c = list;
        }

        @Override // h.e0.b
        public void b() {
            if (g.this.j.a(this.f11565b, this.f11566c)) {
                try {
                    g.this.r.a(this.f11565b, h.e0.i.b.CANCEL);
                    synchronized (g.this) {
                        g.this.u.remove(Integer.valueOf(this.f11565b));
                    }
                } catch (IOException unused) {
                }
            }
        }
    }

    /* compiled from: Http2Connection.java */
    public class d extends h.e0.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f11568b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ List f11569c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f11570d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str, Object[] objArr, int i2, List list, boolean z) {
            super(str, objArr);
            this.f11568b = i2;
            this.f11569c = list;
            this.f11570d = z;
        }

        @Override // h.e0.b
        public void b() {
            boolean a2 = g.this.j.a(this.f11568b, this.f11569c, this.f11570d);
            if (a2) {
                try {
                    g.this.r.a(this.f11568b, h.e0.i.b.CANCEL);
                } catch (IOException unused) {
                    return;
                }
            }
            if (a2 || this.f11570d) {
                synchronized (g.this) {
                    g.this.u.remove(Integer.valueOf(this.f11568b));
                }
            }
        }
    }

    /* compiled from: Http2Connection.java */
    public class e extends h.e0.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f11572b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ i.c f11573c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f11574d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ boolean f11575e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(String str, Object[] objArr, int i2, i.c cVar, int i3, boolean z) {
            super(str, objArr);
            this.f11572b = i2;
            this.f11573c = cVar;
            this.f11574d = i3;
            this.f11575e = z;
        }

        @Override // h.e0.b
        public void b() {
            try {
                boolean a2 = g.this.j.a(this.f11572b, this.f11573c, this.f11574d, this.f11575e);
                if (a2) {
                    g.this.r.a(this.f11572b, h.e0.i.b.CANCEL);
                }
                if (a2 || this.f11575e) {
                    synchronized (g.this) {
                        g.this.u.remove(Integer.valueOf(this.f11572b));
                    }
                }
            } catch (IOException unused) {
            }
        }
    }

    /* compiled from: Http2Connection.java */
    public class f extends h.e0.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f11577b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ h.e0.i.b f11578c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String str, Object[] objArr, int i2, h.e0.i.b bVar) {
            super(str, objArr);
            this.f11577b = i2;
            this.f11578c = bVar;
        }

        @Override // h.e0.b
        public void b() {
            g.this.j.a(this.f11577b, this.f11578c);
            synchronized (g.this) {
                g.this.u.remove(Integer.valueOf(this.f11577b));
            }
        }
    }

    /* compiled from: Http2Connection.java */
    public static abstract class h {

        /* renamed from: a, reason: collision with root package name */
        public static final h f11588a = new a();

        /* compiled from: Http2Connection.java */
        public class a extends h {
            @Override // h.e0.i.g.h
            public void a(h.e0.i.i iVar) throws IOException {
                iVar.a(h.e0.i.b.REFUSED_STREAM);
            }
        }

        public void a(g gVar) {
        }

        public abstract void a(h.e0.i.i iVar) throws IOException;
    }

    /* compiled from: Http2Connection.java */
    public final class i extends h.e0.b {

        /* renamed from: b, reason: collision with root package name */
        public final boolean f11589b;

        /* renamed from: c, reason: collision with root package name */
        public final int f11590c;

        /* renamed from: d, reason: collision with root package name */
        public final int f11591d;

        public i(boolean z, int i2, int i3) {
            super("OkHttp %s ping %08x%08x", g.this.f11553d, Integer.valueOf(i2), Integer.valueOf(i3));
            this.f11589b = z;
            this.f11590c = i2;
            this.f11591d = i3;
        }

        @Override // h.e0.b
        public void b() {
            g.this.a(this.f11589b, this.f11590c, this.f11591d);
        }
    }

    public g(C0169g c0169g) {
        this.j = c0169g.f11585f;
        boolean z = c0169g.f11586g;
        this.f11550a = z;
        this.f11551b = c0169g.f11584e;
        int i2 = z ? 1 : 2;
        this.f11555f = i2;
        if (c0169g.f11586g) {
            this.f11555f = i2 + 2;
        }
        if (c0169g.f11586g) {
            this.n.a(7, 16777216);
        }
        this.f11553d = c0169g.f11581b;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, h.e0.c.a(h.e0.c.a("OkHttp %s Writer", this.f11553d), false));
        this.f11557h = scheduledThreadPoolExecutor;
        if (c0169g.f11587h != 0) {
            i iVar = new i(false, 0, 0);
            int i3 = c0169g.f11587h;
            scheduledThreadPoolExecutor.scheduleAtFixedRate(iVar, i3, i3, TimeUnit.MILLISECONDS);
        }
        this.f11558i = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), h.e0.c.a(h.e0.c.a("OkHttp %s Push Observer", this.f11553d), true));
        this.o.a(7, ContentCommon.INVALID_OPTION);
        this.o.a(5, 16384);
        this.m = this.o.c();
        this.q = c0169g.f11580a;
        this.r = new h.e0.i.j(c0169g.f11583d, this.f11550a);
        this.t = new j(new h.e0.i.h(c0169g.f11582c, this.f11550a));
    }

    public boolean b(int i2) {
        return i2 != 0 && (i2 & 1) == 0;
    }

    public synchronized h.e0.i.i c(int i2) {
        h.e0.i.i remove;
        remove = this.f11552c.remove(Integer.valueOf(i2));
        notifyAll();
        return remove;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        a(h.e0.i.b.NO_ERROR, h.e0.i.b.CANCEL);
    }

    public void e() throws IOException {
        a(true);
    }

    public void flush() throws IOException {
        this.r.flush();
    }

    public void b(int i2, h.e0.i.b bVar) throws IOException {
        this.r.a(i2, bVar);
    }

    public synchronized h.e0.i.i a(int i2) {
        return this.f11552c.get(Integer.valueOf(i2));
    }

    public synchronized boolean b() {
        return this.f11556g;
    }

    /* compiled from: Http2Connection.java */
    /* renamed from: h.e0.i.g$g, reason: collision with other inner class name */
    public static class C0169g {

        /* renamed from: a, reason: collision with root package name */
        public Socket f11580a;

        /* renamed from: b, reason: collision with root package name */
        public String f11581b;

        /* renamed from: c, reason: collision with root package name */
        public i.e f11582c;

        /* renamed from: d, reason: collision with root package name */
        public i.d f11583d;

        /* renamed from: e, reason: collision with root package name */
        public h f11584e = h.f11588a;

        /* renamed from: f, reason: collision with root package name */
        public l f11585f = l.f11644a;

        /* renamed from: g, reason: collision with root package name */
        public boolean f11586g;

        /* renamed from: h, reason: collision with root package name */
        public int f11587h;

        public C0169g(boolean z) {
            this.f11586g = z;
        }

        public C0169g a(Socket socket, String str, i.e eVar, i.d dVar) {
            this.f11580a = socket;
            this.f11581b = str;
            this.f11582c = eVar;
            this.f11583d = dVar;
            return this;
        }

        public C0169g a(h hVar) {
            this.f11584e = hVar;
            return this;
        }

        public C0169g a(int i2) {
            this.f11587h = i2;
            return this;
        }

        public g a() {
            return new g(this);
        }
    }

    public synchronized void a(long j2) {
        long j3 = this.l + j2;
        this.l = j3;
        if (j3 >= this.n.c() / 2) {
            a(0, this.l);
            this.l = 0L;
        }
    }

    public void b(int i2, List<h.e0.i.c> list, boolean z) {
        try {
            a(new d("OkHttp %s Push Headers[%s]", new Object[]{this.f11553d, Integer.valueOf(i2)}, i2, list, z));
        } catch (RejectedExecutionException unused) {
        }
    }

    public synchronized int c() {
        return this.o.b(Integer.MAX_VALUE);
    }

    public void c(int i2, h.e0.i.b bVar) {
        try {
            this.f11557h.execute(new a("OkHttp %s stream %d", new Object[]{this.f11553d, Integer.valueOf(i2)}, i2, bVar));
        } catch (RejectedExecutionException unused) {
        }
    }

    /* compiled from: Http2Connection.java */
    public class j extends h.e0.b implements h.b {

        /* renamed from: b, reason: collision with root package name */
        public final h.e0.i.h f11593b;

        /* compiled from: Http2Connection.java */
        public class a extends h.e0.b {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ h.e0.i.i f11595b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str, Object[] objArr, h.e0.i.i iVar) {
                super(str, objArr);
                this.f11595b = iVar;
            }

            @Override // h.e0.b
            public void b() {
                try {
                    g.this.f11551b.a(this.f11595b);
                } catch (IOException e2) {
                    h.e0.j.f.c().a(4, "Http2Connection.Listener failure for " + g.this.f11553d, e2);
                    try {
                        this.f11595b.a(h.e0.i.b.PROTOCOL_ERROR);
                    } catch (IOException unused) {
                    }
                }
            }
        }

        /* compiled from: Http2Connection.java */
        public class b extends h.e0.b {
            public b(String str, Object... objArr) {
                super(str, objArr);
            }

            @Override // h.e0.b
            public void b() {
                g gVar = g.this;
                gVar.f11551b.a(gVar);
            }
        }

        /* compiled from: Http2Connection.java */
        public class c extends h.e0.b {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ m f11598b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(String str, Object[] objArr, m mVar) {
                super(str, objArr);
                this.f11598b = mVar;
            }

            @Override // h.e0.b
            public void b() {
                try {
                    g.this.r.a(this.f11598b);
                } catch (IOException unused) {
                    g.this.a();
                }
            }
        }

        public j(h.e0.i.h hVar) {
            super("OkHttp %s", g.this.f11553d);
            this.f11593b = hVar;
        }

        @Override // h.e0.i.h.b
        public void a() {
        }

        @Override // h.e0.i.h.b
        public void a(int i2, int i3, int i4, boolean z) {
        }

        @Override // h.e0.i.h.b
        public void a(boolean z, int i2, i.e eVar, int i3) throws IOException {
            if (g.this.b(i2)) {
                g.this.a(i2, eVar, i3, z);
                return;
            }
            h.e0.i.i a2 = g.this.a(i2);
            if (a2 == null) {
                g.this.c(i2, h.e0.i.b.PROTOCOL_ERROR);
                long j = i3;
                g.this.a(j);
                eVar.skip(j);
                return;
            }
            a2.a(eVar, i3);
            if (z) {
                a2.i();
            }
        }

        @Override // h.e0.b
        public void b() {
            h.e0.i.b bVar;
            g gVar;
            h.e0.i.b bVar2 = h.e0.i.b.INTERNAL_ERROR;
            try {
                try {
                    try {
                        this.f11593b.a(this);
                        while (this.f11593b.a(false, (h.b) this)) {
                        }
                        bVar = h.e0.i.b.NO_ERROR;
                    } catch (IOException unused) {
                    } catch (Throwable th) {
                        th = th;
                        bVar = bVar2;
                        try {
                            g.this.a(bVar, bVar2);
                        } catch (IOException unused2) {
                        }
                        h.e0.c.a(this.f11593b);
                        throw th;
                    }
                    try {
                        bVar2 = h.e0.i.b.CANCEL;
                        gVar = g.this;
                    } catch (IOException unused3) {
                        bVar = h.e0.i.b.PROTOCOL_ERROR;
                        bVar2 = h.e0.i.b.PROTOCOL_ERROR;
                        gVar = g.this;
                        gVar.a(bVar, bVar2);
                        h.e0.c.a(this.f11593b);
                    }
                    gVar.a(bVar, bVar2);
                } catch (IOException unused4) {
                }
                h.e0.c.a(this.f11593b);
            } catch (Throwable th2) {
                th = th2;
            }
        }

        @Override // h.e0.i.h.b
        public void a(boolean z, int i2, int i3, List<h.e0.i.c> list) {
            if (g.this.b(i2)) {
                g.this.b(i2, list, z);
                return;
            }
            synchronized (g.this) {
                h.e0.i.i a2 = g.this.a(i2);
                if (a2 == null) {
                    if (g.this.f11556g) {
                        return;
                    }
                    if (i2 <= g.this.f11554e) {
                        return;
                    }
                    if (i2 % 2 == g.this.f11555f % 2) {
                        return;
                    }
                    h.e0.i.i iVar = new h.e0.i.i(i2, g.this, false, z, list);
                    g.this.f11554e = i2;
                    g.this.f11552c.put(Integer.valueOf(i2), iVar);
                    g.v.execute(new a("OkHttp %s stream %d", new Object[]{g.this.f11553d, Integer.valueOf(i2)}, iVar));
                    return;
                }
                a2.a(list);
                if (z) {
                    a2.i();
                }
            }
        }

        @Override // h.e0.i.h.b
        public void a(int i2, h.e0.i.b bVar) {
            if (g.this.b(i2)) {
                g.this.a(i2, bVar);
                return;
            }
            h.e0.i.i c2 = g.this.c(i2);
            if (c2 != null) {
                c2.d(bVar);
            }
        }

        @Override // h.e0.i.h.b
        public void a(boolean z, m mVar) {
            h.e0.i.i[] iVarArr;
            long j;
            int i2;
            synchronized (g.this) {
                int c2 = g.this.o.c();
                if (z) {
                    g.this.o.a();
                }
                g.this.o.a(mVar);
                a(mVar);
                int c3 = g.this.o.c();
                iVarArr = null;
                if (c3 == -1 || c3 == c2) {
                    j = 0;
                } else {
                    j = c3 - c2;
                    if (!g.this.p) {
                        g.this.p = true;
                    }
                    if (!g.this.f11552c.isEmpty()) {
                        iVarArr = (h.e0.i.i[]) g.this.f11552c.values().toArray(new h.e0.i.i[g.this.f11552c.size()]);
                    }
                }
                g.v.execute(new b("OkHttp %s settings", g.this.f11553d));
            }
            if (iVarArr == null || j == 0) {
                return;
            }
            for (h.e0.i.i iVar : iVarArr) {
                synchronized (iVar) {
                    iVar.a(j);
                }
            }
        }

        public final void a(m mVar) {
            try {
                g.this.f11557h.execute(new c("OkHttp %s ACK Settings", new Object[]{g.this.f11553d}, mVar));
            } catch (RejectedExecutionException unused) {
            }
        }

        @Override // h.e0.i.h.b
        public void a(boolean z, int i2, int i3) {
            if (!z) {
                try {
                    g.this.f11557h.execute(g.this.new i(true, i2, i3));
                } catch (RejectedExecutionException unused) {
                }
            } else {
                synchronized (g.this) {
                    g.this.k = false;
                    g.this.notifyAll();
                }
            }
        }

        @Override // h.e0.i.h.b
        public void a(int i2, h.e0.i.b bVar, i.f fVar) {
            h.e0.i.i[] iVarArr;
            fVar.size();
            synchronized (g.this) {
                iVarArr = (h.e0.i.i[]) g.this.f11552c.values().toArray(new h.e0.i.i[g.this.f11552c.size()]);
                g.this.f11556g = true;
            }
            for (h.e0.i.i iVar : iVarArr) {
                if (iVar.c() > i2 && iVar.f()) {
                    iVar.d(h.e0.i.b.REFUSED_STREAM);
                    g.this.c(iVar.c());
                }
            }
        }

        @Override // h.e0.i.h.b
        public void a(int i2, long j) {
            if (i2 == 0) {
                synchronized (g.this) {
                    g.this.m += j;
                    g.this.notifyAll();
                }
                return;
            }
            h.e0.i.i a2 = g.this.a(i2);
            if (a2 != null) {
                synchronized (a2) {
                    a2.a(j);
                }
            }
        }

        @Override // h.e0.i.h.b
        public void a(int i2, int i3, List<h.e0.i.c> list) {
            g.this.a(i3, list);
        }
    }

    public h.e0.i.i a(List<h.e0.i.c> list, boolean z) throws IOException {
        return a(0, list, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0043 A[Catch: all -> 0x0075, TryCatch #0 {, blocks: (B:6:0x0007, B:8:0x000e, B:9:0x0013, B:11:0x0017, B:13:0x002b, B:15:0x0033, B:19:0x003d, B:21:0x0043, B:22:0x004c, B:36:0x006f, B:37:0x0074), top: B:5:0x0007, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final h.e0.i.i a(int r11, java.util.List<h.e0.i.c> r12, boolean r13) throws java.io.IOException {
        /*
            r10 = this;
            r6 = r13 ^ 1
            r4 = 0
            h.e0.i.j r7 = r10.r
            monitor-enter(r7)
            monitor-enter(r10)     // Catch: java.lang.Throwable -> L78
            int r0 = r10.f11555f     // Catch: java.lang.Throwable -> L75
            r1 = 1073741823(0x3fffffff, float:1.9999999)
            if (r0 <= r1) goto L13
            h.e0.i.b r0 = h.e0.i.b.REFUSED_STREAM     // Catch: java.lang.Throwable -> L75
            r10.a(r0)     // Catch: java.lang.Throwable -> L75
        L13:
            boolean r0 = r10.f11556g     // Catch: java.lang.Throwable -> L75
            if (r0 != 0) goto L6f
            int r8 = r10.f11555f     // Catch: java.lang.Throwable -> L75
            int r0 = r10.f11555f     // Catch: java.lang.Throwable -> L75
            int r0 = r0 + 2
            r10.f11555f = r0     // Catch: java.lang.Throwable -> L75
            h.e0.i.i r9 = new h.e0.i.i     // Catch: java.lang.Throwable -> L75
            r0 = r9
            r1 = r8
            r2 = r10
            r3 = r6
            r5 = r12
            r0.<init>(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L75
            if (r13 == 0) goto L3c
            long r0 = r10.m     // Catch: java.lang.Throwable -> L75
            r2 = 0
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 == 0) goto L3c
            long r0 = r9.f11612b     // Catch: java.lang.Throwable -> L75
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 != 0) goto L3a
            goto L3c
        L3a:
            r13 = 0
            goto L3d
        L3c:
            r13 = 1
        L3d:
            boolean r0 = r9.g()     // Catch: java.lang.Throwable -> L75
            if (r0 == 0) goto L4c
            java.util.Map<java.lang.Integer, h.e0.i.i> r0 = r10.f11552c     // Catch: java.lang.Throwable -> L75
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch: java.lang.Throwable -> L75
            r0.put(r1, r9)     // Catch: java.lang.Throwable -> L75
        L4c:
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L75
            if (r11 != 0) goto L55
            h.e0.i.j r0 = r10.r     // Catch: java.lang.Throwable -> L78
            r0.a(r6, r8, r11, r12)     // Catch: java.lang.Throwable -> L78
            goto L5e
        L55:
            boolean r0 = r10.f11550a     // Catch: java.lang.Throwable -> L78
            if (r0 != 0) goto L67
            h.e0.i.j r0 = r10.r     // Catch: java.lang.Throwable -> L78
            r0.a(r11, r8, r12)     // Catch: java.lang.Throwable -> L78
        L5e:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L78
            if (r13 == 0) goto L66
            h.e0.i.j r11 = r10.r
            r11.flush()
        L66:
            return r9
        L67:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> L78
            java.lang.String r12 = "client streams shouldn't have associated stream IDs"
            r11.<init>(r12)     // Catch: java.lang.Throwable -> L78
            throw r11     // Catch: java.lang.Throwable -> L78
        L6f:
            h.e0.i.a r11 = new h.e0.i.a     // Catch: java.lang.Throwable -> L75
            r11.<init>()     // Catch: java.lang.Throwable -> L75
            throw r11     // Catch: java.lang.Throwable -> L75
        L75:
            r11 = move-exception
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L75
            throw r11     // Catch: java.lang.Throwable -> L78
        L78:
            r11 = move-exception
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L78
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: h.e0.i.g.a(int, java.util.List, boolean):h.e0.i.i");
    }

    public void a(int i2, boolean z, i.c cVar, long j2) throws IOException {
        int min;
        long j3;
        if (j2 == 0) {
            this.r.a(z, i2, cVar, 0);
            return;
        }
        while (j2 > 0) {
            synchronized (this) {
                while (this.m <= 0) {
                    try {
                        if (this.f11552c.containsKey(Integer.valueOf(i2))) {
                            wait();
                        } else {
                            throw new IOException("stream closed");
                        }
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException();
                    }
                }
                min = Math.min((int) Math.min(j2, this.m), this.r.b());
                j3 = min;
                this.m -= j3;
            }
            j2 -= j3;
            this.r.a(z && j2 == 0, i2, cVar, min);
        }
    }

    public void a(int i2, long j2) {
        try {
            this.f11557h.execute(new b("OkHttp Window Update %s stream %d", new Object[]{this.f11553d, Integer.valueOf(i2)}, i2, j2));
        } catch (RejectedExecutionException unused) {
        }
    }

    public void a(boolean z, int i2, int i3) {
        boolean z2;
        if (!z) {
            synchronized (this) {
                z2 = this.k;
                this.k = true;
            }
            if (z2) {
                a();
                return;
            }
        }
        try {
            this.r.a(z, i2, i3);
        } catch (IOException unused) {
            a();
        }
    }

    public void a(h.e0.i.b bVar) throws IOException {
        synchronized (this.r) {
            synchronized (this) {
                if (this.f11556g) {
                    return;
                }
                this.f11556g = true;
                this.r.a(this.f11554e, bVar, h.e0.c.f11395a);
            }
        }
    }

    public void a(h.e0.i.b bVar, h.e0.i.b bVar2) throws IOException {
        h.e0.i.i[] iVarArr = null;
        try {
            a(bVar);
            e = null;
        } catch (IOException e2) {
            e = e2;
        }
        synchronized (this) {
            if (!this.f11552c.isEmpty()) {
                iVarArr = (h.e0.i.i[]) this.f11552c.values().toArray(new h.e0.i.i[this.f11552c.size()]);
                this.f11552c.clear();
            }
        }
        if (iVarArr != null) {
            for (h.e0.i.i iVar : iVarArr) {
                try {
                    iVar.a(bVar2);
                } catch (IOException e3) {
                    if (e != null) {
                        e = e3;
                    }
                }
            }
        }
        try {
            this.r.close();
        } catch (IOException e4) {
            if (e == null) {
                e = e4;
            }
        }
        try {
            this.q.close();
        } catch (IOException e5) {
            e = e5;
        }
        this.f11557h.shutdown();
        this.f11558i.shutdown();
        if (e != null) {
            throw e;
        }
    }

    public final void a() {
        try {
            a(h.e0.i.b.PROTOCOL_ERROR, h.e0.i.b.PROTOCOL_ERROR);
        } catch (IOException unused) {
        }
    }

    public void a(boolean z) throws IOException {
        if (z) {
            this.r.a();
            this.r.b(this.n);
            if (this.n.c() != 65535) {
                this.r.a(0, r6 - ContentCommon.INVALID_OPTION);
            }
        }
        new Thread(this.t).start();
    }

    public void a(int i2, List<h.e0.i.c> list) {
        synchronized (this) {
            if (this.u.contains(Integer.valueOf(i2))) {
                c(i2, h.e0.i.b.PROTOCOL_ERROR);
                return;
            }
            this.u.add(Integer.valueOf(i2));
            try {
                a(new c("OkHttp %s Push Request[%s]", new Object[]{this.f11553d, Integer.valueOf(i2)}, i2, list));
            } catch (RejectedExecutionException unused) {
            }
        }
    }

    public void a(int i2, i.e eVar, int i3, boolean z) throws IOException {
        i.c cVar = new i.c();
        long j2 = i3;
        eVar.g(j2);
        eVar.read(cVar, j2);
        if (cVar.g() == j2) {
            a(new e("OkHttp %s Push Data[%s]", new Object[]{this.f11553d, Integer.valueOf(i2)}, i2, cVar, i3, z));
            return;
        }
        throw new IOException(cVar.g() + " != " + i3);
    }

    public void a(int i2, h.e0.i.b bVar) {
        a(new f("OkHttp %s Push Reset[%s]", new Object[]{this.f11553d, Integer.valueOf(i2)}, i2, bVar));
    }

    public final synchronized void a(h.e0.b bVar) {
        if (!b()) {
            this.f11558i.execute(bVar);
        }
    }
}
