package c.c.b.n;

import android.text.TextUtils;
import c.c.b.n.r.d;
import c.c.b.n.r.e;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.firebase:firebase-installations@@16.3.0 */
/* loaded from: classes.dex */
public class g implements h {
    public static final Object k = new Object();
    public static final ThreadFactory l = new a();

    /* renamed from: a, reason: collision with root package name */
    public final c.c.b.c f6040a;

    /* renamed from: b, reason: collision with root package name */
    public final c.c.b.n.r.c f6041b;

    /* renamed from: c, reason: collision with root package name */
    public final c.c.b.n.q.c f6042c;

    /* renamed from: d, reason: collision with root package name */
    public final p f6043d;

    /* renamed from: e, reason: collision with root package name */
    public final c.c.b.n.q.b f6044e;

    /* renamed from: f, reason: collision with root package name */
    public final n f6045f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f6046g;

    /* renamed from: h, reason: collision with root package name */
    public final ExecutorService f6047h;

    /* renamed from: i, reason: collision with root package name */
    public final ExecutorService f6048i;
    public final List<o> j;

    /* compiled from: com.google.firebase:firebase-installations@@16.3.0 */
    public class a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        public final AtomicInteger f6049a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, String.format("firebase-installations-executor-%d", Integer.valueOf(this.f6049a.getAndIncrement())));
        }
    }

    /* compiled from: com.google.firebase:firebase-installations@@16.3.0 */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6050a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f6051b;

        static {
            int[] iArr = new int[e.b.values().length];
            f6051b = iArr;
            try {
                iArr[e.b.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6051b[e.b.BAD_CONFIG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6051b[e.b.AUTH_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[d.b.values().length];
            f6050a = iArr2;
            try {
                iArr2[d.b.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6050a[d.b.BAD_CONFIG.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public g(c.c.b.c cVar, c.c.b.q.h hVar, c.c.b.k.c cVar2) {
        this(new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), l), cVar, new c.c.b.n.r.c(cVar.b(), hVar, cVar2), new c.c.b.n.q.c(cVar), new p(), new c.c.b.n.q.b(cVar), new n());
    }

    @Override // c.c.b.n.h
    public c.c.a.b.j.h<m> a(boolean z) {
        c.c.a.b.j.h<m> a2 = a();
        if (z) {
            this.f6047h.execute(d.a(this));
        } else {
            this.f6047h.execute(e.a(this));
        }
        return a2;
    }

    public final c.c.a.b.j.h<String> b() {
        c.c.a.b.j.i iVar = new c.c.a.b.j.i();
        l lVar = new l(iVar);
        synchronized (this.f6046g) {
            this.j.add(lVar);
        }
        return iVar.a();
    }

    @Override // c.c.b.n.h
    public c.c.a.b.j.h<String> c() {
        c.c.a.b.j.h<String> b2 = b();
        this.f6047h.execute(c.a(this));
        return b2;
    }

    public final void d(c.c.b.n.q.d dVar) {
        synchronized (this.f6046g) {
            Iterator<o> it = this.j.iterator();
            while (it.hasNext()) {
                if (it.next().a(dVar)) {
                    it.remove();
                }
            }
        }
    }

    public final void e() {
        c(false);
    }

    public final void f() {
        c(false);
    }

    public String g() {
        return this.f6040a.d().a();
    }

    public String h() {
        return this.f6040a.d().b();
    }

    public final c.c.b.n.q.d i() {
        c.c.b.n.q.d b2;
        synchronized (k) {
            c.c.b.n.b a2 = c.c.b.n.b.a(this.f6040a.b(), "generatefid.lock");
            try {
                b2 = this.f6042c.b();
                if (b2.i()) {
                    String b3 = b(b2);
                    c.c.b.n.q.c cVar = this.f6042c;
                    b2 = b2.b(b3);
                    cVar.a(b2);
                }
            } finally {
                if (a2 != null) {
                    a2.a();
                }
            }
        }
        return b2;
    }

    public String j() {
        return this.f6040a.d().d();
    }

    public final void c(boolean z) {
        c.c.b.n.q.d i2 = i();
        if (z) {
            i2 = i2.n();
        }
        d(i2);
        this.f6048i.execute(f.a(this, z));
    }

    public g(ExecutorService executorService, c.c.b.c cVar, c.c.b.n.r.c cVar2, c.c.b.n.q.c cVar3, p pVar, c.c.b.n.q.b bVar, n nVar) {
        this.f6046g = new Object();
        this.j = new ArrayList();
        this.f6040a = cVar;
        this.f6041b = cVar2;
        this.f6042c = cVar3;
        this.f6043d = pVar;
        this.f6044e = bVar;
        this.f6045f = nVar;
        this.f6047h = executorService;
        this.f6048i = new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), l);
    }

    public final c.c.a.b.j.h<m> a() {
        c.c.a.b.j.i iVar = new c.c.a.b.j.i();
        k kVar = new k(this.f6043d, iVar);
        synchronized (this.f6046g) {
            this.j.add(kVar);
        }
        return iVar.a();
    }

    public final c.c.b.n.q.d c(c.c.b.n.q.d dVar) throws IOException {
        c.c.b.n.r.d a2 = this.f6041b.a(g(), dVar.c(), j(), h(), dVar.c().length() == 11 ? this.f6044e.d() : null);
        int i2 = b.f6050a[a2.d().ordinal()];
        if (i2 == 1) {
            return dVar.a(a2.b(), a2.c(), this.f6043d.a(), a2.a().b(), a2.a().c());
        }
        if (i2 == 2) {
            return dVar.a("BAD CONFIG");
        }
        throw new IOException();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(boolean r3) {
        /*
            r2 = this;
            c.c.b.n.q.d r0 = r2.i()
            boolean r1 = r0.h()     // Catch: java.io.IOException -> L51
            if (r1 != 0) goto L22
            boolean r1 = r0.k()     // Catch: java.io.IOException -> L51
            if (r1 == 0) goto L11
            goto L22
        L11:
            if (r3 != 0) goto L1d
            c.c.b.n.p r3 = r2.f6043d     // Catch: java.io.IOException -> L51
            boolean r3 = r3.a(r0)     // Catch: java.io.IOException -> L51
            if (r3 == 0) goto L1c
            goto L1d
        L1c:
            return
        L1d:
            c.c.b.n.q.d r3 = r2.a(r0)     // Catch: java.io.IOException -> L51
            goto L26
        L22:
            c.c.b.n.q.d r3 = r2.c(r0)     // Catch: java.io.IOException -> L51
        L26:
            c.c.b.n.q.c r0 = r2.f6042c
            r0.a(r3)
            boolean r0 = r3.h()
            if (r0 == 0) goto L3c
            c.c.b.n.i r0 = new c.c.b.n.i
            c.c.b.n.i$a r1 = c.c.b.n.i.a.BAD_CONFIG
            r0.<init>(r1)
            r2.a(r3, r0)
            goto L50
        L3c:
            boolean r0 = r3.i()
            if (r0 == 0) goto L4d
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "cleared fid due to auth error"
            r0.<init>(r1)
            r2.a(r3, r0)
            goto L50
        L4d:
            r2.d(r3)
        L50:
            return
        L51:
            r3 = move-exception
            r2.a(r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.b.n.g.b(boolean):void");
    }

    public final void d() {
        c(true);
    }

    public final void a(c.c.b.n.q.d dVar, Exception exc) {
        synchronized (this.f6046g) {
            Iterator<o> it = this.j.iterator();
            while (it.hasNext()) {
                if (it.next().a(dVar, exc)) {
                    it.remove();
                }
            }
        }
    }

    public final c.c.b.n.q.d a(c.c.b.n.q.d dVar) throws IOException {
        c.c.b.n.r.e a2 = this.f6041b.a(g(), dVar.c(), j(), dVar.e());
        int i2 = b.f6051b[a2.a().ordinal()];
        if (i2 == 1) {
            return dVar.a(a2.b(), a2.c(), this.f6043d.a());
        }
        if (i2 == 2) {
            return dVar.a("BAD CONFIG");
        }
        if (i2 == 3) {
            return dVar.o();
        }
        throw new IOException();
    }

    public final String b(c.c.b.n.q.d dVar) {
        if ((!this.f6040a.c().equals("CHIME_ANDROID_SDK") && !this.f6040a.h()) || !dVar.l()) {
            return this.f6045f.a();
        }
        String a2 = this.f6044e.a();
        return TextUtils.isEmpty(a2) ? this.f6045f.a() : a2;
    }
}
