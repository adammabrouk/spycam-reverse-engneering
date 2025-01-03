package c.k.d;

import com.shix.shixipc.utilcode.LogUtils;
import java.io.Serializable;
import java.util.BitSet;

/* loaded from: classes.dex */
public class d8 implements i8<d8, Object>, Serializable, Cloneable {

    /* renamed from: f, reason: collision with root package name */
    public static final y8 f7075f = new y8("XmPushActionUnRegistrationResult");

    /* renamed from: g, reason: collision with root package name */
    public static final q8 f7076g = new q8("", (byte) 11, 1);

    /* renamed from: h, reason: collision with root package name */
    public static final q8 f7077h = new q8("", (byte) 12, 2);

    /* renamed from: i, reason: collision with root package name */
    public static final q8 f7078i = new q8("", (byte) 11, 3);
    public static final q8 j = new q8("", (byte) 11, 4);
    public static final q8 k = new q8("", (byte) 10, 6);
    public static final q8 l = new q8("", (byte) 11, 7);
    public static final q8 m = new q8("", (byte) 11, 8);
    public static final q8 n = new q8("", (byte) 10, 9);
    public static final q8 o = new q8("", (byte) 10, 10);

    /* renamed from: a, reason: collision with root package name */
    public long f7079a;

    /* renamed from: a, reason: collision with other field name */
    public l7 f17a;

    /* renamed from: a, reason: collision with other field name */
    public String f18a;

    /* renamed from: a, reason: collision with other field name */
    public BitSet f19a = new BitSet(3);

    /* renamed from: b, reason: collision with root package name */
    public long f7080b;

    /* renamed from: b, reason: collision with other field name */
    public String f20b;

    /* renamed from: c, reason: collision with root package name */
    public long f7081c;

    /* renamed from: c, reason: collision with other field name */
    public String f21c;

    /* renamed from: d, reason: collision with root package name */
    public String f7082d;

