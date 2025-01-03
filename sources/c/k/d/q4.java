package c.k.d;

import com.shix.shixipc.utilcode.LogUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class q4 implements i8<q4, Object>, Serializable, Cloneable {

    /* renamed from: c, reason: collision with root package name */
    public static final y8 f7765c = new y8("StatsEvents");

    /* renamed from: d, reason: collision with root package name */
    public static final q8 f7766d = new q8("", (byte) 11, 1);

    /* renamed from: e, reason: collision with root package name */
    public static final q8 f7767e = new q8("", (byte) 11, 2);

    /* renamed from: f, reason: collision with root package name */
    public static final q8 f7768f = new q8("", (byte) 15, 3);

    /* renamed from: a, reason: collision with root package name */
    public String f7769a;

    /* renamed from: a, reason: collision with other field name */
    public List<p4> f81a;

    /* renamed from: b, reason: collision with root package name */
    public String f7770b;

    public q4() {
    }

    public q4(String str, List<p4> list) {
        this();
        this.f7769a = str;
        this.f81a = list;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(q4 q4Var) {
        int a2;
        int a3;
        int a4;
        if (!q4.class.equals(q4Var.getClass())) {
            return q4.class.getName().compareTo(q4Var.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m425a()).compareTo(Boolean.valueOf(q4Var.m425a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m425a() && (a4 = j8.a(this.f7769a, q4Var.f7769a)) != 0) {
            return a4;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(q4Var.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a3 = j8.a(this.f7770b, q4Var.f7770b)) != 0) {
            return a3;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(q4Var.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (!c() || (a2 = j8.a(this.f81a, q4Var.f81a)) == 0) {
            return 0;
        }
        return a2;
    }

    public q4 a(String str) {
        this.f7770b = str;
        return this;
    }

    public void a() {
        if (this.f7769a == null) {
            throw new u8("Required field 'uuid' was not present! Struct: " + toString());
        }
        if (this.f81a != null) {
            return;
        }
        throw new u8("Required field 'events' was not present! Struct: " + toString());
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
            short s = mo343a.f7786c;
            if (s == 1) {
                if (b2 == 11) {
                    this.f7769a = t8Var.mo348a();
                    t8Var.g();
                }
                w8.a(t8Var, b2);
                t8Var.g();
            } else if (s != 2) {
                if (s == 3 && b2 == 15) {
                    r8 mo344a = t8Var.mo344a();
                    this.f81a = new ArrayList(mo344a.f7822b);
                    for (int i2 = 0; i2 < mo344a.f7822b; i2++) {
                        p4 p4Var = new p4();
                        p4Var.a(t8Var);
                        this.f81a.add(p4Var);
                    }
                    t8Var.i();
                    t8Var.g();
                }
                w8.a(t8Var, b2);
                t8Var.g();
            } else {
                if (b2 == 11) {
                    this.f7770b = t8Var.mo348a();
                    t8Var.g();
                }
                w8.a(t8Var, b2);
                t8Var.g();
            }
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m425a() {
        return this.f7769a != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m426a(q4 q4Var) {
        if (q4Var == null) {
            return false;
        }
        boolean m425a = m425a();
        boolean m425a2 = q4Var.m425a();
        if ((m425a || m425a2) && !(m425a && m425a2 && this.f7769a.equals(q4Var.f7769a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = q4Var.b();
        if ((b2 || b3) && !(b2 && b3 && this.f7770b.equals(q4Var.f7770b))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = q4Var.c();
        if (c2 || c3) {
            return c2 && c3 && this.f81a.equals(q4Var.f81a);
        }
        return true;
    }

    @Override // c.k.d.i8
    public void b(t8 t8Var) {
        a();
        t8Var.a(f7765c);
        if (this.f7769a != null) {
            t8Var.a(f7766d);
            t8Var.a(this.f7769a);
            t8Var.b();
        }
        if (this.f7770b != null && b()) {
            t8Var.a(f7767e);
            t8Var.a(this.f7770b);
            t8Var.b();
        }
        if (this.f81a != null) {
            t8Var.a(f7768f);
            t8Var.a(new r8((byte) 12, this.f81a.size()));
            Iterator<p4> it = this.f81a.iterator();
            while (it.hasNext()) {
                it.next().b(t8Var);
            }
            t8Var.e();
            t8Var.b();
        }
        t8Var.c();
        t8Var.mo351a();
    }

    public boolean b() {
        return this.f7770b != null;
    }

    public boolean c() {
        return this.f81a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof q4)) {
            return m426a((q4) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StatsEvents(");
        sb.append("uuid:");
        String str = this.f7769a;
        if (str == null) {
            sb.append(LogUtils.NULL);
        } else {
            sb.append(str);
        }
        if (b()) {
            sb.append(", ");
            sb.append("operator:");
            String str2 = this.f7770b;
            if (str2 == null) {
                sb.append(LogUtils.NULL);
            } else {
                sb.append(str2);
            }
        }
        sb.append(", ");
        sb.append("events:");
        List<p4> list = this.f81a;
        if (list == null) {
            sb.append(LogUtils.NULL);
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }
}
