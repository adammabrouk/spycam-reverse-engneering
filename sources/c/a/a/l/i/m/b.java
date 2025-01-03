package c.a.a.l.i.m;

import c.a.a.l.i.m.h;
import java.util.Queue;

/* compiled from: BaseKeyPool.java */
/* loaded from: classes.dex */
public abstract class b<T extends h> {

    /* renamed from: a, reason: collision with root package name */
    public final Queue<T> f3127a = c.a.a.r.h.a(20);

    public abstract T a();

    public void a(T t) {
        if (this.f3127a.size() < 20) {
            this.f3127a.offer(t);
        }
    }

    public T b() {
        T poll = this.f3127a.poll();
        return poll == null ? a() : poll;
    }
}
