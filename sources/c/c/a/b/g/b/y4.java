package c.c.a.b.g.b;

import androidx.recyclerview.widget.RecyclerView;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class y4<V> extends FutureTask<V> implements Comparable<y4<V>> {

    /* renamed from: a, reason: collision with root package name */
    public final long f5199a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f5200b;

    /* renamed from: c, reason: collision with root package name */
    public final String f5201c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ x4 f5202d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y4(x4 x4Var, Callable<V> callable, boolean z, String str) {
        super(callable);
        AtomicLong atomicLong;
        this.f5202d = x4Var;
        c.c.a.b.c.o.r.a(str);
        atomicLong = x4.l;
        long andIncrement = atomicLong.getAndIncrement();
        this.f5199a = andIncrement;
        this.f5201c = str;
        this.f5200b = z;
        if (andIncrement == RecyclerView.FOREVER_NS) {
            x4Var.c().t().a("Tasks index overflow");
        }
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        y4 y4Var = (y4) obj;
        boolean z = this.f5200b;
        if (z != y4Var.f5200b) {
            return z ? -1 : 1;
        }
        long j = this.f5199a;
        long j2 = y4Var.f5199a;
        if (j < j2) {
            return -1;
        }
        if (j > j2) {
            return 1;
        }
        this.f5202d.c().u().a("Two tasks share the same index. index", Long.valueOf(this.f5199a));
        return 0;
    }

    @Override // java.util.concurrent.FutureTask
    public final void setException(Throwable th) {
        this.f5202d.c().t().a(this.f5201c, th);
        super.setException(th);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y4(x4 x4Var, Runnable runnable, boolean z, String str) {
        super(runnable, null);
        AtomicLong atomicLong;
        this.f5202d = x4Var;
        c.c.a.b.c.o.r.a(str);
        atomicLong = x4.l;
        long andIncrement = atomicLong.getAndIncrement();
        this.f5199a = andIncrement;
        this.f5201c = str;
        this.f5200b = false;
        if (andIncrement == RecyclerView.FOREVER_NS) {
            x4Var.c().t().a("Tasks index overflow");
        }
    }
}
