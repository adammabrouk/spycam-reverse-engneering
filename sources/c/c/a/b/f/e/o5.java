package c.c.a.b.f.e;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public final class o5 extends n5 {
    public o5() {
        super();
    }

    public static <E> z4<E> b(Object obj, long j) {
        return (z4) q7.f(obj, j);
    }

    @Override // c.c.a.b.f.e.n5
    public final void a(Object obj, long j) {
        b(obj, j).c();
    }

    @Override // c.c.a.b.f.e.n5
    public final <E> void a(Object obj, Object obj2, long j) {
        z4 b2 = b(obj, j);
        z4 b3 = b(obj2, j);
        int size = b2.size();
        int size2 = b3.size();
        if (size > 0 && size2 > 0) {
            if (!b2.zza()) {
                b2 = b2.zza(size2 + size);
            }
            b2.addAll(b3);
        }
        if (size > 0) {
            b3 = b2;
        }
        q7.a(obj, j, b3);
    }
}
