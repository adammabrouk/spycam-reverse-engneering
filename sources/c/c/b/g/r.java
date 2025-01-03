package c.c.b.g;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
/* loaded from: classes.dex */
public class r implements c.c.b.j.d, c.c.b.j.c {

    /* renamed from: a, reason: collision with root package name */
    public final Map<Class<?>, ConcurrentHashMap<c.c.b.j.b<Object>, Executor>> f5869a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public Queue<c.c.b.j.a<?>> f5870b = new ArrayDeque();

    /* renamed from: c, reason: collision with root package name */
    public final Executor f5871c;

    public r(Executor executor) {
        this.f5871c = executor;
    }

    public void b(c.c.b.j.a<?> aVar) {
        u.a(aVar);
        synchronized (this) {
            if (this.f5870b != null) {
                this.f5870b.add(aVar);
                return;
            }
            for (Map.Entry<c.c.b.j.b<Object>, Executor> entry : a(aVar)) {
                entry.getValue().execute(q.a(entry, aVar));
            }
        }
    }

    public final synchronized Set<Map.Entry<c.c.b.j.b<Object>, Executor>> a(c.c.b.j.a<?> aVar) {
        ConcurrentHashMap<c.c.b.j.b<Object>, Executor> concurrentHashMap;
        concurrentHashMap = this.f5869a.get(aVar.b());
        return concurrentHashMap == null ? Collections.emptySet() : concurrentHashMap.entrySet();
    }

    @Override // c.c.b.j.d
    public synchronized <T> void a(Class<T> cls, Executor executor, c.c.b.j.b<? super T> bVar) {
        u.a(cls);
        u.a(bVar);
        u.a(executor);
        if (!this.f5869a.containsKey(cls)) {
            this.f5869a.put(cls, new ConcurrentHashMap<>());
        }
        this.f5869a.get(cls).put(bVar, executor);
    }

    @Override // c.c.b.j.d
    public <T> void a(Class<T> cls, c.c.b.j.b<? super T> bVar) {
        a(cls, this.f5871c, bVar);
    }

    public void a() {
        Queue<c.c.b.j.a<?>> queue;
        synchronized (this) {
            queue = null;
            if (this.f5870b != null) {
                Queue<c.c.b.j.a<?>> queue2 = this.f5870b;
                this.f5870b = null;
                queue = queue2;
            }
        }
        if (queue != null) {
            Iterator<c.c.b.j.a<?>> it = queue.iterator();
            while (it.hasNext()) {
                b(it.next());
            }
        }
    }
}
