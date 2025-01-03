package c.k.d;

import com.shix.shixipc.utilcode.LogUtils;
import java.io.Serializable;
import java.util.BitSet;

/* loaded from: classes.dex */
public class h7 implements i8<h7, Object>, Serializable, Cloneable {

    /* renamed from: d, reason: collision with root package name */
    public static final y8 f7227d = new y8("OnlineConfigItem");

    /* renamed from: e, reason: collision with root package name */
    public static final q8 f7228e = new q8("", (byte) 8, 1);

    /* renamed from: f, reason: collision with root package name */
    public static final q8 f7229f = new q8("", (byte) 8, 2);

    /* renamed from: g, reason: collision with root package name */
    public static final q8 f7230g = new q8("", (byte) 2, 3);

    /* renamed from: h, reason: collision with root package name */
    public static final q8 f7231h = new q8("", (byte) 8, 4);

    /* renamed from: i, reason: collision with root package name */
    public static final q8 f7232i = new q8("", (byte) 10, 5);
    public static final q8 j = new q8("", (byte) 11, 6);
    public static final q8 k = new q8("", (byte) 2, 7);

    /* renamed from: a, reason: collision with root package name */
    public int f7233a;

    /* renamed from: a, reason: collision with other field name */
    public long f31a;

    /* renamed from: a, reason: collision with other field name */
    public String f32a;

    /* renamed from: a, reason: collision with other field name */
    public BitSet f33a = new BitSet(6);

    /* renamed from: a, reason: collision with other field name */
    public boolean f34a;

    /* renamed from: b, reason: collision with root package name */
    public int f7234b;

    /* renamed from: b, reason: collision with other field name */
    public boolean f35b;

    /* renamed from: c, reason: collision with root package name */
    public int f7235c;

