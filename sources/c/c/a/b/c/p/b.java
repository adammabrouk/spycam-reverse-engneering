package c.c.a.b.c.p;

import c.c.a.b.c.p.a;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes.dex */
public final class b implements a.InterfaceC0091a {
    @Override // c.c.a.b.c.p.a.InterfaceC0091a
    public final ScheduledExecutorService a() {
        return Executors.newSingleThreadScheduledExecutor();
    }
}
