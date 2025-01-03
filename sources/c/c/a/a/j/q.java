package c.c.a.a.j;

import android.content.Context;
import c.c.a.a.j.h;
import c.c.a.a.j.l;
import c.c.a.a.j.r;
import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
/* loaded from: classes.dex */
public class q implements p {

    /* renamed from: e, reason: collision with root package name */
    public static volatile r f3598e;

    /* renamed from: a, reason: collision with root package name */
    public final c.c.a.a.j.y.a f3599a;

    /* renamed from: b, reason: collision with root package name */
    public final c.c.a.a.j.y.a f3600b;

    /* renamed from: c, reason: collision with root package name */
    public final c.c.a.a.j.w.e f3601c;

    /* renamed from: d, reason: collision with root package name */
    public final c.c.a.a.j.w.j.m f3602d;

    public q(c.c.a.a.j.y.a aVar, c.c.a.a.j.y.a aVar2, c.c.a.a.j.w.e eVar, c.c.a.a.j.w.j.m mVar, c.c.a.a.j.w.j.q qVar) {
        this.f3599a = aVar;
        this.f3600b = aVar2;
        this.f3601c = eVar;
        this.f3602d = mVar;
        qVar.a();
    }

    public static void a(Context context) {
        if (f3598e == null) {
            synchronized (q.class) {
                if (f3598e == null) {
                    r.a c2 = d.c();
                    c2.a(context);
                    f3598e = c2.a();
                }
            }
        }
    }

    public static q b() {
        r rVar = f3598e;
        if (rVar != null) {
            return rVar.b();
        }
        throw new IllegalStateException("Not initialized!");
    }

    public static Set<c.c.a.a.b> b(e eVar) {
        if (eVar instanceof f) {
            return Collections.unmodifiableSet(((f) eVar).a());
        }
        return Collections.singleton(c.c.a.a.b.a("proto"));
    }

    public c.c.a.a.g a(e eVar) {
        Set<c.c.a.a.b> b2 = b(eVar);
        l.a d2 = l.d();
        d2.a(eVar.b());
        d2.a(eVar.c());
        return new m(b2, d2.a(), this);
    }

    public c.c.a.a.j.w.j.m a() {
        return this.f3602d;
    }

    @Override // c.c.a.a.j.p
    public void a(k kVar, c.c.a.a.h hVar) {
        this.f3601c.a(kVar.e().a(kVar.b().c()), a(kVar), hVar);
    }

    public final h a(k kVar) {
        h.a i2 = h.i();
        i2.a(this.f3599a.a());
        i2.b(this.f3600b.a());
        i2.a(kVar.f());
        i2.a(new g(kVar.a(), kVar.c()));
        i2.a(kVar.b().a());
        return i2.a();
    }
}
