package c.c.a.b.c;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class h0 extends f0 {

    /* renamed from: e, reason: collision with root package name */
    public final Callable<String> f3825e;

    public h0(Callable<String> callable) {
        super(false, null, null);
        this.f3825e = callable;
    }

    @Override // c.c.a.b.c.f0
    public final String a() {
        try {
            return this.f3825e.call();
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }
}
