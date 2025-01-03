package c.k.d;

import com.shix.shixipc.utilcode.LogUtils;
import java.io.Serializable;
import java.util.BitSet;

/* loaded from: classes.dex */
public class y7 implements i8<y7, Object>, Serializable, Cloneable {

    /* renamed from: f, reason: collision with root package name */
    public static final y8 f8043f = new y8("XmPushActionSendFeedbackResult");

    /* renamed from: g, reason: collision with root package name */
    public static final q8 f8044g = new q8("", (byte) 11, 1);

    /* renamed from: h, reason: collision with root package name */
    public static final q8 f8045h = new q8("", (byte) 12, 2);

    /* renamed from: i, reason: collision with root package name */
    public static final q8 f8046i = new q8("", (byte) 11, 3);
    public static final q8 j = new q8("", (byte) 11, 4);
    public static final q8 k = new q8("", (byte) 10, 6);
    public static final q8 l = new q8("", (byte) 11, 7);
    public static final q8 m = new q8("", (byte) 11, 8);

    /* renamed from: a, reason: collision with root package name */
    public long f8047a;

    /* renamed from: a, reason: collision with other field name */
    public l7 f128a;

    /* renamed from: a, reason: collision with other field name */
    public String f129a;

    /* renamed from: a, reason: collision with other field name */
    public BitSet f130a = new BitSet(1);

    /* renamed from: b, reason: collision with root package name */
    public String f8048b;

    /* renamed from: c, reason: collision with root package name */
    public String f8049c;

    /* renamed from: d, reason: collision with root package name */
    public String f8050d;

    /* renamed from: e, reason: collision with root package name */
    public String f8051e;

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(y7 y7Var) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        if (!y7.class.equals(y7Var.getClass())) {
            return y7.class.getName().compareTo(y7Var.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m539a()).compareTo(Boolean.valueOf(y7Var.m539a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m539a() && (a8 = j8.a(this.f129a, y7Var.f129a)) != 0) {
            return a8;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(y7Var.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a7 = j8.a(this.f128a, y7Var.f128a)) != 0) {
            return a7;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(y7Var.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a6 = j8.a(this.f8048b, y7Var.f8048b)) != 0) {
            return a6;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(y7Var.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a5 = j8.a(this.f8049c, y7Var.f8049c)) != 0) {
            return a5;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(y7Var.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a4 = j8.a(this.f8047a, y7Var.f8047a)) != 0) {
            return a4;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(y7Var.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a3 = j8.a(this.f8050d, y7Var.f8050d)) != 0) {
            return a3;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(y7Var.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (!g() || (a2 = j8.a(this.f8051e, y7Var.f8051e)) == 0) {
            return 0;
        }
        return a2;
    }

    public void a() {
        if (this.f8048b == null) {
            throw new u8("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f8049c != null) {
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
                if (e()) {
                    a();
                    return;
                }
                throw new u8("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (mo343a.f7786c) {
                case 1:
                    if (b2 == 11) {
                        this.f129a = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        l7 l7Var = new l7();
                        this.f128a = l7Var;
                        l7Var.a(t8Var);
                        break;
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f8048b = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f8049c = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 6:
                    if (b2 == 10) {
                        this.f8047a = t8Var.mo342a();
                        a(true);
                        break;
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f8050d = t8Var.mo348a();
                        continue;
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f8051e = t8Var.mo348a();
                        continue;
                    }
                    break;
            }
            w8.a(t8Var, b2);
            t8Var.g();
        }
    }

    public void a(boolean z) {
        this.f130a.set(0, z);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m539a() {
        return this.f129a != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m540a(y7 y7Var) {
        if (y7Var == null) {
            return false;
        }
        boolean m539a = m539a();
        boolean m539a2 = y7Var.m539a();
        if ((m539a || m539a2) && !(m539a && m539a2 && this.f129a.equals(y7Var.f129a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = y7Var.b();
        if ((b2 || b3) && !(b2 && b3 && this.f128a.m287a(y7Var.f128a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = y7Var.c();
        if ((c2 || c3) && !(c2 && c3 && this.f8048b.equals(y7Var.f8048b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = y7Var.d();
        if (((d2 || d3) && !(d2 && d3 && this.f8049c.equals(y7Var.f8049c))) || this.f8047a != y7Var.f8047a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = y7Var.f();
        if ((f2 || f3) && !(f2 && f3 && this.f8050d.equals(y7Var.f8050d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = y7Var.g();
        if (g2 || g3) {
            return g2 && g3 && this.f8051e.equals(y7Var.f8051e);
        }
        return true;
    }

    @Override // c.k.d.i8
    public void b(t8 t8Var) {
        a();
        t8Var.a(f8043f);
        if (this.f129a != null && m539a()) {
            t8Var.a(f8044g);
            t8Var.a(this.f129a);
            t8Var.b();
        }
        if (this.f128a != null && b()) {
            t8Var.a(f8045h);
            this.f128a.b(t8Var);
            t8Var.b();
        }
        if (this.f8048b != null) {
            t8Var.a(f8046i);
            t8Var.a(this.f8048b);
            t8Var.b();
        }
        if (this.f8049c != null) {
            t8Var.a(j);
            t8Var.a(this.f8049c);
            t8Var.b();
        }
        t8Var.a(k);
        t8Var.a(this.f8047a);
        t8Var.b();
        if (this.f8050d != null && f()) {
            t8Var.a(l);
            t8Var.a(this.f8050d);
            t8Var.b();
        }
        if (this.f8051e != null && g()) {
            t8Var.a(m);
            t8Var.a(this.f8051e);
            t8Var.b();
        }
        t8Var.c();
        t8Var.mo351a();
    }

    public boolean b() {
        return this.f128a != null;
    }

    public boolean c() {
        return this.f8048b != null;
    }

    public boolean d() {
        return this.f8049c != null;
    }

    public boolean e() {
        return this.f130a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof y7)) {
            return m540a((y7) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f8050d != null;
    }

    public boolean g() {
        return this.f8051e != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSendFeedbackResult(");
        boolean z2 = false;
        if (m539a()) {
            sb.append("debug:");
            String str = this.f129a;
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
            l7 l7Var = this.f128a;
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
        String str2 = this.f8048b;
        if (str2 == null) {
            sb.append(LogUtils.NULL);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f8049c;
        if (str3 == null) {
            sb.append(LogUtils.NULL);
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f8047a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f8050d;
            if (str4 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            String str5 = this.f8051e;
            if (str5 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str5);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
