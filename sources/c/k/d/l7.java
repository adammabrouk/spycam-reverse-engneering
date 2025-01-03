package c.k.d;

import com.shix.shixipc.utilcode.LogUtils;
import java.io.Serializable;
import java.util.BitSet;

/* loaded from: classes.dex */
public class l7 implements i8<l7, Object>, Serializable, Cloneable {

    /* renamed from: e, reason: collision with root package name */
    public static final y8 f7352e = new y8("Target");

    /* renamed from: f, reason: collision with root package name */
    public static final q8 f7353f = new q8("", (byte) 10, 1);

    /* renamed from: g, reason: collision with root package name */
    public static final q8 f7354g = new q8("", (byte) 11, 2);

    /* renamed from: h, reason: collision with root package name */
    public static final q8 f7355h = new q8("", (byte) 11, 3);

    /* renamed from: i, reason: collision with root package name */
    public static final q8 f7356i = new q8("", (byte) 11, 4);
    public static final q8 j = new q8("", (byte) 2, 5);
    public static final q8 k = new q8("", (byte) 11, 7);

    /* renamed from: a, reason: collision with other field name */
    public String f55a;

    /* renamed from: d, reason: collision with root package name */
    public String f7360d;

    /* renamed from: a, reason: collision with other field name */
    public BitSet f56a = new BitSet(2);

    /* renamed from: a, reason: collision with root package name */
    public long f7357a = 5;

    /* renamed from: b, reason: collision with root package name */
    public String f7358b = "xiaomi.com";

    /* renamed from: c, reason: collision with root package name */
    public String f7359c = "";

    /* renamed from: a, reason: collision with other field name */
    public boolean f57a = false;

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(l7 l7Var) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        if (!l7.class.equals(l7Var.getClass())) {
            return l7.class.getName().compareTo(l7Var.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m286a()).compareTo(Boolean.valueOf(l7Var.m286a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m286a() && (a7 = j8.a(this.f7357a, l7Var.f7357a)) != 0) {
            return a7;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(l7Var.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a6 = j8.a(this.f55a, l7Var.f55a)) != 0) {
            return a6;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(l7Var.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a5 = j8.a(this.f7358b, l7Var.f7358b)) != 0) {
            return a5;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(l7Var.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a4 = j8.a(this.f7359c, l7Var.f7359c)) != 0) {
            return a4;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(l7Var.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a3 = j8.a(this.f57a, l7Var.f57a)) != 0) {
            return a3;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(l7Var.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (!f() || (a2 = j8.a(this.f7360d, l7Var.f7360d)) == 0) {
            return 0;
        }
        return a2;
    }

    public void a() {
        if (this.f55a != null) {
            return;
        }
        throw new u8("Required field 'userId' was not present! Struct: " + toString());
    }

    @Override // c.k.d.i8
    public void a(t8 t8Var) {
        t8Var.mo347a();
        while (true) {
            q8 mo343a = t8Var.mo343a();
            byte b2 = mo343a.f7785b;
            if (b2 == 0) {
                break;
            }
            short s = mo343a.f7786c;
            if (s == 1) {
                if (b2 == 10) {
                    this.f7357a = t8Var.mo342a();
                    a(true);
                    t8Var.g();
                }
                w8.a(t8Var, b2);
                t8Var.g();
            } else if (s == 2) {
                if (b2 == 11) {
                    this.f55a = t8Var.mo348a();
                    t8Var.g();
                }
                w8.a(t8Var, b2);
                t8Var.g();
            } else if (s == 3) {
                if (b2 == 11) {
                    this.f7358b = t8Var.mo348a();
                    t8Var.g();
                }
                w8.a(t8Var, b2);
                t8Var.g();
            } else if (s == 4) {
                if (b2 == 11) {
                    this.f7359c = t8Var.mo348a();
                    t8Var.g();
                }
                w8.a(t8Var, b2);
                t8Var.g();
            } else if (s != 5) {
                if (s == 7 && b2 == 11) {
                    this.f7360d = t8Var.mo348a();
                    t8Var.g();
                }
                w8.a(t8Var, b2);
                t8Var.g();
            } else {
                if (b2 == 2) {
                    this.f57a = t8Var.mo353a();
                    b(true);
                    t8Var.g();
                }
                w8.a(t8Var, b2);
                t8Var.g();
            }
        }
        t8Var.f();
        if (m286a()) {
            a();
            return;
        }
        throw new u8("Required field 'channelId' was not found in serialized data! Struct: " + toString());
    }

    public void a(boolean z) {
        this.f56a.set(0, z);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m286a() {
        return this.f56a.get(0);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m287a(l7 l7Var) {
        if (l7Var == null || this.f7357a != l7Var.f7357a) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = l7Var.b();
        if ((b2 || b3) && !(b2 && b3 && this.f55a.equals(l7Var.f55a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = l7Var.c();
        if ((c2 || c3) && !(c2 && c3 && this.f7358b.equals(l7Var.f7358b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = l7Var.d();
        if ((d2 || d3) && !(d2 && d3 && this.f7359c.equals(l7Var.f7359c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = l7Var.e();
        if ((e2 || e3) && !(e2 && e3 && this.f57a == l7Var.f57a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = l7Var.f();
        if (f2 || f3) {
            return f2 && f3 && this.f7360d.equals(l7Var.f7360d);
        }
        return true;
    }

    @Override // c.k.d.i8
    public void b(t8 t8Var) {
        a();
        t8Var.a(f7352e);
        t8Var.a(f7353f);
        t8Var.a(this.f7357a);
        t8Var.b();
        if (this.f55a != null) {
            t8Var.a(f7354g);
            t8Var.a(this.f55a);
            t8Var.b();
        }
        if (this.f7358b != null && c()) {
            t8Var.a(f7355h);
            t8Var.a(this.f7358b);
            t8Var.b();
        }
        if (this.f7359c != null && d()) {
            t8Var.a(f7356i);
            t8Var.a(this.f7359c);
            t8Var.b();
        }
        if (e()) {
            t8Var.a(j);
            t8Var.a(this.f57a);
            t8Var.b();
        }
        if (this.f7360d != null && f()) {
            t8Var.a(k);
            t8Var.a(this.f7360d);
            t8Var.b();
        }
        t8Var.c();
        t8Var.mo351a();
    }

    public void b(boolean z) {
        this.f56a.set(1, z);
    }

    public boolean b() {
        return this.f55a != null;
    }

    public boolean c() {
        return this.f7358b != null;
    }

    public boolean d() {
        return this.f7359c != null;
    }

    public boolean e() {
        return this.f56a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof l7)) {
            return m287a((l7) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f7360d != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Target(");
        sb.append("channelId:");
        sb.append(this.f7357a);
        sb.append(", ");
        sb.append("userId:");
        String str = this.f55a;
        if (str == null) {
            sb.append(LogUtils.NULL);
        } else {
            sb.append(str);
        }
        if (c()) {
            sb.append(", ");
            sb.append("server:");
            String str2 = this.f7358b;
            if (str2 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str2);
            }
        }
        if (d()) {
            sb.append(", ");
            sb.append("resource:");
            String str3 = this.f7359c;
            if (str3 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("isPreview:");
            sb.append(this.f57a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("token:");
            String str4 = this.f7360d;
            if (str4 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str4);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
