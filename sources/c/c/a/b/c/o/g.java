package c.c.a.b.c.o;

import android.accounts.Account;
import android.content.Context;
import android.os.IInterface;
import android.os.Looper;
import c.c.a.b.c.l.a;
import c.c.a.b.c.o.c;
import com.google.android.gms.common.api.Scope;
import java.util.Iterator;
import java.util.Set;

/* JADX WARN: Unexpected interfaces in signature: [java.lang.Object] */
/* loaded from: classes.dex */
public abstract class g<T extends IInterface> extends c<T> implements a.f {
    public final Set<Scope> w;
    public final Account x;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public g(android.content.Context r10, android.os.Looper r11, int r12, c.c.a.b.c.o.d r13, c.c.a.b.c.l.f r14, c.c.a.b.c.l.g r15) {
        /*
            r9 = this;
            c.c.a.b.c.o.h r3 = c.c.a.b.c.o.h.a(r10)
            c.c.a.b.c.c r4 = c.c.a.b.c.c.a()
            c.c.a.b.c.o.r.a(r14)
            r7 = r14
            c.c.a.b.c.l.f r7 = (c.c.a.b.c.l.f) r7
            c.c.a.b.c.o.r.a(r15)
            r8 = r15
            c.c.a.b.c.l.g r8 = (c.c.a.b.c.l.g) r8
            r0 = r9
            r1 = r10
            r2 = r11
            r5 = r12
            r6 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.b.c.o.g.<init>(android.content.Context, android.os.Looper, int, c.c.a.b.c.o.d, c.c.a.b.c.l.f, c.c.a.b.c.l.g):void");
    }

    public static c.a a(c.c.a.b.c.l.f fVar) {
        if (fVar == null) {
            return null;
        }
        return new z(fVar);
    }

    public Set<Scope> a(Set<Scope> set) {
        return set;
    }

    public final Set<Scope> b(Set<Scope> set) {
        a(set);
        Iterator<Scope> it = set.iterator();
        while (it.hasNext()) {
            if (!set.contains(it.next())) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return set;
    }

    @Override // c.c.a.b.c.o.c, c.c.a.b.c.l.a.f
    public int d() {
        return super.d();
    }

    @Override // c.c.a.b.c.o.c
    public final Account o() {
        return this.x;
    }

    @Override // c.c.a.b.c.o.c
    public final Set<Scope> u() {
        return this.w;
    }

    public static c.b a(c.c.a.b.c.l.g gVar) {
        if (gVar == null) {
            return null;
        }
        return new a0(gVar);
    }

    public g(Context context, Looper looper, h hVar, c.c.a.b.c.c cVar, int i2, d dVar, c.c.a.b.c.l.f fVar, c.c.a.b.c.l.g gVar) {
        super(context, looper, hVar, cVar, i2, a(fVar), a(gVar), dVar.e());
        this.x = dVar.a();
        Set<Scope> c2 = dVar.c();
        b(c2);
        this.w = c2;
    }
}
