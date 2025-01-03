package a.f.a.j;

import java.util.HashSet;
import java.util.Iterator;

/* compiled from: ResolutionNode.java */
/* loaded from: classes.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    public HashSet<o> f820a = new HashSet<>(2);

    /* renamed from: b, reason: collision with root package name */
    public int f821b = 0;

    public void a(o oVar) {
        this.f820a.add(oVar);
    }

    public void b() {
        this.f821b = 0;
        Iterator<o> it = this.f820a.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    public boolean c() {
        return this.f821b == 1;
    }

    public void d() {
        this.f821b = 0;
        this.f820a.clear();
    }

    public void e() {
    }

    public void a() {
        this.f821b = 1;
        Iterator<o> it = this.f820a.iterator();
        while (it.hasNext()) {
            it.next().e();
        }
    }
}
