package c.k.d;

import com.shix.shixipc.utilcode.LogUtils;
import java.io.Serializable;
import java.util.BitSet;

/* loaded from: classes.dex */
public class x7 implements i8<x7, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public int f8015a;

    /* renamed from: a, reason: collision with other field name */
    public long f121a;

    /* renamed from: a, reason: collision with other field name */
    public l7 f122a;

    /* renamed from: a, reason: collision with other field name */
    public String f123a;

    /* renamed from: a, reason: collision with other field name */
    public BitSet f124a = new BitSet(5);

    /* renamed from: b, reason: collision with root package name */
    public int f8016b;

    /* renamed from: b, reason: collision with other field name */
    public long f125b;

    /* renamed from: b, reason: collision with other field name */
    public String f126b;

    /* renamed from: c, reason: collision with root package name */
    public long f8017c;

    /* renamed from: c, reason: collision with other field name */
    public String f127c;

    /* renamed from: d, reason: collision with root package name */
    public String f8018d;

    /* renamed from: e, reason: collision with root package name */
    public String f8019e;

    /* renamed from: f, reason: collision with root package name */
    public String f8020f;

    /* renamed from: g, reason: collision with root package name */
    public String f8021g;

    /* renamed from: h, reason: collision with root package name */
    public String f8022h;

    /* renamed from: i, reason: collision with root package name */
    public String f8023i;
    public String j;
    public String k;
    public String l;
    public static final y8 m = new y8("XmPushActionRegistrationResult");
    public static final q8 n = new q8("", (byte) 11, 1);
    public static final q8 o = new q8("", (byte) 12, 2);
    public static final q8 p = new q8("", (byte) 11, 3);
    public static final q8 q = new q8("", (byte) 11, 4);
    public static final q8 r = new q8("", (byte) 10, 6);
    public static final q8 t = new q8("", (byte) 11, 7);
    public static final q8 u = new q8("", (byte) 11, 8);
    public static final q8 v = new q8("", (byte) 11, 9);
    public static final q8 w = new q8("", (byte) 11, 10);
    public static final q8 x = new q8("", (byte) 10, 11);
    public static final q8 y = new q8("", (byte) 11, 12);
    public static final q8 z = new q8("", (byte) 11, 13);
    public static final q8 A = new q8("", (byte) 10, 14);
    public static final q8 B = new q8("", (byte) 11, 15);
    public static final q8 C = new q8("", (byte) 8, 16);
    public static final q8 D = new q8("", (byte) 11, 17);
    public static final q8 E = new q8("", (byte) 8, 18);
    public static final q8 F = new q8("", (byte) 11, 19);

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(x7 x7Var) {
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
        if (!x7.class.equals(x7Var.getClass())) {
            return x7.class.getName().compareTo(x7Var.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m530a()).compareTo(Boolean.valueOf(x7Var.m530a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m530a() && (a19 = j8.a(this.f123a, x7Var.f123a)) != 0) {
            return a19;
        }
        int compareTo2 = Boolean.valueOf(m532b()).compareTo(Boolean.valueOf(x7Var.m532b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m532b() && (a18 = j8.a(this.f122a, x7Var.f122a)) != 0) {
            return a18;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(x7Var.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a17 = j8.a(this.f126b, x7Var.f126b)) != 0) {
            return a17;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(x7Var.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a16 = j8.a(this.f127c, x7Var.f127c)) != 0) {
            return a16;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(x7Var.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a15 = j8.a(this.f121a, x7Var.f121a)) != 0) {
            return a15;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(x7Var.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a14 = j8.a(this.f8018d, x7Var.f8018d)) != 0) {
            return a14;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(x7Var.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a13 = j8.a(this.f8019e, x7Var.f8019e)) != 0) {
            return a13;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(x7Var.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a12 = j8.a(this.f8020f, x7Var.f8020f)) != 0) {
            return a12;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(x7Var.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a11 = j8.a(this.f8021g, x7Var.f8021g)) != 0) {
            return a11;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(x7Var.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (a10 = j8.a(this.f125b, x7Var.f125b)) != 0) {
            return a10;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(x7Var.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k() && (a9 = j8.a(this.f8022h, x7Var.f8022h)) != 0) {
            return a9;
        }
        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(x7Var.l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (l() && (a8 = j8.a(this.f8023i, x7Var.f8023i)) != 0) {
            return a8;
        }
        int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(x7Var.m()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (m() && (a7 = j8.a(this.f8017c, x7Var.f8017c)) != 0) {
            return a7;
        }
        int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(x7Var.n()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (n() && (a6 = j8.a(this.j, x7Var.j)) != 0) {
            return a6;
        }
        int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(x7Var.o()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (o() && (a5 = j8.a(this.f8015a, x7Var.f8015a)) != 0) {
            return a5;
        }
        int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(x7Var.p()));
        if (compareTo16 != 0) {
            return compareTo16;
        }
        if (p() && (a4 = j8.a(this.k, x7Var.k)) != 0) {
            return a4;
        }
        int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(x7Var.q()));
        if (compareTo17 != 0) {
            return compareTo17;
        }
        if (q() && (a3 = j8.a(this.f8016b, x7Var.f8016b)) != 0) {
            return a3;
        }
        int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(x7Var.r()));
        if (compareTo18 != 0) {
            return compareTo18;
        }
        if (!r() || (a2 = j8.a(this.l, x7Var.l)) == 0) {
            return 0;
        }
        return a2;
    }

    public long a() {
        return this.f121a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m528a() {
        return this.f126b;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m529a() {
        if (this.f126b == null) {
            throw new u8("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f127c != null) {
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
                    m529a();
                    return;
                }
                throw new u8("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (mo343a.f7786c) {
                case 1:
                    if (b2 == 11) {
                        this.f123a = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        l7 l7Var = new l7();
                        this.f122a = l7Var;
                        l7Var.a(t8Var);
                        break;
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f126b = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f127c = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 6:
                    if (b2 == 10) {
                        this.f121a = t8Var.mo342a();
                        a(true);
                        continue;
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f8018d = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f8019e = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f8020f = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f8021g = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 11:
                    if (b2 == 10) {
                        this.f125b = t8Var.mo342a();
                        b(true);
                        continue;
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f8022h = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 13:
                    if (b2 == 11) {
                        this.f8023i = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 14:
                    if (b2 == 10) {
                        this.f8017c = t8Var.mo342a();
                        c(true);
                        continue;
                    }
                    break;
                case 15:
                    if (b2 == 11) {
                        this.j = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 16:
                    if (b2 == 8) {
                        this.f8015a = t8Var.mo341a();
                        d(true);
                        continue;
                    }
                    break;
                case 17:
                    if (b2 == 11) {
                        this.k = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 18:
                    if (b2 == 8) {
                        this.f8016b = t8Var.mo341a();
                        e(true);
                        continue;
                    }
                    break;
                case 19:
                    if (b2 == 11) {
                        this.l = t8Var.mo348a();
                        continue;
                    }
                    break;
            }
            w8.a(t8Var, b2);
            t8Var.g();
        }
    }

    public void a(boolean z2) {
        this.f124a.set(0, z2);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m530a() {
        return this.f123a != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m531a(x7 x7Var) {
        if (x7Var == null) {
            return false;
        }
        boolean m530a = m530a();
        boolean m530a2 = x7Var.m530a();
        if ((m530a || m530a2) && !(m530a && m530a2 && this.f123a.equals(x7Var.f123a))) {
            return false;
        }
        boolean m532b = m532b();
        boolean m532b2 = x7Var.m532b();
        if ((m532b || m532b2) && !(m532b && m532b2 && this.f122a.m287a(x7Var.f122a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = x7Var.c();
        if ((c2 || c3) && !(c2 && c3 && this.f126b.equals(x7Var.f126b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = x7Var.d();
        if (((d2 || d3) && !(d2 && d3 && this.f127c.equals(x7Var.f127c))) || this.f121a != x7Var.f121a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = x7Var.f();
        if ((f2 || f3) && !(f2 && f3 && this.f8018d.equals(x7Var.f8018d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = x7Var.g();
        if ((g2 || g3) && !(g2 && g3 && this.f8019e.equals(x7Var.f8019e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = x7Var.h();
        if ((h2 || h3) && !(h2 && h3 && this.f8020f.equals(x7Var.f8020f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = x7Var.i();
        if ((i2 || i3) && !(i2 && i3 && this.f8021g.equals(x7Var.f8021g))) {
            return false;
        }
        boolean j = j();
        boolean j2 = x7Var.j();
        if ((j || j2) && !(j && j2 && this.f125b == x7Var.f125b)) {
            return false;
        }
        boolean k = k();
        boolean k2 = x7Var.k();
        if ((k || k2) && !(k && k2 && this.f8022h.equals(x7Var.f8022h))) {
            return false;
        }
        boolean l = l();
        boolean l2 = x7Var.l();
        if ((l || l2) && !(l && l2 && this.f8023i.equals(x7Var.f8023i))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = x7Var.m();
        if ((m2 || m3) && !(m2 && m3 && this.f8017c == x7Var.f8017c)) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = x7Var.n();
        if ((n2 || n3) && !(n2 && n3 && this.j.equals(x7Var.j))) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = x7Var.o();
        if ((o2 || o3) && !(o2 && o3 && this.f8015a == x7Var.f8015a)) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = x7Var.p();
        if ((p2 || p3) && !(p2 && p3 && this.k.equals(x7Var.k))) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = x7Var.q();
        if ((q2 || q3) && !(q2 && q3 && this.f8016b == x7Var.f8016b)) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = x7Var.r();
        if (r2 || r3) {
            return r2 && r3 && this.l.equals(x7Var.l);
        }
        return true;
    }

    public String b() {
        return this.f8021g;
    }

    @Override // c.k.d.i8
    public void b(t8 t8Var) {
        m529a();
        t8Var.a(m);
        if (this.f123a != null && m530a()) {
            t8Var.a(n);
            t8Var.a(this.f123a);
            t8Var.b();
        }
        if (this.f122a != null && m532b()) {
            t8Var.a(o);
            this.f122a.b(t8Var);
            t8Var.b();
        }
        if (this.f126b != null) {
            t8Var.a(p);
            t8Var.a(this.f126b);
            t8Var.b();
        }
        if (this.f127c != null) {
            t8Var.a(q);
            t8Var.a(this.f127c);
            t8Var.b();
        }
        t8Var.a(r);
        t8Var.a(this.f121a);
        t8Var.b();
        if (this.f8018d != null && f()) {
            t8Var.a(t);
            t8Var.a(this.f8018d);
            t8Var.b();
        }
        if (this.f8019e != null && g()) {
            t8Var.a(u);
            t8Var.a(this.f8019e);
            t8Var.b();
        }
        if (this.f8020f != null && h()) {
            t8Var.a(v);
            t8Var.a(this.f8020f);
            t8Var.b();
        }
        if (this.f8021g != null && i()) {
            t8Var.a(w);
            t8Var.a(this.f8021g);
            t8Var.b();
        }
        if (j()) {
            t8Var.a(x);
            t8Var.a(this.f125b);
            t8Var.b();
        }
        if (this.f8022h != null && k()) {
            t8Var.a(y);
            t8Var.a(this.f8022h);
            t8Var.b();
        }
        if (this.f8023i != null && l()) {
            t8Var.a(z);
            t8Var.a(this.f8023i);
            t8Var.b();
        }
        if (m()) {
            t8Var.a(A);
            t8Var.a(this.f8017c);
            t8Var.b();
        }
        if (this.j != null && n()) {
            t8Var.a(B);
            t8Var.a(this.j);
            t8Var.b();
        }
        if (o()) {
            t8Var.a(C);
            t8Var.mo352a(this.f8015a);
            t8Var.b();
        }
        if (this.k != null && p()) {
            t8Var.a(D);
            t8Var.a(this.k);
            t8Var.b();
        }
        if (q()) {
            t8Var.a(E);
            t8Var.mo352a(this.f8016b);
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
        this.f124a.set(1, z2);
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m532b() {
        return this.f122a != null;
    }

    public void c(boolean z2) {
        this.f124a.set(2, z2);
    }

    public boolean c() {
        return this.f126b != null;
    }

    public void d(boolean z2) {
        this.f124a.set(3, z2);
    }

    public boolean d() {
        return this.f127c != null;
    }

    public void e(boolean z2) {
        this.f124a.set(4, z2);
    }

    public boolean e() {
        return this.f124a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof x7)) {
            return m531a((x7) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f8018d != null;
    }

    public boolean g() {
        return this.f8019e != null;
    }

    public boolean h() {
        return this.f8020f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f8021g != null;
    }

    public boolean j() {
        return this.f124a.get(1);
    }

    public boolean k() {
        return this.f8022h != null;
    }

    public boolean l() {
        return this.f8023i != null;
    }

    public boolean m() {
        return this.f124a.get(2);
    }

    public boolean n() {
        return this.j != null;
    }

    public boolean o() {
        return this.f124a.get(3);
    }

    public boolean p() {
        return this.k != null;
    }

    public boolean q() {
        return this.f124a.get(4);
    }

    public boolean r() {
        return this.l != null;
    }

    public String toString() {
        boolean z2;
        StringBuilder sb = new StringBuilder("XmPushActionRegistrationResult(");
        boolean z3 = false;
        if (m530a()) {
            sb.append("debug:");
            String str = this.f123a;
            if (str == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str);
            }
            z2 = false;
        } else {
            z2 = true;
        }
        if (m532b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            l7 l7Var = this.f122a;
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
        String str2 = this.f126b;
        if (str2 == null) {
            sb.append(LogUtils.NULL);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f127c;
        if (str3 == null) {
            sb.append(LogUtils.NULL);
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f121a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f8018d;
            if (str4 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("regId:");
            String str5 = this.f8019e;
            if (str5 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("regSecret:");
            String str6 = this.f8020f;
            if (str6 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str6);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            String str7 = this.f8021g;
            if (str7 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str7);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("registeredAt:");
            sb.append(this.f125b);
        }
        if (k()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str8 = this.f8022h;
            if (str8 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str8);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("clientId:");
            String str9 = this.f8023i;
            if (str9 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str9);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("costTime:");
            sb.append(this.f8017c);
        }
        if (n()) {
            sb.append(", ");
            sb.append("appVersion:");
            String str10 = this.j;
            if (str10 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str10);
            }
        }
        if (o()) {
            sb.append(", ");
            sb.append("pushSdkVersionCode:");
            sb.append(this.f8015a);
        }
        if (p()) {
            sb.append(", ");
            sb.append("hybridPushEndpoint:");
            String str11 = this.k;
            if (str11 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str11);
            }
        }
        if (q()) {
            sb.append(", ");
            sb.append("appVersionCode:");
            sb.append(this.f8016b);
        }
        if (r()) {
            sb.append(", ");
            sb.append("region:");
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
