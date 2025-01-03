package c.k.d;

import com.shix.shixipc.utilcode.LogUtils;
import java.io.Serializable;
import java.util.BitSet;

/* loaded from: classes.dex */
public class i7 implements i8<i7, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public long f7257a;

    /* renamed from: a, reason: collision with other field name */
    public j7 f36a;

    /* renamed from: a, reason: collision with other field name */
    public l7 f37a;

    /* renamed from: a, reason: collision with other field name */
    public String f38a;

    /* renamed from: a, reason: collision with other field name */
    public BitSet f39a = new BitSet(4);

    /* renamed from: a, reason: collision with other field name */
    public boolean f40a = false;

    /* renamed from: b, reason: collision with root package name */
    public long f7258b;

    /* renamed from: b, reason: collision with other field name */
    public String f41b;

    /* renamed from: c, reason: collision with root package name */
    public long f7259c;

    /* renamed from: c, reason: collision with other field name */
    public String f42c;

    /* renamed from: d, reason: collision with root package name */
    public String f7260d;

    /* renamed from: e, reason: collision with root package name */
    public String f7261e;

    /* renamed from: f, reason: collision with root package name */
    public String f7262f;

    /* renamed from: g, reason: collision with root package name */
    public String f7263g;

    /* renamed from: h, reason: collision with root package name */
    public String f7264h;

    /* renamed from: i, reason: collision with root package name */
    public String f7265i;
    public String j;
    public String k;
    public String l;
    public static final y8 m = new y8("PushMessage");
    public static final q8 n = new q8("", (byte) 12, 1);
    public static final q8 o = new q8("", (byte) 11, 2);
    public static final q8 p = new q8("", (byte) 11, 3);
    public static final q8 q = new q8("", (byte) 11, 4);
    public static final q8 r = new q8("", (byte) 10, 5);
    public static final q8 t = new q8("", (byte) 10, 6);
    public static final q8 u = new q8("", (byte) 11, 7);
    public static final q8 v = new q8("", (byte) 11, 8);
    public static final q8 w = new q8("", (byte) 11, 9);
    public static final q8 x = new q8("", (byte) 11, 10);
    public static final q8 y = new q8("", (byte) 11, 11);
    public static final q8 z = new q8("", (byte) 12, 12);
    public static final q8 A = new q8("", (byte) 11, 13);
    public static final q8 B = new q8("", (byte) 2, 14);
    public static final q8 C = new q8("", (byte) 11, 15);
    public static final q8 D = new q8("", (byte) 10, 16);
    public static final q8 E = new q8("", (byte) 11, 20);
    public static final q8 F = new q8("", (byte) 11, 21);

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(i7 i7Var) {
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
        if (!i7.class.equals(i7Var.getClass())) {
            return i7.class.getName().compareTo(i7Var.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m227a()).compareTo(Boolean.valueOf(i7Var.m227a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m227a() && (a19 = j8.a(this.f37a, i7Var.f37a)) != 0) {
            return a19;
        }
        int compareTo2 = Boolean.valueOf(m229b()).compareTo(Boolean.valueOf(i7Var.m229b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m229b() && (a18 = j8.a(this.f38a, i7Var.f38a)) != 0) {
            return a18;
        }
        int compareTo3 = Boolean.valueOf(m230c()).compareTo(Boolean.valueOf(i7Var.m230c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m230c() && (a17 = j8.a(this.f41b, i7Var.f41b)) != 0) {
            return a17;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(i7Var.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a16 = j8.a(this.f42c, i7Var.f42c)) != 0) {
            return a16;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(i7Var.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a15 = j8.a(this.f7257a, i7Var.f7257a)) != 0) {
            return a15;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(i7Var.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a14 = j8.a(this.f7258b, i7Var.f7258b)) != 0) {
            return a14;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(i7Var.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a13 = j8.a(this.f7260d, i7Var.f7260d)) != 0) {
            return a13;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(i7Var.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a12 = j8.a(this.f7261e, i7Var.f7261e)) != 0) {
            return a12;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(i7Var.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a11 = j8.a(this.f7262f, i7Var.f7262f)) != 0) {
            return a11;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(i7Var.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (a10 = j8.a(this.f7263g, i7Var.f7263g)) != 0) {
            return a10;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(i7Var.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k() && (a9 = j8.a(this.f7264h, i7Var.f7264h)) != 0) {
            return a9;
        }
        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(i7Var.l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (l() && (a8 = j8.a(this.f36a, i7Var.f36a)) != 0) {
            return a8;
        }
        int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(i7Var.m()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (m() && (a7 = j8.a(this.f7265i, i7Var.f7265i)) != 0) {
            return a7;
        }
        int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(i7Var.n()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (n() && (a6 = j8.a(this.f40a, i7Var.f40a)) != 0) {
            return a6;
        }
        int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(i7Var.o()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (o() && (a5 = j8.a(this.j, i7Var.j)) != 0) {
            return a5;
        }
        int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(i7Var.p()));
        if (compareTo16 != 0) {
            return compareTo16;
        }
        if (p() && (a4 = j8.a(this.f7259c, i7Var.f7259c)) != 0) {
            return a4;
        }
        int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(i7Var.q()));
        if (compareTo17 != 0) {
            return compareTo17;
        }
        if (q() && (a3 = j8.a(this.k, i7Var.k)) != 0) {
            return a3;
        }
        int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(i7Var.r()));
        if (compareTo18 != 0) {
            return compareTo18;
        }
        if (!r() || (a2 = j8.a(this.l, i7Var.l)) == 0) {
            return 0;
        }
        return a2;
    }

    public long a() {
        return this.f7257a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m225a() {
        return this.f38a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m226a() {
        if (this.f38a == null) {
            throw new u8("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f41b == null) {
            throw new u8("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f42c != null) {
            return;
        }
        throw new u8("Required field 'payload' was not present! Struct: " + toString());
    }

    @Override // c.k.d.i8
    public void a(t8 t8Var) {
        t8Var.mo347a();
        while (true) {
            q8 mo343a = t8Var.mo343a();
            byte b2 = mo343a.f7785b;
            if (b2 == 0) {
                t8Var.f();
                m226a();
                return;
            }
            short s = mo343a.f7786c;
            if (s == 20) {
                if (b2 == 11) {
                    this.k = t8Var.mo348a();
                    t8Var.g();
                }
                w8.a(t8Var, b2);
                t8Var.g();
            } else if (s != 21) {
                switch (s) {
                    case 1:
                        if (b2 == 12) {
                            l7 l7Var = new l7();
                            this.f37a = l7Var;
                            l7Var.a(t8Var);
                            continue;
                        }
                        break;
                    case 2:
                        if (b2 == 11) {
                            this.f38a = t8Var.mo348a();
                            continue;
                        }
                        break;
                    case 3:
                        if (b2 == 11) {
                            this.f41b = t8Var.mo348a();
                            continue;
                        }
                        break;
                    case 4:
                        if (b2 == 11) {
                            this.f42c = t8Var.mo348a();
                            continue;
                        }
                        break;
                    case 5:
                        if (b2 == 10) {
                            this.f7257a = t8Var.mo342a();
                            a(true);
                            continue;
                        }
                        break;
                    case 6:
                        if (b2 == 10) {
                            this.f7258b = t8Var.mo342a();
                            b(true);
                            continue;
                        }
                        break;
                    case 7:
                        if (b2 == 11) {
                            this.f7260d = t8Var.mo348a();
                            continue;
                        }
                        break;
                    case 8:
                        if (b2 == 11) {
                            this.f7261e = t8Var.mo348a();
                            continue;
                        }
                        break;
                    case 9:
                        if (b2 == 11) {
                            this.f7262f = t8Var.mo348a();
                            continue;
                        }
                        break;
                    case 10:
                        if (b2 == 11) {
                            this.f7263g = t8Var.mo348a();
                            continue;
                        }
                        break;
                    case 11:
                        if (b2 == 11) {
                            this.f7264h = t8Var.mo348a();
                            continue;
                        }
                        break;
                    case 12:
                        if (b2 == 12) {
                            j7 j7Var = new j7();
                            this.f36a = j7Var;
                            j7Var.a(t8Var);
                            continue;
                        }
                        break;
                    case 13:
                        if (b2 == 11) {
                            this.f7265i = t8Var.mo348a();
                            continue;
                        }
                        break;
                    case 14:
                        if (b2 == 2) {
                            this.f40a = t8Var.mo353a();
                            c(true);
                            break;
                        }
                        break;
                    case 15:
                        if (b2 == 11) {
                            this.j = t8Var.mo348a();
                            continue;
                        }
                        break;
                    case 16:
                        if (b2 == 10) {
                            this.f7259c = t8Var.mo342a();
                            d(true);
                            continue;
                        }
                        break;
                }
                w8.a(t8Var, b2);
                t8Var.g();
            } else {
                if (b2 == 11) {
                    this.l = t8Var.mo348a();
                    t8Var.g();
                }
                w8.a(t8Var, b2);
                t8Var.g();
            }
        }
    }

    public void a(boolean z2) {
        this.f39a.set(0, z2);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m227a() {
        return this.f37a != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m228a(i7 i7Var) {
        if (i7Var == null) {
            return false;
        }
        boolean m227a = m227a();
        boolean m227a2 = i7Var.m227a();
        if ((m227a || m227a2) && !(m227a && m227a2 && this.f37a.m287a(i7Var.f37a))) {
            return false;
        }
        boolean m229b = m229b();
        boolean m229b2 = i7Var.m229b();
        if ((m229b || m229b2) && !(m229b && m229b2 && this.f38a.equals(i7Var.f38a))) {
            return false;
        }
        boolean m230c = m230c();
        boolean m230c2 = i7Var.m230c();
        if ((m230c || m230c2) && !(m230c && m230c2 && this.f41b.equals(i7Var.f41b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = i7Var.d();
        if ((d2 || d3) && !(d2 && d3 && this.f42c.equals(i7Var.f42c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = i7Var.e();
        if ((e2 || e3) && !(e2 && e3 && this.f7257a == i7Var.f7257a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = i7Var.f();
        if ((f2 || f3) && !(f2 && f3 && this.f7258b == i7Var.f7258b)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = i7Var.g();
        if ((g2 || g3) && !(g2 && g3 && this.f7260d.equals(i7Var.f7260d))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = i7Var.h();
        if ((h2 || h3) && !(h2 && h3 && this.f7261e.equals(i7Var.f7261e))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = i7Var.i();
        if ((i2 || i3) && !(i2 && i3 && this.f7262f.equals(i7Var.f7262f))) {
            return false;
        }
        boolean j = j();
        boolean j2 = i7Var.j();
        if ((j || j2) && !(j && j2 && this.f7263g.equals(i7Var.f7263g))) {
            return false;
        }
        boolean k = k();
        boolean k2 = i7Var.k();
        if ((k || k2) && !(k && k2 && this.f7264h.equals(i7Var.f7264h))) {
            return false;
        }
        boolean l = l();
        boolean l2 = i7Var.l();
        if ((l || l2) && !(l && l2 && this.f36a.m250a(i7Var.f36a))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = i7Var.m();
        if ((m2 || m3) && !(m2 && m3 && this.f7265i.equals(i7Var.f7265i))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = i7Var.n();
        if ((n2 || n3) && !(n2 && n3 && this.f40a == i7Var.f40a)) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = i7Var.o();
        if ((o2 || o3) && !(o2 && o3 && this.j.equals(i7Var.j))) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = i7Var.p();
        if ((p2 || p3) && !(p2 && p3 && this.f7259c == i7Var.f7259c)) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = i7Var.q();
        if ((q2 || q3) && !(q2 && q3 && this.k.equals(i7Var.k))) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = i7Var.r();
        if (r2 || r3) {
            return r2 && r3 && this.l.equals(i7Var.l);
        }
        return true;
    }

    public String b() {
        return this.f41b;
    }

    @Override // c.k.d.i8
    public void b(t8 t8Var) {
        m226a();
        t8Var.a(m);
        if (this.f37a != null && m227a()) {
            t8Var.a(n);
            this.f37a.b(t8Var);
            t8Var.b();
        }
        if (this.f38a != null) {
            t8Var.a(o);
            t8Var.a(this.f38a);
            t8Var.b();
        }
        if (this.f41b != null) {
            t8Var.a(p);
            t8Var.a(this.f41b);
            t8Var.b();
        }
        if (this.f42c != null) {
            t8Var.a(q);
            t8Var.a(this.f42c);
            t8Var.b();
        }
        if (e()) {
            t8Var.a(r);
            t8Var.a(this.f7257a);
            t8Var.b();
        }
        if (f()) {
            t8Var.a(t);
            t8Var.a(this.f7258b);
            t8Var.b();
        }
        if (this.f7260d != null && g()) {
            t8Var.a(u);
            t8Var.a(this.f7260d);
            t8Var.b();
        }
        if (this.f7261e != null && h()) {
            t8Var.a(v);
            t8Var.a(this.f7261e);
            t8Var.b();
        }
        if (this.f7262f != null && i()) {
            t8Var.a(w);
            t8Var.a(this.f7262f);
            t8Var.b();
        }
        if (this.f7263g != null && j()) {
            t8Var.a(x);
            t8Var.a(this.f7263g);
            t8Var.b();
        }
        if (this.f7264h != null && k()) {
            t8Var.a(y);
            t8Var.a(this.f7264h);
            t8Var.b();
        }
        if (this.f36a != null && l()) {
            t8Var.a(z);
            this.f36a.b(t8Var);
            t8Var.b();
        }
        if (this.f7265i != null && m()) {
            t8Var.a(A);
            t8Var.a(this.f7265i);
            t8Var.b();
        }
        if (n()) {
            t8Var.a(B);
            t8Var.a(this.f40a);
            t8Var.b();
        }
        if (this.j != null && o()) {
            t8Var.a(C);
            t8Var.a(this.j);
            t8Var.b();
        }
        if (p()) {
            t8Var.a(D);
            t8Var.a(this.f7259c);
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
        t8Var.c();
        t8Var.mo351a();
    }

    public void b(boolean z2) {
        this.f39a.set(1, z2);
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m229b() {
        return this.f38a != null;
    }

    public String c() {
        return this.f42c;
    }

    public void c(boolean z2) {
        this.f39a.set(2, z2);
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m230c() {
        return this.f41b != null;
    }

    public void d(boolean z2) {
        this.f39a.set(3, z2);
    }

    public boolean d() {
        return this.f42c != null;
    }

    public boolean e() {
        return this.f39a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof i7)) {
            return m228a((i7) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f39a.get(1);
    }

    public boolean g() {
        return this.f7260d != null;
    }

    public boolean h() {
        return this.f7261e != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f7262f != null;
    }

    public boolean j() {
        return this.f7263g != null;
    }

    public boolean k() {
        return this.f7264h != null;
    }

    public boolean l() {
        return this.f36a != null;
    }

    public boolean m() {
        return this.f7265i != null;
    }

    public boolean n() {
        return this.f39a.get(2);
    }

    public boolean o() {
        return this.j != null;
    }

    public boolean p() {
        return this.f39a.get(3);
    }

    public boolean q() {
        return this.k != null;
    }

    public boolean r() {
        return this.l != null;
    }

    public String toString() {
        boolean z2;
        StringBuilder sb = new StringBuilder("PushMessage(");
        if (m227a()) {
            sb.append("to:");
            l7 l7Var = this.f37a;
            if (l7Var == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(l7Var);
            }
            z2 = false;
        } else {
            z2 = true;
        }
        if (!z2) {
            sb.append(", ");
        }
        sb.append("id:");
        String str = this.f38a;
        if (str == null) {
            sb.append(LogUtils.NULL);
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("appId:");
        String str2 = this.f41b;
        if (str2 == null) {
            sb.append(LogUtils.NULL);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("payload:");
        String str3 = this.f42c;
        if (str3 == null) {
            sb.append(LogUtils.NULL);
        } else {
            sb.append(str3);
        }
        if (e()) {
            sb.append(", ");
            sb.append("createAt:");
            sb.append(this.f7257a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("ttl:");
            sb.append(this.f7258b);
        }
        if (g()) {
            sb.append(", ");
            sb.append("collapseKey:");
            String str4 = this.f7260d;
            if (str4 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str4);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f7261e;
            if (str5 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str5);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("regId:");
            String str6 = this.f7262f;
            if (str6 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f7263g;
            if (str7 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str7);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("topic:");
            String str8 = this.f7264h;
            if (str8 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str8);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("metaInfo:");
            j7 j7Var = this.f36a;
            if (j7Var == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(j7Var);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str9 = this.f7265i;
            if (str9 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str9);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("isOnline:");
            sb.append(this.f40a);
        }
        if (o()) {
            sb.append(", ");
            sb.append("userAccount:");
            String str10 = this.j;
            if (str10 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str10);
            }
        }
        if (p()) {
            sb.append(", ");
            sb.append("miid:");
            sb.append(this.f7259c);
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
        sb.append(")");
        return sb.toString();
    }
}
