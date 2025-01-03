package c.k.d;

import com.shix.shixipc.utilcode.LogUtils;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class z6 implements i8<z6, Object>, Serializable, Cloneable {

    /* renamed from: h, reason: collision with root package name */
    public static final y8 f8077h = new y8("ClientUploadDataItem");

    /* renamed from: i, reason: collision with root package name */
    public static final q8 f8078i = new q8("", (byte) 11, 1);
    public static final q8 j = new q8("", (byte) 11, 2);
    public static final q8 k = new q8("", (byte) 11, 3);
    public static final q8 l = new q8("", (byte) 10, 4);
    public static final q8 m = new q8("", (byte) 10, 5);
    public static final q8 n = new q8("", (byte) 2, 6);
    public static final q8 o = new q8("", (byte) 11, 7);
    public static final q8 p = new q8("", (byte) 11, 8);
    public static final q8 q = new q8("", (byte) 11, 9);
    public static final q8 r = new q8("", (byte) 13, 10);
    public static final q8 t = new q8("", (byte) 11, 11);

    /* renamed from: a, reason: collision with root package name */
    public long f8079a;

    /* renamed from: a, reason: collision with other field name */
    public String f132a;

    /* renamed from: a, reason: collision with other field name */
    public BitSet f133a = new BitSet(3);

    /* renamed from: a, reason: collision with other field name */
    public Map<String, String> f134a;

    /* renamed from: a, reason: collision with other field name */
    public boolean f135a;

    /* renamed from: b, reason: collision with root package name */
    public long f8080b;

    /* renamed from: b, reason: collision with other field name */
    public String f136b;

    /* renamed from: c, reason: collision with root package name */
    public String f8081c;

    /* renamed from: d, reason: collision with root package name */
    public String f8082d;

    /* renamed from: e, reason: collision with root package name */
    public String f8083e;

    /* renamed from: f, reason: collision with root package name */
    public String f8084f;

    /* renamed from: g, reason: collision with root package name */
    public String f8085g;

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(z6 z6Var) {
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
        if (!z6.class.equals(z6Var.getClass())) {
            return z6.class.getName().compareTo(z6Var.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m558a()).compareTo(Boolean.valueOf(z6Var.m558a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m558a() && (a12 = j8.a(this.f132a, z6Var.f132a)) != 0) {
            return a12;
        }
        int compareTo2 = Boolean.valueOf(m560b()).compareTo(Boolean.valueOf(z6Var.m560b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m560b() && (a11 = j8.a(this.f136b, z6Var.f136b)) != 0) {
            return a11;
        }
        int compareTo3 = Boolean.valueOf(m561c()).compareTo(Boolean.valueOf(z6Var.m561c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m561c() && (a10 = j8.a(this.f8081c, z6Var.f8081c)) != 0) {
            return a10;
        }
        int compareTo4 = Boolean.valueOf(m562d()).compareTo(Boolean.valueOf(z6Var.m562d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m562d() && (a9 = j8.a(this.f8079a, z6Var.f8079a)) != 0) {
            return a9;
        }
        int compareTo5 = Boolean.valueOf(m563e()).compareTo(Boolean.valueOf(z6Var.m563e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m563e() && (a8 = j8.a(this.f8080b, z6Var.f8080b)) != 0) {
            return a8;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(z6Var.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a7 = j8.a(this.f135a, z6Var.f135a)) != 0) {
            return a7;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(z6Var.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a6 = j8.a(this.f8082d, z6Var.f8082d)) != 0) {
            return a6;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(z6Var.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a5 = j8.a(this.f8083e, z6Var.f8083e)) != 0) {
            return a5;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(z6Var.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a4 = j8.a(this.f8084f, z6Var.f8084f)) != 0) {
            return a4;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(z6Var.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (a3 = j8.a(this.f134a, z6Var.f134a)) != 0) {
            return a3;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(z6Var.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (!k() || (a2 = j8.a(this.f8085g, z6Var.f8085g)) == 0) {
            return 0;
        }
        return a2;
    }

    public long a() {
        return this.f8080b;
    }

    public z6 a(long j2) {
        this.f8079a = j2;
        m557a(true);
        return this;
    }

    public z6 a(String str) {
        this.f132a = str;
        return this;
    }

    public z6 a(boolean z) {
        this.f135a = z;
        c(true);
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m555a() {
        return this.f132a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m556a() {
    }

    @Override // c.k.d.i8
    public void a(t8 t8Var) {
        t8Var.mo347a();
        while (true) {
            q8 mo343a = t8Var.mo343a();
            byte b2 = mo343a.f7785b;
            if (b2 == 0) {
                t8Var.f();
                m556a();
                return;
            }
            switch (mo343a.f7786c) {
                case 1:
                    if (b2 == 11) {
                        this.f132a = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 2:
                    if (b2 == 11) {
                        this.f136b = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f8081c = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 4:
                    if (b2 == 10) {
                        this.f8079a = t8Var.mo342a();
                        m557a(true);
                        continue;
                    }
                    break;
                case 5:
                    if (b2 == 10) {
                        this.f8080b = t8Var.mo342a();
                        b(true);
                        continue;
                    }
                    break;
                case 6:
                    if (b2 == 2) {
                        this.f135a = t8Var.mo353a();
                        c(true);
                        continue;
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f8082d = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f8083e = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f8084f = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 10:
                    if (b2 == 13) {
                        s8 mo345a = t8Var.mo345a();
                        this.f134a = new HashMap(mo345a.f7854c * 2);
                        for (int i2 = 0; i2 < mo345a.f7854c; i2++) {
                            this.f134a.put(t8Var.mo348a(), t8Var.mo348a());
                        }
                        t8Var.h();
                        break;
                    }
                    break;
                case 11:
                    if (b2 == 11) {
                        this.f8085g = t8Var.mo348a();
                        continue;
                    }
                    break;
            }
            w8.a(t8Var, b2);
            t8Var.g();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m557a(boolean z) {
        this.f133a.set(0, z);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m558a() {
        return this.f132a != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m559a(z6 z6Var) {
        if (z6Var == null) {
            return false;
        }
        boolean m558a = m558a();
        boolean m558a2 = z6Var.m558a();
        if ((m558a || m558a2) && !(m558a && m558a2 && this.f132a.equals(z6Var.f132a))) {
            return false;
        }
        boolean m560b = m560b();
        boolean m560b2 = z6Var.m560b();
        if ((m560b || m560b2) && !(m560b && m560b2 && this.f136b.equals(z6Var.f136b))) {
            return false;
        }
        boolean m561c = m561c();
        boolean m561c2 = z6Var.m561c();
        if ((m561c || m561c2) && !(m561c && m561c2 && this.f8081c.equals(z6Var.f8081c))) {
            return false;
        }
        boolean m562d = m562d();
        boolean m562d2 = z6Var.m562d();
        if ((m562d || m562d2) && !(m562d && m562d2 && this.f8079a == z6Var.f8079a)) {
            return false;
        }
        boolean m563e = m563e();
        boolean m563e2 = z6Var.m563e();
        if ((m563e || m563e2) && !(m563e && m563e2 && this.f8080b == z6Var.f8080b)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = z6Var.f();
        if ((f2 || f3) && !(f2 && f3 && this.f135a == z6Var.f135a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = z6Var.g();
        if ((g2 || g3) && !(g2 && g3 && this.f8082d.equals(z6Var.f8082d))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = z6Var.h();
        if ((h2 || h3) && !(h2 && h3 && this.f8083e.equals(z6Var.f8083e))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = z6Var.i();
        if ((i2 || i3) && !(i2 && i3 && this.f8084f.equals(z6Var.f8084f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = z6Var.j();
        if ((j2 || j3) && !(j2 && j3 && this.f134a.equals(z6Var.f134a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = z6Var.k();
        if (k2 || k3) {
            return k2 && k3 && this.f8085g.equals(z6Var.f8085g);
        }
        return true;
    }

    public z6 b(long j2) {
        this.f8080b = j2;
        b(true);
        return this;
    }

    public z6 b(String str) {
        this.f136b = str;
        return this;
    }

    public String b() {
        return this.f8081c;
    }

    @Override // c.k.d.i8
    public void b(t8 t8Var) {
        m556a();
        t8Var.a(f8077h);
        if (this.f132a != null && m558a()) {
            t8Var.a(f8078i);
            t8Var.a(this.f132a);
            t8Var.b();
        }
        if (this.f136b != null && m560b()) {
            t8Var.a(j);
            t8Var.a(this.f136b);
            t8Var.b();
        }
        if (this.f8081c != null && m561c()) {
            t8Var.a(k);
            t8Var.a(this.f8081c);
            t8Var.b();
        }
        if (m562d()) {
            t8Var.a(l);
            t8Var.a(this.f8079a);
            t8Var.b();
        }
        if (m563e()) {
            t8Var.a(m);
            t8Var.a(this.f8080b);
            t8Var.b();
        }
        if (f()) {
            t8Var.a(n);
            t8Var.a(this.f135a);
            t8Var.b();
        }
        if (this.f8082d != null && g()) {
            t8Var.a(o);
            t8Var.a(this.f8082d);
            t8Var.b();
        }
        if (this.f8083e != null && h()) {
            t8Var.a(p);
            t8Var.a(this.f8083e);
            t8Var.b();
        }
        if (this.f8084f != null && i()) {
            t8Var.a(q);
            t8Var.a(this.f8084f);
            t8Var.b();
        }
        if (this.f134a != null && j()) {
            t8Var.a(r);
            t8Var.a(new s8((byte) 11, (byte) 11, this.f134a.size()));
            for (Map.Entry<String, String> entry : this.f134a.entrySet()) {
                t8Var.a(entry.getKey());
                t8Var.a(entry.getValue());
            }
            t8Var.d();
            t8Var.b();
        }
        if (this.f8085g != null && k()) {
            t8Var.a(t);
            t8Var.a(this.f8085g);
            t8Var.b();
        }
        t8Var.c();
        t8Var.mo351a();
    }

    public void b(boolean z) {
        this.f133a.set(1, z);
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m560b() {
        return this.f136b != null;
    }

    public z6 c(String str) {
        this.f8081c = str;
        return this;
    }

    public String c() {
        return this.f8083e;
    }

    public void c(boolean z) {
        this.f133a.set(2, z);
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m561c() {
        return this.f8081c != null;
    }

    public z6 d(String str) {
        this.f8082d = str;
        return this;
    }

    public String d() {
        return this.f8084f;
    }

    /* renamed from: d, reason: collision with other method in class */
    public boolean m562d() {
        return this.f133a.get(0);
    }

    public z6 e(String str) {
        this.f8083e = str;
        return this;
    }

    public String e() {
        return this.f8085g;
    }

    /* renamed from: e, reason: collision with other method in class */
    public boolean m563e() {
        return this.f133a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof z6)) {
            return m559a((z6) obj);
        }
        return false;
    }

    public z6 f(String str) {
        this.f8084f = str;
        return this;
    }

    public boolean f() {
        return this.f133a.get(2);
    }

    public z6 g(String str) {
        this.f8085g = str;
        return this;
    }

    public boolean g() {
        return this.f8082d != null;
    }

    public boolean h() {
        return this.f8083e != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f8084f != null;
    }

    public boolean j() {
        return this.f134a != null;
    }

    public boolean k() {
        return this.f8085g != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("ClientUploadDataItem(");
        boolean z2 = false;
        if (m558a()) {
            sb.append("channel:");
            String str = this.f132a;
            if (str == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m560b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("data:");
            String str2 = this.f136b;
            if (str2 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str2);
            }
            z = false;
        }
        if (m561c()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("name:");
            String str3 = this.f8081c;
            if (str3 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str3);
            }
            z = false;
        }
        if (m562d()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("counter:");
            sb.append(this.f8079a);
            z = false;
        }
        if (m563e()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("timestamp:");
            sb.append(this.f8080b);
            z = false;
        }
        if (f()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("fromSdk:");
            sb.append(this.f135a);
            z = false;
        }
        if (g()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("category:");
            String str4 = this.f8082d;
            if (str4 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str4);
            }
            z = false;
        }
        if (h()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("sourcePackage:");
            String str5 = this.f8083e;
            if (str5 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str5);
            }
            z = false;
        }
        if (i()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("id:");
            String str6 = this.f8084f;
            if (str6 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str6);
            }
            z = false;
        }
        if (j()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("extra:");
            Map<String, String> map = this.f134a;
            if (map == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(map);
            }
        } else {
            z2 = z;
        }
        if (k()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("pkgName:");
            String str7 = this.f8085g;
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