    public int a() {
        return this.f7233a;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(h7 h7Var) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        if (!h7.class.equals(h7Var.getClass())) {
            return h7.class.getName().compareTo(h7Var.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m211a()).compareTo(Boolean.valueOf(h7Var.m211a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m211a() && (a8 = j8.a(this.f7233a, h7Var.f7233a)) != 0) {
            return a8;
        }
        int compareTo2 = Boolean.valueOf(m213b()).compareTo(Boolean.valueOf(h7Var.m213b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m213b() && (a7 = j8.a(this.f7234b, h7Var.f7234b)) != 0) {
            return a7;
        }
        int compareTo3 = Boolean.valueOf(m214c()).compareTo(Boolean.valueOf(h7Var.m214c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m214c() && (a6 = j8.a(this.f34a, h7Var.f34a)) != 0) {
            return a6;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(h7Var.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a5 = j8.a(this.f7235c, h7Var.f7235c)) != 0) {
            return a5;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(h7Var.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a4 = j8.a(this.f31a, h7Var.f31a)) != 0) {
            return a4;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(h7Var.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a3 = j8.a(this.f32a, h7Var.f32a)) != 0) {
            return a3;
        }
        int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(h7Var.h()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (!h() || (a2 = j8.a(this.f35b, h7Var.f35b)) == 0) {
            return 0;
        }
        return a2;
    }

    /* renamed from: a, reason: collision with other method in class */
    public long m208a() {
        return this.f31a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m209a() {
        return this.f32a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m210a() {
    }

    @Override // c.k.d.i8
    public void a(t8 t8Var) {
        t8Var.mo347a();
        while (true) {
            q8 mo343a = t8Var.mo343a();
            byte b2 = mo343a.f7785b;
            if (b2 == 0) {
                t8Var.f();
                m210a();
                return;
            }
            switch (mo343a.f7786c) {
                case 1:
                    if (b2 == 8) {
                        this.f7233a = t8Var.mo341a();
                        a(true);
                        continue;
                    }
                    break;
                case 2:
                    if (b2 == 8) {
                        this.f7234b = t8Var.mo341a();
                        b(true);
                        continue;
                    }
                    break;
                case 3:
                    if (b2 == 2) {
                        this.f34a = t8Var.mo353a();
                        c(true);
                        continue;
                    }
                    break;
                case 4:
                    if (b2 == 8) {
                        this.f7235c = t8Var.mo341a();
                        d(true);
                        continue;
                    }
                    break;
                case 5:
                    if (b2 == 10) {
                        this.f31a = t8Var.mo342a();
                        e(true);
                        break;
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f32a = t8Var.mo348a();
                        break;
                    }
                    break;
                case 7:
                    if (b2 == 2) {
                        this.f35b = t8Var.mo353a();
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
        this.f33a.set(0, z);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m211a() {
        return this.f33a.get(0);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m212a(h7 h7Var) {
        if (h7Var == null) {
            return false;
        }
        boolean m211a = m211a();
        boolean m211a2 = h7Var.m211a();
        if ((m211a || m211a2) && !(m211a && m211a2 && this.f7233a == h7Var.f7233a)) {
            return false;
        }
        boolean m213b = m213b();
        boolean m213b2 = h7Var.m213b();
        if ((m213b || m213b2) && !(m213b && m213b2 && this.f7234b == h7Var.f7234b)) {
            return false;
        }
        boolean m214c = m214c();
        boolean m214c2 = h7Var.m214c();
        if ((m214c || m214c2) && !(m214c && m214c2 && this.f34a == h7Var.f34a)) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = h7Var.d();
        if ((d2 || d3) && !(d2 && d3 && this.f7235c == h7Var.f7235c)) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = h7Var.e();
        if ((e2 || e3) && !(e2 && e3 && this.f31a == h7Var.f31a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = h7Var.f();
        if ((f2 || f3) && !(f2 && f3 && this.f32a.equals(h7Var.f32a))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = h7Var.h();
        if (h2 || h3) {
            return h2 && h3 && this.f35b == h7Var.f35b;
        }
        return true;
    }

    public int b() {
        return this.f7234b;
    }

    @Override // c.k.d.i8
    public void b(t8 t8Var) {
        m210a();
        t8Var.a(f7227d);
        if (m211a()) {
            t8Var.a(f7228e);
            t8Var.mo352a(this.f7233a);
            t8Var.b();
        }
        if (m213b()) {
            t8Var.a(f7229f);
            t8Var.mo352a(this.f7234b);
            t8Var.b();
        }
        if (m214c()) {
            t8Var.a(f7230g);
            t8Var.a(this.f34a);
            t8Var.b();
        }
        if (d()) {
            t8Var.a(f7231h);
            t8Var.mo352a(this.f7235c);
            t8Var.b();
        }
        if (e()) {
            t8Var.a(f7232i);
            t8Var.a(this.f31a);
            t8Var.b();
        }
        if (this.f32a != null && f()) {
            t8Var.a(j);
            t8Var.a(this.f32a);
            t8Var.b();
        }
        if (h()) {
            t8Var.a(k);
            t8Var.a(this.f35b);
            t8Var.b();
        }
        t8Var.c();
        t8Var.mo351a();
    }

    public void b(boolean z) {
        this.f33a.set(1, z);
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m213b() {
        return this.f33a.get(1);
    }

    public int c() {
        return this.f7235c;
    }

    public void c(boolean z) {
        this.f33a.set(2, z);
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m214c() {
        return this.f33a.get(2);
    }

    public void d(boolean z) {
        this.f33a.set(3, z);
    }

    public boolean d() {
        return this.f33a.get(3);
    }

    public void e(boolean z) {
        this.f33a.set(4, z);
    }

    public boolean e() {
        return this.f33a.get(4);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof h7)) {
            return m212a((h7) obj);
        }
        return false;
    }

    public void f(boolean z) {
        this.f33a.set(5, z);
    }

    public boolean f() {
        return this.f32a != null;
    }

    public boolean g() {
        return this.f35b;
    }

    public boolean h() {
        return this.f33a.get(5);
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("OnlineConfigItem(");
        boolean z2 = false;
        if (m211a()) {
            sb.append("key:");
            sb.append(this.f7233a);
            z = false;
        } else {
            z = true;
        }
        if (m213b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("type:");
            sb.append(this.f7234b);
            z = false;
        }
        if (m214c()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("clear:");
            sb.append(this.f34a);
            z = false;
        }
        if (d()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("intValue:");
            sb.append(this.f7235c);
            z = false;
        }
        if (e()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("longValue:");
            sb.append(this.f31a);
            z = false;
        }
        if (f()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("stringValue:");
            String str = this.f32a;
            if (str == null) {
                str = LogUtils.NULL;
            }
            sb.append(str);
        } else {
            z2 = z;
        }
        if (h()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("boolValue:");
            sb.append(this.f35b);
        }
        sb.append(")");
        return sb.toString();
    }
}
