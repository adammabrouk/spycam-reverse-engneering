package c.k.d;

import com.shix.shixipc.utilcode.LogUtils;
import java.io.Serializable;
import java.util.BitSet;

/* loaded from: classes.dex */
public class p4 implements i8<p4, Object>, Serializable, Cloneable {

    /* renamed from: f, reason: collision with root package name */
    public static final y8 f7490f = new y8("StatsEvent");

    /* renamed from: g, reason: collision with root package name */
    public static final q8 f7491g = new q8("", (byte) 3, 1);

    /* renamed from: h, reason: collision with root package name */
    public static final q8 f7492h = new q8("", (byte) 8, 2);

    /* renamed from: i, reason: collision with root package name */
    public static final q8 f7493i = new q8("", (byte) 8, 3);
    public static final q8 j = new q8("", (byte) 11, 4);
    public static final q8 k = new q8("", (byte) 11, 5);
    public static final q8 l = new q8("", (byte) 8, 6);
    public static final q8 m = new q8("", (byte) 11, 7);
    public static final q8 n = new q8("", (byte) 11, 8);
    public static final q8 o = new q8("", (byte) 8, 9);
    public static final q8 p = new q8("", (byte) 8, 10);

    /* renamed from: a, reason: collision with root package name */
    public byte f7494a;

    /* renamed from: a, reason: collision with other field name */
    public int f74a;

    /* renamed from: a, reason: collision with other field name */
    public String f75a;

    /* renamed from: a, reason: collision with other field name */
    public BitSet f76a = new BitSet(6);

    /* renamed from: b, reason: collision with root package name */
    public int f7495b;

    /* renamed from: b, reason: collision with other field name */
    public String f77b;

    /* renamed from: c, reason: collision with root package name */
    public int f7496c;

    /* renamed from: c, reason: collision with other field name */
    public String f78c;

    /* renamed from: d, reason: collision with root package name */
    public int f7497d;

    /* renamed from: d, reason: collision with other field name */
    public String f79d;

