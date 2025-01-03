package c.c.a.b.f.e;

import android.os.Bundle;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public final class vc extends bd {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReference<Bundle> f4497a = new AtomicReference<>();

    /* renamed from: b, reason: collision with root package name */
    public boolean f4498b;

    @Override // c.c.a.b.f.e.yc
    public final void a(Bundle bundle) {
        synchronized (this.f4497a) {
            try {
                this.f4497a.set(bundle);
                this.f4498b = true;
            } finally {
                this.f4497a.notify();
            }
        }
    }

    public final Bundle b(long j) {
        Bundle bundle;
        synchronized (this.f4497a) {
            if (!this.f4498b) {
                try {
                    this.f4497a.wait(j);
                } catch (InterruptedException unused) {
                    return null;
                }
            }
            bundle = this.f4497a.get();
        }
        return bundle;
    }

    public final String a(long j) {
        return (String) a(b(j), String.class);
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0003, code lost:
    
        r4 = r4.get("r");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <T> T a(android.os.Bundle r4, java.lang.Class<T> r5) {
        /*
            r0 = 0
            if (r4 == 0) goto L38
            java.lang.String r1 = "r"
            java.lang.Object r4 = r4.get(r1)
            if (r4 == 0) goto L38
            java.lang.Object r4 = r5.cast(r4)     // Catch: java.lang.ClassCastException -> L10
            return r4
        L10:
            r0 = move-exception
            java.lang.String r5 = r5.getCanonicalName()
            java.lang.Class r4 = r4.getClass()
            java.lang.String r4 = r4.getCanonicalName()
            java.lang.String r1 = "Unexpected object type. Expected, Received"
            java.lang.String r2 = ": %s, %s"
            java.lang.String r1 = r1.concat(r2)
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r5
            r5 = 1
            r2[r5] = r4
            java.lang.String r4 = java.lang.String.format(r1, r2)
            java.lang.String r5 = "AM"
            android.util.Log.w(r5, r4, r0)
            throw r0
        L38:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.b.f.e.vc.a(android.os.Bundle, java.lang.Class):java.lang.Object");
    }
}
