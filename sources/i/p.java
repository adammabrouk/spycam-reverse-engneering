package i;

import javax.annotation.Nullable;

/* compiled from: SegmentPool.java */
/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public static o f11852a;

    /* renamed from: b, reason: collision with root package name */
    public static long f11853b;

    public static o a() {
        synchronized (p.class) {
            if (f11852a == null) {
                return new o();
            }
            o oVar = f11852a;
            f11852a = oVar.f11850f;
            oVar.f11850f = null;
            f11853b -= 8192;
            return oVar;
        }
    }

    public static void a(o oVar) {
        if (oVar.f11850f == null && oVar.f11851g == null) {
            if (oVar.f11848d) {
                return;
            }
            synchronized (p.class) {
                if (f11853b + 8192 > 65536) {
                    return;
                }
                f11853b += 8192;
                oVar.f11850f = f11852a;
                oVar.f11847c = 0;
                oVar.f11846b = 0;
                f11852a = oVar;
                return;
            }
        }
        throw new IllegalArgumentException();
    }
}