    /* renamed from: e, reason: collision with root package name */
    public int f7498e;

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(p4 p4Var) {
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
        if (!p4.class.equals(p4Var.getClass())) {
            return p4.class.getName().compareTo(p4Var.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m333a()).compareTo(Boolean.valueOf(p4Var.m333a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m333a() && (a11 = j8.a(this.f7494a, p4Var.f7494a)) != 0) {
            return a11;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(p4Var.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a10 = j8.a(this.f74a, p4Var.f74a)) != 0) {
            return a10;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(p4Var.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a9 = j8.a(this.f7495b, p4Var.f7495b)) != 0) {
            return a9;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(p4Var.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a8 = j8.a(this.f75a, p4Var.f75a)) != 0) {
            return a8;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(p4Var.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a7 = j8.a(this.f77b, p4Var.f77b)) != 0) {
            return a7;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(p4Var.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a6 = j8.a(this.f7496c, p4Var.f7496c)) != 0) {
            return a6;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(p4Var.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a5 = j8.a(this.f78c, p4Var.f78c)) != 0) {
            return a5;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(p4Var.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a4 = j8.a(this.f79d, p4Var.f79d)) != 0) {
            return a4;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(p4Var.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a3 = j8.a(this.f7497d, p4Var.f7497d)) != 0) {
            return a3;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(p4Var.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (!j() || (a2 = j8.a(this.f7498e, p4Var.f7498e)) == 0) {
            return 0;
        }
        return a2;
    }

    public p4 a(byte b2) {
        this.f7494a = b2;
        a(true);
        return this;
    }

    public p4 a(int i2) {
        this.f74a = i2;
        b(true);
        return this;
    }

    public p4 a(String str) {
        this.f75a = str;
        return this;
    }

    public void a() {
        if (this.f75a != null) {
            return;
        }
        throw new u8("Required field 'connpt' was not present! Struct: " + toString());
    }

    @Override // c.k.d.i8
    public void a(t8 t8Var) {
        t8Var.mo347a();
        while (true) {
            q8 mo343a = t8Var.mo343a();
            byte b2 = mo343a.f7785b;
            if (b2 == 0) {
                t8Var.f();
                if (!m333a()) {
                    throw new u8("Required field 'chid' was not found in serialized data! Struct: " + toString());
                }
                if (!b()) {
                    throw new u8("Required field 'type' was not found in serialized data! Struct: " + toString());
                }
                if (c()) {
                    a();
                    return;
                }
                throw new u8("Required field 'value' was not found in serialized data! Struct: " + toString());
            }
            switch (mo343a.f7786c) {
                case 1:
                    if (b2 == 3) {
                        this.f7494a = t8Var.a();
                        a(true);
                        break;
                    }
                    break;
                case 2:
                    if (b2 == 8) {
                        this.f74a = t8Var.mo341a();
                        b(true);
                        continue;
                    }
                    break;
                case 3:
                    if (b2 == 8) {
                        this.f7495b = t8Var.mo341a();
                        c(true);
                        continue;
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f75a = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f77b = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 6:
                    if (b2 == 8) {
                        this.f7496c = t8Var.mo341a();
                        d(true);
                        continue;
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f78c = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f79d = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 9:
                    if (b2 == 8) {
                        this.f7497d = t8Var.mo341a();
                        e(true);
                        continue;
                    }
                    break;
                case 10:
                    if (b2 == 8) {
                        this.f7498e = t8Var.mo341a();
                        f(true);
                        continue;
                    }
                    break;
            }
            w8.a(t8Var, b2);
            t8Var.g();
        }
    }

    public void a(boolean z) {
        this.f76a.set(0, z);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m333a() {
        return this.f76a.get(0);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m334a(p4 p4Var) {
        if (p4Var == null || this.f7494a != p4Var.f7494a || this.f74a != p4Var.f74a || this.f7495b != p4Var.f7495b) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = p4Var.d();
        if ((d2 || d3) && !(d2 && d3 && this.f75a.equals(p4Var.f75a))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = p4Var.e();
        if ((e2 || e3) && !(e2 && e3 && this.f77b.equals(p4Var.f77b))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = p4Var.f();
        if ((f2 || f3) && !(f2 && f3 && this.f7496c == p4Var.f7496c)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = p4Var.g();
        if ((g2 || g3) && !(g2 && g3 && this.f78c.equals(p4Var.f78c))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = p4Var.h();
        if ((h2 || h3) && !(h2 && h3 && this.f79d.equals(p4Var.f79d))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = p4Var.i();
        if ((i2 || i3) && !(i2 && i3 && this.f7497d == p4Var.f7497d)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = p4Var.j();
        if (j2 || j3) {
            return j2 && j3 && this.f7498e == p4Var.f7498e;
        }
        return true;
    }

    public p4 b(int i2) {
        this.f7495b = i2;
        c(true);
        return this;
    }

    public p4 b(String str) {
        this.f77b = str;
        return this;
    }

    @Override // c.k.d.i8
    public void b(t8 t8Var) {
        a();
        t8Var.a(f7490f);
        t8Var.a(f7491g);
        t8Var.a(this.f7494a);
        t8Var.b();
        t8Var.a(f7492h);
        t8Var.mo352a(this.f74a);
        t8Var.b();
        t8Var.a(f7493i);
        t8Var.mo352a(this.f7495b);
        t8Var.b();
        if (this.f75a != null) {
            t8Var.a(j);
            t8Var.a(this.f75a);
            t8Var.b();
        }
        if (this.f77b != null && e()) {
            t8Var.a(k);
            t8Var.a(this.f77b);
            t8Var.b();
        }
        if (f()) {
            t8Var.a(l);
            t8Var.mo352a(this.f7496c);
            t8Var.b();
        }
        if (this.f78c != null && g()) {
            t8Var.a(m);
            t8Var.a(this.f78c);
            t8Var.b();
        }
        if (this.f79d != null && h()) {
            t8Var.a(n);
            t8Var.a(this.f79d);
            t8Var.b();
        }
        if (i()) {
            t8Var.a(o);
            t8Var.mo352a(this.f7497d);
            t8Var.b();
        }
        if (j()) {
            t8Var.a(p);
            t8Var.mo352a(this.f7498e);
            t8Var.b();
        }
        t8Var.c();
        t8Var.mo351a();
    }

    public void b(boolean z) {
        this.f76a.set(1, z);
    }

    public boolean b() {
        return this.f76a.get(1);
    }

    public p4 c(int i2) {
        this.f7496c = i2;
        d(true);
        return this;
    }

    public p4 c(String str) {
        this.f78c = str;
        return this;
    }

    public void c(boolean z) {
        this.f76a.set(2, z);
    }

    public boolean c() {
        return this.f76a.get(2);
    }

    public p4 d(int i2) {
        this.f7497d = i2;
        e(true);
        return this;
    }

    public p4 d(String str) {
        this.f79d = str;
        return this;
    }

    public void d(boolean z) {
        this.f76a.set(3, z);
    }

    public boolean d() {
        return this.f75a != null;
    }

    public void e(boolean z) {
        this.f76a.set(4, z);
    }

    public boolean e() {
        return this.f77b != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof p4)) {
            return m334a((p4) obj);
        }
        return false;
    }

    public void f(boolean z) {
        this.f76a.set(5, z);
    }

    public boolean f() {
        return this.f76a.get(3);
    }

    public boolean g() {
        return this.f78c != null;
    }

    public boolean h() {
        return this.f79d != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f76a.get(4);
    }

    public boolean j() {
        return this.f76a.get(5);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StatsEvent(");
        sb.append("chid:");
        sb.append((int) this.f7494a);
        sb.append(", ");
        sb.append("type:");
        sb.append(this.f74a);
        sb.append(", ");
        sb.append("value:");
        sb.append(this.f7495b);
        sb.append(", ");
        sb.append("connpt:");
        String str = this.f75a;
        if (str == null) {
            sb.append(LogUtils.NULL);
        } else {
            sb.append(str);
        }
        if (e()) {
            sb.append(", ");
            sb.append("host:");
            String str2 = this.f77b;
            if (str2 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str2);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("subvalue:");
            sb.append(this.f7496c);
        }
        if (g()) {
            sb.append(", ");
            sb.append("annotation:");
            String str3 = this.f78c;
            if (str3 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str3);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("user:");
            String str4 = this.f79d;
            if (str4 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str4);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("time:");
            sb.append(this.f7497d);
        }
        if (j()) {
            sb.append(", ");
            sb.append("clientIp:");
            sb.append(this.f7498e);
        }
        sb.append(")");
        return sb.toString();
    }
}
