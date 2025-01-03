package c.a.a.l.i.n;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: DiskCacheWriteLocker.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final Map<c.a.a.l.c, b> f3154a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final C0068c f3155b = new C0068c();

    /* compiled from: DiskCacheWriteLocker.java */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final Lock f3156a;

        /* renamed from: b, reason: collision with root package name */
        public int f3157b;

        public b() {
            this.f3156a = new ReentrantLock();
        }
    }

    public void a(c.a.a.l.c cVar) {
        b bVar;
        synchronized (this) {
            bVar = this.f3154a.get(cVar);
            if (bVar == null) {
                bVar = this.f3155b.a();
                this.f3154a.put(cVar, bVar);
            }
            bVar.f3157b++;
        }
        bVar.f3156a.lock();
    }

    public void b(c.a.a.l.c cVar) {
        b bVar;
        synchronized (this) {
            bVar = this.f3154a.get(cVar);
            if (bVar != null && bVar.f3157b > 0) {
                int i2 = bVar.f3157b - 1;
                bVar.f3157b = i2;
                if (i2 == 0) {
                    b remove = this.f3154a.remove(cVar);
                    if (!remove.equals(bVar)) {
                        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + bVar + ", but actually removed: " + remove + ", key: " + cVar);
                    }
                    this.f3155b.a(remove);
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot release a lock that is not held, key: ");
            sb.append(cVar);
            sb.append(", interestedThreads: ");
            sb.append(bVar == null ? 0 : bVar.f3157b);
            throw new IllegalArgumentException(sb.toString());
        }
        bVar.f3156a.unlock();
    }

    /* compiled from: DiskCacheWriteLocker.java */
    /* renamed from: c.a.a.l.i.n.c$c, reason: collision with other inner class name */
    public static class C0068c {

        /* renamed from: a, reason: collision with root package name */
        public final Queue<b> f3158a;

        public C0068c() {
            this.f3158a = new ArrayDeque();
        }

        public b a() {
            b poll;
            synchronized (this.f3158a) {
                poll = this.f3158a.poll();
            }
            return poll == null ? new b() : poll;
        }

        public void a(b bVar) {
            synchronized (this.f3158a) {
                if (this.f3158a.size() < 10) {
                    this.f3158a.offer(bVar);
                }
            }
        }
    }
}
