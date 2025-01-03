package c.c.b.n.q;

import c.c.b.n.q.a;
import c.c.b.n.q.c;

/* compiled from: com.google.firebase:firebase-installations@@16.3.0 */
/* loaded from: classes.dex */
public abstract class d {

    /* compiled from: com.google.firebase:firebase-installations@@16.3.0 */
    public static abstract class a {
        public abstract a a(long j);

        public abstract a a(c.a aVar);

        public abstract a a(String str);

        public abstract d a();

        public abstract a b(long j);

        public abstract a b(String str);

        public abstract a c(String str);

        public abstract a d(String str);
    }

    static {
        p().a();
    }

    public static a p() {
        a.b bVar = new a.b();
        bVar.b(0L);
        bVar.a(c.a.ATTEMPT_MIGRATION);
        bVar.a(0L);
        return bVar;
    }

    public d a(String str, String str2, long j, String str3, long j2) {
        a m = m();
        m.b(str);
        m.a(c.a.REGISTERED);
        m.a(str3);
        m.d(str2);
        m.a(j2);
        m.b(j);
        return m.a();
    }

    public abstract String a();

    public abstract long b();

    public d b(String str) {
        a m = m();
        m.b(str);
        m.a(c.a.UNREGISTERED);
        return m.a();
    }

    public abstract String c();

    public abstract String d();

    public abstract String e();

    public abstract c.a f();

    public abstract long g();

    public boolean h() {
        return f() == c.a.REGISTER_ERROR;
    }

    public boolean i() {
        return f() == c.a.NOT_GENERATED || f() == c.a.ATTEMPT_MIGRATION;
    }

    public boolean j() {
        return f() == c.a.REGISTERED;
    }

    public boolean k() {
        return f() == c.a.UNREGISTERED;
    }

    public boolean l() {
        return f() == c.a.ATTEMPT_MIGRATION;
    }

    public abstract a m();

    public d n() {
        a m = m();
        m.a((String) null);
        return m.a();
    }

    public d o() {
        a m = m();
        m.a(c.a.NOT_GENERATED);
        return m.a();
    }

    public d a(String str) {
        a m = m();
        m.c(str);
        m.a(c.a.REGISTER_ERROR);
        return m.a();
    }

    public d a(String str, long j, long j2) {
        a m = m();
        m.a(str);
        m.a(j);
        m.b(j2);
        return m.a();
    }
}
