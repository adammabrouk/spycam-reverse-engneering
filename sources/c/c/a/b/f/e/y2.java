package c.c.a.b.f.e;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public final class y2 {

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<x2, List<Throwable>> f4530a = new ConcurrentHashMap<>(16, 0.75f, 10);

    /* renamed from: b, reason: collision with root package name */
    public final ReferenceQueue<Throwable> f4531b = new ReferenceQueue<>();

    public final List<Throwable> a(Throwable th, boolean z) {
        Reference<? extends Throwable> poll = this.f4531b.poll();
        while (poll != null) {
            this.f4530a.remove(poll);
            poll = this.f4531b.poll();
        }
        List<Throwable> list = this.f4530a.get(new x2(th, null));
        if (list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> putIfAbsent = this.f4530a.putIfAbsent(new x2(th, this.f4531b), vector);
        return putIfAbsent == null ? vector : putIfAbsent;
    }
}
