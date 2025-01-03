package c.k.d;

import com.shix.shixipc.utilcode.LogUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class e8 implements i8<e8, Object>, Serializable, Cloneable {

    /* renamed from: g, reason: collision with root package name */
    public static final y8 f7101g = new y8("XmPushActionUnSubscription");

    /* renamed from: h, reason: collision with root package name */
    public static final q8 f7102h = new q8("", (byte) 11, 1);

    /* renamed from: i, reason: collision with root package name */
    public static final q8 f7103i = new q8("", (byte) 12, 2);
    public static final q8 j = new q8("", (byte) 11, 3);
    public static final q8 k = new q8("", (byte) 11, 4);
    public static final q8 l = new q8("", (byte) 11, 5);
    public static final q8 m = new q8("", (byte) 11, 6);
    public static final q8 n = new q8("", (byte) 11, 7);
    public static final q8 o = new q8("", (byte) 15, 8);

    /* renamed from: a, reason: collision with root package name */
    public l7 f7104a;

    /* renamed from: a, reason: collision with other field name */
    public String f25a;

    /* renamed from: a, reason: collision with other field name */
    public List<String> f26a;

    /* renamed from: b, reason: collision with root package name */
    public String f7105b;

    /* renamed from: c, reason: collision with root package name */
    public String f7106c;

    /* renamed from: d, reason: collision with root package name */
    public String f7107d;

    /* renamed from: e, reason: collision with root package name */
    public String f7108e;

    /* renamed from: f, reason: collision with root package name */
    public String f7109f;

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(e8 e8Var) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        if (!e8.class.equals(e8Var.getClass())) {
            return e8.class.getName().compareTo(e8Var.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m146a()).compareTo(Boolean.valueOf(e8Var.m146a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m146a() && (a9 = j8.a(this.f25a, e8Var.f25a)) != 0) {
            return a9;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(e8Var.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a8 = j8.a(this.f7104a, e8Var.f7104a)) != 0) {
            return a8;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(e8Var.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a7 = j8.a(this.f7105b, e8Var.f7105b)) != 0) {
            return a7;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(e8Var.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a6 = j8.a(this.f7106c, e8Var.f7106c)) != 0) {
            return a6;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(e8Var.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a5 = j8.a(this.f7107d, e8Var.f7107d)) != 0) {
            return a5;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(e8Var.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a4 = j8.a(this.f7108e, e8Var.f7108e)) != 0) {
            return a4;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(e8Var.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a3 = j8.a(this.f7109f, e8Var.f7109f)) != 0) {
            return a3;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(e8Var.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (!h() || (a2 = j8.a(this.f26a, e8Var.f26a)) == 0) {
            return 0;
        }
        return a2;
    }

    public e8 a(String str) {
        this.f7105b = str;
        return this;
    }

    public void a() {
        if (this.f7105b == null) {
            throw new u8("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f7106c == null) {
            throw new u8("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f7107d != null) {
            return;
        }
        throw new u8("Required field 'topic' was not present! Struct: " + toString());
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
                        this.f25a = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        l7 l7Var = new l7();
                        this.f7104a = l7Var;
                        l7Var.a(t8Var);
                        break;
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f7105b = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f7106c = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f7107d = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f7108e = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f7109f = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 8:
                    if (b2 == 15) {
                        r8 mo344a = t8Var.mo344a();
                        this.f26a = new ArrayList(mo344a.f7822b);
                        for (int i2 = 0; i2 < mo344a.f7822b; i2++) {
                            this.f26a.add(t8Var.mo348a());
                        }
                        t8Var.i();
                        break;
                    }
                    break;
            }
            w8.a(t8Var, b2);
            t8Var.g();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m146a() {
        return this.f25a != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m147a(e8 e8Var) {
        if (e8Var == null) {
            return false;
        }
        boolean m146a = m146a();
        boolean m146a2 = e8Var.m146a();
        if ((m146a || m146a2) && !(m146a && m146a2 && this.f25a.equals(e8Var.f25a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = e8Var.b();
        if ((b2 || b3) && !(b2 && b3 && this.f7104a.m287a(e8Var.f7104a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = e8Var.c();
        if ((c2 || c3) && !(c2 && c3 && this.f7105b.equals(e8Var.f7105b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = e8Var.d();
        if ((d2 || d3) && !(d2 && d3 && this.f7106c.equals(e8Var.f7106c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = e8Var.e();
        if ((e2 || e3) && !(e2 && e3 && this.f7107d.equals(e8Var.f7107d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = e8Var.f();
        if ((f2 || f3) && !(f2 && f3 && this.f7108e.equals(e8Var.f7108e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = e8Var.g();
        if ((g2 || g3) && !(g2 && g3 && this.f7109f.equals(e8Var.f7109f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = e8Var.h();
        if (h2 || h3) {
            return h2 && h3 && this.f26a.equals(e8Var.f26a);
        }
        return true;
    }

    public e8 b(String str) {
        this.f7106c = str;
        return this;
    }

    @Override // c.k.d.i8
    public void b(t8 t8Var) {
        a();
        t8Var.a(f7101g);
        if (this.f25a != null && m146a()) {
            t8Var.a(f7102h);
            t8Var.a(this.f25a);
            t8Var.b();
        }
        if (this.f7104a != null && b()) {
            t8Var.a(f7103i);
            this.f7104a.b(t8Var);
            t8Var.b();
        }
        if (this.f7105b != null) {
            t8Var.a(j);
            t8Var.a(this.f7105b);
            t8Var.b();
        }
        if (this.f7106c != null) {
            t8Var.a(k);
            t8Var.a(this.f7106c);
            t8Var.b();
        }
        if (this.f7107d != null) {
            t8Var.a(l);
            t8Var.a(this.f7107d);
            t8Var.b();
        }
        if (this.f7108e != null && f()) {
            t8Var.a(m);
            t8Var.a(this.f7108e);
            t8Var.b();
        }
        if (this.f7109f != null && g()) {
            t8Var.a(n);
            t8Var.a(this.f7109f);
            t8Var.b();
        }
        if (this.f26a != null && h()) {
            t8Var.a(o);
            t8Var.a(new r8((byte) 11, this.f26a.size()));
            Iterator<String> it = this.f26a.iterator();
            while (it.hasNext()) {
                t8Var.a(it.next());
            }
            t8Var.e();
            t8Var.b();
        }
        t8Var.c();
        t8Var.mo351a();
    }

    public boolean b() {
        return this.f7104a != null;
    }

    public e8 c(String str) {
        this.f7107d = str;
        return this;
    }

    public boolean c() {
        return this.f7105b != null;
    }

    public e8 d(String str) {
        this.f7108e = str;
        return this;
    }

    public boolean d() {
        return this.f7106c != null;
    }

    public e8 e(String str) {
        this.f7109f = str;
        return this;
    }

    public boolean e() {
        return this.f7107d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof e8)) {
            return m147a((e8) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f7108e != null;
    }

    public boolean g() {
        return this.f7109f != null;
    }

    public boolean h() {
        return this.f26a != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscription(");
        boolean z2 = false;
        if (m146a()) {
            sb.append("debug:");
            String str = this.f25a;
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
            l7 l7Var = this.f7104a;
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
        String str2 = this.f7105b;
        if (str2 == null) {
            sb.append(LogUtils.NULL);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f7106c;
        if (str3 == null) {
            sb.append(LogUtils.NULL);
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("topic:");
        String str4 = this.f7107d;
        if (str4 == null) {
            sb.append(LogUtils.NULL);
        } else {
            sb.append(str4);
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f7108e;
            if (str5 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            String str6 = this.f7109f;
            if (str6 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("aliases:");
            List<String> list = this.f26a;
            if (list == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(list);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
