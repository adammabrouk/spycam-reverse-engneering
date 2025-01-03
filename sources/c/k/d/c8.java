package c.k.d;

import com.shix.shixipc.utilcode.LogUtils;
import java.io.Serializable;
import java.util.BitSet;

/* loaded from: classes.dex */
public class c8 implements i8<c8, Object>, Serializable, Cloneable {
    public static final y8 j = new y8("XmPushActionUnRegistration");
    public static final q8 k = new q8("", (byte) 11, 1);
    public static final q8 l = new q8("", (byte) 12, 2);
    public static final q8 m = new q8("", (byte) 11, 3);
    public static final q8 n = new q8("", (byte) 11, 4);
    public static final q8 o = new q8("", (byte) 11, 5);
    public static final q8 p = new q8("", (byte) 11, 6);
    public static final q8 q = new q8("", (byte) 11, 7);
    public static final q8 r = new q8("", (byte) 11, 8);
    public static final q8 t = new q8("", (byte) 11, 9);
    public static final q8 u = new q8("", (byte) 11, 10);
    public static final q8 v = new q8("", (byte) 2, 11);
    public static final q8 w = new q8("", (byte) 10, 12);

    /* renamed from: a, reason: collision with root package name */
    public long f7041a;

    /* renamed from: a, reason: collision with other field name */
    public l7 f9a;

    /* renamed from: a, reason: collision with other field name */
    public String f10a;

    /* renamed from: a, reason: collision with other field name */
    public BitSet f11a = new BitSet(2);

    /* renamed from: a, reason: collision with other field name */
    public boolean f12a = true;

    /* renamed from: b, reason: collision with root package name */
    public String f7042b;

    /* renamed from: c, reason: collision with root package name */
    public String f7043c;

    /* renamed from: d, reason: collision with root package name */
    public String f7044d;

    /* renamed from: e, reason: collision with root package name */
    public String f7045e;

    /* renamed from: f, reason: collision with root package name */
    public String f7046f;

    /* renamed from: g, reason: collision with root package name */
    public String f7047g;

    /* renamed from: h, reason: collision with root package name */
    public String f7048h;

