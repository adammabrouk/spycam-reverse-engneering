package c.c.a.b.f.e;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public final class x2 extends WeakReference<Throwable> {

    /* renamed from: a, reason: collision with root package name */
    public final int f4514a;

    public x2(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        if (th == null) {
            throw new NullPointerException("The referent cannot be null");
        }
        this.f4514a = System.identityHashCode(th);
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == x2.class) {
            if (this == obj) {
                return true;
            }
            x2 x2Var = (x2) obj;
            if (this.f4514a == x2Var.f4514a && get() == x2Var.get()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f4514a;
    }
}
