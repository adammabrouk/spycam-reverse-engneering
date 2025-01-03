package c.a.a.m;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: ActivityFragmentLifecycle.java */
/* loaded from: classes.dex */
public class a implements g {

    /* renamed from: a, reason: collision with root package name */
    public final Set<h> f3362a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b, reason: collision with root package name */
    public boolean f3363b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f3364c;

    @Override // c.a.a.m.g
    public void a(h hVar) {
        this.f3362a.add(hVar);
        if (this.f3364c) {
            hVar.f();
        } else if (this.f3363b) {
            hVar.a();
        } else {
            hVar.b();
        }
    }

    public void b() {
        this.f3363b = true;
        Iterator it = c.a.a.r.h.a(this.f3362a).iterator();
        while (it.hasNext()) {
            ((h) it.next()).a();
        }
    }

    public void c() {
        this.f3363b = false;
        Iterator it = c.a.a.r.h.a(this.f3362a).iterator();
        while (it.hasNext()) {
            ((h) it.next()).b();
        }
    }

    public void a() {
        this.f3364c = true;
        Iterator it = c.a.a.r.h.a(this.f3362a).iterator();
        while (it.hasNext()) {
            ((h) it.next()).f();
        }
    }
}
