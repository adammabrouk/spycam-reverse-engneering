package c.k.d;

import com.shix.shixipc.utilcode.LogUtils;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class z7 implements i8<z7, Object>, Serializable, Cloneable {

    /* renamed from: i, reason: collision with root package name */
    public static final y8 f8086i = new y8("XmPushActionSendMessage");
    public static final q8 j = new q8("", (byte) 11, 1);
    public static final q8 k = new q8("", (byte) 12, 2);
    public static final q8 l = new q8("", (byte) 11, 3);
    public static final q8 m = new q8("", (byte) 11, 4);
    public static final q8 n = new q8("", (byte) 11, 5);
    public static final q8 o = new q8("", (byte) 11, 6);
    public static final q8 p = new q8("", (byte) 11, 7);
    public static final q8 q = new q8("", (byte) 12, 8);
    public static final q8 r = new q8("", (byte) 2, 9);
    public static final q8 t = new q8("", (byte) 13, 10);
    public static final q8 u = new q8("", (byte) 11, 11);
    public static final q8 v = new q8("", (byte) 11, 12);

    /* renamed from: a, reason: collision with root package name */
    public i7 f8087a;

    /* renamed from: a, reason: collision with other field name */
    public l7 f137a;

    /* renamed from: a, reason: collision with other field name */
    public String f138a;

    /* renamed from: a, reason: collision with other field name */
    public Map<String, String> f140a;

    /* renamed from: b, reason: collision with root package name */
    public String f8088b;

    /* renamed from: c, reason: collision with root package name */
    public String f8089c;

    /* renamed from: d, reason: collision with root package name */
    public String f8090d;

    /* renamed from: e, reason: collision with root package name */
    public String f8091e;

    /* renamed from: f, reason: collision with root package name */
    public String f8092f;

    /* renamed from: g, reason: collision with root package name */
    public String f8093g;

    /* renamed from: h, reason: collision with root package name */
    public String f8094h;

    /* renamed from: a, reason: collision with other field name */
    public BitSet f139a = new BitSet(1);

    /* renamed from: a, reason: collision with other field name */
    public boolean f141a = true;

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(z7 z7Var) {
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
        if (!z7.class.equals(z7Var.getClass())) {
            return z7.class.getName().compareTo(z7Var.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m566a()).compareTo(Boolean.valueOf(z7Var.m566a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m566a() && (a13 = j8.a(this.f138a, z7Var.f138a)) != 0) {
            return a13;
        }
        int compareTo2 = Boolean.valueOf(m568b()).compareTo(Boolean.valueOf(z7Var.m568b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m568b() && (a12 = j8.a(this.f137a, z7Var.f137a)) != 0) {
            return a12;
        }
        int compareTo3 = Boolean.valueOf(m569c()).compareTo(Boolean.valueOf(z7Var.m569c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m569c() && (a11 = j8.a(this.f8088b, z7Var.f8088b)) != 0) {
            return a11;
        }
        int compareTo4 = Boolean.valueOf(m570d()).compareTo(Boolean.valueOf(z7Var.m570d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m570d() && (a10 = j8.a(this.f8089c, z7Var.f8089c)) != 0) {
            return a10;
        }
        int compareTo5 = Boolean.valueOf(m571e()).compareTo(Boolean.valueOf(z7Var.m571e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m571e() && (a9 = j8.a(this.f8090d, z7Var.f8090d)) != 0) {
            return a9;
        }
        int compareTo6 = Boolean.valueOf(m572f()).compareTo(Boolean.valueOf(z7Var.m572f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m572f() && (a8 = j8.a(this.f8091e, z7Var.f8091e)) != 0) {
            return a8;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(z7Var.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a7 = j8.a(this.f8092f, z7Var.f8092f)) != 0) {
            return a7;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(z7Var.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a6 = j8.a(this.f8087a, z7Var.f8087a)) != 0) {
            return a6;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(z7Var.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a5 = j8.a(this.f141a, z7Var.f141a)) != 0) {
            return a5;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(z7Var.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (a4 = j8.a(this.f140a, z7Var.f140a)) != 0) {
            return a4;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(z7Var.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k() && (a3 = j8.a(this.f8093g, z7Var.f8093g)) != 0) {
            return a3;
        }
        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(z7Var.l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (!l() || (a2 = j8.a(this.f8094h, z7Var.f8094h)) == 0) {
            return 0;
        }
        return a2;
    }

    public i7 a() {
        return this.f8087a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m564a() {
        return this.f8088b;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m565a() {
        if (this.f8088b == null) {
            throw new u8("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f8089c != null) {
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
                m565a();
                return;
            }
            switch (mo343a.f7786c) {
                case 1:
                    if (b2 == 11) {
                        this.f138a = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        l7 l7Var = new l7();
                        this.f137a = l7Var;
                        l7Var.a(t8Var);
                        continue;
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f8088b = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f8089c = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f8090d = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f8091e = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f8092f = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 8:
                    if (b2 == 12) {
                        i7 i7Var = new i7();
                        this.f8087a = i7Var;
                        i7Var.a(t8Var);
                        continue;
                    }
                    break;
                case 9:
                    if (b2 == 2) {
                        this.f141a = t8Var.mo353a();
                        a(true);
                        continue;
                    }
                    break;
                case 10:
                    if (b2 == 13) {
                        s8 mo345a = t8Var.mo345a();
                        this.f140a = new HashMap(mo345a.f7854c * 2);
                        for (int i2 = 0; i2 < mo345a.f7854c; i2++) {
                            this.f140a.put(t8Var.mo348a(), t8Var.mo348a());
                        }
                        t8Var.h();
                        break;
                    }
                    break;
                case 11:
                    if (b2 == 11) {
                        this.f8093g = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f8094h = t8Var.mo348a();
                        continue;
                    }
                    break;
            }
            w8.a(t8Var, b2);
            t8Var.g();
        }
    }

    public void a(boolean z) {
        this.f139a.set(0, z);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m566a() {
        return this.f138a != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m567a(z7 z7Var) {
        if (z7Var == null) {
            return false;
        }
        boolean m566a = m566a();
        boolean m566a2 = z7Var.m566a();
        if ((m566a || m566a2) && !(m566a && m566a2 && this.f138a.equals(z7Var.f138a))) {
            return false;
        }
        boolean m568b = m568b();
        boolean m568b2 = z7Var.m568b();
        if ((m568b || m568b2) && !(m568b && m568b2 && this.f137a.m287a(z7Var.f137a))) {
            return false;
        }
        boolean m569c = m569c();
        boolean m569c2 = z7Var.m569c();
        if ((m569c || m569c2) && !(m569c && m569c2 && this.f8088b.equals(z7Var.f8088b))) {
            return false;
        }
        boolean m570d = m570d();
        boolean m570d2 = z7Var.m570d();
        if ((m570d || m570d2) && !(m570d && m570d2 && this.f8089c.equals(z7Var.f8089c))) {
            return false;
        }
        boolean m571e = m571e();
        boolean m571e2 = z7Var.m571e();
        if ((m571e || m571e2) && !(m571e && m571e2 && this.f8090d.equals(z7Var.f8090d))) {
            return false;
        }
        boolean m572f = m572f();
        boolean m572f2 = z7Var.m572f();
        if ((m572f || m572f2) && !(m572f && m572f2 && this.f8091e.equals(z7Var.f8091e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = z7Var.g();
        if ((g2 || g3) && !(g2 && g3 && this.f8092f.equals(z7Var.f8092f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = z7Var.h();
        if ((h2 || h3) && !(h2 && h3 && this.f8087a.m228a(z7Var.f8087a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = z7Var.i();
        if ((i2 || i3) && !(i2 && i3 && this.f141a == z7Var.f141a)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = z7Var.j();
        if ((j2 || j3) && !(j2 && j3 && this.f140a.equals(z7Var.f140a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = z7Var.k();
        if ((k2 || k3) && !(k2 && k3 && this.f8093g.equals(z7Var.f8093g))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = z7Var.l();
        if (l2 || l3) {
            return l2 && l3 && this.f8094h.equals(z7Var.f8094h);
        }
        return true;
    }

    public String b() {
        return this.f8089c;
    }

    @Override // c.k.d.i8
    public void b(t8 t8Var) {
        m565a();
        t8Var.a(f8086i);
        if (this.f138a != null && m566a()) {
            t8Var.a(j);
            t8Var.a(this.f138a);
            t8Var.b();
        }
        if (this.f137a != null && m568b()) {
            t8Var.a(k);
            this.f137a.b(t8Var);
            t8Var.b();
        }
        if (this.f8088b != null) {
            t8Var.a(l);
            t8Var.a(this.f8088b);
            t8Var.b();
        }
        if (this.f8089c != null) {
            t8Var.a(m);
            t8Var.a(this.f8089c);
            t8Var.b();
        }
        if (this.f8090d != null && m571e()) {
            t8Var.a(n);
            t8Var.a(this.f8090d);
            t8Var.b();
        }
        if (this.f8091e != null && m572f()) {
            t8Var.a(o);
            t8Var.a(this.f8091e);
            t8Var.b();
        }
        if (this.f8092f != null && g()) {
            t8Var.a(p);
            t8Var.a(this.f8092f);
            t8Var.b();
        }
        if (this.f8087a != null && h()) {
            t8Var.a(q);
            this.f8087a.b(t8Var);
            t8Var.b();
        }
        if (i()) {
            t8Var.a(r);
            t8Var.a(this.f141a);
            t8Var.b();
        }
        if (this.f140a != null && j()) {
            t8Var.a(t);
            t8Var.a(new s8((byte) 11, (byte) 11, this.f140a.size()));
            for (Map.Entry<String, String> entry : this.f140a.entrySet()) {
                t8Var.a(entry.getKey());
                t8Var.a(entry.getValue());
            }
            t8Var.d();
            t8Var.b();
        }
        if (this.f8093g != null && k()) {
            t8Var.a(u);
            t8Var.a(this.f8093g);
            t8Var.b();
        }
        if (this.f8094h != null && l()) {
            t8Var.a(v);
            t8Var.a(this.f8094h);
            t8Var.b();
        }
        t8Var.c();
        t8Var.mo351a();
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m568b() {
        return this.f137a != null;
    }

    public String c() {
        return this.f8091e;
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m569c() {
        return this.f8088b != null;
    }

    public String d() {
        return this.f8092f;
    }

    /* renamed from: d, reason: collision with other method in class */
    public boolean m570d() {
        return this.f8089c != null;
    }

    public String e() {
        return this.f8093g;
    }

    /* renamed from: e, reason: collision with other method in class */
    public boolean m571e() {
        return this.f8090d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof z7)) {
            return m567a((z7) obj);
        }
        return false;
    }

    public String f() {
        return this.f8094h;
    }

    /* renamed from: f, reason: collision with other method in class */
    public boolean m572f() {
        return this.f8091e != null;
    }

    public boolean g() {
        return this.f8092f != null;
    }

    public boolean h() {
        return this.f8087a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f139a.get(0);
    }

    public boolean j() {
        return this.f140a != null;
    }

    public boolean k() {
        return this.f8093g != null;
    }

    public boolean l() {
        return this.f8094h != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSendMessage(");
        boolean z2 = false;
        if (m566a()) {
            sb.append("debug:");
            String str = this.f138a;
            if (str == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m568b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            l7 l7Var = this.f137a;
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
        String str2 = this.f8088b;
        if (str2 == null) {
            sb.append(LogUtils.NULL);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f8089c;
        if (str3 == null) {
            sb.append(LogUtils.NULL);
        } else {
            sb.append(str3);
        }
        if (m571e()) {
            sb.append(", ");
            sb.append("packageName:");
            String str4 = this.f8090d;
            if (str4 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str4);
            }
        }
        if (m572f()) {
            sb.append(", ");
            sb.append("topic:");
            String str5 = this.f8091e;
            if (str5 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str6 = this.f8092f;
            if (str6 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("message:");
            i7 i7Var = this.f8087a;
            if (i7Var == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(i7Var);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("needAck:");
            sb.append(this.f141a);
        }
        if (j()) {
            sb.append(", ");
            sb.append("params:");
            Map<String, String> map = this.f140a;
            if (map == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(map);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f8093g;
            if (str7 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str7);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("userAccount:");
            String str8 = this.f8094h;
            if (str8 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str8);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
