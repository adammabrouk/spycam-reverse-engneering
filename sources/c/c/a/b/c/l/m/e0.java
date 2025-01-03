package c.c.a.b.c.l.m;

import c.c.a.b.c.l.a;
import c.c.a.b.c.l.a.d;

/* loaded from: classes.dex */
public final class e0<O extends a.d> {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f3874a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3875b;

    /* renamed from: c, reason: collision with root package name */
    public final c.c.a.b.c.l.a<O> f3876c;

    /* renamed from: d, reason: collision with root package name */
    public final O f3877d;

    public final String a() {
        return this.f3876c.a();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e0)) {
            return false;
        }
        e0 e0Var = (e0) obj;
        return !this.f3874a && !e0Var.f3874a && c.c.a.b.c.o.q.a(this.f3876c, e0Var.f3876c) && c.c.a.b.c.o.q.a(this.f3877d, e0Var.f3877d);
    }

    public final int hashCode() {
        return this.f3875b;
    }
}
