package c.c.a.a.i.b;

import c.c.a.a.i.b.h;
import java.util.List;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
/* loaded from: classes.dex */
public abstract class r {

    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
    public static abstract class a {
        public abstract a a(int i2);

        public abstract a a(long j);

        public abstract a a(b bVar);

        public abstract a a(m mVar);

        public abstract a a(String str);

        public abstract a a(List<p> list);

        public abstract r a();

        public a b(int i2) {
            a(i2);
            return this;
        }

        public abstract a b(long j);

        public a b(String str) {
            a(str);
            return this;
        }
    }

    public static a a() {
        h.b bVar = new h.b();
        bVar.a(Integer.MIN_VALUE);
        return bVar;
    }
}