    /* renamed from: e, reason: collision with root package name */
    public String f7083e;

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(d8 d8Var) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        int a10;
        if (!d8.class.equals(d8Var.getClass())) {
            return d8.class.getName().compareTo(d8Var.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m135a()).compareTo(Boolean.valueOf(d8Var.m135a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m135a() && (a10 = j8.a(this.f18a, d8Var.f18a)) != 0) {
            return a10;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(d8Var.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a9 = j8.a(this.f17a, d8Var.f17a)) != 0) {
            return a9;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(d8Var.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a8 = j8.a(this.f20b, d8Var.f20b)) != 0) {
            return a8;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(d8Var.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a7 = j8.a(this.f21c, d8Var.f21c)) != 0) {
            return a7;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(d8Var.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a6 = j8.a(this.f7079a, d8Var.f7079a)) != 0) {
            return a6;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(d8Var.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a5 = j8.a(this.f7082d, d8Var.f7082d)) != 0) {
            return a5;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(d8Var.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a4 = j8.a(this.f7083e, d8Var.f7083e)) != 0) {
            return a4;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(d8Var.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a3 = j8.a(this.f7080b, d8Var.f7080b)) != 0) {
            return a3;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(d8Var.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (!i() || (a2 = j8.a(this.f7081c, d8Var.f7081c)) == 0) {
            return 0;
        }
        return a2;
    }

    public String a() {
        return this.f7083e;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m134a() {
        if (this.f20b == null) {
            throw new u8("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f21c != null) {
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
                    m134a();
                    return;
                }
                throw new u8("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (mo343a.f7786c) {
                case 1:
                    if (b2 == 11) {
                        this.f18a = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        l7 l7Var = new l7();
                        this.f17a = l7Var;
                        l7Var.a(t8Var);
                        break;
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f20b = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f21c = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 6:
                    if (b2 == 10) {
                        this.f7079a = t8Var.mo342a();
                        a(true);
                        continue;
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f7082d = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f7083e = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 9:
                    if (b2 == 10) {
                        this.f7080b = t8Var.mo342a();
                        b(true);
                        continue;
                    }
                    break;
                case 10:
                    if (b2 == 10) {
                        this.f7081c = t8Var.mo342a();
                        c(true);
                        continue;
                    }
                    break;
            }
            w8.a(t8Var, b2);
            t8Var.g();
        }
    }

    public void a(boolean z) {
        this.f19a.set(0, z);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m135a() {
        return this.f18a != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m136a(d8 d8Var) {
        if (d8Var == null) {
            return false;
        }
        boolean m135a = m135a();
        boolean m135a2 = d8Var.m135a();
        if ((m135a || m135a2) && !(m135a && m135a2 && this.f18a.equals(d8Var.f18a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = d8Var.b();
        if ((b2 || b3) && !(b2 && b3 && this.f17a.m287a(d8Var.f17a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = d8Var.c();
        if ((c2 || c3) && !(c2 && c3 && this.f20b.equals(d8Var.f20b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = d8Var.d();
        if (((d2 || d3) && !(d2 && d3 && this.f21c.equals(d8Var.f21c))) || this.f7079a != d8Var.f7079a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = d8Var.f();
        if ((f2 || f3) && !(f2 && f3 && this.f7082d.equals(d8Var.f7082d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = d8Var.g();
        if ((g2 || g3) && !(g2 && g3 && this.f7083e.equals(d8Var.f7083e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = d8Var.h();
        if ((h2 || h3) && !(h2 && h3 && this.f7080b == d8Var.f7080b)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = d8Var.i();
        if (i2 || i3) {
            return i2 && i3 && this.f7081c == d8Var.f7081c;
        }
        return true;
    }

    @Override // c.k.d.i8
    public void b(t8 t8Var) {
        m134a();
        t8Var.a(f7075f);
        if (this.f18a != null && m135a()) {
            t8Var.a(f7076g);
            t8Var.a(this.f18a);
            t8Var.b();
        }
        if (this.f17a != null && b()) {
            t8Var.a(f7077h);
            this.f17a.b(t8Var);
            t8Var.b();
        }
        if (this.f20b != null) {
            t8Var.a(f7078i);
            t8Var.a(this.f20b);
            t8Var.b();
        }
        if (this.f21c != null) {
            t8Var.a(j);
            t8Var.a(this.f21c);
            t8Var.b();
        }
        t8Var.a(k);
        t8Var.a(this.f7079a);
        t8Var.b();
        if (this.f7082d != null && f()) {
            t8Var.a(l);
            t8Var.a(this.f7082d);
            t8Var.b();
        }
        if (this.f7083e != null && g()) {
            t8Var.a(m);
            t8Var.a(this.f7083e);
            t8Var.b();
        }
        if (h()) {
            t8Var.a(n);
            t8Var.a(this.f7080b);
            t8Var.b();
        }
        if (i()) {
            t8Var.a(o);
            t8Var.a(this.f7081c);
            t8Var.b();
        }
        t8Var.c();
        t8Var.mo351a();
    }

    public void b(boolean z) {
        this.f19a.set(1, z);
    }

    public boolean b() {
        return this.f17a != null;
    }

    public void c(boolean z) {
        this.f19a.set(2, z);
    }

    public boolean c() {
        return this.f20b != null;
    }

    public boolean d() {
        return this.f21c != null;
    }

    public boolean e() {
        return this.f19a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof d8)) {
            return m136a((d8) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f7082d != null;
    }

    public boolean g() {
        return this.f7083e != null;
    }

    public boolean h() {
        return this.f19a.get(1);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f19a.get(2);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistrationResult(");
        boolean z2 = false;
        if (m135a()) {
            sb.append("debug:");
            String str = this.f18a;
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
            l7 l7Var = this.f17a;
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
        String str2 = this.f20b;
        if (str2 == null) {
            sb.append(LogUtils.NULL);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f21c;
        if (str3 == null) {
            sb.append(LogUtils.NULL);
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f7079a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f7082d;
            if (str4 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f7083e;
            if (str5 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("unRegisteredAt:");
            sb.append(this.f7080b);
        }
        if (i()) {
            sb.append(", ");
            sb.append("costTime:");
            sb.append(this.f7081c);
        }
        sb.append(")");
        return sb.toString();
    }
}
