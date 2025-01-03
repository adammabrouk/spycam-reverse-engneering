package a.p.a;

import a.p.a.j;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AdapterHelper.java */
/* loaded from: classes.dex */
public class a implements j.a {

    /* renamed from: a, reason: collision with root package name */
    public a.h.i.e<b> f1578a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList<b> f1579b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList<b> f1580c;

    /* renamed from: d, reason: collision with root package name */
    public final InterfaceC0047a f1581d;

    /* renamed from: e, reason: collision with root package name */
    public Runnable f1582e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f1583f;

    /* renamed from: g, reason: collision with root package name */
    public final j f1584g;

    /* renamed from: h, reason: collision with root package name */
    public int f1585h;

    /* compiled from: AdapterHelper.java */
    /* renamed from: a.p.a.a$a, reason: collision with other inner class name */
    public interface InterfaceC0047a {
        RecyclerView.c0 a(int i2);

        void a(int i2, int i3);

        void a(int i2, int i3, Object obj);

        void a(b bVar);

        void b(int i2, int i3);

        void b(b bVar);

        void c(int i2, int i3);

        void d(int i2, int i3);
    }

    /* compiled from: AdapterHelper.java */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f1586a;

        /* renamed from: b, reason: collision with root package name */
        public int f1587b;

        /* renamed from: c, reason: collision with root package name */
        public Object f1588c;

        /* renamed from: d, reason: collision with root package name */
        public int f1589d;

        public b(int i2, int i3, int i4, Object obj) {
            this.f1586a = i2;
            this.f1587b = i3;
            this.f1589d = i4;
            this.f1588c = obj;
        }

