package a.p.a;

import androidx.recyclerview.widget.RecyclerView;

/* compiled from: ViewInfoStore.java */
/* loaded from: classes.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    public final a.e.g<RecyclerView.c0, a> f1704a = new a.e.g<>();

    /* renamed from: b, reason: collision with root package name */
    public final a.e.d<RecyclerView.c0> f1705b = new a.e.d<>();

    /* compiled from: ViewInfoStore.java */
    public interface b {
        void a(RecyclerView.c0 c0Var);

        void a(RecyclerView.c0 c0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2);

        void b(RecyclerView.c0 c0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2);

        void c(RecyclerView.c0 c0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2);
    }

    public void a() {
        this.f1704a.clear();
        this.f1705b.a();
    }

    public boolean b(RecyclerView.c0 c0Var) {
        a aVar = this.f1704a.get(c0Var);
        return (aVar == null || (aVar.f1707a & 1) == 0) ? false : true;
    }

    public void c(RecyclerView.c0 c0Var, RecyclerView.l.c cVar) {
        a aVar = this.f1704a.get(c0Var);
        if (aVar == null) {
            aVar = a.b();
            this.f1704a.put(c0Var, aVar);
        }
        aVar.f1708b = cVar;
        aVar.f1707a |= 4;
    }

    public void d(RecyclerView.c0 c0Var) {
        g(c0Var);
    }

    public RecyclerView.l.c e(RecyclerView.c0 c0Var) {
        return a(c0Var, 8);
    }

    public RecyclerView.l.c f(RecyclerView.c0 c0Var) {
        return a(c0Var, 4);
    }

    public void g(RecyclerView.c0 c0Var) {
        a aVar = this.f1704a.get(c0Var);
        if (aVar == null) {
            return;
        }
        aVar.f1707a &= -2;
    }

    public void h(RecyclerView.c0 c0Var) {
        int c2 = this.f1705b.c() - 1;
        while (true) {
            if (c2 < 0) {
                break;
            }
            if (c0Var == this.f1705b.c(c2)) {
                this.f1705b.b(c2);
                break;
            }
            c2--;
        }
        a remove = this.f1704a.remove(c0Var);
        if (remove != null) {
            a.a(remove);
        }
    }

    public final RecyclerView.l.c a(RecyclerView.c0 c0Var, int i2) {
        a e2;
        RecyclerView.l.c cVar;
        int a2 = this.f1704a.a(c0Var);
        if (a2 >= 0 && (e2 = this.f1704a.e(a2)) != null) {
            int i3 = e2.f1707a;
            if ((i3 & i2) != 0) {
                e2.f1707a = (i2 ^ (-1)) & i3;
                if (i2 == 4) {
                    cVar = e2.f1708b;
                } else if (i2 == 8) {
                    cVar = e2.f1709c;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((e2.f1707a & 12) == 0) {
                    this.f1704a.d(a2);
                    a.a(e2);
                }
                return cVar;
            }
        }
        return null;
    }

    public void b(RecyclerView.c0 c0Var, RecyclerView.l.c cVar) {
        a aVar = this.f1704a.get(c0Var);
        if (aVar == null) {
            aVar = a.b();
            this.f1704a.put(c0Var, aVar);
        }
        aVar.f1709c = cVar;
        aVar.f1707a |= 8;
    }

    /* compiled from: ViewInfoStore.java */
    public static class a {

        /* renamed from: d, reason: collision with root package name */
        public static a.h.i.e<a> f1706d = new a.h.i.f(20);

        /* renamed from: a, reason: collision with root package name */
        public int f1707a;

        /* renamed from: b, reason: collision with root package name */
        public RecyclerView.l.c f1708b;

        /* renamed from: c, reason: collision with root package name */
        public RecyclerView.l.c f1709c;

        public static void a(a aVar) {
            aVar.f1707a = 0;
            aVar.f1708b = null;
            aVar.f1709c = null;
            f1706d.a(aVar);
        }

        public static a b() {
            a a2 = f1706d.a();
            return a2 == null ? new a() : a2;
        }

        public static void a() {
            while (f1706d.a() != null) {
            }
        }
    }

    public boolean c(RecyclerView.c0 c0Var) {
        a aVar = this.f1704a.get(c0Var);
        return (aVar == null || (aVar.f1707a & 4) == 0) ? false : true;
    }

    public void b() {
        a.a();
    }

    public void a(long j, RecyclerView.c0 c0Var) {
        this.f1705b.c(j, c0Var);
    }

    public void a(RecyclerView.c0 c0Var, RecyclerView.l.c cVar) {
        a aVar = this.f1704a.get(c0Var);
        if (aVar == null) {
            aVar = a.b();
            this.f1704a.put(c0Var, aVar);
        }
        aVar.f1707a |= 2;
        aVar.f1708b = cVar;
    }

    public RecyclerView.c0 a(long j) {
        return this.f1705b.a(j);
    }

    public void a(RecyclerView.c0 c0Var) {
        a aVar = this.f1704a.get(c0Var);
        if (aVar == null) {
            aVar = a.b();
            this.f1704a.put(c0Var, aVar);
        }
        aVar.f1707a |= 1;
    }

    public void a(b bVar) {
        for (int size = this.f1704a.size() - 1; size >= 0; size--) {
            RecyclerView.c0 c2 = this.f1704a.c(size);
            a d2 = this.f1704a.d(size);
            int i2 = d2.f1707a;
            if ((i2 & 3) == 3) {
                bVar.a(c2);
            } else if ((i2 & 1) != 0) {
                RecyclerView.l.c cVar = d2.f1708b;
                if (cVar == null) {
                    bVar.a(c2);
                } else {
                    bVar.b(c2, cVar, d2.f1709c);
                }
            } else if ((i2 & 14) == 14) {
                bVar.a(c2, d2.f1708b, d2.f1709c);
            } else if ((i2 & 12) == 12) {
                bVar.c(c2, d2.f1708b, d2.f1709c);
            } else if ((i2 & 4) != 0) {
                bVar.b(c2, d2.f1708b, null);
            } else if ((i2 & 8) != 0) {
                bVar.a(c2, d2.f1708b, d2.f1709c);
            }
            a.a(d2);
        }
    }
}
