package c.k.d;

import com.shix.shixipc.utilcode.LogUtils;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class w7 implements i8<w7, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public int f7986a;

    /* renamed from: a, reason: collision with other field name */
    public long f109a;

    /* renamed from: a, reason: collision with other field name */
    public k7 f110a;

    /* renamed from: a, reason: collision with other field name */
    public l7 f111a;

    /* renamed from: a, reason: collision with other field name */
    public String f112a;

    /* renamed from: a, reason: collision with other field name */
    public Map<String, String> f114a;

    /* renamed from: b, reason: collision with root package name */
    public int f7987b;

    /* renamed from: b, reason: collision with other field name */
    public long f116b;

    /* renamed from: b, reason: collision with other field name */
    public String f117b;

    /* renamed from: c, reason: collision with root package name */
    public int f7988c;

    /* renamed from: c, reason: collision with other field name */
    public String f119c;

    /* renamed from: d, reason: collision with root package name */
    public String f7989d;

    /* renamed from: e, reason: collision with root package name */
    public String f7990e;

    /* renamed from: f, reason: collision with root package name */
    public String f7991f;

    /* renamed from: g, reason: collision with root package name */
    public String f7992g;

    /* renamed from: h, reason: collision with root package name */
    public String f7993h;

    /* renamed from: i, reason: collision with root package name */
    public String f7994i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public static final y8 t = new y8("XmPushActionRegistration");
    public static final q8 u = new q8("", (byte) 11, 1);
    public static final q8 v = new q8("", (byte) 12, 2);
    public static final q8 w = new q8("", (byte) 11, 3);
    public static final q8 x = new q8("", (byte) 11, 4);
    public static final q8 y = new q8("", (byte) 11, 5);
    public static final q8 z = new q8("", (byte) 11, 6);
    public static final q8 A = new q8("", (byte) 11, 7);
    public static final q8 B = new q8("", (byte) 11, 8);
    public static final q8 C = new q8("", (byte) 11, 9);
    public static final q8 D = new q8("", (byte) 11, 10);
    public static final q8 E = new q8("", (byte) 11, 11);
    public static final q8 F = new q8("", (byte) 11, 12);
    public static final q8 G = new q8("", (byte) 8, 13);
    public static final q8 H = new q8("", (byte) 8, 14);
    public static final q8 I = new q8("", (byte) 11, 15);
    public static final q8 J = new q8("", (byte) 11, 16);
    public static final q8 K = new q8("", (byte) 11, 17);
    public static final q8 L = new q8("", (byte) 11, 18);
    public static final q8 M = new q8("", (byte) 8, 19);
    public static final q8 N = new q8("", (byte) 8, 20);
    public static final q8 O = new q8("", (byte) 2, 21);
    public static final q8 P = new q8("", (byte) 10, 22);
    public static final q8 Q = new q8("", (byte) 10, 23);
    public static final q8 R = new q8("", (byte) 11, 24);
    public static final q8 S = new q8("", (byte) 11, 25);
    public static final q8 T = new q8("", (byte) 13, 100);
    public static final q8 U = new q8("", (byte) 2, 101);
    public static final q8 V = new q8("", (byte) 11, 102);

    /* renamed from: a, reason: collision with other field name */
    public BitSet f113a = new BitSet(7);

    /* renamed from: a, reason: collision with other field name */
    public boolean f115a = true;

    /* renamed from: b, reason: collision with other field name */
    public boolean f118b = false;

    public boolean A() {
        return this.f113a.get(6);
    }

    public boolean B() {
        return this.r != null;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(w7 w7Var) {
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
        int a22;
        int a23;
        int a24;
        int a25;
        int a26;
        int a27;
        int a28;
        int a29;
        if (!w7.class.equals(w7Var.getClass())) {
            return w7.class.getName().compareTo(w7Var.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m518a()).compareTo(Boolean.valueOf(w7Var.m518a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m518a() && (a29 = j8.a(this.f112a, w7Var.f112a)) != 0) {
            return a29;
        }
        int compareTo2 = Boolean.valueOf(m520b()).compareTo(Boolean.valueOf(w7Var.m520b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m520b() && (a28 = j8.a(this.f111a, w7Var.f111a)) != 0) {
            return a28;
        }
        int compareTo3 = Boolean.valueOf(m521c()).compareTo(Boolean.valueOf(w7Var.m521c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m521c() && (a27 = j8.a(this.f117b, w7Var.f117b)) != 0) {
            return a27;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(w7Var.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a26 = j8.a(this.f119c, w7Var.f119c)) != 0) {
            return a26;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(w7Var.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a25 = j8.a(this.f7989d, w7Var.f7989d)) != 0) {
            return a25;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(w7Var.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a24 = j8.a(this.f7990e, w7Var.f7990e)) != 0) {
            return a24;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(w7Var.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a23 = j8.a(this.f7991f, w7Var.f7991f)) != 0) {
            return a23;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(w7Var.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a22 = j8.a(this.f7992g, w7Var.f7992g)) != 0) {
            return a22;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(w7Var.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a21 = j8.a(this.f7993h, w7Var.f7993h)) != 0) {
            return a21;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(w7Var.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (a20 = j8.a(this.f7994i, w7Var.f7994i)) != 0) {
            return a20;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(w7Var.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k() && (a19 = j8.a(this.j, w7Var.j)) != 0) {
            return a19;
        }
        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(w7Var.l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (l() && (a18 = j8.a(this.k, w7Var.k)) != 0) {
            return a18;
        }
        int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(w7Var.m()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (m() && (a17 = j8.a(this.f7986a, w7Var.f7986a)) != 0) {
            return a17;
        }
        int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(w7Var.n()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (n() && (a16 = j8.a(this.f7987b, w7Var.f7987b)) != 0) {
            return a16;
        }
        int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(w7Var.o()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (o() && (a15 = j8.a(this.l, w7Var.l)) != 0) {
            return a15;
        }
        int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(w7Var.p()));
        if (compareTo16 != 0) {
            return compareTo16;
        }
        if (p() && (a14 = j8.a(this.m, w7Var.m)) != 0) {
            return a14;
        }
        int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(w7Var.q()));
        if (compareTo17 != 0) {
            return compareTo17;
        }
        if (q() && (a13 = j8.a(this.n, w7Var.n)) != 0) {
            return a13;
        }
        int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(w7Var.r()));
        if (compareTo18 != 0) {
            return compareTo18;
        }
        if (r() && (a12 = j8.a(this.o, w7Var.o)) != 0) {
            return a12;
        }
        int compareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(w7Var.s()));
        if (compareTo19 != 0) {
            return compareTo19;
        }
        if (s() && (a11 = j8.a(this.f7988c, w7Var.f7988c)) != 0) {
            return a11;
        }
        int compareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(w7Var.t()));
        if (compareTo20 != 0) {
            return compareTo20;
        }
        if (t() && (a10 = j8.a(this.f110a, w7Var.f110a)) != 0) {
            return a10;
        }
        int compareTo21 = Boolean.valueOf(u()).compareTo(Boolean.valueOf(w7Var.u()));
        if (compareTo21 != 0) {
            return compareTo21;
        }
        if (u() && (a9 = j8.a(this.f115a, w7Var.f115a)) != 0) {
            return a9;
        }
        int compareTo22 = Boolean.valueOf(v()).compareTo(Boolean.valueOf(w7Var.v()));
        if (compareTo22 != 0) {
            return compareTo22;
        }
        if (v() && (a8 = j8.a(this.f109a, w7Var.f109a)) != 0) {
            return a8;
        }
        int compareTo23 = Boolean.valueOf(w()).compareTo(Boolean.valueOf(w7Var.w()));
        if (compareTo23 != 0) {
            return compareTo23;
        }
        if (w() && (a7 = j8.a(this.f116b, w7Var.f116b)) != 0) {
            return a7;
        }
        int compareTo24 = Boolean.valueOf(x()).compareTo(Boolean.valueOf(w7Var.x()));
        if (compareTo24 != 0) {
            return compareTo24;
        }
        if (x() && (a6 = j8.a(this.p, w7Var.p)) != 0) {
            return a6;
        }
        int compareTo25 = Boolean.valueOf(y()).compareTo(Boolean.valueOf(w7Var.y()));
        if (compareTo25 != 0) {
            return compareTo25;
        }
        if (y() && (a5 = j8.a(this.q, w7Var.q)) != 0) {
            return a5;
        }
        int compareTo26 = Boolean.valueOf(z()).compareTo(Boolean.valueOf(w7Var.z()));
        if (compareTo26 != 0) {
            return compareTo26;
        }
        if (z() && (a4 = j8.a(this.f114a, w7Var.f114a)) != 0) {
            return a4;
        }
        int compareTo27 = Boolean.valueOf(A()).compareTo(Boolean.valueOf(w7Var.A()));
        if (compareTo27 != 0) {
            return compareTo27;
        }
        if (A() && (a3 = j8.a(this.f118b, w7Var.f118b)) != 0) {
            return a3;
        }
        int compareTo28 = Boolean.valueOf(B()).compareTo(Boolean.valueOf(w7Var.B()));
        if (compareTo28 != 0) {
            return compareTo28;
        }
        if (!B() || (a2 = j8.a(this.r, w7Var.r)) == 0) {
            return 0;
        }
        return a2;
    }

    public w7 a(int i2) {
        this.f7986a = i2;
        a(true);
        return this;
    }

    public w7 a(k7 k7Var) {
        this.f110a = k7Var;
        return this;
    }

    public w7 a(String str) {
        this.f117b = str;
        return this;
    }

    public String a() {
        return this.f117b;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m517a() {
        if (this.f117b == null) {
            throw new u8("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f119c == null) {
            throw new u8("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f7991f != null) {
            return;
        }
        throw new u8("Required field 'token' was not present! Struct: " + toString());
    }

    @Override // c.k.d.i8
    public void a(t8 t8Var) {
        t8Var.mo347a();
        while (true) {
            q8 mo343a = t8Var.mo343a();
            byte b2 = mo343a.f7785b;
            if (b2 == 0) {
                t8Var.f();
                m517a();
                return;
            }
            short s = mo343a.f7786c;
            switch (s) {
                case 1:
                    if (b2 == 11) {
                        this.f112a = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        l7 l7Var = new l7();
                        this.f111a = l7Var;
                        l7Var.a(t8Var);
                        break;
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f117b = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f119c = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f7989d = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f7990e = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f7991f = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f7992g = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f7993h = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f7994i = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 11:
                    if (b2 == 11) {
                        this.j = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.k = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 13:
                    if (b2 == 8) {
                        this.f7986a = t8Var.mo341a();
                        a(true);
                        continue;
                    }
                    break;
                case 14:
                    if (b2 == 8) {
                        this.f7987b = t8Var.mo341a();
                        b(true);
                        continue;
                    }
                    break;
                case 15:
                    if (b2 == 11) {
                        this.l = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 16:
                    if (b2 == 11) {
                        this.m = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 17:
                    if (b2 == 11) {
                        this.n = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 18:
                    if (b2 == 11) {
                        this.o = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 19:
                    if (b2 == 8) {
                        this.f7988c = t8Var.mo341a();
                        c(true);
                        continue;
                    }
                    break;
                case 20:
                    if (b2 == 8) {
                        this.f110a = k7.a(t8Var.mo341a());
                        continue;
                    }
                    break;
                case 21:
                    if (b2 == 2) {
                        this.f115a = t8Var.mo353a();
                        d(true);
                        continue;
                    }
                    break;
                case 22:
                    if (b2 == 10) {
                        this.f109a = t8Var.mo342a();
                        e(true);
                        continue;
                    }
                    break;
                case 23:
                    if (b2 == 10) {
                        this.f116b = t8Var.mo342a();
                        f(true);
                        continue;
                    }
                    break;
                case 24:
                    if (b2 == 11) {
                        this.p = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 25:
                    if (b2 == 11) {
                        this.q = t8Var.mo348a();
                        continue;
                    }
                    break;
                default:
                    switch (s) {
                        case 100:
                            if (b2 == 13) {
                                s8 mo345a = t8Var.mo345a();
                                this.f114a = new HashMap(mo345a.f7854c * 2);
                                for (int i2 = 0; i2 < mo345a.f7854c; i2++) {
                                    this.f114a.put(t8Var.mo348a(), t8Var.mo348a());
                                }
                                t8Var.h();
                                break;
                            }
                            break;
                        case 101:
                            if (b2 == 2) {
                                this.f118b = t8Var.mo353a();
                                g(true);
                                continue;
                            }
                            break;
                        case 102:
                            if (b2 == 11) {
                                this.r = t8Var.mo348a();
                                continue;
                            }
                            break;
                    }
            }
            w8.a(t8Var, b2);
            t8Var.g();
        }
    }

    public void a(boolean z2) {
        this.f113a.set(0, z2);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m518a() {
        return this.f112a != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m519a(w7 w7Var) {
        if (w7Var == null) {
            return false;
        }
        boolean m518a = m518a();
        boolean m518a2 = w7Var.m518a();
        if ((m518a || m518a2) && !(m518a && m518a2 && this.f112a.equals(w7Var.f112a))) {
            return false;
        }
        boolean m520b = m520b();
        boolean m520b2 = w7Var.m520b();
        if ((m520b || m520b2) && !(m520b && m520b2 && this.f111a.m287a(w7Var.f111a))) {
            return false;
        }
        boolean m521c = m521c();
        boolean m521c2 = w7Var.m521c();
        if ((m521c || m521c2) && !(m521c && m521c2 && this.f117b.equals(w7Var.f117b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = w7Var.d();
        if ((d2 || d3) && !(d2 && d3 && this.f119c.equals(w7Var.f119c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = w7Var.e();
        if ((e2 || e3) && !(e2 && e3 && this.f7989d.equals(w7Var.f7989d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = w7Var.f();
        if ((f2 || f3) && !(f2 && f3 && this.f7990e.equals(w7Var.f7990e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = w7Var.g();
        if ((g2 || g3) && !(g2 && g3 && this.f7991f.equals(w7Var.f7991f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = w7Var.h();
        if ((h2 || h3) && !(h2 && h3 && this.f7992g.equals(w7Var.f7992g))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = w7Var.i();
        if ((i2 || i3) && !(i2 && i3 && this.f7993h.equals(w7Var.f7993h))) {
            return false;
        }
        boolean j = j();
        boolean j2 = w7Var.j();
        if ((j || j2) && !(j && j2 && this.f7994i.equals(w7Var.f7994i))) {
            return false;
        }
        boolean k = k();
        boolean k2 = w7Var.k();
        if ((k || k2) && !(k && k2 && this.j.equals(w7Var.j))) {
            return false;
        }
        boolean l = l();
        boolean l2 = w7Var.l();
        if ((l || l2) && !(l && l2 && this.k.equals(w7Var.k))) {
            return false;
        }
        boolean m = m();
        boolean m2 = w7Var.m();
        if ((m || m2) && !(m && m2 && this.f7986a == w7Var.f7986a)) {
            return false;
        }
        boolean n = n();
        boolean n2 = w7Var.n();
        if ((n || n2) && !(n && n2 && this.f7987b == w7Var.f7987b)) {
            return false;
        }
        boolean o = o();
        boolean o2 = w7Var.o();
        if ((o || o2) && !(o && o2 && this.l.equals(w7Var.l))) {
            return false;
        }
        boolean p = p();
        boolean p2 = w7Var.p();
        if ((p || p2) && !(p && p2 && this.m.equals(w7Var.m))) {
            return false;
        }
        boolean q = q();
        boolean q2 = w7Var.q();
        if ((q || q2) && !(q && q2 && this.n.equals(w7Var.n))) {
            return false;
        }
        boolean r = r();
        boolean r2 = w7Var.r();
        if ((r || r2) && !(r && r2 && this.o.equals(w7Var.o))) {
            return false;
        }
        boolean s = s();
        boolean s2 = w7Var.s();
        if ((s || s2) && !(s && s2 && this.f7988c == w7Var.f7988c)) {
            return false;
        }
        boolean t2 = t();
        boolean t3 = w7Var.t();
        if ((t2 || t3) && !(t2 && t3 && this.f110a.equals(w7Var.f110a))) {
            return false;
        }
        boolean u2 = u();
        boolean u3 = w7Var.u();
        if ((u2 || u3) && !(u2 && u3 && this.f115a == w7Var.f115a)) {
            return false;
        }
        boolean v2 = v();
        boolean v3 = w7Var.v();
        if ((v2 || v3) && !(v2 && v3 && this.f109a == w7Var.f109a)) {
            return false;
        }
        boolean w2 = w();
        boolean w3 = w7Var.w();
        if ((w2 || w3) && !(w2 && w3 && this.f116b == w7Var.f116b)) {
            return false;
        }
        boolean x2 = x();
        boolean x3 = w7Var.x();
        if ((x2 || x3) && !(x2 && x3 && this.p.equals(w7Var.p))) {
            return false;
        }
        boolean y2 = y();
        boolean y3 = w7Var.y();
        if ((y2 || y3) && !(y2 && y3 && this.q.equals(w7Var.q))) {
            return false;
        }
        boolean z2 = z();
        boolean z3 = w7Var.z();
        if ((z2 || z3) && !(z2 && z3 && this.f114a.equals(w7Var.f114a))) {
            return false;
        }
        boolean A2 = A();
        boolean A3 = w7Var.A();
        if ((A2 || A3) && !(A2 && A3 && this.f118b == w7Var.f118b)) {
            return false;
        }
        boolean B2 = B();
        boolean B3 = w7Var.B();
        if (B2 || B3) {
            return B2 && B3 && this.r.equals(w7Var.r);
        }
        return true;
    }

    public w7 b(int i2) {
        this.f7987b = i2;
        b(true);
        return this;
    }

    public w7 b(String str) {
        this.f119c = str;
        return this;
    }

    public String b() {
        return this.f119c;
    }

    @Override // c.k.d.i8
    public void b(t8 t8Var) {
        m517a();
        t8Var.a(t);
        if (this.f112a != null && m518a()) {
            t8Var.a(u);
            t8Var.a(this.f112a);
            t8Var.b();
        }
        if (this.f111a != null && m520b()) {
            t8Var.a(v);
            this.f111a.b(t8Var);
            t8Var.b();
        }
        if (this.f117b != null) {
            t8Var.a(w);
            t8Var.a(this.f117b);
            t8Var.b();
        }
        if (this.f119c != null) {
            t8Var.a(x);
            t8Var.a(this.f119c);
            t8Var.b();
        }
        if (this.f7989d != null && e()) {
            t8Var.a(y);
            t8Var.a(this.f7989d);
            t8Var.b();
        }
        if (this.f7990e != null && f()) {
            t8Var.a(z);
            t8Var.a(this.f7990e);
            t8Var.b();
        }
        if (this.f7991f != null) {
            t8Var.a(A);
            t8Var.a(this.f7991f);
            t8Var.b();
        }
        if (this.f7992g != null && h()) {
            t8Var.a(B);
            t8Var.a(this.f7992g);
            t8Var.b();
        }
        if (this.f7993h != null && i()) {
            t8Var.a(C);
            t8Var.a(this.f7993h);
            t8Var.b();
        }
        if (this.f7994i != null && j()) {
            t8Var.a(D);
            t8Var.a(this.f7994i);
            t8Var.b();
        }
        if (this.j != null && k()) {
            t8Var.a(E);
            t8Var.a(this.j);
            t8Var.b();
        }
        if (this.k != null && l()) {
            t8Var.a(F);
            t8Var.a(this.k);
            t8Var.b();
        }
        if (m()) {
            t8Var.a(G);
            t8Var.mo352a(this.f7986a);
            t8Var.b();
        }
        if (n()) {
            t8Var.a(H);
            t8Var.mo352a(this.f7987b);
            t8Var.b();
        }
        if (this.l != null && o()) {
            t8Var.a(I);
            t8Var.a(this.l);
            t8Var.b();
        }
        if (this.m != null && p()) {
            t8Var.a(J);
            t8Var.a(this.m);
            t8Var.b();
        }
        if (this.n != null && q()) {
            t8Var.a(K);
            t8Var.a(this.n);
            t8Var.b();
        }
        if (this.o != null && r()) {
            t8Var.a(L);
            t8Var.a(this.o);
            t8Var.b();
        }
        if (s()) {
            t8Var.a(M);
            t8Var.mo352a(this.f7988c);
            t8Var.b();
        }
        if (this.f110a != null && t()) {
            t8Var.a(N);
            t8Var.mo352a(this.f110a.a());
            t8Var.b();
        }
        if (u()) {
            t8Var.a(O);
            t8Var.a(this.f115a);
            t8Var.b();
        }
        if (v()) {
            t8Var.a(P);
            t8Var.a(this.f109a);
            t8Var.b();
        }
        if (w()) {
            t8Var.a(Q);
            t8Var.a(this.f116b);
            t8Var.b();
        }
        if (this.p != null && x()) {
            t8Var.a(R);
            t8Var.a(this.p);
            t8Var.b();
        }
        if (this.q != null && y()) {
            t8Var.a(S);
            t8Var.a(this.q);
            t8Var.b();
        }
        if (this.f114a != null && z()) {
            t8Var.a(T);
            t8Var.a(new s8((byte) 11, (byte) 11, this.f114a.size()));
            for (Map.Entry<String, String> entry : this.f114a.entrySet()) {
                t8Var.a(entry.getKey());
                t8Var.a(entry.getValue());
            }
            t8Var.d();
            t8Var.b();
        }
        if (A()) {
            t8Var.a(U);
            t8Var.a(this.f118b);
            t8Var.b();
        }
        if (this.r != null && B()) {
            t8Var.a(V);
            t8Var.a(this.r);
            t8Var.b();
        }
        t8Var.c();
        t8Var.mo351a();
    }

    public void b(boolean z2) {
        this.f113a.set(1, z2);
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m520b() {
        return this.f111a != null;
    }

    public w7 c(int i2) {
        this.f7988c = i2;
        c(true);
        return this;
    }

    public w7 c(String str) {
        this.f7989d = str;
        return this;
    }

    public String c() {
        return this.f7991f;
    }

    public void c(boolean z2) {
        this.f113a.set(2, z2);
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m521c() {
        return this.f117b != null;
    }

    public w7 d(String str) {
        this.f7990e = str;
        return this;
    }

    public void d(boolean z2) {
        this.f113a.set(3, z2);
    }

    public boolean d() {
        return this.f119c != null;
    }

    public w7 e(String str) {
        this.f7991f = str;
        return this;
    }

    public void e(boolean z2) {
        this.f113a.set(4, z2);
    }

    public boolean e() {
        return this.f7989d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof w7)) {
            return m519a((w7) obj);
        }
        return false;
    }

    public w7 f(String str) {
        this.f7992g = str;
        return this;
    }

    public void f(boolean z2) {
        this.f113a.set(5, z2);
    }

    public boolean f() {
        return this.f7990e != null;
    }

    public w7 g(String str) {
        this.f7993h = str;
        return this;
    }

    public void g(boolean z2) {
        this.f113a.set(6, z2);
    }

    public boolean g() {
        return this.f7991f != null;
    }

    public w7 h(String str) {
        this.k = str;
        return this;
    }

    public boolean h() {
        return this.f7992g != null;
    }

    public int hashCode() {
        return 0;
    }

    public w7 i(String str) {
        this.l = str;
        return this;
    }

    public boolean i() {
        return this.f7993h != null;
    }

    public w7 j(String str) {
        this.n = str;
        return this;
    }

    public boolean j() {
        return this.f7994i != null;
    }

    public w7 k(String str) {
        this.o = str;
        return this;
    }

    public boolean k() {
        return this.j != null;
    }

    public boolean l() {
        return this.k != null;
    }

    public boolean m() {
        return this.f113a.get(0);
    }

    public boolean n() {
        return this.f113a.get(1);
    }

    public boolean o() {
        return this.l != null;
    }

    public boolean p() {
        return this.m != null;
    }

    public boolean q() {
        return this.n != null;
    }

    public boolean r() {
        return this.o != null;
    }

    public boolean s() {
        return this.f113a.get(2);
    }

    public boolean t() {
        return this.f110a != null;
    }

    public String toString() {
        boolean z2;
        StringBuilder sb = new StringBuilder("XmPushActionRegistration(");
        boolean z3 = false;
        if (m518a()) {
            sb.append("debug:");
            String str = this.f112a;
            if (str == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str);
            }
            z2 = false;
        } else {
            z2 = true;
        }
        if (m520b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            l7 l7Var = this.f111a;
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
        String str2 = this.f117b;
        if (str2 == null) {
            sb.append(LogUtils.NULL);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f119c;
        if (str3 == null) {
            sb.append(LogUtils.NULL);
        } else {
            sb.append(str3);
        }
        if (e()) {
            sb.append(", ");
            sb.append("appVersion:");
            String str4 = this.f7989d;
            if (str4 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f7990e;
            if (str5 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str5);
            }
        }
        sb.append(", ");
        sb.append("token:");
        String str6 = this.f7991f;
        if (str6 == null) {
            sb.append(LogUtils.NULL);
        } else {
            sb.append(str6);
        }
        if (h()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str7 = this.f7992g;
            if (str7 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str7);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str8 = this.f7993h;
            if (str8 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str8);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("sdkVersion:");
            String str9 = this.f7994i;
            if (str9 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str9);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("regId:");
            String str10 = this.j;
            if (str10 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str10);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("pushSdkVersionName:");
            String str11 = this.k;
            if (str11 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str11);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("pushSdkVersionCode:");
            sb.append(this.f7986a);
        }
        if (n()) {
            sb.append(", ");
            sb.append("appVersionCode:");
            sb.append(this.f7987b);
        }
        if (o()) {
            sb.append(", ");
            sb.append("androidId:");
            String str12 = this.l;
            if (str12 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str12);
            }
        }
        if (p()) {
            sb.append(", ");
            sb.append("imei:");
            String str13 = this.m;
            if (str13 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str13);
            }
        }
        if (q()) {
            sb.append(", ");
            sb.append("serial:");
            String str14 = this.n;
            if (str14 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str14);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            String str15 = this.o;
            if (str15 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str15);
            }
        }
        if (s()) {
            sb.append(", ");
            sb.append("spaceId:");
            sb.append(this.f7988c);
        }
        if (t()) {
            sb.append(", ");
            sb.append("reason:");
            k7 k7Var = this.f110a;
            if (k7Var == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(k7Var);
            }
        }
        if (u()) {
            sb.append(", ");
            sb.append("validateToken:");
            sb.append(this.f115a);
        }
        if (v()) {
            sb.append(", ");
            sb.append("miid:");
            sb.append(this.f109a);
        }
        if (w()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f116b);
        }
        if (x()) {
            sb.append(", ");
            sb.append("subImei:");
            String str16 = this.p;
            if (str16 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str16);
            }
        }
        if (y()) {
            sb.append(", ");
            sb.append("subImeiMd5:");
            String str17 = this.q;
            if (str17 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str17);
            }
        }
        if (z()) {
            sb.append(", ");
            sb.append("connectionAttrs:");
            Map<String, String> map = this.f114a;
            if (map == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(map);
            }
        }
        if (A()) {
            sb.append(", ");
            sb.append("cleanOldRegInfo:");
            sb.append(this.f118b);
        }
        if (B()) {
            sb.append(", ");
            sb.append("oldRegId:");
            String str18 = this.r;
            if (str18 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str18);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public boolean u() {
        return this.f113a.get(3);
    }

    public boolean v() {
        return this.f113a.get(4);
    }

    public boolean w() {
        return this.f113a.get(5);
    }

    public boolean x() {
        return this.p != null;
    }

    public boolean y() {
        return this.q != null;
    }

    public boolean z() {
        return this.f114a != null;
    }
}
