package c.c.a.b.f.d;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
/* loaded from: classes.dex */
public final class q extends WeakReference<Throwable> {

    /* renamed from: a, reason: collision with root package name */
    public final int f4060a;

    public q(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        if (th == null) {
            throw new NullPointerException("The referent cannot be null");
        }
        this.f4060a = System.identityHashCode(th);
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == q.class) {
            if (this == obj) {
                return true;
            }
            q qVar = (q) obj;
            if (this.f4060a == qVar.f4060a && get() == qVar.get()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f4060a;
    }
}
