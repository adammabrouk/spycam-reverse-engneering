package c.k.d;

import com.shix.shixipc.utilcode.LogUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class r7 implements i8<r7, Object>, Serializable, Cloneable {

    /* renamed from: g, reason: collision with root package name */
    public static final y8 f7812g = new y8("XmPushActionCommandResult");

    /* renamed from: h, reason: collision with root package name */
    public static final q8 f7813h = new q8("", (byte) 12, 2);

    /* renamed from: i, reason: collision with root package name */
    public static final q8 f7814i = new q8("", (byte) 11, 3);
    public static final q8 j = new q8("", (byte) 11, 4);
    public static final q8 k = new q8("", (byte) 11, 5);
    public static final q8 l = new q8("", (byte) 10, 7);
    public static final q8 m = new q8("", (byte) 11, 8);
    public static final q8 n = new q8("", (byte) 11, 9);
    public static final q8 o = new q8("", (byte) 15, 10);
    public static final q8 p = new q8("", (byte) 11, 12);
    public static final q8 q = new q8("", (byte) 2, 13);

    /* renamed from: a, reason: collision with root package name */
    public long f7815a;

    /* renamed from: a, reason: collision with other field name */
    public l7 f88a;

    /* renamed from: a, reason: collision with other field name */
    public String f89a;

    /* renamed from: a, reason: collision with other field name */
    public List<String> f91a;

    /* renamed from: b, reason: collision with root package name */
    public String f7816b;

    /* renamed from: c, reason: collision with root package name */
    public String f7817c;

    /* renamed from: d, reason: collision with root package name */
    public String f7818d;

    /* renamed from: e, reason: collision with root package name */
    public String f7819e;

    /* renamed from: f, reason: collision with root package name */
    public String f7820f;

    /* renamed from: a, reason: collision with other field name */
    public BitSet f90a = new BitSet(2);

    /* renamed from: a, reason: collision with other field name */
    public boolean f92a = true;

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(r7 r7Var) {
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
        if (!r7.class.equals(r7Var.getClass())) {
            return r7.class.getName().compareTo(r7Var.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m452a()).compareTo(Boolean.valueOf(r7Var.m452a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m452a() && (a11 = j8.a(this.f88a, r7Var.f88a)) != 0) {
            return a11;
        }
        int compareTo2 = Boolean.valueOf(m454b()).compareTo(Boolean.valueOf(r7Var.m454b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m454b() && (a10 = j8.a(this.f89a, r7Var.f89a)) != 0) {
            return a10;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(r7Var.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a9 = j8.a(this.f7816b, r7Var.f7816b)) != 0) {
            return a9;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(r7Var.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a8 = j8.a(this.f7817c, r7Var.f7817c)) != 0) {
            return a8;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(r7Var.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a7 = j8.a(this.f7815a, r7Var.f7815a)) != 0) {
            return a7;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(r7Var.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a6 = j8.a(this.f7818d, r7Var.f7818d)) != 0) {
            return a6;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(r7Var.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a5 = j8.a(this.f7819e, r7Var.f7819e)) != 0) {
            return a5;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(r7Var.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a4 = j8.a(this.f91a, r7Var.f91a)) != 0) {
            return a4;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(r7Var.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a3 = j8.a(this.f7820f, r7Var.f7820f)) != 0) {
            return a3;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(r7Var.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (!j() || (a2 = j8.a(this.f92a, r7Var.f92a)) == 0) {
            return 0;
        }
        return a2;
    }

    public String a() {
        return this.f7817c;
    }

    /* renamed from: a, reason: collision with other method in class */
    public List<String> m450a() {
        return this.f91a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m451a() {
        if (this.f89a == null) {
            throw new u8("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f7816b == null) {
            throw new u8("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f7817c != null) {
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
                if (e()) {
                    m451a();
                    return;
                }
                throw new u8("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (mo343a.f7786c) {
                case 2:
                    if (b2 == 12) {
                        l7 l7Var = new l7();
                        this.f88a = l7Var;
                        l7Var.a(t8Var);
                        break;
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f89a = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f7816b = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f7817c = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 7:
                    if (b2 == 10) {
                        this.f7815a = t8Var.mo342a();
                        a(true);
                        break;
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f7818d = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f7819e = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 10:
                    if (b2 == 15) {
                        r8 mo344a = t8Var.mo344a();
                        this.f91a = new ArrayList(mo344a.f7822b);
                        for (int i2 = 0; i2 < mo344a.f7822b; i2++) {
                            this.f91a.add(t8Var.mo348a());
                        }
                        t8Var.i();
                        break;
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f7820f = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 13:
                    if (b2 == 2) {
                        this.f92a = t8Var.mo353a();
                        b(true);
                        break;
                    }
                    break;
            }
            w8.a(t8Var, b2);
            t8Var.g();
        }
    }

    public void a(boolean z) {
        this.f90a.set(0, z);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m452a() {
        return this.f88a != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m453a(r7 r7Var) {
        if (r7Var == null) {
            return false;
        }
        boolean m452a = m452a();
        boolean m452a2 = r7Var.m452a();
        if ((m452a || m452a2) && !(m452a && m452a2 && this.f88a.m287a(r7Var.f88a))) {
            return false;
        }
        boolean m454b = m454b();
        boolean m454b2 = r7Var.m454b();
        if ((m454b || m454b2) && !(m454b && m454b2 && this.f89a.equals(r7Var.f89a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = r7Var.c();
        if ((c2 || c3) && !(c2 && c3 && this.f7816b.equals(r7Var.f7816b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = r7Var.d();
        if (((d2 || d3) && !(d2 && d3 && this.f7817c.equals(r7Var.f7817c))) || this.f7815a != r7Var.f7815a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = r7Var.f();
        if ((f2 || f3) && !(f2 && f3 && this.f7818d.equals(r7Var.f7818d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = r7Var.g();
        if ((g2 || g3) && !(g2 && g3 && this.f7819e.equals(r7Var.f7819e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = r7Var.h();
        if ((h2 || h3) && !(h2 && h3 && this.f91a.equals(r7Var.f91a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = r7Var.i();
        if ((i2 || i3) && !(i2 && i3 && this.f7820f.equals(r7Var.f7820f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = r7Var.j();
        if (j2 || j3) {
            return j2 && j3 && this.f92a == r7Var.f92a;
        }
        return true;
    }

    public String b() {
        return this.f7820f;
    }

    @Override // c.k.d.i8
    public void b(t8 t8Var) {
        m451a();
        t8Var.a(f7812g);
        if (this.f88a != null && m452a()) {
            t8Var.a(f7813h);
            this.f88a.b(t8Var);
            t8Var.b();
        }
        if (this.f89a != null) {
            t8Var.a(f7814i);
            t8Var.a(this.f89a);
            t8Var.b();
        }
        if (this.f7816b != null) {
            t8Var.a(j);
            t8Var.a(this.f7816b);
            t8Var.b();
        }
        if (this.f7817c != null) {
            t8Var.a(k);
            t8Var.a(this.f7817c);
            t8Var.b();
        }
        t8Var.a(l);
        t8Var.a(this.f7815a);
        t8Var.b();
        if (this.f7818d != null && f()) {
            t8Var.a(m);
            t8Var.a(this.f7818d);
            t8Var.b();
        }
        if (this.f7819e != null && g()) {
            t8Var.a(n);
            t8Var.a(this.f7819e);
            t8Var.b();
        }
        if (this.f91a != null && h()) {
            t8Var.a(o);
            t8Var.a(new r8((byte) 11, this.f91a.size()));
            Iterator<String> it = this.f91a.iterator();
            while (it.hasNext()) {
                t8Var.a(it.next());
            }
            t8Var.e();
            t8Var.b();
        }
        if (this.f7820f != null && i()) {
            t8Var.a(p);
            t8Var.a(this.f7820f);
            t8Var.b();
        }
        if (j()) {
            t8Var.a(q);
            t8Var.a(this.f92a);
            t8Var.b();
        }
        t8Var.c();
        t8Var.mo351a();
    }

    public void b(boolean z) {
        this.f90a.set(1, z);
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m454b() {
        return this.f89a != null;
    }

    public boolean c() {
        return this.f7816b != null;
    }

    public boolean d() {
        return this.f7817c != null;
    }

    public boolean e() {
        return this.f90a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof r7)) {
            return m453a((r7) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f7818d != null;
    }

    public boolean g() {
        return this.f7819e != null;
    }

    public boolean h() {
        return this.f91a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f7820f != null;
    }

    public boolean j() {
        return this.f90a.get(1);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionCommandResult(");
        if (m452a()) {
            sb.append("target:");
            l7 l7Var = this.f88a;
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
        String str = this.f89a;
        if (str == null) {
            sb.append(LogUtils.NULL);
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("appId:");
        String str2 = this.f7816b;
        if (str2 == null) {
            sb.append(LogUtils.NULL);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("cmdName:");
        String str3 = this.f7817c;
        if (str3 == null) {
            sb.append(LogUtils.NULL);
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f7815a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f7818d;
            if (str4 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f7819e;
            if (str5 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("cmdArgs:");
            List<String> list = this.f91a;
            if (list == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(list);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            String str6 = this.f7820f;
            if (str6 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("response2Client:");
            sb.append(this.f92a);
        }
        sb.append(")");
        return sb.toString();
    }
}
