package c.c.a.a.j.w.j;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import c.c.a.a.j.t.f;
import c.c.a.a.j.t.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
/* loaded from: classes.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    public final Context f3692a;

    /* renamed from: b, reason: collision with root package name */
    public final c.c.a.a.j.t.e f3693b;

    /* renamed from: c, reason: collision with root package name */
    public final c.c.a.a.j.w.k.c f3694c;

    /* renamed from: d, reason: collision with root package name */
    public final s f3695d;

    /* renamed from: e, reason: collision with root package name */
    public final Executor f3696e;

    /* renamed from: f, reason: collision with root package name */
    public final c.c.a.a.j.x.b f3697f;

    /* renamed from: g, reason: collision with root package name */
    public final c.c.a.a.j.y.a f3698g;

    public m(Context context, c.c.a.a.j.t.e eVar, c.c.a.a.j.w.k.c cVar, s sVar, Executor executor, c.c.a.a.j.x.b bVar, c.c.a.a.j.y.a aVar) {
        this.f3692a = context;
        this.f3693b = eVar;
        this.f3694c = cVar;
        this.f3695d = sVar;
        this.f3696e = executor;
        this.f3697f = bVar;
        this.f3698g = aVar;
    }

    public boolean a() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f3692a.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public void a(c.c.a.a.j.l lVar, int i2, Runnable runnable) {
        this.f3696e.execute(h.a(this, lVar, i2, runnable));
    }

    public static /* synthetic */ void a(m mVar, c.c.a.a.j.l lVar, int i2, Runnable runnable) {
        try {
            try {
                c.c.a.a.j.x.b bVar = mVar.f3697f;
                c.c.a.a.j.w.k.c cVar = mVar.f3694c;
                cVar.getClass();
                bVar.a(k.a(cVar));
                if (!mVar.a()) {
                    mVar.f3697f.a(l.a(mVar, lVar, i2));
                } else {
                    mVar.a(lVar, i2);
                }
            } catch (c.c.a.a.j.x.a unused) {
                mVar.f3695d.a(lVar, i2 + 1);
            }
        } finally {
            runnable.run();
        }
    }

    public static /* synthetic */ Object a(m mVar, c.c.a.a.j.l lVar, int i2) {
        mVar.f3695d.a(lVar, i2 + 1);
        return null;
    }

    public void a(c.c.a.a.j.l lVar, int i2) {
        c.c.a.a.j.t.g a2;
        c.c.a.a.j.t.m a3 = this.f3693b.a(lVar.a());
        Iterable iterable = (Iterable) this.f3697f.a(i.a(this, lVar));
        if (iterable.iterator().hasNext()) {
            if (a3 == null) {
                c.c.a.a.j.u.a.a("Uploader", "Unknown backend for %s, deleting event batch for it...", lVar);
                a2 = c.c.a.a.j.t.g.c();
            } else {
                ArrayList arrayList = new ArrayList();
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    arrayList.add(((c.c.a.a.j.w.k.h) it.next()).a());
                }
                f.a c2 = c.c.a.a.j.t.f.c();
                c2.a(arrayList);
                c2.a(lVar.b());
                a2 = a3.a(c2.a());
            }
            this.f3697f.a(j.a(this, a2, iterable, lVar, i2));
        }
    }

    public static /* synthetic */ Object a(m mVar, c.c.a.a.j.t.g gVar, Iterable iterable, c.c.a.a.j.l lVar, int i2) {
        if (gVar.b() == g.a.TRANSIENT_ERROR) {
            mVar.f3694c.b((Iterable<c.c.a.a.j.w.k.h>) iterable);
            mVar.f3695d.a(lVar, i2 + 1);
            return null;
        }
        mVar.f3694c.a((Iterable<c.c.a.a.j.w.k.h>) iterable);
        if (gVar.b() == g.a.OK) {
            mVar.f3694c.a(lVar, mVar.f3698g.a() + gVar.a());
        }
        if (!mVar.f3694c.c(lVar)) {
            return null;
        }
        mVar.f3695d.a(lVar, 1);
        return null;
    }
}
