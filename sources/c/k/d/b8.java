package c.k.d;

import com.shix.shixipc.utilcode.LogUtils;
import java.io.Serializable;
import java.util.BitSet;

/* loaded from: classes.dex */
public class b8 implements i8<b8, Object>, Serializable, Cloneable {

    /* renamed from: h, reason: collision with root package name */
    public static final y8 f6994h = new y8("XmPushActionSubscriptionResult");

    /* renamed from: i, reason: collision with root package name */
    public static final q8 f6995i = new q8("", (byte) 11, 1);
    public static final q8 j = new q8("", (byte) 12, 2);
    public static final q8 k = new q8("", (byte) 11, 3);
    public static final q8 l = new q8("", (byte) 11, 4);
    public static final q8 m = new q8("", (byte) 10, 6);
    public static final q8 n = new q8("", (byte) 11, 7);
    public static final q8 o = new q8("", (byte) 11, 8);
    public static final q8 p = new q8("", (byte) 11, 9);
    public static final q8 q = new q8("", (byte) 11, 10);

    /* renamed from: a, reason: collision with root package name */
    public long f6996a;

    /* renamed from: a, reason: collision with other field name */
    public l7 f5a;

    /* renamed from: a, reason: collision with other field name */
    public String f6a;

    /* renamed from: a, reason: collision with other field name */
    public BitSet f7a = new BitSet(1);

    /* renamed from: b, reason: collision with root package name */
    public String f6997b;

    /* renamed from: c, reason: collision with root package name */
    public String f6998c;

    /* renamed from: d, reason: collision with root package name */
    public String f6999d;

    /* renamed from: e, reason: collision with root package name */
    public String f7000e;

    /* renamed from: f, reason: collision with root package name */
    public String f7001f;

