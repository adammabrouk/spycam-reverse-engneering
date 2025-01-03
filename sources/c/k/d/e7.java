package c.k.d;

import com.shix.shixipc.utilcode.LogUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class e7 implements i8<e7, Object>, Serializable, Cloneable {

    /* renamed from: b, reason: collision with root package name */
    public static final y8 f7096b = new y8("NormalConfig");

    /* renamed from: c, reason: collision with root package name */
    public static final q8 f7097c = new q8("", (byte) 8, 1);

    /* renamed from: d, reason: collision with root package name */
    public static final q8 f7098d = new q8("", (byte) 15, 2);

    /* renamed from: e, reason: collision with root package name */
    public static final q8 f7099e = new q8("", (byte) 8, 3);

    /* renamed from: a, reason: collision with root package name */
    public int f7100a;

    /* renamed from: a, reason: collision with other field name */
    public b7 f22a;

    /* renamed from: a, reason: collision with other field name */
    public BitSet f23a = new BitSet(1);

    /* renamed from: a, reason: collision with other field name */
    public List<h7> f24a;

    public int a() {
        return this.f7100a;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(e7 e7Var) {
        int a2;
        int a3;
        int a4;
        if (!e7.class.equals(e7Var.getClass())) {
            return e7.class.getName().compareTo(e7Var.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m144a()).compareTo(Boolean.valueOf(e7Var.m144a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m144a() && (a4 = j8.a(this.f7100a, e7Var.f7100a)) != 0) {
            return a4;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(e7Var.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a3 = j8.a(this.f24a, e7Var.f24a)) != 0) {
            return a3;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(e7Var.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (!c() || (a2 = j8.a(this.f22a, e7Var.f22a)) == 0) {
            return 0;
        }
        return a2;
    }

    /* renamed from: a, reason: collision with other method in class */
    public b7 m142a() {
        return this.f22a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m143a() {
        if (this.f24a != null) {
            return;
        }
        throw new u8("Required field 'configItems' was not present! Struct: " + toString());
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
                if (b2 == 8) {
                    this.f7100a = t8Var.mo341a();
                    a(true);
                    t8Var.g();
                }
                w8.a(t8Var, b2);
                t8Var.g();
            } else if (s != 2) {
                if (s == 3 && b2 == 8) {
                    this.f22a = b7.a(t8Var.mo341a());
                    t8Var.g();
                }
                w8.a(t8Var, b2);
                t8Var.g();
            } else {
                if (b2 == 15) {
                    r8 mo344a = t8Var.mo344a();
                    this.f24a = new ArrayList(mo344a.f7822b);
                    for (int i2 = 0; i2 < mo344a.f7822b; i2++) {
                        h7 h7Var = new h7();
                        h7Var.a(t8Var);
                        this.f24a.add(h7Var);
                    }
                    t8Var.i();
                    t8Var.g();
                }
                w8.a(t8Var, b2);
                t8Var.g();
            }
        }
        t8Var.f();
        if (m144a()) {
            m143a();
            return;
        }
        throw new u8("Required field 'version' was not found in serialized data! Struct: " + toString());
    }

    public void a(boolean z) {
        this.f23a.set(0, z);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m144a() {
        return this.f23a.get(0);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m145a(e7 e7Var) {
        if (e7Var == null || this.f7100a != e7Var.f7100a) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = e7Var.b();
        if ((b2 || b3) && !(b2 && b3 && this.f24a.equals(e7Var.f24a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = e7Var.c();
        if (c2 || c3) {
            return c2 && c3 && this.f22a.equals(e7Var.f22a);
        }
        return true;
    }

    @Override // c.k.d.i8
    public void b(t8 t8Var) {
        m143a();
        t8Var.a(f7096b);
        t8Var.a(f7097c);
        t8Var.mo352a(this.f7100a);
        t8Var.b();
        if (this.f24a != null) {
            t8Var.a(f7098d);
            t8Var.a(new r8((byte) 12, this.f24a.size()));
            Iterator<h7> it = this.f24a.iterator();
            while (it.hasNext()) {
                it.next().b(t8Var);
            }
            t8Var.e();
            t8Var.b();
        }
        if (this.f22a != null && c()) {
            t8Var.a(f7099e);
            t8Var.mo352a(this.f22a.a());
            t8Var.b();
        }
        t8Var.c();
        t8Var.mo351a();
    }

    public boolean b() {
        return this.f24a != null;
    }

    public boolean c() {
        return this.f22a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof e7)) {
            return m145a((e7) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NormalConfig(");
        sb.append("version:");
        sb.append(this.f7100a);
        sb.append(", ");
        sb.append("configItems:");
        List<h7> list = this.f24a;
        if (list == null) {
            sb.append(LogUtils.NULL);
        } else {
            sb.append(list);
        }
        if (c()) {
            sb.append(", ");
            sb.append("type:");
            b7 b7Var = this.f22a;
            if (b7Var == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(b7Var);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
