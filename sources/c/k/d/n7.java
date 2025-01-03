package c.k.d;

import com.shix.shixipc.utilcode.LogUtils;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class n7 implements i8<n7, Object>, Serializable, Cloneable {

    /* renamed from: h, reason: collision with root package name */
    public static final y8 f7431h = new y8("XmPushActionAckNotification");

    /* renamed from: i, reason: collision with root package name */
    public static final q8 f7432i = new q8("", (byte) 11, 1);
    public static final q8 j = new q8("", (byte) 12, 2);
    public static final q8 k = new q8("", (byte) 11, 3);
    public static final q8 l = new q8("", (byte) 11, 4);
    public static final q8 m = new q8("", (byte) 11, 5);
    public static final q8 n = new q8("", (byte) 10, 7);
    public static final q8 o = new q8("", (byte) 11, 8);
    public static final q8 p = new q8("", (byte) 13, 9);
    public static final q8 q = new q8("", (byte) 11, 10);
    public static final q8 r = new q8("", (byte) 11, 11);

    /* renamed from: a, reason: collision with other field name */
    public l7 f68a;

    /* renamed from: a, reason: collision with other field name */
    public String f69a;

    /* renamed from: a, reason: collision with other field name */
    public Map<String, String> f71a;

    /* renamed from: b, reason: collision with root package name */
    public String f7434b;

    /* renamed from: c, reason: collision with root package name */
    public String f7435c;

    /* renamed from: d, reason: collision with root package name */
    public String f7436d;

    /* renamed from: e, reason: collision with root package name */
    public String f7437e;

    /* renamed from: f, reason: collision with root package name */
    public String f7438f;

    /* renamed from: g, reason: collision with root package name */
    public String f7439g;

    /* renamed from: a, reason: collision with other field name */
    public BitSet f70a = new BitSet(1);

    /* renamed from: a, reason: collision with root package name */
    public long f7433a = 0;

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(n7 n7Var) {
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
        if (!n7.class.equals(n7Var.getClass())) {
            return n7.class.getName().compareTo(n7Var.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m315a()).compareTo(Boolean.valueOf(n7Var.m315a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m315a() && (a11 = j8.a(this.f69a, n7Var.f69a)) != 0) {
            return a11;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(n7Var.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a10 = j8.a(this.f68a, n7Var.f68a)) != 0) {
            return a10;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(n7Var.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a9 = j8.a(this.f7434b, n7Var.f7434b)) != 0) {
            return a9;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(n7Var.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a8 = j8.a(this.f7435c, n7Var.f7435c)) != 0) {
            return a8;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(n7Var.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a7 = j8.a(this.f7436d, n7Var.f7436d)) != 0) {
            return a7;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(n7Var.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a6 = j8.a(this.f7433a, n7Var.f7433a)) != 0) {
            return a6;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(n7Var.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a5 = j8.a(this.f7437e, n7Var.f7437e)) != 0) {
            return a5;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(n7Var.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a4 = j8.a(this.f71a, n7Var.f71a)) != 0) {
            return a4;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(n7Var.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a3 = j8.a(this.f7438f, n7Var.f7438f)) != 0) {
            return a3;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(n7Var.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (!j() || (a2 = j8.a(this.f7439g, n7Var.f7439g)) == 0) {
            return 0;
        }
        return a2;
    }

    public String a() {
        return this.f7434b;
    }

    /* renamed from: a, reason: collision with other method in class */
    public Map<String, String> m313a() {
        return this.f71a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m314a() {
        if (this.f7434b != null) {
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
                m314a();
                return;
            }
            switch (mo343a.f7786c) {
                case 1:
                    if (b2 == 11) {
                        this.f69a = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        l7 l7Var = new l7();
                        this.f68a = l7Var;
                        l7Var.a(t8Var);
                        break;
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f7434b = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f7435c = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f7436d = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 7:
                    if (b2 == 10) {
                        this.f7433a = t8Var.mo342a();
                        a(true);
                        break;
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f7437e = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 9:
                    if (b2 == 13) {
                        s8 mo345a = t8Var.mo345a();
                        this.f71a = new HashMap(mo345a.f7854c * 2);
                        for (int i2 = 0; i2 < mo345a.f7854c; i2++) {
                            this.f71a.put(t8Var.mo348a(), t8Var.mo348a());
                        }
                        t8Var.h();
                        break;
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f7438f = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 11:
                    if (b2 == 11) {
                        this.f7439g = t8Var.mo348a();
                        continue;
                    }
                    break;
            }
            w8.a(t8Var, b2);
            t8Var.g();
        }
    }

    public void a(boolean z) {
        this.f70a.set(0, z);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m315a() {
        return this.f69a != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m316a(n7 n7Var) {
        if (n7Var == null) {
            return false;
        }
        boolean m315a = m315a();
        boolean m315a2 = n7Var.m315a();
        if ((m315a || m315a2) && !(m315a && m315a2 && this.f69a.equals(n7Var.f69a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = n7Var.b();
        if ((b2 || b3) && !(b2 && b3 && this.f68a.m287a(n7Var.f68a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = n7Var.c();
        if ((c2 || c3) && !(c2 && c3 && this.f7434b.equals(n7Var.f7434b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = n7Var.d();
        if ((d2 || d3) && !(d2 && d3 && this.f7435c.equals(n7Var.f7435c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = n7Var.e();
        if ((e2 || e3) && !(e2 && e3 && this.f7436d.equals(n7Var.f7436d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = n7Var.f();
        if ((f2 || f3) && !(f2 && f3 && this.f7433a == n7Var.f7433a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = n7Var.g();
        if ((g2 || g3) && !(g2 && g3 && this.f7437e.equals(n7Var.f7437e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = n7Var.h();
        if ((h2 || h3) && !(h2 && h3 && this.f71a.equals(n7Var.f71a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = n7Var.i();
        if ((i2 || i3) && !(i2 && i3 && this.f7438f.equals(n7Var.f7438f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = n7Var.j();
        if (j2 || j3) {
            return j2 && j3 && this.f7439g.equals(n7Var.f7439g);
        }
        return true;
    }

    @Override // c.k.d.i8
    public void b(t8 t8Var) {
        m314a();
        t8Var.a(f7431h);
        if (this.f69a != null && m315a()) {
            t8Var.a(f7432i);
            t8Var.a(this.f69a);
            t8Var.b();
        }
        if (this.f68a != null && b()) {
            t8Var.a(j);
            this.f68a.b(t8Var);
            t8Var.b();
        }
        if (this.f7434b != null) {
            t8Var.a(k);
            t8Var.a(this.f7434b);
            t8Var.b();
        }
        if (this.f7435c != null && d()) {
            t8Var.a(l);
            t8Var.a(this.f7435c);
            t8Var.b();
        }
        if (this.f7436d != null && e()) {
            t8Var.a(m);
            t8Var.a(this.f7436d);
            t8Var.b();
        }
        if (f()) {
            t8Var.a(n);
            t8Var.a(this.f7433a);
            t8Var.b();
        }
        if (this.f7437e != null && g()) {
            t8Var.a(o);
            t8Var.a(this.f7437e);
            t8Var.b();
        }
        if (this.f71a != null && h()) {
            t8Var.a(p);
            t8Var.a(new s8((byte) 11, (byte) 11, this.f71a.size()));
            for (Map.Entry<String, String> entry : this.f71a.entrySet()) {
                t8Var.a(entry.getKey());
                t8Var.a(entry.getValue());
            }
            t8Var.d();
            t8Var.b();
        }
        if (this.f7438f != null && i()) {
            t8Var.a(q);
            t8Var.a(this.f7438f);
            t8Var.b();
        }
        if (this.f7439g != null && j()) {
            t8Var.a(r);
            t8Var.a(this.f7439g);
            t8Var.b();
        }
        t8Var.c();
        t8Var.mo351a();
    }

    public boolean b() {
        return this.f68a != null;
    }

    public boolean c() {
        return this.f7434b != null;
    }

    public boolean d() {
        return this.f7435c != null;
    }

    public boolean e() {
        return this.f7436d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof n7)) {
            return m316a((n7) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f70a.get(0);
    }

    public boolean g() {
        return this.f7437e != null;
    }

    public boolean h() {
        return this.f71a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f7438f != null;
    }

    public boolean j() {
        return this.f7439g != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionAckNotification(");
        boolean z2 = false;
        if (m315a()) {
            sb.append("debug:");
            String str = this.f69a;
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
            l7 l7Var = this.f68a;
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
        String str2 = this.f7434b;
        if (str2 == null) {
            sb.append(LogUtils.NULL);
        } else {
            sb.append(str2);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.f7435c;
            if (str3 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("type:");
            String str4 = this.f7436d;
            if (str4 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f7433a);
        }
        if (g()) {
            sb.append(", ");
            sb.append("reason:");
            String str5 = this.f7437e;
            if (str5 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f71a;
            if (map == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(map);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f7438f;
            if (str6 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f7439g;
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
