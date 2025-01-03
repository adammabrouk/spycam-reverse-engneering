package c.c.a.a.j.w;

import c.c.a.a.j.l;
import c.c.a.a.j.q;
import c.c.a.a.j.t.m;
import c.c.a.a.j.w.j.s;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
/* loaded from: classes.dex */
public class c implements e {

    /* renamed from: f, reason: collision with root package name */
    public static final Logger f3639f = Logger.getLogger(q.class.getName());

    /* renamed from: a, reason: collision with root package name */
    public final s f3640a;

    /* renamed from: b, reason: collision with root package name */
    public final Executor f3641b;

    /* renamed from: c, reason: collision with root package name */
    public final c.c.a.a.j.t.e f3642c;

    /* renamed from: d, reason: collision with root package name */
    public final c.c.a.a.j.w.k.c f3643d;

    /* renamed from: e, reason: collision with root package name */
    public final c.c.a.a.j.x.b f3644e;

    public c(Executor executor, c.c.a.a.j.t.e eVar, s sVar, c.c.a.a.j.w.k.c cVar, c.c.a.a.j.x.b bVar) {
        this.f3641b = executor;
        this.f3642c = eVar;
        this.f3640a = sVar;
        this.f3643d = cVar;
        this.f3644e = bVar;
    }

    @Override // c.c.a.a.j.w.e
    public void a(l lVar, c.c.a.a.j.h hVar, c.c.a.a.h hVar2) {
        this.f3641b.execute(a.a(this, lVar, hVar2, hVar));
    }

    public static /* synthetic */ void a(c cVar, l lVar, c.c.a.a.h hVar, c.c.a.a.j.h hVar2) {
        try {
            m a2 = cVar.f3642c.a(lVar.a());
            if (a2 != null) {
                cVar.f3644e.a(b.a(cVar, lVar, a2.a(hVar2)));
                hVar.a(null);
            } else {
                String format = String.format("Transport backend '%s' is not registered", lVar.a());
                f3639f.warning(format);
                hVar.a(new IllegalArgumentException(format));
            }
        } catch (Exception e2) {
            f3639f.warning("Error scheduling event " + e2.getMessage());
            hVar.a(e2);
        }
    }

    public static /* synthetic */ Object a(c cVar, l lVar, c.c.a.a.j.h hVar) {
        cVar.f3643d.a(lVar, hVar);
        cVar.f3640a.a(lVar, 1);
        return null;
    }
}
