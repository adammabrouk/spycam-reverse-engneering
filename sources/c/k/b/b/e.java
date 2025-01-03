package c.k.b.b;

import c.k.d.j;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public class e extends j.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f6789a;

    public e(b bVar) {
        this.f6789a = bVar;
    }

    @Override // c.k.d.j.a
    public int a() {
        return 100888;
    }

    @Override // java.lang.Runnable
    public void run() {
        int a2;
        ExecutorService executorService;
        a2 = this.f6789a.a();
        if (a2 > 0) {
            executorService = this.f6789a.f6777a;
            executorService.execute(new f(this));
        }
    }
}
