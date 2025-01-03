package c.c.a.b.f.d;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<q, List<Throwable>> f4057a = new ConcurrentHashMap<>(16, 0.75f, 10);

    /* renamed from: b, reason: collision with root package name */
    public final ReferenceQueue<Throwable> f4058b = new ReferenceQueue<>();

    public final List<Throwable> a(Throwable th, boolean z) {
        Reference<? extends Throwable> poll = this.f4058b.poll();
        while (poll != null) {
            this.f4057a.remove(poll);
            poll = this.f4058b.poll();
        }
        List<Throwable> list = this.f4057a.get(new q(th, null));
        if (list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> putIfAbsent = this.f4057a.putIfAbsent(new q(th, this.f4058b), vector);
        return putIfAbsent == null ? vector : putIfAbsent;
    }
}
