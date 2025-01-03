package c.k.b.b;

import c.k.d.j;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public class g extends j.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f6791a;

    public g(b bVar) {
        this.f6791a = bVar;
    }

    @Override // c.k.d.j.a
    public int a() {
        return 100889;
    }

    @Override // java.lang.Runnable
    public void run() {
        int b2;
        ExecutorService executorService;
        b2 = this.f6791a.b();
        if (b2 > 0) {
            executorService = this.f6791a.f6777a;
            executorService.execute(new h(this));
        }
    }
}