    /* renamed from: i, reason: collision with root package name */
    public String f7049i;

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(c8 c8Var) {
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
        if (!c8.class.equals(c8Var.getClass())) {
            return c8.class.getName().compareTo(c8Var.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m120a()).compareTo(Boolean.valueOf(c8Var.m120a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m120a() && (a13 = j8.a(this.f10a, c8Var.f10a)) != 0) {
            return a13;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(c8Var.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a12 = j8.a(this.f9a, c8Var.f9a)) != 0) {
            return a12;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(c8Var.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a11 = j8.a(this.f7042b, c8Var.f7042b)) != 0) {
            return a11;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(c8Var.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a10 = j8.a(this.f7043c, c8Var.f7043c)) != 0) {
            return a10;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(c8Var.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a9 = j8.a(this.f7044d, c8Var.f7044d)) != 0) {
            return a9;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(c8Var.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a8 = j8.a(this.f7045e, c8Var.f7045e)) != 0) {
            return a8;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(c8Var.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a7 = j8.a(this.f7046f, c8Var.f7046f)) != 0) {
            return a7;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(c8Var.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a6 = j8.a(this.f7047g, c8Var.f7047g)) != 0) {
            return a6;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(c8Var.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a5 = j8.a(this.f7048h, c8Var.f7048h)) != 0) {
            return a5;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(c8Var.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (a4 = j8.a(this.f7049i, c8Var.f7049i)) != 0) {
            return a4;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(c8Var.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k() && (a3 = j8.a(this.f12a, c8Var.f12a)) != 0) {
            return a3;
        }
        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(c8Var.l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (!l() || (a2 = j8.a(this.f7041a, c8Var.f7041a)) == 0) {
            return 0;
        }
        return a2;
    }

    public c8 a(String str) {
        this.f7042b = str;
        return this;
    }

    public void a() {
        if (this.f7042b == null) {
            throw new u8("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f7043c != null) {
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
                a();
                return;
            }
            switch (mo343a.f7786c) {
                case 1:
                    if (b2 == 11) {
                        this.f10a = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        l7 l7Var = new l7();
                        this.f9a = l7Var;
                        l7Var.a(t8Var);
                        break;
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f7042b = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f7043c = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f7044d = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f7045e = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f7046f = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f7047g = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f7048h = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f7049i = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 11:
                    if (b2 == 2) {
                        this.f12a = t8Var.mo353a();
                        a(true);
                        break;
                    }
                    break;
                case 12:
                    if (b2 == 10) {
                        this.f7041a = t8Var.mo342a();
                        b(true);
                        break;
                    }
                    break;
            }
            w8.a(t8Var, b2);
            t8Var.g();
        }
    }

    public void a(boolean z) {
        this.f11a.set(0, z);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m120a() {
        return this.f10a != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m121a(c8 c8Var) {
        if (c8Var == null) {
            return false;
        }
        boolean m120a = m120a();
        boolean m120a2 = c8Var.m120a();
        if ((m120a || m120a2) && !(m120a && m120a2 && this.f10a.equals(c8Var.f10a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = c8Var.b();
        if ((b2 || b3) && !(b2 && b3 && this.f9a.m287a(c8Var.f9a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = c8Var.c();
        if ((c2 || c3) && !(c2 && c3 && this.f7042b.equals(c8Var.f7042b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = c8Var.d();
        if ((d2 || d3) && !(d2 && d3 && this.f7043c.equals(c8Var.f7043c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = c8Var.e();
        if ((e2 || e3) && !(e2 && e3 && this.f7044d.equals(c8Var.f7044d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = c8Var.f();
        if ((f2 || f3) && !(f2 && f3 && this.f7045e.equals(c8Var.f7045e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = c8Var.g();
        if ((g2 || g3) && !(g2 && g3 && this.f7046f.equals(c8Var.f7046f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = c8Var.h();
        if ((h2 || h3) && !(h2 && h3 && this.f7047g.equals(c8Var.f7047g))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = c8Var.i();
        if ((i2 || i3) && !(i2 && i3 && this.f7048h.equals(c8Var.f7048h))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = c8Var.j();
        if ((j2 || j3) && !(j2 && j3 && this.f7049i.equals(c8Var.f7049i))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = c8Var.k();
        if ((k2 || k3) && !(k2 && k3 && this.f12a == c8Var.f12a)) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = c8Var.l();
        if (l2 || l3) {
            return l2 && l3 && this.f7041a == c8Var.f7041a;
        }
        return true;
    }

    public c8 b(String str) {
        this.f7043c = str;
        return this;
    }

    @Override // c.k.d.i8
    public void b(t8 t8Var) {
        a();
        t8Var.a(j);
        if (this.f10a != null && m120a()) {
            t8Var.a(k);
            t8Var.a(this.f10a);
            t8Var.b();
        }
        if (this.f9a != null && b()) {
            t8Var.a(l);
            this.f9a.b(t8Var);
            t8Var.b();
        }
        if (this.f7042b != null) {
            t8Var.a(m);
            t8Var.a(this.f7042b);
            t8Var.b();
        }
        if (this.f7043c != null) {
            t8Var.a(n);
            t8Var.a(this.f7043c);
            t8Var.b();
        }
        if (this.f7044d != null && e()) {
            t8Var.a(o);
            t8Var.a(this.f7044d);
            t8Var.b();
        }
        if (this.f7045e != null && f()) {
            t8Var.a(p);
            t8Var.a(this.f7045e);
            t8Var.b();
        }
        if (this.f7046f != null && g()) {
            t8Var.a(q);
            t8Var.a(this.f7046f);
            t8Var.b();
        }
        if (this.f7047g != null && h()) {
            t8Var.a(r);
            t8Var.a(this.f7047g);
            t8Var.b();
        }
        if (this.f7048h != null && i()) {
            t8Var.a(t);
            t8Var.a(this.f7048h);
            t8Var.b();
        }
        if (this.f7049i != null && j()) {
            t8Var.a(u);
            t8Var.a(this.f7049i);
            t8Var.b();
        }
        if (k()) {
            t8Var.a(v);
            t8Var.a(this.f12a);
            t8Var.b();
        }
        if (l()) {
            t8Var.a(w);
            t8Var.a(this.f7041a);
            t8Var.b();
        }
        t8Var.c();
        t8Var.mo351a();
    }

    public void b(boolean z) {
        this.f11a.set(1, z);
    }

    public boolean b() {
        return this.f9a != null;
    }

    public c8 c(String str) {
        this.f7044d = str;
        return this;
    }

    public boolean c() {
        return this.f7042b != null;
    }

    public c8 d(String str) {
        this.f7046f = str;
        return this;
    }

    public boolean d() {
        return this.f7043c != null;
    }

    public c8 e(String str) {
        this.f7047g = str;
        return this;
    }

    public boolean e() {
        return this.f7044d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof c8)) {
            return m121a((c8) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f7045e != null;
    }

    public boolean g() {
        return this.f7046f != null;
    }

    public boolean h() {
        return this.f7047g != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f7048h != null;
    }

    public boolean j() {
        return this.f7049i != null;
    }

    public boolean k() {
        return this.f11a.get(0);
    }

    public boolean l() {
        return this.f11a.get(1);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistration(");
        boolean z2 = false;
        if (m120a()) {
            sb.append("debug:");
            String str = this.f10a;
            if (str == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            l7 l7Var = this.f9a;
            if (l7Var == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(l7Var);
            }
        } else {
            z2 = z;
        }
        if (!z2) {
            sb.append(", ");
        }
        sb.append("id:");
        String str2 = this.f7042b;
        if (str2 == null) {
            sb.append(LogUtils.NULL);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f7043c;
        if (str3 == null) {
            sb.append(LogUtils.NULL);
        } else {
            sb.append(str3);
        }
        if (e()) {
            sb.append(", ");
            sb.append("regId:");
            String str4 = this.f7044d;
            if (str4 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("appVersion:");
            String str5 = this.f7045e;
            if (str5 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f7046f;
            if (str6 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("token:");
            String str7 = this.f7047g;
            if (str7 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str7);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str8 = this.f7048h;
            if (str8 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str8);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str9 = this.f7049i;
            if (str9 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str9);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("needAck:");
            sb.append(this.f12a);
        }
        if (l()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f7041a);
        }
        sb.append(")");
        return sb.toString();
    }
}
