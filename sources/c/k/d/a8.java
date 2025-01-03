package c.k.d;

import com.shix.shixipc.utilcode.LogUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class a8 implements i8<a8, Object>, Serializable, Cloneable {

    /* renamed from: g, reason: collision with root package name */
    public static final y8 f6966g = new y8("XmPushActionSubscription");

    /* renamed from: h, reason: collision with root package name */
    public static final q8 f6967h = new q8("", (byte) 11, 1);

    /* renamed from: i, reason: collision with root package name */
    public static final q8 f6968i = new q8("", (byte) 12, 2);
    public static final q8 j = new q8("", (byte) 11, 3);
    public static final q8 k = new q8("", (byte) 11, 4);
    public static final q8 l = new q8("", (byte) 11, 5);
    public static final q8 m = new q8("", (byte) 11, 6);
    public static final q8 n = new q8("", (byte) 11, 7);
    public static final q8 o = new q8("", (byte) 15, 8);

    /* renamed from: a, reason: collision with root package name */
    public l7 f6969a;

    /* renamed from: a, reason: collision with other field name */
    public String f2a;

    /* renamed from: a, reason: collision with other field name */
    public List<String> f3a;

    /* renamed from: b, reason: collision with root package name */
    public String f6970b;

    /* renamed from: c, reason: collision with root package name */
    public String f6971c;

    /* renamed from: d, reason: collision with root package name */
    public String f6972d;

    /* renamed from: e, reason: collision with root package name */
    public String f6973e;

    /* renamed from: f, reason: collision with root package name */
    public String f6974f;

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(a8 a8Var) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        if (!a8.class.equals(a8Var.getClass())) {
            return a8.class.getName().compareTo(a8Var.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m74a()).compareTo(Boolean.valueOf(a8Var.m74a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m74a() && (a9 = j8.a(this.f2a, a8Var.f2a)) != 0) {
            return a9;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(a8Var.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a8 = j8.a(this.f6969a, a8Var.f6969a)) != 0) {
            return a8;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(a8Var.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a7 = j8.a(this.f6970b, a8Var.f6970b)) != 0) {
            return a7;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(a8Var.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a6 = j8.a(this.f6971c, a8Var.f6971c)) != 0) {
            return a6;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(a8Var.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a5 = j8.a(this.f6972d, a8Var.f6972d)) != 0) {
            return a5;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(a8Var.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a4 = j8.a(this.f6973e, a8Var.f6973e)) != 0) {
            return a4;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(a8Var.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a3 = j8.a(this.f6974f, a8Var.f6974f)) != 0) {
            return a3;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(a8Var.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (!h() || (a2 = j8.a(this.f3a, a8Var.f3a)) == 0) {
            return 0;
        }
        return a2;
    }

    public a8 a(String str) {
        this.f6970b = str;
        return this;
    }

    public void a() {
        if (this.f6970b == null) {
            throw new u8("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f6971c == null) {
            throw new u8("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f6972d != null) {
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
                        this.f2a = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        l7 l7Var = new l7();
                        this.f6969a = l7Var;
                        l7Var.a(t8Var);
                        break;
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f6970b = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f6971c = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f6972d = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f6973e = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f6974f = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 8:
                    if (b2 == 15) {
                        r8 mo344a = t8Var.mo344a();
                        this.f3a = new ArrayList(mo344a.f7822b);
                        for (int i2 = 0; i2 < mo344a.f7822b; i2++) {
                            this.f3a.add(t8Var.mo348a());
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
    public boolean m74a() {
        return this.f2a != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m75a(a8 a8Var) {
        if (a8Var == null) {
            return false;
        }
        boolean m74a = m74a();
        boolean m74a2 = a8Var.m74a();
        if ((m74a || m74a2) && !(m74a && m74a2 && this.f2a.equals(a8Var.f2a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = a8Var.b();
        if ((b2 || b3) && !(b2 && b3 && this.f6969a.m287a(a8Var.f6969a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = a8Var.c();
        if ((c2 || c3) && !(c2 && c3 && this.f6970b.equals(a8Var.f6970b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = a8Var.d();
        if ((d2 || d3) && !(d2 && d3 && this.f6971c.equals(a8Var.f6971c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = a8Var.e();
        if ((e2 || e3) && !(e2 && e3 && this.f6972d.equals(a8Var.f6972d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = a8Var.f();
        if ((f2 || f3) && !(f2 && f3 && this.f6973e.equals(a8Var.f6973e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = a8Var.g();
        if ((g2 || g3) && !(g2 && g3 && this.f6974f.equals(a8Var.f6974f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = a8Var.h();
        if (h2 || h3) {
            return h2 && h3 && this.f3a.equals(a8Var.f3a);
        }
        return true;
    }

    public a8 b(String str) {
        this.f6971c = str;
        return this;
    }

    @Override // c.k.d.i8
    public void b(t8 t8Var) {
        a();
        t8Var.a(f6966g);
        if (this.f2a != null && m74a()) {
            t8Var.a(f6967h);
            t8Var.a(this.f2a);
            t8Var.b();
        }
        if (this.f6969a != null && b()) {
            t8Var.a(f6968i);
            this.f6969a.b(t8Var);
            t8Var.b();
        }
        if (this.f6970b != null) {
            t8Var.a(j);
            t8Var.a(this.f6970b);
            t8Var.b();
        }
        if (this.f6971c != null) {
            t8Var.a(k);
            t8Var.a(this.f6971c);
            t8Var.b();
        }
        if (this.f6972d != null) {
            t8Var.a(l);
            t8Var.a(this.f6972d);
            t8Var.b();
        }
        if (this.f6973e != null && f()) {
            t8Var.a(m);
            t8Var.a(this.f6973e);
            t8Var.b();
        }
        if (this.f6974f != null && g()) {
            t8Var.a(n);
            t8Var.a(this.f6974f);
            t8Var.b();
        }
        if (this.f3a != null && h()) {
            t8Var.a(o);
            t8Var.a(new r8((byte) 11, this.f3a.size()));
            Iterator<String> it = this.f3a.iterator();
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
        return this.f6969a != null;
    }

    public a8 c(String str) {
        this.f6972d = str;
        return this;
    }

    public boolean c() {
        return this.f6970b != null;
    }

    public a8 d(String str) {
        this.f6973e = str;
        return this;
    }

    public boolean d() {
        return this.f6971c != null;
    }

    public a8 e(String str) {
        this.f6974f = str;
        return this;
    }

    public boolean e() {
        return this.f6972d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof a8)) {
            return m75a((a8) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f6973e != null;
    }

    public boolean g() {
        return this.f6974f != null;
    }

    public boolean h() {
        return this.f3a != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSubscription(");
        boolean z2 = false;
        if (m74a()) {
            sb.append("debug:");
            String str = this.f2a;
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
            l7 l7Var = this.f6969a;
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
        String str2 = this.f6970b;
        if (str2 == null) {
            sb.append(LogUtils.NULL);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f6971c;
        if (str3 == null) {
            sb.append(LogUtils.NULL);
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("topic:");
        String str4 = this.f6972d;
        if (str4 == null) {
            sb.append(LogUtils.NULL);
        } else {
            sb.append(str4);
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f6973e;
            if (str5 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            String str6 = this.f6974f;
            if (str6 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("aliases:");
            List<String> list = this.f3a;
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
