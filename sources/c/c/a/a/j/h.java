package c.c.a.a.j;

import c.c.a.a.j.a;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
/* loaded from: classes.dex */
public abstract class h {

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
    public static abstract class a {
        public abstract a a(long j);

        public abstract a a(g gVar);

        public abstract a a(Integer num);

        public abstract a a(String str);

        public final a a(String str, String str2) {
            b().put(str, str2);
            return this;
        }

        public abstract a a(Map<String, String> map);

        public abstract h a();

        public abstract a b(long j);

        public abstract Map<String, String> b();

        public final a a(String str, long j) {
            b().put(str, String.valueOf(j));
            return this;
        }

        public final a a(String str, int i2) {
            b().put(str, String.valueOf(i2));
            return this;
        }
    }

    public static a i() {
        a.b bVar = new a.b();
        bVar.a(new HashMap());
        return bVar;
    }

    public final String a(String str) {
        String str2 = a().get(str);
        return str2 == null ? "" : str2;
    }

    public abstract Map<String, String> a();

    public final int b(String str) {
        String str2 = a().get(str);
        if (str2 == null) {
            return 0;
        }
        return Integer.valueOf(str2).intValue();
    }

    public abstract Integer b();

    public final long c(String str) {
        String str2 = a().get(str);
        if (str2 == null) {
            return 0L;
        }
        return Long.valueOf(str2).longValue();
    }

    public abstract g c();

    public abstract long d();

    public final Map<String, String> e() {
        return Collections.unmodifiableMap(a());
    }

    public abstract String f();

    public abstract long g();

    public a h() {
        a.b bVar = new a.b();
        bVar.a(f());
        bVar.a(b());
        bVar.a(c());
        bVar.a(d());
        bVar.b(g());
        bVar.a(new HashMap(a()));
        return bVar;
    }
}
