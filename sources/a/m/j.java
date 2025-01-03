package a.m;

import a.m.f;
import android.annotation.SuppressLint;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* compiled from: LifecycleRegistry.java */
/* loaded from: classes.dex */
public class j extends f {

    /* renamed from: a, reason: collision with root package name */
    public a.c.a.b.a<h, a> f1515a;

    /* renamed from: b, reason: collision with root package name */
    public f.c f1516b;

    /* renamed from: c, reason: collision with root package name */
    public final WeakReference<i> f1517c;

    /* renamed from: d, reason: collision with root package name */
    public int f1518d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f1519e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f1520f;

    /* renamed from: g, reason: collision with root package name */
    public ArrayList<f.c> f1521g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f1522h;

    /* compiled from: LifecycleRegistry.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public f.c f1523a;

        /* renamed from: b, reason: collision with root package name */
        public g f1524b;

        public a(h hVar, f.c cVar) {
            this.f1524b = l.a(hVar);
            this.f1523a = cVar;
        }

        public void a(i iVar, f.b bVar) {
            f.c targetState = bVar.getTargetState();
            this.f1523a = j.a(this.f1523a, targetState);
            this.f1524b.a(iVar, bVar);
            this.f1523a = targetState;
        }
    }

    public j(i iVar) {
        this(iVar, true);
    }

    @Deprecated
    public void a(f.c cVar) {
        a("markState");
        d(cVar);
    }

    public final void b(f.c cVar) {
        if (this.f1516b == cVar) {
            return;
        }
        this.f1516b = cVar;
        if (this.f1519e || this.f1518d != 0) {
            this.f1520f = true;
            return;
        }
        this.f1519e = true;
        d();
        this.f1519e = false;
    }

    public final f.c c(h hVar) {
        Map.Entry<h, a> b2 = this.f1515a.b(hVar);
        f.c cVar = null;
        f.c cVar2 = b2 != null ? b2.getValue().f1523a : null;
        if (!this.f1521g.isEmpty()) {
            cVar = this.f1521g.get(r0.size() - 1);
        }
        return a(a(this.f1516b, cVar2), cVar);
    }

    public void d(f.c cVar) {
        a("setCurrentState");
        b(cVar);
    }

    public j(i iVar, boolean z) {
        this.f1515a = new a.c.a.b.a<>();
        this.f1518d = 0;
        this.f1519e = false;
        this.f1520f = false;
        this.f1521g = new ArrayList<>();
        this.f1517c = new WeakReference<>(iVar);
        this.f1516b = f.c.INITIALIZED;
        this.f1522h = z;
    }

    public void a(f.b bVar) {
        a("handleLifecycleEvent");
        b(bVar.getTargetState());
    }

    public final void d() {
        i iVar = this.f1517c.get();
        if (iVar != null) {
            while (!b()) {
                this.f1520f = false;
                if (this.f1516b.compareTo(this.f1515a.d().getValue().f1523a) < 0) {
                    a(iVar);
                }
                Map.Entry<h, a> f2 = this.f1515a.f();
                if (!this.f1520f && f2 != null && this.f1516b.compareTo(f2.getValue().f1523a) > 0) {
                    b(iVar);
                }
            }
            this.f1520f = false;
            return;
        }
        throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
    }

    @Override // a.m.f
    public void a(h hVar) {
        i iVar;
        a("addObserver");
        f.c cVar = this.f1516b;
        f.c cVar2 = f.c.DESTROYED;
        if (cVar != cVar2) {
            cVar2 = f.c.INITIALIZED;
        }
        a aVar = new a(hVar, cVar2);
        if (this.f1515a.b(hVar, aVar) == null && (iVar = this.f1517c.get()) != null) {
            boolean z = this.f1518d != 0 || this.f1519e;
            f.c c2 = c(hVar);
            this.f1518d++;
            while (aVar.f1523a.compareTo(c2) < 0 && this.f1515a.contains(hVar)) {
                c(aVar.f1523a);
                f.b upFrom = f.b.upFrom(aVar.f1523a);
                if (upFrom != null) {
                    aVar.a(iVar, upFrom);
                    c();
                    c2 = c(hVar);
                } else {
                    throw new IllegalStateException("no event up from " + aVar.f1523a);
                }
            }
            if (!z) {
                d();
            }
            this.f1518d--;
        }
    }

    public final void c() {
        this.f1521g.remove(r0.size() - 1);
    }

    public final void c(f.c cVar) {
        this.f1521g.add(cVar);
    }

    public final boolean b() {
        if (this.f1515a.size() == 0) {
            return true;
        }
        f.c cVar = this.f1515a.d().getValue().f1523a;
        f.c cVar2 = this.f1515a.f().getValue().f1523a;
        return cVar == cVar2 && this.f1516b == cVar2;
    }

    @Override // a.m.f
    public void b(h hVar) {
        a("removeObserver");
        this.f1515a.remove(hVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(i iVar) {
        a.c.a.b.b<h, a>.d e2 = this.f1515a.e();
        while (e2.hasNext() && !this.f1520f) {
            Map.Entry next = e2.next();
            a aVar = (a) next.getValue();
            while (aVar.f1523a.compareTo(this.f1516b) < 0 && !this.f1520f && this.f1515a.contains(next.getKey())) {
                c(aVar.f1523a);
                f.b upFrom = f.b.upFrom(aVar.f1523a);
                if (upFrom != null) {
                    aVar.a(iVar, upFrom);
                    c();
                } else {
                    throw new IllegalStateException("no event up from " + aVar.f1523a);
                }
            }
        }
    }

    @Override // a.m.f
    public f.c a() {
        return this.f1516b;
    }

    public final void a(i iVar) {
        Iterator<Map.Entry<h, a>> b2 = this.f1515a.b();
        while (b2.hasNext() && !this.f1520f) {
            Map.Entry<h, a> next = b2.next();
            a value = next.getValue();
            while (value.f1523a.compareTo(this.f1516b) > 0 && !this.f1520f && this.f1515a.contains(next.getKey())) {
                f.b downFrom = f.b.downFrom(value.f1523a);
                if (downFrom != null) {
                    c(downFrom.getTargetState());
                    value.a(iVar, downFrom);
                    c();
                } else {
                    throw new IllegalStateException("no event down from " + value.f1523a);
                }
            }
        }
    }

    @SuppressLint({"RestrictedApi"})
    public final void a(String str) {
        if (!this.f1522h || a.c.a.a.a.b().a()) {
            return;
        }
        throw new IllegalStateException("Method " + str + " must be called on the main thread");
    }

    public static f.c a(f.c cVar, f.c cVar2) {
        return (cVar2 == null || cVar2.compareTo(cVar) >= 0) ? cVar : cVar2;
    }
}
