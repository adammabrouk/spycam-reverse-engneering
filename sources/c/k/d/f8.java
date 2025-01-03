package c.k.d;

import com.shix.shixipc.utilcode.LogUtils;
import java.io.Serializable;
import java.util.BitSet;

/* loaded from: classes.dex */
public class f8 implements i8<f8, Object>, Serializable, Cloneable {

    /* renamed from: h, reason: collision with root package name */
    public static final y8 f7130h = new y8("XmPushActionUnSubscriptionResult");

    /* renamed from: i, reason: collision with root package name */
    public static final q8 f7131i = new q8("", (byte) 11, 1);
    public static final q8 j = new q8("", (byte) 12, 2);
    public static final q8 k = new q8("", (byte) 11, 3);
    public static final q8 l = new q8("", (byte) 11, 4);
    public static final q8 m = new q8("", (byte) 10, 6);
    public static final q8 n = new q8("", (byte) 11, 7);
    public static final q8 o = new q8("", (byte) 11, 8);
    public static final q8 p = new q8("", (byte) 11, 9);
    public static final q8 q = new q8("", (byte) 11, 10);

    /* renamed from: a, reason: collision with root package name */
    public long f7132a;

    /* renamed from: a, reason: collision with other field name */
    public l7 f27a;

    /* renamed from: a, reason: collision with other field name */
    public String f28a;

    /* renamed from: a, reason: collision with other field name */
    public BitSet f29a = new BitSet(1);

    /* renamed from: b, reason: collision with root package name */
    public String f7133b;

    /* renamed from: c, reason: collision with root package name */
    public String f7134c;

    /* renamed from: d, reason: collision with root package name */
    public String f7135d;

    /* renamed from: e, reason: collision with root package name */
    public String f7136e;

    /* renamed from: f, reason: collision with root package name */
    public String f7137f;

