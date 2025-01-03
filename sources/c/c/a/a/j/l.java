package c.c.a.a.j;

import android.util.Base64;
import c.c.a.a.j.c;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
/* loaded from: classes.dex */
public abstract class l {

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
    public static abstract class a {
        public abstract a a(c.c.a.a.d dVar);

        public abstract a a(String str);

        public abstract a a(byte[] bArr);

        public abstract l a();
    }

    public static a d() {
        c.b bVar = new c.b();
        bVar.a(c.c.a.a.d.DEFAULT);
        return bVar;
    }

    public l a(c.c.a.a.d dVar) {
        a d2 = d();
        d2.a(a());
        d2.a(dVar);
        d2.a(b());
        return d2.a();
    }

    public abstract String a();

    public abstract byte[] b();

    public abstract c.c.a.a.d c();

    public final String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = a();
        objArr[1] = c();
        objArr[2] = b() == null ? "" : Base64.encodeToString(b(), 2);
        return String.format("TransportContext(%s, %s, %s)", objArr);
    }
}