    /* renamed from: g, reason: collision with root package name */
    public String f7002g;

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(b8 b8Var) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        int a10;
        if (!b8.class.equals(b8Var.getClass())) {
            return b8.class.getName().compareTo(b8Var.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m94a()).compareTo(Boolean.valueOf(b8Var.m94a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m94a() && (a10 = j8.a(this.f6a, b8Var.f6a)) != 0) {
            return a10;
        }
        int compareTo2 = Boolean.valueOf(m96b()).compareTo(Boolean.valueOf(b8Var.m96b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m96b() && (a9 = j8.a(this.f5a, b8Var.f5a)) != 0) {
            return a9;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(b8Var.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a8 = j8.a(this.f6997b, b8Var.f6997b)) != 0) {
            return a8;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(b8Var.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a7 = j8.a(this.f6998c, b8Var.f6998c)) != 0) {
            return a7;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(b8Var.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a6 = j8.a(this.f6996a, b8Var.f6996a)) != 0) {
            return a6;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(b8Var.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a5 = j8.a(this.f6999d, b8Var.f6999d)) != 0) {
            return a5;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(b8Var.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a4 = j8.a(this.f7000e, b8Var.f7000e)) != 0) {
            return a4;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(b8Var.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a3 = j8.a(this.f7001f, b8Var.f7001f)) != 0) {
            return a3;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(b8Var.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (!i() || (a2 = j8.a(this.f7002g, b8Var.f7002g)) == 0) {
            return 0;
        }
        return a2;
    }

    public String a() {
        return this.f7000e;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m93a() {
        if (this.f6997b != null) {
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
                m93a();
                return;
            }
            switch (mo343a.f7786c) {
                case 1:
                    if (b2 == 11) {
                        this.f6a = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        l7 l7Var = new l7();
                        this.f5a = l7Var;
                        l7Var.a(t8Var);
                        break;
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f6997b = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f6998c = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 6:
                    if (b2 == 10) {
                        this.f6996a = t8Var.mo342a();
                        a(true);
                        break;
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f6999d = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f7000e = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f7001f = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f7002g = t8Var.mo348a();
                        continue;
                    }
                    break;
            }
            w8.a(t8Var, b2);
            t8Var.g();
        }
    }

    public void a(boolean z) {
        this.f7a.set(0, z);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m94a() {
        return this.f6a != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m95a(b8 b8Var) {
        if (b8Var == null) {
            return false;
        }
        boolean m94a = m94a();
        boolean m94a2 = b8Var.m94a();
        if ((m94a || m94a2) && !(m94a && m94a2 && this.f6a.equals(b8Var.f6a))) {
            return false;
        }
        boolean m96b = m96b();
        boolean m96b2 = b8Var.m96b();
        if ((m96b || m96b2) && !(m96b && m96b2 && this.f5a.m287a(b8Var.f5a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = b8Var.c();
        if ((c2 || c3) && !(c2 && c3 && this.f6997b.equals(b8Var.f6997b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = b8Var.d();
        if ((d2 || d3) && !(d2 && d3 && this.f6998c.equals(b8Var.f6998c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = b8Var.e();
        if ((e2 || e3) && !(e2 && e3 && this.f6996a == b8Var.f6996a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = b8Var.f();
        if ((f2 || f3) && !(f2 && f3 && this.f6999d.equals(b8Var.f6999d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = b8Var.g();
        if ((g2 || g3) && !(g2 && g3 && this.f7000e.equals(b8Var.f7000e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = b8Var.h();
        if ((h2 || h3) && !(h2 && h3 && this.f7001f.equals(b8Var.f7001f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = b8Var.i();
        if (i2 || i3) {
            return i2 && i3 && this.f7002g.equals(b8Var.f7002g);
        }
        return true;
    }

    public String b() {
        return this.f7002g;
    }

    @Override // c.k.d.i8
    public void b(t8 t8Var) {
        m93a();
        t8Var.a(f6994h);
        if (this.f6a != null && m94a()) {
            t8Var.a(f6995i);
            t8Var.a(this.f6a);
            t8Var.b();
        }
        if (this.f5a != null && m96b()) {
            t8Var.a(j);
            this.f5a.b(t8Var);
            t8Var.b();
        }
        if (this.f6997b != null) {
            t8Var.a(k);
            t8Var.a(this.f6997b);
            t8Var.b();
        }
        if (this.f6998c != null && d()) {
            t8Var.a(l);
            t8Var.a(this.f6998c);
            t8Var.b();
        }
        if (e()) {
            t8Var.a(m);
            t8Var.a(this.f6996a);
            t8Var.b();
        }
        if (this.f6999d != null && f()) {
            t8Var.a(n);
            t8Var.a(this.f6999d);
            t8Var.b();
        }
        if (this.f7000e != null && g()) {
            t8Var.a(o);
            t8Var.a(this.f7000e);
            t8Var.b();
        }
        if (this.f7001f != null && h()) {
            t8Var.a(p);
            t8Var.a(this.f7001f);
            t8Var.b();
        }
        if (this.f7002g != null && i()) {
            t8Var.a(q);
            t8Var.a(this.f7002g);
            t8Var.b();
        }
        t8Var.c();
        t8Var.mo351a();
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m96b() {
        return this.f5a != null;
    }

    public boolean c() {
        return this.f6997b != null;
    }

    public boolean d() {
        return this.f6998c != null;
    }

    public boolean e() {
        return this.f7a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof b8)) {
            return m95a((b8) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f6999d != null;
    }

    public boolean g() {
        return this.f7000e != null;
    }

    public boolean h() {
        return this.f7001f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f7002g != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSubscriptionResult(");
        boolean z2 = false;
        if (m94a()) {
            sb.append("debug:");
            String str = this.f6a;
            if (str == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m96b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            l7 l7Var = this.f5a;
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
        String str2 = this.f6997b;
        if (str2 == null) {
            sb.append(LogUtils.NULL);
        } else {
            sb.append(str2);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.f6998c;
            if (str3 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f6996a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f6999d;
            if (str4 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("topic:");
            String str5 = this.f7000e;
            if (str5 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f7001f;
            if (str6 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str6);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f7002g;
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