        public String a() {
            int i2 = this.f1586a;
            return i2 != 1 ? i2 != 2 ? i2 != 4 ? i2 != 8 ? "??" : "mv" : "up" : "rm" : "add";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            int i2 = this.f1586a;
            if (i2 != bVar.f1586a) {
                return false;
            }
            if (i2 == 8 && Math.abs(this.f1589d - this.f1587b) == 1 && this.f1589d == bVar.f1587b && this.f1587b == bVar.f1589d) {
                return true;
            }
            if (this.f1589d != bVar.f1589d || this.f1587b != bVar.f1587b) {
                return false;
            }
            Object obj2 = this.f1588c;
            if (obj2 != null) {
                if (!obj2.equals(bVar.f1588c)) {
                    return false;
                }
            } else if (bVar.f1588c != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f1586a * 31) + this.f1587b) * 31) + this.f1589d;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + a() + ",s:" + this.f1587b + "c:" + this.f1589d + ",p:" + this.f1588c + "]";
        }
    }

    public a(InterfaceC0047a interfaceC0047a) {
        this(interfaceC0047a, false);
    }

    public void a() {
        int size = this.f1580c.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f1581d.a(this.f1580c.get(i2));
        }
        a(this.f1580c);
        this.f1585h = 0;
    }

    public final boolean b(int i2) {
        int size = this.f1580c.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.f1580c.get(i3);
            int i4 = bVar.f1586a;
            if (i4 == 8) {
                if (a(bVar.f1589d, i3 + 1) == i2) {
                    return true;
                }
            } else if (i4 == 1) {
                int i5 = bVar.f1587b;
                int i6 = bVar.f1589d + i5;
                while (i5 < i6) {
                    if (a(i5, i3 + 1) == i2) {
                        return true;
                    }
                    i5++;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    public final void c(b bVar) {
        g(bVar);
    }

    public final void d(b bVar) {
        boolean z;
        char c2;
        int i2 = bVar.f1587b;
        int i3 = bVar.f1589d + i2;
        char c3 = 65535;
        int i4 = i2;
        int i5 = 0;
        while (i4 < i3) {
            if (this.f1581d.a(i4) != null || b(i4)) {
                if (c3 == 0) {
                    f(a(2, i2, i5, null));
                    z = true;
                } else {
                    z = false;
                }
                c2 = 1;
            } else {
                if (c3 == 1) {
                    g(a(2, i2, i5, null));
                    z = true;
                } else {
                    z = false;
                }
                c2 = 0;
            }
            if (z) {
                i4 -= i5;
                i3 -= i5;
                i5 = 1;
            } else {
                i5++;
            }
            i4++;
            c3 = c2;
        }
        if (i5 != bVar.f1589d) {
            a(bVar);
            bVar = a(2, i2, i5, null);
        }
        if (c3 == 0) {
            f(bVar);
        } else {
            g(bVar);
        }
    }

    public void e() {
        this.f1584g.b(this.f1579b);
        int size = this.f1579b.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.f1579b.get(i2);
            int i3 = bVar.f1586a;
            if (i3 == 1) {
                b(bVar);
            } else if (i3 == 2) {
                d(bVar);
            } else if (i3 == 4) {
                e(bVar);
            } else if (i3 == 8) {
                c(bVar);
            }
            Runnable runnable = this.f1582e;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.f1579b.clear();
    }

    public void f() {
        a(this.f1579b);
        a(this.f1580c);
        this.f1585h = 0;
    }

    public final void g(b bVar) {
        this.f1580c.add(bVar);
        int i2 = bVar.f1586a;
        if (i2 == 1) {
            this.f1581d.c(bVar.f1587b, bVar.f1589d);
            return;
        }
        if (i2 == 2) {
            this.f1581d.b(bVar.f1587b, bVar.f1589d);
            return;
        }
        if (i2 == 4) {
            this.f1581d.a(bVar.f1587b, bVar.f1589d, bVar.f1588c);
        } else {
            if (i2 == 8) {
                this.f1581d.a(bVar.f1587b, bVar.f1589d);
                return;
            }
            throw new IllegalArgumentException("Unknown update op type for " + bVar);
        }
    }

    public a(InterfaceC0047a interfaceC0047a, boolean z) {
        this.f1578a = new a.h.i.f(30);
        this.f1579b = new ArrayList<>();
        this.f1580c = new ArrayList<>();
        this.f1585h = 0;
        this.f1581d = interfaceC0047a;
        this.f1583f = z;
        this.f1584g = new j(this);
    }

    public boolean c() {
        return this.f1579b.size() > 0;
    }

    public int c(int i2) {
        return a(i2, 0);
    }

    public boolean c(int i2, int i3) {
        if (i3 < 1) {
            return false;
        }
        this.f1579b.add(a(2, i2, i3, null));
        this.f1585h |= 2;
        return this.f1579b.size() == 1;
    }

    public final void f(b bVar) {
        int i2;
        int i3 = bVar.f1586a;
        if (i3 != 1 && i3 != 8) {
            int d2 = d(bVar.f1587b, i3);
            int i4 = bVar.f1587b;
            int i5 = bVar.f1586a;
            if (i5 == 2) {
                i2 = 0;
            } else {
                if (i5 != 4) {
                    throw new IllegalArgumentException("op should be remove or update." + bVar);
                }
                i2 = 1;
            }
            int i6 = 1;
            for (int i7 = 1; i7 < bVar.f1589d; i7++) {
                int d3 = d(bVar.f1587b + (i2 * i7), bVar.f1586a);
                int i8 = bVar.f1586a;
                if (i8 == 2 ? d3 == d2 : i8 == 4 && d3 == d2 + 1) {
                    i6++;
                } else {
                    b a2 = a(bVar.f1586a, d2, i6, bVar.f1588c);
                    a(a2, i4);
                    a(a2);
                    if (bVar.f1586a == 4) {
                        i4 += i6;
                    }
                    d2 = d3;
                    i6 = 1;
                }
            }
            Object obj = bVar.f1588c;
            a(bVar);
            if (i6 > 0) {
                b a3 = a(bVar.f1586a, d2, i6, obj);
                a(a3, i4);
                a(a3);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("should not dispatch add or move for pre layout");
    }

    public void a(b bVar, int i2) {
        this.f1581d.b(bVar);
        int i3 = bVar.f1586a;
        if (i3 == 2) {
            this.f1581d.d(i2, bVar.f1589d);
        } else {
            if (i3 == 4) {
                this.f1581d.a(i2, bVar.f1589d, bVar.f1588c);
                return;
            }
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    public final void b(b bVar) {
        g(bVar);
    }

    public boolean b(int i2, int i3) {
        if (i3 < 1) {
            return false;
        }
        this.f1579b.add(a(1, i2, i3, null));
        this.f1585h |= 1;
        return this.f1579b.size() == 1;
    }

    public int a(int i2, int i3) {
        int size = this.f1580c.size();
        while (i3 < size) {
            b bVar = this.f1580c.get(i3);
            int i4 = bVar.f1586a;
            if (i4 == 8) {
                int i5 = bVar.f1587b;
                if (i5 == i2) {
                    i2 = bVar.f1589d;
                } else {
                    if (i5 < i2) {
                        i2--;
                    }
                    if (bVar.f1589d <= i2) {
                        i2++;
                    }
                }
            } else {
                int i6 = bVar.f1587b;
                if (i6 > i2) {
                    continue;
                } else if (i4 == 2) {
                    int i7 = bVar.f1589d;
                    if (i2 < i6 + i7) {
                        return -1;
                    }
                    i2 -= i7;
                } else if (i4 == 1) {
                    i2 += bVar.f1589d;
                }
            }
            i3++;
        }
        return i2;
    }

    public void b() {
        a();
        int size = this.f1579b.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.f1579b.get(i2);
            int i3 = bVar.f1586a;
            if (i3 == 1) {
                this.f1581d.a(bVar);
                this.f1581d.c(bVar.f1587b, bVar.f1589d);
            } else if (i3 == 2) {
                this.f1581d.a(bVar);
                this.f1581d.d(bVar.f1587b, bVar.f1589d);
            } else if (i3 == 4) {
                this.f1581d.a(bVar);
                this.f1581d.a(bVar.f1587b, bVar.f1589d, bVar.f1588c);
            } else if (i3 == 8) {
                this.f1581d.a(bVar);
                this.f1581d.a(bVar.f1587b, bVar.f1589d);
            }
            Runnable runnable = this.f1582e;
            if (runnable != null) {
                runnable.run();
            }
        }
        a(this.f1579b);
        this.f1585h = 0;
    }

    public final void e(b bVar) {
        int i2 = bVar.f1587b;
        int i3 = bVar.f1589d + i2;
        int i4 = i2;
        char c2 = 65535;
        int i5 = 0;
        while (i2 < i3) {
            if (this.f1581d.a(i2) != null || b(i2)) {
                if (c2 == 0) {
                    f(a(4, i4, i5, bVar.f1588c));
                    i4 = i2;
                    i5 = 0;
                }
                c2 = 1;
            } else {
                if (c2 == 1) {
                    g(a(4, i4, i5, bVar.f1588c));
                    i4 = i2;
                    i5 = 0;
                }
                c2 = 0;
            }
            i5++;
            i2++;
        }
        if (i5 != bVar.f1589d) {
            Object obj = bVar.f1588c;
            a(bVar);
            bVar = a(4, i4, i5, obj);
        }
        if (c2 == 0) {
            f(bVar);
        } else {
            g(bVar);
        }
    }

    public final int d(int i2, int i3) {
        for (int size = this.f1580c.size() - 1; size >= 0; size--) {
            b bVar = this.f1580c.get(size);
            int i4 = bVar.f1586a;
            if (i4 == 8) {
                int i5 = bVar.f1587b;
                int i6 = bVar.f1589d;
                if (i5 >= i6) {
                    i6 = i5;
                    i5 = i6;
                }
                if (i2 >= i5 && i2 <= i6) {
                    int i7 = bVar.f1587b;
                    if (i5 == i7) {
                        if (i3 == 1) {
                            bVar.f1589d++;
                        } else if (i3 == 2) {
                            bVar.f1589d--;
                        }
                        i2++;
                    } else {
                        if (i3 == 1) {
                            bVar.f1587b = i7 + 1;
                        } else if (i3 == 2) {
                            bVar.f1587b = i7 - 1;
                        }
                        i2--;
                    }
                } else {
                    int i8 = bVar.f1587b;
                    if (i2 < i8) {
                        if (i3 == 1) {
                            bVar.f1587b = i8 + 1;
                            bVar.f1589d++;
                        } else if (i3 == 2) {
                            bVar.f1587b = i8 - 1;
                            bVar.f1589d--;
                        }
                    }
                }
            } else {
                int i9 = bVar.f1587b;
                if (i9 <= i2) {
                    if (i4 == 1) {
                        i2 -= bVar.f1589d;
                    } else if (i4 == 2) {
                        i2 += bVar.f1589d;
                    }
                } else if (i3 == 1) {
                    bVar.f1587b = i9 + 1;
                } else if (i3 == 2) {
                    bVar.f1587b = i9 - 1;
                }
            }
        }
        for (int size2 = this.f1580c.size() - 1; size2 >= 0; size2--) {
            b bVar2 = this.f1580c.get(size2);
            if (bVar2.f1586a == 8) {
                int i10 = bVar2.f1589d;
                if (i10 == bVar2.f1587b || i10 < 0) {
                    this.f1580c.remove(size2);
                    a(bVar2);
                }
            } else if (bVar2.f1589d <= 0) {
                this.f1580c.remove(size2);
                a(bVar2);
            }
        }
        return i2;
    }

    public boolean a(int i2, int i3, Object obj) {
        if (i3 < 1) {
            return false;
        }
        this.f1579b.add(a(4, i2, i3, obj));
        this.f1585h |= 4;
        return this.f1579b.size() == 1;
    }

    public boolean a(int i2, int i3, int i4) {
        if (i2 == i3) {
            return false;
        }
        if (i4 == 1) {
            this.f1579b.add(a(8, i2, i3, null));
            this.f1585h |= 8;
            return this.f1579b.size() == 1;
        }
        throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
    }

    public int a(int i2) {
        int size = this.f1579b.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.f1579b.get(i3);
            int i4 = bVar.f1586a;
            if (i4 != 1) {
                if (i4 == 2) {
                    int i5 = bVar.f1587b;
                    if (i5 <= i2) {
                        int i6 = bVar.f1589d;
                        if (i5 + i6 > i2) {
                            return -1;
                        }
                        i2 -= i6;
                    } else {
                        continue;
                    }
                } else if (i4 == 8) {
                    int i7 = bVar.f1587b;
                    if (i7 == i2) {
                        i2 = bVar.f1589d;
                    } else {
                        if (i7 < i2) {
                            i2--;
                        }
                        if (bVar.f1589d <= i2) {
                            i2++;
                        }
                    }
                }
            } else if (bVar.f1587b <= i2) {
                i2 += bVar.f1589d;
            }
        }
        return i2;
    }

    @Override // a.p.a.j.a
    public b a(int i2, int i3, int i4, Object obj) {
        b a2 = this.f1578a.a();
        if (a2 == null) {
            return new b(i2, i3, i4, obj);
        }
        a2.f1586a = i2;
        a2.f1587b = i3;
        a2.f1589d = i4;
        a2.f1588c = obj;
        return a2;
    }

    @Override // a.p.a.j.a
    public void a(b bVar) {
        if (this.f1583f) {
            return;
        }
        bVar.f1588c = null;
        this.f1578a.a(bVar);
    }

    public boolean d(int i2) {
        return (i2 & this.f1585h) != 0;
    }

    public boolean d() {
        return (this.f1580c.isEmpty() || this.f1579b.isEmpty()) ? false : true;
    }

    public void a(List<b> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            a(list.get(i2));
        }
        list.clear();
    }
}
