package c.k.d;

import com.shix.shixipc.utilcode.LogUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class q7 implements i8<q7, Object>, Serializable, Cloneable {

    /* renamed from: f, reason: collision with root package name */
    public static final y8 f7775f = new y8("XmPushActionCommand");

    /* renamed from: g, reason: collision with root package name */
    public static final q8 f7776g = new q8("", (byte) 12, 2);

    /* renamed from: h, reason: collision with root package name */
    public static final q8 f7777h = new q8("", (byte) 11, 3);

    /* renamed from: i, reason: collision with root package name */
    public static final q8 f7778i = new q8("", (byte) 11, 4);
    public static final q8 j = new q8("", (byte) 11, 5);
    public static final q8 k = new q8("", (byte) 15, 6);
    public static final q8 l = new q8("", (byte) 11, 7);
    public static final q8 m = new q8("", (byte) 11, 9);
    public static final q8 n = new q8("", (byte) 2, 10);
    public static final q8 o = new q8("", (byte) 2, 11);
    public static final q8 p = new q8("", (byte) 10, 12);

    /* renamed from: a, reason: collision with root package name */
    public long f7779a;

    /* renamed from: a, reason: collision with other field name */
    public l7 f82a;

    /* renamed from: a, reason: collision with other field name */
    public String f83a;

    /* renamed from: a, reason: collision with other field name */
    public List<String> f85a;

    /* renamed from: b, reason: collision with root package name */
    public String f7780b;

    /* renamed from: c, reason: collision with root package name */
    public String f7781c;

    /* renamed from: d, reason: collision with root package name */
    public String f7782d;

    /* renamed from: e, reason: collision with root package name */
    public String f7783e;

    /* renamed from: a, reason: collision with other field name */
    public BitSet f84a = new BitSet(3);

    /* renamed from: a, reason: collision with other field name */
    public boolean f86a = false;

    /* renamed from: b, reason: collision with other field name */
    public boolean f87b = true;

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(q7 q7Var) {
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
        if (!q7.class.equals(q7Var.getClass())) {
            return q7.class.getName().compareTo(q7Var.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m430a()).compareTo(Boolean.valueOf(q7Var.m430a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m430a() && (a11 = j8.a(this.f82a, q7Var.f82a)) != 0) {
            return a11;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(q7Var.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a10 = j8.a(this.f83a, q7Var.f83a)) != 0) {
            return a10;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(q7Var.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a9 = j8.a(this.f7780b, q7Var.f7780b)) != 0) {
            return a9;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(q7Var.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a8 = j8.a(this.f7781c, q7Var.f7781c)) != 0) {
            return a8;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(q7Var.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a7 = j8.a(this.f85a, q7Var.f85a)) != 0) {
            return a7;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(q7Var.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a6 = j8.a(this.f7782d, q7Var.f7782d)) != 0) {
            return a6;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(q7Var.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a5 = j8.a(this.f7783e, q7Var.f7783e)) != 0) {
            return a5;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(q7Var.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a4 = j8.a(this.f86a, q7Var.f86a)) != 0) {
            return a4;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(q7Var.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a3 = j8.a(this.f87b, q7Var.f87b)) != 0) {
            return a3;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(q7Var.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (!j() || (a2 = j8.a(this.f7779a, q7Var.f7779a)) == 0) {
            return 0;
        }
        return a2;
    }

    public q7 a(String str) {
        this.f83a = str;
        return this;
    }

    public q7 a(List<String> list) {
        this.f85a = list;
        return this;
    }

    public String a() {
        return this.f7781c;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m428a() {
        if (this.f83a == null) {
            throw new u8("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f7780b == null) {
            throw new u8("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f7781c != null) {
            return;
        }
        throw new u8("Required field 'cmdName' was not present! Struct: " + toString());
    }

    @Override // c.k.d.i8
    public void a(t8 t8Var) {
        t8Var.mo347a();
        while (true) {
            q8 mo343a = t8Var.mo343a();
            byte b2 = mo343a.f7785b;
            if (b2 == 0) {
                t8Var.f();
                m428a();
                return;
            }
            switch (mo343a.f7786c) {
                case 2:
                    if (b2 == 12) {
                        l7 l7Var = new l7();
                        this.f82a = l7Var;
                        l7Var.a(t8Var);
                        break;
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f83a = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f7780b = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f7781c = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 6:
                    if (b2 == 15) {
                        r8 mo344a = t8Var.mo344a();
                        this.f85a = new ArrayList(mo344a.f7822b);
                        for (int i2 = 0; i2 < mo344a.f7822b; i2++) {
                            this.f85a.add(t8Var.mo348a());
                        }
                        t8Var.i();
                        break;
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f7782d = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f7783e = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 10:
                    if (b2 == 2) {
                        this.f86a = t8Var.mo353a();
                        a(true);
                        continue;
                    }
                    break;
                case 11:
                    if (b2 == 2) {
                        this.f87b = t8Var.mo353a();
                        b(true);
                        continue;
                    }
                    break;
                case 12:
                    if (b2 == 10) {
                        this.f7779a = t8Var.mo342a();
                        c(true);
                        break;
                    }
                    break;
            }
            w8.a(t8Var, b2);
            t8Var.g();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m429a(String str) {
        if (this.f85a == null) {
            this.f85a = new ArrayList();
        }
        this.f85a.add(str);
    }

    public void a(boolean z) {
        this.f84a.set(0, z);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m430a() {
        return this.f82a != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m431a(q7 q7Var) {
        if (q7Var == null) {
            return false;
        }
        boolean m430a = m430a();
        boolean m430a2 = q7Var.m430a();
        if ((m430a || m430a2) && !(m430a && m430a2 && this.f82a.m287a(q7Var.f82a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = q7Var.b();
        if ((b2 || b3) && !(b2 && b3 && this.f83a.equals(q7Var.f83a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = q7Var.c();
        if ((c2 || c3) && !(c2 && c3 && this.f7780b.equals(q7Var.f7780b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = q7Var.d();
        if ((d2 || d3) && !(d2 && d3 && this.f7781c.equals(q7Var.f7781c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = q7Var.e();
        if ((e2 || e3) && !(e2 && e3 && this.f85a.equals(q7Var.f85a))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = q7Var.f();
        if ((f2 || f3) && !(f2 && f3 && this.f7782d.equals(q7Var.f7782d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = q7Var.g();
        if ((g2 || g3) && !(g2 && g3 && this.f7783e.equals(q7Var.f7783e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = q7Var.h();
        if ((h2 || h3) && !(h2 && h3 && this.f86a == q7Var.f86a)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = q7Var.i();
        if ((i2 || i3) && !(i2 && i3 && this.f87b == q7Var.f87b)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = q7Var.j();
        if (j2 || j3) {
            return j2 && j3 && this.f7779a == q7Var.f7779a;
        }
        return true;
    }

    public q7 b(String str) {
        this.f7780b = str;
        return this;
    }

    @Override // c.k.d.i8
    public void b(t8 t8Var) {
        m428a();
        t8Var.a(f7775f);
        if (this.f82a != null && m430a()) {
            t8Var.a(f7776g);
            this.f82a.b(t8Var);
            t8Var.b();
        }
        if (this.f83a != null) {
            t8Var.a(f7777h);
            t8Var.a(this.f83a);
            t8Var.b();
        }
        if (this.f7780b != null) {
            t8Var.a(f7778i);
            t8Var.a(this.f7780b);
            t8Var.b();
        }
        if (this.f7781c != null) {
            t8Var.a(j);
            t8Var.a(this.f7781c);
            t8Var.b();
        }
        if (this.f85a != null && e()) {
            t8Var.a(k);
            t8Var.a(new r8((byte) 11, this.f85a.size()));
            Iterator<String> it = this.f85a.iterator();
            while (it.hasNext()) {
                t8Var.a(it.next());
            }
            t8Var.e();
            t8Var.b();
        }
        if (this.f7782d != null && f()) {
            t8Var.a(l);
            t8Var.a(this.f7782d);
            t8Var.b();
        }
        if (this.f7783e != null && g()) {
            t8Var.a(m);
            t8Var.a(this.f7783e);
            t8Var.b();
        }
        if (h()) {
            t8Var.a(n);
            t8Var.a(this.f86a);
            t8Var.b();
        }
        if (i()) {
            t8Var.a(o);
            t8Var.a(this.f87b);
            t8Var.b();
        }
        if (j()) {
            t8Var.a(p);
            t8Var.a(this.f7779a);
            t8Var.b();
        }
        t8Var.c();
        t8Var.mo351a();
    }

    public void b(boolean z) {
        this.f84a.set(1, z);
    }

    public boolean b() {
        return this.f83a != null;
    }

    public q7 c(String str) {
        this.f7781c = str;
        return this;
    }

    public void c(boolean z) {
        this.f84a.set(2, z);
    }

    public boolean c() {
        return this.f7780b != null;
    }

    public q7 d(String str) {
        this.f7782d = str;
        return this;
    }

    public boolean d() {
        return this.f7781c != null;
    }

    public q7 e(String str) {
        this.f7783e = str;
        return this;
    }

    public boolean e() {
        return this.f85a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof q7)) {
            return m431a((q7) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f7782d != null;
    }

    public boolean g() {
        return this.f7783e != null;
    }

    public boolean h() {
        return this.f84a.get(0);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f84a.get(1);
    }

    public boolean j() {
        return this.f84a.get(2);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionCommand(");
        if (m430a()) {
            sb.append("target:");
            l7 l7Var = this.f82a;
            if (l7Var == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(l7Var);
            }
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        String str = this.f83a;
        if (str == null) {
            sb.append(LogUtils.NULL);
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("appId:");
        String str2 = this.f7780b;
        if (str2 == null) {
            sb.append(LogUtils.NULL);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("cmdName:");
        String str3 = this.f7781c;
        if (str3 == null) {
            sb.append(LogUtils.NULL);
        } else {
            sb.append(str3);
        }
        if (e()) {
            sb.append(", ");
            sb.append("cmdArgs:");
            List<String> list = this.f85a;
            if (list == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(list);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            String str4 = this.f7782d;
            if (str4 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            String str5 = this.f7783e;
            if (str5 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("updateCache:");
            sb.append(this.f86a);
        }
        if (i()) {
            sb.append(", ");
            sb.append("response2Client:");
            sb.append(this.f87b);
        }
        if (j()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f7779a);
        }
        sb.append(")");
        return sb.toString();
    }
}