    /* renamed from: g, reason: collision with root package name */
    public String f7138g;

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(f8 f8Var) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        int a10;
        if (!f8.class.equals(f8Var.getClass())) {
            return f8.class.getName().compareTo(f8Var.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m161a()).compareTo(Boolean.valueOf(f8Var.m161a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m161a() && (a10 = j8.a(this.f28a, f8Var.f28a)) != 0) {
            return a10;
        }
        int compareTo2 = Boolean.valueOf(m163b()).compareTo(Boolean.valueOf(f8Var.m163b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m163b() && (a9 = j8.a(this.f27a, f8Var.f27a)) != 0) {
            return a9;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(f8Var.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a8 = j8.a(this.f7133b, f8Var.f7133b)) != 0) {
            return a8;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(f8Var.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a7 = j8.a(this.f7134c, f8Var.f7134c)) != 0) {
            return a7;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(f8Var.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a6 = j8.a(this.f7132a, f8Var.f7132a)) != 0) {
            return a6;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(f8Var.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a5 = j8.a(this.f7135d, f8Var.f7135d)) != 0) {
            return a5;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(f8Var.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a4 = j8.a(this.f7136e, f8Var.f7136e)) != 0) {
            return a4;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(f8Var.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a3 = j8.a(this.f7137f, f8Var.f7137f)) != 0) {
            return a3;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(f8Var.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (!i() || (a2 = j8.a(this.f7138g, f8Var.f7138g)) == 0) {
            return 0;
        }
        return a2;
    }

    public String a() {
        return this.f7136e;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m160a() {
        if (this.f7133b != null) {
            return;
        }
        throw new u8("Required field 'id' was not present! Struct: " + toString());
    }

    @Override // c.k.d.i8
    public void a(t8 t8Var) {
        t8Var.mo347a();
        while (true) {
            q8 mo343a = t8Var.mo343a();
            byte b2 = mo343a.f7785b;
            if (b2 == 0) {
                t8Var.f();
                m160a();
                return;
            }
            switch (mo343a.f7786c) {
                case 1:
                    if (b2 == 11) {
                        this.f28a = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        l7 l7Var = new l7();
                        this.f27a = l7Var;
                        l7Var.a(t8Var);
                        break;
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f7133b = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f7134c = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 6:
                    if (b2 == 10) {
                        this.f7132a = t8Var.mo342a();
                        a(true);
                        break;
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f7135d = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f7136e = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f7137f = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f7138g = t8Var.mo348a();
                        continue;
                    }
                    break;
            }
            w8.a(t8Var, b2);
            t8Var.g();
        }
    }

    public void a(boolean z) {
        this.f29a.set(0, z);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m161a() {
        return this.f28a != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m162a(f8 f8Var) {
        if (f8Var == null) {
            return false;
        }
        boolean m161a = m161a();
        boolean m161a2 = f8Var.m161a();
        if ((m161a || m161a2) && !(m161a && m161a2 && this.f28a.equals(f8Var.f28a))) {
            return false;
        }
        boolean m163b = m163b();
        boolean m163b2 = f8Var.m163b();
        if ((m163b || m163b2) && !(m163b && m163b2 && this.f27a.m287a(f8Var.f27a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = f8Var.c();
        if ((c2 || c3) && !(c2 && c3 && this.f7133b.equals(f8Var.f7133b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = f8Var.d();
        if ((d2 || d3) && !(d2 && d3 && this.f7134c.equals(f8Var.f7134c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = f8Var.e();
        if ((e2 || e3) && !(e2 && e3 && this.f7132a == f8Var.f7132a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = f8Var.f();
        if ((f2 || f3) && !(f2 && f3 && this.f7135d.equals(f8Var.f7135d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = f8Var.g();
        if ((g2 || g3) && !(g2 && g3 && this.f7136e.equals(f8Var.f7136e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = f8Var.h();
        if ((h2 || h3) && !(h2 && h3 && this.f7137f.equals(f8Var.f7137f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = f8Var.i();
        if (i2 || i3) {
            return i2 && i3 && this.f7138g.equals(f8Var.f7138g);
        }
        return true;
    }

    public String b() {
        return this.f7138g;
    }

    @Override // c.k.d.i8
    public void b(t8 t8Var) {
        m160a();
        t8Var.a(f7130h);
        if (this.f28a != null && m161a()) {
            t8Var.a(f7131i);
            t8Var.a(this.f28a);
            t8Var.b();
        }
        if (this.f27a != null && m163b()) {
            t8Var.a(j);
            this.f27a.b(t8Var);
            t8Var.b();
        }
        if (this.f7133b != null) {
            t8Var.a(k);
            t8Var.a(this.f7133b);
            t8Var.b();
        }
        if (this.f7134c != null && d()) {
            t8Var.a(l);
            t8Var.a(this.f7134c);
            t8Var.b();
        }
        if (e()) {
            t8Var.a(m);
            t8Var.a(this.f7132a);
            t8Var.b();
        }
        if (this.f7135d != null && f()) {
            t8Var.a(n);
            t8Var.a(this.f7135d);
            t8Var.b();
        }
        if (this.f7136e != null && g()) {
            t8Var.a(o);
            t8Var.a(this.f7136e);
            t8Var.b();
        }
        if (this.f7137f != null && h()) {
            t8Var.a(p);
            t8Var.a(this.f7137f);
            t8Var.b();
        }
        if (this.f7138g != null && i()) {
            t8Var.a(q);
            t8Var.a(this.f7138g);
            t8Var.b();
        }
        t8Var.c();
        t8Var.mo351a();
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m163b() {
        return this.f27a != null;
    }

    public boolean c() {
        return this.f7133b != null;
    }

    public boolean d() {
        return this.f7134c != null;
    }

    public boolean e() {
        return this.f29a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof f8)) {
            return m162a((f8) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f7135d != null;
    }

    public boolean g() {
        return this.f7136e != null;
    }

    public boolean h() {
        return this.f7137f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f7138g != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscriptionResult(");
        boolean z2 = false;
        if (m161a()) {
            sb.append("debug:");
            String str = this.f28a;
            if (str == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m163b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            l7 l7Var = this.f27a;
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
        String str2 = this.f7133b;
        if (str2 == null) {
            sb.append(LogUtils.NULL);
        } else {
            sb.append(str2);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.f7134c;
            if (str3 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f7132a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f7135d;
            if (str4 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("topic:");
            String str5 = this.f7136e;
            if (str5 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f7137f;
            if (str6 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str6);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f7138g;
            if (str7 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str7);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
