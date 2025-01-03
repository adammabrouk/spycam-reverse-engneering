package c.k.b.b;

import android.content.Context;
import c.k.b.a.a;
import c.k.d.g9;
import c.k.d.j;
import c.k.d.k0;
import c.k.d.l0;
import c.k.d.m0;
import c.k.d.n0;
import c.k.d.o0;
import c.k.d.r0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class b {

    /* renamed from: i, reason: collision with root package name */
    public static final int f6776i;
    public static volatile b j;

    /* renamed from: a, reason: collision with root package name */
    public ExecutorService f6777a = Executors.newSingleThreadExecutor();

    /* renamed from: b, reason: collision with root package name */
    public HashMap<String, HashMap<String, c.k.b.a.d>> f6778b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    public HashMap<String, ArrayList<c.k.b.a.d>> f6779c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    public Context f6780d;

    /* renamed from: e, reason: collision with root package name */
    public c.k.b.a.a f6781e;

    /* renamed from: f, reason: collision with root package name */
    public String f6782f;

    /* renamed from: g, reason: collision with root package name */
    public c.k.b.c.a f6783g;

    /* renamed from: h, reason: collision with root package name */
    public c.k.b.c.b f6784h;

    static {
        f6776i = g9.m183a() ? 30 : 10;
    }

    public b(Context context) {
        this.f6780d = context;
    }

    public static b a(Context context) {
        if (j == null) {
            synchronized (b.class) {
                if (j == null) {
                    j = new b(context);
                }
            }
        }
        return j;
    }

    public final int a() {
        HashMap<String, ArrayList<c.k.b.a.d>> hashMap = this.f6779c;
        if (hashMap == null) {
            return 0;
        }
        Iterator<String> it = hashMap.keySet().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            ArrayList<c.k.b.a.d> arrayList = this.f6779c.get(it.next());
            i2 += arrayList != null ? arrayList.size() : 0;
        }
        return i2;
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized c.k.b.a.a m10a() {
        if (this.f6781e == null) {
            this.f6781e = c.k.b.a.a.a(this.f6780d);
        }
        return this.f6781e;
    }

    public c.k.b.a.b a(int i2, String str) {
        c.k.b.a.b bVar = new c.k.b.a.b();
        bVar.k = str;
        bVar.j = System.currentTimeMillis();
        bVar.f6766i = i2;
        bVar.f6765h = k0.a(6);
        bVar.f6769a = 1000;
        bVar.f6771c = 1001;
        bVar.f6770b = "E100004";
        bVar.a(this.f6780d.getPackageName());
        bVar.b(this.f6782f);
        return bVar;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m11a() {
        a(this.f6780d).f();
        a(this.f6780d).g();
    }

    public void a(c.k.b.a.a aVar, c.k.b.c.a aVar2, c.k.b.c.b bVar) {
        this.f6781e = aVar;
        this.f6783g = aVar2;
        this.f6784h = bVar;
        aVar2.b(this.f6779c);
        this.f6784h.a(this.f6778b);
    }

    public void a(c.k.b.a.b bVar) {
        if (m10a().e()) {
            this.f6777a.execute(new c(this, bVar));
        }
    }

    public void a(c.k.b.a.c cVar) {
        if (m10a().f()) {
            this.f6777a.execute(new d(this, cVar));
        }
    }

    public final void a(j.a aVar, int i2) {
        c.k.d.j.a(this.f6780d).b(aVar, i2);
    }

    public void a(String str) {
        this.f6782f = str;
    }

    public void a(boolean z, boolean z2, long j2, long j3) {
        c.k.b.a.a aVar = this.f6781e;
        if (aVar != null) {
            if (z == aVar.e() && z2 == this.f6781e.f() && j2 == this.f6781e.a() && j3 == this.f6781e.c()) {
                return;
            }
            long a2 = this.f6781e.a();
            long c2 = this.f6781e.c();
            a.C0127a g2 = c.k.b.a.a.g();
            g2.a(o0.a(this.f6780d));
            g2.a(this.f6781e.d());
            g2.b(z);
            g2.a(j2);
            g2.c(z2);
            g2.c(j3);
            c.k.b.a.a a3 = g2.a(this.f6780d);
            this.f6781e = a3;
            if (!a3.e()) {
                c.k.d.j.a(this.f6780d).m234a(100886);
            } else if (a2 != a3.a()) {
                c.k.a.a.a.c.c(this.f6780d.getPackageName() + "reset event job " + a3.a());
                f();
            }
            if (!this.f6781e.f()) {
                c.k.d.j.a(this.f6780d).m234a(100887);
                return;
            }
            if (c2 != a3.c()) {
                c.k.a.a.a.c.c(this.f6780d.getPackageName() + "reset perf job " + a3.c());
                g();
            }
        }
    }

    public final int b() {
        HashMap<String, HashMap<String, c.k.b.a.d>> hashMap = this.f6778b;
        int i2 = 0;
        if (hashMap != null) {
            Iterator<String> it = hashMap.keySet().iterator();
            while (it.hasNext()) {
                HashMap<String, c.k.b.a.d> hashMap2 = this.f6778b.get(it.next());
                if (hashMap2 != null) {
                    Iterator<String> it2 = hashMap2.keySet().iterator();
                    while (it2.hasNext()) {
                        c.k.b.a.d dVar = hashMap2.get(it2.next());
                        if (dVar instanceof c.k.b.a.c) {
                            i2 = (int) (i2 + ((c.k.b.a.c) dVar).f6768i);
                        }
                    }
                }
            }
        }
        return i2;
    }

    /* renamed from: b, reason: collision with other method in class */
    public void m12b() {
        if (m10a().e()) {
            n0 n0Var = new n0();
            n0Var.a(this.f6780d);
            n0Var.a(this.f6783g);
            this.f6777a.execute(n0Var);
        }
    }

    public final void b(c.k.b.a.b bVar) {
        c.k.b.c.a aVar = this.f6783g;
        if (aVar != null) {
            aVar.mo13a(bVar);
            if (a() < 10) {
                a(new e(this), f6776i);
            } else {
                d();
                c.k.d.j.a(this.f6780d).m234a(100888);
            }
        }
    }

    public final void b(c.k.b.a.c cVar) {
        c.k.b.c.b bVar = this.f6784h;
        if (bVar != null) {
            bVar.mo13a(cVar);
            if (b() < 10) {
                a(new g(this), f6776i);
            } else {
                e();
                c.k.d.j.a(this.f6780d).m234a(100889);
            }
        }
    }

    public void c() {
        if (m10a().f()) {
            n0 n0Var = new n0();
            n0Var.a(this.f6784h);
            n0Var.a(this.f6780d);
            this.f6777a.execute(n0Var);
        }
    }

    public final void d() {
        try {
            this.f6783g.b();
        } catch (Exception e2) {
            c.k.a.a.a.c.d("we: " + e2.getMessage());
        }
    }

    public final void e() {
        try {
            this.f6784h.b();
        } catch (Exception e2) {
            c.k.a.a.a.c.d("wp: " + e2.getMessage());
        }
    }

    public final void f() {
        if (a(this.f6780d).m10a().e()) {
            l0 l0Var = new l0(this.f6780d);
            int a2 = (int) a(this.f6780d).m10a().a();
            if (a2 < 1800) {
                a2 = 1800;
            }
            if (System.currentTimeMillis() - r0.a(this.f6780d).a("sp_client_report_status", "event_last_upload_time", 0L) > a2 * 1000) {
                c.k.d.j.a(this.f6780d).a(new i(this, l0Var), 10);
            }
            synchronized (b.class) {
                if (!c.k.d.j.a(this.f6780d).a((j.a) l0Var, a2)) {
                    c.k.d.j.a(this.f6780d).m234a(100886);
                    c.k.d.j.a(this.f6780d).a((j.a) l0Var, a2);
                }
            }
        }
    }

    public final void g() {
        if (a(this.f6780d).m10a().f()) {
            m0 m0Var = new m0(this.f6780d);
            int c2 = (int) a(this.f6780d).m10a().c();
            if (c2 < 1800) {
                c2 = 1800;
            }
            if (System.currentTimeMillis() - r0.a(this.f6780d).a("sp_client_report_status", "perf_last_upload_time", 0L) > c2 * 1000) {
                c.k.d.j.a(this.f6780d).a(new j(this, m0Var), 15);
            }
            synchronized (b.class) {
                if (!c.k.d.j.a(this.f6780d).a((j.a) m0Var, c2)) {
                    c.k.d.j.a(this.f6780d).m234a(100887);
                    c.k.d.j.a(this.f6780d).a((j.a) m0Var, c2);
                }
            }
        }
    }
}
