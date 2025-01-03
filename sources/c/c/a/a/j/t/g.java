package c.c.a.a.j.t;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
/* loaded from: classes.dex */
public abstract class g {

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
    public enum a {
        OK,
        TRANSIENT_ERROR,
        FATAL_ERROR
    }

    public static g a(long j) {
        return new b(a.OK, j);
    }

    public static g c() {
        return new b(a.FATAL_ERROR, -1L);
    }

    public static g d() {
        return new b(a.TRANSIENT_ERROR, -1L);
    }

    public abstract long a();

    public abstract a b();
}
