package c.c.a.a.j.w.j;

import java.util.Iterator;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
/* loaded from: classes.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f3708a;

    /* renamed from: b, reason: collision with root package name */
    public final c.c.a.a.j.w.k.c f3709b;

    /* renamed from: c, reason: collision with root package name */
    public final s f3710c;

    /* renamed from: d, reason: collision with root package name */
    public final c.c.a.a.j.x.b f3711d;

    public q(Executor executor, c.c.a.a.j.w.k.c cVar, s sVar, c.c.a.a.j.x.b bVar) {
        this.f3708a = executor;
        this.f3709b = cVar;
        this.f3710c = sVar;
        this.f3711d = bVar;
    }

    public void a() {
        this.f3708a.execute(o.a(this));
    }

    public static /* synthetic */ Object a(q qVar) {
        Iterator<c.c.a.a.j.l> it = qVar.f3709b.n().iterator();
        while (it.hasNext()) {
            qVar.f3710c.a(it.next(), 1);
        }
        return null;
    }
}
