package c.c.b.n.r;

import c.c.b.n.r.b;

/* compiled from: com.google.firebase:firebase-installations@@16.3.0 */
/* loaded from: classes.dex */
public abstract class e {

    /* compiled from: com.google.firebase:firebase-installations@@16.3.0 */
    public static abstract class a {
        public abstract a a(long j);

        public abstract a a(b bVar);

        public abstract a a(String str);

        public abstract e a();
    }

    /* compiled from: com.google.firebase:firebase-installations@@16.3.0 */
    public enum b {
        OK,
        BAD_CONFIG,
        AUTH_ERROR
    }

    public static a d() {
        b.C0116b c0116b = new b.C0116b();
        c0116b.a(0L);
        return c0116b;
    }

    public abstract b a();

    public abstract String b();

    public abstract long c();
}
