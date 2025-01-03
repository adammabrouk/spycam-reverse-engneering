package c.c.b.q;

import c.c.b.g.d;
import c.c.b.g.n;
import java.util.Iterator;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-common@@19.3.0 */
/* loaded from: classes.dex */
public class c implements h {

    /* renamed from: a, reason: collision with root package name */
    public final String f6173a;

    /* renamed from: b, reason: collision with root package name */
    public final d f6174b;

    public c(Set<f> set, d dVar) {
        this.f6173a = a(set);
        this.f6174b = dVar;
    }

    public static c.c.b.g.d<h> b() {
        d.b a2 = c.c.b.g.d.a(h.class);
        a2.a(n.c(f.class));
        a2.a(b.a());
        return a2.b();
    }

    @Override // c.c.b.q.h
    public String a() {
        if (this.f6174b.a().isEmpty()) {
            return this.f6173a;
        }
        return this.f6173a + ' ' + a(this.f6174b.a());
    }

    public static String a(Set<f> set) {
        StringBuilder sb = new StringBuilder();
        Iterator<f> it = set.iterator();
        while (it.hasNext()) {
            f next = it.next();
            sb.append(next.a());
            sb.append('/');
            sb.append(next.b());
            if (it.hasNext()) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    public static /* synthetic */ h a(c.c.b.g.e eVar) {
        return new c(eVar.b(f.class), d.b());
    }
}
