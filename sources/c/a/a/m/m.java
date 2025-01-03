package c.a.a.m;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: RequestTracker.java */
/* loaded from: classes.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    public final Set<c.a.a.p.b> f3381a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b, reason: collision with root package name */
    public final List<c.a.a.p.b> f3382b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public boolean f3383c;

    public void a(c.a.a.p.b bVar) {
        this.f3381a.remove(bVar);
        this.f3382b.remove(bVar);
    }

    public void b(c.a.a.p.b bVar) {
        this.f3381a.add(bVar);
        if (this.f3383c) {
            this.f3382b.add(bVar);
        } else {
            bVar.d();
        }
    }

    public void c() {
        for (c.a.a.p.b bVar : c.a.a.r.h.a(this.f3381a)) {
            if (!bVar.f() && !bVar.isCancelled()) {
                bVar.c();
                if (this.f3383c) {
                    this.f3382b.add(bVar);
                } else {
                    bVar.d();
                }
            }
        }
    }

    public void d() {
        this.f3383c = false;
        for (c.a.a.p.b bVar : c.a.a.r.h.a(this.f3381a)) {
            if (!bVar.f() && !bVar.isCancelled() && !bVar.isRunning()) {
                bVar.d();
            }
        }
        this.f3382b.clear();
    }

    public void a() {
        Iterator it = c.a.a.r.h.a(this.f3381a).iterator();
        while (it.hasNext()) {
            ((c.a.a.p.b) it.next()).clear();
        }
        this.f3382b.clear();
    }

    public void b() {
        this.f3383c = true;
        for (c.a.a.p.b bVar : c.a.a.r.h.a(this.f3381a)) {
            if (bVar.isRunning()) {
                bVar.c();
                this.f3382b.add(bVar);
            }
        }
    }
}
