package h.e0.f;

import h.c0;
import java.util.LinkedHashSet;
import java.util.Set;

/* compiled from: RouteDatabase.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final Set<c0> f11435a = new LinkedHashSet();

    public synchronized void a(c0 c0Var) {
        this.f11435a.remove(c0Var);
    }

    public synchronized void b(c0 c0Var) {
        this.f11435a.add(c0Var);
    }

    public synchronized boolean c(c0 c0Var) {
        return this.f11435a.contains(c0Var);
    }
}
