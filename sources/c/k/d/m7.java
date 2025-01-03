package c.k.d;

import com.shix.shixipc.utilcode.LogUtils;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class m7 implements i8<m7, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public int f7391a;

    /* renamed from: a, reason: collision with other field name */
    public long f58a;

    /* renamed from: a, reason: collision with other field name */
    public l7 f59a;

    /* renamed from: a, reason: collision with other field name */
    public z7 f60a;

    /* renamed from: a, reason: collision with other field name */
    public String f61a;

    /* renamed from: a, reason: collision with other field name */
    public Map<String, String> f63a;

    /* renamed from: a, reason: collision with other field name */
    public short f64a;

    /* renamed from: b, reason: collision with root package name */
    public String f7392b;

    /* renamed from: b, reason: collision with other field name */
    public short f66b;

    /* renamed from: c, reason: collision with root package name */
    public String f7393c;

    /* renamed from: d, reason: collision with root package name */
    public String f7394d;

    /* renamed from: e, reason: collision with root package name */
    public String f7395e;

    /* renamed from: f, reason: collision with root package name */
    public String f7396f;

    /* renamed from: g, reason: collision with root package name */
    public String f7397g;

    /* renamed from: h, reason: collision with root package name */
    public String f7398h;

    /* renamed from: i, reason: collision with root package name */
    public String f7399i;
    public String j;
    public String k;
    public String l;
    public static final y8 m = new y8("XmPushActionAckMessage");
    public static final q8 n = new q8("", (byte) 11, 1);
    public static final q8 o = new q8("", (byte) 12, 2);
    public static final q8 p = new q8("", (byte) 11, 3);
    public static final q8 q = new q8("", (byte) 11, 4);
    public static final q8 r = new q8("", (byte) 10, 5);
    public static final q8 t = new q8("", (byte) 11, 6);
    public static final q8 u = new q8("", (byte) 11, 7);
    public static final q8 v = new q8("", (byte) 12, 8);
    public static final q8 w = new q8("", (byte) 11, 9);
    public static final q8 x = new q8("", (byte) 11, 10);
    public static final q8 y = new q8("", (byte) 2, 11);
    public static final q8 z = new q8("", (byte) 11, 12);
    public static final q8 A = new q8("", (byte) 11, 13);
    public static final q8 B = new q8("", (byte) 11, 14);
    public static final q8 C = new q8("", (byte) 6, 15);
    public static final q8 D = new q8("", (byte) 6, 16);
    public static final q8 E = new q8("", (byte) 11, 20);
    public static final q8 F = new q8("", (byte) 11, 21);
    public static final q8 G = new q8("", (byte) 8, 22);
    public static final q8 H = new q8("", (byte) 13, 23);

    /* renamed from: a, reason: collision with other field name */
    public BitSet f62a = new BitSet(5);

    /* renamed from: a, reason: collision with other field name */
    public boolean f65a = false;

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(m7 m7Var) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        int a10;
        int a11;
        int a12;
        int a13;
        int a14;
        int a15;
        int a16;
        int a17;
        int a18;
        int a19;
        int a20;
        int a21;
        if (!m7.class.equals(m7Var.getClass())) {
            return m7.class.getName().compareTo(m7Var.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m300a()).compareTo(Boolean.valueOf(m7Var.m300a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m300a() && (a21 = j8.a(this.f61a, m7Var.f61a)) != 0) {
            return a21;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(m7Var.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a20 = j8.a(this.f59a, m7Var.f59a)) != 0) {
            return a20;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(m7Var.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a19 = j8.a(this.f7392b, m7Var.f7392b)) != 0) {
            return a19;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(m7Var.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a18 = j8.a(this.f7393c, m7Var.f7393c)) != 0) {
            return a18;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(m7Var.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a17 = j8.a(this.f58a, m7Var.f58a)) != 0) {
            return a17;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(m7Var.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a16 = j8.a(this.f7394d, m7Var.f7394d)) != 0) {
            return a16;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(m7Var.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a15 = j8.a(this.f7395e, m7Var.f7395e)) != 0) {
            return a15;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(m7Var.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a14 = j8.a(this.f60a, m7Var.f60a)) != 0) {
            return a14;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(m7Var.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a13 = j8.a(this.f7396f, m7Var.f7396f)) != 0) {
            return a13;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(m7Var.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (a12 = j8.a(this.f7397g, m7Var.f7397g)) != 0) {
            return a12;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(m7Var.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k() && (a11 = j8.a(this.f65a, m7Var.f65a)) != 0) {
            return a11;
        }
        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(m7Var.l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (l() && (a10 = j8.a(this.f7398h, m7Var.f7398h)) != 0) {
            return a10;
        }
        int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(m7Var.m()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (m() && (a9 = j8.a(this.f7399i, m7Var.f7399i)) != 0) {
            return a9;
        }
        int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(m7Var.n()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (n() && (a8 = j8.a(this.j, m7Var.j)) != 0) {
            return a8;
        }
        int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(m7Var.o()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (o() && (a7 = j8.a(this.f64a, m7Var.f64a)) != 0) {
            return a7;
        }
        int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(m7Var.p()));
        if (compareTo16 != 0) {
            return compareTo16;
        }
        if (p() && (a6 = j8.a(this.f66b, m7Var.f66b)) != 0) {
            return a6;
        }
        int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(m7Var.q()));
        if (compareTo17 != 0) {
            return compareTo17;
        }
        if (q() && (a5 = j8.a(this.k, m7Var.k)) != 0) {
            return a5;
        }
        int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(m7Var.r()));
        if (compareTo18 != 0) {
            return compareTo18;
        }
        if (r() && (a4 = j8.a(this.l, m7Var.l)) != 0) {
            return a4;
        }
        int compareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(m7Var.s()));
        if (compareTo19 != 0) {
            return compareTo19;
        }
        if (s() && (a3 = j8.a(this.f7391a, m7Var.f7391a)) != 0) {
            return a3;
        }
        int compareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(m7Var.t()));
        if (compareTo20 != 0) {
            return compareTo20;
        }
        if (!t() || (a2 = j8.a(this.f63a, m7Var.f63a)) == 0) {
            return 0;
        }
        return a2;
    }

    public m7 a(long j) {
        this.f58a = j;
        a(true);
        return this;
    }

    public m7 a(String str) {
        this.f7392b = str;
        return this;
    }

    public m7 a(short s) {
        this.f64a = s;
        c(true);
        return this;
    }

    public void a() {
        if (this.f7392b == null) {
            throw new u8("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f7393c != null) {
            return;
        }
        throw new u8("Required field 'appId' was not present! Struct: " + toString());
    }

    @Override // c.k.d.i8
    public void a(t8 t8Var) {
        t8Var.mo347a();
        while (true) {
            q8 mo343a = t8Var.mo343a();
            byte b2 = mo343a.f7785b;
            if (b2 == 0) {
                t8Var.f();
                if (e()) {
                    a();
                    return;
                }
                throw new u8("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
            }
            switch (mo343a.f7786c) {
                case 1:
                    if (b2 == 11) {
                        this.f61a = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        l7 l7Var = new l7();
                        this.f59a = l7Var;
                        l7Var.a(t8Var);
                        continue;
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f7392b = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f7393c = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 5:
                    if (b2 == 10) {
                        this.f58a = t8Var.mo342a();
                        a(true);
                        break;
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f7394d = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f7395e = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 8:
                    if (b2 == 12) {
                        z7 z7Var = new z7();
                        this.f60a = z7Var;
                        z7Var.a(t8Var);
                        continue;
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f7396f = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f7397g = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 11:
                    if (b2 == 2) {
                        this.f65a = t8Var.mo353a();
                        b(true);
                        continue;
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f7398h = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 13:
                    if (b2 == 11) {
                        this.f7399i = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 14:
                    if (b2 == 11) {
                        this.j = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 15:
                    if (b2 == 6) {
                        this.f64a = t8Var.mo350a();
                        c(true);
                        continue;
                    }
                    break;
                case 16:
                    if (b2 == 6) {
                        this.f66b = t8Var.mo350a();
                        d(true);
                        continue;
                    }
                    break;
                case 20:
                    if (b2 == 11) {
                        this.k = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 21:
                    if (b2 == 11) {
                        this.l = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 22:
                    if (b2 == 8) {
                        this.f7391a = t8Var.mo341a();
                        e(true);
                        break;
                    }
                    break;
                case 23:
                    if (b2 == 13) {
                        s8 mo345a = t8Var.mo345a();
                        this.f63a = new HashMap(mo345a.f7854c * 2);
                        for (int i2 = 0; i2 < mo345a.f7854c; i2++) {
                            this.f63a.put(t8Var.mo348a(), t8Var.mo348a());
                        }
                        t8Var.h();
                        break;
                    }
                    break;
            }
            w8.a(t8Var, b2);
            t8Var.g();
        }
    }

    public void a(boolean z2) {
        this.f62a.set(0, z2);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m300a() {
        return this.f61a != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m301a(m7 m7Var) {
        if (m7Var == null) {
            return false;
        }
        boolean m300a = m300a();
        boolean m300a2 = m7Var.m300a();
        if ((m300a || m300a2) && !(m300a && m300a2 && this.f61a.equals(m7Var.f61a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = m7Var.b();
        if ((b2 || b3) && !(b2 && b3 && this.f59a.m287a(m7Var.f59a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = m7Var.c();
        if ((c2 || c3) && !(c2 && c3 && this.f7392b.equals(m7Var.f7392b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = m7Var.d();
        if (((d2 || d3) && !(d2 && d3 && this.f7393c.equals(m7Var.f7393c))) || this.f58a != m7Var.f58a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = m7Var.f();
        if ((f2 || f3) && !(f2 && f3 && this.f7394d.equals(m7Var.f7394d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = m7Var.g();
        if ((g2 || g3) && !(g2 && g3 && this.f7395e.equals(m7Var.f7395e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = m7Var.h();
        if ((h2 || h3) && !(h2 && h3 && this.f60a.m567a(m7Var.f60a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = m7Var.i();
        if ((i2 || i3) && !(i2 && i3 && this.f7396f.equals(m7Var.f7396f))) {
            return false;
        }
        boolean j = j();
        boolean j2 = m7Var.j();
        if ((j || j2) && !(j && j2 && this.f7397g.equals(m7Var.f7397g))) {
            return false;
        }
        boolean k = k();
        boolean k2 = m7Var.k();
        if ((k || k2) && !(k && k2 && this.f65a == m7Var.f65a)) {
            return false;
        }
        boolean l = l();
        boolean l2 = m7Var.l();
        if ((l || l2) && !(l && l2 && this.f7398h.equals(m7Var.f7398h))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = m7Var.m();
        if ((m2 || m3) && !(m2 && m3 && this.f7399i.equals(m7Var.f7399i))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = m7Var.n();
        if ((n2 || n3) && !(n2 && n3 && this.j.equals(m7Var.j))) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = m7Var.o();
        if ((o2 || o3) && !(o2 && o3 && this.f64a == m7Var.f64a)) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = m7Var.p();
        if ((p2 || p3) && !(p2 && p3 && this.f66b == m7Var.f66b)) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = m7Var.q();
        if ((q2 || q3) && !(q2 && q3 && this.k.equals(m7Var.k))) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = m7Var.r();
        if ((r2 || r3) && !(r2 && r3 && this.l.equals(m7Var.l))) {
            return false;
        }
        boolean s = s();
        boolean s2 = m7Var.s();
        if ((s || s2) && !(s && s2 && this.f7391a == m7Var.f7391a)) {
            return false;
        }
        boolean t2 = t();
        boolean t3 = m7Var.t();
        if (t2 || t3) {
            return t2 && t3 && this.f63a.equals(m7Var.f63a);
        }
        return true;
    }

    public m7 b(String str) {
        this.f7393c = str;
        return this;
    }

    @Override // c.k.d.i8
    public void b(t8 t8Var) {
        a();
        t8Var.a(m);
        if (this.f61a != null && m300a()) {
            t8Var.a(n);
            t8Var.a(this.f61a);
            t8Var.b();
        }
        if (this.f59a != null && b()) {
            t8Var.a(o);
            this.f59a.b(t8Var);
            t8Var.b();
        }
        if (this.f7392b != null) {
            t8Var.a(p);
            t8Var.a(this.f7392b);
            t8Var.b();
        }
        if (this.f7393c != null) {
            t8Var.a(q);
            t8Var.a(this.f7393c);
            t8Var.b();
        }
        t8Var.a(r);
        t8Var.a(this.f58a);
        t8Var.b();
        if (this.f7394d != null && f()) {
            t8Var.a(t);
            t8Var.a(this.f7394d);
            t8Var.b();
        }
        if (this.f7395e != null && g()) {
            t8Var.a(u);
            t8Var.a(this.f7395e);
            t8Var.b();
        }
        if (this.f60a != null && h()) {
            t8Var.a(v);
            this.f60a.b(t8Var);
            t8Var.b();
        }
        if (this.f7396f != null && i()) {
            t8Var.a(w);
            t8Var.a(this.f7396f);
            t8Var.b();
        }
        if (this.f7397g != null && j()) {
            t8Var.a(x);
            t8Var.a(this.f7397g);
            t8Var.b();
        }
        if (k()) {
            t8Var.a(y);
            t8Var.a(this.f65a);
            t8Var.b();
        }
        if (this.f7398h != null && l()) {
            t8Var.a(z);
            t8Var.a(this.f7398h);
            t8Var.b();
        }
        if (this.f7399i != null && m()) {
            t8Var.a(A);
            t8Var.a(this.f7399i);
            t8Var.b();
        }
        if (this.j != null && n()) {
            t8Var.a(B);
            t8Var.a(this.j);
            t8Var.b();
        }
        if (o()) {
            t8Var.a(C);
            t8Var.a(this.f64a);
            t8Var.b();
        }
        if (p()) {
            t8Var.a(D);
            t8Var.a(this.f66b);
            t8Var.b();
        }
        if (this.k != null && q()) {
            t8Var.a(E);
            t8Var.a(this.k);
            t8Var.b();
        }
        if (this.l != null && r()) {
            t8Var.a(F);
            t8Var.a(this.l);
            t8Var.b();
        }
        if (s()) {
            t8Var.a(G);
            t8Var.mo352a(this.f7391a);
            t8Var.b();
        }
        if (this.f63a != null && t()) {
            t8Var.a(H);
            t8Var.a(new s8((byte) 11, (byte) 11, this.f63a.size()));
            for (Map.Entry<String, String> entry : this.f63a.entrySet()) {
                t8Var.a(entry.getKey());
                t8Var.a(entry.getValue());
            }
            t8Var.d();
            t8Var.b();
        }
        t8Var.c();
        t8Var.mo351a();
    }

    public void b(boolean z2) {
        this.f62a.set(1, z2);
    }

    public boolean b() {
        return this.f59a != null;
    }

    public m7 c(String str) {
        this.f7394d = str;
        return this;
    }

    public void c(boolean z2) {
        this.f62a.set(2, z2);
    }

    public boolean c() {
        return this.f7392b != null;
    }

    public m7 d(String str) {
        this.f7395e = str;
        return this;
    }

    public void d(boolean z2) {
        this.f62a.set(3, z2);
    }

    public boolean d() {
        return this.f7393c != null;
    }

    public void e(boolean z2) {
        this.f62a.set(4, z2);
    }

    public boolean e() {
        return this.f62a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof m7)) {
            return m301a((m7) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f7394d != null;
    }

    public boolean g() {
        return this.f7395e != null;
    }

    public boolean h() {
        return this.f60a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f7396f != null;
    }

    public boolean j() {
        return this.f7397g != null;
    }

    public boolean k() {
        return this.f62a.get(1);
    }

    public boolean l() {
        return this.f7398h != null;
    }

    public boolean m() {
        return this.f7399i != null;
    }

    public boolean n() {
        return this.j != null;
    }

    public boolean o() {
        return this.f62a.get(2);
    }

    public boolean p() {
        return this.f62a.get(3);
    }

    public boolean q() {
        return this.k != null;
    }

    public boolean r() {
        return this.l != null;
    }

    public boolean s() {
        return this.f62a.get(4);
    }

    public boolean t() {
        return this.f63a != null;
    }

    public String toString() {
        boolean z2;
        StringBuilder sb = new StringBuilder("XmPushActionAckMessage(");
        boolean z3 = false;
        if (m300a()) {
            sb.append("debug:");
            String str = this.f61a;
            if (str == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str);
            }
            z2 = false;
        } else {
            z2 = true;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            l7 l7Var = this.f59a;
            if (l7Var == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(l7Var);
            }
        } else {
            z3 = z2;
        }
        if (!z3) {
            sb.append(", ");
        }
        sb.append("id:");
        String str2 = this.f7392b;
        if (str2 == null) {
            sb.append(LogUtils.NULL);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f7393c;
        if (str3 == null) {
            sb.append(LogUtils.NULL);
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("messageTs:");
        sb.append(this.f58a);
        if (f()) {
            sb.append(", ");
            sb.append("topic:");
            String str4 = this.f7394d;
            if (str4 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str5 = this.f7395e;
            if (str5 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("request:");
            z7 z7Var = this.f60a;
            if (z7Var == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(z7Var);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f7396f;
            if (str6 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f7397g;
            if (str7 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str7);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("isOnline:");
            sb.append(this.f65a);
        }
        if (l()) {
            sb.append(", ");
            sb.append("regId:");
            String str8 = this.f7398h;
            if (str8 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str8);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("callbackUrl:");
            String str9 = this.f7399i;
            if (str9 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str9);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("userAccount:");
            String str10 = this.j;
            if (str10 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str10);
            }
        }
        if (o()) {
            sb.append(", ");
            sb.append("deviceStatus:");
            sb.append((int) this.f64a);
        }
        if (p()) {
            sb.append(", ");
            sb.append("geoMsgStatus:");
            sb.append((int) this.f66b);
        }
        if (q()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            String str11 = this.k;
            if (str11 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str11);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str12 = this.l;
            if (str12 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str12);
            }
        }
        if (s()) {
            sb.append(", ");
            sb.append("passThrough:");
            sb.append(this.f7391a);
        }
        if (t()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f63a;
            if (map == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(map);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
